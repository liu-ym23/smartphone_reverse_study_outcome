package com.bytedance.ee.util.ui;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f243162a = null;

    static {
        f243162a = new Handler(Looper.getMainLooper());
    }

    public static boolean b() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(f243162a.getLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(Runnable r100) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return f243162a.hasCallbacks(r100);
    L7:
        return HandlerCompat.hasCallbacks(f243162a, r100);
    }

    public static void c(Runnable r100) {
        f243162a.post(r100);
    }

    public static void e(Runnable r100) {
        f243162a.removeCallbacks(r100);
    }

    public static void f(Runnable r100) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r100.run();
        return;
    L5:
        c(r100);
    }

    public static void d(Runnable r100, long r101) {
        f243162a.postDelayed(r100, r101);
    }
}
