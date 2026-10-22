package org.apache.commons.lang3.mutable;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;

/* JADX INFO: loaded from: classes42.dex */
public class MutableDouble extends Number implements Comparable<MutableDouble> {
    private static final long serialVersionUID = 1587163916;
    private double value;

    public void decrement() {
        this.value -= 1.0d;
    }

    public double decrementAndGet() {
        double r100 = this.value - 1.0d;
        this.value = r100;
        return r100;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    public double getAndDecrement() {
        double r100 = this.value;
        this.value = r100 - 1.0d;
        return r100;
    }

    public double getAndIncrement() {
        double r100 = this.value;
        this.value = 1.0d + r100;
        return r100;
    }

    public Double getValue() {
        return Double.valueOf(this.value);
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.value);
        return (int) (r100 ^ (r100 >>> 32));
    }

    public void increment() {
        this.value += 1.0d;
    }

    public double incrementAndGet() {
        double r100 = this.value + 1.0d;
        this.value = r100;
        return r100;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Double.isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public Double toDouble() {
        return Double.valueOf(doubleValue());
    }

    public MutableDouble() {
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10981getValue() {
        return getValue();
    }

    public MutableDouble(Number r100) {
        this.value = r100.doubleValue();
    }

    public void add(Number r100) {
        this.value += r100.doubleValue();
    }

    public double addAndGet(Number r100) {
        double r101 = this.value + r100.doubleValue();
        this.value = r101;
        return r101;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MutableDouble r100) {
        return Double.compare(this.value, r100.value);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MutableDouble) == true) goto L5;
    L7:
        return false;
    L5:
        if (Double.doubleToLongBits(((MutableDouble) r100).value) != Double.doubleToLongBits(this.value)) goto L7;
        return true;
    }

    public double getAndAdd(Number r100) {
        double r101 = this.value;
        this.value = r100.doubleValue() + r101;
        return r101;
    }

    public void setValue(Number r100) {
        this.value = r100.doubleValue();
    }

    public void subtract(Number r100) {
        this.value -= r100.doubleValue();
    }

    public MutableDouble(String r100) {
        this.value = CastDoubleProtector.parseDouble(r100);
    }

    public void add(double r100) {
        this.value += r100;
    }

    public double addAndGet(double r100) {
        double r101 = this.value + r100;
        this.value = r101;
        return r101;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MutableDouble r100) {
        return compareTo2(r100);
    }

    public double getAndAdd(double r100) {
        double r101 = this.value;
        this.value = r100 + r101;
        return r101;
    }

    public /* bridge */ /* synthetic */ void setValue(Object r100) {
        setValue((Number) r100);
    }

    public void subtract(double r100) {
        this.value -= r100;
    }

    public MutableDouble(double r100) {
        this.value = r100;
    }

    public void setValue(double r100) {
        this.value = r100;
    }
}
