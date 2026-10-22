package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0011\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0082\bJ \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J(\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/animation/core/FloatTweenSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "duration", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "<init>", "(IILandroidx/compose/animation/core/Easing;)V", "getDuration", "()I", "getDelay", "durationNanos", "", "delayNanos", "getValueFromNanos", "", "playTimeNanos", "initialValue", "targetValue", "initialVelocity", "clampPlayTimeNanos", "getDurationNanos", "getVelocityFromNanos", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatTweenSpec implements FloatAnimationSpec {
    public static final int $stable = 0;
    private final int delay;
    private final long delayNanos;
    private final int duration;
    private final long durationNanos;
    private final Easing easing;

    public FloatTweenSpec() {
        this(0, 0, null, 7, null);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final /* synthetic */ float getEndVelocity(float r1, float r2, float r3) {
        return FloatAnimationSpec.CC.$default$getEndVelocity(this, r1, r2, r3);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter r1) {
        return FloatAnimationSpec.CC.$default$vectorize(this, r1);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final /* synthetic */ VectorizedFloatAnimationSpec vectorize(TwoWayConverter r1) {
        return FloatAnimationSpec.CC.m263$default$vectorize(this, r1);
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDuration() {
        return this.duration;
    }

    private final long clampPlayTimeNanos(long r6) {
        long r7 = r6 - this.delayNanos;
        long r0 = this.durationNanos;
        if (r7 >= 0) goto L6;
        r7 = 0;
    L6:
        if (r7 <= r0) goto L9;
        return r0;
    L9:
        return r7;
    }

    public FloatTweenSpec(int r5, int r6, Easing r7) {
        this.duration = r5;
        this.delay = r6;
        this.easing = r7;
        this.durationNanos = ((long) r5) * AnimationKt.MillisToNanos;
        this.delayNanos = ((long) r6) * AnimationKt.MillisToNanos;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float r3, float r4, float r5) {
        return this.delayNanos + this.durationNanos;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long r5, float r7, float r8, float r9) {
        long r6 = r5 - this.delayNanos;
        long r0 = this.durationNanos;
        if (r6 >= 0) goto L6;
        r6 = 0;
    L6:
        if (r6 <= r0) goto L9;
        r6 = r0;
    L9:
        if (this.duration != 0) goto L11;
        float r10 = 1.0f;
    L12:
        float r11 = this.easing.transform(r10);
        return (r7 * (1 - r11)) + (r8 * r11);
    L11:
        r10 = r6 / r0;
        goto L12
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long r10, float r12, float r13, float r14) {
        long r0 = r10 - this.delayNanos;
        long r2 = this.durationNanos;
        if (r0 >= 0) goto L6;
        r0 = 0;
    L6:
        if (r0 <= r2) goto L8;
        long r6 = r2;
    L10:
        if (r6 != 0) goto L13;
        return r14;
    L13:
        return (getValueFromNanos(r6, r12, r13, r14) - getValueFromNanos(r6 - AnimationKt.MillisToNanos, r12, r13, r14)) * 1000.0f;
    L8:
        r6 = r0;
        goto L10
    }

    public /* synthetic */ FloatTweenSpec(int r1, int r2, Easing r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 300;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = EasingKt.getFastOutSlowInEasing();
    L11:
        this(r1, r2, r3);
    }
}
