package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\t\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0001J\u0011\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\bJ\u0011\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\bJ\u0011\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\nJ\u0011\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\nJ\u0006\u0010\u0013\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0003J\u0011\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\fH\u0086\nJ\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\fH\u0086\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\u0002J\u0010\u0010\u001a\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u0003J\u001a\u0010\u001b\u001a\u00020\r2\b\b\u0001\u0010\u001c\u001a\u00020\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001J\u001b\u0010\u001f\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\u0006\u0010 \u001a\u00020\rJ\u0006\u0010!\u001a\u00020\rR\u0012\u0010\u0006\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Landroidx/collection/MutableDoubleList;", "Landroidx/collection/DoubleList;", "initialCapacity", "", "<init>", "(I)V", "capacity", "getCapacity", "()I", "add", "", "element", "", "", "index", "addAll", "elements", "", "plusAssign", "clear", "trim", "minCapacity", "ensureCapacity", "minusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", "set", "sort", "sortDescending", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableDoubleList extends DoubleList {
    public MutableDoubleList() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public final void clear() {
        this._size = 0;
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void sort() {
        int r0 = this._size;
        if (r0 != 0) goto L5;
        return;
    L5:
        ArraysKt.sort(this.content, 0, r0);
    }

    public final void sortDescending() {
        int r0 = this._size;
        if (r0 != 0) goto L5;
        return;
    L5:
        ArraysKt.sortDescending(this.content, 0, r0);
    }

    public MutableDoubleList(int r2) {
        super(r2, null);
    }

    public final boolean add(double r4) {
        ensureCapacity(this._size + 1);
        double[] r0 = this.content;
        int r2 = this._size;
        r0[r2] = r4;
        this._size = r2 + 1;
        return true;
    }

    public final boolean addAll(DoubleList r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        return addAll(this._size, r2);
    }

    public final void ensureCapacity(int r3) {
        double[] r0 = this.content;
        if (r0.length >= r3) goto L6;
        this.content = Arrays.copyOf(r0, Math.max(r3, (r0.length * 3) / 2));
        return;
    }

    public final void minusAssign(DoubleList r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        double[] r0 = r5.content;
        int r6 = r5._size;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        remove(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(DoubleList r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        addAll(this._size, r2);
    }

    public final boolean remove(double r1) {
        int r2 = indexOf(r1);
        if (r2 < 0) goto L6;
        removeAt(r2);
        return true;
    L6:
        return false;
    }

    public final boolean removeAll(DoubleList r8) {
        Intrinsics.checkNotNullParameter(r8, "elements");
        int r0 = this._size;
        int r1 = r8._size - 1;
        if (r1 < 0) goto L9;
        int r4 = 0;
    L5:
        remove(r8.get(r4));
        if (r4 == r1) goto L9;
        r4 = r4 + 1;
    L9:
        if (r0 != this._size) goto L14;
        return false;
    L14:
        return true;
    }

    public final double removeAt(int r6) {
        boolean r0 = false;
        if (r6 >= 0) goto L5;
    L7:
        if (r0 == true) goto L9;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
    L9:
        double[] r1 = this.content;
        double r2 = r1[r6];
        int r3 = this._size;
        if (r6 == (r3 - 1)) goto L12;
        ArraysKt.copyInto(r1, r1, r6, r6 + 1, r3);
    L12:
        this._size--;
        return r2;
    L5:
        if (r6 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final boolean retainAll(double[] r14) {
        Intrinsics.checkNotNullParameter(r14, "elements");
        int r0 = this._size;
        double[] r1 = this.content;
        int r2 = r0 - 1;
    L3:
        int r4 = -1;
        if ((-1) >= r2) goto L18;
        double r6 = r1[r2];
        int r8 = r14.length;
        int r9 = 0;
    L6:
        if (r9 >= r8) goto L14;
        if (r14[r9] != r6) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L12;
        r9 = r9 + 1;
        goto L6
    L12:
        r4 = r9;
        goto L14
    L10:
        r10 = false;
    L14:
        if (r4 >= 0) goto L16;
        removeAt(r2);
    L16:
        r2 = r2 - 1;
        goto L3
    L18:
        if (r0 == this._size) goto L26;
        return true;
    L26:
        return false;
    }

    public final void trim(int r3) {
        int r4 = Math.max(r3, this._size);
        double[] r0 = this.content;
        if (r0.length <= r4) goto L6;
        this.content = Arrays.copyOf(r0, r4);
        return;
    }

    public final boolean addAll(double[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        return addAll(this._size, r2);
    }

    public final void minusAssign(double[] r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(double[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        addAll(this._size, r2);
    }

    public final boolean removeAll(double[] r7) {
        Intrinsics.checkNotNullParameter(r7, "elements");
        int r0 = this._size;
        int r1 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        remove(r7[r3]);
        r3 = r3 + 1;
        goto L3
    L6:
        if (r0 == this._size) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean retainAll(DoubleList r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        int r0 = this._size;
        double[] r1 = this.content;
        int r2 = r0 - 1;
    L4:
        if ((-1) >= r2) goto L10;
        if (r6.contains(r1[r2]) == true) goto L8;
        removeAt(r2);
    L8:
        r2 = r2 - 1;
        goto L4
    L10:
        if (r0 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final void minusAssign(double r1) {
        remove(r1);
    }

    public final void plusAssign(double r1) {
        add(r1);
    }

    public final void add(int r5, double r6) {
        boolean r0 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r0 == true) goto L9;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
    L9:
        ensureCapacity(this._size + 1);
        double[] r1 = this.content;
        int r2 = this._size;
        if (r5 == r2) goto L12;
        ArraysKt.copyInto(r1, r1, r5 + 1, r5, r2);
    L12:
        r1[r5] = r6;
        this._size++;
        return;
    L5:
        if (r5 > this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final boolean addAll(int r10, double[] r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r10 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("");
    L11:
        if (r11.length != 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return false;
    L16:
        ensureCapacity(this._size + r11.length);
        double[] r4 = this.content;
        int r1 = this._size;
        if (r10 == r1) goto L19;
        ArraysKt.copyInto(r4, r4, r11.length + r10, r10, r1);
    L19:
        ArraysKt.copyInto$default(r11, r4, r10, 0, 0, 12, null);
        this._size += r11.length;
        return true;
    L13:
        r3 = false;
        goto L14
    L5:
        if (r10 > this._size) goto L7;
        r2 = true;
        goto L8
    }

    public final void removeRange(int r4, int r5) {
        boolean r0 = true;
        if (r4 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L15;
        if (r5 >= 0) goto L11;
    L13:
        r0 = false;
    L14:
        if (r0 == false) goto L15;
    L16:
        if (r5 >= r4) goto L18;
        RuntimeHelpersKt.throwIllegalArgumentException("The end index must be < start index");
    L18:
        if (r5 == r4) goto L24;
        int r1 = this._size;
        if (r5 >= r1) goto L22;
        double[] r3 = this.content;
        ArraysKt.copyInto(r3, r3, r4, r5, r1);
    L22:
        this._size -= r5 - r4;
        return;
    L24:
        return;
    L11:
        if (r5 > this._size) goto L13;
    L15:
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        goto L16
    L5:
        if (r4 > this._size) goto L7;
        r2 = true;
        goto L8
    }

    public final double set(int r4, double r5) {
        boolean r0 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r0 == true) goto L9;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
    L9:
        double[] r1 = this.content;
        double r2 = r1[r4];
        r1[r4] = r5;
        return r2;
    L5:
        if (r4 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final boolean addAll(int r6, DoubleList r7) {
        Intrinsics.checkNotNullParameter(r7, "elements");
        if (r6 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        RuntimeHelpersKt.throwIndexOutOfBoundsException("");
    L10:
        int r3 = r7._size;
        if (r3 != 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
        return false;
    L16:
        ensureCapacity(this._size + r3);
        double[] r5 = this.content;
        int r8 = this._size;
        if (r6 == r8) goto L19;
        ArraysKt.copyInto(r5, r5, r7._size + r6, r6, r8);
    L19:
        ArraysKt.copyInto(r7.content, r5, r6, 0, r7._size);
        this._size += r7._size;
        return true;
    L13:
        r4 = false;
        goto L14
    L5:
        if (r6 > this._size) goto L7;
        r2 = true;
        goto L8
    }

    public /* synthetic */ MutableDoubleList(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 16;
    L5:
        this(r1);
    }

    public static /* synthetic */ void trim$default(MutableDoubleList r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = r0._size;
    L5:
        r0.trim(r1);
    }
}
