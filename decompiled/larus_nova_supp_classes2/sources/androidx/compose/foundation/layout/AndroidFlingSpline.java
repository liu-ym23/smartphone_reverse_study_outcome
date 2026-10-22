package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline;", "", "<init>", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "flingPosition", "Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "time", "", "flingPosition-LfoxSSI", "(F)J", "deceleration", "", "velocity", "friction", "FlingResult", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidFlingSpline {
    public static final AndroidFlingSpline INSTANCE = null;
    private static final int NbSamples = 100;
    private static final float[] SplinePositions = null;
    private static final float[] SplineTimes = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "", "packedValue", "", "constructor-impl", "(J)J", "distanceCoefficient", "", "getDistanceCoefficient-impl", "(J)F", "velocityCoefficient", "getVelocityCoefficient-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class FlingResult {
        private final long packedValue;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ FlingResult m797boximpl(long r1) {
            return new FlingResult(r1);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m798constructorimpl(long r0) {
            return r0;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m799equalsimpl(long r4, Object r6) {
            if ((r6 instanceof FlingResult) == true) goto L6;
            return false;
        L6:
            if (r4 == ((FlingResult) r6).m805unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m800equalsimpl0(long r1, long r3) {
            if (r1 != r3) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m803hashCodeimpl(long r2) {
            return (int) (r2 ^ (r2 >>> 32));
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m804toStringimpl(long r2) {
            return "FlingResult(packedValue=" + r2 + ')';
        }

        public boolean equals(Object r3) {
            return m799equalsimpl(this.packedValue, r3);
        }

        public int hashCode() {
            return m803hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m804toStringimpl(this.packedValue);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m805unboximpl() {
            return this.packedValue;
        }

        private /* synthetic */ FlingResult(long r1) {
            this.packedValue = r1;
        }

        /* JADX INFO: renamed from: getDistanceCoefficient-impl, reason: not valid java name */
        public static final float m801getDistanceCoefficientimpl(long r1) {
            return Float.intBitsToFloat((int) (r1 >> 32));
        }

        /* JADX INFO: renamed from: getVelocityCoefficient-impl, reason: not valid java name */
        public static final float m802getVelocityCoefficientimpl(long r2) {
            return Float.intBitsToFloat((int) (r2 & 4294967295L));
        }
    }

    private AndroidFlingSpline() {
    }

    static {
        INSTANCE = new AndroidFlingSpline();
        SplinePositions = new float[101];
        SplineTimes = new float[101];
        float r0 = MenuKt.ClosedAlphaTarget;
        float r1 = MenuKt.ClosedAlphaTarget;
        int r2 = 0;
    L4:
        if (r2 >= 100) goto L21;
        float r5 = r2 / 100;
        float r3 = 1.0f;
    L6:
        float r6 = ((r3 - r0) / 2.0f) + r0;
        float r10 = 1.0f - r6;
        float r9 = (r6 * 3.0f) * r10;
        float r14 = (r6 * r6) * r6;
        float r12 = (((r10 * 0.175f) + (r6 * 0.35000002f)) * r9) + r14;
        if (Math.abs(r12 - r5) < 1.0E-5d) goto L12;
        if (r12 > r5) goto L10;
        r0 = r6;
        goto L6
    L10:
        r3 = r6;
        goto L6
    L12:
        float r7 = 0.5f;
        SplinePositions[r2] = (r9 * ((r10 * 0.5f) + r6)) + r14;
        float r4 = 1.0f;
    L13:
        float r8 = ((r4 - r1) / 2.0f) + r1;
        float r13 = 1.0f - r8;
        float r11 = (r8 * 3.0f) * r13;
        float r15 = (r8 * r8) * r8;
        float r16 = (((r13 * r7) + r8) * r11) + r15;
        if (Math.abs(r16 - r5) < 1.0E-5d) goto L20;
        if (r16 <= r5) goto L18;
        r4 = r8;
    L19:
        r7 = 0.5f;
        goto L13
    L18:
        r1 = r8;
        goto L19
    L20:
        SplineTimes[r2] = (r11 * ((r13 * 0.175f) + (r8 * 0.35000002f))) + r15;
        r2 = r2 + 1;
        goto L4
    L21:
        SplineTimes[100] = 1.0f;
        SplinePositions[100] = 1.0f;
    }

    /* JADX INFO: renamed from: flingPosition-LfoxSSI, reason: not valid java name */
    public final long m796flingPositionLfoxSSI(float r7) {
        float r1 = 100;
        int r2 = (int) (r1 * r7);
        if (r2 >= 100) goto L5;
        float r0 = r2 / r1;
        int r3 = r2 + 1;
        float r4 = r3 / r1;
        float[] r5 = SplinePositions;
        float r6 = r5[r2];
        float r8 = (r5[r3] - r6) / (r4 - r0);
        float r9 = r6 + ((r7 - r0) * r8);
    L6:
        long r10 = Float.floatToRawIntBits(r9);
        return FlingResult.m798constructorimpl((((long) Float.floatToRawIntBits(r8)) & 4294967295L) | (r10 << 32));
    L5:
        r9 = 1.0f;
        r8 = MenuKt.ClosedAlphaTarget;
        goto L6
    }

    public final double deceleration(float r3, float r4) {
        return Math.log(((double) (Math.abs(r3) * 0.35f)) / ((double) r4));
    }
}
