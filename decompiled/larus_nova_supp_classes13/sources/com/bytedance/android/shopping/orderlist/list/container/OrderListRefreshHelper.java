package com.bytedance.android.shopping.orderlist.list.container;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.yata.abilities.OrderCommonYataPageCallbackImpl;
import com.bytedance.android.shopping.orderlist.list.slice.elements.tab.OrderListTabLayout;
import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import com.bytedance.android.shopping.utils.t;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListRefreshHelper implements c {
    public boolean a;
    public boolean b;
    public final List<a> c;
    public final List<t> d;
    public OrderListTabLayout e;
    public final OrderListFragment f;
    public final OrderListViewModel g;
    public final AndroidYaTaInstance h;
    public final OrderListLinkedScrollView i;

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void g() {
        this.a = true;
        a();
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void a() {
        OrderCommonErrorMonitorKt.c(this.g.getTracker(), "OrderListRefreshHelper-showGULByLoadMore", new OrderListRefreshHelper$tryShowGUL$1(this));
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final OrderCommonYataPageCallbackImpl b() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRefreshHelper", OrderListRefreshHelper$getPageCallbackImpl$1.INSTANCE);
        return (OrderCommonYataPageCallbackImpl) ((com.bytedance.android.shopping.orderlist.list.yata.ability.a) this.f.n.getValue()).e.getValue();
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final boolean c() {
        AndroidYaTaInstance r0 = this.h;
        if (r0 == null) goto L5;
        final Object r1 = r0.i("has_more");
    L6:
        if (r1 != null) goto L8;
        OrderCommonErrorMonitorKt.b(this.g.getTracker(), "GLOBAL_DATA_ERROR", "OrderListRefreshHelper-needLoadMore: hasMore is null");
    L8:
        Lazy r2 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRefreshHelper", new OrderListRefreshHelper$needLoadMore$1(r1));
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void d() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRefreshHelper", OrderListRefreshHelper$forbidRefresh$1.INSTANCE);
        this.b = true;
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void e() {
        OrderCommonErrorMonitorKt.c(this.g.getTracker(), "OrderListRefreshHelper-checkQueryWhenAppear", new OrderListRefreshHelper$checkQueryWhenAppear$1(this));
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void f() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRefreshHelper", OrderListRefreshHelper$allowRefresh$1.INSTANCE);
        this.b = false;
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final boolean isRequesting() {
        return this.b;
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void h(final OrderListRequestType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        OrderCommonErrorMonitorKt.c(this.g.getTracker(), "OrderListRefreshHelper-showGULForErrorState", new OrderListRefreshHelper$showGULForErrorState$1(this, r3));
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void i(OrderListTabLayout r1) {
        this.e = r1;
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void j(com.bytedance.android.shopping.orderlist.list.widget.gul.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.c).add(r2);
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final boolean l(final OrderListRequestType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = false;
        OrderCommonErrorMonitorKt.c(this.g.getTracker(), "OrderListRefreshHelper-doRequest", new OrderListRefreshHelper$doRequestWithoutRefresh$1(this, r4, r0));
        return r0.element;
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void n(final boolean r3) {
        OrderCommonErrorMonitorKt.c(this.g.getTracker(), "OrderListRefreshHelper-sideSlipTabToRefresh", new OrderListRefreshHelper$sideSlipTabToRefresh$1(this, r3));
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void o(t r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.d).add(r2);
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void u0(final int r5) {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRefreshHelper", new OrderListRefreshHelper$clickTabToRefresh$1(r5));
        OrderListTracker.ChangeTabType r1 = OrderListTracker.ChangeTabType.CLICK;
        OrderCommonErrorMonitorKt.c(this.g.getTracker(), "OrderListRefreshHelper-changeTabInner", new OrderListRefreshHelper$changeTabInner$1(this, r5, "clickChangeTab", r1));
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void m(OrderListTracker.ChangeTabType r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "changeType");
        OrderListFragment r0 = this.f;
        int r1 = g.c[r5.ordinal()];
        if (r1 != 1) goto L5;
        OrderListRequestType r2 = OrderListRequestType.SIDE_SLIP_TAB_REQUEST;
    L10:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.q = r2;
        OrderListFragment r3 = this.f;
        String r4 = null;
        if (r6 != null) goto L13;
    L20:
        r6 = null;
    L21:
        if (r6 == null) goto L25;
        r3.getClass();
        if ((!StringsKt.isBlank(r6)) == false) goto L25;
        r4 = r6;
    L25:
        r3.y = r4;
        this.a = true;
        return;
    L13:
        if ((!StringsKt.isBlank(r6)) == true) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == false) goto L20;
    L15:
        if (r5 != OrderListTracker.ChangeTabType.CLICK) goto L17;
        r7 = true;
        goto L18
    L5:
        if (r1 != 2) goto L8;
        r2 = OrderListRequestType.CLICK_TAB_REQUEST;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.c
    public final void k(final OrderListRequestType r3, final com.bytedance.kmp.ec.yata.common.protocol.data.e r4, final Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "downLinkDataResponse");
        OrderCommonErrorMonitorKt.c(this.g.getTracker(), "OrderListRefreshHelper-doRefreshYataUI", new OrderListRefreshHelper$refreshYataUIWhenSuccess$1(this, r4, r3, r5));
    }

    public OrderListRefreshHelper(OrderListFragment r2, OrderListViewModel r3, AndroidYaTaInstance r4, OrderListLinkedScrollView r5, OrderListStickyController r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "linkedScrollView");
        Intrinsics.checkNotNullParameter(r6, "stickyController");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.a = true;
        this.c = new ArrayList();
        this.d = new ArrayList();
    }
}
