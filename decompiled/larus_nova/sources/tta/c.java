package tta;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f547570a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f547571b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f547572c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f547573d = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f547574a = null;

        static {
            f547574a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.f547572c.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("DyPay ImageLoader Thread");
        ThreadMethodProxy.start(r100);
        Handler r101 = new Handler(r100.getLooper());
        f547573d = r101;
        f547570a = new e();
        f547571b = new h();
        f547572c = new b();
        r101.post(a.f547574a);
    }
}
