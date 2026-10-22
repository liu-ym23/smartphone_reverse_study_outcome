package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public static void a(View r12, ColorValueItem r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        if (r13 != null) goto L5;
        return;
    L5:
        float r1 = 1.0f;
        boolean r2 = true;
        int r3 = 0;
        String r4 = "linear";
        String r6 = "";
        Integer r9 = null;
        List<ColorValueItem.ColorStop> r10 = null;
        List<ColorValueItem.ColorStop> r11 = null;
        if ((r12 instanceof CircleColorView) == false) goto L49;
        ColorValueItem.Data r0 = r13.getData();
        if (Intrinsics.areEqual(r13.getType(), "rgba") == false) goto L12;
        if (r0 == null) goto L12;
        ((CircleColorView) r12).setColor(b(r0.getAlpha(), r0.getR(), r0.getG(), r0.getB()));
        return;
    L12:
        if (r0 == null) goto L14;
        r10 = r0.getColorStops();
    L14:
        List<ColorValueItem.ColorStop> r8 = r10;
        if (r8 != null) goto L17;
    L20:
        if (r2 == true) goto L46;
        List<ColorValueItem.ColorStop> r14 = r10;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r7 = r14.iterator();
    L23:
        if (r7.hasNext() == false) goto L36;
        ColorValueItem.ColorStop r15 = (ColorValueItem.ColorStop) r7.next();
        String r16 = r15.getColor();
        if (r16 != null) goto L27;
        r16 = "";
    L27:
        Float r17 = r15.getAlpha();
        if (r17 == null) goto L30;
        float r18 = r17.floatValue();
    L31:
        Float r19 = r15.getOffset();
        if (r19 == null) goto L34;
        float r20 = r19.floatValue();
    L35:
        r5.add(new d(r18, r16, r20));
        goto L23
    L34:
        r20 = 0.0f;
        goto L35
    L30:
        r18 = 1.0f;
        goto L31
    L36:
        String r110 = r13.getType();
        if (r110 == null) goto L40;
        r4 = r110;
    L40:
        if (r0 == null) goto L44;
        Double r111 = r0.getAngle();
        if (r111 == null) goto L44;
        r3 = (int) r111.doubleValue();
    L44:
        ((CircleColorView) r12).setGradientColor(new e(r3, r4, r5));
        return;
    L46:
        ((CircleColorView) r12).setColor(-1);
        return;
    L17:
        if (r8.isEmpty() == true) goto L20;
        r2 = false;
        goto L20
    L49:
        if ((r12 instanceof RoundedView) == false) goto L75;
        ColorValueItem.Data r21 = r13.getData();
        if (Intrinsics.areEqual(r13.getType(), "rgba") == false) goto L55;
        if (r21 == null) goto L55;
        ((RoundedView) r12).setColor(b(r21.getAlpha(), r21.getR(), r21.getG(), r21.getB()));
        return;
    L55:
        if (r21 == null) goto L57;
        r11 = r21.getColorStops();
    L57:
        List<ColorValueItem.ColorStop> r112 = r11;
        if (r112 != null) goto L60;
    L63:
        if (r2 == true) goto L73;
        ColorValueItem.ColorStop r113 = (ColorValueItem.ColorStop) ListProtector.get(r11, 0);
        String r22 = r113.getColor();
        if (r22 == null) goto L68;
        r6 = r22;
    L68:
        Float r114 = r113.getAlpha();
        if (r114 == null) goto L71;
        r1 = r114.floatValue();
    L71:
        ((RoundedView) r12).setColor(c(r6, r1));
        return;
    L73:
        ((RoundedView) r12).setColor(-1);
        return;
    L60:
        if (r112.isEmpty() == true) goto L63;
        r2 = false;
        goto L63
    L75:
        ColorValueItem.Data r23 = r13.getData();
        if (Intrinsics.areEqual(r13.getType(), "rgba") == false) goto L80;
        if (r23 == null) goto L80;
        r12.setBackgroundColor(b(r23.getAlpha(), r23.getR(), r23.getG(), r23.getB()));
        return;
    L80:
        if (r23 == null) goto L82;
        List<ColorValueItem.ColorStop> r24 = r23.getColorStops();
    L83:
        List<ColorValueItem.ColorStop> r115 = r24;
        if (r115 != null) goto L86;
    L89:
        boolean r116 = true;
    L90:
        if (r116 == false) goto L93;
        r12.setBackgroundColor(-1);
        return;
    L93:
        List<ColorValueItem.ColorStop> r25 = r24;
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator<T> r27 = r25.iterator();
    L95:
        if (r27.hasNext() == false) goto L104;
        ColorValueItem.ColorStop r28 = (ColorValueItem.ColorStop) r27.next();
        c r117 = a;
        String r118 = r28.getColor();
        if (r118 != null) goto L99;
        r118 = "";
    L99:
        Float r29 = r28.getAlpha();
        if (r29 == null) goto L102;
        float r30 = r29.floatValue();
    L103:
        r117.getClass();
        r26.add(Integer.valueOf(c(r118, r30)));
        goto L95
    L102:
        r30 = 1.0f;
        goto L103
    L104:
        int[] r31 = CollectionsKt.toIntArray(r26);
        String r119 = r13.getType();
        if (r119 == null) goto L109;
        r4 = r119;
    L109:
        if (Intrinsics.areEqual(r4, "radial") == false) goto L120;
        GradientDrawable r120 = new GradientDrawable();
        r120.setGradientType(1);
        r120.setColors(r31);
        r120.setGradientCenter(0.5f, 0.5f);
        Integer r32 = Integer.valueOf(Math.max(r12.getWidth(), r12.getHeight()));
        if (r32.intValue() > 0) goto L114;
        r2 = false;
    L114:
        if (r2 == false) goto L116;
        r9 = r32;
    L116:
        if (r9 == null) goto L118;
        int r33 = r9.intValue();
    L119:
        r120.setGradientRadius(r33);
        r12.setBackground(r120);
        return;
    L118:
        r33 = 100;
        goto L119
    L120:
        if (r23 == null) goto L124;
        Double r121 = r23.getAngle();
        if (r121 == null) goto L124;
        int r122 = (int) r121.doubleValue();
    L125:
        int r123 = ((r122 % 360) + 360) % 360;
        if (r123 < 0) goto L129;
        if (r123 >= 23) goto L129;
        boolean r34 = true;
    L130:
        if (r34 == false) goto L132;
    L177:
        GradientDrawable.Orientation r124 = GradientDrawable.Orientation.LEFT_RIGHT;
    L178:
        r12.setBackground(new GradientDrawable(r124, r31));
        return;
    L132:
        if (r123 >= 338) goto L177;
        if (23 > r123) goto L138;
        if (r123 >= 68) goto L138;
        boolean r35 = true;
    L139:
        if (r35 == false) goto L142;
        r124 = GradientDrawable.Orientation.BL_TR;
        goto L178
    L142:
        if (68 > r123) goto L145;
        if (r123 >= 113) goto L145;
        boolean r36 = true;
    L146:
        if (r36 == false) goto L149;
        r124 = GradientDrawable.Orientation.BOTTOM_TOP;
        goto L178
    L149:
        if (113 > r123) goto L152;
        if (r123 >= 158) goto L152;
        boolean r37 = true;
    L153:
        if (r37 == false) goto L156;
        r124 = GradientDrawable.Orientation.BR_TL;
        goto L178
    L156:
        if (158 > r123) goto L159;
        if (r123 >= 203) goto L159;
        boolean r38 = true;
    L160:
        if (r38 == false) goto L163;
        r124 = GradientDrawable.Orientation.RIGHT_LEFT;
        goto L178
    L163:
        if (203 > r123) goto L166;
        if (r123 >= 248) goto L166;
        boolean r39 = true;
    L167:
        if (r39 == false) goto L169;
        r124 = GradientDrawable.Orientation.TR_BL;
        goto L178
    L169:
        if (248 <= r123) goto L171;
    L173:
        r2 = false;
    L174:
        if (r2 == false) goto L176;
        r124 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L178
    L176:
        r124 = GradientDrawable.Orientation.TL_BR;
        goto L178
    L171:
        if (r123 >= 293) goto L173;
    L166:
        r39 = false;
    L159:
        r38 = false;
    L152:
        r37 = false;
    L145:
        r36 = false;
    L138:
        r35 = false;
    L129:
        r34 = false;
    L124:
        r122 = 0;
        goto L125
    L86:
        if (r115.isEmpty() == true) goto L89;
        r116 = false;
        goto L90
    L82:
        r24 = null;
        goto L83
    }

    public static int c(String r2, float r3) {
        int r4 = Color.parseColor(r2);     // Catch: IllegalArgumentException -> L4
    L6:
        return Color.argb((int) (RangesKt.coerceIn(r3, 0.0f, 1.0f) * 255), Color.red(r4), Color.green(r4), Color.blue(r4));
    L4:
        r4 = -16777216;
        goto L6
    }

    public static boolean d(Context r6, ColorValueItem r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "colorValue");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L48
        List<ColorValueItem.ColorStop> r2 = null;
        Float r3 = null;
        if (Intrinsics.areEqual(r7.getType(), "rgba") == false) goto L19;
        ColorValueItem.Data r8 = r7.getData();     // Catch: Throwable -> L48
        if (r8 == null) goto L8;
        Integer r4 = r8.getR();     // Catch: Throwable -> L48
    L9:
        if (r8 == null) goto L11;
        Integer r5 = r8.getG();     // Catch: Throwable -> L48
    L12:
        if (r8 == null) goto L14;
        Integer r9 = r8.getB();     // Catch: Throwable -> L48
    L15:
        if (r8 == null) goto L18;
        r3 = r8.getAlpha();     // Catch: Throwable -> L48
    L18:
        return e(r6, r4, r5, r9, r3);
    L14:
        r9 = null;
        goto L15
    L11:
        r5 = null;
        goto L12
    L8:
        r4 = null;
        goto L9
    L19:
        ColorValueItem.Data r10 = r7.getData();     // Catch: Throwable -> L48
        if (r10 == null) goto L22;
        r2 = r10.getColorStops();     // Catch: Throwable -> L48
    L22:
        List<ColorValueItem.ColorStop> r11 = r2;     // Catch: Throwable -> L48
        if (r11 != null) goto L25;
    L28:
        boolean r12 = true;
    L29:
        if (r12 == false) goto L31;
        return false;
    L31:
        List<ColorValueItem.ColorStop> r13 = r2;     // Catch: Throwable -> L48
        if ((r13 instanceof Collection) == true) goto L34;
    L36:
        Iterator<T> r14 = r13.iterator();     // Catch: Throwable -> L48
    L38:
        if (r14.hasNext() == false) goto L46;
        ColorValueItem.ColorStop r15 = (ColorValueItem.ColorStop) r14.next();     // Catch: Throwable -> L48
        int r16 = Color.parseColor(r15.getColor());     // Catch: Exception -> L43 Throwable -> L48
        boolean r17 = e(r6, Integer.valueOf(Color.red(r16)), Integer.valueOf(Color.green(r16)), Integer.valueOf(Color.blue(r16)), r15.getAlpha());     // Catch: Throwable -> L48
    L44:
        if (r17 == true) goto L38;
        return false;
    L43:
        r17 = false;
    L46:
        return true;
    L34:
        if (r13.isEmpty() == false) goto L36;
    L25:
        if (r11.isEmpty() == true) goto L28;
        r12 = false;
    L48:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Throwable r19 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r19 == null) goto L52;
        tt5.a.e("ColorRenderUtil", "shouldShowBorder", r19, false);
    L52:
        return false;
    }

    public static int b(Float r2, Integer r3, Integer r4, Integer r5) {
        float r0 = 1.0f;
        if (r2 == null) goto L5;
        r0 = RangesKt.coerceIn(r2.floatValue(), 0.0f, 1.0f);
    L5:
        int r1 = (int) (r0 * 255);
        int r6 = 0;
        if (r3 == null) goto L8;
        int r7 = RangesKt.coerceIn(r3.intValue(), 0, 255);
    L9:
        if (r4 == null) goto L11;
        int r8 = RangesKt.coerceIn(r4.intValue(), 0, 255);
    L12:
        if (r5 == null) goto L15;
        r6 = RangesKt.coerceIn(r5.intValue(), 0, 255);
    L15:
        return Color.argb(r1, r7, r8, r6);
    L11:
        r8 = 0;
        goto L12
    L8:
        r7 = 0;
        goto L9
    }

    public static boolean e(Context r19, Integer r20, Integer r21, Integer r22, Float r23) {
        Intrinsics.checkNotNullParameter(r19, "context");
        if (r20 == null) goto L42;
        if (r21 == null) goto L43;
        if (r22 == null) goto L44;
        if (r23 == null) goto L47;
        int r2 = r20.intValue();
        double r5 = ((double) r2) / 255.0d;
        double r3 = ((double) r21.intValue()) / 255.0d;
        double r9 = ((double) r22.intValue()) / 255.0d;
        if (r5 > 0.03928d) goto L11;
        double r6 = r5 / 12.92d;
    L13:
        if (r3 > 0.03928d) goto L15;
        double r4 = r3 / 12.92d;
    L17:
        if (r9 > 0.03928d) goto L19;
        double r10 = r9 / 12.92d;
    L20:
        double r7 = ((r6 * 0.2126d) + (r4 * 0.7152d)) + (r10 * 0.0722d);
        if (r7 > 0.008856d) goto L23;
        double r8 = r7 * 903.3d;
    L24:
        float r11 = RangesKt.coerceIn(r23.floatValue(), 0.0f, 1.0f);
        if (h18.f.a(r19) == false) goto L37;
        if (0.0d <= r8) goto L29;
    L31:
        boolean r1 = false;
    L32:
        if (r1 == false) goto L34;
    L40:
        return true;
    L34:
        if (r11 < 0.2d) goto L40;
        return false;
    L29:
        if (r8 > 20.0d) goto L31;
        r1 = true;
        goto L32
    L37:
        if (r8 >= 94.0d) goto L40;
        if (r11 < 0.2d) goto L40;
        return false;
    L23:
        r8 = (Math.pow(r7, 0.3333333333333333d) * 116.0d) - 16.0d;
        goto L24
    L19:
        r10 = Math.pow((r9 + 0.055d) / 1.055d, 2.4d);
        goto L20
    L15:
        r4 = Math.pow((r3 + 0.055d) / 1.055d, 2.4d);
        goto L17
    L11:
        r6 = Math.pow((r5 + 0.055d) / 1.055d, 2.4d);
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
