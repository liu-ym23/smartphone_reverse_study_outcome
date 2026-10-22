package com.bytedance.sdk.account.network.dispatcher;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicInteger f269219n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile c f269220o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f269221p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f269222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f269223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f269224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PriorityBlockingQueue<IRequest> f269225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PriorityBlockingQueue<IRequest> f269226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PriorityBlockingQueue<IRequest> f269227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final cc7.a[] f269228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final cc7.b[] f269229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f269230i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f269231j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f269232k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f269233l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile long f269234m;

    public c() {
        this(4, true);
    }

    public final synchronized void b() {
        monitor-enter(this);
    L30:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);
        return;
    L34:
        th = move-exception;
        throw th;
    L4:
        if (f269221p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        tb7.a.a("RequestQueue", "handleExpandDownloadRequestQueueSize");     // Catch: Throwable -> L30
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L30
        if (this.f269232k <= r100) goto L11;
        this.f269232k = r100;     // Catch: Throwable -> L30
    L11:
        if ((r100 - this.f269232k) > 1000) goto L15;
        tb7.a.a("RequestQueue", "handleExpandDownloadRequestQueueSize (now - mLastExpandDownloadRequestQueueTime) <= ApiThread.ENQUEUE_EXPIRE");     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L15:
        this.f269232k = r100;     // Catch: Throwable -> L30
        if (this.f269229h != null) goto L19;
        monitor-exit(this);
        return;
    L19:
        int r101 = 0;
        int r102 = 0;
    L20:
        cc7.b[] r103 = this.f269229h;     // Catch: Throwable -> L30
        if (r101 >= r103.length) goto L32;
        if (r103[r101] != null) goto L29;
        r102 = r102 + 1;     // Catch: Throwable -> L30
        if (r102 > this.f269224c) goto L32;
        cc7.b r104 = new cc7.b(this.f269227f);     // Catch: Throwable -> L30
        tb7.a.a("RequestQueue", "downloadDispatcher : " + r104.toString() + " create");     // Catch: Throwable -> L30
        this.f269229h[r101] = r104;     // Catch: Throwable -> L30
        ThreadMethodProxy.start(r104);     // Catch: Throwable -> L30
    L29:
        r101 = r101 + 1;
        goto L20
    }

    public final synchronized void c() {
        monitor-enter(this);
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return;
    L30:
        th = move-exception;
        throw th;
    L4:
        if (f269221p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        tb7.a.a("RequestQueue", "handleExpandRequestQueueSize");     // Catch: Throwable -> L26
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L26
        if (this.f269231j <= r100) goto L11;
        this.f269231j = r100;     // Catch: Throwable -> L26
    L11:
        if ((r100 - this.f269231j) > 1000) goto L15;
        tb7.a.a("RequestQueue", "handleExpandRequestQueueSize (now - mLastExpandRequestQueueTime) <= ApiThread.ENQUEUE_EXPIRE");     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L15:
        this.f269231j = r100;     // Catch: Throwable -> L26
        int r101 = 0;
        int r102 = 0;
    L16:
        cc7.a[] r103 = this.f269228g;     // Catch: Throwable -> L26
        if (r101 >= r103.length) goto L28;
        if (r103[r101] != null) goto L25;
        r102 = r102 + 1;     // Catch: Throwable -> L26
        if (r102 > this.f269223b) goto L28;
        cc7.a r104 = new cc7.a(this.f269226e, "Account-ApiDispatcher-Thread", "ApiDispatcher");     // Catch: Throwable -> L26
        tb7.a.a("RequestQueue", "apiDispatcher : " + r104.toString() + " create");     // Catch: Throwable -> L26
        this.f269228g[r101] = r104;     // Catch: Throwable -> L26
        ThreadMethodProxy.start(r104);     // Catch: Throwable -> L26
    L25:
        r101 = r101 + 1;
        goto L16
    }

    public final synchronized void d() {
        monitor-enter(this);
    L51:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L55
    L53:
        monitor-exit(this);
        return;
    L55:
        th = move-exception;
        throw th;
    L4:
        if (f269221p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        tb7.a.a("RequestQueue", "handleShrinkDownloadRequestQueueSize");     // Catch: Throwable -> L51
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L51
        if (this.f269234m <= r100) goto L11;
        this.f269234m = r100;     // Catch: Throwable -> L51
    L11:
        if ((r100 - this.f269234m) > 2000) goto L15;
        tb7.a.a("RequestQueue", "handleShrinkDownloadRequestQueueSize (now - mLastShrinkDownloadRequestQueueTime) <= ApiDispatcher.SHRINK_EXPIRE");     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L15:
        cc7.b[] r101 = this.f269229h;     // Catch: Throwable -> L51
        if (r101 != null) goto L19;
        monitor-exit(this);
        return;
    L19:
        int r102 = r101.length - 1;     // Catch: Throwable -> L51
        boolean r103 = true;
        boolean r104 = true;
    L21:
        if (r102 < this.f269224c) goto L30;
        cc7.b r105 = this.f269229h[r102];     // Catch: Throwable -> L51
        if (r105 != null) goto L25;
    L27:
        if (r105 == null) goto L29;
        r104 = false;
    L29:
        r102 = r102 - 1;     // Catch: Throwable -> L51
        goto L21
    L25:
        if (r105.f23317y == false) goto L27;
        r103 = false;
        goto L27
    L30:
        this.f269234m = r100;     // Catch: Throwable -> L51
        if (r103 == false) goto L48;
        if (r104 == true) goto L48;
        int r106 = this.f269229h.length - 1;     // Catch: Throwable -> L51
    L36:
        if (r106 < this.f269224c) goto L53;
        cc7.b r107 = this.f269229h[r106];     // Catch: Throwable -> L45
        if (r107 == null) goto L47;
        if (r107.getState() == Thread.State.RUNNABLE) goto L47;
        if (r107.f23317y == true) goto L47;
        tb7.a.a("RequestQueue", "apiDispatcher : " + r107.toString() + " quit");     // Catch: Throwable -> L45
        r107.f23316x = true;     // Catch: Throwable -> L45
        r107.interrupt();     // Catch: Throwable -> L45
        this.f269229h[r106] = null;     // Catch: Throwable -> L45
    L47:
        r106 = r106 - 1;     // Catch: Throwable -> L51
    L45:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L51
    L48:
        tb7.a.a("RequestQueue", "handleShrinkDownloadRequestQueueSize shouldShrink " + r103 + " allNull = " + r104);     // Catch: Throwable -> L51
        monitor-exit(this);
    }

    public final synchronized void e() {
        monitor-enter(this);
    L47:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L51
    L49:
        monitor-exit(this);
        return;
    L51:
        th = move-exception;
        throw th;
    L4:
        if (f269221p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        tb7.a.a("RequestQueue", "handleShrinkRequestQueueSize");     // Catch: Throwable -> L47
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L47
        if (this.f269233l <= r100) goto L11;
        this.f269233l = r100;     // Catch: Throwable -> L47
    L11:
        if ((r100 - this.f269233l) > 2000) goto L15;
        tb7.a.a("RequestQueue", "handleShrinkRequestQueueSize (now - mLastShrinkRequestQueueTime) <= ApiDispatcher.SHRINK_EXPIRE");     // Catch: Throwable -> L47
        monitor-exit(this);
        return;
    L15:
        int r101 = this.f269228g.length - 1;     // Catch: Throwable -> L47
        boolean r102 = true;
        boolean r103 = true;
    L17:
        if (r101 < this.f269223b) goto L26;
        cc7.a r104 = this.f269228g[r101];     // Catch: Throwable -> L47
        if (r104 != null) goto L21;
    L23:
        if (r104 == null) goto L25;
        r103 = false;
    L25:
        r101 = r101 - 1;     // Catch: Throwable -> L47
        goto L17
    L21:
        if (r104.f23317y == false) goto L23;
        r102 = false;
        goto L23
    L26:
        this.f269233l = r100;     // Catch: Throwable -> L47
        if (r102 == false) goto L44;
        if (r103 == true) goto L44;
        int r105 = this.f269228g.length - 1;     // Catch: Throwable -> L47
    L32:
        if (r105 < this.f269223b) goto L49;
        cc7.a r106 = this.f269228g[r105];     // Catch: Throwable -> L41
        if (r106 == null) goto L43;
        if (r106.getState() == Thread.State.RUNNABLE) goto L43;
        if (r106.f23317y == true) goto L43;
        tb7.a.a("RequestQueue", "apiDispatcher : " + r106.toString() + " quit");     // Catch: Throwable -> L41
        r106.f23316x = true;     // Catch: Throwable -> L41
        r106.interrupt();     // Catch: Throwable -> L41
        this.f269228g[r105] = null;     // Catch: Throwable -> L41
    L43:
        r105 = r105 - 1;     // Catch: Throwable -> L47
    L41:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L47
    L44:
        tb7.a.a("RequestQueue", "handleShrinkRequestQueueSize shouldShrink = " + r102 + " allNull = " + r103);     // Catch: Throwable -> L47
        monitor-exit(this);
    }

    public final synchronized void f() {
        monitor-enter(this);
        g();     // Catch: Throwable -> L15
        a r100 = new a(this.f269225d, this.f269226e);     // Catch: Throwable -> L15
        this.f269230i = r100;     // Catch: Throwable -> L15
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L15
        int r101 = 0;
        int r102 = 0;
    L5:
        if (r102 >= this.f269223b) goto L8;
        cc7.a r103 = new cc7.a(this.f269226e, "Account-ApiDispatcher-Thread", "ApiDispatcher");     // Catch: Throwable -> L15
        this.f269228g[r102] = r103;     // Catch: Throwable -> L15
        ThreadMethodProxy.start(r103);     // Catch: Throwable -> L15
        r102 = r102 + 1;     // Catch: Throwable -> L15
        goto L5
    L8:
        if (this.f269229h != null) goto L10;
    L12:
        this.f269222a = true;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L10:
        if (r101 >= this.f269224c) goto L12;
        cc7.b r104 = new cc7.b(this.f269227f);     // Catch: Throwable -> L15
        this.f269229h[r101] = r104;     // Catch: Throwable -> L15
        ThreadMethodProxy.start(r104);     // Catch: Throwable -> L15
        r101 = r101 + 1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void g() {
        monitor-enter(this);
        int r100 = 0;
        this.f269222a = false;     // Catch: Throwable -> L24
        a r101 = this.f269230i;     // Catch: Throwable -> L24
        if (r101 == null) goto L7;
        r101.f269211x = true;     // Catch: Throwable -> L24
        r101.interrupt();     // Catch: Throwable -> L24
    L7:
        int r102 = 0;
    L8:
        cc7.a[] r103 = this.f269228g;     // Catch: Throwable -> L24
        if (r102 >= r103.length) goto L15;
        cc7.a r104 = r103[r102];     // Catch: Throwable -> L24
        if (r104 == null) goto L13;
        r104.f23316x = true;     // Catch: Throwable -> L24
        r104.interrupt();     // Catch: Throwable -> L24
        this.f269228g[r102] = null;     // Catch: Throwable -> L24
    L13:
        r102 = r102 + 1;     // Catch: Throwable -> L24
        goto L8
    L15:
        if (this.f269229h == null) goto L22;
    L16:
        cc7.b[] r105 = this.f269229h;     // Catch: Throwable -> L24
        if (r100 >= r105.length) goto L22;
        cc7.b r106 = r105[r100];     // Catch: Throwable -> L24
        if (r106 == null) goto L21;
        r106.f23316x = true;     // Catch: Throwable -> L24
        r106.interrupt();     // Catch: Throwable -> L24
        this.f269229h[r100] = null;     // Catch: Throwable -> L24
    L21:
        r100 = r100 + 1;
    L22:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    static {
        f269219n = new AtomicInteger();
        f269221p = true;
    }

    public static c a() {
        if (f269220o != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f269220o != null) goto L9;
        f269220o = new c(0, false);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f269220o;
    }

    public c(int r100, boolean r101) {
        this.f269222a = false;
        this.f269225d = new PriorityBlockingQueue();
        this.f269226e = new PriorityBlockingQueue();
        this.f269227f = new PriorityBlockingQueue();
        this.f269231j = 0;
        this.f269232k = 0;
        this.f269233l = 0;
        this.f269234m = 0;
        this.f269223b = 4;
        this.f269228g = new cc7.a[16];
        if (r101 == false) goto L6;
        this.f269224c = r100;
        this.f269229h = new cc7.b[r100 * 4];
        return;
    }
}
