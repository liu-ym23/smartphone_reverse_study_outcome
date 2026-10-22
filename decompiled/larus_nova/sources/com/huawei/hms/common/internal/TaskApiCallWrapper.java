package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes23.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskApiCall<? extends AnyClient, TResult> f277125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource<TResult> f277126b;

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f277125a;
    }

    public TaskCompletionSource<TResult> getTaskCompletionSource() {
        return this.f277126b;
    }

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> r100, TaskCompletionSource<TResult> r101) {
        super(1);
        this.f277125a = r100;
        this.f277126b = r101;
    }
}
