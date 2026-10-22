package com.bytedance.ee.bear.list.homepage.navigation;

import com.larus.media.MediaScene;
import com.obric.miniapp.alarm.AlarmSessionType;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NavigationEnum[] f228306a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f228307id;

    static {
        NavigationEnum r100 = new NavigationEnum("MY_SPACE", 0, 1);
        MY_SPACE = r100;
        NavigationEnum r101 = new NavigationEnum("SHARED_SPACE", 1, 2);
        SHARED_SPACE = r101;
        NavigationEnum r102 = new NavigationEnum("WIKI", 2, 3);
        WIKI = r102;
        NavigationEnum r103 = new NavigationEnum("FAVORITE", 3, 4);
        FAVORITE = r103;
        NavigationEnum r104 = new NavigationEnum("MANUAL_OFFLINE", 4, 5);
        MANUAL_OFFLINE = r104;
        NavigationEnum r110 = new NavigationEnum("TEMPLATE", 5, 6);
        TEMPLATE = r110;
        NavigationEnum r111 = new NavigationEnum(AlarmSessionType.TODO, 6, 7);
        TODO = r111;
        NavigationEnum r112 = new NavigationEnum("MY_LIBRARY", 7, 9);
        MY_LIBRARY = r112;
        NavigationEnum r113 = new NavigationEnum("MY_DRIVE", 8, 10);
        MY_DRIVE = r113;
        NavigationEnum r114 = new NavigationEnum("SIDEBAR_RECENT", 9, 11);
        SIDEBAR_RECENT = r114;
        NavigationEnum r105 = new NavigationEnum("SIDEBAR_DRIVE", 10, 12);
        SIDEBAR_DRIVE = r105;
        NavigationEnum r115 = new NavigationEnum("TO_ORGANIZE_FILE", 11, 13);
        TO_ORGANIZE_FILE = r115;
        NavigationEnum r106 = new NavigationEnum("SUBORDINATE_RECENT", 12, 14);
        SUBORDINATE_RECENT = r106;
        NavigationEnum r107 = new NavigationEnum("PIN_FOLDER", 13, 15);
        PIN_FOLDER = r107;
        NavigationEnum r108 = new NavigationEnum("AI", 14, 16);
        AI = r108;
        NavigationEnum r109 = new NavigationEnum("HOME_PAGE", 15, 17);
        HOME_PAGE = r109;
        NavigationEnum r116 = new NavigationEnum(MediaScene.AI_NOTE, 16, 18);
        AI_NOTE = r116;
        f228306a = new NavigationEnum[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r105, r115, r106, r107, r108, r109, r116};
    }

    public static NavigationEnum[] values() {
        return (NavigationEnum[]) f228306a.clone();
    }

    public static NavigationEnum valueOf(String r100) {
        return (NavigationEnum) r27.a.a(NavigationEnum.class, r100);
    }

    public NavigationEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.f228307id = r102;
    }
}
