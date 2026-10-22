package com.ss.android.lark.pb.department;

import com.google.protobuf.server.EnumOptions;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ActionType extends Enum<ActionType> implements WireEnum {
    private static final /* synthetic */ ActionType[] $VALUES = null;
    public static final ProtoAdapter<ActionType> ADAPTER = null;
    public static final ActionType ActionType_Group_Chat = null;
    public static final ActionType ActionType_Secret_Group_Chat = null;
    public static final ActionType ActionType_UNKNOWN = null;
    public static final EnumOptions ENUM_OPTIONS = null;
    private final int value;

    static {
        ActionType r100 = new ActionType("ActionType_UNKNOWN", 0, 0);
        ActionType_UNKNOWN = r100;
        ActionType r101 = new ActionType("ActionType_Group_Chat", 1, 1);
        ActionType_Group_Chat = r101;
        ActionType r102 = new ActionType("ActionType_Secret_Group_Chat", 2, 2);
        ActionType_Secret_Group_Chat = r102;
        $VALUES = new ActionType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ActionType.class);
        ENUM_OPTIONS = new EnumOptions.Builder().deprecated(Boolean.TRUE).build();
    }

    public static ActionType[] values() {
        return (ActionType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ActionType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return ActionType_Secret_Group_Chat;
    L12:
        return ActionType_Group_Chat;
    L14:
        return ActionType_UNKNOWN;
    }

    public static ActionType valueOf(String r100) {
        return (ActionType) a.a(ActionType.class, r100);
    }

    private ActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
