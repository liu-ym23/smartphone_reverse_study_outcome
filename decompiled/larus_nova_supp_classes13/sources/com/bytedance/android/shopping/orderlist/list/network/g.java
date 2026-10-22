package com.bytedance.android.shopping.orderlist.list.network;

import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.FirstScreenPoint;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.skeleton.OrderCommonSkeletonMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ OrderListRequestViewModel a;
    public final /* synthetic */ b b;

    public g(OrderListRequestViewModel r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r8 = (com.bytedance.kmp.ec.yata.common.protocol.data.e) r7;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", new OrderListRequestViewModel$doNormalRequest$4$1(r8));
        if (this.b.c == false) goto L19;
        ig3.a r1 = this.a.g;
        if (r1 == null) goto L9;
        OrderCommonFirstScreenMonitor r2 = r1.a;
        if (r2 == null) goto L9;
        r2.a(FirstScreenPoint.FETCH_END);
    L9:
        ig3.a r3 = this.a.g;
        if (r3 == null) goto L14;
        OrderCommonFirstScreenMonitor r4 = r3.a;
        if (r4 == null) goto L14;
        r4.a(FirstScreenPoint.REQUEST_END);
    L14:
        ig3.a r5 = this.a.g;
        if (r5 == null) goto L19;
        OrderCommonFirstScreenMonitor r6 = r5.a;
        if (r6 == null) goto L19;
        r6.a(FirstScreenPoint.RENDER_START);
    L19:
        ig3.a r9 = this.a.g;
        if (r9 == null) goto L24;
        OrderCommonSkeletonMonitor r10 = r9.e;
        if (r10 == null) goto L24;
        r10.d(this.b.getType());
    L24:
        OrderListRequestViewModel r11 = this.a;
        OrderListRequestViewModel.a(r11, new com.bytedance.android.shopping.orderlist.list.starter.a(r11.x, new gg3.c(r8, this.b.b, false), false));
    }
}
