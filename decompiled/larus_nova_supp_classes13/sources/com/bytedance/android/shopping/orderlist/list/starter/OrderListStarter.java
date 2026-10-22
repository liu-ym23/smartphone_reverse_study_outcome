package com.bytedance.android.shopping.orderlist.list.starter;

import android.content.Context;
import android.net.Uri;
import c53.b;
import c53.d;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.opt.ab.c;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.FirstScreenPoint;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderAppletPageScene;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.container.OrderListRequestType;
import com.bytedance.android.shopping.orderlist.list.network.OrderListRequestViewModel;
import com.bytedance.android.shopping.orderlist.list.tab.OrderListFirstScreenTabResolver;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListStarter implements d {
    public static final /* synthetic */ int i = 0;
    public final String a;
    public ig3.a b;
    public OrderListRequestViewModel c;
    public OrderListParams d;
    public com.bytedance.android.shopping.orderlist.list.tab.a e;
    public int f;
    public final String g;
    public final /* synthetic */ b h;

    public static final class a {
    }

    static {
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.h.add(r2);
        return r2;
    }

    public final void doClear() {
        this.h.doClear();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.h.remove(r2);
    }

    public final void b() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListStarter", new OrderListStarter$release$1(this));
        doClear();
    }

    public OrderListStarter(String r3) {
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        this.h = new b();
        this.g = r3;
        this.a = "YATA-OrderListStarter-" + r3;
    }

    public final void a(OrderAppletPageScene r21) {
        OrderListParams r3 = this.d;
        if (r3 != null) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.orderlist.list.tab.a r1 = this.e;
        if (r1 != null) goto L9;
        r1 = new com.bytedance.android.shopping.orderlist.list.tab.a();
    L9:
        if (c.h() == false) goto L13;
        if (r1.b != 0) goto L13;
    L16:
        boolean r9 = true;
    L18:
        Lazy r2 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListStarter", OrderListStarter$loadOrderListData$1.INSTANCE);
        ig3.a r4 = this.b;
        if (r4 == null) goto L23;
        OrderCommonFirstScreenMonitor r5 = r4.a;
        if (r5 == null) goto L23;
        r5.a(FirstScreenPoint.REQUEST_START);
    L23:
        ig3.a r6 = this.b;
        if (r6 == null) goto L28;
        OrderCommonFirstScreenMonitor r7 = r6.a;
        if (r7 == null) goto L28;
        r7.a(FirstScreenPoint.QUERY_NET_START);
    L28:
        ig3.a r8 = this.b;
        if (r8 == null) goto L33;
        OrderCommonFirstScreenMonitor r10 = r8.a;
        if (r10 == null) goto L33;
        r10.a(FirstScreenPoint.FETCH_START);
    L33:
        int r12 = this.f + 1;
        this.f = r12;
        com.bytedance.android.shopping.orderlist.list.tracker.b r11 = new com.bytedance.android.shopping.orderlist.list.tracker.b(new com.bytedance.android.shopping.orderlist.list.viewmodel.a(this.g, r3, r1.c, r1.a, Integer.valueOf(r1.b), "a1.b6871.c0.d0", 67072445));
        OrderListRequestViewModel r13 = this.c;
        if (r13 == null) goto L37;
        r13.b(new com.bytedance.android.shopping.orderlist.list.network.b(OrderListRequestType.FIRST_REQUEST, r12, true, true, false, false, r21, r11, 416), r9);
        return;
    L37:
        return;
    L13:
        if (c.i() == true) goto L15;
    L17:
        r9 = false;
        goto L18
    L15:
        if (ArraysKt.contains(CollectionsKt.toIntArray(ECSettingKeys.K()), 0) == false) goto L17;
        goto L16
    }

    public final Disposable ignore(Disposable r3) {
        Intrinsics.checkNotNullParameter(r3, "disposable");
        this.h.getClass();
        Intrinsics.checkNotNullParameter(r3, "disposable");
        return r3;
    }

    public final void c(Uri r6, Context r7) {
        ig3.a r0 = this.b;
        if (r0 == null) goto L7;
        OrderCommonFirstScreenMonitor r1 = r0.a;
        if (r1 == null) goto L7;
        r1.e(MonitorScenes.EC_PERF_PAGE_START_ORDER_LIST);
    L7:
        ig3.a r2 = this.b;
        if (r2 == null) goto L12;
        OrderCommonFirstScreenMonitor r3 = r2.a;
        if (r3 == null) goto L12;
        r3.a(FirstScreenPoint.INITIAL);
    L12:
        ig3.a r4 = this.b;
        if (r4 == null) goto L17;
        OrderCommonFirstScreenMonitor r5 = r4.a;
        if (r5 == null) goto L17;
        r5.a(FirstScreenPoint.C_PAGE_INIT);
    L17:
        Map<String, ig3.a> r8 = ig3.a.h;
        String r9 = this.g;
        MonitorScenes r10 = MonitorScenes.FPS_SCENE_ORDER_LIST;
        if (r6 != null) goto L20;
        r6 = Uri.EMPTY;
    L20:
        this.b = ig3.a.C0206a.b(r9, "yata_order_list", r10, r6);
        Map<String, OrderListRequestViewModel> r11 = OrderListRequestViewModel.z;
        String r12 = this.g;
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        OrderListRequestViewModel r13 = new OrderListRequestViewModel(r12);
        OrderListRequestViewModel.z.put(r12, r13);
        this.c = r13;
        nj.d r14 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        Context r15 = null;
        if (r14 == null) goto L23;
        r14.l();
        final Boolean r16 = Boolean.FALSE;
    L24:
        if (r14 == null) goto L26;
        r14.a();
        final Boolean r17 = Boolean.FALSE;
    L27:
        Boolean r18 = Boolean.TRUE;
        if (Intrinsics.areEqual(r16, r18) == true) goto L30;
    L32:
        boolean r19 = false;
    L33:
        Lazy r20 = OrderCommonLog.a;
        OrderCommonLog.c("zhedieping", new OrderListStarter$reloadStarter$1(r16, r17));
        ig3.a r21 = this.b;
        if (r21 == null) goto L38;
        OrderCommonFirstScreenMonitor r22 = r21.a;
        if (r22 == null) goto L38;
        r22.e(MonitorScenes.EC_PERF_PAGE_START_ORDER_LIST);
    L38:
        ig3.a r23 = this.b;
        if (r23 == null) goto L43;
        OrderCommonFirstScreenMonitor r24 = r23.a;
        if (r24 == null) goto L43;
        r24.a(FirstScreenPoint.INITIAL);
    L43:
        ig3.a r25 = this.b;
        if (r25 == null) goto L48;
        OrderCommonFirstScreenMonitor r26 = r25.a;
        if (r26 == null) goto L48;
        r26.a(FirstScreenPoint.C_PAGE_INIT);
    L48:
        ig3.a r27 = this.b;
        if (r27 == null) goto L53;
        OrderCommonFirstScreenMonitor r28 = r27.a;
        if (r28 == null) goto L53;
        r28.a(FirstScreenPoint.PARSE_SCHEMA_START);
    L53:
        int r29 = OrderListFirstScreenTabResolver.a;
        if (r7 == null) goto L56;
        r15 = r7.getApplicationContext();
    L56:
        this.e = OrderListFirstScreenTabResolver.a(r15, this.d, true);
        ig3.a r30 = this.b;
        if (r30 == null) goto L61;
        OrderCommonFirstScreenMonitor r31 = r30.a;
        if (r31 == null) goto L61;
        r31.a(FirstScreenPoint.PARSE_SCHEMA_END);
    L61:
        OrderListRequestViewModel r32 = this.c;
        if (r32 == null) goto L64;
        r32.f(this.d, r19, this.e);
    L64:
        ig3.a r33 = this.b;
        if (r33 == null) goto L69;
        OrderCommonFirstScreenMonitor r34 = r33.a;
        if (r34 == null) goto L69;
        r34.a(FirstScreenPoint.CONTAINER_INIT_START);
    L69:
        ig3.a r35 = this.b;
        if (r35 == null) goto L74;
        OrderCommonFirstScreenMonitor r36 = r35.a;
        if (r36 == null) goto L74;
        r36.a(FirstScreenPoint.T_CONTAINER_INIT);
    L74:
        a(OrderAppletPageScene.GO_TO_LANDING);
        return;
    L30:
        if (Intrinsics.areEqual(r17, r18) == false) goto L32;
        r19 = true;
        goto L33
    L26:
        r17 = null;
        goto L27
    L23:
        r16 = null;
        goto L24
    }
}
