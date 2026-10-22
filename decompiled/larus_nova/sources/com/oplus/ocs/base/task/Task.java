package com.oplus.ocs.base.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
public abstract class Task<TResult> {
    public abstract Task<TResult> addOnCanceledListener(OnCanceledListener r100);

    public abstract Task<TResult> addOnCanceledListener(Executor r100, OnCanceledListener r101);

    public abstract Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> r100);

    public abstract Task<TResult> addOnCompleteListener(Executor r100, OnCompleteListener<TResult> r101);

    public abstract Task<TResult> addOnFailureListener(OnFailureListener r100);

    public abstract Task<TResult> addOnFailureListener(Executor r100, OnFailureListener r101);

    public abstract Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> r100);

    public abstract Task<TResult> addOnSuccessListener(Executor r100, OnSuccessListener<? super TResult> r101);

    public abstract <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> r100);

    public abstract <TContinuationResult> Task<TContinuationResult> continueWith(Executor r100, Continuation<TResult, TContinuationResult> r101);

    public abstract <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> r100);

    public abstract <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor r100, Continuation<TResult, Task<TContinuationResult>> r101);

    public abstract Exception getException();

    public abstract TResult getResult();

    public abstract <X extends Throwable> TResult getResult(Class<X> r100) throws Throwable, Throwable;

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    public abstract <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> r100);

    public abstract <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor r100, SuccessContinuation<TResult, TContinuationResult> r101);

    public Task() {
    }
}
