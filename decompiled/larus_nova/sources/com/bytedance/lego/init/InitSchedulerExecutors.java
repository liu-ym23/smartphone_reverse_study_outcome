package com.bytedance.lego.init;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class InitSchedulerExecutors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f254492a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f254493b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InitSchedulerExecutors f254494c = null;

    static {
        f254492a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitSchedulerExecutors.class), "threadPoolExecutor", "getThreadPoolExecutor$initscheduler_release()Ljava/util/concurrent/ThreadPoolExecutor;"))};
        f254494c = new InitSchedulerExecutors();
        f254493b = LazyKt.lazy(InitSchedulerExecutors$threadPoolExecutor$2.INSTANCE);
    }

    public InitSchedulerExecutors() {
    }
}
