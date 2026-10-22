package com.bytedance.locallife.biz.common.utils;

import android.util.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f256638a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final qs6.b f256639b = null;

    static {
        f256638a = HostServiceUtilsKt.E().isDebug();
        f256639b = HostServiceUtilsKt.k();
    }

    @JvmStatic
    public static final void e(String r100) {
        f256639b.w("LifePageParamTrace", r100);
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        f256639b.d(r100, r101);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        f256639b.e(r100, r101);
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        f256639b.i(r100, r101);
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r102, "tr");
        f256639b.e(r100, r101, r102);
        if (f256638a == false) goto L19;
        boolean r103 = true;
        if (r101 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        return;
    L13:
        if (r100.length() == 0) goto L16;
        r103 = false;
    L16:
        if (r103 == true) goto L21;
        r102.getMessage();
        Log.getStackTraceString(r102);
        return;
    L21:
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r104 = false;
        goto L11
    }
}
