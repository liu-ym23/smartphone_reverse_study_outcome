package com.bytedance.android.shopping.orderlist.common.eventcenter.core;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonEventCenter$jsFuncSubscriber$1 implements j {
    public final /* synthetic */ OrderCommonEventCenter a;
    public final /* synthetic */ String b;

    public final void a(final JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        OrderCommonErrorMonitorKt.c(this.a.g.E0(), "OrderCommonEventCenter-" + this.b + "-onReceiveJsEvent", new OrderCommonEventCenter$jsFuncSubscriber$1$onReceiveJsEvent$1(this, r4));
    }

    public OrderCommonEventCenter$jsFuncSubscriber$1(OrderCommonEventCenter r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
