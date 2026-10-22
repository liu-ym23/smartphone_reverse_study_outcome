package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use FakeTimeLimiter")
@ElementTypesAreNonnullByDefault
public interface TimeLimiter {
    @ParametricNullness
    <T> T callUninterruptiblyWithTimeout(Callable<T> r100, long r101, TimeUnit r102) throws TimeoutException, ExecutionException;

    @ParametricNullness
    <T> T callWithTimeout(Callable<T> r100, long r101, TimeUnit r102) throws TimeoutException, InterruptedException, ExecutionException;

    <T> T newProxy(T r100, Class<T> r101, long r102, TimeUnit r103);

    void runUninterruptiblyWithTimeout(Runnable r100, long r101, TimeUnit r102) throws TimeoutException;

    void runWithTimeout(Runnable r100, long r101, TimeUnit r102) throws TimeoutException, InterruptedException;
}
