package com.bytedance.android.shopping.orderlist.list.network;

import com.bytedance.android.shopping.orderlist.common.monitor.skeleton.OrderCommonSkeletonMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ OrderListRequestViewModel a;
    public final /* synthetic */ b b;

    public h(OrderListRequestViewModel r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        final Throwable r7 = (Throwable) r6;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.b("OrderListRequestViewModel", new OrderListRequestViewModel$doNormalRequest$5$1(r7));
        ig3.a r1 = this.a.g;
        if (r1 == null) goto L7;
        OrderCommonSkeletonMonitor r2 = r1.e;
        if (r2 == null) goto L7;
        r2.d(this.b.getType());
    L7:
        OrderListRequestViewModel r3 = this.a;
        String r4 = r3.x;
        com.bytedance.kmp.ec.yata.common.protocol.data.e r5 = new com.bytedance.kmp.ec.yata.common.protocol.data.e(null);
        r5.d(-1);
        r5.e("异常:" + r7.getMessage());
        Unit r8 = Unit.INSTANCE;
        OrderListRequestViewModel.a(r3, new com.bytedance.android.shopping.orderlist.list.starter.a(r4, new gg3.c(r5, this.b.b, 4), false));
    }
}
