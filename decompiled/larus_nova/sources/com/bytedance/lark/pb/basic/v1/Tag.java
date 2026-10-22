package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum Tag extends Enum<Tag> implements WireEnum {
    private static final /* synthetic */ Tag[] $VALUES = null;
    public static final ProtoAdapter<Tag> ADAPTER = null;
    public static final Tag APPROVAL = null;
    public static final Tag B2B_TAG = null;
    public static final Tag BOT = null;
    public static final Tag DELETED = null;
    public static final Tag DEPARTMENT = null;
    public static final Tag EDU = null;
    public static final Tag EXTERNAL = null;
    public static final Tag FROZEN = null;
    public static final Tag GROUP_ADMIN = null;
    public static final Tag MEETING = null;
    public static final Tag OFFICIAL = null;
    public static final Tag OFFLINE = null;
    public static final Tag ONCALL_OFFLINE = null;
    public static final Tag ON_CALL = null;
    public static final Tag PUBLIC = null;
    public static final Tag RELATION_TAG_INFO = null;
    public static final Tag SECRET_CHAT = null;
    public static final Tag STOPPED = null;
    public static final Tag SUPERVISOR = null;
    public static final Tag UNACTIVATED = null;
    public static final Tag UNKNOWN_TAG = null;
    public static final Tag USER_RESIGNED = null;
    public static final Tag WHOLE = null;
    private final int value;

    static {
        Tag r100 = new Tag("UNKNOWN_TAG", 0, 0);
        UNKNOWN_TAG = r100;
        Tag r101 = new Tag("OFFICIAL", 1, 1);
        OFFICIAL = r101;
        Tag r102 = new Tag("ON_CALL", 2, 2);
        ON_CALL = r102;
        Tag r103 = new Tag("BOT", 3, 3);
        BOT = r103;
        Tag r104 = new Tag("MEETING", 4, 4);
        MEETING = r104;
        Tag r105 = new Tag("APPROVAL", 5, 5);
        APPROVAL = r105;
        Tag r110 = new Tag("SECRET_CHAT", 6, 6);
        SECRET_CHAT = r110;
        Tag r111 = new Tag("WHOLE", 7, 7);
        WHOLE = r111;
        Tag r112 = new Tag("DEPARTMENT", 8, 8);
        DEPARTMENT = r112;
        Tag r113 = new Tag("EXTERNAL", 9, 9);
        EXTERNAL = r113;
        Tag r114 = new Tag("PUBLIC", 10, 10);
        PUBLIC = r114;
        Tag r115 = new Tag("GROUP_ADMIN", 11, 11);
        GROUP_ADMIN = r115;
        Tag r106 = new Tag("SUPERVISOR", 12, 12);
        SUPERVISOR = r106;
        Tag r107 = new Tag("STOPPED", 13, 13);
        STOPPED = r107;
        Tag r108 = new Tag("OFFLINE", 14, 14);
        OFFLINE = r108;
        Tag r109 = new Tag("DELETED", 15, 15);
        DELETED = r109;
        Tag r116 = new Tag("UNACTIVATED", 16, 16);
        UNACTIVATED = r116;
        Tag r117 = new Tag("EDU", 17, 17);
        EDU = r117;
        Tag r118 = new Tag("FROZEN", 18, 18);
        FROZEN = r118;
        Tag r119 = new Tag("RELATION_TAG_INFO", 19, 19);
        RELATION_TAG_INFO = r119;
        Tag r120 = new Tag("B2B_TAG", 20, 20);
        B2B_TAG = r120;
        Tag r121 = new Tag("USER_RESIGNED", 21, 21);
        USER_RESIGNED = r121;
        Tag r122 = new Tag("ONCALL_OFFLINE", 22, 100);
        ONCALL_OFFLINE = r122;
        $VALUES = new Tag[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122};
        ADAPTER = ProtoAdapter.newEnumAdapter(Tag.class);
    }

    public static Tag[] values() {
        return (Tag[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static Tag fromValue(int r100) {
        if (r100 == 100) goto L52;
        switch(r100) {
            case 0: goto L50;
            case 1: goto L48;
            case 2: goto L46;
            case 3: goto L44;
            case 4: goto L42;
            case 5: goto L40;
            case 6: goto L38;
            case 7: goto L36;
            case 8: goto L34;
            case 9: goto L32;
            case 10: goto L30;
            case 11: goto L28;
            case 12: goto L26;
            case 13: goto L24;
            case 14: goto L22;
            case 15: goto L20;
            case 16: goto L18;
            case 17: goto L16;
            case 18: goto L14;
            case 19: goto L12;
            case 20: goto L10;
            case 21: goto L8;
            default: goto L5;
        };
    L5:
        return null;
    L8:
        return USER_RESIGNED;
    L10:
        return B2B_TAG;
    L12:
        return RELATION_TAG_INFO;
    L14:
        return FROZEN;
    L16:
        return EDU;
    L18:
        return UNACTIVATED;
    L20:
        return DELETED;
    L22:
        return OFFLINE;
    L24:
        return STOPPED;
    L26:
        return SUPERVISOR;
    L28:
        return GROUP_ADMIN;
    L30:
        return PUBLIC;
    L32:
        return EXTERNAL;
    L34:
        return DEPARTMENT;
    L36:
        return WHOLE;
    L38:
        return SECRET_CHAT;
    L40:
        return APPROVAL;
    L42:
        return MEETING;
    L44:
        return BOT;
    L46:
        return ON_CALL;
    L48:
        return OFFICIAL;
    L50:
        return UNKNOWN_TAG;
    L52:
        return ONCALL_OFFLINE;
    }

    public static Tag valueOf(String r100) {
        return (Tag) a.a(Tag.class, r100);
    }

    private Tag(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
