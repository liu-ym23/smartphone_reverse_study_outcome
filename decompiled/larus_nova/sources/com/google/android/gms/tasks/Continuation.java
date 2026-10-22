package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes23.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> r100) throws Exception;
}
