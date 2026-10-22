package com.bytedance.awemeopen.apps.framework.feed.ui.pendant;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SharedPreferences f196594a = null;

    static {
        f196594a = z54.a.b("aos_pendant_sp");
    }

    public static float a() {
        SharedPreferences r100 = f196594a;
        Resources r101 = Resources.getSystem();
        return r100.getFloat("locationX", TypedValue.applyDimension(1, 18, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
    }

    public static float b() {
        SharedPreferences r100 = f196594a;
        Resources r101 = Resources.getSystem();
        return r100.getFloat("locationY", TypedValue.applyDimension(1, 214, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
    }
}
