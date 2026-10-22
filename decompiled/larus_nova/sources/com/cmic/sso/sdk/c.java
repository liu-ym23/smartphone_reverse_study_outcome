package com.cmic.sso.sdk;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f273351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f273352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f273353c;

    public void a() {
        com.cmic.sso.sdk.e.c.b("LockManager", "unLockPre");
        Object r100 = this.f273352b;
        monitor-enter(r100);
        this.f273353c = false;     // Catch: Throwable -> L7 Exception -> L9
        this.f273352b.notify();     // Catch: Throwable -> L7 Exception -> L9
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        com.cmic.sso.sdk.e.c.a("LockManager", "unLock error ");     // Catch: Throwable -> L7
        goto L11
    }

    public c() {
        this.f273351a = "LockManager";
        this.f273352b = new Object();
        this.f273353c = false;
    }

    public void a(long r100) {
        Object r101 = this.f273352b;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f273353c == false) goto L11;
        com.cmic.sso.sdk.e.c.b("LockManager", "wait for pre");     // Catch: Throwable -> L14
        this.f273352b.wait(r100);     // Catch: InterruptedException -> L9 Throwable -> L14
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L11:
        this.f273353c = true;     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
    }
}
