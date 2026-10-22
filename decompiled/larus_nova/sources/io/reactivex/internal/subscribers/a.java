package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a<T, R> implements vtc.a<T>, vtc.g<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vtc.a<? super R> f495013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wwc.c f495014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vtc.g<T> f495015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f495016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f495017e;

    @Override // wwc.c
    public final void cancel() {
        this.f495014b.cancel();
    }

    @Override // vtc.j
    public final void clear() {
        this.f495015c.clear();
    }

    @Override // vtc.j
    public final boolean isEmpty() {
        return this.f495015c.isEmpty();
    }

    @Override // wwc.b
    public void onComplete() {
        if (this.f495016d == false) goto L5;
        return;
    L5:
        this.f495016d = true;
        this.f495013a.onComplete();
    }

    public a(vtc.a<? super R> r100) {
        this.f495013a = r100;
    }

    public final void a(Throwable r100) {
        Exceptions.throwIfFatal(r100);
        this.f495014b.cancel();
        onError(r100);
    }

    public final int b(int r100) {
        vtc.g<T> r101 = this.f495015c;
        if (r101 != null) goto L5;
        return 0;
    L5:
        if ((r100 & 4) != 0) goto L12;
        int r102 = r101.requestFusion(r100);
        if (r102 == 0) goto L9;
        this.f495017e = r102;
    L9:
        return r102;
    L12:
        return 0;
    }

    @Override // vtc.j
    public final boolean offer(R r100) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        if (this.f495016d == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.f495016d = true;
        this.f495013a.onError(r100);
    }

    @Override // io.reactivex.g, wwc.b
    public final void onSubscribe(wwc.c r100) {
        if (SubscriptionHelper.validate(this.f495014b, r100) == false) goto L9;
        this.f495014b = r100;
        if ((r100 instanceof vtc.g) == false) goto L7;
        this.f495015c = (vtc.g) r100;
    L7:
        this.f495013a.onSubscribe(this);
        return;
    }

    @Override // wwc.c
    public final void request(long r100) {
        this.f495014b.request(r100);
    }
}
