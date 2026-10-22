package com.bytedance.jedi.model.cache;

import com.bytedance.jedi.model.datasource.IDataSource;
import com.bytedance.jedi.model.datasource.Optional;
import com.bytedance.jedi.model.datasource.OptionalKt;
import com.bytedance.jedi.model.traceable.ITracePoint;
import com.bytedance.jedi.model.traceable.ITraceable;
import com.bytedance.jedi.model.traceable.ITraceableObserved;
import com.bytedance.jedi.model.traceable.Traceable;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/model/cache/AbstractCache;", "K", "V", "Lcom/bytedance/jedi/model/cache/ICache;", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public abstract class AbstractCache<K, V> implements ICache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f251048a;

    public abstract V b(K r100);

    public abstract void g(K r100, V r101);

    public AbstractCache() {
        this.f251048a = LazyKt.lazy(new AbstractCache$dataSource$2(this));
    }

    @Override // com.bytedance.jedi.model.cache.ICache
    public final Observable<Optional<V>> get(K r100) {
        return Observable.just(OptionalKt.a(b(r100)));
    }

    public final void c(K r100, V r101) {
        g(r100, r101);
        Map<ITracePoint<?>, Map<?, ITraceable<?>>> r102 = PointcutKt.f251050a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(this, "<this>");
        IDataSource r103 = (IDataSource) this.f251048a.getValue();
        if ((r103 instanceof ITraceableObserved) == false) goto L5;
        ITraceableObserved r104 = (ITraceableObserved) r103;
    L6:
        if (r104 == null) goto L16;
        Map<ITracePoint<?>, Map<?, ITraceable<?>>> r105 = PointcutKt.f251050a;
        if (r105.get(this) == null) goto L13;
        Map<?, ITraceable<?>> r106 = r105.get(this);
        Intrinsics.checkNotNull(r106);
        if (r106.get(r100) == null) goto L13;
        Map<?, ITraceable<?>> r107 = r105.get(this);
        Intrinsics.checkNotNull(r107);
        ITraceable<?> r108 = r107.get(r100);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.bytedance.jedi.model.traceable.ITraceable<kotlin.Pair<K of com.bytedance.jedi.model.cache.PointcutKt.fire$lambda$0, V of com.bytedance.jedi.model.cache.PointcutKt.fire$lambda$0?>>");
        ITraceable<?> r109 = r108;
    L14:
        r104.b(r109);
        return;
    L13:
        r109 = Traceable.Companion.a(Traceable.f251191c, TuplesKt.to(r100, r101));
        goto L14
    L16:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
