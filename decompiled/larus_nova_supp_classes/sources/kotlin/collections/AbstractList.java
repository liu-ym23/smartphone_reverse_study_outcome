package kotlin.collections;

import android.util.EventsUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b'\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", XmlPullParser.NO_NAMESPACE, "()V", "size", XmlPullParser.NO_NAMESPACE, "getSize", "()I", "equals", XmlPullParser.NO_NAMESPACE, "other", XmlPullParser.NO_NAMESPACE, "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", XmlPullParser.NO_NAMESPACE, "lastIndexOf", "listIterator", XmlPullParser.NO_NAMESPACE, "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    public static final Companion Companion = null;
    private static final int maxArraySize = 2147483639;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\nJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\rJ\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000fJ%\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001dJ\u0019\u0010\u001e\u001a\u00020\u00042\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlin/collections/AbstractList$Companion;", XmlPullParser.NO_NAMESPACE, "()V", "maxArraySize", XmlPullParser.NO_NAMESPACE, "checkBoundsIndexes", XmlPullParser.NO_NAMESPACE, "startIndex", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "orderedEquals", XmlPullParser.NO_NAMESPACE, "c", XmlPullParser.NO_NAMESPACE, "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final int newCapacity$kotlin_stdlib(int r3, int r4) {
            int r5 = r3 + (r3 >> 1);
            if ((r5 - r4) >= 0) goto L6;
            r5 = r4;
        L6:
            if ((r5 - AbstractList.maxArraySize) <= 0) goto L11;
            if (r4 <= AbstractList.maxArraySize) goto L9;
            return Integer.MAX_VALUE;
        L9:
            return AbstractList.maxArraySize;
        L11:
            return r5;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "c");
            Iterator<?> r4 = r3.iterator();
            int r0 = 1;
        L4:
            if (r4.hasNext() == false) goto L10;
            Object r1 = r4.next();
            int r2 = r0 * 31;
            if (r1 == null) goto L8;
            int r5 = r1.hashCode();
        L9:
            r0 = r2 + r5;
            goto L4
        L8:
            r5 = 0;
            goto L9
        L10:
            return r0;
        }

        public final void checkElementIndex$kotlin_stdlib(int r4, int r5) {
            if (r4 < 0) goto L6;
            if (r4 >= r5) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r4 + ", size: " + r5);
        }

        public final void checkPositionIndex$kotlin_stdlib(int r4, int r5) {
            if (r4 < 0) goto L6;
            if (r4 > r5) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r4 + ", size: " + r5);
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> r4, Collection<?> r5) {
            Intrinsics.checkNotNullParameter(r4, "c");
            Intrinsics.checkNotNullParameter(r5, "other");
            if (r4.size() == r5.size()) goto L5;
            return false;
        L5:
            Iterator<?> r6 = r5.iterator();
            Iterator<?> r7 = r4.iterator();
        L7:
            if (r7.hasNext() == false) goto L11;
            if (Intrinsics.areEqual(r7.next(), r6.next()) == true) goto L7;
            return false;
        L11:
            return true;
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int r4, int r5, int r6) {
            if (r4 < 0) goto L10;
            if (r5 > r6) goto L10;
            if (r4 > r5) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("startIndex: " + r4 + " > endIndex: " + r5);
        L10:
            throw new IndexOutOfBoundsException("startIndex: " + r4 + ", endIndex: " + r5 + ", size: " + r6);
        }

        public final void checkRangeIndexes$kotlin_stdlib(int r4, int r5, int r6) {
            if (r4 < 0) goto L10;
            if (r5 > r6) goto L10;
            if (r4 > r5) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("fromIndex: " + r4 + " > toIndex: " + r5);
        L10:
            throw new IndexOutOfBoundsException("fromIndex: " + r4 + ", toIndex: " + r5 + ", size: " + r6);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // java.util.List
    public void add(int r1, E r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r1, Collection<? extends E> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public abstract E get(int r1);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // java.util.List
    public E remove(int r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int r1, E r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.orderedHashCode$kotlin_stdlib(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new IteratorImpl(this);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(this, 0);
    }

    public AbstractList() {
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof List) == true) goto L10;
        return false;
    L10:
        return Companion.orderedEquals$kotlin_stdlib(this, (Collection) r2);
    }

    @Override // java.util.List
    public int indexOf(E r4) {
        Iterator<E> r0 = iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next(), r4) == true) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        return r1;
    L9:
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(E r3) {
        ListIterator<E> r0 = listIterator(size());
    L4:
        if (r0.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r0.previous(), r3) == false) goto L4;
        return r0.nextIndex();
    L8:
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int r2) {
        return new ListIteratorImpl(this, r2);
    }

    @Override // java.util.List
    public List<E> subList(int r2, int r3) {
        return new SubList(this, r2, r3);
    }
}
