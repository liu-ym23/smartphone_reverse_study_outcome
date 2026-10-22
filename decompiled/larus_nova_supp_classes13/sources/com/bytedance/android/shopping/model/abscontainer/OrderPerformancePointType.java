package com.bytedance.android.shopping.model.abscontainer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/model/abscontainer/OrderPerformancePointType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ORDER_SUBMIT", "ORDER_CREATE_START", "ORDER_CREATE_NET_START", "ORDER_CREATE_NET_END", "ORDER_CREATE_END", "ORDER_TTPAY_CALL_START", "ORDER_TTPAY_CALL_END", "ORDER_CHECK_START", "ORDER_CHECK_END", "END", "REQUEST_START", "REQUEST_END", "STANDARD_RENDER_START", "STANDARD_RENDER_END", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum OrderPerformancePointType extends Enum<OrderPerformancePointType> {
    public static final OrderPerformancePointType END = null;
    public static final OrderPerformancePointType ORDER_CHECK_END = null;
    public static final OrderPerformancePointType ORDER_CHECK_START = null;
    public static final OrderPerformancePointType ORDER_CREATE_END = null;
    public static final OrderPerformancePointType ORDER_CREATE_NET_END = null;
    public static final OrderPerformancePointType ORDER_CREATE_NET_START = null;
    public static final OrderPerformancePointType ORDER_CREATE_START = null;
    public static final OrderPerformancePointType ORDER_SUBMIT = null;
    public static final OrderPerformancePointType ORDER_TTPAY_CALL_END = null;
    public static final OrderPerformancePointType ORDER_TTPAY_CALL_START = null;
    public static final OrderPerformancePointType REQUEST_END = null;
    public static final OrderPerformancePointType REQUEST_START = null;
    public static final OrderPerformancePointType STANDARD_RENDER_END = null;
    public static final OrderPerformancePointType STANDARD_RENDER_START = null;
    public static final /* synthetic */ OrderPerformancePointType[] a = null;
    private final String value;

    public static OrderPerformancePointType valueOf(String r1) {
        return (OrderPerformancePointType) a.a(OrderPerformancePointType.class, r1);
    }

    public static OrderPerformancePointType[] values() {
        return (OrderPerformancePointType[]) a.clone();
    }

    static {
        OrderPerformancePointType r1 = new OrderPerformancePointType("ORDER_SUBMIT", 0, "C_ORDER_SUBMIT");
        ORDER_SUBMIT = r1;
        OrderPerformancePointType r2 = new OrderPerformancePointType("ORDER_CREATE_START", 1, "C_ORDER_CREATE_START");
        ORDER_CREATE_START = r2;
        OrderPerformancePointType r3 = new OrderPerformancePointType("ORDER_CREATE_NET_START", 2, "C_ORDER_CREATE_NET_START");
        ORDER_CREATE_NET_START = r3;
        OrderPerformancePointType r4 = new OrderPerformancePointType("ORDER_CREATE_NET_END", 3, "C_ORDER_CREATE_NET_END");
        ORDER_CREATE_NET_END = r4;
        OrderPerformancePointType r5 = new OrderPerformancePointType("ORDER_CREATE_END", 4, "C_ORDER_CREATE_END");
        ORDER_CREATE_END = r5;
        OrderPerformancePointType r6 = new OrderPerformancePointType("ORDER_TTPAY_CALL_START", 5, "C_ORDER_TTPAY_CALL_START");
        ORDER_TTPAY_CALL_START = r6;
        OrderPerformancePointType r7 = new OrderPerformancePointType("ORDER_TTPAY_CALL_END", 6, "C_ORDER_TTPAY_CALL_END");
        ORDER_TTPAY_CALL_END = r7;
        OrderPerformancePointType r8 = new OrderPerformancePointType("ORDER_CHECK_START", 7, "C_ORDER_CHECK_START");
        ORDER_CHECK_START = r8;
        OrderPerformancePointType r9 = new OrderPerformancePointType("ORDER_CHECK_END", 8, "C_ORDER_CHECK_END");
        ORDER_CHECK_END = r9;
        OrderPerformancePointType r10 = new OrderPerformancePointType("END", 9, "C_END");
        END = r10;
        OrderPerformancePointType r11 = new OrderPerformancePointType("REQUEST_START", 10, "request_start");
        REQUEST_START = r11;
        OrderPerformancePointType r12 = new OrderPerformancePointType("REQUEST_END", 11, "request_end");
        REQUEST_END = r12;
        OrderPerformancePointType r13 = new OrderPerformancePointType("STANDARD_RENDER_START", 12, "render_start");
        STANDARD_RENDER_START = r13;
        OrderPerformancePointType r14 = new OrderPerformancePointType("STANDARD_RENDER_END", 13, "render_end");
        STANDARD_RENDER_END = r14;
        a = new OrderPerformancePointType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14};
    }

    public final String getValue() {
        return this.value;
    }

    public OrderPerformancePointType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
