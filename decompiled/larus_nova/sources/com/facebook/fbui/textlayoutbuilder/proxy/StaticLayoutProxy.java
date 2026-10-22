package com.facebook.fbui.textlayoutbuilder.proxy;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;

/* JADX INFO: loaded from: classes23.dex */
public class StaticLayoutProxy {
    public StaticLayoutProxy() {
    }

    public static TextDirectionHeuristic fromTextDirectionHeuristicCompat(TextDirectionHeuristicCompat r100) {
        if (r100 != TextDirectionHeuristicsCompat.LTR) goto L7;
        return TextDirectionHeuristics.LTR;
    L7:
        if (r100 != TextDirectionHeuristicsCompat.RTL) goto L11;
        return TextDirectionHeuristics.RTL;
    L11:
        if (r100 != TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR) goto L15;
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L15:
        if (r100 != TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL) goto L19;
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L19:
        if (r100 != TextDirectionHeuristicsCompat.ANYRTL_LTR) goto L23;
        return TextDirectionHeuristics.ANYRTL_LTR;
    L23:
        if (r100 != TextDirectionHeuristicsCompat.LOCALE) goto L27;
        return TextDirectionHeuristics.LOCALE;
    L27:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    }

    public static StaticLayout create(CharSequence r110, int r111, int r112, TextPaint r113, int r210, Layout.Alignment r211, float r212, float r213, boolean r214, TextUtils.TruncateAt r215, int r216, int r217, TextDirectionHeuristicCompat r218) {
        return new StaticLayout(r110, r111, r112, r113, r210, r211, fromTextDirectionHeuristicCompat(r218), r212, r213, r214, r215, r216, r217);
    L4:
        e = move-exception;
        if (e.getMessage().contains("utext_close") == true) goto L8;
        throw e;
    L8:
        return new StaticLayout(r110, r111, r112, r113, r210, r211, fromTextDirectionHeuristicCompat(r218), r212, r213, r214, r215, r216, r217);
    }
}
