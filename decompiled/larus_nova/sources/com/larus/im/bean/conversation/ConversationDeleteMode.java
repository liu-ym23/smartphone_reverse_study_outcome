package com.larus.im.bean.conversation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/larus/im/bean/conversation/ConversationDeleteMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "DeleteMode_Unknown", "DeleteMode_RemoveFromChain", "DeleteMode_RealDelete", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversationDeleteMode extends Enum<ConversationDeleteMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ConversationDeleteMode[] $VALUES = null;
    public static final a Companion = null;

    @SerialName("2")
    public static final ConversationDeleteMode DeleteMode_RealDelete = null;

    @SerialName("1")
    public static final ConversationDeleteMode DeleteMode_RemoveFromChain = null;

    @SerialName("0")
    public static final ConversationDeleteMode DeleteMode_Unknown = null;
    public final int value;

    private static final /* synthetic */ ConversationDeleteMode[] $values() {
        return new ConversationDeleteMode[]{DeleteMode_Unknown, DeleteMode_RemoveFromChain, DeleteMode_RealDelete};
    }

    public static EnumEntries<ConversationDeleteMode> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.im.bean.conversation.ConversationDeleteMode$a] */
    static {
        DeleteMode_Unknown = new ConversationDeleteMode("DeleteMode_Unknown", 0, 0);
        DeleteMode_RemoveFromChain = new ConversationDeleteMode("DeleteMode_RemoveFromChain", 1, 1);
        DeleteMode_RealDelete = new ConversationDeleteMode("DeleteMode_RealDelete", 2, 2);
        ConversationDeleteMode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static ConversationDeleteMode[] values() {
        return (ConversationDeleteMode[]) $VALUES.clone();
    }

    public static ConversationDeleteMode valueOf(String r100) {
        return (ConversationDeleteMode) r27.a.a(ConversationDeleteMode.class, r100);
    }

    private ConversationDeleteMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
