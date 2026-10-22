package ex2;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    public static final int a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return MathKt.roundToInt(TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
    }
}
