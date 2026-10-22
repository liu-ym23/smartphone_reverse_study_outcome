package com.ss.ugc.effectplatform;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public final class k implements bytekn.foundation.concurrent.executor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f457402a;

    /* JADX INFO: loaded from: classes36.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f457403a;

        public a(Runnable r100) {
            this.f457403a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r100 = this.f457403a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.run();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public k(PThreadPoolExecutor r100) {
        this.f457402a = r100;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        this.f457402a.execute(new a(r100));
    }
}
