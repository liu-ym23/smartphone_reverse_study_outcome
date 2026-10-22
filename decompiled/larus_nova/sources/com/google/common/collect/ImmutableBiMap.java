package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements m<K, V> {

    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<K, V> r100) {
            super(r100);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public a<K, V> makeBuilder(int r100) {
            return new a(r100);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public /* bridge */ /* synthetic */ ImmutableMap.b makeBuilder(int r100) {
            return makeBuilder(r100);
        }
    }

    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public a() {
            super(4);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final ImmutableMap c() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        public final ImmutableBiMap<K, V> i() {
            if (this.f275072b != 0) goto L7;
            return ImmutableBiMap.of();
        L7:
            return new RegularImmutableBiMap(this.f275071a, this.f275072b);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final ImmutableMap a() {
            return i();
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final /* bridge */ /* synthetic */ ImmutableMap d() {
            return i();
        }

        public a(int r100) {
            super(r100);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final void f(Map.Entry r100) {
            super.f(r100);
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final ImmutableMap.b g(Iterable r100) {
            super.g(r100);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public final void h(ImmutableMap r100) {
            super.g(r100.entrySet());
        }

        public final void j(Iterable r100) {
            super.g(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.b
        public final ImmutableMap.b e(Object r100, Object r101) {
            super.e(r100, r101);
            return this;
        }
    }

    @Override // com.google.common.collect.m
    public abstract ImmutableBiMap<V, K> inverse();

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // com.google.common.collect.m
    public /* bridge */ /* synthetic */ m inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    public ImmutableBiMap() {
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @Override // com.google.common.collect.ImmutableMap
    public /* bridge */ /* synthetic */ ImmutableCollection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ ImmutableCollection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return values();
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int r100) {
        o.b(r100, "expectedSize");
        return new a(r100);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r100) {
        if ((r100 instanceof Collection) == false) goto L5;
        int r101 = ((Collection) r100).size();
    L6:
        a r102 = new a(r101);
        r102.j(r100);
        return r102.i();
    L5:
        r101 = 4;
        goto L6
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... r100) {
        return copyOf(Arrays.asList(r100));
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> r100) {
        if ((r100 instanceof ImmutableBiMap) == false) goto L8;
        ImmutableBiMap<K, V> r101 = (ImmutableBiMap) r100;
        if (r101.isPartialView() == true) goto L8;
        return r101;
    L8:
        return copyOf(r100.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r100, V r101) {
        o.a(r100, r101);
        return new RegularImmutableBiMap(new Object[]{r100, r101}, 1);
    }

    @Override // com.google.common.collect.m
    @CheckForNull
    public final V forcePut(K r100, V r101) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r100, V r101, K r102, V r103) {
        o.a(r100, r101);
        o.a(r102, r103);
        return new RegularImmutableBiMap(new Object[]{r100, r101, r102, r103}, 2);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        return new RegularImmutableBiMap(new Object[]{r100, r101, r102, r103, r104, r105}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r110) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r106, r110);
        return new RegularImmutableBiMap(new Object[]{r100, r101, r102, r103, r104, r105, r106, r110}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r110, K r111, V r112) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r106, r110);
        o.a(r111, r112);
        return new RegularImmutableBiMap(new Object[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112}, 5);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r110, K r111, V r112, K r113, V r114) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r106, r110);
        o.a(r111, r112);
        o.a(r113, r114);
        return new RegularImmutableBiMap(new Object[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114}, 6);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r110, V r111, K r112, V r113, K r114, V r115, K r116, V r117) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r110, r111);
        o.a(r112, r113);
        o.a(r114, r115);
        o.a(r116, r117);
        return new RegularImmutableBiMap(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117}, 7);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r110, V r111, K r112, V r113, K r114, V r115, K r116, V r117, K r118, V r119) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r110, r111);
        o.a(r112, r113);
        o.a(r114, r115);
        o.a(r116, r117);
        o.a(r118, r119);
        return new RegularImmutableBiMap(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119}, 8);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r110, V r111, K r112, V r113, K r114, V r115, K r116, V r117, K r118, V r119, K r210, V r211) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r110, r111);
        o.a(r112, r113);
        o.a(r114, r115);
        o.a(r116, r117);
        o.a(r118, r119);
        o.a(r210, r211);
        return new RegularImmutableBiMap(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211}, 9);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r110, V r111, K r112, V r113, K r114, V r115, K r116, V r117, K r118, V r119, K r210, V r211, K r212, V r213) {
        o.a(r100, r101);
        o.a(r102, r103);
        o.a(r104, r105);
        o.a(r110, r111);
        o.a(r112, r113);
        o.a(r114, r115);
        o.a(r116, r117);
        o.a(r118, r119);
        o.a(r210, r211);
        o.a(r212, r213);
        return new RegularImmutableBiMap(new Object[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213}, 10);
    }
}
