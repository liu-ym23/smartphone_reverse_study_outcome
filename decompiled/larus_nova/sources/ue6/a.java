package ue6;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f549807a = null;

    /* JADX INFO: renamed from: ue6.a$a, reason: collision with other inner class name */
    public static final class C7870a {
        public static long a() {
            AtomicLong r100 = a.f549807a;
            long r101 = r100.incrementAndGet();
            if (r101 < 9223372036854775707L) goto L14;
            monitor-enter(r100);
        L11:
            th = move-exception;
            throw th;
        L6:
            if (r100.get() < 9223372036854775707L) goto L8;
            r100.set(100);     // Catch: Throwable -> L11
        L8:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r100);
        L14:
            return r101;
        }
    }

    static {
        f549807a = new AtomicLong(100);
    }
}
