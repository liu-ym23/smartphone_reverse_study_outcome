package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum MoveType extends Enum<MoveType> implements WireEnum {
    private static final /* synthetic */ MoveType[] $VALUES = null;
    public static final ProtoAdapter<MoveType> ADAPTER = null;
    public static final MoveType ANTI_CONFLICT = null;
    public static final MoveType NORMAL = null;
    public static final MoveType UNKNOWN_MOVE_TYPE = null;
    public static final MoveType WHOLE = null;
    private final int value;

    static {
        MoveType r100 = new MoveType("UNKNOWN_MOVE_TYPE", 0, 0);
        UNKNOWN_MOVE_TYPE = r100;
        MoveType r101 = new MoveType(EffectConstants.NORMAL, 1, 1);
        NORMAL = r101;
        MoveType r102 = new MoveType("WHOLE", 2, 2);
        WHOLE = r102;
        MoveType r103 = new MoveType("ANTI_CONFLICT", 3, 3);
        ANTI_CONFLICT = r103;
        $VALUES = new MoveType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(MoveType.class);
    }

    public static MoveType[] values() {
        return (MoveType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MoveType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return ANTI_CONFLICT;
    L14:
        return WHOLE;
    L16:
        return NORMAL;
    L18:
        return UNKNOWN_MOVE_TYPE;
    }

    public static MoveType valueOf(String r100) {
        return (MoveType) a.a(MoveType.class, r100);
    }

    private MoveType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
