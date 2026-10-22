package com.larus.bmhome.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes26.dex */
public final class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f315020a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f315021b = null;

    static {
        f315020a = LazyKt.lazy(new e3());
        f315021b = LazyKt.lazy(new f3());
    }

    public static long a() {
        return ((Number) f315021b.getValue()).longValue();
    }
}
