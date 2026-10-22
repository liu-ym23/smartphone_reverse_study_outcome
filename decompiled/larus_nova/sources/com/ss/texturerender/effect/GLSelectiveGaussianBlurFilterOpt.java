package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;

/* JADX INFO: loaded from: classes40.dex */
public class GLSelectiveGaussianBlurFilterOpt extends GLGaussianBlurFilter {
    private final String fragmentShaderEmptyFunc;
    private final String fragmentShaderGaussianFunc;
    private final String fragmentShaderMainFunc;
    private final String fragmentShaderParam;
    private float mDisplayHeight;
    private float mDisplayWidth;
    private float mDisplayX;
    private float mDisplayY;
    private boolean mEnableOptVer2;
    protected boolean mEnableSecondPass;
    private EffectTexture mFirstGauBlurTexture;
    private int mGauBlurLongTexLength;
    private int mGaussianBlurTexHeight;
    private int mGaussianBlurTexWidth;
    public int mHeightFit;
    private int mHeightFitLoc;
    private int mHeightFitLocV;
    protected int mInTexHeight;
    protected int mInTexWidth;
    protected float[] mLayoutCoord;
    private int mLayoutCoordLoc;
    private int mMiddleLoc;
    private int mProcessStageLoc;
    private int mProcessStageLocV;
    private EffectTexture mSecondGauBlurTexture;
    protected int mSurfaceHeight;
    protected int mSurfaceWidth;
    private final String vertexShaderParam;

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public EffectTexture genTexture() {
        if (this.mGaussianBlurTexWidth != 0) goto L5;
    L6:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "gaussianBlur size invaild");
    L7:
        int r100 = this.mProcessStage;
        if (r100 != 0) goto L25;
        EffectTexture r101 = this.mFirstGauBlurTexture;
        if (r101 != null) goto L12;
    L15:
        EffectTexture r102 = this.mFirstGauBlurTexture;
        if (r102 == null) goto L18;
        _releaseEffectTex(r102);
        this.mFirstGauBlurTexture = null;
    L18:
        VideoSurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 == null) goto L21;
        this.mFirstGauBlurTexture = _genTexture(this.mGaussianBlurTexWidth, this.mGaussianBlurTexHeight, r103.getIntOption(130), this.mOutTexRect);
    L23:
        return this.mFirstGauBlurTexture;
    L21:
        this.mFirstGauBlurTexture = _genTexture(this.mGaussianBlurTexWidth, this.mGaussianBlurTexHeight, this.mOutTexRect);
        goto L23
    L12:
        if (r101.getWidth() != this.mGaussianBlurTexWidth) goto L15;
        if (this.mFirstGauBlurTexture.getHeight() == this.mGaussianBlurTexHeight) goto L23;
    L25:
        if (r100 != 1) goto L41;
        EffectTexture r104 = this.mSecondGauBlurTexture;
        if (r104 != null) goto L29;
    L32:
        EffectTexture r105 = this.mSecondGauBlurTexture;
        if (r105 == null) goto L35;
        _releaseEffectTex(r105);
        this.mSecondGauBlurTexture = null;
    L35:
        VideoSurfaceTexture r106 = this.mSurfaceTexture;
        if (r106 == null) goto L38;
        this.mSecondGauBlurTexture = _genTexture(this.mGaussianBlurTexWidth, this.mGaussianBlurTexHeight, r106.getIntOption(130), this.mOutTexRect);
    L40:
        return this.mSecondGauBlurTexture;
    L38:
        this.mSecondGauBlurTexture = _genTexture(this.mGaussianBlurTexWidth, this.mGaussianBlurTexHeight, this.mOutTexRect);
        goto L40
    L29:
        if (r104.getWidth() != this.mGaussianBlurTexWidth) goto L32;
        if (this.mSecondGauBlurTexture.getHeight() == this.mGaussianBlurTexHeight) goto L40;
    L41:
        return null;
    L5:
        if (this.mGaussianBlurTexHeight != 0) goto L7;
        goto L6
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        float r100 = 0.0f;
        if (this.mProcessStage != 0) goto L8;
        float r101 = this.mDisplayX;
        if (r101 >= 0.0f) goto L7;
        updateLayoutCoord((this.mSurfaceHeight * 1.0f) / this.mSurfaceWidth, (this.mInTexHeight * 1.0f) / this.mInTexWidth, 0, this.mLayoutAspectRatio, this.mLayoutCoord);
        goto L8
    L7:
        float[] r102 = this.mLayoutCoord;
        r102[0] = r101;
        r102[1] = this.mDisplayY;
        r102[2] = this.mDisplayWidth;
        r102[3] = this.mDisplayHeight;
    L8:
        int r103 = this.mLayoutCoordLoc;
        float[] r104 = this.mLayoutCoord;
        GLES20.glUniform4f(r103, r104[0], r104[1], r104[2], r104[3]);
        int r105 = this.mProcessStageLoc;
        if (r105 < 0) goto L11;
        GLES20.glUniform1i(r105, this.mProcessStage);
        GLES20.glUniform1i(this.mProcessStageLocV, this.mProcessStage);
    L11:
        GLES20.glUniform1i(this.mHeightFitLoc, this.mHeightFit);
        GLES20.glUniform1i(this.mHeightFitLocV, this.mHeightFit);
        if (this.mEnableOptVer2 == false) goto L14;
        r100 = 0.5f;
    L17:
        GLES20.glUniform1f(this.mMiddleLoc, r100);
        TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays before,type:" + this.mEffectType);
        return super.onDrawFrameBefore();
    L14:
        float[] r106 = this.mLayoutCoord;
        float r107 = r106[3];
        if ((1.0f - r107) <= 0.0f) goto L17;
        r100 = r106[1] / (1.0f - r107);
        goto L17
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        EffectTexture r100 = this.mFirstGauBlurTexture;
        if (r100 == null) goto L5;
        _releaseEffectTex(r100);
        this.mFirstGauBlurTexture = null;
    L5:
        EffectTexture r101 = this.mSecondGauBlurTexture;
        if (r101 == null) goto L9;
        _releaseEffectTex(r101);
        this.mSecondGauBlurTexture = null;
    L9:
        return super.release();
    }

    public EffectTexture getSecondGauBlurTexture() {
        return this.mSecondGauBlurTexture;
    }

    public GLSelectiveGaussianBlurFilterOpt(int r100) {
        super(r100);
        this.vertexShaderParam = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec4 vTextureCoordGau;\nuniform vec4 layoutCoord;//x,y,w,h\nuniform int processStageV;//0:stage1;1:stage2\nuniform int heightFitV;//SurfaceRatio > TexRatio\nuniform float middle;\nvarying float middleF;\nvoid main() {\n \tgl_Position =  aPosition;\n\tvTextureCoord = aTextureCoord.xy;\n\tvec4 realCoord = vec4(aTextureCoord.xy,aTextureCoord.xy);\n\tif (processStageV == 0) {\n\t\tif (heightFitV == 1) {\n\t\t\tfloat ycoordb = -(((vTextureCoord.y / middle * layoutCoord.y) - layoutCoord.y) / layoutCoord.w);\n\t\t\tfloat ycoordt =  2.0 - ((((vTextureCoord.y - middle) / (1.0 - middle) * (1.0 - layoutCoord.y - layoutCoord.w) + (layoutCoord.y + layoutCoord.w)) -layoutCoord.y) / layoutCoord.w);\n\t\t\trealCoord.y = ycoordb;\n\t\t\trealCoord.w = ycoordt;\n\t\t}\n\t}\n\tmiddleF = middle;\n\tvTextureCoordGau = realCoord;\n}\n";
        this.fragmentShaderParam = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float gaussianAlpha;\nuniform int processStage;//0:stage1;1:stage2\nuniform int heightFit;//SurfaceRatio > TexRatio\nvarying vec4 vTextureCoordGau;\nvarying float middleF;";
        this.fragmentShaderMainFunc = " void main() {\n     vec2 resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n    if (processStage == 0)\n    {\n        if (heightFit == 1) {\n            if (vTextureCoord.y <= middleF) {\n                resetCoord = vec2(vTextureCoordGau.x, vTextureCoordGau.y);\n            } else {\n                resetCoord = vec2(vTextureCoordGau.z, vTextureCoordGau.w);\n            }\n        } else {\n            resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n        }\n    }\n    vec4 oriColor = texture2D(sTexture, resetCoord);\n    gl_FragColor = gaussianBlurKernel(oriColor, resetCoord);\n }";
        this.fragmentShaderGaussianFunc = "uniform float gaussianWeights[44];\nuniform int radius;\nuniform vec2 texelOffset;\nvec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord) {\n    int curRadius = radius;\n    vec4 sum = oriColor * gaussianWeights[0];\n    for (int i = 1; i <= curRadius; i++) {\n        vec2 stepOffset = vec2(texelOffset.x * float(i), texelOffset.y * float(i));\n        sum += texture2D(sTexture, texCoord + stepOffset) * gaussianWeights[i];\n        sum += texture2D(sTexture, texCoord - stepOffset) * gaussianWeights[i];\n    }\n    return sum;\n}\n";
        this.fragmentShaderEmptyFunc = "vec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord) {\n    return oriColor;\n}\n";
        this.mDisplayX = -1.0f;
        this.mLayoutCoord = null;
        this.mLayoutCoordLoc = -1;
        this.mProcessStageLoc = -1;
        this.mProcessStageLocV = -1;
        this.mEnableSecondPass = false;
        this.mInTexHeight = -1;
        this.mInTexWidth = -1;
        this.mSurfaceHeight = -1;
        this.mSurfaceWidth = -1;
        this.mFirstGauBlurTexture = null;
        this.mSecondGauBlurTexture = null;
        this.mGaussianBlurTexWidth = 0;
        this.mGaussianBlurTexHeight = 0;
        this.mGauBlurLongTexLength = 320;
        this.mHeightFit = 0;
        this.mHeightFitLoc = -1;
        this.mHeightFitLocV = -1;
        this.mMiddleLoc = -1;
        this.mEnableOptVer2 = false;
        this.mEffectType = 15;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLSelectiveGaussianBlurFilter");
    }

    private void _releaseEffectTex(EffectTexture r100) {
        if (r100 == null) goto L5;
        TexGLUtils.deleteTexture(r100.getTexID());
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "onTextureReturn delTex:" + r100);
        return;
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11000) goto L5;
        return "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec4 vTextureCoordGau;\nuniform vec4 layoutCoord;//x,y,w,h\nuniform int processStageV;//0:stage1;1:stage2\nuniform int heightFitV;//SurfaceRatio > TexRatio\nuniform float middle;\nvarying float middleF;\nvoid main() {\n \tgl_Position =  aPosition;\n\tvTextureCoord = aTextureCoord.xy;\n\tvec4 realCoord = vec4(aTextureCoord.xy,aTextureCoord.xy);\n\tif (processStageV == 0) {\n\t\tif (heightFitV == 1) {\n\t\t\tfloat ycoordb = -(((vTextureCoord.y / middle * layoutCoord.y) - layoutCoord.y) / layoutCoord.w);\n\t\t\tfloat ycoordt =  2.0 - ((((vTextureCoord.y - middle) / (1.0 - middle) * (1.0 - layoutCoord.y - layoutCoord.w) + (layoutCoord.y + layoutCoord.w)) -layoutCoord.y) / layoutCoord.w);\n\t\t\trealCoord.y = ycoordb;\n\t\t\trealCoord.w = ycoordt;\n\t\t}\n\t}\n\tmiddleF = middle;\n\tvTextureCoordGau = realCoord;\n}\n";
    L5:
        if (r100 == 11001) goto L9;
        return super.getStringOption(r100);
    L9:
        if (this.mSigma != 1.0f) goto L13;
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float gaussianAlpha;\nuniform int processStage;//0:stage1;1:stage2\nuniform int heightFit;//SurfaceRatio > TexRatio\nvarying vec4 vTextureCoordGau;\nvarying float middleF;vec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord) {\n    return oriColor;\n}\n void main() {\n     vec2 resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n    if (processStage == 0)\n    {\n        if (heightFit == 1) {\n            if (vTextureCoord.y <= middleF) {\n                resetCoord = vec2(vTextureCoordGau.x, vTextureCoordGau.y);\n            } else {\n                resetCoord = vec2(vTextureCoordGau.z, vTextureCoordGau.w);\n            }\n        } else {\n            resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n        }\n    }\n    vec4 oriColor = texture2D(sTexture, resetCoord);\n    gl_FragColor = gaussianBlurKernel(oriColor, resetCoord);\n }";
    L13:
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float gaussianAlpha;\nuniform int processStage;//0:stage1;1:stage2\nuniform int heightFit;//SurfaceRatio > TexRatio\nvarying vec4 vTextureCoordGau;\nvarying float middleF;uniform float gaussianWeights[44];\nuniform int radius;\nuniform vec2 texelOffset;\nvec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord) {\n    int curRadius = radius;\n    vec4 sum = oriColor * gaussianWeights[0];\n    for (int i = 1; i <= curRadius; i++) {\n        vec2 stepOffset = vec2(texelOffset.x * float(i), texelOffset.y * float(i));\n        sum += texture2D(sTexture, texCoord + stepOffset) * gaussianWeights[i];\n        sum += texture2D(sTexture, texCoord - stepOffset) * gaussianWeights[i];\n    }\n    return sum;\n}\n void main() {\n     vec2 resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n    if (processStage == 0)\n    {\n        if (heightFit == 1) {\n            if (vTextureCoord.y <= middleF) {\n                resetCoord = vec2(vTextureCoordGau.x, vTextureCoordGau.y);\n            } else {\n                resetCoord = vec2(vTextureCoordGau.z, vTextureCoordGau.w);\n            }\n        } else {\n            resetCoord = vec2(vTextureCoord.x, vTextureCoord.y);\n        }\n    }\n    vec4 oriColor = texture2D(sTexture, resetCoord);\n    gl_FragColor = gaussianBlurKernel(oriColor, resetCoord);\n }";
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        this.mInTextureTarget = 3553;
        this.mSigma = r100.getFloat(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, -1.0f);
        this.mEnableOptVer2 = r100.getBoolean(TextureRenderKeys.KEY_IS_DYGAUSSBLUR_OPT_VER2, false);
        if (this.mLayoutCoord != null) goto L6;
        this.mLayoutCoord = new float[4];
    L6:
        if (r100.containsKey("x") == false) goto L8;
        this.mDisplayX = r100.getFloat("x", 0.0f);
        this.mDisplayY = r100.getFloat("y", 0.0f);
        this.mDisplayWidth = r100.getFloat("width", 1.0f);
        this.mDisplayHeight = r100.getFloat("height", 1.0f);
    L9:
        this.mGauBlurLongTexLength = r100.getInt(TextureRenderKeys.KEY_IS_SELECT_GAUSSBLUR_TEX_LENGTH, 320);
        int r101 = super.init(r100);
        if (r101 != 0) goto L12;
        this.mLayoutCoordLoc = GLES20.glGetUniformLocation(this.mProgram, "layoutCoord");
        this.mProcessStageLoc = GLES20.glGetUniformLocation(this.mProgram, "processStage");
        this.mHeightFitLoc = GLES20.glGetUniformLocation(this.mProgram, "heightFit");
        this.mProcessStageLocV = GLES20.glGetUniformLocation(this.mProgram, "processStageV");
        this.mHeightFitLocV = GLES20.glGetUniformLocation(this.mProgram, "heightFitV");
        this.mMiddleLoc = GLES20.glGetUniformLocation(this.mProgram, "middle");
    L12:
        GLES20.glUseProgram(this.mProgram);
        return r101;
    L8:
        this.mLayoutAspectRatio = r100.getFloat(TextureRenderKeys.KEY_IS_ASPECT_RATIO, 0.5f);
        goto L9
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r110) {
        this.mInTexWidth = r100.getWidth();
        this.mInTexHeight = r100.getHeight();
        this.mSurfaceWidth = this.mSurfaceTexture.getViewportWidth();
        int r101 = this.mSurfaceTexture.getViewportHeight();
        this.mSurfaceHeight = r101;
        if (((r101 * 1.0f) / this.mSurfaceWidth) < ((this.mInTexHeight * 1.0f) / this.mInTexWidth)) goto L5;
        this.mHeightFit = 1;
    L7:
        return processWithTwoPass(r100, r110, false, false, false, true);
    L5:
        this.mHeightFit = 0;
        goto L7
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int updateRenderParam(EffectTexture r100, FrameBuffer r101) {
        if (this.mProcessStage != 0) goto L5;
        cacluGauBlurTexSize((this.mSurfaceHeight * 1.0f) / this.mSurfaceWidth, (this.mInTexHeight * 1.0f) / this.mInTexWidth, 0);
    L5:
        int r102 = this.mGaussianBlurTexWidth;
        this.mViewPortWidth = r102;
        int r103 = this.mGaussianBlurTexHeight;
        this.mViewPortHeight = r103;
        this.mViewPortX = 0;
        this.mViewPortY = 0;
        this.mOutTexWidth = r102;
        this.mOutTexHeight = r103;
        return 0;
    }

    private EffectTexture _genTexture(int r100, int r101, Bundle r110) {
        return _genTexture(r100, r101, 6408, 6408, 5121, r110);
    }

    private void cacluGauBlurTexSize(float r100, float r101, int r102) {
        if (r102 == 0) goto L4;
        return;
    L4:
        if (r100 < r101) goto L11;
        float r103 = this.mSurfaceHeight;
        int r104 = this.mSurfaceWidth;
        float r105 = r103 - (r104 * r101);
        if (r105 <= r104) goto L8;
        int r106 = this.mGauBlurLongTexLength;
        this.mGaussianBlurTexHeight = r106;
        this.mGaussianBlurTexWidth = (int) (r106 * (r104 / r105));
        return;
    L8:
        int r107 = this.mGauBlurLongTexLength;
        this.mGaussianBlurTexWidth = r107;
        this.mGaussianBlurTexHeight = (int) (r107 * (r105 / r104));
        return;
    }

    private EffectTexture _genTexture(int r100, int r110, int r111, Bundle r112) {
        if (r111 < 10) goto L7;
        return _genTexture(r100, r110, 32857, 6408, 33640, r112);
    L7:
        return _genTexture(r100, r110, r112);
    }

    private void updateLayoutCoord(float r100, float r101, int r102, float r110, float[] r111) {
        if (r102 == 0) goto L4;
        return;
    L4:
        if (r100 < r101) goto L6;
        float r103 = r101 / r100;
        r111[0] = 0.0f;
        r111[1] = (1.0f - r103) * r110;
        r111[2] = 1.0f;
        r111[3] = r103;
        return;
    L6:
        float r104 = r100 / r101;
        r111[0] = (1.0f - r104) * r110;
        r111[1] = 0.0f;
        r111[2] = r104;
        r111[3] = 1.0f;
    }

    private EffectTexture _genTexture(int r110, int r111, int r112, int r113, int r114, Bundle r210) {
        int r100 = TexGLUtils.genTexture(3553);
        GLES20.glBindTexture(3553, r100);
        GLES20.glTexImage2D(3553, 0, r112, r110, r111, 0, r113, r114, null);
        EffectTexture r101 = new EffectTexture(null, r100, r110, r111, 3553, r112, r113, r114, r210);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "genTexture:" + r101.toString());
        return r101;
    }
}
