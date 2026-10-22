package com.bytedance.jedi.model.fetcher;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/jedi/model/fetcher/AbstractBatchFetcher;", "K", "V", "RESP", "Lcom/bytedance/jedi/model/fetcher/IBatchFetcher;", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public abstract class AbstractBatchFetcher<K, V, RESP> implements IBatchFetcher<K, V, RESP> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f251070a;

    public AbstractBatchFetcher() {
        this.f251070a = LazyKt.lazy(new AbstractBatchFetcher$dataSource$2(this));
    }
}
