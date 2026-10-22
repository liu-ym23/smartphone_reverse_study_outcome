package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0001\u0010\u000e*\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Landroidx/compose/animation/core/StartDelayAnimationSpec;", "T", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "startDelayNanos", "", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;J)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getStartDelayNanos", "()J", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "hashCode", "", "equals", "", "other", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StartDelayAnimationSpec<T> implements AnimationSpec<T> {
    private final AnimationSpec<T> animationSpec;
    private final long startDelayNanos;

    public int hashCode() {
        int r0 = this.animationSpec.hashCode() * 31;
        long r1 = this.startDelayNanos;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final AnimationSpec<T> getAnimationSpec() {
        return this.animationSpec;
    }

    public final long getStartDelayNanos() {
        return this.startDelayNanos;
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof StartDelayAnimationSpec) == true) goto L5;
        return false;
    L5:
        StartDelayAnimationSpec r8 = (StartDelayAnimationSpec) r7;
        if (r8.startDelayNanos == this.startDelayNanos) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r8.animationSpec, this.animationSpec) == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public <V extends AnimationVector> VectorizedAnimationSpec<V> vectorize(TwoWayConverter<T, V> r4) {
        return new StartDelayVectorizedAnimationSpec(this.animationSpec.vectorize(r4), this.startDelayNanos);
    }

    public StartDelayAnimationSpec(AnimationSpec<T> r1, long r2) {
        this.animationSpec = r1;
        this.startDelayNanos = r2;
    }
}
