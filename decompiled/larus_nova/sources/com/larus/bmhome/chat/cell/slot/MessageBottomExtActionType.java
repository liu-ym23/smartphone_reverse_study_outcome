package com.larus.bmhome.chat.cell.slot;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageBottomExtActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "JUMP_DEEP_THINK", "FORCE_DEEP_THINK", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageBottomExtActionType extends Enum<MessageBottomExtActionType> {
    public static final MessageBottomExtActionType FORCE_DEEP_THINK = null;
    public static final MessageBottomExtActionType JUMP_DEEP_THINK = null;
    public static final MessageBottomExtActionType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageBottomExtActionType[] f297630a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297631b = null;
    private final int value;

    public static EnumEntries<MessageBottomExtActionType> getEntries() {
        return f297631b;
    }

    static {
        MessageBottomExtActionType r100 = new MessageBottomExtActionType("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        MessageBottomExtActionType r101 = new MessageBottomExtActionType("JUMP_DEEP_THINK", 1, 1);
        JUMP_DEEP_THINK = r101;
        MessageBottomExtActionType r102 = new MessageBottomExtActionType("FORCE_DEEP_THINK", 2, 2);
        FORCE_DEEP_THINK = r102;
        MessageBottomExtActionType[] r103 = {r100, r101, r102};
        f297630a = r103;
        f297631b = EnumEntriesKt.enumEntries(r103);
    }

    public static MessageBottomExtActionType[] values() {
        return (MessageBottomExtActionType[]) f297630a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MessageBottomExtActionType valueOf(String r100) {
        return (MessageBottomExtActionType) r27.a.a(MessageBottomExtActionType.class, r100);
    }

    public MessageBottomExtActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
