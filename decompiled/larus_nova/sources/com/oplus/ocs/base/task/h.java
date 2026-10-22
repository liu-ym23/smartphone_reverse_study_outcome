package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
final class h<TResult> implements b<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Executor f404286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f404287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile OnFailureListener f404288c;

    public final OnFailureListener a() {
        Object r100 = this.f404287b;
        monitor-enter(r100);
        OnFailureListener r101 = this.f404288c;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.oplus.ocs.base.task.b
    public final void a(Task<TResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "Task is not null");
        if (r100.isSuccessful() == false) goto L5;
        return;
    L5:
        if (r100.isCanceled() == true) goto L19;
        Object r101 = this.f404287b;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.f404288c != null) goto L12;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        this.f404286a.execute(new i(this, r100));
        return;
    }

    public h(Executor r100, OnFailureListener r101) {
        this.f404287b = new Object();
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "OnFailureListener is not null");
        this.f404286a = r100;
        this.f404288c = r101;
    }
}
