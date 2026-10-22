package com.ss.android.lark.pb.department;

import com.google.protobuf.server.EnumOptions;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum DenyReason extends Enum<DenyReason> implements WireEnum {
    private static final /* synthetic */ DenyReason[] $VALUES = null;
    public static final ProtoAdapter<DenyReason> ADAPTER = null;
    public static final DenyReason DenyReason_Group_Chat_Control = null;
    public static final DenyReason DenyReason_Secret_Chat_Control = null;
    public static final DenyReason DenyReason_UNKNOWN = null;
    public static final EnumOptions ENUM_OPTIONS = null;
    private final int value;

    static {
        DenyReason r100 = new DenyReason("DenyReason_UNKNOWN", 0, 0);
        DenyReason_UNKNOWN = r100;
        DenyReason r101 = new DenyReason("DenyReason_Group_Chat_Control", 1, 1);
        DenyReason_Group_Chat_Control = r101;
        DenyReason r102 = new DenyReason("DenyReason_Secret_Chat_Control", 2, 2);
        DenyReason_Secret_Chat_Control = r102;
        $VALUES = new DenyReason[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(DenyReason.class);
        ENUM_OPTIONS = new EnumOptions.Builder().deprecated(Boolean.TRUE).build();
    }

    public static DenyReason[] values() {
        return (DenyReason[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DenyReason fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return DenyReason_Secret_Chat_Control;
    L12:
        return DenyReason_Group_Chat_Control;
    L14:
        return DenyReason_UNKNOWN;
    }

    public static DenyReason valueOf(String r100) {
        return (DenyReason) a.a(DenyReason.class, r100);
    }

    private DenyReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
