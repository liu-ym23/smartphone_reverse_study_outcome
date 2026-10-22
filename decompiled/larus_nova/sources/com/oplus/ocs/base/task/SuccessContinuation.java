package com.oplus.ocs.base.task;

/* JADX INFO: loaded from: classes34.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    Task<TContinuationResult> then(TResult r100);
}
