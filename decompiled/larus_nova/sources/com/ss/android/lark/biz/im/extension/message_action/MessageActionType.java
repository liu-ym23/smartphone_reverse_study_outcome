package com.ss.android.lark.biz.im.extension.message_action;

import com.ss.android.lark.biz.im.api.extension.message.TaskType;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\bL\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bP¨\u0006Q"}, d2 = {"Lcom/ss/android/lark/biz/im/extension/message_action/MessageActionType;", "", "key", "", "ignoreSetting", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getKey", "()Ljava/lang/String;", "getIgnoreSetting", "()Z", "ADD_REACTION", "MUTE_PLAY_VIDEO", "SELECT_AUDIO_PLAY_MODE", "TOGGLE_AUDIO_TO_TEXT", "DING", "RECALL", "REEDIT", "REPLY", "FORWARD", "FORWARD_REPLY_IN_THREAD", "REPLY_IN_THREAD", "MULTI_SELECT", "MUTE_DOCS_NOTIFICATION", "COPY", "COPY_IMAGE_AND_MEDIA", "ADD_FLAG", "ADD_TO_FAVORITE", "PIN", "CHAT_PIN", "CHAT_PIN_MENU", "PIN_TO_TOP", "COPY_MESSAGE_LINK", "ADD_STICKER", "IMAGE_TO_STICKER", "ADD_TASK", "BACK_TO_CHAT", "MESSAGE_RESTRICT", "TRANSLATE", "SWITCH_TRANSLATION_LANGUAGE", "MEEGO", "SEARCH", "SEARCH_EXTERNAL", "TOGGLE_URL_PREVIEW", "EDIT_IMAGE", "EXPORT_MESSAGE_TO_DOC", "DELETE", "SHORTCUTS", "HYPER_TRANSLATE", "SAVE_TO", "MY_AI_DEBUG_MODE", "MY_AI_UP_VOTE", "MY_AI_DOWN_VOTE", "COPY_URL_LINK", "MY_AI_ANSWER_PROCESS", "COPY_MESSAGE_ID", "KA", "ZONE_COPY", "ZONE_SEARCH", "ZONE_SEARCH_EXTERNAL", "ZONE_HYPER_TRANSLATE", "ZONE_REPLY", "SMART_REPLY", "AI_SHARE", "FLOW_LIKE", "FLOW_DISLIKE", "FLOW_FEEDBACK", "FLOW_MORE", "SELECT_TEXT", "CREATE_DOC", "FOLLOW_UP_QUESTION", "FLOW_ASK_DOUBAO", "WORDS_ASK_DOUBAO", "DOUBAO_SAVE_IMAGE", "DOUBAO_SHARE_IMAGE", "DOUBAO_SAVE_VIDEO", "DOUBAO_SHARE_VIDEO", "DOUBAO_TTS", "MESSAGE_SOURCE_INFO", "CLOSE_TOPIC", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageActionType extends Enum<MessageActionType> {
    public static final MessageActionType ADD_FLAG = null;
    public static final MessageActionType ADD_REACTION = null;
    public static final MessageActionType ADD_STICKER = null;
    public static final MessageActionType ADD_TASK = null;
    public static final MessageActionType ADD_TO_FAVORITE = null;
    public static final MessageActionType AI_SHARE = null;
    public static final MessageActionType BACK_TO_CHAT = null;
    public static final MessageActionType CHAT_PIN = null;
    public static final MessageActionType CHAT_PIN_MENU = null;
    public static final MessageActionType CLOSE_TOPIC = null;
    public static final MessageActionType COPY = null;
    public static final MessageActionType COPY_IMAGE_AND_MEDIA = null;
    public static final MessageActionType COPY_MESSAGE_ID = null;
    public static final MessageActionType COPY_MESSAGE_LINK = null;
    public static final MessageActionType COPY_URL_LINK = null;
    public static final MessageActionType CREATE_DOC = null;
    public static final MessageActionType DELETE = null;
    public static final MessageActionType DING = null;
    public static final MessageActionType DOUBAO_SAVE_IMAGE = null;
    public static final MessageActionType DOUBAO_SAVE_VIDEO = null;
    public static final MessageActionType DOUBAO_SHARE_IMAGE = null;
    public static final MessageActionType DOUBAO_SHARE_VIDEO = null;
    public static final MessageActionType DOUBAO_TTS = null;
    public static final MessageActionType EDIT_IMAGE = null;
    public static final MessageActionType EXPORT_MESSAGE_TO_DOC = null;
    public static final MessageActionType FLOW_ASK_DOUBAO = null;
    public static final MessageActionType FLOW_DISLIKE = null;
    public static final MessageActionType FLOW_FEEDBACK = null;
    public static final MessageActionType FLOW_LIKE = null;
    public static final MessageActionType FLOW_MORE = null;
    public static final MessageActionType FOLLOW_UP_QUESTION = null;
    public static final MessageActionType FORWARD = null;
    public static final MessageActionType FORWARD_REPLY_IN_THREAD = null;
    public static final MessageActionType HYPER_TRANSLATE = null;
    public static final MessageActionType IMAGE_TO_STICKER = null;
    public static final MessageActionType KA = null;
    public static final MessageActionType MEEGO = null;
    public static final MessageActionType MESSAGE_RESTRICT = null;
    public static final MessageActionType MESSAGE_SOURCE_INFO = null;
    public static final MessageActionType MULTI_SELECT = null;
    public static final MessageActionType MUTE_DOCS_NOTIFICATION = null;
    public static final MessageActionType MUTE_PLAY_VIDEO = null;
    public static final MessageActionType MY_AI_ANSWER_PROCESS = null;
    public static final MessageActionType MY_AI_DEBUG_MODE = null;
    public static final MessageActionType MY_AI_DOWN_VOTE = null;
    public static final MessageActionType MY_AI_UP_VOTE = null;
    public static final MessageActionType PIN = null;
    public static final MessageActionType PIN_TO_TOP = null;
    public static final MessageActionType RECALL = null;
    public static final MessageActionType REEDIT = null;
    public static final MessageActionType REPLY = null;
    public static final MessageActionType REPLY_IN_THREAD = null;
    public static final MessageActionType SAVE_TO = null;
    public static final MessageActionType SEARCH = null;
    public static final MessageActionType SEARCH_EXTERNAL = null;
    public static final MessageActionType SELECT_AUDIO_PLAY_MODE = null;
    public static final MessageActionType SELECT_TEXT = null;
    public static final MessageActionType SHORTCUTS = null;
    public static final MessageActionType SMART_REPLY = null;
    public static final MessageActionType SWITCH_TRANSLATION_LANGUAGE = null;
    public static final MessageActionType TOGGLE_AUDIO_TO_TEXT = null;
    public static final MessageActionType TOGGLE_URL_PREVIEW = null;
    public static final MessageActionType TRANSLATE = null;
    public static final MessageActionType WORDS_ASK_DOUBAO = null;
    public static final MessageActionType ZONE_COPY = null;
    public static final MessageActionType ZONE_HYPER_TRANSLATE = null;
    public static final MessageActionType ZONE_REPLY = null;
    public static final MessageActionType ZONE_SEARCH = null;
    public static final MessageActionType ZONE_SEARCH_EXTERNAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageActionType[] f410499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410500b = null;
    private final boolean ignoreSetting;
    private final String key;

    public static EnumEntries<MessageActionType> getEntries() {
        return f410500b;
    }

    static {
        MessageActionType r100 = new MessageActionType("ADD_REACTION", 0, INotificationHitPoint.NoticeType.REACTION, false, 2, null);
        ADD_REACTION = r100;
        boolean r110 = false;
        int r111 = 2;
        DefaultConstructorMarker r112 = null;
        MessageActionType r101 = new MessageActionType("MUTE_PLAY_VIDEO", 1, "mute_play_video", r110, r111, r112);
        MUTE_PLAY_VIDEO = r101;
        boolean r113 = false;
        int r210 = 2;
        DefaultConstructorMarker r211 = null;
        MessageActionType r102 = new MessageActionType("SELECT_AUDIO_PLAY_MODE", 2, "audio_play_mode", r113, r210, r211);
        SELECT_AUDIO_PLAY_MODE = r102;
        MessageActionType r103 = new MessageActionType("TOGGLE_AUDIO_TO_TEXT", 3, "audio_to_text", r110, r111, r112);
        TOGGLE_AUDIO_TO_TEXT = r103;
        MessageActionType r104 = new MessageActionType("DING", 4, "ding", r113, r210, r211);
        DING = r104;
        MessageActionType r105 = new MessageActionType("RECALL", 5, "recall", r110, r111, r112);
        RECALL = r105;
        MessageActionType r106 = new MessageActionType("REEDIT", 6, "reedit", r113, r210, r211);
        REEDIT = r106;
        MessageActionType r107 = new MessageActionType("REPLY", 7, "reply", r110, r111, r112);
        REPLY = r107;
        MessageActionType r108 = new MessageActionType("FORWARD", 8, "forward", r113, r210, r211);
        FORWARD = r108;
        MessageActionType r114 = new MessageActionType("FORWARD_REPLY_IN_THREAD", 9, "forward", false, 2, null);
        FORWARD_REPLY_IN_THREAD = r114;
        boolean r212 = false;
        int r213 = 2;
        DefaultConstructorMarker r214 = null;
        MessageActionType r109 = new MessageActionType("REPLY_IN_THREAD", 10, "reply_in_thread", r212, r213, r214);
        REPLY_IN_THREAD = r109;
        boolean r215 = false;
        int r216 = 2;
        DefaultConstructorMarker r310 = null;
        MessageActionType r115 = new MessageActionType("MULTI_SELECT", 11, "multi_select", r215, r216, r310);
        MULTI_SELECT = r115;
        MessageActionType r116 = new MessageActionType("MUTE_DOCS_NOTIFICATION", 12, "mute_docs_notification", r212, r213, r214);
        MUTE_DOCS_NOTIFICATION = r116;
        MessageActionType r117 = new MessageActionType("COPY", 13, "copy", r215, r216, r310);
        COPY = r117;
        MessageActionType r118 = new MessageActionType("COPY_IMAGE_AND_MEDIA", 14, "copy", r212, r213, r214);
        COPY_IMAGE_AND_MEDIA = r118;
        MessageActionType r119 = new MessageActionType("ADD_FLAG", 15, ForwardDependency$ForwardLocation.FLAG, r215, r216, r310);
        ADD_FLAG = r119;
        MessageActionType r120 = new MessageActionType("ADD_TO_FAVORITE", 16, "favorite", r212, r213, r214);
        ADD_TO_FAVORITE = r120;
        MessageActionType r121 = new MessageActionType("PIN", 17, "pin", r215, r216, r310);
        PIN = r121;
        MessageActionType r217 = new MessageActionType("CHAT_PIN", 18, "chat_pin", false, 2, null);
        CHAT_PIN = r217;
        boolean r311 = false;
        int r312 = 2;
        DefaultConstructorMarker r313 = null;
        MessageActionType r122 = new MessageActionType("CHAT_PIN_MENU", 19, "", r311, r312, r313);
        CHAT_PIN_MENU = r122;
        boolean r314 = false;
        int r315 = 2;
        DefaultConstructorMarker r316 = null;
        MessageActionType r123 = new MessageActionType("PIN_TO_TOP", 20, "pin_to_top", r314, r315, r316);
        PIN_TO_TOP = r123;
        MessageActionType r218 = new MessageActionType("COPY_MESSAGE_LINK", 21, "copy_link", r311, r312, r313);
        COPY_MESSAGE_LINK = r218;
        MessageActionType r219 = new MessageActionType("ADD_STICKER", 22, "add_sticker", r314, r315, r316);
        ADD_STICKER = r219;
        MessageActionType r220 = new MessageActionType("IMAGE_TO_STICKER", 23, "add_sticker", r311, r312, r313);
        IMAGE_TO_STICKER = r220;
        MessageActionType r221 = new MessageActionType("ADD_TASK", 24, "add_task", r314, r315, r316);
        ADD_TASK = r221;
        MessageActionType r222 = new MessageActionType("BACK_TO_CHAT", 25, "back_to_chat", r311, r312, r313);
        BACK_TO_CHAT = r222;
        MessageActionType r223 = new MessageActionType("MESSAGE_RESTRICT", 26, "message_restrict", r314, r315, r316);
        MESSAGE_RESTRICT = r223;
        MessageActionType r317 = new MessageActionType("TRANSLATE", 27, "translate", false, 2, null);
        TRANSLATE = r317;
        boolean r318 = false;
        int r410 = 2;
        DefaultConstructorMarker r411 = null;
        MessageActionType r224 = new MessageActionType("SWITCH_TRANSLATION_LANGUAGE", 28, "switch_translate_language", r318, r410, r411);
        SWITCH_TRANSLATION_LANGUAGE = r224;
        boolean r412 = false;
        int r413 = 2;
        DefaultConstructorMarker r414 = null;
        MessageActionType r225 = new MessageActionType("MEEGO", 29, TaskType.MEEGO_TASK, r412, r413, r414);
        MEEGO = r225;
        MessageActionType r226 = new MessageActionType("SEARCH", 30, "search", r318, r410, r411);
        SEARCH = r226;
        MessageActionType r319 = new MessageActionType("SEARCH_EXTERNAL", 31, "search_external", r412, r413, r414);
        SEARCH_EXTERNAL = r319;
        MessageActionType r320 = new MessageActionType("TOGGLE_URL_PREVIEW", 32, "hide_url_preview", r318, r410, r411);
        TOGGLE_URL_PREVIEW = r320;
        MessageActionType r321 = new MessageActionType("EDIT_IMAGE", 33, "edit_image", r412, r413, r414);
        EDIT_IMAGE = r321;
        MessageActionType r322 = new MessageActionType("EXPORT_MESSAGE_TO_DOC", 34, "export_message_to_doc", r318, r410, r411);
        EXPORT_MESSAGE_TO_DOC = r322;
        MessageActionType r323 = new MessageActionType("DELETE", 35, "delete", r412, r413, r414);
        DELETE = r323;
        MessageActionType r415 = new MessageActionType("SHORTCUTS", 36, "shortcuts", false, 2, null);
        SHORTCUTS = r415;
        boolean r416 = false;
        int r417 = 2;
        DefaultConstructorMarker r510 = null;
        MessageActionType r324 = new MessageActionType("HYPER_TRANSLATE", 37, "hyper_translate", r416, r417, r510);
        HYPER_TRANSLATE = r324;
        boolean r511 = false;
        int r512 = 2;
        DefaultConstructorMarker r513 = null;
        MessageActionType r325 = new MessageActionType("SAVE_TO", 38, "", r511, r512, r513);
        SAVE_TO = r325;
        MessageActionType r326 = new MessageActionType("MY_AI_DEBUG_MODE", 39, "my_ai_debug_mode", r416, r417, r510);
        MY_AI_DEBUG_MODE = r326;
        MessageActionType r327 = new MessageActionType("MY_AI_UP_VOTE", 40, "my_ai_up_vote", r511, r512, r513);
        MY_AI_UP_VOTE = r327;
        MessageActionType r418 = new MessageActionType("MY_AI_DOWN_VOTE", 41, "my_ai_down_vote", r416, r417, r510);
        MY_AI_DOWN_VOTE = r418;
        MessageActionType r419 = new MessageActionType("COPY_URL_LINK", 42, "copy_url_link", r511, r512, r513);
        COPY_URL_LINK = r419;
        MessageActionType r420 = new MessageActionType("MY_AI_ANSWER_PROCESS", 43, "my_ai_answer_process", r416, r417, r510);
        MY_AI_ANSWER_PROCESS = r420;
        MessageActionType r124 = new MessageActionType("COPY_MESSAGE_ID", 44, "", true);
        COPY_MESSAGE_ID = r124;
        boolean r514 = false;
        int r515 = 2;
        DefaultConstructorMarker r516 = null;
        MessageActionType r125 = new MessageActionType("KA", 45, "ka", r514, r515, r516);
        KA = r125;
        MessageActionType r126 = new MessageActionType("ZONE_COPY", 46, "full_copy", false, 2, null);
        ZONE_COPY = r126;
        MessageActionType r517 = new MessageActionType("ZONE_SEARCH", 47, "full_search", r514, r515, r516);
        ZONE_SEARCH = r517;
        boolean r610 = false;
        int r611 = 2;
        DefaultConstructorMarker r612 = null;
        MessageActionType r421 = new MessageActionType("ZONE_SEARCH_EXTERNAL", 48, "full_search_external", r610, r611, r612);
        ZONE_SEARCH_EXTERNAL = r421;
        boolean r613 = false;
        int r614 = 2;
        DefaultConstructorMarker r710 = null;
        MessageActionType r518 = new MessageActionType("ZONE_HYPER_TRANSLATE", 49, "full_hyper_translate", r613, r614, r710);
        ZONE_HYPER_TRANSLATE = r518;
        MessageActionType r519 = new MessageActionType("ZONE_REPLY", 50, "full_zone_reply", r610, r611, r612);
        ZONE_REPLY = r519;
        MessageActionType r520 = new MessageActionType("SMART_REPLY", 51, "ai_reply", r613, r614, r710);
        SMART_REPLY = r520;
        MessageActionType r521 = new MessageActionType("AI_SHARE", 52, "answer_share", r610, r611, r612);
        AI_SHARE = r521;
        MessageActionType r522 = new MessageActionType("FLOW_LIKE", 53, "flow_like", r613, r614, r710);
        FLOW_LIKE = r522;
        MessageActionType r523 = new MessageActionType("FLOW_DISLIKE", 54, "flow_dislike", r610, r611, r612);
        FLOW_DISLIKE = r523;
        MessageActionType r524 = new MessageActionType("FLOW_FEEDBACK", 55, "flow_feedback", r613, r614, r710);
        FLOW_FEEDBACK = r524;
        MessageActionType r615 = new MessageActionType("FLOW_MORE", 56, "flow_more", false, 2, null);
        FLOW_MORE = r615;
        boolean r711 = false;
        int r712 = 2;
        DefaultConstructorMarker r713 = null;
        MessageActionType r525 = new MessageActionType("SELECT_TEXT", 57, "select_text", r711, r712, r713);
        SELECT_TEXT = r525;
        boolean r714 = false;
        int r715 = 2;
        DefaultConstructorMarker r716 = null;
        MessageActionType r526 = new MessageActionType("CREATE_DOC", 58, "create_doc", r714, r715, r716);
        CREATE_DOC = r526;
        MessageActionType r616 = new MessageActionType("FOLLOW_UP_QUESTION", 59, "follow_up_question", r711, r712, r713);
        FOLLOW_UP_QUESTION = r616;
        MessageActionType r617 = new MessageActionType("FLOW_ASK_DOUBAO", 60, "flow_ask_doubao", r714, r715, r716);
        FLOW_ASK_DOUBAO = r617;
        MessageActionType r618 = new MessageActionType("WORDS_ASK_DOUBAO", 61, "ask_flow", r711, r712, r713);
        WORDS_ASK_DOUBAO = r618;
        MessageActionType r619 = new MessageActionType("DOUBAO_SAVE_IMAGE", 62, "doubao_save_image", r714, r715, r716);
        DOUBAO_SAVE_IMAGE = r619;
        MessageActionType r620 = new MessageActionType("DOUBAO_SHARE_IMAGE", 63, "doubao_share_image", r711, r712, r713);
        DOUBAO_SHARE_IMAGE = r620;
        MessageActionType r621 = new MessageActionType("DOUBAO_SAVE_VIDEO", 64, "doubao_save_video", r714, r715, r716);
        DOUBAO_SAVE_VIDEO = r621;
        MessageActionType r717 = new MessageActionType("DOUBAO_SHARE_VIDEO", 65, "doubao_share_video", false, 2, null);
        DOUBAO_SHARE_VIDEO = r717;
        boolean r718 = false;
        int r810 = 2;
        DefaultConstructorMarker r811 = null;
        MessageActionType r622 = new MessageActionType("DOUBAO_TTS", 66, "doubao_tts", r718, r810, r811);
        DOUBAO_TTS = r622;
        MessageActionType r623 = new MessageActionType("MESSAGE_SOURCE_INFO", 67, "message_source_info", false, 2, null);
        MESSAGE_SOURCE_INFO = r623;
        MessageActionType r624 = new MessageActionType("CLOSE_TOPIC", 68, "close_topic", r718, r810, r811);
        CLOSE_TOPIC = r624;
        MessageActionType[] r127 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r114, r109, r115, r116, r117, r118, r119, r120, r121, r217, r122, r123, r218, r219, r220, r221, r222, r223, r317, r224, r225, r226, r319, r320, r321, r322, r323, r415, r324, r325, r326, r327, r418, r419, r420, r124, r125, r126, r517, r421, r518, r519, r520, r521, r522, r523, r524, r615, r525, r526, r616, r617, r618, r619, r620, r621, r717, r622, r623, r624};
        f410499a = r127;
        f410500b = EnumEntriesKt.enumEntries(r127);
    }

    public static MessageActionType[] values() {
        return (MessageActionType[]) f410499a.clone();
    }

    public final boolean getIgnoreSetting() {
        return this.ignoreSetting;
    }

    public final String getKey() {
        return this.key;
    }

    public static MessageActionType valueOf(String r100) {
        return (MessageActionType) a.a(MessageActionType.class, r100);
    }

    public MessageActionType(String r100, int r101, String r102, boolean r103) {
        super(r100, r101);
        this.key = r102;
        this.ignoreSetting = r103;
    }

    public /* synthetic */ MessageActionType(String r100, int r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = false;
    L5:
        this(r100, r101, r102, r103);
    }
}
