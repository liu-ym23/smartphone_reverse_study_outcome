package com.lynx.animax.property;

/* JADX INFO: loaded from: classes32.dex */
public final enum ResourcePropertyType extends Enum<ResourcePropertyType> {
    public static final ResourcePropertyType FONT_ASCENT = null;
    public static final ResourcePropertyType FONT_FAMILY = null;
    public static final ResourcePropertyType FONT_PATH = null;
    public static final ResourcePropertyType FONT_STYLE = null;
    public static final ResourcePropertyType IMAGE_DIR_NAME = null;
    public static final ResourcePropertyType IMAGE_FILE_NAME = null;
    public static final ResourcePropertyType IMAGE_HEIGHT = null;
    public static final ResourcePropertyType IMAGE_WIDTH = null;
    public static final ResourcePropertyType VIDEO_DIR_NAME = null;
    public static final ResourcePropertyType VIDEO_FILE_NAME = null;
    public static final ResourcePropertyType VIDEO_HEIGHT = null;
    public static final ResourcePropertyType VIDEO_WIDTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourcePropertyType[] f380407a = null;
    private final int mValue;

    static {
        ResourcePropertyType r100 = new ResourcePropertyType("IMAGE_DIR_NAME", 0, 1);
        IMAGE_DIR_NAME = r100;
        ResourcePropertyType r101 = new ResourcePropertyType("IMAGE_FILE_NAME", 1, 2);
        IMAGE_FILE_NAME = r101;
        ResourcePropertyType r102 = new ResourcePropertyType("IMAGE_WIDTH", 2, 3);
        IMAGE_WIDTH = r102;
        ResourcePropertyType r103 = new ResourcePropertyType("IMAGE_HEIGHT", 3, 4);
        IMAGE_HEIGHT = r103;
        ResourcePropertyType r104 = new ResourcePropertyType("FONT_FAMILY", 4, 101);
        FONT_FAMILY = r104;
        ResourcePropertyType r110 = new ResourcePropertyType("FONT_STYLE", 5, 102);
        FONT_STYLE = r110;
        ResourcePropertyType r111 = new ResourcePropertyType("FONT_ASCENT", 6, 103);
        FONT_ASCENT = r111;
        ResourcePropertyType r112 = new ResourcePropertyType("FONT_PATH", 7, 104);
        FONT_PATH = r112;
        ResourcePropertyType r113 = new ResourcePropertyType("VIDEO_DIR_NAME", 8, 201);
        VIDEO_DIR_NAME = r113;
        ResourcePropertyType r114 = new ResourcePropertyType("VIDEO_FILE_NAME", 9, 202);
        VIDEO_FILE_NAME = r114;
        ResourcePropertyType r105 = new ResourcePropertyType("VIDEO_WIDTH", 10, 203);
        VIDEO_WIDTH = r105;
        ResourcePropertyType r106 = new ResourcePropertyType("VIDEO_HEIGHT", 11, 204);
        VIDEO_HEIGHT = r106;
        f380407a = new ResourcePropertyType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r105, r106};
    }

    public static ResourcePropertyType[] values() {
        return (ResourcePropertyType[]) f380407a.clone();
    }

    public int getValue() {
        return this.mValue;
    }

    public static ResourcePropertyType valueOf(String r100) {
        return (ResourcePropertyType) r27.a.a(ResourcePropertyType.class, r100);
    }

    public ResourcePropertyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}
