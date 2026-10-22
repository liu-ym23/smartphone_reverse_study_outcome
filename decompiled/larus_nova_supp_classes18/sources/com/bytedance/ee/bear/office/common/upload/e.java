package com.bytedance.ee.bear.office.common.upload;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final int a(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Resources r3 = r1.getResources();
        return (int) (r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density);
    }
}
