package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private Entry<K, V> mEnd;
    private final WeakHashMap<SupportRemove<K, V>, Boolean> mIterators;
    private int mSize;
    Entry<K, V> mStart;

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        SupportRemove<K, V> r0 = new DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put(r0, Boolean.FALSE);
        return r0;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        SupportRemove<K, V> r0 = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put(r0, Boolean.FALSE);
        return r0;
    }

    /* JADX WARN: Incorrect inner types in method signature: ()Landroidx/arch/core/internal/SafeIterableMap<TK;TV;>.IteratorWithAdditions; */
    public IteratorWithAdditions iteratorWithAdditions() {
        SupportRemove<K, V> r0 = new IteratorWithAdditions(this);
        this.mIterators.put(r0, Boolean.FALSE);
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[");
        Iterator<Map.Entry<K, V>> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        r0.append(r1.next().toString());
        if (r1.hasNext() == false) goto L4;
        r0.append(", ");
        goto L4
    L8:
        r0.append("]");
        return r0.toString();
    }

    public SafeIterableMap() {
        this.mIterators = new WeakHashMap();
        this.mSize = 0;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> r0 = iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + r0.next().hashCode();
        goto L4
    L6:
        return r1;
    }

    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    public int size() {
        return this.mSize;
    }

    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if ((r6 instanceof SafeIterableMap) == true) goto L8;
        return false;
    L8:
        SafeIterableMap r7 = (SafeIterableMap) r6;
        if (size() == r7.size()) goto L11;
        return false;
    L11:
        Iterator<Map.Entry<K, V>> r1 = iterator();
        Iterator<Map.Entry<K, V>> r8 = r7.iterator();
    L13:
        if (r1.hasNext() == false) goto L24;
        if (r8.hasNext() == false) goto L24;
        Map.Entry<K, V> r3 = r1.next();
        Map.Entry<K, V> r4 = r8.next();
        if (r3 != null) goto L19;
        if (r4 == null) goto L19;
    L22:
        return false;
    L19:
        if (r3 == null) goto L13;
        if (r3.equals(r4) == true) goto L13;
    L24:
        if (r1.hasNext() == false) goto L26;
    L28:
        return false;
    L26:
        if (r8.hasNext() == true) goto L28;
        return true;
    }

    public Entry<K, V> get(K r3) {
        Entry<K, V> r0 = this.mStart;
    L3:
        if (r0 == null) goto L8;
        if (r0.mKey.equals(r3) == true) goto L8;
        r0 = r0.mNext;
    L8:
        return r0;
    }

    public V remove(K r4) {
        Entry<K, V> r5 = get(r4);
        if (r5 != null) goto L5;
        return null;
    L5:
        this.mSize--;
        if (this.mIterators.isEmpty() == true) goto L11;
        Iterator<SupportRemove<K, V>> r1 = this.mIterators.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        r1.next().supportRemove(r5);
    L11:
        Entry<K, V> r2 = r5.mPrevious;
        if (r2 == null) goto L14;
        r2.mNext = r5.mNext;
    L15:
        Entry r3 = r5.mNext;
        if (r3 == null) goto L18;
        r3.mPrevious = r2;
    L19:
        r5.mNext = null;
        r5.mPrevious = null;
        return (V) r5.mValue;
    L18:
        this.mEnd = r2;
        goto L19
    L14:
        this.mStart = r5.mNext;
        goto L15
    }

    public Entry<K, V> put(K r2, V r3) {
        Entry<K, V> r0 = new Entry(r2, r3);
        this.mSize++;
        Entry<K, V> r4 = this.mEnd;
        if (r4 != null) goto L6;
        this.mStart = r0;
        this.mEnd = r0;
        return r0;
    L6:
        r4.mNext = r0;
        r0.mPrevious = r4;
        this.mEnd = r0;
        return r0;
    }

    public V putIfAbsent(K r2, V r3) {
        Entry<K, V> r0 = get(r2);
        if (r0 != null) goto L5;
        put(r2, r3);
        return null;
    L5:
        return (V) r0.mValue;
    }
}
