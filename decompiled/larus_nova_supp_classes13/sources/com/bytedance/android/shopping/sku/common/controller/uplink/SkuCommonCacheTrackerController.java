package com.bytedance.android.shopping.sku.common.controller.uplink;

import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonCacheTrackerController {
    public SkuCommonCacheTrackerController() {
    }

    public static com.bytedance.kmp.ec.yata.event.ability.tracker.b a(AndroidYaTaInstance r2, final com.bytedance.kmp.ec.yata.event.ability.tracker.a r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        Map<String, UltimateBuyCacheQueryHelper> r0 = UltimateBuyCacheHelper.b;
        final boolean r4 = UltimateBuyCacheHelper.e(r2, r3.a);
        Lazy r1 = SkuCommonLog.a;
        SkuCommonLog.a("SkuCommonCacheTrackerController", new SkuCommonCacheTrackerController$handleTracker$1(r4, r3));
        if (r4 == false) goto L7;
        int r5 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return new com.bytedance.kmp.ec.yata.event.ability.tracker.b(true, com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    L7:
        return new com.bytedance.kmp.ec.yata.event.ability.tracker.b(false, null);
    }
}
