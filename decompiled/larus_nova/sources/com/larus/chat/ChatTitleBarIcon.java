package com.larus.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/chat/ChatTitleBarIcon;", "", "<init>", "(Ljava/lang/String;I)V", "BACK", "COLLAPSE", "SIDE_NAV", "PAGE_SIZE", "SEARCH", "NEW_CONVERSATION", "TTS", "MORE", "ADD_BOT", "REAL_TIME_CALL", "HISTORY", "MULTITASK_MANAGEMENT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatTitleBarIcon extends Enum<ChatTitleBarIcon> {
    public static final ChatTitleBarIcon ADD_BOT = null;
    public static final ChatTitleBarIcon BACK = null;
    public static final ChatTitleBarIcon COLLAPSE = null;
    public static final ChatTitleBarIcon HISTORY = null;
    public static final ChatTitleBarIcon MORE = null;
    public static final ChatTitleBarIcon MULTITASK_MANAGEMENT = null;
    public static final ChatTitleBarIcon NEW_CONVERSATION = null;
    public static final ChatTitleBarIcon PAGE_SIZE = null;
    public static final ChatTitleBarIcon REAL_TIME_CALL = null;
    public static final ChatTitleBarIcon SEARCH = null;
    public static final ChatTitleBarIcon SIDE_NAV = null;
    public static final ChatTitleBarIcon TTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatTitleBarIcon[] f323901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323902b = null;

    public static EnumEntries<ChatTitleBarIcon> getEntries() {
        return f323902b;
    }

    static {
        ChatTitleBarIcon r100 = new ChatTitleBarIcon("BACK", 0);
        BACK = r100;
        ChatTitleBarIcon r101 = new ChatTitleBarIcon("COLLAPSE", 1);
        COLLAPSE = r101;
        ChatTitleBarIcon r102 = new ChatTitleBarIcon("SIDE_NAV", 2);
        SIDE_NAV = r102;
        ChatTitleBarIcon r103 = new ChatTitleBarIcon("PAGE_SIZE", 3);
        PAGE_SIZE = r103;
        ChatTitleBarIcon r104 = new ChatTitleBarIcon("SEARCH", 4);
        SEARCH = r104;
        ChatTitleBarIcon r105 = new ChatTitleBarIcon("NEW_CONVERSATION", 5);
        NEW_CONVERSATION = r105;
        ChatTitleBarIcon r110 = new ChatTitleBarIcon("TTS", 6);
        TTS = r110;
        ChatTitleBarIcon r111 = new ChatTitleBarIcon("MORE", 7);
        MORE = r111;
        ChatTitleBarIcon r112 = new ChatTitleBarIcon("ADD_BOT", 8);
        ADD_BOT = r112;
        ChatTitleBarIcon r113 = new ChatTitleBarIcon("REAL_TIME_CALL", 9);
        REAL_TIME_CALL = r113;
        ChatTitleBarIcon r114 = new ChatTitleBarIcon("HISTORY", 10);
        HISTORY = r114;
        ChatTitleBarIcon r115 = new ChatTitleBarIcon("MULTITASK_MANAGEMENT", 11);
        MULTITASK_MANAGEMENT = r115;
        ChatTitleBarIcon[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        f323901a = r106;
        f323902b = EnumEntriesKt.enumEntries(r106);
    }

    public static ChatTitleBarIcon[] values() {
        return (ChatTitleBarIcon[]) f323901a.clone();
    }

    public static ChatTitleBarIcon valueOf(String r100) {
        return (ChatTitleBarIcon) a.a(ChatTitleBarIcon.class, r100);
    }

    public ChatTitleBarIcon(String r100, int r101) {
        super(r100, r101);
    }
}
