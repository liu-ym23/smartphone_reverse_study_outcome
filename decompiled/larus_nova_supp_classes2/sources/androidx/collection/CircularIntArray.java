package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0003J\u0011\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006 "}, d2 = {"Landroidx/collection/CircularIntArray;", "", "minCapacity", "", "<init>", "(I)V", "elements", "", "head", "tail", "capacityBitmask", "doubleCapacity", "", "addFirst", "element", "addLast", "popFirst", "popLast", "clear", "removeFromStart", "count", "removeFromEnd", "first", "getFirst", "()I", "last", "getLast", "get", "index", "size", "isEmpty", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray() {
        int r2 = 0;
        this(r2, 1, null);
    }

    private final void doubleCapacity() {
        int[] r0 = this.elements;
        int r1 = r0.length;
        int r2 = this.head;
        int r3 = r1 - r2;
        int r4 = r1 << 1;
        if (r4 < 0) goto L7;
        int[] r5 = new int[r4];
        ArraysKt.copyInto(r0, r5, 0, r2, r1);
        ArraysKt.copyInto(this.elements, r5, r3, 0, this.head);
        this.elements = r5;
        this.head = 0;
        this.tail = r1;
        this.capacityBitmask = r4 - 1;
        return;
    L7:
        throw new RuntimeException("Max array capacity exceeded");
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final int getFirst() {
        int r0 = this.head;
        if (r0 != this.tail) goto L5;
        CollectionPlatformUtils r1 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    L5:
        return this.elements[r0];
    }

    public final int getLast() {
        int r0 = this.head;
        int r1 = this.tail;
        if (r0 != r1) goto L5;
        CollectionPlatformUtils r2 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    L5:
        return this.elements[(r1 - 1) & this.capacityBitmask];
    }

    public final boolean isEmpty() {
        if (this.head != this.tail) goto L5;
        return true;
    L5:
        return false;
    }

    public final int popFirst() {
        int r0 = this.head;
        if (r0 == this.tail) goto L6;
        int r1 = this.elements[r0];
        this.head = (r0 + 1) & this.capacityBitmask;
        return r1;
    L6:
        CollectionPlatformUtils r2 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int popLast() {
        int r0 = this.head;
        int r1 = this.tail;
        if (r0 == r1) goto L6;
        int r2 = this.capacityBitmask & (r1 - 1);
        int r3 = this.elements[r2];
        this.tail = r2;
        return r3;
    L6:
        CollectionPlatformUtils r4 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularIntArray(int r4) {
        boolean r0 = false;
        if (r4 < 1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        RuntimeHelpersKt.throwIllegalArgumentException("capacity must be >= 1");
    L9:
        if (r4 > 1073741824) goto L11;
        r0 = true;
    L11:
        if (r0 == true) goto L14;
        RuntimeHelpersKt.throwIllegalArgumentException("capacity must be <= 2^30");
    L14:
        if (Integer.bitCount(r4) == 1) goto L16;
        r4 = Integer.highestOneBit(r4 - 1) << 1;
    L16:
        this.capacityBitmask = r4 - 1;
        this.elements = new int[r4];
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void addFirst(int r3) {
        int r0 = (this.head - 1) & this.capacityBitmask;
        this.head = r0;
        this.elements[r0] = r3;
        if (r0 != this.tail) goto L6;
        doubleCapacity();
        return;
    }

    public final void addLast(int r3) {
        int[] r0 = this.elements;
        int r1 = this.tail;
        r0[r1] = r3;
        int r4 = this.capacityBitmask;
        int r5 = r4 & (r1 + 1);
        this.tail = r5;
        if (r5 != this.head) goto L6;
        doubleCapacity();
        return;
    }

    public final int get(int r3) {
        if (r3 >= 0) goto L4;
    L7:
        CollectionPlatformUtils r4 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    L4:
        if (r3 >= size()) goto L7;
        int[] r0 = this.elements;
        int r1 = this.head + r3;
        return r0[this.capacityBitmask & r1];
    }

    public final void removeFromEnd(int r2) {
        if (r2 > 0) goto L5;
        return;
    L5:
        if (r2 > size()) goto L8;
        int r0 = this.tail - r2;
        this.tail = this.capacityBitmask & r0;
        return;
    L8:
        CollectionPlatformUtils r3 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromStart(int r2) {
        if (r2 > 0) goto L5;
        return;
    L5:
        if (r2 > size()) goto L8;
        int r0 = this.head + r2;
        this.head = this.capacityBitmask & r0;
        return;
    L8:
        CollectionPlatformUtils r3 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public /* synthetic */ CircularIntArray(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 8;
    L5:
        this(r1);
    }
}
