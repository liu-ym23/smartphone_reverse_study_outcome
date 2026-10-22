package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.i;

/* JADX INFO: loaded from: classes23.dex */
public class TaskCompletionSource<TResult> {
    public final i<TResult> task;

    public TaskCompletionSource() {
        this.task = new i();
    }

    public TaskCompletionSource(CancellationToken r100) {
        this.task = new i();
        r100.register(new AnonymousClass1(this));
    }

    public static /* synthetic */ i access$000(TaskCompletionSource r100) {
        return r100.task;
    }

    public Task<TResult> getTask() {
        return this.task;
    }

    public void setException(Exception r100) {
        this.task.a(r100);
    }

    public void setResult(TResult r100) {
        this.task.a(r100);
    }
}
