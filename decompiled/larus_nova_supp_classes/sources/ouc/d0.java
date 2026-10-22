package ouc;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Serializable(with = f0.class)
public final class d0 extends i implements Map<String, i>, KMappedMarker {
    public static final a Companion = null;
    public final Map<String, i> a;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i compute(String r1, BiFunction<? super String, ? super i, ? extends i> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i computeIfAbsent(String r1, Function<? super String, ? extends i> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i computeIfPresent(String r1, BiFunction<? super String, ? super i, ? extends i> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i merge(String r1, i r2, BiFunction<? super i, ? super i, ? extends i> r3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i put(String r1, i r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends i> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i putIfAbsent(String r1, i r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean remove(Object r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i replace(String r1, i r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String r1, i r2, i r3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super i, ? extends i> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    static {
        Companion = new a();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, i>> entrySet() {
        return this.a.entrySet();
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.a.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.a.size();
    }

    public final String toString() {
        return CollectionsKt.joinToString$default(this.a.entrySet(), ",", "{", "}", 0, null, new c0(), 24, null);
    }

    @Override // java.util.Map
    public final Collection<i> values() {
        return this.a.values();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(Map<String, ? extends i> r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.a = r2;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return false;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.a.containsKey(r3);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r2) {
        if ((r2 instanceof i) == true) goto L6;
        return false;
    L6:
        i r3 = (i) r2;
        Intrinsics.checkNotNullParameter(r3, "value");
        return this.a.containsValue(r3);
    }

    @Override // java.util.Map
    public final boolean equals(Object r2) {
        return Intrinsics.areEqual(this.a, r2);
    }

    @Override // java.util.Map
    public final i get(Object r2) {
        if ((r2 instanceof String) == true) goto L6;
        return null;
    L6:
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.a.get(r3);
    }

    @Override // java.util.Map
    public final i remove(Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
