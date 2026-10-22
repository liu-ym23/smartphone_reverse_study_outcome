package com.bytedance.android.shopping.orderlist.list.network;

import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.container.OrderListRequestType;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class OrderListRequestViewModel$onOrderListQuerySuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b $config;
    final /* synthetic */ com.bytedance.android.shopping.orderlist.list.starter.a $event;
    final /* synthetic */ OrderListRequestViewModel this$0;

    public OrderListRequestViewModel$onOrderListQuerySuccess$1(OrderListRequestViewModel r1, b r2, com.bytedance.android.shopping.orderlist.list.starter.a r3) {
        this.this$0 = r1;
        this.$config = r2;
        this.$event = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2217invoke() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", new AnonymousClass1(this));
        String r1 = this.$event.a;
        OrderListViewModel r2 = this.this$0.d;
        String r3 = null;
        if (r2 == null) goto L7;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r4 = r2.getStaticState();
        if (r4 == null) goto L7;
        String r5 = r4.b;
    L9:
        if ((!Intrinsics.areEqual(r1, r5)) == false) goto L12;
        OrderCommonLog.c("OrderListRequestViewModel", new AnonymousClass2(this));
        return;
    L12:
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r6 = this.$event.b.i();
        OrderCommonLog.c("OrderListRequestViewModel", new AnonymousClass3(r6));
        OrderListRequestViewModel r7 = this.this$0;
        if (r6 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        gg3.c r9 = this.$event.b;
        Function4<? super Boolean, ? super Boolean, ? super gg3.c, ? super com.bytedance.kmp.ec.yata.common.biz.callback.a, Unit> r10 = r7.t;
        if (r10 == null) goto L22;
        Unit r11 = (Unit) r10.invoke(Boolean.FALSE, Boolean.valueOf(r8), r9, null);
    L22:
        if (k.i(Boolean.valueOf(this.$config.c)) == false) goto L35;
        ig3.a r12 = this.this$0.g;
        if (r12 == null) goto L35;
        OrderCommonFirstScreenMonitor r13 = r12.a;
        if (r13 == null) goto L35;
        MonitorScenes r14 = MonitorScenes.EC_PERF_PAGE_SHOW_ORDER_LIST;
        if (r6 == null) goto L30;
        Integer r15 = r6.a();
    L31:
        Integer r16 = Integer.valueOf(k.f(r15));
        if (r6 == null) goto L34;
        r3 = r6.b();
    L34:
        r13.d(r14, r16, r3);
        goto L35
    L30:
        r15 = null;
    L35:
        OrderCommonLog.c("OrderListRequestViewModel", AnonymousClass4.INSTANCE);
        if (r6 != null) goto L38;
    L42:
        OrderListRequestViewModel r17 = this.this$0;
        OrderListRequestType r18 = this.$config.getType();
        Function1<? super OrderListRequestType, Unit> r19 = r17.v;
        if (r19 == null) goto L48;
        Unit r20 = (Unit) r19.invoke(r18);
        return;
    L48:
        return;
    L38:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r6) != true) goto L42;
        OrderCommonLog.a("OrderListFragment", AnonymousClass5.INSTANCE);
        OrderListRequestViewModel r21 = this.this$0;
        com.bytedance.android.shopping.orderlist.list.starter.a r22 = this.$event;
        OrderListRequestType r23 = this.$config.getType();
        Function2<? super com.bytedance.android.shopping.orderlist.list.starter.a, ? super OrderListRequestType, Unit> r24 = r21.u;
        if (r24 == null) goto L46;
        Unit r25 = (Unit) r24.invoke(r22, r23);
        return;
    L46:
        return;
    L15:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r6) != true) goto L17;
        r8 = true;
    L7:
        r5 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2217invoke();
        return Unit.INSTANCE;
    }
}
