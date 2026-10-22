package com.bytedance.sync.v2.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class UtilKtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f270546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f270547b = null;

    static {
        f270546a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(UtilKtKt.class, "sync-sdk_release"), "CALLBACK_EXECUTORS", "getCALLBACK_EXECUTORS()Ljava/util/concurrent/ExecutorService;"))};
        f270547b = LazyKt.lazy(UtilKtKt$CALLBACK_EXECUTORS$2.INSTANCE);
    }
}
