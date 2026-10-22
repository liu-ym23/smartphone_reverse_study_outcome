package vuc;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes42.dex */
public final class b {
    public static int a(Context r100, double r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * ((double) WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density)) + 0.5d);
    }
}
