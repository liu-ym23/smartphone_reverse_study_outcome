package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.graphics.BezierKt;
import androidx.compose.ui.graphics.IntervalTree;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathIterator;
import androidx.compose.ui.graphics.PathSegment;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/animation/core/PathEasing;", "Landroidx/compose/animation/core/Easing;", "path", "Landroidx/compose/ui/graphics/Path;", "<init>", "(Landroidx/compose/ui/graphics/Path;)V", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "transform", "", "fraction", "initializeEasing", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PathEasing implements Easing {
    public static final int $stable = 0;
    private IntervalTree<PathSegment> intervals;
    private final Path path;

    private final void initializeEasing() {
        float[] r0 = new float[5];
        IntervalTree<PathSegment> r1 = new IntervalTree();
        PathIterator r2 = this.path.iterator(PathIterator.ConicEvaluation.AsQuadratics, 2.0E-4f);
    L3:
        boolean r4 = true;
        if (r2.hasNext() == false) goto L17;
        PathSegment r3 = r2.next();
        if (r3.getType() != PathSegment.Type.Close) goto L9;
        r4 = false;
    L9:
        if (r4 == true) goto L12;
        PreconditionsKt.throwIllegalArgumentException("The path cannot contain a close() command.");
    L12:
        if (r3.getType() == PathSegment.Type.Move) goto L3;
        if (r3.getType() == PathSegment.Type.Done) goto L3;
        long r5 = BezierKt.computeHorizontalBounds$default(r3, r0, 0, 4, null);
        r1.addInterval(Float.intBitsToFloat((int) (r5 >> 32)), Float.intBitsToFloat((int) (r5 & 4294967295L)), r3);
        goto L3
    L17:
        if (r1.contains(MenuKt.ClosedAlphaTarget) == true) goto L19;
    L21:
        r4 = false;
    L22:
        if (r4 == true) goto L24;
        PreconditionsKt.throwIllegalArgumentException("The easing path must start at 0.0f and end at 1.0f.");
    L24:
        this.intervals = r1;
        return;
    L19:
        if (r1.contains(1.0f) == false) goto L21;
        goto L21
    }

    public PathEasing(Path r1) {
        this.path = r1;
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float r5) {
        if (r5 > MenuKt.ClosedAlphaTarget) goto L6;
        return MenuKt.ClosedAlphaTarget;
    L6:
        if (r5 < 1.0f) goto L9;
        return 1.0f;
    L9:
        if (this.intervals != null) goto L11;
        initializeEasing();
    L11:
        IntervalTree<PathSegment> r1 = this.intervals;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("intervals");
        r1 = null;
    L14:
        Object r0 = IntervalTree.findFirstOverlap$default(r1, r5, MenuKt.ClosedAlphaTarget, 2, null).getData();
        if (r0 == null) goto L21;
        PathSegment r2 = (PathSegment) r0;
        float r6 = BezierKt.findFirstRoot(r2, r5);
        if ((!Float.isNaN(r6)) == true) goto L20;
        PreconditionsKt.throwIllegalStateException("The easing path is invalid. Make sure it does not contain NaN/Infinity values.");
    L20:
        return BezierKt.evaluateY(r2, r6);
    L21:
        PreconditionsKt.throwIllegalStateExceptionForNullCheck("The easing path is invalid. Make sure it is continuous on the x axis.");
        throw new KotlinNothingValueException();
    }
}
