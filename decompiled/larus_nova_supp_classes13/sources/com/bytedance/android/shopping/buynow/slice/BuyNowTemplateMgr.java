package com.bytedance.android.shopping.buynow.slice;

import android.content.Context;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowBizCode;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.ecom.slice.ext.template.gecko.g;
import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import com.bytedance.android.shopping.buynow.monitor.error.a;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z43.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowTemplateMgr {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(BuyNowViewModel r2, final BuyNowBizCode r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "bizCode");
        a.f(r2.getTracker(), "runtime_error", "BuyNowTemplateMgr-registerCustomManagerPoolCreator", new BuyNowTemplateMgr$registerCustomManagerPoolCreator$1(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList] */
    public static void a(Context r9, BuyNowBizCode r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "buynowBizCode");
        if (BuyNowPerformanceOpt.q() == false) goto L7;
        if (r11 == true) goto L40;
        BuyNowPerformanceOpt.r(r10);
        return;
    L40:
        return;
    L7:
        if (r10 != BuyNowBizCode.YATA_SKUBUY) goto L9;
        String r12 = "ultimate_buynow";
    L10:
        b r0 = ECSettingKeys.f();
        List r2 = null;
        if (r0.b() == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L34;
        Map r1 = r0.c();
        if (r1 == null) goto L33;
        List r13 = (List) r1.get(r12);
        if (r13 == null) goto L33;
        ArrayList r3 = new ArrayList();
        Iterator r14 = r13.iterator();
    L21:
        if (r14.hasNext() == false) goto L32;
        z43.a r4 = (z43.a) r14.next();
        int r5 = r4.b();
        Map r6 = r0.a();
        if (r6 == null) goto L30;
        List r7 = (List) r6.get(r4.a());
        if (r7 == null) goto L30;
        List r8 = r7;
        ?? r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r16 = r8.iterator();
    L28:
        if (r16.hasNext() == false) goto L31;
        j r17 = (j) r16.next();
        r15.add(new j(r17.a(), r17.c(), r17.b() * r5));
    L31:
        CollectionsKt.addAll(r3, (Iterable) r15);
    L30:
        r15 = CollectionsKt.emptyList();
        goto L31
    L32:
        r2 = CollectionsKt.toList(r3);
    L33:
        final g r18 = new g(r2, 6);
    L35:
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, r10.getValue(), "ecom_buynow_card_template", wh.a.b(r9), new BuyNowTemplateMgr$preload$1(r18));
        return;
    L34:
        r18 = new g(null, 7);
        goto L35
    L9:
        r12 = "single_normal_product";
        goto L10
    }
}
