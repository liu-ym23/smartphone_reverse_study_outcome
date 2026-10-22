package com.bytedance.crash.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f203406a;

    public static String a() {
        if (TextUtils.isEmpty(f203406a) == false) goto L5;
        String r100 = d();
        f203406a = r100;
        if (r100 != null) goto L10;
        return "";
    L10:
        return r100;
    L5:
        return f203406a;
    }

    public static String b() {
        String r100 = f203406a;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    public static String c() {
        if (TextUtils.isEmpty(f203406a) == false) goto L6;
        f203406a = d();
    L6:
        return f203406a;
    }

    public static String d() {
        StringBuilder r100 = new StringBuilder();
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper("/proc/self/cmdline");     // Catch: Throwable -> L21 Exception -> L27
        goto L24
    L30:
        byte[] r103 = new byte[64];     // Catch: Throwable -> L18 Exception -> L20
    L6:
        int r104 = 0;
        int r105 = r102.read(r103, 0, 64);     // Catch: Throwable -> L18 Exception -> L20
    L7:
        if (r104 >= r105) goto L16;
        char r106 = (char) r103[r104];     // Catch: Throwable -> L18 Exception -> L20
        if (r106 == 0) goto L15;
        if (r106 == '\n') goto L15;
        r100.append(r106);     // Catch: Throwable -> L18 Exception -> L20
        r104 = r104 + 1;
        goto L7
    L15:
        r105 = -1;
    L16:
        if (r105 > 0) goto L6;
        g.a(r102);
    L26:
        return r100.toString();
    L20:
        r101 = r102;
    L18:
        th = th;
        r101 = r102;
    L22:
        g.a(r101);
        throw th;
    L21:
        th = th;
    L24:
        g.a(r101);
        goto L26
    }

    public static boolean e(Context r100, String r101) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.contains(":") == false) goto L8;
        return false;
    L8:
        if (r100 != null) goto L10;
        r100 = com.bytedance.crash.i.getContext();
    L10:
        if (r100 != null) goto L13;
        return false;
    L13:
        if (r101.equals(r100.getPackageName()) == false) goto L17;
        return true;
    L17:
        return r101.equals(r100.getApplicationInfo().processName);
    }
}
