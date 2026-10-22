package com.bytedance.vmsdk.jsbridge.utils;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes3.dex */
public class SystemThread {
    private Thread mAndroidThread;
    private long mNativeThread;

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SystemThread f272508a;

        @Override // java.lang.Runnable
        public final void run() {
            Looper.prepare();     // Catch: Throwable -> L4
            SystemThread.access$100(SystemThread.access$000(this.f272508a));     // Catch: Throwable -> L4
            Looper.loop();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(SystemThread r100) {
            this.f272508a = r100;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f272509a;

        @Override // java.lang.Runnable
        public final void run() {
            SystemThread.access$100(this.f272509a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(long r100) {
            this.f272509a = r100;
        }
    }

    private static native void nativeRun(long r100);

    public void join() {
        ThreadMethodProxy.join(this.mAndroidThread);     // Catch: InterruptedException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void stop() {
        Looper r100 = Looper.myLooper();
        if (ThreadMethodProxy.currentThread() != this.mAndroidThread) goto L7;
        if (r100 == null) goto L8;
        ThreadMethodProxy.quit(r100);
        return;
    L8:
        return;
    }

    public static /* synthetic */ long access$000(SystemThread r100) {
        return r100.mNativeThread;
    }

    public static /* synthetic */ void access$100(long r100) {
        nativeRun(r100);
    }

    public static void attachMainThread(long r100) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        nativeRun(r100);
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new b(r100));
    }

    private void createAndroidThread(String r100, int r101) {
        PthreadThreadV2 r102 = new PthreadThreadV2(new a(this), r100);
        this.mAndroidThread = r102;
        ThreadMethodProxy.setPriority(r102, r101);
        ThreadMethodProxy.start(this.mAndroidThread);
    }

    private SystemThread(long r100, String r101, int r102) {
        this.mNativeThread = r100;
        createAndroidThread(r101, r102);
    }

    public static SystemThread create(long r100, String r101, int r102) {
        return new SystemThread(r100, r101, r102);
    }
}
