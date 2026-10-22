package com.larus.navigation.api;

import android.app.Application;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes30.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Boolean f359724a;

    static {
    }

    public static boolean a() {
        Boolean r100 = f359724a;
        if (r100 != null) goto L5;
        Application r101 = AppHost.f326268a.getApplication();
        if (r101 != null) goto L9;
        return false;
    L9:
        boolean r102 = r101.getSharedPreferences("navigation_debug", 0).getBoolean("debug_suppress_notification", false);
        f359724a = Boolean.valueOf(r102);
        return r102;
    L5:
        return r100.booleanValue();
    }
}
