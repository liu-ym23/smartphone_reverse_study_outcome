package jv;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f500536b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Subject<Object> f500537a;

    public static a a() {
        if (f500536b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f500536b != null) goto L9;
        f500536b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f500536b;
    }

    public a() {
        this.f500537a = PublishSubject.create().toSerialized();
    }

    public final void b(Object r100) {
        this.f500537a.onNext(r100);
    }

    public final <T> Observable<T> c(Class<T> r100) {
        return this.f500537a.ofType(r100).observeOn(AndroidSchedulers.mainThread());
    }
}
