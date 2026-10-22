package com.bytedance.ies.tools.prefetch;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class PrefetchDebugTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f248729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f248730b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f248731c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PrefetchDebugTool f248732d = null;

    static {
        f248729a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PrefetchDebugTool.class), "configMap", "getConfigMap()Ljava/util/concurrent/ConcurrentHashMap;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PrefetchDebugTool.class), "cacheMap", "getCacheMap()Ljava/util/concurrent/ConcurrentHashMap;"))};
        f248732d = new PrefetchDebugTool();
        f248730b = LazyKt.lazy(PrefetchDebugTool$configMap$2.INSTANCE);
        f248731c = LazyKt.lazy(PrefetchDebugTool$cacheMap$2.INSTANCE);
    }

    public PrefetchDebugTool() {
    }
}
