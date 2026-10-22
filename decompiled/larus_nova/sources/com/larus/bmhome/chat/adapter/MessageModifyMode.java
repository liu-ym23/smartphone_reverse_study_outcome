package com.larus.bmhome.chat.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/adapter/MessageModifyMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MODIFY_TO_REPLACE_TXT", "MODIFY_TO_REPLACE_TXT_AND_FILE", "MODIFY_TO_REGENERATE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageModifyMode extends Enum<MessageModifyMode> {
    public static final MessageModifyMode MODIFY_TO_REGENERATE = null;
    public static final MessageModifyMode MODIFY_TO_REPLACE_TXT = null;
    public static final MessageModifyMode MODIFY_TO_REPLACE_TXT_AND_FILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageModifyMode[] f297047a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297048b = null;
    private final int value;

    public static EnumEntries<MessageModifyMode> getEntries() {
        return f297048b;
    }

    static {
        MessageModifyMode r100 = new MessageModifyMode("MODIFY_TO_REPLACE_TXT", 0, 0);
        MODIFY_TO_REPLACE_TXT = r100;
        MessageModifyMode r101 = new MessageModifyMode("MODIFY_TO_REPLACE_TXT_AND_FILE", 1, 1);
        MODIFY_TO_REPLACE_TXT_AND_FILE = r101;
        MessageModifyMode r102 = new MessageModifyMode("MODIFY_TO_REGENERATE", 2, 2);
        MODIFY_TO_REGENERATE = r102;
        MessageModifyMode[] r103 = {r100, r101, r102};
        f297047a = r103;
        f297048b = EnumEntriesKt.enumEntries(r103);
    }

    public static MessageModifyMode[] values() {
        return (MessageModifyMode[]) f297047a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MessageModifyMode valueOf(String r100) {
        return (MessageModifyMode) r27.a.a(MessageModifyMode.class, r100);
    }

    public MessageModifyMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
