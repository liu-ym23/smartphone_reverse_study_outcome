package emc;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes36.dex */
public final class d<E extends Delayed> extends AbstractQueue<E> implements BlockingQueue<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ReentrantLock f473130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityQueue<E> f473131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Thread f473132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Condition f473133d;

    public class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f473134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f473135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f473136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f473137d;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f473135b >= this.f473134a.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int r100 = this.f473135b;
            Object[] r101 = this.f473134a;
            if (r100 >= r101.length) goto L7;
            this.f473136c = r100;
            this.f473135b = r100 + 1;
            return (Delayed) r101[r100];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            int r100 = this.f473136c;
            if (r100 < 0) goto L17;
            d r101 = this.f473137d;
            Object r102 = this.f473134a[r100];
            ReentrantLock r103 = r101.f473130a;
            r103.lock();
            Iterator<E> r104 = r101.f473131b.iterator();     // Catch: Throwable -> L13
        L7:
            if (r104.hasNext() == false) goto L11;
            if (r102 != r104.next()) goto L7;
            r104.remove();     // Catch: Throwable -> L13
        L11:
            r103.unlock();
            this.f473136c = -1;
            return;
        L13:
            th = move-exception;
            r103.unlock();
            throw th;
        L17:
            throw new IllegalStateException();
        }

        public a(d r100, Object[] r101) {
            this.f473137d = r100;
            this.f473136c = -1;
            this.f473134a = r101;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    public final E c() throws InterruptedException {
        ReentrantLock r100 = this.f473130a;
        r100.lockInterruptibly();
    L41:
        E r101 = this.f473131b.peek();     // Catch: Throwable -> L33
        if (r101 == null) goto L5;
        TimeUnit r102 = TimeUnit.NANOSECONDS;     // Catch: Throwable -> L33
        long r103 = r101.getDelay(r102);     // Catch: Throwable -> L33
        if (r103 <= 0) goto L8;
        if (this.f473132c != null) goto L18;
        Thread r104 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L33
        this.f473132c = r104;     // Catch: Throwable -> L33
        long r105 = r102.convert(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L28
        if (r103 <= r105) goto L24;
        this.f473133d.awaitNanos(r105);     // Catch: Throwable -> L28
    L26:
        if (this.f473132c != r104) goto L41;
        this.f473132c = null;     // Catch: Throwable -> L33
        goto L41
    L24:
        this.f473133d.awaitNanos(r103);     // Catch: Throwable -> L28
        goto L26
    L28:
        th = move-exception;
        if (this.f473132c != r104) goto L32;
        this.f473132c = null;     // Catch: Throwable -> L33
    L32:
        throw th;     // Catch: Throwable -> L33
    L18:
        this.f473133d.await();     // Catch: Throwable -> L33
        goto L41
    L8:
        E r106 = this.f473131b.poll();     // Catch: Throwable -> L33
        if (this.f473132c == null) goto L12;
    L14:
        r100.unlock();
        return r106;
    L12:
        if (this.f473131b.peek() == null) goto L14;
        this.f473133d.signal();
        goto L14
    L5:
        this.f473133d.await();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        if (this.f473132c == null) goto L37;
    L39:
        r100.unlock();
        throw th;
    L37:
        if (this.f473131b.peek() == null) goto L39;
        this.f473133d.signal();
        goto L39
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        ReentrantLock r100 = this.f473130a;
        r100.lock();
        this.f473131b.clear();     // Catch: Throwable -> L6
        r100.unlock();
        return;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return new a(this, toArray());
    }

    @Override // java.util.Queue
    public final Object peek() {
        ReentrantLock r100 = this.f473130a;
        r100.lock();
        E r101 = this.f473131b.peek();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // java.util.Queue
    public final Object poll() {
        ReentrantLock r100 = this.f473130a;
        r100.lock();
        E r101 = this.f473131b.peek();     // Catch: Throwable -> L13
        if (r101 != null) goto L6;
    L10:
        E r102 = null;
    L11:
        r100.unlock();
        return r102;
    L6:
        if (r101.getDelay(TimeUnit.NANOSECONDS) > 0) goto L10;
        r102 = this.f473131b.poll();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        ReentrantLock r100 = this.f473130a;
        r100.lock();
        int r101 = this.f473131b.size();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        ReentrantLock r100 = this.f473130a;
        r100.lock();
        Object[] r101 = this.f473131b.toArray();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public d() {
        ReentrantLock r100 = new ReentrantLock();
        this.f473130a = r100;
        this.f473131b = new PriorityQueue();
        this.f473133d = r100.newCondition();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final /* bridge */ /* synthetic */ Object take() throws InterruptedException {
        return c();
    }

    public final void a(Delayed r100) {
        ReentrantLock r101 = this.f473130a;
        r101.lock();
        this.f473131b.offer(r100);     // Catch: Throwable -> L8
        if (this.f473131b.peek() != r100) goto L6;
        this.f473132c = null;     // Catch: Throwable -> L8
        this.f473133d.signal();     // Catch: Throwable -> L8
    L6:
        r101.unlock();
        return;
    L8:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingQueue
    public final boolean add(Object r100) {
        a((Delayed) r100);
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> r100) {
        r100.getClass();
        if (r100 == this) goto L20;
        ReentrantLock r101 = this.f473130a;
        r101.lock();
        int r102 = 0;
    L21:
        E r103 = this.f473131b.peek();     // Catch: Throwable -> L13
        if (r103 != null) goto L8;
    L9:
        r103 = null;
    L10:
        if (r103 == null) goto L15;
        r100.add(r103);     // Catch: Throwable -> L13
        this.f473131b.poll();     // Catch: Throwable -> L13
        r102 = r102 + 1;
        goto L21
    L15:
        r101.unlock();
        return r102;
    L8:
        if (r103.getDelay(TimeUnit.NANOSECONDS) <= 0) goto L10;
    L13:
        th = move-exception;
        r101.unlock();
        throw th;
    L20:
        throw new IllegalArgumentException();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public final /* bridge */ /* synthetic */ boolean offer(Object r100) {
        a((Delayed) r100);
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final void put(Object r100) throws InterruptedException {
        a((Delayed) r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final boolean remove(Object r100) {
        ReentrantLock r101 = this.f473130a;
        r101.lock();
        boolean r102 = this.f473131b.remove(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        ReentrantLock r101 = this.f473130a;
        r101.lock();
        T[] r102 = (T[]) this.f473131b.toArray(r100);
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> r100, int r110) {
        r100.getClass();
        if (r100 == this) goto L23;
        int r101 = 0;
        if (r110 > 0) goto L7;
        return 0;
    L7:
        ReentrantLock r102 = this.f473130a;
        r102.lock();
    L8:
        if (r101 >= r110) goto L20;
        E r103 = this.f473131b.peek();     // Catch: Throwable -> L17
        if (r103 != null) goto L12;
    L13:
        r103 = null;
    L14:
        if (r103 == null) goto L20;
        r100.add(r103);     // Catch: Throwable -> L17
        this.f473131b.poll();     // Catch: Throwable -> L17
        r101 = r101 + 1;
        goto L8
    L12:
        if (r103.getDelay(TimeUnit.NANOSECONDS) <= 0) goto L14;
    L17:
        th = move-exception;
        r102.unlock();
        throw th;
    L20:
        r102.unlock();
        return r101;
    L23:
        throw new IllegalArgumentException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final Object poll(long r100, TimeUnit r101) throws InterruptedException {
        long r102 = r101.toNanos(r100);
        ReentrantLock r103 = this.f473130a;
        r103.lockInterruptibly();
    L59:
        E r104 = this.f473131b.peek();     // Catch: Throwable -> L49
        E r105 = null;
        if (r104 == null) goto L7;
        long r106 = r104.getDelay(TimeUnit.NANOSECONDS);     // Catch: Throwable -> L49
        if (r106 <= 0) goto L17;
        if (r102 <= 0) goto L26;
        if (r102 < r106) goto L47;
        if (this.f473132c != null) goto L47;
        Thread r107 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L49
        this.f473132c = r107;     // Catch: Throwable -> L49
        r102 = r102 - (r106 - this.f473133d.awaitNanos(r106));
        if (this.f473132c != r107) goto L59;
        this.f473132c = null;     // Catch: Throwable -> L49
        goto L59
    L42:
        th = move-exception;
        if (this.f473132c != r107) goto L46;
        this.f473132c = null;     // Catch: Throwable -> L49
    L46:
        throw th;     // Catch: Throwable -> L49
    L47:
        r102 = this.f473133d.awaitNanos(r102);     // Catch: Throwable -> L49
        goto L59
    L26:
        if (this.f473132c == null) goto L28;
    L13:
        r103.unlock();
        return r105;
    L28:
        if (this.f473131b.peek() == null) goto L13;
    L12:
        this.f473133d.signal();
        goto L13
    L17:
        r105 = this.f473131b.poll();     // Catch: Throwable -> L49
        if (this.f473132c != null) goto L13;
        if (this.f473131b.peek() == null) goto L13;
    L7:
        if (r102 <= 0) goto L9;
        r102 = this.f473133d.awaitNanos(r102);     // Catch: Throwable -> L49
        goto L59
    L9:
        if (this.f473132c != null) goto L13;
        if (this.f473131b.peek() == null) goto L13;
    L49:
        th = move-exception;
        if (this.f473132c == null) goto L53;
    L55:
        r103.unlock();
        throw th;
    L53:
        if (this.f473131b.peek() == null) goto L55;
        this.f473133d.signal();
        goto L55
    }

    @Override // java.util.concurrent.BlockingQueue
    public final boolean offer(Object r100, long r101, TimeUnit r102) throws InterruptedException {
        a((Delayed) r100);
        return true;
    }
}
