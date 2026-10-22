package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/message/block/FileSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "FILE_SOURCE_O", "FILE_SOURCE_PC", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileSource extends Enum<FileSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FileSource[] $VALUES = null;
    public static final FileSource FILE_SOURCE_O = null;
    public static final FileSource FILE_SOURCE_PC = null;
    public static final FileSource UNKNOWN = null;
    private final int value;

    private static final /* synthetic */ FileSource[] $values() {
        return new FileSource[]{UNKNOWN, FILE_SOURCE_O, FILE_SOURCE_PC};
    }

    public static EnumEntries<FileSource> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new FileSource("UNKNOWN", 0, -1);
        FILE_SOURCE_O = new FileSource("FILE_SOURCE_O", 1, 0);
        FILE_SOURCE_PC = new FileSource("FILE_SOURCE_PC", 2, 1);
        FileSource[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static FileSource[] values() {
        return (FileSource[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FileSource valueOf(String r100) {
        return (FileSource) a.a(FileSource.class, r100);
    }

    private FileSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
