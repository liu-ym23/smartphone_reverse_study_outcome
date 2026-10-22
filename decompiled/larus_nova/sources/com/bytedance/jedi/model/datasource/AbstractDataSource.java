package com.bytedance.jedi.model.datasource;

import com.bytedance.jedi.model.traceable.ITracePoint;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/datasource/AbstractDataSource;", "K", "V", "Lcom/bytedance/jedi/model/datasource/IDataSource;", "model_release"}, k = 1, mv = {1, 7, 1})
public abstract class AbstractDataSource<K, V> implements IDataSource<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ITracePoint<Pair<K, V>>> f251062a;

    @Override // com.bytedance.jedi.model.datasource.IDataSource
    public final ITracePoint<Pair<K, V>> c() {
        return this.f251062a.get();
    }

    public AbstractDataSource(ITracePoint<Pair<K, V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        this.f251062a = new WeakReference(r100);
    }
}
