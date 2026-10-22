package mp3;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c<T> {
    public final CopyOnWriteArrayList<Function1<T, Unit>> a;
    public final c<T> b;
    public T c;
    public boolean d;
    public final Function0<T> e;

    public c() {
        throw null;
    }

    public final T a() {
        c<T> r0 = this.b;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.d == false) goto L9;
        T r1 = this.c;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return r1;
    L9:
        T r2 = (T) this.e.invoke();
        this.c = r2;     // Catch: Throwable -> L12
        b(r2);     // Catch: Throwable -> L12
        T r3 = this.c;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return r3;
    }

    public c(Function0 r3) {
        Scheduler r0 = Schedulers.computation();
        Intrinsics.checkNotNullParameter(r3, "initializer");
        Intrinsics.checkNotNullParameter(r0, "scheduler");
        this.e = r3;
        this.a = new CopyOnWriteArrayList();
        this.b = this;
        r0.scheduleDirect(new b(this));
    }

    public final void b(T r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function1) r0.next()).invoke(r3);
        goto L4
    L6:
        this.a.clear();
        this.d = true;
    }
}
