package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes41.dex */
public final class c<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableSource<T> f494279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f494280b;

    public static final class a<T> extends io.reactivex.observers.a<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile Object f494281b;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.c$a$a, reason: collision with other inner class name */
        public final class C6325a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f494282a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f494283b;

            @Override // java.util.Iterator
            public final T next() {
            L17:
                th = move-exception;
                this.f494282a = null;
                throw th;
            L4:
                if (this.f494282a != null) goto L7;
                this.f494282a = this.f494283b.f494281b;     // Catch: Throwable -> L17
            L7:
                if (NotificationLite.isComplete(this.f494282a) == true) goto L16;
                if (NotificationLite.isError(this.f494282a) == true) goto L14;
                T r100 = (T) NotificationLite.getValue(this.f494282a);
                this.f494282a = null;
                return r100;
            L14:
                throw ExceptionHelper.d(NotificationLite.getError(this.f494282a));     // Catch: Throwable -> L17
            L16:
                throw new NoSuchElementException();     // Catch: Throwable -> L17
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                Object r100 = this.f494283b.f494281b;
                this.f494282a = r100;
                return !NotificationLite.isComplete(r100);
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }

            public C6325a(a r100) {
                this.f494283b = r100;
            }
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494281b = NotificationLite.complete();
        }

        public a(T r100) {
            this.f494281b = NotificationLite.next(r100);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494281b = NotificationLite.error(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            this.f494281b = NotificationLite.next(r100);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        a r100 = new a(this.f494280b);
        this.f494279a.subscribe(r100);
        return new a.C6325a(r100);
    }

    public c(ObservableSource<T> r100, T r101) {
        this.f494279a = r100;
        this.f494280b = r101;
    }
}
