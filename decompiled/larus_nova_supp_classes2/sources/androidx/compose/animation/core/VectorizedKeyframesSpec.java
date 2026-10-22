package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BE\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011B;\b\u0016\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u00130\u0012\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0014J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010+J-\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010/J-\u00100\u001a\u00028\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010/J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\nH\u0002J \u00104\u001a\u0002022\u0006\u00105\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010\u001f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010 \u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010!\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\"\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "timestamps", "Landroidx/collection/IntList;", "keyframes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "durationMillis", "", "delayMillis", "defaultEasing", "Landroidx/compose/animation/core/Easing;", "initialArcMode", "Landroidx/compose/animation/core/ArcMode;", "<init>", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IILandroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "Lkotlin/Pair;", "(Ljava/util/Map;II)V", "getDurationMillis", "()I", "getDelayMillis", "I", "modes", "", "times", "", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "lastInitialValue", "lastTargetValue", "posArray", "slopeArray", "arcSpline", "Landroidx/compose/animation/core/ArcSpline;", "init", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "getValueFromNanos", "playTimeNanos", "", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getEasedTime", "", "timeMillis", "getEasedTimeFromIndex", "index", "asFraction", "", "findEntryForTimeMillis", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private ArcSpline arcSpline;
    private final Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final int initialArcMode;
    private final IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private V velocityVector;

    public /* synthetic */ VectorizedKeyframesSpec(IntList r1, IntObjectMap r2, int r3, int r4, Easing r5, int r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

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

    private final float getEasedTime(int r3) {
        return getEasedTimeFromIndex(findEntryForTimeMillis(r3), r3, false);
    }

    public VectorizedKeyframesSpec(Map<Integer, ? extends Pair<? extends V, ? extends Easing>> r9, int r10, int r11) {
        MutableIntList r1 = new MutableIntList(r9.size() + 2);
        Iterator<Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>>> r0 = r9.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        r1.add(r0.next().getKey().intValue());
        goto L4
    L7:
        if (r9.containsKey(0) == true) goto L10;
        r1.add(0, 0);
    L10:
        if (r9.containsKey(Integer.valueOf(r10)) == true) goto L12;
        r1.add(r10);
    L12:
        r1.sort();
        MutableIntObjectMap r2 = new MutableIntObjectMap(0, 1, null);
        Iterator<Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>>> r12 = r9.entrySet().iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        Map.Entry<Integer, ? extends Pair<? extends V, ? extends Easing>> r3 = r12.next();
        int r4 = r3.getKey().intValue();
        Pair<? extends V, ? extends Easing> r5 = r3.getValue();
        r2.set(r4, new VectorizedKeyframeSpecElementInfo((AnimationVector) r5.getFirst(), (Easing) r5.getSecond(), ArcMode.Companion.m262getArcLinear9TMq4(), null));
        goto L14
    L16:
        this(r1, r2, r10, r11, EasingKt.getLinearEasing(), ArcMode.Companion.m262getArcLinear9TMq4(), null);
    }

    private final float getEasedTimeFromIndex(int r5, int r6, boolean r7) {
        IntList r0 = this.timestamps;
        if (r5 < (r0._size - 1)) goto L7;
        float r8 = r6;
    L6:
        return r8 / 1000;
    L7:
        int r1 = r0.get(r5);
        int r9 = this.timestamps.get(r5 + 1);
        if (r6 != r1) goto L10;
        r8 = r1;
        goto L6
    L10:
        int r10 = r9 - r1;
        VectorizedKeyframeSpecElementInfo<V> r2 = this.keyframes.get(r1);
        if (r2 == null) goto L14;
        Easing r3 = r2.getEasing();
        if (r3 == null) goto L14;
    L15:
        float r11 = r10;
        float r12 = r3.transform((r6 - r1) / r11);
        if (r7 == false) goto L18;
        return r12;
    L18:
        r8 = (r11 * r12) + r1;
    L14:
        r3 = this.defaultEasing;
        goto L15
    }

    private final void init(V r9, V r10, V r11) {
        if (this.arcSpline == VectorizedAnimationSpecKt.access$getEmptyArcSpline$p()) goto L5;
        boolean r0 = true;
    L7:
        if (this.valueVector != null) goto L22;
        this.valueVector = (V) AnimationVectorsKt.newInstance(r9);
        this.velocityVector = (V) AnimationVectorsKt.newInstance(r11);
        int r12 = this.timestamps._size;
        float[] r1 = new float[r12];
        int r4 = 0;
    L9:
        if (r4 >= r12) goto L11;
        r1[r4] = this.timestamps.get(r4) / 1000;
        r4 = r4 + 1;
        goto L9
    L11:
        this.times = r1;
        int r13 = this.timestamps._size;
        int[] r2 = new int[r13];
        int r5 = 0;
    L12:
        if (r5 >= r13) goto L21;
        VectorizedKeyframeSpecElementInfo<V> r6 = this.keyframes.get(this.timestamps.get(r5));
        if (r6 == null) goto L16;
        int r7 = r6.m303getArcMode9TMq4();
    L18:
        if (ArcMode.m256equalsimpl0(r7, ArcMode.Companion.m262getArcLinear9TMq4()) == true) goto L20;
        r0 = true;
    L20:
        r2[r5] = r7;
        r5 = r5 + 1;
        goto L12
    L16:
        r7 = this.initialArcMode;
        goto L18
    L21:
        this.modes = r2;
    L22:
        if (r0 == true) goto L25;
        return;
    L25:
        if (this.arcSpline != VectorizedAnimationSpecKt.access$getEmptyArcSpline$p()) goto L27;
    L30:
        this.lastInitialValue = r9;
        this.lastTargetValue = r10;
        int r14 = (r9.getSize$animation_core() % 2) + r9.getSize$animation_core();
        this.posArray = new float[r14];
        this.slopeArray = new float[r14];
        int r3 = this.timestamps._size;
        float[][] r8 = new float[r3][];
        int r15 = 0;
    L31:
        if (r15 >= r3) goto L49;
        int r16 = this.timestamps.get(r15);
        VectorizedKeyframeSpecElementInfo<V> r17 = this.keyframes.get(r16);
        if (r16 != 0) goto L39;
        if (r17 != null) goto L39;
        float[] r18 = new float[r14];
        int r19 = 0;
    L36:
        if (r19 >= r14) goto L48;
        r18[r19] = r9.get$animation_core(r19);
        r19 = r19 + 1;
    L48:
        r8[r15] = r18;
        r15 = r15 + 1;
    L39:
        if (r16 != getDurationMillis()) goto L44;
        if (r17 != null) goto L44;
        r18 = new float[r14];
        int r20 = 0;
    L42:
        if (r20 >= r14) goto L48;
        r18[r20] = r10.get$animation_core(r20);
        r20 = r20 + 1;
    L44:
        Intrinsics.checkNotNull(r17);
        AnimationVector r21 = r17.getVectorValue();
        float[] r22 = new float[r14];
        int r23 = 0;
    L45:
        if (r23 >= r14) goto L47;
        r22[r23] = r21.get$animation_core(r23);
        r23 = r23 + 1;
        goto L45
    L47:
        r18 = r22;
        goto L48
    L49:
        this.arcSpline = new ArcSpline(this.modes, this.times, r8);
        return;
    L27:
        if (Intrinsics.areEqual(this.lastInitialValue, r9) == false) goto L30;
        if (Intrinsics.areEqual(this.lastTargetValue, r10) == false) goto L30;
        return;
    L5:
        r0 = false;
        goto L7
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long r6, V r8, V r9, V r10) {
        int r7 = (int) VectorizedAnimationSpecKt.clampPlayTime(this, r6 / AnimationKt.MillisToNanos);
        VectorizedKeyframeSpecElementInfo<V> r11 = this.keyframes.get(r7);
        if (r11 == null) goto L7;
        return (V) r11.getVectorValue();
    L7:
        if (r7 < getDurationMillis()) goto L9;
        return r9;
    L9:
        if (r7 > 0) goto L11;
        return r8;
    L11:
        init(r8, r9, r10);
        V r12 = this.valueVector;
        Intrinsics.checkNotNull(r12);
        int r1 = 0;
        if (this.arcSpline == VectorizedAnimationSpecKt.access$getEmptyArcSpline$p()) goto L17;
        float r13 = getEasedTime(r7);
        float[] r14 = this.posArray;
        this.arcSpline.getPos(r13, r14);
        int r15 = r14.length;
    L14:
        if (r1 >= r15) goto L16;
        r12.set$animation_core(r1, r14[r1]);
        r1 = r1 + 1;
        goto L14
    L16:
        return r12;
    L17:
        int r16 = findEntryForTimeMillis(r7);
        float r17 = getEasedTimeFromIndex(r16, r7, true);
        VectorizedKeyframeSpecElementInfo<V> r2 = this.keyframes.get(this.timestamps.get(r16));
        if (r2 == null) goto L23;
        AnimationVector r3 = r2.getVectorValue();
        if (r3 == null) goto L23;
        r8 = (V) r3;
    L23:
        VectorizedKeyframeSpecElementInfo<V> r18 = this.keyframes.get(this.timestamps.get(r16 + 1));
        if (r18 == null) goto L29;
        AnimationVector r19 = r18.getVectorValue();
        if (r19 == null) goto L29;
        r9 = (V) r19;
    L29:
        int r110 = r12.getSize$animation_core();
    L30:
        if (r1 >= r110) goto L32;
        r12.set$animation_core(r1, (r8.get$animation_core(r1) * (1 - r17)) + (r9.get$animation_core(r1) * r17));
        r1 = r1 + 1;
        goto L30
    L32:
        return r12;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long r16, V r18, V r19, V r20) {
        long r8 = VectorizedAnimationSpecKt.clampPlayTime(this, r16 / AnimationKt.MillisToNanos);
        if (r8 >= 0) goto L5;
        return r20;
    L5:
        init(r18, r19, r20);
        V r12 = this.velocityVector;
        Intrinsics.checkNotNull(r12);
        int r13 = 0;
        if (this.arcSpline == VectorizedAnimationSpecKt.access$getEmptyArcSpline$p()) goto L11;
        float r0 = getEasedTime((int) r8);
        float[] r1 = this.slopeArray;
        this.arcSpline.getSlope(r0, r1);
        int r2 = r1.length;
    L8:
        if (r13 >= r2) goto L10;
        r12.set$animation_core(r13, r1[r13]);
        r13 = r13 + 1;
        goto L8
    L10:
        return r12;
    L11:
        AnimationVector r14 = VectorizedAnimationSpecKt.getValueFromMillis(this, r8 - 1, r18, r19, r20);
        AnimationVector r3 = VectorizedAnimationSpecKt.getValueFromMillis(this, r8, r18, r19, r20);
        int r4 = r14.getSize$animation_core();
    L12:
        if (r13 >= r4) goto L14;
        r12.set$animation_core(r13, (r14.get$animation_core(r13) - r3.get$animation_core(r13)) * 1000.0f);
        r13 = r13 + 1;
        goto L12
    L14:
        return r12;
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }

    private VectorizedKeyframesSpec(IntList r1, IntObjectMap<VectorizedKeyframeSpecElementInfo<V>> r2, int r3, int r4, Easing r5, int r6) {
        this.timestamps = r1;
        this.keyframes = r2;
        this.durationMillis = r3;
        this.delayMillis = r4;
        this.defaultEasing = r5;
        this.initialArcMode = r6;
        this.modes = VectorizedAnimationSpecKt.access$getEmptyIntArray$p();
        this.times = VectorizedAnimationSpecKt.access$getEmptyFloatArray$p();
        this.posArray = VectorizedAnimationSpecKt.access$getEmptyFloatArray$p();
        this.slopeArray = VectorizedAnimationSpecKt.access$getEmptyFloatArray$p();
        this.arcSpline = VectorizedAnimationSpecKt.access$getEmptyArcSpline$p();
    }
}
