package kotlin.ranges;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/OpenEndDoubleRange;", "Lkotlin/ranges/OpenEndRange;", "", "start", "endExclusive", "(DD)V", "_endExclusive", "_start", "getEndExclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class OpenEndDoubleRange implements OpenEndRange<Double> {
    private final double _endExclusive;
    private final double _start;

    private final boolean lessThanOrEquals(double r100, double r101) {
        if (r100 > r101) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.OpenEndRange
    public Double getEndExclusive() {
        return Double.valueOf(this._endExclusive);
    }

    @Override // kotlin.ranges.OpenEndRange
    public Double getStart() {
        return Double.valueOf(this._start);
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        if (this._start < this._endExclusive) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        long r100 = Double.doubleToLongBits(this._start);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this._endExclusive);
        return ((int) (r102 ^ (r102 >>> 32))) + r101;
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return getEndExclusive();
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return getStart();
    }

    public boolean contains(double r100) {
        if (r100 >= this._start) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= this._endExclusive) goto L7;
        return true;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof OpenEndDoubleRange) == true) goto L5;
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        OpenEndDoubleRange r101 = (OpenEndDoubleRange) r100;
        if (this._start != r101._start) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L14;
        return false;
    L14:
        if (this._endExclusive != r101._endExclusive) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L22;
    L18:
        return true;
    L22:
        return false;
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
        goto L12
    L7:
        if (((OpenEndDoubleRange) r100).isEmpty() == true) goto L18;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r100) {
        return contains(((Number) r100).doubleValue());
    }

    public OpenEndDoubleRange(double r100, double r101) {
        this._start = r100;
        this._endExclusive = r101;
    }
}
