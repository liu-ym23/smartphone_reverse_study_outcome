package io.reactivex.internal.util;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static long c(long r100, long r101) {
        long r102 = r100 + r101;
        if (r102 >= 0) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r102;
    }

    public static long a(AtomicLong r100, long r101) {
    L2:
        long r102 = r100.get();
        if (r102 == Long.MAX_VALUE) goto L4;
        if (r100.compareAndSet(r102, c(r102, r101)) == false) goto L2;
        return r102;
    L4:
        return Long.MAX_VALUE;
    }

    public static long b(AtomicLong r100, long r101) {
    L2:
        long r102 = r100.get();
        if (r102 == Long.MIN_VALUE) goto L4;
        if (r102 == Long.MAX_VALUE) goto L7;
        if (r100.compareAndSet(r102, c(r102, r101)) == false) goto L2;
        return r102;
    L7:
        return Long.MAX_VALUE;
    L4:
        return Long.MIN_VALUE;
    }

    public static long d(long r100, long r101) {
        long r102 = r100 * r101;
        if (((r100 | r101) >>> 31) != 0) goto L5;
    L8:
        return r102;
    L5:
        if ((r102 / r100) == r101) goto L8;
        return Long.MAX_VALUE;
    }

    public static void e(AtomicLong r100, long r110) {
    L2:
        long r101 = r100.get();
        if (r101 == Long.MAX_VALUE) goto L4;
        long r102 = r101 - r110;
        if (r102 >= 0) goto L9;
        RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + r102));
        r102 = 0;
    L9:
        if (r100.compareAndSet(r101, r102) == false) goto L2;
        return;
    }

    public static long f(AtomicLong r100, long r110) {
    L2:
        long r101 = r100.get();
        if (r101 == Long.MIN_VALUE) goto L4;
        if (r101 == Long.MAX_VALUE) goto L7;
        long r102 = r101 - r110;
        if (r102 >= 0) goto L12;
        RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + r102));
        r102 = 0;
    L12:
        if (r100.compareAndSet(r101, r102) == false) goto L2;
        return r102;
    L7:
        return Long.MAX_VALUE;
    L4:
        return Long.MIN_VALUE;
    }
}
