package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ArrayMap$ValueCollection<V> implements Collection<V> {
    final /* synthetic */ ArrayMap this$0;

    @Override // java.util.Collection
    public void clear() {
        this.this$0.clear();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        final ArrayMap r1 = this.this$0;
        return new ArrayMap$ValueIterator(r1);
    }

    @Override // java.util.Collection
    public int size() {
        return this.this$0.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        int r0 = this.this$0.size();
        Object[] r1 = new Object[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.this$0.valueAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public ArrayMap$ValueCollection(ArrayMap r1) {
        this.this$0 = r1;
    }

    @Override // java.util.Collection
    public boolean add(V r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends V> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean contains(Object r2) {
        if (this.this$0.__restricted$indexOfValue(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> r2) {
        Iterator<?> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (contains(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // java.util.Collection
    public boolean remove(Object r2) {
        int r3 = this.this$0.__restricted$indexOfValue(r2);
        if (r3 < 0) goto L6;
        this.this$0.removeAt(r3);
        return true;
    L6:
        return false;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> r6) {
        int r0 = this.this$0.size();
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L8;
        if (r6.contains(this.this$0.valueAt(r1)) == false) goto L7;
        this.this$0.removeAt(r1);
        r1 = r1 - 1;
        r0 = r0 - 1;
        r2 = true;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> r6) {
        int r0 = this.this$0.size();
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L8;
        if (r6.contains(this.this$0.valueAt(r1)) == true) goto L7;
        this.this$0.removeAt(r1);
        r1 = r1 - 1;
        r0 = r0 - 1;
        r2 = true;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r4) {
        int r0 = size();
        if (r4.length >= r0) goto L5;
        r4 = (T[]) ((Object[]) Array.newInstance(r4.getClass().getComponentType(), r0));
    L5:
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L9;
        T[] r5 = r4;
        r5[r1] = this.this$0.valueAt(r1);
        r1 = r1 + 1;
        goto L6
    L9:
        if (r4.length <= r0) goto L11;
        r4[r0] = null;
    L11:
        return r4;
    }
}
