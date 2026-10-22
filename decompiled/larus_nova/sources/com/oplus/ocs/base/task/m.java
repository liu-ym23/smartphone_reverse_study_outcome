package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
final class m<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, b<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SuccessContinuation<TResult, TContinuationResult> f404298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f404299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TaskImpl<TContinuationResult> f404300c;

    @Override // com.oplus.ocs.base.task.OnCanceledListener
    public final void onCanceled() {
        this.f404300c.tryCancel();
    }

    @Override // com.oplus.ocs.base.task.b
    public final void a(Task<TResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100, "task is not null");
        this.f404299b.execute(new n(this, r100));
    }

    @Override // com.oplus.ocs.base.task.OnFailureListener
    public final void onFailure(Exception r100) {
        com.oplus.ocs.base.utils.d.a(r100, "param exception is not null");
        this.f404300c.setException(r100);
    }

    @Override // com.oplus.ocs.base.task.OnSuccessListener
    public final void onSuccess(TContinuationResult r100) {
        this.f404300c.setResult(r100);
    }

    public m(Executor r100, SuccessContinuation<TResult, TContinuationResult> r101, TaskImpl<TContinuationResult> r102) {
        com.oplus.ocs.base.utils.d.a(r100, "executor is not null");
        com.oplus.ocs.base.utils.d.a(r101, "successContinuation is not null");
        com.oplus.ocs.base.utils.d.a(r102, "task is not null");
        this.f404299b = r100;
        this.f404298a = r101;
        this.f404300c = r102;
    }
}
