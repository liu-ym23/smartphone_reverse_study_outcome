package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class MultimapBuilder<K0, V0> {

    public static final class ArrayListSupplier<V> implements com.google.common.base.t<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        @Override // com.google.common.base.t
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }

        @Override // com.google.common.base.t
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        public ArrayListSupplier(int r100) {
            o.b(r100, "expectedValuesPerKey");
            this.expectedValuesPerKey = r100;
        }
    }

    public static final class EnumSetSupplier<V extends Enum<V>> implements com.google.common.base.t<Set<V>>, Serializable {
        private final Class<V> clazz;

        @Override // com.google.common.base.t
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }

        @Override // com.google.common.base.t
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        public EnumSetSupplier(Class<V> r100) {
            r100.getClass();
            this.clazz = r100;
        }
    }

    public static final class HashSetSupplier<V> implements com.google.common.base.t<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        @Override // com.google.common.base.t
        public Set<V> get() {
            return CompactHashSet.createWithExpectedSize(this.expectedValuesPerKey);
        }

        @Override // com.google.common.base.t
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        public HashSetSupplier(int r100) {
            o.b(r100, "expectedValuesPerKey");
            this.expectedValuesPerKey = r100;
        }
    }

    public static final class LinkedHashSetSupplier<V> implements com.google.common.base.t<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        @Override // com.google.common.base.t
        public Set<V> get() {
            return CompactLinkedHashSet.createWithExpectedSize(this.expectedValuesPerKey);
        }

        @Override // com.google.common.base.t
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        public LinkedHashSetSupplier(int r100) {
            o.b(r100, "expectedValuesPerKey");
            this.expectedValuesPerKey = r100;
        }
    }

    public static final enum LinkedListSupplier extends Enum<LinkedListSupplier> implements com.google.common.base.t<List<?>> {
        public static final LinkedListSupplier INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkedListSupplier[] f275267a = null;

        static {
            LinkedListSupplier r100 = new LinkedListSupplier();
            INSTANCE = r100;
            f275267a = new LinkedListSupplier[]{r100};
        }

        public LinkedListSupplier() {
            super("INSTANCE", 0);
        }

        public static LinkedListSupplier[] values() {
            return (LinkedListSupplier[]) f275267a.clone();
        }

        @Override // com.google.common.base.t
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public List<?> get2() {
            return new LinkedList();
        }

        public static <V> com.google.common.base.t<List<V>> instance() {
            return INSTANCE;
        }

        @Override // com.google.common.base.t
        public /* bridge */ /* synthetic */ List<?> get() {
            return get2();
        }

        public static LinkedListSupplier valueOf(String r100) {
            return (LinkedListSupplier) r27.a.a(LinkedListSupplier.class, r100);
        }
    }

    public static final class TreeSetSupplier<V> implements com.google.common.base.t<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        @Override // com.google.common.base.t
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }

        @Override // com.google.common.base.t
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        public TreeSetSupplier(Comparator<? super V> r100) {
            r100.getClass();
            this.comparator = r100;
        }
    }

    public static abstract class a<K0, V0> extends MultimapBuilder<K0, V0> {
        public a() {
        }
    }

    public static abstract class b<K0> {
        public b() {
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> a();
    }

    public static abstract class c<K0, V0> extends MultimapBuilder<K0, V0> {
        public c() {
        }
    }

    public MultimapBuilder() {
    }
}
