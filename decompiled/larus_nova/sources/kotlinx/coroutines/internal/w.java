package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: loaded from: classes.dex */
public final class w<T> {
    private volatile AtomicReferenceArray<T> array;

    public final int a() {
        return this.array.length();
    }

    public w(int r100) {
        this.array = new AtomicReferenceArray(r100);
    }

    public final T b(int r100) {
        AtomicReferenceArray<T> r101 = this.array;
        if (r100 < r101.length()) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public final void c(int r100, CoroutineScheduler.c r101) {
        AtomicReferenceArray<T> r102 = this.array;
        int r103 = r102.length();
        if (r100 >= r103) goto L6;
        r102.set(r100, r101);
        return;
    L6:
        AtomicReferenceArray<T> r104 = new AtomicReferenceArray(RangesKt.coerceAtLeast(r100 + 1, r103 * 2));
        int r105 = 0;
    L7:
        if (r105 >= r103) goto L9;
        r104.set(r105, r102.get(r105));
        r105 = r105 + 1;
        goto L7
    L9:
        r104.set(r100, r101);
        this.array = r104;
    }
}
