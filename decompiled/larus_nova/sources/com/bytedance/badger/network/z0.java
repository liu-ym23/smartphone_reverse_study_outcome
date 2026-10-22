package com.bytedance.badger.network;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f199163f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f199164g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f199165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f199166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f199167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f199168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f199169e;

    static {
        f199163f = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(z0.class), "executor", "getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(z0.class), "scheduler", "getScheduler()Ljava/util/concurrent/ScheduledExecutorService;"))};
        f199164g = new AtomicInteger(1);
    }

    public z0(String r100, int r101, int r102) {
        this.f199167c = r100;
        this.f199168d = r101;
        this.f199169e = r102;
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.f199165a = LazyKt.lazy(r103, new x(this));
        this.f199166b = LazyKt.lazy(r103, new y(this));
    }

    public final void a(Runnable r100) {
        Lazy r101 = this.f199165a;
        KProperty r102 = f199163f[0];
        ((ThreadPoolExecutor) r101.getValue()).execute(r100);
    }
}
