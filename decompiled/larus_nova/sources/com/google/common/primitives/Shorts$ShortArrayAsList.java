package com.google.common.primitives;

import com.google.common.base.m;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
class Shorts$ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;
    final short[] array;
    final int end;
    final int start;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r100 = this.start;
        int r101 = 1;
    L4:
        if (r100 >= this.end) goto L6;
        r101 = (r101 * 31) + this.array[r100];
        r100 = r100 + 1;
        goto L4
    L6:
        return r101;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.end - this.start;
    }

    public short[] toShortArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder r100 = new StringBuilder(size() * 6);
        r100.append('[');
        r100.append(this.array[this.start]);
        int r101 = this.start;
    L3:
        r101 = r101 + 1;
        if (r101 >= this.end) goto L6;
        r100.append(", ");
        r100.append(this.array[r101]);
        goto L3
    L6:
        r100.append(']');
        return r100.toString();
    }

    public Shorts$ShortArrayAsList(short[] r100) {
        this(r100, 0, r100.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@CheckForNull Object r100) {
        if ((r100 instanceof Short) == false) goto L14;
        short[] r101 = this.array;
        short r102 = ((Short) r100).shortValue();
        int r103 = this.start;
        int r104 = this.end;
    L6:
        if (r103 >= r104) goto L11;
        if (r101[r103] == r102) goto L12;
        r103 = r103 + 1;
    L12:
        if (r103 == (-1)) goto L14;
        return true;
    L11:
        r103 = -1;
    L14:
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Shorts$ShortArrayAsList) == false) goto L18;
        Shorts$ShortArrayAsList r101 = (Shorts$ShortArrayAsList) r100;
        int r102 = size();
        if (r101.size() == r102) goto L10;
        return false;
    L10:
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L16;
        if (this.array[this.start + r103] != r101.array[r101.start + r103]) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return super.equals(r100);
    }

    @Override // java.util.AbstractList, java.util.List
    public Short get(int r100) {
        m.j(r100, size());
        return Short.valueOf(this.array[this.start + r100]);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(@CheckForNull Object r100) {
        if ((r100 instanceof Short) == false) goto L14;
        short[] r101 = this.array;
        short r102 = ((Short) r100).shortValue();
        int r103 = this.start;
        int r104 = this.end;
    L5:
        if (r103 >= r104) goto L10;
        if (r101[r103] == r102) goto L11;
        r103 = r103 + 1;
    L11:
        if (r103 < 0) goto L14;
        return r103 - this.start;
    L10:
        r103 = -1;
    L14:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(@CheckForNull Object r100) {
        if ((r100 instanceof Short) == false) goto L14;
        short[] r101 = this.array;
        short r102 = ((Short) r100).shortValue();
        int r103 = this.start;
        int r104 = this.end - 1;
    L5:
        if (r104 < r103) goto L10;
        if (r101[r104] == r102) goto L11;
        r104 = r104 - 1;
    L11:
        if (r104 < 0) goto L14;
        return r104 - this.start;
    L10:
        r104 = -1;
    L14:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r100) {
        return get(r100);
    }

    public Short set(int r100, Short r101) {
        m.j(r100, size());
        short[] r102 = this.array;
        int r103 = this.start + r100;
        short r104 = r102[r103];
        r101.getClass();
        r102[r103] = r101.shortValue();
        return Short.valueOf(r104);
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Short> subList(int r100, int r101) {
        m.n(r100, r101, size());
        if (r100 == r101) goto L5;
        short[] r102 = this.array;
        int r103 = this.start;
        return new Shorts$ShortArrayAsList(r102, r100 + r103, r103 + r101);
    L5:
        return Collections.emptyList();
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
        return set(r100, (Short) r101);
    }

    public Shorts$ShortArrayAsList(short[] r100, int r101, int r102) {
        this.array = r100;
        this.start = r101;
        this.end = r102;
    }
}
