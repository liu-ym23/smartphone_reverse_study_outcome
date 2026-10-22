package com.bytedance.ee.bear.integrator.di;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class KoinSetupTask {
    public static final AtomicBoolean a = null;
    public static final AtomicBoolean b = null;

    static {
        a = new AtomicBoolean();
        b = new AtomicBoolean();
    }

    public static void a() {
        hwc.a r0 = hwc.a.a;
        org.koin.core.a r1 = hwc.a.a();
        Intrinsics.checkNotNullParameter("DynamicModuleLoader", "key");
        nwc.b r3 = r1.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter("DynamicModuleLoader", "key");
        final String r2 = (String) ((ConcurrentHashMap) r3.a).get("DynamicModuleLoader");
        tt5.a.h("KoinInit", "setupDynamicModule:" + r2);
        if (r2 != null) goto L5;
        kwc.a r4 = owc.b.a(KoinSetupTask$setupDynamicModule$dynamicModuleLoaderModule$1.INSTANCE);
    L6:
        r1.c(CollectionsKt.listOf(r4), false);
        r1.c(((ib5.a) r1.a.d().c(Reflection.getOrCreateKotlinClass(ib5.a.class), null, null)).c(), false);
        return;
    L5:
        r4 = owc.b.a(new KoinSetupTask$setupDynamicModule$dynamicModuleLoaderModule$2(r2));
        goto L6
    }

    @JvmStatic
    public static final void b(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (a.compareAndSet(false, true) == true) goto L10;
        return;
    L10:
        tt5.a.h("KoinInit", "onSetupKoin Start");     // Catch: Throwable -> L7
        hwc.b.a(new KoinSetupTask$onSetupKoin$1(r3));     // Catch: Throwable -> L7
        tt5.a.h("KoinInit", "onSetupKoin End");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        iu5.d.b("KoinInit", th);
    }

    @JvmStatic
    public static final void c(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (b.compareAndSet(false, true) == false) goto L49;
        tt5.a.h("KoinInit", "onSetupModules Start");
        hwc.a r7 = hwc.a.a;     // Catch: Throwable -> L33
        org.koin.core.a r8 = hwc.a.a();     // Catch: Throwable -> L33
        r8.c(CollectionsKt.listOf(KoinCommonModuleKt.a), false);     // Catch: Throwable -> L8
    L10:
        tt5.a.h("KoinInit", "load CommonModule success");     // Catch: Throwable -> L33
        Iterator<T> r2 = e.a.iterator();     // Catch: Throwable -> L33
        int r3 = 0;
    L12:
        if (r2.hasNext() == false) goto L17;
        Object r4 = r2.next();     // Catch: Throwable -> L33
        int r5 = r3 + 1;     // Catch: Throwable -> L33
        if (r3 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L33
    L16:
        r8.c(CollectionsKt.listOf((kwc.a) r4), false);     // Catch: Throwable -> L33
        r3 = r5;
        goto L12
    L17:
        Iterator<T> r9 = e.b.iterator();     // Catch: Throwable -> L33
        int r10 = 0;
    L19:
        if (r9.hasNext() == false) goto L24;
        Object r11 = r9.next();     // Catch: Throwable -> L33
        int r12 = r10 + 1;     // Catch: Throwable -> L33
        if (r10 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L33
    L23:
        r8.c(CollectionsKt.listOf((kwc.a) r11), false);     // Catch: Throwable -> L33
        r10 = r12;
        goto L19
    L24:
        Iterator r13 = ((ArrayList) f.a).iterator();     // Catch: Throwable -> L33
        int r14 = 0;
    L26:
        if (r13.hasNext() == false) goto L31;
        Object r16 = r13.next();     // Catch: Throwable -> L33
        int r17 = r14 + 1;     // Catch: Throwable -> L33
        if (r14 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L33
    L30:
        r8.c(CollectionsKt.listOf((kwc.a) r16), false);     // Catch: Throwable -> L33
        r14 = r17;
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
