package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum FollowUpFrom extends Enum<FollowUpFrom> implements WireEnum {
    private static final /* synthetic */ FollowUpFrom[] $VALUES = null;
    public static final ProtoAdapter<FollowUpFrom> ADAPTER = null;
    public static final FollowUpFrom OneParty = null;
    public static final FollowUpFrom Tripartite = null;
    private final int value;

    static {
        FollowUpFrom r100 = new FollowUpFrom("OneParty", 0, 1);
        OneParty = r100;
        FollowUpFrom r101 = new FollowUpFrom("Tripartite", 1, 3);
        Tripartite = r101;
        $VALUES = new FollowUpFrom[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(FollowUpFrom.class);
    }

    public static FollowUpFrom[] values() {
        return (FollowUpFrom[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FollowUpFrom fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 3) goto L9;
        return null;
    L9:
        return Tripartite;
    L11:
        return OneParty;
    }

    public static FollowUpFrom valueOf(String r100) {
        return (FollowUpFrom) a.a(FollowUpFrom.class, r100);
    }

    private FollowUpFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
