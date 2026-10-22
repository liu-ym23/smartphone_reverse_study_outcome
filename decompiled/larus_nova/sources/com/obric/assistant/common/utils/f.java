package com.obric.assistant.common.utils;

import android.content.res.Resources;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes32.dex */
public final class f {
    public static final int a(int r100) {
        Resources r101 = AppHost.f326268a.getApplication().getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }
}
