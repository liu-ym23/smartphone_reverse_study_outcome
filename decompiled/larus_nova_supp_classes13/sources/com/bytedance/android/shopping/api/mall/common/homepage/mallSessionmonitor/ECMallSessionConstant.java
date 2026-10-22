package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/mallSessionmonitor/ECMallSessionConstant;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "FORCE_REPORT", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECMallSessionConstant extends Enum<ECMallSessionConstant> {
    public static final ECMallSessionConstant FORCE_REPORT = null;
    public static final /* synthetic */ ECMallSessionConstant[] a = null;
    private final String type;

    static {
        ECMallSessionConstant r1 = new ECMallSessionConstant();
        FORCE_REPORT = r1;
        a = new ECMallSessionConstant[]{r1};
    }

    public static ECMallSessionConstant valueOf(String r1) {
        return (ECMallSessionConstant) r27.a.a(ECMallSessionConstant.class, r1);
    }

    public static ECMallSessionConstant[] values() {
        return (ECMallSessionConstant[]) a.clone();
    }

    public ECMallSessionConstant() {
        super("FORCE_REPORT", 0);
        this.type = "force_report";
    }

    public final String getType() {
        return this.type;
    }
}
