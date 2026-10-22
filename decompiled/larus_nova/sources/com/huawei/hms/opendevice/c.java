package com.huawei.hms.opendevice;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes23.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadGroup f277527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f277528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f277529c;

    public c(String r100) {
        this.f277528b = 1;
        SecurityManager r101 = System.getSecurityManager();
        if (r101 == null) goto L5;
        ThreadGroup r102 = r101.getThreadGroup();
    L6:
        this.f277527a = r102;
        this.f277529c = r100 + "-pool-";
        return;
    L5:
        r102 = Thread.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        monitor-enter(this);
        this.f277528b++;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        Thread r101 = new Thread(this.f277527a, r100, this.f277529c + this.f277528b, 0);
        r101.setUncaughtExceptionHandler(null);
        if (r101.isDaemon() == false) goto L8;
        r101.setDaemon(false);
    L8:
        return r101;
    L9:
        th = move-exception;
        throw th;
    }
}
