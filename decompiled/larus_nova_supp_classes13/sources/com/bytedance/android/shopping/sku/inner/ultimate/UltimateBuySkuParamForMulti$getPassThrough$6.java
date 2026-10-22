package com.bytedance.android.shopping.sku.inner.ultimate;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class UltimateBuySkuParamForMulti$getPassThrough$6 extends Lambda implements Function0<Object> {
    final /* synthetic */ i this$0;

    public UltimateBuySkuParamForMulti$getPassThrough$6(i r1) {
        this.this$0 = r1;
        super(0);
    }

    public final Object invoke() {
        i r0 = this.this$0;
        r0.getClass();
        BuyNowPerformanceOpt.l();
        return MapsKt.toMutableMap(r0.a.getEventParams());
    }
}
