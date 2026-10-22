package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a&\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\u001b\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u000e\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0000¢\u0006\u0002\u0010\r\u001a#\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000b2\u0006\u0010\u0011\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"AnimationVector", "Landroidx/compose/animation/core/AnimationVector1D;", "v1", "", "Landroidx/compose/animation/core/AnimationVector2D;", "v2", "Landroidx/compose/animation/core/AnimationVector3D;", "v3", "Landroidx/compose/animation/core/AnimationVector4D;", "v4", "newInstance", "T", "Landroidx/compose/animation/core/AnimationVector;", "(Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "copy", "copyFrom", "", "source", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimationVectorsKt {
    public static final AnimationVector1D AnimationVector(float r1) {
        return new AnimationVector1D(r1);
    }

    public static final <T extends AnimationVector> T copy(T r4) {
        T r0 = (T) newInstance(r4);
        int r1 = r0.getSize$animation_core();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.set$animation_core(r2, r4.get$animation_core(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static final <T extends AnimationVector> T newInstance(T r1) {
        T r2 = (T) r1.newVector$animation_core();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return r2;
    }

    public static final AnimationVector2D AnimationVector(float r1, float r2) {
        return new AnimationVector2D(r1, r2);
    }

    public static final <T extends AnimationVector> void copyFrom(T r3, T r4) {
        int r0 = r3.getSize$animation_core();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3.set$animation_core(r1, r4.get$animation_core(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final AnimationVector3D AnimationVector(float r1, float r2, float r3) {
        return new AnimationVector3D(r1, r2, r3);
    }

    public static final AnimationVector4D AnimationVector(float r1, float r2, float r3, float r4) {
        return new AnimationVector4D(r1, r2, r3, r4);
    }
}
