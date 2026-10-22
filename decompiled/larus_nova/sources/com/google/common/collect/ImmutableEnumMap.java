package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient EnumMap<K, V> f275058e;

    public static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        public Object readResolve() {
            return new ImmutableEnumMap(this.delegate, null);
        }

        public EnumSerializedForm(EnumMap<K, V> r100) {
            this.delegate = r100;
        }
    }

    public static /* synthetic */ class a {
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public z2<Map.Entry<K, V>> entryIterator() {
        return new m1(this.f275058e.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap
    public z2<K> keyIterator() {
        return Iterators.i(this.f275058e.keySet().iterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.f275058e.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new EnumSerializedForm(this.f275058e);
    }

    public ImmutableEnumMap(EnumMap<K, V> r100) {
        this.f275058e = r100;
        com.google.common.base.m.b(!r100.isEmpty());
    }

    public static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> r100) {
        int r101 = r100.size();
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L7;
        Map.Entry r102 = (Map.Entry) a1.b(r100.entrySet());
        return ImmutableMap.of((Enum) r102.getKey(), r102.getValue());
    L7:
        return new ImmutableEnumMap(r100);
    L11:
        return ImmutableMap.of();
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use EnumSerializedForm");
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@CheckForNull Object r100) {
        return this.f275058e.containsKey(r100);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImmutableEnumMap) == false) goto L9;
        r100 = ((ImmutableEnumMap) r100).f275058e;
    L9:
        return this.f275058e.equals(r100);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r100) {
        return this.f275058e.get(r100);
    }

    public /* synthetic */ ImmutableEnumMap(EnumMap r100, a r101) {
        this(r100);
    }
}
