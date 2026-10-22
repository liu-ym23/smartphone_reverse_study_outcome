package com.ss.android.lark.keyboard.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "PROCESSING", "SUCCESS", "FAIL", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatAttachmentUploadState extends Enum<ChatAttachmentUploadState> {
    public static final a Companion = null;
    public static final ChatAttachmentUploadState DEFAULT = null;
    public static final ChatAttachmentUploadState FAIL = null;
    public static final ChatAttachmentUploadState PROCESSING = null;
    public static final ChatAttachmentUploadState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatAttachmentUploadState[] f428219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f428220b = null;
    private final int value;

    public static EnumEntries<ChatAttachmentUploadState> getEntries() {
        return f428220b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.keyboard.base.ChatAttachmentUploadState$a] */
    static {
        ChatAttachmentUploadState r100 = new ChatAttachmentUploadState("DEFAULT", 0, 0);
        DEFAULT = r100;
        ChatAttachmentUploadState r101 = new ChatAttachmentUploadState("PROCESSING", 1, 1);
        PROCESSING = r101;
        ChatAttachmentUploadState r102 = new ChatAttachmentUploadState("SUCCESS", 2, 2);
        SUCCESS = r102;
        ChatAttachmentUploadState r103 = new ChatAttachmentUploadState("FAIL", 3, 3);
        FAIL = r103;
        ChatAttachmentUploadState[] r104 = {r100, r101, r102, r103};
        f428219a = r104;
        f428220b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static ChatAttachmentUploadState[] values() {
        return (ChatAttachmentUploadState[]) f428219a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatAttachmentUploadState valueOf(String r100) {
        return (ChatAttachmentUploadState) r27.a.a(ChatAttachmentUploadState.class, r100);
    }

    public ChatAttachmentUploadState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
