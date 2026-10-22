package com.bytedance.android.shopping.buynow.cache;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.sku.UltimateBuyCacheConfig;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.utils.l;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ma3.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class UltimateBuyQueryResponseCache {
    public static final UltimateBuyCacheConfig a = null;
    public static final l<a, q> b = null;

    static {
        UltimateBuyCacheConfig r0 = ECSettingKeys.M0();
        a = r0;
        b = new l(r0.getCacheCount());
    }

    public static q a(final a r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        final q r0 = (q) b.b(r3);
        if (r0 == null) goto L5;
        final boolean r1 = true;
    L6:
        Lazy r2 = BuyNowLog.a;
        BuyNowLog.b("UltimateBuyQueryResponseCache", new UltimateBuyQueryResponseCache$getCache$1(r1, r0, r3));
        if (r1 == true) goto L11;
        return null;
    L11:
        return r0;
    L5:
        r1 = false;
        goto L6
    }
}
