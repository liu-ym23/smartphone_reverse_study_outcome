package com.bytedance.android.shopping.orderlist.list.widget.headrefresh;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[OrderListHeadRefreshLayout.MoveState.values().length];
        a = r0;
        OrderListHeadRefreshLayout.MoveState r1 = OrderListHeadRefreshLayout.MoveState.V_MOVING_HEAD;
        r0[r1.ordinal()] = 1;
        OrderListHeadRefreshLayout.MoveState r2 = OrderListHeadRefreshLayout.MoveState.V_MOVING_HEAD_UP_OR_CANCEL;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[OrderListHeadRefreshLayout.MoveState.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
