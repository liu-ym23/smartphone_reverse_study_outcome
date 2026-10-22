package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: classes35.dex */
public class DarkModeContextExtension {
    private static final String TAG = "DarkModeContextExtension";
    private final Context mContext;
    private final int mOriginApplicationUiMode;

    public Context getContext() {
        return this.mContext;
    }

    public DarkModeContextExtension(Context r100) {
        this.mContext = r100;
        Configuration r101 = r100.getResources().getConfiguration();
        this.mOriginApplicationUiMode = r101.uiMode;
        Log.i(TAG, "origin config=" + r101);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_DarkModeContextExtension_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public void injectRedirectConfiguration(Context r100) {
        Configuration r101 = r100.getResources().getConfiguration();
        Log.i(TAG, "merge config=" + r101);
        int r102 = this.mOriginApplicationUiMode;
        if (r102 != r101.uiMode) goto L5;
        Log.i(TAG, "redirect pass");
        return;
    L5:
        r101.uiMode = r102;
        r100.getResources().updateConfiguration(r101, INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_DarkModeContextExtension_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
        Log.i(TAG, "redirect config=" + r100.getResources().getConfiguration());
    }
}
