package fm3;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final int b(Context r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        Resources r3 = r2.getResources();
        DisplayMetrics r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics());
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.heightPixels;
    }

    public static float a(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return (r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f;
    }
}
