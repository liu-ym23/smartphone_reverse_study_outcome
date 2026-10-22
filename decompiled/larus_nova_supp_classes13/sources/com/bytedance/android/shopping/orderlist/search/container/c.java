package com.bytedance.android.shopping.orderlist.search.container;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ OrderSearchResultActivity a;

    public c(OrderSearchResultActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ig3.a r3 = this.a.B;
        if (r3 == null) goto L8;
        OrderCommonBusinessMonitor r4 = r3.c;
        if (r4 == null) goto L9;
        r4.b("clickBody");
        return;
    L9:
        return;
    }
}
