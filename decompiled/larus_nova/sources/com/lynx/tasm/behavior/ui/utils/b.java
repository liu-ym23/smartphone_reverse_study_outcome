package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f383132a = null;

        static {
            int[] r100 = new int[BorderStyle.values().length];
            f383132a = r100;
            r100[BorderStyle.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            f383132a[BorderStyle.HIDDEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            f383132a[BorderStyle.DASHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            f383132a[BorderStyle.DOTTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            f383132a[BorderStyle.SOLID.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            f383132a[BorderStyle.INSET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            f383132a[BorderStyle.OUTSET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            f383132a[BorderStyle.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            f383132a[BorderStyle.GROOVE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            f383132a[BorderStyle.RIDGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static void c(Canvas r410, Paint r411, Rect r412, int[] r413, int[] r414, BorderStyle[] r510) {
        if (r413.length != 4) goto L108;
        if (r414 != null) goto L6;
        return;
    L6:
        if (r414.length == 4) goto L8;
        return;
    L8:
        if (r510.length != 4) goto L111;
        int r110 = r413[0];
        int r111 = r413[1];
        int r100 = r413[2];
        int r101 = r413[3];
        if (r110 > 0) goto L17;
        if (r100 > 0) goto L17;
        if (r111 > 0) goto L17;
        if (r101 > 0) goto L17;
        boolean r102 = false;
    L18:
        if (r102 == false) goto L105;
        int r112 = r414[0];
        int r103 = r414[1];
        int r113 = r414[2];
        int r210 = r414[3];
        int r104 = r412.left;
        int r105 = r412.top;
        r411.setAntiAlias(false);
        r411.setStyle(Paint.Style.STROKE);
        int r106 = -1;
        if (r110 <= 0) goto L22;
        int r107 = r112;
    L23:
        if (r111 <= 0) goto L25;
        int r108 = r103;
    L26:
        int r109 = r107 & r108;
        if (r100 <= 0) goto L29;
        int r114 = r113;
    L30:
        int r115 = r109 & r114;
        if (r101 <= 0) goto L33;
        r106 = r210;
    L33:
        int r116 = r106 & r115;
        if (r110 <= 0) goto L36;
        int r117 = r112;
    L37:
        if (r111 <= 0) goto L39;
        int r118 = r103;
    L40:
        int r119 = r117 | r118;
        if (r100 <= 0) goto L43;
        int r120 = r113;
    L44:
        int r121 = r119 | r120;
        if (r101 <= 0) goto L47;
        int r122 = r210;
    L49:
        if (r116 != (r121 | r122)) goto L51;
        int r123 = r116;
    L53:
        if (r123 == 0) goto L84;
        BorderStyle r124 = r510[0];
        BorderStyle r125 = r510[1];
        if (r124 != r125) goto L62;
        BorderStyle r126 = r510[2];
        if (r125 != r126) goto L62;
        if (r126 != r510[3]) goto L62;
        boolean r127 = r124.isSolidDashedOrDotted();
    L63:
        if (r127 == false) goto L84;
        if (Color.alpha(r123) == 0) goto L105;
        int r128 = r412.right;
        int r129 = r412.bottom;
        BorderStyle r130 = r510[1];
        if (r110 != r111) goto L74;
        if (r111 != r100) goto L74;
        if (r100 != r101) goto L74;
        if (r130 != BorderStyle.SOLID) goto L74;
        r411.setStyle(Paint.Style.STROKE);
        float r131 = r110;
        r411.setStrokeWidth(r131);
        r411.setColor(r123);
        float r132 = r131 * 0.5f;
        r410.drawRect(new RectF(r104 + r132, r105 + r132, r128 - r132, r129 - r132), r411);
        Paint r133 = r411;
    L106:
        r133.setAntiAlias(true);
        return;
    L74:
        if (r111 <= 0) goto L76;
        float r134 = r111;
        float r135 = r105 + (r134 * 0.5f);
        int r136 = r123;
        int r137 = r104;
        r130.strokeBorderLine(r410, r411, 1, r134, r136, r104, r135, r128 - Math.max(r100, 0), r135, r128 - r104, r134);
        int r138 = r100;
    L77:
        if (r138 <= 0) goto L79;
        float r139 = r138;
        float r140 = r128 - (r139 * 0.5f);
        int r141 = r136;
        int r310 = r105;
        int r311 = r128;
        r130.strokeBorderLine(r410, r411, 2, r139, r141, r140, r105, r140, r129 - Math.max(r101, 0), r129 - r105, r139);
        int r142 = r101;
    L80:
        if (r142 <= 0) goto L82;
        float r143 = r142;
        float r144 = r129 - (r143 * 0.5f);
        int r145 = r311;
        int r146 = r136;
        r130.strokeBorderLine(r410, r411, 3, r143, r146, r145, r144, r137 + Math.max(r110, 0), r144, r145 - r137, r143);
    L82:
        if (r110 <= 0) goto L105;
        float r147 = r110;
        float r148 = r137 + (0.5f * r147);
        int r149 = r310;
        int r150 = r136;
        r130.strokeBorderLine(r410, r411, 0, r147, r150, r148, r129, r148, r149 + Math.max(r111, 0), r129 - r149, r147);
        goto L105
    L79:
        r311 = r128;
        r310 = r105;
        r142 = r101;
        goto L80
    L76:
        r136 = r123;
        r137 = r104;
        r138 = r100;
    L62:
        r127 = false;
    L84:
        int r151 = r412.width();
        int r152 = r412.height();
        if (r111 > 0) goto L87;
    L89:
        int r312 = r105;
    L90:
        if (r11 > 0) goto L92;
    L94:
        int r153 = r312;
        int r415 = r152;
        int r416 = r10;
    L95:
        int r154 = r416;
        if (r154 > 0) goto L98;
    L100:
        int r417 = r415;
    L101:
        if (r110 <= 0) goto L105;
        if (Color.alpha(r112) == 0) goto L105;
        float r155 = r104 + r110;
        float r156 = r153 + r9;
        int r157 = r417;
        int r158 = r153 + r157;
        float r159 = r158 - r154;
        float r160 = r158;
        float r161 = r104;
        float r162 = r110;
        float r163 = r161 + (0.5f * r162);
        r410.save();
        float r164 = r153;
        a(r410, r161, r164, r155, r156, r155, r159, r161, r160);
        r510[0].strokeBorderLine(r410, r411, 0, r162, r112, r163, r160, r163, r164, r157, r162);
        r410.restore();
        goto L105
    L98:
        if (Color.alpha(r210) == 0) goto L100;
        int r165 = r415;
        int r166 = r153 + r165;
        float r167 = r166;
        int r168 = r104 + r151;
        float r169 = r168;
        float r170 = r168 - r11;
        float r171 = r166 - r154;
        float r172 = r104 + r110;
        float r173 = r154;
        float r174 = r167 - (r173 * 0.5f);
        r410.save();
        float r175 = r104;
        a(r410, r175, r167, r169, r167, r170, r171, r172, r171);
        r417 = r165;
        r510[3].strokeBorderLine(r410, r411, 3, r173, r210, r169, r174, r175, r174, r151, r173);
        r410.restore();
        goto L101
    L92:
        if (Color.alpha(r113) == 0) goto L94;
        int r176 = r104 + r151;
        float r177 = r176;
        int r178 = r312;
        int r179 = r178 + r152;
        float r180 = r179;
        float r181 = r176 - r11;
        float r182 = r100;
        float r313 = r177 - (r182 * 0.5f);
        r410.save();
        float r183 = r178;
        a(r410, r177, r183, r177, r180, r181, r179 - r101, r181, r178 + r111);
        r416 = r101;
        r415 = r152;
        r153 = r178;
        r510[2].strokeBorderLine(r410, r411, 2, r182, r113, r313, r183, r313, r180, r152, r182);
        r410.restore();
        goto L95
    L87:
        if (Color.alpha(r103) == 0) goto L89;
        float r184 = r104 + r110;
        float r185 = r105 + r111;
        int r186 = r104 + r151;
        float r187 = r186 - r100;
        float r188 = r186;
        float r189 = r105;
        float r190 = r111;
        float r314 = r189 + (r190 * 0.5f);
        r410.save();
        float r191 = r104;
        a(r410, r191, r189, r184, r185, r187, r185, r188, r189);
        r312 = r105;
        r510[1].strokeBorderLine(r410, r411, 1, r190, r103, r191, r314, r188, r314, r151, r190);
        r410.restore();
        goto L90
    L51:
        r123 = 0;
        goto L53
    L47:
        r122 = 0;
        goto L49
    L43:
        r120 = 0;
        goto L44
    L39:
        r118 = 0;
        goto L40
    L36:
        r117 = 0;
        goto L37
    L29:
        r114 = -1;
        goto L30
    L25:
        r108 = -1;
        goto L26
    L22:
        r107 = -1;
    L105:
        r133 = r411;
    L17:
        r102 = true;
        goto L18
    L111:
        return;
    }

    public static void a(Canvas r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108) {
        Path r109 = new Path();
        r109.reset();
        r109.moveTo(r101, r102);
        r109.lineTo(r103, r104);
        r109.lineTo(r105, r106);
        r109.lineTo(r107, r108);
        r109.lineTo(r101, r102);
        r100.clipPath(r109);
    }

    public static void d(Canvas r100, Paint r110, BorderStyle r111, int r112, int r113, float r114, float r115, x6a.j r116, x6a.j r117) {
        switch(a.f383132a[r111.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L19;
            case 5: goto L21;
            case 6: goto L16;
            case 7: goto L12;
            case 8: goto L9;
            case 9: goto L7;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        LLog.e("BorderDrawingUtil", "Unsupported border style: " + r111);
        goto L21
    L5:
        e(r100, r110, r112, r114 / 2.0f, BorderStyle.darkenColor(r113), r113, false, r116, r117);
        return;
    L7:
        e(r100, r110, r112, r114 / 2.0f, r113, BorderStyle.darkenColor(r113), false, r116, r117);
        return;
    L9:
        e(r100, r110, r112, r114 / 3.0f, r113, r113, true, r116, r117);
        return;
    L16:
        if (r112 == 1) goto L18;
        if (r112 != 0) goto L21;
    L18:
        int r101 = BorderStyle.darkenColor(r113);
    L22:
        PathEffect r102 = null;
    L23:
        r110.setStyle(Paint.Style.STROKE);
        r110.setColor(c.a(r101, 255));
        r110.setStrokeWidth(r115);
        r110.setPathEffect(r102);
        r110.setAntiAlias(true);
        new BackgroundDrawable.RoundRectPath(r116, r117, BackgroundDrawable.RoundRectPath.Pos.CENTER).b(r100, r110);
        r110.setPathEffect(null);
        return;
    L19:
        r102 = r111.getPathEffect(r114);
        r101 = r113;
        goto L23
    L20:
        return;
    L21:
        r101 = r113;
        goto L22
    L12:
        if (r112 != 3) goto L14;
    L15:
        r101 = BorderStyle.darkenColor(r113);
        goto L22
    L14:
        if (r112 != 2) goto L21;
        goto L15
    }

    public static void e(Canvas r100, Paint r101, int r102, float r103, int r104, int r105, boolean r106, x6a.j r107, x6a.j r110) {
        r101.setPathEffect(null);
        r101.setStyle(Paint.Style.STROKE);
        r101.setStrokeWidth(r103);
        boolean r108 = true;
        if (r102 == 1) goto L7;
        if (r102 == 0) goto L7;
        r108 = false;
    L7:
        if (r108 == false) goto L9;
        int r109 = r105;
    L10:
        r101.setColor(c.a(r109, 255));
        if (r106 == false) goto L13;
        BackgroundDrawable.RoundRectPath.Pos r111 = BackgroundDrawable.RoundRectPath.Pos.OUTER3;
    L14:
        new BackgroundDrawable.RoundRectPath(r107, r110, r111).b(r100, r101);
        if (r108 == true) goto L18;
        r104 = r105;
    L18:
        r101.setColor(c.a(r104, 255));
        if (r106 == false) goto L21;
        BackgroundDrawable.RoundRectPath.Pos r112 = BackgroundDrawable.RoundRectPath.Pos.INNER3;
    L22:
        new BackgroundDrawable.RoundRectPath(r107, r110, r112).b(r100, r101);
        return;
    L21:
        r112 = BackgroundDrawable.RoundRectPath.Pos.INNER2;
        goto L22
    L13:
        r111 = BackgroundDrawable.RoundRectPath.Pos.OUTER2;
        goto L14
    L9:
        r109 = r104;
        goto L10
    }

    public static void b(Canvas r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r110, boolean r111, x6a.j r112, x6a.j r113) {
        if (r111 == false) goto L4;
        Path r114 = new Path();
        r114.addRoundRect(r112.f562749a, r112.f562750b, Path.Direction.CW);
        r100.clipPath(r114, Region.Op.INTERSECT);
        Path r115 = new Path();
        r115.addRoundRect(r113.f562749a, r113.f562750b, Path.Direction.CW);
        r100.clipPath(r115, Region.Op.DIFFERENCE);
    L4:
        a(r100, r101, r102, r103, r104, r105, r106, r107, r110);
    }
}
