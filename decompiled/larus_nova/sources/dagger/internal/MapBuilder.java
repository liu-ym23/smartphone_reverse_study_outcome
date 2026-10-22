package dagger.internal;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class MapBuilder<K, V> {
    private final Map<K, V> contributions;

    public Map<K, V> build() {
        if (this.contributions.isEmpty() == false) goto L7;
        return Collections.emptyMap();
    L7:
        return Collections.unmodifiableMap(this.contributions);
    }

    private MapBuilder(int r100) {
        this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(r100);
    }

    public static <K, V> MapBuilder<K, V> newMapBuilder(int r100) {
        return new MapBuilder(r100);
    }

    public MapBuilder<K, V> putAll(Map<K, V> r100) {
        this.contributions.putAll(r100);
        return this;
    }

    public MapBuilder<K, V> put(K r100, V r101) {
        this.contributions.put(r100, r101);
        return this;
    }
}
