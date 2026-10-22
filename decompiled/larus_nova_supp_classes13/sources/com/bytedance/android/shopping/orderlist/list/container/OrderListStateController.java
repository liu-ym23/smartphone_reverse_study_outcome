package com.bytedance.android.shopping.orderlist.list.container;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonBallLoadingView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonHeadBarView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonMaskView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonShopSkeletonLoadingView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.ShowBarType;
import com.bytedance.android.shopping.orderlist.list.widget.headrefresh.OrderListHeadRefreshLayout;
import com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.BaseHorizontalPullLayout;
import com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.PageHorizontalPullLayout;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListStateController extends com.bytedance.android.shopping.orderlist.common.controller.a {
    public static final /* synthetic */ int m = 0;
    public final OrderListFragment h;
    public final PageHorizontalPullLayout i;
    public final OrderListHeadRefreshLayout j;
    public final View k;
    public final OrderCommonShopSkeletonLoadingView l;

    @Override // com.bytedance.android.shopping.orderlist.common.controller.a
    public final ShowBarType b() {
        return ShowBarType.ONLY_BACK;
    }

    public static Integer f(View r3, View r4) {
        int r0 = 0;
    L3:
        ViewParent r1 = null;
        if (r3 == null) goto L13;
        if ((!Intrinsics.areEqual(r3, r4)) == false) goto L13;
        r0 = r0 + r3.getTop();
        ViewParent r5 = r3.getParent();
        if ((r5 instanceof View) == false) goto L11;
        r1 = r5;
    L11:
        r3 = (View) r1;
    L13:
        if (Intrinsics.areEqual(r3, r4) == true) goto L15;
        return null;
    L15:
        return Integer.valueOf(r0);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.controller.a
    public final void a(SlcRenderContext r11, final String r12) {
        Object r0 = this.l.getParent();
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof View) == true) goto L5;
        r0 = null;
    L5:
        View r1 = (View) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        Integer r3 = f(this.k, r1);
        if (r3 == null) goto L38;
        final int r5 = r3.intValue();
        int r4 = this.k.getHeight();
        if (r4 > 0) goto L13;
        return;
    L13:
        final int r6 = r5 + r4;
        final Integer r7 = g(r11, r1, r12);
        if (r7 == null) goto L16;
        int r13 = r7.intValue();
    L17:
        int r8 = 0;
        final int r9 = RangesKt.coerceIn(r13, 0, RangesKt.coerceAtLeast(r6, 0));
        ViewGroup.LayoutParams r14 = this.l.getLayoutParams();
        if ((r14 instanceof ConstraintLayout.LayoutParams) == false) goto L21;
        r2 = r14;
    L21:
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r2;
        if (r10 != null) goto L24;
        return;
    L24:
        if (r7 != null) goto L26;
        final boolean r15 = true;
    L27:
        if (r15 == false) goto L29;
        r8 = this.k.getId();
    L29:
        if (r15 == false) goto L31;
        int r16 = r9 - r5;
    L32:
        Lazy r17 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStateController", new OrderListStateController$beforeShowShopSkeletonLoading$1(r12, r5, r6, r7, r9, r15));
        if (r10.topToTop == r8) goto L35;
    L36:
        ConstraintLayout r18 = this.l;
        r10.topToTop = r8;
        ((ViewGroup.MarginLayoutParams) r10).topMargin = r16;
        Unit r19 = Unit.INSTANCE;
        r18.setLayoutParams(r10);
        return;
    L35:
        if (((ViewGroup.MarginLayoutParams) r10).topMargin != r16) goto L36;
        return;
    L31:
        r16 = r9;
        goto L32
    L26:
        r15 = false;
        goto L27
    L16:
        r13 = r5;
        goto L17
    }

    public final void h(SlcRenderContext r8, String r9) {
        Object r0 = this.k.getParent();
        if ((r0 instanceof View) == true) goto L5;
        r0 = null;
    L5:
        View r1 = (View) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        Integer r2 = f(this.i, r1);
        if (r2 == null) goto L41;
        int r3 = r2.intValue();
        int r4 = this.i.getHeight() + r3;
        Integer r10 = g(r8, r1, r9);
        if (r10 == null) goto L13;
        int r11 = r10.intValue();
    L14:
        boolean r12 = false;
        int r13 = RangesKt.coerceIn(r11, 0, RangesKt.coerceAtLeast(r4, 0));
        PageHorizontalPullLayout r5 = this.i;
        r5.getClass();
        int r14 = RangesKt.coerceAtLeast(r13 - r3, 0);
        Iterator r6 = CollectionsKt.listOf(new Integer[]{0, 2}).iterator();
    L16:
        if (r6.hasNext() == false) goto L29;
        View r7 = com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(r5.getChildViews(), Integer.valueOf(((Number) r6.next()).intValue()));
        if (r7 == null) goto L16;
        ViewGroup.LayoutParams r15 = r7.getLayoutParams();
        if ((r15 instanceof BaseHorizontalPullLayout.LayoutParams) == true) goto L23;
        r15 = null;
    L23:
        BaseHorizontalPullLayout.LayoutParams r16 = (BaseHorizontalPullLayout.LayoutParams) r15;
        if (r16 == null) goto L16;
        if (((ViewGroup.MarginLayoutParams) r16).topMargin == r14) goto L16;
        ((ViewGroup.MarginLayoutParams) r16).topMargin = r14;
        r7.setLayoutParams(r16);
        r12 = true;
        goto L16
    L29:
        if (r12 == false) goto L42;
        r5.requestLayout();
        return;
    L42:
        return;
    L13:
        r11 = r3;
        goto L14
    }

    public final Integer g(SlcRenderContext r5, View r6, final String r7) {
        if (r7 != null) goto L5;
    L40:
        return null;
    L5:
        if ((!StringsKt.isBlank(r7)) == true) goto L8;
        r7 = null;
    L8:
        if (r7 == null) goto L40;
        AndroidYaTaInstance r1 = this.h.k;
        if (r1 == null) goto L17;
        List r2 = r1.p("tab_bar_group");
        if (r2 == null) goto L17;
        com.bytedance.kmp.ec.yata.store.node.c r3 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L17;
        final String r4 = r3.getKey();
    L19:
        if (r4 != null) goto L22;
        Lazy r8 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStateController", new OrderListStateController$resolveSkeletonTopInParent$1(r7));
        return null;
    L22:
        if (r1 == null) goto L24;
        View r9 = r1.K(r4);
    L25:
        if (r9 != null) goto L28;
        Lazy r10 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStateController", new OrderListStateController$resolveSkeletonTopInParent$2(r4, r7));
        return null;
    L28:
        if (r5 == null) goto L30;
        final View r11 = SlcRenderContext.f(r9, r7);
    L31:
        if (r11 != null) goto L34;
        Lazy r12 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStateController", new OrderListStateController$resolveSkeletonTopInParent$3(r4, r7));
        return null;
    L34:
        final Integer r13 = f(r11, r6);
        if (r13 != null) goto L38;
        Lazy r14 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStateController", new OrderListStateController$resolveSkeletonTopInParent$4(r7));
        return null;
    L38:
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStateController", new OrderListStateController$resolveSkeletonTopInParent$5(r7, r13, r11));
        return Integer.valueOf(r13.intValue() + r11.getHeight());
    L30:
        r11 = null;
        goto L31
    L24:
        r9 = null;
    L17:
        r4 = null;
        goto L19
    }

    public OrderListStateController(OrderListFragment r14, PageHorizontalPullLayout r15, OrderListHeadRefreshLayout r16, OrderListLinkedScrollView r17, View r18, OrderCommonHeadBarView r19, View r20, OrderCommonShopSkeletonLoadingView r21, OrderCommonBallLoadingView r22, OrderCommonMaskView r23) {
        Intrinsics.checkNotNullParameter(r14, "fragment");
        Intrinsics.checkNotNullParameter(r15, "pullLayout");
        Intrinsics.checkNotNullParameter(r16, "headRefreshLayout");
        Intrinsics.checkNotNullParameter(r17, "linkedScrollView");
        Intrinsics.checkNotNullParameter(r18, "bodyContainer");
        Intrinsics.checkNotNullParameter(r19, "headBarView");
        Intrinsics.checkNotNullParameter(r20, "headMakeUpView");
        Intrinsics.checkNotNullParameter(r21, "shopSkeletonLoadingView");
        Intrinsics.checkNotNullParameter(r22, "ballLoadingView");
        Intrinsics.checkNotNullParameter(r23, "maskView");
        super(r17, r19, r20, r21, r22, r23);
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r18;
        this.l = r21;
    }
}
