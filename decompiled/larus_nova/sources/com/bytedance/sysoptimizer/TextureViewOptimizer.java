package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes22.dex */
public class TextureViewOptimizer {
    private static String TAG = "TextureViewOptimizer";
    private static Handler mMainLooperHandler;
    private static boolean mOptimized;

    private TextureViewOptimizer() {
    }

    private static native boolean optimize(int r100, boolean r101);

    private static native void pushLayerNative(long r100, long r101);

    static {
        mMainLooperHandler = new Handler(Looper.getMainLooper());
    }

    private static boolean loadOptimizerOnNeed(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 26) goto L5;
        return false;
    L5:
        if (r101 <= 33) goto L8;
        return false;
    L8:
        return SysOptimizer.loadOptimizerLibrary(r100);
    }

    public static boolean optimize(Context r100) {
        return optimize(r100, true);
    }

    public static /* synthetic */ void access$000(long r100, long r101) {
        pushLayerNative(r100, r101);
    }

    public static synchronized boolean optimize(Context r100, boolean r101) {
        monitor-enter(TextureViewOptimizer.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L9;
        monitor-exit(TextureViewOptimizer.class);
        return true;
    L9:
        if (loadOptimizerOnNeed(r100) == true) goto L21;
    L14:
        monitor-exit(TextureViewOptimizer.class);
        return false;
    L21:
        boolean r102 = optimize(Build.VERSION.SDK_INT, r101);     // Catch: Throwable -> L20
        mOptimized = r102;     // Catch: Throwable -> L20
        monitor-exit(TextureViewOptimizer.class);
        return r102;
    }

    private static boolean postOnUiThread(final long r100, final long r110) {
        final Object r101 = new Object();
        monitor-enter(r101);
        mMainLooperHandler.post(new AnonymousClass1(r100, r110, r101));     // Catch: Throwable -> L12
        r101.wait();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return true;
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
