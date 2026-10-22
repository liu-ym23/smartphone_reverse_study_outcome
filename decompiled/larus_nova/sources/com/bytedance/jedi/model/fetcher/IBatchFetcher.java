package com.bytedance.jedi.model.fetcher;

import com.bytedance.jedi.model.traceable.ITracePoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/model/fetcher/IBatchFetcher;", "K", "V", "RESP", "Lcom/bytedance/jedi/model/traceable/ITracePoint;", "Lkotlin/Pair;", "model_release"}, k = 1, mv = {1, 7, 1})
public interface IBatchFetcher<K, V, RESP> extends ITracePoint<Pair<? extends K, ? extends V>> {
    List f();
}
