package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes23.dex */
public class LimitQueue<E> extends ConcurrentLinkedQueue<E> {
    private static final String TAG = "LimitQueue";
    private static final long serialVersionUID = -4636313759149307798L;
    private boolean deduplication;
    private int limit;

    public E peekLast() {
        Iterator<E> r100 = iterator();
        E r101 = null;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r100.next();
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public E poll() {
        return (E) super.poll();
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        return (E) super.remove();
    L4:
        Logger.w(TAG, "remove failed, limitQueue is empty");
        return null;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        super.clear();
    }

    public int getLimit() {
        return this.limit;
    }

    public LimitQueue(int r100) {
        this.deduplication = false;
        this.limit = r100;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E r100) {
        if (this.deduplication == false) goto L6;
        super.remove(r100);
    L6:
        if (super.size() < this.limit) goto L9;
        super.poll();
    L9:
        return super.add(r100);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> r100) {
        if (r100.size() <= this.limit) goto L7;
        return false;
    L7:
        if (this.deduplication == false) goto L9;
        super.removeAll(r100);
    L9:
        int r101 = (r100.size() + super.size()) - this.limit;
    L10:
        if (r101 <= 0) goto L13;
        super.poll();
        r101 = r101 - 1;
        goto L10
    L13:
        return super.addAll(r100);
    }

    public E get(int r100) {
        Iterator<E> r101 = iterator();
        E r102 = null;
        int r103 = 0;
    L3:
        if (r103 > r100) goto L7;
        if (r101.hasNext() == false) goto L7;
        r102 = r101.next();
        r103 = r103 + 1;
    L7:
        return r102;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public boolean offer(E r100) {
        if (this.deduplication == false) goto L6;
        super.remove(r100);
    L6:
        if (super.size() < this.limit) goto L9;
        super.poll();
    L9:
        return super.offer(r100);
    }

    public LimitQueue(Collection<? extends E> r100, boolean r101) {
        this(r100.size(), r101);
        addAll(r100);
    }

    public LimitQueue(int r100, boolean r101) {
        this.limit = r100;
        this.deduplication = r101;
    }
}
