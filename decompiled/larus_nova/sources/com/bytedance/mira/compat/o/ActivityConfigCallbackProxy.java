package com.bytedance.mira.compat.o;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewRootImpl;
import com.bytedance.mira.core.MiraResourcesManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes21.dex */
public class ActivityConfigCallbackProxy implements ViewRootImpl.ActivityConfigCallback {
    private ViewRootImpl.ActivityConfigCallback mOriginCallback;

    public ActivityConfigCallbackProxy(ViewRootImpl.ActivityConfigCallback r100) {
        this.mOriginCallback = r100;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_mira_compat_o_ActivityConfigCallbackProxy_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public void onConfigurationChanged(Configuration r100, int r101) {
        MiraResourcesManager.getInstance().updateConfiguration(r100, INVOKEVIRTUAL_com_bytedance_mira_compat_o_ActivityConfigCallbackProxy_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(MiraResourcesManager.getInstance().getAppResources()));
        ViewRootImpl.ActivityConfigCallback r102 = this.mOriginCallback;
        if (r102 == null) goto L6;
        r102.onConfigurationChanged(r100, r101);
        return;
    }
}
