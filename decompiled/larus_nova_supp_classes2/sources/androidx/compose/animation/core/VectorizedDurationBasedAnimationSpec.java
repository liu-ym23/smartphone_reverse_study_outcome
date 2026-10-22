package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J%\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "durationMillis", "", "getDurationMillis", "()I", "delayMillis", "getDelayMillis", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface VectorizedDurationBasedAnimationSpec<V extends AnimationVector> extends VectorizedFiniteAnimationSpec<V> {

    /* JADX INFO: renamed from: androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<V extends AnimationVector> {
        public static /* synthetic */ boolean access$isInfinite$jd(VectorizedDurationBasedAnimationSpec r0) {
            return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(r0);
        }

        public static long $default$getDurationNanos(VectorizedDurationBasedAnimationSpec r0, AnimationVector r1, AnimationVector r2, AnimationVector r3) {
            return ((long) (r0.getDelayMillis() + r0.getDurationMillis())) * AnimationKt.MillisToNanos;
        }

        public static /* synthetic */ long access$getDurationNanos$jd(VectorizedDurationBasedAnimationSpec r0, AnimationVector r1, AnimationVector r2, AnimationVector r3) {
            return $default$getDurationNanos(r0, r1, r2, r3);
        }

        public static /* synthetic */ AnimationVector access$getEndVelocity$jd(VectorizedDurationBasedAnimationSpec r0, AnimationVector r1, AnimationVector r2, AnimationVector r3) {
            return VectorizedAnimationSpec.CC.$default$getEndVelocity(r0, r1, r2, r3);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <V extends AnimationVector> boolean isInfinite(VectorizedDurationBasedAnimationSpec<V> r0) {
            return CC.access$isInfinite$jd(r0);
        }

        public static <V extends AnimationVector> long getDurationNanos(VectorizedDurationBasedAnimationSpec<V> r0, V r1, V r2, V r3) {
            return CC.access$getDurationNanos$jd(r0, r1, r2, r3);
        }

        public static <V extends AnimationVector> V getEndVelocity(VectorizedDurationBasedAnimationSpec<V> r0, V r1, V r2, V r3) {
            return (V) CC.access$getEndVelocity$jd(r0, r1, r2, r3);
        }
    }

    int getDelayMillis();

    int getDurationMillis();

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    long getDurationNanos(V r1, V r2, V r3);
}
