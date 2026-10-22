package vj6;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final int a(Context r100, int r101) {
        Resources r102 = r100.getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density * r101) + 0.5f);
    }
}
