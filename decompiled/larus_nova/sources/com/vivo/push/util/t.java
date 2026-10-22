package com.vivo.push.util;

import android.content.Context;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;

/* JADX INFO: loaded from: classes41.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f462606a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f462607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f462608c;

    static {
        f462606a = new r();
        f462607b = ah.b("persist.sys.log.ctrl", BdpAppEventConstant.NO).equals(BdpAppEventConstant.YES);
    }

    public static boolean b() {
        if (f462607b == true) goto L5;
        return false;
    L5:
        if (f462608c == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean a() {
        return f462607b;
    }

    public static void a(String r100) {
        if (f462607b == false) goto L6;
        f462606a.c("VIVO.PUSH.MSG_NODE", r100);
        return;
    }

    public static void b(String r100) {
        if (f462607b == false) goto L6;
        f462606a.c("VIVO.PUSH.PROFILE.SYNC", r100);
        return;
    }

    public static void a(int r100, String r101) {
        a("RunTimeException", "code: " + r100 + ", exceptionMsg: " + r101);
    }

    public static int b(String r100, String r101) {
        return f462606a.b(r100, r101);
    }

    public static int c(String r100, String r101) {
        return f462606a.c(r100, r101);
    }

    public static int d(String r100, String r101) {
        return f462606a.d(r100, r101);
    }

    public static int e(String r100, String r101) {
        return f462606a.e(r100, r101);
    }

    public static int a(String r100, String r101) {
        return f462606a.a(r100, r101);
    }

    public static void b(Context r100, String r101) {
        f462606a.b(r100, r101);
    }

    public static void c(Context r100, String r101) {
        f462606a.c(r100, r101);
    }

    public static int a(String r100, Throwable r101) {
        return f462606a.a(r100, r101);
    }

    public static void a(Context r100, String r101) {
        f462606a.a(r100, r101);
    }

    public static int a(String r100, String r101, Throwable r102) {
        return f462606a.a(r100, r101, r102);
    }

    public static int b(String r100, String r101, Throwable r102) {
        return f462606a.b(r100, r101, r102);
    }
}
