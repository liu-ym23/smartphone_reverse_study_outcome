package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/message/block/QuickReplyBlockStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATUS_UNKNOWN", "STATUS_VISIBLE", "STATUS_HIDDEN", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QuickReplyBlockStatus extends Enum<QuickReplyBlockStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ QuickReplyBlockStatus[] $VALUES = null;
    public static final QuickReplyBlockStatus STATUS_HIDDEN = null;
    public static final QuickReplyBlockStatus STATUS_UNKNOWN = null;
    public static final QuickReplyBlockStatus STATUS_VISIBLE = null;
    private final int value;

    private static final /* synthetic */ QuickReplyBlockStatus[] $values() {
        return new QuickReplyBlockStatus[]{STATUS_UNKNOWN, STATUS_VISIBLE, STATUS_HIDDEN};
    }

    public static EnumEntries<QuickReplyBlockStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        STATUS_UNKNOWN = new QuickReplyBlockStatus("STATUS_UNKNOWN", 0, 0);
        STATUS_VISIBLE = new QuickReplyBlockStatus("STATUS_VISIBLE", 1, 1);
        STATUS_HIDDEN = new QuickReplyBlockStatus("STATUS_HIDDEN", 2, 2);
        QuickReplyBlockStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static QuickReplyBlockStatus[] values() {
        return (QuickReplyBlockStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static QuickReplyBlockStatus valueOf(String r100) {
        return (QuickReplyBlockStatus) a.a(QuickReplyBlockStatus.class, r100);
    }

    private QuickReplyBlockStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
