package com.larus.dora.obric.device_management.setting.g.ota;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes27.dex */
public final class f0 {
    public static final int a(int r100, Context r101) {
        Resources r102 = r101.getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }
}
