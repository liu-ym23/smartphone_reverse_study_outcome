package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv3.widget.FixedRecyclerView;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ ProductDetailInfoComponent a;

    public s(ProductDetailInfoComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r8) {
        int r9 = ((Number) r8).intValue();
        ProductDetailInfoComponent r0 = this.a;
        if (r9 > 10) goto L5;
        r0.getClass();
        return;
    L5:
        if (r0.y == true) goto L24;
        r0.y = true;
        FixedRecyclerView r10 = r0.o;     // Catch: Exception -> L18
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("topRecycleView");     // Catch: Exception -> L18
    L10:
        PageFinder r11 = PageFinder.via(r10);     // Catch: Exception -> L18
        Map<String, ? extends Object> r12 = BtmSDK.INSTANCE.createReportParams("a1.b8094.c0.d0", r11);     // Catch: Exception -> L18
        vg3.w r1 = (vg3.w) r0.N1(vg3.w.class);     // Catch: Exception -> L18
        if (r1 == null) goto L25;
        ProductDetailEventService.b r2 = r1.m();     // Catch: Exception -> L18
        if (r2 == null) goto L26;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r3 = r2.d(r12);     // Catch: Exception -> L18
        if (r3 == null) goto L27;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r3, "product_detail_draw", false, null, null, 12);     // Catch: Exception -> L18
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L18:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }
}
