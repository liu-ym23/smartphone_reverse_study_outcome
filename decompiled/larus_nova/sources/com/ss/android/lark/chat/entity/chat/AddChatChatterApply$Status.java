package com.ss.android.lark.chat.entity.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/AddChatChatterApply$Status;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATUS", "APPROVED", "REFUSED", "PROCESSING", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AddChatChatterApply$Status extends Enum<AddChatChatterApply$Status> {
    public static final AddChatChatterApply$Status APPROVED = null;
    public static final a Companion = null;
    public static final AddChatChatterApply$Status PROCESSING = null;
    public static final AddChatChatterApply$Status REFUSED = null;
    public static final AddChatChatterApply$Status UNKNOWN_STATUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AddChatChatterApply$Status[] f415097a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415098b = null;
    private final int value;

    public static EnumEntries<AddChatChatterApply$Status> getEntries() {
        return f415098b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.entity.chat.AddChatChatterApply$Status$a] */
    static {
        AddChatChatterApply$Status r100 = new AddChatChatterApply$Status("UNKNOWN_STATUS", 0, 0);
        UNKNOWN_STATUS = r100;
        AddChatChatterApply$Status r101 = new AddChatChatterApply$Status("APPROVED", 1, 1);
        APPROVED = r101;
        AddChatChatterApply$Status r102 = new AddChatChatterApply$Status("REFUSED", 2, 2);
        REFUSED = r102;
        AddChatChatterApply$Status r103 = new AddChatChatterApply$Status("PROCESSING", 3, 3);
        PROCESSING = r103;
        AddChatChatterApply$Status[] r104 = {r100, r101, r102, r103};
        f415097a = r104;
        f415098b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static AddChatChatterApply$Status[] values() {
        return (AddChatChatterApply$Status[]) f415097a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AddChatChatterApply$Status valueOf(String r100) {
        return (AddChatChatterApply$Status) r27.a.a(AddChatChatterApply$Status.class, r100);
    }

    public AddChatChatterApply$Status(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
