package com.larus.business.markdown.impl.common.utils;

import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static final int a(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static final float b(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float r101 = r100.floatValue();
        Resources r102 = Resources.getSystem();
        return r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
    }
}
