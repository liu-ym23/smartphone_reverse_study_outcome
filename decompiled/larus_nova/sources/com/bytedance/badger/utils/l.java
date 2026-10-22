package com.bytedance.badger.utils;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f199269b;

    public l() {
        this.f199269b = new AtomicInteger(1);
        this.f199268a = "Badger-IO";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        return new PthreadThreadV2(r100, this.f199268a + "-" + this.f199269b.getAndIncrement());
    }
}
