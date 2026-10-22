package com.bytedance.sysoptimizer.javahook;

import java.security.AccessControlContext;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyThread {
    private static final String TAG = "ProxyThread";

    public void run() throws Throwable {
    }

    public synchronized void start() throws Throwable {
        monitor-enter(this);
        monitor-exit(this);
    }

    public ProxyThread() throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_Thread_INIT, this, new Object[0]);
        AHook.getCallback().d(TAG, "ProxyThread() called");
    }

    public ProxyThread(Runnable r100) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_Thread_INIT_1, this, new Object[]{r100});
        AHook.getCallback().d(TAG, "ProxyThread() called with: target = [" + r100 + "], this = [" + this + "]");
    }

    public ProxyThread(String r100) {
    }

    public ProxyThread(Runnable r100, String r101) {
    }

    public ProxyThread(Runnable r100, AccessControlContext r101) {
    }

    public ProxyThread(ThreadGroup r100, Runnable r101) {
    }

    public ProxyThread(ThreadGroup r100, String r101) {
    }

    public ProxyThread(ThreadGroup r100, Runnable r101, String r102) {
    }

    public ProxyThread(ThreadGroup r100, Runnable r101, String r102, long r103) {
    }

    public ProxyThread(ThreadGroup r100, String r101, int r102, boolean r103) {
    }
}
