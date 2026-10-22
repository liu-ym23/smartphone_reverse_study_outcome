package com.bytedance.realx.video.memory;

import android.opengl.EGLContext;
import com.bytedance.realx.video.RXPixelFormat;
import com.bytedance.realx.video.RXVideoMemoryType;
import com.bytedance.realx.video.RXVideoRotation;
import com.bytedance.realx.video.RXVideoScaleFilter;

/* JADX INFO: loaded from: classes21.dex */
public class NativeTextureVideoMemory extends RXVideoTextureMemory {
    private long nativeHandle;

    public static /* synthetic */ void b(NativeTextureVideoMemory r100) {
        r100.lambda$new$0();
    }

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

    private /* synthetic */ void lambda$new$0() {
        long r100 = this.nativeHandle;
        if (r100 == 0) goto L6;
        nativeReleaseTextureVideoMemory(r100);
        this.nativeHandle = 0;
        return;
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public EGLContext getEGLContext() {
        long r100 = this.nativeHandle;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return nativeGetJavaEGLContext(r100);
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public int getHeight() {
        long r100 = this.nativeHandle;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return nativeGetHeight(r100);
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public RXVideoMemoryType getMemoryType() {
        long r100 = this.nativeHandle;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return nativeGetVideoMemoryType(r100);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public long getNativeEGLContext() {
        long r100 = this.nativeHandle;
        if (r100 != 0) goto L6;
        return 0;
    L6:
        return nativeGetNativeEGLContext(r100);
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public RXVideoRotation getRotation() {
        long r100 = this.nativeHandle;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return nativeGetRotation(r100);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public RXVideoScaleFilter getScaleFilter() {
        return nativeGetScaleFilter(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public int getTextureId() {
        long r100 = this.nativeHandle;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return nativeGetTextureId(r100);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public float[] getTextureMatrix() {
        long r100 = this.nativeHandle;
        if (r100 != 0) goto L7;
        float[] r101 = new float[16];
        r101[0] = 1.0f;
        r101[5] = 1.0f;
        r101[10] = 1.0f;
        r101[15] = 1.0f;
        return r101;
    L7:
        return nativeGetTextureMatrix(r100);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public RXPixelFormat getTextureTarget() {
        long r100 = this.nativeHandle;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return nativeGetTextureTarget(r100);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public int getUnScaledHeight() {
        return nativeGetUnscaledHeight(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RXVideoTextureMemory
    public int getUnScaledWidth() {
        return nativeGetUnscaledWidth(this.nativeHandle);
    }

    @Override // com.bytedance.realx.video.memory.RTCVideoMemory
    public int getWidth() {
        long r100 = this.nativeHandle;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return nativeGetWidth(r100);
    }

    public NativeTextureVideoMemory(long r100) {
        this.nativeHandle = r100;
        setReleaseCallback(new b(this));
    }
}
