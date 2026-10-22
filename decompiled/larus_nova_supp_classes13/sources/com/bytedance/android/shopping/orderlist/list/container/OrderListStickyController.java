package com.bytedance.android.shopping.orderlist.list.container;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.SlcRootView;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListStickyController {
    public final i a;
    public boolean b;
    public boolean c;
    public Float d;
    public final OrderListFragment e;
    public final AndroidYaTaInstance f;
    public final LinearLayout g;
    public final OrderListLinkedScrollView h;

    public final void b() {
        OrderCommonErrorMonitorKt.c(this.e.Y90().getTracker(), "OrderListStickyController-reset", new OrderListStickyController$initOrReset$1(this));
    }

    public final void c(final String r10) {
        AndroidYaTaInstance r0 = this.f;
        final String r1 = null;
        if (r0 == null) goto L9;
        List r2 = r0.p("newer_coupon_sticky");
        if (r2 == null) goto L9;
        com.bytedance.kmp.ec.yata.store.node.c r3 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L9;
        final String r5 = r3.getKey();
    L10:
        AndroidYaTaInstance r4 = this.f;
        if (r4 == null) goto L17;
        List r6 = r4.p("newer_coupon");
        if (r6 == null) goto L17;
        com.bytedance.kmp.ec.yata.store.node.c r7 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L17;
        r1 = r7.getKey();
    L17:
        Lazy r8 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStickyController", new OrderListStickyController$postEvent$1(r1, r5));
        AndroidYaTaInstance r9 = this.f;
        if (r9 == null) goto L22;
        YataEventCenter r11 = r9.k();
        if (r11 == null) goto L22;
        r11.d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.f, null, r5, r10, null, "OrderListStickyController_postEvent"));
    L22:
        m.a r12 = m.a;
        m.a(this.e, 100, new OrderListStickyController$postEvent$2(this, r1, r10));
        return;
    L9:
        r5 = null;
        goto L10
    }

    public static final void a(OrderListStickyController r7, com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.b r8) {
        if (r7.e.Y90().getStaticState().f == false) goto L75;
        i r0 = r7.a;
        Iterator r1 = com.bytedance.commerce.base.view.b.a(r0.b.getYataRecyclerView()).iterator();
    L6:
        final Float r4 = null;
        if (r1.hasNext() == false) goto L32;
        SlcRootView r2 = (View) r1.next();
        if ((r2 instanceof SlcRootView) == true) goto L11;
        SlcRootView r5 = null;
    L12:
        SlcRootView r6 = r5;
        if (r6 == null) goto L29;
        View r9 = (View) CollectionsKt.firstOrNull(com.bytedance.commerce.base.view.b.a(r6));
        if (r9 == null) goto L22;
        BaseSlcViewManager r10 = SlcViewExtensionsKt.g(r9);
        if (r10 == null) goto L22;
        Map r11 = r10.l();
        if (r11 == null) goto L22;
        Object r12 = r11.get("data");
    L24:
        if ((r12 instanceof HashMap) == true) goto L26;
        r12 = null;
    L26:
        HashMap r13 = (HashMap) r12;
        if (r13 == null) goto L29;
        boolean r14 = r13.containsKey("is_newer_coupon_sticky");
    L30:
        if (r14 == false) goto L6;
        new WeakReference(r2);
    L34:
        if (r2 != null) goto L36;
        Integer r3 = null;
    L37:
        if (r3 == null) goto L45;
        i r15 = r7.a;
        r15.c.getLocationOnScreen(r15.a);
        if (r3.intValue() > r15.a[1]) goto L44;
        r7.g.setVisibility(0);
        if (r7.c == true) goto L45;
        r7.c = true;
        r7.c("scrolledTopToTrigger");
        goto L45
    L44:
        r7.g.setVisibility(8);
    L45:
        float r16 = Math.abs(r8.b);
        Float r17 = r7.d;
        if (r17 != null) goto L61;
        AndroidYaTaInstance r18 = r7.f;
        if (r18 == null) goto L50;
        Object r19 = r18.i("newer_coupon_page_count");
    L52:
        if ((r19 instanceof Number) == true) goto L54;
        r19 = null;
    L54:
        Number r20 = (Number) r19;
        if (r20 == null) goto L57;
        r4 = Float.valueOf(r20.floatValue());
    L57:
        Lazy r21 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListStickyController", new OrderListStickyController$getNewerCouponPageCount$1(r4));
        r7.d = r4;
        if (r4 == null) goto L60;
        float r22 = r4.floatValue();
    L63:
        if (r16 >= (r22 * r7.h.getHeight())) goto L65;
        return;
    L65:
        if (r7.b == true) goto L76;
        r7.b = true;
        r7.c("scrolledPagesToTrigger");
        return;
    L76:
        return;
    L60:
        r22 = 3.0f;
        goto L63
    L50:
        r19 = null;
        goto L52
    L61:
        r22 = r17.floatValue();
        goto L63
    L36:
        r2.getLocationOnScreen(r0.a);
        r3 = Integer.valueOf(r0.a[1]);
    L22:
        r12 = null;
    L29:
        r14 = false;
        goto L30
    L11:
        r5 = r2;
        goto L12
    L32:
        r2 = null;
        goto L34
    }

    public OrderListStickyController(OrderListFragment r2, AndroidYaTaInstance r3, LinearLayout r4, OrderListLinkedScrollView r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "stickyContainer");
        Intrinsics.checkNotNullParameter(r5, "linkedScrollView");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = new i(this.h, this.g);
    }
}
