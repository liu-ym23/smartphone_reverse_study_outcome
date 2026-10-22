package mp3;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function1<T, Unit>> f514710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<T> f514711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f514712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f514713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<T> f514714e;

    public c() {
        throw null;
    }

    public final T a() {
        c<T> r100 = this.f514711b;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f514713d == false) goto L9;
        T r101 = this.f514712c;     // Catch: Throwable -> L12
        monitor-exit(r100);
        return r101;
    L9:
        T r102 = this.f514714e.invoke();     // Catch: Throwable -> L12
        this.f514712c = r102;     // Catch: Throwable -> L12
        b(r102);     // Catch: Throwable -> L12
        T r103 = this.f514712c;     // Catch: Throwable -> L12
        monitor-exit(r100);
        return r103;
    }

    public c(Function0 r100) {
        Scheduler r101 = Schedulers.computation();
        Intrinsics.checkNotNullParameter(r100, "initializer");
        Intrinsics.checkNotNullParameter(r101, "scheduler");
        this.f514714e = r100;
        this.f514710a = new CopyOnWriteArrayList();
        this.f514711b = this;
        r101.scheduleDirect(new b(this));
    }

    public final void b(T r100) {
        Iterator<T> r101 = this.f514710a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function1) r101.next()).invoke(r100);
        goto L4
    L6:
        this.f514710a.clear();
        this.f514713d = true;
    }
}
