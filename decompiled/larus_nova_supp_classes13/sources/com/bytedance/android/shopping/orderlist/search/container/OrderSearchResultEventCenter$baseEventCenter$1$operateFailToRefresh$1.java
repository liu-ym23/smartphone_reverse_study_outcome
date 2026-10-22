package com.bytedance.android.shopping.orderlist.search.container;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "it", "", "invoke", "(Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class OrderSearchResultEventCenter$baseEventCenter$1$operateFailToRefresh$1 extends Lambda implements Function1<com.bytedance.kmp.ec.yata.common.protocol.data.e, Unit> {
    final /* synthetic */ OrderSearchRequestType $requestType;
    final /* synthetic */ OrderSearchResultEventCenter$baseEventCenter$1 this$0;

    public OrderSearchResultEventCenter$baseEventCenter$1$operateFailToRefresh$1(OrderSearchResultEventCenter$baseEventCenter$1 r1, OrderSearchRequestType r2) {
        this.this$0 = r1;
        this.$requestType = r2;
        super(1);
    }

    public final void invoke(com.bytedance.kmp.ec.yata.common.protocol.data.e r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        this.this$0.a.c.G1().h(this.$requestType, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.kmp.ec.yata.common.protocol.data.e) r1);
        return Unit.INSTANCE;
    }
}
