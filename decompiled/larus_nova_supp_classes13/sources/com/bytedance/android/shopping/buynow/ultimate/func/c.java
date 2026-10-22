package com.bytedance.android.shopping.buynow.ultimate.func;

import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowViewModel a;
    public final BuyNowFragment b;

    public static final class a {
    }

    static {
    }

    public c(BuyNowViewModel r2, BuyNowFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "buyNowViewModel");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.a = r2;
        this.b = r3;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        Map r0 = r7.q();
        if (r0 == null) goto L5;
        Object r1 = r0.get("next_count");
    L7:
        if ((r1 instanceof Integer) == true) goto L9;
        r1 = null;
    L9:
        Integer r2 = (Integer) r1;
        Map<String, UltimateBuyCacheQueryHelper> r3 = UltimateBuyCacheHelper.b;
        boolean r9 = UltimateBuyCacheHelper.e(this.a.getYataInstance(), r7);
        Lazy r4 = BuyNowLog.a;
        BuyNowLog.d("SelfChangeBuyNumFunction", "isClientCache:" + r9);
        if (r9 == false) goto L12;
        BuyNowLog.d("SelfChangeBuyNumFunction", "nextCount:" + r2);
        this.b.aa0(new com.bytedance.android.shopping.sku.common.data.e(null, r2, null, 5));
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, "isClientCache so not do next", null, null, 57));
        return;
    L12:
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L5:
        r1 = null;
        goto L7
    }
}
