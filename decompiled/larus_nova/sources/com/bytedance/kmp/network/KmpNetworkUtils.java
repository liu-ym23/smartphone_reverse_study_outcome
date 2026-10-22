package com.bytedance.kmp.network;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes19.dex */
public final class KmpNetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f252474a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f252475b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f252476c = null;

    static {
        f252474a = LazyKt.lazy(KmpNetworkUtils$nqeListenerManager$2.INSTANCE);
        pd6.b r100 = pd6.c.f528682a;
        pd6.a r101 = pd6.c.a(Reflection.getOrCreateKotlinClass(c.class));
        Intrinsics.checkNotNull(r101);
        f252475b = (c) r101;
        f252476c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        buc.b.a(false);
    }
}
