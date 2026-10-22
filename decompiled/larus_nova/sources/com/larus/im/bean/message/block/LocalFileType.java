package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/message/block/LocalFileType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LocalFileTypeUnknown", "LocalFileTypeFile", "LocalFileTypeDirectory", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LocalFileType extends Enum<LocalFileType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LocalFileType[] $VALUES = null;
    public static final LocalFileType LocalFileTypeDirectory = null;
    public static final LocalFileType LocalFileTypeFile = null;
    public static final LocalFileType LocalFileTypeUnknown = null;
    private final int value;

    private static final /* synthetic */ LocalFileType[] $values() {
        return new LocalFileType[]{LocalFileTypeUnknown, LocalFileTypeFile, LocalFileTypeDirectory};
    }

    public static EnumEntries<LocalFileType> getEntries() {
        return $ENTRIES;
    }

    static {
        LocalFileTypeUnknown = new LocalFileType("LocalFileTypeUnknown", 0, 0);
        LocalFileTypeFile = new LocalFileType("LocalFileTypeFile", 1, 1);
        LocalFileTypeDirectory = new LocalFileType("LocalFileTypeDirectory", 2, 2);
        LocalFileType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static LocalFileType[] values() {
        return (LocalFileType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static LocalFileType valueOf(String r100) {
        return (LocalFileType) a.a(LocalFileType.class, r100);
    }

    private LocalFileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
