package xs2;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f564942b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Subject<Object> f564943a;

    public static b a() {
        if (f564942b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f564942b != null) goto L9;
        f564942b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f564942b;
    }

    public b() {
        new ConcurrentHashMap();
        this.f564943a = PublishSubject.create().toSerialized();
    }

    @Override // xs2.a
    public final <T> Observable<T> b(Class<T> r100) {
        return this.f564943a.ofType(r100).observeOn(AndroidSchedulers.mainThread());
    }

    public final <T> Observable<T> c(Class<T> r100) {
        return (Observable<T>) this.f564943a.ofType(r100);
    }

    @Override // xs2.a
    public final void post(Object r100) {
        this.f564943a.onNext(r100);
    }
}
