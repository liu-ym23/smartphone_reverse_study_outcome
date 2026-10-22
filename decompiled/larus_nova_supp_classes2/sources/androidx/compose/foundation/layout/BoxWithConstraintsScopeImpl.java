package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0016\u001a\u00020\u0004HÂ\u0003J\u0010\u0010\u0017\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\nJ$\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0097\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\r\u0010&\u001a\u00020\u001d*\u00020\u001dH\u0097\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f¨\u0006)"}, d2 = {"Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/foundation/layout/BoxScope;", "density", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "minWidth", "Landroidx/compose/ui/unit/Dp;", "getMinWidth-D9Ej5fM", "()F", "maxWidth", "getMaxWidth-D9Ej5fM", "minHeight", "getMinHeight-D9Ej5fM", "maxHeight", "getMaxHeight-D9Ej5fM", "component1", "component2", "component2-msEJaDk", "copy", "copy-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "equals", "", "other", "", "hashCode", "", "matchParentSize", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BoxWithConstraintsScopeImpl implements BoxWithConstraintsScope, BoxScope {
    private final /* synthetic */ BoxScopeInstance $$delegate_0;
    private final long constraints;
    private final Density density;

    public /* synthetic */ BoxWithConstraintsScopeImpl(Density r1, long r2, DefaultConstructorMarker r4) {
        this(r1, r2);
    }

    private final Density component1() {
        return this.density;
    }

    /* JADX INFO: renamed from: copy-0kLqBqw$default, reason: not valid java name */
    public static /* synthetic */ BoxWithConstraintsScopeImpl m843copy0kLqBqw$default(BoxWithConstraintsScopeImpl r0, Density r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.density;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.constraints;
    L9:
        return r0.m845copy0kLqBqw(r1, r2);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier align(Modifier r2, Alignment r3) {
        return this.$$delegate_0.align(r2, r3);
    }

    /* JADX INFO: renamed from: component2-msEJaDk, reason: not valid java name */
    public final long m844component2msEJaDk() {
        return this.constraints;
    }

    /* JADX INFO: renamed from: copy-0kLqBqw, reason: not valid java name */
    public final BoxWithConstraintsScopeImpl m845copy0kLqBqw(Density r3, long r4) {
        return new BoxWithConstraintsScopeImpl(r3, r4, null);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof BoxWithConstraintsScopeImpl) == true) goto L8;
        return false;
    L8:
        BoxWithConstraintsScopeImpl r9 = (BoxWithConstraintsScopeImpl) r8;
        if (Intrinsics.areEqual(this.density, r9.density) == true) goto L12;
        return false;
    L12:
        if (Constraints.equals-impl0(this.constraints, r9.constraints) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.density.hashCode() * 31) + Constraints.hashCode-impl(this.constraints);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier matchParentSize(Modifier r2) {
        return this.$$delegate_0.matchParentSize(r2);
    }

    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + Constraints.toString-impl(this.constraints) + ')';
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM */
    public float mo839getMaxHeightD9Ej5fM() {
        Density r0 = this.density;
        if (Constraints.getHasBoundedHeight-impl(mo838getConstraintsmsEJaDk()) == false) goto L6;
        return r0.toDp-u2uoSUM(Constraints.getMaxHeight-impl(mo838getConstraintsmsEJaDk()));
    L6:
        return Dp.Companion.getInfinity-D9Ej5fM();
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM */
    public float mo840getMaxWidthD9Ej5fM() {
        Density r0 = this.density;
        if (Constraints.getHasBoundedWidth-impl(mo838getConstraintsmsEJaDk()) == false) goto L6;
        return r0.toDp-u2uoSUM(Constraints.getMaxWidth-impl(mo838getConstraintsmsEJaDk()));
    L6:
        return Dp.Companion.getInfinity-D9Ej5fM();
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM */
    public float mo841getMinHeightD9Ej5fM() {
        return this.density.toDp-u2uoSUM(Constraints.getMinHeight-impl(mo838getConstraintsmsEJaDk()));
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM */
    public float mo842getMinWidthD9Ej5fM() {
        return this.density.toDp-u2uoSUM(Constraints.getMinWidth-impl(mo838getConstraintsmsEJaDk()));
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    public long mo838getConstraintsmsEJaDk() {
        return this.constraints;
    }

    private BoxWithConstraintsScopeImpl(Density r2, long r3) {
        this.$$delegate_0 = BoxScopeInstance.INSTANCE;
        this.density = r2;
        this.constraints = r3;
    }
}
