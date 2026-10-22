package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/LogisticsTextType;", "", "", "value", "I", "getValue", "()I", "DELIVERY", "DELIVERY_ADDRESS_WITH_EPIDEMIC", "SHIPPING_ADDRESS_WITH_EPIDEMIC", "DELIVERY_ADDRESS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LogisticsTextType extends Enum<LogisticsTextType> {
    public static final LogisticsTextType DELIVERY = null;
    public static final LogisticsTextType DELIVERY_ADDRESS = null;
    public static final LogisticsTextType DELIVERY_ADDRESS_WITH_EPIDEMIC = null;
    public static final LogisticsTextType SHIPPING_ADDRESS_WITH_EPIDEMIC = null;
    public static final /* synthetic */ LogisticsTextType[] a = null;
    private final int value;

    static {
        LogisticsTextType r2 = new LogisticsTextType("DELIVERY", 0, 1);
        DELIVERY = r2;
        LogisticsTextType r3 = new LogisticsTextType("DELIVERY_ADDRESS_WITH_EPIDEMIC", 1, 2);
        DELIVERY_ADDRESS_WITH_EPIDEMIC = r3;
        LogisticsTextType r4 = new LogisticsTextType("SHIPPING_ADDRESS_WITH_EPIDEMIC", 2, 3);
        SHIPPING_ADDRESS_WITH_EPIDEMIC = r4;
        LogisticsTextType r5 = new LogisticsTextType("DELIVERY_ADDRESS", 3, 4);
        DELIVERY_ADDRESS = r5;
        a = new LogisticsTextType[]{r2, r3, r4, r5};
    }

    public static LogisticsTextType valueOf(String r1) {
        return (LogisticsTextType) r27.a.a(LogisticsTextType.class, r1);
    }

    public static LogisticsTextType[] values() {
        return (LogisticsTextType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LogisticsTextType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
