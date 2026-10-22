package com.bytedance.bmmt.video.agfx;

/* JADX INFO: loaded from: classes8.dex */
public class GPUCacheCtrl {
    private static GPUCacheCtrl instance;
    private long nativeHandle;

    private static native void nativeBind(long r100);

    private static native GPUCacheCtrl nativeGetInstance();

    private static native void nativeUnBind(long r100);

    public void bind() {
        nativeBind(this.nativeHandle);
    }

    public void unbind() {
        nativeUnBind(this.nativeHandle);
    }

    public static GPUCacheCtrl getInstance() {
        GPUCacheCtrl r100 = nativeGetInstance();
        instance = r100;
        return r100;
    }

    private GPUCacheCtrl(long r100) {
        this.nativeHandle = r100;
    }
}
