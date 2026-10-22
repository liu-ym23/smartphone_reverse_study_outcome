package com.ss.android.photoeditor.util;

import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes38.dex */
public final class d {
    private static Resources getResources() {
        int r100 = com.larksuite.framework.utils.autoscale.a.f285947a;
        return Resources.getSystem();
    }

    public static float a(float r100) {
        Resources r101 = getResources();
        return (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f;
    }

    public static int b(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }
}
