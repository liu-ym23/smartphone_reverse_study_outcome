package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/im/bean/message/block/QuickReplyHighlightType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "HIGHLIGHT_TYPE_UNKNOWN", "HIGHLIGHT_TYPE_CONFIRM", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickReplyHighlightType extends Enum<QuickReplyHighlightType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ QuickReplyHighlightType[] $VALUES = null;
    public static final QuickReplyHighlightType HIGHLIGHT_TYPE_CONFIRM = null;
    public static final QuickReplyHighlightType HIGHLIGHT_TYPE_UNKNOWN = null;
    private final int value;

    private static final /* synthetic */ QuickReplyHighlightType[] $values() {
        return new QuickReplyHighlightType[]{HIGHLIGHT_TYPE_UNKNOWN, HIGHLIGHT_TYPE_CONFIRM};
    }

    public static EnumEntries<QuickReplyHighlightType> getEntries() {
        return $ENTRIES;
    }

    static {
        HIGHLIGHT_TYPE_UNKNOWN = new QuickReplyHighlightType("HIGHLIGHT_TYPE_UNKNOWN", 0, 0);
        HIGHLIGHT_TYPE_CONFIRM = new QuickReplyHighlightType("HIGHLIGHT_TYPE_CONFIRM", 1, 1);
        QuickReplyHighlightType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static QuickReplyHighlightType[] values() {
        return (QuickReplyHighlightType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static QuickReplyHighlightType valueOf(String r100) {
        return (QuickReplyHighlightType) a.a(QuickReplyHighlightType.class, r100);
    }

    private QuickReplyHighlightType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
