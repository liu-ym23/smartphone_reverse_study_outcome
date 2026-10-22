package com.bytedance.android.shopping.orderlist.list.container;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[OrderListRequestType.values().length];
        a = r0;
        r0[OrderListRequestType.NORMAL.ordinal()] = 1;
        r0[OrderListRequestType.FIRST_REQUEST.ordinal()] = 2;
        r0[OrderListRequestType.PRELOAD_REQUEST.ordinal()] = 3;
        r0[OrderListRequestType.CHANGE_TAB_ERROR_RETRY_REQUEST.ordinal()] = 4;
        r0[OrderListRequestType.FIRST_SCREEN_ERROR_RETRY_REQUEST.ordinal()] = 5;
        OrderListRequestType r1 = OrderListRequestType.HEAD_REQUEST;
        r0[r1.ordinal()] = 6;
        OrderListRequestType r4 = OrderListRequestType.FOOT_REQUEST;
        r0[r4.ordinal()] = 7;
        int[] r2 = new int[OrderListRequestType.values().length];
        b = r2;
        r2[r1.ordinal()] = 1;
        r2[r4.ordinal()] = 2;
    }
}
