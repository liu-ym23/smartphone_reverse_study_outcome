package kp6;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes21.dex */
public final class g {
    public static float a(Context r100, float r101) {
        if (r100 == null) goto L5;
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    L5:
        return 0.0f;
    }

    public static int b(Context r100, double r101) {
        if (r100 == null) goto L5;
        Resources r102 = r100.getResources();
        return (int) ((r101 / ((double) WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density)) + 0.5d);
    L5:
        return 0;
    }

    public static int c(Context r100, float r101) {
        if (r100 == null) goto L5;
        Resources r102 = r100.getResources();
        return (int) ((r101 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    L5:
        return 0;
    }

    public static float d(Context r100, float r101) {
        if (r100 == null) goto L5;
        Resources r102 = r100.getResources();
        return TypedValue.applyDimension(2, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    L5:
        return 0.0f;
    }
}
