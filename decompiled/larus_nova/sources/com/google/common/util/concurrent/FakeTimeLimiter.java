package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class FakeTimeLimiter implements TimeLimiter {
    public FakeTimeLimiter() {
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T callUninterruptiblyWithTimeout(Callable<T> r100, long r101, TimeUnit r102) throws ExecutionException {
        return (T) callWithTimeout(r100, r101, r102);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T callWithTimeout(Callable<T> r100, long r101, TimeUnit r102) throws ExecutionException {
        r100.getClass();
        r102.getClass();
        return r100.call();
    L5:
        e = move-exception;
        throw new ExecutionError(e);
    L11:
        e = move-exception;
        throw new UncheckedExecutionException(e);
    L8:
        e = move-exception;
        Platform.restoreInterruptIfIsInterruptedException(e);
        throw new ExecutionException(e);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable r100, long r101, TimeUnit r102) {
        runWithTimeout(r100, r101, r102);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable r100, long r101, TimeUnit r102) {
        r100.getClass();
        r102.getClass();
        r100.run();     // Catch: Error -> L5 RuntimeException -> L8
        return;
    L5:
        e = move-exception;
        throw new ExecutionError(e);
    L8:
        e = move-exception;
        throw new UncheckedExecutionException(e);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T r100, Class<T> r101, long r102, TimeUnit r103) {
        r100.getClass();
        r101.getClass();
        r103.getClass();
        return r100;
    }
}
