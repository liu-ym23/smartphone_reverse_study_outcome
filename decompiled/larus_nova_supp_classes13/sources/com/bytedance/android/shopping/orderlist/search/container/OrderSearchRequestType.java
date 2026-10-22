package com.bytedance.android.shopping.orderlist.search.container;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/search/container/OrderSearchRequestType;", "", "NORMAL", "FIRST_REQUEST", "FIRST_SCREEN_ERROR_RETRY_REQUEST", "FOOT_REQUEST", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderSearchRequestType extends Enum<OrderSearchRequestType> {
    public static final OrderSearchRequestType FIRST_REQUEST = null;
    public static final OrderSearchRequestType FIRST_SCREEN_ERROR_RETRY_REQUEST = null;
    public static final OrderSearchRequestType FOOT_REQUEST = null;
    public static final OrderSearchRequestType NORMAL = null;
    public static final /* synthetic */ OrderSearchRequestType[] a = null;

    static {
        OrderSearchRequestType r1 = new OrderSearchRequestType("NORMAL", 0);
        NORMAL = r1;
        OrderSearchRequestType r2 = new OrderSearchRequestType("FIRST_REQUEST", 1);
        FIRST_REQUEST = r2;
        OrderSearchRequestType r3 = new OrderSearchRequestType("FIRST_SCREEN_ERROR_RETRY_REQUEST", 2);
        FIRST_SCREEN_ERROR_RETRY_REQUEST = r3;
        OrderSearchRequestType r4 = new OrderSearchRequestType("FOOT_REQUEST", 3);
        FOOT_REQUEST = r4;
        a = new OrderSearchRequestType[]{r1, r2, r3, r4};
    }

    public static OrderSearchRequestType valueOf(String r1) {
        return (OrderSearchRequestType) r27.a.a(OrderSearchRequestType.class, r1);
    }

    public static OrderSearchRequestType[] values() {
        return (OrderSearchRequestType[]) a.clone();
    }

    public OrderSearchRequestType(String r1, int r2) {
        super(r1, r2);
    }
}
