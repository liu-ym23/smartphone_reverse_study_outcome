package com.larus.business.markdown.impl.common;

import btc.b;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class PluginManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f320518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f320519b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f320520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f320521d = null;

    static {
        f320519b = LazyKt.lazy(PluginManager$_movementMethodPlugin$2.INSTANCE);
        f320521d = LazyKt.lazy(PluginManager$_movementMethodAllowInterceptPlugin$2.INSTANCE);
    }
}
