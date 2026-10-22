package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f244764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f244765e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadScheduledThreadPoolExecutor f244766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<b, ScheduledFuture> f244767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<b, Runnable> f244768c;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.util.a$a, reason: collision with other inner class name */
    public class RunnableC3504a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f244769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f244770b;

        public final void a() {
            long r100 = System.currentTimeMillis();     // Catch: Throwable -> L7
            this.f244769a.run();     // Catch: Throwable -> L7
            if (Logger.debug() == false) goto L6;
            Logger.d(a.f244765e, "Task execute time: " + (System.currentTimeMillis() - r100));     // Catch: Throwable -> L7
        L6:
            b r101 = this.f244769a;
            r101.getClass();
            this.f244770b.f244767b.remove(r101);
            this.f244770b.f244768c.remove(this.f244769a);
            return;
        L7:
            th = move-exception;
            Logger.e(a.f244765e, "thread " + ThreadMethodProxy.currentThread().getName() + " exception", th);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            b r102 = this.f244769a;
            r102.getClass();
            this.f244770b.f244767b.remove(r102);
            this.f244770b.f244768c.remove(this.f244769a);
            throw th;
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

        public RunnableC3504a(a r100, ovc.a.C7120a r101) {
            this.f244770b = r100;
            this.f244769a = r101;
        }
    }

    static {
        f244765e = a.class.getSimpleName();
    }

    public a() {
        this.f244767b = new ConcurrentHashMap();
        this.f244768c = new ConcurrentHashMap();
        PThreadScheduledThreadPoolExecutor r100 = new PThreadScheduledThreadPoolExecutor(1, new k());
        this.f244766a = r100;
        r100.setRemoveOnCancelPolicy(true);
    }
}
