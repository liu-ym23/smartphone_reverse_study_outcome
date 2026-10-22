package com.bytedance.android.shopping.sku.common.monitor.chain;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.monitor.listener.a;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.outer.business.cart.repo.SkuOuterAddToCartResponse;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import th3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataAddCartChain {
    public static void a() {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataAddCartChain", SkuYataAddCartChain$destroy$1.INSTANCE);
        Set r1 = ECProcessMonitor.a;
        ECProcessMonitor.d("ec_sku").j.invoke();
    }

    public SkuYataAddCartChain(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "baseParams");
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataAddCartChain", AnonymousClass1.INSTANCE);
        Set r1 = ECProcessMonitor.a;
        ActionRateListener.c(ECProcessMonitor.d("ec_sku"), r5, null, true, 2);
    }

    public static void b(final c r7, final Throwable r8) {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataAddCartChain", new SkuYataAddCartChain$onAddCartRequestEndForNew$1(r7, r8));
        Set r1 = ECProcessMonitor.a;
        a r2 = ECProcessMonitor.d("ec_sku");
        JSONObject r3 = new JSONObject();
        r3.put("use_new_api", true);
        if (r7 == null) goto L5;
        String r4 = r7.d;
    L6:
        r3.put("log_id", r4);
        Unit r5 = Unit.INSTANCE;
        r2.a(r3);
        if (r8 != null) goto L12;
        if (r7 == null) goto L12;
        if (r7.a != 0) goto L12;
        r2.g();
        return;
    L12:
        if (r7 == null) goto L14;
        a.k(r2, r7.a, r7.b, null, null, 12);
    L14:
        if (r8 == null) goto L18;
        a.k(r2, -5, null, null, null, 14);
        return;
    L18:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static void c(final SkuOuterAddToCartResponse r7, final Throwable r8) {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataAddCartChain", new SkuYataAddCartChain$onAddCartRequestEndForOld$1(r7, r8));
        Set r1 = ECProcessMonitor.a;
        a r2 = ECProcessMonitor.d("ec_sku");
        JSONObject r3 = new JSONObject();
        r3.put("use_new_api", false);
        if (r7 == null) goto L5;
        String r4 = r7.getLogId();
    L6:
        r3.put("log_id", r4);
        Unit r5 = Unit.INSTANCE;
        r2.a(r3);
        if (r8 != null) goto L12;
        if (r7 == null) goto L12;
        if (r7.getStatusCode() != 0) goto L12;
        r2.g();
        return;
    L12:
        if (r7 == null) goto L14;
        a.k(r2, r7.getStatusCode(), r7.getStatusMsg(), null, null, 12);
    L14:
        if (r8 == null) goto L18;
        a.k(r2, -5, null, null, null, 14);
        return;
    L18:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static void d(final boolean r2, final int r3) {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataAddCartChain", new SkuYataAddCartChain$onAddCartStart$1(r2, r3));
        Set r1 = ECProcessMonitor.a;
        ECProcessMonitor.d("ec_sku").j(r2, r3);
        ECProcessMonitor.d("ec_sku").d();
    }
}
