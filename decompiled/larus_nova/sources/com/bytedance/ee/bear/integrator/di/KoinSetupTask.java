package com.bytedance.ee.bear.integrator.di;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes16.dex */
public final class KoinSetupTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f227079a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f227080b = null;

    static {
        f227079a = new AtomicBoolean();
        f227080b = new AtomicBoolean();
    }

    public static void a() {
        hwc.a r100 = hwc.a.f487464a;
        org.koin.core.a r101 = hwc.a.a();
        Intrinsics.checkNotNullParameter("DynamicModuleLoader", "key");
        nwc.b r102 = r101.f526123b;
        r102.getClass();
        Intrinsics.checkNotNullParameter("DynamicModuleLoader", "key");
        final String r103 = (String) ((ConcurrentHashMap) r102.f521028a).get("DynamicModuleLoader");
        tt5.a.h("KoinInit", "setupDynamicModule:" + r103);
        if (r103 != null) goto L5;
        kwc.a r104 = owc.b.a(KoinSetupTask$setupDynamicModule$dynamicModuleLoaderModule$1.INSTANCE);
    L6:
        r101.c(CollectionsKt.listOf(r104), false);
        r101.c(((ib5.a) r101.f526122a.d().c(Reflection.getOrCreateKotlinClass(ib5.a.class), null, null)).c(), false);
        return;
    L5:
        r104 = owc.b.a(new KoinSetupTask$setupDynamicModule$dynamicModuleLoaderModule$2(r103));
        goto L6
    }

    @JvmStatic
    public static final void b(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f227079a.compareAndSet(false, true) == true) goto L10;
        return;
    L10:
        tt5.a.h("KoinInit", "onSetupKoin Start");     // Catch: Throwable -> L7
        hwc.b.a(new KoinSetupTask$onSetupKoin$1(r100));     // Catch: Throwable -> L7
        tt5.a.h("KoinInit", "onSetupKoin End");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        iu5.d.b("KoinInit", th);
    }

    @JvmStatic
    public static final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f227080b.compareAndSet(false, true) == false) goto L49;
        tt5.a.h("KoinInit", "onSetupModules Start");
        hwc.a r101 = hwc.a.f487464a;     // Catch: Throwable -> L33
        org.koin.core.a r102 = hwc.a.a();     // Catch: Throwable -> L33
        r102.c(CollectionsKt.listOf(KoinCommonModuleKt.f227078a), false);     // Catch: Throwable -> L8
    L10:
        tt5.a.h("KoinInit", "load CommonModule success");     // Catch: Throwable -> L33
        Iterator<T> r103 = e.f227128a.iterator();     // Catch: Throwable -> L33
        int r104 = 0;
    L12:
        if (r103.hasNext() == false) goto L17;
        Object r105 = r103.next();     // Catch: Throwable -> L33
        int r106 = r104 + 1;     // Catch: Throwable -> L33
        if (r104 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L33
    L16:
        r102.c(CollectionsKt.listOf((kwc.a) r105), false);     // Catch: Throwable -> L33
        r104 = r106;
        goto L12
    L17:
        Iterator<T> r107 = e.f227129b.iterator();     // Catch: Throwable -> L33
        int r108 = 0;
    L19:
        if (r107.hasNext() == false) goto L24;
        Object r109 = r107.next();     // Catch: Throwable -> L33
        int r110 = r108 + 1;     // Catch: Throwable -> L33
        if (r108 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L33
    L23:
        r102.c(CollectionsKt.listOf((kwc.a) r109), false);     // Catch: Throwable -> L33
        r108 = r110;
        goto L19
    L24:
        Iterator r111 = ((ArrayList) f.f227131a).iterator();     // Catch: Throwable -> L33
        int r112 = 0;
    L26:
        if (r111.hasNext() == false) goto L31;
        Object r113 = r111.next();     // Catch: Throwable -> L33
        int r114 = r112 + 1;     // Catch: Throwable -> L33
        if (r112 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L33
    L30:
        r102.c(CollectionsKt.listOf((kwc.a) r113), false);     // Catch: Throwable -> L33
        r112 = r114;
        goto L26
    L31:
        a();     // Catch: Throwable -> L33
        return;
    L8:
        th = move-exception;
        tt5.a.e("KoinInit", "load CommonModule", th, false);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        iu5.d.b("KoinInit", th);
        return;
    }
}
