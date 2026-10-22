package com.ss.android.lark.chat.entity.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTnsOpKind;", "", "tnsOpKind", "", "<init>", "(Ljava/lang/String;II)V", "getTnsOpKind", "()I", "TNS_OP_NONE", "TNS_OP_BANNED", "TNS_OP_DISSOLVED", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatTnsOpKind extends Enum<ChatTnsOpKind> {
    public static final ChatTnsOpKind TNS_OP_BANNED = null;
    public static final ChatTnsOpKind TNS_OP_DISSOLVED = null;
    public static final ChatTnsOpKind TNS_OP_NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatTnsOpKind[] f415163a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415164b = null;
    private final int tnsOpKind;

    public static EnumEntries<ChatTnsOpKind> getEntries() {
        return f415164b;
    }

    static {
        ChatTnsOpKind r100 = new ChatTnsOpKind("TNS_OP_NONE", 0, 0);
        TNS_OP_NONE = r100;
        ChatTnsOpKind r101 = new ChatTnsOpKind("TNS_OP_BANNED", 1, 1);
        TNS_OP_BANNED = r101;
        ChatTnsOpKind r102 = new ChatTnsOpKind("TNS_OP_DISSOLVED", 2, 2);
        TNS_OP_DISSOLVED = r102;
        ChatTnsOpKind[] r103 = {r100, r101, r102};
        f415163a = r103;
        f415164b = EnumEntriesKt.enumEntries(r103);
    }

    public static ChatTnsOpKind[] values() {
        return (ChatTnsOpKind[]) f415163a.clone();
    }

    public final int getTnsOpKind() {
        return this.tnsOpKind;
    }

    public static ChatTnsOpKind valueOf(String r100) {
        return (ChatTnsOpKind) r27.a.a(ChatTnsOpKind.class, r100);
    }

    public ChatTnsOpKind(String r100, int r101, int r102) {
        super(r100, r101);
        this.tnsOpKind = r102;
    }
}
