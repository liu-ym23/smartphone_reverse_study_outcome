package com.facebook.common.executors;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class ScheduledFutureImpl<V> implements RunnableFuture<V>, ScheduledFuture<V> {
    private final Handler mHandler;
    private final FutureTask<V> mListenableFuture;

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return this.mListenableFuture.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mListenableFuture.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mListenableFuture.isDone();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.mListenableFuture.run();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r100) {
        return this.mListenableFuture.cancel(r100);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Delayed r100) {
        return compareTo2(r100);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit r100) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Delayed r100) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFutureImpl(Handler r100, Callable<V> r101) {
        this.mHandler = r100;
        this.mListenableFuture = new FutureTask(r101);
    }

    @Override // java.util.concurrent.Future
    public V get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mListenableFuture.get(r100, r101);
    }

    public ScheduledFutureImpl(Handler r100, Runnable r101, @Nullable V r102) {
        this.mHandler = r100;
        this.mListenableFuture = new FutureTask(r101, r102);
    }
}
