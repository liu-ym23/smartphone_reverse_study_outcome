package com.bytedance.mira.core;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class SystemResourcesManager {
    private static Map<String, Resources> sCache;

    public SystemResourcesManager() {
    }

    static {
        sCache = new HashMap();
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_mira_core_SystemResourcesManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static DisplayMetrics getDisplayMetrics(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.toString();
        Resources r102 = sCache.get(r101);
        if (r102 != null) goto L9;
        return null;
    L9:
        return INVOKEVIRTUAL_com_bytedance_mira_core_SystemResourcesManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r102);
    }

    public static boolean remove(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.toString();
        sCache.remove(r101);
        return true;
    }

    public static boolean add(Object r100, Resources r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r102 = r100.toString();
        sCache.put(r102, r101);
        return true;
    }
}
