package com.bytedance.ee.bear.drive.biz.upload.filepicker.config;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum NavigationSortMode extends Enum<NavigationSortMode> {
    public static final NavigationSortMode DATE_ASC = null;
    public static final NavigationSortMode DATE_DESC = null;
    public static final NavigationSortMode NAME_ASC = null;
    public static final NavigationSortMode NAME_DESC = null;
    public static final NavigationSortMode SIZE_ASC = null;
    public static final NavigationSortMode SIZE_DESC = null;
    public static final NavigationSortMode TYPE_ASC = null;
    public static final NavigationSortMode TYPE_DESC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NavigationSortMode[] f223881a = null;
    private int mId;

    static {
        NavigationSortMode r100 = new NavigationSortMode("NAME_ASC", 0, 0);
        NAME_ASC = r100;
        NavigationSortMode r101 = new NavigationSortMode("NAME_DESC", 1, 1);
        NAME_DESC = r101;
        NavigationSortMode r102 = new NavigationSortMode("DATE_ASC", 2, 2);
        DATE_ASC = r102;
        NavigationSortMode r103 = new NavigationSortMode("DATE_DESC", 3, 3);
        DATE_DESC = r103;
        NavigationSortMode r104 = new NavigationSortMode("SIZE_ASC", 4, 4);
        SIZE_ASC = r104;
        NavigationSortMode r105 = new NavigationSortMode("SIZE_DESC", 5, 5);
        SIZE_DESC = r105;
        NavigationSortMode r110 = new NavigationSortMode("TYPE_ASC", 6, 6);
        TYPE_ASC = r110;
        NavigationSortMode r111 = new NavigationSortMode("TYPE_DESC", 7, 7);
        TYPE_DESC = r111;
        f223881a = new NavigationSortMode[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static NavigationSortMode[] values() {
        return (NavigationSortMode[]) f223881a.clone();
    }

    public static NavigationSortMode valueOf(String r100) {
        return (NavigationSortMode) a.a(NavigationSortMode.class, r100);
    }

    public NavigationSortMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mId = r102;
    }
}
