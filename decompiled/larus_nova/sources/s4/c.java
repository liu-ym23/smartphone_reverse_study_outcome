package s4;

import androidx.core.util.Consumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Consumer<T>> f540526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<T> f540527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f540528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f540529d;

    public final void a() {
        this.f540529d = true;
        c();
        this.f540526a.set(null);
    }

    public final void c() {
        if (this.f540526a.get() != null) goto L6;
        return;
    L6:
        if (this.f540528c.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if ((!this.f540527b.isEmpty()) == false) goto L14;
        T r100 = this.f540527b.poll();
        if (r100 == null) goto L8;
        Consumer<T> r101 = this.f540526a.get();
        if (r101 == null) goto L8;
        r101.accept(r100);
        goto L8
    L14:
        this.f540528c.set(false);
    }

    public c() {
        this.f540526a = new AtomicReference();
        this.f540527b = new ConcurrentLinkedQueue();
        this.f540528c = new AtomicBoolean(false);
    }

    public final void b(T r100) {
        if (this.f540529d == false) goto L5;
        return;
    L5:
        this.f540527b.offer(r100);
        c();
    }

    public final void d(Consumer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        if (this.f540529d == false) goto L5;
        return;
    L5:
        AtomicReference<Consumer<T>> r101 = this.f540526a;
    L7:
        if (r101.compareAndSet(null, r100) == true) goto L8;
        if (r101.get() == null) goto L7;
        boolean r102 = false;
    L12:
        if (r102 == false) goto L18;
        c();
        return;
    L18:
        return;
    L8:
        r102 = true;
        goto L12
    }
}
