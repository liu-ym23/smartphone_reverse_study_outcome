package ha6;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final float a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }
}
