package com.larus.bmhome.chat;

import com.larus.bmhome.chat.bean.SuggestActionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/ChatLandingChannel;", "", "channel", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "COLD_PURE_CHAT", "COLD_VIDEO_CHAT", "COLD_MULTI_CHAT", "CHAT_LIST", "PROFILE_INFO_VIEW", SuggestActionType.BOT_RECOMMEND, "HOME_SEARCH", "BOT_CREATE", "BOT_DISCOVER", "CHAT_BRIDGE", "CREATE_NEW_BOT", "PROFILE_BOT_LIST", "UGC_LANDING", "START_OTHER", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatLandingChannel extends Enum<ChatLandingChannel> {
    public static final ChatLandingChannel BOT_CREATE = null;
    public static final ChatLandingChannel BOT_DISCOVER = null;
    public static final ChatLandingChannel BOT_RECOMMEND = null;
    public static final ChatLandingChannel CHAT_BRIDGE = null;
    public static final ChatLandingChannel CHAT_LIST = null;
    public static final ChatLandingChannel COLD_MULTI_CHAT = null;
    public static final ChatLandingChannel COLD_PURE_CHAT = null;
    public static final ChatLandingChannel COLD_VIDEO_CHAT = null;
    public static final ChatLandingChannel CREATE_NEW_BOT = null;
    public static final ChatLandingChannel HOME_SEARCH = null;
    public static final ChatLandingChannel PROFILE_BOT_LIST = null;
    public static final ChatLandingChannel PROFILE_INFO_VIEW = null;
    public static final ChatLandingChannel START_OTHER = null;
    public static final ChatLandingChannel UGC_LANDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatLandingChannel[] f296887a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f296888b = null;
    private final String channel;

    public static EnumEntries<ChatLandingChannel> getEntries() {
        return f296888b;
    }

    static {
        ChatLandingChannel r100 = new ChatLandingChannel("COLD_PURE_CHAT", 0, "cold_pure_chat");
        COLD_PURE_CHAT = r100;
        ChatLandingChannel r101 = new ChatLandingChannel("COLD_VIDEO_CHAT", 1, "cold_video_chat");
        COLD_VIDEO_CHAT = r101;
        ChatLandingChannel r102 = new ChatLandingChannel("COLD_MULTI_CHAT", 2, "cold_multi_chat");
        COLD_MULTI_CHAT = r102;
        ChatLandingChannel r103 = new ChatLandingChannel("CHAT_LIST", 3, "chat_list");
        CHAT_LIST = r103;
        ChatLandingChannel r104 = new ChatLandingChannel("PROFILE_INFO_VIEW", 4, "profile");
        PROFILE_INFO_VIEW = r104;
        ChatLandingChannel r105 = new ChatLandingChannel(SuggestActionType.BOT_RECOMMEND, 5, "bot_recommend");
        BOT_RECOMMEND = r105;
        ChatLandingChannel r110 = new ChatLandingChannel("HOME_SEARCH", 6, "home_search");
        HOME_SEARCH = r110;
        ChatLandingChannel r111 = new ChatLandingChannel("BOT_CREATE", 7, "bot_create");
        BOT_CREATE = r111;
        ChatLandingChannel r112 = new ChatLandingChannel("BOT_DISCOVER", 8, "bot_discover");
        BOT_DISCOVER = r112;
        ChatLandingChannel r113 = new ChatLandingChannel("CHAT_BRIDGE", 9, "chat_bridge");
        CHAT_BRIDGE = r113;
        ChatLandingChannel r114 = new ChatLandingChannel("CREATE_NEW_BOT", 10, "create_new_bot");
        CREATE_NEW_BOT = r114;
        ChatLandingChannel r106 = new ChatLandingChannel("PROFILE_BOT_LIST", 11, "profile_bot_list");
        PROFILE_BOT_LIST = r106;
        ChatLandingChannel r107 = new ChatLandingChannel("UGC_LANDING", 12, "ugc_landing");
        UGC_LANDING = r107;
        ChatLandingChannel r108 = new ChatLandingChannel("START_OTHER", 13, "other");
        START_OTHER = r108;
        ChatLandingChannel[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108};
        f296887a = r109;
        f296888b = EnumEntriesKt.enumEntries(r109);
    }

    public static ChatLandingChannel[] values() {
        return (ChatLandingChannel[]) f296887a.clone();
    }

    public final String getChannel() {
        return this.channel;
    }

    public static ChatLandingChannel valueOf(String r100) {
        return (ChatLandingChannel) r27.a.a(ChatLandingChannel.class, r100);
    }

    public ChatLandingChannel(String r100, int r101, String r102) {
        super(r100, r101);
        this.channel = r102;
    }
}
