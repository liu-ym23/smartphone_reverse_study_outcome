package com.ss.ttvideoengine.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes35.dex */
public class ScreenUtils {
    public static final int MAX_SYSTEM_BRIGHTNESS = 255;
    public static final int MIN_SYSTEM_BRIGHTNESS = 0;

    public ScreenUtils() {
    }

    public static int getScreenHeight() {
        return INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).heightPixels;
    }

    public static int getScreenPixelDensity() {
        return INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).densityDpi;
    }

    public static int getScreenWidth() {
        return INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).widthPixels;
    }

    public static float getScreenXdpi() {
        return INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).xdpi;
    }

    public static float getScreenYdpi() {
        return INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).ydpi;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_ttvideoengine_utils_ScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static float getNormalizedBrightness(Context r100) {
        return (getSystemBrightness(r100) * 1.0f) / 255.0f;
    }

    public static Point getRealScreenSize(Context r100) {
        Point r101 = new Point();
        ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRealSize(r101);
        return r101;
    }

    public static int getSystemBrightness(Context r100) {
        return Settings.System.getInt(r100.getContentResolver(), "screen_brightness");
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }
}
