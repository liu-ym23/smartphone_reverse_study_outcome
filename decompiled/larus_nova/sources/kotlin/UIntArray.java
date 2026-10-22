package kotlin;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002¢\u0006\u0004\b'\u0010(J \u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\b\u0082\u0002\u0004\n\u0002\b!¨\u00063"}, d2 = {"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "size", "", "constructor-impl", "(I)[I", "storage", "", "([I)[I", "getSize-impl", "([I)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", SlcElement.KEY_ELEMENTS, "containsAll-impl", "([ILjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([ILjava/lang/Object;)Z", MonitorConstants.CONNECT_TYPE_GET, "index", "get-pVg5ArA", "([II)I", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([I)Z", "iterator", "", "iterator-impl", "([I)Ljava/util/Iterator;", "set", "", "value", "set-VXSXFK8", "([III)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    private final int[] storage;

    /* JADX INFO: loaded from: classes41.dex */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0013\u0010\n\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\r"}, d2 = {"Lkotlin/UIntArray$Iterator;", "", "Lkotlin/UInt;", "array", "", "([I)V", "index", "", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "next-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker {
        private final int[] array;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.array.length) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX INFO: renamed from: next-pVg5ArA, reason: not valid java name */
        public int m9614nextpVg5ArA() {
            int r100 = this.index;
            int[] r101 = this.array;
            if (r100 >= r101.length) goto L7;
            this.index = r100 + 1;
            return UInt.m9544constructorimpl(r101[r100]);
        L7:
            throw new NoSuchElementException(String.valueOf(this.index));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UInt next() {
            return UInt.m9538boximpl(m9614nextpVg5ArA());
        }

        public Iterator(int[] r100) {
            Intrinsics.checkNotNullParameter(r100, "array");
            this.array = r100;
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UIntArray m9597boximpl(int[] r100) {
        return new UIntArray(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m9599constructorimpl(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "storage");
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m9602equalsimpl(int[] r100, Object r101) {
        if ((r101 instanceof UIntArray) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((UIntArray) r101).m9613unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9603equalsimpl0(int[] r100, int[] r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m9606hashCodeimpl(int[] r100) {
        return Arrays.hashCode(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m9610toStringimpl(int[] r100) {
        return "UIntArray(storage=" + Arrays.toString(r100) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UInt r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: add-WZ4Q5Ns, reason: not valid java name */
    public boolean m9611addWZ4Q5Ns(int r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean equals(Object r100) {
        return m9602equalsimpl(this.storage, r100);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m9606hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    public String toString() {
        return m9610toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m9613unboximpl() {
        return this.storage;
    }

    public int getSize() {
        return m9605getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m9607isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UInt> iterator() {
        return m9608iteratorimpl(this.storage);
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ int size() {
        return getSize();
    }

    private /* synthetic */ UIntArray(int[] r100) {
        this.storage = r100;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m9598constructorimpl(int r100) {
        return m9599constructorimpl(new int[r100]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m9605getSizeimpl(int[] r100) {
        return r100.length;
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m9607isEmptyimpl(int[] r100) {
        if (r100.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<UInt> m9608iteratorimpl(int[] r100) {
        return new Iterator(r100);
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof UInt) == true) goto L7;
        return false;
    L7:
        return m9612containsWZ4Q5Ns(((UInt) r100).m9596unboximpl());
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m9612containsWZ4Q5Ns(int r100) {
        return m9600containsWZ4Q5Ns(this.storage, r100);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return m9601containsAllimpl(this.storage, r100);
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public static boolean m9600containsWZ4Q5Ns(int[] r100, int r101) {
        return ArraysKt.contains(r100, r101);
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m9601containsAllimpl(int[] r100, Collection<UInt> r101) {
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        Collection<UInt> r102 = r101;
        if (r102.isEmpty() == true) goto L22;
        java.util.Iterator<T> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L23;
        Object r104 = r103.next();
        if ((r104 instanceof UInt) == true) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == true) goto L7;
        return false;
    L11:
        if (ArraysKt.contains(r100, ((UInt) r104).m9596unboximpl()) == false) goto L13;
        r105 = true;
        goto L14
    L23:
        return true;
    L22:
        return true;
    }

    /* JADX INFO: renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m9604getpVg5ArA(int[] r100, int r101) {
        return UInt.m9544constructorimpl(r100[r101]);
    }

    /* JADX INFO: renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m9609setVXSXFK8(int[] r100, int r101, int r102) {
        r100[r101] = r102;
    }
}
