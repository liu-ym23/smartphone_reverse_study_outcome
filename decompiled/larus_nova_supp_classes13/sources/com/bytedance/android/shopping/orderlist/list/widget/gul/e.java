package com.bytedance.android.shopping.orderlist.list.widget.gul;

import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements com.bytedance.android.shopping.orderlist.list.container.a {
    public final /* synthetic */ OrderListGULView a;

    public e(OrderListGULView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.a
    public final void a(OrderListTracker.ChangeTabType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        if (OrderListGULView.i(this.a) != 1) goto L8;
        long r1 = OrderListGULView.j(this.a);
        com.bytedance.android.shopping.api.mall.feed.d r5 = OrderListGULView.l(this.a);
        if (r5 == null) goto L8;
        r5.e(Long.valueOf(r1));
    L8:
        if (OrderListGULView.m(this.a) != 1) goto L13;
        com.bytedance.android.shopping.api.mall.feed.d r6 = OrderListGULView.l(this.a);
        if (r6 == null) goto L14;
        r6.h();
        return;
    L14:
        return;
    }
}
