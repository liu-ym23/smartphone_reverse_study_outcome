package com.bytedance.android.shopping.orderlist.list.container;

import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[OrderListRequestType.values().length];
        a = r0;
        OrderListRequestType r1 = OrderListRequestType.FIRST_REQUEST;
        r0[r1.ordinal()] = 1;
        OrderListRequestType r2 = OrderListRequestType.PRELOAD_REQUEST;
        r0[r2.ordinal()] = 2;
        OrderListRequestType r4 = OrderListRequestType.NORMAL;
        r0[r4.ordinal()] = 3;
        OrderListRequestType r6 = OrderListRequestType.FIRST_SCREEN_ERROR_RETRY_REQUEST;
        r0[r6.ordinal()] = 4;
        OrderListRequestType r8 = OrderListRequestType.CHANGE_TAB_ERROR_RETRY_REQUEST;
        r0[r8.ordinal()] = 5;
        OrderListRequestType r10 = OrderListRequestType.HEAD_REQUEST;
        r0[r10.ordinal()] = 6;
        OrderListRequestType r12 = OrderListRequestType.CLICK_TAB_REQUEST;
        r0[r12.ordinal()] = 7;
        OrderListRequestType r14 = OrderListRequestType.SIDE_SLIP_TAB_REQUEST;
        r0[r14.ordinal()] = 8;
        OrderListRequestType r16 = OrderListRequestType.FOOT_REQUEST;
        r0[r16.ordinal()] = 9;
        int[] r3 = new int[OrderListRequestType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        r3[r8.ordinal()] = 5;
        r3[r12.ordinal()] = 6;
        r3[r14.ordinal()] = 7;
        r3[r10.ordinal()] = 8;
        r3[r16.ordinal()] = 9;
        int[] r5 = new int[OrderListTracker.ChangeTabType.values().length];
        c = r5;
        r5[OrderListTracker.ChangeTabType.SLIDE.ordinal()] = 1;
        r5[OrderListTracker.ChangeTabType.CLICK.ordinal()] = 2;
    }
}
