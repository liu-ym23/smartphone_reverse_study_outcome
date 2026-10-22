package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum SubChatterType extends Enum<SubChatterType> implements WireEnum {
    private static final /* synthetic */ SubChatterType[] $VALUES = null;
    public static final ProtoAdapter<SubChatterType> ADAPTER = null;
    public static final SubChatterType AI_COMMON = null;
    public static final SubChatterType BOT_COMMON = null;
    public static final SubChatterType DOUBAO_COMMON = null;
    public static final SubChatterType UNKNOWN_SUB_CHATTER = null;
    public static final SubChatterType USER_AGENT_EMPLOYEE = null;
    public static final SubChatterType USER_ANONYMOUS = null;
    public static final SubChatterType USER_COMMON = null;
    private final int value;

    static {
        SubChatterType r100 = new SubChatterType("UNKNOWN_SUB_CHATTER", 0, 0);
        UNKNOWN_SUB_CHATTER = r100;
        SubChatterType r101 = new SubChatterType("USER_COMMON", 1, 10001);
        USER_COMMON = r101;
        SubChatterType r102 = new SubChatterType("USER_ANONYMOUS", 2, 10002);
        USER_ANONYMOUS = r102;
        SubChatterType r103 = new SubChatterType("USER_AGENT_EMPLOYEE", 3, 10003);
        USER_AGENT_EMPLOYEE = r103;
        SubChatterType r104 = new SubChatterType("BOT_COMMON", 4, 20001);
        BOT_COMMON = r104;
        SubChatterType r105 = new SubChatterType("AI_COMMON", 5, 30001);
        AI_COMMON = r105;
        SubChatterType r110 = new SubChatterType("DOUBAO_COMMON", 6, 40001);
        DOUBAO_COMMON = r110;
        $VALUES = new SubChatterType[]{r100, r101, r102, r103, r104, r105, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(SubChatterType.class);
    }

    public static SubChatterType[] values() {
        return (SubChatterType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SubChatterType fromValue(int r100) {
        if (r100 == 0) goto L25;
        if (r100 == 20001) goto L23;
        if (r100 == 30001) goto L21;
        if (r100 == 40001) goto L19;
        switch(r100) {
            case 10001: goto L17;
            case 10002: goto L15;
            case 10003: goto L13;
            default: goto L10;
        };
    L10:
        return null;
    L13:
        return USER_AGENT_EMPLOYEE;
    L15:
        return USER_ANONYMOUS;
    L17:
        return USER_COMMON;
    L19:
        return DOUBAO_COMMON;
    L21:
        return AI_COMMON;
    L23:
        return BOT_COMMON;
    L25:
        return UNKNOWN_SUB_CHATTER;
    }

    public static SubChatterType valueOf(String r100) {
        return (SubChatterType) a.a(SubChatterType.class, r100);
    }

    private SubChatterType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
