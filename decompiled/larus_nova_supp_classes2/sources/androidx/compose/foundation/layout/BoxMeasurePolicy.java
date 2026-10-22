package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\b\u001a\u00020\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/BoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "alignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "<init>", "(Landroidx/compose/ui/Alignment;Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BoxMeasurePolicy implements MeasurePolicy {
    private final Alignment alignment;
    private final boolean propagateMinConstraints;

    public static /* synthetic */ Unit a(Placeable[] r0, List r1, MeasureScope r2, Ref.IntRef r3, Ref.IntRef r4, BoxMeasurePolicy r5, Placeable.PlacementScope r6) {
        return measure_3p2s80s$lambda$5(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit b(Placeable.PlacementScope r0) {
        return measure_3p2s80s$lambda$0(r0);
    }

    public static /* synthetic */ Unit c(Placeable r0, Measurable r1, MeasureScope r2, int r3, int r4, BoxMeasurePolicy r5, Placeable.PlacementScope r6) {
        return measure_3p2s80s$lambda$1(r0, r1, r2, r3, r4, r5, r6);
    }

    private final Alignment component1() {
        return this.alignment;
    }

    private final boolean component2() {
        return this.propagateMinConstraints;
    }

    public static /* synthetic */ BoxMeasurePolicy copy$default(BoxMeasurePolicy r0, Alignment r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.alignment;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.propagateMinConstraints;
    L9:
        return r0.copy(r1, r2);
    }

    public final BoxMeasurePolicy copy(Alignment r2, boolean r3) {
        return new BoxMeasurePolicy(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BoxMeasurePolicy) == true) goto L8;
        return false;
    L8:
        BoxMeasurePolicy r6 = (BoxMeasurePolicy) r5;
        if (Intrinsics.areEqual(this.alignment, r6.alignment) == true) goto L12;
        return false;
    L12:
        if (this.propagateMinConstraints == r6.propagateMinConstraints) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.alignment.hashCode() * 31;
        if (this.propagateMinConstraints == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    public String toString() {
        return "BoxMeasurePolicy(alignment=" + this.alignment + ", propagateMinConstraints=" + this.propagateMinConstraints + ')';
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope r0) {
        return Unit.INSTANCE;
    }

    public BoxMeasurePolicy(Alignment r1, boolean r2) {
        this.alignment = r1;
        this.propagateMinConstraints = r2;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m837measure3p2s80s(final MeasureScope r17, final List<? extends Measurable> r18, long r19) {
        if (r18.isEmpty() == false) goto L7;
        return MeasureScope.-CC.layout$default(r17, Constraints.getMinWidth-impl(r19), Constraints.getMinHeight-impl(r19), null, new m(), 4, null);
    L7:
        if (this.propagateMinConstraints == false) goto L9;
        long r0 = r19;
    L10:
        int r5 = 0;
        if (r18.size() != 1) goto L18;
        final Measurable r3 = (Measurable) ListProtector.get(r18, 0);
        if (BoxKt.access$getMatchesParentSize(r3) == true) goto L15;
        Placeable r1 = r3.measure-BRTryo0(r0);
        int r2 = Math.max(Constraints.getMinWidth-impl(r19), r1.getWidth());
        int r4 = Math.max(Constraints.getMinHeight-impl(r19), r1.getHeight());
    L16:
        final int r10 = r2;
        final int r11 = r4;
        final Placeable r6 = r1;
        return MeasureScope.-CC.layout$default(r17, r10, r11, null, new n(r6, r3, r17, r10, r11, this), 4, null);
    L15:
        r2 = Constraints.getMinWidth-impl(r19);
        r4 = Constraints.getMinHeight-impl(r19);
        r1 = r3.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(Constraints.getMinWidth-impl(r19), Constraints.getMinHeight-impl(r19)));
        goto L16
    L18:
        final Placeable[] r7 = new Placeable[r18.size()];
        final Ref.IntRef r8 = new Ref.IntRef();
        r8.element = Constraints.getMinWidth-impl(r19);
        final Ref.IntRef r9 = new Ref.IntRef();
        r9.element = Constraints.getMinHeight-impl(r19);
        List<? extends Measurable> r12 = r18;
        int r13 = r12.size();
        int r14 = 0;
        boolean r15 = false;
    L19:
        if (r14 >= r13) goto L25;
        Measurable r16 = (Measurable) ListProtector.get(r18, r14);
        if (BoxKt.access$getMatchesParentSize(r16) == true) goto L23;
        Placeable r110 = r16.measure-BRTryo0(r0);
        r7[r14] = r110;
        r8.element = Math.max(r8.element, r110.getWidth());
        r9.element = Math.max(r9.element, r110.getHeight());
    L24:
        r14 = r14 + 1;
        goto L19
    L23:
        r15 = true;
        goto L24
    L25:
        if (r15 == false) goto L41;
        int r20 = r8.element;
        if (r20 == Integer.MAX_VALUE) goto L29;
        int r21 = r20;
    L30:
        int r111 = r9.element;
        if (r111 == Integer.MAX_VALUE) goto L33;
        int r22 = r111;
    L34:
        long r23 = ConstraintsKt.Constraints(r21, r20, r22, r111);
        int r24 = r12.size();
    L35:
        if (r5 >= r24) goto L41;
        Measurable r25 = (Measurable) ListProtector.get(r18, r5);
        if (BoxKt.access$getMatchesParentSize(r25) == false) goto L39;
        r7[r5] = r25.measure-BRTryo0(r23);
    L39:
        r5 = r5 + 1;
        goto L35
    L33:
        r22 = 0;
        goto L34
    L29:
        r21 = 0;
    L41:
        return MeasureScope.-CC.layout$default(r17, r8.element, r9.element, null, new o(r7, r18, r17, r8, r9, this), 4, null);
    L9:
        r0 = Constraints.constructor-impl(r19 & (-8589934589L));
        goto L10
    }

    private static final Unit measure_3p2s80s$lambda$1(Placeable r7, Measurable r8, MeasureScope r9, int r10, int r11, BoxMeasurePolicy r12, Placeable.PlacementScope r13) {
        BoxKt.access$placeInBox(r13, r7, r8, r9.getLayoutDirection(), r10, r11, r12.alignment);
        return Unit.INSTANCE;
    }

    private static final Unit measure_3p2s80s$lambda$5(Placeable[] r15, List r16, MeasureScope r17, Ref.IntRef r18, Ref.IntRef r19, BoxMeasurePolicy r20, Placeable.PlacementScope r21) {
        int r1 = r15.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        Placeable r5 = r15[r2];
        int r11 = r3 + 1;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
        BoxKt.access$placeInBox(r21, r5, (Measurable) ListProtector.get(r16, r3), r17.getLayoutDirection(), r18.element, r19.element, r20.alignment);
        r2 = r2 + 1;
        r3 = r11;
        goto L3
    L6:
        return Unit.INSTANCE;
    }
}
