package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b&\b\u0007\u0018\u0000 [*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001[B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\u0082\bJ\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0083\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010B\u001a\u00020\u0017H\u0002J\u0015\u0010C\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010D\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010E\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010G\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010H\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010I\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0018\u0010J\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0014J\u0018\u0010M\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0002J\u0018\u0010N\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0002J\u0016\u0010O\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010P\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010QJ\u001d\u0010R\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0000¢\u0006\u0002\bSJ\u0017\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\bU\u0010VJ)\u0010T\u001a\b\u0012\u0004\u0012\u0002HW0\u000b\"\u0004\b\u0001\u0010W2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0\u000bH\u0000¢\u0006\u0004\bU\u0010YJ\u0015\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0002\u0010VJ'\u0010Z\u001a\b\u0012\u0004\u0012\u0002HW0\u000b\"\u0004\b\u0001\u0010W2\f\u0010X\u001a\b\u0012\u0004\u0012\u0002HW0\u000bH\u0016¢\u0006\u0002\u0010YR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\\"}, d2 = {"Lkotlin/collections/ArrayDeque;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", SlcElement.KEY_ELEMENTS, "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", SoloKtvContext.SOLO_PAGE_FIRST, "()Ljava/lang/Object;", "firstOrNull", MonitorConstants.CONNECT_TYPE_GET, "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "nullifyNonEmpty", "internalFromIndex", "internalToIndex", "positiveMod", "registerModification", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "removeRange", "fromIndex", "toIndex", "removeRangeShiftPreceding", "removeRangeShiftSucceeding", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testRemoveRange", "testRemoveRange$kotlin_stdlib", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final Companion Companion = null;
    private static final int defaultMinCapacity = 10;
    private static final Object[] emptyElementData = null;
    private Object[] elementData;
    private int head;
    private int size;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        emptyElementData = new Object[0];
    }

    private final void registerModification() {
        ((java.util.AbstractList) this).modCount++;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if ((!isEmpty()) == false) goto L5;
        registerModification();
        nullifyNonEmpty(this.head, positiveMod(this.head + size()));
    L5:
        this.head = 0;
        this.size = 0;
    }

    public final E first() {
        if (isEmpty() == true) goto L7;
        return (E) this.elementData[this.head];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E firstOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.elementData[this.head];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final E last() {
        if (isEmpty() == true) goto L7;
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E lastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    public final E removeFirst() {
        if (isEmpty() == true) goto L7;
        registerModification();
        Object[] r100 = this.elementData;
        int r101 = this.head;
        E r102 = (E) r100[r101];
        r100[r101] = null;
        this.head = incremented(r101);
        this.size = size() - 1;
        return r102;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeFirstOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty() == true) goto L7;
        registerModification();
        int r100 = positiveMod(this.head + CollectionsKt.getLastIndex(this));
        Object[] r101 = this.elementData;
        E r102 = (E) r101[r100];
        r101[r100] = null;
        this.size = size() - 1;
        return r102;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeLast();
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    public ArrayDeque(int r100) {
        if (r100 != 0) goto L5;
        Object[] r101 = emptyElementData;
    L7:
        this.elementData = r101;
        return;
    L5:
        if (r100 <= 0) goto L10;
        r101 = new Object[r100];
        goto L7
    L10:
        throw new IllegalArgumentException("Illegal Capacity: " + r100);
    }

    private final void copyElements(int r100) {
        Object[] r101 = new Object[r100];
        Object[] r102 = this.elementData;
        ArraysKt.copyInto(r102, r101, 0, this.head, r102.length);
        Object[] r103 = this.elementData;
        int r104 = r103.length;
        int r105 = this.head;
        ArraysKt.copyInto(r103, r101, r104 - r105, 0, r105);
        this.head = 0;
        this.elementData = r101;
    }

    private final int decremented(int r100) {
        if (r100 != 0) goto L5;
        return ArraysKt.getLastIndex(this.elementData);
    L5:
        return r100 - 1;
    }

    private final void ensureCapacity(int r100) {
        if (r100 < 0) goto L13;
        Object[] r101 = this.elementData;
        if (r100 > r101.length) goto L7;
        return;
    L7:
        if (r101 != emptyElementData) goto L10;
        this.elementData = new Object[RangesKt.coerceAtLeast(r100, 10)];
        return;
    L10:
        copyElements(AbstractList.Companion.newCapacity$kotlin_stdlib(r101.length, r100));
        return;
    L13:
        throw new IllegalStateException("Deque is too big.");
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> r110) {
        boolean r100 = false;
        r100 = false;
        int r101 = 0;
        r100 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r100;
    L5:
        if (this.elementData.length != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L37;
        int r103 = positiveMod(this.head + size());
        int r104 = this.head;
        if (r104 >= r103) goto L20;
        int r105 = r104;
    L13:
        if (r104 >= r103) goto L19;
        Object r106 = this.elementData[r104];
        if (r110.invoke(r106).booleanValue() == false) goto L17;
        this.elementData[r105] = r106;
        r105 = r105 + 1;
    L18:
        r104 = r104 + 1;
        goto L13
    L17:
        r100 = true;
        goto L18
    L19:
        ArraysKt.fill(this.elementData, null, r105, r103);
    L35:
        if (r100 == false) goto L37;
        registerModification();
        this.size = negativeMod(r105 - this.head);
        goto L37
    L20:
        int r107 = this.elementData.length;
        int r108 = r104;
        boolean r109 = false;
    L21:
        if (r104 >= r107) goto L27;
        Object[] r111 = this.elementData;
        Object r112 = r111[r104];
        r111[r104] = null;
        if (r110.invoke(r112).booleanValue() == false) goto L25;
        this.elementData[r108] = r112;
        r108 = r108 + 1;
    L26:
        r104 = r104 + 1;
        goto L21
    L25:
        r109 = true;
        goto L26
    L27:
        r105 = positiveMod(r108);
    L28:
        if (r101 >= r103) goto L34;
        Object[] r113 = this.elementData;
        Object r114 = r113[r101];
        r113[r101] = null;
        if (r110.invoke(r114).booleanValue() == false) goto L32;
        this.elementData[r105] = r114;
        r105 = incremented(r105);
    L33:
        r101 = r101 + 1;
        goto L28
    L32:
        r109 = true;
        goto L33
    L34:
        r100 = r109;
        goto L35
    L7:
        r102 = false;
        goto L8
    }

    private final int incremented(int r100) {
        if (r100 != ArraysKt.getLastIndex(this.elementData)) goto L6;
        return 0;
    L6:
        return r100 + 1;
    }

    private final E internalGet(int r100) {
        return (E) this.elementData[r100];
    }

    private final int internalIndex(int r100) {
        return positiveMod(this.head + r100);
    }

    private final int negativeMod(int r100) {
        if (r100 < 0) goto L4;
        return r100;
    L4:
        return r100 + this.elementData.length;
    }

    private final int positiveMod(int r100) {
        Object[] r101 = this.elementData;
        if (r100 >= r101.length) goto L5;
        return r100;
    L5:
        return r100 - r101.length;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r100) {
        addLast(r100);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        if (r100.isEmpty() == false) goto L6;
        return false;
    L6:
        registerModification();
        ensureCapacity(size() + r100.size());
        copyCollectionElements(positiveMod(this.head + size()), r100);
        return true;
    }

    public final void addFirst(E r100) {
        registerModification();
        ensureCapacity(size() + 1);
        int r101 = decremented(this.head);
        this.head = r101;
        this.elementData[r101] = r100;
        this.size = size() + 1;
    }

    public final void addLast(E r100) {
        registerModification();
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = r100;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r100) {
        if (indexOf(r100) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r100) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, size());
        return (E) this.elementData[positiveMod(this.head + r100)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r100) {
        int r101 = positiveMod(this.head + size());
        int r102 = this.head;
        if (r102 >= r101) goto L11;
    L4:
        if (r102 >= r101) goto L32;
        if (Intrinsics.areEqual(r100, this.elementData[r102]) == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        int r103 = this.head;
    L9:
        return r102 - r103;
    L32:
        return -1;
    L11:
        if (r102 < r101) goto L24;
        int r104 = this.elementData.length;
    L13:
        if (r102 >= r104) goto L18;
        if (Intrinsics.areEqual(r100, this.elementData[r102]) == true) goto L16;
        r102 = r102 + 1;
        goto L13
    L16:
        r103 = this.head;
        goto L9
    L18:
        int r105 = 0;
    L19:
        if (r105 >= r101) goto L33;
        if (Intrinsics.areEqual(r100, this.elementData[r105]) == true) goto L22;
        r105 = r105 + 1;
        goto L19
    L22:
        r102 = r105 + this.elementData.length;
        r103 = this.head;
        goto L9
    L33:
        return -1;
    L24:
        return -1;
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "structure");
        int r101 = positiveMod(this.head + size());
        if (isEmpty() == true) goto L8;
        int r102 = this.head;
        if (r102 < r101) goto L8;
        int r103 = r102 - this.elementData.length;
    L9:
        r100.invoke(Integer.valueOf(r103), toArray());
        return;
    L8:
        r103 = this.head;
        goto L9
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r100) {
        int r101 = positiveMod(this.head + size());
        int r102 = this.head;
        if (r102 >= r101) goto L13;
        int r103 = r101 - 1;
        if (r102 <= r103) goto L7;
    L27:
        return -1;
    L7:
        if (Intrinsics.areEqual(r100, this.elementData[r103]) == true) goto L8;
        if (r103 == r102) goto L27;
        r103 = r103 - 1;
        goto L7
    L8:
        int r104 = this.head;
    L10:
        return r103 - r104;
    L13:
        if (r102 <= r101) goto L27;
        int r105 = r101 - 1;
    L15:
        if ((-1) >= r105) goto L20;
        if (Intrinsics.areEqual(r100, this.elementData[r105]) == true) goto L18;
        r105 = r105 - 1;
        goto L15
    L18:
        r103 = r105 + this.elementData.length;
        r104 = this.head;
        goto L10
    L20:
        r103 = ArraysKt.getLastIndex(this.elementData);
        int r106 = this.head;
        if (r106 > r103) goto L27;
    L23:
        if (Intrinsics.areEqual(r100, this.elementData[r103]) == true) goto L24;
        if (r103 == r106) goto L27;
        r103 = r103 - 1;
        goto L23
    L24:
        r104 = this.head;
        goto L10
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r100) {
        int r101 = indexOf(r100);
        if (r101 != (-1)) goto L6;
        return false;
    L6:
        remove(r101);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        boolean r100 = false;
        r100 = false;
        int r101 = 0;
        r100 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r100;
    L5:
        if (this.elementData.length != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L37;
        int r103 = positiveMod(this.head + size());
        int r104 = this.head;
        if (r104 >= r103) goto L20;
        int r105 = r104;
    L13:
        if (r104 >= r103) goto L19;
        Object r106 = this.elementData[r104];
        if ((!r110.contains(r106)) == false) goto L17;
        this.elementData[r105] = r106;
        r105 = r105 + 1;
    L18:
        r104 = r104 + 1;
        goto L13
    L17:
        r100 = true;
        goto L18
    L19:
        ArraysKt.fill(this.elementData, null, r105, r103);
    L35:
        if (r100 == false) goto L37;
        registerModification();
        this.size = negativeMod(r105 - this.head);
        goto L37
    L20:
        int r107 = this.elementData.length;
        int r108 = r104;
        boolean r109 = false;
    L21:
        if (r104 >= r107) goto L27;
        Object[] r111 = this.elementData;
        Object r112 = r111[r104];
        r111[r104] = null;
        if ((!r110.contains(r112)) == false) goto L25;
        this.elementData[r108] = r112;
        r108 = r108 + 1;
    L26:
        r104 = r104 + 1;
        goto L21
    L25:
        r109 = true;
        goto L26
    L27:
        r105 = positiveMod(r108);
    L28:
        if (r101 >= r103) goto L34;
        Object[] r113 = this.elementData;
        Object r114 = r113[r101];
        r113[r101] = null;
        if ((!r110.contains(r114)) == false) goto L32;
        this.elementData[r105] = r114;
        r105 = incremented(r105);
    L33:
        r101 = r101 + 1;
        goto L28
    L32:
        r109 = true;
        goto L33
    L34:
        r100 = r109;
        goto L35
    L7:
        r102 = false;
        goto L8
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r100) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, size());
        if (r100 == CollectionsKt.getLastIndex(this)) goto L5;
        if (r100 == 0) goto L8;
        registerModification();
        int r101 = positiveMod(this.head + r100);
        E r102 = (E) this.elementData[r101];
        if (r100 >= (size() >> 1)) goto L16;
        int r103 = this.head;
        if (r101 < r103) goto L14;
        Object[] r104 = this.elementData;
        ArraysKt.copyInto(r104, r104, r103 + 1, r103, r101);
    L15:
        Object[] r105 = this.elementData;
        int r106 = this.head;
        r105[r106] = null;
        this.head = incremented(r106);
    L21:
        this.size = size() - 1;
        return r102;
    L14:
        Object[] r107 = this.elementData;
        ArraysKt.copyInto(r107, r107, 1, 0, r101);
        Object[] r108 = this.elementData;
        r108[0] = r108[r108.length - 1];
        int r109 = this.head;
        ArraysKt.copyInto(r108, r108, r109 + 1, r109, r108.length - 1);
        goto L15
    L16:
        int r110 = positiveMod(this.head + CollectionsKt.getLastIndex(this));
        if (r101 > r110) goto L19;
        Object[] r111 = this.elementData;
        ArraysKt.copyInto(r111, r111, r101, r101 + 1, r110 + 1);
    L20:
        this.elementData[r110] = null;
        goto L21
    L19:
        Object[] r112 = this.elementData;
        ArraysKt.copyInto(r112, r112, r101, r101 + 1, r112.length);
        Object[] r113 = this.elementData;
        r113[r113.length - 1] = r113[0];
        ArraysKt.copyInto(r113, r113, 0, 1, r110 + 1);
        goto L20
    L8:
        return removeFirst();
    L5:
        return removeLast();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        boolean r100 = false;
        r100 = false;
        int r101 = 0;
        r100 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r100;
    L5:
        if (this.elementData.length != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L37;
        int r103 = positiveMod(this.head + size());
        int r104 = this.head;
        if (r104 >= r103) goto L20;
        int r105 = r104;
    L13:
        if (r104 >= r103) goto L19;
        Object r106 = this.elementData[r104];
        if (r110.contains(r106) == false) goto L17;
        this.elementData[r105] = r106;
        r105 = r105 + 1;
    L18:
        r104 = r104 + 1;
        goto L13
    L17:
        r100 = true;
        goto L18
    L19:
        ArraysKt.fill(this.elementData, null, r105, r103);
    L35:
        if (r100 == false) goto L37;
        registerModification();
        this.size = negativeMod(r105 - this.head);
        goto L37
    L20:
        int r107 = this.elementData.length;
        int r108 = r104;
        boolean r109 = false;
    L21:
        if (r104 >= r107) goto L27;
        Object[] r111 = this.elementData;
        Object r112 = r111[r104];
        r111[r104] = null;
        if (r110.contains(r112) == false) goto L25;
        this.elementData[r108] = r112;
        r108 = r108 + 1;
    L26:
        r104 = r104 + 1;
        goto L21
    L25:
        r109 = true;
        goto L26
    L27:
        r105 = positiveMod(r108);
    L28:
        if (r101 >= r103) goto L34;
        Object[] r113 = this.elementData;
        Object r114 = r113[r101];
        r113[r101] = null;
        if (r110.contains(r114) == false) goto L32;
        this.elementData[r105] = r114;
        r105 = incremented(r105);
    L33:
        r101 = r101 + 1;
        goto L28
    L32:
        r109 = true;
        goto L33
    L34:
        r100 = r109;
        goto L35
    L7:
        r102 = false;
        goto L8
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        return (T[]) toArray(r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        if (r100.length >= size()) goto L6;
        r100 = (T[]) ArraysKt__ArraysJVMKt.arrayOfNulls(r100, size());
    L6:
        int r101 = positiveMod(this.head + size());
        int r102 = this.head;
        if (r102 >= r101) goto L10;
        ArraysKt.copyInto$default(this.elementData, r100, 0, r102, r101, 2, null);
    L13:
        return (T[]) CollectionsKt.terminateCollectionToArray(size(), r100);
    L10:
        if ((!isEmpty()) == false) goto L13;
        Object[] r103 = this.elementData;
        ArraysKt.copyInto(r103, r100, 0, this.head, r103.length);
        Object[] r104 = this.elementData;
        ArraysKt.copyInto(r104, r100, r104.length - this.head, 0, r101);
        goto L13
    }

    public ArrayDeque(Collection<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        boolean r101 = false;
        Object[] r102 = r100.toArray(new Object[0]);
        this.elementData = r102;
        this.size = r102.length;
        if (r102.length != 0) goto L5;
        r101 = true;
    L5:
        if (r101 == false) goto L8;
        this.elementData = emptyElementData;
        return;
    }

    private final void copyCollectionElements(int r100, Collection<? extends E> r101) {
        Iterator<? extends E> r102 = r101.iterator();
        int r103 = this.elementData.length;
    L3:
        if (r100 >= r103) goto L7;
        if (r102.hasNext() == false) goto L7;
        this.elementData[r100] = r102.next();
        r100 = r100 + 1;
    L7:
        int r104 = this.head;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L12;
        if (r102.hasNext() == false) goto L12;
        this.elementData[r105] = r102.next();
        r105 = r105 + 1;
    L12:
        this.size = size() + r101.size();
    }

    private final void nullifyNonEmpty(int r100, int r101) {
        if (r100 >= r101) goto L5;
        ArraysKt.fill(this.elementData, null, r100, r101);
        return;
    L5:
        Object[] r102 = this.elementData;
        ArraysKt.fill(r102, null, r100, r102.length);
        ArraysKt.fill(this.elementData, null, 0, r101);
    }

    private final void removeRangeShiftPreceding(int r100, int r101) {
        int r102 = positiveMod(this.head + (r100 - 1));
        int r103 = positiveMod(this.head + (r101 - 1));
    L3:
        if (r100 <= 0) goto L5;
        int r104 = r102 + 1;
        int r105 = Math.min(r100, Math.min(r104, r103 + 1));
        Object[] r106 = this.elementData;
        int r107 = r103 - r105;
        int r108 = r102 - r105;
        ArraysKt.copyInto(r106, r106, r107 + 1, r108 + 1, r104);
        r102 = negativeMod(r108);
        r103 = negativeMod(r107);
        r100 = r100 - r105;
        goto L3
    }

    private final void removeRangeShiftSucceeding(int r100, int r101) {
        int r102 = positiveMod(this.head + r101);
        int r103 = positiveMod(this.head + r100);
        int r104 = size();
    L3:
        r104 = r104 - r101;
        if (r104 <= 0) goto L6;
        Object[] r105 = this.elementData;
        r101 = Math.min(r104, Math.min(r105.length - r102, r105.length - r103));
        Object[] r106 = this.elementData;
        int r107 = r102 + r101;
        ArraysKt.copyInto(r106, r106, r103, r102, r107);
        r102 = positiveMod(r107);
        r103 = positiveMod(r103 + r101);
        goto L3
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r100, E r101) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r100, size());
        if (r100 != size()) goto L6;
        addLast(r101);
        return;
    L6:
        if (r100 != 0) goto L9;
        addFirst(r101);
        return;
    L9:
        registerModification();
        ensureCapacity(size() + 1);
        int r102 = positiveMod(this.head + r100);
        if (r100 >= ((size() + 1) >> 1)) goto L16;
        int r103 = decremented(r102);
        int r104 = decremented(this.head);
        int r105 = this.head;
        if (r103 < r105) goto L14;
        Object[] r106 = this.elementData;
        r106[r104] = r106[r105];
        ArraysKt.copyInto(r106, r106, r105, r105 + 1, r103 + 1);
    L15:
        this.elementData[r103] = r101;
        this.head = r104;
    L21:
        this.size = size() + 1;
        return;
    L14:
        Object[] r107 = this.elementData;
        ArraysKt.copyInto(r107, r107, r105 - 1, r105, r107.length);
        Object[] r108 = this.elementData;
        r108[r108.length - 1] = r108[0];
        ArraysKt.copyInto(r108, r108, 0, 1, r103 + 1);
        goto L15
    L16:
        int r109 = positiveMod(this.head + size());
        if (r102 >= r109) goto L19;
        Object[] r110 = this.elementData;
        ArraysKt.copyInto(r110, r110, r102 + 1, r102, r109);
    L20:
        this.elementData[r102] = r101;
        goto L21
    L19:
        Object[] r111 = this.elementData;
        ArraysKt.copyInto(r111, r111, 1, 0, r109);
        Object[] r112 = this.elementData;
        r112[0] = r112[r112.length - 1];
        ArraysKt.copyInto(r112, r112, r102 + 1, r102, r112.length - 1);
        goto L20
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r100, Collection<? extends E> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_ELEMENTS);
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r100, size());
        if (r110.isEmpty() == false) goto L6;
        return false;
    L6:
        if (r100 == size()) goto L8;
        registerModification();
        ensureCapacity(size() + r110.size());
        int r101 = positiveMod(this.head + size());
        int r102 = positiveMod(this.head + r100);
        int r103 = r110.size();
        if (r100 >= ((size() + 1) >> 1)) goto L24;
        int r104 = this.head;
        int r105 = r104 - r103;
        if (r102 < r104) goto L19;
        if (r105 < 0) goto L15;
        Object[] r106 = this.elementData;
        ArraysKt.copyInto(r106, r106, r105, r104, r102);
    L23:
        this.head = r105;
        copyCollectionElements(negativeMod(r102 - r103), r110);
    L38:
        return true;
    L15:
        Object[] r107 = this.elementData;
        r105 = r105 + r107.length;
        int r108 = r102 - r104;
        int r109 = r107.length - r105;
        if (r109 < r108) goto L18;
        ArraysKt.copyInto(r107, r107, r105, r104, r102);
        goto L23
    L18:
        ArraysKt.copyInto(r107, r107, r105, r104, r104 + r109);
        Object[] r111 = this.elementData;
        ArraysKt.copyInto(r111, r111, 0, this.head + r109, r102);
        goto L23
    L19:
        Object[] r112 = this.elementData;
        ArraysKt.copyInto(r112, r112, r105, r104, r112.length);
        if (r103 < r102) goto L22;
        Object[] r113 = this.elementData;
        ArraysKt.copyInto(r113, r113, r113.length - r103, 0, r102);
        goto L23
    L22:
        Object[] r114 = this.elementData;
        ArraysKt.copyInto(r114, r114, r114.length - r103, 0, r103);
        Object[] r115 = this.elementData;
        ArraysKt.copyInto(r115, r115, 0, r103, r102);
        goto L23
    L24:
        int r116 = r102 + r103;
        if (r102 >= r101) goto L33;
        int r117 = r103 + r101;
        Object[] r118 = this.elementData;
        if (r117 > r118.length) goto L30;
        ArraysKt.copyInto(r118, r118, r116, r102, r101);
    L37:
        copyCollectionElements(r102, r110);
        goto L38
    L30:
        if (r116 < r118.length) goto L32;
        ArraysKt.copyInto(r118, r118, r116 - r118.length, r102, r101);
        goto L37
    L32:
        int r119 = r101 - (r117 - r118.length);
        ArraysKt.copyInto(r118, r118, 0, r119, r101);
        Object[] r120 = this.elementData;
        ArraysKt.copyInto(r120, r120, r116, r102, r119);
        goto L37
    L33:
        Object[] r121 = this.elementData;
        ArraysKt.copyInto(r121, r121, r103, 0, r101);
        Object[] r122 = this.elementData;
        if (r116 < r122.length) goto L36;
        ArraysKt.copyInto(r122, r122, r116 - r122.length, r102, r122.length);
        goto L37
    L36:
        ArraysKt.copyInto(r122, r122, 0, r122.length - r103, r122.length);
        Object[] r123 = this.elementData;
        ArraysKt.copyInto(r123, r123, r116, r102, r123.length - r103);
        goto L37
    L8:
        return addAll(r110);
    }

    @Override // java.util.AbstractList
    public void removeRange(int r100, int r101) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r100, r101, size());
        int r102 = r101 - r100;
        if (r102 != 0) goto L6;
        return;
    L6:
        if (r102 != size()) goto L10;
        clear();
        return;
    L10:
        if (r102 != 1) goto L13;
        remove(r100);
        return;
    L13:
        registerModification();
        if (r100 >= (size() - r101)) goto L16;
        removeRangeShiftPreceding(r100, r101);
        int r103 = positiveMod(this.head + r102);
        nullifyNonEmpty(this.head, r103);
        this.head = r103;
    L17:
        this.size = size() - r102;
        return;
    L16:
        removeRangeShiftSucceeding(r100, r101);
        int r104 = positiveMod(this.head + size());
        nullifyNonEmpty(negativeMod(r104 - r102), r104);
        goto L17
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r100, E r101) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, size());
        int r102 = positiveMod(this.head + r100);
        Object[] r103 = this.elementData;
        E r104 = (E) r103[r102];
        r103[r102] = r101;
        return r104;
    }

    public final void testRemoveRange$kotlin_stdlib(int r100, int r101) {
        removeRange(r100, r101);
    }
}
