package com.bytedance.tools.kcp.modelx.runtime.internal;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes22.dex */
public final class c<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a<?> f270954d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<V> f270955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f270956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f270957c;

    static {
        f270954d = new a(0, 0.8f);
    }

    public c() {
        this.f270955a = (a<V>) f270954d;
        this.f270956b = true;
        this.f270957c = new ReentrantLock();
    }

    public final V b(int r110) {
        a<V> r100 = this.f270955a;
        if (r100 != f270954d) goto L5;
        return null;
    L5:
        if (r110 == 0) goto L7;
        int r101 = r100.f270948d;
        int[] r102 = r100.f270949e;
        V[] r103 = r100.f270950f;
        int r104 = (int) ((((long) r110) * (-7046029254386353131L)) >>> r100.f270947c);
    L11:
        int r105 = r102[r104];
        if (r105 == 0) goto L13;
        if (r105 == r110) goto L16;
        r104 = (r104 + 1) & r101;
        goto L11
    L16:
        return r103[r104];
    L13:
        return null;
    L7:
        if (r100.f270953i == true) goto L9;
        return null;
    L9:
        return r100.f270952h;
    }

    public static a a(a r110, int r111) {
        int[] r100 = r110.f270949e;
        int r101 = r100.length;
        V[] r102 = r110.f270950f;
        a r103 = new a(r111, r110.f270945a);
        if (r110.f270951g > 0) goto L5;
    L18:
        return r103;
    L5:
        if (r110.f270953i == false) goto L7;
        r103.f270953i = true;
        r103.f270952h = r110.f270952h;
    L7:
        int r112 = 0;
    L8:
        if (r112 >= r101) goto L17;
        int r104 = r100[r112];
        if (r104 == 0) goto L16;
        V r105 = r102[r112];
        int[] r106 = r103.f270949e;
        V[] r107 = r103.f270950f;
        int r108 = (int) ((((long) r104) * (-7046029254386353131L)) >>> r103.f270947c);
    L13:
        if (r106[r108] == 0) goto L14;
        r108 = (r108 + 1) & r103.f270948d;
        goto L13
    L14:
        r106[r108] = r104;
        r107[r108] = r105;
    L16:
        r112 = r112 + 1;
        goto L8
    L17:
        r103.f270951g = r110.f270951g;
        goto L18
    }

    public final void c(int r100, V r110) {
        boolean r101 = this.f270956b;
        if (r101 == false) goto L40;
        this.f270957c.lock();
    L40:
    L36:
        th = move-exception;
        if (r101 == false) goto L39;
        this.f270957c.unlock();
    L39:
        throw th;
    L6:
        if (this.f270955a != f270954d) goto L8;
        this.f270955a = new a(4, 0.8f);     // Catch: Throwable -> L36
    L8:
        a<V> r102 = this.f270955a;     // Catch: Throwable -> L36
        if (r100 != 0) goto L16;
        r102.f270952h = r110;     // Catch: Throwable -> L36
        if (r102.f270953i == true) goto L13;
        r102.f270953i = true;     // Catch: Throwable -> L36
        r102.f270951g++;     // Catch: Throwable -> L36
    L13:
        if (r101 == false) goto L43;
        this.f270957c.unlock();
        return;
    L43:
        return;
    L16:
        int[] r103 = r102.f270949e;     // Catch: Throwable -> L36
        int r104 = (int) ((((long) r100) * (-7046029254386353131L)) >>> r102.f270947c);     // Catch: Throwable -> L36
    L17:
        int r105 = r103[r104];     // Catch: Throwable -> L36
        if (r105 == 0) goto L19;
        if (r105 == r100) goto L21;
        r104 = (r104 + 1) & r102.f270948d;
    L21:
        if (r104 < 0) goto L26;
        r102.f270950f[r104] = r110;     // Catch: Throwable -> L36
        if (r101 == false) goto L44;
        this.f270957c.unlock();
        return;
    L44:
        return;
    L26:
        int r106 = -(r104 + 1);
        int[] r107 = r102.f270949e;     // Catch: Throwable -> L36
        r107[r106] = r100;     // Catch: Throwable -> L36
        r102.f270950f[r106] = r110;     // Catch: Throwable -> L36
        int r108 = r102.f270951g + 1;     // Catch: Throwable -> L36
        r102.f270951g = r108;     // Catch: Throwable -> L36
        if (r108 < r102.f270946b) goto L30;
        this.f270955a = a(r102, r107.length << 1);     // Catch: Throwable -> L36
    L30:
        if (r101 == false) goto L45;
        this.f270957c.unlock();
        return;
    L45:
        return;
    L19:
        r104 = -(r104 + 1);
        goto L21
    }
}
