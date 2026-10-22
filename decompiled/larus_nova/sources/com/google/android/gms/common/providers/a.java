package com.google.android.gms.common.providers;

import com.google.android.gms.internal.common.k;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements PooledExecutorsProvider.PooledExecutorFactory {
    public a() {
    }

    @Override // com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory
    public final ScheduledExecutorService newSingleThreadScheduledExecutor() {
        int r100 = k.f274649a;
        return Executors.unconfigurableScheduledExecutorService(PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("providers/zza")));
    }
}
