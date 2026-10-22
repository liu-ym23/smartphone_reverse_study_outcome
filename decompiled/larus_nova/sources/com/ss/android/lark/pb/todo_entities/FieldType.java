package com.ss.android.lark.pb.todo_entities;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum FieldType extends Enum<FieldType> implements WireEnum {
    private static final /* synthetic */ FieldType[] $VALUES = null;
    public static final ProtoAdapter<FieldType> ADAPTER = null;
    public static final FieldType AGENT_TASK_PROGRESS = null;
    public static final FieldType AGENT_TASK_STATUS = null;
    public static final FieldType ATTACHMENT = null;
    public static final FieldType DATETIME = null;
    public static final FieldType MEMBER = null;
    public static final FieldType MULTI_SELECT = null;
    public static final FieldType NUMBER = null;
    public static final FieldType SINGLE_SELECT = null;
    public static final FieldType SUB_TASK_PROGRESS = null;
    public static final FieldType TASK_ASSIGNEE = null;
    public static final FieldType TASK_COMPLETED_TIME = null;
    public static final FieldType TASK_COMPLETE_STATUS = null;
    public static final FieldType TASK_CONTAINER = null;
    public static final FieldType TASK_DUE_TIME = null;
    public static final FieldType TASK_NUM = null;
    public static final FieldType TASK_POINTS = null;
    public static final FieldType TASK_RELATED_LIST = null;
    public static final FieldType TASK_SECTION = null;
    public static final FieldType TASK_SOURCE = null;
    public static final FieldType TASK_SOURCE_TYPE = null;
    public static final FieldType TASK_START_TIME = null;
    public static final FieldType TASK_TITLE = null;
    public static final FieldType TEXT = null;
    public static final FieldType UNKNOWN_FIELD_TYPE = null;
    private final int value;

    static {
        FieldType r100 = new FieldType("UNKNOWN_FIELD_TYPE", 0, 0);
        UNKNOWN_FIELD_TYPE = r100;
        FieldType r101 = new FieldType("MEMBER", 1, 1);
        MEMBER = r101;
        FieldType r102 = new FieldType("DATETIME", 2, 2);
        DATETIME = r102;
        FieldType r103 = new FieldType("ATTACHMENT", 3, 3);
        ATTACHMENT = r103;
        FieldType r104 = new FieldType("NUMBER", 4, 4);
        NUMBER = r104;
        FieldType r105 = new FieldType("SINGLE_SELECT", 5, 5);
        SINGLE_SELECT = r105;
        FieldType r110 = new FieldType("MULTI_SELECT", 6, 6);
        MULTI_SELECT = r110;
        FieldType r111 = new FieldType(CardAdapter.TEXT, 7, 7);
        TEXT = r111;
        FieldType r112 = new FieldType("TASK_TITLE", 8, 100);
        TASK_TITLE = r112;
        FieldType r113 = new FieldType("TASK_DUE_TIME", 9, 101);
        TASK_DUE_TIME = r113;
        FieldType r114 = new FieldType("TASK_COMPLETED_TIME", 10, 102);
        TASK_COMPLETED_TIME = r114;
        FieldType r106 = new FieldType("SUB_TASK_PROGRESS", 11, 103);
        SUB_TASK_PROGRESS = r106;
        FieldType r107 = new FieldType("TASK_SOURCE", 12, 104);
        TASK_SOURCE = r107;
        FieldType r108 = new FieldType("TASK_SOURCE_TYPE", 13, 105);
        TASK_SOURCE_TYPE = r108;
        FieldType r109 = new FieldType("TASK_NUM", 14, 106);
        TASK_NUM = r109;
        FieldType r115 = new FieldType("TASK_SECTION", 15, 107);
        TASK_SECTION = r115;
        FieldType r116 = new FieldType("TASK_COMPLETE_STATUS", 16, 108);
        TASK_COMPLETE_STATUS = r116;
        FieldType r117 = new FieldType("TASK_ASSIGNEE", 17, 109);
        TASK_ASSIGNEE = r117;
        FieldType r118 = new FieldType("TASK_RELATED_LIST", 18, 110);
        TASK_RELATED_LIST = r118;
        FieldType r119 = new FieldType("TASK_START_TIME", 19, 111);
        TASK_START_TIME = r119;
        FieldType r120 = new FieldType("TASK_POINTS", 20, 112);
        TASK_POINTS = r120;
        FieldType r121 = new FieldType("TASK_CONTAINER", 21, 113);
        TASK_CONTAINER = r121;
        FieldType r122 = new FieldType("AGENT_TASK_STATUS", 22, 114);
        AGENT_TASK_STATUS = r122;
        FieldType r123 = new FieldType("AGENT_TASK_PROGRESS", 23, 115);
        AGENT_TASK_PROGRESS = r123;
        $VALUES = new FieldType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123};
        ADAPTER = ProtoAdapter.newEnumAdapter(FieldType.class);
    }

    public static FieldType[] values() {
        return (FieldType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FieldType fromValue(int r100) {
        switch(r100) {
            case 0: goto L53;
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L47;
            case 4: goto L45;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            default: goto L3;
        };
    L3:
        switch(r100) {
            case 100: goto L37;
            case 101: goto L35;
            case 102: goto L33;
            case 103: goto L31;
            case 104: goto L29;
            case 105: goto L27;
            case 106: goto L25;
            case 107: goto L23;
            case 108: goto L21;
            case 109: goto L19;
            case 110: goto L17;
            case 111: goto L15;
            case 112: goto L13;
            case 113: goto L11;
            case 114: goto L9;
            case 115: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return AGENT_TASK_PROGRESS;
    L9:
        return AGENT_TASK_STATUS;
    L11:
        return TASK_CONTAINER;
    L13:
        return TASK_POINTS;
    L15:
        return TASK_START_TIME;
    L17:
        return TASK_RELATED_LIST;
    L19:
        return TASK_ASSIGNEE;
    L21:
        return TASK_COMPLETE_STATUS;
    L23:
        return TASK_SECTION;
    L25:
        return TASK_NUM;
    L27:
        return TASK_SOURCE_TYPE;
    L29:
        return TASK_SOURCE;
    L31:
        return SUB_TASK_PROGRESS;
    L33:
        return TASK_COMPLETED_TIME;
    L35:
        return TASK_DUE_TIME;
    L37:
        return TASK_TITLE;
    L39:
        return TEXT;
    L41:
        return MULTI_SELECT;
    L43:
        return SINGLE_SELECT;
    L45:
        return NUMBER;
    L47:
        return ATTACHMENT;
    L49:
        return DATETIME;
    L51:
        return MEMBER;
    L53:
        return UNKNOWN_FIELD_TYPE;
    }

    public static FieldType valueOf(String r100) {
        return (FieldType) a.a(FieldType.class, r100);
    }

    private FieldType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
