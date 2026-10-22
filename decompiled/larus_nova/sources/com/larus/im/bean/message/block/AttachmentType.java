package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/im/bean/message/block/AttachmentType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AttachmentTypeUnknown", "AttachmentTypeImage", "AttachmentTypeVideo", "AttachmentTypeFile", "AttachmentTypeLink", "AttachmentTypeLarkDoc", "AttachmentTypeLocalItem", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AttachmentType extends Enum<AttachmentType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AttachmentType[] $VALUES = null;
    public static final AttachmentType AttachmentTypeFile = null;
    public static final AttachmentType AttachmentTypeImage = null;
    public static final AttachmentType AttachmentTypeLarkDoc = null;
    public static final AttachmentType AttachmentTypeLink = null;
    public static final AttachmentType AttachmentTypeLocalItem = null;
    public static final AttachmentType AttachmentTypeUnknown = null;
    public static final AttachmentType AttachmentTypeVideo = null;
    private final int value;

    private static final /* synthetic */ AttachmentType[] $values() {
        return new AttachmentType[]{AttachmentTypeUnknown, AttachmentTypeImage, AttachmentTypeVideo, AttachmentTypeFile, AttachmentTypeLink, AttachmentTypeLarkDoc, AttachmentTypeLocalItem};
    }

    public static EnumEntries<AttachmentType> getEntries() {
        return $ENTRIES;
    }

    static {
        AttachmentTypeUnknown = new AttachmentType("AttachmentTypeUnknown", 0, 0);
        AttachmentTypeImage = new AttachmentType("AttachmentTypeImage", 1, 1);
        AttachmentTypeVideo = new AttachmentType("AttachmentTypeVideo", 2, 2);
        AttachmentTypeFile = new AttachmentType("AttachmentTypeFile", 3, 3);
        AttachmentTypeLink = new AttachmentType("AttachmentTypeLink", 4, 4);
        AttachmentTypeLarkDoc = new AttachmentType("AttachmentTypeLarkDoc", 5, 7);
        AttachmentTypeLocalItem = new AttachmentType("AttachmentTypeLocalItem", 6, 8);
        AttachmentType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static AttachmentType[] values() {
        return (AttachmentType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AttachmentType valueOf(String r100) {
        return (AttachmentType) a.a(AttachmentType.class, r100);
    }

    private AttachmentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
