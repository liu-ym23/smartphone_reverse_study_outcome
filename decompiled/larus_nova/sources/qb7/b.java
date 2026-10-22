package qb7;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f532405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f532406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<a<T>> f532407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c<T> f532408d;

    public abstract String b();

    public abstract void d();

    public static c a() {
        c r100 = new c();
        r100.f532409a = -1;
        r100.f532410b = "empty result";
        return r100;
    }

    public b() {
        this.f532405a = new AtomicBoolean(false);
        this.f532407c = new CopyOnWriteArrayList();
    }

    public final void c(c<T> r100) {
        if (this.f532406b == false) goto L5;
        return;
    L5:
        this.f532408d = r100;
        boolean r101 = true;
        this.f532406b = true;
        CopyOnWriteArrayList<a<T>> r102 = this.f532407c;
        monitor-enter(r102);
        Iterator<a<T>> r103 = this.f532407c.iterator();     // Catch: Throwable -> L19
    L9:
        if (r103.hasNext() == false) goto L11;
        r103.next().onFinish();     // Catch: Throwable -> L19
        goto L9
    L11:
        this.f532407c.clear();     // Catch: Throwable -> L19
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r102);
        String r105 = b();
        StringBuilder r106 = new StringBuilder("notifyInitFinish, error=");
        r106.append(r100.f532409a);
        r106.append(", errorMsg=");
        r106.append(r100.f532410b);
        r106.append(", data is null=");
        if (r100.f532411c == null) goto L17;
        r101 = false;
    L17:
        r106.append(r101);
        tb7.a.d(r105, r106.toString());
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void e(a<T> r100) {
        if (this.f532406b == true) goto L5;
        CopyOnWriteArrayList<a<T>> r101 = this.f532407c;
        monitor-enter(r101);
    L34:
        th = move-exception;
        throw th;
    L12:
        if (this.f532406b == true) goto L14;
        this.f532407c.add(r100);     // Catch: Throwable -> L34
        monitor-exit(r101);
    L23:
        if (this.f532405a.compareAndSet(false, true) == false) goto L40;
        tb7.a.d(b(), "tryInit start");
        d();     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        tb7.a.c(b(), "tryInit error", e);
        c<T> r102 = new c();
        r102.f532409a = -100;
        String r103 = e.getMessage();
        if (r103 != null) goto L32;
        r103 = "";
    L32:
        r102.f532410b = r103;
        c(r102);
        return;
    L40:
        return;
    L14:
        if (this.f532408d != null) goto L17;
        a();     // Catch: Throwable -> L34
    L17:
        r100.onFinish();     // Catch: Throwable -> L34
        monitor-exit(r101);
        goto L23
    L5:
        if (this.f532408d != null) goto L8;
        a();
    L8:
        r100.onFinish();
        goto L23
    }
}
