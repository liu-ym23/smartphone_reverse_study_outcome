package e74;

import android.content.res.Resources;
import com.bytedance.map.api.logger.MapLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f471173a;

    public static int b() {
        if (f471173a != 0) goto L9;
        Resources r100 = Resources.getSystem();     // Catch: Exception -> L6
        f471173a = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).densityDpi;     // Catch: Exception -> L6
    L6:
        e = move-exception;
        MapLogger.e("BaiduOverlayWidthAdapter", "getDensityDpi error", e);
        f471173a = 0;
    L9:
        return f471173a;
    }

    public static int a(int r100) {
        int r101 = b();
        if (r101 != 0) goto L6;
        return r100;
    L6:
        return Math.round((r100 * 310.0f) / r101);
    }
}
