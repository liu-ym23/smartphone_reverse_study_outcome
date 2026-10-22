package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {

    /* JADX INFO: loaded from: classes42.dex */
    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f504588id;

        public AbstractArrayMapAccessor(int r100) {
            this.f504588id = r100;
        }

        public final T extractValue(AbstractArrayMapOwner<K, V> r100) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            return r100.getArrayMap().get(this.f504588id);
        }
    }

    public AbstractArrayMapOwner() {
    }

    public abstract ArrayMap<V> getArrayMap();

    public abstract TypeRegistry<K, V> getTypeRegistry();

    public abstract void registerComponent(String r100, V r101);

    public final boolean isEmpty() {
        if (getArrayMap().getSize() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<V> iterator() {
        return getArrayMap().iterator();
    }

    public final void registerComponent(KClass<? extends K> r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "tClass");
        Intrinsics.checkNotNullParameter(r101, "value");
        String r102 = r100.getQualifiedName();
        Intrinsics.checkNotNull(r102);
        registerComponent(r102, r101);
    }
}
