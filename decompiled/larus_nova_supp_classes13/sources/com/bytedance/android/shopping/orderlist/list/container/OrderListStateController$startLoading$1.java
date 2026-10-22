package com.bytedance.android.shopping.orderlist.list.container;

import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.state.ShowBarType;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class OrderListStateController$startLoading$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $skeletonAnchorSliceKey;
    final /* synthetic */ SlcRenderContext $slcRenderContext;
    final /* synthetic */ OrderListRequestType $type;
    final /* synthetic */ OrderListStateController this$0;

    public OrderListStateController$startLoading$1(OrderListStateController r1, OrderListRequestType r2, String r3, SlcRenderContext r4) {
        this.this$0 = r1;
        this.$type = r2;
        this.$skeletonAnchorSliceKey = r3;
        this.$slcRenderContext = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2189invoke() {
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStateController", new AnonymousClass1(this));
        OrderListStateController r2 = this.this$0;
        OrderListRequestType r3 = this.$type;
        int r4 = OrderListStateController.m;
        r2.getClass();
        switch(h.a[r3.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        com.bytedance.android.shopping.orderlist.common.controller.c r5 = new com.bytedance.android.shopping.orderlist.common.controller.c(false, false, false, null, false);
    L13:
        this.this$0.d(r5, this.$slcRenderContext, this.$skeletonAnchorSliceKey);
        return;
    L7:
        r5 = new com.bytedance.android.shopping.orderlist.common.controller.c(true, false, false, null, false);
        goto L13
    L8:
        r5 = new com.bytedance.android.shopping.orderlist.common.controller.c(true, true, true, ShowBarType.ONLY_BACK, false);
        goto L13
    L9:
        r5 = new com.bytedance.android.shopping.orderlist.common.controller.c(true, false, false, null, false);
        goto L13
    L10:
        r5 = new com.bytedance.android.shopping.orderlist.common.controller.c(true, false, false, null, true);
        goto L13
    L11:
        r5 = new com.bytedance.android.shopping.orderlist.common.controller.c(true, false, true, ShowBarType.ALL, r2.h.Y90().getStaticState().q, r2.h.Y90().getStaticState().r, true, true);
        goto L13
    L12:
        r5 = new com.bytedance.android.shopping.orderlist.common.controller.c(true, true, false, null, false);
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2189invoke();
        return Unit.INSTANCE;
    }
}
