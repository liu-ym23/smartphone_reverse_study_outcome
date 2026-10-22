package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static z0 f277283a;

    private static synchronized z0 a() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f277283a != null) goto L7;
        f277283a = q.c().b();     // Catch: Throwable -> L10
    L7:
        z0 r100 = f277283a;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r100;
    }

    public static void a(int r100, String r101, LinkedHashMap<String, String> r102) {
        if (a() != null) goto L5;
        return;
    L5:
        if (q1.b().a() == true) goto L7;
        return;
    L7:
        if (r100 == 1) goto L11;
        if (r100 == 0) goto L11;
        v.d("hmsSdk", "Data type no longer collects range.type: " + r100);
        return;
    L11:
        f277283a.a(r100, r101, r102);
    }

    public static void a(Context r100, String r101, String r102) {
        if (a() == null) goto L6;
        f277283a.a(r100, r101, r102);
        return;
    }

    public static void b(int r100, String r101, LinkedHashMap<String, String> r102) {
        if (a() != null) goto L5;
        return;
    L5:
        if (q1.b().a() == true) goto L7;
        return;
    L7:
        if (r100 == 1) goto L11;
        if (r100 == 0) goto L11;
        v.d("hmsSdk", "Data type no longer collects range.type: " + r100);
        return;
    L11:
        f277283a.b(r100, r101, r102);
    }

    public static boolean b() {
        return q.c().a();
    }

    public static void c() {
        if (a() != null) goto L5;
        return;
    L5:
        if (q1.b().a() == false) goto L9;
        f277283a.a(-1);
        return;
    }
}
