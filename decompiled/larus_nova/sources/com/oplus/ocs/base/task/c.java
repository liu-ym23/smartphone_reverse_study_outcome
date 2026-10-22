package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
final class c<TResult, TContinuationResult> implements b<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Continuation<TResult, TContinuationResult> f404274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    TaskImpl<TContinuationResult> f404275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Executor f404276c;

    @Override // com.oplus.ocs.base.task.b
    public final void a(Task<TResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "Task is not null");
        this.f404276c.execute(new l(this, r100));
    }

    public c(Executor r100, Continuation<TResult, TContinuationResult> r101, TaskImpl<TContinuationResult> r102) {
        com.oplus.ocs.base.utils.d.a(r100, "Executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "Continuation is not null");
        com.oplus.ocs.base.utils.d.a(r102, "TaskImpl is not null");
        this.f404276c = r100;
        this.f404274a = r101;
        this.f404275b = r102;
    }
}
