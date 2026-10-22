package androidx.compose.foundation.shape;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/shape/RoundedCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "toString", "", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public String toString() {
        return "RoundedCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RoundedCornerShape) == true) goto L8;
        return false;
    L8:
        RoundedCornerShape r6 = (RoundedCornerShape) r5;
        if (Intrinsics.areEqual(getTopStart(), r6.getTopStart()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getTopEnd(), r6.getTopEnd()) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getBottomEnd(), r6.getBottomEnd()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getBottomStart(), r6.getBottomStart()) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public RoundedCornerShape(CornerSize r1, CornerSize r2, CornerSize r3, CornerSize r4) {
        super(r1, r2, r3, r4);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public RoundedCornerShape copy(CornerSize r2, CornerSize r3, CornerSize r4, CornerSize r5) {
        return new RoundedCornerShape(r2, r3, r4, r5);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public /* bridge */ /* synthetic */ CornerBasedShape copy(CornerSize r1, CornerSize r2, CornerSize r3, CornerSize r4) {
        return copy(r1, r2, r3, r4);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo1312createOutlineLjSzlW0(long r17, float r19, float r20, float r21, float r22, LayoutDirection r23) {
        if ((((r19 + r20) + r21) + r22) != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L26;
        Rect r2 = SizeKt.toRect-uvyYCjk(r17);
        LayoutDirection r3 = LayoutDirection.Ltr;
        if (r23 != r3) goto L11;
        float r4 = r19;
    L12:
        long r5 = CornerRadius.constructor-impl((Float.floatToRawIntBits(r4) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L));
        if (r23 != r3) goto L15;
        float r7 = r20;
    L16:
        long r11 = Float.floatToRawIntBits(r7);
        long r8 = CornerRadius.constructor-impl((((long) Float.floatToRawIntBits(r7)) & 4294967295L) | (r11 << 32));
        if (r23 != r3) goto L19;
        float r12 = r21;
    L20:
        long r13 = CornerRadius.constructor-impl((Float.floatToRawIntBits(r12) << 32) | (Float.floatToRawIntBits(r12) & 4294967295L));
        if (r23 != r3) goto L23;
        float r0 = r22;
    L24:
        long r14 = Float.floatToRawIntBits(r0);
        return new Outline.Rounded(RoundRectKt.RoundRect-ZAM2FJo(r2, r5, r8, r13, CornerRadius.constructor-impl((((long) Float.floatToRawIntBits(r0)) & 4294967295L) | (r14 << 32))));
    L23:
        r0 = r21;
        goto L24
    L19:
        r12 = r22;
        goto L20
    L15:
        r7 = r19;
        goto L16
    L11:
        r4 = r20;
        goto L12
    L26:
        return new Outline.Rectangle(SizeKt.toRect-uvyYCjk(r17));
    L5:
        r1 = false;
        goto L6
    }
}
