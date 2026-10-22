package com.bytedance.realx.video.agfx;

/* JADX INFO: loaded from: classes21.dex */
public class RXGPUCacheCtrl {
    private static RXGPUCacheCtrl instance;
    private long nativeHandle;

    private static native void nativeBind(long r100);

    private static native RXGPUCacheCtrl nativeGetInstance();

    private static native void nativeUnBind(long r100);

    public void bind() {
        nativeBind(this.nativeHandle);
    }

    public void unbind() {
        nativeUnBind(this.nativeHandle);
    }

    public static RXGPUCacheCtrl getInstance() {
        RXGPUCacheCtrl r100 = nativeGetInstance();
        instance = r100;
        return r100;
    }

    private RXGPUCacheCtrl(long r100) {
        this.nativeHandle = r100;
    }
}
