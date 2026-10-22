package com.bytedance.jedi.model.datasource;

import com.bytedance.jedi.model.traceable.ITracePoint;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/datasource/IDataSource;", "K", "V", "", "model_release"}, k = 1, mv = {1, 7, 1})
public interface IDataSource<K, V> {
    Observable<Optional<V>> a(K r100);

    ITracePoint<Pair<K, V>> c();
}
