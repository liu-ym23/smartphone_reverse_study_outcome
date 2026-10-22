package com.bytedance.gkfs;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
public final class GkFSExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PThreadPoolExecutor f245110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f245111b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final GkFSExecutor f245112c = null;

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f245113a = null;

        static {
            f245113a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "GkFSExecutor$parallelExecutor$1");
            ThreadMethodProxy.setName(r101, "gkfs-parallel");
            ThreadMethodProxy.setPriority(r101, 6);
            return r101;
        }
    }

    public GkFSExecutor() {
    }

    static {
        f245112c = new GkFSExecutor();
        f245110a = new PThreadPoolExecutor(3, 5, 30, TimeUnit.MINUTES, new LinkedBlockingQueue(), a.f245113a);
        f245111b = LazyKt.lazy(GkFSExecutor$defaultExecutor$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(Runnable r100) {
        f245112c.getClass();
        ((Executor) f245111b.getValue()).execute(r100);
    }
}
