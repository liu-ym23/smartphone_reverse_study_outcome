package org.apache.commons.lang3.mutable;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import org.apache.commons.lang3.math.NumberUtils;

/* JADX INFO: loaded from: classes42.dex */
public class MutableInt extends Number implements Comparable<MutableInt> {
    private static final long serialVersionUID = 512176391864L;
    private int value;

    public void decrement() {
        this.value--;
    }

    public int decrementAndGet() {
        int r100 = this.value - 1;
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

    public int getAndDecrement() {
        int r100 = this.value;
        this.value = r100 - 1;
        return r100;
    }

    public int getAndIncrement() {
        int r100 = this.value;
        this.value = r100 + 1;
        return r100;
    }

    public Integer getValue() {
        return Integer.valueOf(this.value);
    }

    public void increment() {
        this.value++;
    }

    public int incrementAndGet() {
        int r100 = this.value + 1;
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

    public Integer toInteger() {
        return Integer.valueOf(intValue());
    }

    public MutableInt() {
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10983getValue() {
        return getValue();
    }

    public MutableInt(Number r100) {
        this.value = r100.intValue();
    }

    public void add(Number r100) {
        this.value += r100.intValue();
    }

    public int addAndGet(Number r100) {
        int r101 = this.value + r100.intValue();
        this.value = r101;
        return r101;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MutableInt r100) {
        return NumberUtils.compare(this.value, r100.value);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MutableInt) == true) goto L5;
        return false;
    L5:
        if (this.value != ((MutableInt) r100).intValue()) goto L9;
        return true;
    L9:
        return false;
    }

    public int getAndAdd(Number r100) {
        int r101 = this.value;
        this.value = r100.intValue() + r101;
        return r101;
    }

    public void setValue(Number r100) {
        this.value = r100.intValue();
    }

    public void subtract(Number r100) {
        this.value -= r100.intValue();
    }

    public MutableInt(String r100) {
        this.value = CastIntegerProtector.parseInt(r100);
    }

    public void add(int r100) {
        this.value += r100;
    }

    public int addAndGet(int r100) {
        int r101 = this.value + r100;
        this.value = r101;
        return r101;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MutableInt r100) {
        return compareTo2(r100);
    }

    public int getAndAdd(int r100) {
        int r101 = this.value;
        this.value = r100 + r101;
        return r101;
    }

    public /* bridge */ /* synthetic */ void setValue(Object r100) {
        setValue((Number) r100);
    }

    public void subtract(int r100) {
        this.value -= r100;
    }

    public MutableInt(int r100) {
        this.value = r100;
    }

    public void setValue(int r100) {
        this.value = r100;
    }
}
