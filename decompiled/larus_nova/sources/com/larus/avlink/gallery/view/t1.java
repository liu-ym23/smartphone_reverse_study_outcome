package com.larus.avlink.gallery.view;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes25.dex */
public final class t1 {
    public static final float a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
    }
}
