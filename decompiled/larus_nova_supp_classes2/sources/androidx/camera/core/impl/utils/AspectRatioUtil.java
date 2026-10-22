package androidx.camera.core.impl.utils;

import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.compose.material3.MenuKt;
import androidx.core.util.Preconditions;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class AspectRatioUtil {
    private static final int ALIGN16 = 16;
    public static final Rational ASPECT_RATIO_16_9 = null;
    public static final Rational ASPECT_RATIO_3_4 = null;
    public static final Rational ASPECT_RATIO_4_3 = null;
    public static final Rational ASPECT_RATIO_9_16 = null;

    public static final class CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace implements Comparator<Rational> {
        private final Rational mFullFovRatio;
        private final Rational mTargetRatio;
        private final RectF mTransformedMappingArea;

        private float getMappingAreaSize(RectF r2) {
            return r2.width() * r2.height();
        }

        private RectF getTransformedMappingArea(Rational r6) {
            if (r6.floatValue() != this.mFullFovRatio.floatValue()) goto L7;
            return new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, this.mFullFovRatio.getNumerator(), this.mFullFovRatio.getDenominator());
        L7:
            if (r6.floatValue() <= this.mFullFovRatio.floatValue()) goto L11;
            return new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, this.mFullFovRatio.getNumerator(), (r6.getDenominator() * this.mFullFovRatio.getNumerator()) / r6.getNumerator());
        L11:
            return new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, (r6.getNumerator() * this.mFullFovRatio.getDenominator()) / r6.getDenominator(), this.mFullFovRatio.getDenominator());
        }

        public CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(Rational r3, Rational r4) {
            this.mTargetRatio = r3;
            if (r4 != null) goto L6;
            r4 = new Rational(4, 3);
        L6:
            this.mFullFovRatio = r4;
            this.mTransformedMappingArea = getTransformedMappingArea(r3);
        }

        private float getOverlappingAreaSize(RectF r4, RectF r5) {
            if (r4.width() >= r5.width()) goto L5;
            float r0 = r4.width();
        L7:
            if (r4.height() >= r5.height()) goto L9;
            float r6 = r4.height();
        L11:
            return r0 * r6;
        L9:
            r6 = r5.height();
            goto L11
        L5:
            r0 = r5.width();
            goto L7
        }

        private boolean isMappingAreaCovered(RectF r3, RectF r4) {
            if (r3.width() >= r4.width()) goto L5;
        L7:
            return false;
        L5:
            if (r3.height() < r4.height()) goto L7;
            return true;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Rational r3, Rational r4) {
            if (r3.equals(r4) == false) goto L6;
            return 0;
        L6:
            RectF r5 = getTransformedMappingArea(r3);
            RectF r6 = getTransformedMappingArea(r4);
            boolean r0 = isMappingAreaCovered(r5, this.mTransformedMappingArea);
            boolean r1 = isMappingAreaCovered(r6, this.mTransformedMappingArea);
            if (r0 == false) goto L11;
            if (r1 == false) goto L11;
            return (int) Math.signum(getMappingAreaSize(r5) - getMappingAreaSize(r6));
        L11:
            if (r0 == false) goto L14;
            return -1;
        L14:
            if (r1 == false) goto L18;
            return 1;
        L18:
            return -((int) Math.signum(getOverlappingAreaSize(r5, this.mTransformedMappingArea) - getOverlappingAreaSize(r6, this.mTransformedMappingArea)));
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Rational r1, Rational r2) {
            return compare2(r1, r2);
        }
    }

    static {
        ASPECT_RATIO_4_3 = new Rational(4, 3);
        ASPECT_RATIO_3_4 = new Rational(3, 4);
        ASPECT_RATIO_16_9 = new Rational(16, 9);
        ASPECT_RATIO_9_16 = new Rational(9, 16);
    }

    private AspectRatioUtil() {
    }

    public static boolean hasMatchingAspectRatio(Size r1, Rational r2) {
        return hasMatchingAspectRatio(r1, r2, SizeUtil.RESOLUTION_VGA);
    }

    private static boolean isPossibleMod16FromAspectRatio(Size r5, Rational r6) {
        int r0 = r5.getWidth();
        int r7 = r5.getHeight();
        Rational r1 = new Rational(r6.getDenominator(), r6.getNumerator());
        int r2 = r0 % 16;
        if (r2 == 0) goto L5;
    L12:
        if (r2 != 0) goto L16;
        return ratioIntersectsMod16Segment(r7, r0, r6);
    L16:
        if ((r7 % 16) == 0) goto L18;
        return false;
    L18:
        return ratioIntersectsMod16Segment(r0, r7, r1);
    L5:
        if ((r7 % 16) != 0) goto L12;
        if (ratioIntersectsMod16Segment(Math.max(0, r7 - 16), r0, r6) == false) goto L9;
    L10:
        return true;
    L9:
        if (ratioIntersectsMod16Segment(Math.max(0, r0 - 16), r7, r1) == true) goto L10;
        return false;
    }

    public static boolean hasMatchingAspectRatio(Size r4, Rational r5, Size r6) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.equals(new Rational(r4.getWidth(), r4.getHeight())) == false) goto L9;
        return true;
    L9:
        if (SizeUtil.getArea(r4) >= SizeUtil.getArea(r6)) goto L11;
        return false;
    L11:
        return isPossibleMod16FromAspectRatio(r4, r5);
    }

    private static boolean ratioIntersectsMod16Segment(int r7, int r8, Rational r9) {
        if ((r8 % 16) != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        double r3 = ((double) (r7 * r9.getNumerator())) / ((double) r9.getDenominator());
        if (r3 > Math.max(0, r8 - 16)) goto L9;
    L11:
        return false;
    L9:
        if (r3 >= (r8 + 16)) goto L11;
        return true;
    L5:
        r0 = false;
        goto L6
    }
}
