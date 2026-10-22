package qn;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<T> f533978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<T> f533979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f533980c;

    public a() {
        this(1);
    }

    public void c() {
    }

    public a(int r100) {
        this.f533980c = r100;
        this.f533978a = new LinkedBlockingQueue();
        this.f533979b = new LinkedHashSet();
    }

    public final synchronized T a(Function0<? extends T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "resourceGenerator");     // Catch: Throwable -> L11
        int r101 = RangesKt.coerceAtLeast(this.f533980c, 1);     // Catch: Throwable -> L11
        if (this.f533978a.size() < r101) goto L8;
        T r102 = this.f533978a.poll();     // Catch: Throwable -> L11
        this.f533979b.add(r102);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        T r103 = r100.invoke();     // Catch: Throwable -> L11
        this.f533979b.add(r103);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(T r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f533979b.remove(r100) == false) goto L6;
        this.f533978a.offer(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }
}
