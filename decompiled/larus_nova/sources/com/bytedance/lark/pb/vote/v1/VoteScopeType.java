package com.bytedance.lark.pb.vote.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum VoteScopeType extends Enum<VoteScopeType> implements WireEnum {
    private static final /* synthetic */ VoteScopeType[] $VALUES = null;
    public static final ProtoAdapter<VoteScopeType> ADAPTER = null;
    public static final VoteScopeType IM_CHAT = null;
    public static final VoteScopeType UNKNOWN_SCOPE = null;
    private final int value;

    static {
        VoteScopeType r100 = new VoteScopeType("UNKNOWN_SCOPE", 0, 0);
        UNKNOWN_SCOPE = r100;
        VoteScopeType r101 = new VoteScopeType("IM_CHAT", 1, 1);
        IM_CHAT = r101;
        $VALUES = new VoteScopeType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(VoteScopeType.class);
    }

    public static VoteScopeType[] values() {
        return (VoteScopeType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static VoteScopeType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return IM_CHAT;
    L10:
        return UNKNOWN_SCOPE;
    }

    public static VoteScopeType valueOf(String r100) {
        return (VoteScopeType) a.a(VoteScopeType.class, r100);
    }

    private VoteScopeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
