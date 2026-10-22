package com.bytedance.android.shopping.orderlist.search.container;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.yata.abilities.OrderCommonYataPageCallbackImpl;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import com.bytedance.android.shopping.orderlist.search.widget.linkedlist.OrderSearchResultLinkedScrollView;
import com.bytedance.android.shopping.orderlist.search.yata.ability.OrderSearchResultDefaultAbilityProvider;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderSearchResultRefreshHelper implements a {
    public boolean a;
    public final OrderSearchResultActivity b;
    public final OrderSearchResultViewModel c;
    public final AndroidYaTaInstance d;
    public final OrderSearchResultLinkedScrollView e;

    @Override // com.bytedance.android.shopping.orderlist.search.container.a
    public final void g() {
        this.a = true;
        a();
    }

    @Override // com.bytedance.android.shopping.orderlist.search.container.a
    public final void a() {
        OrderCommonErrorMonitorKt.c(this.c.getTracker(), "OrderSearchResultRefreshHelper-showGULByLoadMore", new OrderSearchResultRefreshHelper$tryShowGUL$1(this));
    }

    @Override // com.bytedance.android.shopping.orderlist.search.container.a
    public final OrderCommonYataPageCallbackImpl b() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultRefreshHelper", OrderSearchResultRefreshHelper$getPageCallbackImpl$1.INSTANCE);
        return (OrderCommonYataPageCallbackImpl) ((OrderSearchResultDefaultAbilityProvider) this.b.q.getValue()).e.getValue();
    }

    @Override // com.bytedance.android.shopping.orderlist.search.container.a
    public final boolean c() {
        AndroidYaTaInstance r0 = this.d;
        if (r0 == null) goto L5;
        final Object r1 = r0.i("has_more");
    L6:
        if (r1 != null) goto L8;
        OrderCommonErrorMonitorKt.b(this.c.getTracker(), "GLOBAL_DATA_ERROR", "OrderSearchResultRefreshHelper-needLoadMore: hasMore is null");
    L8:
        Lazy r2 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultRefreshHelper", new OrderSearchResultRefreshHelper$needLoadMore$1(r1));
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.orderlist.search.container.a
    public final void d() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultRefreshHelper", OrderSearchResultRefreshHelper$forbidRefresh$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.orderlist.search.container.a
    public final void e() {
        OrderCommonErrorMonitorKt.c(this.c.getTracker(), "OrderSearchResultRefreshHelper-checkQueryWhenAppear", new OrderSearchResultRefreshHelper$checkQueryWhenAppear$1(this));
    }

    @Override // com.bytedance.android.shopping.orderlist.search.container.a
    public final void f() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultRefreshHelper", OrderSearchResultRefreshHelper$allowRefresh$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.orderlist.search.container.a
    public final void i(final OrderSearchRequestType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        OrderCommonErrorMonitorKt.c(this.c.getTracker(), "OrderSearchResultRefreshHelper-showGULForErrorState", new OrderSearchResultRefreshHelper$showGULForErrorState$1(this, r3));
    }

    @Override // com.bytedance.android.shopping.orderlist.search.container.a
    public final void h(final OrderSearchRequestType r3, final com.bytedance.kmp.ec.yata.common.protocol.data.e r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "downLinkDataResponse");
        OrderCommonErrorMonitorKt.c(this.c.getTracker(), "OrderSearchResultRefreshHelper-doRefreshYataUI", new OrderSearchResultRefreshHelper$refreshYataUIWhenSuccess$1(this, r4, r3));
    }

    @Override // com.bytedance.android.shopping.orderlist.search.container.a
    public final void j(final OrderSearchRequestType r3, final Function1<? super com.bytedance.kmp.ec.yata.common.protocol.data.e, Unit> r4, final Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "type");
        OrderCommonErrorMonitorKt.c(this.c.getTracker(), "OrderSearchResultRefreshHelper-doRequest", new OrderSearchResultRefreshHelper$doRequestWithoutRefresh$1(this, r3, r4, r5));
    }

    public OrderSearchResultRefreshHelper(OrderSearchResultActivity r2, OrderSearchResultViewModel r3, AndroidYaTaInstance r4, OrderSearchResultLinkedScrollView r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "linkedScrollView");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = true;
    }
}
