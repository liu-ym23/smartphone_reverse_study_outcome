package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u0005R$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0005¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "<init>", "(F)V", "getFinalPosition", "()F", "setFinalPosition", "naturalFreq", "", "value", "stiffness", "getStiffness", "setStiffness", "dampingRatio", "getDampingRatio", "setDampingRatio", "getAcceleration", "lastDisplacement", "lastVelocity", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core", "(FFJ)J", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SpringSimulation {
    public static final int $stable = 8;
    private float dampingRatio;
    private float finalPosition;
    private double naturalFreq;

    public final float getStiffness() {
        double r0 = this.naturalFreq;
        return (float) (r0 * r0);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public SpringSimulation(float r3) {
        this.finalPosition = r3;
        this.naturalFreq = Math.sqrt(50.0d);
        this.dampingRatio = 1.0f;
    }

    public final void setDampingRatio(float r2) {
        if (r2 >= MenuKt.ClosedAlphaTarget) goto L5;
        PreconditionsKt.throwIllegalArgumentException("Damping ratio must be non-negative");
    L5:
        this.dampingRatio = r2;
    }

    public final void setFinalPosition(float r1) {
        this.finalPosition = r1;
    }

    public final void setStiffness(float r3) {
        if (getStiffness() > MenuKt.ClosedAlphaTarget) goto L5;
        PreconditionsKt.throwIllegalArgumentException("Spring stiffness constant must be positive.");
    L5:
        this.naturalFreq = Math.sqrt(r3);
    }

    public final float getAcceleration(float r7, float r8) {
        float r9 = r7 - this.finalPosition;
        double r0 = this.naturalFreq;
        double r2 = r0 * r0;
        double r1 = (r0 * 2.0d) * ((double) this.dampingRatio);
        return (float) (((-r2) * ((double) r9)) - (r1 * ((double) r8)));
    }

    /* JADX INFO: renamed from: updateValues-IJZedt4$animation_core, reason: not valid java name */
    public final long m278updateValuesIJZedt4$animation_core(float r21, float r22, long r23) {
        float r2 = r21 - this.finalPosition;
        double r3 = r23 / 1000.0d;
        float r5 = this.dampingRatio;
        double r6 = ((double) r5) * ((double) r5);
        double r10 = this.naturalFreq;
        double r8 = ((double) (-r5)) * r10;
        if (r5 <= 1.0f) goto L6;
        double r11 = r10 * Math.sqrt(r6 - ((double) 1));
        double r7 = r8 + r11;
        double r9 = r8 - r11;
        double r12 = r2;
        double r13 = ((r9 * r12) - ((double) r22)) / (r9 - r7);
        double r14 = r12 - r13;
        double r1 = r9 * r3;
        double r4 = r3 * r7;
        double r15 = (Math.exp(r1) * r14) + (Math.exp(r4) * r13);
        double r16 = ((r14 * r9) * Math.exp(r1)) + ((r13 * r7) * Math.exp(r4));
    L12:
        long r17 = Float.floatToRawIntBits((float) (r15 + ((double) this.finalPosition)));
        return Motion.m269constructorimpl((((long) Float.floatToRawIntBits((float) r16)) & 4294967295L) | (r17 << 32));
    L6:
        if (r5 != 1.0f) goto L8;
        boolean r18 = true;
    L9:
        if (r18 == false) goto L11;
        double r19 = r2;
        double r20 = ((double) r22) + (r10 * r19);
        double r24 = (-r10) * r3;
        double r25 = r19 + (r3 * r20);
        r15 = r25 * Math.exp(r24);
        r16 = ((r25 * Math.exp(r24)) * (-this.naturalFreq)) + (r20 * Math.exp(r24));
        goto L12
    L11:
        double r110 = 1;
        double r111 = r10 * Math.sqrt(r110 - r6);
        double r112 = r2;
        double r113 = (r110 / r111) * (((-r8) * r112) + ((double) r22));
        double r26 = r111 * r3;
        double r27 = r3 * r8;
        double r28 = Math.exp(r27) * ((Math.cos(r26) * r112) + (Math.sin(r26) * r113));
        r16 = (r8 * r28) + (Math.exp(r27) * ((((-r111) * r112) * Math.sin(r26)) + ((r111 * r113) * Math.cos(r26))));
        r15 = r28;
        goto L12
    L8:
        r18 = false;
        goto L9
    }
}
