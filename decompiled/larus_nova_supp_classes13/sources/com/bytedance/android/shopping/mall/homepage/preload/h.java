package com.bytedance.android.shopping.mall.homepage.preload;

import android.content.Context;
import com.bytedance.android.ec.hybrid.anniex.ECLynxAnnieXCompat;
import com.bytedance.android.ec.hybrid.anniex.ECLynxAnnieXExperiment;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCardPreLoad;
import com.bytedance.android.ec.hybrid.card.service.ECLynxAnnieXService;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public static final Map<String, SoftReference<com.bytedance.android.shopping.api.mall.m>> a = null;
    public static final Object b = null;

    static {
        a = new LinkedHashMap();
        b = new Object();
    }

    public static com.bytedance.android.shopping.api.mall.m a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pageName");
        Object r0 = b;
        monitor-enter(r0);
        Map<String, SoftReference<com.bytedance.android.shopping.api.mall.m>> r1 = a;     // Catch: Throwable -> L16
        com.bytedance.android.shopping.api.mall.m r3 = null;
        if (r1.containsKey(r5) == false) goto L11;
        SoftReference r6 = (SoftReference) ((LinkedHashMap) r1).get(r5);     // Catch: Throwable -> L16
        if (r6 == null) goto L9;
        r3 = (com.bytedance.android.shopping.api.mall.m) r6.get();     // Catch: Throwable -> L16
    L9:
        monitor-exit(r0);
        return r3;
    L11:
        r1.put(r5, new SoftReference(new MallPreloadTaskManager()));     // Catch: Throwable -> L16
        SoftReference r7 = (SoftReference) ((LinkedHashMap) r1).get(r5);     // Catch: Throwable -> L16
        if (r7 == null) goto L14;
        r3 = (com.bytedance.android.shopping.api.mall.m) r7.get();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);
        return r3;
    L16:
        th = move-exception;
        throw th;
    }

    public static void b(Context r6, String r7) {
        Lazy r0 = ECLynxAnnieXService.a;
        if (ECLynxAnnieXExperiment.c().a == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L27;
        Object r2 = ECLynxAnnieXService.g;
        monitor-enter(r2);
        Iterator r3 = ECLynxAnnieXService.c().entrySet().iterator();     // Catch: Throwable -> L24
    L13:
        if (r3.hasNext() == false) goto L18;
        Map.Entry r4 = (Map.Entry) r3.next();     // Catch: Throwable -> L24
        Iterator r5 = ((Iterable) r4.getValue()).iterator();     // Catch: Throwable -> L24
    L16:
        if (r5.hasNext() == false) goto L13;
        String r8 = (String) r5.next();     // Catch: Throwable -> L24
        Lazy r9 = ECLynxAnnieXService.a;     // Catch: Throwable -> L24
        String r10 = ECLynxAnnieXService.h((String) r4.getKey(), r8);     // Catch: Throwable -> L24
        Lazy r11 = ECLynxAnnieXCompat.a;     // Catch: Throwable -> L24
        ECLynxAnnieXCompat.b(r10);     // Catch: Throwable -> L24
        ECLynxAnnieXCompat.c(r10);     // Catch: Throwable -> L24
        goto L16
    L18:
        ECLynxAnnieXService.c().clear();     // Catch: Throwable -> L24
        ((Set) ECLynxAnnieXService.e.getValue()).clear();     // Catch: Throwable -> L24
        ((LinkedHashMap) ECLynxAnnieXService.f).clear();     // Catch: Throwable -> L24
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r2);
        Lazy r13 = ECLynxAnnieXCompat.a;
        if (ECLynxAnnieXExperiment.b() == false) goto L23;
        ((ConcurrentHashMap) ECLynxAnnieXCompat.f.getValue()).clear();
    L23:
        ECLynxCardPreLoad.a();
    L29:
        if (ECLynxAnnieXService.b() == false) goto L31;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "pageName");
        ECLynxAnnieXService.a(ECLynxAnnieXService.d(r6, r7));
        return;
    L31:
        ConcurrentHashMap r14 = com.bytedance.android.ec.hybrid.card.service.b.a;
        com.bytedance.android.ec.hybrid.card.service.e r15 = com.bytedance.android.ec.hybrid.card.service.b.a(com.bytedance.android.ec.hybrid.card.service.e.class);
        if (r15 == null) goto L40;
        r15.c(r6, r7);
        return;
    L40:
        return;
    L24:
        th = move-exception;
        throw th;
    L27:
        ECLynxCardPreLoad.a();
        goto L29
    L5:
        if (ECLynxAnnieXExperiment.c().m == false) goto L7;
        r1 = true;
        goto L8
    }
}
