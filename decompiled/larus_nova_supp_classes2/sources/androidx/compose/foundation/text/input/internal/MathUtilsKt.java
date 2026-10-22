package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001a#\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001a#\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u000e*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"addExactOrElse", "", "right", "defaultValue", "Lkotlin/Function0;", "subtractExactOrElse", "findClosestRect", "Landroidx/compose/ui/geometry/Offset;", "rect1", "Landroidx/compose/ui/geometry/Rect;", "rect2", "findClosestRect-9KIMszo", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)I", "distanceSquaredToClosestCornerFromOutside", "", "rect", "distanceSquaredToClosestCornerFromOutside-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)F", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MathUtilsKt {
    /* JADX INFO: renamed from: distanceSquaredToClosestCornerFromOutside-3MmeM6k, reason: not valid java name */
    private static final float m1609distanceSquaredToClosestCornerFromOutside3MmeM6k(long r3, Rect r5) {
        if (SelectionManagerKt.m1878containsInclusiveUv8p0NA(r5, r3) == false) goto L6;
        return MenuKt.ClosedAlphaTarget;
    L6:
        float r0 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(r5.getTopLeft-F1C5BW0(), r3));
        if (r0 < Float.MAX_VALUE) goto L10;
        r0 = Float.MAX_VALUE;
    L10:
        float r1 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(r5.getTopRight-F1C5BW0(), r3));
        if (r1 >= r0) goto L13;
        r0 = r1;
    L13:
        float r2 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(r5.getBottomLeft-F1C5BW0(), r3));
        if (r2 >= r0) goto L16;
        r0 = r2;
    L16:
        float r4 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(r5.getBottomRight-F1C5BW0(), r3));
        if (r4 < r0) goto L19;
        return r0;
    L19:
        return r4;
    }

    public static final int addExactOrElse(int r1, int r2, Function0<Integer> r3) {
        int r0 = r1 + r2;
        if (((r1 ^ r0) & (r2 ^ r0)) < 0) goto L5;
        return r0;
    L5:
        return ((Number) r3.invoke()).intValue();
    }

    /* JADX INFO: renamed from: findClosestRect-9KIMszo, reason: not valid java name */
    public static final int m1610findClosestRect9KIMszo(long r0, Rect r2, Rect r3) {
        float r4 = m1609distanceSquaredToClosestCornerFromOutside3MmeM6k(r0, r2);
        float r1 = m1609distanceSquaredToClosestCornerFromOutside3MmeM6k(r0, r3);
        if (r4 != r1) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        return 0;
    L8:
        if (r4 >= r1) goto L11;
        return -1;
    L11:
        return 1;
    L5:
        r5 = false;
        goto L6
    }

    public static final int subtractExactOrElse(int r1, int r2, Function0<Integer> r3) {
        int r0 = r1 - r2;
        int r4 = r2 ^ r1;
        if (((r1 ^ r0) & r4) < 0) goto L5;
        return r0;
    L5:
        return ((Number) r3.invoke()).intValue();
    }
}
