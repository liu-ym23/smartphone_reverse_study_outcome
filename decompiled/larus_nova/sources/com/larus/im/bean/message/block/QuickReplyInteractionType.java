package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/bean/message/block/QuickReplyInteractionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "QUICK_REPLY_INTERACTION_TYPE_UNKNOWN", "QUICK_REPLY_INTERACTION_TYPE_REQUEST_ACTION", "QUICK_REPLY_INTERACTION_TYPE_BASH_WARN", "QUICK_REPLY_INTERACTION_TYPE_AUTHORIZE_FOLDER", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickReplyInteractionType extends Enum<QuickReplyInteractionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ QuickReplyInteractionType[] $VALUES = null;
    public static final QuickReplyInteractionType QUICK_REPLY_INTERACTION_TYPE_AUTHORIZE_FOLDER = null;
    public static final QuickReplyInteractionType QUICK_REPLY_INTERACTION_TYPE_BASH_WARN = null;
    public static final QuickReplyInteractionType QUICK_REPLY_INTERACTION_TYPE_REQUEST_ACTION = null;
    public static final QuickReplyInteractionType QUICK_REPLY_INTERACTION_TYPE_UNKNOWN = null;
    private final int value;

    private static final /* synthetic */ QuickReplyInteractionType[] $values() {
        return new QuickReplyInteractionType[]{QUICK_REPLY_INTERACTION_TYPE_UNKNOWN, QUICK_REPLY_INTERACTION_TYPE_REQUEST_ACTION, QUICK_REPLY_INTERACTION_TYPE_BASH_WARN, QUICK_REPLY_INTERACTION_TYPE_AUTHORIZE_FOLDER};
    }

    public static EnumEntries<QuickReplyInteractionType> getEntries() {
        return $ENTRIES;
    }

    static {
        QUICK_REPLY_INTERACTION_TYPE_UNKNOWN = new QuickReplyInteractionType("QUICK_REPLY_INTERACTION_TYPE_UNKNOWN", 0, 0);
        QUICK_REPLY_INTERACTION_TYPE_REQUEST_ACTION = new QuickReplyInteractionType("QUICK_REPLY_INTERACTION_TYPE_REQUEST_ACTION", 1, 1);
        QUICK_REPLY_INTERACTION_TYPE_BASH_WARN = new QuickReplyInteractionType("QUICK_REPLY_INTERACTION_TYPE_BASH_WARN", 2, 2);
        QUICK_REPLY_INTERACTION_TYPE_AUTHORIZE_FOLDER = new QuickReplyInteractionType("QUICK_REPLY_INTERACTION_TYPE_AUTHORIZE_FOLDER", 3, 3);
        QuickReplyInteractionType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static QuickReplyInteractionType[] values() {
        return (QuickReplyInteractionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static QuickReplyInteractionType valueOf(String r100) {
        return (QuickReplyInteractionType) a.a(QuickReplyInteractionType.class, r100);
    }

    private QuickReplyInteractionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
