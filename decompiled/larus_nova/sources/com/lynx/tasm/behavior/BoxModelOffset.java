package com.lynx.tasm.behavior;

/* JADX INFO: loaded from: classes32.dex */
final enum BoxModelOffset extends Enum<BoxModelOffset> {
    public static final BoxModelOffset BORDER_BOTTOM = null;
    public static final BoxModelOffset BORDER_LEFT = null;
    public static final BoxModelOffset BORDER_RIGHT = null;
    public static final BoxModelOffset BORDER_TOP = null;
    public static final BoxModelOffset LAYOUT_BOTTOM = null;
    public static final BoxModelOffset LAYOUT_LEFT = null;
    public static final BoxModelOffset LAYOUT_RIGHT = null;
    public static final BoxModelOffset LAYOUT_TOP = null;
    public static final BoxModelOffset MARGIN_BOTTOM = null;
    public static final BoxModelOffset MARGIN_LEFT = null;
    public static final BoxModelOffset MARGIN_RIGHT = null;
    public static final BoxModelOffset MARGIN_TOP = null;
    public static final BoxModelOffset PAD_BOTTOM = null;
    public static final BoxModelOffset PAD_LEFT = null;
    public static final BoxModelOffset PAD_RIGHT = null;
    public static final BoxModelOffset PAD_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BoxModelOffset[] f381873a = null;

    static {
        BoxModelOffset r100 = new BoxModelOffset("PAD_LEFT", 0);
        PAD_LEFT = r100;
        BoxModelOffset r101 = new BoxModelOffset("PAD_TOP", 1);
        PAD_TOP = r101;
        BoxModelOffset r102 = new BoxModelOffset("PAD_RIGHT", 2);
        PAD_RIGHT = r102;
        BoxModelOffset r103 = new BoxModelOffset("PAD_BOTTOM", 3);
        PAD_BOTTOM = r103;
        BoxModelOffset r104 = new BoxModelOffset("BORDER_LEFT", 4);
        BORDER_LEFT = r104;
        BoxModelOffset r105 = new BoxModelOffset("BORDER_TOP", 5);
        BORDER_TOP = r105;
        BoxModelOffset r110 = new BoxModelOffset("BORDER_RIGHT", 6);
        BORDER_RIGHT = r110;
        BoxModelOffset r111 = new BoxModelOffset("BORDER_BOTTOM", 7);
        BORDER_BOTTOM = r111;
        BoxModelOffset r112 = new BoxModelOffset("MARGIN_LEFT", 8);
        MARGIN_LEFT = r112;
        BoxModelOffset r113 = new BoxModelOffset("MARGIN_TOP", 9);
        MARGIN_TOP = r113;
        BoxModelOffset r114 = new BoxModelOffset("MARGIN_RIGHT", 10);
        MARGIN_RIGHT = r114;
        BoxModelOffset r115 = new BoxModelOffset("MARGIN_BOTTOM", 11);
        MARGIN_BOTTOM = r115;
        BoxModelOffset r106 = new BoxModelOffset("LAYOUT_LEFT", 12);
        LAYOUT_LEFT = r106;
        BoxModelOffset r107 = new BoxModelOffset("LAYOUT_TOP", 13);
        LAYOUT_TOP = r107;
        BoxModelOffset r108 = new BoxModelOffset("LAYOUT_RIGHT", 14);
        LAYOUT_RIGHT = r108;
        BoxModelOffset r109 = new BoxModelOffset("LAYOUT_BOTTOM", 15);
        LAYOUT_BOTTOM = r109;
        f381873a = new BoxModelOffset[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
    }

    public static BoxModelOffset[] values() {
        return (BoxModelOffset[]) f381873a.clone();
    }

    public static BoxModelOffset valueOf(String r100) {
        return (BoxModelOffset) r27.a.a(BoxModelOffset.class, r100);
    }

    public BoxModelOffset(String r100, int r101) {
        super(r100, r101);
    }
}
