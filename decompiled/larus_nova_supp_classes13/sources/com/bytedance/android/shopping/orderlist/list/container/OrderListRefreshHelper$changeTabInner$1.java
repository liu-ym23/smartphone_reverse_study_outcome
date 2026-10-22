package com.bytedance.android.shopping.orderlist.list.container;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundLinearlayout;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.slice.elements.tab.OrderListTabLayout;
import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class OrderListRefreshHelper$changeTabInner$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OrderListTracker.ChangeTabType $changeType;
    final /* synthetic */ String $eventName;
    final /* synthetic */ int $tabId;
    final /* synthetic */ OrderListRefreshHelper this$0;

    public OrderListRefreshHelper$changeTabInner$1(OrderListRefreshHelper r1, int r2, String r3, OrderListTracker.ChangeTabType r4) {
        this.this$0 = r1;
        this.$tabId = r2;
        this.$eventName = r3;
        this.$changeType = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2152invoke() {
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRefreshHelper", new AnonymousClass1(this));
        OrderListTracker r2 = this.this$0.g.getTracker();
        OrderListTracker.ChangeTabType r3 = this.$changeType;
        OrderListTabLayout r4 = this.this$0.e;
        Unit r5 = null;
        if (r4 == null) goto L7;
        OrderListTabLayout.a r6 = r4.e(this.$tabId);
        if (r6 == null) goto L7;
        com.bytedance.android.shopping.orderlist.list.slice.elements.tab.g r7 = r6.a;
    L8:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "changeType");
        boolean r8 = true;
        Map<String, ? extends Object> r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_type", r3.getValue())});
        if (r7 == null) goto L12;
        Map<String, Object> r10 = r7.k;
        if (r10 == null) goto L12;
    L13:
        r9.putAll(r10);
        Unit r11 = Unit.INSTANCE;
        r2.b("click_order_select_button", r9);
        OrderListRefreshHelper r12 = this.this$0;
        OrderListTracker.ChangeTabType r13 = this.$changeType;
        int r14 = this.$tabId;
        String r15 = this.$eventName;
        r12.getClass();
        HashMap r16 = new HashMap();
        r16.put("tab_id", Integer.valueOf(r14));
        Integer r17 = Integer.valueOf(r12.g.getStaticState().n.indexOf(Integer.valueOf(r14)));
        if (r17.intValue() < 0) goto L16;
        boolean r18 = true;
    L17:
        if (r18 == true) goto L20;
        r17 = null;
    L20:
        if (r17 == null) goto L22;
        r16.put("index", Integer.valueOf(r17.intValue()));
    L22:
        r16.put("click_type", r13.getValue());
        r16.put("action_source", "click");
        AndroidYaTaInstance r19 = r12.h;
        if (r19 == null) goto L29;
        List r20 = r19.p("tab_bar_group");
        if (r20 == null) goto L29;
        com.bytedance.kmp.ec.yata.store.node.c r21 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.firstOrNull(r20);
        if (r21 == null) goto L29;
        String r110 = r21.getKey();
    L30:
        SlcRoundLinearlayout r22 = r12.e;
        if (r19 == null) goto L41;
        if (r110 != null) goto L34;
    L37:
        boolean r23 = true;
    L38:
        if (r23 == true) goto L41;
        r19.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r19, null, r110, r15, r16, "OrderListRefreshHelper-dispatchTabChangeEvent"));
    L49:
        if (r8 == true) goto L51;
        return;
    L51:
        Iterator r24 = ((ArrayList) this.this$0.c).iterator();
    L53:
        if (r24.hasNext() == false) goto L55;
        ((a) r24.next()).a(this.$changeType);
        goto L53
    L55:
        return;
    L34:
        if (r110.length() == 0) goto L37;
        r23 = false;
    L41:
        if (r22 == null) goto L47;
        r12.m(r13, null);
        BaseSlcViewManager r25 = SlcViewExtensionsKt.g(r22);
        if (r25 == null) goto L45;
        r25.a.d(new SlcCommonAction(r15, r16), r22, r25.l(), null, null);
        r5 = Unit.INSTANCE;
    L45:
        if (r5 != null) goto L49;
        OrderCommonErrorMonitorKt.b(r12.g.getTracker(), "SERIOUS_BUSINESS_ERROR", "OrderListRefreshHelper-dispatchTabChangeEvent: getSlcViewManager is null");
    L48:
        r8 = false;
        goto L49
    L47:
        OrderCommonErrorMonitorKt.b(r12.g.getTracker(), "SERIOUS_BUSINESS_ERROR", "OrderListRefreshHelper-dispatchTabChangeEvent: tab_bar_group node and tabLayout are null");
    L29:
        r110 = null;
        goto L30
    L16:
        r18 = false;
    L12:
        r10 = MapsKt.emptyMap();
    L7:
        r7 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2152invoke();
        return Unit.INSTANCE;
    }
}
