package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes41.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableSource<? extends T> f493989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f493990b;

    public static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        final Condition condition;
        volatile boolean done;
        Throwable error;
        final Lock lock;
        final io.reactivex.internal.queue.a<T> queue;

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
        L2:
            boolean r100 = this.done;
            boolean r101 = this.queue.isEmpty();
            if (r100 == false) goto L11;
            Throwable r102 = this.error;
            if (r102 != null) goto L10;
            if (r101 == false) goto L11;
            return false;
        L10:
            throw ExceptionHelper.d(r102);
        L11:
            if (r101 == false) goto L26;
            io.reactivex.internal.util.c.b();     // Catch: InterruptedException -> L23
            this.lock.lock();     // Catch: InterruptedException -> L23
        L30:
        L20:
            th = move-exception;
            this.lock.unlock();     // Catch: InterruptedException -> L23
            throw th;     // Catch: InterruptedException -> L23
        L14:
            if (this.done == true) goto L19;
            if (this.queue.isEmpty() == false) goto L19;
            this.condition.await();     // Catch: Throwable -> L20
        L19:
            this.lock.unlock();     // Catch: InterruptedException -> L23
        L23:
            e = move-exception;
            DisposableHelper.dispose(this);
            signalConsumer();
            throw ExceptionHelper.d(e);
        L26:
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        public void signalConsumer() {
            this.lock.lock();
            this.condition.signalAll();     // Catch: Throwable -> L6
            this.lock.unlock();
            return;
        L6:
            th = move-exception;
            this.lock.unlock();
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            return this.queue.poll();
        L7:
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public BlockingObservableIterator(int r100) {
            this.queue = new io.reactivex.internal.queue.a(r100);
            ReentrantLock r101 = new ReentrantLock();
            this.lock = r101;
            this.condition = r101.newCondition();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            this.error = r100;
            this.done = true;
            signalConsumer();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            this.queue.offer(r100);
            signalConsumer();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this, r100);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        BlockingObservableIterator r100 = new BlockingObservableIterator(this.f493990b);
        this.f493989a.subscribe(r100);
        return r100;
    }

    public BlockingObservableIterable(ObservableSource<? extends T> r100, int r101) {
        this.f493989a = r100;
        this.f493990b = r101;
    }
}
