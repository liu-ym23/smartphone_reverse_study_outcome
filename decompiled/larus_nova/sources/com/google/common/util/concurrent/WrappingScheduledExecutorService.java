package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class WrappingScheduledExecutorService extends WrappingExecutorService implements ScheduledExecutorService {
    final ScheduledExecutorService delegate;

    public WrappingScheduledExecutorService(ScheduledExecutorService r100) {
        super(r100);
        this.delegate = r100;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> schedule(Runnable r100, long r101, TimeUnit r102) {
        return this.delegate.schedule(wrapTask(r100), r101, r102);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final <V> ScheduledFuture<V> schedule(Callable<V> r100, long r101, TimeUnit r102) {
        return this.delegate.schedule(wrapTask(r100), r101, r102);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable r100, long r101, long r110, TimeUnit r111) {
        return this.delegate.scheduleAtFixedRate(wrapTask(r100), r101, r110, r111);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable r100, long r101, long r110, TimeUnit r111) {
        return this.delegate.scheduleWithFixedDelay(wrapTask(r100), r101, r110, r111);
    }
}
