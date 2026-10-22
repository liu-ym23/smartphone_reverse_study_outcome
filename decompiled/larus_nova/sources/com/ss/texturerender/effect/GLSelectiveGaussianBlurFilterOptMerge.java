package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* JADX INFO: loaded from: classes40.dex */
public class GLSelectiveGaussianBlurFilterOptMerge extends GLDefaultFilter {
    private float mEdgeSize;
    private int mEdgeSizeLoc;
    private boolean mEnableOptVer2;
    private int mGaussBlurTexLoc;
    private EffectTexture mGaussianBlurTex;
    public int mHeightFit;
    private int mHeightFitLoc;
    private int mHeightFitLocV;
    protected float[] mLayoutCoord;
    private int mLayoutCoordLoc;
    private int mMiddleLoc;
    private float mOffsetPixelInGauBlurTex;
    private int mOffsetPixelLoc;
    protected int mSurfaceHeight;
    protected int mSurfaceWidth;
    private final String selectiveGaussianBlurMergeShader;
    private final String selectiveGaussianBlurVertexMergeShader;

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameAfter() {
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        return super.onDrawFrameAfter();
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        int r100 = this.mHeightFitLoc;
        if (r100 < 0) goto L6;
        GLES20.glUniform1i(r100, this.mHeightFit);
    L6:
        if (this.mGaussBlurTexLoc < 0) goto L8;
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(this.mInTextureTarget, this.mGaussianBlurTex.getTexID());
        GLES20.glUniform1i(this.mGaussBlurTexLoc, 1);
    L8:
        int r101 = this.mLayoutCoordLoc;
        if (r101 < 0) goto L11;
        float[] r102 = this.mLayoutCoord;
        GLES20.glUniform4f(r101, r102[0], r102[1], r102[2], r102[3]);
    L11:
        int r103 = this.mEdgeSizeLoc;
        if (r103 < 0) goto L14;
        GLES20.glUniform1f(r103, this.mEdgeSize / this.mSurfaceHeight);
    L14:
        float r104 = 0.0f;
        if (this.mOffsetPixelLoc < 0) goto L25;
        EffectTexture r105 = this.mGaussianBlurTex;
        if (r105 != null) goto L19;
    L23:
        float r106 = 0.0f;
    L24:
        GLES20.glUniform1f(this.mOffsetPixelLoc, r106);
        goto L25
    L19:
        if (this.mHeightFit != 1) goto L23;
        if (r105.getHeight() == 0) goto L23;
        r106 = (1.0f / this.mGaussianBlurTex.getHeight()) * this.mOffsetPixelInGauBlurTex;
    L25:
        GLES20.glUniform1i(this.mHeightFitLocV, this.mHeightFit);
        if (this.mEnableOptVer2 == false) goto L28;
        r104 = 0.5f;
    L31:
        GLES20.glUniform1f(this.mMiddleLoc, r104);
        return super.onDrawFrameBefore();
    L28:
        float[] r107 = this.mLayoutCoord;
        float r108 = r107[3];
        if ((1.0f - r108) <= 0.0f) goto L31;
        r104 = r107[1] / (1.0f - r108);
        goto L31
    }

    public GLSelectiveGaussianBlurFilterOptMerge(int r100) {
        super(r100, 15);
        this.selectiveGaussianBlurVertexMergeShader = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec2 mapTex1Coord;\nvarying vec4 mapTex2Coord;\nuniform vec4 layoutCoord;//x,y,w,h\nuniform int heightFitV;//SurfaceRatio > TexRatio\nuniform float middle;\nuniform float offsetPixel; \nvarying float middleF;\nvarying vec4 boxlbrt;\n\nvoid main() {\n\tgl_Position =  aPosition;\n\tvTextureCoord = aTextureCoord.xy;\n\tmapTex1Coord = vec2((vTextureCoord.x - layoutCoord.x) / layoutCoord.z, (vTextureCoord.y - layoutCoord.y) / layoutCoord.w);\n\tvec4 gauTexCoord = vec4(aTextureCoord.xy,aTextureCoord.xy);\n\tif (heightFitV == 1) {\n\t\tgauTexCoord.y = vTextureCoord.y / layoutCoord.y * middle - offsetPixel;\n\t\tgauTexCoord.w = (vTextureCoord.y - layoutCoord.y - layoutCoord.w) / (1.0 - layoutCoord.y - layoutCoord.w) * (1.0 - middle) + middle + offsetPixel;\n\t}\n\tboxlbrt = vec4(layoutCoord.x, layoutCoord.y,layoutCoord.x + layoutCoord.z, layoutCoord.y + layoutCoord.w);\n\tmapTex2Coord = gauTexCoord;\n}";
        this.selectiveGaussianBlurMergeShader = "precision mediump float;     \nvarying vec2 vTextureCoord;     \nuniform sampler2D sTexture;     \nuniform sampler2D sTextureGauBlur;    \nuniform float edgeSize; //gaublur gradient length     \nuniform int heightFit;     \nvarying vec2 mapTex1Coord;\nvarying vec4 mapTex2Coord;\nvarying vec4 boxlbrt;\nfloat gaussPersent(float v, float middleValude, float edge) { \n    return smoothstep(0.0, edge, abs(v - middleValude)); \n} \n// return 1 if v inside the box, return 0 otherwise     \nfloat insideBox(vec2 v, vec2 bottomLeft, vec2 topRight) {     \n    vec2 s = step(bottomLeft, v) - (vec2(1.0,1.0) - step(v, topRight)); \n    return s.x * s.y;           \n}    \nvoid main() {  \n \tif (heightFit == 1)\n    {   \n        if (insideBox(vTextureCoord, vec2(boxlbrt.xy), vec2(boxlbrt.zw)) > 0.5) {   \n            gl_FragColor = texture2D(sTexture, mapTex1Coord); \n            return;\n        } else {   \n             if (mapTex1Coord.y <= 0.0) {   \n                vec4 gauColor = texture2D(sTextureGauBlur, vec2(mapTex2Coord.x, mapTex2Coord.y)); \n                vec4 originalColor = texture2D(sTexture, mapTex1Coord); \n                float gauPersent = gaussPersent(mapTex1Coord.y,0.0,edgeSize); \n                gl_FragColor = gauPersent * gauColor + (1.0 - gauPersent) * originalColor; \n                return;   \n            } else if (mapTex1Coord.y >= 1.0) {   \n                vec4 gauColor = texture2D(sTextureGauBlur, vec2(mapTex2Coord.z, mapTex2Coord.w));  \n                vec4 originalColor = texture2D(sTexture, mapTex1Coord); \n                float gauPersent = gaussPersent(mapTex1Coord.y,1.0,edgeSize); \n                gl_FragColor = gauPersent * gauColor + (1.0 - gauPersent) * originalColor; \n                return;   \n            }              \n        }   \n    } else {\n    \t gl_FragColor = texture2D(sTexture, vTextureCoord);             \n    }        \n}\n";
        this.mEdgeSize = 20.0f;
        this.mLayoutCoord = null;
        this.mGaussianBlurTex = null;
        this.mHeightFit = 0;
        this.mLayoutCoordLoc = -1;
        this.mEdgeSizeLoc = -1;
        this.mHeightFitLoc = -1;
        this.mGaussBlurTexLoc = -1;
        this.mOffsetPixelInGauBlurTex = 0.0f;
        this.mOffsetPixelLoc = -1;
        this.mSurfaceHeight = -1;
        this.mSurfaceWidth = -1;
        this.mHeightFitLocV = -1;
        this.mMiddleLoc = -1;
        this.mEnableOptVer2 = false;
        this.mOrder = 6;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLGaussianBlurFilterMerge");
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11000) goto L5;
        return "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec2 mapTex1Coord;\nvarying vec4 mapTex2Coord;\nuniform vec4 layoutCoord;//x,y,w,h\nuniform int heightFitV;//SurfaceRatio > TexRatio\nuniform float middle;\nuniform float offsetPixel; \nvarying float middleF;\nvarying vec4 boxlbrt;\n\nvoid main() {\n\tgl_Position =  aPosition;\n\tvTextureCoord = aTextureCoord.xy;\n\tmapTex1Coord = vec2((vTextureCoord.x - layoutCoord.x) / layoutCoord.z, (vTextureCoord.y - layoutCoord.y) / layoutCoord.w);\n\tvec4 gauTexCoord = vec4(aTextureCoord.xy,aTextureCoord.xy);\n\tif (heightFitV == 1) {\n\t\tgauTexCoord.y = vTextureCoord.y / layoutCoord.y * middle - offsetPixel;\n\t\tgauTexCoord.w = (vTextureCoord.y - layoutCoord.y - layoutCoord.w) / (1.0 - layoutCoord.y - layoutCoord.w) * (1.0 - middle) + middle + offsetPixel;\n\t}\n\tboxlbrt = vec4(layoutCoord.x, layoutCoord.y,layoutCoord.x + layoutCoord.z, layoutCoord.y + layoutCoord.w);\n\tmapTex2Coord = gauTexCoord;\n}";
    L5:
        if (r100 != 11001) goto L7;
        return "precision mediump float;     \nvarying vec2 vTextureCoord;     \nuniform sampler2D sTexture;     \nuniform sampler2D sTextureGauBlur;    \nuniform float edgeSize; //gaublur gradient length     \nuniform int heightFit;     \nvarying vec2 mapTex1Coord;\nvarying vec4 mapTex2Coord;\nvarying vec4 boxlbrt;\nfloat gaussPersent(float v, float middleValude, float edge) { \n    return smoothstep(0.0, edge, abs(v - middleValude)); \n} \n// return 1 if v inside the box, return 0 otherwise     \nfloat insideBox(vec2 v, vec2 bottomLeft, vec2 topRight) {     \n    vec2 s = step(bottomLeft, v) - (vec2(1.0,1.0) - step(v, topRight)); \n    return s.x * s.y;           \n}    \nvoid main() {  \n \tif (heightFit == 1)\n    {   \n        if (insideBox(vTextureCoord, vec2(boxlbrt.xy), vec2(boxlbrt.zw)) > 0.5) {   \n            gl_FragColor = texture2D(sTexture, mapTex1Coord); \n            return;\n        } else {   \n             if (mapTex1Coord.y <= 0.0) {   \n                vec4 gauColor = texture2D(sTextureGauBlur, vec2(mapTex2Coord.x, mapTex2Coord.y)); \n                vec4 originalColor = texture2D(sTexture, mapTex1Coord); \n                float gauPersent = gaussPersent(mapTex1Coord.y,0.0,edgeSize); \n                gl_FragColor = gauPersent * gauColor + (1.0 - gauPersent) * originalColor; \n                return;   \n            } else if (mapTex1Coord.y >= 1.0) {   \n                vec4 gauColor = texture2D(sTextureGauBlur, vec2(mapTex2Coord.z, mapTex2Coord.w));  \n                vec4 originalColor = texture2D(sTexture, mapTex1Coord); \n                float gauPersent = gaussPersent(mapTex1Coord.y,1.0,edgeSize); \n                gl_FragColor = gauPersent * gauColor + (1.0 - gauPersent) * originalColor; \n                return;   \n            }              \n        }   \n    } else {\n    \t gl_FragColor = texture2D(sTexture, vTextureCoord);             \n    }        \n}\n";
    L7:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        this.mInTextureTarget = 3553;
        this.mEnableOptVer2 = r100.getBoolean(TextureRenderKeys.KEY_IS_DYGAUSSBLUR_OPT_VER2, false);
        this.mEdgeSize = r100.getFloat(TextureRenderKeys.KEY_IS_EDGE_SIZE, 0.01f);
        if (this.mEnableOptVer2 == false) goto L5;
        this.mOffsetPixelInGauBlurTex = r100.getFloat(TextureRenderKeys.KEY_IS_DYGAU_OFFSET_PIX, 0.0f);
    L7:
        if (this.mLayoutCoord != null) goto L9;
        this.mLayoutCoord = new float[4];
    L9:
        int r101 = super.init(r100);
        if (r101 != 0) goto L12;
        this.mLayoutCoordLoc = GLES20.glGetUniformLocation(this.mProgram, "layoutCoord");
        this.mEdgeSizeLoc = GLES20.glGetUniformLocation(this.mProgram, "edgeSize");
        this.mHeightFitLoc = GLES20.glGetUniformLocation(this.mProgram, "heightFit");
        this.mGaussBlurTexLoc = GLES20.glGetUniformLocation(this.mProgram, "sTextureGauBlur");
        this.mOffsetPixelLoc = GLES20.glGetUniformLocation(this.mProgram, "offsetPixel");
        this.mHeightFitLocV = GLES20.glGetUniformLocation(this.mProgram, "heightFitV");
        this.mMiddleLoc = GLES20.glGetUniformLocation(this.mProgram, "middle");
    L12:
        GLES20.glUseProgram(this.mProgram);
        return r101;
    L5:
        this.mOffsetPixelInGauBlurTex = r100.getFloat(TextureRenderKeys.KEY_IS_DYGAU_OFFSET_PIX, 1.0f);
        goto L7
    }

    public void setGaussianBlurTexture(EffectTexture r100) {
        this.mGaussianBlurTex = r100;
    }

    public void setLayoutCoord(float[] r100) {
        this.mLayoutCoord = r100;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r101) {
        if (this.mEnableOptVer2 == false) goto L6;
        EffectTexture.TextureWrapType r102 = EffectTexture.TextureWrapType.WRAP_MIRRORED_REPEAT;
        r100.switchWrapType(r102, r102);
    L6:
        return super.process(r100, r101);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int updateRenderParam(EffectTexture r100, FrameBuffer r101) {
        int r102 = this.mSurfaceWidth;
        this.mViewPortWidth = r102;
        int r103 = this.mSurfaceHeight;
        this.mViewPortHeight = r103;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        this.mOutTexHeight = r103;
        this.mOutTexWidth = r102;
        return 0;
    }

    public void updateSurfaceViewPortSize(int r100, int r101) {
        this.mSurfaceWidth = r100;
        this.mSurfaceHeight = r101;
    }
}
