package com.bytedance.android.shopping.orderlist.list.widget.headrefresh;

import android.content.Context;
import android.widget.Scroller;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.container.c;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListHeadRefreshHelper implements a {
    public final Scroller a;
    public final int b;
    public final int c;
    public boolean d;
    public final OrderListFragment e;
    public final OrderListHeadRefreshLayout f;
    public final OrderCommonRefreshSloganView g;

    @Override // com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a
    public final void computeScroll() {
        if (this.a.computeScrollOffset() == false) goto L6;
        OrderListHeadRefreshLayout r0 = this.f;
        r0.scrollTo(r0.getScrollX(), this.a.getCurrY());
        this.f.invalidate();
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a
    public final void d() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListHeadHelper", OrderListHeadRefreshHelper$cancelHeadRefreshWhenFailed$1.INSTANCE);
        h(null);
    }

    @Override // com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a
    public final boolean g() {
        if (this.f.getScrollY() >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a
    public final void c() {
        if (g() == true) goto L6;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListHeadHelper", OrderListHeadRefreshHelper$handleVerticalMovingUpOrCancel$1.INSTANCE);
        return;
    L6:
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListHeadHelper", OrderListHeadRefreshHelper$handleVerticalMovingUpOrCancel$2.INSTANCE);
        if (Math.abs(this.f.getScrollY()) <= this.b) goto L9;
        boolean r2 = true;
    L10:
        c r3 = this.e.I;
        if (r3 != null) goto L13;
    L19:
        if (r2 == false) goto L28;
        c r4 = this.e.I;
        if (r4 == null) goto L28;
        if (r4.isRequesting() == true) goto L28;
        OrderCommonLog.a("OrderListHeadHelper", OrderListHeadRefreshHelper$handleVerticalMovingUpOrCancel$3.INSTANCE);
        if (this.d == false) goto L27;
        OrderCommonLog.c("OrderListHeadHelper", OrderListHeadRefreshHelper$startHeadRefresh$1.INSTANCE);
        return;
    L27:
        this.d = true;
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("执行Head动画效果", new OrderListHeadRefreshHelper$startHeadRefresh$2(this)), com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("执行Head接口请求", new OrderListHeadRefreshHelper$startHeadRefresh$3(this)), com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("刷新Yata", new OrderListHeadRefreshHelper$startHeadRefresh$4(this))}));
        return;
    L28:
        OrderCommonLog.a("OrderListHeadHelper", OrderListHeadRefreshHelper$handleVerticalMovingUpOrCancel$4.INSTANCE);
        h(null);
        return;
    L13:
        if (r3.isRequesting() != true) goto L19;
        ig3.a r5 = this.e.K;
        if (r5 == null) goto L19;
        OrderCommonBusinessMonitor r6 = r5.c;
        if (r6 == null) goto L19;
        r6.b("headRefresh");
        goto L19
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a
    public final boolean b() {
        return this.d;
    }

    @Override // com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a
    public final int a(com.bytedance.android.shopping.orderlist.common.widgets.touch.c r6) {
        Intrinsics.checkNotNullParameter(r6, "moveToMoveInfo");
        boolean r2 = false;
        int r3 = 1;
        if (r6.d <= r6.b) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        float r1 = Math.max(0.3f, (500 - Math.abs(this.f.getScrollY())) / 500.0f);
    L9:
        int r4 = (int) (r1 * Math.abs(r6.b - r6.d));
        if (r6.d <= r6.b) goto L12;
        r2 = true;
    L12:
        if (r2 == false) goto L15;
        r3 = -1;
    L15:
        return r4 * r3;
    L8:
        r1 = 0.8f;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a
    public final void e(final e r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListHeadHelper", OrderListHeadRefreshHelper$cancelHeadRefreshWhenSuccess$1.INSTANCE);
        h(new OrderListHeadRefreshHelper$cancelHeadRefreshWhenSuccess$2(this, r3));
    }

    @Override // com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a
    public final void f(int r2) {
        if (r2 >= 0) goto L10;
        OrderCommonRefreshSloganView r3 = this.g;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.d == false) goto L8;
        String r0 = "正在加载";
    L9:
        r3.a(r0);
        return;
    L8:
        r0 = "下拉刷新";
        goto L9
    L10:
        if (r2 != 0) goto L17;
        OrderCommonRefreshSloganView r4 = this.g;
        if (r4 == null) goto L18;
        r4.b("");
        return;
    L18:
        return;
    }

    public final void h(final Function0<Unit> r5) {
        m.a r0 = m.a;
        m.c(new OrderListHeadRefreshHelper$cancelHeadRefresh$1(this));
        m.a(this.f, this.c, new OrderListHeadRefreshHelper$cancelHeadRefresh$2(this, r5));
    }

    public OrderListHeadRefreshHelper(Context r2, OrderListFragment r3, OrderListHeadRefreshLayout r4, OrderCommonRefreshSloganView r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "container");
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = new Scroller(r2);
        this.b = com.bytedance.android.shopping.extensions.b.b(60);
        this.c = 300;
    }
}
