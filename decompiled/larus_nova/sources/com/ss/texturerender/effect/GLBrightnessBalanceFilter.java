package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.camera.core.processing.util.GLUtils;
import com.ss.texturerender.ShaderHelper;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes40.dex */
public class GLBrightnessBalanceFilter extends GLDefaultFilter {
    private final int STATUS_ERROR;
    private final int STATUS_INITIALIZED;
    private final int STATUS_RELEASED;
    private final int STATUS_RUNNING;
    private final int THRESHOLD_MAX;
    private final int THRESHOLD_MIN;
    private final String fragmentShader;
    private float mAlpha;
    private RenderObject mCurrentRenderObject;
    private int mFadeInThreshold;
    private WeakReference<VideoSurfaceTexture> mLastSurfaceTextureRef;
    private SparseArray<RenderObject> mRenderObjects;
    private float[] mSTMatrix;
    private final AtomicInteger mStatus;
    private int mThresh1;
    private int mThresh2;
    private float mThreshExp;
    private final String oesFragmentShader;
    private final String oesVertexShader;

    /* JADX INFO: renamed from: com.ss.texturerender.effect.GLBrightnessBalanceFilter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class RenderObject {
        int aPositionHandle;
        int aTextureCoordHandle;
        int program;
        int sTextureHandle;
        int uAlphaHandle;
        int uAlphaStepHandle;
        int uSTMatrixHandle;
        int uThresh1Handle;
        int uThresh2Handle;
        int uThreshExpHandle;

        private RenderObject() {
        }

        public /* synthetic */ RenderObject(AnonymousClass1 r100) {
            this();
        }
    }

    private void releaseOesRenderObject() {
        RenderObject r100 = this.mRenderObjects.get(36197);
        if (r100 == null) goto L5;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release oes render object");
        GLES20.glDeleteProgram(r100.program);
    L5:
        this.mRenderObjects.remove(36197);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        if (this.mInTextureTarget != 36197) goto L5;
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        GLES20.glUniformMatrix4fv(this.mCurrentRenderObject.uSTMatrixHandle, 1, false, this.mSTMatrix, 0);
    L5:
        GLES20.glUniform1f(this.mCurrentRenderObject.uAlphaHandle, this.mAlpha);
        int r100 = this.mFadeInThreshold;
        float r101 = 1.0f;
        if (r100 <= 0) goto L8;
        float r102 = Math.min((1.0f / r100) * this.mSurfaceTexture.getFrameCountReceived(), 1.0f);
    L9:
        GLES20.glUniform1f(this.mCurrentRenderObject.uAlphaStepHandle, r102);
        int r103 = this.mThresh2;
        if (r103 < 0) goto L16;
        int r104 = this.mThresh1;
        if (r103 >= r104) goto L16;
        if (r104 > 255) goto L16;
        float r105 = r104 * 1.0f;
        float r106 = r103 * 1.0f;
        r101 = this.mThreshExp;
    L17:
        GLES20.glUniform1f(this.mCurrentRenderObject.uThresh1Handle, r105);
        GLES20.glUniform1f(this.mCurrentRenderObject.uThresh2Handle, r106);
        GLES20.glUniform1f(this.mCurrentRenderObject.uThreshExpHandle, r101);
        return 0;
    L16:
        r105 = 257.0f;
        r106 = 256.0f;
        goto L17
    L8:
        r102 = 1.0f;
        goto L9
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        if (this.mStatus.compareAndSet(1, 0) == false) goto L5;
    L10:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release");
        releaseOesRenderObject();
        AbsEffect r100 = super.release();
        this.mRenderObjects.clear();
        return r100;
    L5:
        if (this.mStatus.compareAndSet(2, 0) == true) goto L10;
        if (this.mStatus.compareAndSet(-1, 0) == true) goto L10;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "released");
        return super.release();
    }

    private int initOesRenderObject() {
        int r100 = ShaderHelper.compileShader(35633, "uniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n");
        int r101 = ShaderHelper.compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uAlpha;\nuniform float uAlphaStep;\nuniform float uThresh1;\nuniform float uThresh2;\nuniform float uThreshExp;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float lumi = clamp(0.299 * color.r + 0.587 * color.g + 0.114 * color.b, 0.0, 1.0) * 255.0;\n  float tmp1 = step(uThresh1, lumi);\n  float tmp2 = step(uThresh2, lumi);\n  float thresh_step1 = (1.0 - tmp1) * tmp2 * clamp((lumi - uThresh2) * (1.0 / (uThresh1 - uThresh2)), 0.000001, 1.0);\n  float thresh_step2 = (1.0 - tmp1) * tmp2 * pow(thresh_step1, uThreshExp);\n  float tmp3 = tmp1 + (1.0 - tmp1) * (tmp2 * (thresh_step2 * (1.0 - uAlpha) + uAlpha) + (1.0 - tmp2) * uAlpha);\n  float alpha = 1.0 + (tmp3 - 1.0) * uAlphaStep;\n  vec3 rgb_linear = pow(color.rgb, vec3(2.2));\n  vec3 rga_bright = rgb_linear * alpha;\n  vec3 srgb = clamp(pow(rga_bright, vec3(1.0 / 2.2)), 0.0, 1.0);\n  gl_FragColor = vec4(srgb, color.a);\n}\n");
        if (r100 == 0) goto L12;
        if (r101 == 0) goto L12;
        AnonymousClass1 r102 = null;
        int r103 = ShaderHelper.createAndLinkProgram(r100, r101, null);
        if (r103 != 0) goto L10;
        setInitErrorCode(9, "link oes shader failed");
        return -1;
    L10:
        RenderObject r104 = new RenderObject(r102);
        r104.program = r103;
        r104.uSTMatrixHandle = GLES20.glGetUniformLocation(r103, "uSTMatrix");
        r104.aPositionHandle = GLES20.glGetAttribLocation(r103, "aPosition");
        r104.aTextureCoordHandle = GLES20.glGetAttribLocation(r103, "aTextureCoord");
        r104.sTextureHandle = GLES20.glGetUniformLocation(r103, GLUtils.VAR_TEXTURE);
        r104.uAlphaHandle = GLES20.glGetUniformLocation(r103, "uAlpha");
        r104.uAlphaStepHandle = GLES20.glGetUniformLocation(r103, "uAlphaStep");
        r104.uThresh1Handle = GLES20.glGetUniformLocation(r103, "uThresh1");
        r104.uThresh2Handle = GLES20.glGetUniformLocation(r103, "uThresh2");
        r104.uThreshExpHandle = GLES20.glGetUniformLocation(r103, "uThreshExp");
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init oes render object success");
        this.mRenderObjects.put(36197, r104);
        return 0;
    L12:
        setInitErrorCode(8, "compile oes shader failed");
        return -1;
    }

    public GLBrightnessBalanceFilter(int r100) {
        super(r100, 30);
        this.fragmentShader = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nuniform float uAlphaStep;\nuniform float uThresh1;\nuniform float uThresh2;\nuniform float uThreshExp;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float lumi = clamp(0.299 * color.r + 0.587 * color.g + 0.114 * color.b, 0.0, 1.0) * 255.0;\n  float tmp1 = step(uThresh1, lumi);\n  float tmp2 = step(uThresh2, lumi);\n  float thresh_step1 = (1.0 - tmp1) * tmp2 * clamp((lumi - uThresh2) * (1.0 / (uThresh1 - uThresh2)), 0.000001, 1.0);\n  float thresh_step2 = (1.0 - tmp1) * tmp2 * pow(thresh_step1, uThreshExp);\n  float tmp3 = tmp1 + (1.0 - tmp1) * (tmp2 * (thresh_step2 * (1.0 - uAlpha) + uAlpha) + (1.0 - tmp2) * uAlpha);\n  float alpha = 1.0 + (tmp3 - 1.0) * uAlphaStep;\n  vec3 rgb_linear = pow(color.rgb, vec3(2.2));\n  vec3 rga_bright = rgb_linear * alpha;\n  vec3 srgb = clamp(pow(rga_bright, vec3(1.0 / 2.2)), 0.0, 1.0);\n  gl_FragColor = vec4(srgb, color.a);\n}\n";
        this.oesVertexShader = "uniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
        this.oesFragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uAlpha;\nuniform float uAlphaStep;\nuniform float uThresh1;\nuniform float uThresh2;\nuniform float uThreshExp;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float lumi = clamp(0.299 * color.r + 0.587 * color.g + 0.114 * color.b, 0.0, 1.0) * 255.0;\n  float tmp1 = step(uThresh1, lumi);\n  float tmp2 = step(uThresh2, lumi);\n  float thresh_step1 = (1.0 - tmp1) * tmp2 * clamp((lumi - uThresh2) * (1.0 / (uThresh1 - uThresh2)), 0.000001, 1.0);\n  float thresh_step2 = (1.0 - tmp1) * tmp2 * pow(thresh_step1, uThreshExp);\n  float tmp3 = tmp1 + (1.0 - tmp1) * (tmp2 * (thresh_step2 * (1.0 - uAlpha) + uAlpha) + (1.0 - tmp2) * uAlpha);\n  float alpha = 1.0 + (tmp3 - 1.0) * uAlphaStep;\n  vec3 rgb_linear = pow(color.rgb, vec3(2.2));\n  vec3 rga_bright = rgb_linear * alpha;\n  vec3 srgb = clamp(pow(rga_bright, vec3(1.0 / 2.2)), 0.0, 1.0);\n  gl_FragColor = vec4(srgb, color.a);\n}\n";
        this.mRenderObjects = new SparseArray();
        this.mAlpha = 1.0f;
        this.mSTMatrix = new float[16];
        this.THRESHOLD_MIN = 0;
        this.THRESHOLD_MAX = 255;
        this.STATUS_ERROR = -1;
        this.STATUS_RELEASED = 0;
        this.STATUS_INITIALIZED = 1;
        this.STATUS_RUNNING = 2;
        this.mStatus = new AtomicInteger(0);
        this.mLastSurfaceTextureRef = new WeakReference(null);
    }

    private void setUseEffect(int r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.setOption(19, this.mEffectType, r100);
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11001) goto L5;
        return "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nuniform float uAlphaStep;\nuniform float uThresh1;\nuniform float uThresh2;\nuniform float uThreshExp;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float lumi = clamp(0.299 * color.r + 0.587 * color.g + 0.114 * color.b, 0.0, 1.0) * 255.0;\n  float tmp1 = step(uThresh1, lumi);\n  float tmp2 = step(uThresh2, lumi);\n  float thresh_step1 = (1.0 - tmp1) * tmp2 * clamp((lumi - uThresh2) * (1.0 / (uThresh1 - uThresh2)), 0.000001, 1.0);\n  float thresh_step2 = (1.0 - tmp1) * tmp2 * pow(thresh_step1, uThreshExp);\n  float tmp3 = tmp1 + (1.0 - tmp1) * (tmp2 * (thresh_step2 * (1.0 - uAlpha) + uAlpha) + (1.0 - tmp2) * uAlpha);\n  float alpha = 1.0 + (tmp3 - 1.0) * uAlphaStep;\n  vec3 rgb_linear = pow(color.rgb, vec3(2.2));\n  vec3 rga_bright = rgb_linear * alpha;\n  vec3 srgb = clamp(pow(rga_bright, vec3(1.0 / 2.2)), 0.0, 1.0);\n  gl_FragColor = vec4(srgb, color.a);\n}\n";
    L5:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        if (this.mStatus.compareAndSet(0, 1) == false) goto L5;
    L8:
        int r101 = super.init(r100);
        if (r101 == 0) goto L12;
        this.mStatus.set(-1);
        return r101;
    L12:
        RenderObject r102 = new RenderObject(null);
        int r103 = this.mProgram;
        r102.program = r103;
        r102.aPositionHandle = this.maPositionHandle;
        r102.aTextureCoordHandle = this.maTextureHandle;
        r102.sTextureHandle = this.mInputTextureHandle;
        r102.uAlphaHandle = GLES20.glGetUniformLocation(r103, "uAlpha");
        r102.uAlphaStepHandle = GLES20.glGetUniformLocation(this.mProgram, "uAlphaStep");
        r102.uThresh1Handle = GLES20.glGetUniformLocation(this.mProgram, "uThresh1");
        r102.uThresh2Handle = GLES20.glGetUniformLocation(this.mProgram, "uThresh2");
        r102.uThreshExpHandle = GLES20.glGetUniformLocation(this.mProgram, "uThreshExp");
        this.mRenderObjects.put(3553, r102);
        if (initOesRenderObject() == 0) goto L16;
        this.mStatus.set(-1);
        return -1;
    L16:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init success");
        return 0;
    L5:
        if (this.mStatus.get() == (-1)) goto L7;
        return 0;
    L7:
        release();
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "reInit");
        this.mStatus.set(1);
        goto L8
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onPrepareDrawFrame(EffectTexture r100) {
        RenderObject r101 = this.mCurrentRenderObject;
        this.mProgram = r101.program;
        this.maPositionHandle = r101.aPositionHandle;
        this.maTextureHandle = r101.aTextureCoordHandle;
        this.mInputTextureHandle = r101.sTextureHandle;
        return 0;
    }

    private void setErrorCode(int r100, String r101) {
        if (r100 == 0) goto L4;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error = " + r100 + " detail = " + r101);
    L4:
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L10;
        if (r100 == 0) goto L8;
        r102.notifyError(r100, this.mEffectType, r101);
        return;
    L8:
        r102.setOption(126, this.mEffectType, 0);
        return;
    }

    private void setInitErrorCode(int r100, String r101) {
        if (r100 == 0) goto L4;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error = " + r100 + " detail = " + r101);
    L4:
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L8;
        r102.notifyInitError(r100, this.mEffectType, r101);
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r110, FrameBuffer r111) {
        if (this.mSurfaceTexture != null) goto L7;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "invalid surface texture");
        return r110;
    L7:
        if (this.mStatus.get() == 1) goto L10;
        setErrorCode(6, this.mSurfaceTexture + " invalid status");
        setUseEffect(0);
        return r110;
    L10:
        int r100 = r110.getTexTarget();
        this.mInTextureTarget = r100;
        RenderObject r101 = this.mRenderObjects.get(r100);
        this.mCurrentRenderObject = r101;
        if (r101 != null) goto L14;
        setErrorCode(13, this.mSurfaceTexture + " no render object");
        setUseEffect(0);
        return r110;
    L14:
        VideoSurfaceTexture r102 = this.mLastSurfaceTextureRef.get();
        if (r102 != null) goto L17;
    L18:
        this.mLastSurfaceTextureRef = new WeakReference(this.mSurfaceTexture);
        Bundle r103 = this.mSurfaceTexture.getBundleOption(184);
        if (r103 != null) goto L22;
        setErrorCode(11, this.mSurfaceTexture + " no params found");
        setUseEffect(0);
        return r110;
    L22:
        this.mAlpha = r103.getFloat("alpha", 1.0f);
        this.mFadeInThreshold = r103.getInt(TextureRenderKeys.KEY_IS_BRIGHTNESS_BALANCE_FADE_IN_THRESHOLD, 0);
        this.mThresh1 = r103.getInt(TextureRenderKeys.KEY_IS_BRIGHTNESS_BALANCE_THRESHOLD1, -1);
        this.mThresh2 = r103.getInt(TextureRenderKeys.KEY_IS_BRIGHTNESS_BALANCE_THRESHOLD2, -1);
        this.mThreshExp = Math.max(r103.getFloat(TextureRenderKeys.KEY_IS_BRIGHTNESS_BALANCE_THRESHOLD_EXP, 0.0f), 1.0f);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, this.mSurfaceTexture + " use alpha = " + this.mAlpha + ", thresh1 = " + this.mThresh1 + ", thresh2 = " + this.mThresh2 + ", threshExp = " + this.mThreshExp + ", fadeInThreshold = " + this.mFadeInThreshold);
    L23:
        EffectTexture r112 = super.process(r110, r111);
        if (this.mGLError == 0) goto L26;
        setUseEffect(0);
    L29:
        return r112;
    L26:
        setErrorCode(0, "");
        setUseEffect(1);
        if ((this.mSurfaceTexture.getFrameCountReceived() % 100) != 0) goto L29;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, this.mSurfaceTexture + " process success texTarget = " + this.mInTextureTarget + ", alpha = " + this.mAlpha + ", thresh1 = " + this.mThresh1 + ", thresh2 = " + this.mThresh2 + ", threshExp = " + this.mThreshExp + ", fadeInThreshold = " + this.mFadeInThreshold);
        goto L29
    L17:
        if (r102 == this.mSurfaceTexture) goto L23;
        goto L18
    }
}
