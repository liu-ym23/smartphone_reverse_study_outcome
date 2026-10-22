package com.bytedance.kmp.ec.yata.common.platform.executor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f251526g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f251527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f251528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f251529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<g> f251530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<g> f251531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f251532f;

    public interface a {
        void a(h r100);

        void b(h r100, long r101);

        void execute(Runnable r100);

        long nanoTime();
    }

    public static final class b {
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PThreadPoolExecutor f251533a;

        public static final class a {
        }

        static {
        }

        @Override // com.bytedance.kmp.ec.yata.common.platform.executor.h.a
        public final long nanoTime() {
            return System.nanoTime();
        }

        public c(j r110) {
            Intrinsics.checkNotNullParameter(r110, "threadFactory");
            this.f251533a = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), r110);
        }

        @Override // com.bytedance.kmp.ec.yata.common.platform.executor.h.a
        public final void a(h r100) {
            Intrinsics.checkNotNullParameter(r100, "taskRunner");
            AtomicInteger r101 = k.f251537a;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.Object");
            r100.notify();
        }

        @Override // com.bytedance.kmp.ec.yata.common.platform.executor.h.a
        public final void execute(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "runnable");
            this.f251533a.execute(r100);
        }

        @Override // com.bytedance.kmp.ec.yata.common.platform.executor.h.a
        public final void b(h r100, long r101) throws InterruptedException {
            Intrinsics.checkNotNullParameter(r100, "taskRunner");
            long r102 = r101 / 1000000;
            long r103 = r101 - (1000000 * r102);
            if (r102 <= 0) goto L5;
        L6:
            r100.wait(r102, (int) r103);
            return;
        L5:
            if (r101 > 0) goto L6;
        }
    }

    public final void d() {
        monitor-enter(this);
        int r100 = ((ArrayList) this.f251530d).size() - 1;     // Catch: Throwable -> L21
    L5:
        if ((-1) >= r100) goto L7;
        ((g) ((ArrayList) this.f251530d).get(r100)).c();     // Catch: Throwable -> L21
        r100 = r100 - 1;     // Catch: Throwable -> L21
        goto L5
    L7:
        int r101 = ((ArrayList) this.f251531e).size() - 1;     // Catch: Throwable -> L21
    L8:
        if ((-1) >= r101) goto L18;
        g r102 = (g) CollectionsKt.getOrNull(this.f251531e, r101);     // Catch: Throwable -> L21
        if (r102 == null) goto L17;
        r102.c();     // Catch: Throwable -> L21
        if (((ArrayList) r102.f251515c).isEmpty() == false) goto L17;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        Result.m9449constructorimpl((g) ((ArrayList) this.f251531e).remove(r101));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L21
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L21
    L17:
        r101 = r101 - 1;     // Catch: Throwable -> L21
        goto L8
    L18:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.kmp.ec.yata.common.platform.executor.j] */
    static {
        AtomicInteger r100 = k.f251537a;
        f251526g = new h(new c(new j()));
    }

    public final f c() {
        k.a(this);
    L3:
        List<g> r100 = this.f251531e;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if ((true ^ ((g) r103).f251513a) == false) goto L5;
        r101.add(r103);
        goto L5
    L10:
        if (r101.isEmpty() == true) goto L11;
        long r104 = this.f251527a.nanoTime();
        Iterator r105 = r101.iterator();
        long r106 = Long.MAX_VALUE;
        f r107 = null;
    L14:
        if (r105.hasNext() == false) goto L23;
        g r110 = (g) r105.next();
        if (((ArrayList) r110.f251515c).isEmpty() == true) goto L14;
        f r111 = (f) ListProtector.get(r110.f251515c, 0);
        long r112 = Math.max(0, r111.f251523b - r104);
        if (r112 > 0) goto L19;
        if (r107 != null) goto L21;
        r107 = r111;
        goto L14
    L21:
        boolean r108 = true;
    L24:
        if (r107 != null) goto L25;
        if (this.f251528b == true) goto L38;
        this.f251528b = true;
        this.f251529c = r104 + r106;
        this.f251527a.b(this, r106);     // Catch: Throwable -> L44 InterruptedException -> L46
    L43:
        this.f251528b = false;
    L46:
        d();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        this.f251528b = false;
        throw th;
    L38:
        if (r106 >= (this.f251529c - r104)) goto L40;
        this.f251527a.a(this);
    L40:
        return null;
    L25:
        k.a(this);
        r107.f251523b = -1;
        g r109 = r107.f251522a;
        Intrinsics.checkNotNull(r109);
        r109.f251514b = r107;
        ((ArrayList) r109.f251515c).remove(r107);
        if (r109.f251525e == false) goto L28;
        ((ArrayList) this.f251531e).remove(r109);
        ((ArrayList) this.f251530d).add(r109);
    L28:
        if (r108 == false) goto L30;
    L33:
        this.f251527a.execute(this.f251532f);
    L34:
        return r107;
    L30:
        if (this.f251528b == true) goto L34;
        if ((!r101.isEmpty()) == false) goto L34;
    L19:
        r106 = Math.min(r112, r106);
        goto L14
    L23:
        r108 = false;
        goto L24
    L11:
        return null;
    }

    public h(c r100) {
        this.f251527a = r100;
        this.f251530d = new ArrayList();
        this.f251531e = new ArrayList();
        this.f251532f = new i(this);
    }

    public final void e(g r100) {
        Intrinsics.checkNotNullParameter(r100, "taskQueue");
        k.a(this);
        if (r100.f251514b != null) goto L11;
        if ((!r100.f251515c.isEmpty()) == false) goto L9;
        ArrayList r101 = (ArrayList) this.f251531e;
        if (r101.contains(r100) == true) goto L11;
        r101.add(r100);
        goto L11
    L9:
        ((ArrayList) this.f251531e).remove(r100);
    L11:
        if (this.f251528b == false) goto L13;
        this.f251527a.a(this);
        return;
    L13:
        this.f251527a.execute(this.f251532f);
    }

    public static final void a(h r100, f r101) {
        r100.getClass();
        AtomicInteger r102 = k.f251537a;
        if (Thread.holdsLock(r100) == true) goto L22;
        r101.a();     // Catch: Throwable -> L13
        monitor-enter(r100);
        r100.b(r101, -1);     // Catch: Throwable -> L10
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        monitor-enter(r100);
        r100.b(r101, -1);     // Catch: Throwable -> L18
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L18
        throw th;
    L18:
        th = move-exception;
        throw th;
    L22:
        throw new AssertionError("Thread " + ThreadMethodProxy.currentThread().getName() + " must NOT hold lock on " + r100);
    }

    public final void b(f r100, long r101) {
        g r102 = r100.f251522a;
        Intrinsics.checkNotNull(r102);
        r102.f251514b = null;
        ((ArrayList) this.f251530d).remove(r102);
        if (r101 == (-1)) goto L8;
        if (r102.f251513a == true) goto L8;
        r102.a(r100, r101);
    L8:
        if ((!((ArrayList) r102.f251515c).isEmpty()) == false) goto L11;
        ((ArrayList) this.f251531e).add(r102);
        return;
    }
}
