package com.ss.texturerender.effect;

import android.hardware.HardwareBuffer;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.base.EGLExt;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes40.dex */
public class HardwareBuffer2GLCopyFilter extends GLDefaultFilter {
    private static final int HARDWAREBUFFER_FORMAT_Y8Cb8Cr8_420 = 35;
    private static final int HARDWARE_EGL_POOL_SIZE = 20;
    private boolean mDoCopy;
    private long mEGLImageHandle;
    int mFrameBufferId;
    private HardwareBuffer mHardwareBuffer;
    private long mHardwareBufferEglPoolHandle;
    private boolean mHasYUVTargetExt;
    private int mInTexHeight;
    private Bundle mInTexRect;
    private int mInTexWidth;
    private EffectTexture mOutEffectTexture;
    int mOutTexFormat;
    int mOutTexId;
    int mOutTexTarget;
    private float[] mSTMatrix;
    private int muImageHeightHandle;
    private int muImageWidthHandle;
    private int muSTMatrixHandle;
    private final String oesFragmentShader;
    private final String oesFragmentShaderYUV;
    private final String oesVertexShader;

    private boolean isYUVTargetExtEnabled() {
        boolean r100 = GLES20.glGetString(7939).contains("GL_EXT_YUV_target");
        if (GLES20.glGetString(7937).contains("Mali") == false) goto L10;
        Matcher r101 = PatternProtector.compile("(r(\\d+)p)").matcher(GLES20.glGetString(7938));
        if (r101.find() == false) goto L11;
        String r102 = r101.group().replace("r", "").replace("p", "");
        if (CastIntegerProtector.parseInt(r102) >= 21) goto L12;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "Mali driverVersion = " + r102);
        return false;
    L12:
        return r100;
    L11:
        return r100;
    L10:
        return r100;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        GLES20.glUniform1i(this.muImageWidthHandle, this.mInTexWidth);
        GLES20.glUniform1i(this.muImageHeightHandle, this.mInTexHeight);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release");
        if (this.mFrameBufferId != 0) goto L5;
    L13:
        int r100 = this.mOutTexId;
        if (r100 == 0) goto L16;
        TexGLUtils.deleteTexture(r100);
        this.mOutTexId = 0;
    L16:
        long r101 = this.mHardwareBufferEglPoolHandle;
        if (r101 == 0) goto L20;
        EGLExt.destroyHardwareBufferEglPool(r101);
        this.mHardwareBufferEglPoolHandle = 0;
    L20:
        return super.release();
    L5:
        if (this.mHasYUVTargetExt == false) goto L12;
        long r102 = this.mEGLImageHandle;
        if (r102 == 0) goto L9;
        EGLExt.destroyEGLImage(r102);
        this.mEGLImageHandle = 0;
    L9:
        HardwareBuffer r103 = this.mHardwareBuffer;
        if (r103 == null) goto L12;
        EGLExt.destroyHardwareBuffer(r103);
        this.mHardwareBuffer = null;
    L12:
        TexGLUtils.deleteFbo(this.mFrameBufferId);
        this.mFrameBufferId = 0;
        goto L13
    }

    public HardwareBuffer2GLCopyFilter(int r100) {
        super(r100, 27);
        this.oesVertexShader = "#version 300 es\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
        this.oesFragmentShader = "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : enable\nprecision highp float;\nin vec2 vTextureCoord;\nuniform int uImageWidth;\nuniform int uImageHeight;\nuniform samplerExternalOES sTexture;\nout vec4 fragColor;\nvoid main() {\n  highp int x = int(vTextureCoord.x * float(uImageWidth));\n  highp int y = int(vTextureCoord.y * float(uImageHeight));\n  fragColor = texelFetch(sTexture, ivec2(x, y), 0);\n}\n";
        this.oesFragmentShaderYUV = "#version 300 es\n#extension GL_EXT_YUV_target : require\nprecision highp float;\nin vec2 vTextureCoord;\nuniform int uImageWidth;\nuniform int uImageHeight;\nuniform __samplerExternal2DY2YEXT sTexture;\nlayout(yuv) out vec4 fragColor;\nvoid main() {\n  highp int x = int(vTextureCoord.x * float(uImageWidth));\n  highp int y = int(vTextureCoord.y * float(uImageHeight));\n  fragColor = texelFetch(sTexture, ivec2(x, y), 0);\n}\n";
        this.mSTMatrix = new float[16];
        this.mDoCopy = false;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11000) goto L5;
        return "#version 300 es\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    L5:
        if (r100 == 11001) goto L9;
        return super.getStringOption(r100);
    L9:
        if (this.mHasYUVTargetExt == false) goto L11;
        return "#version 300 es\n#extension GL_EXT_YUV_target : require\nprecision highp float;\nin vec2 vTextureCoord;\nuniform int uImageWidth;\nuniform int uImageHeight;\nuniform __samplerExternal2DY2YEXT sTexture;\nlayout(yuv) out vec4 fragColor;\nvoid main() {\n  highp int x = int(vTextureCoord.x * float(uImageWidth));\n  highp int y = int(vTextureCoord.y * float(uImageHeight));\n  fragColor = texelFetch(sTexture, ivec2(x, y), 0);\n}\n";
    L11:
        return "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : enable\nprecision highp float;\nin vec2 vTextureCoord;\nuniform int uImageWidth;\nuniform int uImageHeight;\nuniform samplerExternalOES sTexture;\nout vec4 fragColor;\nvoid main() {\n  highp int x = int(vTextureCoord.x * float(uImageWidth));\n  highp int y = int(vTextureCoord.y * float(uImageHeight));\n  fragColor = texelFetch(sTexture, ivec2(x, y), 0);\n}\n";
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r110) {
        if (this.mDoCopy == true) goto L10;
        long r100 = EGLExt.createHardwareBufferEglPool(20);
        this.mHardwareBufferEglPoolHandle = r100;
        if (r100 != 0) goto L8;
        logError(6, "create HardwareBufferEglPool failed");
        return -1;
    L8:
        this.mOutTexTarget = 36197;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init success");
        return 0;
    L10:
        int r111 = super.init(null);
        if (r111 == 0) goto L14;
        logError(r111, "init failed");
        return r111;
    L14:
        this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        this.muImageWidthHandle = GLES20.glGetUniformLocation(this.mProgram, "uImageWidth");
        this.muImageHeightHandle = GLES20.glGetUniformLocation(this.mProgram, "uImageHeight");
        this.mFrameBufferId = TexGLUtils.createFbo();
        long r101 = EGLExt.createHardwareBufferEglPool(20);
        this.mHardwareBufferEglPoolHandle = r101;
        if (r101 != 0) goto L18;
        logError(6, "create HardwareBufferEglPool failed");
        return -1;
    L18:
        this.mInTextureTarget = 36197;
        this.mTextureMagFilter = 9728;
        this.mTextureMinFilter = 9728;
        if (this.mHasYUVTargetExt == false) goto L21;
        this.mOutTexTarget = 36197;
        Matrix.setIdentityM(this.mSTMatrix, 0);
    L22:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init success, hasYUVTargetExt = " + this.mHasYUVTargetExt);
        return r111;
    L21:
        this.mOutTexTarget = 3553;
        Matrix.setIdentityM(this.mSTMatrix, 0);
        float[] r102 = this.mSTMatrix;
        r102[5] = -1.0f;
        r102[13] = 1.0f;
        goto L22
    }

    private void logError(int r100, String r101) {
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, r101 + "," + r100);
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L6;
        r102.notifyError(r100, this.mEffectType, r101);
        return;
    }

    public EffectTexture process(HardwareBuffer r310, int[] r311) {
        if (r310 != null) goto L5;
    L112:
        logError(7, "invalid HardwareBuffer = " + r310);
        return null;
    L5:
        if (r310.isClosed() == true) goto L112;
        int r110 = r310.getWidth();
        int r111 = r310.getHeight();
        if (r311 != null) goto L10;
    L12:
        this.mDoClip = false;
        int r100 = r110;
        int r112 = r111;
        int r101 = 0;
        int r102 = 0;
    L14:
        if (this.mDoCopy == false) goto L16;
        int r312 = r102;
        int r103 = r100;
        int r113 = r101;
        int r313 = r112;
        int r104 = EGLExt.getOrCreateTextureByHardwareBuffer(this.mHardwareBufferEglPoolHandle, r310, r110, r111, this.mInTextureTarget);
        if (r104 > 0) goto L59;
        logError(7, "getOrCreateTextureByHardwareBuffer failed");
        VideoSurfaceTexture r105 = this.mSurfaceTexture;
        if (r105 == null) goto L115;
        r105.getEventLogger().setHardwareBufferProcessError(TexGLUtils.checkGLError(this.mTexType, "HardwareBuffer process failed"));
        return null;
    L115:
        return null;
    L59:
        if (this.mDoClip == true) goto L61;
        int r106 = r313;
        this.mInTexRect = null;
    L68:
        this.mInTexWidth = r110;
        this.mInTexHeight = r111;
        EffectTexture r107 = new EffectTexture(null, r104, r110, r111, this.mInTextureTarget, this.mInTexRect);
        if (this.mOutTexWidth != r103) goto L75;
        if (this.mOutTexHeight != r106) goto L75;
        String r108 = ",";
        String r114 = "]";
    L80:
        if (this.mOutTexId != 0) goto L102;
        int r109 = this.mOutTexTarget;
        if (r109 != 36197) goto L96;
        HardwareBuffer r115 = EGLExt.createHardwareBuffer(r103, r106, 35, 1, 768);
        this.mHardwareBuffer = r115;
        if (r115 != null) goto L87;
        logError(7, "create HardwareBuffer failed");
        return null;
    L87:
        long r116 = EGLExt.createEGLImage(r115);
        this.mEGLImageHandle = r116;
        if (r116 != 0) goto L91;
        logError(7, "create EGLImage failed");
        return null;
    L91:
        int r117 = TexGLUtils.genTexture(this.mOutTexTarget);
        this.mOutTexId = r117;
        GLES20.glBindTexture(this.mOutTexTarget, r117);
        int r118 = EGLExt.glEGLImageTargetTexture2DOES(this.mOutTexTarget, this.mEGLImageHandle);
        if (r118 == 0) goto L95;
        logError(r118, "eglImageTargetTexture2DOES failed");
        return null;
    L95:
        this.mOutTexFormat = 35;
    L97:
        this.mOutTexWidth = r103;
        this.mOutTexHeight = r106;
        int r119 = this.mOutTexTarget;
        if (r119 != 36197) goto L100;
        this.mOutEffectTexture = new EffectTexture(null, this.mOutTexId, r103, r106, r119, 0, this.mOutTexFormat, 0, null);
    L101:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "genTexture[" + this.mOutTexId + r108 + this.mOutTexWidth + r108 + this.mOutTexHeight + r108 + this.mOutTexTarget + r108 + this.mOutTexFormat + r114);
        goto L102
    L100:
        this.mOutEffectTexture = new EffectTexture(null, this.mOutTexId, r103, r106, r119, null);
        goto L101
    L96:
        int r120 = TexGLUtils.genTexture(r109);
        this.mOutTexId = r120;
        GLES20.glBindTexture(this.mOutTexTarget, r120);
        GLES20.glTexImage2D(this.mOutTexTarget, 0, 6408, r103, r106, 0, 6408, 5121, null);
    L102:
        GLES20.glBindFramebuffer(36160, this.mFrameBufferId);
        GLES20.glBindTexture(this.mOutTexTarget, this.mOutTexId);
        GLES20.glTexParameteri(this.mOutTexTarget, 10241, 9728);
        GLES20.glTexParameteri(this.mOutTexTarget, 10240, 9728);
        GLES20.glFramebufferTexture2D(36160, 36064, this.mOutTexTarget, this.mOutTexId, 0);
        int r121 = GLES20.glCheckFramebufferStatus(36160);
        if (r121 == 36053) goto L106;
        logError(r121, "glCheckFramebufferStatus failed");
        return null;
    L106:
        this.mViewPortX = 0;
        this.mViewPortY = 0;
        this.mViewPortWidth = this.mOutTexWidth;
        this.mViewPortHeight = this.mOutTexHeight;
        process(r107, null);
        GLES20.glBindTexture(this.mOutTexTarget, 0);
        GLES20.glFramebufferTexture2D(36160, 36064, this.mOutTexTarget, 0, 0);
        GLES20.glBindFramebuffer(36160, 0);
        int r122 = GLES20.glGetError();
        if (r122 == 0) goto L111;
        logError(r122, "process failed");
        return null;
    L111:
        return this.mOutEffectTexture;
    L75:
        if (this.mOutTexId <= 0) goto L77;
        int r123 = this.mTexType;
        String r124 = this.LOG_TAG;
        StringBuilder r125 = new StringBuilder("deleteTexture[");
        r125.append(this.mOutTexId);
        r108 = ",";
        r125.append(r108);
        r125.append(this.mOutTexWidth);
        r125.append(r108);
        r125.append(this.mOutTexHeight);
        r125.append(r108);
        r125.append(this.mOutTexTarget);
        r125.append(r108);
        r125.append(this.mOutTexFormat);
        r114 = "]";
        r125.append(r114);
        TextureRenderLog.i(r123, r124, r125.toString());
        TexGLUtils.deleteTexture(this.mOutTexId);
    L78:
        this.mOutTexId = 0;
        goto L80
    L77:
        r108 = ",";
        r114 = "]";
        goto L78
    L61:
        if (this.mInTexRect != null) goto L64;
        this.mInTexRect = new Bundle();
    L64:
        if (this.mOutTexTarget != 36197) goto L66;
        float r126 = r110;
        this.mInTexRect.putFloat("x", (r312 * 1.0f) / r126);
        float r127 = r111;
        this.mInTexRect.putFloat("y", (r113 * 1.0f) / r127);
        this.mInTexRect.putFloat("width", (r103 * 1.0f) / r126);
        r106 = r313;
        this.mInTexRect.putFloat("height", (r106 * 1.0f) / r127);
        goto L68
    L66:
        r106 = r313;
        float r128 = r110;
        this.mInTexRect.putFloat("x", (r312 * 1.0f) / r128);
        float r129 = r111;
        this.mInTexRect.putFloat("y", (((r111 - r106) - r113) * 1.0f) / r129);
        this.mInTexRect.putFloat("width", (r103 * 1.0f) / r128);
        this.mInTexRect.putFloat("height", (r106 * 1.0f) / r129);
        goto L68
    L16:
        if (this.mOutTexId != 0) goto L18;
        this.mOutTexId = TexGLUtils.genTexture(this.mOutTexTarget);
    L18:
        int r130 = r101;
        int r210 = r102;
        int r131 = r100;
        if (EGLExt.getTextureByHardwareBuffer(this.mHardwareBufferEglPoolHandle, r310, r110, r111, this.mOutTexTarget, this.mOutTexId) >= 0) goto L26;
        logError(7, "getTextureByHardwareBuffer failed");
        VideoSurfaceTexture r132 = this.mSurfaceTexture;
        if (r132 == null) goto L114;
        r132.getEventLogger().setHardwareBufferProcessError(TexGLUtils.checkGLError(this.mTexType, "HardwareBuffer process failed"));
        return null;
    L114:
        return null;
    L26:
        if (this.mDoClip == true) goto L28;
        int r133 = r131;
        if (this.mInTexRect == null) goto L35;
        Bundle r134 = null;
        boolean r135 = true;
    L36:
        this.mInTexRect = r134;
        boolean r136 = r135;
    L38:
        if (this.mInTexWidth == r110) goto L40;
    L48:
        this.mInTexWidth = r110;
        this.mInTexHeight = r111;
        this.mOutTexWidth = r133;
        this.mOutTexHeight = r112;
        this.mOutTexFormat = r310.getFormat();
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "genTexture[" + this.mOutTexId + "," + this.mInTexWidth + "," + this.mInTexHeight + "," + this.mOutTexTarget + "," + this.mOutTexFormat + "," + this.mInTexRect + "]");
        this.mOutEffectTexture = new EffectTexture(null, this.mOutTexId, this.mInTexWidth, this.mInTexHeight, this.mOutTexTarget, 0, this.mOutTexFormat, 0, this.mInTexRect);
    L50:
        return this.mOutEffectTexture;
    L40:
        if (this.mInTexHeight != r111) goto L48;
        if (this.mOutTexWidth != r133) goto L48;
        if (this.mOutTexHeight != r112) goto L48;
        if (this.mOutTexFormat != r310.getFormat()) goto L48;
        if (r136 == false) goto L50;
    L35:
        r134 = null;
        r135 = false;
        goto L36
    L28:
        if (this.mInTexRect != null) goto L30;
        this.mInTexRect = new Bundle();
        r136 = true;
    L31:
        float r137 = r110;
        this.mInTexRect.putFloat("x", (r210 * 1.0f) / r137);
        float r138 = r111;
        this.mInTexRect.putFloat("y", (((r111 - r112) - r130) * 1.0f) / r138);
        r133 = r131;
        this.mInTexRect.putFloat("width", (r133 * 1.0f) / r137);
        this.mInTexRect.putFloat("height", (r112 * 1.0f) / r138);
        goto L38
    L30:
        r136 = false;
        goto L31
    L10:
        if (r311.length != 4) goto L12;
        int r139 = r311[0];
        int r140 = r311[1];
        int r141 = r311[2];
        int r142 = r311[3];
        this.mDoClip = true;
        r112 = r142;
        r102 = r139;
        r101 = r140;
        r100 = r141;
        goto L14
    }
}
