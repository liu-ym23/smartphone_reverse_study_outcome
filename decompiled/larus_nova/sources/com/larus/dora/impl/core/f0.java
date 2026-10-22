package com.larus.dora.impl.core;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f332195a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f332196b = null;

    static {
        f332195a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f332196b = LazyKt.lazy(new d0());
    }
}
