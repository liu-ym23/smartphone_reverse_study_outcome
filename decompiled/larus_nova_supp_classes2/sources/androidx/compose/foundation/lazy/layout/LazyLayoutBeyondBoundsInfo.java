package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "", "<init>", "()V", "beyondBoundsItems", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "addInterval", "start", "", "end", "removeInterval", "", "interval", "hasIntervals", "", "getStart", "()I", "getEnd", "Interval", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutBeyondBoundsInfo {
    public static final int $stable = 0;
    private final MutableVector<Interval> beyondBoundsItems;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "", "start", "", "end", "<init>", "(II)V", "getStart", "()I", "getEnd", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Interval {
        public static final int $stable = 0;
        private final int end;
        private final int start;

        public static /* synthetic */ Interval copy$default(Interval r0, int r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.start;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.end;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final Interval copy(int r2, int r3) {
            return new Interval(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Interval) == true) goto L8;
            return false;
        L8:
            Interval r6 = (Interval) r5;
            if (this.start == r6.start) goto L12;
            return false;
        L12:
            if (this.end == r6.end) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.start * 31) + this.end;
        }

        public String toString() {
            return "Interval(start=" + this.start + ", end=" + this.end + ')';
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public Interval(int r4, int r5) {
            this.start = r4;
            this.end = r5;
            boolean r0 = true;
            if (r4 < 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("negative start index");
        L8:
            if (r5 >= r4) goto L11;
            r0 = false;
        L11:
            if (r0 == true) goto L14;
            InlineClassHelperKt.throwIllegalArgumentException("end index greater than start");
            return;
        L14:
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    static {
        $stable = MutableVector.$stable;
    }

    public final int getEnd() {
        int r0 = ((Interval) this.beyondBoundsItems.first()).getEnd();
        MutableVector<Interval> r1 = this.beyondBoundsItems;
        Object[] r2 = r1.content;
        int r3 = r1.getSize();
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        Interval r5 = (Interval) r2[r4];
        if (r5.getEnd() <= r0) goto L7;
        r0 = r5.getEnd();
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r0;
    }

    public final int getStart() {
        int r0 = ((Interval) this.beyondBoundsItems.first()).getStart();
        MutableVector<Interval> r1 = this.beyondBoundsItems;
        Object[] r2 = r1.content;
        int r3 = r1.getSize();
        boolean r4 = false;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L8;
        Interval r6 = (Interval) r2[r5];
        if (r6.getStart() >= r0) goto L7;
        r0 = r6.getStart();
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        if (r0 < 0) goto L10;
        r4 = true;
    L10:
        if (r4 == true) goto L12;
        InlineClassHelperKt.throwIllegalArgumentException("negative minIndex");
    L12:
        return r0;
    }

    public final boolean hasIntervals() {
        if (this.beyondBoundsItems.getSize() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public LazyLayoutBeyondBoundsInfo() {
        this.beyondBoundsItems = new MutableVector(new Interval[16], 0);
    }

    public final void removeInterval(Interval r2) {
        this.beyondBoundsItems.remove(r2);
    }

    public final Interval addInterval(int r2, int r3) {
        Interval r0 = new Interval(r2, r3);
        this.beyondBoundsItems.add(r0);
        return r0;
    }
}
