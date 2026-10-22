package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/forest/model/FilePathType;", "", "Asset", "Disk", "Custom", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum FilePathType extends Enum<FilePathType> {
    public static final FilePathType Asset = null;
    public static final FilePathType Custom = null;
    public static final FilePathType Disk = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilePathType[] f244235a = null;

    static {
        FilePathType r100 = new FilePathType("Asset", 0);
        Asset = r100;
        FilePathType r101 = new FilePathType("Disk", 1);
        Disk = r101;
        FilePathType r102 = new FilePathType("Custom", 2);
        Custom = r102;
        f244235a = new FilePathType[]{r100, r101, r102};
    }

    public static FilePathType valueOf(String r100) {
        return (FilePathType) r27.a.a(FilePathType.class, r100);
    }

    public static FilePathType[] values() {
        return (FilePathType[]) f244235a.clone();
    }

    public FilePathType(String r100, int r101) {
        super(r100, r101);
    }
}
