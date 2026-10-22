package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f238659a = null;

    static {
        f238659a = new c();
    }

    public c() {
    }

    public static void a(View r110, ColorValueItem r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if (r111 != null) goto L5;
        return;
    L5:
        float r100 = 1.0f;
        boolean r101 = true;
        int r102 = 0;
        String r103 = "linear";
        String r104 = "";
        Integer r105 = null;
        List<ColorValueItem.ColorStop> r106 = null;
        List<ColorValueItem.ColorStop> r107 = null;
        if ((r110 instanceof CircleColorView) == false) goto L49;
        ColorValueItem.Data r108 = r111.getData();
        if (Intrinsics.areEqual(r111.getType(), "rgba") == false) goto L12;
        if (r108 == null) goto L12;
        ((CircleColorView) r110).setColor(b(r108.getAlpha(), r108.getR(), r108.getG(), r108.getB()));
        return;
    L12:
        if (r108 == null) goto L14;
        r106 = r108.getColorStops();
    L14:
        List<ColorValueItem.ColorStop> r109 = r106;
        if (r109 != null) goto L17;
    L20:
        if (r101 == true) goto L46;
        List<ColorValueItem.ColorStop> r112 = r106;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
    L23:
        if (r114.hasNext() == false) goto L36;
        ColorValueItem.ColorStop r115 = (ColorValueItem.ColorStop) r114.next();
        String r116 = r115.getColor();
        if (r116 != null) goto L27;
        r116 = "";
    L27:
        Float r117 = r115.getAlpha();
        if (r117 == null) goto L30;
        float r118 = r117.floatValue();
    L31:
        Float r119 = r115.getOffset();
        if (r119 == null) goto L34;
        float r120 = r119.floatValue();
    L35:
        r113.add(new d(r118, r116, r120));
        goto L23
    L34:
        r120 = 0.0f;
        goto L35
    L30:
        r118 = 1.0f;
        goto L31
    L36:
        String r121 = r111.getType();
        if (r121 == null) goto L40;
        r103 = r121;
    L40:
        if (r108 == null) goto L44;
        Double r122 = r108.getAngle();
        if (r122 == null) goto L44;
        r102 = (int) r122.doubleValue();
    L44:
        ((CircleColorView) r110).setGradientColor(new e(r102, r103, r113));
        return;
    L46:
        ((CircleColorView) r110).setColor(-1);
        return;
    L17:
        if (r109.isEmpty() == true) goto L20;
        r101 = false;
        goto L20
    L49:
        if ((r110 instanceof RoundedView) == false) goto L75;
        ColorValueItem.Data r123 = r111.getData();
        if (Intrinsics.areEqual(r111.getType(), "rgba") == false) goto L55;
        if (r123 == null) goto L55;
        ((RoundedView) r110).setColor(b(r123.getAlpha(), r123.getR(), r123.getG(), r123.getB()));
        return;
    L55:
        if (r123 == null) goto L57;
        r107 = r123.getColorStops();
    L57:
        List<ColorValueItem.ColorStop> r124 = r107;
        if (r124 != null) goto L60;
    L63:
        if (r101 == true) goto L73;
        ColorValueItem.ColorStop r125 = (ColorValueItem.ColorStop) ListProtector.get(r107, 0);
        String r126 = r125.getColor();
        if (r126 == null) goto L68;
        r104 = r126;
    L68:
        Float r127 = r125.getAlpha();
        if (r127 == null) goto L71;
        r100 = r127.floatValue();
    L71:
        ((RoundedView) r110).setColor(c(r104, r100));
        return;
    L73:
        ((RoundedView) r110).setColor(-1);
        return;
    L60:
        if (r124.isEmpty() == true) goto L63;
        r101 = false;
        goto L63
    L75:
        ColorValueItem.Data r128 = r111.getData();
        if (Intrinsics.areEqual(r111.getType(), "rgba") == false) goto L80;
        if (r128 == null) goto L80;
        r110.setBackgroundColor(b(r128.getAlpha(), r128.getR(), r128.getG(), r128.getB()));
        return;
    L80:
        if (r128 == null) goto L82;
        List<ColorValueItem.ColorStop> r129 = r128.getColorStops();
    L83:
        List<ColorValueItem.ColorStop> r130 = r129;
        if (r130 != null) goto L86;
    L89:
        boolean r131 = true;
    L90:
        if (r131 == false) goto L93;
        r110.setBackgroundColor(-1);
        return;
    L93:
        List<ColorValueItem.ColorStop> r132 = r129;
        ArrayList r133 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r132, 10));
        Iterator<T> r134 = r132.iterator();
    L95:
        if (r134.hasNext() == false) goto L104;
        ColorValueItem.ColorStop r135 = (ColorValueItem.ColorStop) r134.next();
        c r136 = f238659a;
        String r137 = r135.getColor();
        if (r137 != null) goto L99;
        r137 = "";
    L99:
        Float r138 = r135.getAlpha();
        if (r138 == null) goto L102;
        float r139 = r138.floatValue();
    L103:
        r136.getClass();
        r133.add(Integer.valueOf(c(r137, r139)));
        goto L95
    L102:
        r139 = 1.0f;
        goto L103
    L104:
        int[] r140 = CollectionsKt.toIntArray(r133);
        String r141 = r111.getType();
        if (r141 == null) goto L109;
        r103 = r141;
    L109:
        if (Intrinsics.areEqual(r103, "radial") == false) goto L120;
        GradientDrawable r142 = new GradientDrawable();
        r142.setGradientType(1);
        r142.setColors(r140);
        r142.setGradientCenter(0.5f, 0.5f);
        Integer r143 = Integer.valueOf(Math.max(r110.getWidth(), r110.getHeight()));
        if (r143.intValue() > 0) goto L114;
        r101 = false;
    L114:
        if (r101 == false) goto L116;
        r105 = r143;
    L116:
        if (r105 == null) goto L118;
        int r144 = r105.intValue();
    L119:
        r142.setGradientRadius(r144);
        r110.setBackground(r142);
        return;
    L118:
        r144 = 100;
        goto L119
    L120:
        if (r128 == null) goto L124;
        Double r145 = r128.getAngle();
        if (r145 == null) goto L124;
        int r146 = (int) r145.doubleValue();
    L125:
        int r147 = ((r146 % 360) + 360) % 360;
        if (r147 < 0) goto L129;
        if (r147 >= 23) goto L129;
        boolean r148 = true;
    L130:
        if (r148 == false) goto L132;
    L177:
        GradientDrawable.Orientation r149 = GradientDrawable.Orientation.LEFT_RIGHT;
    L178:
        r110.setBackground(new GradientDrawable(r149, r140));
        return;
    L132:
        if (r147 >= 338) goto L177;
        if (23 > r147) goto L138;
        if (r147 >= 68) goto L138;
        boolean r150 = true;
    L139:
        if (r150 == false) goto L142;
        r149 = GradientDrawable.Orientation.BL_TR;
        goto L178
    L142:
        if (68 > r147) goto L145;
        if (r147 >= 113) goto L145;
        boolean r151 = true;
    L146:
        if (r151 == false) goto L149;
        r149 = GradientDrawable.Orientation.BOTTOM_TOP;
        goto L178
    L149:
        if (113 > r147) goto L152;
        if (r147 >= 158) goto L152;
        boolean r152 = true;
    L153:
        if (r152 == false) goto L156;
        r149 = GradientDrawable.Orientation.BR_TL;
        goto L178
    L156:
        if (158 > r147) goto L159;
        if (r147 >= 203) goto L159;
        boolean r153 = true;
    L160:
        if (r153 == false) goto L163;
        r149 = GradientDrawable.Orientation.RIGHT_LEFT;
        goto L178
    L163:
        if (203 > r147) goto L166;
        if (r147 >= 248) goto L166;
        boolean r154 = true;
    L167:
        if (r154 == false) goto L169;
        r149 = GradientDrawable.Orientation.TR_BL;
        goto L178
    L169:
        if (248 <= r147) goto L171;
    L173:
        r101 = false;
    L174:
        if (r101 == false) goto L176;
        r149 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L178
    L176:
        r149 = GradientDrawable.Orientation.TL_BR;
        goto L178
    L171:
        if (r147 >= 293) goto L173;
    L166:
        r154 = false;
    L159:
        r153 = false;
    L152:
        r152 = false;
    L145:
        r151 = false;
    L138:
        r150 = false;
    L129:
        r148 = false;
    L124:
        r146 = 0;
        goto L125
    L86:
        if (r130.isEmpty() == true) goto L89;
        r131 = false;
        goto L90
    L82:
        r129 = null;
        goto L83
    }

    public static int c(String r100, float r101) {
        int r102 = Color.parseColor(r100);     // Catch: IllegalArgumentException -> L4
    L6:
        return Color.argb((int) (RangesKt.coerceIn(r101, 0.0f, 1.0f) * 255), Color.red(r102), Color.green(r102), Color.blue(r102));
    L4:
        r102 = -16777216;
        goto L6
    }

    public static boolean d(Context r100, ColorValueItem r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "colorValue");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L48
        List<ColorValueItem.ColorStop> r103 = null;
        Float r104 = null;
        if (Intrinsics.areEqual(r101.getType(), "rgba") == false) goto L19;
        ColorValueItem.Data r105 = r101.getData();     // Catch: Throwable -> L48
        if (r105 == null) goto L8;
        Integer r106 = r105.getR();     // Catch: Throwable -> L48
    L9:
        if (r105 == null) goto L11;
        Integer r107 = r105.getG();     // Catch: Throwable -> L48
    L12:
        if (r105 == null) goto L14;
        Integer r108 = r105.getB();     // Catch: Throwable -> L48
    L15:
        if (r105 == null) goto L18;
        r104 = r105.getAlpha();     // Catch: Throwable -> L48
    L18:
        return e(r100, r106, r107, r108, r104);
    L14:
        r108 = null;
        goto L15
    L11:
        r107 = null;
        goto L12
    L8:
        r106 = null;
        goto L9
    L19:
        ColorValueItem.Data r109 = r101.getData();     // Catch: Throwable -> L48
        if (r109 == null) goto L22;
        r103 = r109.getColorStops();     // Catch: Throwable -> L48
    L22:
        List<ColorValueItem.ColorStop> r110 = r103;     // Catch: Throwable -> L48
        if (r110 != null) goto L25;
    L28:
        boolean r111 = true;
    L29:
        if (r111 == false) goto L31;
        return false;
    L31:
        List<ColorValueItem.ColorStop> r112 = r103;     // Catch: Throwable -> L48
        if ((r112 instanceof Collection) == true) goto L34;
    L36:
        Iterator<T> r113 = r112.iterator();     // Catch: Throwable -> L48
    L38:
        if (r113.hasNext() == false) goto L46;
        ColorValueItem.ColorStop r114 = (ColorValueItem.ColorStop) r113.next();     // Catch: Throwable -> L48
        int r115 = Color.parseColor(r114.getColor());     // Catch: Exception -> L43 Throwable -> L48
        boolean r116 = e(r100, Integer.valueOf(Color.red(r115)), Integer.valueOf(Color.green(r115)), Integer.valueOf(Color.blue(r115)), r114.getAlpha());     // Catch: Throwable -> L48
    L44:
        if (r116 == true) goto L38;
        return false;
    L43:
        r116 = false;
    L46:
        return true;
    L34:
        if (r112.isEmpty() == false) goto L36;
    L25:
        if (r110.isEmpty() == true) goto L28;
        r111 = false;
    L48:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Throwable r118 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r118 == null) goto L52;
        tt5.a.e("ColorRenderUtil", "shouldShowBorder", r118, false);
    L52:
        return false;
    }

    public static int b(Float r100, Integer r101, Integer r102, Integer r103) {
        float r104 = 1.0f;
        if (r100 == null) goto L5;
        r104 = RangesKt.coerceIn(r100.floatValue(), 0.0f, 1.0f);
    L5:
        int r105 = (int) (r104 * 255);
        int r106 = 0;
        if (r101 == null) goto L8;
        int r107 = RangesKt.coerceIn(r101.intValue(), 0, 255);
    L9:
        if (r102 == null) goto L11;
        int r108 = RangesKt.coerceIn(r102.intValue(), 0, 255);
    L12:
        if (r103 == null) goto L15;
        r106 = RangesKt.coerceIn(r103.intValue(), 0, 255);
    L15:
        return Color.argb(r105, r107, r108, r106);
    L11:
        r108 = 0;
        goto L12
    L8:
        r107 = 0;
        goto L9
    }

    public static boolean e(Context r110, Integer r210, Integer r211, Integer r212, Float r213) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r210 == null) goto L42;
        if (r211 == null) goto L43;
        if (r212 == null) goto L44;
        if (r213 == null) goto L47;
        int r100 = r210.intValue();
        double r101 = ((double) r100) / 255.0d;
        double r102 = ((double) r211.intValue()) / 255.0d;
        double r103 = ((double) r212.intValue()) / 255.0d;
        if (r101 > 0.03928d) goto L11;
        double r104 = r101 / 12.92d;
    L13:
        if (r102 > 0.03928d) goto L15;
        double r105 = r102 / 12.92d;
    L17:
        if (r103 > 0.03928d) goto L19;
        double r106 = r103 / 12.92d;
    L20:
        double r107 = ((r104 * 0.2126d) + (r105 * 0.7152d)) + (r106 * 0.0722d);
        if (r107 > 0.008856d) goto L23;
        double r108 = r107 * 903.3d;
    L24:
        float r109 = RangesKt.coerceIn(r213.floatValue(), 0.0f, 1.0f);
        if (h18.f.a(r110) == false) goto L37;
        if (AudioStats.AUDIO_AMPLITUDE_NONE <= r108) goto L29;
    L31:
        boolean r111 = false;
    L32:
        if (r111 == false) goto L34;
    L40:
        return true;
    L34:
        if (r109 < 0.2d) goto L40;
        return false;
    L29:
        if (r108 > 20.0d) goto L31;
        r111 = true;
        goto L32
    L37:
        if (r108 >= 94.0d) goto L40;
        if (r109 < 0.2d) goto L40;
        return false;
    L23:
        r108 = (Math.pow(r107, 0.3333333333333333d) * 116.0d) - 16.0d;
        goto L24
    L19:
        r106 = Math.pow((r103 + 0.055d) / 1.055d, 2.4d);
        goto L20
    L15:
        r105 = Math.pow((r102 + 0.055d) / 1.055d, 2.4d);
        goto L17
    L11:
        r104 = Math.pow((r101 + 0.055d) / 1.055d, 2.4d);
        goto L13
    L47:
        return false;
    L44:
        return false;
    L43:
        return false;
    L42:
        return false;
    }
}
