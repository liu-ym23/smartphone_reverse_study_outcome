package com.cmic.ida.sdk;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f273180a = null;

    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Thread.UncaughtExceptionHandler f273181a;

        /* JADX INFO: renamed from: com.cmic.ida.sdk.q0$a$a, reason: collision with other inner class name */
        public class C3818a implements Thread.UncaughtExceptionHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f273182a;

            public C3818a(a r100) {
                this.f273182a = r100;
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread r100, Throwable r101) {
                r101.printStackTrace();
            }
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            com_cmic_ida_sdk_q0$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public a() {
            this.f273181a = new C3818a(this);
        }

        public void com_cmic_ida_sdk_q0$a__run$___twin___() {
            ThreadMethodProxy.currentThread().setUncaughtExceptionHandler(this.f273181a);
            a();
            ThreadMethodProxy.currentThread().setUncaughtExceptionHandler(null);
        }

        public static /* synthetic */ Thread.UncaughtExceptionHandler a(a r100) {
            return r100.f273181a;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_cmic_ida_sdk_q0$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_cmic_ida_sdk_q0$a__run$___twin___();     // Catch: Throwable -> L4
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
        f273180a = new PThreadPoolExecutor(0, 30, 60, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("ic/ida/sdk/q0"));
    }

    public static void a(a r100) {
        f273180a.execute(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        a.a(r100).uncaughtException(ThreadMethodProxy.currentThread(), e);
    }
}
