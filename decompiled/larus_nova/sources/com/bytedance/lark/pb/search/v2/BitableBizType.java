package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum BitableBizType extends Enum<BitableBizType> implements WireEnum {
    private static final /* synthetic */ BitableBizType[] $VALUES = null;
    public static final ProtoAdapter<BitableBizType> ADAPTER = null;
    public static final BitableBizType BITABLE_BIZ_TYPE_APP = null;
    public static final BitableBizType BITABLE_BIZ_TYPE_UNKNOWN = null;
    private final int value;

    static {
        BitableBizType r100 = new BitableBizType("BITABLE_BIZ_TYPE_UNKNOWN", 0, 0);
        BITABLE_BIZ_TYPE_UNKNOWN = r100;
        BitableBizType r101 = new BitableBizType("BITABLE_BIZ_TYPE_APP", 1, 1);
        BITABLE_BIZ_TYPE_APP = r101;
        $VALUES = new BitableBizType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(BitableBizType.class);
    }

    public static BitableBizType[] values() {
        return (BitableBizType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static BitableBizType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return BITABLE_BIZ_TYPE_APP;
    L10:
        return BITABLE_BIZ_TYPE_UNKNOWN;
    }

    public static BitableBizType valueOf(String r100) {
        return (BitableBizType) a.a(BitableBizType.class, r100);
    }

    private BitableBizType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
