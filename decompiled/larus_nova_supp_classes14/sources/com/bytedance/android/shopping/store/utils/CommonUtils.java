package com.bytedance.android.shopping.store.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CommonUtils {
    public static final Handler a = null;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
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
        a = new Handler(Looper.getMainLooper());
    }

    public static Activity a() {
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        if (r0 == null) goto L7;
        yj.i r1 = r0.getIHybridHostAppInfo();
        if (r1 == null) goto L7;
        return r1.a();
    L7:
        return null;
    }

    public static boolean b() {
        return Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
    }

    public static void d(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        if (b() == false) goto L5;
        r2.invoke();
        return;
    L5:
        a.postAtFrontOfQueue(new c(r2));
    }

    public static void c(boolean r1, Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        if (b() == false) goto L5;
        r2.invoke();
        return;
    L5:
        if (r1 == false) goto L7;
        a.postAtFrontOfQueue(new a(r2));
        return;
    L7:
        a.post(new b(r2));
    }

    public static void e(boolean r1, final Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        c(r1, new CommonUtils$safeRunOnMainThread$1(r2));
    }
}
