package io.reactivex.internal.operators.parallel;

import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelSortedJoin$SortedJoinInnerSubscriber<T> extends AtomicReference<c> implements g<List<T>> {
    private static final long serialVersionUID = 6751017204873808094L;
    final int index;
    final ParallelSortedJoin$SortedJoinSubscription<T> parent;

    @Override // wwc.b
    public void onComplete() {
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        this.parent.innerError(r100);
    }

    public void onNext(List<T> r100) {
        this.parent.innerNext(r100, this.index);
    }

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(c r100) {
        SubscriptionHelper.setOnce(this, r100, Long.MAX_VALUE);
    }

    @Override // wwc.b
    public /* bridge */ /* synthetic */ void onNext(Object r100) {
        onNext((List) r100);
    }

    public ParallelSortedJoin$SortedJoinInnerSubscriber(ParallelSortedJoin$SortedJoinSubscription<T> r100, int r101) {
        this.parent = r100;
        this.index = r101;
    }
}
