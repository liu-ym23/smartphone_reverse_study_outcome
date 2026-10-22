package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/FloatSpringSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "<init>", "(FFF)V", "getDampingRatio", "()F", "getStiffness", "spring", "Landroidx/compose/animation/core/SpringSimulation;", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "getVelocityFromNanos", "getEndVelocity", "getDurationNanos", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatSpringSpec implements FloatAnimationSpec {
    public static final int $stable = 8;
    private final float dampingRatio;
    private final SpringSimulation spring;
    private final float stiffness;
    private final float visibilityThreshold;

    public FloatSpringSpec() {
        this(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 7, null);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getEndVelocity(float r1, float r2, float r3) {
        return MenuKt.ClosedAlphaTarget;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter r1) {
        return FloatAnimationSpec.CC.$default$vectorize(this, r1);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final /* synthetic */ VectorizedFloatAnimationSpec vectorize(TwoWayConverter r1) {
        return FloatAnimationSpec.CC.m263$default$vectorize(this, r1);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    public FloatSpringSpec(float r2, float r3, float r4) {
        this.dampingRatio = r2;
        this.stiffness = r3;
        this.visibilityThreshold = r4;
        SpringSimulation r5 = new SpringSimulation(1.0f);
        r5.setDampingRatio(r2);
        r5.setStiffness(r3);
        this.spring = r5;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float r3, float r4, float r5) {
        float r0 = this.spring.getStiffness();
        float r1 = this.spring.getDampingRatio();
        float r6 = r3 - r4;
        float r7 = this.visibilityThreshold;
        float r8 = r5 / r7;
        return SpringEstimationKt.estimateAnimationDurationMillis(r0, r1, r8, r6 / r7, 1.0f) * AnimationKt.MillisToNanos;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long r3, float r5, float r6, float r7) {
        long r4 = r3 / AnimationKt.MillisToNanos;
        this.spring.setFinalPosition(r6);
        return Float.intBitsToFloat((int) (this.spring.m278updateValuesIJZedt4$animation_core(r5, r7, r4) >> 32));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long r3, float r5, float r6, float r7) {
        long r4 = r3 / AnimationKt.MillisToNanos;
        this.spring.setFinalPosition(r6);
        return Float.intBitsToFloat((int) (this.spring.m278updateValuesIJZedt4$animation_core(r5, r7, r4) & 4294967295L));
    }

    public /* synthetic */ FloatSpringSpec(float r1, float r2, float r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 1.0f;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 1500.0f;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = 0.01f;
    L11:
        this(r1, r2, r3);
    }
}
