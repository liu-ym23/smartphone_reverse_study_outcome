package com.facebook.common.executors;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class HandlerExecutorServiceImpl extends AbstractExecutorService implements HandlerExecutorService {
    private final Handler mHandler;

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // com.facebook.common.executors.HandlerExecutorService
    public void quit() {
        ThreadMethodProxy.quit(this.mHandler.getLooper());
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // com.facebook.common.executors.HandlerExecutorService
    public boolean isHandlerThread() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(this.mHandler.getLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public HandlerExecutorServiceImpl(Handler r100) {
        this.mHandler = r100;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        this.mHandler.post(r100);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> ScheduledFutureImpl<T> newTaskFor(Callable<T> r100) {
        return new ScheduledFutureImpl(this.mHandler, r100);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ScheduledFuture<T> submit(Callable<T> r100) {
        if (r100 == null) goto L6;
        ScheduledFutureImpl<T> r101 = newTaskFor(r100);
        execute(r101);
        return r101;
    L6:
        throw null;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public /* bridge */ /* synthetic */ RunnableFuture newTaskFor(Callable r100) {
        return newTaskFor(r100);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public ScheduledFuture<?> submit(Runnable r100) {
        return submit(r100, null);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable r100) {
        return submit(r100);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Callable r100) {
        return submit(r100);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> ScheduledFutureImpl<T> newTaskFor(Runnable r100, T r101) {
        return new ScheduledFutureImpl(this.mHandler, r100, r101);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ScheduledFuture<T> submit(Runnable r100, @Nullable T r101) {
        if (r100 == null) goto L6;
        ScheduledFutureImpl<T> r102 = newTaskFor(r100, r101);
        execute(r102);
        return r102;
    L6:
        throw null;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public /* bridge */ /* synthetic */ RunnableFuture newTaskFor(Runnable r100, Object r101) {
        return newTaskFor(r100, r101);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable r100, @Nullable Object r101) {
        return submit(r100, r101);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable r100, long r101, TimeUnit r102) {
        ScheduledFutureImpl r103 = newTaskFor(r100, null);
        this.mHandler.postDelayed(r103, r102.toMillis(r101));
        return r103;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> r100, long r101, TimeUnit r102) {
        ScheduledFutureImpl r103 = newTaskFor(r100);
        this.mHandler.postDelayed(r103, r102.toMillis(r101));
        return r103;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable r100, long r101, long r102, TimeUnit r103) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable r100, long r101, long r102, TimeUnit r103) {
        throw new UnsupportedOperationException();
    }
}
