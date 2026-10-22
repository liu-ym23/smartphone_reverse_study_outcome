package com.bytedance.bdp.appbase.base.bdptask;

import com.bytedance.bdp.appbase.base.bdptask.b;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes11.dex */
public final class g<E extends b<?>> extends AbstractQueue<E> implements BlockingQueue<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f200497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<PriorityBlockingQueue<E>> f200498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f200499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f200500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f200501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f200502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInteger f200503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f200504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f200505i;

    public static abstract class a {
        public a() {
        }

        public abstract int a(BdpTask.TaskType r100);

        public abstract void b();

        public abstract int c(BdpTask.TaskType r100);
    }

    public final E c() {
        int r100 = -1;
        int r101 = 0;
        b r102 = null;
    L4:
        if (r101 >= ((ArrayList) this.f200498b).size()) goto L14;
        b r103 = (b) ((PriorityBlockingQueue) ListProtector.get(this.f200498b, r101)).peek();
        if (r103 == null) goto L13;
        if (a(r103.f200486f) == false) goto L13;
        if (r102 != null) goto L11;
    L12:
        r100 = r101;
        r102 = r103;
        goto L13
    L11:
        if (r103.a(r102) < 0) goto L12;
    L13:
        r101 = r101 + 1;
        goto L4
    L14:
        if (r100 >= 0) goto L16;
        return null;
    L16:
        return (E) ((PriorityBlockingQueue) ListProtector.get(this.f200498b, r100)).poll();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> r100) {
        return 0;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection<? super E> r100, int r101) {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return null;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return new Object[0];
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        Iterator r100 = ((ArrayList) this.f200498b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((PriorityBlockingQueue) r100.next()).clear();
        goto L4
    }

    public final E f() {
        this.f200499c.lock();
        E r100 = (E) c();
        this.f200499c.unlock();
        return r100;
    L6:
        th = move-exception;
        this.f200499c.unlock();
        throw th;
    }

    @Override // java.util.Queue
    public final Object peek() {
        this.f200499c.lock();
        Iterator r100 = ((ArrayList) this.f200498b).iterator();     // Catch: Throwable -> L14
        b r101 = null;
    L5:
        if (r100.hasNext() == false) goto L12;
        b r102 = (b) ((PriorityBlockingQueue) r100.next()).peek();     // Catch: Throwable -> L14
        if (r102 == null) goto L5;
        if (r101 == null) goto L11;
        if (r102.a(r101) >= 0) goto L5;
    L11:
        r101 = r102;
        goto L5
    L12:
        this.f200499c.unlock();
        return r101;
    L14:
        th = move-exception;
        this.f200499c.unlock();
        throw th;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        Iterator r100 = ((ArrayList) this.f200498b).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((PriorityBlockingQueue) r100.next()).size();
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.Queue
    public final /* bridge */ /* synthetic */ Object poll() {
        return f();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final Object take() throws InterruptedException {
        return f();
    }

    public g(BdpPoolExecutor.d r100) {
        this.f200499c = new ReentrantLock();
        int r101 = 0;
        this.f200500d = 0;
        this.f200501e = 0;
        this.f200502f = 0;
        this.f200503g = new AtomicInteger(0);
        this.f200504h = new AtomicInteger(0);
        this.f200505i = new AtomicInteger(0);
        this.f200497a = r100;
        this.f200498b = new ArrayList(3);
    L3:
        if (r101 >= 3) goto L5;
        List<PriorityBlockingQueue<E>> r102 = this.f200498b;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new PriorityBlockingQueue());
        r101 = r101 + 1;
        goto L3
    }

    public final boolean a(BdpTask.TaskType r100) {
        if (d(r100).get() >= this.f200497a.a(r100)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final boolean contains(Object r100) {
        Iterator r101 = ((ArrayList) this.f200498b).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((PriorityBlockingQueue) r101.next()).contains(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final AtomicInteger d(BdpTask.TaskType r100) {
        if (r100 != BdpTask.TaskType.IO) goto L7;
        return this.f200503g;
    L7:
        if (r100 != BdpTask.TaskType.CPU) goto L11;
        return this.f200504h;
    L11:
        if (r100 != BdpTask.TaskType.OWN) goto L15;
        return this.f200505i;
    L15:
        return this.f200503g;
    }

    public final boolean e(E r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = this.f200497a.c(r100.f200486f);
        if (r101 < 0) goto L11;
        this.f200497a.b();
        if (r101 >= 3) goto L11;
        ((PriorityBlockingQueue) ListProtector.get(this.f200498b, r101)).offer(r100);
        return true;
    L11:
        StringBuilder r102 = new StringBuilder("index ");
        r102.append(r101);
        r102.append(" out of 0..");
        this.f200497a.b();
        r102.append(2);
        throw new IllegalStateException(r102.toString());
    }

    public final E g(BdpTask.TaskType... r100) {
        this.f200499c.lock();
        int r101 = -1;
        int r102 = 0;
        b r103 = null;
    L23:
    L20:
        th = move-exception;
        this.f200499c.unlock();
        throw th;
    L4:
        if (r102 >= r100.length) goto L14;
        int r104 = this.f200497a.c(r100[r102]);     // Catch: Throwable -> L20
        b r105 = (b) ((PriorityBlockingQueue) ((ArrayList) this.f200498b).get(r104)).peek();     // Catch: Throwable -> L20
        if (r105 == null) goto L13;
        if (a(r105.f200486f) == false) goto L13;
        if (r103 != null) goto L11;
    L12:
        r101 = r104;
        r103 = r105;
        goto L13
    L11:
        if (r105.a(r103) < 0) goto L12;
    L13:
        r102 = r102 + 1;     // Catch: Throwable -> L20
        goto L23
    L14:
        if (r101 < 0) goto L18;
        E r106 = (E) ((PriorityBlockingQueue) ((ArrayList) this.f200498b).get(r101)).poll();     // Catch: Throwable -> L20
        this.f200499c.unlock();
        return r106;
    L18:
        this.f200499c.unlock();
        return null;
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public final /* bridge */ /* synthetic */ boolean offer(Object r100) {
        return e((b) r100);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final void put(Object r100) throws InterruptedException {
        e((b) r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public final boolean remove(Object r100) {
        Iterator r101 = ((ArrayList) this.f200498b).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((PriorityBlockingQueue) r101.next()).remove(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // java.util.concurrent.BlockingQueue
    public final Object poll(long r100, TimeUnit r101) throws InterruptedException {
        return f();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final boolean offer(Object r100, long r101, TimeUnit r102) throws InterruptedException {
        return e((b) r100);
    }
}
