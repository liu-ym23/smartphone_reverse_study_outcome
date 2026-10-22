package com.ss.android.cert.manager.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;

/* JADX INFO: loaded from: classes34.dex */
public class LocaleHelper {
    public LocaleHelper() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_cert_manager_utils_LocaleHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static Context setLocale(Context r100, String r101) {
        Locale r102 = new Locale(r101);
        Configuration r103 = new Configuration(r100.getResources().getConfiguration());
        r103.setLocale(r102);
        Context r104 = r100.createConfigurationContext(r103);
        NewMiraResourcesManager.getInstance().install(r104);
        return r104;
    }

    public static String getMultiLanguageString(Context r100, String r101, int r102) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (TextUtils.equals("zh", r101) == true) goto L12;
        Configuration r103 = new Configuration(r100.getApplicationContext().getResources().getConfiguration());
        r103.setLocale(new Locale(r101));
        Context r104 = r100.getApplicationContext().createConfigurationContext(r103);
        NewMiraResourcesManager.getInstance().install(r104);
        return r104.getResources().getString(r102);
    L12:
        return r100.getApplicationContext().getString(r102);
    }
}
