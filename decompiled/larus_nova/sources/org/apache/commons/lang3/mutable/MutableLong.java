package org.apache.commons.lang3.mutable;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import org.apache.commons.lang3.math.NumberUtils;

/* JADX INFO: loaded from: classes42.dex */
public class MutableLong extends Number implements Comparable<MutableLong> {
    private static final long serialVersionUID = 62986528375L;
    private long value;

    public void decrement() {
        this.value--;
    }

    public long decrementAndGet() {
        long r100 = this.value - 1;
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

    public long getAndDecrement() {
        long r100 = this.value;
        this.value = r100 - 1;
        return r100;
    }

    public long getAndIncrement() {
        long r100 = this.value;
        this.value = 1 + r100;
        return r100;
    }

    public Long getValue() {
        return Long.valueOf(this.value);
    }

    public int hashCode() {
        long r100 = this.value;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public void increment() {
        this.value++;
    }

    public long incrementAndGet() {
        long r100 = this.value + 1;
        this.value = r100;
        return r100;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public Long toLong() {
        return Long.valueOf(longValue());
    }

    public MutableLong() {
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10984getValue() {
        return getValue();
    }

    public MutableLong(Number r100) {
        this.value = r100.longValue();
    }

    public void add(Number r100) {
        this.value += r100.longValue();
    }

    public long addAndGet(Number r100) {
        long r101 = this.value + r100.longValue();
        this.value = r101;
        return r101;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MutableLong r100) {
        return NumberUtils.compare(this.value, r100.value);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MutableLong) == true) goto L5;
        return false;
    L5:
        if (this.value != ((MutableLong) r100).longValue()) goto L9;
        return true;
    L9:
        return false;
    }

    public long getAndAdd(Number r100) {
        long r101 = this.value;
        this.value = r100.longValue() + r101;
        return r101;
    }

    public void setValue(Number r100) {
        this.value = r100.longValue();
    }

    public void subtract(Number r100) {
        this.value -= r100.longValue();
    }

    public MutableLong(String r100) {
        this.value = CastLongProtector.parseLong(r100);
    }

    public void add(long r100) {
        this.value += r100;
    }

    public long addAndGet(long r100) {
        long r101 = this.value + r100;
        this.value = r101;
        return r101;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MutableLong r100) {
        return compareTo2(r100);
    }

    public long getAndAdd(long r100) {
        long r101 = this.value;
        this.value = r100 + r101;
        return r101;
    }

    public /* bridge */ /* synthetic */ void setValue(Object r100) {
        setValue((Number) r100);
    }

    public void subtract(long r100) {
        this.value -= r100;
    }

    public MutableLong(long r100) {
        this.value = r100;
    }

    public void setValue(long r100) {
        this.value = r100;
    }
}
