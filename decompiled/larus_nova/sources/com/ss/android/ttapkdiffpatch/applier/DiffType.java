package com.ss.android.ttapkdiffpatch.applier;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum DiffType extends Enum<DiffType> {
    public static final DiffType ApkDiffPatch = null;
    public static final DiffType ArchivePatcher = null;
    public static final DiffType HDiffPatch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiffType[] f449820a = null;

    static {
        DiffType r100 = new DiffType("HDiffPatch", 0);
        HDiffPatch = r100;
        DiffType r101 = new DiffType("ApkDiffPatch", 1);
        ApkDiffPatch = r101;
        DiffType r102 = new DiffType("ArchivePatcher", 2);
        ArchivePatcher = r102;
        f449820a = new DiffType[]{r100, r101, r102};
    }

    public static DiffType[] values() {
        return (DiffType[]) f449820a.clone();
    }

    public static DiffType valueOf(String r100) {
        return (DiffType) a.a(DiffType.class, r100);
    }

    public DiffType(String r100, int r101) {
        super(r100, r101);
    }
}
