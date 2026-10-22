package com.unionpay.utils;

import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.unionpay.UPPayWapActivity;

/* JADX INFO: loaded from: classes41.dex */
public final class f {
    public static int a(UPPayWapActivity r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }
}
