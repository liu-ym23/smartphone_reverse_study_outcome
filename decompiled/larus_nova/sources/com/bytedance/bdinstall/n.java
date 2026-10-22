package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f199719a = null;

    static {
        f199719a = new ConcurrentHashMap(4);
    }

    public n() {
    }

    public static String b(o0 r100) {
        String r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        String r102 = r100.a();
        Map<String, String> r103 = f199719a;
        String r104 = (String) ((ConcurrentHashMap) r103).get(r102);
        if (r104 == null) goto L8;
    L22:
        return r104;
    L8:
        monitor-enter(n.class);
        if (r104 == null) goto L23;
    L17:
        monitor-exit(n.class);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L23:
        if (c1.g(r100.getContext()) == false) goto L13;
        r101 = c(r100);     // Catch: Throwable -> L19
        ((ConcurrentHashMap) r103).put(r102, r101);     // Catch: Throwable -> L19
        a1.a(r100.getContext()).c(r100.a(), "cdid", r101);     // Catch: Throwable -> L19
    L16:
        r104 = r101;
        goto L17
    L13:
        Context r105 = r100.getContext();     // Catch: Throwable -> L19
        if (r105 == null) goto L16;
        a1.a(r105).b(r100.a(), "cdid", new m());     // Catch: Throwable -> L19
        ConcurrentHashMap r106 = (ConcurrentHashMap) r103;     // Catch: Throwable -> L19
        r101 = (String) r106.get(r100.a());     // Catch: Throwable -> L19
        goto L16
    }

    public static String c(o0 r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        SharedPreferences r101 = i84.a.a(r100.getContext(), r100);
        String r102 = r101.getString("cdid", null);
        if (TextUtils.isEmpty(r102) == true) goto L8;
        return r102;
    L8:
        if (r100.O == false) goto L10;
        String r103 = i84.h.c();
    L11:
        SharedPreferences r104 = r100.getContext().getSharedPreferences(r103, 0);
        String r105 = r104.getString("cdid", null);
        if (TextUtils.isEmpty(r105) == false) goto L14;
        r105 = UUID.randomUUID().toString();
    L14:
        String r106 = r105;
        r104.edit().putString("cdid", r106).apply();
        r101.edit().putString("cdid", r106).putBoolean("cdid_migrate", true).apply();
        return r106;
    L10:
        r103 = i84.h.c() + "_" + r100.f199728a;
        goto L11
    }

    public static String d(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        SharedPreferences r101 = r100.getSharedPreferences(i84.h.c(), 0);
        String r102 = r101.getString("cdid", null);
        if (TextUtils.isEmpty(r102) == false) goto L9;
        String r103 = UUID.randomUUID().toString();
        r101.edit().putString("cdid", r103).apply();
        return r103;
    L9:
        return r102;
    }

    public static void a(Context r100, o0 r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L15;
        ((ConcurrentHashMap) f199719a).remove(r101.a());
        i84.a.a(r100, r101).edit().remove("cdid").apply();
        if (r101.O == false) goto L8;
        String r102 = i84.h.c();
    L9:
        SharedPreferences r103 = r100.getSharedPreferences(r102, 0);
        if (r103.contains("cdid") == false) goto L14;
        r103.edit().remove("cdid").apply();
        return;
    L14:
        return;
    L8:
        r102 = i84.h.c() + "_" + r101.f199728a;
        goto L9
    L15:
        return;
    }
}
