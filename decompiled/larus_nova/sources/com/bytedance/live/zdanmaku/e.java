package com.bytedance.live.zdanmaku;

import com.bytedance.live.artist.core.CoreEngine;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.live.zdanmaku.pipelines.DanmakuProcessPipeline;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes19.dex */
public final class e<T extends Danmaku> implements i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f255839i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f255840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CoreEngine f255841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.live.artist.render.c f255842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kf6.a f255843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.live.zdanmaku.data.d f255844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Class<?>, com.bytedance.live.zdanmaku.data.b<?>> f255845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DanmakuController<T> f255846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f255847h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public kf6.a f255848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.bytedance.live.zdanmaku.data.d f255849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<Class<?>, com.bytedance.live.zdanmaku.data.b<?>> f255850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Executor f255851d;

        public a() {
            this.f255848a = vk6.g.f555528a;
            this.f255849b = new com.bytedance.live.zdanmaku.data.d();
            this.f255850c = new HashMap();
        }

        public final void b(Class r100, com.bytedance.live.zdanmaku.data.b r101) {
            ((HashMap) this.f255850c).put(r100, r101);
        }

        public final <T extends Danmaku> e<T> a(com.bytedance.live.artist.render.c r100, com.bytedance.live.zdanmaku.data.c<T> r101, rk6.a<T> r110) {
            DanmakuController r102 = new DanmakuController(r101, r110);
            return new e(r100, this.f255848a, this.f255849b, this.f255850c, r102, this.f255851d);
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f255852a;

        public c(e r100) {
            this.f255852a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DanmakuController<T> r100 = this.f255852a.f255846g;     // Catch: Throwable -> L4
            r100.f255814d.clear();     // Catch: Throwable -> L4
            ((LinkedList) r100.f255815e).clear();     // Catch: Throwable -> L4
            ((LinkedBlockingDeque) r100.f255813c).clear();     // Catch: Throwable -> L4
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
    }

    public final void b() {
        postRunnable(new c(this));
    }

    public final int c() {
        DanmakuController<T> r100 = this.f255846g;
        return ((LinkedList) r100.f255815e).size() + ((LinkedBlockingDeque) r100.f255813c).size();
    }

    public final void d() {
        DanmakuController<T> r100 = this.f255846g;
        r100.f255812b.post(new com.bytedance.live.zdanmaku.c(r100));
    }

    public final void e() {
        CoreEngine r100 = this.f255841b;
        if (r100 == null) goto L5;
        r100.e();
    L5:
        this.f255841b = null;
        this.f255840a = false;
    }

    public final void f() {
        DanmakuController<T> r100 = this.f255846g;
        r100.f255812b.post(new d(r100));
    }

    @Override // com.bytedance.live.zdanmaku.i
    public final void start() {
        if (this.f255840a == false) goto L6;
        return;
    L6:
        if (this.f255841b != null) goto L8;
        DanmakuProcessPipeline r100 = new DanmakuProcessPipeline(this.f255846g, this.f255845f, this.f255844e);
        int r101 = lf6.d.f509064b;
        lf6.d.a r102 = new lf6.d.a();
        ((ArrayList) r102.f509066a).add(r100);
        lf6.d r103 = new lf6.d(r102.f509066a);
        this.f255841b = new CoreEngine(this.f255843d, this.f255842c, r103, this.f255847h);
    L8:
        CoreEngine r104 = this.f255841b;
        if (r104 == null) goto L11;
        r104.f();
    L11:
        this.f255840a = true;
    }

    @Override // com.bytedance.live.zdanmaku.i
    public final void stop() {
        if (this.f255840a == true) goto L5;
        return;
    L5:
        CoreEngine r100 = this.f255841b;
        if (r100 == null) goto L8;
        r100.g();
    L8:
        this.f255840a = false;
    }

    @Override // com.bytedance.live.zdanmaku.i
    public final void postRunnable(Runnable r100) {
        CoreEngine r101 = this.f255841b;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public final void a(Object r100, boolean r101) {
        DanmakuController<T> r102 = this.f255846g;
        if (r101 == false) goto L5;
        ((LinkedBlockingDeque) r102.f255813c).addFirst(r100);
    L6:
        r102.f255812b.post(new com.bytedance.live.zdanmaku.a(r102));
        return;
    L5:
        ((LinkedBlockingDeque) r102.f255813c).add(r100);
        goto L6
    }

    public e(com.bytedance.live.artist.render.c r100, kf6.a r101, com.bytedance.live.zdanmaku.data.d r102, Map r103, DanmakuController r104, Executor r105) {
        this.f255842c = r100;
        this.f255843d = r101;
        this.f255844e = r102;
        this.f255845f = r103;
        this.f255846g = r104;
        this.f255847h = r105;
        r104.f255811a = this;
    }
}
