package com.jakewharton.rxrelay2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes23.dex */
public final class ReplayRelay<T> extends b<T> {

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        public Node(T r100) {
            this.value = r100;
        }
    }

    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Observer<? super T> downstream;
        Object index;
        final ReplayRelay<T> state;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            throw null;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public ReplayDisposable(Observer<? super T> r100, ReplayRelay<T> r101) {
            this.downstream = r100;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile TimedNode<T> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;
        final TimeUnit unit;

        public TimedNode<T> getHead() {
            TimedNode<T> r100 = this.head;
            long r101 = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> r102 = r100.get();
        L3:
            TimedNode<T> r103 = r102;
            TimedNode<T> r104 = r100;
            r100 = r103;
            if (r100 == null) goto L9;
            if (r100.time > r101) goto L9;
            r102 = r100.get();
        L9:
            return r104;
        }

        public T getValue() {
            TimedNode<T> r100 = this.head;
        L3:
            TimedNode<T> r101 = r100.get();
            if (r101 == null) goto L5;
            r100 = r101;
            goto L3
        L5:
            long r102 = this.scheduler.now(this.unit) - this.maxAge;
            if (r100.time >= r102) goto L10;
            return null;
        L10:
            return r100.value;
        }

        public void trim() {
            int r100 = this.size;
            if (r100 <= this.maxSize) goto L5;
            this.size = r100 - 1;
            this.head = this.head.get();
        L5:
            long r101 = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> r102 = this.head;
        L7:
            if (this.size <= 1) goto L8;
            TimedNode<T> r103 = r102.get();
            if (r103 == null) goto L11;
            if (r103.time > r101) goto L14;
            this.size--;
            r102 = r103;
            goto L7
        L14:
            this.head = r102;
            return;
        L11:
            this.head = r102;
            return;
        L8:
            this.head = r102;
        }

        public void trimHead() {
            TimedNode<T> r100 = this.head;
            if (r100.value == null) goto L6;
            TimedNode<T> r101 = new TimedNode(null, 0);
            r101.lazySet(r100.get());
            this.head = r101;
            return;
        }

        public int size() {
            return size(getHead());
        }

        public void add(T r100) {
            TimedNode<T> r101 = new TimedNode(r100, this.scheduler.now(this.unit));
            TimedNode<T> r102 = this.tail;
            this.tail = r101;
            this.size++;
            r102.set(r101);
            trim();
        }

        public T[] getValues(T[] r100) {
            TimedNode<T> r101 = getHead();
            int r102 = size(r101);
            int r103 = 0;
            if (r102 != 0) goto L8;
            if (r100.length == 0) goto L15;
            r100[0] = null;
        L15:
            return r100;
        L8:
            if (r100.length >= r102) goto L10;
            r100 = (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), r102));
        L10:
            if (r103 == r102) goto L13;
            r101 = r101.get();
            T[] r104 = r100;
            r104[r103] = r101.value;
            r103 = r103 + 1;
            goto L10
        L13:
            if (r100.length <= r102) goto L15;
            r100[r102] = null;
            goto L15
        }

        public void replay(ReplayDisposable<T> r100) {
            if (r100.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r101 = r100.downstream;
            TimedNode<T> r102 = (TimedNode) r100.index;
            int r103 = 1;
            if (r102 != null) goto L9;
            r102 = getHead();
        L9:
            if (r100.cancelled == true) goto L10;
        L13:
            if (r100.cancelled == true) goto L14;
            TimedNode<T> r104 = r102.get();
            if (r104 == null) goto L19;
            r101.onNext(r104.value);
            r102 = r104;
            goto L13
        L19:
            if (r102.get() != null) goto L9;
            r100.index = r102;
            r103 = r100.addAndGet(-r103);
            if (r103 != 0) goto L9;
            return;
        L14:
            r100.index = null;
            return;
        L10:
            r100.index = null;
        }

        public int size(TimedNode<T> r100) {
            int r101 = 0;
        L4:
            if (r101 == Integer.MAX_VALUE) goto L9;
            r100 = r100.get();
            if (r100 == null) goto L9;
            r101 = r101 + 1;
        L9:
            return r101;
        }

        public SizeAndTimeBoundReplayBuffer(int r100, long r101, TimeUnit r102, Scheduler r103) {
            if (r100 <= 0) goto L17;
            if (r101 <= 0) goto L15;
            if (r102 == null) goto L13;
            if (r103 == null) goto L11;
            this.maxSize = r100;
            this.maxAge = r101;
            this.unit = r102;
            this.scheduler = r103;
            TimedNode<T> r104 = new TimedNode(null, 0);
            this.tail = r104;
            this.head = r104;
            return;
        L11:
            throw new NullPointerException("scheduler == null");
        L13:
            throw new NullPointerException("unit == null");
        L15:
            throw new IllegalArgumentException("maxAge > 0 required but it was " + r101);
        L17:
            throw new IllegalArgumentException("maxSize > 0 required but it was " + r100);
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile Node<T> head;
        final int maxSize;
        int size;
        Node<T> tail;

        public T getValue() {
            Node<T> r100 = this.head;
        L3:
            Node<T> r101 = r100.get();
            if (r101 == null) goto L6;
            r100 = r101;
            goto L3
        L6:
            return r100.value;
        }

        public int size() {
            Node<T> r100 = this.head;
            int r101 = 0;
        L4:
            if (r101 == Integer.MAX_VALUE) goto L9;
            r100 = r100.get();
            if (r100 == null) goto L9;
            r101 = r101 + 1;
        L9:
            return r101;
        }

        public void trim() {
            int r100 = this.size;
            if (r100 <= this.maxSize) goto L6;
            this.size = r100 - 1;
            this.head = this.head.get();
            return;
        }

        public void trimHead() {
            Node<T> r100 = this.head;
            if (r100.value == null) goto L6;
            Node<T> r101 = new Node(null);
            r101.lazySet(r100.get());
            this.head = r101;
            return;
        }

        public SizeBoundReplayBuffer(int r100) {
            if (r100 <= 0) goto L7;
            this.maxSize = r100;
            Node<T> r101 = new Node(null);
            this.tail = r101;
            this.head = r101;
            return;
        L7:
            throw new IllegalArgumentException("maxSize > 0 required but it was " + r100);
        }

        public void add(T r100) {
            Node<T> r101 = new Node(r100);
            Node<T> r102 = this.tail;
            this.tail = r101;
            this.size++;
            r102.set(r101);
            trim();
        }

        public T[] getValues(T[] r100) {
            Node<T> r101 = this.head;
            int r102 = size();
            int r103 = 0;
            if (r102 != 0) goto L8;
            if (r100.length == 0) goto L15;
            r100[0] = null;
        L15:
            return r100;
        L8:
            if (r100.length >= r102) goto L10;
            r100 = (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), r102));
        L10:
            if (r103 == r102) goto L13;
            r101 = r101.get();
            T[] r104 = r100;
            r104[r103] = r101.value;
            r103 = r103 + 1;
            goto L10
        L13:
            if (r100.length <= r102) goto L15;
            r100[r102] = null;
            goto L15
        }

        public void replay(ReplayDisposable<T> r100) {
            if (r100.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r101 = r100.downstream;
            Node<T> r102 = (Node) r100.index;
            int r103 = 1;
            if (r102 != null) goto L9;
            r102 = this.head;
        L9:
            if (r100.cancelled == true) goto L10;
            Node<T> r104 = r102.get();
            if (r104 == null) goto L15;
            r101.onNext(r104.value);
            r102 = r104;
            goto L9
        L15:
            if (r102.get() != null) goto L9;
            r100.index = r102;
            r103 = r100.addAndGet(-r103);
            if (r103 != 0) goto L9;
            return;
        L10:
            r100.index = null;
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        public TimedNode(T r100, long r101) {
            this.value = r100;
            this.time = r101;
        }
    }

    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<T> buffer;
        volatile int size;

        public void trimHead() {
        }

        public T getValue() {
            int r100 = this.size;
            if (r100 != 0) goto L5;
            return null;
        L5:
            return (T) ListProtector.get(this.buffer, r100 - 1);
        }

        public int size() {
            return this.size;
        }

        public UnboundedReplayBuffer(int r100) {
            if (r100 <= 0) goto L7;
            this.buffer = new ArrayList(r100);
            return;
        L7:
            throw new IllegalArgumentException("capacityHint <= 0");
        }

        public void add(T r100) {
            this.buffer.add(r100);
            this.size++;
        }

        public T[] getValues(T[] r100) {
            int r101 = this.size;
            int r102 = 0;
            if (r101 != 0) goto L9;
            if (r100.length == 0) goto L7;
            r100[0] = null;
        L7:
            return r100;
        L9:
            if (r100.length >= r101) goto L11;
            r100 = (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), r101));
        L11:
            List<T> r103 = this.buffer;
        L12:
            if (r102 >= r101) goto L15;
            T[] r104 = r100;
            r104[r102] = ListProtector.get(r103, r102);
            r102 = r102 + 1;
            goto L12
        L15:
            if (r100.length <= r101) goto L17;
            r100[r101] = null;
        L17:
            return r100;
        }

        public void replay(ReplayDisposable<T> r100) {
            if (r100.getAndIncrement() == 0) goto L5;
            return;
        L5:
            List<T> r101 = this.buffer;
            Observer<? super T> r102 = r100.downstream;
            Integer r103 = (Integer) r100.index;
            int r104 = 1;
            if (r103 == null) goto L8;
            int r105 = r103.intValue();
        L10:
            if (r100.cancelled == true) goto L11;
            int r106 = this.size;
        L14:
            if (r106 == r105) goto L21;
            if (r100.cancelled == true) goto L17;
            r102.onNext((Object) ListProtector.get(r101, r105));
            r105 = r105 + 1;
            goto L14
        L17:
            r100.index = null;
            return;
        L21:
            if (r105 != this.size) goto L10;
            r100.index = Integer.valueOf(r105);
            r104 = r100.addAndGet(-r104);
            if (r104 != 0) goto L10;
            return;
        L11:
            r100.index = null;
            return;
        L8:
            r105 = 0;
            r100.index = 0;
            goto L10
        }
    }
}
