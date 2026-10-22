package com.huawei.hmf.tasks;

/* JADX INFO: loaded from: classes23.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    Task<TContinuationResult> then(TResult r100) throws Exception;
}
