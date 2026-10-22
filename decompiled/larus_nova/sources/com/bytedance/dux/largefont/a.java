package com.bytedance.dux.largefont;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final int b(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue() * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f);
        Resources r102 = Resources.getSystem();
        return MathKt.roundToInt(TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
    }

    public static final float d(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = Resources.getSystem().getConfiguration().fontScale;
        if (r101 <= 1.15f) goto L6;
        return (r100.floatValue() / r101) * 1.15f;
    L6:
        return r100.floatValue();
    }

    public static final void c(TextView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r102 = RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f) * r101;
        Resources r103 = Resources.getSystem();
        r100.setTextSize(0, TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        if ((r100 instanceof AppCompatTextView) == false) goto L6;
        float r104 = ((float) (((double) r101) * 1.4d)) * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f);
        Resources r105 = Resources.getSystem();
        ((AppCompatTextView) r100).setLineHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()))));
        return;
    }

    public static final void a(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L7;
        float r104 = r101 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f);
        Resources r105 = Resources.getSystem();
        r103.width = MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
        float r106 = r102 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f);
        Resources r107 = Resources.getSystem();
        r103.height = MathKt.roundToInt(TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())));
        r100.setLayoutParams(r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
