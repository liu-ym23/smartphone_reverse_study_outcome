package org.apache.commons.lang3.mutable;

import com.bytedance.mt.protector.impl.string2number.CastShortProtector;
import org.apache.commons.lang3.math.NumberUtils;

/* JADX INFO: loaded from: classes42.dex */
public class MutableShort extends Number implements Comparable<MutableShort> {
    private static final long serialVersionUID = -2135791679;
    private short value;

    public void decrement() {
        this.value = (short) (this.value - 1);
    }

    public short decrementAndGet() {
        short r100 = (short) (this.value - 1);
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

    public short getAndDecrement() {
        short r100 = this.value;
        this.value = (short) (r100 - 1);
        return r100;
    }

    public short getAndIncrement() {
        short r100 = this.value;
        this.value = (short) (r100 + 1);
        return r100;
    }

    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public Short m10985getValue() {
        return Short.valueOf(this.value);
    }

    public void increment() {
        this.value = (short) (this.value + 1);
    }

    public short incrementAndGet() {
        short r100 = (short) (this.value + 1);
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

    public Short toShort() {
        return Short.valueOf(shortValue());
    }

    public MutableShort() {
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return this.value;
    }

    public /* bridge */ /* synthetic */ Object getValue() {
        return m10985getValue();
    }

    public MutableShort(Number r100) {
        this.value = r100.shortValue();
    }

    public void add(Number r100) {
        this.value = (short) (this.value + r100.shortValue());
    }

    public short addAndGet(Number r100) {
        short r101 = (short) (this.value + r100.shortValue());
        this.value = r101;
        return r101;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MutableShort r100) {
        return NumberUtils.compare(this.value, r100.value);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MutableShort) == true) goto L5;
        return false;
    L5:
        if (this.value != ((MutableShort) r100).shortValue()) goto L9;
        return true;
    L9:
        return false;
    }

    public short getAndAdd(Number r100) {
        short r101 = this.value;
        this.value = (short) (r100.shortValue() + r101);
        return r101;
    }

    public void setValue(Number r100) {
        this.value = r100.shortValue();
    }

    public void subtract(Number r100) {
        this.value = (short) (this.value - r100.shortValue());
    }

    public MutableShort(String r100) {
        this.value = CastShortProtector.parseShort(r100);
    }

    public void add(short r100) {
        this.value = (short) (this.value + r100);
    }

    public short addAndGet(short r100) {
        short r101 = (short) (this.value + r100);
        this.value = r101;
        return r101;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MutableShort r100) {
        return compareTo2(r100);
    }

    public short getAndAdd(short r100) {
        short r101 = this.value;
        this.value = (short) (r100 + r101);
        return r101;
    }

    public /* bridge */ /* synthetic */ void setValue(Object r100) {
        setValue((Number) r100);
    }

    public void subtract(short r100) {
        this.value = (short) (this.value - r100);
    }

    public MutableShort(short r100) {
        this.value = r100;
    }

    public void setValue(short r100) {
        this.value = r100;
    }
}
