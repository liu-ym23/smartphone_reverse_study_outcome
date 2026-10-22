package com.bytedance.ee.bear.fileselector.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/fileselector/api/FileType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "FILE", "framework-file-selector_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileType extends Enum<FileType> {
    public static final FileType FILE = null;
    public static final FileType IMAGE = null;
    public static final FileType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileType[] f226781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f226782b = null;

    public static EnumEntries<FileType> getEntries() {
        return f226782b;
    }

    static {
        FileType r100 = new FileType("IMAGE", 0);
        IMAGE = r100;
        FileType r101 = new FileType("VIDEO", 1);
        VIDEO = r101;
        FileType r102 = new FileType("FILE", 2);
        FILE = r102;
        FileType[] r103 = {r100, r101, r102};
        f226781a = r103;
        f226782b = EnumEntriesKt.enumEntries(r103);
    }

    public static FileType[] values() {
        return (FileType[]) f226781a.clone();
    }

    public static FileType valueOf(String r100) {
        return (FileType) a.a(FileType.class, r100);
    }

    public FileType(String r100, int r101) {
        super(r100, r101);
    }
}
