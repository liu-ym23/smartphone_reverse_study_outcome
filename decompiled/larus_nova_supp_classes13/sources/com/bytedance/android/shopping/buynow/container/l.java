package com.bytedance.android.shopping.buynow.container;

import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements com.bytedance.kmp.ec.yata.event.ability.tracker.c {
    public final /* synthetic */ BuyNowFragment a;

    public l(BuyNowFragment r1) {
        this.a = r1;
    }

    public final com.bytedance.kmp.ec.yata.event.ability.tracker.b c(com.bytedance.kmp.ec.yata.event.ability.tracker.a r13) {
        Intrinsics.checkNotNullParameter(r13, "info");
        com.bytedance.android.shopping.sku.common.controller.a r1 = this.a.W90().getAsyncTwoStageController();
        BuyNowFragment r2 = this.a;
        AndroidYaTaInstance r3 = r2.q;
        BuyNowViewModel r4 = r2.W90();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r13, "info");
        Intrinsics.checkNotNullParameter(r4, "buyNowViewModel");
        if (r1.a == false) goto L63;
        Map<String, UltimateBuyCacheQueryHelper> r0 = UltimateBuyCacheHelper.b;
        if (UltimateBuyCacheHelper.e(r3, r13.a) == false) goto L8;
        int r5 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return new com.bytedance.kmp.ec.yata.event.ability.tracker.b(true, com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    L8:
        String r6 = r13.b;
        if (r6 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L62;
        Map r8 = r13.a.q();
        if (r8 != null) goto L19;
    L22:
        boolean r9 = true;
    L23:
        if (r9 == true) goto L62;
        Map r10 = r13.a.q();
        if (r10 == null) goto L28;
        Object r11 = r10.get("suffix_id");
    L29:
        String r12 = String.valueOf(r11);
        String r14 = r13.a.k() + '-' + r13.b + '-' + r12 + '-' + r13.c.get("level");
        if (r3 == null) goto L32;
        Map<String, ? extends Object> r15 = r3.j();
    L33:
        String r16 = r13.b;
        String r17 = "";
        if (r16 != null) goto L37;
        r16 = "";
    L37:
        if (r1.a(r15, r16) == false) goto L43;
        String r18 = r13.b;
        if (r18 == null) goto L42;
        r17 = r18;
    L42:
        Map r19 = r13.c;
        Intrinsics.checkNotNullParameter(r14, "cacheKey");
        Intrinsics.checkNotNullParameter(r17, "eventName");
        Intrinsics.checkNotNullParameter(r19, "params");
        r1.b.put(r14, TuplesKt.to(r17, r19));
        int r20 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return new com.bytedance.kmp.ec.yata.event.ability.tracker.b(true, com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    L43:
        if (r3 == null) goto L45;
        Map r21 = r3.j();
    L47:
        if (r1.a == true) goto L49;
        boolean r22 = false;
    L53:
        if (r22 == false) goto L68;
        if (r1.c.contains(r14) == false) goto L58;
        int r23 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return new com.bytedance.kmp.ec.yata.event.ability.tracker.b(true, com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, "异步收银台埋点去重拦截", null, null, 57));
    L58:
        if (r1.b.containsKey(r14) == false) goto L68;
        r1.c(r4, r14, r13.c);
        r1.c.add(r14);
        int r24 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return new com.bytedance.kmp.ec.yata.event.ability.tracker.b(true, com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    L68:
        return new com.bytedance.kmp.ec.yata.event.ability.tracker.b(false, null);
    L49:
        if (r21 == null) goto L51;
        Object r25 = r21.get("async_two_stage");
    L52:
        r22 = Intrinsics.areEqual(r25, 2);
        goto L53
    L51:
        r25 = null;
        goto L52
    L45:
        r21 = null;
        goto L47
    L32:
        r15 = null;
        goto L33
    L28:
        r11 = null;
        goto L29
    L19:
        if (r8.isEmpty() == true) goto L22;
        r9 = false;
    L62:
        return new com.bytedance.kmp.ec.yata.event.ability.tracker.b(false, null);
    L11:
        if (r6.length() == 0) goto L14;
        r7 = false;
        goto L15
    L63:
        return r4.getSkuService().c(r13);
    }
}
