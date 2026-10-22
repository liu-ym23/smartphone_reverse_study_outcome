package com.bytedance.awemeopen.apps.framework.feed.ui.pendant;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final SharedPreferences a = null;

    static {
        a = z54.a.b("aos_pendant_sp");
    }

    public static float a() {
        SharedPreferences r0 = a;
        Resources r2 = Resources.getSystem();
        return r0.getFloat("locationX", TypedValue.applyDimension(1, 18, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
    }

    public static float b() {
        SharedPreferences r0 = a;
        Resources r2 = Resources.getSystem();
        return r0.getFloat("locationY", TypedValue.applyDimension(1, 214, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
    }
}
