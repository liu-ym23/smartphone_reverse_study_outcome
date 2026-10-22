package com.bytedance.android.shopping.orderlist.search.container;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonBallLoadingView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonHeadBarView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonMaskView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonShopSkeletonLoadingView;
import com.bytedance.android.shopping.orderlist.search.widget.linkedlist.OrderSearchResultLinkedScrollView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderSearchResultStateController extends com.bytedance.android.shopping.orderlist.common.controller.a {
    public static final /* synthetic */ int i = 0;
    public final OrderSearchResultActivity h;

    public final void f() {
        OrderCommonErrorMonitorKt.c(this.h.I1().getTracker(), "OrderListStateController-showUpScreenSuccess", new OrderSearchResultStateController$showUpScreenSuccess$1(this));
    }

    public OrderSearchResultStateController(OrderSearchResultActivity r8, OrderSearchResultLinkedScrollView r9, OrderCommonHeadBarView r10, View r11, OrderCommonShopSkeletonLoadingView r12, OrderCommonBallLoadingView r13, OrderCommonMaskView r14) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "linkedScrollView");
        Intrinsics.checkNotNullParameter(r10, "headBarView");
        Intrinsics.checkNotNullParameter(r11, "headMakeUpView");
        Intrinsics.checkNotNullParameter(r12, "shopSkeletonLoadingView");
        Intrinsics.checkNotNullParameter(r13, "ballLoadingView");
        Intrinsics.checkNotNullParameter(r14, "maskView");
        super(r9, r10, r11, r12, r13, r14);
        this.h = r8;
    }
}
