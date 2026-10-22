package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes23.dex */
public class PooledExecutorsProvider {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static PooledExecutorFactory f274584zza;

    public interface PooledExecutorFactory {
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    public static synchronized PooledExecutorFactory getInstance() {
        monitor-enter(PooledExecutorsProvider.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f274584zza != null) goto L7;
        f274584zza = new a();     // Catch: Throwable -> L10
    L7:
        PooledExecutorFactory r100 = f274584zza;     // Catch: Throwable -> L10
        monitor-exit(PooledExecutorsProvider.class);
        return r100;
    }
}
