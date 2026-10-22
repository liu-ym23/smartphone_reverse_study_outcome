package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ-\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J%\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000e\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "anims", "Landroidx/compose/animation/core/Animations;", "<init>", "(Landroidx/compose/animation/core/Animations;)V", "anim", "Landroidx/compose/animation/core/FloatAnimationSpec;", "(Landroidx/compose/animation/core/FloatAnimationSpec;)V", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "endVelocityVector", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorizedFloatAnimationSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    private final Animations anims;
    private V endVelocityVector;
    private V valueVector;
    private V velocityVector;

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    public VectorizedFloatAnimationSpec(final FloatAnimationSpec r2) {
        this(new AnonymousClass1(r2));
    }

    public VectorizedFloatAnimationSpec(Animations r1) {
        this.anims = r1;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(V r9, V r10, V r11) {
        int r0 = r9.getSize$animation_core();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = Math.max(r1, this.anims.get(r3).getDurationNanos(r9.get$animation_core(r3), r10.get$animation_core(r3), r11.get$animation_core(r3)));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getEndVelocity(V r10, V r11, V r12) {
        if (this.endVelocityVector != null) goto L5;
        this.endVelocityVector = (V) AnimationVectorsKt.newInstance(r12);
    L5:
        V r0 = this.endVelocityVector;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        r0 = null;
    L8:
        int r1 = r0.getSize$animation_core();
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L14;
        V r4 = this.endVelocityVector;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        r4 = null;
    L13:
        r4.set$animation_core(r3, this.anims.get(r3).getEndVelocity(r10.get$animation_core(r3), r11.get$animation_core(r3), r12.get$animation_core(r3)));
        r3 = r3 + 1;
        goto L9
    L14:
        V r13 = this.endVelocityVector;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        return null;
    L18:
        return r13;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long r16, V r18, V r19, V r20) {
        if (this.valueVector != null) goto L5;
        this.valueVector = (V) AnimationVectorsKt.newInstance(r18);
    L5:
        V r1 = this.valueVector;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        r1 = null;
    L8:
        int r2 = r1.getSize$animation_core();
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L14;
        V r5 = this.valueVector;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        r5 = null;
    L13:
        r5.set$animation_core(r4, this.anims.get(r4).getValueFromNanos(r16, r18.get$animation_core(r4), r19.get$animation_core(r4), r20.get$animation_core(r4)));
        r4 = r4 + 1;
        goto L9
    L14:
        V r3 = this.valueVector;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    L18:
        return r3;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long r16, V r18, V r19, V r20) {
        if (this.velocityVector != null) goto L5;
        this.velocityVector = (V) AnimationVectorsKt.newInstance(r20);
    L5:
        V r1 = this.velocityVector;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        r1 = null;
    L8:
        int r2 = r1.getSize$animation_core();
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L14;
        V r5 = this.velocityVector;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        r5 = null;
    L13:
        r5.set$animation_core(r4, this.anims.get(r4).getVelocityFromNanos(r16, r18.get$animation_core(r4), r19.get$animation_core(r4), r20.get$animation_core(r4)));
        r4 = r4 + 1;
        goto L9
    L14:
        V r3 = this.velocityVector;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    L18:
        return r3;
    }
}
