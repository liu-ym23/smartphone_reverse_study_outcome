package com.bytedance.sdk.account.utils;

/* JADX INFO: loaded from: classes.dex */
public abstract class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f269545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f269546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile T f269547c;

    public abstract T b();

    public final T a() {
        if (this.f269547c == null) goto L7;
        return this.f269547c;
    L7:
        if (this.f269546b == true) goto L28;
        if (this.f269545a == true) goto L28;
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L13:
        if (this.f269546b == false) goto L17;
        T r100 = this.f269547c;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
    L25:
        return r100;
    L17:
        this.f269547c = b();     // Catch: Throwable -> L20
        this.f269546b = true;     // Catch: Throwable -> L20
        r100 = this.f269547c;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
    L28:
        return this.f269547c;
    }

    public i() {
        this.f269545a = false;
        this.f269546b = false;
    }

    public void c(T r100) {
        this.f269547c = r100;
        this.f269545a = true;
    }
}
