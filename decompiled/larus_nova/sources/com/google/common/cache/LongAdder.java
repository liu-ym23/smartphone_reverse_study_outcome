package com.google.common.cache;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class LongAdder extends Striped64 implements Serializable, j {
    private static final long serialVersionUID = 7249069246863182397L;

    @Override // com.google.common.cache.Striped64
    public final long fn(long r100, long r101) {
        return r100 + r101;
    }

    public void decrement() {
        add(-1);
    }

    @Override // com.google.common.cache.j
    public void increment() {
        add(1);
    }

    public void reset() {
        internalReset(0);
    }

    @Override // com.google.common.cache.j
    public long sum() {
        long r100 = this.base;
        Striped64.b[] r101 = this.cells;
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        Striped64.b r104 = r101[r103];
        if (r104 == null) goto L9;
        r100 = r100 + r104.f274866a;
    L9:
        r103 = r103 + 1;
    L10:
        return r100;
    }

    public long sumThenReset() {
        long r100 = this.base;
        Striped64.b[] r101 = this.cells;
        this.base = 0;
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        Striped64.b r104 = r101[r103];
        if (r104 == null) goto L9;
        r100 = r100 + r104.f274866a;
        r104.f274866a = 0;
    L9:
        r103 = r103 + 1;
    L10:
        return r100;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return sum();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public String toString() {
        return Long.toString(sum());
    }

    public LongAdder() {
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = r100.readLong();
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeLong(sum());
    }

    @Override // com.google.common.cache.j
    public void add(long r100) {
        Striped64.b[] r101 = this.cells;
        if (r101 != null) goto L6;
        long r102 = this.base;
        if (casBase(r102, r102 + r100) == false) goto L6;
        return;
    L6:
        int[] r103 = Striped64.threadHashCode.get();
        boolean r104 = true;
        if (r103 == null) goto L15;
        if (r101 == null) goto L15;
        int r105 = r101.length;
        if (r105 < 1) goto L15;
        Striped64.b r106 = r101[(r105 - 1) & r103[0]];
        if (r106 == null) goto L15;
        long r107 = r106.f274866a;
        r104 = r106.a(r107, r107 + r100);
        if (r104 == false) goto L15;
        return;
    L15:
        retryUpdate(r100, r103, r104);
    }
}
