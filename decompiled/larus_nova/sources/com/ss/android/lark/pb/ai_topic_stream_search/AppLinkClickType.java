package com.ss.android.lark.pb.ai_topic_stream_search;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum AppLinkClickType extends Enum<AppLinkClickType> implements WireEnum {
    private static final /* synthetic */ AppLinkClickType[] $VALUES = null;
    public static final ProtoAdapter<AppLinkClickType> ADAPTER = null;
    public static final AppLinkClickType AppLinkClickType_ANSWER_IN_SEARCH = null;
    public static final AppLinkClickType AppLinkClickType_ANSWER_IN_SEARCH_ENTER = null;
    public static final AppLinkClickType AppLinkClickType_ANSWER_IN_SEARCH_FALLBACK = null;
    public static final AppLinkClickType AppLinkClickType_ANSWER_IN_SEARCH_LOADING = null;
    public static final AppLinkClickType AppLinkClickType_ANSWER_IN_SEARCH_TITLE = null;
    public static final AppLinkClickType AppLinkClickType_DOC_BANNER = null;
    public static final AppLinkClickType AppLinkClickType_DOC_FEED = null;
    public static final AppLinkClickType AppLinkClickType_DOC_QUERY_RECOMMEND = null;
    public static final AppLinkClickType AppLinkClickType_DOC_SEARCH = null;
    public static final AppLinkClickType AppLinkClickType_IM_AT_KNOWLEDGE = null;
    public static final AppLinkClickType AppLinkClickType_IM_INPUT_TAB = null;
    public static final AppLinkClickType AppLinkClickType_MAIL_SEARCH_ENTRANCE = null;
    public static final AppLinkClickType AppLinkClickType_MAIL_SEARCH_EXPAND = null;
    public static final AppLinkClickType AppLinkClickType_MESSAGE_SEARCH = null;
    public static final AppLinkClickType AppLinkClickType_OLD_VERSION_INTERCEPT_JUMP = null;
    public static final AppLinkClickType AppLinkClickType_PC_LIVETEXT_AI_SEARCH = null;
    public static final AppLinkClickType AppLinkClickType_PC_LIVETEXT_EXPLAIN_CONTINUE = null;
    public static final AppLinkClickType AppLinkClickType_PC_LIVETEXT_TRANSLATE_CONTINUE = null;
    public static final AppLinkClickType AppLinkClickType_PLACEHOLDER = null;
    public static final AppLinkClickType AppLinkClickType_PLUGIN_AI_SEARCH = null;
    public static final AppLinkClickType AppLinkClickType_PLUGIN_ASK = null;
    public static final AppLinkClickType AppLinkClickType_PLUGIN_EXPLAIN = null;
    public static final AppLinkClickType AppLinkClickType_PLUGIN_TRANSLATE = null;
    public static final AppLinkClickType AppLinkClickType_QA_ONBOARDING = null;
    public static final AppLinkClickType AppLinkClickType_RECOMMEND_PROMPT = null;
    public static final AppLinkClickType AppLinkClickType_REGISTER_JUMP_KNOWLEDGE = null;
    public static final AppLinkClickType AppLinkClickType_SAVE_DOC = null;
    public static final AppLinkClickType AppLinkClickType_SEARCH_COMMON = null;
    public static final AppLinkClickType AppLinkClickType_SEARCH_HELPDESK = null;
    public static final AppLinkClickType AppLinkClickType_SEARCH_IN_CHAT = null;
    public static final AppLinkClickType AppLinkClickType_SEARCH_IN_CHAT_EXPAND = null;
    public static final AppLinkClickType AppLinkClickType_SEARCH_IN_CHAT_TITLE = null;
    public static final AppLinkClickType AppLinkClickType_SEARCH_QA_HISTOTY = null;
    public static final AppLinkClickType AppLinkClickType_SELECT_WORDS_CLIENT_WEBS = null;
    public static final AppLinkClickType AppLinkClickType_SELECT_WORDS_IM = null;
    public static final AppLinkClickType AppLinkClickType_SELECT_WORDS_OUT_CLIENT = null;
    public static final AppLinkClickType AppLinkClickType_UNKNOWN = null;
    public static final AppLinkClickType AppLinkClickType_WEB_CLIENT_DIALOGUE = null;
    public static final AppLinkClickType AppLinkClickType_WEB_DOC_SEARCH = null;
    public static final AppLinkClickType AppLinkClickType_WEB_QA_IN_SEARCH = null;
    private final int value;

    static {
        AppLinkClickType r100 = new AppLinkClickType("AppLinkClickType_UNKNOWN", 0, 0);
        AppLinkClickType_UNKNOWN = r100;
        AppLinkClickType r101 = new AppLinkClickType("AppLinkClickType_ANSWER_IN_SEARCH", 1, 1);
        AppLinkClickType_ANSWER_IN_SEARCH = r101;
        AppLinkClickType r102 = new AppLinkClickType("AppLinkClickType_PLACEHOLDER", 2, 2);
        AppLinkClickType_PLACEHOLDER = r102;
        AppLinkClickType r103 = new AppLinkClickType("AppLinkClickType_RECOMMEND_PROMPT", 3, 3);
        AppLinkClickType_RECOMMEND_PROMPT = r103;
        AppLinkClickType r104 = new AppLinkClickType("AppLinkClickType_SEARCH_IN_CHAT", 4, 4);
        AppLinkClickType_SEARCH_IN_CHAT = r104;
        AppLinkClickType r105 = new AppLinkClickType("AppLinkClickType_SEARCH_HELPDESK", 5, 5);
        AppLinkClickType_SEARCH_HELPDESK = r105;
        AppLinkClickType r110 = new AppLinkClickType("AppLinkClickType_DOC_QUERY_RECOMMEND", 6, 6);
        AppLinkClickType_DOC_QUERY_RECOMMEND = r110;
        AppLinkClickType r111 = new AppLinkClickType("AppLinkClickType_QA_ONBOARDING", 7, 7);
        AppLinkClickType_QA_ONBOARDING = r111;
        AppLinkClickType r112 = new AppLinkClickType("AppLinkClickType_OLD_VERSION_INTERCEPT_JUMP", 8, 8);
        AppLinkClickType_OLD_VERSION_INTERCEPT_JUMP = r112;
        AppLinkClickType r113 = new AppLinkClickType("AppLinkClickType_WEB_CLIENT_DIALOGUE", 9, 9);
        AppLinkClickType_WEB_CLIENT_DIALOGUE = r113;
        AppLinkClickType r114 = new AppLinkClickType("AppLinkClickType_SAVE_DOC", 10, 11);
        AppLinkClickType_SAVE_DOC = r114;
        AppLinkClickType r106 = new AppLinkClickType("AppLinkClickType_WEB_QA_IN_SEARCH", 11, 12);
        AppLinkClickType_WEB_QA_IN_SEARCH = r106;
        AppLinkClickType r115 = new AppLinkClickType("AppLinkClickType_PLUGIN_AI_SEARCH", 12, 13);
        AppLinkClickType_PLUGIN_AI_SEARCH = r115;
        AppLinkClickType r107 = new AppLinkClickType("AppLinkClickType_PLUGIN_ASK", 13, 14);
        AppLinkClickType_PLUGIN_ASK = r107;
        AppLinkClickType r108 = new AppLinkClickType("AppLinkClickType_PLUGIN_EXPLAIN", 14, 15);
        AppLinkClickType_PLUGIN_EXPLAIN = r108;
        AppLinkClickType r109 = new AppLinkClickType("AppLinkClickType_PLUGIN_TRANSLATE", 15, 16);
        AppLinkClickType_PLUGIN_TRANSLATE = r109;
        AppLinkClickType r116 = new AppLinkClickType("AppLinkClickType_DOC_BANNER", 16, 17);
        AppLinkClickType_DOC_BANNER = r116;
        AppLinkClickType r117 = new AppLinkClickType("AppLinkClickType_DOC_FEED", 17, 18);
        AppLinkClickType_DOC_FEED = r117;
        AppLinkClickType r118 = new AppLinkClickType("AppLinkClickType_ANSWER_IN_SEARCH_TITLE", 18, 19);
        AppLinkClickType_ANSWER_IN_SEARCH_TITLE = r118;
        AppLinkClickType r119 = new AppLinkClickType("AppLinkClickType_SEARCH_QA_HISTOTY", 19, 20);
        AppLinkClickType_SEARCH_QA_HISTOTY = r119;
        AppLinkClickType r120 = new AppLinkClickType("AppLinkClickType_SEARCH_COMMON", 20, 21);
        AppLinkClickType_SEARCH_COMMON = r120;
        AppLinkClickType r121 = new AppLinkClickType("AppLinkClickType_ANSWER_IN_SEARCH_LOADING", 21, 23);
        AppLinkClickType_ANSWER_IN_SEARCH_LOADING = r121;
        AppLinkClickType r122 = new AppLinkClickType("AppLinkClickType_ANSWER_IN_SEARCH_ENTER", 22, 24);
        AppLinkClickType_ANSWER_IN_SEARCH_ENTER = r122;
        AppLinkClickType r123 = new AppLinkClickType("AppLinkClickType_ANSWER_IN_SEARCH_FALLBACK", 23, 25);
        AppLinkClickType_ANSWER_IN_SEARCH_FALLBACK = r123;
        AppLinkClickType r124 = new AppLinkClickType("AppLinkClickType_REGISTER_JUMP_KNOWLEDGE", 24, 26);
        AppLinkClickType_REGISTER_JUMP_KNOWLEDGE = r124;
        AppLinkClickType r125 = new AppLinkClickType("AppLinkClickType_SELECT_WORDS_IM", 25, 27);
        AppLinkClickType_SELECT_WORDS_IM = r125;
        AppLinkClickType r126 = new AppLinkClickType("AppLinkClickType_SELECT_WORDS_CLIENT_WEBS", 26, 28);
        AppLinkClickType_SELECT_WORDS_CLIENT_WEBS = r126;
        AppLinkClickType r127 = new AppLinkClickType("AppLinkClickType_SELECT_WORDS_OUT_CLIENT", 27, 29);
        AppLinkClickType_SELECT_WORDS_OUT_CLIENT = r127;
        AppLinkClickType r128 = new AppLinkClickType("AppLinkClickType_IM_INPUT_TAB", 28, 30);
        AppLinkClickType_IM_INPUT_TAB = r128;
        AppLinkClickType r129 = new AppLinkClickType("AppLinkClickType_SEARCH_IN_CHAT_EXPAND", 29, 31);
        AppLinkClickType_SEARCH_IN_CHAT_EXPAND = r129;
        AppLinkClickType r130 = new AppLinkClickType("AppLinkClickType_SEARCH_IN_CHAT_TITLE", 30, 32);
        AppLinkClickType_SEARCH_IN_CHAT_TITLE = r130;
        AppLinkClickType r131 = new AppLinkClickType("AppLinkClickType_PC_LIVETEXT_AI_SEARCH", 31, 33);
        AppLinkClickType_PC_LIVETEXT_AI_SEARCH = r131;
        AppLinkClickType r132 = new AppLinkClickType("AppLinkClickType_PC_LIVETEXT_EXPLAIN_CONTINUE", 32, 34);
        AppLinkClickType_PC_LIVETEXT_EXPLAIN_CONTINUE = r132;
        AppLinkClickType r133 = new AppLinkClickType("AppLinkClickType_PC_LIVETEXT_TRANSLATE_CONTINUE", 33, 35);
        AppLinkClickType_PC_LIVETEXT_TRANSLATE_CONTINUE = r133;
        AppLinkClickType r134 = new AppLinkClickType("AppLinkClickType_IM_AT_KNOWLEDGE", 34, 37);
        AppLinkClickType_IM_AT_KNOWLEDGE = r134;
        AppLinkClickType r135 = new AppLinkClickType("AppLinkClickType_MAIL_SEARCH_ENTRANCE", 35, 38);
        AppLinkClickType_MAIL_SEARCH_ENTRANCE = r135;
        AppLinkClickType r136 = new AppLinkClickType("AppLinkClickType_MAIL_SEARCH_EXPAND", 36, 39);
        AppLinkClickType_MAIL_SEARCH_EXPAND = r136;
        AppLinkClickType r137 = new AppLinkClickType("AppLinkClickType_MESSAGE_SEARCH", 37, 40);
        AppLinkClickType_MESSAGE_SEARCH = r137;
        AppLinkClickType r138 = new AppLinkClickType("AppLinkClickType_DOC_SEARCH", 38, 41);
        AppLinkClickType_DOC_SEARCH = r138;
        AppLinkClickType r139 = new AppLinkClickType("AppLinkClickType_WEB_DOC_SEARCH", 39, 42);
        AppLinkClickType_WEB_DOC_SEARCH = r139;
        $VALUES = new AppLinkClickType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r115, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppLinkClickType.class);
    }

    public static AppLinkClickType[] values() {
        return (AppLinkClickType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AppLinkClickType fromValue(int r100) {
        switch(r100) {
            case 0: goto L84;
            case 1: goto L82;
            case 2: goto L80;
            case 3: goto L78;
            case 4: goto L76;
            case 5: goto L74;
            case 6: goto L72;
            case 7: goto L70;
            case 8: goto L68;
            case 9: goto L66;
            case 10: goto L3;
            case 11: goto L64;
            case 12: goto L62;
            case 13: goto L60;
            case 14: goto L58;
            case 15: goto L56;
            case 16: goto L54;
            case 17: goto L52;
            case 18: goto L50;
            case 19: goto L48;
            case 20: goto L46;
            case 21: goto L44;
            case 22: goto L3;
            case 23: goto L42;
            case 24: goto L40;
            case 25: goto L38;
            case 26: goto L36;
            case 27: goto L34;
            case 28: goto L32;
            case 29: goto L30;
            case 30: goto L28;
            case 31: goto L26;
            case 32: goto L24;
            case 33: goto L22;
            case 34: goto L20;
            case 35: goto L18;
            case 36: goto L3;
            case 37: goto L16;
            case 38: goto L14;
            case 39: goto L12;
            case 40: goto L10;
            case 41: goto L8;
            case 42: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return AppLinkClickType_WEB_DOC_SEARCH;
    L8:
        return AppLinkClickType_DOC_SEARCH;
    L10:
        return AppLinkClickType_MESSAGE_SEARCH;
    L12:
        return AppLinkClickType_MAIL_SEARCH_EXPAND;
    L14:
        return AppLinkClickType_MAIL_SEARCH_ENTRANCE;
    L16:
        return AppLinkClickType_IM_AT_KNOWLEDGE;
    L18:
        return AppLinkClickType_PC_LIVETEXT_TRANSLATE_CONTINUE;
    L20:
        return AppLinkClickType_PC_LIVETEXT_EXPLAIN_CONTINUE;
    L22:
        return AppLinkClickType_PC_LIVETEXT_AI_SEARCH;
    L24:
        return AppLinkClickType_SEARCH_IN_CHAT_TITLE;
    L26:
        return AppLinkClickType_SEARCH_IN_CHAT_EXPAND;
    L28:
        return AppLinkClickType_IM_INPUT_TAB;
    L30:
        return AppLinkClickType_SELECT_WORDS_OUT_CLIENT;
    L32:
        return AppLinkClickType_SELECT_WORDS_CLIENT_WEBS;
    L34:
        return AppLinkClickType_SELECT_WORDS_IM;
    L36:
        return AppLinkClickType_REGISTER_JUMP_KNOWLEDGE;
    L38:
        return AppLinkClickType_ANSWER_IN_SEARCH_FALLBACK;
    L40:
        return AppLinkClickType_ANSWER_IN_SEARCH_ENTER;
    L42:
        return AppLinkClickType_ANSWER_IN_SEARCH_LOADING;
    L44:
        return AppLinkClickType_SEARCH_COMMON;
    L46:
        return AppLinkClickType_SEARCH_QA_HISTOTY;
    L48:
        return AppLinkClickType_ANSWER_IN_SEARCH_TITLE;
    L50:
        return AppLinkClickType_DOC_FEED;
    L52:
        return AppLinkClickType_DOC_BANNER;
    L54:
        return AppLinkClickType_PLUGIN_TRANSLATE;
    L56:
        return AppLinkClickType_PLUGIN_EXPLAIN;
    L58:
        return AppLinkClickType_PLUGIN_ASK;
    L60:
        return AppLinkClickType_PLUGIN_AI_SEARCH;
    L62:
        return AppLinkClickType_WEB_QA_IN_SEARCH;
    L64:
        return AppLinkClickType_SAVE_DOC;
    L66:
        return AppLinkClickType_WEB_CLIENT_DIALOGUE;
    L68:
        return AppLinkClickType_OLD_VERSION_INTERCEPT_JUMP;
    L70:
        return AppLinkClickType_QA_ONBOARDING;
    L72:
        return AppLinkClickType_DOC_QUERY_RECOMMEND;
    L74:
        return AppLinkClickType_SEARCH_HELPDESK;
    L76:
        return AppLinkClickType_SEARCH_IN_CHAT;
    L78:
        return AppLinkClickType_RECOMMEND_PROMPT;
    L80:
        return AppLinkClickType_PLACEHOLDER;
    L82:
        return AppLinkClickType_ANSWER_IN_SEARCH;
    L84:
        return AppLinkClickType_UNKNOWN;
    }

    public static AppLinkClickType valueOf(String r100) {
        return (AppLinkClickType) a.a(AppLinkClickType.class, r100);
    }

    private AppLinkClickType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
