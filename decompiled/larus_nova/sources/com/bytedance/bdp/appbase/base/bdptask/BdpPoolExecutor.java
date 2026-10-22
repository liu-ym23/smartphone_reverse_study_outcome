package com.bytedance.bdp.appbase.base.bdptask;

import android.os.Handler;
import android.os.Process;
import com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f200419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f200420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadLocal<BdpTask> f200421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f200422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f200423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g<com.bytedance.bdp.appbase.base.bdptask.b<?>> f200424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BlockingQueue<com.bytedance.bdp.appbase.base.bdptask.b<?>> f200425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BlockingQueue<com.bytedance.bdp.appbase.base.bdptask.b<?>> f200426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BdpPoolImpl.a f200427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f200428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PThreadPoolExecutor f200429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f200430l;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BdpTask.TaskType f200431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BdpPoolExecutor f200432b;

        public final void a() {
        L2:
            int r100 = com.bytedance.bdp.appbase.base.bdptask.c.f200489a[this.f200431a.ordinal()];
            boolean r101 = false;
            if (r100 != 1) goto L5;
            com.bytedance.bdp.appbase.base.bdptask.b r102 = this.f200432b.f200424f.g(new BdpTask.TaskType[]{BdpTask.TaskType.OWN});
        L9:
            if (r102 == null) goto L10;
            BdpTask r103 = r102.f200485e;
            if (r103 == null) goto L55;
            if (this.f200432b.b(r103) == true) goto L15;
            g<com.bytedance.bdp.appbase.base.bdptask.b<?>> r104 = this.f200432b.f200424f;     // Catch: Throwable -> L46
            BdpTask.TaskType r105 = r102.f200486f;     // Catch: Throwable -> L46
            int r106 = r104.d(r105).incrementAndGet();     // Catch: Throwable -> L46
            if (r105 != BdpTask.TaskType.IO) goto L20;
            r104.f200500d = Math.max(r104.f200500d, r106);     // Catch: Throwable -> L46
        L25:
            Thread.interrupted();     // Catch: Throwable -> L46
            this.f200432b.f200421c.set(r103);     // Catch: Throwable -> L46
            if (BdpTrace.ENABLE == false) goto L41;
            k.f200515b.set(r102.f200488h);     // Catch: Throwable -> L46
            String r107 = "";
            if (r102.f200488h.size() <= 0) goto L32;
            TracePoint r108 = r102.f200488h.getFirst();     // Catch: Throwable -> L46
            if (r108.event != 3) goto L32;
            r107 = r108.getEventKey();     // Catch: Throwable -> L46
        L32:
            String r109 = String.valueOf(this.f200431a);     // Catch: Throwable -> L46
            String r110 = r103.trace;     // Catch: Throwable -> L46
            if (r110 != null) goto L35;
        L36:
            r101 = true;
        L37:
            if (r101 == false) goto L39;
            String r111 = "BdpTask no trace";
        L40:
            TracePoint r112 = new TracePoint(r111, r107 + '#' + r109, 1);     // Catch: Throwable -> L46
            k.d(r112);     // Catch: Throwable -> L46
            k.b(r102.f200488h, r112);     // Catch: Throwable -> L46
            goto L41
        L39:
            r111 = r103.trace;     // Catch: Throwable -> L46
            goto L40
        L35:
            if (r110.length() != 0) goto L37;
        L41:
            r102.run();     // Catch: Throwable -> L46
            this.f200432b.f200424f.d(r102.f200486f).decrementAndGet();
            if (BdpTrace.ENABLE == false) goto L45;
            k.e();
            k.f200515b.remove();
        L45:
            this.f200432b.f200421c.remove();
            Thread.interrupted();
            this.f200432b.a(r103);
            goto L2
        L20:
            if (r105 != BdpTask.TaskType.CPU) goto L23;
            r104.f200501e = Math.max(r104.f200501e, r106);     // Catch: Throwable -> L46
            goto L25
        L23:
            if (r105 != BdpTask.TaskType.OWN) goto L25;
            r104.f200502f = Math.max(r104.f200502f, r106);     // Catch: Throwable -> L46
        L46:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            this.f200432b.f200424f.d(r102.f200486f).decrementAndGet();
            if (BdpTrace.ENABLE == false) goto L52;
            k.e();
            k.f200515b.remove();
        L52:
            this.f200432b.f200421c.remove();
            Thread.interrupted();
            this.f200432b.a(r103);
            throw th;
        L15:
            return;
        L55:
            throw new IllegalArgumentException("BdpTask can not be null!!!");
        L10:
            return;
        L5:
            if (r100 == 2) goto L7;
            r102 = this.f200432b.f200424f.f();
            goto L9
        L7:
            r102 = this.f200432b.f200424f.g(new BdpTask.TaskType[]{BdpTask.TaskType.CPU, BdpTask.TaskType.OWN});
            goto L9
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

        public b(BdpPoolExecutor r100, BdpTask.TaskType r101) {
            this.f200432b = r100;
            this.f200431a = r101;
        }
    }

    public static final class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f200433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f200434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f200435c;

        public static final class a extends PthreadThreadV2 {

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ Runnable f200436v;

            @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(-4);     // Catch: Throwable -> L5
                super.run();     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L9;
                return;
            L9:
                throw th;
            }

            public a(Runnable r100, ThreadGroup r101, Runnable r102, String r110) {
                this.f200436v = r100;
                super(r101, r102, r110, 0);
            }
        }

        public c() {
            ThreadGroup r100 = new ThreadGroup("BdpPool");
            r100.setDaemon(false);
            r100.setMaxPriority(10);
            Unit r101 = Unit.INSTANCE;
            this.f200433a = r100;
            this.f200434b = new AtomicInteger(1);
            this.f200435c = "BdpPool-OWN-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            int r101 = this.f200434b.getAndIncrement();
            a r102 = new a(r100, this.f200433a, r100, this.f200435c + r101);
            if (r102.isDaemon() == false) goto L6;
            r102.setDaemon(false);
        L6:
            if (r102.getPriority() == 5) goto L8;
            ThreadMethodProxy.setPriority(r102, 5);
        L8:
            return r102;
        }
    }

    public static final class d extends g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BdpPoolExecutor f200437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f200438b;

        @Override // com.bytedance.bdp.appbase.base.bdptask.g.a
        public final void b() {
        }

        @Override // com.bytedance.bdp.appbase.base.bdptask.g.a
        public final int a(BdpTask.TaskType r100) {
            int r101 = com.bytedance.bdp.appbase.base.bdptask.d.f200491b[r100.ordinal()];
            if (r101 == 1) goto L9;
            if (r101 == 2) goto L11;
            return this.f200437a.f200423e;
        L11:
            return this.f200438b;
        L9:
            return this.f200438b;
        }

        @Override // com.bytedance.bdp.appbase.base.bdptask.g.a
        public final int c(BdpTask.TaskType r100) {
            int r101 = com.bytedance.bdp.appbase.base.bdptask.d.f200490a[r100.ordinal()];
            if (r101 == 1) goto L8;
            if (r101 == 2) goto L6;
            return 0;
        L6:
            return 1;
        L8:
            return 2;
        }

        public d(BdpPoolExecutor r100, int r101) {
            this.f200437a = r100;
            this.f200438b = r101;
        }
    }

    static {
    }

    public final Handler c() {
        return (Handler) this.f200430l.getValue();
    }

    public final BdpThreadService d() {
        return (BdpThreadService) this.f200428j.getValue();
    }

    public final void f() {
        if (this.f200422d == false) goto L5;
        return;
    L5:
        com.bytedance.bdp.appbase.base.bdptask.b r100 = (com.bytedance.bdp.appbase.base.bdptask.b) ((PriorityBlockingQueue) this.f200426h).peek();
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.f200481a != (-1)) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L37;
        BdpTask r102 = r100.f200485e;
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.priority != Integer.MIN_VALUE) goto L41;
        BdpTask r103 = this.f200421c.get();
        String r104 = null;
        if (BdpTrace.ENABLE == false) goto L21;
        LinkedList<TracePoint> r105 = k.f200515b.get();
    L22:
        this.f200422d = true;
        Handler r106 = c();     // Catch: Throwable -> L32
        Handler r107 = c();     // Catch: Throwable -> L32
        BdpTask r108 = r100.f200485e;     // Catch: Throwable -> L32
        if (r108 == null) goto L26;
        r104 = r108.trace;     // Catch: Throwable -> L32
    L26:
        r106.handleMessage(r107.obtainMessage(1, r104));     // Catch: Throwable -> L32
        this.f200422d = false;
        this.f200421c.set(r103);
        if (BdpTrace.ENABLE == false) goto L30;
        k.f200515b.set(r105);
    L30:
        f();
        return;
    L32:
        th = move-exception;
        this.f200422d = false;
        this.f200421c.set(r103);
        if (BdpTrace.ENABLE == false) goto L36;
        k.f200515b.set(r105);
    L36:
        throw th;
    L21:
        r105 = null;
        goto L22
    L41:
        return;
    L37:
        return;
    L11:
        r101 = false;
        goto L12
    }

    public final void a(BdpTask r100) {
        BdpPoolImpl.a r101 = this.f200427i;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final boolean b(BdpTask r100) {
        if (this.f200427i == null) goto L20;
        TaskLifecycle r101 = r100.lifecycle;
        if (r101 == null) goto L10;
        if ((!Intrinsics.areEqual(r101.getCurState(), TaskLifecycle.State.Start.INSTANCE)) == false) goto L10;
        r100.f200462e = 0;
        return true;
    L10:
        if (r100.b(BdpTask.Stage.EXECUTE) == false) goto L23;
        Object r102 = BdpPoolImpl.f200440a;
        if (BdpPoolImpl.f200454o == null) goto L20;
        if (r100.taskType == BdpTask.TaskType.MAIN) goto L20;
        TaskExecuteStatusListener r103 = BdpPoolImpl.f200454o;
        if (r103 == null) goto L20;
        r103.taskStart(r100);
        goto L20
    L23:
        return true;
    L20:
        return false;
    }

    public final void e(com.bytedance.bdp.appbase.base.bdptask.b r100) {
        BdpTask.TaskType r101 = r100.f200486f;
        boolean r102 = true;
        if (r101 != BdpTask.TaskType.LOGIC) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        ((PriorityBlockingQueue) this.f200425g).remove(r100);
        return;
    L10:
        if (r101 == BdpTask.TaskType.MAIN) goto L13;
        r102 = false;
    L13:
        if (r102 == false) goto L16;
        ((PriorityBlockingQueue) this.f200426h).remove(r100);
        return;
    L16:
        this.f200424f.remove(r100);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public BdpPoolExecutor(int r110, int r111) {
        this.f200420b = new Object();
        this.f200421c = new ThreadLocal();
        int r100 = Math.max(2, Math.round(r110 / 3.0f));
        this.f200423e = r111;
        Math.max(2, r110 - 2);
        this.f200424f = new g(new d(this, r111));
        this.f200428j = LazyKt.lazy(BdpPoolExecutor$pool$2.INSTANCE);
        this.f200425g = new PriorityBlockingQueue();
        this.f200426h = new PriorityBlockingQueue();
        this.f200429k = new PThreadPoolExecutor(r100, r100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c());
        this.f200430l = LazyKt.lazy(new BdpPoolExecutor$mMainHandler$2(this));
    }
}
