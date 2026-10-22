package dagger.internal;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    private final Map<K, Provider<V>> contributingMap;

    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap<K, Provider<V>> map;

        public Builder(int r100) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(r100);
        }

        public Builder<K, V, V2> putAll(Provider<Map<K, V2>> r100) {
            if ((r100 instanceof DelegateFactory) == true) goto L5;
            this.map.putAll(AbstractMapFactory.access$000((AbstractMapFactory) r100));
            return this;
        L5:
            return putAll(((DelegateFactory) r100).getDelegate());
        }

        public Builder<K, V, V2> put(K r100, Provider<V> r101) {
            LinkedHashMap<K, Provider<V>> r102 = this.map;
            Object r103 = Preconditions.checkNotNull(r100, "key");
            r102.put((K) r103, (Provider) Preconditions.checkNotNull(r101, ShortVideoSegments.KEY_PROP_PROVIDER));
            return this;
        }
    }

    public final Map<K, Provider<V>> contributingMap() {
        return this.contributingMap;
    }

    public AbstractMapFactory(Map<K, Provider<V>> r100) {
        this.contributingMap = Collections.unmodifiableMap(r100);
    }

    public static /* synthetic */ Map access$000(AbstractMapFactory r100) {
        return r100.contributingMap;
    }
}
