package com.bytedance.lark.pb.calendar.v1;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ConflictType extends Enum<ConflictType> implements WireEnum {
    private static final /* synthetic */ ConflictType[] $VALUES = null;
    public static final ProtoAdapter<ConflictType> ADAPTER = null;
    public static final ConflictType NONE = null;
    public static final ConflictType NORMAL = null;
    public static final ConflictType RECURRENCE = null;
    private final int value;

    static {
        ConflictType r100 = new ConflictType(UserProfileEvent.POSITION_NONE, 0, 1);
        NONE = r100;
        ConflictType r101 = new ConflictType(EffectConstants.NORMAL, 1, 2);
        NORMAL = r101;
        ConflictType r102 = new ConflictType("RECURRENCE", 2, 3);
        RECURRENCE = r102;
        $VALUES = new ConflictType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ConflictType.class);
    }

    public static ConflictType[] values() {
        return (ConflictType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ConflictType fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return RECURRENCE;
    L13:
        return NORMAL;
    L15:
        return NONE;
    }

    public static ConflictType valueOf(String r100) {
        return (ConflictType) a.a(ConflictType.class, r100);
    }

    private ConflictType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
