package np5;

import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes18.dex */
public final class b {
    public static int a(float r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }
}
