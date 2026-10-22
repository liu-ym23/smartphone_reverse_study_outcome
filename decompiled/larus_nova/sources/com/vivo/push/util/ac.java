package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes41.dex */
final class ac implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ContentResolver f462536a;

    public ac() {
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context r100) {
        if (m.b() == false) goto L6;
        this.f462536a = r100.getContentResolver();
        return true;
    L6:
        return false;
    }

    private static String com_vivo_push_util_ac_android_provider_Settings$System_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.System.getString(r110, r111);
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, r114, r112, true);
        return r114;
    }

    @Override // com.vivo.push.util.e
    public final String a(String r100, String r101) {
        return com_vivo_push_util_ac_android_provider_Settings$System_getString(this.f462536a, r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        t.b("SettingsCache", "getString error by ".concat(String.valueOf(r100)));
        return r101;
    }
}
