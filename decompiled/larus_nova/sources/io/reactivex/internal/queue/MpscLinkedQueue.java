package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;
import vtc.i;

/* JADX INFO: loaded from: classes41.dex */
public final class MpscLinkedQueue<T> implements i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f494901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f494902b;

    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        public E getAndNullValue() {
            E r100 = lpValue();
            spValue(null);
            return r100;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public LinkedQueueNode() {
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode(E r100) {
            spValue(r100);
        }

        public void soNext(LinkedQueueNode<E> r100) {
            lazySet(r100);
        }

        public void spValue(E r100) {
            this.value = r100;
        }
    }

    @Override // vtc.j
    public final boolean isEmpty() {
        if (this.f494902b.get() != this.f494901a.get()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // vtc.i, vtc.j
    public final T poll() {
        LinkedQueueNode<T> r100 = this.f494902b.get();
        LinkedQueueNode<T> r101 = r100.lvNext();
        if (r101 == null) goto L7;
        T r102 = r101.getAndNullValue();
        this.f494902b.lazySet(r101);
        return r102;
    L7:
        if (r100 == this.f494901a.get()) goto L13;
    L8:
        LinkedQueueNode<T> r103 = r100.lvNext();
        if (r103 == null) goto L8;
        T r104 = r103.getAndNullValue();
        this.f494902b.lazySet(r103);
        return r104;
    L13:
        return null;
    }

    public MpscLinkedQueue() {
        AtomicReference<LinkedQueueNode<T>> r100 = new AtomicReference();
        this.f494901a = r100;
        AtomicReference<LinkedQueueNode<T>> r101 = new AtomicReference();
        this.f494902b = r101;
        LinkedQueueNode<T> r102 = new LinkedQueueNode();
        r101.lazySet(r102);
        LinkedQueueNode<T> r103 = r100.getAndSet(r102);
    }

    @Override // vtc.j
    public final void clear() {
    L3:
        if (poll() == null) goto L7;
        if (isEmpty() == false) goto L3;
        return;
    }

    @Override // vtc.j
    public final boolean offer(T r100) {
        if (r100 == null) goto L6;
        LinkedQueueNode<T> r101 = new LinkedQueueNode(r100);
        this.f494901a.getAndSet(r101).soNext(r101);
        return true;
    L6:
        throw new NullPointerException("Null is not a valid element");
    }
}
