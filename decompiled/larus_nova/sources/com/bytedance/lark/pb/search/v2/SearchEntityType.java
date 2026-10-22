package com.bytedance.lark.pb.search.v2;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SearchEntityType extends Enum<SearchEntityType> implements WireEnum {
    private static final /* synthetic */ SearchEntityType[] $VALUES = null;
    public static final ProtoAdapter<SearchEntityType> ADAPTER = null;
    public static final SearchEntityType APP = null;
    public static final SearchEntityType BANNER = null;
    public static final SearchEntityType BOT = null;
    public static final SearchEntityType CALENDAR_EVENT = null;
    public static final SearchEntityType CHAMELEON = null;
    public static final SearchEntityType CRYPTO_P2P_CHAT = null;
    public static final SearchEntityType CUSTOMIZATION = null;
    public static final SearchEntityType DEPARTMENT = null;
    public static final SearchEntityType DOC = null;
    public static final SearchEntityType EMAIL = null;
    public static final SearchEntityType FACILITY = null;
    public static final SearchEntityType GROUP_CHAT = null;
    public static final SearchEntityType MAIL_CONTACT = null;
    public static final SearchEntityType MAIL_USER = null;
    public static final SearchEntityType MAX = null;
    public static final SearchEntityType MESSAGE = null;
    public static final SearchEntityType MESSAGE_FILE = null;
    public static final SearchEntityType MY_AI = null;
    public static final SearchEntityType NEW_USER_GROUP = null;
    public static final SearchEntityType ONCALL = null;
    public static final SearchEntityType PANO = null;
    public static final SearchEntityType QA_CARD = null;
    public static final SearchEntityType RESOURCE = null;
    public static final SearchEntityType SECTION = null;
    public static final SearchEntityType SHIELD_P2P_CHAT = null;
    public static final SearchEntityType SLASH_COMMAND = null;
    public static final SearchEntityType THREAD = null;
    public static final SearchEntityType UNKNOWN = null;
    public static final SearchEntityType URL = null;
    public static final SearchEntityType USER = null;
    public static final SearchEntityType USER_GROUP = null;
    public static final SearchEntityType USER_GROUP_ASSIGN = null;
    public static final SearchEntityType WIKI = null;
    public static final SearchEntityType WIKI_SPACE = null;
    public final Boolean deprecated;
    private final int value;

    static {
        SearchEntityType r100 = new SearchEntityType("UNKNOWN", 0, 0, null);
        UNKNOWN = r100;
        SearchEntityType r101 = new SearchEntityType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1, null);
        USER = r101;
        SearchEntityType r102 = new SearchEntityType("BOT", 2, 2, null);
        BOT = r102;
        SearchEntityType r103 = new SearchEntityType("GROUP_CHAT", 3, 3, null);
        GROUP_CHAT = r103;
        SearchEntityType r104 = new SearchEntityType("CRYPTO_P2P_CHAT", 4, 4, null);
        CRYPTO_P2P_CHAT = r104;
        SearchEntityType r110 = new SearchEntityType("MESSAGE", 5, 5, null);
        MESSAGE = r110;
        SearchEntityType r111 = new SearchEntityType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 6, 6, null);
        DOC = r111;
        SearchEntityType r112 = new SearchEntityType("WIKI", 7, 7, null);
        WIKI = r112;
        SearchEntityType r113 = new SearchEntityType("APP", 8, 8, null);
        APP = r113;
        SearchEntityType r114 = new SearchEntityType("ONCALL", 9, 9, null);
        ONCALL = r114;
        SearchEntityType r115 = new SearchEntityType("THREAD", 10, 10, null);
        THREAD = r115;
        SearchEntityType r105 = new SearchEntityType("QA_CARD", 11, 11, null);
        QA_CARD = r105;
        SearchEntityType r106 = new SearchEntityType("URL", 12, 12, null);
        URL = r106;
        SearchEntityType r107 = new SearchEntityType("DEPARTMENT", 13, 13, null);
        DEPARTMENT = r107;
        SearchEntityType r108 = new SearchEntityType("PANO", 14, 14, null);
        PANO = r108;
        SearchEntityType r109 = new SearchEntityType("SLASH_COMMAND", 15, 15, null);
        SLASH_COMMAND = r109;
        SearchEntityType r116 = new SearchEntityType("SECTION", 16, 16, null);
        SECTION = r116;
        SearchEntityType r117 = new SearchEntityType("RESOURCE", 17, 18, null);
        RESOURCE = r117;
        SearchEntityType r118 = new SearchEntityType("CUSTOMIZATION", 18, 19, null);
        CUSTOMIZATION = r118;
        SearchEntityType r119 = new SearchEntityType("FACILITY", 19, 20, null);
        FACILITY = r119;
        SearchEntityType r120 = new SearchEntityType("MAIL_CONTACT", 20, 21, null);
        MAIL_CONTACT = r120;
        SearchEntityType r121 = new SearchEntityType("CHAMELEON", 21, 22, null);
        CHAMELEON = r121;
        SearchEntityType r122 = new SearchEntityType("BANNER", 22, 23, null);
        BANNER = r122;
        SearchEntityType r123 = new SearchEntityType("WIKI_SPACE", 23, 25, null);
        WIKI_SPACE = r123;
        SearchEntityType r124 = new SearchEntityType("SHIELD_P2P_CHAT", 24, 27, null);
        SHIELD_P2P_CHAT = r124;
        SearchEntityType r125 = new SearchEntityType("USER_GROUP", 25, 28, null);
        USER_GROUP = r125;
        SearchEntityType r126 = new SearchEntityType("USER_GROUP_ASSIGN", 26, 29, null);
        USER_GROUP_ASSIGN = r126;
        SearchEntityType r127 = new SearchEntityType("MESSAGE_FILE", 27, 30, null);
        MESSAGE_FILE = r127;
        SearchEntityType r128 = new SearchEntityType("MY_AI", 28, 31, Boolean.TRUE);
        MY_AI = r128;
        SearchEntityType r129 = new SearchEntityType("CALENDAR_EVENT", 29, 32, null);
        CALENDAR_EVENT = r129;
        SearchEntityType r130 = new SearchEntityType(CommonConstant.RETKEY.EMAIL, 30, 33, null);
        EMAIL = r130;
        SearchEntityType r131 = new SearchEntityType("MAIL_USER", 31, 34, null);
        MAIL_USER = r131;
        SearchEntityType r132 = new SearchEntityType("NEW_USER_GROUP", 32, 35, null);
        NEW_USER_GROUP = r132;
        SearchEntityType r133 = new SearchEntityType("MAX", 33, 100, null);
        MAX = r133;
        $VALUES = new SearchEntityType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r105, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133};
        ADAPTER = ProtoAdapter.newEnumAdapter(SearchEntityType.class);
    }

    public static SearchEntityType[] values() {
        return (SearchEntityType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SearchEntityType fromValue(int r100) {
        if (r100 == 25) goto L78;
        if (r100 == 100) goto L76;
        switch(r100) {
            case 0: goto L74;
            case 1: goto L72;
            case 2: goto L70;
            case 3: goto L68;
            case 4: goto L66;
            case 5: goto L64;
            case 6: goto L62;
            case 7: goto L60;
            case 8: goto L58;
            case 9: goto L56;
            case 10: goto L54;
            case 11: goto L52;
            case 12: goto L50;
            case 13: goto L48;
            case 14: goto L46;
            case 15: goto L44;
            case 16: goto L42;
            default: goto L7;
        };
    L7:
        switch(r100) {
            case 18: goto L40;
            case 19: goto L38;
            case 20: goto L36;
            case 21: goto L34;
            case 22: goto L32;
            case 23: goto L30;
            default: goto L8;
        };
    L8:
        switch(r100) {
            case 27: goto L28;
            case 28: goto L26;
            case 29: goto L24;
            case 30: goto L22;
            case 31: goto L20;
            case 32: goto L18;
            case 33: goto L16;
            case 34: goto L14;
            case 35: goto L12;
            default: goto L9;
        };
    L9:
        return null;
    L12:
        return NEW_USER_GROUP;
    L14:
        return MAIL_USER;
    L16:
        return EMAIL;
    L18:
        return CALENDAR_EVENT;
    L20:
        return MY_AI;
    L22:
        return MESSAGE_FILE;
    L24:
        return USER_GROUP_ASSIGN;
    L26:
        return USER_GROUP;
    L28:
        return SHIELD_P2P_CHAT;
    L30:
        return BANNER;
    L32:
        return CHAMELEON;
    L34:
        return MAIL_CONTACT;
    L36:
        return FACILITY;
    L38:
        return CUSTOMIZATION;
    L40:
        return RESOURCE;
    L42:
        return SECTION;
    L44:
        return SLASH_COMMAND;
    L46:
        return PANO;
    L48:
        return DEPARTMENT;
    L50:
        return URL;
    L52:
        return QA_CARD;
    L54:
        return THREAD;
    L56:
        return ONCALL;
    L58:
        return APP;
    L60:
        return WIKI;
    L62:
        return DOC;
    L64:
        return MESSAGE;
    L66:
        return CRYPTO_P2P_CHAT;
    L68:
        return GROUP_CHAT;
    L70:
        return BOT;
    L72:
        return USER;
    L74:
        return UNKNOWN;
    L76:
        return MAX;
    L78:
        return WIKI_SPACE;
    }

    public static SearchEntityType valueOf(String r100) {
        return (SearchEntityType) a.a(SearchEntityType.class, r100);
    }

    private SearchEntityType(String r100, int r101, int r102, Boolean r103) {
        super(r100, r101);
        this.value = r102;
        this.deprecated = r103;
    }
}
