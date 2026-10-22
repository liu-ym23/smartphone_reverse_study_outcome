package com.ss.android.ugc.aweme.search.utils.extensions;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"trade-search-impl_release"}, k = 2, mv = {1, 4, 3})
public final class DimenExtensionsKt {
    public static final int a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return MathKt.roundToInt((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static final int b(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static final int c(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return MathKt.roundToInt(r101 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density);
    }

    public static final Object d(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Resources r101 = Resources.getSystem();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        if (r102 != 0.0f) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L14;
        return Float.valueOf((float) Math.ceil(r100.floatValue() / Math.max(1.0f, r102)));
    L11:
        return Unit.INSTANCE;
    L14:
        return r100;
    L5:
        r103 = false;
        goto L6
    }
}
