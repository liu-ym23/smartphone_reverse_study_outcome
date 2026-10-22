package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TypeRegistry<K, V> {
    private final AtomicInteger idCounter;
    private final ConcurrentHashMap<String, Integer> idPerType;

    public static /* synthetic */ int accessor$TypeRegistry$lambda0(TypeRegistry r100, String r101) {
        return getId$lambda$0(r100, r101);
    }

    public abstract int customComputeIfAbsent(ConcurrentHashMap<String, Integer> r100, String r101, Function1<? super String, Integer> r102);

    public final Collection<Integer> getIndices() {
        return this.idPerType.values();
    }

    public TypeRegistry() {
        this.idPerType = new ConcurrentHashMap();
        this.idCounter = new AtomicInteger(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(KClass<KK> r100) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        return new NullableArrayMapAccessor(getId(r100));
    }

    public final int getId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyQualifiedName");
        return customComputeIfAbsent(this.idPerType, r100, new TypeRegistry$$Lambda$0(this));
    }

    public final <T extends K> int getId(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        String r101 = r100.getQualifiedName();
        Intrinsics.checkNotNull(r101);
        return getId(r101);
    }

    private static final int getId$lambda$0(TypeRegistry r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNullParameter(r101, "it");
        return r100.idCounter.getAndIncrement();
    }
}
