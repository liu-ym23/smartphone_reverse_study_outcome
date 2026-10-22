package com.bytedance.jedi.model.fetcher;

import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/jedi/model/fetcher/AbstractFetcher;", "K", "V", "REQ", "RESP", "Lcom/bytedance/jedi/model/fetcher/IFetcher;", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public abstract class AbstractFetcher<K, V, REQ, RESP> implements IFetcher<K, V, REQ, RESP> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f251071a;

    public abstract Observable<RESP> g(REQ r100);

    public AbstractFetcher() {
        this.f251071a = LazyKt.lazy(new AbstractFetcher$dataSource$2(this));
    }

    @Override // com.bytedance.jedi.model.fetcher.IFetcher
    public final Observable<RESP> a(final REQ r100) {
        Observable<RESP> r101 = g(r100);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r101, "observable");
        final Function1<Object, Unit> r102 = new PointcutKt$fire$1(this, r100);
        return r101.doOnNext(new b(r102));
    }
}
