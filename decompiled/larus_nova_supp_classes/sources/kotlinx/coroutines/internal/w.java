package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class w<T> {
    private volatile AtomicReferenceArray<T> array;

    public final int a() {
        return this.array.length();
    }

    public w(int r2) {
        this.array = new AtomicReferenceArray(r2);
    }

    public final T b(int r3) {
        AtomicReferenceArray<T> r0 = this.array;
        if (r3 < r0.length()) goto L7;
        return null;
    L7:
        return r0.get(r3);
    }

    public final void c(int r6, CoroutineScheduler.c r7) {
        AtomicReferenceArray<T> r0 = this.array;
        int r1 = r0.length();
        if (r6 >= r1) goto L6;
        r0.set(r6, r7);
        return;
    L6:
        AtomicReferenceArray<T> r2 = new AtomicReferenceArray(RangesKt.coerceAtLeast(r6 + 1, r1 * 2));
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r2.set(r3, r0.get(r3));
        r3 = r3 + 1;
        goto L7
    L9:
        r2.set(r6, r7);
        this.array = r2;
    }
}
