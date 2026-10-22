package com.ss.android.lark.intent.export.entity.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SendChatInfoType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CHAT", "CHATTER", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SendChatInfoType extends Enum<SendChatInfoType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SendChatInfoType[] $VALUES = null;
    public static final SendChatInfoType CHAT = null;
    public static final SendChatInfoType CHATTER = null;
    public static final SendChatInfoType UNKNOWN = null;

    private static final /* synthetic */ SendChatInfoType[] $values() {
        return new SendChatInfoType[]{UNKNOWN, CHAT, CHATTER};
    }

    public static EnumEntries<SendChatInfoType> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new SendChatInfoType("UNKNOWN", 0);
        CHAT = new SendChatInfoType("CHAT", 1);
        CHATTER = new SendChatInfoType("CHATTER", 2);
        SendChatInfoType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SendChatInfoType[] values() {
        return (SendChatInfoType[]) $VALUES.clone();
    }

    public static SendChatInfoType valueOf(String r100) {
        return (SendChatInfoType) a.a(SendChatInfoType.class, r100);
    }

    private SendChatInfoType(String r100, int r101) {
        super(r100, r101);
    }
}
