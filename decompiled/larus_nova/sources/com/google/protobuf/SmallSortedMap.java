package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes23.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private List<SmallSortedMap<K, V>.Entry> entryList;
    private boolean isImmutable;
    private volatile SmallSortedMap<K, V>.EntrySet lazyEntrySet;
    private final int maxArraySize;
    private Map<K, V> overflowEntries;

    public static class EmptySet {
        private static final Iterable<Object> ITERABLE = null;
        private static final Iterator<Object> ITERATOR = null;

        private EmptySet() {
        }

        static {
            ITERATOR = new AnonymousClass1();
            ITERABLE = new AnonymousClass2();
        }

        public static /* synthetic */ Iterator access$700() {
            return ITERATOR;
        }

        public static <T> Iterable<T> iterable() {
            return (Iterable<T>) ITERABLE;
        }
    }

    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {
        private final K key;
        final /* synthetic */ SmallSortedMap this$0;
        private V value;

        @Override // java.util.Map.Entry
        public int hashCode() {
            K r100 = this.key;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            V r103 = this.value;
            if (r103 == null) goto L11;
            r101 = r103.hashCode();
        L11:
            return r102 ^ r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return this.key + ContainerUtils.KEY_VALUE_DELIMITER + this.value;
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return getKey();
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        public int compareTo(SmallSortedMap<K, V>.Entry r100) {
            return getKey().compareTo(r100.getKey());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof Map.Entry) == true) goto L8;
            return false;
        L8:
            Map.Entry r101 = (Map.Entry) r100;
            if (equals(this.key, r101.getKey()) == true) goto L11;
        L13:
            return false;
        L11:
            if (equals(this.value, r101.getValue()) == false) goto L13;
            return true;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r100) {
            SmallSortedMap.access$200(this.this$0);
            V r101 = this.value;
            this.value = r100;
            return r101;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r100) {
            return compareTo((Entry) r100);
        }

        public Entry(SmallSortedMap r100, Map.Entry<K, V> r101) {
            this(r100, r101.getKey(), r101.getValue());
        }

        private boolean equals(Object r100, Object r101) {
            if (r100 != null) goto L7;
            if (r101 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return r100.equals(r101);
        }

        public Entry(SmallSortedMap r100, K r101, V r102) {
            this.this$0 = r100;
            this.key = r101;
            this.value = r102;
        }
    }

    public class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private Iterator<Map.Entry<K, V>> lazyOverflowIterator;
        private boolean nextCalledBeforeRemove;
        private int pos;
        final /* synthetic */ SmallSortedMap this$0;

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.nextCalledBeforeRemove = true;
            int r100 = this.pos + 1;
            this.pos = r100;
            if (r100 >= SmallSortedMap.access$400(this.this$0).size()) goto L7;
            return (Map.Entry) ListProtector.get(SmallSortedMap.access$400(this.this$0), this.pos);
        L7:
            return getOverflowIterator().next();
        }

        private Iterator<Map.Entry<K, V>> getOverflowIterator() {
            if (this.lazyOverflowIterator != null) goto L6;
            this.lazyOverflowIterator = SmallSortedMap.access$500(this.this$0).entrySet().iterator();
        L6:
            return this.lazyOverflowIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if ((this.pos + 1) >= SmallSortedMap.access$400(this.this$0).size()) goto L5;
            return true;
        L5:
            if (SmallSortedMap.access$500(this.this$0).isEmpty() == false) goto L7;
        L9:
            return false;
        L7:
            if (getOverflowIterator().hasNext() == false) goto L9;
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.nextCalledBeforeRemove == false) goto L10;
            this.nextCalledBeforeRemove = false;
            SmallSortedMap.access$200(this.this$0);
            if (this.pos >= SmallSortedMap.access$400(this.this$0).size()) goto L7;
            SmallSortedMap r100 = this.this$0;
            int r101 = this.pos;
            this.pos = r101 - 1;
            SmallSortedMap.access$600(r100, r101);
            return;
        L7:
            getOverflowIterator().remove();
            return;
        L10:
            throw new IllegalStateException("remove() was called before next()");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        private EntryIterator(SmallSortedMap r100) {
            this.this$0 = r100;
            this.pos = -1;
        }

        public /* synthetic */ EntryIterator(SmallSortedMap r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ SmallSortedMap this$0;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(this.this$0, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }

        private EntrySet(SmallSortedMap r100) {
            this.this$0 = r100;
        }

        public boolean add(Map.Entry<K, V> r100) {
            if (contains(r100) == true) goto L6;
            this.this$0.put(r100.getKey(), r100.getValue());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r100) {
            Map.Entry r101 = (Map.Entry) r100;
            Object r102 = this.this$0.get(r101.getKey());
            Object r103 = r101.getValue();
            if (r102 == r103) goto L9;
            if (r102 != null) goto L6;
        L8:
            return false;
        L6:
            if (r102.equals(r103) == false) goto L8;
        L9:
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r100) {
            Map.Entry r101 = (Map.Entry) r100;
            if (contains(r101) == false) goto L6;
            this.this$0.remove(r101.getKey());
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object r100) {
            return add((Map.Entry) r100);
        }

        public /* synthetic */ EntrySet(SmallSortedMap r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    private void checkMutable() {
        if (this.isImmutable == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.lazyEntrySet != null) goto L6;
        this.lazyEntrySet = new EntrySet(this, null);
    L6:
        return this.lazyEntrySet;
    }

    public int getNumArrayEntries() {
        return this.entryList.size();
    }

    public int getNumOverflowEntries() {
        return this.overflowEntries.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        if (this.overflowEntries.isEmpty() == false) goto L6;
        return EmptySet.iterable();
    L6:
        return this.overflowEntries.entrySet();
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        if (this.overflowEntries.isEmpty() == false) goto L7;
        Map<K, V> r100 = Collections.emptyMap();
    L8:
        this.overflowEntries = r100;
        this.isImmutable = true;
        return;
    L7:
        r100 = Collections.unmodifiableMap(this.overflowEntries);
        goto L8
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.entryList.size() + this.overflowEntries.size();
    }

    private void ensureEntryArrayMutable() {
        checkMutable();
        if (this.entryList.isEmpty() == true) goto L5;
        return;
    L5:
        if ((this.entryList instanceof ArrayList) == true) goto L9;
        this.entryList = new ArrayList(this.maxArraySize);
        return;
    }

    private SortedMap<K, V> getOverflowEntriesMutable() {
        checkMutable();
        if (this.overflowEntries.isEmpty() == false) goto L8;
        if ((this.overflowEntries instanceof TreeMap) == true) goto L8;
        this.overflowEntries = new TreeMap();
    L8:
        return (SortedMap) this.overflowEntries;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        checkMutable();
        if (this.entryList.isEmpty() == true) goto L6;
        this.entryList.clear();
    L6:
        if (this.overflowEntries.isEmpty() == true) goto L9;
        this.overflowEntries.clear();
        return;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int r100 = getNumArrayEntries();
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L6;
        r102 = r102 + ((Entry) ListProtector.get(this.entryList, r101)).hashCode();
        r101 = r101 + 1;
        goto L3
    L6:
        if (getNumOverflowEntries() > 0) goto L8;
        return r102;
    L8:
        return r102 + this.overflowEntries.hashCode();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    private SmallSortedMap(int r100) {
        this.maxArraySize = r100;
        this.entryList = Collections.emptyList();
        this.overflowEntries = Collections.emptyMap();
    }

    public static /* synthetic */ void access$200(SmallSortedMap r100) {
        r100.checkMutable();
    }

    public static /* synthetic */ List access$400(SmallSortedMap r100) {
        return r100.entryList;
    }

    public static /* synthetic */ Map access$500(SmallSortedMap r100) {
        return r100.overflowEntries;
    }

    private int binarySearchInArray(K r100) {
        int r101 = this.entryList.size() - 1;
        if (r101 < 0) goto L10;
        int r102 = r100.compareTo(((Entry) ListProtector.get(this.entryList, r101)).getKey());
        if (r102 > 0) goto L7;
        if (r102 != 0) goto L10;
        return r101;
    L7:
        return -(r101 + 2);
    L10:
        int r103 = 0;
    L11:
        if (r103 > r101) goto L19;
        int r104 = (r103 + r101) / 2;
        int r105 = r100.compareTo(((Entry) ListProtector.get(this.entryList, r104)).getKey());
        if (r105 < 0) goto L14;
        if (r105 <= 0) goto L17;
        r103 = r104 + 1;
        goto L11
    L17:
        return r104;
    L14:
        r101 = r104 - 1;
        goto L11
    L19:
        return -(r103 + 1);
    }

    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(final int r100) {
        return (SmallSortedMap<FieldDescriptorType, Object>) new AnonymousClass1(r100);
    }

    public static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest(int r100) {
        return new SmallSortedMap(r100);
    }

    private V removeArrayEntryAt(int r100) {
        checkMutable();
        V r101 = (V) ((Entry) ListProtector.remove(this.entryList, r100)).getValue();
        if (this.overflowEntries.isEmpty() == true) goto L5;
        Iterator<Map.Entry<K, V>> r102 = getOverflowEntriesMutable().entrySet().iterator();
        this.entryList.add(new Entry(this, r102.next()));
        r102.remove();
    L5:
        return r101;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r100) {
        Comparable r101 = (Comparable) r100;
        if (binarySearchInArray(r101) < 0) goto L5;
    L8:
        return true;
    L5:
        if (this.overflowEntries.containsKey(r101) == true) goto L8;
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SmallSortedMap) == false) goto L8;
        SmallSortedMap r101 = (SmallSortedMap) r100;
        int r102 = size();
        if (r102 == r101.size()) goto L12;
        return false;
    L12:
        int r103 = getNumArrayEntries();
        if (r103 != r101.getNumArrayEntries()) goto L15;
        int r104 = 0;
    L17:
        if (r104 >= r103) goto L22;
        if (getArrayEntryAt(r104).equals(r101.getArrayEntryAt(r104)) == false) goto L20;
        r104 = r104 + 1;
        goto L17
    L20:
        return false;
    L22:
        if (r103 != r102) goto L24;
        return true;
    L24:
        return this.overflowEntries.equals(r101.overflowEntries);
    L15:
        return entrySet().equals(r101.entrySet());
    L8:
        return super.equals(r100);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r100) {
        Comparable r101 = (Comparable) r100;
        int r102 = binarySearchInArray(r101);
        if (r102 < 0) goto L7;
        return (V) ((Entry) ListProtector.get(this.entryList, r102)).getValue();
    L7:
        return this.overflowEntries.get(r101);
    }

    public Map.Entry<K, V> getArrayEntryAt(int r100) {
        return (Map.Entry) ListProtector.get(this.entryList, r100);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r100) {
        checkMutable();
        Comparable r101 = (Comparable) r100;
        int r102 = binarySearchInArray(r101);
        if (r102 < 0) goto L7;
        return removeArrayEntryAt(r102);
    L7:
        if (this.overflowEntries.isEmpty() == false) goto L11;
        return null;
    L11:
        return this.overflowEntries.remove(r101);
    }

    public /* synthetic */ SmallSortedMap(int r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ Object access$600(SmallSortedMap r100, int r101) {
        return r100.removeArrayEntryAt(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V put(K r100, V r101) {
        checkMutable();
        int r102 = binarySearchInArray(r100);
        if (r102 >= 0) goto L5;
        ensureEntryArrayMutable();
        int r103 = -(r102 + 1);
        if (r103 >= this.maxArraySize) goto L9;
        int r104 = this.entryList.size();
        int r105 = this.maxArraySize;
        if (r104 != r105) goto L13;
        Entry r106 = (Entry) ListProtector.remove(this.entryList, r105 - 1);
        getOverflowEntriesMutable().put(r106.getKey(), r106.getValue());
    L13:
        ListProtector.add(this.entryList, r103, new Entry(this, r100, r101));
        return null;
    L9:
        return getOverflowEntriesMutable().put(r100, r101);
    L5:
        return (V) ((Entry) ListProtector.get(this.entryList, r102)).setValue(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object r100, Object r101) {
        return put((Comparable) r100, r101);
    }
}
