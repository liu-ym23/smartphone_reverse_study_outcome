package io.reactivex.subscribers;

import io.reactivex.g;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.f;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a<T> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wwc.c f495149a;

    public a() {
    }

    @Override // io.reactivex.g, wwc.b
    public final void onSubscribe(wwc.c r100) {
        wwc.c r101 = this.f495149a;
        Class<?> r102 = getClass();
        ObjectHelper.requireNonNull(r100, "next is null");
        if (r101 == null) goto L8;
        r100.cancel();
        if (r101 == SubscriptionHelper.CANCELLED) goto L7;
        f.a(r102);
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L14;
        this.f495149a = r100;
        if (r100 == null) goto L15;
        r100.request(Long.MAX_VALUE);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r103 = true;
        goto L9
    }
}
