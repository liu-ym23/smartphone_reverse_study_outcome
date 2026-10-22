package com.bytedance.locallife.common.utils;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference<Handler> f257152a;

    public static Handler b() {
        SoftReference<Handler> r100 = f257152a;
        if (r100 == null) goto L7;
        Handler r101 = r100.get();
        if (r101 == null) goto L7;
        return r101;
    L7:
        Handler r102 = new Handler(Looper.getMainLooper());
        f257152a = new SoftReference(r102);
        return r102;
    }

    public static void a(Runnable r100) {
        b().removeCallbacks(r100);
    }

    public static void d(Runnable r100) {
        b().post(r100);
    }

    public static void c(Runnable r100, long r101) {
        b().postDelayed(r100, r101);
    }
}
