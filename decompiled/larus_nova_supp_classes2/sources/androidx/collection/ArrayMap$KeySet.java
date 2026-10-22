package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ArrayMap$KeySet<K> implements Set<K> {
    final /* synthetic */ ArrayMap this$0;

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.this$0.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        int r0 = this.this$0.size() - 1;
        int r2 = 0;
    L3:
        if (r0 < 0) goto L9;
        Object r3 = this.this$0.keyAt(r0);
        if (r3 != null) goto L7;
        int r4 = 0;
    L8:
        r2 = r2 + r4;
        r0 = r0 - 1;
        goto L3
    L7:
        r4 = r3.hashCode();
        goto L8
    L9:
        return r2;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<K> iterator() {
        final ArrayMap r1 = this.this$0;
        return new ArrayMap$KeyIterator(r1);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.this$0.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        int r0 = this.this$0.size();
        Object[] r1 = new Object[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.this$0.keyAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public ArrayMap$KeySet(ArrayMap r1) {
        this.this$0 = r1;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(K r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends K> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r2) {
        return this.this$0.containsKey(r2);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r2) {
        return this.this$0.containsAll(r2);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object r1) {
        return ArrayMap.equalsSetHelper(this, r1);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object r2) {
        int r3 = this.this$0.indexOfKey(r2);
        if (r3 < 0) goto L6;
        this.this$0.removeAt(r3);
        return true;
    L6:
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r2) {
        return this.this$0.removeAll(r2);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> r2) {
        return this.this$0.retainAll(r2);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r4) {
        int r0 = size();
        if (r4.length >= r0) goto L5;
        r4 = (T[]) ((Object[]) Array.newInstance(r4.getClass().getComponentType(), r0));
    L5:
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L9;
        T[] r5 = r4;
        r5[r1] = this.this$0.keyAt(r1);
        r1 = r1 + 1;
        goto L6
    L9:
        if (r4.length <= r0) goto L11;
        r4[r0] = null;
    L11:
        return r4;
    }
}
