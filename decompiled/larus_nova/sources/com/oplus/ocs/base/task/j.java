package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
final class j<TResult> implements b<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Executor f404291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f404292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile OnSuccessListener<? super TResult> f404293c;

    public final OnSuccessListener<? super TResult> a() {
        Object r100 = this.f404292b;
        monitor-enter(r100);
        OnSuccessListener<? super TResult> r101 = this.f404293c;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.oplus.ocs.base.task.b
    public final void a(Task<TResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "task is not null");
        if (r100.isSuccessful() == false) goto L15;
        Object r101 = this.f404292b;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f404293c != null) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        this.f404291a.execute(new k(this, r100));
        return;
    }

    public j(Executor r100, OnSuccessListener<? super TResult> r101) {
        this.f404292b = new Object();
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "OnSuccessListener is not null");
        this.f404291a = r100;
        this.f404293c = r101;
    }
}
