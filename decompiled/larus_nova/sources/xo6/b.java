package xo6;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static final float a(int r100) {
        Resources r101 = Resources.getSystem();
        return TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }
}
