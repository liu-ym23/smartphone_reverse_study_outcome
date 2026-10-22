package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum MergeFowardMessageType extends Enum<MergeFowardMessageType> implements WireEnum {
    private static final /* synthetic */ MergeFowardMessageType[] $VALUES = null;
    public static final ProtoAdapter<MergeFowardMessageType> ADAPTER = null;
    public static final MergeFowardMessageType MERGE_MESSAGE = null;
    public static final MergeFowardMessageType MERGE_THREAD = null;
    private final int value;

    static {
        MergeFowardMessageType r100 = new MergeFowardMessageType("MERGE_MESSAGE", 0, 1);
        MERGE_MESSAGE = r100;
        MergeFowardMessageType r101 = new MergeFowardMessageType("MERGE_THREAD", 1, 2);
        MERGE_THREAD = r101;
        $VALUES = new MergeFowardMessageType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(MergeFowardMessageType.class);
    }

    public static MergeFowardMessageType[] values() {
        return (MergeFowardMessageType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MergeFowardMessageType fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return MERGE_THREAD;
    L11:
        return MERGE_MESSAGE;
    }

    public static MergeFowardMessageType valueOf(String r100) {
        return (MergeFowardMessageType) a.a(MergeFowardMessageType.class, r100);
    }

    private MergeFowardMessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
