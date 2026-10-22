package com.larus.im.bean.conversation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/conversation/ArchiveStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "FAILED", "PARTIAL_SUCCESS", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ArchiveStatus extends Enum<ArchiveStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ArchiveStatus[] $VALUES = null;
    public static final ArchiveStatus FAILED = null;
    public static final ArchiveStatus PARTIAL_SUCCESS = null;
    public static final ArchiveStatus SUCCESS = null;
    private final int value;

    private static final /* synthetic */ ArchiveStatus[] $values() {
        return new ArchiveStatus[]{SUCCESS, FAILED, PARTIAL_SUCCESS};
    }

    public static EnumEntries<ArchiveStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        SUCCESS = new ArchiveStatus("SUCCESS", 0, 0);
        FAILED = new ArchiveStatus("FAILED", 1, 1);
        PARTIAL_SUCCESS = new ArchiveStatus("PARTIAL_SUCCESS", 2, 2);
        ArchiveStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ArchiveStatus[] values() {
        return (ArchiveStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ArchiveStatus valueOf(String r100) {
        return (ArchiveStatus) a.a(ArchiveStatus.class, r100);
    }

    private ArchiveStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
