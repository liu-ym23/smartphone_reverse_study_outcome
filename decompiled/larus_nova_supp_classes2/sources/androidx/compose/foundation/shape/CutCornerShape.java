package androidx.compose.foundation.shape;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/shape/CutCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "toString", "", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CutCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public String toString() {
        return "CutCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CutCornerShape) == true) goto L8;
        return false;
    L8:
        CutCornerShape r6 = (CutCornerShape) r5;
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

    public CutCornerShape(CornerSize r1, CornerSize r2, CornerSize r3, CornerSize r4) {
        super(r1, r2, r3, r4);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public CutCornerShape copy(CornerSize r2, CornerSize r3, CornerSize r4, CornerSize r5) {
        return new CutCornerShape(r2, r3, r4, r5);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public /* bridge */ /* synthetic */ CornerBasedShape copy(CornerSize r1, CornerSize r2, CornerSize r3, CornerSize r4) {
        return copy(r1, r2, r3, r4);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: createOutline-LjSzlW0 */
    public Outline mo1312createOutlineLjSzlW0(long r7, float r9, float r10, float r11, float r12, LayoutDirection r13) {
        if ((((r9 + r10) + r12) + r11) != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L24;
        Path r1 = AndroidPath_androidKt.Path();
        LayoutDirection r2 = LayoutDirection.Ltr;
        if (r13 != r2) goto L11;
        float r3 = r9;
    L12:
        r1.moveTo(MenuKt.ClosedAlphaTarget, r3);
        r1.lineTo(r3, MenuKt.ClosedAlphaTarget);
        if (r13 != r2) goto L15;
        r9 = r10;
    L15:
        int r14 = (int) (r7 >> 32);
        r1.lineTo(Float.intBitsToFloat(r14) - r9, MenuKt.ClosedAlphaTarget);
        r1.lineTo(Float.intBitsToFloat(r14), r9);
        if (r13 != r2) goto L18;
        float r15 = r11;
    L19:
        int r8 = (int) (r7 & 4294967295L);
        r1.lineTo(Float.intBitsToFloat(r14), Float.intBitsToFloat(r8) - r15);
        r1.lineTo(Float.intBitsToFloat(r14) - r15, Float.intBitsToFloat(r8));
        if (r13 != r2) goto L22;
        r11 = r12;
    L22:
        r1.lineTo(r11, Float.intBitsToFloat(r8));
        r1.lineTo(MenuKt.ClosedAlphaTarget, Float.intBitsToFloat(r8) - r11);
        r1.close();
        return new Outline.Generic(r1);
    L18:
        r15 = r12;
        goto L19
    L11:
        r3 = r10;
        goto L12
    L24:
        return new Outline.Rectangle(SizeKt.toRect-uvyYCjk(r7));
    L5:
        r0 = false;
        goto L6
    }
}
