package com.xiaomi.push;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes41.dex */
public class dh {
    private static void a(byte[] r100) {
        if (r100.length < 2) goto L6;
        r100[0] = 99;
        r100[1] = 100;
        return;
    }

    public static byte[] a(String r100, byte[] r101) {
        byte[] r102 = ax.m8829a(r100);
        a(r102);     // Catch: Exception -> L5
        return h.a(r102, r101);
    L5:
        return null;
    }

    public static byte[] b(String r100, byte[] r101) {
        byte[] r102 = ax.m8829a(r100);
        a(r102);     // Catch: Exception -> L5
        return h.b(r102, r101);
    L5:
        return null;
    }

    public static boolean a(Context r100, String r101, long r102) {
        if (com.xiaomi.push.service.ah.a(r100).a(gj.aY.a(), false) == true) goto L5;
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        if (r100.getApplicationInfo().targetSdkVersion < 29) goto L9;
        return false;
    L9:
        if (ab.a(r100, r101, r102) == true) goto L14;
        return true;
    L14:
        return false;
    }
}
