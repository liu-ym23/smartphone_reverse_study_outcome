package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ActivityRecordKey extends Enum<ActivityRecordKey> implements WireEnum {
    private static final /* synthetic */ ActivityRecordKey[] $VALUES = null;
    public static final ProtoAdapter<ActivityRecordKey> ADAPTER = null;
    public static final ActivityRecordKey TASK_ADD_ATTACHMENTS = null;
    public static final ActivityRecordKey TASK_ADD_COMMENT = null;
    public static final ActivityRecordKey TASK_ADD_CUSTOM_FIELD_VALUE = null;
    public static final ActivityRecordKey TASK_ADD_DEPENDENT = null;
    public static final ActivityRecordKey TASK_ADD_DESCRIPTION = null;
    public static final ActivityRecordKey TASK_ADD_DUE_TIME = null;
    public static final ActivityRecordKey TASK_ADD_FOLLOWER = null;
    public static final ActivityRecordKey TASK_ADD_INTO_LIST = null;
    public static final ActivityRecordKey TASK_ADD_MILESTONE = null;
    public static final ActivityRecordKey TASK_ADD_OWNER = null;
    public static final ActivityRecordKey TASK_ADD_RRULE = null;
    public static final ActivityRecordKey TASK_COMPLETED = null;
    public static final ActivityRecordKey TASK_CREATE = null;
    public static final ActivityRecordKey TASK_DELETE = null;
    public static final ActivityRecordKey TASK_DELETE_ATTACHMENTS = null;
    public static final ActivityRecordKey TASK_DELETE_CUSTOM_FIELD_VALUE = null;
    public static final ActivityRecordKey TASK_DELETE_DESCRIPTION = null;
    public static final ActivityRecordKey TASK_DELETE_REFER_CONTEXT = null;
    public static final ActivityRecordKey TASK_LIST_ADD_ASSIGNEE = null;
    public static final ActivityRecordKey TASK_LIST_ADD_CUSTOM_FIELD = null;
    public static final ActivityRecordKey TASK_LIST_ADD_SUBSCRIBE = null;
    public static final ActivityRecordKey TASK_LIST_ARCHIVED = null;
    public static final ActivityRecordKey TASK_LIST_CREATE = null;
    public static final ActivityRecordKey TASK_LIST_CREATE_SECTION = null;
    public static final ActivityRecordKey TASK_LIST_DELETE = null;
    public static final ActivityRecordKey TASK_LIST_DELETE_ASSIGNEE = null;
    public static final ActivityRecordKey TASK_LIST_DELETE_SECTION = null;
    public static final ActivityRecordKey TASK_LIST_DELETE_SUBSCRIBE = null;
    public static final ActivityRecordKey TASK_LIST_NOT_ARCHIVED = null;
    public static final ActivityRecordKey TASK_LIST_REMOVE_CUSTOM_FIELD = null;
    public static final ActivityRecordKey TASK_LIST_RENAME = null;
    public static final ActivityRecordKey TASK_LIST_UPDATE_ASSIGNEE = null;
    public static final ActivityRecordKey TASK_LIST_UPDATE_OWNER = null;
    public static final ActivityRecordKey TASK_LIST_UPDATE_SECTION = null;
    public static final ActivityRecordKey TASK_LIST_VIEW_ADMIN_SETTING = null;
    public static final ActivityRecordKey TASK_PART_COMPLETE = null;
    public static final ActivityRecordKey TASK_PART_UNCOMPLETE = null;
    public static final ActivityRecordKey TASK_REMOVE_DEPENDENT = null;
    public static final ActivityRecordKey TASK_REMOVE_DUE_TIME = null;
    public static final ActivityRecordKey TASK_REMOVE_FOLLOWER = null;
    public static final ActivityRecordKey TASK_REMOVE_FROM_LIST = null;
    public static final ActivityRecordKey TASK_REMOVE_MILESTONE = null;
    public static final ActivityRecordKey TASK_REMOVE_OWNER = null;
    public static final ActivityRecordKey TASK_REMOVE_RRULE = null;
    public static final ActivityRecordKey TASK_REMOVE_START_AND_DUE_TIME = null;
    public static final ActivityRecordKey TASK_REMOVE_SUBTASK = null;
    public static final ActivityRecordKey TASK_REPEAT_GENERATE = null;
    public static final ActivityRecordKey TASK_REPLY_COMMENT = null;
    public static final ActivityRecordKey TASK_RESTORE = null;
    public static final ActivityRecordKey TASK_SET_ANCESTOR = null;
    public static final ActivityRecordKey TASK_SET_SUBTASK = null;
    public static final ActivityRecordKey TASK_UNCOMPLETE = null;
    public static final ActivityRecordKey TASK_UPDATE_CUSTOM_FIELD_VALUE = null;
    public static final ActivityRecordKey TASK_UPDATE_DEPENDENT = null;
    public static final ActivityRecordKey TASK_UPDATE_DESCRIPTION = null;
    public static final ActivityRecordKey TASK_UPDATE_DUE_TIME = null;
    public static final ActivityRecordKey TASK_UPDATE_OWNER = null;
    public static final ActivityRecordKey TASK_UPDATE_REMINDERS = null;
    public static final ActivityRecordKey TASK_UPDATE_RRULE = null;
    public static final ActivityRecordKey TASK_UPDATE_SINGLE_DUE_TIME = null;
    public static final ActivityRecordKey TASK_UPDATE_START_AND_DUE_TIME = null;
    public static final ActivityRecordKey TASK_UPDATE_START_TIME = null;
    public static final ActivityRecordKey TASK_UPDATE_SUMMARY = null;
    public static final ActivityRecordKey TASK_USER_ADD_FOLLOWERS = null;
    public static final ActivityRecordKey TASK_USER_REMOVE_FOLLOWERS = null;
    public static final ActivityRecordKey UNKNOWN_RECORD = null;
    private final int value;

    static {
        ActivityRecordKey r100 = new ActivityRecordKey("UNKNOWN_RECORD", 0, 0);
        UNKNOWN_RECORD = r100;
        ActivityRecordKey r101 = new ActivityRecordKey("TASK_LIST_CREATE", 1, 1);
        TASK_LIST_CREATE = r101;
        ActivityRecordKey r102 = new ActivityRecordKey("TASK_LIST_RENAME", 2, 2);
        TASK_LIST_RENAME = r102;
        ActivityRecordKey r103 = new ActivityRecordKey("TASK_LIST_DELETE", 3, 3);
        TASK_LIST_DELETE = r103;
        ActivityRecordKey r104 = new ActivityRecordKey("TASK_LIST_ARCHIVED", 4, 4);
        TASK_LIST_ARCHIVED = r104;
        ActivityRecordKey r105 = new ActivityRecordKey("TASK_LIST_NOT_ARCHIVED", 5, 5);
        TASK_LIST_NOT_ARCHIVED = r105;
        ActivityRecordKey r110 = new ActivityRecordKey("TASK_LIST_CREATE_SECTION", 6, 6);
        TASK_LIST_CREATE_SECTION = r110;
        ActivityRecordKey r111 = new ActivityRecordKey("TASK_LIST_UPDATE_SECTION", 7, 7);
        TASK_LIST_UPDATE_SECTION = r111;
        ActivityRecordKey r112 = new ActivityRecordKey("TASK_LIST_DELETE_SECTION", 8, 8);
        TASK_LIST_DELETE_SECTION = r112;
        ActivityRecordKey r113 = new ActivityRecordKey("TASK_LIST_ADD_ASSIGNEE", 9, 9);
        TASK_LIST_ADD_ASSIGNEE = r113;
        ActivityRecordKey r114 = new ActivityRecordKey("TASK_LIST_UPDATE_ASSIGNEE", 10, 10);
        TASK_LIST_UPDATE_ASSIGNEE = r114;
        ActivityRecordKey r115 = new ActivityRecordKey("TASK_LIST_DELETE_ASSIGNEE", 11, 11);
        TASK_LIST_DELETE_ASSIGNEE = r115;
        ActivityRecordKey r106 = new ActivityRecordKey("TASK_LIST_UPDATE_OWNER", 12, 12);
        TASK_LIST_UPDATE_OWNER = r106;
        ActivityRecordKey r107 = new ActivityRecordKey("TASK_LIST_ADD_SUBSCRIBE", 13, 13);
        TASK_LIST_ADD_SUBSCRIBE = r107;
        ActivityRecordKey r108 = new ActivityRecordKey("TASK_LIST_DELETE_SUBSCRIBE", 14, 14);
        TASK_LIST_DELETE_SUBSCRIBE = r108;
        ActivityRecordKey r109 = new ActivityRecordKey("TASK_LIST_ADD_CUSTOM_FIELD", 15, 15);
        TASK_LIST_ADD_CUSTOM_FIELD = r109;
        ActivityRecordKey r116 = new ActivityRecordKey("TASK_LIST_REMOVE_CUSTOM_FIELD", 16, 16);
        TASK_LIST_REMOVE_CUSTOM_FIELD = r116;
        ActivityRecordKey r117 = new ActivityRecordKey("TASK_LIST_VIEW_ADMIN_SETTING", 17, 17);
        TASK_LIST_VIEW_ADMIN_SETTING = r117;
        ActivityRecordKey r118 = new ActivityRecordKey("TASK_ADD_INTO_LIST", 18, 100);
        TASK_ADD_INTO_LIST = r118;
        ActivityRecordKey r119 = new ActivityRecordKey("TASK_REMOVE_FROM_LIST", 19, 101);
        TASK_REMOVE_FROM_LIST = r119;
        ActivityRecordKey r120 = new ActivityRecordKey("TASK_REPEAT_GENERATE", 20, 102);
        TASK_REPEAT_GENERATE = r120;
        ActivityRecordKey r121 = new ActivityRecordKey("TASK_COMPLETED", 21, 103);
        TASK_COMPLETED = r121;
        ActivityRecordKey r122 = new ActivityRecordKey("TASK_UNCOMPLETE", 22, 104);
        TASK_UNCOMPLETE = r122;
        ActivityRecordKey r123 = new ActivityRecordKey("TASK_DELETE", 23, 105);
        TASK_DELETE = r123;
        ActivityRecordKey r124 = new ActivityRecordKey("TASK_UPDATE_SUMMARY", 24, 106);
        TASK_UPDATE_SUMMARY = r124;
        ActivityRecordKey r125 = new ActivityRecordKey("TASK_ADD_DESCRIPTION", 25, 107);
        TASK_ADD_DESCRIPTION = r125;
        ActivityRecordKey r126 = new ActivityRecordKey("TASK_UPDATE_DESCRIPTION", 26, 108);
        TASK_UPDATE_DESCRIPTION = r126;
        ActivityRecordKey r127 = new ActivityRecordKey("TASK_ADD_OWNER", 27, 109);
        TASK_ADD_OWNER = r127;
        ActivityRecordKey r128 = new ActivityRecordKey("TASK_UPDATE_OWNER", 28, 110);
        TASK_UPDATE_OWNER = r128;
        ActivityRecordKey r129 = new ActivityRecordKey("TASK_REMOVE_OWNER", 29, 111);
        TASK_REMOVE_OWNER = r129;
        ActivityRecordKey r130 = new ActivityRecordKey("TASK_ADD_FOLLOWER", 30, 112);
        TASK_ADD_FOLLOWER = r130;
        ActivityRecordKey r131 = new ActivityRecordKey("TASK_ADD_DUE_TIME", 31, 113);
        TASK_ADD_DUE_TIME = r131;
        ActivityRecordKey r132 = new ActivityRecordKey("TASK_UPDATE_DUE_TIME", 32, 114);
        TASK_UPDATE_DUE_TIME = r132;
        ActivityRecordKey r133 = new ActivityRecordKey("TASK_REMOVE_DUE_TIME", 33, 115);
        TASK_REMOVE_DUE_TIME = r133;
        ActivityRecordKey r134 = new ActivityRecordKey("TASK_ADD_RRULE", 34, 116);
        TASK_ADD_RRULE = r134;
        ActivityRecordKey r135 = new ActivityRecordKey("TASK_UPDATE_RRULE", 35, 117);
        TASK_UPDATE_RRULE = r135;
        ActivityRecordKey r136 = new ActivityRecordKey("TASK_REMOVE_RRULE", 36, 118);
        TASK_REMOVE_RRULE = r136;
        ActivityRecordKey r137 = new ActivityRecordKey("TASK_ADD_ATTACHMENTS", 37, 119);
        TASK_ADD_ATTACHMENTS = r137;
        ActivityRecordKey r138 = new ActivityRecordKey("TASK_DELETE_ATTACHMENTS", 38, 120);
        TASK_DELETE_ATTACHMENTS = r138;
        ActivityRecordKey r139 = new ActivityRecordKey("TASK_ADD_COMMENT", 39, 121);
        TASK_ADD_COMMENT = r139;
        ActivityRecordKey r140 = new ActivityRecordKey("TASK_REPLY_COMMENT", 40, 122);
        TASK_REPLY_COMMENT = r140;
        ActivityRecordKey r141 = new ActivityRecordKey("TASK_RESTORE", 41, 123);
        TASK_RESTORE = r141;
        ActivityRecordKey r142 = new ActivityRecordKey("TASK_DELETE_DESCRIPTION", 42, 124);
        TASK_DELETE_DESCRIPTION = r142;
        ActivityRecordKey r143 = new ActivityRecordKey("TASK_USER_ADD_FOLLOWERS", 43, 125);
        TASK_USER_ADD_FOLLOWERS = r143;
        ActivityRecordKey r144 = new ActivityRecordKey("TASK_ADD_CUSTOM_FIELD_VALUE", 44, 126);
        TASK_ADD_CUSTOM_FIELD_VALUE = r144;
        ActivityRecordKey r145 = new ActivityRecordKey("TASK_UPDATE_CUSTOM_FIELD_VALUE", 45, 127);
        TASK_UPDATE_CUSTOM_FIELD_VALUE = r145;
        ActivityRecordKey r146 = new ActivityRecordKey("TASK_DELETE_CUSTOM_FIELD_VALUE", 46, 128);
        TASK_DELETE_CUSTOM_FIELD_VALUE = r146;
        ActivityRecordKey r147 = new ActivityRecordKey("TASK_UPDATE_START_TIME", 47, 129);
        TASK_UPDATE_START_TIME = r147;
        ActivityRecordKey r148 = new ActivityRecordKey("TASK_UPDATE_SINGLE_DUE_TIME", 48, 130);
        TASK_UPDATE_SINGLE_DUE_TIME = r148;
        ActivityRecordKey r149 = new ActivityRecordKey("TASK_UPDATE_START_AND_DUE_TIME", 49, 131);
        TASK_UPDATE_START_AND_DUE_TIME = r149;
        ActivityRecordKey r150 = new ActivityRecordKey("TASK_REMOVE_START_AND_DUE_TIME", 50, 132);
        TASK_REMOVE_START_AND_DUE_TIME = r150;
        ActivityRecordKey r151 = new ActivityRecordKey("TASK_ADD_MILESTONE", 51, 133);
        TASK_ADD_MILESTONE = r151;
        ActivityRecordKey r152 = new ActivityRecordKey("TASK_REMOVE_MILESTONE", 52, 134);
        TASK_REMOVE_MILESTONE = r152;
        ActivityRecordKey r153 = new ActivityRecordKey("TASK_ADD_DEPENDENT", 53, 135);
        TASK_ADD_DEPENDENT = r153;
        ActivityRecordKey r154 = new ActivityRecordKey("TASK_REMOVE_DEPENDENT", 54, 136);
        TASK_REMOVE_DEPENDENT = r154;
        ActivityRecordKey r155 = new ActivityRecordKey("TASK_UPDATE_DEPENDENT", 55, 137);
        TASK_UPDATE_DEPENDENT = r155;
        ActivityRecordKey r156 = new ActivityRecordKey("TASK_CREATE", 56, 138);
        TASK_CREATE = r156;
        ActivityRecordKey r157 = new ActivityRecordKey("TASK_PART_COMPLETE", 57, 139);
        TASK_PART_COMPLETE = r157;
        ActivityRecordKey r158 = new ActivityRecordKey("TASK_PART_UNCOMPLETE", 58, 140);
        TASK_PART_UNCOMPLETE = r158;
        ActivityRecordKey r159 = new ActivityRecordKey("TASK_REMOVE_FOLLOWER", 59, 141);
        TASK_REMOVE_FOLLOWER = r159;
        ActivityRecordKey r160 = new ActivityRecordKey("TASK_USER_REMOVE_FOLLOWERS", 60, 142);
        TASK_USER_REMOVE_FOLLOWERS = r160;
        ActivityRecordKey r161 = new ActivityRecordKey("TASK_UPDATE_REMINDERS", 61, 143);
        TASK_UPDATE_REMINDERS = r161;
        ActivityRecordKey r162 = new ActivityRecordKey("TASK_SET_ANCESTOR", 62, 144);
        TASK_SET_ANCESTOR = r162;
        ActivityRecordKey r163 = new ActivityRecordKey("TASK_DELETE_REFER_CONTEXT", 63, 145);
        TASK_DELETE_REFER_CONTEXT = r163;
        ActivityRecordKey r164 = new ActivityRecordKey("TASK_SET_SUBTASK", 64, 146);
        TASK_SET_SUBTASK = r164;
        ActivityRecordKey r165 = new ActivityRecordKey("TASK_REMOVE_SUBTASK", 65, 147);
        TASK_REMOVE_SUBTASK = r165;
        $VALUES = new ActivityRecordKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165};
        ADAPTER = ProtoAdapter.newEnumAdapter(ActivityRecordKey.class);
    }

    public static ActivityRecordKey[] values() {
        return (ActivityRecordKey[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ActivityRecordKey fromValue(int r100) {
        switch(r100) {
            case 0: goto L137;
            case 1: goto L135;
            case 2: goto L133;
            case 3: goto L131;
            case 4: goto L129;
            case 5: goto L127;
            case 6: goto L125;
            case 7: goto L123;
            case 8: goto L121;
            case 9: goto L119;
            case 10: goto L117;
            case 11: goto L115;
            case 12: goto L113;
            case 13: goto L111;
            case 14: goto L109;
            case 15: goto L107;
            case 16: goto L105;
            case 17: goto L103;
            default: goto L3;
        };
    L3:
        switch(r100) {
            case 100: goto L101;
            case 101: goto L99;
            case 102: goto L97;
            case 103: goto L95;
            case 104: goto L93;
            case 105: goto L91;
            case 106: goto L89;
            case 107: goto L87;
            case 108: goto L85;
            case 109: goto L83;
            case 110: goto L81;
            case 111: goto L79;
            case 112: goto L77;
            case 113: goto L75;
            case 114: goto L73;
            case 115: goto L71;
            case 116: goto L69;
            case 117: goto L67;
            case 118: goto L65;
            case 119: goto L63;
            case 120: goto L61;
            case 121: goto L59;
            case 122: goto L57;
            case 123: goto L55;
            case 124: goto L53;
            case 125: goto L51;
            case 126: goto L49;
            case 127: goto L47;
            case 128: goto L45;
            case 129: goto L43;
            case 130: goto L41;
            case 131: goto L39;
            case 132: goto L37;
            case 133: goto L35;
            case 134: goto L33;
            case 135: goto L31;
            case 136: goto L29;
            case 137: goto L27;
            case 138: goto L25;
            case 139: goto L23;
            case 140: goto L21;
            case 141: goto L19;
            case 142: goto L17;
            case 143: goto L15;
            case 144: goto L13;
            case 145: goto L11;
            case 146: goto L9;
            case 147: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return TASK_REMOVE_SUBTASK;
    L9:
        return TASK_SET_SUBTASK;
    L11:
        return TASK_DELETE_REFER_CONTEXT;
    L13:
        return TASK_SET_ANCESTOR;
    L15:
        return TASK_UPDATE_REMINDERS;
    L17:
        return TASK_USER_REMOVE_FOLLOWERS;
    L19:
        return TASK_REMOVE_FOLLOWER;
    L21:
        return TASK_PART_UNCOMPLETE;
    L23:
        return TASK_PART_COMPLETE;
    L25:
        return TASK_CREATE;
    L27:
        return TASK_UPDATE_DEPENDENT;
    L29:
        return TASK_REMOVE_DEPENDENT;
    L31:
        return TASK_ADD_DEPENDENT;
    L33:
        return TASK_REMOVE_MILESTONE;
    L35:
        return TASK_ADD_MILESTONE;
    L37:
        return TASK_REMOVE_START_AND_DUE_TIME;
    L39:
        return TASK_UPDATE_START_AND_DUE_TIME;
    L41:
        return TASK_UPDATE_SINGLE_DUE_TIME;
    L43:
        return TASK_UPDATE_START_TIME;
    L45:
        return TASK_DELETE_CUSTOM_FIELD_VALUE;
    L47:
        return TASK_UPDATE_CUSTOM_FIELD_VALUE;
    L49:
        return TASK_ADD_CUSTOM_FIELD_VALUE;
    L51:
        return TASK_USER_ADD_FOLLOWERS;
    L53:
        return TASK_DELETE_DESCRIPTION;
    L55:
        return TASK_RESTORE;
    L57:
        return TASK_REPLY_COMMENT;
    L59:
        return TASK_ADD_COMMENT;
    L61:
        return TASK_DELETE_ATTACHMENTS;
    L63:
        return TASK_ADD_ATTACHMENTS;
    L65:
        return TASK_REMOVE_RRULE;
    L67:
        return TASK_UPDATE_RRULE;
    L69:
        return TASK_ADD_RRULE;
    L71:
        return TASK_REMOVE_DUE_TIME;
    L73:
        return TASK_UPDATE_DUE_TIME;
    L75:
        return TASK_ADD_DUE_TIME;
    L77:
        return TASK_ADD_FOLLOWER;
    L79:
        return TASK_REMOVE_OWNER;
    L81:
        return TASK_UPDATE_OWNER;
    L83:
        return TASK_ADD_OWNER;
    L85:
        return TASK_UPDATE_DESCRIPTION;
    L87:
        return TASK_ADD_DESCRIPTION;
    L89:
        return TASK_UPDATE_SUMMARY;
    L91:
        return TASK_DELETE;
    L93:
        return TASK_UNCOMPLETE;
    L95:
        return TASK_COMPLETED;
    L97:
        return TASK_REPEAT_GENERATE;
    L99:
        return TASK_REMOVE_FROM_LIST;
    L101:
        return TASK_ADD_INTO_LIST;
    L103:
        return TASK_LIST_VIEW_ADMIN_SETTING;
    L105:
        return TASK_LIST_REMOVE_CUSTOM_FIELD;
    L107:
        return TASK_LIST_ADD_CUSTOM_FIELD;
    L109:
        return TASK_LIST_DELETE_SUBSCRIBE;
    L111:
        return TASK_LIST_ADD_SUBSCRIBE;
    L113:
        return TASK_LIST_UPDATE_OWNER;
    L115:
        return TASK_LIST_DELETE_ASSIGNEE;
    L117:
        return TASK_LIST_UPDATE_ASSIGNEE;
    L119:
        return TASK_LIST_ADD_ASSIGNEE;
    L121:
        return TASK_LIST_DELETE_SECTION;
    L123:
        return TASK_LIST_UPDATE_SECTION;
    L125:
        return TASK_LIST_CREATE_SECTION;
    L127:
        return TASK_LIST_NOT_ARCHIVED;
    L129:
        return TASK_LIST_ARCHIVED;
    L131:
        return TASK_LIST_DELETE;
    L133:
        return TASK_LIST_RENAME;
    L135:
        return TASK_LIST_CREATE;
    L137:
        return UNKNOWN_RECORD;
    }

    public static ActivityRecordKey valueOf(String r100) {
        return (ActivityRecordKey) a.a(ActivityRecordKey.class, r100);
    }

    private ActivityRecordKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
