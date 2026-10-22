package com.obric.miniapp.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.caverock.androidsvg.SVG;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class f1 {
    public static final o0 a(SVG r110, Context r111) {
        Resources r100 = r111.getResources();
        DisplayMetrics r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        Float r102 = Float.valueOf(r101.density);
        if (r102.floatValue() <= 0.0f) goto L5;
        boolean r103 = true;
    L6:
        Float r104 = null;
        if (r103 == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        float r105 = r102.floatValue();
    L13:
        SVG.d0 r106 = r110.f272756a;
        if (r106 == null) goto L81;
        SVG.b r107 = r106.f272892p;
        if (r107 != null) goto L18;
        RectF r108 = null;
    L20:
        if (r110.f272756a == null) goto L79;
        Float r109 = Float.valueOf(r110.a(r110.f272757b).f272816c);
        float r112 = r109.floatValue();
        if (Float.isInfinite(r112) == false) goto L24;
    L26:
        boolean r113 = false;
    L27:
        if (r113 == true) goto L29;
    L31:
        boolean r114 = false;
    L32:
        if (r114 == true) goto L35;
        r109 = null;
    L35:
        if (r109 != null) goto L41;
        if (r108 == null) goto L39;
        r109 = Float.valueOf(r108.width());
    L40:
        if (r109 != null) goto L41;
        float r115 = 24.0f;
    L44:
        if (r110.f272756a == null) goto L77;
        Float r116 = Float.valueOf(r110.a(r110.f272757b).f272817d);
        float r117 = r116.floatValue();
        if (Float.isInfinite(r117) == false) goto L48;
    L50:
        boolean r118 = false;
    L51:
        if (r118 == true) goto L53;
    L55:
        boolean r119 = false;
    L56:
        if (r119 == true) goto L59;
        r116 = null;
    L59:
        if (r116 == null) goto L61;
        float r120 = r116.floatValue();
    L66:
        int r121 = (int) Math.ceil(r115 * r105);
        float r122 = 24;
        Resources r123 = Resources.getSystem();
        int r124 = RangesKt.coerceAtLeast(r121, MathKt.roundToInt(TypedValue.applyDimension(1, r122, WindowDisplayMetricsOverride.apply(r123, r123.getDisplayMetrics()))));
        int r125 = (int) Math.ceil(r120 * r105);
        Resources r126 = Resources.getSystem();
        int r127 = RangesKt.coerceAtLeast(r125, MathKt.roundToInt(TypedValue.applyDimension(1, r122, WindowDisplayMetricsOverride.apply(r126, r126.getDisplayMetrics()))));
        int r128 = r124 * 3;
        int r129 = r127 * 3;
        float r130 = r128;
        SVG.d0 r131 = r110.f272756a;
        if (r131 == null) goto L75;
        r131.f272833s = new SVG.o(r130);
        float r132 = r129;
        SVG.d0 r133 = r110.f272756a;
        if (r133 == null) goto L73;
        r133.f272834t = new SVG.o(r132);
        Bitmap r134 = Bitmap.createBitmap(r128, r129, Bitmap.Config.ARGB_8888);
        r134.setDensity(r101.densityDpi * 3);
        r110.e(new Canvas(r134));
        o0 r135 = new o0(r111.getResources(), r134, r124, r127);
        r135.setAntiAlias(true);
        r135.setFilterBitmap(true);
        r135.setBounds(0, 0, r124, r127);
        return r135;
    L73:
        throw new IllegalArgumentException("SVG document is empty");
    L75:
        throw new IllegalArgumentException("SVG document is empty");
    L61:
        if (r108 == null) goto L63;
        r104 = Float.valueOf(r108.height());
    L63:
        if (r104 == null) goto L65;
        r120 = r104.floatValue();
        goto L66
    L65:
        r120 = r115;
        goto L66
    L53:
        if (r117 <= 0.0f) goto L55;
        r119 = true;
        goto L56
    L48:
        if (Float.isNaN(r117) == true) goto L50;
        r118 = true;
        goto L51
    L77:
        throw new IllegalArgumentException("SVG document is empty");
    L39:
        r109 = null;
    L41:
        r115 = r109.floatValue();
        goto L44
    L29:
        if (r112 <= 0.0f) goto L31;
        r114 = true;
        goto L32
    L24:
        if (Float.isNaN(r112) == true) goto L26;
        r113 = true;
        goto L27
    L79:
        throw new IllegalArgumentException("SVG document is empty");
    L18:
        float r136 = r107.f272814a;
        float r137 = r107.f272815b;
        r108 = new RectF(r136, r137, r107.f272816c + r136, r107.f272817d + r137);
        goto L20
    L81:
        throw new IllegalArgumentException("SVG document is empty");
    L12:
        r105 = 1.0f;
        goto L13
    L5:
        r103 = false;
        goto L6
    }
}
