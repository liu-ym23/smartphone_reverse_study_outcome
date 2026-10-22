package com.cmic.ida.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f273076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f273077b;

        public a() {
        }
    }

    public static a a(Context r100) {
        c1 r101 = new c1();
        r101.f273093b = r100;
        e1 r102 = null;
        String r103 = Settings.Global.getString(r100.getContentResolver(), "oaid_limit_state");     // Catch: Throwable -> L14
        String r104 = Settings.Global.getString(r100.getContentResolver(), "oaid");     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r103) == false) goto L6;
    L7:
        r103 = com_cmic_ida_sdk_b_android_provider_Settings$Secure_getString(r100.getContentResolver(), "oaid_limit_state");     // Catch: Throwable -> L14
        r104 = com_cmic_ida_sdk_b_android_provider_Settings$Secure_getString(r100.getContentResolver(), "oaid");     // Catch: Throwable -> L14
    L9:
        if (TextUtils.isEmpty(r103) == false) goto L11;
    L16:
        a r105 = null;
    L17:
        if (r105 == null) goto L20;
        return r105;
    L20:
        if (r101.a(r100) == false) goto L53;
        f1 r106 = new f1();
        Intent r107 = new Intent();     // Catch: Throwable -> L39 Exception -> L41
        r107.setAction("com.hihonor.id.HnOaIdService");     // Catch: Throwable -> L39 Exception -> L41
        r107.setPackage("com.hihonor.id");     // Catch: Throwable -> L39 Exception -> L41
        if (r100.bindService(r107, r106, 1) == false) goto L34;
        r101.f273092a = new a();     // Catch: Throwable -> L39 Exception -> L41
        IBinder r108 = r106.a();     // Catch: Throwable -> L39 Exception -> L41
        int r109 = e1.a.f273107a;     // Catch: Throwable -> L39 Exception -> L41
        if (r108 == null) goto L33;
        IInterface r110 = r108.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");     // Catch: Throwable -> L39 Exception -> L41
        if (r110 != null) goto L30;
    L32:
        r102 = new e1.a.C3817a(r108);     // Catch: Throwable -> L39 Exception -> L41
        goto L33
    L30:
        if ((r110 instanceof e1) == false) goto L32;
        r102 = (e1) r110;     // Catch: Throwable -> L39 Exception -> L41
    L33:
        r102.b(r101.f273094c);     // Catch: Throwable -> L39 Exception -> L41
        r102.a(r101.f273095d);     // Catch: Throwable -> L39 Exception -> L41
    L34:
        r101.f273096e.await(3000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L39 Exception -> L41
        r101.f273093b.unbindService(r106);     // Catch: Exception -> L37
    L59:
    L44:
        r101.a();
        return r101.f273092a;
    L39:
        th = move-exception;
        r101.f273093b.unbindService(r106);     // Catch: Exception -> L48
    L50:
        r101.a();
        throw th;
    L48:
        e = move-exception;
        e.getMessage();
    L41:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L39
        r101.f273093b.unbindService(r106);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        e.getMessage();
        goto L44
    L53:
        throw new IOException("Service not found or advertisingId not available");
    L11:
        if (TextUtils.isEmpty(r104) == true) goto L16;
        boolean r111 = Boolean.parseBoolean(r103);     // Catch: Throwable -> L14
        r105 = new a();     // Catch: Throwable -> L14
        r105.f273077b = r111;     // Catch: Throwable -> L14
        r105.f273076a = r104;     // Catch: Throwable -> L14
        goto L17
    L6:
        if (TextUtils.isEmpty(r104) == false) goto L9;
    L14:
        th = move-exception;
        th.toString();
        goto L16
    }

    private static String com_cmic_ida_sdk_b_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }
}
