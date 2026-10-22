package com.google.common.collect;

import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = null;
    final transient Object[] alternatingKeysAndValues;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @CheckForNull
    public final transient Object f275298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f275299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f275300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final transient RegularImmutableBiMap<V, K> f275301h;

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    static {
        EMPTY = new RegularImmutableBiMap();
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.f275299f, this.f275300g);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.f275299f, this.f275300g));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RegularImmutableBiMap() {
        this.f275298e = null;
        this.alternatingKeysAndValues = new Object[0];
        this.f275299f = 0;
        this.f275300g = 0;
        this.f275301h = this;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.m
    public /* bridge */ /* synthetic */ m inverse() {
        return inverse();
    }

    @Override // java.util.Map
    public int size() {
        return this.f275300g;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.m
    public ImmutableBiMap<V, K> inverse() {
        return this.f275301h;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r100) {
        V r101 = (V) RegularImmutableMap.get(this.f275298e, this.alternatingKeysAndValues, this.f275300g, this.f275299f, r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101;
    }

    public RegularImmutableBiMap(Object[] r100, int r101) {
        this.alternatingKeysAndValues = r100;
        this.f275300g = r101;
        this.f275299f = 0;
        if (r101 < 2) goto L5;
        int r102 = ImmutableSet.chooseTableSize(r101);
    L6:
        this.f275298e = RegularImmutableMap.createHashTableOrThrow(r100, r101, r102, 0);
        this.f275301h = new RegularImmutableBiMap(RegularImmutableMap.createHashTableOrThrow(r100, r101, r102, 1), r100, r101, this);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public RegularImmutableBiMap(@CheckForNull Object r100, Object[] r101, int r102, RegularImmutableBiMap<V, K> r103) {
        this.f275298e = r100;
        this.alternatingKeysAndValues = r101;
        this.f275299f = 1;
        this.f275300g = r102;
        this.f275301h = r103;
    }
}
