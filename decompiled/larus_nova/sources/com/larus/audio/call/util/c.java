package com.larus.audio.call.util;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f289642a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f289643b = null;

    static {
        f289642a = LazyKt.lazy(new a());
        f289643b = LazyKt.lazy(new b());
    }

    public static final void a(Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        BuildersKt.launch$default((CoroutineScope) f289642a.getValue(), null, null, r100, 3, null);
    }
}
