package pla;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes33.dex */
public final class d {
    public static final float h(float r100, float r101) {
        if (r100 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        return r100 * r101;
    L5:
        r102 = false;
        goto L6
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Deprecated(message = "use dp2px(dpValue: Int, context: Context) instead")
    public static final int g(int r100) {
        return (int) ((r100 * a(Resources.getSystem()).density) + 0.5f);
    }

    public static final int i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DisplayMetrics r101 = a(r100.getResources());
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.heightPixels;
    }

    public static final int j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DisplayMetrics r101 = a(r100.getResources());
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.widthPixels;
    }

    public static final int b(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0;
    L9:
        return MathKt.roundToInt(r101 * a(r100.getResources()).density);
    L5:
        r102 = false;
        goto L6
    }

    public static final int c(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != 0) goto L6;
        return 0;
    L6:
        return b(r100, r101);
    }

    public static final float d(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r101, a(r100.getResources()));
    L5:
        r102 = false;
        goto L6
    }

    public static final float e(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != 0) goto L6;
        return 0.0f;
    L6:
        return d(r100, r101);
    }

    public static final float f(float r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return r100 * a(r101.getResources()).density;
    }

    public static final int k(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return MathKt.roundToInt(r101 / a(r100.getResources()).density);
    }

    public static final int l(View r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0;
    L9:
        return m(r100, (float) r101);
    L5:
        r102 = false;
        goto L6
    }

    public static final int m(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0;
    L9:
        return MathKt.roundToInt(r101 * a(r100.getResources()).density);
    L5:
        r102 = false;
        goto L6
    }

    public static final int n(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != 0) goto L6;
        return 0;
    L6:
        return m(r100, r101);
    }

    public static final float o(View r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        return p(r100, (float) r101);
    L5:
        r102 = false;
        goto L6
    }

    public static final float p(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r101, a(r100.getResources()));
    L5:
        r102 = false;
        goto L6
    }

    public static final float q(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != 0) goto L6;
        return 0.0f;
    L6:
        return p(r100, r101);
    }

    public static final float r(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(2, r101, a(r100.getResources()));
    L5:
        r102 = false;
        goto L6
    }
}
