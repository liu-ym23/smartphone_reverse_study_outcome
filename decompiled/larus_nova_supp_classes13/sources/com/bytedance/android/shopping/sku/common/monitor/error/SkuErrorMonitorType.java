package com.bytedance.android.shopping.sku.common.monitor.error;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/monitor/error/SkuErrorMonitorType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CRASH", "SERIOUS_BUSINESS_ERROR", "MINOR_BUSINESS_ERROR", "SERVER_BUSINESS_ERROR", "SELF_FUN_ERROR", "SKU_QUERY_API_ERROR", "SKU_UPDATE_API_ERROR", "AUTO_COUPON_API_ERROR", "ADD_CART_API_ERROR", "TRIGGER_INTERCEPTED", "CACHE_TRIGGER_INTERCEPTED", "UPLINK_ROLLBACK", "YATA_REQUEST_ERROR", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkuErrorMonitorType extends Enum<SkuErrorMonitorType> {
    public static final SkuErrorMonitorType ADD_CART_API_ERROR = null;
    public static final SkuErrorMonitorType AUTO_COUPON_API_ERROR = null;
    public static final SkuErrorMonitorType CACHE_TRIGGER_INTERCEPTED = null;
    public static final SkuErrorMonitorType CRASH = null;
    public static final SkuErrorMonitorType MINOR_BUSINESS_ERROR = null;
    public static final SkuErrorMonitorType SELF_FUN_ERROR = null;
    public static final SkuErrorMonitorType SERIOUS_BUSINESS_ERROR = null;
    public static final SkuErrorMonitorType SERVER_BUSINESS_ERROR = null;
    public static final SkuErrorMonitorType SKU_QUERY_API_ERROR = null;
    public static final SkuErrorMonitorType SKU_UPDATE_API_ERROR = null;
    public static final SkuErrorMonitorType TRIGGER_INTERCEPTED = null;
    public static final SkuErrorMonitorType UPLINK_ROLLBACK = null;
    public static final SkuErrorMonitorType YATA_REQUEST_ERROR = null;
    public static final /* synthetic */ SkuErrorMonitorType[] a = null;
    private final String value;

    public static SkuErrorMonitorType valueOf(String r1) {
        return (SkuErrorMonitorType) r27.a.a(SkuErrorMonitorType.class, r1);
    }

    public static SkuErrorMonitorType[] values() {
        return (SkuErrorMonitorType[]) a.clone();
    }

    static {
        SkuErrorMonitorType r1 = new SkuErrorMonitorType("CRASH", 0, "CRASH");
        CRASH = r1;
        SkuErrorMonitorType r2 = new SkuErrorMonitorType("SERIOUS_BUSINESS_ERROR", 1, "SERIOUS_BUSINESS_ERROR");
        SERIOUS_BUSINESS_ERROR = r2;
        SkuErrorMonitorType r3 = new SkuErrorMonitorType("MINOR_BUSINESS_ERROR", 2, "MINOR_BUSINESS_ERROR");
        MINOR_BUSINESS_ERROR = r3;
        SkuErrorMonitorType r4 = new SkuErrorMonitorType("SERVER_BUSINESS_ERROR", 3, "SERVER_BUSINESS_ERROR");
        SERVER_BUSINESS_ERROR = r4;
        SkuErrorMonitorType r5 = new SkuErrorMonitorType("SELF_FUN_ERROR", 4, "SELF_FUN_ERROR");
        SELF_FUN_ERROR = r5;
        SkuErrorMonitorType r6 = new SkuErrorMonitorType("SKU_QUERY_API_ERROR", 5, "SKU_QUERY_API_ERROR");
        SKU_QUERY_API_ERROR = r6;
        SkuErrorMonitorType r7 = new SkuErrorMonitorType("SKU_UPDATE_API_ERROR", 6, "SKU_UPDATE_API_ERROR");
        SKU_UPDATE_API_ERROR = r7;
        SkuErrorMonitorType r8 = new SkuErrorMonitorType("AUTO_COUPON_API_ERROR", 7, "AUTO_COUPON_API_ERROR");
        AUTO_COUPON_API_ERROR = r8;
        SkuErrorMonitorType r9 = new SkuErrorMonitorType("ADD_CART_API_ERROR", 8, "ADD_CART_API_ERROR");
        ADD_CART_API_ERROR = r9;
        SkuErrorMonitorType r10 = new SkuErrorMonitorType("TRIGGER_INTERCEPTED", 9, "TRIGGER_INTERCEPTED");
        TRIGGER_INTERCEPTED = r10;
        SkuErrorMonitorType r11 = new SkuErrorMonitorType("CACHE_TRIGGER_INTERCEPTED", 10, "CACHE_TRIGGER_INTERCEPTED");
        CACHE_TRIGGER_INTERCEPTED = r11;
        SkuErrorMonitorType r12 = new SkuErrorMonitorType("UPLINK_ROLLBACK", 11, "UPLINK_ROLLBACK");
        UPLINK_ROLLBACK = r12;
        SkuErrorMonitorType r13 = new SkuErrorMonitorType("YATA_REQUEST_ERROR", 12, "yata_request_error");
        YATA_REQUEST_ERROR = r13;
        a = new SkuErrorMonitorType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13};
    }

    public final String getValue() {
        return this.value;
    }

    public SkuErrorMonitorType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
