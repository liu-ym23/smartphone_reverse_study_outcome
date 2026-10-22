package com.bytedance.sysoptimizer.javahook;

/* JADX INFO: loaded from: classes22.dex */
public class ProxySystem {
    private static final String TAG = "ProxySystem";

    public ProxySystem() {
    }

    public static void exit(int r100) throws Throwable {
        AHook.getCallback().e(TAG, "exit() called with: status = [" + r100 + "]", new Throwable());
        AHook.callOrigin(OriginMethodKey.KEY_SYSTEM_EXIT, null, new Object[]{Integer.valueOf(r100)});
    }
}
