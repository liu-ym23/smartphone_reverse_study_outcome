package com.bytedance.platform.godzilla.anr.sp;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes21.dex */
public class LinkedListProxyForFinishers<E> extends LinkedList<E> {
    private LinkedList<Runnable> mRealList;

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public E poll() {
        return null;
    }

    public LinkedListProxyForFinishers(LinkedList<Runnable> r100) {
        this.mRealList = r100;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E r100) {
        return this.mRealList.add((Runnable) r100);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object r100) {
        return this.mRealList.remove(r100);
    }
}
