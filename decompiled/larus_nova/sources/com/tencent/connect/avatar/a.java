package com.tencent.connect.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes40.dex */
public class a {
    public static DisplayMetrics INVOKEVIRTUAL_com_tencent_connect_avatar_a_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static int a(Context r100, float r101) {
        return (int) ((r101 * INVOKEVIRTUAL_com_tencent_connect_avatar_a_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f);
    }
}
