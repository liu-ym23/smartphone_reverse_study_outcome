package com.ss.android.lark.chat.entity.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatShareInfo$ShareType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "CARD_MESSAGE", "QRCODE", "CARD_DOC", "LINK", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatShareInfo$ShareType extends Enum<ChatShareInfo$ShareType> {
    public static final ChatShareInfo$ShareType CARD_DOC = null;
    public static final ChatShareInfo$ShareType CARD_MESSAGE = null;
    public static final a Companion = null;
    public static final ChatShareInfo$ShareType LINK = null;
    public static final ChatShareInfo$ShareType QRCODE = null;
    public static final ChatShareInfo$ShareType UNKNOWN_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatShareInfo$ShareType[] f415154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415155b = null;
    private final int value;

    public static EnumEntries<ChatShareInfo$ShareType> getEntries() {
        return f415155b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.entity.chat.ChatShareInfo$ShareType$a] */
    static {
        ChatShareInfo$ShareType r100 = new ChatShareInfo$ShareType("UNKNOWN_TYPE", 0, 0);
        UNKNOWN_TYPE = r100;
        ChatShareInfo$ShareType r101 = new ChatShareInfo$ShareType("CARD_MESSAGE", 1, 1);
        CARD_MESSAGE = r101;
        ChatShareInfo$ShareType r102 = new ChatShareInfo$ShareType("QRCODE", 2, 2);
        QRCODE = r102;
        ChatShareInfo$ShareType r103 = new ChatShareInfo$ShareType("CARD_DOC", 3, 3);
        CARD_DOC = r103;
        ChatShareInfo$ShareType r104 = new ChatShareInfo$ShareType("LINK", 4, 4);
        LINK = r104;
        ChatShareInfo$ShareType[] r105 = {r100, r101, r102, r103, r104};
        f415154a = r105;
        f415155b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static ChatShareInfo$ShareType[] values() {
        return (ChatShareInfo$ShareType[]) f415154a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatShareInfo$ShareType valueOf(String r100) {
        return (ChatShareInfo$ShareType) r27.a.a(ChatShareInfo$ShareType.class, r100);
    }

    public ChatShareInfo$ShareType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
