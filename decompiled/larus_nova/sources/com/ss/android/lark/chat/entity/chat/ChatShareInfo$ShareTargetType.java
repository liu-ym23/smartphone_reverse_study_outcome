package com.ss.android.lark.chat.entity.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatShareInfo$ShareTargetType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TARGET_TYPE", "TARGET_CHAT", "TARGET_CHATTER", "TARGET_QRCODE", "TARGET_DOC", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatShareInfo$ShareTargetType extends Enum<ChatShareInfo$ShareTargetType> {
    public static final a Companion = null;
    public static final ChatShareInfo$ShareTargetType TARGET_CHAT = null;
    public static final ChatShareInfo$ShareTargetType TARGET_CHATTER = null;
    public static final ChatShareInfo$ShareTargetType TARGET_DOC = null;
    public static final ChatShareInfo$ShareTargetType TARGET_QRCODE = null;
    public static final ChatShareInfo$ShareTargetType UNKNOWN_TARGET_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatShareInfo$ShareTargetType[] f415152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415153b = null;
    private final int value;

    public static EnumEntries<ChatShareInfo$ShareTargetType> getEntries() {
        return f415153b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.entity.chat.ChatShareInfo$ShareTargetType$a] */
    static {
        ChatShareInfo$ShareTargetType r100 = new ChatShareInfo$ShareTargetType("UNKNOWN_TARGET_TYPE", 0, 0);
        UNKNOWN_TARGET_TYPE = r100;
        ChatShareInfo$ShareTargetType r101 = new ChatShareInfo$ShareTargetType("TARGET_CHAT", 1, 1);
        TARGET_CHAT = r101;
        ChatShareInfo$ShareTargetType r102 = new ChatShareInfo$ShareTargetType("TARGET_CHATTER", 2, 2);
        TARGET_CHATTER = r102;
        ChatShareInfo$ShareTargetType r103 = new ChatShareInfo$ShareTargetType("TARGET_QRCODE", 3, 3);
        TARGET_QRCODE = r103;
        ChatShareInfo$ShareTargetType r104 = new ChatShareInfo$ShareTargetType("TARGET_DOC", 4, 4);
        TARGET_DOC = r104;
        ChatShareInfo$ShareTargetType[] r105 = {r100, r101, r102, r103, r104};
        f415152a = r105;
        f415153b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static ChatShareInfo$ShareTargetType[] values() {
        return (ChatShareInfo$ShareTargetType[]) f415152a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatShareInfo$ShareTargetType valueOf(String r100) {
        return (ChatShareInfo$ShareTargetType) r27.a.a(ChatShareInfo$ShareTargetType.class, r100);
    }

    public ChatShareInfo$ShareTargetType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
