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
class Booleans$BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;
    final boolean[] array;
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
        if (r100 >= this.end) goto L10;
        int r102 = r101 * 31;
        if (this.array[r100] == false) goto L8;
        int r103 = 1231;
    L9:
        r101 = r102 + r103;
        r100 = r100 + 1;
        goto L4
    L8:
        r103 = 1237;
        goto L9
    L10:
        return r101;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.end - this.start;
    }

    public boolean[] toBooleanArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder r100 = new StringBuilder(size() * 7);
        if (this.array[this.start] == false) goto L5;
        String r101 = "[true";
    L6:
        r100.append(r101);
        int r102 = this.start;
    L7:
        r102 = r102 + 1;
        if (r102 >= this.end) goto L14;
        if (this.array[r102] == false) goto L12;
        String r103 = ", true";
    L13:
        r100.append(r103);
        goto L7
    L12:
        r103 = ", false";
        goto L13
    L14:
        r100.append(']');
        return r100.toString();
    L5:
        r101 = "[false";
        goto L6
    }

    public Booleans$BooleanArrayAsList(boolean[] r100) {
        this(r100, 0, r100.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@CheckForNull Object r100) {
        if ((r100 instanceof Boolean) == false) goto L14;
        boolean[] r101 = this.array;
        boolean r102 = ((Boolean) r100).booleanValue();
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
        if ((r100 instanceof Booleans$BooleanArrayAsList) == false) goto L18;
        Booleans$BooleanArrayAsList r101 = (Booleans$BooleanArrayAsList) r100;
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
    public Boolean get(int r100) {
        m.j(r100, size());
        return Boolean.valueOf(this.array[this.start + r100]);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(@CheckForNull Object r100) {
        if ((r100 instanceof Boolean) == false) goto L14;
        boolean[] r101 = this.array;
        boolean r102 = ((Boolean) r100).booleanValue();
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
        if ((r100 instanceof Boolean) == false) goto L14;
        boolean[] r101 = this.array;
        boolean r102 = ((Boolean) r100).booleanValue();
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

    public Boolean set(int r100, Boolean r101) {
        m.j(r100, size());
        boolean[] r102 = this.array;
        int r103 = this.start + r100;
        boolean r104 = r102[r103];
        r101.getClass();
        r102[r103] = r101.booleanValue();
        return Boolean.valueOf(r104);
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Boolean> subList(int r100, int r101) {
        m.n(r100, r101, size());
        if (r100 == r101) goto L5;
        boolean[] r102 = this.array;
        int r103 = this.start;
        return new Booleans$BooleanArrayAsList(r102, r100 + r103, r103 + r101);
    L5:
        return Collections.emptyList();
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
        return set(r100, (Boolean) r101);
    }

    public Booleans$BooleanArrayAsList(boolean[] r100, int r101, int r102) {
        this.array = r100;
        this.start = r101;
        this.end = r102;
    }
}
