package com.bytedance.lark.pb.vote.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum VoteContainerType extends Enum<VoteContainerType> implements WireEnum {
    private static final /* synthetic */ VoteContainerType[] $VALUES = null;
    public static final ProtoAdapter<VoteContainerType> ADAPTER = null;
    public static final VoteContainerType IM_MESSAGE = null;
    public static final VoteContainerType UNKNOWN_CONTAINER = null;
    private final int value;

    static {
        VoteContainerType r100 = new VoteContainerType("UNKNOWN_CONTAINER", 0, 0);
        UNKNOWN_CONTAINER = r100;
        VoteContainerType r101 = new VoteContainerType("IM_MESSAGE", 1, 1);
        IM_MESSAGE = r101;
        $VALUES = new VoteContainerType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(VoteContainerType.class);
    }

    public static VoteContainerType[] values() {
        return (VoteContainerType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static VoteContainerType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return IM_MESSAGE;
    L10:
        return UNKNOWN_CONTAINER;
    }

    public static VoteContainerType valueOf(String r100) {
        return (VoteContainerType) a.a(VoteContainerType.class, r100);
    }

    private VoteContainerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
