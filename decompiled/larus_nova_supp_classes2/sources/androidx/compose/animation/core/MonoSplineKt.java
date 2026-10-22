package androidx.compose.animation.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001a8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a8\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"MonoSplineIsExtrapolate", "", "hermiteInterpolate", "", "h", "x", "y1", "y2", "t1", "t2", "hermiteDifferential", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MonoSplineKt {
    private static final boolean MonoSplineIsExtrapolate = true;

    public static final float hermiteDifferential(float r3, float r4, float r5, float r6, float r7, float r8) {
        float r0 = r4 * r4;
        float r1 = 2;
        return (r3 * ((r7 - ((r1 * r4) * ((r1 * r7) + r8))) + ((3 * (r7 + r8)) * r0))) - ((6 * (r4 - r0)) * (r5 - r6));
    }

    public static final float hermiteInterpolate(float r4, float r5, float r6, float r7, float r8, float r9) {
        float r0 = r5 * r5;
        float r1 = r0 * r5;
        float r2 = 2;
        return ((((r8 * r4) * ((r5 - (r2 * r0)) + r1)) + ((r4 * r9) * (r1 - r0))) + r6) - (((3 * r0) - (r2 * r1)) * (r6 - r7));
    }
}
