package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes22.dex */
public class NativeBitmap {
    private static final String TAG = "NativeBitmap";
    private static boolean mEnabled;
    private static boolean mStarted;

    private NativeBitmap() {
    }

    private static native boolean start(int r100);

    public static /* synthetic */ double access$100() {
        return getJavaHeapUtilizaiton();
    }

    private static double getJavaHeapUtilizaiton() {
        return (Runtime.getRuntime().totalMemory() * 1.0d) / Runtime.getRuntime().maxMemory();
    }

    public static /* synthetic */ boolean access$000() {
        return mEnabled;
    }

    public static /* synthetic */ boolean access$200(Context r100) {
        return realStart(r100);
    }

    public static synchronized boolean enable(Context r100) {
        monitor-enter(NativeBitmap.class);
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        if (r101 >= 22) goto L7;
    L12:
        monitor-exit(NativeBitmap.class);
        return false;
    L7:
        if (r101 > 25) goto L12;
        boolean r102 = realStart(r100);     // Catch: Throwable -> L15
        monitor-exit(NativeBitmap.class);
        return r102;
    L15:
        th = move-exception;
        throw th;
    }

    private static synchronized boolean realStart(Context r100) {
        monitor-enter(NativeBitmap.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (mEnabled == false) goto L10;
        monitor-exit(NativeBitmap.class);
        return true;
    L10:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L21;
    L14:
        monitor-exit(NativeBitmap.class);
        return false;
    L21:
        boolean r101 = start(Build.VERSION.SDK_INT);     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        mEnabled = r101;     // Catch: UnsatisfiedLinkError -> L20 Throwable -> L17
        monitor-exit(NativeBitmap.class);
        return r101;
        goto L14
    }

    public static synchronized boolean enable(final Context r110, final long r111, final double r112, long r113) {
        monitor-enter(NativeBitmap.class);
        int r100 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L26
        if (r100 >= 22) goto L7;
    L24:
        monitor-exit(NativeBitmap.class);
        return false;
    L7:
        if (r100 > 25) goto L24;
        if (Runtime.getRuntime().maxMemory() <= r113) goto L15;
        monitor-exit(NativeBitmap.class);
        return false;
    L15:
        if (mStarted == false) goto L17;
    L22:
        monitor-exit(NativeBitmap.class);
        return true;
    L17:
        if (mEnabled == true) goto L22;
        mStarted = true;     // Catch: Throwable -> L26
        ThreadMethodProxy.start(new PthreadThreadV2(null, new AnonymousClass1(r111, r112, r110), TAG, PlaybackStateCompat.ACTION_SET_REPEAT_MODE));     // Catch: Throwable -> L26
        monitor-exit(NativeBitmap.class);
        return true;
    L26:
        th = move-exception;
        throw th;
    }
}
