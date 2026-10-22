package io.reactivex.internal.operators.observable;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableSubscribeOn<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f494176b;

    public static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8094547886072529208L;
        final Observer<? super T> downstream;
        final AtomicReference<Disposable> upstream;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        public SubscribeOnObserver(Observer<? super T> r100) {
            this.downstream = r100;
            this.upstream = new AtomicReference();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            this.downstream.onNext(r100);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this.upstream, r100);
        }

        public void setDisposable(Disposable r100) {
            DisposableHelper.setOnce(this, r100);
        }
    }

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SubscribeOnObserver<T> f494177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableSubscribeOn f494178b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f494178b.f494245a.subscribe(this.f494177a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ObservableSubscribeOn r100, SubscribeOnObserver<T> r101) {
            this.f494178b = r100;
            this.f494177a = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        SubscribeOnObserver r101 = new SubscribeOnObserver(r100);
        r100.onSubscribe(r101);
        r101.setDisposable(this.f494176b.scheduleDirect(new a(this, r101)));
    }

    public ObservableSubscribeOn(ObservableSource<T> r100, Scheduler r101) {
        super(r100);
        this.f494176b = r101;
    }
}
