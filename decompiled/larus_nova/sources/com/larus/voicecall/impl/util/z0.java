package com.larus.voicecall.impl.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes4.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f379493a = null;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f379494a;

        public final void a() {
            Runnable r100 = this.f379494a;
            if (r100 == null) goto L11;
            r100.run();     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            FLogger.f375446a.e("SafeWrapper", "fail to execute runnable = " + this.f379494a + " error = " + Log.getStackTraceString(e));
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
            this.f379494a = r100;
        }
    }

    static {
        f379493a = new Handler(Looper.getMainLooper());
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("background_thread_utils");
        ThreadMethodProxy.start(r100);
        new Handler(r100.getLooper());
        FLogger.f375446a.i("ThreadUtils", "ThreadUtils inited，currentThread = " + ThreadMethodProxy.currentThread());
    }
}
