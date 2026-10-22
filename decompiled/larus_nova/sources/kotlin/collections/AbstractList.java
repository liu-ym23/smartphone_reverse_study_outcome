package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b'\u0018\u0000 \u001c*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0016\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Lkotlin/collections/AbstractList;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    public static final Companion Companion = null;
    private static final int maxArraySize = 2147483639;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\nJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\rJ\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000fJ%\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001dJ\u0019\u0010\u001e\u001a\u00020\u00042\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "()V", "maxArraySize", "", "checkBoundsIndexes", "", "startIndex", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final int newCapacity$kotlin_stdlib(int r100, int r101) {
            int r102 = r100 + (r100 >> 1);
            if ((r102 - r101) >= 0) goto L6;
            r102 = r101;
        L6:
            if ((r102 - AbstractList.maxArraySize) <= 0) goto L11;
            if (r101 <= AbstractList.maxArraySize) goto L9;
            return Integer.MAX_VALUE;
        L9:
            return AbstractList.maxArraySize;
        L11:
            return r102;
        }

        public final int orderedHashCode$kotlin_stdlib(Collection<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Iterator<?> r101 = r100.iterator();
            int r102 = 1;
        L4:
            if (r101.hasNext() == false) goto L10;
            Object r103 = r101.next();
            int r104 = r102 * 31;
            if (r103 == null) goto L8;
            int r105 = r103.hashCode();
        L9:
            r102 = r104 + r105;
            goto L4
        L8:
            r105 = 0;
            goto L9
        L10:
            return r102;
        }

        public final void checkElementIndex$kotlin_stdlib(int r100, int r101) {
            if (r100 < 0) goto L6;
            if (r100 >= r101) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r100 + ", size: " + r101);
        }

        public final void checkPositionIndex$kotlin_stdlib(int r100, int r101) {
            if (r100 < 0) goto L6;
            if (r100 > r101) goto L6;
            return;
        L6:
            throw new IndexOutOfBoundsException("index: " + r100 + ", size: " + r101);
        }

        public final boolean orderedEquals$kotlin_stdlib(Collection<?> r100, Collection<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r101, "other");
            if (r100.size() == r101.size()) goto L5;
            return false;
        L5:
            Iterator<?> r102 = r101.iterator();
            Iterator<?> r103 = r100.iterator();
        L7:
            if (r103.hasNext() == false) goto L11;
            if (Intrinsics.areEqual(r103.next(), r102.next()) == true) goto L7;
            return false;
        L11:
            return true;
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int r100, int r101, int r102) {
            if (r100 < 0) goto L10;
            if (r101 > r102) goto L10;
            if (r100 > r101) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("startIndex: " + r100 + " > endIndex: " + r101);
        L10:
            throw new IndexOutOfBoundsException("startIndex: " + r100 + ", endIndex: " + r101 + ", size: " + r102);
        }

        public final void checkRangeIndexes$kotlin_stdlib(int r100, int r101, int r102) {
            if (r100 < 0) goto L10;
            if (r101 > r102) goto L10;
            if (r100 > r101) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("fromIndex: " + r100 + " > toIndex: " + r101);
        L10:
            throw new IndexOutOfBoundsException("fromIndex: " + r100 + ", toIndex: " + r101 + ", size: " + r102);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0092\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000e\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public class IteratorImpl implements Iterator<E>, KMappedMarker {
        private int index;
        final /* synthetic */ AbstractList<E> this$0;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.this$0.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext() == false) goto L7;
            AbstractList<E> r100 = this.this$0;
            int r101 = this.index;
            this.index = r101 + 1;
            return r100.get(r101);
        L7:
            throw new NoSuchElementException();
        }

        public final int getIndex() {
            return this.index;
        }

        public IteratorImpl(AbstractList r100) {
            this.this$0 = r100;
        }

        public final void setIndex(int r100) {
            this.index = r100;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0092\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\r\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public class ListIteratorImpl extends AbstractList<E>.IteratorImpl implements ListIterator<E> {
        final /* synthetic */ AbstractList<E> this$0;

        @Override // java.util.ListIterator
        public void add(E r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(E r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (getIndex() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return getIndex();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious() == false) goto L7;
            AbstractList<E> r100 = this.this$0;
            setIndex(getIndex() - 1);
            return r100.get(getIndex());
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return getIndex() - 1;
        }

        public ListIteratorImpl(AbstractList r100, int r101) {
            this.this$0 = r100;
            super(r100);
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r101, r100.size());
            setIndex(r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/collections/AbstractList$SubList;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SubList<E> extends AbstractList<E> implements RandomAccess {
        private int _size;
        private final int fromIndex;
        private final AbstractList<E> list;

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this._size;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public E get(int r100) {
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, this._size);
            return this.list.get(this.fromIndex + r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SubList(AbstractList<? extends E> r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.list = r100;
            this.fromIndex = r101;
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r101, r102, r100.size());
            this._size = r102 - r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // java.util.List
    public void add(int r100, E r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r100, Collection<? extends E> r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract E get(int r100);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // java.util.List
    public E remove(int r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int r100, E r101) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.orderedHashCode$kotlin_stdlib(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new IteratorImpl(this);
    }

    public ListIterator<E> listIterator() {
        return new ListIteratorImpl(this, 0);
    }

    public AbstractList() {
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof List) == true) goto L10;
        return false;
    L10:
        return Companion.orderedEquals$kotlin_stdlib(this, (Collection) r100);
    }

    public int indexOf(E r100) {
        Iterator<E> r101 = iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r101.next(), r100) == true) goto L13;
        r102 = r102 + 1;
        goto L4
    L13:
        return r102;
    L9:
        return -1;
    }

    public int lastIndexOf(E r100) {
        ListIterator<E> r101 = listIterator(size());
    L4:
        if (r101.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r101.previous(), r100) == false) goto L4;
        return r101.nextIndex();
    L8:
        return -1;
    }

    public ListIterator<E> listIterator(int r100) {
        return new ListIteratorImpl(this, r100);
    }

    public List<E> subList(int r100, int r101) {
        return new SubList(this, r100, r101);
    }
}
