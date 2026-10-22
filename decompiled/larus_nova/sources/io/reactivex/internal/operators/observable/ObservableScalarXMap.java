package io.reactivex.internal.operators.observable;

import com.larus.apm.impl.protector.RunnableProtector;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements vtc.e<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final Observer<? super T> observer;
        final T value;

        @Override // vtc.j
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(3);
        }

        @Override // java.lang.Runnable
        public void run() {
            io_reactivex_internal_operators_observable_ObservableScalarXMap$ScalarDisposable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void io_reactivex_internal_operators_observable_ObservableScalarXMap$ScalarDisposable__run$___twin___() {
            if (get() == 0) goto L5;
            return;
        L5:
            if (compareAndSet(0, 2) == false) goto L11;
            this.observer.onNext(this.value);
            if (get() != 2) goto L12;
            lazySet(3);
            this.observer.onComplete();
            return;
        L12:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // vtc.j
        public boolean isEmpty() {
            if (get() != 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // vtc.j
        public T poll() throws Exception {
            if (get() != 1) goto L6;
            lazySet(3);
            return this.value;
        L6:
            return null;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void io_reactivex_internal_operators_observable_ObservableScalarXMap$ScalarDisposable_com_larus_apm_impl_protector_RunnableLancet_run(ScalarDisposable r100) {
            r100.io_reactivex_internal_operators_observable_ObservableScalarXMap$ScalarDisposable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // vtc.j
        public boolean offer(T r100) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // vtc.f
        public int requestFusion(int r100) {
            if ((r100 & 1) == 0) goto L6;
            lazySet(1);
            return 1;
        L6:
            return 0;
        }

        public ScalarDisposable(Observer<? super T> r100, T r101) {
            this.observer = r100;
            this.value = r101;
        }

        public boolean offer(T r100, T r101) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public static final class a<T, R> extends Observable<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f494146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f494147b;

        @Override // io.reactivex.Observable
        public final void subscribeActual(Observer<? super R> r100) {
            ObservableSource r101 = (ObservableSource) ObjectHelper.requireNonNull(this.f494147b.apply(this.f494146a), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L15
            if ((r101 instanceof Callable) == true) goto L20;
            r101.subscribe(r100);
            return;
        L20:
            Object r102 = ((Callable) r101).call();     // Catch: Throwable -> L10
            if (r102 != null) goto L9;
            EmptyDisposable.complete(r100);
            return;
        L9:
            ScalarDisposable r103 = new ScalarDisposable(r100, r102);
            r100.onSubscribe(r103);
            r103.run();
            return;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, r100);
            return;
        L15:
            th = move-exception;
            EmptyDisposable.error(th, r100);
        }

        public a(T r100, Function<? super T, ? extends ObservableSource<? extends R>> r101) {
            this.f494146a = r100;
            this.f494147b = r101;
        }
    }

    public static <T, R> boolean a(ObservableSource<T> r100, Observer<? super R> r101, Function<? super T, ? extends ObservableSource<? extends R>> r102) {
        if ((r100 instanceof Callable) == true) goto L34;
        return false;
    L34:
        DeepThinkTopHeaderComponent$runCollapseAnimation$2 r103 = (Object) ((Callable) r100).call();
        if (r103 != null) goto L30;
        EmptyDisposable.complete(r101);
        return true;
    L30:
        ObservableSource r104 = (ObservableSource) ObjectHelper.requireNonNull(r102.apply(r103), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L22
        if ((r104 instanceof Callable) == true) goto L32;
        r104.subscribe(r101);
    L21:
        return true;
    L32:
        Object r105 = ((Callable) r104).call();     // Catch: Throwable -> L17
        if (r105 != null) goto L16;
        EmptyDisposable.complete(r101);
        return true;
    L16:
        ScalarDisposable r106 = new ScalarDisposable(r101, r105);
        r101.onSubscribe(r106);
        r106.run();
    L17:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r101);
        return true;
    L22:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r101);
        return true;
    L25:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r101);
        return true;
    }
}
