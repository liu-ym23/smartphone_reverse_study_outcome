package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum BadgeAnchor extends Enum<BadgeAnchor> {
    public static final BadgeAnchor BOTTOM = null;
    public static final BadgeAnchor BOTTOM_EDGE_CENTER_Y = null;
    public static final BadgeAnchor CENTER_X = null;
    public static final BadgeAnchor CENTER_Y = null;
    public static final BadgeAnchor CONTENT_BOTTOM = null;
    public static final BadgeAnchor CONTENT_LEFT = null;
    public static final BadgeAnchor CONTENT_RIGHT = null;
    public static final BadgeAnchor CONTENT_TOP = null;
    public static final BadgeAnchor LEFT = null;
    public static final BadgeAnchor LEFT_EDGE_CENTER_X = null;
    public static final BadgeAnchor RIGHT = null;
    public static final BadgeAnchor RIGHT_EDGE_CENTER_X = null;
    public static final BadgeAnchor TOP = null;
    public static final BadgeAnchor TOP_EDGE_CENTER_Y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BadgeAnchor[] f518941a = null;

    static {
        BadgeAnchor r100 = new BadgeAnchor("LEFT", 0);
        LEFT = r100;
        BadgeAnchor r101 = new BadgeAnchor("TOP", 1);
        TOP = r101;
        BadgeAnchor r102 = new BadgeAnchor("RIGHT", 2);
        RIGHT = r102;
        BadgeAnchor r103 = new BadgeAnchor("BOTTOM", 3);
        BOTTOM = r103;
        BadgeAnchor r104 = new BadgeAnchor("CONTENT_LEFT", 4);
        CONTENT_LEFT = r104;
        BadgeAnchor r105 = new BadgeAnchor("CONTENT_TOP", 5);
        CONTENT_TOP = r105;
        BadgeAnchor r110 = new BadgeAnchor("CONTENT_RIGHT", 6);
        CONTENT_RIGHT = r110;
        BadgeAnchor r111 = new BadgeAnchor("CONTENT_BOTTOM", 7);
        CONTENT_BOTTOM = r111;
        BadgeAnchor r112 = new BadgeAnchor("CENTER_X", 8);
        CENTER_X = r112;
        BadgeAnchor r113 = new BadgeAnchor("CENTER_Y", 9);
        CENTER_Y = r113;
        BadgeAnchor r114 = new BadgeAnchor("LEFT_EDGE_CENTER_X", 10);
        LEFT_EDGE_CENTER_X = r114;
        BadgeAnchor r115 = new BadgeAnchor("TOP_EDGE_CENTER_Y", 11);
        TOP_EDGE_CENTER_Y = r115;
        BadgeAnchor r106 = new BadgeAnchor("RIGHT_EDGE_CENTER_X", 12);
        RIGHT_EDGE_CENTER_X = r106;
        BadgeAnchor r107 = new BadgeAnchor("BOTTOM_EDGE_CENTER_Y", 13);
        BOTTOM_EDGE_CENTER_Y = r107;
        f518941a = new BadgeAnchor[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
    }

    public static BadgeAnchor[] values() {
        return (BadgeAnchor[]) f518941a.clone();
    }

    public static BadgeAnchor valueOf(String r100) {
        return (BadgeAnchor) a.a(BadgeAnchor.class, r100);
    }

    public BadgeAnchor(String r100, int r101) {
        super(r100, r101);
    }
}
