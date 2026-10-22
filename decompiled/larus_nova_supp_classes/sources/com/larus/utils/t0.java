package com.larus.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class t0 {
    public static final Handler a = null;
    public static final Handler b = null;

    public static class a implements Runnable {
        public final Runnable a;

        public final void a() {
            Runnable r0 = this.a;
            if (r0 == null) goto L11;
            r0.run();     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            FLogger.a.e("SafeWrapper", "fail to execute runnable = " + this.a + " error = " + Log.getStackTraceString(e));
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

        public a(Runnable r1) {
            this.a = r1;
        }
    }

    static {
        a = new Handler(Looper.getMainLooper());
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("background_thread_utils");
        ThreadMethodProxy.start(r0);
        b = new Handler(r0.getLooper());
        FLogger.a.i("ThreadUtils", "ThreadUtils inited，currentThread = " + ThreadMethodProxy.currentThread());
    }

    public static void a(Runnable r2) {
        b.post(new a(r2));
    }

    public static void c(Runnable r2) {
        a.post(new a(r2));
    }

    public static void e(Runnable r2) {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        r2.run();
        return;
    L5:
        c(r2);
    }

    public static void b(Runnable r2, long r3) {
        b.postDelayed(new a(r2), r3);
    }

    public static void d(Runnable r2, long r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        a.postDelayed(new a(r2), r3);
    }
}
