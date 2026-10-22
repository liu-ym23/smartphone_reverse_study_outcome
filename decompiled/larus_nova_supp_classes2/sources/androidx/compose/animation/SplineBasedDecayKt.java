package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Inflection", "", "StartTension", "EndTension", "P1", "P2", "computeSplineInfo", "", "splinePositions", "", "splineTimes", "nbSamples", "", "splineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "density", "Landroidx/compose/ui/unit/Density;", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SplineBasedDecayKt {
    private static final float EndTension = 1.0f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float StartTension = 0.5f;

    public static final <T> DecayAnimationSpec<T> splineBasedDecay(Density r1) {
        return DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(r1));
    }

    public static final /* synthetic */ void access$computeSplineInfo(float[] r0, float[] r1, int r2) {
        computeSplineInfo(r0, r1, r2);
    }

    private static final void computeSplineInfo(float[] r19, float[] r20, int r21) {
        float r1 = MenuKt.ClosedAlphaTarget;
        float r2 = MenuKt.ClosedAlphaTarget;
        int r3 = 0;
    L4:
        if (r3 >= r21) goto L21;
        float r5 = r3 / r21;
        float r6 = 1.0f;
    L6:
        float r7 = ((r6 - r1) / 2.0f) + r1;
        float r11 = 1.0f - r7;
        float r10 = (r7 * 3.0f) * r11;
        float r15 = (r7 * r7) * r7;
        float r13 = (((r11 * P1) + (r7 * P2)) * r10) + r15;
        if (Math.abs(r13 - r5) < 1.0E-5d) goto L12;
        if (r13 > r5) goto L10;
        r1 = r7;
        goto L6
    L10:
        r6 = r7;
        goto L6
    L12:
        float r8 = 0.5f;
        r19[r3] = (r10 * ((r11 * 0.5f) + r7)) + r15;
        float r9 = 1.0f;
    L13:
        float r12 = ((r9 - r2) / 2.0f) + r2;
        float r14 = 1.0f - r12;
        float r16 = (r12 * 3.0f) * r14;
        float r17 = (r12 * r12) * r12;
        float r18 = (((r14 * r8) + r12) * r16) + r17;
        if (Math.abs(r18 - r5) < 1.0E-5d) goto L20;
        if (r18 <= r5) goto L18;
        r9 = r12;
    L19:
        r8 = 0.5f;
        goto L13
    L18:
        r2 = r12;
        goto L19
    L20:
        r20[r3] = (r16 * ((r14 * P1) + (r12 * P2))) + r17;
        r3 = r3 + 1;
        goto L4
    L21:
        r20[r21] = 1.0f;
        r19[r21] = 1.0f;
    }
}
