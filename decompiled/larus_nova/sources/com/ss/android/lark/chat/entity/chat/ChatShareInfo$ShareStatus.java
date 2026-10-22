package com.ss.android.lark.chat.entity.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatShareInfo$ShareStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATE", "ACTIVE", "EXPIRED", "DEACTIVATED", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatShareInfo$ShareStatus extends Enum<ChatShareInfo$ShareStatus> {
    public static final ChatShareInfo$ShareStatus ACTIVE = null;
    public static final a Companion = null;
    public static final ChatShareInfo$ShareStatus DEACTIVATED = null;
    public static final ChatShareInfo$ShareStatus EXPIRED = null;
    public static final ChatShareInfo$ShareStatus UNKNOWN_STATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatShareInfo$ShareStatus[] f415150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415151b = null;
    private final int value;

    public static EnumEntries<ChatShareInfo$ShareStatus> getEntries() {
        return f415151b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.entity.chat.ChatShareInfo$ShareStatus$a] */
    static {
        ChatShareInfo$ShareStatus r100 = new ChatShareInfo$ShareStatus("UNKNOWN_STATE", 0, 0);
        UNKNOWN_STATE = r100;
        ChatShareInfo$ShareStatus r101 = new ChatShareInfo$ShareStatus("ACTIVE", 1, 1);
        ACTIVE = r101;
        ChatShareInfo$ShareStatus r102 = new ChatShareInfo$ShareStatus("EXPIRED", 2, 2);
        EXPIRED = r102;
        ChatShareInfo$ShareStatus r103 = new ChatShareInfo$ShareStatus("DEACTIVATED", 3, 3);
        DEACTIVATED = r103;
        ChatShareInfo$ShareStatus[] r104 = {r100, r101, r102, r103};
        f415150a = r104;
        f415151b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static ChatShareInfo$ShareStatus[] values() {
        return (ChatShareInfo$ShareStatus[]) f415150a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatShareInfo$ShareStatus valueOf(String r100) {
        return (ChatShareInfo$ShareStatus) r27.a.a(ChatShareInfo$ShareStatus.class, r100);
    }

    public ChatShareInfo$ShareStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
