package com.oplus.ocs.base.task;

/* JADX INFO: loaded from: classes34.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> r100);
}
