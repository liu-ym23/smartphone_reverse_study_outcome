package com.bytedance.sdk.account.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class i<T> {
    public volatile boolean a;
    public volatile boolean b;
    public volatile T c;

    public abstract T b();

    public final T a() {
        if (this.c == null) goto L7;
        return this.c;
    L7:
        if (this.b == true) goto L28;
        if (this.a == true) goto L28;
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L13:
        if (this.b == false) goto L17;
        T r0 = this.c;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
    L25:
        return r0;
    L17:
        this.c = b();     // Catch: Throwable -> L20
        this.b = true;     // Catch: Throwable -> L20
        r0 = this.c;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
    L28:
        return this.c;
    }

    public i() {
        this.a = false;
        this.b = false;
    }

    public void c(T r1) {
        this.c = r1;
        this.a = true;
    }
}
