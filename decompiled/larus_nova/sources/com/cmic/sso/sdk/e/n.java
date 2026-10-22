package com.cmic.sso.sdk.e;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f273516a = null;

    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Thread.UncaughtExceptionHandler f273517a;

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            com_cmic_sso_sdk_e_n$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public a() {
            this.f273517a = new AnonymousClass1(this);
        }

        public void com_cmic_sso_sdk_e_n$a__run$___twin___() {
            ThreadMethodProxy.currentThread().setUncaughtExceptionHandler(this.f273517a);
            a();
            ThreadMethodProxy.currentThread().setUncaughtExceptionHandler(null);
        }

        public static /* synthetic */ Thread.UncaughtExceptionHandler a(a r100) {
            return r100.f273517a;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_cmic_sso_sdk_e_n$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_cmic_sso_sdk_e_n$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(final Context r100, final com.cmic.sso.sdk.a r101) {
            this.f273517a = new AnonymousClass2(this, r101, r100);
        }
    }

    static {
        f273516a = new PThreadPoolExecutor(0, 30, 60, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("c/sso/sdk/e/n"));
    }

    public static void a(a r100) {
        f273516a.execute(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        a.a(r100).uncaughtException(ThreadMethodProxy.currentThread(), e);
    }
}
