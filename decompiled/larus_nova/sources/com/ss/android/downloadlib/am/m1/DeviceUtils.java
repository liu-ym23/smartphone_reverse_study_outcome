package com.ss.android.downloadlib.am.m1;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import f06.b;
import f06.c;
import f06.d;

/* JADX INFO: loaded from: classes34.dex */
public class DeviceUtils {
    public DeviceUtils() {
    }

    public static String getDeviceId() {
        return getDeviceId(GlobalInfo.getContext());
    }

    public static String getDeviceId(Context r100) {
        return com_ss_android_downloadlib_am_m1_DeviceUtils_android_provider_Settings$Secure_getString(r100.getContentResolver(), "android_id");
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getImeiMd5(Context r100) {
        return toHexReadable(DigestUtils.get(getDeviceId(), "MD5"));
    L4:
        return null;
    }

    public static String toHexReadable(byte[] r100) {
        return BinStr.byte2str(r100);
    }

    private static String com_ss_android_downloadlib_am_m1_DeviceUtils_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r110, r111};
        b r112 = new b();
        d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }
}
