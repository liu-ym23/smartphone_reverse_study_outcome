package com.bytedance.sdk.open.aweme.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes22.dex */
public class UIUtils {
    public UIUtils() {
    }

    public static void detachFromParent(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getParent() == null) goto L13;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L14;
        ((ViewGroup) r101).removeView(r100);     // Catch: Exception -> L9
        return;
    L15:
        return;
    L14:
        return;
    }

    public static float dip2Px(Context r100, float r101) {
        return (r101 * INVOKEVIRTUAL_com_bytedance_sdk_open_aweme_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f;
    }

    public static void removeParentView(View r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        ViewParent r101 = r100.getParent();     // Catch: Exception -> L8
        if ((r101 instanceof ViewGroup) == false) goto L11;
        ((ViewGroup) r101).removeView(r100);     // Catch: Exception -> L8
        return;
    L11:
        return;
    }

    public static final boolean setViewVisibility(View r100, int r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.getVisibility() != r101) goto L6;
        return false;
    L6:
        if (visibilityValid(r101) == false) goto L13;
        r100.setVisibility(r101);
        return true;
    L13:
        return false;
    }

    public static float sp2px(Context r100, float r101) {
        return (r101 * INVOKEVIRTUAL_com_bytedance_sdk_open_aweme_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).scaledDensity) + 0.5f;
    }

    private static boolean visibilityValid(int r100) {
        if (r100 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r100 == 8) goto L9;
        if (r100 == 4) goto L9;
        return false;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_sdk_open_aweme_utils_UIUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }
}
