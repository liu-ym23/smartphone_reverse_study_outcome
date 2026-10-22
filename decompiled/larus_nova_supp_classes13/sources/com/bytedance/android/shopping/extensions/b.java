package com.bytedance.android.shopping.extensions;

import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final int a(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$dp2px");
        float r3 = r2.floatValue();
        Resources r0 = Resources.getSystem();
        return MathKt.roundToInt((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static final int b(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$dp");
        float r3 = r2.floatValue();
        Resources r0 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public static final float c(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$sp");
        float r3 = r2.floatValue();
        Resources r0 = uf4.a.a().getResources();
        return TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public static final float d(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toDp");
        float r3 = r2.floatValue();
        Resources r0 = Resources.getSystem();
        return r3 / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
    }

    public static final int e(Number r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toDpInt");
        return MathKt.roundToInt(d(r1));
    }

    public static final Object f(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$px2dp");
        Resources r0 = Resources.getSystem();
        float r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
        if (r1 == 0.0f) goto L12;
        return Float.valueOf((float) Math.ceil(r2.floatValue() / Math.max(1.0f, r1)));
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return Unit.INSTANCE;
    L12:
        return r2;
    }
}
