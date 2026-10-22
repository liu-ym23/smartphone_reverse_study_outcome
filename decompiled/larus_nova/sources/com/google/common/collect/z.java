package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class z<K, V> extends y<K, V> implements c0<K, V> {

    public class a extends y<K, V>.c implements Set<Map.Entry<K, V>> {
        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            return Sets.c(this);
        }

        public a(z r100) {
            super(r100);
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(@CheckForNull Object r100) {
            return Sets.a(this, r100);
        }
    }

    @Override // com.google.common.collect.c0
    public final k2<K, V> a() {
        return (k2) this.f275539f;
    }

    @Override // com.google.common.collect.c
    public final Collection createEntries() {
        return new a(this);
    }

    @Override // com.google.common.collect.a0
    public final k2 d() {
        return (k2) this.f275539f;
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
        if (this.f275540g.apply(r100) == false) goto L6;
        Collection<V> r101 = this.f275539f.get(r100);
    L11:
        return (Set) r101;
    L6:
        if ((this.f275539f instanceof k2) == false) goto L8;
        Collection<V> r102 = new y.b(r100);
    L9:
        r101 = r102;
        goto L11
    L8:
        r102 = new y.a(r100);
        goto L9
    }

    @Override // com.google.common.collect.q1
    public final Set<V> removeAll(@CheckForNull Object r100) {
        if (containsKey(r100) == false) goto L6;
        Collection<V> r101 = this.f275539f.removeAll(r100);
    L10:
        return (Set) r101;
    L6:
        if ((this.f275539f instanceof k2) == false) goto L8;
        r101 = Collections.emptySet();
        goto L10
    L8:
        r101 = Collections.emptyList();
        goto L10
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

    public z(k2<K, V> r100, com.google.common.base.n<? super K> r101) {
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
