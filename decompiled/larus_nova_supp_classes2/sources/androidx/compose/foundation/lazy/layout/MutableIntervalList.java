package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J2\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\u000f0\u0015H\u0016J\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0017\u001a\u00020\tH\u0096\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0011\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tH\u0082\bJ\u001a\u0010\u001b\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0017\u001a\u00020\tH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "T", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "<init>", "()V", "intervals", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "value", "", "size", "getSize", "()I", "lastInterval", "addInterval", "", "(ILjava/lang/Object;)V", "forEach", "fromIndex", "toIndex", "block", "Lkotlin/Function1;", "get", "index", "getIntervalForIndex", "itemIndex", "checkIndexBounds", "contains", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableIntervalList<T> implements IntervalList<T> {
    public static final int $stable = 8;
    private final MutableVector<IntervalList.Interval<T>> intervals;
    private IntervalList.Interval<? extends T> lastInterval;
    private int size;

    public MutableIntervalList() {
        this.intervals = new MutableVector(new IntervalList.Interval[16], 0);
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public int getSize() {
        return this.size;
    }

    private final void checkIndexBounds(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L10;
        InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + r3 + ", size " + getSize());
        return;
    L10:
        return;
    L5:
        if (r3 >= getSize()) goto L7;
        r0 = true;
        goto L7
    }

    private final IntervalList.Interval<T> getIntervalForIndex(int r3) {
        IntervalList.Interval<? extends T> r0 = this.lastInterval;
        if (r0 != null) goto L5;
    L7:
        MutableVector<IntervalList.Interval<T>> r1 = this.intervals;
        int r4 = IntervalListKt.access$binarySearch(r1, r3);
        IntervalList.Interval r2 = (IntervalList.Interval<? extends T>) ((IntervalList.Interval) r1.content[r4]);
        this.lastInterval = r2;
        return r2;
    L5:
        if (contains(r0, r3) == false) goto L7;
        return r0;
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public IntervalList.Interval<T> get(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L10;
        InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + r3 + ", size " + getSize());
    L10:
        return getIntervalForIndex(r3);
    L5:
        if (r3 >= getSize()) goto L7;
        r0 = true;
        goto L7
    }

    private final boolean contains(IntervalList.Interval<? extends T> r3, int r4) {
        int r0 = r3.getStartIndex();
        if (r4 >= (r3.getStartIndex() + r3.getSize())) goto L7;
        if (r0 > r4) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    public final void addInterval(int r3, T r4) {
        if (r3 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == true) goto L7;
        InlineClassHelperKt.throwIllegalArgumentException("size should be >=0");
    L7:
        if (r3 != 0) goto L9;
        return;
    L9:
        IntervalList.Interval r1 = new IntervalList.Interval(getSize(), r3, r4);
        this.size = getSize() + r3;
        this.intervals.add(r1);
        return;
    L4:
        r0 = false;
        goto L5
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public void forEach(int r7, int r8, Function1<? super IntervalList.Interval<? extends T>, Unit> r9) {
        boolean r1 = false;
        if (r7 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == true) goto L11;
        InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + r7 + ", size " + getSize());
    L11:
        if (r8 >= 0) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L18;
        InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + r8 + ", size " + getSize());
    L18:
        if (r8 < r7) goto L20;
        r1 = true;
    L20:
        if (r1 == true) goto L22;
        InlineClassHelperKt.throwIllegalArgumentException("toIndex (" + r8 + ") should be not smaller than fromIndex (" + r7 + ')');
    L22:
        int r10 = IntervalListKt.access$binarySearch(this.intervals, r7);
        int r4 = ((IntervalList.Interval) this.intervals.content[r10]).getStartIndex();
    L23:
        if (r4 > r8) goto L25;
        IntervalList.Interval r5 = (IntervalList.Interval) this.intervals.content[r10];
        r9.invoke(r5);
        r4 = r4 + r5.getSize();
        r10 = r10 + 1;
        goto L23
    L25:
        return;
    L13:
        if (r8 >= getSize()) goto L15;
        r3 = true;
        goto L16
    L5:
        if (r7 >= getSize()) goto L7;
        r2 = true;
        goto L9
    }
}
