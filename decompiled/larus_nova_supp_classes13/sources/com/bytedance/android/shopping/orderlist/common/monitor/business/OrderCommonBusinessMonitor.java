package com.bytedance.android.shopping.orderlist.common.monitor.business;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import gg3.d;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonBusinessMonitor {
    public static final /* synthetic */ int h = 0;
    public long a;
    public long b;
    public long c;
    public String d;
    public long e;
    public final Map<String, Integer> f;
    public final WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> g;

    public static final class a {
    }

    static {
    }

    public final void e() {
        c("load_gul_success", new OrderCommonBusinessMonitor$onGULLoadSuccess$1(this));
    }

    public final void g() {
        c("load_lynx_bridge_success", new OrderCommonBusinessMonitor$onLynxBridgeLoadSuccess$1(this));
    }

    public final void l() {
        OrderCommonErrorMonitorKt.c(this.g.get(), "OrderCommonBusinessMonitor-onUpScreenFinishNotFastMode", new OrderCommonBusinessMonitor$onUpScreenFinishNotFastMode$1(this));
    }

    public OrderCommonBusinessMonitor(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "reporter");
        this.g = r2;
        this.f = new LinkedHashMap();
    }

    public final void b(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "actionArea");
        OrderCommonErrorMonitorKt.c(this.g.get(), "OrderCommonBusinessMonitor-addActionInterceptInfo", new OrderCommonBusinessMonitor$addActionInterceptInfo$1(this, r3));
    }

    public final void d(final String r2) {
        c("load_gul_fail", new OrderCommonBusinessMonitor$onGULLoadFail$1(r2));
    }

    public final void f(final String r2) {
        c("load_lynx_bridge_fail", new OrderCommonBusinessMonitor$onLynxBridgeLoadFailed$1(r2));
    }

    public final void j(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "requestType");
        OrderCommonErrorMonitorKt.c(this.g.get(), "OrderCommonBusinessMonitor-onRequestStartNotFastMode", new OrderCommonBusinessMonitor$onRequestStartNotFastMode$1(this, r3));
    }

    public final void k(final d r3) {
        Intrinsics.checkNotNullParameter(r3, "silentRequestState");
        OrderCommonErrorMonitorKt.c(this.g.get(), "OrderCommonBusinessMonitor-onSilentRequestAllEnd", new OrderCommonBusinessMonitor$onSilentRequestAllEnd$1(this, r3));
    }

    public final void n(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "bridgeName");
        this.b = System.currentTimeMillis();
        c("use_bridge_start", new OrderCommonBusinessMonitor$useBridgeStart$1(r3));
    }

    public static final void a(OrderCommonBusinessMonitor r1, Map r2) {
        if ((!r1.f.isEmpty()) == false) goto L6;
        r2.putAll(r1.f);
        ((LinkedHashMap) r1.f).clear();
        return;
    }

    public final void c(final String r3, final Function0<? extends Map<String, ? extends Object>> r4) {
        OrderCommonErrorMonitorKt.c(this.g.get(), "OrderCommonBusinessMonitor-logForBusiness", new OrderCommonBusinessMonitor$logForBusiness$1(this, r4, r3));
    }

    public final void i(final String r3, final boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "requestType");
        OrderCommonErrorMonitorKt.c(this.g.get(), "OrderCommonBusinessMonitor-onRequestEndNotFastMode", new OrderCommonBusinessMonitor$onRequestEndNotFastMode$1(this, r4, r3));
    }

    public final void m(final String r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "bridgeName");
        c("use_bridge_end", new OrderCommonBusinessMonitor$useBridgeEnd$1(this, r2, r3));
    }

    public final void h(final String r3, final boolean r4, final boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "requestType");
        OrderCommonErrorMonitorKt.c(this.g.get(), "OrderCommonBusinessMonitor-onPageFinish", new OrderCommonBusinessMonitor$onPageFinish$1(this, r3, r4, r5));
    }
}
