package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "isInfinite", "", "()Z", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface VectorizedFiniteAnimationSpec<V extends AnimationVector> extends VectorizedAnimationSpec<V> {

    /* JADX INFO: renamed from: androidx.compose.animation.core.VectorizedFiniteAnimationSpec$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<V extends AnimationVector> {
        public static boolean $default$isInfinite(VectorizedFiniteAnimationSpec r0) {
            return false;
        }

        public static /* synthetic */ boolean access$isInfinite$jd(VectorizedFiniteAnimationSpec r0) {
            return $default$isInfinite(r0);
        }

        public static /* synthetic */ AnimationVector access$getEndVelocity$jd(VectorizedFiniteAnimationSpec r0, AnimationVector r1, AnimationVector r2, AnimationVector r3) {
            return VectorizedAnimationSpec.CC.$default$getEndVelocity(r0, r1, r2, r3);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <V extends AnimationVector> boolean isInfinite(VectorizedFiniteAnimationSpec<V> r0) {
            return CC.access$isInfinite$jd(r0);
        }

        public static <V extends AnimationVector> V getEndVelocity(VectorizedFiniteAnimationSpec<V> r0, V r1, V r2, V r3) {
            return (V) CC.access$getEndVelocity$jd(r0, r1, r2, r3);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    boolean isInfinite();
}
