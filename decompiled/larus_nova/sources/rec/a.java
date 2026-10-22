package rec;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static final int a(Context r100, int r101) {
        Resources r102 = r100.getResources();
        return MathKt.roundToInt(TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
    }
}
