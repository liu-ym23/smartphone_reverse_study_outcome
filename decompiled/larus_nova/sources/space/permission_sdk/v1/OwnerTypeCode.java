package space.permission_sdk.v1;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum OwnerTypeCode extends Enum<OwnerTypeCode> implements WireEnum {
    private static final /* synthetic */ OwnerTypeCode[] $VALUES = null;
    public static final ProtoAdapter<OwnerTypeCode> ADAPTER = null;
    public static final OwnerTypeCode APP = null;
    public static final OwnerTypeCode ASSIGN_GROUP = null;
    public static final OwnerTypeCode AUTOSHARE_DEPARTMENT = null;
    public static final OwnerTypeCode BASE_GLOBAL_USER_GROUP = null;
    public static final OwnerTypeCode BASE_GLOBAL_WORK_SPACE_ADMIN = null;
    public static final OwnerTypeCode BASE_GLOBAL_WORK_SPACE_FELLOW = null;
    public static final OwnerTypeCode BASE_GLOBAL_WORK_SPACE_OUTLIER = null;
    public static final OwnerTypeCode BEAR_OBJECT = null;
    public static final OwnerTypeCode CALENDER_EVENT = null;
    public static final OwnerTypeCode COMPANY = null;
    public static final OwnerTypeCode DEPARTMENT = null;
    public static final OwnerTypeCode DYNAMIC_GROUP = null;
    public static final OwnerTypeCode EFFECTIVE_MEETING_GROUP = null;
    public static final OwnerTypeCode EMAIL = null;
    public static final OwnerTypeCode FOLDER = null;
    public static final OwnerTypeCode HOST_DOC = null;
    public static final OwnerTypeCode LARK_CHAT = null;
    public static final OwnerTypeCode LARK_CHAT_WHITE_LIST = null;
    public static final OwnerTypeCode LARK_USER = null;
    public static final OwnerTypeCode LEADER_ROLE = null;
    public static final OwnerTypeCode LINK_ANYONE_EDIT = null;
    public static final OwnerTypeCode LINK_ANYONE_EDIT_WITH_PASSWORD = null;
    public static final OwnerTypeCode LINK_ANYONE_PASSWORD = null;
    public static final OwnerTypeCode LINK_ANYONE_VIEW = null;
    public static final OwnerTypeCode LINK_ANYONE_VIEW_WITH_PASSWORD = null;
    public static final OwnerTypeCode LINK_TENANT_EDIT = null;
    public static final OwnerTypeCode LINK_TENANT_VIEW = null;
    public static final OwnerTypeCode MAIL_GROUP = null;
    public static final OwnerTypeCode MEEGO_PROJECT = null;
    public static final OwnerTypeCode MEEGO_WORKITEM = null;
    public static final OwnerTypeCode MEETING_GROUP = null;
    public static final OwnerTypeCode MEETING_SPACE = null;
    public static final OwnerTypeCode NEW_WIKI_ADMIN = null;
    public static final OwnerTypeCode NEW_WIKI_MEMBER = null;
    public static final OwnerTypeCode NEW_WIKI_MEMBER_GROUP = null;
    public static final OwnerTypeCode OTHER = null;
    public static final OwnerTypeCode PHOENIX_ADMIN = null;
    public static final OwnerTypeCode PHOENIX_MEMBER = null;
    public static final OwnerTypeCode PUBLIC = null;
    public static final OwnerTypeCode PUBLIC_ALL = null;
    public static final OwnerTypeCode SETTING = null;
    public static final OwnerTypeCode SHARED_MAILBOX = null;
    public static final OwnerTypeCode SHARE_FOLDER = null;
    public static final OwnerTypeCode SHARE_SPACE = null;
    public static final OwnerTypeCode TEAM_SPACE_ROOT = null;
    public static final OwnerTypeCode TEMP_USER = null;
    public static final OwnerTypeCode USER = null;
    public static final OwnerTypeCode WIKI_AREA_GROUP = null;
    public static final OwnerTypeCode WIKI_SPACE = null;
    private final int value;

    static {
        OwnerTypeCode r100 = new OwnerTypeCode(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0, 0);
        USER = r100;
        OwnerTypeCode r101 = new OwnerTypeCode("LARK_USER", 1, 1);
        LARK_USER = r101;
        OwnerTypeCode r102 = new OwnerTypeCode("LARK_CHAT", 2, 2);
        LARK_CHAT = r102;
        OwnerTypeCode r103 = new OwnerTypeCode("COMPANY", 3, 3);
        COMPANY = r103;
        OwnerTypeCode r104 = new OwnerTypeCode("PUBLIC", 4, 4);
        PUBLIC = r104;
        OwnerTypeCode r105 = new OwnerTypeCode("SHARE_SPACE", 5, 5);
        SHARE_SPACE = r105;
        OwnerTypeCode r110 = new OwnerTypeCode("PUBLIC_ALL", 6, 6);
        PUBLIC_ALL = r110;
        OwnerTypeCode r111 = new OwnerTypeCode("LARK_CHAT_WHITE_LIST", 7, 7);
        LARK_CHAT_WHITE_LIST = r111;
        OwnerTypeCode r112 = new OwnerTypeCode("CALENDER_EVENT", 8, 9);
        CALENDER_EVENT = r112;
        OwnerTypeCode r113 = new OwnerTypeCode("WIKI_SPACE", 9, 10);
        WIKI_SPACE = r113;
        OwnerTypeCode r114 = new OwnerTypeCode("FOLDER", 10, 11);
        FOLDER = r114;
        OwnerTypeCode r115 = new OwnerTypeCode("BEAR_OBJECT", 11, 12);
        BEAR_OBJECT = r115;
        OwnerTypeCode r106 = new OwnerTypeCode("SETTING", 12, 13);
        SETTING = r106;
        OwnerTypeCode r107 = new OwnerTypeCode("MEETING_GROUP", 13, 14);
        MEETING_GROUP = r107;
        OwnerTypeCode r108 = new OwnerTypeCode("MEETING_SPACE", 14, 15);
        MEETING_SPACE = r108;
        OwnerTypeCode r109 = new OwnerTypeCode("WIKI_AREA_GROUP", 15, 16);
        WIKI_AREA_GROUP = r109;
        OwnerTypeCode r116 = new OwnerTypeCode("TEMP_USER", 16, 17);
        TEMP_USER = r116;
        OwnerTypeCode r117 = new OwnerTypeCode("DEPARTMENT", 17, 18);
        DEPARTMENT = r117;
        OwnerTypeCode r118 = new OwnerTypeCode("APP", 18, 19);
        APP = r118;
        OwnerTypeCode r119 = new OwnerTypeCode("TEAM_SPACE_ROOT", 19, 20);
        TEAM_SPACE_ROOT = r119;
        OwnerTypeCode r120 = new OwnerTypeCode("SHARE_FOLDER", 20, 21);
        SHARE_FOLDER = r120;
        OwnerTypeCode r121 = new OwnerTypeCode("DYNAMIC_GROUP", 21, 22);
        DYNAMIC_GROUP = r121;
        OwnerTypeCode r122 = new OwnerTypeCode("NEW_WIKI_ADMIN", 22, 23);
        NEW_WIKI_ADMIN = r122;
        OwnerTypeCode r123 = new OwnerTypeCode("NEW_WIKI_MEMBER", 23, 24);
        NEW_WIKI_MEMBER = r123;
        OwnerTypeCode r124 = new OwnerTypeCode("PHOENIX_ADMIN", 24, 26);
        PHOENIX_ADMIN = r124;
        OwnerTypeCode r125 = new OwnerTypeCode("PHOENIX_MEMBER", 25, 27);
        PHOENIX_MEMBER = r125;
        OwnerTypeCode r126 = new OwnerTypeCode("NEW_WIKI_MEMBER_GROUP", 26, 28);
        NEW_WIKI_MEMBER_GROUP = r126;
        OwnerTypeCode r127 = new OwnerTypeCode(CommonConstant.RETKEY.EMAIL, 27, 29);
        EMAIL = r127;
        OwnerTypeCode r128 = new OwnerTypeCode("ASSIGN_GROUP", 28, 30);
        ASSIGN_GROUP = r128;
        OwnerTypeCode r129 = new OwnerTypeCode("MAIL_GROUP", 29, 31);
        MAIL_GROUP = r129;
        OwnerTypeCode r130 = new OwnerTypeCode("SHARED_MAILBOX", 30, 32);
        SHARED_MAILBOX = r130;
        OwnerTypeCode r131 = new OwnerTypeCode("MEEGO_PROJECT", 31, 33);
        MEEGO_PROJECT = r131;
        OwnerTypeCode r132 = new OwnerTypeCode("MEEGO_WORKITEM", 32, 34);
        MEEGO_WORKITEM = r132;
        OwnerTypeCode r133 = new OwnerTypeCode("EFFECTIVE_MEETING_GROUP", 33, 35);
        EFFECTIVE_MEETING_GROUP = r133;
        OwnerTypeCode r134 = new OwnerTypeCode("BASE_GLOBAL_WORK_SPACE_ADMIN", 34, 36);
        BASE_GLOBAL_WORK_SPACE_ADMIN = r134;
        OwnerTypeCode r135 = new OwnerTypeCode("BASE_GLOBAL_WORK_SPACE_FELLOW", 35, 37);
        BASE_GLOBAL_WORK_SPACE_FELLOW = r135;
        OwnerTypeCode r136 = new OwnerTypeCode("BASE_GLOBAL_WORK_SPACE_OUTLIER", 36, 38);
        BASE_GLOBAL_WORK_SPACE_OUTLIER = r136;
        OwnerTypeCode r137 = new OwnerTypeCode("BASE_GLOBAL_USER_GROUP", 37, 39);
        BASE_GLOBAL_USER_GROUP = r137;
        OwnerTypeCode r138 = new OwnerTypeCode("LINK_TENANT_VIEW", 38, 100);
        LINK_TENANT_VIEW = r138;
        OwnerTypeCode r139 = new OwnerTypeCode("LINK_TENANT_EDIT", 39, 101);
        LINK_TENANT_EDIT = r139;
        OwnerTypeCode r140 = new OwnerTypeCode("LINK_ANYONE_VIEW", 40, 102);
        LINK_ANYONE_VIEW = r140;
        OwnerTypeCode r141 = new OwnerTypeCode("LINK_ANYONE_EDIT", 41, 103);
        LINK_ANYONE_EDIT = r141;
        OwnerTypeCode r142 = new OwnerTypeCode("LINK_ANYONE_VIEW_WITH_PASSWORD", 42, 104);
        LINK_ANYONE_VIEW_WITH_PASSWORD = r142;
        OwnerTypeCode r143 = new OwnerTypeCode("LINK_ANYONE_EDIT_WITH_PASSWORD", 43, 105);
        LINK_ANYONE_EDIT_WITH_PASSWORD = r143;
        OwnerTypeCode r144 = new OwnerTypeCode("LINK_ANYONE_PASSWORD", 44, 106);
        LINK_ANYONE_PASSWORD = r144;
        OwnerTypeCode r145 = new OwnerTypeCode(FlowDoraWifiScene.OTHER, 45, 107);
        OTHER = r145;
        OwnerTypeCode r146 = new OwnerTypeCode("AUTOSHARE_DEPARTMENT", 46, 108);
        AUTOSHARE_DEPARTMENT = r146;
        OwnerTypeCode r147 = new OwnerTypeCode("HOST_DOC", 47, 110);
        HOST_DOC = r147;
        OwnerTypeCode r148 = new OwnerTypeCode("LEADER_ROLE", 48, 111);
        LEADER_ROLE = r148;
        $VALUES = new OwnerTypeCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148};
        ADAPTER = ProtoAdapter.newEnumAdapter(OwnerTypeCode.class);
    }

    public static OwnerTypeCode[] values() {
        return (OwnerTypeCode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static OwnerTypeCode fromValue(int r100) {
        if (r100 == 110) goto L109;
        if (r100 == 111) goto L107;
        switch(r100) {
            case 0: goto L105;
            case 1: goto L103;
            case 2: goto L101;
            case 3: goto L99;
            case 4: goto L97;
            case 5: goto L95;
            case 6: goto L93;
            case 7: goto L91;
            default: goto L7;
        };
    L7:
        switch(r100) {
            case 9: goto L89;
            case 10: goto L87;
            case 11: goto L85;
            case 12: goto L83;
            case 13: goto L81;
            case 14: goto L79;
            case 15: goto L77;
            case 16: goto L75;
            case 17: goto L73;
            case 18: goto L71;
            case 19: goto L69;
            case 20: goto L67;
            case 21: goto L65;
            case 22: goto L63;
            case 23: goto L61;
            case 24: goto L59;
            default: goto L8;
        };
    L8:
        switch(r100) {
            case 26: goto L57;
            case 27: goto L55;
            case 28: goto L53;
            case 29: goto L51;
            case 30: goto L49;
            case 31: goto L47;
            case 32: goto L45;
            case 33: goto L43;
            case 34: goto L41;
            case 35: goto L39;
            case 36: goto L37;
            case 37: goto L35;
            case 38: goto L33;
            case 39: goto L31;
            default: goto L9;
        };
    L9:
        switch(r100) {
            case 100: goto L29;
            case 101: goto L27;
            case 102: goto L25;
            case 103: goto L23;
            case 104: goto L21;
            case 105: goto L19;
            case 106: goto L17;
            case 107: goto L15;
            case 108: goto L13;
            default: goto L10;
        };
    L10:
        return null;
    L13:
        return AUTOSHARE_DEPARTMENT;
    L15:
        return OTHER;
    L17:
        return LINK_ANYONE_PASSWORD;
    L19:
        return LINK_ANYONE_EDIT_WITH_PASSWORD;
    L21:
        return LINK_ANYONE_VIEW_WITH_PASSWORD;
    L23:
        return LINK_ANYONE_EDIT;
    L25:
        return LINK_ANYONE_VIEW;
    L27:
        return LINK_TENANT_EDIT;
    L29:
        return LINK_TENANT_VIEW;
    L31:
        return BASE_GLOBAL_USER_GROUP;
    L33:
        return BASE_GLOBAL_WORK_SPACE_OUTLIER;
    L35:
        return BASE_GLOBAL_WORK_SPACE_FELLOW;
    L37:
        return BASE_GLOBAL_WORK_SPACE_ADMIN;
    L39:
        return EFFECTIVE_MEETING_GROUP;
    L41:
        return MEEGO_WORKITEM;
    L43:
        return MEEGO_PROJECT;
    L45:
        return SHARED_MAILBOX;
    L47:
        return MAIL_GROUP;
    L49:
        return ASSIGN_GROUP;
    L51:
        return EMAIL;
    L53:
        return NEW_WIKI_MEMBER_GROUP;
    L55:
        return PHOENIX_MEMBER;
    L57:
        return PHOENIX_ADMIN;
    L59:
        return NEW_WIKI_MEMBER;
    L61:
        return NEW_WIKI_ADMIN;
    L63:
        return DYNAMIC_GROUP;
    L65:
        return SHARE_FOLDER;
    L67:
        return TEAM_SPACE_ROOT;
    L69:
        return APP;
    L71:
        return DEPARTMENT;
    L73:
        return TEMP_USER;
    L75:
        return WIKI_AREA_GROUP;
    L77:
        return MEETING_SPACE;
    L79:
        return MEETING_GROUP;
    L81:
        return SETTING;
    L83:
        return BEAR_OBJECT;
    L85:
        return FOLDER;
    L87:
        return WIKI_SPACE;
    L89:
        return CALENDER_EVENT;
    L91:
        return LARK_CHAT_WHITE_LIST;
    L93:
        return PUBLIC_ALL;
    L95:
        return SHARE_SPACE;
    L97:
        return PUBLIC;
    L99:
        return COMPANY;
    L101:
        return LARK_CHAT;
    L103:
        return LARK_USER;
    L105:
        return USER;
    L107:
        return LEADER_ROLE;
    L109:
        return HOST_DOC;
    }

    public static OwnerTypeCode valueOf(String r100) {
        return (OwnerTypeCode) a.a(OwnerTypeCode.class, r100);
    }

    private OwnerTypeCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
