package com.bytedance.android.shopping.sku.common.monitor.chain;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.monitor.listener.b;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.outer.business.buynow.c;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataBuyNowChain {
    public static void b() {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataBuyNowChain", SkuYataBuyNowChain$onBuyNowSuccess$1.INSTANCE);
        Set r1 = ECProcessMonitor.a;
        ECProcessMonitor.e("ec_sku").g();
    }

    public SkuYataBuyNowChain(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "baseParams");
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataBuyNowChain", AnonymousClass1.INSTANCE);
        Set r1 = ECProcessMonitor.a;
        ActionRateListener.c(ECProcessMonitor.e("ec_sku"), r5, null, true, 2);
    }

    public static void a(JSONObject r6, c r7) {
        Intrinsics.checkNotNullParameter(r7, "buyNowData");
        Lazy r2 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataBuyNowChain", SkuYataBuyNowChain$onBuyNowStart$1.INSTANCE);
        Set r3 = ECProcessMonitor.a;
        b r4 = ECProcessMonitor.e("ec_sku");
        JSONObject r5 = new JSONObject();
        r5.put(SimilarProductParam.ENTER_FROM, r7.b.getSourcePage());     // Catch: Exception -> L7
        if (r6 == null) goto L9;
        r5.put("product_source_page", r6.optString("product_source_page"));     // Catch: Exception -> L7
        r5.put("module_label", r6.optString("module_label"));     // Catch: Exception -> L7
    L9:
        Unit r8 = Unit.INSTANCE;
        ActionRateListener.c(r4, r5, null, false, 6);
        Set r9 = ECProcessMonitor.a;
        ECProcessMonitor.e("ec_sku").d();
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L9
    }
}
