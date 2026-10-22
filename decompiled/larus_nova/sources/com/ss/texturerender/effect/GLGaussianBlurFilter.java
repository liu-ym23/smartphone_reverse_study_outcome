package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;

/* JADX INFO: loaded from: classes40.dex */
public class GLGaussianBlurFilter extends GLDefaultFilter {
    private static final int BASE_RESOLUTION = 172800;
    private static final float DEFAULT_SIGMA = 2.0f;
    private static final float MAX_SIGMA = 26.0f;
    private int mBlurRadius;
    private int mBlurRadiusLoc;
    private float mGaussianAlpha;
    private int mGaussianAlphaLoc;
    private float[] mGaussianWeights;
    private int mGaussianWeightsLoc;
    private boolean mIsGaussianWeightsSet;
    protected int mProcessStage;
    private float mScaleRatio;
    protected float mSigma;
    private int mTexH;
    private int mTexW;
    private float mTexelHeightOffset;
    private int mTexelOffsetLoc;
    private float mTexelWidthOffset;
    private final String vertexDefaultShader;

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameAfter() {
        if (this.mGaussianAlpha >= 1.0f) goto L7;
        GLES20.glDisable(3042);
        return 0;
    L7:
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        if (this.mIsGaussianWeightsSet == true) goto L11;
        int r100 = this.mGaussianWeightsLoc;
        if (r100 < 0) goto L7;
        GLES20.glUniform1fv(r100, this.mBlurRadius + 1, this.mGaussianWeights, 0);
    L7:
        int r101 = this.mBlurRadiusLoc;
        if (r101 < 0) goto L10;
        GLES20.glUniform1i(r101, this.mBlurRadius);
    L10:
        this.mIsGaussianWeightsSet = true;
    L11:
        int r102 = this.mBlurRadiusLoc;
        if (r102 < 0) goto L14;
        GLES20.glUniform1i(r102, this.mBlurRadius);
    L14:
        int r103 = this.mTexelOffsetLoc;
        if (r103 < 0) goto L17;
        GLES20.glUniform2f(r103, this.mTexelWidthOffset, this.mTexelHeightOffset);
    L17:
        float r104 = this.mGaussianAlpha;
        if (r104 >= 1.0f) goto L23;
        int r105 = this.mGaussianAlphaLoc;
        if (r105 < 0) goto L22;
        GLES20.glUniform1f(r105, r104);
    L22:
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
    L23:
        return 0;
    }

    public GLGaussianBlurFilter(int r100) {
        super(r100, 10);
        this.vertexDefaultShader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float gaussianWeights[44];\nuniform int radius;\nuniform vec2 texelOffset;\nuniform float gaussianAlpha;\nvoid main() {\n    vec4 sum = texture2D(sTexture, vTextureCoord) * gaussianWeights[0];\n    for (int i = 1; i <= radius; i++) {\n        vec2 stepOffset = vec2(texelOffset.x * float(i), texelOffset.y * float(i));\n        sum += texture2D(sTexture, vTextureCoord + stepOffset) * gaussianWeights[i];\n        sum += texture2D(sTexture, vTextureCoord - stepOffset) * gaussianWeights[i];\n    }\n    gl_FragColor = vec4(sum.rgb, gaussianAlpha);\n}\n";
        this.mSigma = 2.0f;
        this.mIsGaussianWeightsSet = false;
        this.mGaussianWeightsLoc = -1;
        this.mTexelOffsetLoc = -1;
        this.mBlurRadiusLoc = -1;
        this.mGaussianAlphaLoc = -1;
        this.mTexelWidthOffset = 0.0f;
        this.mTexelHeightOffset = 0.0f;
        this.mGaussianAlpha = 1.0f;
        this.mProcessStage = -1;
        this.mOrder = 6;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLGaussianBlurFilter");
    }

    private void updateGaussianWeights(float r100) {
        float r101 = Math.max(Math.min(r100, MAX_SIGMA), 1.0f);
        this.mSigma = r101;
        this.mBlurRadius = (int) Math.floor(Math.sqrt((Math.pow(r101, 2.0d) * (-2.0d)) * Math.log(((double) 0.00390625f) * Math.sqrt(Math.pow(this.mSigma, 2.0d) * 6.283185307179586d))));
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "updateGaussianWeights sigma:" + this.mSigma + ",mBlurRadius:" + this.mBlurRadius);
        int r102 = 1;
        this.mGaussianWeights = new float[this.mBlurRadius + 1];
        int r103 = 0;
    L4:
        if (r103 > this.mBlurRadius) goto L6;
        this.mGaussianWeights[r103] = (float) getGaussianWeight(this.mSigma, r103);
        r103 = r103 + 1;
        goto L4
    L6:
        float r104 = this.mGaussianWeights[0];
    L8:
        if (r102 > this.mBlurRadius) goto L10;
        r104 = r104 + (this.mGaussianWeights[r102] * 2.0f);
        r102 = r102 + 1;
        goto L8
    L10:
        int r105 = 0;
    L12:
        if (r105 > this.mBlurRadius) goto L14;
        float[] r106 = this.mGaussianWeights;
        r106[r105] = r106[r105] / r104;
        r105 = r105 + 1;
        goto L12
    L14:
        this.mIsGaussianWeightsSet = false;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11001) goto L5;
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float gaussianWeights[44];\nuniform int radius;\nuniform vec2 texelOffset;\nuniform float gaussianAlpha;\nvoid main() {\n    vec4 sum = texture2D(sTexture, vTextureCoord) * gaussianWeights[0];\n    for (int i = 1; i <= radius; i++) {\n        vec2 stepOffset = vec2(texelOffset.x * float(i), texelOffset.y * float(i));\n        sum += texture2D(sTexture, vTextureCoord + stepOffset) * gaussianWeights[i];\n        sum += texture2D(sTexture, vTextureCoord - stepOffset) * gaussianWeights[i];\n    }\n    gl_FragColor = vec4(sum.rgb, gaussianAlpha);\n}\n";
    L5:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        if (super.init(r100) == 0) goto L9;
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L15;
        r101.notifyInitError(10, this.mEffectType, "super.init(bundle) != TR_OK");
        return -1;
    L15:
        return -1;
    L9:
        this.mGaussianWeightsLoc = GLES20.glGetUniformLocation(this.mProgram, "gaussianWeights");
        this.mTexelOffsetLoc = GLES20.glGetUniformLocation(this.mProgram, "texelOffset");
        this.mBlurRadiusLoc = GLES20.glGetUniformLocation(this.mProgram, "radius");
        this.mGaussianAlphaLoc = GLES20.glGetUniformLocation(this.mProgram, "gaussianAlpha");
        float r102 = r100.getFloat(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, -1.0f);
        if (r102 <= 1.0f) goto L12;
        updateGaussianWeights(r102);
    L13:
        this.mGaussianAlpha = r100.getFloat("alpha", 1.0f);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "GLGaussianBlurFilter init");
        return 0;
    L12:
        updateGaussianWeights(2.0f);
        goto L13
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mEffectType != r100.getInt("effect_type")) goto L15;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setOption:" + r100);
        if (r100.getInt("action") != 20) goto L18;
        float r101 = r100.getFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE, -1.0f);
        if (r101 != this.mSigma) goto L11;
        return;
    L11:
        if (r101 <= 0.0f) goto L17;
        updateGaussianWeights(r101);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "set strength:" + this.mSigma);
        return;
    L17:
        return;
    L18:
        return;
    }

    private double getGaussianWeight(float r100, int r110) {
        double r101 = r100;
        return (1.0d / Math.sqrt(Math.pow(r101, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(r110, 2.0d)) / (Math.pow(r101, 2.0d) * 2.0d));
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r110, FrameBuffer r111) {
        if (this.mSigma != 1.0f) goto L5;
        return r110;
    L5:
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L8;
        r100.currentEffectProcessBegin(this.mEffectType);
    L8:
        EffectTexture r112 = processWithTwoPass(r110, r111, true, false, true, false);
        VideoSurfaceTexture r113 = this.mSurfaceTexture;
        if (r113 == null) goto L11;
        r113.currentEffectProcessEnd(this.mEffectType);
    L11:
        return r112;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(int r100, float r101) {
        if (r100 == 20) goto L6;
        return;
    L6:
        if (r101 == this.mSigma) goto L9;
        updateGaussianWeights(r101);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "set strength:" + this.mSigma);
        return;
    }

    public EffectTexture processWithTwoPass(EffectTexture r100, FrameBuffer r101, boolean r102, boolean r103, boolean r110, boolean r111) {
        if (this.mTexH == r100.getHeight()) goto L5;
    L6:
        this.mTexW = r100.getWidth();
        int r104 = r100.getHeight();
        this.mTexH = r104;
        float r105 = (float) Math.sqrt(((this.mTexW * 1.0f) * r104) / 172800.0f);
        this.mScaleRatio = r105;
        this.mScaleRatio = Math.max(r105, 1.0f);
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "tex w:" + this.mTexW + ",h:" + this.mTexH + ",ratio:" + this.mScaleRatio);
    L7:
        int r106 = this.mProcessStage;
        if (r106 == (-1)) goto L14;
        if (r106 == 0) goto L14;
        if (r111 == false) goto L13;
        this.mTexelWidthOffset = (1.0f / r100.getWidth()) * this.mScaleRatio;
        this.mTexelHeightOffset = 0.0f;
    L17:
        EffectTexture r112 = super.process(r100, r101, Boolean.valueOf(r110));
        if (r102 == false) goto L24;
        this.mTexelWidthOffset = 0.0f;
        this.mTexelHeightOffset = (1.0f / r100.getHeight()) * this.mScaleRatio;
        if (r103 == false) goto L23;
        super.process(r112, null, Boolean.valueOf(r110));
        return null;
    L23:
        return super.process(r112, r101, Boolean.valueOf(r110));
    L24:
        return r112;
    L13:
        this.mTexelWidthOffset = 0.0f;
        this.mTexelHeightOffset = (1.0f / r100.getHeight()) * this.mScaleRatio;
    L14:
        if (r111 == false) goto L16;
        this.mTexelWidthOffset = 0.0f;
        this.mTexelHeightOffset = (1.0f / r100.getHeight()) * this.mScaleRatio;
        goto L17
    L16:
        this.mTexelWidthOffset = (1.0f / r100.getWidth()) * this.mScaleRatio;
        this.mTexelHeightOffset = 0.0f;
        goto L17
    L5:
        if (this.mTexW == r100.getWidth()) goto L7;
        goto L6
    }
}
