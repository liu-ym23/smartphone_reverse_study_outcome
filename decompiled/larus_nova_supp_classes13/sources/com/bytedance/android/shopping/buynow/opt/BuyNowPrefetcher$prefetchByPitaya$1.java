package com.bytedance.android.shopping.buynow.opt;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tf3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class BuyNowPrefetcher$prefetchByPitaya$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ l $extraParams;
    final /* synthetic */ ql.a $targetPromotion;

    public BuyNowPrefetcher$prefetchByPitaya$1(ql.a r1, l r2) {
        this.$targetPromotion = r1;
        this.$extraParams = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m275invoke() {
        dm.a.a("BuyNowPrefetcher").a("judgeToPrefetch successCallback");
        int r0 = d.a;
        d.b(this.$targetPromotion, this.$extraParams);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m275invoke();
        return Unit.INSTANCE;
    }
}
