package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0019\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001b\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0017R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Landroidx/collection/MutableValues;", "K", "V", "", "parent", "Landroidx/collection/MutableScatterMap;", "<init>", "(Landroidx/collection/MutableScatterMap;)V", "size", "", "getSize", "()I", "isEmpty", "", "iterator", "", "clear", "", "addAll", "elements", "", "add", "element", "(Ljava/lang/Object;)Z", "retainAll", "removeAll", "remove", "containsAll", "contains", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MutableValues<K, V> implements Collection<V>, KMutableCollection {
    private final MutableScatterMap<K, V> parent;

    /* JADX INFO: renamed from: androidx.collection.MutableValues$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010(\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\f\u001a\u00020\rH\u0096\u0002J\u000e\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"androidx/collection/MutableValues$iterator$1", "", "iterator", "", "", "getIterator", "()Ljava/util/Iterator;", "current", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<V>, KMutableIterator {
        private int current;
        private final Iterator<Integer> iterator;
        final /* synthetic */ MutableValues<K, V> this$0;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            this.current = this.iterator.next().intValue();
            return (V) MutableValues.access$getParent$p(this.this$0).values[this.current];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current < 0) goto L6;
            MutableValues.access$getParent$p(this.this$0).removeValueAt(this.current);
            this.current = -1;
            return;
        }

        public final int getCurrent() {
            return this.current;
        }

        public final Iterator<Integer> getIterator() {
            return this.iterator;
        }

        public AnonymousClass1(MutableValues<K, V> r3) {
            this.this$0 = r3;
            this.iterator = SequencesKt.iterator(new MutableValues$iterator$1$iterator$1(r3, null));
            this.current = -1;
        }

        public final void setCurrent(int r1) {
            this.current = r1;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (T[]) CollectionToArray.toArray(this, r2);
    }

    @Override // java.util.Collection
    public void clear() {
        this.parent.clear();
    }

    public int getSize() {
        return this.parent._size;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public MutableValues(MutableScatterMap<K, V> r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        this.parent = r2;
    }

    public static final /* synthetic */ MutableScatterMap access$getParent$p(MutableValues r0) {
        return r0.parent;
    }

    @Override // java.util.Collection
    public boolean add(V r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends V> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean contains(Object r2) {
        return this.parent.containsValue(r2);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        Collection<?> r5 = r4;
        if (r5.isEmpty() == true) goto L15;
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        Object r0 = r6.next();
        if (this.parent.containsValue((V) r0) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Collection
    public boolean remove(Object r17) {
        long[] r1 = this.parent.metadata;
        int r2 = r1.length - 2;
        if (r2 < 0) goto L26;
        int r4 = 0;
    L5:
        long r5 = r1[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L24;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L21;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L19;
        int r11 = (r4 << 3) + r9;
        if (Intrinsics.areEqual(this.parent.values[r11], r17) == false) goto L19;
        this.parent.removeValueAt(r11);
        return true;
    L19:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L21:
        if (r7 != 8) goto L26;
    L24:
        if (r4 == r2) goto L26;
        r4 = r4 + 1;
    L26:
        return false;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> r19) {
        Intrinsics.checkNotNullParameter(r19, "elements");
        long[] r2 = this.parent.metadata;
        int r3 = r2.length - 2;
        boolean r4 = false;
        if (r3 < 0) goto L23;
        int r5 = 0;
        boolean r6 = false;
    L5:
        long r7 = r2[r5];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r9 = 8 - ((~(r5 - r3)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L18;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L17;
        int r13 = (r5 << 3) + r11;
        if (CollectionsKt.contains(r19, this.parent.values[r13]) == false) goto L17;
        this.parent.removeValueAt(r13);
        r6 = true;
    L17:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L18:
        if (r9 == 8) goto L19;
        return r6;
    L19:
        if (r5 == r3) goto L21;
        r5 = r5 + 1;
        goto L5
    L21:
        r4 = r6;
    L23:
        return r4;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> r19) {
        Intrinsics.checkNotNullParameter(r19, "elements");
        long[] r2 = this.parent.metadata;
        int r3 = r2.length - 2;
        boolean r4 = false;
        if (r3 < 0) goto L23;
        int r5 = 0;
        boolean r6 = false;
    L5:
        long r7 = r2[r5];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r9 = 8 - ((~(r5 - r3)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L18;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L17;
        int r13 = (r5 << 3) + r11;
        if (CollectionsKt.contains(r19, this.parent.values[r13]) == true) goto L17;
        this.parent.removeValueAt(r13);
        r6 = true;
    L17:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L18:
        if (r9 == 8) goto L19;
        return r6;
    L19:
        if (r5 == r3) goto L21;
        r5 = r5 + 1;
        goto L5
    L21:
        r4 = r6;
    L23:
        return r4;
    }
}
