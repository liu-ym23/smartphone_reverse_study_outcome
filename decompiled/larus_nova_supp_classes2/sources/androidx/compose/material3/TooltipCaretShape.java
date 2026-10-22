package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/TooltipCaretShape;", "Landroidx/compose/ui/graphics/Shape;", "transformationMatrix", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/Matrix;", "tooltipShape", "caretShape", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;)V", "tooltipPath", "Landroidx/compose/ui/graphics/Path;", "getTooltipPath", "()Landroidx/compose/ui/graphics/Path;", "combinedPath", "getCombinedPath", "caretPath", "getCaretPath", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TooltipCaretShape implements Shape {
    private final Path caretPath;
    private final Shape caretShape;
    private final Path combinedPath;
    private final Path tooltipPath;
    private final Shape tooltipShape;
    private final MutableState<Matrix> transformationMatrix;

    public final Path getCaretPath() {
        return this.caretPath;
    }

    public final Path getCombinedPath() {
        return this.combinedPath;
    }

    public final Path getTooltipPath() {
        return this.tooltipPath;
    }

    public TooltipCaretShape(MutableState<Matrix> r1, Shape r2, Shape r3) {
        this.transformationMatrix = r1;
        this.tooltipShape = r2;
        this.caretShape = r3;
        this.tooltipPath = AndroidPath_androidKt.Path();
        this.combinedPath = AndroidPath_androidKt.Path();
        this.caretPath = AndroidPath_androidKt.Path();
    }

    /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public Outline m3541createOutlinePq9zytI(long r8, LayoutDirection r10, Density r11) {
        this.tooltipPath.reset();
        this.combinedPath.reset();
        this.caretPath.reset();
        Outline.Generic r0 = this.tooltipShape.createOutline-Pq9zytI(r8, r10, r11);
        Outline.Generic r9 = this.caretShape.createOutline-Pq9zytI(r8, r10, r11);
        if ((r0 instanceof Outline.Generic) == false) goto L6;
        Path.-CC.addPath-Uv8p0NA$default(this.tooltipPath, r0.getPath(), 0, 2, null);
    L12:
        if ((r9 instanceof Outline.Generic) == false) goto L15;
        Path.-CC.addPath-Uv8p0NA$default(this.caretPath, r9.getPath(), 0, 2, null);
    L20:
        this.caretPath.transform-58bKbWc(((Matrix) this.transformationMatrix.getValue()).unbox-impl());
        this.combinedPath.op-N5in7k0(this.tooltipPath, this.caretPath, PathOperation.Companion.getUnion-b3I0S0c());
        return new Outline.Generic(this.combinedPath);
    L15:
        if ((r9 instanceof Outline.Rounded) == false) goto L18;
        Path.-CC.addRoundRect$default(this.caretPath, ((Outline.Rounded) r9).getRoundRect(), null, 2, null);
        goto L20
    L18:
        if ((r9 instanceof Outline.Rectangle) == false) goto L23;
        Path.-CC.addRect$default(this.caretPath, ((Outline.Rectangle) r9).getRect(), null, 2, null);
        goto L20
    L23:
        throw new NoWhenBranchMatchedException();
    L6:
        if ((r0 instanceof Outline.Rounded) == false) goto L9;
        Path.-CC.addRoundRect$default(this.tooltipPath, ((Outline.Rounded) r0).getRoundRect(), null, 2, null);
        goto L12
    L9:
        if ((r0 instanceof Outline.Rectangle) == false) goto L25;
        Path.-CC.addRect$default(this.tooltipPath, ((Outline.Rectangle) r0).getRect(), null, 2, null);
        goto L12
    L25:
        throw new NoWhenBranchMatchedException();
    }
}
