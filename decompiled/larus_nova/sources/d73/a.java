package d73;

import com.bytedance.jedi.model.ext.cache.guava.LruCache;
import com.bytedance.jedi.model.guava.cache.Cache;
import com.bytedance.jedi.model.guava.cache.CacheBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes12.dex */
public class a<K, V> extends LruCache<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<K, V> f467228c;

    @Override // com.bytedance.jedi.model.ext.cache.guava.LruCache
    public final List<Pair<K, V>> h() {
        b<K, V> r100 = this.f467228c;
        r100.getClass();
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<K, V>> r102 = r100.f467229a.asMap().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<K, V> r103 = r102.next();
        r101.add(TuplesKt.to(r103.getKey(), r103.getValue()));
        goto L4
    L6:
        return r101;
    }

    public a(long r100) {
        super(r100);
        if (r100 <= 0) goto L5;
        CacheBuilder<Object, Object> r101 = CacheBuilder.c();
        r101.b(r100);
        Cache r102 = r101.a();
    L6:
        this.f467228c = new b(r102);
        return;
    L5:
        r102 = CacheBuilder.c().a();
        goto L6
    }
}
