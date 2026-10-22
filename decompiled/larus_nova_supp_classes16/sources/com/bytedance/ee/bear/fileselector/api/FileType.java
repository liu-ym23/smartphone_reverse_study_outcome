package com.bytedance.ee.bear.fileselector.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/fileselector/api/FileType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "FILE", "framework-file-selector_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileType extends Enum<FileType> {
    public static final FileType FILE = null;
    public static final FileType IMAGE = null;
    public static final FileType VIDEO = null;
    public static final /* synthetic */ FileType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FileType> getEntries() {
        return b;
    }

    static {
        FileType r0 = new FileType("IMAGE", 0);
        IMAGE = r0;
        FileType r1 = new FileType("VIDEO", 1);
        VIDEO = r1;
        FileType r3 = new FileType("FILE", 2);
        FILE = r3;
        FileType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static FileType[] values() {
        return (FileType[]) a.clone();
    }

    public static FileType valueOf(String r1) {
        return (FileType) a.a(FileType.class, r1);
    }

    public FileType(String r1, int r2) {
        super(r1, r2);
    }
}
