package androidx.compose.foundation.shape;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J?\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H&¢\u0006\u0004\b\u0019\u0010\u001aJ0\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/shape/CornerBasedShape;", "Landroidx/compose/ui/graphics/Shape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "getTopStart", "()Landroidx/compose/foundation/shape/CornerSize;", "getTopEnd", "getBottomEnd", "getBottomStart", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "all", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CornerBasedShape implements Shape {
    public static final int $stable = 0;
    private final CornerSize bottomEnd;
    private final CornerSize bottomStart;
    private final CornerSize topEnd;
    private final CornerSize topStart;

    public abstract CornerBasedShape copy(CornerSize r1, CornerSize r2, CornerSize r3, CornerSize r4);

    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public abstract Outline mo1312createOutlineLjSzlW0(long r1, float r3, float r4, float r5, float r6, LayoutDirection r7);

    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    public final CornerSize getTopStart() {
        return this.topStart;
    }

    public final CornerBasedShape copy(CornerSize r1) {
        return copy(r1, r1, r1, r1);
    }

    /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public final Outline m1320createOutlinePq9zytI(long r10, LayoutDirection r12, Density r13) {
        float r3 = this.topStart.mo1321toPxTmRCtEA(r10, r13);
        float r4 = this.topEnd.mo1321toPxTmRCtEA(r10, r13);
        float r5 = this.bottomEnd.mo1321toPxTmRCtEA(r10, r13);
        float r0 = this.bottomStart.mo1321toPxTmRCtEA(r10, r13);
        float r6 = Size.getMinDimension-impl(r10);
        float r7 = r3 + r0;
        if (r7 <= r6) goto L5;
        float r8 = r6 / r7;
        r3 = r3 * r8;
        r0 = r0 * r8;
    L5:
        float r9 = r0;
        float r1 = r4 + r5;
        if (r1 <= r6) goto L9;
        float r11 = r6 / r1;
        r4 = r4 * r11;
        r5 = r5 * r11;
    L9:
        if (r3 >= MenuKt.ClosedAlphaTarget) goto L11;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == true) goto L21;
        InlineClassHelperKt.throwIllegalArgumentException("Corner size in Px can't be negative(topStart = " + r3 + ", topEnd = " + r4 + ", bottomEnd = " + r5 + ", bottomStart = " + r9 + ")!");
    L21:
        return mo1312createOutlineLjSzlW0(r10, r3, r4, r5, r9, r12);
    L11:
        if (r4 < MenuKt.ClosedAlphaTarget) goto L17;
        if (r5 < MenuKt.ClosedAlphaTarget) goto L17;
        if (r9 < MenuKt.ClosedAlphaTarget) goto L17;
        r2 = true;
        goto L18
    }

    public CornerBasedShape(CornerSize r1, CornerSize r2, CornerSize r3, CornerSize r4) {
        this.topStart = r1;
        this.topEnd = r2;
        this.bottomEnd = r3;
        this.bottomStart = r4;
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape r0, CornerSize r1, CornerSize r2, CornerSize r3, CornerSize r4, int r5, Object r6) {
        if (r6 != null) goto L18;
        if ((r5 & 1) == 0) goto L7;
        r1 = r0.topStart;
    L7:
        if ((r5 & 2) == 0) goto L10;
        r2 = r0.topEnd;
    L10:
        if ((r5 & 4) == 0) goto L13;
        r3 = r0.bottomEnd;
    L13:
        if ((r5 & 8) == 0) goto L16;
        r4 = r0.bottomStart;
    L16:
        return r0.copy(r1, r2, r3, r4);
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }
}
