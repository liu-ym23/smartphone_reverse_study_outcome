package com.huawei.hmf.tasks;

/* JADX INFO: loaded from: classes23.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> r100) throws Exception;
}
