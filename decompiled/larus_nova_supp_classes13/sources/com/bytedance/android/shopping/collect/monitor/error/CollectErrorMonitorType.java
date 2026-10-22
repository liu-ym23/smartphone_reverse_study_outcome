package com.bytedance.android.shopping.collect.monitor.error;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/collect/monitor/error/CollectErrorMonitorType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CRASH", "SERIOUS_BUSINESS_ERROR", "MINOR_BUSINESS_ERROR", "SERVER_BUSINESS_ERROR", "SELF_FUN_ERROR", "COLLECT_QUERY_API_ERROR", "COLLECT_UPDATE_API_ERROR", "AUTO_COUPON_API_ERROR", "ADD_CART_API_ERROR", "TRIGGER_INTERCEPTED", "CACHE_TRIGGER_INTERCEPTED", "UPLINK_ROLLBACK", "YATA_REQUEST_ERROR", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CollectErrorMonitorType extends Enum<CollectErrorMonitorType> {
    public static final CollectErrorMonitorType ADD_CART_API_ERROR = null;
    public static final CollectErrorMonitorType AUTO_COUPON_API_ERROR = null;
    public static final CollectErrorMonitorType CACHE_TRIGGER_INTERCEPTED = null;
    public static final CollectErrorMonitorType COLLECT_QUERY_API_ERROR = null;
    public static final CollectErrorMonitorType COLLECT_UPDATE_API_ERROR = null;
    public static final CollectErrorMonitorType CRASH = null;
    public static final CollectErrorMonitorType MINOR_BUSINESS_ERROR = null;
    public static final CollectErrorMonitorType SELF_FUN_ERROR = null;
    public static final CollectErrorMonitorType SERIOUS_BUSINESS_ERROR = null;
    public static final CollectErrorMonitorType SERVER_BUSINESS_ERROR = null;
    public static final CollectErrorMonitorType TRIGGER_INTERCEPTED = null;
    public static final CollectErrorMonitorType UPLINK_ROLLBACK = null;
    public static final CollectErrorMonitorType YATA_REQUEST_ERROR = null;
    public static final /* synthetic */ CollectErrorMonitorType[] a = null;
    private final String value;

    public static CollectErrorMonitorType valueOf(String r1) {
        return (CollectErrorMonitorType) r27.a.a(CollectErrorMonitorType.class, r1);
    }

    public static CollectErrorMonitorType[] values() {
        return (CollectErrorMonitorType[]) a.clone();
    }

    static {
        CollectErrorMonitorType r1 = new CollectErrorMonitorType("CRASH", 0, "CRASH");
        CRASH = r1;
        CollectErrorMonitorType r2 = new CollectErrorMonitorType("SERIOUS_BUSINESS_ERROR", 1, "SERIOUS_BUSINESS_ERROR");
        SERIOUS_BUSINESS_ERROR = r2;
        CollectErrorMonitorType r3 = new CollectErrorMonitorType("MINOR_BUSINESS_ERROR", 2, "MINOR_BUSINESS_ERROR");
        MINOR_BUSINESS_ERROR = r3;
        CollectErrorMonitorType r4 = new CollectErrorMonitorType("SERVER_BUSINESS_ERROR", 3, "SERVER_BUSINESS_ERROR");
        SERVER_BUSINESS_ERROR = r4;
        CollectErrorMonitorType r5 = new CollectErrorMonitorType("SELF_FUN_ERROR", 4, "SELF_FUN_ERROR");
        SELF_FUN_ERROR = r5;
        CollectErrorMonitorType r6 = new CollectErrorMonitorType("COLLECT_QUERY_API_ERROR", 5, "COLLECT_QUERY_API_ERROR");
        COLLECT_QUERY_API_ERROR = r6;
        CollectErrorMonitorType r7 = new CollectErrorMonitorType("COLLECT_UPDATE_API_ERROR", 6, "COLLECT_UPDATE_API_ERROR");
        COLLECT_UPDATE_API_ERROR = r7;
        CollectErrorMonitorType r8 = new CollectErrorMonitorType("AUTO_COUPON_API_ERROR", 7, "AUTO_COUPON_API_ERROR");
        AUTO_COUPON_API_ERROR = r8;
        CollectErrorMonitorType r9 = new CollectErrorMonitorType("ADD_CART_API_ERROR", 8, "ADD_CART_API_ERROR");
        ADD_CART_API_ERROR = r9;
        CollectErrorMonitorType r10 = new CollectErrorMonitorType("TRIGGER_INTERCEPTED", 9, "TRIGGER_INTERCEPTED");
        TRIGGER_INTERCEPTED = r10;
        CollectErrorMonitorType r11 = new CollectErrorMonitorType("CACHE_TRIGGER_INTERCEPTED", 10, "CACHE_TRIGGER_INTERCEPTED");
        CACHE_TRIGGER_INTERCEPTED = r11;
        CollectErrorMonitorType r12 = new CollectErrorMonitorType("UPLINK_ROLLBACK", 11, "UPLINK_ROLLBACK");
        UPLINK_ROLLBACK = r12;
        CollectErrorMonitorType r13 = new CollectErrorMonitorType("YATA_REQUEST_ERROR", 12, "yata_request_error");
        YATA_REQUEST_ERROR = r13;
        a = new CollectErrorMonitorType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13};
    }

    public final String getValue() {
        return this.value;
    }

    public CollectErrorMonitorType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
