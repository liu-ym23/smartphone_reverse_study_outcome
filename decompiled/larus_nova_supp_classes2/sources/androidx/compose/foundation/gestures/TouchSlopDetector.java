package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\n\u001a\u00020\u000b*\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u000b*\u00020\u0005¢\u0006\u0004\b\u000f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "initialPositionChange", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "crossAxis", "crossAxis-k-4lQ0M", "totalPositionChange", "J", "addPointerInputChange", "dragEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "touchSlop", "addPointerInputChange-dBAh8RU", "(Landroidx/compose/ui/input/pointer/PointerInputChange;F)J", "reset", "", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TouchSlopDetector {
    public static final int $stable = 8;
    private final Orientation orientation;
    private long totalPositionChange;

    public /* synthetic */ TouchSlopDetector(Orientation r1, long r2, DefaultConstructorMarker r4) {
        this(r1, r2);
    }

    public final void reset() {
        this.totalPositionChange = Offset.Companion.getZero-F1C5BW0();
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* JADX INFO: renamed from: calculatePostSlopOffset-tuRUvjQ, reason: not valid java name */
    private final long m715calculatePostSlopOffsettuRUvjQ(float r9) {
        if (this.orientation != null) goto L5;
        long r0 = this.totalPositionChange;
        return Offset.minus-MK-Hz9U(this.totalPositionChange, Offset.times-tuRUvjQ(Offset.div-tuRUvjQ(r0, Offset.getDistance-impl(r0)), r9));
    L5:
        float r1 = m718mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m718mainAxisk4lQ0M(this.totalPositionChange)) * r9);
        float r10 = m717crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation != Orientation.Horizontal) goto L9;
        return Offset.constructor-impl((Float.floatToRawIntBits(r1) << 32) | (((long) Float.floatToRawIntBits(r10)) & 4294967295L));
    L9:
        return Offset.constructor-impl((Float.floatToRawIntBits(r10) << 32) | (Float.floatToRawIntBits(r1) & 4294967295L));
    }

    /* JADX INFO: renamed from: crossAxis-k-4lQ0M, reason: not valid java name */
    public final float m717crossAxisk4lQ0M(long r3) {
        if (this.orientation != Orientation.Horizontal) goto L5;
        long r4 = r3 & 4294967295L;
    L7:
        return Float.intBitsToFloat((int) r4);
    L5:
        r4 = r3 >> 32;
        goto L7
    }

    /* JADX INFO: renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public final float m718mainAxisk4lQ0M(long r3) {
        if (this.orientation != Orientation.Horizontal) goto L5;
        long r4 = r3 >> 32;
    L7:
        return Float.intBitsToFloat((int) r4);
    L5:
        r4 = r3 & 4294967295L;
        goto L7
    }

    private TouchSlopDetector(Orientation r1, long r2) {
        this.orientation = r1;
        this.totalPositionChange = r2;
    }

    /* JADX INFO: renamed from: addPointerInputChange-dBAh8RU, reason: not valid java name */
    public final long m716addPointerInputChangedBAh8RU(PointerInputChange r5, float r6) {
        long r0 = Offset.minus-MK-Hz9U(r5.getPosition-F1C5BW0(), r5.getPreviousPosition-F1C5BW0());
        long r1 = Offset.plus-MK-Hz9U(this.totalPositionChange, r0);
        this.totalPositionChange = r1;
        if (this.orientation != null) goto L5;
        float r7 = Offset.getDistance-impl(r1);
    L7:
        if (r7 < r6) goto L9;
        boolean r8 = true;
    L10:
        if (r8 == false) goto L13;
        return m715calculatePostSlopOffsettuRUvjQ(r6);
    L13:
        return Offset.Companion.getUnspecified-F1C5BW0();
    L9:
        r8 = false;
        goto L10
    L5:
        r7 = Math.abs(m718mainAxisk4lQ0M(r1));
        goto L7
    }

    public /* synthetic */ TouchSlopDetector(Orientation r2, long r3, int r5, DefaultConstructorMarker r6) {
        DefaultConstructorMarker r0 = null;
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = Offset.Companion.getZero-F1C5BW0();
    L8:
        this(r2, r3, r0);
    }
}
