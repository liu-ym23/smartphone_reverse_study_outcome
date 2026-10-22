package com.bytedance.android.shopping.mall.opt;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j {
    public static i a;

    public static List a() {
        if (a != null) goto L13;
        int r0 = s93.c.a;
        Object r1 = new i(null);
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L12;
        yj.g r3 = r2.getHostAB();
        if (r3 == null) goto L12;
        Object r4 = r3.a("ec_mall_search_pitaya_refresh_config", r1);
        if (r4 == null) goto L12;
        r1 = r4;
    L12:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_search_pitaya_refresh_config, Value: " + r1);
        a = (i) r1;
    L13:
        i r6 = a;
        if (r6 == null) goto L18;
        List<String> r7 = r6.b();
        if (r7 == null) goto L18;
        return r7;
    L18:
        return new ArrayList();
    }

    public static boolean b() {
        Integer r1 = null;
        if (a != null) goto L13;
        int r0 = s93.c.a;
        Object r2 = new i(null);
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L12;
        yj.g r4 = r3.getHostAB();
        if (r4 == null) goto L12;
        Object r5 = r4.a("ec_mall_search_pitaya_refresh_config", r2);
        if (r5 == null) goto L12;
        r2 = r5;
    L12:
        Lazy r6 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_search_pitaya_refresh_config, Value: " + r2);
        a = (i) r2;
    L13:
        i r7 = a;
        if (r7 == null) goto L16;
        r1 = r7.a();
    L16:
        if (r1 != null) goto L19;
    L20:
        return true;
    L19:
        if (r1.intValue() != 0) goto L20;
        return false;
    }

    static {
    }
}
