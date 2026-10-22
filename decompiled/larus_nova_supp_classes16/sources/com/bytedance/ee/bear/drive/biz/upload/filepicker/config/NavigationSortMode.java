package com.bytedance.ee.bear.drive.biz.upload.filepicker.config;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum NavigationSortMode extends Enum<NavigationSortMode> {
    public static final NavigationSortMode DATE_ASC = null;
    public static final NavigationSortMode DATE_DESC = null;
    public static final NavigationSortMode NAME_ASC = null;
    public static final NavigationSortMode NAME_DESC = null;
    public static final NavigationSortMode SIZE_ASC = null;
    public static final NavigationSortMode SIZE_DESC = null;
    public static final NavigationSortMode TYPE_ASC = null;
    public static final NavigationSortMode TYPE_DESC = null;
    public static final /* synthetic */ NavigationSortMode[] a = null;
    private int mId;

    static {
        NavigationSortMode r0 = new NavigationSortMode("NAME_ASC", 0, 0);
        NAME_ASC = r0;
        NavigationSortMode r1 = new NavigationSortMode("NAME_DESC", 1, 1);
        NAME_DESC = r1;
        NavigationSortMode r3 = new NavigationSortMode("DATE_ASC", 2, 2);
        DATE_ASC = r3;
        NavigationSortMode r5 = new NavigationSortMode("DATE_DESC", 3, 3);
        DATE_DESC = r5;
        NavigationSortMode r7 = new NavigationSortMode("SIZE_ASC", 4, 4);
        SIZE_ASC = r7;
        NavigationSortMode r9 = new NavigationSortMode("SIZE_DESC", 5, 5);
        SIZE_DESC = r9;
        NavigationSortMode r11 = new NavigationSortMode("TYPE_ASC", 6, 6);
        TYPE_ASC = r11;
        NavigationSortMode r13 = new NavigationSortMode("TYPE_DESC", 7, 7);
        TYPE_DESC = r13;
        a = new NavigationSortMode[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public static NavigationSortMode[] values() {
        return (NavigationSortMode[]) a.clone();
    }

    public static NavigationSortMode valueOf(String r1) {
        return (NavigationSortMode) a.a(NavigationSortMode.class, r1);
    }

    public NavigationSortMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.mId = r3;
    }
}
