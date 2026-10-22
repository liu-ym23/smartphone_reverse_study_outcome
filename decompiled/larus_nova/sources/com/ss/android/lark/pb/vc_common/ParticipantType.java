package com.ss.android.lark.pb.vc_common;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ParticipantType extends Enum<ParticipantType> implements WireEnum {
    private static final /* synthetic */ ParticipantType[] $VALUES = null;
    public static final ProtoAdapter<ParticipantType> ADAPTER = null;
    public static final ParticipantType DOC_USER = null;
    public static final ParticipantType LARK_USER = null;
    public static final ParticipantType NEO_GUEST_USER = null;
    public static final ParticipantType NEO_USER = null;
    public static final ParticipantType PSTN_USER = null;
    public static final ParticipantType RESERVED_USER_10 = null;
    public static final ParticipantType RESERVED_USER_11 = null;
    public static final ParticipantType RESERVED_USER_12 = null;
    public static final ParticipantType RESERVED_USER_13 = null;
    public static final ParticipantType RESERVED_USER_14 = null;
    public static final ParticipantType RESERVED_USER_15 = null;
    public static final ParticipantType RESERVED_USER_16 = null;
    public static final ParticipantType RESERVED_USER_17 = null;
    public static final ParticipantType RESERVED_USER_18 = null;
    public static final ParticipantType RESERVED_USER_19 = null;
    public static final ParticipantType RESERVED_USER_2 = null;
    public static final ParticipantType RESERVED_USER_20 = null;
    public static final ParticipantType RESERVED_USER_3 = null;
    public static final ParticipantType RESERVED_USER_5 = null;
    public static final ParticipantType RESERVED_USER_6 = null;
    public static final ParticipantType RESERVED_USER_7 = null;
    public static final ParticipantType RESERVED_USER_8 = null;
    public static final ParticipantType RESERVED_USER_9 = null;
    public static final ParticipantType ROOM = null;
    public static final ParticipantType SHAREBOX_USER = null;
    public static final ParticipantType SIP_USER = null;
    public static final ParticipantType STANDALONE_VC_USER = null;
    public static final ParticipantType UNKNOW = null;
    private final int value;

    static {
        ParticipantType r100 = new ParticipantType("UNKNOW", 0, 0);
        UNKNOW = r100;
        ParticipantType r101 = new ParticipantType("LARK_USER", 1, 1);
        LARK_USER = r101;
        ParticipantType r102 = new ParticipantType("ROOM", 2, 2);
        ROOM = r102;
        ParticipantType r103 = new ParticipantType("DOC_USER", 3, 3);
        DOC_USER = r103;
        ParticipantType r104 = new ParticipantType("NEO_USER", 4, 4);
        NEO_USER = r104;
        ParticipantType r105 = new ParticipantType("NEO_GUEST_USER", 5, 5);
        NEO_GUEST_USER = r105;
        ParticipantType r110 = new ParticipantType("PSTN_USER", 6, 6);
        PSTN_USER = r110;
        ParticipantType r111 = new ParticipantType("SIP_USER", 7, 7);
        SIP_USER = r111;
        ParticipantType r112 = new ParticipantType("SHAREBOX_USER", 8, 8);
        SHAREBOX_USER = r112;
        ParticipantType r113 = new ParticipantType("RESERVED_USER_2", 9, 9);
        RESERVED_USER_2 = r113;
        ParticipantType r114 = new ParticipantType("RESERVED_USER_3", 10, 10);
        RESERVED_USER_3 = r114;
        ParticipantType r115 = new ParticipantType("STANDALONE_VC_USER", 11, 11);
        STANDALONE_VC_USER = r115;
        ParticipantType r106 = new ParticipantType("RESERVED_USER_5", 12, 12);
        RESERVED_USER_5 = r106;
        ParticipantType r107 = new ParticipantType("RESERVED_USER_6", 13, 13);
        RESERVED_USER_6 = r107;
        ParticipantType r108 = new ParticipantType("RESERVED_USER_7", 14, 14);
        RESERVED_USER_7 = r108;
        ParticipantType r109 = new ParticipantType("RESERVED_USER_8", 15, 15);
        RESERVED_USER_8 = r109;
        ParticipantType r116 = new ParticipantType("RESERVED_USER_9", 16, 16);
        RESERVED_USER_9 = r116;
        ParticipantType r117 = new ParticipantType("RESERVED_USER_10", 17, 17);
        RESERVED_USER_10 = r117;
        ParticipantType r118 = new ParticipantType("RESERVED_USER_11", 18, 18);
        RESERVED_USER_11 = r118;
        ParticipantType r119 = new ParticipantType("RESERVED_USER_12", 19, 19);
        RESERVED_USER_12 = r119;
        ParticipantType r120 = new ParticipantType("RESERVED_USER_13", 20, 20);
        RESERVED_USER_13 = r120;
        ParticipantType r121 = new ParticipantType("RESERVED_USER_14", 21, 21);
        RESERVED_USER_14 = r121;
        ParticipantType r122 = new ParticipantType("RESERVED_USER_15", 22, 22);
        RESERVED_USER_15 = r122;
        ParticipantType r123 = new ParticipantType("RESERVED_USER_16", 23, 23);
        RESERVED_USER_16 = r123;
        ParticipantType r124 = new ParticipantType("RESERVED_USER_17", 24, 24);
        RESERVED_USER_17 = r124;
        ParticipantType r125 = new ParticipantType("RESERVED_USER_18", 25, 25);
        RESERVED_USER_18 = r125;
        ParticipantType r126 = new ParticipantType("RESERVED_USER_19", 26, 26);
        RESERVED_USER_19 = r126;
        ParticipantType r127 = new ParticipantType("RESERVED_USER_20", 27, 27);
        RESERVED_USER_20 = r127;
        $VALUES = new ParticipantType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
        ADAPTER = ProtoAdapter.newEnumAdapter(ParticipantType.class);
    }

    public static ParticipantType[] values() {
        return (ParticipantType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ParticipantType fromValue(int r100) {
        switch(r100) {
            case 0: goto L60;
            case 1: goto L58;
            case 2: goto L56;
            case 3: goto L54;
            case 4: goto L52;
            case 5: goto L50;
            case 6: goto L48;
            case 7: goto L46;
            case 8: goto L44;
            case 9: goto L42;
            case 10: goto L40;
            case 11: goto L38;
            case 12: goto L36;
            case 13: goto L34;
            case 14: goto L32;
            case 15: goto L30;
            case 16: goto L28;
            case 17: goto L26;
            case 18: goto L24;
            case 19: goto L22;
            case 20: goto L20;
            case 21: goto L18;
            case 22: goto L16;
            case 23: goto L14;
            case 24: goto L12;
            case 25: goto L10;
            case 26: goto L8;
            case 27: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return RESERVED_USER_20;
    L8:
        return RESERVED_USER_19;
    L10:
        return RESERVED_USER_18;
    L12:
        return RESERVED_USER_17;
    L14:
        return RESERVED_USER_16;
    L16:
        return RESERVED_USER_15;
    L18:
        return RESERVED_USER_14;
    L20:
        return RESERVED_USER_13;
    L22:
        return RESERVED_USER_12;
    L24:
        return RESERVED_USER_11;
    L26:
        return RESERVED_USER_10;
    L28:
        return RESERVED_USER_9;
    L30:
        return RESERVED_USER_8;
    L32:
        return RESERVED_USER_7;
    L34:
        return RESERVED_USER_6;
    L36:
        return RESERVED_USER_5;
    L38:
        return STANDALONE_VC_USER;
    L40:
        return RESERVED_USER_3;
    L42:
        return RESERVED_USER_2;
    L44:
        return SHAREBOX_USER;
    L46:
        return SIP_USER;
    L48:
        return PSTN_USER;
    L50:
        return NEO_GUEST_USER;
    L52:
        return NEO_USER;
    L54:
        return DOC_USER;
    L56:
        return ROOM;
    L58:
        return LARK_USER;
    L60:
        return UNKNOW;
    }

    public static ParticipantType valueOf(String r100) {
        return (ParticipantType) a.a(ParticipantType.class, r100);
    }

    private ParticipantType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
