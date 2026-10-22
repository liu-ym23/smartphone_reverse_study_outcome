package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.observers.k;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes41.dex */
public final class j {
    public static void e(wwc.c r100, int r101) {
        if (r101 >= 0) goto L4;
        long r102 = Long.MAX_VALUE;
    L5:
        r100.request(r102);
        return;
    L4:
        r102 = r101;
        goto L5
    }

    public static void b(vtc.i r110, Observer r111, Disposable r112, h r113) {
        int r100 = 1;
    L4:
        if (a(((k) r113).f492893e, r110.isEmpty(), r111, r110, r112, r113) == true) goto L5;
    L6:
        k r101 = (k) r113;
        boolean r102 = r101.f492893e;
        Object r103 = r110.poll();
        if (r103 != null) goto L9;
        boolean r114 = true;
    L11:
        if (a(r102, r114, r111, r110, r112, r113) == true) goto L12;
        if (r114 == true) goto L14;
        r113.b(r111, r103);
        goto L6
    L14:
        r100 = r101.n(-r100);
        if (r100 != 0) goto L4;
        return;
    L12:
        return;
    L9:
        r114 = false;
        goto L11
    }

    public static void c(vtc.i r100, wwc.b r110, Disposable r111, i r112) {
        int r101 = 1;
    L3:
        io.reactivex.internal.subscribers.h r102 = (io.reactivex.internal.subscribers.h) r112;
        boolean r103 = r102.f495032f;
        Object r104 = r100.poll();
        boolean r105 = false;
        if (r104 != null) goto L6;
        boolean r106 = true;
    L8:
        if (r102.f495031e == false) goto L10;
        r100.clear();
    L16:
        r105 = true;
    L17:
        if (r105 == true) goto L18;
        if (r106 == true) goto L22;
        long r107 = r102.u();
        if (r107 == 0) goto L32;
        if (r112.b(r110, r104) == false) goto L3;
        if (r107 == Long.MAX_VALUE) goto L3;
        r102.q(1);
        goto L3
    L32:
        r100.clear();
        if (r111 == null) goto L35;
        r111.dispose();
    L35:
        r110.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
        return;
    L22:
        r101 = r102.n(-r101);
        if (r101 != 0) goto L3;
        return;
    L18:
        if (r111 == null) goto L49;
        r111.dispose();
        return;
    L49:
        return;
    L10:
        if (r103 == false) goto L17;
        Throwable r108 = r102.f495033g;
        if (r108 == null) goto L14;
        r100.clear();
        r110.onError(r108);
        goto L16
    L14:
        if (r106 == false) goto L17;
        r110.onComplete();
        goto L16
    L6:
        r106 = false;
        goto L8
    }

    public static <T> boolean d(long r100, wwc.b<? super T> r110, Queue<T> r111, AtomicLong r112, ttc.b r113) {
        long r101 = r100 & Long.MIN_VALUE;
    L4:
        if (r101 != r100) goto L35;
        boolean r102 = r113.getAsBoolean();     // Catch: Throwable -> L18
    L20:
        if (r102 == true) goto L21;
        if (r111.isEmpty() == true) goto L24;
        r100 = r112.get();
        if (r100 != r101) goto L4;
        long r103 = r112.addAndGet(-(r101 & Long.MAX_VALUE));
        if ((Long.MAX_VALUE & r103) == 0) goto L30;
        r100 = r103;
        r101 = r103 & Long.MIN_VALUE;
        goto L4
    L30:
        return false;
    L24:
        r110.onComplete();
        return true;
    L21:
        return true;
    L18:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r102 = true;
        goto L20
    L35:
        boolean r104 = r113.getAsBoolean();     // Catch: Throwable -> L7
    L9:
        if (r104 == true) goto L10;
        T r105 = r111.poll();
        if (r105 == null) goto L13;
        r110.onNext(r105);
        r101 = r101 + 1;
        goto L4
    L13:
        r110.onComplete();
        return true;
    L10:
        return true;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r104 = true;
        goto L9
    }

    public static boolean a(boolean r100, boolean r101, Observer r102, vtc.j r103, Disposable r104, h r105) {
        k r106 = (k) r105;
        if (r106.f492892d == false) goto L6;
        r103.clear();
        r104.dispose();
        return true;
    L6:
        if (r100 == false) goto L19;
        Throwable r107 = r106.f492894f;
        if (r107 == null) goto L14;
        r103.clear();
        if (r104 == null) goto L12;
        r104.dispose();
    L12:
        r102.onError(r107);
        return true;
    L14:
        if (r101 == false) goto L21;
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        r102.onComplete();
        return true;
    L21:
        return false;
    L19:
        return false;
    }
}
