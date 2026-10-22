package com.bytedance.sysoptimizer.javahook;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyPhoneWindow {
    private static final String TAG = "ProxyPhoneWindow";

    public ProxyPhoneWindow() {
    }

    public void installDecor() throws Throwable {
        monitor-enter(this);
        AHook.callOrigin(OriginMethodKey.KEY_PHONEWINDOW_INSTALLDECOR, this, new Object[0]);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        AHook.getCallback().e(TAG, "installDecor() called this = [" + this + "", new Throwable());
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
