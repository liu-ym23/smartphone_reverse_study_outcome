package com.lynx.tasm.core;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import android.view.WindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class VSyncMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<WindowManager> f383256a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DisplayManager f383257b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Choreographer f383258c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f383259d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static d f383260e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f383261f = -1;

    public static class a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f383262a;

        public a(long r100) {
            this.f383262a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            VSyncMonitor.a(this.f383262a, r100);
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f383263a;

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L3:
            if (VSyncMonitor.f383258c != null) goto L6;
            UIThreadUtils.runOnUiThreadImmediately(new o());     // Catch: Throwable -> L8
        L6:
            VSyncMonitor.requestOnUIThread(this.f383263a);     // Catch: Throwable -> L8
        }

        public b(long r100) {
            this.f383263a = r100;
        }
    }

    public static class c implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f383264a;

        public c(long r100) {
            this.f383264a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            VSyncMonitor.a(this.f383264a, r100);
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
            if (VSyncMonitor.f383257b == null) goto L8;
            VSyncMonitor.b();
            return;
        }
    }

    public VSyncMonitor() {
    }

    private static native void nativeOnVSync(long r100, long r101, long r102);

    public static void b() {
        f383261f = (long) (1.0E9f / f383257b.getDisplay(0).getRefreshRate());     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("VSyncMonitor", "onDisplayChanged failed: " + CallStackUtil.a(e));
    }

    public static void request(long r100) {
        Choreographer.getInstance().postFrameCallback(new a(r100));
    }

    public static void requestOnUIThread(long r100) {
        Choreographer r101 = f383258c;
        if (r101 != null) goto L5;
        UIThreadUtils.runOnUiThreadImmediately(new b(r100));
        return;
    L5:
        r101.postFrameCallback(new c(r100));
    }

    public static void a(long r100, long r110) {
        if (f383259d == false) goto L13;
    L11:
        nativeOnVSync(r100, r110, r110 + f383261f);
        return;
    L13:
        f383261f = com.relax.VSyncMonitor.DEFAULT_FRAME_TIME_NS;     // Catch: RuntimeException -> L9
        WindowManager r101 = f383256a.get();     // Catch: RuntimeException -> L9
        if (r101 == null) goto L11;
        f383261f = (long) (1.0E9d / ((double) r101.getDefaultDisplay().getRefreshRate()));     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        LLog.e("VSyncMonitor", "getRefreshRate failed: " + e.getMessage());
        goto L11
    }
}
