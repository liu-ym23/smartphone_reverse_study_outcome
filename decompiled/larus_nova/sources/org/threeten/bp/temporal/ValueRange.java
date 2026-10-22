package org.threeten.bp.temporal;

import androidx.collection.SieveCacheKt;
import java.io.Serializable;
import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes41.dex */
public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    public int hashCode() {
        long r100 = this.minSmallest;
        long r101 = this.minLargest;
        long r102 = (r100 + r101) << ((int) (r101 + 16));
        long r103 = this.maxSmallest;
        long r104 = (r102 >> ((int) (r103 + 48))) << ((int) (r103 + 32));
        long r105 = this.maxLargest;
        long r106 = ((r104 >> ((int) (32 + r105))) << ((int) (r105 + 48))) >> 16;
        return (int) (r106 ^ (r106 >>> 32));
    }

    public boolean isFixed() {
        if (this.minSmallest == this.minLargest) goto L5;
    L7:
        return false;
    L5:
        if (this.maxSmallest != this.maxLargest) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.minSmallest);
        if (this.minSmallest == this.minLargest) goto L5;
        r100.append('/');
        r100.append(this.minLargest);
    L5:
        r100.append(" - ");
        r100.append(this.maxSmallest);
        if (this.maxSmallest == this.maxLargest) goto L9;
        r100.append('/');
        r100.append(this.maxLargest);
    L9:
        return r100.toString();
    }

    public boolean isIntValue() {
        if (getMinimum() >= SieveCacheKt.NodeMetaAndPreviousMask) goto L5;
    L7:
        return false;
    L5:
        if (getMaximum() > SieveCacheKt.NodeLinkMask) goto L7;
        return true;
    }

    public long getLargestMinimum() {
        return this.minLargest;
    }

    public long getMaximum() {
        return this.maxLargest;
    }

    public long getMinimum() {
        return this.minSmallest;
    }

    public long getSmallestMaximum() {
        return this.maxSmallest;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ValueRange) == false) goto L18;
        ValueRange r101 = (ValueRange) r100;
        if (this.minSmallest == r101.minSmallest) goto L10;
    L16:
        return false;
    L10:
        if (this.minLargest != r101.minLargest) goto L16;
        if (this.maxSmallest != r101.maxSmallest) goto L16;
        if (this.maxLargest != r101.maxLargest) goto L16;
        return true;
    L18:
        return false;
    }

    public boolean isValidIntValue(long r100) {
        if (isIntValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidValue(r100) == false) goto L7;
        return true;
    }

    public boolean isValidValue(long r100) {
        if (r100 >= getMinimum()) goto L5;
    L7:
        return false;
    L5:
        if (r100 > getMaximum()) goto L7;
        return true;
    }

    public static ValueRange of(long r110, long r111) {
        if (r110 > r111) goto L7;
        return new ValueRange(r110, r110, r111, r111);
    L7:
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public int checkValidIntValue(long r100, f r101) {
        if (isValidIntValue(r100) == false) goto L7;
        return (int) r100;
    L7:
        throw new DateTimeException("Invalid int value for " + r101 + ": " + r100);
    }

    public long checkValidValue(long r100, f r101) {
        if (isValidValue(r100) == false) goto L5;
        return r100;
    L5:
        if (r101 == null) goto L9;
        throw new DateTimeException("Invalid value for " + r101 + " (valid values " + this + "): " + r100);
    L9:
        throw new DateTimeException("Invalid value (valid values " + this + "): " + r100);
    }

    public static ValueRange of(long r100, long r110, long r111) {
        return of(r100, r100, r110, r111);
    }

    public ValueRange(long r100, long r101, long r102, long r103) {
        this.minSmallest = r100;
        this.minLargest = r101;
        this.maxSmallest = r102;
        this.maxLargest = r103;
    }

    public static ValueRange of(long r110, long r111, long r112, long r113) {
        if (r110 > r111) goto L15;
        if (r112 > r113) goto L13;
        if (r111 > r113) goto L11;
        return new ValueRange(r110, r111, r112, r113);
    L11:
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    L13:
        throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
    L15:
        throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
    }
}
