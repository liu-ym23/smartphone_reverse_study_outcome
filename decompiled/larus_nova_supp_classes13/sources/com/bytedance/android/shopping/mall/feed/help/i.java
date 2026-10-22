package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public static final ArrayList<String> a = null;
    public static final ArrayList<String> b = null;

    static {
        ArrayList<String> r0 = CollectionsKt.arrayListOf(new String[]{"product_detail"});
        a = r0;
        int r1 = s93.c.a;
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        Object r3 = r0;
        if (r2 == null) goto L10;
        yj.g r4 = r2.getHostAB();
        r3 = r0;
        if (r4 == null) goto L10;
        Object r5 = r4.a("fix_detail_report_error", r0);
        r3 = r0;
        if (r5 == null) goto L10;
        r3 = r5;
    L10:
        Lazy r6 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : fix_detail_report_error, Value: " + r3);
        b = (ArrayList) r3;
    }
}
