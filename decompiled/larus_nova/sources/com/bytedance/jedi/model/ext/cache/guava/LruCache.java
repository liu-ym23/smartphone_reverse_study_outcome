package com.bytedance.jedi.model.ext.cache.guava;

import com.bytedance.jedi.model.cache.AbstractCache;
import com.bytedance.jedi.model.guava.cache.Cache;
import com.bytedance.jedi.model.guava.cache.CacheBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/ext/cache/guava/LruCache;", "K", "V", "Lcom/bytedance/jedi/model/cache/AbstractCache;", "ext_cache_guava_release"}, k = 1, mv = {1, 7, 1})
public class LruCache<K, V> extends AbstractCache<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CacheImpl<K, V> f251069b;

    public /* synthetic */ LruCache() {
        this(-1);
    }

    public List<Pair<K, V>> h() {
        CacheImpl<K, V> r100 = this.f251069b;
        r100.getClass();
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<K, V>> r102 = r100.f251068a.asMap().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<K, V> r103 = r102.next();
        r101.add(TuplesKt.to(r103.getKey(), r103.getValue()));
        goto L4
    L6:
        return r101;
    }

    public LruCache(long r100) {
        if (r100 <= 0) goto L5;
        CacheBuilder<Object, Object> r101 = CacheBuilder.c();
        r101.b(r100);
        Cache r102 = r101.a();
    L6:
        this.f251069b = new CacheImpl(r102);
        return;
    L5:
        r102 = CacheBuilder.c().a();
        goto L6
    }

    @Override // com.bytedance.jedi.model.cache.AbstractCache
    public void g(K r100, V r101) {
        CacheImpl<K, V> r102 = this.f251069b;
        if (r101 == null) goto L5;
        r102.f251068a.put(r100, r101);
        return;
    L5:
        r102.f251068a.invalidate(r100);
    }
}
