package uzb;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes37.dex */
public final class l {
    public static Resources getResources(Context r100) {
        return r100.getResources();
    }

    public static int a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static int b(Context r100, int r101) {
        return getResources(r100).getColor(r101);
    }

    public static float c(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).scaledDensity;
    }
}
