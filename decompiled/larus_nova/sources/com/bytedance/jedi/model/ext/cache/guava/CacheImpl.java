package com.bytedance.jedi.model.ext.cache.guava;

import com.bytedance.jedi.model.guava.cache.Cache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/ext/cache/guava/CacheImpl;", "K", "V", "", "ext_cache_guava_release"}, k = 1, mv = {1, 7, 1})
public final class CacheImpl<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache<K, V> f251068a;

    public CacheImpl(Cache<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "mRealCache");
        this.f251068a = r100;
    }
}
