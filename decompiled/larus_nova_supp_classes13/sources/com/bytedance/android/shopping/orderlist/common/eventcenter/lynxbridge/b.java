package com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements k {
    public final /* synthetic */ BridgetLynxComponent a;

    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    public b(BridgetLynxComponent r1) {
        this.a = r1;
    }

    public final void onFirstScreen(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void onLoadSuccess(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        BridgetLynxComponent r3 = this.a;
        r3.b = true;
        OrderCommonBusinessMonitor r4 = r3.b();
        if (r4 == null) goto L6;
        r4.g();
        return;
    }

    public final void onRuntimeReady(View r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
    }

    public final void g(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
    }

    public final void onLoadFailed(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        OrderCommonBusinessMonitor r4 = this.a.b();
        if (r4 == null) goto L5;
        r4.f(r3);
    L5:
        OrderCommonErrorMonitorKt.b(null, "LYNX_BRIDGE_ERROR", "BridgetLynxComponent-createLiveComponent: onLoadFailed msg:" + r3);
    }

    public final void onPageStart(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r1, "lynxView");
    }

    public final void s(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        OrderCommonErrorMonitorKt.b(null, "LYNX_BRIDGE_ERROR", "BridgetLynxComponent-createLiveComponent: receiveError msg:" + r4 + "  url:" + r3);
    }
}
