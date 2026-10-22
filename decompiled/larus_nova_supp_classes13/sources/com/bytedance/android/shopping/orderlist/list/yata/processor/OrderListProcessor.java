package com.bytedance.android.shopping.orderlist.list.yata.processor;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.kmp.ec.yata.store.core.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListProcessor extends a {
    public final OrderListFragment a;
    public final OrderListViewModel b;

    public final void b(final a.a r4) {
        Intrinsics.checkNotNullParameter(r4, "modifier");
        String r0 = r4.c();
        if (r0 == null) goto L16;
        int r1 = r0.hashCode();
        if (r1 == (-1398028712)) goto L14;
        if (r1 != (-799049810)) goto L16;
        if (r0.equals("order_list_tabbar") == false) goto L16;
        OrderCommonErrorMonitorKt.c(this.b.getTracker(), "OrderListProcessor-order_list_tabbar", new OrderListProcessor$doProcessModify$1(r4));
        goto L16
    L14:
        if (r0.equals("newer_coupon") == false) goto L16;
        boolean r5 = true;
    L17:
        this.a.Y90().getStaticState().f = r5;
        return;
    L16:
        r5 = false;
        goto L17
    }

    public OrderListProcessor(OrderListFragment r2, OrderListViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }
}
