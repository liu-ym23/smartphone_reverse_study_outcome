package io.reactivex.observers;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, k<T>, SingleObserver<T>, io.reactivex.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Observer<? super T> f495058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<Disposable> f495059f;

    public static final enum EmptyObserver extends Enum<EmptyObserver> implements Observer<Object> {
        public static final EmptyObserver INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EmptyObserver[] f495060a = null;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
        }

        @Override // io.reactivex.Observer
        public void onNext(Object r100) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
        }

        static {
            EmptyObserver r100 = new EmptyObserver();
            INSTANCE = r100;
            f495060a = new EmptyObserver[]{r100};
        }

        public EmptyObserver() {
            super("INSTANCE", 0);
        }

        public static EmptyObserver[] values() {
            return (EmptyObserver[]) f495060a.clone();
        }

        public static EmptyObserver valueOf(String r100) {
            return (EmptyObserver) r27.a.a(EmptyObserver.class, r100);
        }
    }

    public TestObserver() {
        EmptyObserver r100 = EmptyObserver.INSTANCE;
        this.f495059f = new AtomicReference();
        this.f495058e = r100;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f495059f);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f495059f.get());
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.f495056d == true) goto L13;
        this.f495056d = true;
        if (this.f495059f.get() != null) goto L13;
        this.f495055c.add(new IllegalStateException("onSubscribe not called in proper order"));
    L13:
        ThreadMethodProxy.currentThread();     // Catch: Throwable -> L10
        this.f495058e.onComplete();     // Catch: Throwable -> L10
        this.f495053a.countDown();
        return;
    L10:
        th = move-exception;
        this.f495053a.countDown();
        throw th;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        if (this.f495056d == true) goto L17;
        this.f495056d = true;
        if (this.f495059f.get() != null) goto L17;
        this.f495055c.add(new IllegalStateException("onSubscribe not called in proper order"));
    L17:
        ThreadMethodProxy.currentThread();     // Catch: Throwable -> L14
        if (r100 != null) goto L10;
        this.f495055c.add(new NullPointerException("onError received a null Throwable"));     // Catch: Throwable -> L14
    L11:
        this.f495058e.onError(r100);     // Catch: Throwable -> L14
        this.f495053a.countDown();
        return;
    L10:
        this.f495055c.add(r100);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.f495053a.countDown();
        throw th;
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        if (this.f495056d == true) goto L7;
        this.f495056d = true;
        if (this.f495059f.get() != null) goto L7;
        this.f495055c.add(new IllegalStateException("onSubscribe not called in proper order"));
    L7:
        ThreadMethodProxy.currentThread();
        this.f495054b.add(r100);
        if (r100 != null) goto L10;
        this.f495055c.add(new NullPointerException("onNext received a null value"));
    L10:
        this.f495058e.onNext(r100);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        ThreadMethodProxy.currentThread();
        if (r100 != null) goto L6;
        this.f495055c.add(new NullPointerException("onSubscribe received a null Subscription"));
        return;
    L6:
        AtomicReference<Disposable> r101 = this.f495059f;
    L8:
        if (r101.compareAndSet(null, r100) == true) goto L9;
        if (r101.get() == null) goto L8;
        boolean r102 = false;
    L13:
        if (r102 == true) goto L18;
        r100.dispose();
        if (this.f495059f.get() == DisposableHelper.DISPOSED) goto L23;
        this.f495055c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + r100));
        return;
    L23:
        return;
    L18:
        this.f495058e.onSubscribe(r100);
        return;
    L9:
        r102 = true;
        goto L13
    }

    @Override // io.reactivex.k
    public final void onSuccess(T r100) {
        onNext(r100);
        onComplete();
    }
}
