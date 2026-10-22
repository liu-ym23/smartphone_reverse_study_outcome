package androidx.compose.material3;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/EqualWeightContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class EqualWeightContentMeasurePolicy implements MeasurePolicy {
    public EqualWeightContentMeasurePolicy() {
    }

    public static /* synthetic */ Unit a(List r0, Placeable.PlacementScope r1) {
        return measure_3p2s80s$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit b(Placeable.PlacementScope r0) {
        return measure_3p2s80s$lambda$0(r0);
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

    private static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope r0) {
        return Unit.INSTANCE;
    }

    private static final Unit measure_3p2s80s$lambda$5(List r12, Placeable.PlacementScope r13) {
        int r8 = r12.size();
        int r9 = 0;
        int r10 = 0;
    L3:
        if (r9 >= r8) goto L6;
        Placeable r11 = (Placeable) ListProtector.get(r12, r9);
        Placeable.PlacementScope.placeRelative$default(r13, r11, r10, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r10 = r10 + r11.getWidth();
        r9 = r9 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2658measure3p2s80s(MeasureScope r10, List<? extends Measurable> r11, long r12) {
        int r1 = Constraints.getMaxWidth-impl(r12);
        int r2 = Constraints.getMinHeight-impl(r12);
        int r0 = r11.size();
        if (r0 < 1) goto L5;
        int r4 = 0;
        if (Constraints.getHasBoundedWidth-impl(r12) == true) goto L11;
        final ArrayList r3 = new ArrayList(r11.size());
        int r5 = r11.size();
    L9:
        if (r4 >= r5) goto L22;
        r3.add(((Measurable) ListProtector.get(r11, r4)).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r12, Constraints.Companion.fixedHeight-OenEA2s(r2))));
        r4 = r4 + 1;
    L22:
        return MeasureScope.-CC.layout$default(r10, r1, r2, null, new ja(r3), 4, null);
    L11:
        int r6 = r1 / r0;
        List<? extends Measurable> r7 = r11;
        int r8 = r7.size();
        int r9 = 0;
    L12:
        if (r9 >= r8) goto L17;
        int r13 = ((Measurable) ListProtector.get(r11, r9)).maxIntrinsicHeight(r6);
        if (r2 >= r13) goto L16;
        r2 = RangesKt.coerceAtMost(r13, Constraints.getMaxHeight-impl(r12));
    L16:
        r9 = r9 + 1;
        goto L12
    L17:
        ArrayList r14 = new ArrayList(r11.size());
        int r15 = r7.size();
    L18:
        if (r4 >= r15) goto L20;
        r14.add(((Measurable) ListProtector.get(r11, r4)).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r12, Constraints.Companion.fixed-JhjzzOo(r6, r2))));
        r4 = r4 + 1;
        goto L18
    L20:
        r3 = r14;
        goto L22
    L5:
        return MeasureScope.-CC.layout$default(r10, r1, r2, null, new ia(), 4, null);
    }
}
