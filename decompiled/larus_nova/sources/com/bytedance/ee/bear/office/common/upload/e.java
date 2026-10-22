package com.bytedance.ee.bear.office.common.upload;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {
    public static final int a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Resources r102 = r100.getResources();
        return (int) (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density);
    }
}
