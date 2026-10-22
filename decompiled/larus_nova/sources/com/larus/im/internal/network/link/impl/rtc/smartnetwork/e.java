package com.larus.im.internal.network.link.impl.rtc.smartnetwork;

import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f349395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityBlockingQueue<Integer> f349396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f349397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f349398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PriorityBlockingQueue<Integer> f349399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f349400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PriorityBlockingQueue<Integer> f349401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f349402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f349403i;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f349404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f349405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f349406c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f349404a == r101.f349404a) goto L12;
            return false;
        L12:
            if (this.f349405b == r101.f349405b) goto L15;
            return false;
        L15:
            if (this.f349406c == r101.f349406c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f349404a * 31) + this.f349405b) * 31) + this.f349406c;
        }

        public final String toString() {
            return "Rtt(minRtt=" + this.f349404a + ", maxRtt=" + this.f349405b + ", avgRtt=" + this.f349406c + ')';
        }

        public b(int r100, int r101, int r102) {
            this.f349404a = r100;
            this.f349405b = r101;
            this.f349406c = r102;
        }
    }

    static {
    }

    public final synchronized void c() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.f349396b.isEmpty() == false) goto L6;
        int r100 = 0;
    L8:
        if (this.f349399e.isEmpty() == false) goto L10;
        int r101 = 0;
    L12:
        if (this.f349401g.isEmpty() == false) goto L14;
        int r102 = 0;
    L15:
        qd9.a.f532581a.c(r100, a(this.f349396b), r101, a(this.f349399e), r102, a(this.f349401g));     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L14:
        r102 = (int) (this.f349402h / ((long) this.f349401g.size()));     // Catch: Throwable -> L18
        goto L15
    L10:
        r101 = (int) (this.f349400f / ((long) this.f349399e.size()));     // Catch: Throwable -> L18
        goto L12
    L6:
        r100 = (int) (this.f349397c / ((long) this.f349396b.size()));     // Catch: Throwable -> L18
        goto L8
    }

    public e() {
        this.f349395a = new b(0, 0, 0);
        this.f349396b = new PriorityBlockingQueue();
        this.f349399e = new PriorityBlockingQueue();
        this.f349401g = new PriorityBlockingQueue();
    }

    public static int a(PriorityBlockingQueue r100) {
        if (r100.isEmpty() == false) goto L5;
        return 0;
    L5:
        int r101 = (int) (((double) r100.size()) * 0.95d);
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        r102 = r102 + 1;
        r100.poll();
        goto L6
    L8:
        Integer r103 = (Integer) r100.poll();
        if (r103 != null) goto L11;
        return 0;
    L11:
        return r103.intValue();
    }

    public final synchronized void b(int r100, int r110, int r111, int r112, int r113, int r114) {
        monitor-enter(this);
        fe9.a.f476620a.e("SmartNetwork", "rtcRttMonitor, wifiRtt (" + r100 + ", " + r110 + ", " + r111 + ") cellRtt (" + r112 + ", " + r113 + ", " + r114 + ')');     // Catch: Throwable -> L29
        if (r112 == 0) goto L24;
        if (r113 == 0) goto L24;
        if (r114 == 0) goto L24;
        this.f349398d = r110;     // Catch: Throwable -> L29
        if (this.f349399e.isEmpty() == false) goto L12;
        b r101 = new b(Math.max(this.f349395a.f349404a, r100), Math.max(this.f349395a.f349405b, r110), Math.max(this.f349395a.f349406c, r111));     // Catch: Throwable -> L29
    L14:
        if (this.f349399e.size() > 900) goto L17;
        this.f349399e.add(Integer.valueOf(r111));     // Catch: Throwable -> L29
        this.f349400f += (long) r111;     // Catch: Throwable -> L29
    L17:
        if (this.f349401g.size() > 900) goto L19;
        this.f349401g.add(Integer.valueOf(r114));     // Catch: Throwable -> L29
        this.f349402h += (long) r114;     // Catch: Throwable -> L29
    L19:
        int r102 = this.f349403i;     // Catch: Throwable -> L29
        if (r102 >= 20) goto L22;
        qd9.a.f532581a.b(r101.f349404a, r101.f349405b, r101.f349406c, r112, r113, r114, r102);     // Catch: Throwable -> L29
        this.f349403i++;     // Catch: Throwable -> L29
    L22:
        monitor-exit(this);
        return;
    L12:
        r101 = new b(r100, r110, r111);     // Catch: Throwable -> L29
    L24:
        this.f349395a = new b(r100, r110, r111);     // Catch: Throwable -> L29
        if (this.f349396b.size() > 900) goto L27;
        this.f349396b.add(Integer.valueOf(r111));     // Catch: Throwable -> L29
        this.f349397c += (long) r111;     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);
        return;
    L29:
        th = move-exception;
        throw th;
    }
}
