package com.bytedance.android.shopping.api.mall.idl;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/idl/ECMallDeviceScreenTypeEnum;", "", "", "value", "I", "getValue", "()I", "WIDE_SCREEN", "NORMAL_SCREEN", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECMallDeviceScreenTypeEnum extends Enum<ECMallDeviceScreenTypeEnum> {
    public static final ECMallDeviceScreenTypeEnum NORMAL_SCREEN = null;
    public static final ECMallDeviceScreenTypeEnum WIDE_SCREEN = null;
    public static final /* synthetic */ ECMallDeviceScreenTypeEnum[] a = null;
    private final int value;

    static {
        ECMallDeviceScreenTypeEnum r1 = new ECMallDeviceScreenTypeEnum("WIDE_SCREEN", 0, 0);
        WIDE_SCREEN = r1;
        ECMallDeviceScreenTypeEnum r2 = new ECMallDeviceScreenTypeEnum("NORMAL_SCREEN", 1, 1);
        NORMAL_SCREEN = r2;
        a = new ECMallDeviceScreenTypeEnum[]{r1, r2};
    }

    public static ECMallDeviceScreenTypeEnum valueOf(String r1) {
        return (ECMallDeviceScreenTypeEnum) r27.a.a(ECMallDeviceScreenTypeEnum.class, r1);
    }

    public static ECMallDeviceScreenTypeEnum[] values() {
        return (ECMallDeviceScreenTypeEnum[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ECMallDeviceScreenTypeEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
