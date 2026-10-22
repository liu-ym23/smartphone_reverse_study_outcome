package com.bytedance.android.shopping.orderlist.common.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/model/OrderListPreloadResultCode;", "", "", "code", "I", "getCode", "()I", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "ALREADY_REQUESTING", "ALREADY_IN_ORDER_LIST", "INVALID_ENTER_FROM", "GET_SCHEMA_FAILURE", "SCHEMA_PROCESSOR_INVALID", "EXIST_VALID_PRELOAD_RESPONSE", "GET_QUERY_RESPONSE_FAILURE", "SUCCESS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OrderListPreloadResultCode extends Enum<OrderListPreloadResultCode> {
    public static final OrderListPreloadResultCode ALREADY_IN_ORDER_LIST = null;
    public static final OrderListPreloadResultCode ALREADY_REQUESTING = null;
    public static final OrderListPreloadResultCode EXIST_VALID_PRELOAD_RESPONSE = null;
    public static final OrderListPreloadResultCode GET_QUERY_RESPONSE_FAILURE = null;
    public static final OrderListPreloadResultCode GET_SCHEMA_FAILURE = null;
    public static final OrderListPreloadResultCode INVALID_ENTER_FROM = null;
    public static final OrderListPreloadResultCode SCHEMA_PROCESSOR_INVALID = null;
    public static final OrderListPreloadResultCode SUCCESS = null;
    public static final /* synthetic */ OrderListPreloadResultCode[] a = null;
    private final int code;
    private final String msg;

    public static OrderListPreloadResultCode valueOf(String r1) {
        return (OrderListPreloadResultCode) a.a(OrderListPreloadResultCode.class, r1);
    }

    public static OrderListPreloadResultCode[] values() {
        return (OrderListPreloadResultCode[]) a.clone();
    }

    static {
        OrderListPreloadResultCode r1 = new OrderListPreloadResultCode("ALREADY_REQUESTING", 0, -1, "当前正在请求中");
        ALREADY_REQUESTING = r1;
        OrderListPreloadResultCode r2 = new OrderListPreloadResultCode("ALREADY_IN_ORDER_LIST", 1, -2, "当前在订单列表页面");
        ALREADY_IN_ORDER_LIST = r2;
        OrderListPreloadResultCode r3 = new OrderListPreloadResultCode("INVALID_ENTER_FROM", 2, -3, "输入enterFrom为空");
        INVALID_ENTER_FROM = r3;
        OrderListPreloadResultCode r4 = new OrderListPreloadResultCode("GET_SCHEMA_FAILURE", 3, -4, "获取最新scheme失败");
        GET_SCHEMA_FAILURE = r4;
        OrderListPreloadResultCode r5 = new OrderListPreloadResultCode("SCHEMA_PROCESSOR_INVALID", 4, -5, "业务返回scheme为空");
        SCHEMA_PROCESSOR_INVALID = r5;
        OrderListPreloadResultCode r6 = new OrderListPreloadResultCode("EXIST_VALID_PRELOAD_RESPONSE", 5, -6, "已存在有效的预加载结果");
        EXIST_VALID_PRELOAD_RESPONSE = r6;
        OrderListPreloadResultCode r7 = new OrderListPreloadResultCode("GET_QUERY_RESPONSE_FAILURE", 6, -7, "获取订单列表协议失败");
        GET_QUERY_RESPONSE_FAILURE = r7;
        OrderListPreloadResultCode r8 = new OrderListPreloadResultCode("SUCCESS", 7, 0, "预加载成功");
        SUCCESS = r8;
        a = new OrderListPreloadResultCode[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public OrderListPreloadResultCode(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.code = r3;
        this.msg = r4;
    }
}
