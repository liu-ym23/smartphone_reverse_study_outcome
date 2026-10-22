package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class FlowableFromIterable<T> extends Flowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<? extends T> f493127a;

    public static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, wwc.c
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, vtc.j
        public final void clear() {
            this.it = null;
        }

        public abstract void fastPath();

        @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, vtc.f
        public final int requestFusion(int r100) {
            return r100 & 1;
        }

        public abstract void slowPath(long r100);

        @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, vtc.j
        public final boolean isEmpty() {
            Iterator<? extends T> r100 = this.it;
            if (r100 != null) goto L5;
        L8:
            return true;
        L5:
            if (r100.hasNext() == false) goto L8;
            return false;
        }

        @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, vtc.j
        public final T poll() {
            Iterator<? extends T> r100 = this.it;
            if (r100 != null) goto L6;
            return null;
        L6:
            if (this.once == true) goto L9;
            this.once = true;
        L12:
            return (T) ObjectHelper.requireNonNull(this.it.next(), "Iterator.next() returned a null value");
        L9:
            if (r100.hasNext() == true) goto L12;
            return null;
        }

        public BaseRangeSubscription(Iterator<? extends T> r100) {
            this.it = r100;
        }

        @Override // io.reactivex.internal.subscriptions.BasicQueueSubscription, wwc.c
        public final void request(long r100) {
            if (SubscriptionHelper.validate(r100) == true) goto L5;
            return;
        L5:
            if (io.reactivex.internal.util.b.a(this, r100) == 0) goto L7;
            return;
        L7:
            if (r100 != Long.MAX_VALUE) goto L9;
            fastPath();
            return;
        L9:
            slowPath(r100);
        }
    }

    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final vtc.a<? super T> downstream;

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void fastPath() {
            Iterator<? extends T> r100 = this.it;
            vtc.a<? super T> r101 = this.downstream;
        L4:
            if (this.cancelled == true) goto L5;
            T r102 = r100.next();     // Catch: Throwable -> L25
            if (this.cancelled == true) goto L9;
            if (r102 == null) goto L11;
            r101.tryOnNext(r102);
            if (this.cancelled == true) goto L15;
            if (r100.hasNext() == true) goto L4;
            if (this.cancelled == true) goto L38;
            r101.onComplete();
            return;
        L38:
            return;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r101.onError(th);
            return;
        L15:
            return;
        L11:
            r101.onError(new NullPointerException("Iterator.next() returned a null value"));
            return;
        L9:
            return;
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r101.onError(th);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void slowPath(long r100) {
            Iterator<? extends T> r101 = this.it;
            vtc.a<? super T> r102 = this.downstream;
        L3:
            long r103 = 0;
        L5:
            if (r103 != r100) goto L7;
            r100 = get();
            if (r103 != r100) goto L5;
            r100 = addAndGet(-r103);
            if (r100 != 0) goto L3;
            return;
        L7:
            if (this.cancelled == true) goto L8;
            T r104 = r101.next();     // Catch: Throwable -> L30
            if (this.cancelled == true) goto L12;
            if (r104 == null) goto L14;
            boolean r105 = r102.tryOnNext(r104);
            if (this.cancelled == true) goto L18;
            if (r101.hasNext() == false) goto L22;
            if (r105 == false) goto L5;
            r103 = r103 + 1;
            goto L5
        L22:
            if (this.cancelled == true) goto L57;
            r102.onComplete();
            return;
        L57:
            return;
        L27:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r102.onError(th);
            return;
        L18:
            return;
        L14:
            r102.onError(new NullPointerException("Iterator.next() returned a null value"));
            return;
        L12:
            return;
        L30:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r102.onError(th);
            return;
        }

        public IteratorConditionalSubscription(vtc.a<? super T> r100, Iterator<? extends T> r101) {
            super(r101);
            this.downstream = r100;
        }
    }

    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final wwc.b<? super T> downstream;

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void fastPath() {
            Iterator<? extends T> r100 = this.it;
            wwc.b<? super T> r101 = this.downstream;
        L4:
            if (this.cancelled == true) goto L5;
            T r102 = r100.next();     // Catch: Throwable -> L25
            if (this.cancelled == true) goto L9;
            if (r102 == null) goto L11;
            r101.onNext(r102);
            if (this.cancelled == true) goto L15;
            if (r100.hasNext() == true) goto L4;
            if (this.cancelled == true) goto L38;
            r101.onComplete();
            return;
        L38:
            return;
        L22:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r101.onError(th);
            return;
        L15:
            return;
        L11:
            r101.onError(new NullPointerException("Iterator.next() returned a null value"));
            return;
        L9:
            return;
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r101.onError(th);
            return;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void slowPath(long r100) {
            Iterator<? extends T> r101 = this.it;
            wwc.b<? super T> r102 = this.downstream;
        L3:
            long r103 = 0;
        L5:
            if (r103 != r100) goto L7;
            r100 = get();
            if (r103 != r100) goto L5;
            r100 = addAndGet(-r103);
            if (r100 != 0) goto L3;
            return;
        L7:
            if (this.cancelled == true) goto L8;
            T r104 = r101.next();     // Catch: Throwable -> L29
            if (this.cancelled == true) goto L12;
            if (r104 == null) goto L14;
            r102.onNext(r104);
            if (this.cancelled == true) goto L18;
            if (r101.hasNext() == false) goto L22;
            r103 = r103 + 1;
            goto L5
        L22:
            if (this.cancelled == true) goto L54;
            r102.onComplete();
            return;
        L54:
            return;
        L26:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r102.onError(th);
            return;
        L18:
            return;
        L14:
            r102.onError(new NullPointerException("Iterator.next() returned a null value"));
            return;
        L12:
            return;
        L29:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r102.onError(th);
            return;
        }

        public IteratorSubscription(wwc.b<? super T> r100, Iterator<? extends T> r101) {
            super(r101);
            this.downstream = r100;
        }
    }

    public FlowableFromIterable(Iterable<? extends T> r100) {
        this.f493127a = r100;
    }

    @Override // io.reactivex.Flowable
    public final void subscribeActual(wwc.b<? super T> r100) {
        d(r100, this.f493127a.iterator());
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r100);
    }

    public static <T> void d(wwc.b<? super T> r100, Iterator<? extends T> r101) {
        if (r101.hasNext() == true) goto L7;
        EmptySubscription.complete(r100);
        return;
    L7:
        if ((r100 instanceof vtc.a) == false) goto L9;
        r100.onSubscribe(new IteratorConditionalSubscription((vtc.a) r100, r101));
        return;
    L9:
        r100.onSubscribe(new IteratorSubscription(r100, r101));
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptySubscription.error(th, r100);
    }
}
