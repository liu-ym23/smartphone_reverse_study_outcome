package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<c> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        int r100 = 0;
        if (get(0) == SubscriptionHelper.CANCELLED) goto L13;
        int r101 = length();
    L5:
        if (r100 >= r101) goto L19;
        c r102 = get(r100);
        SubscriptionHelper r103 = SubscriptionHelper.CANCELLED;
        if (r102 == r103) goto L12;
        c r104 = getAndSet(r100, r103);
        if (r104 == r103) goto L12;
        if (r104 == null) goto L12;
        r104.cancel();
    L12:
        r100 = r100 + 1;
        goto L5
    L19:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get(0) != SubscriptionHelper.CANCELLED) goto L6;
        return true;
    L6:
        return false;
    }

    public ArrayCompositeSubscription(int r100) {
        super(r100);
    }

    public c replaceResource(int r100, c r101) {
    L2:
        c r102 = get(r100);
        if (r102 == SubscriptionHelper.CANCELLED) goto L4;
        if (compareAndSet(r100, r102, r101) == false) goto L2;
        return r102;
    L4:
        if (r101 == null) goto L14;
        r101.cancel();
        return null;
    L14:
        return null;
    }

    public boolean setResource(int r100, c r101) {
    L2:
        c r102 = get(r100);
        if (r102 == SubscriptionHelper.CANCELLED) goto L4;
        if (compareAndSet(r100, r102, r101) == false) goto L2;
        if (r102 == null) goto L18;
        r102.cancel();
        return true;
    L18:
        return true;
    L4:
        if (r101 == null) goto L17;
        r101.cancel();
        return false;
    L17:
        return false;
    }
}
