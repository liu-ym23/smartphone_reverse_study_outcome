package com.bytedance.lark.pb.openplatform.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum UniversalCardBizType extends Enum<UniversalCardBizType> implements WireEnum {
    private static final /* synthetic */ UniversalCardBizType[] $VALUES = null;
    public static final ProtoAdapter<UniversalCardBizType> ADAPTER = null;
    public static final UniversalCardBizType BIZ_TYPE_MESSAGE_CARD = null;
    public static final UniversalCardBizType BIZ_TYPE_ON_DEMAND = null;
    public static final UniversalCardBizType BIZ_TYPE_PROFILE = null;
    public static final UniversalCardBizType BIZ_TYPE_UNKNOWN = null;
    public static final UniversalCardBizType BIZ_TYPE_URL_PREVIEW = null;
    private final int value;

    static {
        UniversalCardBizType r100 = new UniversalCardBizType("BIZ_TYPE_UNKNOWN", 0, 0);
        BIZ_TYPE_UNKNOWN = r100;
        UniversalCardBizType r101 = new UniversalCardBizType("BIZ_TYPE_MESSAGE_CARD", 1, 1);
        BIZ_TYPE_MESSAGE_CARD = r101;
        UniversalCardBizType r102 = new UniversalCardBizType("BIZ_TYPE_URL_PREVIEW", 2, 2);
        BIZ_TYPE_URL_PREVIEW = r102;
        UniversalCardBizType r103 = new UniversalCardBizType("BIZ_TYPE_ON_DEMAND", 3, 3);
        BIZ_TYPE_ON_DEMAND = r103;
        UniversalCardBizType r104 = new UniversalCardBizType("BIZ_TYPE_PROFILE", 4, 4);
        BIZ_TYPE_PROFILE = r104;
        $VALUES = new UniversalCardBizType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(UniversalCardBizType.class);
    }

    public static UniversalCardBizType[] values() {
        return (UniversalCardBizType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UniversalCardBizType fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return BIZ_TYPE_PROFILE;
    L16:
        return BIZ_TYPE_ON_DEMAND;
    L18:
        return BIZ_TYPE_URL_PREVIEW;
    L20:
        return BIZ_TYPE_MESSAGE_CARD;
    L22:
        return BIZ_TYPE_UNKNOWN;
    }

    public static UniversalCardBizType valueOf(String r100) {
        return (UniversalCardBizType) a.a(UniversalCardBizType.class, r100);
    }

    private UniversalCardBizType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
