package com.huawei.hmf.tasks;

import android.app.Activity;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public abstract class Task<TResult> {
    public Task() {
    }

    public Task<TResult> addOnCanceledListener(Activity r100, OnCanceledListener r101) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task<TResult> addOnCanceledListener(OnCanceledListener r100) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task<TResult> addOnCanceledListener(Executor r100, OnCanceledListener r101) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task<TResult> addOnCompleteListener(Activity r100, OnCompleteListener<TResult> r101) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> r100) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public Task<TResult> addOnCompleteListener(Executor r100, OnCompleteListener<TResult> r101) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract Task<TResult> addOnFailureListener(Activity r100, OnFailureListener r101);

    public abstract Task<TResult> addOnFailureListener(OnFailureListener r100);

    public abstract Task<TResult> addOnFailureListener(Executor r100, OnFailureListener r101);

    public abstract Task<TResult> addOnSuccessListener(Activity r100, OnSuccessListener<TResult> r101);

    public abstract Task<TResult> addOnSuccessListener(OnSuccessListener<TResult> r100);

    public abstract Task<TResult> addOnSuccessListener(Executor r100, OnSuccessListener<TResult> r101);

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> r100) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor r100, Continuation<TResult, TContinuationResult> r101) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> r100) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor r100, Continuation<TResult, Task<TContinuationResult>> r101) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract Exception getException();

    public abstract TResult getResult();

    public abstract <E extends Throwable> TResult getResultThrowException(Class<E> r100) throws Throwable;

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> r100) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor r100, SuccessContinuation<TResult, TContinuationResult> r101) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
