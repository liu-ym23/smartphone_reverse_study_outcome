package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/CornerType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DOT", "TEXT", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CornerType extends Enum<CornerType> {
    private static final /* synthetic */ CornerType[] $VALUES = null;
    public static final CornerType DOT = null;
    public static final CornerType TEXT = null;
    private final String value;

    static {
        CornerType r1 = new CornerType("DOT", 0, "dot");
        DOT = r1;
        CornerType r2 = new CornerType("TEXT", 1, "text");
        TEXT = r2;
        $VALUES = new CornerType[]{r1, r2};
    }

    public static CornerType valueOf(String r1) {
        return (CornerType) a.a(CornerType.class, r1);
    }

    public static CornerType[] values() {
        return (CornerType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    private CornerType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
