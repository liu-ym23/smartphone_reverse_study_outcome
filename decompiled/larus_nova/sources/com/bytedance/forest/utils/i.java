package com.bytedance.forest.utils;

import android.util.Log;
import com.bytedance.forest.Forest;
import com.ss.android.agilelogger.ALog;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f244548a = null;

    public i() {
    }

    static {
        f244548a = new i();
    }

    public static /* synthetic */ void f(String r100, String r101, int r102) {
        i r103 = f244548a;
        if ((r102 & 1) == 0) goto L5;
        r100 = null;
    L5:
        r103.c(r100, r101, null);
    }

    public static Map i(String r100, String r101, Map r102) {
        if (r102 != null) goto L5;
        r102 = new HashMap(2);
    L5:
        r102.put("name", r100);
        r102.put("message", r101);
        return r102;
    }

    public final int c(String r100, String r110, Throwable r111) {
        return e(this, "Forest_" + r100, r110, r111, false, 112);
    }

    public static /* synthetic */ void b(String r100, String r101, boolean r110, int r111) {
        String r102 = null;
        if ((r111 & 1) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r111 & 4) == 0) goto L9;
        boolean r104 = false;
    L11:
        if ((r111 & 16) == 0) goto L13;
        r102 = "";
    L13:
        a(r103, r101, r104, null, r102, null);
        return;
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }

    public static /* synthetic */ void h(String r100, String r101, boolean r110, int r111) {
        String r102 = null;
        if ((r111 & 1) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r111 & 4) == 0) goto L9;
        boolean r104 = false;
    L11:
        if ((r111 & 16) == 0) goto L13;
        r102 = "";
    L13:
        g(r103, r101, r104, null, r102, null);
        return;
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }

    public static int a(String r100, String r101, boolean r102, Function3 r103, String r104, Map r105) {
        Map r106 = i(r104, r101, r105);
        String r107 = r106.toString();
        boolean r108 = false;
        if (r102 == false) goto L15;
        if (r103 != null) goto L18;
    L11:
        ALog.d("Forest_" + r100, r107);     // Catch: Throwable -> L13
    L12:
        return 1;
    L21:
        return Log.d("Forest_" + r100, r107);
    L18:
        if (r104.length() <= 0) goto L9;
        r108 = true;
    L9:
        if (r108 == false) goto L11;
        r103.invoke(3, "Forest_" + r100, r106);     // Catch: Throwable -> L13
        goto L12
    L15:
        if (Forest.Companion.getConsoleLogEnable$forest_release() == true) goto L17;
        return 0;
    L17:
        return Log.d("Forest_" + r100, r107);
    }

    public static /* synthetic */ int e(i r100, String r110, String r111, Throwable r112, boolean r113, int r114) {
        String r101 = null;
        if ((r114 & 1) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r114 & 4) == 0) goto L9;
        Throwable r103 = null;
    L11:
        if ((r114 & 8) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r114 & 32) == 0) goto L17;
        r101 = "";
    L17:
        r100.getClass();
        return d(r102, r111, r103, r104, null, r101, null);
    L13:
        r104 = r113;
        goto L15
    L9:
        r103 = r112;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }

    public static int g(String r100, String r101, boolean r102, Function3 r103, String r104, Map r105) {
        Map r106 = i(r104, r101, r105);
        String r107 = r106.toString();
        if (r102 == false) goto L16;
        if (r103 != null) goto L20;
    L12:
        ALog.i("Forest_" + r100, r107);     // Catch: Throwable -> L14
    L19:
        goto L16
    L20:
        if (r104.length() <= 0) goto L8;
        boolean r108 = true;
    L9:
        if (r108 == false) goto L12;
        if (r105 == null) goto L12;
        r103.invoke(4, "Forest_" + r100, r106);     // Catch: Throwable -> L14
        goto L19
    L8:
        r108 = false;
    L16:
        if (Forest.Companion.getConsoleLogEnable$forest_release() == true) goto L18;
        return 0;
    L18:
        return Log.i("Forest_" + r100, r107);
    }

    public static int d(String r100, String r101, Throwable r102, boolean r103, Function3 r104, String r105, Map r106) {
        Map r107 = i(r105, r101, r106);
        String r108 = r107.toString();
        boolean r109 = false;
        if (r103 == false) goto L16;
        if (r104 != null) goto L19;
    L12:
        ALog.e("Forest_" + r100, r108, r102);     // Catch: Throwable -> L14
    L13:
        return 1;
    L22:
        return Log.e("Forest_" + r100, r108, r102);
    L19:
        if (r105.length() <= 0) goto L9;
        r109 = true;
    L9:
        if (r109 == false) goto L12;
        if (r106 == null) goto L12;
        r104.invoke(6, "Forest_" + r100, r107);     // Catch: Throwable -> L14
        goto L13
    L16:
        if (Forest.Companion.getConsoleLogEnable$forest_release() == true) goto L18;
        return 0;
    L18:
        return Log.e("Forest_" + r100, r108, r102);
    }
}
