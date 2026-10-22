package com.bytedance.jedi.model.keyless;

import com.bytedance.jedi.model.fetcher.IFetcher;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/jedi/model/keyless/ISingleFetcher;", "V", "RESP", "Lcom/bytedance/jedi/model/fetcher/IFetcher;", "", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public interface ISingleFetcher<V, RESP> extends IFetcher<Unit, V, Unit, RESP> {
    Observable<RESP> request();
}
