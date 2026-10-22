package com.bytedance.sysoptimizer.javahook;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyProcess {
    private static final String TAG = "ProxyProcess";

    public ProxyProcess() {
    }

    public static final void killProcess(int r100) throws Throwable {
        AHook.getCallback().e(TAG, "killProcess() called with: pid = [" + r100 + "]", new Throwable());
        AHook.callOrigin(OriginMethodKey.KEY_PROCESS_KILLPROCESS, null, new Object[]{Integer.valueOf(r100)});
    }
}
