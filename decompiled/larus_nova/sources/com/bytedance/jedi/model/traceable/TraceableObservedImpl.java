package com.bytedance.jedi.model.traceable;

import com.jakewharton.rxrelay2.b;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/jedi/model/traceable/TraceableObservedImpl;", "K", "V", "Lcom/bytedance/jedi/model/traceable/ITraceableObserved;", "Lkotlin/Pair;", "model_release"}, k = 1, mv = {1, 7, 1})
public final class TraceableObservedImpl<K, V> implements ITraceableObserved<Pair<? extends K, ? extends V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ITracePoint<Pair<K, V>>> f251194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f251195b;

    public TraceableObservedImpl(ITracePoint<Pair<K, V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        this.f251194a = new WeakReference(r100);
        this.f251195b = LazyKt.lazy(TraceableObservedImpl$subject$2.INSTANCE);
    }

    @Override // com.bytedance.jedi.model.traceable.ITraceableObserved
    public final void b(ITraceable<Pair<K, V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "traceable");
        ((b) this.f251195b.getValue()).accept(r100);
    }
}
