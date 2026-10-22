package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
final class d<TResult> implements b<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Executor f404277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f404278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile OnCanceledListener f404279c;

    public final OnCanceledListener a() {
        Object r100 = this.f404278b;
        monitor-enter(r100);
        OnCanceledListener r101 = this.f404279c;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.oplus.ocs.base.task.b
    public final void a(Task r100) {
        com.oplus.ocs.base.utils.d.a(r100, "Task is not null");
        if (r100.isCanceled() == false) goto L15;
        Object r101 = this.f404278b;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f404279c != null) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        this.f404277a.execute(new e(this));
        return;
    }

    public d(Executor r100, OnCanceledListener r101) {
        this.f404278b = new Object();
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "OnCanceledListener is not null");
        this.f404277a = r100;
        this.f404279c = r101;
    }
}
