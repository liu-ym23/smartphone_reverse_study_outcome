package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public final class PublishProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PublishSubscription[] f495074c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PublishSubscription[] f495075d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<PublishSubscription<T>[]> f495076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f495077b;

    public static final class PublishSubscription<T> extends AtomicLong implements c {
        private static final long serialVersionUID = 3562861878281475070L;
        final wwc.b<? super T> downstream;
        final PublishProcessor<T> parent;

        @Override // wwc.c
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) goto L6;
            this.parent.d(this);
            return;
        }

        public boolean isCancelled() {
            if (get() != Long.MIN_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isFull() {
            if (get() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void onComplete() {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r100) {
            if (get() == Long.MIN_VALUE) goto L5;
            this.downstream.onError(r100);
            return;
        L5:
            RxJavaPlugins.onError(r100);
        }

        public void onNext(T r100) {
            long r101 = get();
            if (r101 != Long.MIN_VALUE) goto L6;
            return;
        L6:
            if (r101 == 0) goto L8;
            this.downstream.onNext(r100);
            io.reactivex.internal.util.b.f(this, 1);
            return;
        L8:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
        }

        @Override // wwc.c
        public void request(long r100) {
            if (SubscriptionHelper.validate(r100) == false) goto L6;
            io.reactivex.internal.util.b.b(this, r100);
            return;
        }

        public PublishSubscription(wwc.b<? super T> r100, PublishProcessor<T> r101) {
            this.downstream = r100;
            this.parent = r101;
        }
    }

    static {
        f495074c = new PublishSubscription[0];
        f495075d = new PublishSubscription[0];
    }

    @Override // wwc.b
    public final void onComplete() {
        PublishSubscription<T>[] r100 = this.f495076a.get();
        PublishSubscription<T>[] r101 = f495074c;
        if (r100 != r101) goto L5;
        return;
    L5:
        PublishSubscription<T>[] r102 = this.f495076a.getAndSet(r101);
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        r102[r104].onComplete();
        r104 = r104 + 1;
        goto L6
    }

    public PublishProcessor() {
        this.f495076a = new AtomicReference(f495075d);
    }

    public final void d(PublishSubscription<T> r100) {
    L2:
        PublishSubscription<T>[] r101 = this.f495076a.get();
        if (r101 == f495074c) goto L27;
        PublishSubscription<T>[] r102 = f495075d;
        if (r101 == r102) goto L39;
        int r103 = r101.length;
        boolean r104 = false;
        int r105 = 0;
    L8:
        if (r105 >= r103) goto L13;
        if (r101[r105] == r100) goto L14;
        r105 = r105 + 1;
    L14:
        if (r105 < 0) goto L15;
        if (r103 == 1) goto L20;
        r102 = new PublishSubscription[r103 - 1];
        System.arraycopy(r101, 0, r102, 0, r105);
        System.arraycopy(r101, r105 + 1, r102, r105, (r103 - r105) - 1);
    L20:
        AtomicReference<PublishSubscription<T>[]> r106 = this.f495076a;
    L22:
        if (r106.compareAndSet(r101, r102) == true) goto L23;
        if (r106.get() == r101) goto L22;
    L26:
        if (r104 == false) goto L2;
        return;
    L23:
        r104 = true;
        goto L26
    L15:
        return;
    L13:
        r105 = -1;
        goto L14
    L39:
        return;
    }

    @Override // wwc.b
    public final void onError(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] r101 = this.f495076a.get();
        PublishSubscription<T>[] r102 = f495074c;
        if (r101 != r102) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.f495077b = r100;
        PublishSubscription<T>[] r103 = this.f495076a.getAndSet(r102);
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r103[r105].onError(r100);
        r105 = r105 + 1;
        goto L7
    }

    @Override // wwc.b
    public final void onNext(T r100) {
        ObjectHelper.requireNonNull(r100, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] r101 = this.f495076a.get();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101[r103].onNext(r100);
        r103 = r103 + 1;
        goto L3
    }

    @Override // wwc.b
    public final void onSubscribe(c r100) {
        if (this.f495076a.get() != f495074c) goto L6;
        r100.cancel();
        return;
    L6:
        r100.request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.Flowable
    public final void subscribeActual(wwc.b<? super T> r100) {
        PublishSubscription<T> r101 = new PublishSubscription(r100, this);
        r100.onSubscribe(r101);
    L3:
        PublishSubscription<T>[] r102 = this.f495076a.get();
        boolean r103 = false;
        if (r102 == f495074c) goto L14;
        int r104 = r102.length;
        PublishSubscription<T>[] r105 = new PublishSubscription[r104 + 1];
        System.arraycopy(r102, 0, r105, 0, r104);
        r105[r104] = r101;
        AtomicReference<PublishSubscription<T>[]> r106 = this.f495076a;
    L8:
        if (r106.compareAndSet(r102, r105) == true) goto L9;
        if (r106.get() == r102) goto L8;
    L12:
        if (r103 == false) goto L3;
        r103 = true;
        goto L14
    L9:
        r103 = true;
    L14:
        if (r103 == true) goto L16;
        Throwable r107 = this.f495077b;
        if (r107 == null) goto L21;
        r100.onError(r107);
        return;
    L21:
        r100.onComplete();
        return;
    L16:
        if (r101.isCancelled() == false) goto L30;
        d(r101);
        return;
    }
}
