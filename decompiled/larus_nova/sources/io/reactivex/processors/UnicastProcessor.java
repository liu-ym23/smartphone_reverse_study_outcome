package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public final class UnicastProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.internal.queue.a<T> f495078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Runnable> f495079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f495080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f495081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f495082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<wwc.b<? super T>> f495083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f495084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f495085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BasicIntQueueSubscription<T> f495086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicLong f495087j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f495088k;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;
        final /* synthetic */ UnicastProcessor this$0;

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, wwc.c
        public void cancel() {
            if (this.this$0.f495084g == false) goto L5;
            return;
        L5:
            this.this$0.f495084g = true;
            Runnable r100 = this.this$0.f495079b.getAndSet(null);
            if (r100 == null) goto L8;
            r100.run();
        L8:
            UnicastProcessor r101 = this.this$0;
            if (r101.f495088k == false) goto L11;
            return;
        L11:
            if (r101.f495086i.getAndIncrement() != 0) goto L15;
            this.this$0.f495078a.clear();
            this.this$0.f495083f.lazySet(null);
            return;
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vtc.j
        public void clear() {
            this.this$0.f495078a.clear();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vtc.j
        public boolean isEmpty() {
            return this.this$0.f495078a.isEmpty();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vtc.j
        public T poll() {
            return this.this$0.f495078a.poll();
        }

        public UnicastQueueSubscription(UnicastProcessor r100) {
            this.this$0 = r100;
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, wwc.c
        public void request(long r100) {
            if (SubscriptionHelper.validate(r100) == false) goto L6;
            io.reactivex.internal.util.b.a(this.this$0.f495087j, r100);
            this.this$0.j();
            return;
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vtc.f
        public int requestFusion(int r100) {
            if ((r100 & 2) == 0) goto L6;
            this.this$0.f495088k = true;
            return 2;
        L6:
            return 0;
        }
    }

    public final void j() {
        if (this.f495086i.getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r100 = 1;
        wwc.b<? super T> r101 = this.f495083f.get();
        int r102 = 1;
    L6:
        if (r101 != null) goto L8;
        r102 = this.f495086i.addAndGet(-r102);
        if (r102 == 0) goto L58;
        r101 = this.f495083f.get();
        r100 = 1;
        goto L6
    L58:
        return;
    L8:
        if (this.f495088k == false) goto L28;
        io.reactivex.internal.queue.a<T> r103 = this.f495078a;
        int r104 = (this.f495080c ? 1 : 0) ^ r100;
    L11:
        if (this.f495084g == true) goto L12;
        boolean r105 = this.f495081d;
        if (r104 == 0) goto L19;
        if (r105 == false) goto L19;
        if (this.f495082e == null) goto L19;
        r103.clear();
        this.f495083f.lazySet(null);
        r101.onError(this.f495082e);
        return;
    L19:
        r101.onNext(null);
        if (r105 == true) goto L21;
        r100 = this.f495086i.addAndGet(-r100);
        if (r100 != 0) goto L11;
        return;
    L21:
        this.f495083f.lazySet(null);
        Throwable r106 = this.f495082e;
        if (r106 == null) goto L24;
        r101.onError(r106);
        return;
    L24:
        r101.onComplete();
        return;
    L12:
        r103.clear();
        this.f495083f.lazySet(null);
        return;
    L28:
        io.reactivex.internal.queue.a<T> r107 = this.f495078a;
        boolean r110 = !this.f495080c;
        int r111 = 1;
    L29:
        long r112 = this.f495087j.get();
        long r108 = 0;
    L31:
        if (r112 == r108) goto L42;
        boolean r109 = this.f495081d;
        T r113 = r107.poll();
        if (r113 != null) goto L35;
        boolean r114 = true;
    L36:
        long r115 = r108;
        if (d(r110, r109, r114, r101, r107) == true) goto L76;
        if (r114 == true) goto L43;
        r101.onNext(r113);
        r108 = r115 + 1;
    L43:
        if (r112 != r108) goto L48;
        if (d(r110, this.f495081d, r107.isEmpty(), r101, r107) == false) goto L48;
        return;
    L48:
        if (r115 != 0) goto L50;
    L52:
        r111 = this.f495086i.addAndGet(-r111);
        if (r111 != 0) goto L29;
        return;
    L50:
        if (r112 == Long.MAX_VALUE) goto L52;
        this.f495087j.addAndGet(-r115);
        goto L52
    L76:
        return;
    L35:
        r114 = false;
        goto L36
    L42:
        r115 = r108;
        goto L43
    }

    @Override // wwc.b
    public final void onComplete() {
        if (this.f495081d == false) goto L5;
        return;
    L5:
        if (this.f495084g == true) goto L13;
        this.f495081d = true;
        Runnable r100 = this.f495079b.getAndSet(null);
        if (r100 == null) goto L10;
        r100.run();
    L10:
        j();
        return;
    }

    public UnicastProcessor(int r100) {
        this(r100, null);
    }

    @Override // wwc.b
    public final void onError(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f495081d == false) goto L5;
    L12:
        RxJavaPlugins.onError(r100);
        return;
    L5:
        if (this.f495084g == true) goto L12;
        this.f495082e = r100;
        this.f495081d = true;
        Runnable r101 = this.f495079b.getAndSet(null);
        if (r101 == null) goto L10;
        r101.run();
    L10:
        j();
    }

    @Override // wwc.b
    public final void onNext(T r100) {
        ObjectHelper.requireNonNull(r100, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f495081d == false) goto L5;
        return;
    L5:
        if (this.f495084g == true) goto L10;
        this.f495078a.offer(r100);
        j();
        return;
    }

    @Override // wwc.b
    public final void onSubscribe(c r100) {
        if (this.f495081d == false) goto L5;
    L8:
        r100.cancel();
        return;
    L5:
        if (this.f495084g == true) goto L8;
        r100.request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.Flowable
    public final void subscribeActual(wwc.b<? super T> r100) {
        if (this.f495085h.get() == false) goto L5;
    L10:
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), r100);
        return;
    L5:
        if (this.f495085h.compareAndSet(false, true) == false) goto L10;
        r100.onSubscribe(this.f495086i);
        this.f495083f.set(r100);
        if (this.f495084g == false) goto L9;
        this.f495083f.lazySet(null);
        return;
    L9:
        j();
    }

    public UnicastProcessor(int r100, Runnable r101) {
        this.f495078a = new io.reactivex.internal.queue.a(ObjectHelper.verifyPositive(r100, "capacityHint"));
        this.f495079b = new AtomicReference(r101);
        this.f495080c = true;
        this.f495083f = new AtomicReference();
        this.f495085h = new AtomicBoolean();
        this.f495086i = new UnicastQueueSubscription(this);
        this.f495087j = new AtomicLong();
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> e(int r100, Runnable r101) {
        ObjectHelper.requireNonNull(r101, "onTerminate");
        return new UnicastProcessor(r100, r101);
    }

    public final boolean d(boolean r100, boolean r101, boolean r102, wwc.b<? super T> r103, io.reactivex.internal.queue.a<T> r104) {
        if (this.f495084g == false) goto L6;
        r104.clear();
        this.f495083f.lazySet(null);
        return true;
    L6:
        if (r101 == false) goto L18;
        if (r100 == true) goto L9;
    L12:
        if (r102 == false) goto L20;
        Throwable r105 = this.f495082e;
        this.f495083f.lazySet(null);
        if (r105 == null) goto L16;
        r103.onError(r105);
    L17:
        return true;
    L16:
        r103.onComplete();
        goto L17
    L20:
        return false;
    L9:
        if (this.f495082e == null) goto L12;
        r104.clear();
        this.f495083f.lazySet(null);
        r103.onError(this.f495082e);
        return true;
    L18:
        return false;
    }
}
