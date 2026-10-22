package com.bytedance.realx.video.memory;

import android.graphics.Matrix;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.bytedance.realx.video.MediaCodecTextureBufferHelper;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.RXVideoMemoryType;
import com.bytedance.realx.video.RXVideoRotation;
import com.bytedance.realx.video.RXVideoScaleFilter;
import com.bytedance.realx.video.RendererCommon;

/* JADX INFO: loaded from: classes21.dex */
public class NativeRXOpenGLMemory extends RXVideoMemory implements RXVideoOpenGLMemoryInterface {
    private static native long nativeCreateOpenGLMemory(int r100, int r101, int r102, int r103, int r104, RXPixelFormat r105, float[] r106, EGLContext r107, RXVideoScaleFilter r108, RXVideoRotation r109, Runnable r110);

    private static native long nativeGetGLSync(long r100);

    private static native int nativeGetHeight(long r100);

    private static native EGLContext nativeGetJavaEGLContext(long r100);

    private static native long nativeGetNativeEGLContext(long r100);

    private static native RXVideoRotation nativeGetRotation(long r100);

    private static native RXVideoScaleFilter nativeGetScaleFilter(long r100);

    private static native int nativeGetTextureId(long r100);

    private static native float[] nativeGetTextureMatrix(long r100);

    private static native RXPixelFormat nativeGetTextureTarget(long r100);

    private static native int nativeGetUnscaledHeight(long r100);

    private static native int nativeGetUnscaledWidth(long r100);

    private static native RXVideoMemoryType nativeGetVideoMemoryType(long r100);

    private static native int nativeGetWidth(long r100);

    private static native void nativeReleaseTextureVideoMemory(long r100);

    private static native void nativeSetRenderHelper(long r100, MediaCodecTextureBufferHelper r101);

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public int getHeight() {
        return nativeGetHeight(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public RXVideoScaleFilter getScaleFilter() {
        return nativeGetScaleFilter(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public int getUnScaledHeight() {
        return nativeGetUnscaledHeight(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public int getUnScaledWidth() {
        return nativeGetUnscaledWidth(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public int getWidth() {
        return nativeGetWidth(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public Matrix getAndroidTextureMatrix() {
        if (isNullPointer() == false) goto L7;
        return new Matrix();
    L7:
        return RendererCommon.convertMatrixToAndroidGraphicsMatrix(nativeGetTextureMatrix(this.nativeHandle));
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public EGLContext getEGLContext() {
        if (isNullPointer() == false) goto L7;
        return EGL14.EGL_NO_CONTEXT;
    L7:
        return nativeGetJavaEGLContext(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public long getGLSync() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetGLSync(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public RXVideoMemoryType getMemoryType() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetVideoMemoryType(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public long getNativeEGLContext() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetNativeEGLContext(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoMemoryInterface
    public RXPixelFormat getPixelFormat() {
        return getTextureTarget();
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public RXVideoRotation getRotation() {
        if (isNullPointer() == false) goto L7;
        return null;
    L7:
        return nativeGetRotation(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public int getTextureId() {
        if (isNullPointer() == false) goto L7;
        return 0;
    L7:
        return nativeGetTextureId(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
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

    @Override // com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface
    public RXPixelFormat getTextureTarget() {
        if (isNullPointer() == false) goto L7;
        return RXPixelFormat.kUnknown;
    L7:
        return nativeGetTextureTarget(this.nativeHandle);
    }

    public NativeRXOpenGLMemory(long r100) {
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

    public static NativeRXOpenGLMemory createRXOpenGLMemory(int r100, int r101, int r102, int r103, int r104, RXPixelFormat r105, float[] r106, EGLContext r107, RXVideoScaleFilter r108, RXVideoRotation r109, Runnable r110) {
        return new NativeRXOpenGLMemory(nativeCreateOpenGLMemory(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110));
    }
}
