package fm3;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes14.dex */
public final class e {
    public static final int b(Context r100) {
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

    public static float a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    }
}
