package com.bytedance.lark.pb.vote.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum VoteMessageType extends Enum<VoteMessageType> implements WireEnum {
    private static final /* synthetic */ VoteMessageType[] $VALUES = null;
    public static final ProtoAdapter<VoteMessageType> ADAPTER = null;
    public static final VoteMessageType GROUP = null;
    public static final VoteMessageType INITIATOR = null;
    public static final VoteMessageType UNKNOWN = null;
    private final int value;

    static {
        VoteMessageType r100 = new VoteMessageType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        VoteMessageType r101 = new VoteMessageType("GROUP", 1, 1);
        GROUP = r101;
        VoteMessageType r102 = new VoteMessageType("INITIATOR", 2, 2);
        INITIATOR = r102;
        $VALUES = new VoteMessageType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(VoteMessageType.class);
    }

    public static VoteMessageType[] values() {
        return (VoteMessageType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static VoteMessageType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return INITIATOR;
    L12:
        return GROUP;
    L14:
        return UNKNOWN;
    }

    public static VoteMessageType valueOf(String r100) {
        return (VoteMessageType) a.a(VoteMessageType.class, r100);
    }

    private VoteMessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
