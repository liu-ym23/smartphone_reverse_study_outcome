package com.bytedance.android.shopping.orderlist.list.container;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/container/OrderListRequestType;", "", "NORMAL", "FIRST_REQUEST", "FIRST_SCREEN_ERROR_RETRY_REQUEST", "CHANGE_TAB_ERROR_RETRY_REQUEST", "HEAD_REQUEST", "FOOT_REQUEST", "PRELOAD_REQUEST", "CLICK_TAB_REQUEST", "SIDE_SLIP_TAB_REQUEST", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderListRequestType extends Enum<OrderListRequestType> {
    public static final OrderListRequestType CHANGE_TAB_ERROR_RETRY_REQUEST = null;
    public static final OrderListRequestType CLICK_TAB_REQUEST = null;
    public static final OrderListRequestType FIRST_REQUEST = null;
    public static final OrderListRequestType FIRST_SCREEN_ERROR_RETRY_REQUEST = null;
    public static final OrderListRequestType FOOT_REQUEST = null;
    public static final OrderListRequestType HEAD_REQUEST = null;
    public static final OrderListRequestType NORMAL = null;
    public static final OrderListRequestType PRELOAD_REQUEST = null;
    public static final OrderListRequestType SIDE_SLIP_TAB_REQUEST = null;
    public static final /* synthetic */ OrderListRequestType[] a = null;

    static {
        OrderListRequestType r1 = new OrderListRequestType("NORMAL", 0);
        NORMAL = r1;
        OrderListRequestType r2 = new OrderListRequestType("FIRST_REQUEST", 1);
        FIRST_REQUEST = r2;
        OrderListRequestType r3 = new OrderListRequestType("FIRST_SCREEN_ERROR_RETRY_REQUEST", 2);
        FIRST_SCREEN_ERROR_RETRY_REQUEST = r3;
        OrderListRequestType r4 = new OrderListRequestType("CHANGE_TAB_ERROR_RETRY_REQUEST", 3);
        CHANGE_TAB_ERROR_RETRY_REQUEST = r4;
        OrderListRequestType r5 = new OrderListRequestType("HEAD_REQUEST", 4);
        HEAD_REQUEST = r5;
        OrderListRequestType r6 = new OrderListRequestType("FOOT_REQUEST", 5);
        FOOT_REQUEST = r6;
        OrderListRequestType r7 = new OrderListRequestType("PRELOAD_REQUEST", 6);
        PRELOAD_REQUEST = r7;
        OrderListRequestType r8 = new OrderListRequestType("CLICK_TAB_REQUEST", 7);
        CLICK_TAB_REQUEST = r8;
        OrderListRequestType r9 = new OrderListRequestType("SIDE_SLIP_TAB_REQUEST", 8);
        SIDE_SLIP_TAB_REQUEST = r9;
        a = new OrderListRequestType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public static OrderListRequestType valueOf(String r1) {
        return (OrderListRequestType) r27.a.a(OrderListRequestType.class, r1);
    }

    public static OrderListRequestType[] values() {
        return (OrderListRequestType[]) a.clone();
    }

    public OrderListRequestType(String r1, int r2) {
        super(r1, r2);
    }
}
