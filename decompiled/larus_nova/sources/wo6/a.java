package wo6;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static int b(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Resources r101 = r100.getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r102 != null) goto L9;
        return 0;
    L9:
        return r102.heightPixels;
    }

    public static int c(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        Resources r101 = r100.getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r102 != null) goto L9;
        return 0;
    L9:
        return r102.widthPixels;
    }

    public static float a(Context r100, float r101) {
        if (r100 == null) goto L5;
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    L5:
        return 0.0f;
    }

    public static int d(Context r100, float r101) {
        if (r100 == null) goto L5;
        Resources r102 = r100.getResources();
        return (int) ((r101 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    L5:
        return 0;
    }
}
