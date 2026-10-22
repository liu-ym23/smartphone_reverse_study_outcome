package com.bytedance.bmmt.video.memory;

import android.graphics.Matrix;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.bytedance.bmmt.video.BmmtGlConfig;
import com.bytedance.bmmt.video.BmmtVideoMemoryType;
import com.bytedance.bmmt.video.MediaCodecTextureBufferHelper;
import com.bytedance.bmmt.video.PixelFormat;
import com.bytedance.bmmt.video.RendererCommon;
import com.bytedance.bmmt.video.VideoRotation;
import com.bytedance.bmmt.video.VideoScaleFilter;

/* JADX INFO: loaded from: classes8.dex */
public class NativeBmmtOpenGLMemory extends BmmtVideoMemory implements BmmtVideoOpenGLMemoryInterface {
    private static native long nativeCreateOpenGLMemory(int r100, int r101, int r102, int r103, int r104, int r105, PixelFormat r106, float[] r107, EGLContext r108, VideoScaleFilter r109, VideoRotation r110, Runnable r111);

    private static native long nativeGetGLSync(long r100);

    private static native int nativeGetHeight(long r100);

    private static native EGLContext nativeGetJavaEGLContext(long r100);

    private static native long nativeGetNativeEGLContext(long r100);

    private static native VideoRotation nativeGetRotation(long r100);

    private static native VideoScaleFilter nativeGetScaleFilter(long r100);

    private static native int nativeGetTextureId(long r100);

    private static native float[] nativeGetTextureMatrix(long r100);

    private static native PixelFormat nativeGetTextureTarget(long r100);

    private static native int nativeGetUnscaledHeight(long r100);

    private static native int nativeGetUnscaledWidth(long r100);

    private static native BmmtVideoMemoryType nativeGetVideoMemoryType(long r100);

    private static native int nativeGetWidth(long r100);

    private static native void nativeReleaseTextureVideoMemory(long r100);

    private static native void nativeSetRenderHelper(long r100, MediaCodecTextureBufferHelper r101);

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public int getHeight() {
        return nativeGetHeight(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public VideoScaleFilter getScaleFilter() {
        return nativeGetScaleFilter(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public int getUnScaledHeight() {
        return nativeGetUnscaledHeight(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public int getUnScaledWidth() {
        return nativeGetUnscaledWidth(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public int getWidth() {
        return nativeGetWidth(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public Matrix getAndroidTextureMatrix() {
        if (isNullPointer() == false) goto L7;
        return new Matrix();
    L7:
        return RendererCommon.convertMatrixToAndroidGraphicsMatrix(nativeGetTextureMatrix(this.nativeHandle));
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public EGLContext getEGLContext() {
        if (isNullPointer() == false) goto L7;
        return EGL14.EGL_NO_CONTEXT;
    L7:
        return nativeGetJavaEGLContext(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public long getGLSync() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetGLSync(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public BmmtVideoMemoryType getMemoryType() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetVideoMemoryType(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public long getNativeEGLContext() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetNativeEGLContext(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoMemoryInterface
    public PixelFormat getPixelFormat() {
        return getTextureTarget();
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public VideoRotation getRotation() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetRotation(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public int getTextureId() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetTextureId(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public float[] getTextureMatrix() {
        if (isNullPointer() == false) goto L7;
        float[] r100 = new float[16];
        r100[0] = 1.0f;
        r100[5] = 1.0f;
        r100[10] = 1.0f;
        r100[15] = 1.0f;
        return r100;
    L7:
        return nativeGetTextureMatrix(this.nativeHandle);
    }

    @Override // com.bytedance.bmmt.video.memory.BmmtVideoOpenGLMemoryInterface
    public PixelFormat getTextureTarget() {
        if (isNullPointer() == false) goto L7;
        return PixelFormat.kUnknown;
    L7:
        return nativeGetTextureTarget(this.nativeHandle);
    }

    public NativeBmmtOpenGLMemory(long r100) {
        super(r100);
    }

    private static void release(Runnable r100) {
        if (r100 == null) goto L5;
        r100.run();
        return;
    }

    public void setRenderHelper(MediaCodecTextureBufferHelper r100) {
        nativeSetRenderHelper(this.nativeHandle, r100);
    }

    public static NativeBmmtOpenGLMemory createOpenGLMemory(int r110, int r111, int r112, int r113, int r114, PixelFormat r115, float[] r116, EGLContext r117, VideoScaleFilter r210, VideoRotation r211, Runnable r212) {
        return new NativeBmmtOpenGLMemory(nativeCreateOpenGLMemory(r110, r111, r112, r113, r114, BmmtGlConfig.getTexture2DGlFormat(), r115, r116, r117, r210, r211, r212));
    }
}
