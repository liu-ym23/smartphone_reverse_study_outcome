package com.bytedance.ee.bear.list.homepage.tab;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum HomeTabEnum extends Enum<HomeTabEnum> {
    public static final HomeTabEnum AI_NOTES = null;
    public static final HomeTabEnum FAVORITE = null;
    public static final HomeTabEnum MANUAL_OFFLINE = null;
    public static final HomeTabEnum MY_INVOLVED = null;
    public static final HomeTabEnum MY_SPACE = null;
    public static final HomeTabEnum OFFLINE = null;
    public static final HomeTabEnum OWNED_BY_ME = null;
    public static final HomeTabEnum PERSONAL_FOLDER = null;
    public static final HomeTabEnum PIN = null;
    public static final HomeTabEnum RECENT = null;
    public static final HomeTabEnum SHARED_SPACE = null;
    public static final HomeTabEnum SHARED_SPACE_DOCUMENT = null;
    public static final HomeTabEnum SHARE_FOLDER = null;
    public static final HomeTabEnum SHARE_WITH_ME = null;
    public static final HomeTabEnum SIDEBAR_TREE_VIEW = null;
    public static final HomeTabEnum WIKI = null;
    public static final /* synthetic */ HomeTabEnum[] a = null;
    public int id;

    static {
        HomeTabEnum r0 = new HomeTabEnum("RECENT", 0, 0);
        RECENT = r0;
        HomeTabEnum r1 = new HomeTabEnum("PIN", 1, 1);
        PIN = r1;
        HomeTabEnum r3 = new HomeTabEnum("MANUAL_OFFLINE", 2, 2);
        MANUAL_OFFLINE = r3;
        HomeTabEnum r5 = new HomeTabEnum("FAVORITE", 3, 3);
        FAVORITE = r5;
        HomeTabEnum r7 = new HomeTabEnum("MY_SPACE", 4, 4);
        MY_SPACE = r7;
        HomeTabEnum r9 = new HomeTabEnum("SHARED_SPACE", 5, 5);
        SHARED_SPACE = r9;
        HomeTabEnum r11 = new HomeTabEnum("SHARED_SPACE_DOCUMENT", 6, 6);
        SHARED_SPACE_DOCUMENT = r11;
        HomeTabEnum r13 = new HomeTabEnum("SIDEBAR_TREE_VIEW", 7, 7);
        SIDEBAR_TREE_VIEW = r13;
        HomeTabEnum r15 = new HomeTabEnum("PERSONAL_FOLDER", 8, 8);
        PERSONAL_FOLDER = r15;
        HomeTabEnum r14 = new HomeTabEnum("SHARE_FOLDER", 9, 9);
        SHARE_FOLDER = r14;
        HomeTabEnum r12 = new HomeTabEnum("WIKI", 10, 10);
        WIKI = r12;
        HomeTabEnum r10 = new HomeTabEnum("OFFLINE", 11, 11);
        OFFLINE = r10;
        HomeTabEnum r8 = new HomeTabEnum("AI_NOTES", 12, 12);
        AI_NOTES = r8;
        HomeTabEnum r6 = new HomeTabEnum("OWNED_BY_ME", 13, 13);
        OWNED_BY_ME = r6;
        HomeTabEnum r4 = new HomeTabEnum("MY_INVOLVED", 14, 14);
        MY_INVOLVED = r4;
        HomeTabEnum r2 = new HomeTabEnum("SHARE_WITH_ME", 15, 15);
        SHARE_WITH_ME = r2;
        a = new HomeTabEnum[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
    }

    public static HomeTabEnum[] values() {
        return (HomeTabEnum[]) a.clone();
    }

    public static HomeTabEnum valueOf(String r1) {
        return (HomeTabEnum) a.a(HomeTabEnum.class, r1);
    }

    public HomeTabEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.id = r3;
    }
}
