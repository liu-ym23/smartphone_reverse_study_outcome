package com.lynx.animax.property;

import com.ss.android.bytedcert.config.ThemeConfig;

/* JADX INFO: loaded from: classes32.dex */
public final enum LayerPropertyType extends Enum<LayerPropertyType> {
    public static final LayerPropertyType BLUR_RADIUS = null;
    public static final LayerPropertyType COLOR = null;
    public static final LayerPropertyType COLOR_FILTER = null;
    public static final LayerPropertyType CORNER_RADIUS = null;
    public static final LayerPropertyType DROP_SHADOW_COLOR = null;
    public static final LayerPropertyType DROP_SHADOW_DIRECTION = null;
    public static final LayerPropertyType DROP_SHADOW_DISTANCE = null;
    public static final LayerPropertyType DROP_SHADOW_OPACITY = null;
    public static final LayerPropertyType DROP_SHADOW_RADIUS = null;
    public static final LayerPropertyType ELLIPSE_SIZE = null;
    public static final LayerPropertyType OPACITY = null;
    public static final LayerPropertyType POLYSTAR_INNER_RADIUS = null;
    public static final LayerPropertyType POLYSTAR_INNER_ROUNDED = null;
    public static final LayerPropertyType POLYSTAR_OUTER_RADIUS = null;
    public static final LayerPropertyType POLYSTAR_OUTER_ROUNDED = null;
    public static final LayerPropertyType POLYSTAR_POINTS = null;
    public static final LayerPropertyType POLYSTAR_ROTATION = null;
    public static final LayerPropertyType POSITION = null;
    public static final LayerPropertyType RECTANGLE_SIZE = null;
    public static final LayerPropertyType REPEATER_COPIES = null;
    public static final LayerPropertyType REPEATER_OFFSET = null;
    public static final LayerPropertyType STROKE_COLOR = null;
    public static final LayerPropertyType STROKE_WIDTH = null;
    public static final LayerPropertyType TEXT_COLOR = null;
    public static final LayerPropertyType TEXT_SIZE = null;
    public static final LayerPropertyType TEXT_TRACKING = null;
    public static final LayerPropertyType TEXT_VALUE = null;
    public static final LayerPropertyType TRANSFORM_ANCHOR = null;
    public static final LayerPropertyType TRANSFORM_END_OPACITY = null;
    public static final LayerPropertyType TRANSFORM_OPACITY = null;
    public static final LayerPropertyType TRANSFORM_POSITION = null;
    public static final LayerPropertyType TRANSFORM_ROTATION = null;
    public static final LayerPropertyType TRANSFORM_ROTATION_X = null;
    public static final LayerPropertyType TRANSFORM_ROTATION_Y = null;
    public static final LayerPropertyType TRANSFORM_ROTATION_Z = null;
    public static final LayerPropertyType TRANSFORM_SCALE = null;
    public static final LayerPropertyType TRANSFORM_SKEW = null;
    public static final LayerPropertyType TRANSFORM_SKEW_ANGLE = null;
    public static final LayerPropertyType TRANSFORM_START_OPACITY = null;
    public static final LayerPropertyType VISIBILITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayerPropertyType[] f380406a = null;
    private final int mValue;

    static {
        LayerPropertyType r100 = new LayerPropertyType("VISIBILITY", 0, 1);
        VISIBILITY = r100;
        LayerPropertyType r101 = new LayerPropertyType("TRANSFORM_OPACITY", 1, 2);
        TRANSFORM_OPACITY = r101;
        LayerPropertyType r102 = new LayerPropertyType("TRANSFORM_ANCHOR", 2, 3);
        TRANSFORM_ANCHOR = r102;
        LayerPropertyType r103 = new LayerPropertyType("TRANSFORM_POSITION", 3, 4);
        TRANSFORM_POSITION = r103;
        LayerPropertyType r104 = new LayerPropertyType("TRANSFORM_SCALE", 4, 5);
        TRANSFORM_SCALE = r104;
        LayerPropertyType r110 = new LayerPropertyType("TRANSFORM_ROTATION", 5, 6);
        TRANSFORM_ROTATION = r110;
        LayerPropertyType r111 = new LayerPropertyType("TRANSFORM_SKEW", 6, 7);
        TRANSFORM_SKEW = r111;
        LayerPropertyType r112 = new LayerPropertyType("TRANSFORM_SKEW_ANGLE", 7, 8);
        TRANSFORM_SKEW_ANGLE = r112;
        LayerPropertyType r113 = new LayerPropertyType("TRANSFORM_START_OPACITY", 8, 9);
        TRANSFORM_START_OPACITY = r113;
        LayerPropertyType r114 = new LayerPropertyType("TRANSFORM_END_OPACITY", 9, 10);
        TRANSFORM_END_OPACITY = r114;
        LayerPropertyType r115 = new LayerPropertyType("TRANSFORM_ROTATION_X", 10, 11);
        TRANSFORM_ROTATION_X = r115;
        LayerPropertyType r105 = new LayerPropertyType("TRANSFORM_ROTATION_Y", 11, 12);
        TRANSFORM_ROTATION_Y = r105;
        LayerPropertyType r106 = new LayerPropertyType("TRANSFORM_ROTATION_Z", 12, 13);
        TRANSFORM_ROTATION_Z = r106;
        LayerPropertyType r107 = new LayerPropertyType("TEXT_VALUE", 13, 101);
        TEXT_VALUE = r107;
        LayerPropertyType r108 = new LayerPropertyType(ThemeConfig.TEXT_SIZE, 14, 102);
        TEXT_SIZE = r108;
        LayerPropertyType r109 = new LayerPropertyType(ThemeConfig.TEXT_COLOR, 15, 103);
        TEXT_COLOR = r109;
        LayerPropertyType r116 = new LayerPropertyType("TEXT_TRACKING", 16, 104);
        TEXT_TRACKING = r116;
        LayerPropertyType r117 = new LayerPropertyType("COLOR", 17, 201);
        COLOR = r117;
        LayerPropertyType r118 = new LayerPropertyType("COLOR_FILTER", 18, 202);
        COLOR_FILTER = r118;
        LayerPropertyType r119 = new LayerPropertyType("STROKE_COLOR", 19, 203);
        STROKE_COLOR = r119;
        LayerPropertyType r120 = new LayerPropertyType("STROKE_WIDTH", 20, 204);
        STROKE_WIDTH = r120;
        LayerPropertyType r121 = new LayerPropertyType("OPACITY", 21, 205);
        OPACITY = r121;
        LayerPropertyType r122 = new LayerPropertyType("BLUR_RADIUS", 22, 206);
        BLUR_RADIUS = r122;
        LayerPropertyType r123 = new LayerPropertyType("ELLIPSE_SIZE", 23, 207);
        ELLIPSE_SIZE = r123;
        LayerPropertyType r124 = new LayerPropertyType("RECTANGLE_SIZE", 24, 208);
        RECTANGLE_SIZE = r124;
        LayerPropertyType r125 = new LayerPropertyType("CORNER_RADIUS", 25, 209);
        CORNER_RADIUS = r125;
        LayerPropertyType r126 = new LayerPropertyType("POSITION", 26, 210);
        POSITION = r126;
        LayerPropertyType r127 = new LayerPropertyType("REPEATER_COPIES", 27, 211);
        REPEATER_COPIES = r127;
        LayerPropertyType r128 = new LayerPropertyType("REPEATER_OFFSET", 28, 212);
        REPEATER_OFFSET = r128;
        LayerPropertyType r129 = new LayerPropertyType("POLYSTAR_POINTS", 29, 213);
        POLYSTAR_POINTS = r129;
        LayerPropertyType r130 = new LayerPropertyType("POLYSTAR_ROTATION", 30, 214);
        POLYSTAR_ROTATION = r130;
        LayerPropertyType r131 = new LayerPropertyType("POLYSTAR_INNER_RADIUS", 31, 215);
        POLYSTAR_INNER_RADIUS = r131;
        LayerPropertyType r132 = new LayerPropertyType("POLYSTAR_OUTER_RADIUS", 32, 216);
        POLYSTAR_OUTER_RADIUS = r132;
        LayerPropertyType r133 = new LayerPropertyType("POLYSTAR_INNER_ROUNDED", 33, 217);
        POLYSTAR_INNER_ROUNDED = r133;
        LayerPropertyType r134 = new LayerPropertyType("POLYSTAR_OUTER_ROUNDED", 34, 218);
        POLYSTAR_OUTER_ROUNDED = r134;
        LayerPropertyType r135 = new LayerPropertyType("DROP_SHADOW_COLOR", 35, 219);
        DROP_SHADOW_COLOR = r135;
        LayerPropertyType r136 = new LayerPropertyType("DROP_SHADOW_OPACITY", 36, 220);
        DROP_SHADOW_OPACITY = r136;
        LayerPropertyType r137 = new LayerPropertyType("DROP_SHADOW_DIRECTION", 37, 221);
        DROP_SHADOW_DIRECTION = r137;
        LayerPropertyType r138 = new LayerPropertyType("DROP_SHADOW_DISTANCE", 38, 222);
        DROP_SHADOW_DISTANCE = r138;
        LayerPropertyType r139 = new LayerPropertyType("DROP_SHADOW_RADIUS", 39, 223);
        DROP_SHADOW_RADIUS = r139;
        f380406a = new LayerPropertyType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r105, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139};
    }

    public static LayerPropertyType[] values() {
        return (LayerPropertyType[]) f380406a.clone();
    }

    public int getValue() {
        return this.mValue;
    }

    public static LayerPropertyType valueOf(String r100) {
        return (LayerPropertyType) r27.a.a(LayerPropertyType.class, r100);
    }

    public LayerPropertyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}
