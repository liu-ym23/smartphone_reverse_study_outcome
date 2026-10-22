package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004BG\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\f\u0010\rBG\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\f\u0010\u000fJ\u0015\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(H\u0016¢\u0006\u0002\u0010)J\u0015\u00102\u001a\u00028\u00012\u0006\u0010'\u001a\u00020(H\u0016¢\u0006\u0002\u00103J\b\u00104\u001a\u000205H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0011\u0010\t\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017R\u0014\u0010\n\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0010\u0010 \u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\u000b\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010%R\u000e\u0010*\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010/\u001a\u00028\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00066"}, d2 = {"Landroidx/compose/animation/core/TargetBasedAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocityVector", "<init>", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "getAnimationSpec$animation_core", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "mutableTargetValue", "getMutableTargetValue$animation_core", "()Ljava/lang/Object;", "setMutableTargetValue$animation_core", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "mutableInitialValue", "getMutableInitialValue$animation_core", "setMutableInitialValue$animation_core", "getInitialValue", "getTargetValue", "initialValueVector", "Landroidx/compose/animation/core/AnimationVector;", "targetValueVector", "isInfinite", "", "()Z", "getValueFromNanos", "playTimeNanos", "", "(J)Ljava/lang/Object;", "_durationNanos", "durationNanos", "getDurationNanos", "()J", "_endVelocity", "endVelocity", "getEndVelocity", "()Landroidx/compose/animation/core/AnimationVector;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "toString", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TargetBasedAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public static final int $stable = 8;
    private long _durationNanos;
    private V _endVelocity;
    private final VectorizedAnimationSpec<V> animationSpec;
    private V initialValueVector;
    private final V initialVelocityVector;
    private T mutableInitialValue;
    private T mutableTargetValue;
    private V targetValueVector;
    private final TwoWayConverter<T, V> typeConverter;

    @Override // androidx.compose.animation.core.Animation
    public final /* synthetic */ boolean isFinishedFromNanos(long r1) {
        return Animation.CC.$default$isFinishedFromNanos(this, r1);
    }

    private final V getEndVelocity() {
        V r0 = this._endVelocity;
        if (r0 != null) goto L6;
        V r1 = (V) this.animationSpec.getEndVelocity(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        this._endVelocity = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        if (this._durationNanos >= 0) goto L6;
        this._durationNanos = this.animationSpec.getDurationNanos(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
    L6:
        return this._durationNanos;
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    public String toString() {
        return "TargetBasedAnimation: " + getInitialValue() + " -> " + getTargetValue() + ",initial velocity: " + this.initialVelocityVector + ", duration: " + AnimationKt.getDurationMillis(this) + " ms,animationSpec: " + this.animationSpec;
    }

    public final VectorizedAnimationSpec<V> getAnimationSpec$animation_core() {
        return this.animationSpec;
    }

    public final T getInitialValue() {
        return this.mutableInitialValue;
    }

    public final T getMutableInitialValue$animation_core() {
        return this.mutableInitialValue;
    }

    public final T getMutableTargetValue$animation_core() {
        return this.mutableTargetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getTargetValue() {
        return this.mutableTargetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getValueFromNanos(long r8) {
        if (Animation.CC.$default$isFinishedFromNanos(this, r8) == true) goto L12;
        AnimationVector r0 = this.animationSpec.getValueFromNanos(r8, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        int r1 = r0.getSize$animation_core();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L16;
        if ((!Float.isNaN(r0.get$animation_core(r2))) == true) goto L9;
        PreconditionsKt.throwIllegalStateException("AnimationVector cannot contain a NaN. " + r0 + ". Animation: " + this + ", playTimeNanos: " + r8);
    L9:
        r2 = r2 + 1;
        goto L5
    L16:
        return (T) getTypeConverter().getConvertFromVector().invoke(r0);
    L12:
        return getTargetValue();
    }

    @Override // androidx.compose.animation.core.Animation
    public V getVelocityVectorFromNanos(long r8) {
        if (Animation.CC.$default$isFinishedFromNanos(this, r8) == true) goto L6;
        return (V) this.animationSpec.getVelocityFromNanos(r8, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
    L6:
        return (V) getEndVelocity();
    }

    public final void setMutableInitialValue$animation_core(T r3) {
        if (Intrinsics.areEqual(r3, this.mutableInitialValue) == true) goto L6;
        this.mutableInitialValue = r3;
        this.initialValueVector = (V) getTypeConverter().getConvertToVector().invoke(r3);
        this._endVelocity = null;
        this._durationNanos = -1;
        return;
    }

    public final void setMutableTargetValue$animation_core(T r3) {
        if (Intrinsics.areEqual(this.mutableTargetValue, r3) == true) goto L6;
        this.mutableTargetValue = r3;
        this.targetValueVector = (V) getTypeConverter().getConvertToVector().invoke(r3);
        this._endVelocity = null;
        this._durationNanos = -1;
        return;
    }

    public TargetBasedAnimation(VectorizedAnimationSpec<V> r1, TwoWayConverter<T, V> r2, T r3, T r4, V r5) {
        this.animationSpec = r1;
        this.typeConverter = r2;
        this.mutableTargetValue = r4;
        this.mutableInitialValue = r3;
        this.initialValueVector = (V) getTypeConverter().getConvertToVector().invoke(r3);
        this.targetValueVector = (V) getTypeConverter().getConvertToVector().invoke(r4);
        if (r5 == null) goto L6;
        V r6 = (V) AnimationVectorsKt.copy(r5);
        if (r6 == null) goto L6;
    L7:
        this.initialVelocityVector = r6;
        this._durationNanos = -1;
        return;
    L6:
        r6 = (V) AnimationVectorsKt.newInstance((AnimationVector) getTypeConverter().getConvertToVector().invoke(r3));
        goto L7
    }

    public TargetBasedAnimation(AnimationSpec<T> r7, TwoWayConverter<T, V> r8, T r9, T r10, V r11) {
        this(r7.vectorize(r8), r8, r9, r10, r11);
    }

    public /* synthetic */ TargetBasedAnimation(AnimationSpec r7, TwoWayConverter r8, Object r9, Object r10, AnimationVector r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public /* synthetic */ TargetBasedAnimation(VectorizedAnimationSpec r7, TwoWayConverter r8, Object r9, Object r10, AnimationVector r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }
}
