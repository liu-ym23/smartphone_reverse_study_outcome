package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface ListeningScheduledExecutorService extends ScheduledExecutorService, ListeningExecutorService {

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ListeningScheduledExecutorService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ ScheduledFuture $default$schedule(ListeningScheduledExecutorService r100, Runnable r101, long r102, TimeUnit r103) {
            return r100.schedule(r101, r102, r103);
        }

        public static /* bridge */ /* synthetic */ ScheduledFuture $default$schedule(ListeningScheduledExecutorService r100, Callable r101, long r102, TimeUnit r103) {
            return r100.schedule(r101, r102, r103);
        }

        public static /* bridge */ /* synthetic */ ScheduledFuture $default$scheduleAtFixedRate(ListeningScheduledExecutorService r100, Runnable r101, long r102, long r103, TimeUnit r104) {
            return r100.scheduleAtFixedRate(r101, r102, r103, r104);
        }

        public static /* bridge */ /* synthetic */ ScheduledFuture $default$scheduleWithFixedDelay(ListeningScheduledExecutorService r100, Runnable r101, long r102, long r103, TimeUnit r104) {
            return r100.scheduleWithFixedDelay(r101, r102, r103, r104);
        }
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture<?> schedule(Runnable r100, long r101, TimeUnit r102);

    @Override // java.util.concurrent.ScheduledExecutorService
    <V> ListenableScheduledFuture<V> schedule(Callable<V> r100, long r101, TimeUnit r102);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable r100, long r101, TimeUnit r102);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable r100, long r101, TimeUnit r102);

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable r100, long r101, long r102, TimeUnit r103);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable r100, long r101, long r102, TimeUnit r103);

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable r100, long r101, long r102, TimeUnit r103);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable r100, long r101, long r102, TimeUnit r103);
}
