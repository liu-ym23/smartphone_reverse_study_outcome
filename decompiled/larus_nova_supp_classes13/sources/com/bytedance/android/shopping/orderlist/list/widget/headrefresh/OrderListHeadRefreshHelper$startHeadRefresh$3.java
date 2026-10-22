package com.bytedance.android.shopping.orderlist.list.widget.headrefresh;

import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.container.OrderListRequestType;
import com.bytedance.android.shopping.orderlist.list.container.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/task/a;", "nextTask", "", "<anonymous parameter 1>", "", "invoke", "(Lcom/bytedance/android/shopping/orderlist/common/widgets/task/a;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class OrderListHeadRefreshHelper$startHeadRefresh$3 extends Lambda implements Function2<com.bytedance.android.shopping.orderlist.common.widgets.task.a, Object, Unit> {
    final /* synthetic */ OrderListHeadRefreshHelper this$0;

    public OrderListHeadRefreshHelper$startHeadRefresh$3(OrderListHeadRefreshHelper r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(final com.bytedance.android.shopping.orderlist.common.widgets.task.a r4, Object r5) {
        Lazy r6 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListHeadHelper", AnonymousClass1.INSTANCE);
        c r7 = this.this$0.e.I;
        if (r7 == null) goto L5;
        OrderListRequestType r1 = OrderListRequestType.HEAD_REQUEST;
        new OrderListHeadRefreshHelper$startHeadRefresh$3$hasStarted$1(this, r4);
        new OrderListHeadRefreshHelper$startHeadRefresh$3$hasStarted$2(this);
        Boolean r8 = Boolean.valueOf(r7.l(r1));
    L7:
        if ((!Intrinsics.areEqual(r8, Boolean.TRUE)) == false) goto L15;
        ig3.a r9 = this.this$0.e.K;
        if (r9 == null) goto L13;
        OrderCommonBusinessMonitor r10 = r9.c;
        if (r10 == null) goto L13;
        r10.b("headRefresh");
    L13:
        this.this$0.h(null);
        return;
    L15:
        return;
    L5:
        r8 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((com.bytedance.android.shopping.orderlist.common.widgets.task.a) r1, r2);
        return Unit.INSTANCE;
    }
}
