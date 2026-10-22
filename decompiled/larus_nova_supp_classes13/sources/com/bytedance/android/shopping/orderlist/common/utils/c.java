package com.bytedance.android.shopping.orderlist.common.utils;

import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(OrderListFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Object r0 = r3.getContext();
        Fragment r2 = null;
        if ((r0 instanceof com.bytedance.android.shopping.orderlist.list.container.b) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.shopping.orderlist.list.container.b r1 = (com.bytedance.android.shopping.orderlist.list.container.b) r0;
        if (r1 != null) goto L12;
        Fragment r4 = r3.getParentFragment();
        if ((r4 instanceof com.bytedance.android.shopping.orderlist.list.container.b) == false) goto L11;
        r2 = r4;
    L11:
        r1 = (com.bytedance.android.shopping.orderlist.list.container.b) r2;
    L12:
        if (r1 == null) goto L14;
        r1.close();
        return;
    L14:
        OrderCommonErrorMonitorKt.b(r3.Y90().getTracker(), "MINOR_BUSINESS_ERROR", "context and parentFragment is not IOrderListPageContainer");
    }
}
