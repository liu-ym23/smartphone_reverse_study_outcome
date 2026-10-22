package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/core/FloatExponentialDecaySpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "frictionMultiplier", "", "absVelocityThreshold", "<init>", "(FF)V", "getAbsVelocityThreshold", "()F", "friction", "getValueFromNanos", "playTimeNanos", "", "initialValue", "initialVelocity", "getVelocityFromNanos", "getDurationNanos", "getTargetValue", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatExponentialDecaySpec implements FloatDecayAnimationSpec {
    public static final int $stable = 0;
    private final float absVelocityThreshold;
    private final float friction;

    public FloatExponentialDecaySpec() {
        float r2 = MenuKt.ClosedAlphaTarget;
        this(r2, r2, 3, null);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public FloatExponentialDecaySpec(float r2, float r3) {
        this.absVelocityThreshold = Math.max(1.0E-7f, Math.abs(r3));
        this.friction = Math.max(1.0E-4f, r2) * (-4.2f);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float r3, float r4) {
        return ((long) ((((float) Math.log(getAbsVelocityThreshold() / Math.abs(r4))) * 1000.0f) / this.friction)) * AnimationKt.MillisToNanos;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float r6, float r7) {
        if (Math.abs(r7) > getAbsVelocityThreshold()) goto L5;
        return r6;
    L5:
        double r0 = Math.log(Math.abs(getAbsVelocityThreshold() / r7));
        float r2 = this.friction;
        return (r6 - (r7 / r2)) + ((r7 / r2) * ((float) Math.exp((((double) r2) * ((r0 / ((double) r2)) * ((double) 1000))) / ((double) 1000.0f))));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(long r3, float r5, float r6) {
        long r4 = r3 / AnimationKt.MillisToNanos;
        float r0 = this.friction;
        return (r5 - (r6 / r0)) + ((r6 / r0) * ((float) Math.exp((r0 * r4) / 1000.0f)));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(long r3, float r5, float r6) {
        return r6 * ((float) Math.exp(((r3 / AnimationKt.MillisToNanos) / 1000.0f) * this.friction));
    }

    public /* synthetic */ FloatExponentialDecaySpec(float r1, float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 1.0f;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0.1f;
    L8:
        this(r1, r2);
    }
}
