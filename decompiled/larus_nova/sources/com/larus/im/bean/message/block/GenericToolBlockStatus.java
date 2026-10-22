package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/im/bean/message/block/GenericToolBlockStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATUS_UNKNOWN", "STATUS_CANCEL", "STATUS_FINISH", "STATUS_FAIL", "STATUS_PROCESSING", "STATUS_PAUSE", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GenericToolBlockStatus extends Enum<GenericToolBlockStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ GenericToolBlockStatus[] $VALUES = null;
    public static final GenericToolBlockStatus STATUS_CANCEL = null;
    public static final GenericToolBlockStatus STATUS_FAIL = null;
    public static final GenericToolBlockStatus STATUS_FINISH = null;
    public static final GenericToolBlockStatus STATUS_PAUSE = null;
    public static final GenericToolBlockStatus STATUS_PROCESSING = null;
    public static final GenericToolBlockStatus STATUS_UNKNOWN = null;
    private final int value;

    private static final /* synthetic */ GenericToolBlockStatus[] $values() {
        return new GenericToolBlockStatus[]{STATUS_UNKNOWN, STATUS_CANCEL, STATUS_FINISH, STATUS_FAIL, STATUS_PROCESSING, STATUS_PAUSE};
    }

    public static EnumEntries<GenericToolBlockStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        STATUS_UNKNOWN = new GenericToolBlockStatus("STATUS_UNKNOWN", 0, 0);
        STATUS_CANCEL = new GenericToolBlockStatus("STATUS_CANCEL", 1, 1);
        STATUS_FINISH = new GenericToolBlockStatus("STATUS_FINISH", 2, 2);
        STATUS_FAIL = new GenericToolBlockStatus("STATUS_FAIL", 3, 3);
        STATUS_PROCESSING = new GenericToolBlockStatus("STATUS_PROCESSING", 4, 4);
        STATUS_PAUSE = new GenericToolBlockStatus("STATUS_PAUSE", 5, 5);
        GenericToolBlockStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static GenericToolBlockStatus[] values() {
        return (GenericToolBlockStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GenericToolBlockStatus valueOf(String r100) {
        return (GenericToolBlockStatus) a.a(GenericToolBlockStatus.class, r100);
    }

    private GenericToolBlockStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
