package com.google.common.util.concurrent;

import com.google.common.collect.o0;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingExecutorService extends o0 implements ExecutorService {
    @Override // com.google.common.collect.o0
    public abstract ExecutorService delegate();

    @Override // com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return delegate().isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return delegate().isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        delegate().shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return delegate().shutdownNow();
    }

    public ForwardingExecutorService() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        delegate().execute(r100);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100) throws InterruptedException {
        return delegate().invokeAll(r100);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r100) throws InterruptedException, ExecutionException {
        return (T) delegate().invokeAny(r100);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r100) {
        return delegate().submit(r100);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r100) {
        return delegate().submit(r100);
    }

    @Override // java.util.concurrent.ExecutorService
    @CheckReturnValue
    public boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
        return delegate().awaitTermination(r100, r101);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r100, @ParametricNullness T r101) {
        return delegate().submit(r100, r101);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) throws InterruptedException {
        return delegate().invokeAll(r100, r101, r102);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r100, long r101, TimeUnit r102) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) delegate().invokeAny(r100, r101, r102);
    }
}
