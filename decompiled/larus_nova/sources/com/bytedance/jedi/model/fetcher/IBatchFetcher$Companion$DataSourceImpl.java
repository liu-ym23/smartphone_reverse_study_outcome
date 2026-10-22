package com.bytedance.jedi.model.fetcher;

import com.bytedance.jedi.model.datasource.AbstractDataSource;
import com.bytedance.jedi.model.datasource.Optional;
import com.bytedance.jedi.model.traceable.ITraceable;
import com.bytedance.jedi.model.traceable.ITraceableObserved;
import com.bytedance.jedi.model.traceable.TraceableObservedImpl;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0004\b\u0005\u0010\u00032\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00042\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0003\u0012\u0006\u0012\u0004\u0018\u00018\u00040\u00060\u0005¨\u0006\u0007"}, d2 = {"com/bytedance/jedi/model/fetcher/IBatchFetcher$Companion$DataSourceImpl", "K", "V", "RESP", "Lcom/bytedance/jedi/model/datasource/AbstractDataSource;", "Lcom/bytedance/jedi/model/traceable/ITraceableObserved;", "Lkotlin/Pair;", "model_release"}, k = 1, mv = {1, 7, 1})
public final class IBatchFetcher$Companion$DataSourceImpl<K, V, RESP> extends AbstractDataSource<K, V> implements ITraceableObserved<Pair<? extends K, ? extends V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TraceableObservedImpl<K, V> f251072b;

    @Override // com.bytedance.jedi.model.traceable.ITraceableObserved
    public final void b(ITraceable<Pair<K, V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "traceable");
        this.f251072b.b(r100);
    }

    public IBatchFetcher$Companion$DataSourceImpl(AbstractBatchFetcher r100) {
        Intrinsics.checkNotNullParameter(r100, "inheritance");
        super(r100);
        this.f251072b = new TraceableObservedImpl(r100);
    }

    @Override // com.bytedance.jedi.model.datasource.IDataSource
    public final Observable<Optional<V>> a(K r100) {
        return Observable.empty();
    }
}
