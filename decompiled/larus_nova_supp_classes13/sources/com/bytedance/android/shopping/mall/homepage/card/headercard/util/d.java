package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import kotlin.Lazy;
import yj.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final boolean a = false;

    static {
        int r0 = s93.c.a;
        boolean r1 = true;
        Object r2 = 1;
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L10;
        g r4 = r3.getHostAB();
        if (r4 == null) goto L10;
        Object r5 = r4.a("ec_mall_header_card_async_report", r2);
        if (r5 == null) goto L10;
        r2 = r5;
    L10:
        Lazy r6 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_header_card_async_report, Value: " + r2);
        if (((Number) r2).intValue() == 1) goto L14;
        r1 = false;
    L14:
        a = r1;
    }
}
