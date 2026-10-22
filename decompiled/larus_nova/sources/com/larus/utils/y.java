package com.larus.utils;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference<Handler> f375498a;

    static {
    }

    public static Handler b() {
        SoftReference<Handler> r100 = f375498a;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        Handler r101 = r100.get();
        if (r101 == null) goto L7;
        return r101;
    L7:
        Handler r102 = new Handler(Looper.getMainLooper());
        f375498a = new SoftReference(r102);
        return r102;
    }

    public static void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        b().removeCallbacks(r100);
    }

    public static void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        b().post(r100);
    }

    public static void d(Runnable r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        b().postDelayed(r100, r101);
    }
}
