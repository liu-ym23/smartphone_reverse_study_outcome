package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
public class cs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ck f463282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static cl f338a;

    public static void a(Context r100) {
        a("onSendMsg");
        if (m8921b(r100) == true) goto L5;
        return;
    L5:
        cv.a(r100, System.currentTimeMillis(), m8920a(r100));
    }

    public static void b(Context r100) {
        a("onReceiveMsg");
        if (m8921b(r100) == true) goto L5;
        return;
    L5:
        cv.b(r100, System.currentTimeMillis(), m8920a(r100));
    }

    public static void c(Context r100) {
        a("onPing");
        if (m8921b(r100) == true) goto L5;
        return;
    L5:
        cv.c(r100, System.currentTimeMillis(), m8920a(r100));
    }

    public static void d(Context r100) {
        a("onPong");
        if (m8921b(r100) == true) goto L5;
        return;
    L5:
        cv.d(r100, System.currentTimeMillis(), m8920a(r100));
    }

    public static void a(String r100) {
        cj.a("Push-PowerStats", r100);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static boolean m8921b(Context r100) {
        return cj.a(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m8920a(Context r100) {
        return i.m9288b(r100);
    }

    public static void a(Context r100, ez r101) {
        if (m8921b(r100) == true) goto L5;
        return;
    L5:
        if (f463282a != null) goto L8;
        f463282a = new ck(r100);
    L8:
        if (f338a != null) goto L10;
        f338a = new cl(r100);
    L10:
        ck r102 = f463282a;
        r101.a(r102, r102);
        cl r103 = f338a;
        r101.b(r103, r103);
        a("startStats");
    }

    public static void b(Context r100, ez r101) {
        ck r102 = f463282a;
        if (r102 == null) goto L5;
        r101.a(r102);
        f463282a = null;
    L5:
        cl r103 = f338a;
        if (r103 == null) goto L8;
        r101.b(r103);
        f338a = null;
    L8:
        a("stopStats");
    }
}
