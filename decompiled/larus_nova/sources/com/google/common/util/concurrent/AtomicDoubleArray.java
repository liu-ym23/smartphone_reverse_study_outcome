package com.google.common.util.concurrent;

import com.google.common.primitives.ImmutableLongArray;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public final int length() {
        return this.longs.length();
    }

    public String toString() {
        int r100 = length() - 1;
        if (r100 != (-1)) goto L6;
        return "[]";
    L6:
        StringBuilder r101 = new StringBuilder((r100 + 1) * 19);
        r101.append('[');
        int r102 = 0;
    L7:
        r101.append(Double.longBitsToDouble(this.longs.get(r102)));
        if (r102 == r100) goto L9;
        r101.append(", ");
        r102 = r102 + 1;
        goto L7
    L9:
        r101.append(']');
        return r101.toString();
    }

    public AtomicDoubleArray(double[] r100) {
        int r101 = r100.length;
        long[] r102 = new long[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = Double.doubleToRawLongBits(r100[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        this.longs = new AtomicLongArray(r102);
    }

    private void readObject(ObjectInputStream r110) throws IOException, ClassNotFoundException {
        r110.defaultReadObject();
        int r100 = r110.readInt();
        ImmutableLongArray.b r101 = ImmutableLongArray.builder();
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        long r103 = Double.doubleToRawLongBits(r110.readDouble());
        r101.a(1);
        long[] r104 = r101.f275647a;
        int r105 = r101.f275648b;
        r104[r105] = r103;
        r101.f275648b = r105 + 1;
        r102 = r102 + 1;
        goto L3
    L6:
        if (r101.f275648b != 0) goto L8;
        ImmutableLongArray r106 = ImmutableLongArray.access$200();
    L9:
        this.longs = new AtomicLongArray(r106.toArray());
        return;
    L8:
        r106 = new ImmutableLongArray(r101.f275647a, 0, r101.f275648b, null);
        goto L9
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        int r101 = length();
        r100.writeInt(r101);
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100.writeDouble(get(r102));
        r102 = r102 + 1;
        goto L3
    }

    public final double get(int r100) {
        return Double.longBitsToDouble(this.longs.get(r100));
    }

    public AtomicDoubleArray(int r100) {
        this.longs = new AtomicLongArray(r100);
    }

    public double addAndGet(int r110, double r111) {
    L2:
        long r100 = this.longs.get(r110);
        double r101 = Double.longBitsToDouble(r100) + r111;
        long r102 = Double.doubleToRawLongBits(r101);
        if (this.longs.compareAndSet(r110, r100, r102) == false) goto L2;
        return r101;
    }

    public final double getAndAdd(int r110, double r111) {
    L2:
        long r100 = this.longs.get(r110);
        double r101 = Double.longBitsToDouble(r100);
        long r102 = Double.doubleToRawLongBits(r101 + r111);
        if (this.longs.compareAndSet(r110, r100, r102) == false) goto L2;
        return r101;
    }

    public final double getAndSet(int r100, double r101) {
        long r102 = Double.doubleToRawLongBits(r101);
        return Double.longBitsToDouble(this.longs.getAndSet(r100, r102));
    }

    public final void lazySet(int r100, double r101) {
        long r102 = Double.doubleToRawLongBits(r101);
        this.longs.lazySet(r100, r102);
    }

    public final void set(int r100, double r101) {
        long r102 = Double.doubleToRawLongBits(r101);
        this.longs.set(r100, r102);
    }

    public final boolean compareAndSet(int r100, double r101, double r110) {
        return this.longs.compareAndSet(r100, Double.doubleToRawLongBits(r101), Double.doubleToRawLongBits(r110));
    }

    public final boolean weakCompareAndSet(int r100, double r101, double r110) {
        return this.longs.weakCompareAndSet(r100, Double.doubleToRawLongBits(r101), Double.doubleToRawLongBits(r110));
    }
}
