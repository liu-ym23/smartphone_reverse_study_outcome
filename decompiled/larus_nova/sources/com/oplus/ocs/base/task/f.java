package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
final class f<TResult> implements b<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f404281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f404282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile OnCompleteListener<TResult> f404283c;

    public final OnCompleteListener<TResult> a() {
        Object r100 = this.f404281a;
        monitor-enter(r100);
        OnCompleteListener<TResult> r101 = this.f404283c;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.oplus.ocs.base.task.b
    public final void a(Task<TResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "Task is not null");
        Object r101 = this.f404281a;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f404283c != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L11
        this.f404282b.execute(new g(this, r100));
    }

    public f(Executor r100, OnCompleteListener<TResult> r101) {
        this.f404281a = new Object();
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "OnCompleteListener is not null");
        this.f404282b = r100;
        this.f404283c = r101;
    }
}
