package com.bytedance.ies.web.jsbridge2;

/* JADX INFO: loaded from: classes19.dex */
public abstract class g0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f249354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f249355b;

    public abstract T b();

    public final T a() {
        T r100 = this.f249355b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        if (this.f249354a == true) goto L24;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (this.f249354a == false) goto L13;
        T r101 = this.f249355b;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
    L21:
        return r101;
    L13:
        this.f249355b = b();     // Catch: Throwable -> L17
        this.f249354a = true;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        r101 = this.f249355b;
        goto L21
    L24:
        return this.f249355b;
    }

    public g0() {
        this.f249354a = false;
    }
}
