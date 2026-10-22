package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/utils/FirstFeedSceneEnum;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "CVS_LIST", "CHAT_DETAIL", "CHAT_DETAIL_NEW_CONVERSATION", "BOT_DISCOVERY", "VIDEO_FEED", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FirstFeedSceneEnum extends Enum<FirstFeedSceneEnum> {
    public static final FirstFeedSceneEnum BOT_DISCOVERY = null;
    public static final FirstFeedSceneEnum CHAT_DETAIL = null;
    public static final FirstFeedSceneEnum CHAT_DETAIL_NEW_CONVERSATION = null;
    public static final FirstFeedSceneEnum CVS_LIST = null;
    public static final FirstFeedSceneEnum VIDEO_FEED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FirstFeedSceneEnum[] f314893a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314894b = null;
    private final String scene;

    public static EnumEntries<FirstFeedSceneEnum> getEntries() {
        return f314894b;
    }

    static {
        FirstFeedSceneEnum r100 = new FirstFeedSceneEnum("CVS_LIST", 0, "cvs_list");
        CVS_LIST = r100;
        FirstFeedSceneEnum r101 = new FirstFeedSceneEnum("CHAT_DETAIL", 1, "chat_detail");
        CHAT_DETAIL = r101;
        FirstFeedSceneEnum r102 = new FirstFeedSceneEnum("CHAT_DETAIL_NEW_CONVERSATION", 2, "chat_detail_new_conversation");
        CHAT_DETAIL_NEW_CONVERSATION = r102;
        FirstFeedSceneEnum r103 = new FirstFeedSceneEnum("BOT_DISCOVERY", 3, "bot_discovery");
        BOT_DISCOVERY = r103;
        FirstFeedSceneEnum r104 = new FirstFeedSceneEnum("VIDEO_FEED", 4, "video_feed");
        VIDEO_FEED = r104;
        FirstFeedSceneEnum[] r105 = {r100, r101, r102, r103, r104};
        f314893a = r105;
        f314894b = EnumEntriesKt.enumEntries(r105);
    }

    public static FirstFeedSceneEnum[] values() {
        return (FirstFeedSceneEnum[]) f314893a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static FirstFeedSceneEnum valueOf(String r100) {
        return (FirstFeedSceneEnum) r27.a.a(FirstFeedSceneEnum.class, r100);
    }

    public FirstFeedSceneEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
