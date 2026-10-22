package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/message/block/AttachmentItemUploadStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AttachmentItemUploadStatusDefault", "AttachmentItemUploadStatusSuccess", "AttachmentItemUploadStatusFail", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AttachmentItemUploadStatus extends Enum<AttachmentItemUploadStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AttachmentItemUploadStatus[] $VALUES = null;
    public static final AttachmentItemUploadStatus AttachmentItemUploadStatusDefault = null;
    public static final AttachmentItemUploadStatus AttachmentItemUploadStatusFail = null;
    public static final AttachmentItemUploadStatus AttachmentItemUploadStatusSuccess = null;
    private final int value;

    private static final /* synthetic */ AttachmentItemUploadStatus[] $values() {
        return new AttachmentItemUploadStatus[]{AttachmentItemUploadStatusDefault, AttachmentItemUploadStatusSuccess, AttachmentItemUploadStatusFail};
    }

    public static EnumEntries<AttachmentItemUploadStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        AttachmentItemUploadStatusDefault = new AttachmentItemUploadStatus("AttachmentItemUploadStatusDefault", 0, 0);
        AttachmentItemUploadStatusSuccess = new AttachmentItemUploadStatus("AttachmentItemUploadStatusSuccess", 1, 1);
        AttachmentItemUploadStatusFail = new AttachmentItemUploadStatus("AttachmentItemUploadStatusFail", 2, 2);
        AttachmentItemUploadStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static AttachmentItemUploadStatus[] values() {
        return (AttachmentItemUploadStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AttachmentItemUploadStatus valueOf(String r100) {
        return (AttachmentItemUploadStatus) a.a(AttachmentItemUploadStatus.class, r100);
    }

    private AttachmentItemUploadStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
