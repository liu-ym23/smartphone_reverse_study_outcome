package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ak\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00022\b\b\u0002\u0010\b\u001a\u0002H\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u0001H\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0001¢\u0006\u0002\u0010\u000e\u001aT\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0002*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00022\b\b\u0002\u0010\b\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0001\u001aB\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0001\u001ai\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00162\u0006\u0010\u0013\u001a\u0002H\u00052\u0006\u0010\u0014\u001a\u0002H\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0001¢\u0006\u0002\u0010\u0017\u001a3\u0010\u0018\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00162\u0006\u0010\b\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0019\"\u001d\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u001a"}, d2 = {"isFinished", "", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/animation/core/AnimationState;)Z", "copy", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "value", "velocityVector", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "velocity", "AnimationState", "initialValue", "initialVelocity", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;JJZ)Landroidx/compose/animation/core/AnimationState;", "createZeroVectorFrom", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimationStateKt {
    public static final boolean isFinished(AnimationState<?, ?> r4) {
        if (r4.getFinishedTimeNanos() == Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T, V extends AnimationVector> V createZeroVectorFrom(TwoWayConverter<T, V> r0, T r1) {
        V r2 = (V) r0.getConvertToVector().invoke(r1);
        r2.reset$animation_core();
        return r2;
    }

    public static final AnimationState<Float, AnimationVector1D> AnimationState(float r10, float r11, long r12, long r14, boolean r16) {
        return new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(r10), AnimationVectorsKt.AnimationVector(r11), r12, r14, r16);
    }

    public static final <T, V extends AnimationVector> AnimationState<T, V> AnimationState(TwoWayConverter<T, V> r10, T r11, T r12, long r13, long r15, boolean r17) {
        return new AnimationState(r10, r11, (AnimationVector) r10.getConvertToVector().invoke(r12), r13, r15, r17);
    }

    public static final AnimationState<Float, AnimationVector1D> copy(AnimationState<Float, AnimationVector1D> r10, float r11, float r12, long r13, long r15, boolean r17) {
        return new AnimationState(r10.getTypeConverter(), Float.valueOf(r11), AnimationVectorsKt.AnimationVector(r12), r13, r15, r17);
    }

    public static final <T, V extends AnimationVector> AnimationState<T, V> copy(AnimationState<T, V> r10, T r11, V r12, long r13, long r15, boolean r17) {
        return new AnimationState(r10.getTypeConverter(), r11, r12, r13, r15, r17);
    }

    public static /* synthetic */ AnimationState AnimationState$default(float r4, float r5, long r6, long r8, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r5 = MenuKt.ClosedAlphaTarget;
    L5:
        long r0 = Long.MIN_VALUE;
        if ((r11 & 4) == 0) goto L8;
        long r2 = Long.MIN_VALUE;
    L10:
        if ((r11 & 8) != 0) goto L14;
        r0 = r8;
    L14:
        if ((r11 & 16) == 0) goto L16;
        boolean r13 = false;
    L18:
        return AnimationState(r4, r5, r2, r0, r13);
    L16:
        r13 = r10;
        goto L18
    L8:
        r2 = r6;
        goto L10
    }

    public static /* synthetic */ AnimationState AnimationState$default(TwoWayConverter r11, Object r12, Object r13, long r14, long r16, boolean r18, int r19, Object r20) {
        if ((r19 & 8) == 0) goto L5;
        long r6 = Long.MIN_VALUE;
    L7:
        if ((r19 & 16) == 0) goto L9;
        long r8 = Long.MIN_VALUE;
    L11:
        if ((r19 & 32) == 0) goto L13;
        boolean r10 = false;
    L15:
        return AnimationState(r11, r12, r13, r6, r8, r10);
    L13:
        r10 = r18;
        goto L15
    L9:
        r8 = r16;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState r5, float r6, float r7, long r8, long r10, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = ((Number) r5.getValue()).floatValue();
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = ((AnimationVector1D) r5.getVelocityVector()).getValue();
    L8:
        float r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.getLastFrameTimeNanos();
    L11:
        long r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r10 = r5.getFinishedTimeNanos();
    L14:
        long r2 = r10;
        if ((r13 & 16) == 0) goto L17;
        r12 = r5.isRunning();
    L17:
        float r9 = r6;
        return copy(r5, r9, r15, r0, r2, r12);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState r5, Object r6, AnimationVector r7, long r8, long r10, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.getValue();
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = AnimationVectorsKt.copy(r5.getVelocityVector());
    L8:
        AnimationVector r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.getLastFrameTimeNanos();
    L11:
        long r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r10 = r5.getFinishedTimeNanos();
    L14:
        long r2 = r10;
        if ((r13 & 16) == 0) goto L17;
        r12 = r5.isRunning();
    L17:
        Object r9 = r6;
        return copy(r5, r9, r15, r0, r2, r12);
    }
}
