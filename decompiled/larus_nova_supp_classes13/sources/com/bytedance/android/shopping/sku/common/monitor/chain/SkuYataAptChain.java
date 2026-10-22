package com.bytedance.android.shopping.sku.common.monitor.chain;

import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.core.monitor.param.a;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.outer.business.cart.repo.SkuOuterAddToCartResponse;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ph3.b;
import th3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataAptChain {
    public final SkuParams a;

    public final void a() {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataAptChain", SkuYataAptChain$destroy$1.INSTANCE);
        Map r1 = ECParamTrackerCenter.a;
        ECParamTrackerCenter.a(this.a.getUniqueId());
    }

    public SkuYataAptChain(SkuParams r2) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        this.a = r2;
    }

    public final void d(final b r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Map r0 = ECParamTrackerCenter.a;
        a r1 = ECParamTrackerCenter.c(this.a.getUniqueId());
        if (r1 == null) goto L6;
        r1.l("aweme/v2/sku/yata/query", new SkuYataAptChain$onSkuRequestStart$1(r3));
        return;
    }

    public final void e(final com.bytedance.android.shopping.sku.inner.repo.a r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Map r0 = ECParamTrackerCenter.a;
        a r1 = ECParamTrackerCenter.c(this.a.getUniqueId());
        if (r1 == null) goto L6;
        r1.l("aweme/v2/sku/yata/query", new SkuYataAptChain$onSkuRequestSuccess$1(r3));
        return;
    }

    public final void b(final th3.a r3, final c r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "response");
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataAptChain", SkuYataAptChain$onAddCartRequestEndForNew$1.INSTANCE);
        Map r1 = ECParamTrackerCenter.a;
        a r2 = ECParamTrackerCenter.c(this.a.getUniqueId());
        if (r2 == null) goto L6;
        r2.l("/cart/cartAdd_new", new SkuYataAptChain$onAddCartRequestEndForNew$2(r3, r4));
        return;
    }

    public final void c(final th3.b r3, final SkuOuterAddToCartResponse r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "response");
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataAptChain", SkuYataAptChain$onAddCartRequestEndForOld$1.INSTANCE);
        Map r1 = ECParamTrackerCenter.a;
        a r2 = ECParamTrackerCenter.c(this.a.getUniqueId());
        if (r2 == null) goto L6;
        r2.l("/cart/cartAdd", new SkuYataAptChain$onAddCartRequestEndForOld$2(r3, r4));
        return;
    }
}
