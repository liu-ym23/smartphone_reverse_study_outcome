package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J-\u0010&\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010)J-\u0010*\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010)J\u0010\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0018\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\f\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010\u001e\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u001f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u00060"}, d2 = {"Landroidx/compose/animation/core/VectorizedMonoSplineKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "timestamps", "Landroidx/collection/IntList;", "keyframes", "Landroidx/collection/IntObjectMap;", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "", "delayMillis", "periodicBias", "", "<init>", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IIF)V", "getDurationMillis", "()I", "getDelayMillis", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "times", "", "monoSpline", "Landroidx/compose/animation/core/MonoSpline;", "values", "", "[[F", "lastInitialValue", "lastTargetValue", "init", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "getValueFromNanos", "playTimeNanos", "", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getEasing", "index", "getEasedTimeFromIndex", "timeMillis", "findEntryForTimeMillis", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorizedMonoSplineKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final IntObjectMap<Pair<V, Easing>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private MonoSpline monoSpline;
    private final float periodicBias;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private float[][] values;
    private V velocityVector;

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ long getDurationNanos(AnimationVector r1, AnimationVector r2, AnimationVector r3) {
        return VectorizedDurationBasedAnimationSpec.CC.$default$getDurationNanos(this, r1, r2, r3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ AnimationVector getEndVelocity(AnimationVector r1, AnimationVector r2, AnimationVector r3) {
        return VectorizedAnimationSpec.CC.$default$getEndVelocity(this, r1, r2, r3);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public final /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    private final int findEntryForTimeMillis(int r7) {
        int r8 = IntList.binarySearch$default(this.timestamps, r7, 0, 0, 6, null);
        if (r8 < (-1)) goto L5;
        return r8;
    L5:
        return -(r8 + 2);
    }

    private final Easing getEasing(int r2) {
        int r3 = this.timestamps.get(r2);
        Pair<V, Easing> r4 = this.keyframes.get(r3);
        if (r4 == null) goto L7;
        Easing r5 = (Easing) r4.getSecond();
        if (r5 == null) goto L7;
        return r5;
    L7:
        return EasingKt.getLinearEasing();
    }

    private final float getEasedTimeFromIndex(int r6, int r7) {
        IntList r0 = this.timestamps;
        if (r6 < (r0._size - 1)) goto L7;
        float r8 = r7;
    L6:
        return r8 / 1000;
    L7:
        int r1 = r0.get(r6);
        int r2 = this.timestamps.get(r6 + 1);
        if (r7 != r1) goto L10;
        r8 = r1;
        goto L6
    L10:
        float r3 = r2 - r1;
        return ((r3 * getEasing(r6).transform((r7 - r1) / r3)) + r1) / 1000;
    }

    private final void init(V r11, V r12, V r13) {
        int r1 = 0;
        if (this.valueVector != null) goto L9;
        this.valueVector = (V) AnimationVectorsKt.newInstance(r11);
        this.velocityVector = (V) AnimationVectorsKt.newInstance(r13);
        int r14 = this.timestamps._size;
        float[] r0 = new float[r14];
        int r2 = 0;
    L5:
        if (r2 >= r14) goto L7;
        r0[r2] = this.timestamps.get(r2) / 1000;
        r2 = r2 + 1;
        goto L5
    L7:
        this.times = r0;
    L9:
        if (this.monoSpline != null) goto L11;
    L14:
        boolean r15 = !Intrinsics.areEqual(this.lastInitialValue, r11);
        boolean r3 = !Intrinsics.areEqual(this.lastTargetValue, r12);
        this.lastInitialValue = r11;
        this.lastTargetValue = r12;
        int r4 = r11.getSize$animation_core();
        float[][] r5 = this.values;
        if (r5 != null) goto L36;
        int r16 = this.timestamps._size;
        r5 = new float[r16][];
        int r6 = 0;
    L17:
        if (r6 >= r16) goto L35;
        int r7 = this.timestamps.get(r6);
        Pair<V, Easing> r8 = this.keyframes.get(r7);
        if (r7 != 0) goto L25;
        if (r8 != null) goto L25;
        float[] r9 = new float[r4];
        int r10 = 0;
    L22:
        if (r10 >= r4) goto L34;
        r9[r10] = r11.get$animation_core(r10);
        r10 = r10 + 1;
    L34:
        r5[r6] = r9;
        r6 = r6 + 1;
    L25:
        if (r7 != getDurationMillis()) goto L30;
        if (r8 != null) goto L30;
        r9 = new float[r4];
        int r17 = 0;
    L28:
        if (r17 >= r4) goto L34;
        r9[r17] = r12.get$animation_core(r17);
        r17 = r17 + 1;
    L30:
        Intrinsics.checkNotNull(r8);
        AnimationVector r18 = (AnimationVector) r8.getFirst();
        float[] r19 = new float[r4];
        int r20 = 0;
    L31:
        if (r20 >= r4) goto L33;
        r19[r20] = r18.get$animation_core(r20);
        r20 = r20 + 1;
        goto L31
    L33:
        r9 = r19;
        goto L34
    L35:
        this.values = r5;
    L50:
        float[] r110 = this.times;
        if (r110 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("times");
        r110 = null;
    L53:
        this.monoSpline = new MonoSpline(r110, r5, this.periodicBias);
        return;
    L36:
        if (r15 == true) goto L38;
    L43:
        if (r3 == false) goto L50;
        if (this.keyframes.containsKey(getDurationMillis()) == true) goto L50;
        int r111 = IntList.binarySearch$default(this.timestamps, getDurationMillis(), 0, 0, 6, null);
        float[] r112 = new float[r4];
    L47:
        if (r1 >= r4) goto L49;
        r112[r1] = r12.get$animation_core(r1);
        r1 = r1 + 1;
        goto L47
    L49:
        r5[r111] = r112;
        goto L50
    L38:
        if (this.keyframes.containsKey(0) == true) goto L43;
        int r113 = IntList.binarySearch$default(this.timestamps, 0, 0, 0, 6, null);
        float[] r21 = new float[r4];
        int r22 = 0;
    L40:
        if (r22 >= r4) goto L42;
        r21[r22] = r11.get$animation_core(r22);
        r22 = r22 + 1;
        goto L40
    L42:
        r5[r113] = r21;
        goto L43
    L11:
        if (Intrinsics.areEqual(this.lastInitialValue, r11) == false) goto L14;
        if (Intrinsics.areEqual(this.lastTargetValue, r12) == false) goto L14;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long r3, V r5, V r6, V r7) {
        int r4 = (int) VectorizedAnimationSpecKt.clampPlayTime(this, r3 / AnimationKt.MillisToNanos);
        Pair<V, Easing> r8 = this.keyframes.get(r4);
        if (r8 == null) goto L7;
        return (V) r8.getFirst();
    L7:
        if (r4 < getDurationMillis()) goto L9;
        return r6;
    L9:
        if (r4 > 0) goto L11;
        return r5;
    L11:
        init(r5, r6, r7);
        int r9 = findEntryForTimeMillis(r4);
        V r10 = this.valueVector;
        Intrinsics.checkNotNull(r10);
        MonoSpline r11 = this.monoSpline;
        Intrinsics.checkNotNull(r11);
        r11.getPos(getEasedTimeFromIndex(r9, r4), r10, r9);
        return r10;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long r3, V r5, V r6, V r7) {
        int r4 = (int) VectorizedAnimationSpecKt.clampPlayTime(this, r3 / AnimationKt.MillisToNanos);
        init(r5, r6, r7);
        int r8 = findEntryForTimeMillis(r4);
        V r9 = this.velocityVector;
        Intrinsics.checkNotNull(r9);
        MonoSpline r10 = this.monoSpline;
        Intrinsics.checkNotNull(r10);
        r10.getSlope(getEasedTimeFromIndex(r8, r4), r9, r8);
        return r9;
    }

    public VectorizedMonoSplineKeyframesSpec(IntList r1, IntObjectMap<Pair<V, Easing>> r2, int r3, int r4, float r5) {
        this.timestamps = r1;
        this.keyframes = r2;
        this.durationMillis = r3;
        this.delayMillis = r4;
        this.periodicBias = r5;
    }
}
