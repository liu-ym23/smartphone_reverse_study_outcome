package com.bytedance.android.shopping.orderlist.common.monitor.fps;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import et3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1 implements c.d {
    public final /* synthetic */ OrderCommonFpsMonitor$fpsTracker$2 a;
    public final /* synthetic */ String b;

    public OrderCommonFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1(OrderCommonFpsMonitor$fpsTracker$2 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void fpsCallBack(final double r2) {
        OrderCommonErrorMonitorKt.c(null, "OrderCommonFpsMonitor-fpsTracker", new AnonymousClass1(this, r2));
    }
}
