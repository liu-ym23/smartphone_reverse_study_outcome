package io.reactivex.subjects;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ReplaySubject<T> extends Subject<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReplayDisposable[] f495124d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReplayDisposable[] f495125e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object[] f495126f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<T> f495127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<ReplayDisposable<T>[]> f495128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f495129c;

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
        final ReplaySubject<T> state;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.state.c(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public ReplayDisposable(Observer<? super T> r100, ReplaySubject<T> r101) {
            this.downstream = r100;
            this.state = r101;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile TimedNode<Object> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<Object> tail;
        final TimeUnit unit;

        public TimedNode<Object> getHead() {
            TimedNode<Object> r100 = this.head;
            long r101 = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> r102 = r100.get();
        L3:
            TimedNode<T> r103 = r102;
            TimedNode<Object> r104 = r100;
            r100 = r103;
            if (r100 == null) goto L9;
            if (r100.time > r101) goto L9;
            r102 = r100.get();
        L9:
            return r104;
        }

        public T getValue() {
            TimedNode<Object> r100 = this.head;
            TimedNode<Object> r101 = null;
        L3:
            TimedNode<T> r102 = r100.get();
            if (r102 == null) goto L6;
            r101 = r100;
            r100 = r102;
            goto L3
        L6:
            if (r100.time >= (this.scheduler.now(this.unit) - this.maxAge)) goto L8;
            return null;
        L8:
            T r103 = (T) r100.value;
            if (r103 != null) goto L12;
            return null;
        L12:
            if (NotificationLite.isComplete(r103) == true) goto L18;
            if (NotificationLite.isError(r103) == true) goto L18;
            return r103;
        L18:
            return (T) r101.value;
        }

        public void trim() {
            int r100 = this.size;
            if (r100 <= this.maxSize) goto L5;
            this.size = r100 - 1;
            this.head = this.head.get();
        L5:
            long r101 = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<Object> r102 = this.head;
        L6:
            TimedNode<T> r103 = r102.get();
            if (r103 == null) goto L8;
            if (r103.time > r101) goto L11;
            r102 = r103;
            goto L6
        L11:
            this.head = r102;
            return;
        L8:
            this.head = r102;
        }

        public void trimFinal() {
            long r100 = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<Object> r101 = this.head;
        L3:
            TimedNode<T> r102 = r101.get();
            if (r102.get() == null) goto L6;
            if (r102.time > r100) goto L12;
            r101 = r102;
            goto L3
        L12:
            if (r101.value == null) goto L14;
            TimedNode<Object> r103 = new TimedNode(null, 0);
            r103.lazySet(r101.get());
            this.head = r103;
            return;
        L14:
            this.head = r101;
            return;
        L6:
            if (r101.value == null) goto L8;
            TimedNode<Object> r104 = new TimedNode(null, 0);
            r104.lazySet(r101.get());
            this.head = r104;
            return;
        L8:
            this.head = r101;
        }

        public void trimHead() {
            TimedNode<Object> r100 = this.head;
            if (r100.value == null) goto L6;
            TimedNode<Object> r101 = new TimedNode(null, 0);
            r101.lazySet(r100.get());
            this.head = r101;
            return;
        }

        public int size() {
            return size(getHead());
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T r100) {
            TimedNode<Object> r101 = new TimedNode(r100, this.scheduler.now(this.unit));
            TimedNode<Object> r102 = this.tail;
            this.tail = r101;
            this.size++;
            r102.set(r101);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void addFinal(Object r100) {
            TimedNode<Object> r101 = new TimedNode(r100, Long.MAX_VALUE);
            TimedNode<Object> r102 = this.tail;
            this.tail = r101;
            this.size++;
            r102.lazySet(r101);
            trimFinal();
            this.done = true;
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

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void replay(ReplayDisposable<T> r100) {
            if (r100.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r101 = r100.downstream;
            TimedNode<Object> r102 = (TimedNode) r100.index;
            if (r102 != null) goto L8;
            r102 = getHead();
        L8:
            int r103 = 1;
        L10:
            if (r100.cancelled == true) goto L11;
        L14:
            if (r100.cancelled == true) goto L15;
            TimedNode<T> r104 = r102.get();
            if (r104 == null) goto L20;
            T r105 = r104.value;
            if (this.done == false) goto L35;
            if (r104.get() != null) goto L35;
            if (NotificationLite.isComplete(r105) == false) goto L32;
            r101.onComplete();
        L33:
            r100.index = null;
            r100.cancelled = true;
            return;
        L32:
            r101.onError(NotificationLite.getError(r105));
        L35:
            r101.onNext(r105);
            r102 = r104;
            goto L14
        L20:
            if (r102.get() != null) goto L10;
            r100.index = r102;
            r103 = r100.addAndGet(-r103);
            if (r103 != 0) goto L10;
            return;
        L15:
            r100.index = null;
            return;
        L11:
            r100.index = null;
        }

        public int size(TimedNode<Object> r100) {
            int r101 = 0;
        L4:
            if (r101 == Integer.MAX_VALUE) goto L17;
            TimedNode<T> r102 = r100.get();
            if (r102 == null) goto L7;
            r101 = r101 + 1;
            r100 = r102;
            goto L4
        L7:
            Object r103 = r100.value;
            if (NotificationLite.isComplete(r103) == true) goto L16;
            if (NotificationLite.isError(r103) == true) goto L16;
            return r101;
        L16:
            return r101 - 1;
        L17:
            return r101;
        }

        public SizeAndTimeBoundReplayBuffer(int r100, long r101, TimeUnit r102, Scheduler r103) {
            this.maxSize = ObjectHelper.verifyPositive(r100, "maxSize");
            this.maxAge = ObjectHelper.verifyPositive(r101, "maxAge");
            this.unit = (TimeUnit) ObjectHelper.requireNonNull(r102, "unit is null");
            this.scheduler = (Scheduler) ObjectHelper.requireNonNull(r103, "scheduler is null");
            TimedNode<Object> r104 = new TimedNode(null, 0);
            this.tail = r104;
            this.head = r104;
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile Node<Object> head;
        final int maxSize;
        int size;
        Node<Object> tail;

        public T getValue() {
            Node<Object> r100 = this.head;
            Node<Object> r101 = null;
        L3:
            Node<T> r102 = r100.get();
            if (r102 == null) goto L5;
            r101 = r100;
            r100 = r102;
            goto L3
        L5:
            T r103 = (T) r100.value;
            if (r103 != null) goto L9;
            return null;
        L9:
            if (NotificationLite.isComplete(r103) == true) goto L15;
            if (NotificationLite.isError(r103) == true) goto L15;
            return r103;
        L15:
            return (T) r101.value;
        }

        public int size() {
            Node<Object> r100 = this.head;
            int r101 = 0;
        L4:
            if (r101 == Integer.MAX_VALUE) goto L17;
            Node<T> r102 = r100.get();
            if (r102 == null) goto L7;
            r101 = r101 + 1;
            r100 = r102;
            goto L4
        L7:
            Object r103 = r100.value;
            if (NotificationLite.isComplete(r103) == true) goto L16;
            if (NotificationLite.isError(r103) == true) goto L16;
            return r101;
        L16:
            return r101 - 1;
        L17:
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
            Node<Object> r100 = this.head;
            if (r100.value == null) goto L6;
            Node<Object> r101 = new Node(null);
            r101.lazySet(r100.get());
            this.head = r101;
            return;
        }

        public SizeBoundReplayBuffer(int r100) {
            this.maxSize = ObjectHelper.verifyPositive(r100, "maxSize");
            Node<Object> r101 = new Node(null);
            this.tail = r101;
            this.head = r101;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T r100) {
            Node<Object> r101 = new Node(r100);
            Node<Object> r102 = this.tail;
            this.tail = r101;
            this.size++;
            r102.set(r101);
            trim();
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void addFinal(Object r100) {
            Node<Object> r101 = new Node(r100);
            Node<Object> r102 = this.tail;
            this.tail = r101;
            this.size++;
            r102.lazySet(r101);
            trimHead();
            this.done = true;
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

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void replay(ReplayDisposable<T> r100) {
            if (r100.getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r101 = r100.downstream;
            Node<Object> r102 = (Node) r100.index;
            if (r102 != null) goto L8;
            r102 = this.head;
        L8:
            int r103 = 1;
        L10:
            if (r100.cancelled == true) goto L11;
            Node<T> r104 = r102.get();
            if (r104 == null) goto L16;
            T r105 = r104.value;
            if (this.done == true) goto L24;
        L31:
            r101.onNext(r105);
            r102 = r104;
            goto L10
        L24:
            if (r104.get() != null) goto L31;
            if (NotificationLite.isComplete(r105) == false) goto L28;
            r101.onComplete();
        L29:
            r100.index = null;
            r100.cancelled = true;
            return;
        L28:
            r101.onError(NotificationLite.getError(r105));
            goto L29
        L16:
            if (r102.get() != null) goto L10;
            r100.index = r102;
            r103 = r100.addAndGet(-r103);
            if (r103 != 0) goto L10;
            return;
        L11:
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

    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements a<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        public void trimHead() {
        }

        public T getValue() {
            int r100 = this.size;
            if (r100 == 0) goto L15;
            List<Object> r101 = this.buffer;
            T r102 = (T) ListProtector.get(r101, r100 - 1);
            if (NotificationLite.isComplete(r102) == true) goto L11;
            if (NotificationLite.isError(r102) == true) goto L11;
            return r102;
        L11:
            if (r100 != 1) goto L14;
            return null;
        L14:
            return (T) ListProtector.get(r101, r100 - 2);
        L15:
            return null;
        }

        public int size() {
            int r100 = this.size;
            if (r100 == 0) goto L11;
            int r101 = r100 - 1;
            Object r102 = ListProtector.get(this.buffer, r101);
            if (NotificationLite.isComplete(r102) == false) goto L7;
        L10:
            return r101;
        L7:
            if (NotificationLite.isError(r102) == true) goto L10;
            return r100;
        L11:
            return 0;
        }

        public UnboundedReplayBuffer(int r100) {
            this.buffer = new ArrayList(ObjectHelper.verifyPositive(r100, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void add(T r100) {
            this.buffer.add(r100);
            this.size++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void addFinal(Object r100) {
            this.buffer.add(r100);
            trimHead();
            this.size++;
            this.done = true;
        }

        public T[] getValues(T[] r100) {
            int r101 = this.size;
            int r102 = 0;
            if (r101 == 0) goto L5;
            List<Object> r103 = this.buffer;
            Object r104 = ListProtector.get(r103, r101 - 1);
            if (NotificationLite.isComplete(r104) == false) goto L11;
        L12:
            r101 = r101 - 1;
            if (r101 == 0) goto L15;
        L19:
            if (r100.length >= r101) goto L21;
            r100 = (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), r101));
        L21:
            if (r102 >= r101) goto L24;
            r100[r102] = ListProtector.get(r103, r102);
            r102 = r102 + 1;
            goto L21
        L24:
            if (r100.length <= r101) goto L26;
            r100[r101] = null;
        L26:
            return r100;
        L15:
            if (r100.length == 0) goto L17;
            r100[0] = null;
        L17:
            return r100;
        L11:
            if (NotificationLite.isError(r104) == false) goto L19;
        L5:
            if (r100.length == 0) goto L7;
            r100[0] = null;
        L7:
            return r100;
        }

        @Override // io.reactivex.subjects.ReplaySubject.a
        public void replay(ReplayDisposable<T> r110) {
            if (r110.getAndIncrement() == 0) goto L5;
            return;
        L5:
            List<Object> r100 = this.buffer;
            Observer<? super T> r101 = r110.downstream;
            Integer r102 = (Integer) r110.index;
            if (r102 == null) goto L8;
            int r103 = r102.intValue();
        L9:
            int r104 = 1;
        L11:
            if (r110.cancelled == true) goto L12;
            int r105 = this.size;
        L15:
            if (r105 == r103) goto L34;
            if (r110.cancelled == true) goto L18;
            DeepThinkTopHeaderComponent$runCollapseAnimation$2 r106 = (Object) ListProtector.get(r100, r103);
            if (this.done == false) goto L32;
            int r107 = r103 + 1;
            if (r107 != r105) goto L32;
            r105 = this.size;
            if (r107 != r105) goto L32;
            if (NotificationLite.isComplete(r106) == false) goto L29;
            r101.onComplete();
        L30:
            r110.index = null;
            r110.cancelled = true;
            return;
        L29:
            r101.onError(NotificationLite.getError(r106));
        L32:
            r101.onNext(r106);
            r103 = r103 + 1;
            goto L15
        L18:
            r110.index = null;
            return;
        L34:
            if (r103 != this.size) goto L11;
            r110.index = Integer.valueOf(r103);
            r104 = r110.addAndGet(-r104);
            if (r104 != 0) goto L11;
            return;
        L12:
            r110.index = null;
            return;
        L8:
            r103 = 0;
            r110.index = 0;
            goto L9
        }
    }

    public interface a<T> {
        void add(T r100);

        void addFinal(Object r100);

        boolean compareAndSet(Object r100, Object r101);

        Object get();

        void replay(ReplayDisposable<T> r100);
    }

    static {
        f495124d = new ReplayDisposable[0];
        f495125e = new ReplayDisposable[0];
        f495126f = new Object[0];
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> a() {
        return new ReplaySubject(new UnboundedReplayBuffer(16));
    }

    @Override // io.reactivex.subjects.Subject
    public final Throwable getThrowable() {
        Object r100 = this.f495127a.get();
        if (NotificationLite.isError(r100) == true) goto L5;
        return null;
    L5:
        return NotificationLite.getError(r100);
    }

    @Override // io.reactivex.subjects.Subject
    public final boolean hasComplete() {
        return NotificationLite.isComplete(this.f495127a.get());
    }

    @Override // io.reactivex.subjects.Subject
    public final boolean hasObservers() {
        if (this.f495128b.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    public final boolean hasThrowable() {
        return NotificationLite.isError(this.f495127a.get());
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.f495129c == false) goto L5;
        return;
    L5:
        this.f495129c = true;
        Object r100 = NotificationLite.complete();
        a<T> r101 = this.f495127a;
        r101.addFinal(r100);
        boolean r102 = this.f495127a.compareAndSet(null, r100);
        ReplayDisposable<T>[] r103 = f495125e;
        if (r102 == false) goto L8;
        r103 = this.f495128b.getAndSet(r103);
    L8:
        int r104 = r103.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L11;
        r101.replay(r103[r105]);
        r105 = r105 + 1;
        goto L9
    }

    public ReplaySubject(a<T> r100) {
        this.f495127a = r100;
        this.f495128b = new AtomicReference(f495124d);
    }

    public final void c(ReplayDisposable<T> r100) {
    L2:
        ReplayDisposable<T>[] r101 = this.f495128b.get();
        if (r101 == f495125e) goto L27;
        ReplayDisposable<T>[] r102 = f495124d;
        if (r101 == r102) goto L39;
        int r103 = r101.length;
        boolean r104 = false;
        int r105 = 0;
    L8:
        if (r105 >= r103) goto L13;
        if (r101[r105] == r100) goto L14;
        r105 = r105 + 1;
    L14:
        if (r105 < 0) goto L15;
        if (r103 == 1) goto L20;
        r102 = new ReplayDisposable[r103 - 1];
        System.arraycopy(r101, 0, r102, 0, r105);
        System.arraycopy(r101, r105 + 1, r102, r105, (r103 - r105) - 1);
    L20:
        AtomicReference<ReplayDisposable<T>[]> r106 = this.f495128b;
    L22:
        if (r106.compareAndSet(r101, r102) == true) goto L23;
        if (r106.get() == r101) goto L22;
    L26:
        if (r104 == false) goto L2;
        return;
    L23:
        r104 = true;
        goto L26
    L15:
        return;
    L13:
        r105 = -1;
        goto L14
    L39:
        return;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f495129c == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.f495129c = true;
        Object r101 = NotificationLite.error(r100);
        a<T> r102 = this.f495127a;
        r102.addFinal(r101);
        boolean r103 = this.f495127a.compareAndSet(null, r101);
        ReplayDisposable<T>[] r104 = f495125e;
        if (r103 == false) goto L9;
        r104 = this.f495128b.getAndSet(r104);
    L9:
        int r105 = r104.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L12;
        r102.replay(r104[r106]);
        r106 = r106 + 1;
        goto L10
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        ObjectHelper.requireNonNull(r100, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f495129c == false) goto L5;
        return;
    L5:
        a<T> r101 = this.f495127a;
        r101.add(r100);
        ReplayDisposable<T>[] r102 = this.f495128b.get();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        r101.replay(r102[r104]);
        r104 = r104 + 1;
        goto L6
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        if (this.f495129c == false) goto L6;
        r100.dispose();
        return;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        ReplayDisposable<T> r101 = new ReplayDisposable(r100, this);
        r100.onSubscribe(r101);
        if (r101.cancelled == true) goto L29;
    L4:
        ReplayDisposable<T>[] r102 = this.f495128b.get();
        boolean r103 = false;
        if (r102 == f495125e) goto L15;
        int r104 = r102.length;
        ReplayDisposable<T>[] r105 = new ReplayDisposable[r104 + 1];
        System.arraycopy(r102, 0, r105, 0, r104);
        r105[r104] = r101;
        AtomicReference<ReplayDisposable<T>[]> r106 = this.f495128b;
    L9:
        if (r106.compareAndSet(r102, r105) == true) goto L10;
        if (r106.get() == r102) goto L9;
    L13:
        if (r103 == false) goto L4;
        r103 = true;
        goto L15
    L10:
        r103 = true;
    L15:
        if (r103 == true) goto L17;
    L20:
        this.f495127a.replay(r101);
        return;
    L17:
        if (r101.cancelled == false) goto L20;
        c(r101);
        return;
    }
}
