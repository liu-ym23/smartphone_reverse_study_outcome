package com.larksuite.component.universe_design.icon.compose;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes24.dex */
public final class UDIconCatalog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f285038a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f285039b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f285040c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f285041d = null;

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        f285038a = LazyKt.lazy(r100, UDIconCatalog$outlined$2.INSTANCE);
        f285039b = LazyKt.lazy(r100, UDIconCatalog$filled$2.INSTANCE);
        f285040c = LazyKt.lazy(r100, UDIconCatalog$colorful$2.INSTANCE);
        f285041d = LazyKt.lazy(r100, UDIconCatalog$all$2.INSTANCE);
    }
}
