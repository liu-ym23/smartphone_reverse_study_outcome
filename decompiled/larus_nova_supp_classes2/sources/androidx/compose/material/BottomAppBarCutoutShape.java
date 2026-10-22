package androidx.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J4\u0010\u0018\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\t\u0010\u001f\u001a\u00020\u0001HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\u001d\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006*"}, d2 = {"Landroidx/compose/material/BottomAppBarCutoutShape;", "Landroidx/compose/ui/graphics/Shape;", "cutoutShape", "fabPlacement", "Landroidx/compose/material/FabPlacement;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/FabPlacement;)V", "getCutoutShape", "()Landroidx/compose/ui/graphics/Shape;", "getFabPlacement", "()Landroidx/compose/material/FabPlacement;", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "addCutoutShape", "", "Landroidx/compose/ui/graphics/Path;", "addRoundedEdges", "cutoutStartPosition", "", "cutoutEndPosition", "cutoutRadius", "roundedEdgeRadius", "verticalOffset", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BottomAppBarCutoutShape implements Shape {
    private final Shape cutoutShape;
    private final FabPlacement fabPlacement;

    public static /* synthetic */ BottomAppBarCutoutShape copy$default(BottomAppBarCutoutShape r0, Shape r1, FabPlacement r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.cutoutShape;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.fabPlacement;
    L9:
        return r0.copy(r1, r2);
    }

    public final Shape component1() {
        return this.cutoutShape;
    }

    public final FabPlacement component2() {
        return this.fabPlacement;
    }

    public final BottomAppBarCutoutShape copy(Shape r2, FabPlacement r3) {
        return new BottomAppBarCutoutShape(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BottomAppBarCutoutShape) == true) goto L8;
        return false;
    L8:
        BottomAppBarCutoutShape r6 = (BottomAppBarCutoutShape) r5;
        if (Intrinsics.areEqual(this.cutoutShape, r6.cutoutShape) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fabPlacement, r6.fabPlacement) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.cutoutShape.hashCode() * 31) + this.fabPlacement.hashCode();
    }

    public String toString() {
        return "BottomAppBarCutoutShape(cutoutShape=" + this.cutoutShape + ", fabPlacement=" + this.fabPlacement + ')';
    }

    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    public final FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    public BottomAppBarCutoutShape(Shape r1, FabPlacement r2) {
        this.cutoutShape = r1;
        this.fabPlacement = r2;
    }

    private final void addCutoutShape(Path r15, LayoutDirection r16, Density r17) {
        float r2 = r17.toPx-0680j_4(AppBarKt.access$getBottomAppBarCutoutOffset$p());
        float r4 = 2 * r2;
        float r3 = this.fabPlacement.getWidth() + r4;
        float r5 = this.fabPlacement.getHeight() + r4;
        long r6 = Size.constructor-impl((Float.floatToRawIntBits(r3) << 32) | (((long) Float.floatToRawIntBits(r5)) & 4294967295L));
        float r7 = this.fabPlacement.getLeft() - r2;
        float r8 = Float.intBitsToFloat((int) (r6 >> 32)) + r7;
        float r9 = Float.intBitsToFloat((int) (r6 & 4294967295L)) / 2.0f;
        OutlineKt.addOutline(r15, this.cutoutShape.createOutline-Pq9zytI(r6, r16, r17));
        r15.translate-k-4lQ0M(Offset.constructor-impl((Float.floatToRawIntBits(r7) << 32) | (((long) Float.floatToRawIntBits(-r9)) & 4294967295L)));
        if (Intrinsics.areEqual(this.cutoutShape, RoundedCornerShapeKt.getCircleShape()) == false) goto L6;
        addRoundedEdges(r15, r7, r8, r9, r17.toPx-0680j_4(AppBarKt.access$getBottomAppBarRoundedEdgeRadius$p()), androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        return;
    }

    /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public Outline m1944createOutlinePq9zytI(long r6, LayoutDirection r8, Density r9) {
        Path r0 = AndroidPath_androidKt.Path();
        Path.-CC.addRect$default(r0, new Rect(androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, Float.intBitsToFloat((int) (r6 >> 32)), Float.intBitsToFloat((int) (r6 & 4294967295L))), null, 2, null);
        Path r7 = AndroidPath_androidKt.Path();
        addCutoutShape(r7, r8, r9);
        r7.op-N5in7k0(r0, r7, PathOperation.Companion.getDifference-b3I0S0c());
        return new Outline.Generic(r7);
    }

    private final void addRoundedEdges(Path r6, float r7, float r8, float r9, float r10, float r11) {
        float r0 = -((float) Math.sqrt((r9 * r9) - (r11 * r11)));
        float r1 = r9 + r0;
        float r2 = r7 + r1;
        float r3 = r8 - r1;
        Pair<Float, Float> r4 = AppBarKt.calculateRoundedEdgeIntercept(r0 - 1.0f, r11, r9);
        float r5 = ((Number) r4.component1()).floatValue() + r9;
        float r12 = ((Number) r4.component2()).floatValue() - r11;
        float r13 = r2 - r10;
        r6.moveTo(r13, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r6.quadraticTo(r2 - 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r7 + r5, r12);
        r6.lineTo(r8 - r5, r12);
        r6.quadraticTo(r3 + 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r10 + r3, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r6.close();
    }
}
