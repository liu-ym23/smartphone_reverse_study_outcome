package com.ss.android.lark.utils;

import android.os.Looper;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public final class QueuedWorkUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444669a = 0;

    public static class ConcurrentLinkedQueueProxy<E> extends ConcurrentLinkedQueue<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient ConcurrentLinkedQueue<E> f444670a;

        public ConcurrentLinkedQueueProxy() {
            throw null;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
        public E poll() {
            return null;
        }

        @Override // java.util.AbstractQueue, java.util.Queue
        public E remove() {
            ConcurrentLinkedQueue<E> r100 = this.f444670a;
            if (r100 != null) goto L6;
            return null;
        L6:
            return r100.remove();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
        public boolean add(E r100) {
            ConcurrentLinkedQueue<E> r101 = this.f444670a;
            if (r101 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.add(r100) == false) goto L7;
            return true;
        }

        public ConcurrentLinkedQueueProxy(ConcurrentLinkedQueue r100, a r101) {
            this.f444670a = r100;
        }
    }

    public static class FinishersProxy extends LinkedList<Runnable> {
        public FinishersProxy() {
            throw null;
        }

        @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
        public Runnable poll() {
            return null;
        }

        @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
        public /* bridge */ /* synthetic */ Object poll() {
            return poll();
        }

        public FinishersProxy(LinkedList r100, a r101) {
            super(r100);
        }
    }

    public static class WorkProxy extends LinkedList<Runnable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient LinkedList<Runnable> f444671a;

        public WorkProxy() {
            throw null;
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
            int r100 = QueuedWorkUtil.f444669a;
            return;
        L6:
            super.clear();
        }

        @Override // java.util.LinkedList
        public Object clone() {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
            return this.f444671a;
        L7:
            return super.clone();
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public boolean addAll(Collection<? extends Runnable> r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            int r101 = QueuedWorkUtil.f444669a;
            throw null;
        }

        public WorkProxy(LinkedList r100, a r101) {
            super(r100);
            this.f444671a = new LinkedList();
        }
    }

    public static /* synthetic */ class a {
    }

    static {
        new AtomicBoolean(false);
    }
}
