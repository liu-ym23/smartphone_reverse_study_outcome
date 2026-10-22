package kotlin.collections.builders;

import android.util.EventsUtils;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 Q*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0003PQRB\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0016\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J&\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u001d\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0016J\u0014\u0010%\u001a\u00020\u000f2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030\"H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0013\u0010*\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010+H\u0096\u0002J\u0016\u0010,\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\tH\u0016J\u0015\u0010/\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u0018\u00101\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\u000fH\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0096\u0002J\u0015\u00105\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000072\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\u0017H\u0002J\u0015\u00109\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010:\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0015\u0010;\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0002\u0010-J\u0015\u0010<\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0002\u0010-J\u0018\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH\u0002J\u0016\u0010@\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J.\u0010A\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010B\u001a\u00020\u000fH\u0002J\u001e\u0010C\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0016J\u0015\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\fH\u0016¢\u0006\u0002\u0010IJ'\u0010H\u001a\b\u0012\u0004\u0012\u0002HJ0\f\"\u0004\b\u0001\u0010J2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0\fH\u0016¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020+H\u0002R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006S"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", XmlPullParser.NO_NAMESPACE, "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initialCapacity", XmlPullParser.NO_NAMESPACE, "(I)V", "backing", XmlPullParser.NO_NAMESPACE, "[Ljava/lang/Object;", "isReadOnly", XmlPullParser.NO_NAMESPACE, "length", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", XmlPullParser.NO_NAMESPACE, "index", "(ILjava/lang/Object;)V", "addAll", "elements", XmlPullParser.NO_NAMESPACE, "addAllInternal", "i", "n", "addAtInternal", "build", XmlPullParser.NO_NAMESPACE, "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacityInternal", "minCapacity", "ensureExtraCapacity", "equals", XmlPullParser.NO_NAMESPACE, "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", XmlPullParser.NO_NAMESPACE, "lastIndexOf", "listIterator", XmlPullParser.NO_NAMESPACE, "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", XmlPullParser.NO_NAMESPACE, "writeReplace", "BuilderSubList", "Companion", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ListBuilder<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {
    private static final Companion Companion = null;
    private static final ListBuilder Empty = null;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Companion;", XmlPullParser.NO_NAMESPACE, "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", XmlPullParser.NO_NAMESPACE, "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\r\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", XmlPullParser.NO_NAMESPACE, "list", "Lkotlin/collections/builders/ListBuilder;", "index", XmlPullParser.NO_NAMESPACE, "(Lkotlin/collections/builders/ListBuilder;I)V", "expectedModCount", "lastIndex", "add", XmlPullParser.NO_NAMESPACE, "element", "(Ljava/lang/Object;)V", "checkForComodification", "hasNext", XmlPullParser.NO_NAMESPACE, "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        private final void checkForComodification() {
            if (ListBuilder.m164access$getModCount$p$s2084097795(this.list) != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.index >= ListBuilder.access$getLength$p(this.list)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.index <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkForComodification();
            if (this.index >= ListBuilder.access$getLength$p(this.list)) goto L7;
            int r0 = this.index;
            this.index = r0 + 1;
            this.lastIndex = r0;
            return (E) ListBuilder.access$getBacking$p(this.list)[this.lastIndex];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            int r0 = this.index;
            if (r0 <= 0) goto L7;
            int r1 = r0 - 1;
            this.index = r1;
            this.lastIndex = r1;
            return (E) ListBuilder.access$getBacking$p(this.list)[this.lastIndex];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComodification();
            int r0 = this.lastIndex;
            if (r0 == (-1)) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L10;
            this.list.remove(r0);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m164access$getModCount$p$s2084097795(this.list);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        L5:
            r2 = false;
            goto L6
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public void add(E r4) {
            checkForComodification();
            ListBuilder<E> r0 = this.list;
            int r1 = this.index;
            this.index = r1 + 1;
            r0.add(r1, r4);
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m164access$getModCount$p$s2084097795(this.list);
        }

        @Override // java.util.ListIterator
        public void set(E r3) {
            checkForComodification();
            int r0 = this.lastIndex;
            if (r0 == (-1)) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L10;
            this.list.set(r0, r3);
            return;
        L10:
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        L5:
            r1 = false;
            goto L6
        }

        public Itr(ListBuilder<E> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            this.list = r2;
            this.index = r3;
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.m164access$getModCount$p$s2084097795(r2);
        }
    }

    public ListBuilder() {
        int r2 = 0;
        this(r2, 1, null);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    static {
        Companion = new Companion(null);
        ListBuilder r0 = new ListBuilder(0);
        r0.isReadOnly = true;
        Empty = r0;
    }

    private final void checkIsMutable() {
        if (this.isReadOnly == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    private final Object writeReplace() {
        if (this.isReadOnly == false) goto L7;
        return new SerializedCollection(this, 0);
    L7:
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (this.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.backing, 0, this.length, this);
    }

    public final List<E> build() {
        checkIsMutable();
        this.isReadOnly = true;
        if (this.length <= 0) goto L6;
        return this;
    L6:
        return Empty;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.length;
    }

    public ListBuilder(int r1) {
        this.backing = (E[]) ListBuilderKt.arrayOfUninitializedElements(r1);
    }

    public static final /* synthetic */ Object[] access$getBacking$p(ListBuilder r0) {
        return r0.backing;
    }

    public static final /* synthetic */ int access$getLength$p(ListBuilder r0) {
        return r0.length;
    }

    /* JADX INFO: renamed from: access$getModCount$p$s-2084097795, reason: not valid java name */
    public static final /* synthetic */ int m164access$getModCount$p$s2084097795(ListBuilder r0) {
        return ((AbstractList) r0).modCount;
    }

    public static final /* synthetic */ boolean access$isReadOnly$p(ListBuilder r0) {
        return r0.isReadOnly;
    }

    private final boolean contentEquals(List<?> r4) {
        return ListBuilderKt.access$subarrayContentEquals(this.backing, 0, this.length, r4);
    }

    private final void ensureCapacityInternal(int r3) {
        if (r3 < 0) goto L8;
        E[] r0 = this.backing;
        if (r3 <= r0.length) goto L9;
        int r4 = kotlin.collections.AbstractList.Companion.newCapacity$kotlin_stdlib(r0.length, r3);
        this.backing = (E[]) ListBuilderKt.copyOfUninitializedElements(this.backing, r4);
        return;
    L9:
        return;
    L8:
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int r2) {
        ensureCapacityInternal(this.length + r2);
    }

    private final E removeAtInternal(int r5) {
        registerModification();
        E[] r0 = this.backing;
        E r1 = r0[r5];
        ArraysKt.copyInto(r0, r0, r5, r5 + 1, this.length);
        ListBuilderKt.resetAt(this.backing, this.length - 1);
        this.length--;
        return r1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r2) {
        checkIsMutable();
        addAtInternal(this.length, r2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r3) {
        Intrinsics.checkNotNullParameter(r3, "elements");
        checkIsMutable();
        int r0 = r3.size();
        addAllInternal(this.length, r3, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r2) {
        if (r2 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof List) == true) goto L6;
    L8:
        return false;
    L6:
        if (contentEquals((List) r2) == false) goto L8;
        goto L8
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r3) {
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        return this.backing[r3];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.length) goto L9;
        if (Intrinsics.areEqual(this.backing[r0], r3) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r3) {
        int r0 = this.length - 1;
    L3:
        if (r0 < 0) goto L8;
        if (Intrinsics.areEqual(this.backing[r0], r3) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r3) {
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        return new Itr(this, r3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r1) {
        checkIsMutable();
        int r2 = indexOf(r1);
        if (r2 < 0) goto L5;
        remove(r2);
    L5:
        if (r2 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(0, this.length, r3, false) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r3) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        return removeAtInternal(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        if (retainOrRemoveAllInternal(0, this.length, r4, true) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r4) {
        Intrinsics.checkNotNullParameter(r4, "array");
        int r0 = r4.length;
        int r1 = this.length;
        if (r0 < r1) goto L5;
        ArraysKt.copyInto(this.backing, r4, 0, 0, r1);
        return (T[]) CollectionsKt.terminateCollectionToArray(this.length, r4);
    L5:
        return (T[]) Arrays.copyOfRange(this.backing, 0, r1, r4.getClass());
    }

    public static final /* synthetic */ Object access$removeAtInternal(ListBuilder r0, int r1) {
        return r0.removeAtInternal(r1);
    }

    private final void addAtInternal(int r2, E r3) {
        registerModification();
        insertAtInternal(r2, 1);
        this.backing[r2] = r3;
    }

    private final void insertAtInternal(int r4, int r5) {
        ensureExtraCapacity(r5);
        E[] r0 = this.backing;
        ArraysKt.copyInto(r0, r0, r4 + r5, r4, this.length);
        this.length += r5;
    }

    private final void removeRangeInternal(int r4, int r5) {
        if (r5 <= 0) goto L4;
        registerModification();
    L4:
        E[] r0 = this.backing;
        ArraysKt.copyInto(r0, r0, r4, r4 + r5, this.length);
        E[] r6 = this.backing;
        int r1 = this.length;
        ListBuilderKt.resetRange(r6, r1 - r5, r1);
        this.length -= r5;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r3, E r4) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        addAtInternal(r3, r4);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r3, Collection<? extends E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, this.length);
        int r0 = r4.size();
        addAllInternal(r3, r4, r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        checkIsMutable();
        kotlin.collections.AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, this.length);
        E[] r0 = this.backing;
        E r1 = r0[r3];
        r0[r3] = r4;
        return r1;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int r9, int r10) {
        kotlin.collections.AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r9, r10, this.length);
        return new BuilderSubList(this.backing, r9, r10 - r9, null, this);
    }

    public /* synthetic */ ListBuilder(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 10;
    L5:
        this(r1);
    }

    public static final /* synthetic */ void access$addAtInternal(ListBuilder r0, int r1, Object r2) {
        r0.addAtInternal(r1, r2);
    }

    public static final /* synthetic */ void access$removeRangeInternal(ListBuilder r0, int r1, int r2) {
        r0.removeRangeInternal(r1, r2);
    }

    private final void addAllInternal(int r5, Collection<? extends E> r6, int r7) {
        registerModification();
        insertAtInternal(r5, r7);
        Iterator<? extends E> r8 = r6.iterator();
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        this.backing[r5 + r0] = r8.next();
        r0 = r0 + 1;
        goto L3
    }

    public static final /* synthetic */ void access$addAllInternal(ListBuilder r0, int r1, Collection r2, int r3) {
        r0.addAllInternal(r1, r2, r3);
    }

    private final int retainOrRemoveAllInternal(int r6, int r7, Collection<? extends E> r8, boolean r9) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r7) goto L8;
        int r3 = r6 + r0;
        if (r8.contains(this.backing[r3]) == r9) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        E[] r2 = this.backing;
        r0 = r0 + 1;
        r2[r1 + r6] = r2[r3];
        r1 = r1 + 1;
        goto L3
    L8:
        int r10 = r7 - r1;
        E[] r11 = this.backing;
        ArraysKt.copyInto(r11, r11, r6 + r1, r7 + r6, this.length);
        E[] r12 = this.backing;
        int r13 = this.length;
        ListBuilderKt.resetRange(r12, r13 - r10, r13);
        if (r10 <= 0) goto L11;
        registerModification();
    L11:
        this.length -= r10;
        return r10;
    }

    public static final /* synthetic */ int access$retainOrRemoveAllInternal(ListBuilder r0, int r1, int r2, Collection r3, boolean r4) {
        return r0.retainOrRemoveAllInternal(r1, r2, r3, r4);
    }
}
