package org.koin.java;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import mwc.c;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f526158a = 0;

    static {
    }

    @JvmStatic
    public static final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) c(r100, null, null, 6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Lazy d(final Class r100) {
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.SYNCHRONIZED;
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "mode");
        final mwc.a r102 = null;
        final Object[] r103 = 0 == true ? 1 : 0;
        return LazyKt.lazy(r101, new KoinJavaComponent$inject$1(r100, r102, r103));
    }

    @JvmStatic
    public static final <T> T b(Class<T> r100, mwc.a r101, Function0<? extends lwc.a> r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        KClass<T> r103 = JvmClassMappingKt.getKotlinClass(r100);
        org.koin.core.a r104 = hwc.a.a();
        Intrinsics.checkNotNullParameter(r103, "clazz");
        T r105 = (T) r104.f526122a.d().c(r103, r101, r102);
        if (r105 != null) goto L6;
        org.koin.core.a r106 = hwc.a.a();
        Intrinsics.checkNotNullParameter(r103, "clazz");
        return (T) r106.f526122a.d().c(r103, r101, r102);
    L6:
        return r105;
    }

    public static /* synthetic */ Object c(Class r100, c r101, Function0 r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = null;
    L9:
        return b(r100, r101, r102);
    }
}
