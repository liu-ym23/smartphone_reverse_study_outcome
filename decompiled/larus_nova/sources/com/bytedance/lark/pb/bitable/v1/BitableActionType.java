package com.bytedance.lark.pb.bitable.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum BitableActionType extends Enum<BitableActionType> implements WireEnum {
    private static final /* synthetic */ BitableActionType[] $VALUES = null;
    public static final ProtoAdapter<BitableActionType> ADAPTER = null;
    public static final BitableActionType BASE = null;
    public static final BitableActionType TABLE = null;
    private final int value;

    static {
        BitableActionType r100 = new BitableActionType("BASE", 0, 1);
        BASE = r100;
        BitableActionType r101 = new BitableActionType("TABLE", 1, 2);
        TABLE = r101;
        $VALUES = new BitableActionType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(BitableActionType.class);
    }

    public static BitableActionType[] values() {
        return (BitableActionType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static BitableActionType fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return TABLE;
    L11:
        return BASE;
    }

    public static BitableActionType valueOf(String r100) {
        return (BitableActionType) a.a(BitableActionType.class, r100);
    }

    private BitableActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
