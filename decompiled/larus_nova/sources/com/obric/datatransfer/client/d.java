package com.obric.datatransfer.client;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f396681a;

    public d() {
        this.f396681a = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        return new PthreadThreadV2(r100, "transfer-file-" + this.f396681a.getAndIncrement());
    }
}
