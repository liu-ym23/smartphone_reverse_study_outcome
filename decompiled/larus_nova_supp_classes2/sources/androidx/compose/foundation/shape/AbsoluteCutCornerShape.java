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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topLeft", "Landroidx/compose/foundation/shape/CornerSize;", "topRight", "bottomRight", "bottomLeft", "<init>", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "topStart", "", "topEnd", "bottomEnd", "bottomStart", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "copy", "toString", "", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AbsoluteCutCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public String toString() {
        return "AbsoluteCutCornerShape(topLeft = " + getTopStart() + ", topRight = " + getTopEnd() + ", bottomRight = " + getBottomEnd() + ", bottomLeft = " + getBottomStart() + ')';
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AbsoluteCutCornerShape) == true) goto L8;
        return false;
    L8:
        AbsoluteCutCornerShape r6 = (AbsoluteCutCornerShape) r5;
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

    public AbsoluteCutCornerShape(CornerSize r1, CornerSize r2, CornerSize r3, CornerSize r4) {
        super(r1, r2, r3, r4);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public AbsoluteCutCornerShape copy(CornerSize r2, CornerSize r3, CornerSize r4, CornerSize r5) {
        return new AbsoluteCutCornerShape(r2, r3, r4, r5);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public /* bridge */ /* synthetic */ CornerBasedShape copy(CornerSize r1, CornerSize r2, CornerSize r3, CornerSize r4) {
        return copy(r1, r2, r3, r4);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* JADX INFO: renamed from: createOutline-LjSzlW0, reason: not valid java name */
    public Outline mo1312createOutlineLjSzlW0(long r4, float r6, float r7, float r8, float r9, LayoutDirection r10) {
        if ((((r6 + r7) + r9) + r8) != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L10;
        Path r12 = AndroidPath_androidKt.Path();
        r12.moveTo(MenuKt.ClosedAlphaTarget, r6);
        r12.lineTo(r6, MenuKt.ClosedAlphaTarget);
        int r13 = (int) (r4 >> 32);
        r12.lineTo(Float.intBitsToFloat(r13) - r7, MenuKt.ClosedAlphaTarget);
        r12.lineTo(Float.intBitsToFloat(r13), r7);
        int r5 = (int) (r4 & 4294967295L);
        r12.lineTo(Float.intBitsToFloat(r13), Float.intBitsToFloat(r5) - r8);
        r12.lineTo(Float.intBitsToFloat(r13) - r8, Float.intBitsToFloat(r5));
        r12.lineTo(r9, Float.intBitsToFloat(r5));
        r12.lineTo(MenuKt.ClosedAlphaTarget, Float.intBitsToFloat(r5) - r9);
        r12.close();
        return new Outline.Generic(r12);
    L10:
        return new Outline.Rectangle(SizeKt.toRect-uvyYCjk(r4));
    L5:
        r11 = false;
        goto L6
    }
}
