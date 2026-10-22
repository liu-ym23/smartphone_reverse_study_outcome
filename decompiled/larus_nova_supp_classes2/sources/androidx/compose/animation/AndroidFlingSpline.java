package androidx.compose.animation;

import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/AndroidFlingSpline;", "", "<init>", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "flingPosition", "Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "time", "", "deceleration", "", "velocity", "friction", "FlingResult", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidFlingSpline {
    public static final int $stable = 0;
    public static final AndroidFlingSpline INSTANCE = null;
    private static final int NbSamples = 100;
    private static final float[] SplinePositions = null;
    private static final float[] SplineTimes = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "", "distanceCoefficient", "", "velocityCoefficient", "<init>", "(FF)V", "getDistanceCoefficient", "()F", "getVelocityCoefficient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FlingResult {
        public static final int $stable = 0;
        private final float distanceCoefficient;
        private final float velocityCoefficient;

        public static /* synthetic */ FlingResult copy$default(FlingResult r0, float r1, float r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.distanceCoefficient;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.velocityCoefficient;
        L9:
            return r0.copy(r1, r2);
        }

        public final float component1() {
            return this.distanceCoefficient;
        }

        public final float component2() {
            return this.velocityCoefficient;
        }

        public final FlingResult copy(float r2, float r3) {
            return new FlingResult(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof FlingResult) == true) goto L8;
            return false;
        L8:
            FlingResult r6 = (FlingResult) r5;
            if (Float.compare(this.distanceCoefficient, r6.distanceCoefficient) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.velocityCoefficient, r6.velocityCoefficient) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.distanceCoefficient) * 31) + Float.floatToIntBits(this.velocityCoefficient);
        }

        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.distanceCoefficient + ", velocityCoefficient=" + this.velocityCoefficient + ')';
        }

        public final float getDistanceCoefficient() {
            return this.distanceCoefficient;
        }

        public final float getVelocityCoefficient() {
            return this.velocityCoefficient;
        }

        public FlingResult(float r1, float r2) {
            this.distanceCoefficient = r1;
            this.velocityCoefficient = r2;
        }
    }

    private AndroidFlingSpline() {
    }

    static {
        INSTANCE = new AndroidFlingSpline();
        float[] r1 = new float[101];
        SplinePositions = r1;
        float[] r0 = new float[101];
        SplineTimes = r0;
        SplineBasedDecayKt.access$computeSplineInfo(r1, r0, 100);
        $stable = 8;
    }

    public final FlingResult flingPosition(float r6) {
        float r0 = MenuKt.ClosedAlphaTarget;
        float r1 = 1.0f;
        float r7 = RangesKt.coerceIn(r6, MenuKt.ClosedAlphaTarget, 1.0f);
        float r3 = 100;
        int r4 = (int) (r3 * r7);
        if (r4 >= 100) goto L6;
        float r2 = r4 / r3;
        int r5 = r4 + 1;
        float r8 = r5 / r3;
        float[] r9 = SplinePositions;
        float r10 = r9[r4];
        float r11 = (r9[r5] - r10) / (r8 - r2);
        float r12 = ((r7 - r2) * r11) + r10;
        r0 = r11;
        r1 = r12;
    L6:
        return new FlingResult(r1, r0);
    }

    public final double deceleration(float r3, float r4) {
        return Math.log(((double) (Math.abs(r3) * 0.35f)) / ((double) r4));
    }
}
