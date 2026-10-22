package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a<T, R> extends Maybe<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaybeSource<T> f493817a;

    public a(MaybeSource<T> r100) {
        this.f493817a = r100;
    }
}
