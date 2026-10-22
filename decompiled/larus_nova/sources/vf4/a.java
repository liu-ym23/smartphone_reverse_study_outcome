package vf4;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final int b(Number r100) {
        float r101 = r100.floatValue();
        Resources r102 = uf4.a.a().getResources();
        return (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static final int a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }
}
