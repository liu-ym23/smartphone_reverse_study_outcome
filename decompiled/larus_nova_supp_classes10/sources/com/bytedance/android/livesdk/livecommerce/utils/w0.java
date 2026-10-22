package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w0 {
    public static Context getContext() {
        return com.bytedance.android.livesdk.livecommerce.room.f.a();
    }

    public static Resources getResources() {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getResources();
    }

    public static int a(float r2) {
        Resources r0 = Resources.getSystem();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static float b(float r2) {
        Resources r0 = Resources.getSystem();
        return TypedValue.applyDimension(2, r2, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }
}
