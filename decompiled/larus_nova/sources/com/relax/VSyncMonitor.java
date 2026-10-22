package com.relax;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.WindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.relax.embedding.LLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes34.dex */
public class VSyncMonitor {
    public static final long DEFAULT_FRAME_TIME_NS = 16666666;
    private static DisplayManager.DisplayListener mDisplayListener = null;
    private static DisplayManager mDisplayManager = null;
    private static long mFrameRefreshTimeNS = -1;
    private static boolean mUseDisplayManager;
    private static WeakReference<WindowManager> mWindowManager;
    private static Choreographer sUIThreadChoreographer;

    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            VSyncMonitor.access$202(Choreographer.getInstance());     // Catch: Throwable -> L4 RuntimeException -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            LLog.e("initUIThreadChoreographer failed: " + e.getMessage());     // Catch: Throwable -> L4
            goto L13
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f404616a;

        @Override // java.lang.Runnable
        public final void run() {
            VSyncMonitor.initUIThreadChoreographer();     // Catch: Throwable -> L4
            VSyncMonitor.requestOnUIThread(this.f404616a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(long r100) {
            this.f404616a = r100;
        }
    }

    public static class c implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f404617a;

        public c(long r100) {
            this.f404617a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            VSyncMonitor.access$300(this.f404617a, r100);
        }
    }

    public static class d implements DisplayManager.DisplayListener {
        public d() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int r100) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int r100) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int r100) {
            if (r100 == 0) goto L4;
            return;
        L4:
            if (VSyncMonitor.access$000() == null) goto L8;
            VSyncMonitor.access$100();
            return;
        }
    }

    public VSyncMonitor() {
    }

    private static native void nativeOnVSync(long r100, long r101, long r102);

    private static long getRefreshRate() {
        if (mUseDisplayManager == true) goto L15;
        mFrameRefreshTimeNS = DEFAULT_FRAME_TIME_NS;     // Catch: RuntimeException -> L12
        WeakReference<WindowManager> r100 = mWindowManager;     // Catch: RuntimeException -> L12
        if (r100 != null) goto L8;
        return DEFAULT_FRAME_TIME_NS;
    L8:
        WindowManager r101 = r100.get();     // Catch: RuntimeException -> L12
        if (r101 == null) goto L15;
        mFrameRefreshTimeNS = (long) (1.0E9d / ((double) r101.getDefaultDisplay().getRefreshRate()));     // Catch: RuntimeException -> L12
    L12:
        e = move-exception;
        LLog.e("getRefreshRate failed: " + e.getMessage());
    L15:
        return mFrameRefreshTimeNS;
    }

    public static void initUIThreadChoreographer() {
        if (sUIThreadChoreographer == null) goto L5;
        return;
    L5:
        spa.e.a(new a());
    }

    private static void updateFreshRate() {
        mFrameRefreshTimeNS = (long) (1.0E9f / mDisplayManager.getDisplay(0).getRefreshRate());     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("onDisplayChanged failed: " + e.getMessage());
    }

    public static /* synthetic */ DisplayManager access$000() {
        return mDisplayManager;
    }

    public static /* synthetic */ void access$100() {
        updateFreshRate();
    }

    public static /* synthetic */ Choreographer access$202(Choreographer r100) {
        sUIThreadChoreographer = r100;
        return r100;
    }

    public static void requestOnUIThread(long r100) {
        Choreographer r101 = sUIThreadChoreographer;
        if (r101 != null) goto L5;
        spa.e.a(new b(r100));
        return;
    L5:
        r101.postFrameCallback(new c(r100));
    }

    public static void setCurrentDisplayManager(DisplayManager r100) {
        if (r100 == null) goto L8;
        mDisplayManager = r100;
        updateFreshRate();
        if (mDisplayListener != null) goto L6;
        mDisplayListener = new d();
    L6:
        r100.registerDisplayListener(mDisplayListener, new Handler(Looper.getMainLooper()));
        mUseDisplayManager = true;
        return;
    }

    public static void setCurrentWindowManager(WindowManager r100) {
        mWindowManager = new WeakReference(r100);
        mUseDisplayManager = false;
    }

    public static /* synthetic */ void access$300(long r100, long r101) {
        doFrame(r100, r101);
    }

    private static void doFrame(long r100, long r110) {
        nativeOnVSync(r100, r110, r110 + getRefreshRate());
    }
}
