package com.ss.android.lark.biz.im.api.extension.scroll;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b-\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u0006."}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/scroll/ScrollScene;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL_SPECIFIED_POSITION", "INITIAL_PREVIOUS_POSITION", "INITIAL_NEWEST_MESSAGE", "AUTO_BOTTOM", "RELOCATE_MESSAGE", "ENSURE_LAST_PAGE_DATA_LOADED", "KEYBOARD", "KEYBOARD_TYPE_CHANGE", "KEYBOARD_TOP_EXTEND_SHOW", "KEYBOARD_TOP_EXTEND_HIDE", "TIME_ZONE", "SCHEDULE_SEND", "BOT_MENU_MSG_SENT", "BOT_FLOAT_MENU_MSG_SENT", "CHAT_NEW_PIN", "MESSAGE_TOP_NOTICE", "NEW_INTENT_SCROLL", "MESSAGE_TIPS_AT", "MESSAGE_TIPS_NEW_MESSAGE", "AI_THREAD_TIPS_AT", "AI_THREAD_TIPS_NEW_MESSAGE", "CHAT_PREVIEW_TO_TOP", "CHAT_PREVIEW_TO_BOTTOM", "MESSAGE_LINK_PREVIEW_TO_TOP", "MESSAGE_LINK_PREVIEW_TO_BOTTOM", "AI_KEYBOARD", "AI_FOLLOW_UP_SHOW", "GENERAL_FOLLOW_UP_SHOW", "AI_NEW_TOPIC", "AI_REGENERATED", "AI_SCENE_SELECTED", "AI_NATIVE_ONBOARD", "AI_ONBOARD_V1_SHOW", "AI_ONBOARD_V2_SHOW", "AI_ONBOARD_V3_SHOW", "AI_SMART_REPLY", "CARD_MESSAGE_STREAM", "KNOWLEDGE_AI_ALIGN_TOP", "KNOWLEDGE_AI_CHANGE_TOPIC", "KNOWLEDGE_AI_ENTER_SHARE", "KNOWLEDGE_AI_ELEVATOR", "SMART_RECOMMEND", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScrollScene extends Enum<ScrollScene> {
    public static final ScrollScene AI_FOLLOW_UP_SHOW = null;
    public static final ScrollScene AI_KEYBOARD = null;
    public static final ScrollScene AI_NATIVE_ONBOARD = null;
    public static final ScrollScene AI_NEW_TOPIC = null;
    public static final ScrollScene AI_ONBOARD_V1_SHOW = null;
    public static final ScrollScene AI_ONBOARD_V2_SHOW = null;
    public static final ScrollScene AI_ONBOARD_V3_SHOW = null;
    public static final ScrollScene AI_REGENERATED = null;
    public static final ScrollScene AI_SCENE_SELECTED = null;
    public static final ScrollScene AI_SMART_REPLY = null;
    public static final ScrollScene AI_THREAD_TIPS_AT = null;
    public static final ScrollScene AI_THREAD_TIPS_NEW_MESSAGE = null;
    public static final ScrollScene AUTO_BOTTOM = null;
    public static final ScrollScene BOT_FLOAT_MENU_MSG_SENT = null;
    public static final ScrollScene BOT_MENU_MSG_SENT = null;
    public static final ScrollScene CARD_MESSAGE_STREAM = null;
    public static final ScrollScene CHAT_NEW_PIN = null;
    public static final ScrollScene CHAT_PREVIEW_TO_BOTTOM = null;
    public static final ScrollScene CHAT_PREVIEW_TO_TOP = null;
    public static final ScrollScene ENSURE_LAST_PAGE_DATA_LOADED = null;
    public static final ScrollScene GENERAL_FOLLOW_UP_SHOW = null;
    public static final ScrollScene INITIAL_NEWEST_MESSAGE = null;
    public static final ScrollScene INITIAL_PREVIOUS_POSITION = null;
    public static final ScrollScene INITIAL_SPECIFIED_POSITION = null;
    public static final ScrollScene KEYBOARD = null;
    public static final ScrollScene KEYBOARD_TOP_EXTEND_HIDE = null;
    public static final ScrollScene KEYBOARD_TOP_EXTEND_SHOW = null;
    public static final ScrollScene KEYBOARD_TYPE_CHANGE = null;
    public static final ScrollScene KNOWLEDGE_AI_ALIGN_TOP = null;
    public static final ScrollScene KNOWLEDGE_AI_CHANGE_TOPIC = null;
    public static final ScrollScene KNOWLEDGE_AI_ELEVATOR = null;
    public static final ScrollScene KNOWLEDGE_AI_ENTER_SHARE = null;
    public static final ScrollScene MESSAGE_LINK_PREVIEW_TO_BOTTOM = null;
    public static final ScrollScene MESSAGE_LINK_PREVIEW_TO_TOP = null;
    public static final ScrollScene MESSAGE_TIPS_AT = null;
    public static final ScrollScene MESSAGE_TIPS_NEW_MESSAGE = null;
    public static final ScrollScene MESSAGE_TOP_NOTICE = null;
    public static final ScrollScene NEW_INTENT_SCROLL = null;
    public static final ScrollScene RELOCATE_MESSAGE = null;
    public static final ScrollScene SCHEDULE_SEND = null;
    public static final ScrollScene SMART_RECOMMEND = null;
    public static final ScrollScene TIME_ZONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScrollScene[] f410232a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410233b = null;

    public static EnumEntries<ScrollScene> getEntries() {
        return f410233b;
    }

    static {
        ScrollScene r100 = new ScrollScene("INITIAL_SPECIFIED_POSITION", 0);
        INITIAL_SPECIFIED_POSITION = r100;
        ScrollScene r101 = new ScrollScene("INITIAL_PREVIOUS_POSITION", 1);
        INITIAL_PREVIOUS_POSITION = r101;
        ScrollScene r102 = new ScrollScene("INITIAL_NEWEST_MESSAGE", 2);
        INITIAL_NEWEST_MESSAGE = r102;
        ScrollScene r103 = new ScrollScene("AUTO_BOTTOM", 3);
        AUTO_BOTTOM = r103;
        ScrollScene r104 = new ScrollScene("RELOCATE_MESSAGE", 4);
        RELOCATE_MESSAGE = r104;
        ScrollScene r105 = new ScrollScene("ENSURE_LAST_PAGE_DATA_LOADED", 5);
        ENSURE_LAST_PAGE_DATA_LOADED = r105;
        ScrollScene r110 = new ScrollScene("KEYBOARD", 6);
        KEYBOARD = r110;
        ScrollScene r111 = new ScrollScene("KEYBOARD_TYPE_CHANGE", 7);
        KEYBOARD_TYPE_CHANGE = r111;
        ScrollScene r112 = new ScrollScene("KEYBOARD_TOP_EXTEND_SHOW", 8);
        KEYBOARD_TOP_EXTEND_SHOW = r112;
        ScrollScene r113 = new ScrollScene("KEYBOARD_TOP_EXTEND_HIDE", 9);
        KEYBOARD_TOP_EXTEND_HIDE = r113;
        ScrollScene r114 = new ScrollScene("TIME_ZONE", 10);
        TIME_ZONE = r114;
        ScrollScene r115 = new ScrollScene("SCHEDULE_SEND", 11);
        SCHEDULE_SEND = r115;
        ScrollScene r106 = new ScrollScene("BOT_MENU_MSG_SENT", 12);
        BOT_MENU_MSG_SENT = r106;
        ScrollScene r107 = new ScrollScene("BOT_FLOAT_MENU_MSG_SENT", 13);
        BOT_FLOAT_MENU_MSG_SENT = r107;
        ScrollScene r108 = new ScrollScene("CHAT_NEW_PIN", 14);
        CHAT_NEW_PIN = r108;
        ScrollScene r109 = new ScrollScene("MESSAGE_TOP_NOTICE", 15);
        MESSAGE_TOP_NOTICE = r109;
        ScrollScene r116 = new ScrollScene("NEW_INTENT_SCROLL", 16);
        NEW_INTENT_SCROLL = r116;
        ScrollScene r117 = new ScrollScene("MESSAGE_TIPS_AT", 17);
        MESSAGE_TIPS_AT = r117;
        ScrollScene r118 = new ScrollScene("MESSAGE_TIPS_NEW_MESSAGE", 18);
        MESSAGE_TIPS_NEW_MESSAGE = r118;
        ScrollScene r119 = new ScrollScene("AI_THREAD_TIPS_AT", 19);
        AI_THREAD_TIPS_AT = r119;
        ScrollScene r120 = new ScrollScene("AI_THREAD_TIPS_NEW_MESSAGE", 20);
        AI_THREAD_TIPS_NEW_MESSAGE = r120;
        ScrollScene r121 = new ScrollScene("CHAT_PREVIEW_TO_TOP", 21);
        CHAT_PREVIEW_TO_TOP = r121;
        ScrollScene r122 = new ScrollScene("CHAT_PREVIEW_TO_BOTTOM", 22);
        CHAT_PREVIEW_TO_BOTTOM = r122;
        ScrollScene r123 = new ScrollScene("MESSAGE_LINK_PREVIEW_TO_TOP", 23);
        MESSAGE_LINK_PREVIEW_TO_TOP = r123;
        ScrollScene r124 = new ScrollScene("MESSAGE_LINK_PREVIEW_TO_BOTTOM", 24);
        MESSAGE_LINK_PREVIEW_TO_BOTTOM = r124;
        ScrollScene r125 = new ScrollScene("AI_KEYBOARD", 25);
        AI_KEYBOARD = r125;
        ScrollScene r126 = new ScrollScene("AI_FOLLOW_UP_SHOW", 26);
        AI_FOLLOW_UP_SHOW = r126;
        ScrollScene r127 = new ScrollScene("GENERAL_FOLLOW_UP_SHOW", 27);
        GENERAL_FOLLOW_UP_SHOW = r127;
        ScrollScene r128 = new ScrollScene("AI_NEW_TOPIC", 28);
        AI_NEW_TOPIC = r128;
        ScrollScene r129 = new ScrollScene("AI_REGENERATED", 29);
        AI_REGENERATED = r129;
        ScrollScene r130 = new ScrollScene("AI_SCENE_SELECTED", 30);
        AI_SCENE_SELECTED = r130;
        ScrollScene r131 = new ScrollScene("AI_NATIVE_ONBOARD", 31);
        AI_NATIVE_ONBOARD = r131;
        ScrollScene r132 = new ScrollScene("AI_ONBOARD_V1_SHOW", 32);
        AI_ONBOARD_V1_SHOW = r132;
        ScrollScene r133 = new ScrollScene("AI_ONBOARD_V2_SHOW", 33);
        AI_ONBOARD_V2_SHOW = r133;
        ScrollScene r134 = new ScrollScene("AI_ONBOARD_V3_SHOW", 34);
        AI_ONBOARD_V3_SHOW = r134;
        ScrollScene r135 = new ScrollScene("AI_SMART_REPLY", 35);
        AI_SMART_REPLY = r135;
        ScrollScene r136 = new ScrollScene("CARD_MESSAGE_STREAM", 36);
        CARD_MESSAGE_STREAM = r136;
        ScrollScene r137 = new ScrollScene("KNOWLEDGE_AI_ALIGN_TOP", 37);
        KNOWLEDGE_AI_ALIGN_TOP = r137;
        ScrollScene r138 = new ScrollScene("KNOWLEDGE_AI_CHANGE_TOPIC", 38);
        KNOWLEDGE_AI_CHANGE_TOPIC = r138;
        ScrollScene r139 = new ScrollScene("KNOWLEDGE_AI_ENTER_SHARE", 39);
        KNOWLEDGE_AI_ENTER_SHARE = r139;
        ScrollScene r140 = new ScrollScene("KNOWLEDGE_AI_ELEVATOR", 40);
        KNOWLEDGE_AI_ELEVATOR = r140;
        ScrollScene r141 = new ScrollScene("SMART_RECOMMEND", 41);
        SMART_RECOMMEND = r141;
        ScrollScene[] r142 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141};
        f410232a = r142;
        f410233b = EnumEntriesKt.enumEntries(r142);
    }

    public static ScrollScene[] values() {
        return (ScrollScene[]) f410232a.clone();
    }

    public static ScrollScene valueOf(String r100) {
        return (ScrollScene) r27.a.a(ScrollScene.class, r100);
    }

    public ScrollScene(String r100, int r101) {
        super(r100, r101);
    }
}
