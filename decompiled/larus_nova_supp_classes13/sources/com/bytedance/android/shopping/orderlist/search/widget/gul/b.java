package com.bytedance.android.shopping.orderlist.search.widget.gul;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.search.container.OrderSearchResultActivity;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements k {
    public final /* synthetic */ OrderSearchResultGULComponent a;

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public b(OrderSearchResultGULComponent r1) {
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
        Object r5 = d0.a.getActivity(this.a.c);
        lg3.a r1 = null;
        if ((r5 instanceof OrderSearchResultActivity) == true) goto L5;
        r5 = null;
    L5:
        OrderSearchResultActivity r6 = (OrderSearchResultActivity) r5;
        if (r6 == null) goto L10;
        OrderSearchResultViewModel r7 = r6.I1();
        if (r7 == null) goto L10;
        r1 = r7.getTracker();
    L10:
        OrderCommonErrorMonitorKt.b(r1, "H5_GUL_ERROR", "OrderSearchResultGULComponent-createLiveComponent: onLoadFailed msg:" + r4);
        OrderCommonBusinessMonitor r8 = this.a.c();
        if (r8 == null) goto L14;
        r8.d(r4);
        return;
    }

    public final void onPageStart(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public final void s(View r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Object r6 = d0.a.getActivity(this.a.c);
        lg3.a r1 = null;
        if ((r6 instanceof OrderSearchResultActivity) == true) goto L5;
        r6 = null;
    L5:
        OrderSearchResultActivity r7 = (OrderSearchResultActivity) r6;
        if (r7 == null) goto L10;
        OrderSearchResultViewModel r8 = r7.I1();
        if (r8 == null) goto L10;
        r1 = r8.getTracker();
    L10:
        OrderCommonErrorMonitorKt.b(r1, "H5_GUL_ERROR", "OrderSearchResultGULComponent-createLiveComponent: receiveError msg:" + r5 + "  url:" + r4);
    }
}
