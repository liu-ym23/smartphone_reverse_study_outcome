package androidx.compose.animation.core;

import androidx.camera.video.AudioStats;
import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0007\u001a8\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0007\u001a0\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a(\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a0\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a@\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a9\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001aH\u0082\b\u001a\r\u0010\u001c\u001a\u00020\u001d*\u00020\tH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"MAX_LONG_MILLIS", "", "estimateAnimationDurationMillis", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "", "springConstant", "dampingCoefficient", "mass", "estimateUnderDamped", "firstRootReal", "firstRootImaginary", "p0", "v0", "estimateCriticallyDamped", "estimateOverDamped", "secondRootReal", "estimateDurationInternal", "initialPosition", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SpringEstimationKt {
    private static final long MAX_LONG_MILLIS = 9223372036854L;

    private static final boolean isNotFinite(double r4) {
        if ((Double.doubleToRawLongBits(r4) & Long.MAX_VALUE) >= 9218868437227405312L) goto L5;
        boolean r5 = true;
    L7:
        return !r5;
    L5:
        r5 = false;
        goto L7
    }

    private static final double iterateNewtonsMethod(double r2, Function1<? super Double, Double> r4, Function1<? super Double, Double> r5) {
        return r2 - (((Number) r4.invoke(Double.valueOf(r2))).doubleValue() / ((Number) r5.invoke(Double.valueOf(r2))).doubleValue());
    }

    private static final double estimateCriticallyDamped(double r21, double r23, double r25, double r27) {
        double r0 = r27;
        double r2 = r21 * r23;
        double r4 = r25 - r2;
        double r6 = Math.log(Math.abs(r0 / r23)) / r21;
        double r8 = Math.log(Math.abs(r0 / r4));
        int r10 = 0;
        double r12 = r8;
        int r11 = 0;
    L4:
        if (r11 >= 6) goto L6;
        r12 = r8 - Math.log(Math.abs(r12 / r21));
        r11 = r11 + 1;
        goto L4
    L6:
        double r13 = r12 / r21;
        if ((Double.doubleToRawLongBits(r6) & Long.MAX_VALUE) >= 9218868437227405312L) goto L9;
        boolean r9 = true;
    L11:
        if ((!r9) == false) goto L14;
        r6 = r13;
    L21:
        double r14 = (-(r2 + r4)) / (r21 * r4);
        double r15 = r21 * r14;
        double r16 = (Math.exp(r15) * r23) + ((r4 * r14) * Math.exp(r15));
        if (Double.isNaN(r14) == false) goto L24;
    L36:
        r0 = -r0;
    L37:
        double r17 = Double.MAX_VALUE;
    L39:
        if (r17 <= 0.001d) goto L43;
        if (r10 >= 100) goto L43;
        r10 = r10 + 1;
        double r18 = r21 * r6;
        double r19 = r6 - ((((r23 + (r4 * r6)) * Math.exp(r18)) + r0) / ((((((double) 1) + r18) * r4) + r2) * Math.exp(r18)));
        double r7 = Math.abs(r6 - r19);
        r6 = r19;
        r17 = r7;
    L43:
        return r6;
    L24:
        if (r14 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
        if (r14 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
    L35:
        r6 = (-(2.0d / r21)) - (r23 / r4);
        goto L37
    L29:
        if ((-r16) >= r0) goto L35;
        if (r4 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
        if (r23 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
        r6 = 0.0d;
        goto L36
    L14:
        if ((Double.doubleToRawLongBits(r13) & Long.MAX_VALUE) >= 9218868437227405312L) goto L16;
        boolean r20 = true;
    L18:
        if ((!r20) == true) goto L21;
        r6 = Math.max(r6, r13);
        goto L21
    L16:
        r20 = false;
        goto L18
    L9:
        r9 = false;
        goto L11
    }

    public static final long estimateAnimationDurationMillis(double r16, double r18, double r20, double r22, double r24) {
        double r0 = (2.0d * r18) * Math.sqrt(r16);
        double r2 = (r0 * r0) - (4.0d * r16);
        double r4 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r2 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r7 = 0.0d;
    L6:
        if (r2 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        r4 = Math.sqrt(Math.abs(r2));
    L8:
        double r1 = -r0;
        return estimateDurationInternal((r1 + r7) * 0.5d, r4 * 0.5d, (r1 - r7) * 0.5d, r18, r20, r22, r24);
    L5:
        r7 = Math.sqrt(r2);
        goto L6
    }

    private static final double estimateOverDamped(double r25, double r27, double r29, double r31, double r33) {
        double r12 = r25 - r27;
        double r14 = ((r25 * r29) - r31) / r12;
        double r16 = r29 - r14;
        double r0 = Math.log(Math.abs(r33 / r16)) / r25;
        double r2 = Math.log(Math.abs(r33 / r14)) / r27;
        if ((Double.doubleToRawLongBits(r0) & Long.MAX_VALUE) >= 9218868437227405312L) goto L5;
        boolean r4 = true;
    L7:
        if ((!r4) == false) goto L10;
        double r19 = r2;
    L18:
        double r21 = r16 * r25;
        double r5 = Math.log(r21 / ((-r14) * r27)) / (r27 - r25);
        if (Double.isNaN(r5) == false) goto L21;
    L33:
        double r1 = -r33;
    L34:
        double r6 = r14 * r27;
        if (Math.abs((Math.exp(r25 * r19) * r21) + (Math.exp(r27 * r19) * r6)) >= 1.0E-4d) goto L37;
        return r19;
    L37:
        double r3 = Double.MAX_VALUE;
        int r7 = 0;
    L39:
        if (r3 <= 0.001d) goto L43;
        if (r7 >= 100) goto L43;
        r7 = r7 + 1;
        double r8 = r25 * r19;
        double r9 = r27 * r19;
        double r10 = r19 - ((((Math.exp(r8) * r16) + (Math.exp(r9) * r14)) + r1) / ((Math.exp(r8) * r21) + (Math.exp(r9) * r6)));
        double r11 = Math.abs(r19 - r10);
        r19 = r10;
        r3 = r11;
    L43:
        return r19;
    L21:
        if (r5 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        if (r5 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L26;
    L32:
        r19 = Math.log((-((r14 * r27) * r27)) / (r21 * r25)) / r12;
        r1 = r33;
        goto L34
    L26:
        if ((-estimateOverDamped$xInflection(r16, r25, r5, r14, r27)) >= r33) goto L32;
        if (r14 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        if (r16 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        r19 = 0.0d;
        goto L33
    L10:
        if ((Double.doubleToRawLongBits(r2) & Long.MAX_VALUE) >= 9218868437227405312L) goto L12;
        boolean r13 = true;
    L14:
        if ((!r13) == true) goto L17;
        r0 = Math.max(r0, r2);
    L17:
        r19 = r0;
        goto L18
    L12:
        r13 = false;
        goto L14
    L5:
        r4 = false;
        goto L7
    }

    private static final double estimateOverDamped$xInflection(double r0, double r2, double r4, double r6, double r8) {
        return (r0 * Math.exp(r2 * r4)) + (r6 * Math.exp(r8 * r4));
    }

    private static final double estimateUnderDamped(double r2, double r4, double r6, double r8, double r10) {
        double r9 = (r8 - (r2 * r6)) / r4;
        return Math.log(r10 / Math.sqrt((r6 * r6) + (r9 * r9))) / r2;
    }

    public static final long estimateAnimationDurationMillis(float r10, float r11, float r12, float r13, float r14) {
        if (r11 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return MAX_LONG_MILLIS;
    L10:
        return estimateAnimationDurationMillis(r10, r11, r12, r13, r14);
    L5:
        r0 = false;
        goto L6
    }

    public static final long estimateAnimationDurationMillis(double r20, double r22, double r24, double r26, double r28, double r30) {
        double r12 = r22 / (Math.sqrt(r20 * r24) * 2.0d);
        double r2 = (r22 * r22) - ((4.0d * r24) * r20);
        double r6 = 1.0d / (2.0d * r24);
        double r4 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r2 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        double r9 = 0.0d;
    L6:
        if (r2 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        r4 = Math.sqrt(Math.abs(r2));
    L8:
        double r0 = -r22;
        return estimateDurationInternal((r0 + r9) * r6, r4 * r6, (r0 - r9) * r6, r12, r26, r28, r30);
    L5:
        r9 = Math.sqrt(r2);
        goto L6
    }

    private static final long estimateDurationInternal(double r12, double r14, double r16, double r18, double r20, double r22, double r24) {
        double r0 = r20;
        boolean r2 = true;
        if (r22 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == true) goto L8;
    L14:
        if (r22 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
        r0 = -r0;
    L16:
        double r6 = Math.abs(r22);
        if (r18 <= 1.0d) goto L20;
        double r1 = estimateOverDamped(r12, r16, r6, r0, r24);
    L24:
        return (long) (r1 * 1000.0d);
    L20:
        if (r18 >= 1.0d) goto L22;
        r1 = estimateUnderDamped(r12, r14, r6, r0, r24);
        goto L24
    L22:
        r1 = estimateCriticallyDamped(r12, r6, r0, r24);
        goto L24
    L8:
        if (r0 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        r2 = false;
    L11:
        if (r2 == false) goto L14;
        return 0;
    L5:
        r7 = false;
        goto L6
    }
}
