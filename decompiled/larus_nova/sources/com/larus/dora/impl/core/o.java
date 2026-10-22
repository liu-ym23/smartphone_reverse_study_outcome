package com.larus.dora.impl.core;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f332220a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<l> f332221b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f332222c = null;

    public o() {
    }

    static {
        f332220a = new AtomicInteger(0);
        f332221b = new CopyOnWriteArraySet();
        f332222c = new AtomicBoolean(false);
    }

    public static final void a(int r100, int r101) {
        int r102 = r100 ^ r101;
        if (r102 == 0) goto L76;
        Iterator<l> r103 = f332221b.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r103.next().onBtStateChanged(r100, r101);
        goto L7
    L9:
        boolean r104 = false;
        if ((r102 & 1) == 0) goto L20;
        if ((r101 & 1) == 0) goto L14;
        boolean r105 = true;
    L15:
        Iterator<l> r106 = f332221b.iterator();
    L17:
        if (r106.hasNext() == false) goto L20;
        r106.next().f(r105);
        goto L17
    L14:
        r105 = false;
    L20:
        if ((r102 & 2) == 0) goto L30;
        if ((r101 & 2) == 0) goto L24;
        boolean r107 = true;
    L25:
        Iterator<l> r108 = f332221b.iterator();
    L27:
        if (r108.hasNext() == false) goto L30;
        r108.next().c(r107);
        goto L27
    L24:
        r107 = false;
    L30:
        if ((r102 & 4) == 0) goto L40;
        if ((r101 & 4) == 0) goto L34;
        boolean r109 = true;
    L35:
        Iterator<l> r110 = f332221b.iterator();
    L37:
        if (r110.hasNext() == false) goto L40;
        r110.next().e(r109);
        goto L37
    L34:
        r109 = false;
    L40:
        if ((r102 & 8) == 0) goto L50;
        if ((r101 & 8) == 0) goto L44;
        boolean r111 = true;
    L45:
        Iterator<l> r112 = f332221b.iterator();
    L47:
        if (r112.hasNext() == false) goto L50;
        r112.next().b(r111);
        goto L47
    L44:
        r111 = false;
    L50:
        if ((r102 & 16) == 0) goto L60;
        if ((r101 & 16) == 0) goto L54;
        boolean r113 = true;
    L55:
        Iterator<l> r114 = f332221b.iterator();
    L57:
        if (r114.hasNext() == false) goto L60;
        r114.next().d(r113);
        goto L57
    L54:
        r113 = false;
    L60:
        if ((r102 & 32) != 0) goto L62;
        return;
    L62:
        if ((r101 & 32) == 0) goto L64;
        r104 = true;
    L64:
        Iterator<l> r115 = f332221b.iterator();
    L66:
        if (r115.hasNext() == false) goto L77;
        r115.next().a(r104);
        goto L66
    L77:
        return;
    }
}
