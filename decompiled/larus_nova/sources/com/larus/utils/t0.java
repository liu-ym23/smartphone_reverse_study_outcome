package com.larus.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f375468a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f375469b = null;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f375470a;

        public final void a() {
            Runnable r100 = this.f375470a;
            if (r100 == null) goto L11;
            r100.run();     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            FLogger.f375446a.e("SafeWrapper", "fail to execute runnable = " + this.f375470a + " error = " + Log.getStackTraceString(e));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Runnable r100) {
            this.f375470a = r100;
        }
    }

    static {
        f375468a = new Handler(Looper.getMainLooper());
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("background_thread_utils");
        ThreadMethodProxy.start(r100);
        f375469b = new Handler(r100.getLooper());
        FLogger.f375446a.i("ThreadUtils", "ThreadUtils inited，currentThread = " + ThreadMethodProxy.currentThread());
    }

    public static void a(Runnable r100) {
        f375469b.post(new a(r100));
    }

    public static void c(Runnable r100) {
        f375468a.post(new a(r100));
    }

    public static void e(Runnable r100) {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        r100.run();
        return;
    L5:
        c(r100);
    }

    public static void b(Runnable r100, long r101) {
        f375469b.postDelayed(new a(r100), r101);
    }

    public static void d(Runnable r100, long r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        f375468a.postDelayed(new a(r100), r101);
    }
}
