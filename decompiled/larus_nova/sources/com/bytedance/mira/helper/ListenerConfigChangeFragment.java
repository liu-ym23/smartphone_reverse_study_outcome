package com.bytedance.mira.helper;

import android.app.Fragment;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.bytedance.mira.core.MiraResourcesManager;
import com.bytedance.mira.core.SystemResourcesManager;
import com.bytedance.mira.log.MiraLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes21.dex */
public class ListenerConfigChangeFragment extends Fragment {
    public ListenerConfigChangeFragment() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_mira_helper_ListenerConfigChangeFragment_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        DisplayMetrics r101 = SystemResourcesManager.getDisplayMetrics(getActivity());
        DisplayMetrics r102 = INVOKEVIRTUAL_com_bytedance_mira_helper_ListenerConfigChangeFragment_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(MiraResourcesManager.getInstance().getAppResources());
        if (r101 == null) goto L5;
        DisplayMetrics r103 = r101;
    L6:
        MiraResourcesManager.getInstance().updateConfiguration(r100, r103);
        MiraLogger.i(MiraLogger.TAG_ACTIVITY, "Act:" + getActivity());
        MiraLogger.i(MiraLogger.TAG_ACTIVITY, "ListenerConfigChangeFragment--> " + r100);
        MiraLogger.i(MiraLogger.TAG_ACTIVITY, "ListenerConfigChangeFragment--> appMetrics=" + r102 + "; actMetrics=" + r101);
        return;
    L5:
        r103 = r102;
        goto L6
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
    }
}
