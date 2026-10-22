package yu3;

import av3.b;
import java.util.concurrent.ConcurrentLinkedQueue;
import nu3.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f569219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<T> f569220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC8387a<T> f569221c;

    /* JADX INFO: renamed from: yu3.a$a, reason: collision with other inner class name */
    public interface InterfaceC8387a<T> {
    }

    public final boolean a() {
        return this.f569220b.isEmpty();
    }

    public final T b() {
        return this.f569220b.poll();
    }

    public a(int r100) {
        this.f569220b = new ConcurrentLinkedQueue();
        this.f569219a = r100;
    }

    public final void c(T r100) {
        this.f569220b.add(r100);
        if (this.f569220b.size() <= this.f569219a) goto L10;
        T r101 = this.f569220b.poll();
        InterfaceC8387a<T> r102 = this.f569221c;
        if (r102 == null) goto L11;
        ((jt3.a.C6484a) r102).getClass();
        c r103 = (c) r101;
        if (jt3.a.f500291e == false) goto L12;
        b.b("APM-CommonEvent", "evicted Monitorable " + r103);
        return;
    L12:
        return;
    L11:
        return;
    }
}
