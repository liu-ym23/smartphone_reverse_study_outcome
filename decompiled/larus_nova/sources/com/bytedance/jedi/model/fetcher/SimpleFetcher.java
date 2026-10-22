package com.bytedance.jedi.model.fetcher;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/model/fetcher/SimpleFetcher;", "K", "V", "Lcom/bytedance/jedi/model/fetcher/AbstractFetcher;", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public abstract class SimpleFetcher<K, V> extends AbstractFetcher<K, V, K, V> {
    @Override // com.bytedance.jedi.model.fetcher.IFetcher
    public final K d(K r100) {
        return r100;
    }

    @Override // com.bytedance.jedi.model.fetcher.IFetcher
    public final V e(K r100, V r101) {
        return r101;
    }

    public SimpleFetcher() {
    }
}
