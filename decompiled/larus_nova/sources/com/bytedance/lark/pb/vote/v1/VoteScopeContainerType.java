package com.bytedance.lark.pb.vote.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum VoteScopeContainerType extends Enum<VoteScopeContainerType> implements WireEnum {
    private static final /* synthetic */ VoteScopeContainerType[] $VALUES = null;
    public static final ProtoAdapter<VoteScopeContainerType> ADAPTER = null;
    public static final VoteScopeContainerType IM_CHAT_IM_MESSAGE = null;
    public static final VoteScopeContainerType UNKNOWN_SCOPE_CONTAINER = null;
    private final int value;

    static {
        VoteScopeContainerType r100 = new VoteScopeContainerType("UNKNOWN_SCOPE_CONTAINER", 0, 0);
        UNKNOWN_SCOPE_CONTAINER = r100;
        VoteScopeContainerType r101 = new VoteScopeContainerType("IM_CHAT_IM_MESSAGE", 1, 1);
        IM_CHAT_IM_MESSAGE = r101;
        $VALUES = new VoteScopeContainerType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(VoteScopeContainerType.class);
    }

    public static VoteScopeContainerType[] values() {
        return (VoteScopeContainerType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static VoteScopeContainerType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return IM_CHAT_IM_MESSAGE;
    L10:
        return UNKNOWN_SCOPE_CONTAINER;
    }

    public static VoteScopeContainerType valueOf(String r100) {
        return (VoteScopeContainerType) a.a(VoteScopeContainerType.class, r100);
    }

    private VoteScopeContainerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
