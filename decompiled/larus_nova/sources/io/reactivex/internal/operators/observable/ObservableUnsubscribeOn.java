package io.reactivex.internal.operators.observable;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableUnsubscribeOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f494211b;

    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1015244841293359600L;
        final Observer<? super T> downstream;
        final Scheduler scheduler;
        Disposable upstream;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UnsubscribeObserver f494212a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f494212a.upstream.dispose();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(UnsubscribeObserver r100) {
                this.f494212a = r100;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.scheduler.scheduleDirect(new a(this));
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (get() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            if (get() == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            if (get() == true) goto L6;
            this.downstream.onNext(r100);
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            return;
        }

        public UnsubscribeObserver(Observer<? super T> r100, Scheduler r101) {
            this.downstream = r100;
            this.scheduler = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new UnsubscribeObserver(r100, this.f494211b));
    }

    public ObservableUnsubscribeOn(ObservableSource<T> r100, Scheduler r101) {
        super(r100);
        this.f494211b = r101;
    }
}
