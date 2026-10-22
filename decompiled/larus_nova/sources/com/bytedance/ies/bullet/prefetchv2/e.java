package com.bytedance.ies.bullet.prefetchv2;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f247528b;

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f247527a = r100;
        this.f247528b = new AtomicInteger();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        return new PthreadThreadV2(r100, this.f247527a + '-' + this.f247528b.incrementAndGet());
    }
}
