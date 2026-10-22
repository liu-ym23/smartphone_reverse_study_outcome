package com.ss.android.dypay.base;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f408436a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f408437b = "";

    static {
    }

    public static String a() {
        boolean r100 = true;
        if (f408436a.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        SharedPreferences.Editor r102 = null;
        if (r101 == false) goto L21;
        WeakReference<Context> r103 = e.f408447a;
        if (r103 == null) goto L11;
        Context r104 = r103.get();
    L12:
        if (r104 == null) goto L14;
        SharedPreferences r105 = r104.getSharedPreferences("dy_pay_device_info", 0);
    L15:
        String r106 = "";
        if (r105 == null) goto L20;
        String r107 = r105.getString("device_id", "");
        if (r107 == null) goto L20;
        r106 = r107;
    L20:
        f408436a = r106;
    L23:
        if (f408436a.length() == 0) goto L26;
        r100 = false;
    L26:
        if (r100 == false) goto L35;
        StringBuilder r108 = new StringBuilder();
        r108.append(System.currentTimeMillis());
        r108.append(new SecureRandom().nextInt(10000));
        f408436a = r108.toString();
        if (r105 == null) goto L30;
        r102 = r105.edit();
    L30:
        if (r102 == null) goto L32;
        r102.putString("device_id", f408436a);
    L32:
        if (r102 == null) goto L35;
        r102.apply();
    L35:
        return f408436a;
    L14:
        r105 = null;
        goto L15
    L11:
        r104 = null;
        goto L12
    L21:
        r105 = null;
        goto L23
    L5:
        r101 = false;
        goto L6
    }
}
