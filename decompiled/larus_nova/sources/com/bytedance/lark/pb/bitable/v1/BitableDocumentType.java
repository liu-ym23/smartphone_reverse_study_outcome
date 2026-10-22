package com.bytedance.lark.pb.bitable.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum BitableDocumentType extends Enum<BitableDocumentType> implements WireEnum {
    private static final /* synthetic */ BitableDocumentType[] $VALUES = null;
    public static final ProtoAdapter<BitableDocumentType> ADAPTER = null;
    public static final BitableDocumentType ADD_RECORD = null;
    public static final BitableDocumentType MAIN = null;
    public static final BitableDocumentType RECORD = null;
    private final int value;

    static {
        BitableDocumentType r100 = new BitableDocumentType(AccountType.MAIN, 0, 1);
        MAIN = r100;
        BitableDocumentType r101 = new BitableDocumentType("RECORD", 1, 2);
        RECORD = r101;
        BitableDocumentType r102 = new BitableDocumentType("ADD_RECORD", 2, 3);
        ADD_RECORD = r102;
        $VALUES = new BitableDocumentType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(BitableDocumentType.class);
    }

    public static BitableDocumentType[] values() {
        return (BitableDocumentType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static BitableDocumentType fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return ADD_RECORD;
    L13:
        return RECORD;
    L15:
        return MAIN;
    }

    public static BitableDocumentType valueOf(String r100) {
        return (BitableDocumentType) a.a(BitableDocumentType.class, r100);
    }

    private BitableDocumentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
