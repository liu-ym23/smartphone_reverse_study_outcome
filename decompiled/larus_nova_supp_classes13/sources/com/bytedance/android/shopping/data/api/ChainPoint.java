package com.bytedance.android.shopping.data.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/data/api/ChainPoint;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PAGE_INIT", "SKU_CHECK_START", "SKU_CHECK_END", "AUTO_COUPON_START", "PAGE_START", "AUTO_COUPON_END", "CREATE_SCHEMA_START", "CREATE_SCHEMA_END", "SKU_PARAM_START", "SKU_PARAM_END", "DELAY_START", "DELAY_END", "PARSE_SCHEMA_START", "PARSE_SCHEMA_END", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ChainPoint extends Enum<ChainPoint> {
    public static final ChainPoint AUTO_COUPON_END = null;
    public static final ChainPoint AUTO_COUPON_START = null;
    public static final ChainPoint CREATE_SCHEMA_END = null;
    public static final ChainPoint CREATE_SCHEMA_START = null;
    public static final ChainPoint DELAY_END = null;
    public static final ChainPoint DELAY_START = null;
    public static final ChainPoint PAGE_INIT = null;
    public static final ChainPoint PAGE_START = null;
    public static final ChainPoint PARSE_SCHEMA_END = null;
    public static final ChainPoint PARSE_SCHEMA_START = null;
    public static final ChainPoint SKU_CHECK_END = null;
    public static final ChainPoint SKU_CHECK_START = null;
    public static final ChainPoint SKU_PARAM_END = null;
    public static final ChainPoint SKU_PARAM_START = null;
    public static final /* synthetic */ ChainPoint[] a = null;
    private final String value;

    public static ChainPoint valueOf(String r1) {
        return (ChainPoint) a.a(ChainPoint.class, r1);
    }

    public static ChainPoint[] values() {
        return (ChainPoint[]) a.clone();
    }

    static {
        ChainPoint r1 = new ChainPoint("PAGE_INIT", 0, "C_PAGE_INIT");
        PAGE_INIT = r1;
        ChainPoint r2 = new ChainPoint("SKU_CHECK_START", 1, "C_SKU_CHECK_START");
        SKU_CHECK_START = r2;
        ChainPoint r3 = new ChainPoint("SKU_CHECK_END", 2, "C_SKU_CHECK_END");
        SKU_CHECK_END = r3;
        ChainPoint r4 = new ChainPoint("AUTO_COUPON_START", 3, "C_AUTO_COUPON_START");
        AUTO_COUPON_START = r4;
        ChainPoint r5 = new ChainPoint("PAGE_START", 4, "C_PAGE_START");
        PAGE_START = r5;
        ChainPoint r6 = new ChainPoint("AUTO_COUPON_END", 5, "C_AUTO_COUPON_END");
        AUTO_COUPON_END = r6;
        ChainPoint r7 = new ChainPoint("CREATE_SCHEMA_START", 6, "C_SCHEMA_CREATE_START");
        CREATE_SCHEMA_START = r7;
        ChainPoint r8 = new ChainPoint("CREATE_SCHEMA_END", 7, "C_SCHEMA_CREATE_END");
        CREATE_SCHEMA_END = r8;
        ChainPoint r9 = new ChainPoint("SKU_PARAM_START", 8, "C_SKU_PARAM_START");
        SKU_PARAM_START = r9;
        ChainPoint r10 = new ChainPoint("SKU_PARAM_END", 9, "C_SKU_PARAM_END");
        SKU_PARAM_END = r10;
        ChainPoint r11 = new ChainPoint("DELAY_START", 10, "C_DELAY_START");
        DELAY_START = r11;
        ChainPoint r12 = new ChainPoint("DELAY_END", 11, "C_DELAY_END");
        DELAY_END = r12;
        ChainPoint r13 = new ChainPoint("PARSE_SCHEMA_START", 12, "C_PARSE_SCHEMA_START");
        PARSE_SCHEMA_START = r13;
        ChainPoint r14 = new ChainPoint("PARSE_SCHEMA_END", 13, "C_PARSE_SCHEMA_END");
        PARSE_SCHEMA_END = r14;
        a = new ChainPoint[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14};
    }

    public final String getValue() {
        return this.value;
    }

    public ChainPoint(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
