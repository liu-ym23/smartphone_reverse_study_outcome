package com.oplus.ocs.base.task;

/* JADX INFO: loaded from: classes34.dex */
public class TaskCompletionSource<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TaskImpl<TResult> f404255a;

    public TaskCompletionSource() {
        this.f404255a = new TaskImpl();
    }

    public Task<TResult> getTask() {
        return this.f404255a;
    }

    public void setException(Exception r100) {
        com.oplus.ocs.base.utils.d.a(r100);
        this.f404255a.setException(r100);
    }

    public void setResult(TResult r100) {
        this.f404255a.setResult(r100);
    }

    public boolean trySetException(Exception r100) {
        com.oplus.ocs.base.utils.d.a(r100);
        return this.f404255a.trySetException(r100);
    }

    public boolean trySetResult(TResult r100) {
        return this.f404255a.trySetResult(r100);
    }
}
