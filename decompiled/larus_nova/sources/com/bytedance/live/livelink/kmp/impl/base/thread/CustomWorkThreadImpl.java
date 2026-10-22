package com.bytedance.live.livelink.kmp.impl.base.thread;

import android.os.Handler;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.live.livelink.kmp.impl.base.log.TraceEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import ej6.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import oi6.b;

/* JADX INFO: loaded from: classes19.dex */
public final class CustomWorkThreadImpl implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f255329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f255330b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f255331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f255332b;

        public a(Function0 r100, String r101) {
            this.f255331a = r100;
            this.f255332b = r101;
        }

        public final void a() {
            this.f255331a.invoke();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            int r100 = ej6.a.f472874a;
            ej6.a.b("ThreadManager", "submitTask error, taskInfo: " + this.f255332b + ", ex: " + e);
            int r101 = e.f472877a;
            e.a(TraceEvent.THREAD_MANAGER, "submitTaskError", 0, "submitTask error, taskInfo: " + this.f255332b + ", ex: " + e, null, 20);
            KmpEnv r102 = KmpEnv.f255139a;
            if (v.a() == true) goto L9;
            return;
        L9:
            throw new RuntimeException("submitTask error, taskInfo: " + this.f255332b + ", ex: " + e);
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
    }

    @Override // oi6.b
    public final void release() {
        this.f255329a.quitSafely();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        int r100 = ej6.a.f472874a;
        ej6.a.d("ThreadManager", "release error, ex: " + th);
        this.f255329a.quit();
    }

    public CustomWorkThreadImpl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f255329a = new PthreadHandlerThreadV2(r100);
        this.f255330b = LazyKt.lazy(new CustomWorkThreadImpl$handler$2(this));
    }

    @Override // oi6.b
    public final boolean a(Function0<Unit> r100, String r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "taskInfo");
        if (r110 <= 0) goto L5;
    L15:
        ((Handler) this.f255330b.getValue()).postDelayed(new a(r100, r101), r110);
        return true;
    L5:
        if (ThreadMethodProxy.currentThread().getId() != this.f255329a.getId()) goto L15;
        r100.invoke();     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        int r111 = ej6.a.f472874a;
        ej6.a.b("ThreadManager", "submitTask error, taskInfo: " + r101 + ", ex: " + e);
        int r112 = e.f472877a;
        e.a(TraceEvent.THREAD_MANAGER, "submitTaskError", 0, "submitTask error, taskInfo: " + r101 + ", ex: " + e, null, 20);
        KmpEnv r113 = KmpEnv.f255139a;
        if (v.a() == true) goto L14;
        return false;
    L14:
        throw new RuntimeException("submitTask error, taskInfo: " + r101 + ", ex: " + e);
    }
}
