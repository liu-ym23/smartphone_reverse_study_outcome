package com.bytedance.lighten.core.utils;

/* JADX INFO: loaded from: classes20.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f254683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile T f254684b;

    public T b() {
        throw null;
    }

    public final T a() {
        if (this.f254684b == null) goto L7;
        return this.f254684b;
    L7:
        if (this.f254683a == true) goto L24;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L11:
        if (this.f254683a == false) goto L15;
        T r100 = this.f254684b;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
    L21:
        return r100;
    L15:
        this.f254684b = b();     // Catch: Throwable -> L18
        this.f254683a = true;     // Catch: Throwable -> L18
        r100 = this.f254684b;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        goto L21
    L24:
        return this.f254684b;
    }

    public a() {
        this.f254683a = false;
    }
}
