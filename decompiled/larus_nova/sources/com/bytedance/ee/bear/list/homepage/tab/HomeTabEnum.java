package com.bytedance.ee.bear.list.homepage.tab;

import r27.a;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HomeTabEnum[] f228343a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f228344id;

    static {
        HomeTabEnum r100 = new HomeTabEnum("RECENT", 0, 0);
        RECENT = r100;
        HomeTabEnum r101 = new HomeTabEnum("PIN", 1, 1);
        PIN = r101;
        HomeTabEnum r102 = new HomeTabEnum("MANUAL_OFFLINE", 2, 2);
        MANUAL_OFFLINE = r102;
        HomeTabEnum r103 = new HomeTabEnum("FAVORITE", 3, 3);
        FAVORITE = r103;
        HomeTabEnum r104 = new HomeTabEnum("MY_SPACE", 4, 4);
        MY_SPACE = r104;
        HomeTabEnum r105 = new HomeTabEnum("SHARED_SPACE", 5, 5);
        SHARED_SPACE = r105;
        HomeTabEnum r110 = new HomeTabEnum("SHARED_SPACE_DOCUMENT", 6, 6);
        SHARED_SPACE_DOCUMENT = r110;
        HomeTabEnum r111 = new HomeTabEnum("SIDEBAR_TREE_VIEW", 7, 7);
        SIDEBAR_TREE_VIEW = r111;
        HomeTabEnum r112 = new HomeTabEnum("PERSONAL_FOLDER", 8, 8);
        PERSONAL_FOLDER = r112;
        HomeTabEnum r113 = new HomeTabEnum("SHARE_FOLDER", 9, 9);
        SHARE_FOLDER = r113;
        HomeTabEnum r114 = new HomeTabEnum("WIKI", 10, 10);
        WIKI = r114;
        HomeTabEnum r115 = new HomeTabEnum("OFFLINE", 11, 11);
        OFFLINE = r115;
        HomeTabEnum r106 = new HomeTabEnum("AI_NOTES", 12, 12);
        AI_NOTES = r106;
        HomeTabEnum r107 = new HomeTabEnum("OWNED_BY_ME", 13, 13);
        OWNED_BY_ME = r107;
        HomeTabEnum r108 = new HomeTabEnum("MY_INVOLVED", 14, 14);
        MY_INVOLVED = r108;
        HomeTabEnum r109 = new HomeTabEnum("SHARE_WITH_ME", 15, 15);
        SHARE_WITH_ME = r109;
        f228343a = new HomeTabEnum[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
    }

    public static HomeTabEnum[] values() {
        return (HomeTabEnum[]) f228343a.clone();
    }

    public static HomeTabEnum valueOf(String r100) {
        return (HomeTabEnum) a.a(HomeTabEnum.class, r100);
    }

    public HomeTabEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.f228344id = r102;
    }
}
