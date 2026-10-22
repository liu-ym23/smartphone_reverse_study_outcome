package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/mallSessionmonitor/ECStageTriggerSource;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "GENERAL", "PUZZLE_LIFECYCLE_DELIVERY", "SECONDARY_PAGE_LIFECYCLE_DELIVERY", "SECONDARY_PAGE_LIFECYCLE_GENERAL", "NATIVE_LIFECYCLE_DELIVERY", "TABKIT_LIFECYCLE_DELIVERY", "NATIVE_LIFECYCLE_GENERAL", "MALL_DELIVERYRECORD_BRIDGE", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECStageTriggerSource extends Enum<ECStageTriggerSource> {
    public static final ECStageTriggerSource GENERAL = null;
    public static final ECStageTriggerSource MALL_DELIVERYRECORD_BRIDGE = null;
    public static final ECStageTriggerSource NATIVE_LIFECYCLE_DELIVERY = null;
    public static final ECStageTriggerSource NATIVE_LIFECYCLE_GENERAL = null;
    public static final ECStageTriggerSource PUZZLE_LIFECYCLE_DELIVERY = null;
    public static final ECStageTriggerSource SECONDARY_PAGE_LIFECYCLE_DELIVERY = null;
    public static final ECStageTriggerSource SECONDARY_PAGE_LIFECYCLE_GENERAL = null;
    public static final ECStageTriggerSource TABKIT_LIFECYCLE_DELIVERY = null;
    public static final /* synthetic */ ECStageTriggerSource[] a = null;
    private final String type;

    public static ECStageTriggerSource valueOf(String r1) {
        return (ECStageTriggerSource) r27.a.a(ECStageTriggerSource.class, r1);
    }

    public static ECStageTriggerSource[] values() {
        return (ECStageTriggerSource[]) a.clone();
    }

    static {
        ECStageTriggerSource r1 = new ECStageTriggerSource("GENERAL", 0, "general");
        GENERAL = r1;
        ECStageTriggerSource r2 = new ECStageTriggerSource("PUZZLE_LIFECYCLE_DELIVERY", 1, "puzzle_lifecycle_delivery");
        PUZZLE_LIFECYCLE_DELIVERY = r2;
        ECStageTriggerSource r3 = new ECStageTriggerSource("SECONDARY_PAGE_LIFECYCLE_DELIVERY", 2, "secondaryPage_lifecycle_delivery");
        SECONDARY_PAGE_LIFECYCLE_DELIVERY = r3;
        ECStageTriggerSource r4 = new ECStageTriggerSource("SECONDARY_PAGE_LIFECYCLE_GENERAL", 3, "secondaryPage_lifecycle_general");
        SECONDARY_PAGE_LIFECYCLE_GENERAL = r4;
        ECStageTriggerSource r5 = new ECStageTriggerSource("NATIVE_LIFECYCLE_DELIVERY", 4, "native_lifecycle_delivery");
        NATIVE_LIFECYCLE_DELIVERY = r5;
        ECStageTriggerSource r6 = new ECStageTriggerSource("TABKIT_LIFECYCLE_DELIVERY", 5, "tabkit_lifecycle_delivery");
        TABKIT_LIFECYCLE_DELIVERY = r6;
        ECStageTriggerSource r7 = new ECStageTriggerSource("NATIVE_LIFECYCLE_GENERAL", 6, "native_lifecycle_general");
        NATIVE_LIFECYCLE_GENERAL = r7;
        ECStageTriggerSource r8 = new ECStageTriggerSource("MALL_DELIVERYRECORD_BRIDGE", 7, "mall_deliveryRecord_bridge");
        MALL_DELIVERYRECORD_BRIDGE = r8;
        a = new ECStageTriggerSource[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final String getType() {
        return this.type;
    }

    public ECStageTriggerSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
