package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final ExecutionList executionList;

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.executionList.execute();
    }

    public ListenableFutureTask(Callable<V> r100) {
        super(r100);
        this.executionList = new ExecutionList();
    }

    public static <V> ListenableFutureTask<V> create(Callable<V> r100) {
        return new ListenableFutureTask(r100);
    }

    public ListenableFutureTask(Runnable r100, @ParametricNullness V r101) {
        super(r100, r101);
        this.executionList = new ExecutionList();
    }

    public static <V> ListenableFutureTask<V> create(Runnable r100, @ParametricNullness V r101) {
        return new ListenableFutureTask(r100, r101);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r100, Executor r101) {
        this.executionList.add(r100, r101);
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    @ParametricNullness
    public V get(long r100, TimeUnit r101) throws TimeoutException, InterruptedException, ExecutionException {
        long r102 = r101.toNanos(r100);
        if (r102 > 2147483647999999999L) goto L7;
        return (V) super.get(r100, r101);
    L7:
        return (V) super.get(Math.min(r102, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }
}
