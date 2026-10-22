package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.defaulttrigger;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.api.settings.h;
import rk7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends xk7.c {

    public static final class a {
    }

    static {
    }

    public b() {
        boolean r100 = rk7.a.f538312a;
        if (rk7.a.f538315d == true) goto L6;
        rk7.a.f538315d = true;
        Application r101 = m.f538347a;
        StringBuilder r102 = new StringBuilder("enableDogSettingsDelayRequest: false has static settings?: ");
        r102.append(!TextUtils.isEmpty(h.a().getStaticSettings()));
        r102.append(", has dynamic settings?: ");
        r102.append(true ^ TextUtils.isEmpty(h.a().getDynamicSettings()));
        r102.append(" has polling settings?: ");
        r102.append(TextUtils.isEmpty(h.a().getPollSettingsDg()));
        com.bytedance.ug.sdk.luckydog.api.log.a.c("AppLaunchOptimizeManager", r102.toString());
    L6:
        c("cold_start");
    }
}
