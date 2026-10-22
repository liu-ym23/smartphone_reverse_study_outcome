package em4;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class g {
    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static final float b(float r100) {
        return r100 * a(Resources.getSystem()).density;
    }

    public static final int c(int r100) {
        return (int) ((r100 * a(Resources.getSystem()).density) + 0.5f);
    }

    public static final int d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DisplayMetrics r101 = a(r100.getResources());
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.heightPixels;
    }

    public static final int e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DisplayMetrics r101 = a(r100.getResources());
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.widthPixels;
    }

    public static final int f(int r100) {
        return MathKt.roundToInt(TypedValue.applyDimension(2, r100, a(Resources.getSystem())));
    }
}
