package io.reactivex.internal.operators.observable;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableDebounceTimed<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f494037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f494038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Scheduler f494039d;

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once;
        final a<T> parent;
        final T value;

        @Override // java.lang.Runnable
        public void run() {
            io_reactivex_internal_operators_observable_ObservableDebounceTimed$DebounceEmitter_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void io_reactivex_internal_operators_observable_ObservableDebounceTimed$DebounceEmitter__run$___twin___() {
            if (this.once.compareAndSet(false, true) == false) goto L8;
            a<T> r100 = this.parent;
            long r101 = this.idx;
            T r102 = this.value;
            if (r101 != r100.f494046g) goto L9;
            r100.f494040a.onNext(r102);
            dispose();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void io_reactivex_internal_operators_observable_ObservableDebounceTimed$DebounceEmitter_com_larus_apm_impl_protector_RunnableLancet_run(DebounceEmitter r100) {
            r100.io_reactivex_internal_operators_observable_ObservableDebounceTimed$DebounceEmitter__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void setResource(Disposable r100) {
            DisposableHelper.replace(this, r100);
        }

        public DebounceEmitter(T r100, long r101, a<T> r102) {
            this.once = new AtomicBoolean();
            this.value = r100;
            this.idx = r101;
            this.parent = r102;
        }
    }

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f494041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TimeUnit f494042c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Scheduler.Worker f494043d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Disposable f494044e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Disposable f494045f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile long f494046g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f494047h;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494044e.dispose();
            this.f494043d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494043d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494047h == false) goto L5;
            return;
        L5:
            this.f494047h = true;
            Disposable r100 = this.f494045f;
            if (r100 == null) goto L8;
            r100.dispose();
        L8:
            DebounceEmitter r101 = (DebounceEmitter) r100;
            if (r101 == null) goto L11;
            r101.run();
        L11:
            this.f494040a.onComplete();
            this.f494043d.dispose();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494047h == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            Disposable r101 = this.f494045f;
            if (r101 == null) goto L9;
            r101.dispose();
        L9:
            this.f494047h = true;
            this.f494040a.onError(r100);
            this.f494043d.dispose();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494047h == false) goto L5;
            return;
        L5:
            long r101 = this.f494046g + 1;
            this.f494046g = r101;
            Disposable r102 = this.f494045f;
            if (r102 == null) goto L8;
            r102.dispose();
        L8:
            DebounceEmitter r103 = new DebounceEmitter(r100, r101, this);
            this.f494045f = r103;
            r103.setResource(this.f494043d.schedule(r103, this.f494041b, this.f494042c));
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494044e, r100) == false) goto L6;
            this.f494044e = r100;
            this.f494040a.onSubscribe(this);
            return;
        }

        public a(io.reactivex.observers.f r100, long r101, TimeUnit r102, Scheduler.Worker r103) {
            this.f494040a = r100;
            this.f494041b = r101;
            this.f494042c = r102;
            this.f494043d = r103;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(new io.reactivex.observers.f(r100), this.f494037b, this.f494038c, this.f494039d.createWorker()));
    }

    public ObservableDebounceTimed(ObservableSource<T> r100, long r101, TimeUnit r102, Scheduler r103) {
        super(r100);
        this.f494037b = r101;
        this.f494038c = r102;
        this.f494039d = r103;
    }
}
