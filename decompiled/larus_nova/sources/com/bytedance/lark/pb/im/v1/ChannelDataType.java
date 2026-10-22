package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ChannelDataType extends Enum<ChannelDataType> implements WireEnum {
    private static final /* synthetic */ ChannelDataType[] $VALUES = null;
    public static final ProtoAdapter<ChannelDataType> ADAPTER = null;
    public static final ChannelDataType NORMAL_DATA = null;
    public static final ChannelDataType QUASI_DATA = null;
    private final int value;

    static {
        ChannelDataType r100 = new ChannelDataType("NORMAL_DATA", 0, 1);
        NORMAL_DATA = r100;
        ChannelDataType r101 = new ChannelDataType("QUASI_DATA", 1, 2);
        QUASI_DATA = r101;
        $VALUES = new ChannelDataType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChannelDataType.class);
    }

    public static ChannelDataType[] values() {
        return (ChannelDataType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChannelDataType fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return QUASI_DATA;
    L11:
        return NORMAL_DATA;
    }

    public static ChannelDataType valueOf(String r100) {
        return (ChannelDataType) a.a(ChannelDataType.class, r100);
    }

    private ChannelDataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
