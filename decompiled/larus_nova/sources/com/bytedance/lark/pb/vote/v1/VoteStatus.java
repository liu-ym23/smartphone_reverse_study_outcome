package com.bytedance.lark.pb.vote.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum VoteStatus extends Enum<VoteStatus> implements WireEnum {
    private static final /* synthetic */ VoteStatus[] $VALUES = null;
    public static final ProtoAdapter<VoteStatus> ADAPTER = null;
    public static final VoteStatus CLOSE = null;
    public static final VoteStatus OPEN = null;
    private final int value;

    static {
        VoteStatus r100 = new VoteStatus("OPEN", 0, 0);
        OPEN = r100;
        VoteStatus r101 = new VoteStatus("CLOSE", 1, 1);
        CLOSE = r101;
        $VALUES = new VoteStatus[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(VoteStatus.class);
    }

    public static VoteStatus[] values() {
        return (VoteStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static VoteStatus fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return CLOSE;
    L10:
        return OPEN;
    }

    public static VoteStatus valueOf(String r100) {
        return (VoteStatus) a.a(VoteStatus.class, r100);
    }

    private VoteStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
