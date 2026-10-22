package j08;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes24.dex */
public final class b {
    public static float a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static int b(int r100, float r101) {
        return Color.argb((int) (r101 * 255.0f), Color.red(r100), Color.green(r100), Color.blue(r100));
    }

    public static int d(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static int e(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) TypedValue.applyDimension(2, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static int c(Context r100, int r101, float r102) {
        return b(r100.getResources().getColor(r101), r102);
    }
}
