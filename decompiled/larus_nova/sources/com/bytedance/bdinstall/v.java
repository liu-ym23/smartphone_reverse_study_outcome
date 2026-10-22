package com.bytedance.bdinstall;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Executor> f199797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, ExecutorService> f199798b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Looper> f199799c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Handler> f199800d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f199801e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f199802f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f199803g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f199804h = null;

    public static class a extends i84.r<Executor> {
        public a() {
        }

        @Override // i84.r
        public final Executor a(Object[] r100) {
            return new PThreadPoolExecutor(0, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("xecutorUtil$1"));
        }
    }

    public static class b extends i84.r<ExecutorService> {
        public b() {
        }

        @Override // i84.r
        public final ExecutorService a(Object[] r100) {
            return new PThreadPoolExecutor(0, Integer.MAX_VALUE, 5, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("xecutorUtil$2"));
        }
    }

    public static class c extends i84.r<Looper> {
        public c() {
        }

        @Override // i84.r
        public final Looper a(Object[] r100) {
            PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("bd_install");     // Catch: Exception -> L4
            ThreadMethodProxy.start(r101);     // Catch: Exception -> L4
            return r101.getLooper();
        L5:
            return Looper.getMainLooper();
        }
    }

    public static class d extends i84.r<Handler> {
        public d() {
        }

        @Override // i84.r
        public final Handler a(Object[] r100) {
            return new Handler(v.f199803g.b(new Object[0]));
        }
    }

    static {
        f199797a = new ConcurrentHashMap(4);
        f199798b = new ConcurrentHashMap(4);
        f199799c = new ConcurrentHashMap(4);
        f199800d = new ConcurrentHashMap(4);
        f199801e = new a();
        f199802f = new b();
        f199803g = new c();
        f199804h = new d();
    }

    public static String a(Map r100) {
        if (r100 != null) goto L5;
    L13:
        return null;
    L5:
        if (r100.size() == 0) goto L13;
        Set r101 = r100.keySet();
        if (r101 == null) goto L13;
        if (r101.size() <= 0) goto L13;
        return (String) r101.iterator().next();
    }

    public static Handler b(String r100) {
        if (r100 == null) goto L4;
        ConcurrentHashMap r101 = (ConcurrentHashMap) f199800d;
        Handler r102 = (Handler) r101.get(r100);
        if (r102 != null) goto L12;
        Looper r103 = d(r100);
        if (r103 == null) goto L10;
        Handler r104 = new Handler(r103);
        r101.put(r100, r104);
        return r104;
    L10:
        t.b("getLooper return null");
        return r102;
    L12:
        return r102;
    L4:
        return f199804h.b(new Object[0]);
    }

    public static ExecutorService c(String r100) {
        if (r100 == null) goto L9;
        ExecutorService r101 = (ExecutorService) ((ConcurrentHashMap) f199798b).get(r100);
        if (r101 == null) goto L8;
        return r101;
    L8:
        return f199802f.b(new Object[0]);
    L9:
        return f199802f.b(new Object[0]);
    }

    public static Looper d(String r100) {
        if (r100 == null) goto L9;
        Looper r101 = (Looper) ((ConcurrentHashMap) f199799c).get(r100);
        if (r101 == null) goto L8;
        return r101;
    L8:
        return f199803g.b(new Object[0]);
    L9:
        return f199803g.b(new Object[0]);
    }

    public static void e(String r100, Runnable r101) {
        if (Looper.myLooper() != d(r100)) goto L5;
        r101.run();
        return;
    L5:
        Handler r102 = b(r100);
        if (r102 != null) goto L8;
        r102 = f199804h.b(new Object[0]);
    L8:
        r102.post(r101);
    }

    public static void f(String r100, Runnable r101) {
        if (r100 != null) goto L5;
        Executor r102 = f199801e.b(new Object[0]);
    L8:
        r102.execute(r101);
        return;
    L5:
        r102 = (Executor) ((ConcurrentHashMap) f199797a).get(r100);
        if (r102 != null) goto L8;
        r102 = f199801e.b(new Object[0]);
        goto L8
    }
}
