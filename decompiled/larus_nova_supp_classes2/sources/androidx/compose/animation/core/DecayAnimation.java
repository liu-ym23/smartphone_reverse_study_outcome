package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B9\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\fB;\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\u000eB;\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\u0010J\u0015\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010&J\u0015\u0010'\u001a\u00028\u00012\u0006\u0010%\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010(R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0013\u0010\n\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0016\u0010\u001b\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010#¨\u0006)"}, d2 = {"Landroidx/compose/animation/core/DecayAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "<init>", "(Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "initialVelocity", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "initialValueVector", "Landroidx/compose/animation/core/AnimationVector;", "getInitialVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "endVelocity", "targetValue", "getTargetValue", "durationNanos", "", "getDurationNanos", "()J", "isInfinite", "", "()Z", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DecayAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public static final int $stable = 0;
    private final VectorizedDecayAnimationSpec<V> animationSpec;
    private final long durationNanos;
    private final V endVelocity;
    private final T initialValue;
    private final V initialValueVector;
    private final V initialVelocityVector;
    private final boolean isInfinite;
    private final T targetValue;
    private final TwoWayConverter<T, V> typeConverter;

    @Override // androidx.compose.animation.core.Animation
    public final /* synthetic */ boolean isFinishedFromNanos(long r1) {
        return Animation.CC.$default$isFinishedFromNanos(this, r1);
    }

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        return this.durationNanos;
    }

    public final T getInitialValue() {
        return this.initialValue;
    }

    public final V getInitialVelocityVector() {
        return this.initialVelocityVector;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getTargetValue() {
        return this.targetValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean isInfinite() {
        return this.isInfinite;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getValueFromNanos(long r5) {
        if (Animation.CC.$default$isFinishedFromNanos(this, r5) == true) goto L7;
        return (T) getTypeConverter().getConvertFromVector().invoke(this.animationSpec.getValueFromNanos(r5, this.initialValueVector, this.initialVelocityVector));
    L7:
        return getTargetValue();
    }

    @Override // androidx.compose.animation.core.Animation
    public V getVelocityVectorFromNanos(long r4) {
        if (Animation.CC.$default$isFinishedFromNanos(this, r4) == true) goto L7;
        return (V) this.animationSpec.getVelocityFromNanos(r4, this.initialValueVector, this.initialVelocityVector);
    L7:
        return this.endVelocity;
    }

    public DecayAnimation(VectorizedDecayAnimationSpec<V> r3, TwoWayConverter<T, V> r4, T r5, V r6) {
        this.animationSpec = r3;
        this.typeConverter = r4;
        this.initialValue = r5;
        V r7 = (V) getTypeConverter().getConvertToVector().invoke(r5);
        this.initialValueVector = r7;
        this.initialVelocityVector = (V) AnimationVectorsKt.copy(r6);
        this.targetValue = (T) getTypeConverter().getConvertFromVector().invoke(r3.getTargetValue(r7, r6));
        this.durationNanos = r3.getDurationNanos(r7, r6);
        V r8 = (V) AnimationVectorsKt.copy(r3.getVelocityFromNanos(getDurationNanos(), r7, r6));
        this.endVelocity = r8;
        int r9 = r8.getSize$animation_core();
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L5;
        V r11 = this.endVelocity;
        r11.set$animation_core(r10, RangesKt.coerceIn(r11.get$animation_core(r10), -this.animationSpec.getAbsVelocityThreshold(), this.animationSpec.getAbsVelocityThreshold()));
        r10 = r10 + 1;
        goto L3
    }

    public DecayAnimation(DecayAnimationSpec<T> r2, TwoWayConverter<T, V> r3, T r4, T r5) {
        this(r2.vectorize(r3), r3, r4, (AnimationVector) r3.getConvertToVector().invoke(r5));
    }

    public DecayAnimation(DecayAnimationSpec<T> r1, TwoWayConverter<T, V> r2, T r3, V r4) {
        this(r1.vectorize(r2), r2, r3, r4);
    }
}
