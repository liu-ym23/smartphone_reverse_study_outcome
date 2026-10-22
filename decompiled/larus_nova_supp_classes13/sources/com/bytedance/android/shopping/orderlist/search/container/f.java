package com.bytedance.android.shopping.orderlist.search.container;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[OrderSearchRequestType.values().length];
        a = r0;
        OrderSearchRequestType r1 = OrderSearchRequestType.NORMAL;
        r0[r1.ordinal()] = 1;
        OrderSearchRequestType r2 = OrderSearchRequestType.FIRST_REQUEST;
        r0[r2.ordinal()] = 2;
        OrderSearchRequestType r4 = OrderSearchRequestType.FIRST_SCREEN_ERROR_RETRY_REQUEST;
        r0[r4.ordinal()] = 3;
        OrderSearchRequestType r6 = OrderSearchRequestType.FOOT_REQUEST;
        r0[r6.ordinal()] = 4;
        int[] r3 = new int[OrderSearchRequestType.values().length];
        b = r3;
        r3[r2.ordinal()] = 1;
        r3[r4.ordinal()] = 2;
        r3[r6.ordinal()] = 3;
        r3[r1.ordinal()] = 4;
    }
}
