package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/mallSessionmonitor/ECHandlerType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "DELIVERY_SESSION", "EC_PERF_SESSION", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECHandlerType extends Enum<ECHandlerType> {
    public static final ECHandlerType DELIVERY_SESSION = null;
    public static final ECHandlerType EC_PERF_SESSION = null;
    public static final /* synthetic */ ECHandlerType[] a = null;
    private final String type;

    static {
        ECHandlerType r1 = new ECHandlerType("DELIVERY_SESSION", 0, "delivery_session");
        DELIVERY_SESSION = r1;
        ECHandlerType r2 = new ECHandlerType("EC_PERF_SESSION", 1, "ec_perf_session");
        EC_PERF_SESSION = r2;
        a = new ECHandlerType[]{r1, r2};
    }

    public static ECHandlerType valueOf(String r1) {
        return (ECHandlerType) r27.a.a(ECHandlerType.class, r1);
    }

    public static ECHandlerType[] values() {
        return (ECHandlerType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public ECHandlerType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
