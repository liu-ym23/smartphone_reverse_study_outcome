package com.bytedance.forest.utils;

import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class MainThreadExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f244488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Runnable> f244489b;

    public MainThreadExecutor() {
        this.f244488a = LazyKt.lazy(MainThreadExecutor$handler$2.INSTANCE);
        this.f244489b = new ConcurrentLinkedQueue();
    }
}
