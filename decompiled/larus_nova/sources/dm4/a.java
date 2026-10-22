package dm4;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final int b(int r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static final float a(Context r100, float r101) {
        if (r100 == null) goto L4;
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    L4:
        return 0.0f;
    }
}
