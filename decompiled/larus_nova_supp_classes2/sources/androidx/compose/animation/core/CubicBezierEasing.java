package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.graphics.BezierKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/animation/core/CubicBezierEasing;", "Landroidx/compose/animation/core/Easing;", "a", "", "b", "c", "d", "<init>", "(FFFF)V", "min", "max", "transform", "fraction", "throwNoSolution", "", "equals", "", "other", "", "hashCode", "", "toString", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CubicBezierEasing implements Easing {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f982c;
    private final float d;
    private final float max;
    private final float min;

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f980a) * 31) + Float.floatToIntBits(this.f981b)) * 31) + Float.floatToIntBits(this.f982c)) * 31) + Float.floatToIntBits(this.d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f980a + ", b=" + this.f981b + ", c=" + this.f982c + ", d=" + this.d + ')';
    }

    private final void throwNoSolution(float r5) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.f980a + ", " + this.f981b + ", " + this.f982c + ", " + this.d + ") has no solution at " + r5);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof CubicBezierEasing) == false) goto L26;
        CubicBezierEasing r6 = (CubicBezierEasing) r5;
        if (this.f980a != r6.f980a) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (this.f981b != r6.f981b) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return false;
    L15:
        if (this.f982c != r6.f982c) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L20;
        return false;
    L20:
        if (this.d != r6.d) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L30;
        return true;
    L30:
        return false;
    L22:
        r7 = false;
        goto L23
    L17:
        r2 = false;
        goto L18
    L12:
        r1 = false;
        goto L13
    L7:
        r0 = false;
        goto L8
    L26:
        return false;
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float r6) {
        if (r6 > MenuKt.ClosedAlphaTarget) goto L5;
        return r6;
    L5:
        if (r6 >= 1.0f) goto L17;
        float r2 = Math.max(r6, 1.1920929E-7f);
        float r0 = BezierKt.findFirstCubicRoot(MenuKt.ClosedAlphaTarget - r2, this.f980a - r2, this.f982c - r2, 1.0f - r2);
        if (Float.isNaN(r0) == false) goto L9;
        throwNoSolution(r6);
    L9:
        float r7 = BezierKt.evaluateCubic(this.f981b, this.d, r0);
        float r1 = this.min;
        float r3 = this.max;
        if (r7 >= r1) goto L13;
        r7 = r1;
    L13:
        if (r7 > r3) goto L15;
        return r7;
    L15:
        return r3;
    L17:
        return r6;
    }

    public CubicBezierEasing(float r7, float r8, float r9, float r10) {
        this.f980a = r7;
        this.f981b = r8;
        this.f982c = r9;
        this.d = r10;
        if (Float.isNaN(r7) == false) goto L5;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == true) goto L14;
        PreconditionsKt.throwIllegalArgumentException("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + r7 + ", " + r8 + ", " + r9 + ", " + r10 + '.');
    L14:
        long r11 = BezierKt.computeCubicVerticalBounds(MenuKt.ClosedAlphaTarget, r8, r10, 1.0f, new float[5], 0);
        this.min = Float.intBitsToFloat((int) (r11 >> 32));
        this.max = Float.intBitsToFloat((int) (r11 & 4294967295L));
        return;
    L5:
        if (Float.isNaN(r8) == true) goto L11;
        if (Float.isNaN(r9) == true) goto L11;
        if (Float.isNaN(r10) == true) goto L11;
        r0 = true;
        goto L12
    }
}
