package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class i2<T> extends io.reactivex.internal.operators.observable.a<T, io.reactivex.schedulers.a<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f494393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f494394c;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super io.reactivex.schedulers.a<T>> f494395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TimeUnit f494396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Scheduler f494397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f494398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Disposable f494399e;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494399e.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494399e.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494395a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494395a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            long r101 = this.f494397c.now(this.f494396b);
            long r102 = this.f494398d;
            this.f494398d = r101;
            long r103 = r101 - r102;
            this.f494395a.onNext(new io.reactivex.schedulers.a(r100, r103, this.f494396b));
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494399e, r100) == false) goto L6;
            this.f494399e = r100;
            this.f494398d = this.f494397c.now(this.f494396b);
            this.f494395a.onSubscribe(this);
            return;
        }

        public a(Observer<? super io.reactivex.schedulers.a<T>> r100, TimeUnit r101, Scheduler r102) {
            this.f494395a = r100;
            this.f494397c = r102;
            this.f494396b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super io.reactivex.schedulers.a<T>> r100) {
        this.f494245a.subscribe(new a(r100, this.f494394c, this.f494393b));
    }

    public i2(ObservableSource<T> r100, TimeUnit r101, Scheduler r102) {
        super(r100);
        this.f494393b = r102;
        this.f494394c = r101;
    }
}
