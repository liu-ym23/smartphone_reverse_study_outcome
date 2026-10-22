package com.bytedance.ee.bear.list.homepage.navigation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum NavigationEnum extends Enum<NavigationEnum> {
    public static final NavigationEnum AI = null;
    public static final NavigationEnum AI_NOTE = null;
    public static final NavigationEnum FAVORITE = null;
    public static final NavigationEnum HOME_PAGE = null;
    public static final NavigationEnum MANUAL_OFFLINE = null;
    public static final NavigationEnum MY_DRIVE = null;
    public static final NavigationEnum MY_LIBRARY = null;
    public static final NavigationEnum MY_SPACE = null;
    public static final NavigationEnum PIN_FOLDER = null;
    public static final NavigationEnum SHARED_SPACE = null;
    public static final NavigationEnum SIDEBAR_DRIVE = null;
    public static final NavigationEnum SIDEBAR_RECENT = null;
    public static final NavigationEnum SUBORDINATE_RECENT = null;
    public static final NavigationEnum TEMPLATE = null;
    public static final NavigationEnum TODO = null;
    public static final NavigationEnum TO_ORGANIZE_FILE = null;
    public static final NavigationEnum WIKI = null;
    public static final /* synthetic */ NavigationEnum[] a = null;
    public int id;

    static {
        NavigationEnum r0 = new NavigationEnum("MY_SPACE", 0, 1);
        MY_SPACE = r0;
        NavigationEnum r1 = new NavigationEnum("SHARED_SPACE", 1, 2);
        SHARED_SPACE = r1;
        NavigationEnum r4 = new NavigationEnum("WIKI", 2, 3);
        WIKI = r4;
        NavigationEnum r6 = new NavigationEnum("FAVORITE", 3, 4);
        FAVORITE = r6;
        NavigationEnum r8 = new NavigationEnum("MANUAL_OFFLINE", 4, 5);
        MANUAL_OFFLINE = r8;
        NavigationEnum r10 = new NavigationEnum("TEMPLATE", 5, 6);
        TEMPLATE = r10;
        NavigationEnum r12 = new NavigationEnum("TODO", 6, 7);
        TODO = r12;
        NavigationEnum r14 = new NavigationEnum("MY_LIBRARY", 7, 9);
        MY_LIBRARY = r14;
        NavigationEnum r13 = new NavigationEnum("MY_DRIVE", 8, 10);
        MY_DRIVE = r13;
        NavigationEnum r15 = new NavigationEnum("SIDEBAR_RECENT", 9, 11);
        SIDEBAR_RECENT = r15;
        NavigationEnum r9 = new NavigationEnum("SIDEBAR_DRIVE", 10, 12);
        SIDEBAR_DRIVE = r9;
        NavigationEnum r11 = new NavigationEnum("TO_ORGANIZE_FILE", 11, 13);
        TO_ORGANIZE_FILE = r11;
        NavigationEnum r7 = new NavigationEnum("SUBORDINATE_RECENT", 12, 14);
        SUBORDINATE_RECENT = r7;
        NavigationEnum r5 = new NavigationEnum("PIN_FOLDER", 13, 15);
        PIN_FOLDER = r5;
        NavigationEnum r3 = new NavigationEnum("AI", 14, 16);
        AI = r3;
        NavigationEnum r16 = new NavigationEnum("HOME_PAGE", 15, 17);
        HOME_PAGE = r16;
        NavigationEnum r17 = new NavigationEnum("AI_NOTE", 16, 18);
        AI_NOTE = r17;
        a = new NavigationEnum[]{r0, r1, r4, r6, r8, r10, r12, r14, r13, r15, r9, r11, r7, r5, r3, r16, r17};
    }

    public static NavigationEnum[] values() {
        return (NavigationEnum[]) a.clone();
    }

    public static NavigationEnum valueOf(String r1) {
        return (NavigationEnum) r27.a.a(NavigationEnum.class, r1);
    }

    public NavigationEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.id = r3;
    }
}
