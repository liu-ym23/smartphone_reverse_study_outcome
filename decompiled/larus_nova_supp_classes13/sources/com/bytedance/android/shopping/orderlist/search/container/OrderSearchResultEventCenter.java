package com.bytedance.android.shopping.orderlist.search.container;

import com.bytedance.android.shopping.orderlist.common.eventcenter.core.OrderCommonEventCenter;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import com.bytedance.android.shopping.orderlist.search.widget.linkedlist.OrderSearchResultLinkedScrollView;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderSearchResultEventCenter {
    public final Lazy a;
    public final OrderCommonEventCenter b;
    public final OrderSearchResultActivity c;
    public final OrderSearchResultViewModel d;
    public final AndroidYaTaInstance e;
    public final OrderSearchResultLinkedScrollView f;

    /* JADX WARN: Multi-variable type inference failed */
    public OrderSearchResultEventCenter(OrderSearchResultActivity r2, OrderSearchResultViewModel r3, AndroidYaTaInstance r4, OrderSearchResultLinkedScrollView r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "linkedScrollView");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.a = LazyKt.lazy(new OrderSearchResultEventCenter$scrollStrategyController$2(this));
        this.b = new OrderCommonEventCenter(r2, r2, r4, new OrderSearchResultEventCenter$baseEventCenter$1(this));
    }
}
