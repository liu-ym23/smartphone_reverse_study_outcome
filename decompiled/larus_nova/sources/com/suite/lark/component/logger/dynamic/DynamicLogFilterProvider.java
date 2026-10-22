package com.suite.lark.component.logger.dynamic;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes40.dex */
public final class DynamicLogFilterProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f460158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f460159b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f460160c = null;

    static {
        f460158a = LazyKt.lazy(DynamicLogFilterProvider$tagFilter$2.INSTANCE);
        f460159b = LazyKt.lazy(DynamicLogFilterProvider$longFilter$2.INSTANCE);
        f460160c = LazyKt.lazy(DynamicLogFilterProvider$rateLimitFilter$2.INSTANCE);
    }
}
