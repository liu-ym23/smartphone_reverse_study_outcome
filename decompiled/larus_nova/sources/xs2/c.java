package xs2;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, c> f564944b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Subject<Object> f564945a;

    static {
        f564944b = new ConcurrentHashMap();
    }

    public c() {
        this.f564945a = PublishSubject.create().toSerialized();
    }

    public static c a(String r100) {
        Map<String, c> r101 = f564944b;
        c r102 = (c) ((ConcurrentHashMap) r101).get(r100);
        if (r102 == null) goto L5;
    L15:
        return r102;
    L5:
        monitor-enter(c.class);
        r102 = (c) ((ConcurrentHashMap) r101).get(r100);     // Catch: Throwable -> L13
        if (r102 != null) goto L9;
        r102 = new c();     // Catch: Throwable -> L13
        ((ConcurrentHashMap) r101).put(r100, r102);     // Catch: Throwable -> L13
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // xs2.a
    public final <T> Observable<T> b(Class<T> r100) {
        return this.f564945a.ofType(r100).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // xs2.a
    public final void post(Object r100) {
        this.f564945a.onNext(r100);
    }
}
