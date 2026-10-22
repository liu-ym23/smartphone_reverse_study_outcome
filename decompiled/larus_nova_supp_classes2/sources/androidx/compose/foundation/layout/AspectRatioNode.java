package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001c\u0010\u001f\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001c\u0010 \u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u001c\u0010\"\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0013\u0010#\u001a\u00020$*\u00020\u0017H\u0002¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010*J\u001b\u0010-\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010*J\u001b\u0010/\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010*R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u00061"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "<init>", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "findSize", "Landroidx/compose/ui/unit/IntSize;", "findSize-ToXhtMw", "(J)J", "tryMaxWidth", "enforceConstraints", "tryMaxWidth-JN-0ABg", "(JZ)J", "tryMaxHeight", "tryMaxHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public static /* synthetic */ Unit a(Placeable r0, Placeable.PlacementScope r1) {
        return measure_3p2s80s$lambda$0(r0, r1);
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    /* JADX INFO: renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m828findSizeToXhtMw(long r8) {
        if (this.matchHeightConstraintsFirst == true) goto L28;
        long r3 = m830tryMaxWidthJN0ABg(r8, true);
        IntSize.Companion r0 = IntSize.Companion;
        if (IntSize.equals-impl0(r3, r0.getZero-YbymL2g()) == true) goto L7;
        return r3;
    L7:
        long r4 = m829tryMaxHeightJN0ABg(r8, true);
        if (IntSize.equals-impl0(r4, r0.getZero-YbymL2g()) == true) goto L10;
        return r4;
    L10:
        long r5 = m832tryMinWidthJN0ABg(r8, true);
        if (IntSize.equals-impl0(r5, r0.getZero-YbymL2g()) == true) goto L13;
        return r5;
    L13:
        long r2 = m831tryMinHeightJN0ABg(r8, true);
        if (IntSize.equals-impl0(r2, r0.getZero-YbymL2g()) == true) goto L16;
        return r2;
    L16:
        long r6 = m830tryMaxWidthJN0ABg(r8, false);
        if (IntSize.equals-impl0(r6, r0.getZero-YbymL2g()) == true) goto L19;
        return r6;
    L19:
        long r7 = m829tryMaxHeightJN0ABg(r8, false);
        if (IntSize.equals-impl0(r7, r0.getZero-YbymL2g()) == true) goto L22;
        return r7;
    L22:
        long r9 = m832tryMinWidthJN0ABg(r8, false);
        if (IntSize.equals-impl0(r9, r0.getZero-YbymL2g()) == true) goto L25;
        return r9;
    L25:
        long r10 = m831tryMinHeightJN0ABg(r8, false);
        if (IntSize.equals-impl0(r10, r0.getZero-YbymL2g()) == true) goto L53;
        return r10;
    L53:
        return IntSize.Companion.getZero-YbymL2g();
    L28:
        long r11 = m829tryMaxHeightJN0ABg(r8, true);
        IntSize.Companion r1 = IntSize.Companion;
        if (IntSize.equals-impl0(r11, r1.getZero-YbymL2g()) == true) goto L31;
        return r11;
    L31:
        long r12 = m830tryMaxWidthJN0ABg(r8, true);
        if (IntSize.equals-impl0(r12, r1.getZero-YbymL2g()) == true) goto L34;
        return r12;
    L34:
        long r13 = m831tryMinHeightJN0ABg(r8, true);
        if (IntSize.equals-impl0(r13, r1.getZero-YbymL2g()) == true) goto L37;
        return r13;
    L37:
        long r14 = m832tryMinWidthJN0ABg(r8, true);
        if (IntSize.equals-impl0(r14, r1.getZero-YbymL2g()) == true) goto L40;
        return r14;
    L40:
        long r15 = m829tryMaxHeightJN0ABg(r8, false);
        if (IntSize.equals-impl0(r15, r1.getZero-YbymL2g()) == true) goto L43;
        return r15;
    L43:
        long r16 = m830tryMaxWidthJN0ABg(r8, false);
        if (IntSize.equals-impl0(r16, r1.getZero-YbymL2g()) == true) goto L46;
        return r16;
    L46:
        long r17 = m831tryMinHeightJN0ABg(r8, false);
        if (IntSize.equals-impl0(r17, r1.getZero-YbymL2g()) == true) goto L49;
        return r17;
    L49:
        long r18 = m832tryMinWidthJN0ABg(r8, false);
        if (IntSize.equals-impl0(r18, r1.getZero-YbymL2g()) == true) goto L53;
        return r18;
    }

    public final void setAspectRatio(float r1) {
        this.aspectRatio = r1;
    }

    public final void setMatchHeightConstraintsFirst(boolean r1) {
        this.matchHeightConstraintsFirst = r1;
    }

    public AspectRatioNode(float r1, boolean r2) {
        this.aspectRatio = r1;
        this.matchHeightConstraintsFirst = r2;
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.placeRelative$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m829tryMaxHeightJN0ABg(long r5, boolean r7) {
        int r0 = Constraints.getMaxHeight-impl(r5);
        if (r0 == Integer.MAX_VALUE) goto L12;
        int r1 = Math.round(r0 * this.aspectRatio);
        if (r1 <= 0) goto L12;
        if (r7 == false) goto L10;
        if (AspectRatioKt.m827isSatisfiedByNN6EwU(r5, r1, r0) == false) goto L12;
    L10:
        return IntSize.constructor-impl((((long) r1) << 32) | (((long) r0) & 4294967295L));
    L12:
        return IntSize.Companion.getZero-YbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m830tryMaxWidthJN0ABg(long r5, boolean r7) {
        int r0 = Constraints.getMaxWidth-impl(r5);
        if (r0 == Integer.MAX_VALUE) goto L12;
        int r1 = Math.round(r0 / this.aspectRatio);
        if (r1 <= 0) goto L12;
        if (r7 == false) goto L10;
        if (AspectRatioKt.m827isSatisfiedByNN6EwU(r5, r0, r1) == false) goto L12;
    L10:
        return IntSize.constructor-impl((((long) r0) << 32) | (((long) r1) & 4294967295L));
    L12:
        return IntSize.Companion.getZero-YbymL2g();
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m831tryMinHeightJN0ABg(long r5, boolean r7) {
        int r0 = Constraints.getMinHeight-impl(r5);
        int r1 = Math.round(r0 * this.aspectRatio);
        if (r1 <= 0) goto L10;
        if (r7 == false) goto L8;
        if (AspectRatioKt.m827isSatisfiedByNN6EwU(r5, r1, r0) == false) goto L10;
    L8:
        return IntSize.constructor-impl((((long) r1) << 32) | (((long) r0) & 4294967295L));
    L10:
        return IntSize.Companion.getZero-YbymL2g();
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m832tryMinWidthJN0ABg(long r5, boolean r7) {
        int r0 = Constraints.getMinWidth-impl(r5);
        int r1 = Math.round(r0 / this.aspectRatio);
        if (r1 <= 0) goto L10;
        if (r7 == false) goto L8;
        if (AspectRatioKt.m827isSatisfiedByNN6EwU(r5, r0, r1) == false) goto L10;
    L8:
        return IntSize.constructor-impl((((long) r0) << 32) | (((long) r1) & 4294967295L));
    L10:
        return IntSize.Companion.getZero-YbymL2g();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        if (r3 == Integer.MAX_VALUE) goto L6;
        return Math.round(r3 / this.aspectRatio);
    L6:
        return r2.maxIntrinsicHeight(r3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        if (r3 == Integer.MAX_VALUE) goto L6;
        return Math.round(r3 * this.aspectRatio);
    L6:
        return r2.maxIntrinsicWidth(r3);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m833measure3p2s80s(MeasureScope r8, Measurable r9, long r10) {
        long r0 = m828findSizeToXhtMw(r10);
        if (IntSize.equals-impl0(r0, IntSize.Companion.getZero-YbymL2g()) == true) goto L5;
        r10 = Constraints.Companion.fixed-JhjzzOo((int) (r0 >> 32), (int) (r0 & 4294967295L));
    L5:
        final Placeable r11 = r9.measure-BRTryo0(r10);
        return MeasureScope.-CC.layout$default(r8, r11.getWidth(), r11.getHeight(), null, new j(r11), 4, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        if (r3 == Integer.MAX_VALUE) goto L6;
        return Math.round(r3 / this.aspectRatio);
    L6:
        return r2.minIntrinsicHeight(r3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        if (r3 == Integer.MAX_VALUE) goto L6;
        return Math.round(r3 * this.aspectRatio);
    L6:
        return r2.minIntrinsicWidth(r3);
    }
}
