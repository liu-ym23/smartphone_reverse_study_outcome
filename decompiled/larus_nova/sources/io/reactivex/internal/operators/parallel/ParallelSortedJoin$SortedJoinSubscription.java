package io.reactivex.internal.operators.parallel;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wwc.b;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelSortedJoin$SortedJoinSubscription<T> extends AtomicInteger implements c {
    private static final long serialVersionUID = 3481980673745556697L;
    volatile boolean cancelled;
    final Comparator<? super T> comparator;
    final b<? super T> downstream;
    final AtomicReference<Throwable> error;
    final int[] indexes;
    final List<T>[] lists;
    final AtomicInteger remaining;
    final AtomicLong requested;
    final ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] subscribers;

    @Override // wwc.c
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() != 0) goto L9;
        Arrays.fill(this.lists, null);
        return;
    L9:
        return;
    }

    public void cancelAll() {
        ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] r100 = this.subscribers;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].cancel();
        r102 = r102 + 1;
        goto L3
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        b<? super T> r100 = this.downstream;
        List<T>[] r101 = this.lists;
        int[] r102 = this.indexes;
        int r103 = r102.length;
        int r104 = 1;
    L6:
        long r105 = this.requested.get();
        long r110 = 0;
    L8:
        if (r110 == r105) goto L50;
        if (this.cancelled == true) goto L11;
        Throwable r111 = this.error.get();
        if (r111 != null) goto L15;
        int r112 = -1;
        Object r106 = null;
        int r113 = 0;
    L18:
        if (r113 >= r103) goto L45;
        List<T> r114 = r101[r113];
        int r107 = r102[r113];
        if (r114.size() == r107) goto L44;
        if (r106 != null) goto L24;
        r106 = ListProtector.get(r114, r107);
    L23:
        r112 = r113;
        goto L44
    L24:
        Object r108 = ListProtector.get(r114, r107);
        if (this.comparator.compare(r106, r108) <= 0) goto L28;
        boolean r115 = true;
    L29:
        if (r115 == false) goto L44;
        r106 = r108;
        goto L23
    L28:
        r115 = false;
    L31:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        cancelAll();
        Throwable r109 = null;
        Arrays.fill(r101, null);
        AtomicReference<Throwable> r116 = this.error;
    L34:
        if (r116.compareAndSet(r109, th) == true) goto L35;
        if (r116.get() != null) goto L38;
        r109 = null;
        goto L34
    L38:
        boolean r117 = false;
    L39:
        if (r117 == true) goto L41;
        RxJavaPlugins.onError(th);
    L41:
        r100.onError(this.error.get());
        return;
    L35:
        r117 = true;
    L44:
        r113 = r113 + 1;
        goto L18
    L45:
        if (r106 == null) goto L46;
        r100.onNext(r106);
        r102[r112] = r102[r112] + 1;
        r110 = r110 + 1;
        goto L8
    L46:
        Arrays.fill(r101, null);
        r100.onComplete();
        return;
    L15:
        cancelAll();
        Arrays.fill(r101, null);
        r100.onError(r111);
        return;
    L11:
        Arrays.fill(r101, null);
        return;
    L50:
        if (r110 != r105) goto L70;
        if (this.cancelled == true) goto L53;
        Throwable r118 = this.error.get();
        if (r118 != null) goto L57;
        int r119 = 0;
    L60:
        if (r119 >= r103) goto L65;
        if (r102[r119] != r101[r119].size()) goto L63;
        r119 = r119 + 1;
        goto L60
    L63:
        boolean r120 = false;
    L66:
        if (r120 == false) goto L70;
        Arrays.fill(r101, null);
        r100.onComplete();
        return;
    L65:
        r120 = true;
        goto L66
    L57:
        cancelAll();
        Arrays.fill(r101, null);
        r100.onError(r118);
        return;
    L53:
        Arrays.fill(r101, null);
        return;
    L70:
        if (r110 != 0) goto L72;
    L74:
        int r121 = get();
        if (r121 != r104) goto L79;
        r121 = addAndGet(-r104);
        if (r121 != 0) goto L79;
        return;
    L79:
        r104 = r121;
        goto L6
    L72:
        if (r105 == Long.MAX_VALUE) goto L74;
        this.requested.addAndGet(-r110);
        goto L74
    }

    public void innerError(Throwable r100) {
        AtomicReference<Throwable> r101 = this.error;
    L4:
        if (r101.compareAndSet(null, r100) == true) goto L5;
        if (r101.get() == null) goto L4;
        boolean r102 = false;
    L9:
        if (r102 == false) goto L12;
        drain();
        return;
    L12:
        if (r100 == this.error.get()) goto L19;
        RxJavaPlugins.onError(r100);
        return;
    L19:
        return;
    L5:
        r102 = true;
        goto L9
    }

    @Override // wwc.c
    public void request(long r100) {
        if (SubscriptionHelper.validate(r100) == false) goto L8;
        io.reactivex.internal.util.b.a(this.requested, r100);
        if (this.remaining.get() != 0) goto L9;
        drain();
        return;
    L9:
        return;
    }

    public void innerNext(List<T> r100, int r101) {
        this.lists[r101] = r100;
        if (this.remaining.decrementAndGet() != 0) goto L6;
        drain();
        return;
    }

    public ParallelSortedJoin$SortedJoinSubscription(b<? super T> r100, int r101, Comparator<? super T> r102) {
        this.requested = new AtomicLong();
        this.remaining = new AtomicInteger();
        this.error = new AtomicReference();
        this.downstream = r100;
        this.comparator = r102;
        ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] r103 = new ParallelSortedJoin$SortedJoinInnerSubscriber[r101];
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        r103[r104] = new ParallelSortedJoin$SortedJoinInnerSubscriber(this, r104);
        r104 = r104 + 1;
        goto L3
    L5:
        this.subscribers = r103;
        this.lists = new List[r101];
        this.indexes = new int[r101];
        this.remaining.lazySet(r101);
    }
}
