package com.bytedance.lark.pb.sync.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum MsgType extends Enum<MsgType> implements WireEnum {
    private static final /* synthetic */ MsgType[] $VALUES = null;
    public static final ProtoAdapter<MsgType> ADAPTER = null;
    public static final MsgType Common = null;
    public static final MsgType Order = null;
    private final int value;

    static {
        MsgType r100 = new MsgType("Common", 0, 0);
        Common = r100;
        MsgType r101 = new MsgType("Order", 1, 1);
        Order = r101;
        $VALUES = new MsgType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(MsgType.class);
    }

    public static MsgType[] values() {
        return (MsgType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MsgType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return Order;
    L10:
        return Common;
    }

    public static MsgType valueOf(String r100) {
        return (MsgType) a.a(MsgType.class, r100);
    }

    private MsgType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
