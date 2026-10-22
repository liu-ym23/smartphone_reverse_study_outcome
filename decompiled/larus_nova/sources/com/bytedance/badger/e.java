package com.bytedance.badger;

import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f199030a;

    static {
    }

    public static String a(String r100) {
        return "Badger/" + r100;
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        d r102 = f199030a;
        if (r102 == null) goto L5;
        r102.d(a(r100), r101);
        return;
    L5:
        a(r100);
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        d r103 = f199030a;
        if (r103 == null) goto L5;
        r103.e(a(r100), r101, r102);
        return;
    L5:
        a(r100);
    }

    public static void d(String r100, JSONObject r101) {
        d r102 = f199030a;
        if (r102 == null) goto L5;
        r102.a(r100, r101);
        return;
    L5:
        r101.toString(2);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        d r102 = f199030a;
        if (r102 == null) goto L5;
        r102.e(a(r100), r101);
        return;
    L5:
        a(r100);
    }

    @JvmStatic
    public static final void f(String r100, String r101) {
        d r102 = f199030a;
        if (r102 == null) goto L5;
        r102.i(a(r100), r101);
        return;
    L5:
        a(r100);
    }

    @JvmStatic
    public static final void g(String r100, String r101) {
        d r102 = f199030a;
        if (r102 == null) goto L5;
        r102.w(a(r100), r101);
        return;
    L5:
        a(r100);
    }
}
