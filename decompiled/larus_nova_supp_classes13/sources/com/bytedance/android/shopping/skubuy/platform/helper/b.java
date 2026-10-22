package com.bytedance.android.shopping.skubuy.platform.helper;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.ecom.slice.ext.template.gecko.g;
import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import com.bytedance.android.shopping.abscontainer.arch.platform.slice.PlatformSliceSDK;
import com.bytedance.android.shopping.utils.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import nj.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final AtomicBoolean a = null;

    static {
        a = new AtomicBoolean(false);
    }

    public static void c() {
        if (a.compareAndSet(false, true) == false) goto L6;
        int r0 = PlatformSliceSDK.a;
        List r1 = CollectionsKt.listOf(new com.bytedance.android.ecom.arch.slice.render.cache.a[]{new wa3.a(), new wa3.b(), new wa3.c()});
        Intrinsics.checkNotNullParameter("yata_skubuy", "biz");
        Intrinsics.checkNotNullParameter(r1, "customPoolCreators");
        SliceRender.o.getClass();
        ElementTypes.c("yata_skubuy", r1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.ArrayList] */
    public static g a() {
        if (BuyNowPerformanceOpt.q() == false) goto L5;
        BuyNowPerformanceOpt.a r0 = new BuyNowPerformanceOpt.a("performance_opt_ultimate_buynow", "ultimate_buynow");
    L6:
        z43.b r1 = ECSettingKeys.f();
        Map r3 = null;
        Object r4 = null;
        if (r1.b() == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L48;
        Map r2 = r1.c();
        if (r2 == null) goto L15;
        List r5 = (List) r2.get(r0.a);
        if (r5 == null) goto L15;
    L19:
        if (r5 == null) goto L34;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L22:
        if (r7.hasNext() == false) goto L33;
        z43.a r8 = (z43.a) r7.next();
        int r9 = r8.b();
        Map r10 = r1.a();
        if (r10 == null) goto L31;
        List r11 = (List) r10.get(r8.a());
        if (r11 == null) goto L31;
        List r12 = r11;
        ?? r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L29:
        if (r14.hasNext() == false) goto L32;
        j r15 = (j) r14.next();
        r13.add(new j(r15.a(), r15.c(), r15.b() * r9));
    L32:
        CollectionsKt.addAll(r6, (Iterable) r13);
    L31:
        r13 = CollectionsKt.emptyList();
        goto L32
    L33:
        List r16 = CollectionsKt.toList(r6);
    L35:
        String r17 = ECSettingKeys.e();
        if (r17 == null) goto L54;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L39
        int r19 = t0.a;     // Catch: Throwable -> L39
        Object r20 = Result.constructor-impl(((BuyNowPerformanceOpt.b) t0.a.a.fromJson("{\"map\":" + r17 + "}", BuyNowPerformanceOpt.b.class)).a());     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r20) == true) goto L45;
        r4 = r20;
    L45:
        r3 = (Map) r4;
    L39:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
    L54:
        return new g(r16, r3, BuyNowPerformanceOpt.i());
    L34:
        r16 = null;
    L15:
        Map r22 = r1.c();
        if (r22 == null) goto L18;
        r5 = (List) r22.get(r0.b);
        goto L19
    L18:
        r5 = null;
        goto L19
    L48:
        return new g(null, 7);
    L5:
        r0 = new BuyNowPerformanceOpt.a("ultimate_buynow", "ultimate_buynow");
        goto L6
    }

    @JvmStatic
    public static final v33.c b(boolean r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        ECSettingKeys.j.getClass();
        float r2 = 1.0f;
        if (ECSettingKeys.T() != 1) goto L7;
        int r1 = o.a;
        if (ECAppInfoService.e.f() == false) goto L7;
        float r3 = 1.15f;
    L9:
        if (ECSettingKeys.T() != 1) goto L12;
        r2 = o.a();
    L12:
        if (r5 == false) goto L20;
        d r6 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r6 == null) goto L16;
        r6.getSpiltWidth();
        float r7 = 0;
    L17:
        int r4 = com.bytedance.android.shopping.buynow.utils.g.a;
        return new v33.c((int) ((com.bytedance.android.shopping.buynow.utils.g.a(ECAppInfoService.e.getCurrentActivity()).a * 375.0f) / r7), r0, r3, r2);
    L16:
        r7 = 360.0f;
        goto L17
    L20:
        if (ECSettingKeys.V() == false) goto L24;
        return new v33.c(390, r0, r3, r2);
    L24:
        return new v33.c(0, r0, r3, r2);
    L7:
        r3 = 1.0f;
        goto L9
    }
}
