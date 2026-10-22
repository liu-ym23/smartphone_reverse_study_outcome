package org.apache.commons.lang3.mutable;

import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import org.apache.commons.lang3.math.NumberUtils;

/* JADX INFO: loaded from: classes42.dex */
public class MutableByte extends Number implements Comparable<MutableByte> {
    private static final long serialVersionUID = -1585823265;
    private byte value;

    public void decrement() {
        this.value = (byte) (this.value - 1);
    }

    public byte decrementAndGet() {
        byte r100 = (byte) (this.value - 1);
        this.value = r100;
        return r100;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public byte getAndDecrement() {
        byte r100 = this.value;
        this.value = (byte) (r100 - 1);
        return r100;
    }

    public byte getAndIncrement() {
        byte r100 = this.value;
        this.value = (byte) (r100 + 1);
        return r100;
    }

    public Byte getValue() {
        return Byte.valueOf(this.value);
    }

    public void increment() {
        this.value = (byte) (this.value + 1);
    }

    public byte incrementAndGet() {
        byte r100 = (byte) (this.value + 1);
        this.value = r100;
        return r100;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public Byte toByte() {
        return Byte.valueOf(byteValue());
    }

    public MutableByte() {
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10980getValue() {
        return getValue();
    }

    public MutableByte(Number r100) {
        this.value = r100.byteValue();
    }

    public void add(Number r100) {
        this.value = (byte) (this.value + r100.byteValue());
    }

    public byte addAndGet(Number r100) {
        byte r101 = (byte) (this.value + r100.byteValue());
        this.value = r101;
        return r101;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MutableByte r100) {
        return NumberUtils.compare(this.value, r100.value);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MutableByte) == true) goto L5;
        return false;
    L5:
        if (this.value != ((MutableByte) r100).byteValue()) goto L9;
        return true;
    L9:
        return false;
    }

    public byte getAndAdd(Number r100) {
        byte r101 = this.value;
        this.value = (byte) (r100.byteValue() + r101);
        return r101;
    }

    public void setValue(Number r100) {
        this.value = r100.byteValue();
    }

    public void subtract(Number r100) {
        this.value = (byte) (this.value - r100.byteValue());
    }

    public MutableByte(String r100) {
        this.value = CastByteProtector.parseByte(r100);
    }

    public void add(byte r100) {
        this.value = (byte) (this.value + r100);
    }

    public byte addAndGet(byte r100) {
        byte r101 = (byte) (this.value + r100);
        this.value = r101;
        return r101;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MutableByte r100) {
        return compareTo2(r100);
    }

    public byte getAndAdd(byte r100) {
        byte r101 = this.value;
        this.value = (byte) (r100 + r101);
        return r101;
    }

    public /* bridge */ /* synthetic */ void setValue(Object r100) {
        setValue((Number) r100);
    }

    public void subtract(byte r100) {
        this.value = (byte) (this.value - r100);
    }

    public MutableByte(byte r100) {
        this.value = r100;
    }

    public void setValue(byte r100) {
        this.value = r100;
    }
}
