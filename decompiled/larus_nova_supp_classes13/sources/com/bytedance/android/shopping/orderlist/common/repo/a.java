package com.bytedance.android.shopping.orderlist.common.repo;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.n;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.shopping.orderlist.common.monitor.error.a a;

    public a(com.bytedance.android.shopping.orderlist.common.monitor.error.a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        OrderCommonErrorMonitorKt.b(this.a, "API_NET_ERROR", "OrderCommonRepository-firstQuery: " + ((Throwable) r3).getMessage());
        n.a("网络异常", false, false);
    }
}
