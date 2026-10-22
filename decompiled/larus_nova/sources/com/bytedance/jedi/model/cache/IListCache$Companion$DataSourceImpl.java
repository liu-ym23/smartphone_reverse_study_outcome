package com.bytedance.jedi.model.cache;

import com.bytedance.jedi.model.datasource.AbstractDataSource;
import com.bytedance.jedi.model.datasource.Optional;
import com.bytedance.jedi.model.traceable.ITracePoint;
import com.bytedance.jedi.model.traceable.ITraceable;
import com.bytedance.jedi.model.traceable.ITraceableObserved;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u0014\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u00040\u00032\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00040\u00060\u00052\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00040\u00060\u0007¨\u0006\b"}, d2 = {"com/bytedance/jedi/model/cache/IListCache$Companion$DataSourceImpl", "K", "V", "Lcom/bytedance/jedi/model/datasource/AbstractDataSource;", "", "Lcom/bytedance/jedi/model/traceable/ITraceableObserved;", "Lkotlin/Pair;", "", "model_release"}, k = 1, mv = {1, 7, 1})
public final class IListCache$Companion$DataSourceImpl<K, V> extends AbstractDataSource<K, List<? extends V>> implements ITraceableObserved<Pair<? extends K, ? extends List<? extends V>>> {
    @Override // com.bytedance.jedi.model.traceable.ITraceableObserved
    public final void b(ITraceable<Pair<K, List<V>>> r100) {
        Intrinsics.checkNotNullParameter(r100, "traceable");
        throw null;
    }

    public IListCache$Companion$DataSourceImpl() {
        Intrinsics.checkNotNullParameter(null, "inheritance");
        super(null);
        throw null;
    }

    @Override // com.bytedance.jedi.model.datasource.IDataSource
    public final Observable<Optional<List<V>>> a(K r100) {
        ITracePoint<Pair<K, V>> r101 = c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.jedi.model.cache.IListCache<K of com.bytedance.jedi.model.cache.IListCacheKt.toInheritance, V of com.bytedance.jedi.model.cache.IListCacheKt.toInheritance>");
        return ((IListCache) r101).get(r100);
    }
}
