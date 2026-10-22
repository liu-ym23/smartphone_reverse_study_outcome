package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class x<K, V> extends v<K, V> implements c0<K, V> {
    @Override // com.google.common.collect.c0
    public final k2<K, V> a() {
        return (k2) this.f275519f;
    }

    @Override // com.google.common.collect.c
    public final Collection createEntries() {
        return Sets.b(((k2) this.f275519f).entries(), this.f275520g);
    }

    @Override // com.google.common.collect.a0
    public final k2 d() {
        return (k2) this.f275519f;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public final Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public final /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.q1
    public final Set<V> get(@ParametricNullness K r100) {
        return (Set) v.b(this.f275519f.get(r100), new v.c(this, r100));
    }

    @Override // com.google.common.collect.q1
    public final Set<V> removeAll(@CheckForNull Object r100) {
        Collection<V> r101 = asMap().remove(r100);
        if ((this.f275519f instanceof k2) == false) goto L5;
        Object r102 = Collections.emptySet();
    L7:
        return (Set) ((Collection) com.google.common.base.j.a(r101, r102));
    L5:
        r102 = Collections.emptyList();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.q1
    public final /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object r100) {
        return get(r100);
    }

    @Override // com.google.common.collect.q1
    public final /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
        return removeAll(r100);
    }

    public x(k2<K, V> r100, com.google.common.base.n<? super Map.Entry<K, V>> r101) {
        super(r100, r101);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public final Set<V> replaceValues(@ParametricNullness K r100, Iterable<? extends V> r101) {
        return (Set) super.replaceValues(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.q1
    public final /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object r100, Iterable r101) {
        return replaceValues(r100, r101);
    }
}
