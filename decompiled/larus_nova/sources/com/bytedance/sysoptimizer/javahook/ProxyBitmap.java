package com.bytedance.sysoptimizer.javahook;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyBitmap {
    private static final String TAG = "ProxyBitmap";

    public ProxyBitmap() {
    }

    public void recycle() throws Throwable {
        AHook.getCallback().d(TAG, "recycle() called " + this);
        AHook.callOrigin(OriginMethodKey.KEY_RECYCLE, this, new Object[0]);
    }
}
