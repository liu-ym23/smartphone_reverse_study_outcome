package com.bytedance.map.api.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes21.dex */
public class DensityUtil {
    public DensityUtil() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_map_api_utils_DensityUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static int dp2px(Context r100, float r101) {
        return (int) ((r101 * INVOKEVIRTUAL_com_bytedance_map_api_utils_DensityUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }

    public static int px2dp(Context r100, float r101) {
        return (int) ((r101 / INVOKEVIRTUAL_com_bytedance_map_api_utils_DensityUtil_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }
}
