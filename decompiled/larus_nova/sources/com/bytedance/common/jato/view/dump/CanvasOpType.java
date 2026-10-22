package com.bytedance.common.jato.view.dump;

import com.lynx.serval.svg.SVGRenderEngine;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum CanvasOpType extends Enum<CanvasOpType> {
    private static final /* synthetic */ CanvasOpType[] $VALUES = null;
    public static final CanvasOpType canvasOpMax = null;
    public static final CanvasOpType clipPath = null;
    public static final CanvasOpType clipRect = null;
    public static final CanvasOpType drawArc = null;
    public static final CanvasOpType drawBitmap = null;
    public static final CanvasOpType drawBitmapArray = null;
    public static final CanvasOpType drawBitmapMatrix = null;
    public static final CanvasOpType drawBitmapMesh = null;
    public static final CanvasOpType drawBitmapRect = null;
    public static final CanvasOpType drawBitmapSize = null;
    public static final CanvasOpType drawCircle = null;
    public static final CanvasOpType drawColor = null;
    public static final CanvasOpType drawColorLong = null;
    public static final CanvasOpType drawDoubleRoundRectRadii = null;
    public static final CanvasOpType drawDoubleRoundRectXY = null;
    public static final CanvasOpType drawGlyphs = null;
    public static final CanvasOpType drawLine = null;
    public static final CanvasOpType drawLines = null;
    public static final CanvasOpType drawMesh = null;
    public static final CanvasOpType drawNinePatch = null;
    public static final CanvasOpType drawOval = null;
    public static final CanvasOpType drawPaint = null;
    public static final CanvasOpType drawPath = null;
    public static final CanvasOpType drawPoint = null;
    public static final CanvasOpType drawPoints = null;
    public static final CanvasOpType drawRect = null;
    public static final CanvasOpType drawRegion = null;
    public static final CanvasOpType drawRoundRect = null;
    public static final CanvasOpType drawTextChars = null;
    public static final CanvasOpType drawTextOnPathChars = null;
    public static final CanvasOpType drawTextOnPathString = null;
    public static final CanvasOpType drawTextRunChars = null;
    public static final CanvasOpType drawTextRunString = null;
    public static final CanvasOpType drawTextSize = null;
    public static final CanvasOpType drawTextString = null;
    public static final CanvasOpType drawVertices = null;
    public static final CanvasOpType punchHole = null;
    public static final CanvasOpType saveLayer = null;
    public static final CanvasOpType saveLayerAlpha = null;
    public static final CanvasOpType setPaintFilter = null;
    public static final CanvasOpType unknown = null;
    public final int index;

    static {
        CanvasOpType r100 = new CanvasOpType("unknown", 0, 0);
        unknown = r100;
        CanvasOpType r101 = new CanvasOpType("drawBitmapSize", 1, 1);
        drawBitmapSize = r101;
        CanvasOpType r102 = new CanvasOpType("drawTextSize", 2, 2);
        drawTextSize = r102;
        CanvasOpType r103 = new CanvasOpType("saveLayer", 3, 3);
        saveLayer = r103;
        CanvasOpType r104 = new CanvasOpType("saveLayerAlpha", 4, 4);
        saveLayerAlpha = r104;
        CanvasOpType r105 = new CanvasOpType("clipRect", 5, 5);
        clipRect = r105;
        CanvasOpType r110 = new CanvasOpType(SVGRenderEngine.CLIP_PATH, 6, 6);
        clipPath = r110;
        CanvasOpType r111 = new CanvasOpType("drawColor", 7, 7);
        drawColor = r111;
        CanvasOpType r112 = new CanvasOpType("drawColorLong", 8, 8);
        drawColorLong = r112;
        CanvasOpType r113 = new CanvasOpType("drawPaint", 9, 9);
        drawPaint = r113;
        CanvasOpType r114 = new CanvasOpType("drawPoint", 10, 10);
        drawPoint = r114;
        CanvasOpType r115 = new CanvasOpType("drawPoints", 11, 11);
        drawPoints = r115;
        CanvasOpType r106 = new CanvasOpType("drawLine", 12, 12);
        drawLine = r106;
        CanvasOpType r107 = new CanvasOpType("drawLines", 13, 13);
        drawLines = r107;
        CanvasOpType r108 = new CanvasOpType("drawRect", 14, 14);
        drawRect = r108;
        CanvasOpType r109 = new CanvasOpType("drawDoubleRoundRectXY", 15, 15);
        drawDoubleRoundRectXY = r109;
        CanvasOpType r116 = new CanvasOpType("drawDoubleRoundRectRadii", 16, 16);
        drawDoubleRoundRectRadii = r116;
        CanvasOpType r117 = new CanvasOpType("drawRegion", 17, 17);
        drawRegion = r117;
        CanvasOpType r118 = new CanvasOpType("drawRoundRect", 18, 18);
        drawRoundRect = r118;
        CanvasOpType r119 = new CanvasOpType("drawCircle", 19, 19);
        drawCircle = r119;
        CanvasOpType r120 = new CanvasOpType("drawOval", 20, 20);
        drawOval = r120;
        CanvasOpType r121 = new CanvasOpType("drawArc", 21, 21);
        drawArc = r121;
        CanvasOpType r122 = new CanvasOpType("drawPath", 22, 22);
        drawPath = r122;
        CanvasOpType r123 = new CanvasOpType("drawVertices", 23, 23);
        drawVertices = r123;
        CanvasOpType r124 = new CanvasOpType("drawMesh", 24, 24);
        drawMesh = r124;
        CanvasOpType r125 = new CanvasOpType("drawNinePatch", 25, 25);
        drawNinePatch = r125;
        CanvasOpType r126 = new CanvasOpType("drawBitmap", 26, 26);
        drawBitmap = r126;
        CanvasOpType r127 = new CanvasOpType("drawBitmapMatrix", 27, 27);
        drawBitmapMatrix = r127;
        CanvasOpType r128 = new CanvasOpType("drawBitmapRect", 28, 28);
        drawBitmapRect = r128;
        CanvasOpType r129 = new CanvasOpType("drawBitmapArray", 29, 29);
        drawBitmapArray = r129;
        CanvasOpType r130 = new CanvasOpType("drawBitmapMesh", 30, 30);
        drawBitmapMesh = r130;
        CanvasOpType r131 = new CanvasOpType("drawGlyphs", 31, 31);
        drawGlyphs = r131;
        CanvasOpType r132 = new CanvasOpType("drawTextChars", 32, 32);
        drawTextChars = r132;
        CanvasOpType r133 = new CanvasOpType("drawTextString", 33, 33);
        drawTextString = r133;
        CanvasOpType r134 = new CanvasOpType("drawTextRunChars", 34, 34);
        drawTextRunChars = r134;
        CanvasOpType r135 = new CanvasOpType("drawTextRunString", 35, 35);
        drawTextRunString = r135;
        CanvasOpType r136 = new CanvasOpType("drawTextOnPathChars", 36, 36);
        drawTextOnPathChars = r136;
        CanvasOpType r137 = new CanvasOpType("drawTextOnPathString", 37, 37);
        drawTextOnPathString = r137;
        CanvasOpType r138 = new CanvasOpType("setPaintFilter", 38, 38);
        setPaintFilter = r138;
        CanvasOpType r139 = new CanvasOpType("punchHole", 39, 39);
        punchHole = r139;
        CanvasOpType r140 = new CanvasOpType("canvasOpMax", 40, 40);
        canvasOpMax = r140;
        $VALUES = new CanvasOpType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140};
    }

    public static CanvasOpType[] values() {
        return (CanvasOpType[]) $VALUES.clone();
    }

    public static CanvasOpType valueOf(String r100) {
        return (CanvasOpType) a.a(CanvasOpType.class, r100);
    }

    private CanvasOpType(String r100, int r101, int r102) {
        super(r100, r101);
        this.index = r102;
    }
}
