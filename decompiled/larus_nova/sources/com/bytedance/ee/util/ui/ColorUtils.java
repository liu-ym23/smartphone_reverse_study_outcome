package com.bytedance.ee.util.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class ColorUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f243151a = 0;

    static {
    }

    @JvmStatic
    public static final boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        double r101 = androidx.core.graphics.ColorUtils.calculateContrast(-1, r100.getResources().getColor(R.color.bg_body));
        if (h18.f.a(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r101 <= 3.0d) goto L7;
        return true;
    }

    @JvmStatic
    public static final ColorStateList d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{androidx.core.graphics.ColorUtils.compositeColors(ContextCompat.getColor(r100, R.color.fill_active), ContextCompat.getColor(r100, R.color.bg_float)), androidx.core.graphics.ColorUtils.compositeColors(ContextCompat.getColor(r100, R.color.fill_pressed), ContextCompat.getColor(r100, R.color.bg_float)), ContextCompat.getColor(r100, R.color.bg_float)});
    }

    @JvmStatic
    public static final boolean e(int r100) {
        int r101 = Color.red(r100);
        int r102 = Color.green(r100);
        int r103 = Color.blue(r100);
        int r104 = RangesKt.coerceAtMost(r101, RangesKt.coerceAtMost(r102, r103));
        if ((RangesKt.coerceAtLeast(r101, RangesKt.coerceAtLeast(r102, r103)) - r104) < 15) goto L5;
    L7:
        return false;
    L5:
        if ((((r101 + r102) + r103) / 3) >= 115) goto L7;
        return true;
    }

    public static boolean f(int r100) {
        int r101 = Color.red(r100);
        int r102 = Color.green(r100);
        int r103 = Color.blue(r100);
        if (3 >= ((a(255, 255, 255) + 0.05d) / (a(r101, r102, r103) + 0.05d))) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean g(int r100) {
        int r101 = Color.red(r100);
        int r102 = Color.green(r100);
        int r103 = Color.blue(r100);
        int r104 = RangesKt.coerceAtMost(r101, RangesKt.coerceAtMost(r102, r103));
        if ((RangesKt.coerceAtLeast(r101, RangesKt.coerceAtLeast(r102, r103)) - r104) < 15) goto L5;
    L7:
        return false;
    L5:
        if ((((r101 + r102) + r103) / 3) <= 188) goto L7;
        return true;
    }

    @JvmStatic
    public static final int h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rgbaColor");
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L13:
        tt5.a.c("parseArgbColor error, error color : " + r100);
        return -16777216;
    L5:
        if (r100.charAt(0) != '#') goto L13;
        if (r100.length() != 9) goto L10;
        int r101 = Color.parseColor("#" + r100.substring(7) + r100.substring(1, 7));     // Catch: Exception -> L15
    L12:
        return r101;
    L10:
        r101 = Color.parseColor(r100);     // Catch: Exception -> L15
        goto L12
    L17:
        return 0;
    }

    @JvmStatic
    public static final int c(int r100, int r101) {
        return Color.argb(r100, Color.red(r101), Color.green(r101), Color.blue(r101));
    }

    public static double a(int r100, int r101, int r102) {
        return SequencesKt.sumOfDouble(SequencesKt.zip(SequencesKt.map(SequencesKt.map(SequencesKt.sequenceOf(new Integer[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102)}), ColorUtils$calcLuminance$1.INSTANCE), ColorUtils$calcLuminance$2.INSTANCE), SequencesKt.sequenceOf(new Double[]{Double.valueOf(0.2126d), Double.valueOf(0.7152d), Double.valueOf(0.0722d)}), ColorUtils$calcLuminance$3.INSTANCE));
    }
}
