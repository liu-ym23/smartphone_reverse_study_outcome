package com.ss.android.lark.chat.open.message;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.ss.android.lark.blueprint.j;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b:\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;¨\u0006<"}, d2 = {"Lcom/ss/android/lark/chat/open/message/IMMessageKeys$Blocks;", "Lcom/ss/android/lark/blueprint/IBlockKey;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN_CONTENT", "FLOW_UNKNOWN_CONTENT", "RECALLED_CONTENT", "RECALLED_SYSTEM_CONTENT", "SYSTEM_CONTENT", "TEXT_CONTENT", "MESSAGE_ATTACHMENT_LIST", "IMAGE_CONTENT", "URL_PREVIEW", "URL_PREVIEW_CONTENT", "SHARE_GROUP_CHAT_CONTENT", "STICKER_CONTENT", "FILE_CONTENT", "FOLDER_CONTENT", "POST_CONTENT", "MEDIA_CONTENT", "MERGE_FORWARD_CONTENT", "THREAD_FORWARD_CONTENT", "AUDIO_CONTENT", "FOLD_CONTENT", "SYS_CHAT_GUIDE", "SYS_RED_PACKET", "HIDE_CONTENT", "DOUBAO_CONTENT", "FLOW_PROFILE_CONTENT", "FLOW_THREAD_FORWARD_HEADER", "FLOW_THREAD_FORWARD_EXPOSURE", "FLOW_CALENDAR_CONTENT", "FLOW_VIDEO_CHAT_CONTENT", "FLOW_RED_PACKET_CONTENT", "FLOW_TODO_CONTENT", "AVATAR", "USERNAME", "COT_PROCESS", CardAdapter.REACTION, "REPLY_IN_THREAD_EXPOSURE", "REPLY", "MESSAGE_STATUS", "FLAG", "TIME", "REPLY_COUNT", "PIN_INFO", "DING_DESC", "DING_ICON", "MULTI_SELECT", "DLP", "FILE_DETECT", "EDIT_STATUS", "RESTRICTED", "THREAD_REPLY", "APP_INFO_SOURCE", "AI_SMART_REPLY", "AI_SMART_REPLY_APPLY_ANSWER", "TRANSLATION_ENTRY", "EXCEL_PERMISSION", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IMMessageKeys$Blocks extends Enum<IMMessageKeys$Blocks> implements j {
    public static final IMMessageKeys$Blocks AI_SMART_REPLY = null;
    public static final IMMessageKeys$Blocks AI_SMART_REPLY_APPLY_ANSWER = null;
    public static final IMMessageKeys$Blocks APP_INFO_SOURCE = null;
    public static final IMMessageKeys$Blocks AUDIO_CONTENT = null;
    public static final IMMessageKeys$Blocks AVATAR = null;
    public static final IMMessageKeys$Blocks COT_PROCESS = null;
    public static final IMMessageKeys$Blocks DING_DESC = null;
    public static final IMMessageKeys$Blocks DING_ICON = null;
    public static final IMMessageKeys$Blocks DLP = null;
    public static final IMMessageKeys$Blocks DOUBAO_CONTENT = null;
    public static final IMMessageKeys$Blocks EDIT_STATUS = null;
    public static final IMMessageKeys$Blocks EXCEL_PERMISSION = null;
    public static final IMMessageKeys$Blocks FILE_CONTENT = null;
    public static final IMMessageKeys$Blocks FILE_DETECT = null;
    public static final IMMessageKeys$Blocks FLAG = null;
    public static final IMMessageKeys$Blocks FLOW_CALENDAR_CONTENT = null;
    public static final IMMessageKeys$Blocks FLOW_PROFILE_CONTENT = null;
    public static final IMMessageKeys$Blocks FLOW_RED_PACKET_CONTENT = null;
    public static final IMMessageKeys$Blocks FLOW_THREAD_FORWARD_EXPOSURE = null;
    public static final IMMessageKeys$Blocks FLOW_THREAD_FORWARD_HEADER = null;
    public static final IMMessageKeys$Blocks FLOW_TODO_CONTENT = null;
    public static final IMMessageKeys$Blocks FLOW_UNKNOWN_CONTENT = null;
    public static final IMMessageKeys$Blocks FLOW_VIDEO_CHAT_CONTENT = null;
    public static final IMMessageKeys$Blocks FOLDER_CONTENT = null;
    public static final IMMessageKeys$Blocks FOLD_CONTENT = null;
    public static final IMMessageKeys$Blocks HIDE_CONTENT = null;
    public static final IMMessageKeys$Blocks IMAGE_CONTENT = null;
    public static final IMMessageKeys$Blocks MEDIA_CONTENT = null;
    public static final IMMessageKeys$Blocks MERGE_FORWARD_CONTENT = null;
    public static final IMMessageKeys$Blocks MESSAGE_ATTACHMENT_LIST = null;
    public static final IMMessageKeys$Blocks MESSAGE_STATUS = null;
    public static final IMMessageKeys$Blocks MULTI_SELECT = null;
    public static final IMMessageKeys$Blocks PIN_INFO = null;
    public static final IMMessageKeys$Blocks POST_CONTENT = null;
    public static final IMMessageKeys$Blocks REACTION = null;
    public static final IMMessageKeys$Blocks RECALLED_CONTENT = null;
    public static final IMMessageKeys$Blocks RECALLED_SYSTEM_CONTENT = null;
    public static final IMMessageKeys$Blocks REPLY = null;
    public static final IMMessageKeys$Blocks REPLY_COUNT = null;
    public static final IMMessageKeys$Blocks REPLY_IN_THREAD_EXPOSURE = null;
    public static final IMMessageKeys$Blocks RESTRICTED = null;
    public static final IMMessageKeys$Blocks SHARE_GROUP_CHAT_CONTENT = null;
    public static final IMMessageKeys$Blocks STICKER_CONTENT = null;
    public static final IMMessageKeys$Blocks SYSTEM_CONTENT = null;
    public static final IMMessageKeys$Blocks SYS_CHAT_GUIDE = null;
    public static final IMMessageKeys$Blocks SYS_RED_PACKET = null;
    public static final IMMessageKeys$Blocks TEXT_CONTENT = null;
    public static final IMMessageKeys$Blocks THREAD_FORWARD_CONTENT = null;
    public static final IMMessageKeys$Blocks THREAD_REPLY = null;
    public static final IMMessageKeys$Blocks TIME = null;
    public static final IMMessageKeys$Blocks TRANSLATION_ENTRY = null;
    public static final IMMessageKeys$Blocks UNKNOWN_CONTENT = null;
    public static final IMMessageKeys$Blocks URL_PREVIEW = null;
    public static final IMMessageKeys$Blocks URL_PREVIEW_CONTENT = null;
    public static final IMMessageKeys$Blocks USERNAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMMessageKeys$Blocks[] f415962a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415963b = null;

    public static EnumEntries<IMMessageKeys$Blocks> getEntries() {
        return f415963b;
    }

    static {
        IMMessageKeys$Blocks r100 = new IMMessageKeys$Blocks("UNKNOWN_CONTENT", 0);
        UNKNOWN_CONTENT = r100;
        IMMessageKeys$Blocks r101 = new IMMessageKeys$Blocks("FLOW_UNKNOWN_CONTENT", 1);
        FLOW_UNKNOWN_CONTENT = r101;
        IMMessageKeys$Blocks r102 = new IMMessageKeys$Blocks("RECALLED_CONTENT", 2);
        RECALLED_CONTENT = r102;
        IMMessageKeys$Blocks r103 = new IMMessageKeys$Blocks("RECALLED_SYSTEM_CONTENT", 3);
        RECALLED_SYSTEM_CONTENT = r103;
        IMMessageKeys$Blocks r104 = new IMMessageKeys$Blocks("SYSTEM_CONTENT", 4);
        SYSTEM_CONTENT = r104;
        IMMessageKeys$Blocks r105 = new IMMessageKeys$Blocks("TEXT_CONTENT", 5);
        TEXT_CONTENT = r105;
        IMMessageKeys$Blocks r110 = new IMMessageKeys$Blocks("MESSAGE_ATTACHMENT_LIST", 6);
        MESSAGE_ATTACHMENT_LIST = r110;
        IMMessageKeys$Blocks r111 = new IMMessageKeys$Blocks("IMAGE_CONTENT", 7);
        IMAGE_CONTENT = r111;
        IMMessageKeys$Blocks r112 = new IMMessageKeys$Blocks("URL_PREVIEW", 8);
        URL_PREVIEW = r112;
        IMMessageKeys$Blocks r113 = new IMMessageKeys$Blocks("URL_PREVIEW_CONTENT", 9);
        URL_PREVIEW_CONTENT = r113;
        IMMessageKeys$Blocks r114 = new IMMessageKeys$Blocks("SHARE_GROUP_CHAT_CONTENT", 10);
        SHARE_GROUP_CHAT_CONTENT = r114;
        IMMessageKeys$Blocks r115 = new IMMessageKeys$Blocks("STICKER_CONTENT", 11);
        STICKER_CONTENT = r115;
        IMMessageKeys$Blocks r106 = new IMMessageKeys$Blocks("FILE_CONTENT", 12);
        FILE_CONTENT = r106;
        IMMessageKeys$Blocks r107 = new IMMessageKeys$Blocks("FOLDER_CONTENT", 13);
        FOLDER_CONTENT = r107;
        IMMessageKeys$Blocks r108 = new IMMessageKeys$Blocks("POST_CONTENT", 14);
        POST_CONTENT = r108;
        IMMessageKeys$Blocks r109 = new IMMessageKeys$Blocks("MEDIA_CONTENT", 15);
        MEDIA_CONTENT = r109;
        IMMessageKeys$Blocks r116 = new IMMessageKeys$Blocks("MERGE_FORWARD_CONTENT", 16);
        MERGE_FORWARD_CONTENT = r116;
        IMMessageKeys$Blocks r117 = new IMMessageKeys$Blocks("THREAD_FORWARD_CONTENT", 17);
        THREAD_FORWARD_CONTENT = r117;
        IMMessageKeys$Blocks r118 = new IMMessageKeys$Blocks("AUDIO_CONTENT", 18);
        AUDIO_CONTENT = r118;
        IMMessageKeys$Blocks r119 = new IMMessageKeys$Blocks("FOLD_CONTENT", 19);
        FOLD_CONTENT = r119;
        IMMessageKeys$Blocks r120 = new IMMessageKeys$Blocks("SYS_CHAT_GUIDE", 20);
        SYS_CHAT_GUIDE = r120;
        IMMessageKeys$Blocks r121 = new IMMessageKeys$Blocks("SYS_RED_PACKET", 21);
        SYS_RED_PACKET = r121;
        IMMessageKeys$Blocks r122 = new IMMessageKeys$Blocks("HIDE_CONTENT", 22);
        HIDE_CONTENT = r122;
        IMMessageKeys$Blocks r123 = new IMMessageKeys$Blocks("DOUBAO_CONTENT", 23);
        DOUBAO_CONTENT = r123;
        IMMessageKeys$Blocks r124 = new IMMessageKeys$Blocks("FLOW_PROFILE_CONTENT", 24);
        FLOW_PROFILE_CONTENT = r124;
        IMMessageKeys$Blocks r125 = new IMMessageKeys$Blocks("FLOW_THREAD_FORWARD_HEADER", 25);
        FLOW_THREAD_FORWARD_HEADER = r125;
        IMMessageKeys$Blocks r126 = new IMMessageKeys$Blocks("FLOW_THREAD_FORWARD_EXPOSURE", 26);
        FLOW_THREAD_FORWARD_EXPOSURE = r126;
        IMMessageKeys$Blocks r127 = new IMMessageKeys$Blocks("FLOW_CALENDAR_CONTENT", 27);
        FLOW_CALENDAR_CONTENT = r127;
        IMMessageKeys$Blocks r128 = new IMMessageKeys$Blocks("FLOW_VIDEO_CHAT_CONTENT", 28);
        FLOW_VIDEO_CHAT_CONTENT = r128;
        IMMessageKeys$Blocks r129 = new IMMessageKeys$Blocks("FLOW_RED_PACKET_CONTENT", 29);
        FLOW_RED_PACKET_CONTENT = r129;
        IMMessageKeys$Blocks r130 = new IMMessageKeys$Blocks("FLOW_TODO_CONTENT", 30);
        FLOW_TODO_CONTENT = r130;
        IMMessageKeys$Blocks r131 = new IMMessageKeys$Blocks("AVATAR", 31);
        AVATAR = r131;
        IMMessageKeys$Blocks r132 = new IMMessageKeys$Blocks("USERNAME", 32);
        USERNAME = r132;
        IMMessageKeys$Blocks r133 = new IMMessageKeys$Blocks("COT_PROCESS", 33);
        COT_PROCESS = r133;
        IMMessageKeys$Blocks r134 = new IMMessageKeys$Blocks(CardAdapter.REACTION, 34);
        REACTION = r134;
        IMMessageKeys$Blocks r135 = new IMMessageKeys$Blocks("REPLY_IN_THREAD_EXPOSURE", 35);
        REPLY_IN_THREAD_EXPOSURE = r135;
        IMMessageKeys$Blocks r136 = new IMMessageKeys$Blocks("REPLY", 36);
        REPLY = r136;
        IMMessageKeys$Blocks r137 = new IMMessageKeys$Blocks("MESSAGE_STATUS", 37);
        MESSAGE_STATUS = r137;
        IMMessageKeys$Blocks r138 = new IMMessageKeys$Blocks("FLAG", 38);
        FLAG = r138;
        IMMessageKeys$Blocks r139 = new IMMessageKeys$Blocks("TIME", 39);
        TIME = r139;
        IMMessageKeys$Blocks r140 = new IMMessageKeys$Blocks("REPLY_COUNT", 40);
        REPLY_COUNT = r140;
        IMMessageKeys$Blocks r141 = new IMMessageKeys$Blocks("PIN_INFO", 41);
        PIN_INFO = r141;
        IMMessageKeys$Blocks r142 = new IMMessageKeys$Blocks("DING_DESC", 42);
        DING_DESC = r142;
        IMMessageKeys$Blocks r143 = new IMMessageKeys$Blocks("DING_ICON", 43);
        DING_ICON = r143;
        IMMessageKeys$Blocks r144 = new IMMessageKeys$Blocks("MULTI_SELECT", 44);
        MULTI_SELECT = r144;
        IMMessageKeys$Blocks r145 = new IMMessageKeys$Blocks("DLP", 45);
        DLP = r145;
        IMMessageKeys$Blocks r146 = new IMMessageKeys$Blocks("FILE_DETECT", 46);
        FILE_DETECT = r146;
        IMMessageKeys$Blocks r147 = new IMMessageKeys$Blocks("EDIT_STATUS", 47);
        EDIT_STATUS = r147;
        IMMessageKeys$Blocks r148 = new IMMessageKeys$Blocks("RESTRICTED", 48);
        RESTRICTED = r148;
        IMMessageKeys$Blocks r149 = new IMMessageKeys$Blocks("THREAD_REPLY", 49);
        THREAD_REPLY = r149;
        IMMessageKeys$Blocks r150 = new IMMessageKeys$Blocks("APP_INFO_SOURCE", 50);
        APP_INFO_SOURCE = r150;
        IMMessageKeys$Blocks r151 = new IMMessageKeys$Blocks("AI_SMART_REPLY", 51);
        AI_SMART_REPLY = r151;
        IMMessageKeys$Blocks r152 = new IMMessageKeys$Blocks("AI_SMART_REPLY_APPLY_ANSWER", 52);
        AI_SMART_REPLY_APPLY_ANSWER = r152;
        IMMessageKeys$Blocks r153 = new IMMessageKeys$Blocks("TRANSLATION_ENTRY", 53);
        TRANSLATION_ENTRY = r153;
        IMMessageKeys$Blocks r154 = new IMMessageKeys$Blocks("EXCEL_PERMISSION", 54);
        EXCEL_PERMISSION = r154;
        IMMessageKeys$Blocks[] r155 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154};
        f415962a = r155;
        f415963b = EnumEntriesKt.enumEntries(r155);
    }

    public static IMMessageKeys$Blocks[] values() {
        return (IMMessageKeys$Blocks[]) f415962a.clone();
    }

    public static IMMessageKeys$Blocks valueOf(String r100) {
        return (IMMessageKeys$Blocks) a.a(IMMessageKeys$Blocks.class, r100);
    }

    public IMMessageKeys$Blocks(String r100, int r101) {
        super(r100, r101);
    }
}
