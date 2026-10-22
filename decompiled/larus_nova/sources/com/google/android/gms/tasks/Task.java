package com.google.android.gms.tasks;

import android.app.Activity;
import dv7.b;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public abstract class Task<TResult> {
    public Task() {
    }

    public abstract Task<TResult> addOnFailureListener(Activity r100, OnFailureListener r101);

    public abstract Task<TResult> addOnFailureListener(OnFailureListener r100);

    public abstract Task<TResult> addOnFailureListener(Executor r100, OnFailureListener r101);

    public abstract Task<TResult> addOnSuccessListener(Activity r100, OnSuccessListener<? super TResult> r101);

    public abstract Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> r100);

    public abstract Task<TResult> addOnSuccessListener(Executor r100, OnSuccessListener<? super TResult> r101);

    public abstract Exception getException();

    public abstract TResult getResult();

    public abstract <X extends Throwable> TResult getResult(Class<X> r100) throws Throwable;

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    public Task<TResult> addOnCanceledListener(b r100) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> r100) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> r100) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> r100) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> r100) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public Task<TResult> addOnCanceledListener(Activity r100, b r101) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task<TResult> addOnCompleteListener(Activity r100, OnCompleteListener<TResult> r101) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor r100, Continuation<TResult, TContinuationResult> r101) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor r100, Continuation<TResult, Task<TContinuationResult>> r101) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor r100, SuccessContinuation<TResult, TContinuationResult> r101) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public Task<TResult> addOnCanceledListener(Executor r100, b r101) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public Task<TResult> addOnCompleteListener(Executor r100, OnCompleteListener<TResult> r101) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }
}
