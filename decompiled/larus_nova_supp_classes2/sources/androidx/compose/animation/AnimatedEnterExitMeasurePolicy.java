package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\"\u0010\u001d\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\"\u0010\u001f\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\"\u0010 \u001a\u00020\u0019*\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00122\u0006\u0010\u001e\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Landroidx/compose/animation/AnimatedEnterExitMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scope", "Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "<init>", "(Landroidx/compose/animation/AnimatedVisibilityScopeImpl;)V", "getScope", "()Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "hasLookaheadOccurred", "", "getHasLookaheadOccurred", "()Z", "setHasLookaheadOccurred", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    private boolean hasLookaheadOccurred;
    private final AnimatedVisibilityScopeImpl scope;

    public final boolean getHasLookaheadOccurred() {
        return this.hasLookaheadOccurred;
    }

    public final AnimatedVisibilityScopeImpl getScope() {
        return this.scope;
    }

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl r1) {
        this.scope = r1;
    }

    public final void setHasLookaheadOccurred(boolean r1) {
        this.hasLookaheadOccurred = r1;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r4, List<? extends IntrinsicMeasurable> r5, int r6) {
        if (r5.isEmpty() == true) goto L15;
        int r7 = ((IntrinsicMeasurable) ListProtector.get(r5, 0)).maxIntrinsicHeight(r6);
        int r0 = CollectionsKt.getLastIndex(r5);
        int r1 = 1;
        if (1 > r0) goto L13;
    L7:
        int r2 = ((IntrinsicMeasurable) ListProtector.get(r5, r1)).maxIntrinsicHeight(r6);
        if (r2 <= r7) goto L10;
        r7 = r2;
    L10:
        if (r1 == r0) goto L13;
        r1 = r1 + 1;
    L13:
        return r7;
    L15:
        return 0;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r4, List<? extends IntrinsicMeasurable> r5, int r6) {
        if (r5.isEmpty() == true) goto L15;
        int r7 = ((IntrinsicMeasurable) ListProtector.get(r5, 0)).maxIntrinsicWidth(r6);
        int r0 = CollectionsKt.getLastIndex(r5);
        int r1 = 1;
        if (1 > r0) goto L13;
    L7:
        int r2 = ((IntrinsicMeasurable) ListProtector.get(r5, r1)).maxIntrinsicWidth(r6);
        if (r2 <= r7) goto L10;
        r7 = r2;
    L10:
        if (r1 == r0) goto L13;
        r1 = r1 + 1;
    L13:
        return r7;
    L15:
        return 0;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m144measure3p2s80s(MeasureScope r11, List<? extends Measurable> r12, long r13) {
        final ArrayList r0 = new ArrayList(r12.size());
        int r1 = r12.size();
        int r2 = 0;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r2 >= r1) goto L6;
        Placeable r3 = ((Measurable) ListProtector.get(r12, r2)).measure-BRTryo0(r13);
        r4 = Math.max(r4, r3.getWidth());
        r5 = Math.max(r5, r3.getHeight());
        r0.add(r3);
        r2 = r2 + 1;
        goto L3
    L6:
        if (r11.isLookingAhead() == false) goto L9;
        this.hasLookaheadOccurred = true;
        long r14 = 4294967295L & ((long) r5);
        this.scope.getTargetSize$animation().setValue(IntSize.box-impl(IntSize.constructor-impl(r14 | (((long) r4) << 32))));
    L12:
        return MeasureScope.-CC.layout$default(r11, r4, r5, null, new AnimatedEnterExitMeasurePolicy$measure$1(r0), 4, null);
    L9:
        if (this.hasLookaheadOccurred == true) goto L12;
        long r15 = 4294967295L & ((long) r5);
        this.scope.getTargetSize$animation().setValue(IntSize.box-impl(IntSize.constructor-impl(r15 | (((long) r4) << 32))));
        goto L12
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r4, List<? extends IntrinsicMeasurable> r5, int r6) {
        if (r5.isEmpty() == true) goto L15;
        int r7 = ((IntrinsicMeasurable) ListProtector.get(r5, 0)).minIntrinsicHeight(r6);
        int r0 = CollectionsKt.getLastIndex(r5);
        int r1 = 1;
        if (1 > r0) goto L13;
    L7:
        int r2 = ((IntrinsicMeasurable) ListProtector.get(r5, r1)).minIntrinsicHeight(r6);
        if (r2 <= r7) goto L10;
        r7 = r2;
    L10:
        if (r1 == r0) goto L13;
        r1 = r1 + 1;
    L13:
        return r7;
    L15:
        return 0;
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r4, List<? extends IntrinsicMeasurable> r5, int r6) {
        if (r5.isEmpty() == true) goto L15;
        int r7 = ((IntrinsicMeasurable) ListProtector.get(r5, 0)).minIntrinsicWidth(r6);
        int r0 = CollectionsKt.getLastIndex(r5);
        int r1 = 1;
        if (1 > r0) goto L13;
    L7:
        int r2 = ((IntrinsicMeasurable) ListProtector.get(r5, r1)).minIntrinsicWidth(r6);
        if (r2 <= r7) goto L10;
        r7 = r2;
    L10:
        if (r1 == r0) goto L13;
        r1 = r1 + 1;
    L13:
        return r7;
    L15:
        return 0;
    }
}
