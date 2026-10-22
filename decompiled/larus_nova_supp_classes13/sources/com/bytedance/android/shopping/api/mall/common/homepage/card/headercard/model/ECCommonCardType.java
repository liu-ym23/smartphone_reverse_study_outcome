package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECCommonCardType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LIVE", "PRODUCT", "SHOP", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECCommonCardType extends Enum<ECCommonCardType> {
    private static final /* synthetic */ ECCommonCardType[] $VALUES = null;
    public static final ECCommonCardType LIVE = null;
    public static final ECCommonCardType PRODUCT = null;
    public static final ECCommonCardType SHOP = null;
    private final int value;

    static {
        ECCommonCardType r1 = new ECCommonCardType("LIVE", 0, 1);
        LIVE = r1;
        ECCommonCardType r2 = new ECCommonCardType("PRODUCT", 1, 2);
        PRODUCT = r2;
        ECCommonCardType r3 = new ECCommonCardType("SHOP", 2, 12);
        SHOP = r3;
        $VALUES = new ECCommonCardType[]{r1, r2, r3};
    }

    public static ECCommonCardType valueOf(String r1) {
        return (ECCommonCardType) a.a(ECCommonCardType.class, r1);
    }

    public static ECCommonCardType[] values() {
        return (ECCommonCardType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private ECCommonCardType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
