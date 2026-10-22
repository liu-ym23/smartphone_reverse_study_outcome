package com.bytedance.locallife.common.utils;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f257135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f257136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f257137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f257138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f257139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f257140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f257141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f257142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n f257143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f257144j;

    public interface a {
        void onFinish();

        void onStart();

        void onTick();
    }

    @Override // com.bytedance.locallife.common.utils.n.a
    public final void a() {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L4:
        if (this.f257139e == false) goto L6;
    L30:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L6:
        if (this.f257142h == true) goto L30;
        long r100 = this.f257137c - SystemClock.elapsedRealtime();     // Catch: Throwable -> L32
        long r101 = 0;
        if (r100 > 0) goto L13;
        this.f257140f = true;     // Catch: Throwable -> L32
        this.f257141g = false;     // Catch: Throwable -> L32
        a r102 = this.f257144j;     // Catch: Throwable -> L32
        if (r102 == null) goto L28;
        r102.onFinish();     // Catch: Throwable -> L32
    L28:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L13:
        long r103 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L32
        a r104 = this.f257144j;     // Catch: Throwable -> L32
        if (r104 == null) goto L16;
        r104.onTick();     // Catch: Throwable -> L32
    L16:
        long r105 = SystemClock.elapsedRealtime() - r103;     // Catch: Throwable -> L32
        long r106 = this.f257136b;     // Catch: Throwable -> L32
        if (r100 >= r106) goto L22;
        long r107 = r100 - r105;     // Catch: Throwable -> L32
        if (r107 < 0) goto L27;
        r101 = r107;
    L27:
        n r108 = this.f257143i;     // Catch: Throwable -> L32
        r108.sendMessageDelayed(r108.obtainMessage(1), r101);     // Catch: Throwable -> L32
        goto L28
    L22:
        long r109 = r106 - r105;     // Catch: Throwable -> L32
    L24:
        if (r109 >= 0) goto L26;
        r109 = r109 + this.f257136b;     // Catch: Throwable -> L32
        goto L24
    L26:
        r101 = r109;
        goto L27
    }

    public final synchronized boolean b() {
        monitor-enter(this);
        boolean r100 = this.f257139e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c() {
        monitor-enter(this);
        boolean r100 = this.f257140f;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void d() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f257142h == false) goto L6;
        this.f257142h = false;     // Catch: Throwable -> L8
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        long r101 = this.f257138d;     // Catch: Throwable -> L8
        this.f257137c = r100 + r101;     // Catch: Throwable -> L8
        long r102 = this.f257135a - r101;     // Catch: Throwable -> L8
        long r103 = this.f257136b;     // Catch: Throwable -> L8
        long r104 = r103 - (r102 % r103);     // Catch: Throwable -> L8
        n r105 = this.f257143i;     // Catch: Throwable -> L8
        r105.sendMessageDelayed(r105.obtainMessage(1), r104);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void e() {
        monitor-enter(this);
        this.f257142h = false;     // Catch: Throwable -> L17
        this.f257139e = false;     // Catch: Throwable -> L17
        this.f257140f = false;     // Catch: Throwable -> L17
        this.f257141g = true;     // Catch: Throwable -> L17
        if (this.f257135a > 0) goto L11;
        this.f257140f = true;     // Catch: Throwable -> L17
        this.f257141g = false;     // Catch: Throwable -> L17
        a r100 = this.f257144j;     // Catch: Throwable -> L17
        if (r100 == null) goto L9;
        r100.onFinish();     // Catch: Throwable -> L17
    L9:
        monitor-exit(this);
        return;
    L11:
        a r101 = this.f257144j;     // Catch: Throwable -> L17
        if (r101 == null) goto L14;
        r101.onStart();     // Catch: Throwable -> L17
    L14:
        this.f257137c = SystemClock.elapsedRealtime() + this.f257135a;     // Catch: Throwable -> L17
        n r102 = this.f257143i;     // Catch: Throwable -> L17
        r102.sendMessage(r102.obtainMessage(1));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public c(long r100, long r101, a r102) {
        this.f257139e = false;
        this.f257140f = false;
        this.f257141g = false;
        this.f257142h = false;
        this.f257135a = r100;
        this.f257136b = r101;
        this.f257143i = new n(this);
        this.f257144j = r102;
    }
}
