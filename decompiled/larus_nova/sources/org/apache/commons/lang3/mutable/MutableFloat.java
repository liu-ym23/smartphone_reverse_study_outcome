package org.apache.commons.lang3.mutable;

import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;

/* JADX INFO: loaded from: classes42.dex */
public class MutableFloat extends Number implements Comparable<MutableFloat> {
    private static final long serialVersionUID = 5787169186L;
    private float value;

    public void decrement() {
        this.value -= 1.0f;
    }

    public float decrementAndGet() {
        float r100 = this.value - 1.0f;
        this.value = r100;
        return r100;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public float getAndDecrement() {
        float r100 = this.value;
        this.value = r100 - 1.0f;
        return r100;
    }

    public float getAndIncrement() {
        float r100 = this.value;
        this.value = 1.0f + r100;
        return r100;
    }

    public Float getValue() {
        return Float.valueOf(this.value);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public void increment() {
        this.value += 1.0f;
    }

    public float incrementAndGet() {
        float r100 = this.value + 1.0f;
        this.value = r100;
        return r100;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Float.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Float.isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public Float toFloat() {
        return Float.valueOf(floatValue());
    }

    public MutableFloat() {
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10982getValue() {
        return getValue();
    }

    public MutableFloat(Number r100) {
        this.value = r100.floatValue();
    }

    public void add(Number r100) {
        this.value += r100.floatValue();
    }

    public float addAndGet(Number r100) {
        float r101 = this.value + r100.floatValue();
        this.value = r101;
        return r101;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MutableFloat r100) {
        return Float.compare(this.value, r100.value);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MutableFloat) == true) goto L5;
    L7:
        return false;
    L5:
        if (Float.floatToIntBits(((MutableFloat) r100).value) != Float.floatToIntBits(this.value)) goto L7;
        return true;
    }

    public float getAndAdd(Number r100) {
        float r101 = this.value;
        this.value = r100.floatValue() + r101;
        return r101;
    }

    public void setValue(Number r100) {
        this.value = r100.floatValue();
    }

    public void subtract(Number r100) {
        this.value -= r100.floatValue();
    }

    public MutableFloat(String r100) {
        this.value = CastFloatProtector.parseFloat(r100);
    }

    public void add(float r100) {
        this.value += r100;
    }

    public float addAndGet(float r100) {
        float r101 = this.value + r100;
        this.value = r101;
        return r101;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MutableFloat r100) {
        return compareTo2(r100);
    }

    public float getAndAdd(float r100) {
        float r101 = this.value;
        this.value = r100 + r101;
        return r101;
    }

    public /* bridge */ /* synthetic */ void setValue(Object r100) {
        setValue((Number) r100);
    }

    public void subtract(float r100) {
        this.value -= r100;
    }

    public MutableFloat(float r100) {
        this.value = r100;
    }

    public void setValue(float r100) {
        this.value = r100;
    }
}
