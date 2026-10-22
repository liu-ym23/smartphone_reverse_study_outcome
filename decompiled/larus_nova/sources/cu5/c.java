package cu5;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f465432a;

    public static int f() {
        Resources r100 = getResources();
        return (int) ((14 * WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).scaledDensity) + 0.5f);
    }

    private static Resources getResources() {
        int r100 = com.larksuite.framework.utils.autoscale.a.f285947a;
        return Resources.getSystem();
    }

    public static int c() {
        Resources r100 = getResources();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).heightPixels;
    }

    public static int d() {
        Resources r100 = getResources();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).widthPixels;
    }

    public static int a(float r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static int b(int r100) {
        return a(Float.valueOf(r100).floatValue());
    }

    public static boolean e(Context r100) {
        if (r100.getResources().getConfiguration().orientation != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
