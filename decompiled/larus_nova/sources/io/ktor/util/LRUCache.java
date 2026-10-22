package io.ktor.util;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B7\b\u0000\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011H\u0014R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/ktor/util/LRUCache;", "K", "V", "Ljava/util/LinkedHashMap;", "supplier", "Lkotlin/Function1;", "close", "", "maxSize", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;I)V", MonitorConstants.CONNECT_TYPE_GET, "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "removeEldestEntry", "", "eldest", "", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final Function1<V, Unit> close;
    private final int maxSize;
    private final Function1<K, V> supplier;

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return (Set<Map.Entry<K, V>>) getEntries();
    }

    public /* bridge */ Set<Map.Entry<Object, Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<Object> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) getValues();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object r100) {
        if (this.maxSize == 0) goto L19;
        monitor-enter(this);
        V r101 = (V) super.get(r100);
        if (r101 == null) goto L10;
        monitor-exit(this);
        return r101;
    L10:
        V r102 = this.supplier.invoke(r100);     // Catch: Throwable -> L14
        put(r100, r102);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r102;
    L14:
        th = move-exception;
        throw th;
    L19:
        return this.supplier.invoke(r100);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "eldest");
        if (size() <= this.maxSize) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        this.close.invoke(r100.getValue());
    L8:
        return r101;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LRUCache(Function1<? super K, ? extends V> r100, Function1<? super V, Unit> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "supplier");
        Intrinsics.checkNotNullParameter(r101, "close");
        super(10, 0.75f, true);
        this.supplier = r100;
        this.close = r101;
        this.maxSize = r102;
    }
}
