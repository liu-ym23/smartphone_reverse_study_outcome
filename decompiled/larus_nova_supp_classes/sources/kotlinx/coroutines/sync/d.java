package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static final int a = 0;
    public static final b0 b = null;
    public static final b0 c = null;
    public static final b0 d = null;
    public static final b0 e = null;
    public static final int f = 0;

    static {
        a = c0.b("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12);
        b = new b0("PERMIT");
        c = new b0("TAKEN");
        d = new b0("BROKEN");
        e = new b0("CANCELLED");
        f = c0.b("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12);
    }
}
