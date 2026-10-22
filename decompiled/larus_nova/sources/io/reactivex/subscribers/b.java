package io.reactivex.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.g;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.f;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public abstract class b<T> implements g<T>, Disposable {
    final AtomicReference<wwc.c> upstream;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this.upstream);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.upstream.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public void onStart() {
        this.upstream.get().request(Long.MAX_VALUE);
    }

    public b() {
        this.upstream = new AtomicReference();
    }

    public final void cancel() {
        dispose();
    }

    @Override // io.reactivex.g, wwc.b
    public final void onSubscribe(wwc.c r100) {
        AtomicReference<wwc.c> r101 = this.upstream;
        Class<?> r102 = getClass();
        ObjectHelper.requireNonNull(r100, "next is null");
    L3:
        boolean r103 = true;
        if (r101.compareAndSet(null, r100) == true) goto L5;
        if (r101.get() == null) goto L3;
        boolean r104 = false;
    L9:
        if (r104 == true) goto L14;
        r100.cancel();
        if (r101.get() == SubscriptionHelper.CANCELLED) goto L13;
        f.a(r102);
    L13:
        r103 = false;
    L14:
        if (r103 == false) goto L20;
        onStart();
        return;
    L20:
        return;
    L5:
        r104 = true;
        goto L9
    }

    public final void request(long r100) {
        this.upstream.get().request(r100);
    }
}
