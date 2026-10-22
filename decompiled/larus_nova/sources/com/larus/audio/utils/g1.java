package com.larus.audio.utils;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f290034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f290035b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BlockingQueue<Runnable> f290036c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f290037d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d1 f290038e = null;

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f290039d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f290040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f290041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f290042c;

        /* JADX INFO: renamed from: com.larus.audio.utils.g1$a$a, reason: collision with other inner class name */
        public static final class C3970a {
        }

        static {
            f290039d = new AtomicInteger(1);
        }

        public a() {
            Intrinsics.checkNotNullParameter("AudioThreads", "factoryTag");
            this.f290041b = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.f290040a = r101;
            this.f290042c = "AudioThreads-" + f290039d.getAndIncrement() + "-Thread-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "runnable");
            PthreadThreadV2 r101 = new PthreadThreadV2(this.f290040a, r100, this.f290042c + this.f290041b.getAndIncrement(), 0);
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r101, 5);
        L8:
            return r101;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.audio.utils.d1] */
    static {
        f290034a = new Handler(Looper.getMainLooper());
        f290035b = LazyKt.lazy(new c1());
        f290036c = new LinkedBlockingQueue();
        f290037d = new a();
        f290038e = new d1();
    }

    public static void a(long r100, final Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        if (r100 <= 0) goto L5;
        f290034a.postDelayed(new f1(r101), r100);
        return;
    L5:
        r101.invoke();
    }
}
