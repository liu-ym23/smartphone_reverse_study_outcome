package com.larus.platform.model.chat;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/chat/ChatAwemeFeedEntryMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, "DIRECT_SLIDE", "VIEW_MORE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatAwemeFeedEntryMode extends Enum<ChatAwemeFeedEntryMode> {
    public static final ChatAwemeFeedEntryMode DIRECT_SLIDE = null;
    public static final ChatAwemeFeedEntryMode NONE = null;
    public static final ChatAwemeFeedEntryMode VIEW_MORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatAwemeFeedEntryMode[] f365561a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365562b = null;
    private final int value;

    public static EnumEntries<ChatAwemeFeedEntryMode> getEntries() {
        return f365562b;
    }

    static {
        ChatAwemeFeedEntryMode r100 = new ChatAwemeFeedEntryMode(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        ChatAwemeFeedEntryMode r101 = new ChatAwemeFeedEntryMode("DIRECT_SLIDE", 1, 1);
        DIRECT_SLIDE = r101;
        ChatAwemeFeedEntryMode r102 = new ChatAwemeFeedEntryMode("VIEW_MORE", 2, 2);
        VIEW_MORE = r102;
        ChatAwemeFeedEntryMode[] r103 = {r100, r101, r102};
        f365561a = r103;
        f365562b = EnumEntriesKt.enumEntries(r103);
    }

    public static ChatAwemeFeedEntryMode[] values() {
        return (ChatAwemeFeedEntryMode[]) f365561a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatAwemeFeedEntryMode valueOf(String r100) {
        return (ChatAwemeFeedEntryMode) r27.a.a(ChatAwemeFeedEntryMode.class, r100);
    }

    public ChatAwemeFeedEntryMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
