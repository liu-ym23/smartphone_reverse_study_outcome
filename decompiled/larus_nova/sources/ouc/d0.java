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

/* JADX INFO: loaded from: classes.dex */
@Serializable(with = f0.class)
public final class d0 extends i implements Map<String, i>, KMappedMarker {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, i> f526813a;

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a {
        public a() {
        }

        public final juc.d<d0> serializer() {
            return f0.f526848a;
        }
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i compute(String r100, BiFunction<? super String, ? super i, ? extends i> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i computeIfAbsent(String r100, Function<? super String, ? extends i> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i computeIfPresent(String r100, BiFunction<? super String, ? super i, ? extends i> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f526813a.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i merge(String r100, i r101, BiFunction<? super i, ? super i, ? extends i> r102) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i put(String r100, i r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends i> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i putIfAbsent(String r100, i r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean remove(Object r100, Object r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ i replace(String r100, i r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String r100, i r101, i r102) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super i, ? extends i> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    static {
        Companion = new a();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, i>> entrySet() {
        return this.f526813a.entrySet();
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f526813a.hashCode();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f526813a.keySet();
    }

    @Override // java.util.Map
    public final int size() {
        return this.f526813a.size();
    }

    public final String toString() {
        return CollectionsKt.joinToString$default(this.f526813a.entrySet(), ",", "{", com.alipay.sdk.m.u.i.f25855d, 0, null, new c0(), 24, null);
    }

    @Override // java.util.Map
    public final Collection<i> values() {
        return this.f526813a.values();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(Map<String, ? extends i> r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f526813a = r100;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return false;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f526813a.containsKey(r101);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        i r101 = (i) r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        return this.f526813a.containsValue(r101);
    }

    @Override // java.util.Map
    public final boolean equals(Object r100) {
        return Intrinsics.areEqual(this.f526813a, r100);
    }

    @Override // java.util.Map
    public final i get(Object r100) {
        if ((r100 instanceof String) == true) goto L6;
        return null;
    L6:
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f526813a.get(r101);
    }

    @Override // java.util.Map
    public final i remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
