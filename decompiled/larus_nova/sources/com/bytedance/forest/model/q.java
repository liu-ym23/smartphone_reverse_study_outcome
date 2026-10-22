package com.bytedance.forest.model;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f244368a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f244369b = null;

    static {
        new int[ResourceFrom2.values().length][ResourceFrom2.BUILTIN.ordinal()] = 1;
        int[] r100 = new int[FilePathType.values().length];
        f244368a = r100;
        r100[FilePathType.Asset.ordinal()] = 1;
        r100[FilePathType.Disk.ordinal()] = 2;
        int[] r101 = new int[ResourceFrom.values().length];
        f244369b = r101;
        r101[ResourceFrom.MEMORY.ordinal()] = 1;
        r101[ResourceFrom.GECKO.ordinal()] = 2;
        r101[ResourceFrom.BUILTIN.ordinal()] = 3;
        r101[ResourceFrom.CDN.ordinal()] = 4;
    }
}
