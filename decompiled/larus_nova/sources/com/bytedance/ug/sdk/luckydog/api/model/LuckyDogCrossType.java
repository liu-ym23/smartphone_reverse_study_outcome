package com.bytedance.ug.sdk.luckydog.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/model/LuckyDogCrossType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "TYPE_CROSS_ACK_TIME", "TYPE_CROSS_REACK_INSTALL", "UNKNOWN", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum LuckyDogCrossType extends Enum<LuckyDogCrossType> {
    public static final LuckyDogCrossType TYPE_CROSS_ACK_TIME = null;
    public static final LuckyDogCrossType TYPE_CROSS_REACK_INSTALL = null;
    public static final LuckyDogCrossType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LuckyDogCrossType[] f271590a = null;
    private final String value;

    static {
        LuckyDogCrossType r100 = new LuckyDogCrossType("TYPE_CROSS_ACK_TIME", 0, "luckydog_cross_type_ack_time");
        TYPE_CROSS_ACK_TIME = r100;
        LuckyDogCrossType r101 = new LuckyDogCrossType("TYPE_CROSS_REACK_INSTALL", 1, "luckydog_cross_type_reack_install");
        TYPE_CROSS_REACK_INSTALL = r101;
        LuckyDogCrossType r102 = new LuckyDogCrossType("UNKNOWN", 2, "unknown");
        UNKNOWN = r102;
        f271590a = new LuckyDogCrossType[]{r100, r101, r102};
    }

    public static LuckyDogCrossType valueOf(String r100) {
        return (LuckyDogCrossType) a.a(LuckyDogCrossType.class, r100);
    }

    public static LuckyDogCrossType[] values() {
        return (LuckyDogCrossType[]) f271590a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public LuckyDogCrossType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
