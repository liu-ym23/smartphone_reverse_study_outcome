package com.bytedance.android.shopping.orderlist.list.widget.gul;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements k {
    public final /* synthetic */ OrderListGULComponent a;

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public c(OrderListGULComponent r1) {
        this.a = r1;
    }

    public final void onFirstScreen(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onLoadSuccess(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onRuntimeReady(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void g(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }

    public final void onLoadFailed(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        OrderCommonErrorMonitorKt.b(this.a.e.Y90().getTracker(), "LYNX_GUL_ERROR", "OrderListGULComponent-createLiveComponent: onLoadFailed msg:" + r4);
        ig3.a r5 = this.a.e.K;
        if (r5 == null) goto L5;
        OrderCommonBusinessMonitor r6 = r5.c;
    L6:
        if (r6 == null) goto L9;
        r6.d(r4);
        return;
    L9:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onPageStart(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public final void s(View r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        OrderCommonErrorMonitorKt.b(this.a.e.Y90().getTracker(), "LYNX_GUL_ERROR", "OrderListGULComponent-createLiveComponent: receiveError msg:" + r5 + "  url:" + r4);
    }
}
