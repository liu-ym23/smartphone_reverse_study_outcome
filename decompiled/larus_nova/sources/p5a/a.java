package p5a;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import c5a.c;
import o5a.d;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static Layout a(CharSequence r210, d r211, int r212) {
        Layout.Alignment r100 = Layout.Alignment.ALIGN_NORMAL;
        int r101 = r211.getGravity();
        if (r101 == 3) goto L10;
        if (r101 != 5) goto L6;
        Layout.Alignment r102 = Layout.Alignment.ALIGN_OPPOSITE;
    L11:
        Layout.Alignment r103 = r102;
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 23) goto L26;
        int r105 = r211.getTextDirection();
        if (r105 == 3) goto L20;
        if (r105 == 4) goto L19;
        if (r105 == 5) goto L18;
        TextDirectionHeuristic r106 = TextDirectionHeuristics.LTR;
    L21:
        StaticLayout.Builder r107 = StaticLayout.Builder.obtain(r210, 0, r210.length(), r211.getPaint(), r212).setAlignment(r103).setTextDirection(r106).setLineSpacing(r211.getLineSpacingExtra(), r211.getLineSpacingMultiplier()).setIncludePad(r211.getIncludeFontPadding());
        if (r104 < 28) goto L25;
        r107.setUseLineSpacingFromFallbacks(true);
    L25:
        return r107.build();
    L18:
        r106 = TextDirectionHeuristics.LOCALE;
        goto L21
    L19:
        r106 = TextDirectionHeuristics.RTL;
        goto L21
    L20:
        r106 = TextDirectionHeuristics.LTR;
        goto L21
    L26:
        int r108 = r211.getTextDirection();
        if (r108 == 3) goto L33;
        if (r108 == 4) goto L32;
        if (r108 == 5) goto L31;
        TextDirectionHeuristic r109 = TextDirectionHeuristics.LTR;
    L34:
        int r110 = r210.length();
        TextPaint r111 = r211.getPaint();
        float r112 = r211.getLineSpacingMultiplier();
        float r113 = r211.getLineSpacingExtra();
        boolean r114 = r211.getIncludeFontPadding();
        TextUtils.TruncateAt r115 = TextUtils.TruncateAt.END;
        if (r109 == TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L41;
        Class r116 = Integer.TYPE;     // Catch: Throwable -> L38
        Class r213 = Float.TYPE;     // Catch: Throwable -> L38
        return (StaticLayout) StaticLayout.class.getConstructor(new Class[]{CharSequence.class, r116, r116, TextPaint.class, r116, Layout.Alignment.class, TextDirectionHeuristic.class, r213, r213, Boolean.TYPE, TextUtils.TruncateAt.class, r116, r116}).newInstance(new Object[]{r210, 0, Integer.valueOf(r110), r111, Integer.valueOf(r212), r103, r109, Float.valueOf(r112), Float.valueOf(r113), Boolean.valueOf(r114), r115, Integer.valueOf(r212), Integer.MAX_VALUE});
    L38:
        th = move-exception;
        c.b("Lynx", "create StaticLayout failed!", th);
        return new StaticLayout(r210, 0, r110, r111, r212, r103, r112, r113, r114);
    L41:
        return new StaticLayout(r210, 0, r110, r111, r212, r103, r112, r113, r114);
    L31:
        r109 = TextDirectionHeuristics.LOCALE;
        goto L34
    L32:
        r109 = TextDirectionHeuristics.RTL;
        goto L34
    L33:
        r109 = TextDirectionHeuristics.LTR;
        goto L34
    L6:
        if (r101 == 17) goto L8;
        r102 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    L8:
        r102 = Layout.Alignment.ALIGN_CENTER;
        goto L11
    L10:
        r102 = Layout.Alignment.ALIGN_NORMAL;
        goto L11
    }
}
