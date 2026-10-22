package com.huawei.hmf.tasks;

import android.os.Looper;
import com.huawei.hmf.tasks.a.i;
import com.huawei.hmf.tasks.a.j;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
public class Tasks {
    public static j IMPL;

    static {
        IMPL = new j();
    }

    public Tasks() {
    }

    public static Task<List<Task<?>>> allOf(Collection<? extends Task<?>> r100) {
        return j.a(r100);
    }

    public static Task<List<Task<?>>> allOf(Task<?>... r100) {
        return j.a(Arrays.asList(r100));
    }

    public static <TResult> Task<TResult> call(Callable<TResult> r100) {
        return IMPL.a(TaskExecutors.immediate(), r100);
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> r100) {
        return IMPL.a(TaskExecutors.background(), r100);
    }

    public static <TResult> Task<TResult> callInBackground(Executor r100, Callable<TResult> r101) {
        return IMPL.a(r100, r101);
    }

    public static Task<Void> join(Collection<? extends Task<?>> r100) {
        return j.b(r100);
    }

    public static Task<Void> join(Task<?>... r100) {
        return j.b(Arrays.asList(r100));
    }

    public static <TResult> Task<List<TResult>> successOf(Collection<? extends Task<TResult>> r100) {
        return j.c(r100);
    }

    public static <TResult> Task<List<TResult>> successOf(Task<?>... r100) {
        return j.c(Arrays.asList(r100));
    }

    public static <TResult> Task<TResult> fromCanceled() {
        i r100 = new i();
        r100.a();
        return r100;
    }

    public static <TResult> TResult await(Task<TResult> r100) throws ExecutionException, InterruptedException {
        j r101 = IMPL;
        r101.getClass();
        if (Looper.myLooper() == Looper.getMainLooper()) goto L10;
        if (r100.isComplete() == true) goto L11;
        j.d r102 = new j.d();
        ((i) r100).addOnSuccessListener(TaskExecutors.uiThread(), r102).addOnFailureListener(r102);
        r102.f276823a.await();
        return (TResult) r101.a(r100);
    L11:
        return (TResult) r101.a(r100);
    L10:
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public static <TResult> Task<TResult> fromException(Exception r100) {
        TaskCompletionSource r101 = new TaskCompletionSource();
        r101.setException(r100);
        return r101.getTask();
    }

    public static <TResult> Task<TResult> fromResult(TResult r100) {
        TaskCompletionSource r101 = new TaskCompletionSource();
        r101.setResult(r100);
        return r101.getTask();
    }

    public static <TResult> TResult await(Task<TResult> r100, long r101, TimeUnit r102) throws ExecutionException, InterruptedException, TimeoutException {
        j r103 = IMPL;
        r103.getClass();
        if (Looper.myLooper() == Looper.getMainLooper()) goto L14;
        if (r100.isComplete() == true) goto L10;
        j.d r104 = new j.d();
        ((i) r100).addOnSuccessListener(TaskExecutors.uiThread(), r104).addOnFailureListener(r104);
        if (r104.f276823a.await(r101, r102) == true) goto L10;
        throw new TimeoutException("Timed out waiting for Task");
    L10:
        return (TResult) r103.a(r100);
    L14:
        throw new IllegalStateException("await must not be called on the UI thread");
    }
}
