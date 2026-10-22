package com.bytedance.android.shopping.buynow.opt;

import com.bytedance.android.ec.model.order.IOrderSchema;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class BuyNowPrefetcher$prefetchOnProductDetail$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IOrderSchema $orderSchema;

    public BuyNowPrefetcher$prefetchOnProductDetail$1(IOrderSchema r1) {
        this.$orderSchema = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m276invoke() {
        dm.a.a("BuyNowPrefetcher").a("judgeToPrefetch successCallback");
        int r0 = d.a;
        d.c(this.$orderSchema);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m276invoke();
        return Unit.INSTANCE;
    }
}
