package com.bytedance.android.shopping.api.mall;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/ECMallHostType;", "", "XIGUA", "TOUTIAO", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum ECMallHostType extends Enum<ECMallHostType> {
    public static final ECMallHostType TOUTIAO = null;
    public static final ECMallHostType XIGUA = null;
    public static final /* synthetic */ ECMallHostType[] a = null;

    static {
        ECMallHostType r1 = new ECMallHostType("XIGUA", 0);
        XIGUA = r1;
        ECMallHostType r2 = new ECMallHostType("TOUTIAO", 1);
        TOUTIAO = r2;
        a = new ECMallHostType[]{r1, r2};
    }

    public static ECMallHostType valueOf(String r1) {
        return (ECMallHostType) r27.a.a(ECMallHostType.class, r1);
    }

    public static ECMallHostType[] values() {
        return (ECMallHostType[]) a.clone();
    }

    public ECMallHostType(String r1, int r2) {
        super(r1, r2);
    }
}
