package com.google.gson.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = null;
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedTreeMap<K, V>.KeySet keySet;
    int modCount;
    Node<K, V> root;
    int size;

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ LinkedTreeMap this$0;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }

        public EntrySet(LinkedTreeMap r100) {
            this.this$0 = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r100) {
            if ((r100 instanceof Map.Entry) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.findByEntry((Map.Entry) r100) == null) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r100) {
            if ((r100 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Node<K, V> r101 = this.this$0.findByEntry((Map.Entry) r100);
            if (r101 != null) goto L8;
            return false;
        L8:
            this.this$0.removeInternal(r101, true);
            return true;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public final class KeySet extends AbstractSet<K> {
        final /* synthetic */ LinkedTreeMap this$0;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size;
        }

        public KeySet(LinkedTreeMap r100) {
            this.this$0 = r100;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r100) {
            return this.this$0.containsKey(r100);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r100) {
            if (this.this$0.removeInternalByKey(r100) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        Node<K, V> lastReturned;
        Node<K, V> next;
        final /* synthetic */ LinkedTreeMap this$0;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.next == this.this$0.header) goto L5;
            return true;
        L5:
            return false;
        }

        public final Node<K, V> nextNode() {
            Node<K, V> r100 = this.next;
            LinkedTreeMap r101 = this.this$0;
            if (r100 == r101.header) goto L11;
            if (r101.modCount != this.expectedModCount) goto L9;
            this.next = r100.next;
            this.lastReturned = r100;
            return r100;
        L9:
            throw new ConcurrentModificationException();
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> r100 = this.lastReturned;
            if (r100 == null) goto L7;
            this.this$0.removeInternal(r100, true);
            this.lastReturned = null;
            this.expectedModCount = this.this$0.modCount;
            return;
        L7:
            throw new IllegalStateException();
        }

        public LinkedTreeMapIterator(LinkedTreeMap r100) {
            this.this$0 = r100;
            this.next = r100.header.next;
            this.lastReturned = null;
            this.expectedModCount = r100.modCount;
        }
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {
        final boolean allowNullValue;
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        public Node<K, V> first() {
            Node<K, V> r100 = this.left;
            Node<K, V> r101 = this;
        L3:
            if (r100 == null) goto L5;
            r101 = r100;
            r100 = r100.left;
            goto L3
        L5:
            return r101;
        }

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

        public Node<K, V> last() {
            Node<K, V> r100 = this.right;
            Node<K, V> r101 = this;
        L3:
            if (r100 == null) goto L5;
            r101 = r100;
            r100 = r100.right;
            goto L3
        L5:
            return r101;
        }

        public String toString() {
            return this.key + ContainerUtils.KEY_VALUE_DELIMITER + this.value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        public Node(boolean r100) {
            this.key = null;
            this.allowNullValue = r100;
            this.prev = this;
            this.next = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L20;
            Map.Entry r101 = (Map.Entry) r100;
            K r102 = this.key;
            if (r102 != null) goto L10;
            if (r101.getKey() != null) goto L21;
        L11:
            V r103 = this.value;
            if (r103 != null) goto L17;
            if (r101.getValue() != null) goto L23;
        L18:
            return true;
        L23:
            return false;
        L17:
            if (r103.equals(r101.getValue()) == true) goto L18;
            return false;
        L21:
            return false;
        L10:
            if (r102.equals(r101.getKey()) == true) goto L11;
            return false;
        L20:
            return false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r100) {
            if (r100 == null) goto L4;
        L8:
            V r101 = this.value;
            this.value = r100;
            return r101;
        L4:
            if (this.allowNullValue == true) goto L8;
            throw new NullPointerException("value == null");
        }

        public Node(boolean r100, Node<K, V> r101, K r102, Node<K, V> r103, Node<K, V> r104) {
            this.parent = r101;
            this.key = r102;
            this.allowNullValue = r100;
            this.height = 1;
            this.next = r103;
            this.prev = r104;
            r104.next = this;
            r103.prev = this;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node<K, V> r100 = this.header;
        r100.prev = r100;
        r100.next = r100;
    }

    static {
        NATURAL_ORDER = new AnonymousClass1();
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER, true);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet r100 = this.entrySet;
        if (r100 != null) goto L7;
        LinkedTreeMap<K, V>.EntrySet r101 = new EntrySet(this);
        this.entrySet = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet r100 = this.keySet;
        if (r100 != null) goto L7;
        LinkedTreeMap<K, V>.KeySet r101 = new KeySet(this);
        this.keySet = r101;
        return r101;
    L7:
        return r100;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(boolean r100) {
        this(NATURAL_ORDER, r100);
    }

    private void readObject(ObjectInputStream r100) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rotateLeft(Node<K, V> r100) {
        Node<K, V> r101 = r100.left;
        Node<K, V> r102 = r100.right;
        Node<K, V> r103 = r102.left;
        Node<K, V> r104 = r102.right;
        r100.right = r103;
        if (r103 == null) goto L5;
        r103.parent = r100;
    L5:
        replaceInParent(r100, r102);
        r102.left = r100;
        r100.parent = r102;
        int r105 = 0;
        if (r101 == null) goto L8;
        int r106 = r101.height;
    L9:
        if (r103 == null) goto L11;
        int r107 = r103.height;
    L12:
        int r108 = Math.max(r106, r107) + 1;
        r100.height = r108;
        if (r104 == null) goto L15;
        r105 = r104.height;
    L15:
        r102.height = Math.max(r108, r105) + 1;
        return;
    L11:
        r107 = 0;
        goto L12
    L8:
        r106 = 0;
        goto L9
    }

    private void rotateRight(Node<K, V> r100) {
        Node<K, V> r101 = r100.left;
        Node<K, V> r102 = r100.right;
        Node<K, V> r103 = r101.left;
        Node<K, V> r104 = r101.right;
        r100.left = r104;
        if (r104 == null) goto L5;
        r104.parent = r100;
    L5:
        replaceInParent(r100, r101);
        r101.right = r100;
        r100.parent = r101;
        int r105 = 0;
        if (r102 == null) goto L8;
        int r106 = r102.height;
    L9:
        if (r104 == null) goto L11;
        int r107 = r104.height;
    L12:
        int r108 = Math.max(r106, r107) + 1;
        r100.height = r108;
        if (r103 == null) goto L15;
        r105 = r103.height;
    L15:
        r101.height = Math.max(r108, r105) + 1;
        return;
    L11:
        r107 = 0;
        goto L12
    L8:
        r106 = 0;
        goto L9
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object r100) {
        if (findByObject(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Node<K, V> findByEntry(Map.Entry<?, ?> r100) {
        Node<K, V> r101 = findByObject(r100.getKey());
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L12;
        return null;
    L12:
        return r101;
    L5:
        if (equal(r101.value, r100.getValue()) == false) goto L7;
        r102 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Node<K, V> findByObject(Object r100) {
        if (r100 != 0) goto L8;
        return null;
    L8:
        return find(r100, false);
    L11:
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object r100) {
        Node<K, V> r101 = findByObject(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object r100) {
        Node<K, V> r101 = removeInternalByKey(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.value;
    }

    public Node<K, V> removeInternalByKey(Object r100) {
        Node<K, V> r101 = findByObject(r100);
        if (r101 == null) goto L5;
        removeInternal(r101, true);
    L5:
        return r101;
    }

    public LinkedTreeMap(Comparator<? super K> r100, boolean r101) {
        this.size = 0;
        this.modCount = 0;
        if (r100 != null) goto L6;
        r100 = NATURAL_ORDER;
    L6:
        this.comparator = r100;
        this.allowNullValues = r101;
        this.header = new Node(r101);
    }

    private boolean equal(Object r100, Object r101) {
        return Objects.equals(r100, r101);
    }

    private void rebalance(Node<K, V> r100, boolean r101) {
    L2:
        if (r100 == null) goto L52;
        Node<K, V> r102 = r100.left;
        Node<K, V> r103 = r100.right;
        int r104 = 0;
        if (r102 == null) goto L6;
        int r105 = r102.height;
    L7:
        if (r103 == null) goto L9;
        int r106 = r103.height;
    L10:
        int r107 = r105 - r106;
        if (r107 != (-2)) goto L28;
        Node<K, V> r108 = r103.left;
        Node<K, V> r109 = r103.right;
        if (r109 == null) goto L15;
        int r110 = r109.height;
    L16:
        if (r108 == null) goto L18;
        r104 = r108.height;
    L18:
        int r111 = r104 - r110;
        if (r111 == (-1)) goto L24;
        if (r111 != 0) goto L23;
        if (r101 == false) goto L24;
    L23:
        rotateRight(r103);
        rotateLeft(r100);
    L25:
        if (r101 == false) goto L51;
        return;
    L51:
        r100 = r100.parent;
    L24:
        rotateLeft(r100);
        goto L25
    L15:
        r110 = 0;
        goto L16
    L28:
        if (r107 != 2) goto L44;
        Node<K, V> r112 = r102.left;
        Node<K, V> r113 = r102.right;
        if (r113 == null) goto L32;
        int r114 = r113.height;
    L33:
        if (r112 == null) goto L35;
        r104 = r112.height;
    L35:
        int r115 = r104 - r114;
        if (r115 == 1) goto L41;
        if (r115 != 0) goto L40;
        if (r101 == false) goto L41;
    L40:
        rotateLeft(r102);
        rotateRight(r100);
    L42:
        if (r101 == false) goto L51;
        return;
    L41:
        rotateRight(r100);
        goto L42
    L32:
        r114 = 0;
        goto L33
    L44:
        if (r107 != 0) goto L48;
        r100.height = r105 + 1;
        if (r101 == false) goto L51;
        return;
    L48:
        r100.height = Math.max(r105, r106) + 1;
        if (r101 == true) goto L51;
        return;
    L9:
        r106 = 0;
        goto L10
    L6:
        r105 = 0;
        goto L7
    }

    private void replaceInParent(Node<K, V> r100, Node<K, V> r101) {
        Node<K, V> r102 = r100.parent;
        r100.parent = null;
        if (r101 == null) goto L5;
        r101.parent = r102;
    L5:
        if (r102 != null) goto L7;
        this.root = r101;
        return;
    L7:
        if (r102.left != r100) goto L9;
        r102.left = r101;
        return;
    L9:
        r102.right = r101;
    }

    public Node<K, V> find(K r110, boolean r111) {
        Comparator<? super K> r100 = this.comparator;
        Node<K, V> r101 = this.root;
        if (r101 != null) goto L5;
        int r102 = 0;
    L20:
        if (r111 == true) goto L22;
        return null;
    L22:
        Node<K, V> r103 = this.header;
        if (r101 == null) goto L25;
        Node<K, V> r104 = new Node(this.allowNullValues, r101, r110, r103, r103.prev);
        if (r102 >= 0) goto L35;
        r101.left = r104;
    L36:
        rebalance(r101, true);
    L37:
        this.size++;
        this.modCount++;
        return r104;
    L35:
        r101.right = r104;
        goto L36
    L25:
        if (r100 == NATURAL_ORDER) goto L27;
    L31:
        r104 = new Node(this.allowNullValues, r101, r110, r103, r103.prev);
        this.root = r104;
        goto L37
    L27:
        if ((r110 instanceof Comparable) == true) goto L31;
        throw new ClassCastException(r110.getClass().getName().concat(" is not Comparable"));
    L5:
        if (r100 != NATURAL_ORDER) goto L7;
        Comparable r105 = (Comparable) r110;
    L8:
        if (r105 == null) goto L10;
        r102 = r105.compareTo(r101.key);
    L11:
        if (r102 == 0) goto L12;
        if (r102 >= 0) goto L15;
        Node<K, V> r106 = r101.left;
    L16:
        if (r106 == null) goto L20;
        r101 = r106;
        goto L8
    L15:
        r106 = r101.right;
        goto L16
    L12:
        return r101;
    L10:
        r102 = r100.compare(r110, r101.key);
        goto L11
    L7:
        r105 = null;
        goto L8
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K r100, V r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L5;
    L9:
        Node<K, V> r102 = find(r100, true);
        V r103 = r102.value;
        r102.value = r101;
        return r103;
    L5:
        if (this.allowNullValues == true) goto L9;
        throw new NullPointerException("value == null");
    L12:
        throw new NullPointerException("key == null");
    }

    public void removeInternal(Node<K, V> r100, boolean r101) {
        if (r101 == false) goto L4;
        Node<K, V> r102 = r100.prev;
        r102.next = r100.next;
        r100.next.prev = r102;
    L4:
        Node<K, V> r103 = r100.left;
        Node<K, V> r104 = r100.right;
        Node<K, V> r105 = r100.parent;
        int r106 = 0;
        if (r103 == null) goto L20;
        if (r104 == null) goto L20;
        if (r103.height <= r104.height) goto L10;
        Node<K, V> r107 = r103.last();
    L11:
        removeInternal(r107, false);
        Node<K, V> r108 = r100.left;
        if (r108 == null) goto L14;
        int r109 = r108.height;
        r107.left = r108;
        r108.parent = r107;
        r100.left = null;
    L15:
        Node<K, V> r110 = r100.right;
        if (r110 == null) goto L18;
        r106 = r110.height;
        r107.right = r110;
        r110.parent = r107;
        r100.right = null;
    L18:
        r107.height = Math.max(r109, r106) + 1;
        replaceInParent(r100, r107);
        return;
    L14:
        r109 = 0;
        goto L15
    L10:
        r107 = r104.first();
    L20:
        if (r103 == null) goto L22;
        replaceInParent(r100, r103);
        r100.left = null;
    L25:
        rebalance(r105, false);
        this.size--;
        this.modCount++;
        return;
    L22:
        if (r104 == null) goto L24;
        replaceInParent(r100, r104);
        r100.right = null;
        goto L25
    L24:
        replaceInParent(r100, null);
        goto L25
    }
}
