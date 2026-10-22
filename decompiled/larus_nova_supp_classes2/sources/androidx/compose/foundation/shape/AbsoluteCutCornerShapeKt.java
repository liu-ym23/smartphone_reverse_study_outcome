package androidx.compose.foundation.shape;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\b\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0003\u0010\u0012\u001a\u00020\n2\b\b\u0003\u0010\u0013\u001a\u00020\n2\b\b\u0003\u0010\u0014\u001a\u00020\n¨\u0006\u0015"}, d2 = {"AbsoluteCutCornerShape", "Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "AbsoluteCutCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "", "percent", "", "topLeft", "topRight", "bottomRight", "bottomLeft", "AbsoluteCutCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "topLeftPercent", "topRightPercent", "bottomRightPercent", "bottomLeftPercent", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AbsoluteCutCornerShapeKt {
    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(float r0) {
        return AbsoluteCutCornerShape(CornerSizeKt.CornerSize(r0));
    }

    /* JADX INFO: renamed from: AbsoluteCutCornerShape-0680j_4, reason: not valid java name */
    public static final AbsoluteCutCornerShape m1313AbsoluteCutCornerShape0680j_4(float r0) {
        return AbsoluteCutCornerShape(CornerSizeKt.m1322CornerSize0680j_4(r0));
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(int r0) {
        return AbsoluteCutCornerShape(CornerSizeKt.CornerSize(r0));
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(CornerSize r1) {
        return new AbsoluteCutCornerShape(r1, r1, r1, r1);
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(float r1, float r2, float r3, float r4) {
        return new AbsoluteCutCornerShape(CornerSizeKt.CornerSize(r1), CornerSizeKt.CornerSize(r2), CornerSizeKt.CornerSize(r3), CornerSizeKt.CornerSize(r4));
    }

    /* JADX INFO: renamed from: AbsoluteCutCornerShape-a9UjIt4, reason: not valid java name */
    public static final AbsoluteCutCornerShape m1314AbsoluteCutCornerShapea9UjIt4(float r1, float r2, float r3, float r4) {
        return new AbsoluteCutCornerShape(CornerSizeKt.m1322CornerSize0680j_4(r1), CornerSizeKt.m1322CornerSize0680j_4(r2), CornerSizeKt.m1322CornerSize0680j_4(r3), CornerSizeKt.m1322CornerSize0680j_4(r4));
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(int r1, int r2, int r3, int r4) {
        return new AbsoluteCutCornerShape(CornerSizeKt.CornerSize(r1), CornerSizeKt.CornerSize(r2), CornerSizeKt.CornerSize(r3), CornerSizeKt.CornerSize(r4));
    }

    public static /* synthetic */ AbsoluteCutCornerShape AbsoluteCutCornerShape$default(float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = MenuKt.ClosedAlphaTarget;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = MenuKt.ClosedAlphaTarget;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = MenuKt.ClosedAlphaTarget;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = MenuKt.ClosedAlphaTarget;
    L15:
        return AbsoluteCutCornerShape(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: AbsoluteCutCornerShape-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ AbsoluteCutCornerShape m1315AbsoluteCutCornerShapea9UjIt4$default(float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = Dp.constructor-impl(0);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = Dp.constructor-impl(0);
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = Dp.constructor-impl(0);
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = Dp.constructor-impl(0);
    L15:
        return m1314AbsoluteCutCornerShapea9UjIt4(r1, r2, r3, r4);
    }

    public static /* synthetic */ AbsoluteCutCornerShape AbsoluteCutCornerShape$default(int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = 0;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = 0;
    L15:
        return AbsoluteCutCornerShape(r1, r2, r3, r4);
    }
}
