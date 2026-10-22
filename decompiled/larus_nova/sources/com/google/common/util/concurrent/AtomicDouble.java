package com.google.common.util.concurrent;

import androidx.camera.video.AudioStats;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class AtomicDouble extends Number implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLong value;

    public AtomicDouble() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public final double get() {
        return Double.longBitsToDouble(this.value.get());
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public String toString() {
        return Double.toString(get());
    }

    public AtomicDouble(double r100) {
        this.value = new AtomicLong(Double.doubleToRawLongBits(r100));
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        this.value = new AtomicLong();
        set(r100.readDouble());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeDouble(get());
    }

    public final double addAndGet(double r100) {
    L2:
        long r101 = this.value.get();
        double r102 = Double.longBitsToDouble(r101) + r100;
        long r103 = Double.doubleToRawLongBits(r102);
        if (this.value.compareAndSet(r101, r103) == false) goto L2;
        return r102;
    }

    public final double getAndAdd(double r100) {
    L2:
        long r101 = this.value.get();
        double r102 = Double.longBitsToDouble(r101);
        long r103 = Double.doubleToRawLongBits(r102 + r100);
        if (this.value.compareAndSet(r101, r103) == false) goto L2;
        return r102;
    }

    public final double getAndSet(double r100) {
        long r101 = Double.doubleToRawLongBits(r100);
        return Double.longBitsToDouble(this.value.getAndSet(r101));
    }

    public final void lazySet(double r100) {
        long r101 = Double.doubleToRawLongBits(r100);
        this.value.lazySet(r101);
    }

    public final void set(double r100) {
        long r101 = Double.doubleToRawLongBits(r100);
        this.value.set(r101);
    }

    public final boolean compareAndSet(double r100, double r101) {
        return this.value.compareAndSet(Double.doubleToRawLongBits(r100), Double.doubleToRawLongBits(r101));
    }

    public final boolean weakCompareAndSet(double r100, double r101) {
        return this.value.weakCompareAndSet(Double.doubleToRawLongBits(r100), Double.doubleToRawLongBits(r101));
    }
}
