package com.ss.android.lark.widget.light.layout;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes38.dex */
public final class g {
    public static StaticLayout a(CharSequence r110, int r111, TextPaint r112, int r113, Layout.Alignment r210, float r211, float r212, boolean r213, TextUtils.TruncateAt r214, int r215) {
        goto L12
    L15:
        return new StaticLayout(r110, 0, r111, r112, r113, r210, r211, r212, r213, r214, r215);
    L5:
        e = move-exception;
        if (e.getMessage().contains("utext_close") == true) goto L9;
        throw e;     // Catch: LinkageError -> L11
    L9:
        return new StaticLayout(r110, 0, r111, r112, r113, r210, r211, r212, r213, r214, r215);
    L12:
        return new StaticLayout(r110, 0, r111, r112, r113, r210, r211, r212, r213, r214, r215);
    }

    public static StaticLayout b(CharSequence r210, int r211, TextPaint r212, int r213, Layout.Alignment r214, float r215, float r216, boolean r310, TextUtils.TruncateAt r311, int r312, int r313, TextDirectionHeuristicCompat r314, int r315, boolean r316) {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 23) goto L31;
        StaticLayout.Builder r101 = StaticLayout.Builder.obtain(r210, 0, r211, r212, r213).setAlignment(r214).setLineSpacing(r216, r215).setIncludePad(r310).setEllipsize(r311).setEllipsizedWidth(r312).setMaxLines(r313);
        if (r314 != TextDirectionHeuristicsCompat.LTR) goto L8;
        TextDirectionHeuristic r102 = TextDirectionHeuristics.LTR;
    L23:
        StaticLayout.Builder r103 = r101.setTextDirection(r102).setBreakStrategy(r315).setHyphenationFrequency(0).setIndents(null, null);
        if (r100 < 26) goto L27;
        r103.setJustificationMode(0);
    L27:
        if (r100 < 28) goto L30;
        r103.setUseLineSpacingFromFallbacks(r316);
    L30:
        return r103.build();
    L8:
        if (r314 != TextDirectionHeuristicsCompat.RTL) goto L11;
        r102 = TextDirectionHeuristics.RTL;
        goto L23
    L11:
        if (r314 != TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR) goto L14;
        r102 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        goto L23
    L14:
        if (r314 != TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL) goto L17;
        r102 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        goto L23
    L17:
        if (r314 != TextDirectionHeuristicsCompat.ANYRTL_LTR) goto L20;
        r102 = TextDirectionHeuristics.ANYRTL_LTR;
        goto L23
    L20:
        if (r314 != TextDirectionHeuristicsCompat.LOCALE) goto L22;
        r102 = TextDirectionHeuristics.LOCALE;
        goto L23
    L22:
        r102 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        goto L23
    L31:
        int r104 = r211;
        StaticLayout r105 = a(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312);
        if (r313 <= 0) goto L50;
    L34:
        if (r105.getLineCount() <= r313) goto L50;
        int r106 = r105.getLineStart(r313);
        if (r106 >= r104) goto L50;
        int r107 = r106;
    L39:
        if (r107 <= 0) goto L43;
        int r108 = r107 - 1;
        if (Character.isSpace(r210.charAt(r108)) == false) goto L43;
        r107 = r108;
    L43:
        int r110 = r107;
        r105 = a(r210, r107, r212, r213, r214, r215, r216, r310, r311, r312);
        if (r105.getLineCount() < r313) goto L49;
        if (r105.getEllipsisCount(r313 - 1) != 0) goto L49;
        String r109 = r210.subSequence(0, r110) + " …";
        r105 = a(r109, r109.length(), r212, r213, r214, r215, r216, r310, r311, r312);
    L49:
        r104 = r110;
    L50:
        int r111 = r105.getLineStart(0);
        int r112 = r105.getLineCount();
        int r113 = 0;
    L51:
        boolean r114 = true;
        if (r113 >= r112) goto L62;
        int r115 = r105.getLineEnd(r113);
        if (r115 < r111) goto L65;
        r113 = r113 + 1;
        r111 = r115;
        goto L51
    L65:
        Field r116 = StaticLayout.class.getDeclaredField("mLines");     // Catch: Exception -> L60
        r116.setAccessible(true);     // Catch: Exception -> L60
        Field r117 = StaticLayout.class.getDeclaredField("mColumns");     // Catch: Exception -> L60
        r117.setAccessible(true);     // Catch: Exception -> L60
        int[] r118 = (int[]) r116.get(r105);     // Catch: Exception -> L60
        int r119 = r117.getInt(r105);     // Catch: Exception -> L60
        int r120 = 0;
    L56:
        if (r120 >= r119) goto L59;
        int r121 = (r119 * r113) + r120;     // Catch: Exception -> L60
        int r122 = r121 + r119;     // Catch: Exception -> L60
        int r123 = r118[r121];     // Catch: Exception -> L60
        r118[r121] = r118[r122];     // Catch: Exception -> L60
        r118[r122] = r123;     // Catch: Exception -> L60
        r120 = r120 + 1;
        goto L56
    L59:
        r114 = false;
    L62:
        if (r114 == false) goto L50;
        return r105;
    }
}
