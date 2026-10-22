package com.bytedance.sysoptimizer.javahook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.android.internal.policy.PhoneWindow;
import com.bytedance.sysoptimizer.proxyinstance.ProxyInstance;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyPhoneWindowV2 extends PhoneWindow {
    private static final String TAG = "ProxyPhoneWindowV2";
    private static boolean sLog;

    @Override // com.android.internal.policy.PhoneWindow, android.view.Window
    public synchronized View getDecorView() {
        monitor-enter(this);
        View r100 = super.getDecorView();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public ProxyPhoneWindowV2(Context r100) {
        super(r100);
    }

    @Override // com.android.internal.policy.PhoneWindow, android.view.Window
    public synchronized void setContentView(int r100) {
        monitor-enter(this);
        super.setContentView(r100);     // Catch: Throwable -> L9
        if (sLog == false) goto L7;
        ProxyInstance.getCallback().e(TAG, "setContentView() called with: layoutResID = [" + r100 + "]", new Throwable());     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.internal.policy.PhoneWindow, android.view.Window
    public synchronized void setContentView(View r100) {
        monitor-enter(this);
        super.setContentView(r100);     // Catch: Throwable -> L9
        if (sLog == false) goto L7;
        ProxyInstance.getCallback().e(TAG, "setContentView() called with: view = [" + r100 + "]", new Throwable());     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.internal.policy.PhoneWindow, android.view.Window
    public synchronized void addContentView(View r100, ViewGroup.LayoutParams r101) {
        monitor-enter(this);
        super.addContentView(r100, r101);     // Catch: Throwable -> L9
        if (sLog == false) goto L7;
        ProxyInstance.getCallback().e(TAG, "addContentView() called with: view = [" + r100 + "], params = [" + r101 + "]", new Throwable());     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.internal.policy.PhoneWindow, android.view.Window
    public synchronized void setContentView(View r100, ViewGroup.LayoutParams r101) {
        monitor-enter(this);
        super.setContentView(r100, r101);     // Catch: Throwable -> L9
        if (sLog == false) goto L7;
        ProxyInstance.getCallback().e(TAG, "setContentView() called with: view = [" + r100 + "], params = [" + r101 + "]", new Throwable());     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
