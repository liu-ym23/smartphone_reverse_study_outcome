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
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/CenteredContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CenteredContentMeasurePolicy implements MeasurePolicy {
    public CenteredContentMeasurePolicy() {
    }

    public static /* synthetic */ Unit a(Ref.IntRef r0, List r1, Placeable.PlacementScope r2) {
        return measure_3p2s80s$lambda$5(r0, r1, r2);
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

    private static final Unit measure_3p2s80s$lambda$5(Ref.IntRef r11, List r12, Placeable.PlacementScope r13) {
        int r14 = r11.element;
        int r8 = r12.size();
        int r9 = 0;
    L3:
        if (r9 >= r8) goto L6;
        Placeable r10 = (Placeable) ListProtector.get(r12, r9);
        Placeable.PlacementScope.placeRelative$default(r13, r10, r14, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r14 = r14 + r10.getWidth();
        r9 = r9 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2376measure3p2s80s(MeasureScope r16, List<? extends Measurable> r17, long r18) {
        int r3 = Constraints.getMaxWidth-impl(r18);
        int r4 = Constraints.getMinHeight-impl(r18);
        int r5 = r17.size();
        if (r5 < 1) goto L5;
        final Ref.IntRef r6 = new Ref.IntRef();
        int r8 = 0;
        if (Constraints.getHasBoundedWidth-impl(r18) == true) goto L12;
        final ArrayList r7 = new ArrayList(r17.size());
        int r9 = r17.size();
    L9:
        if (r8 >= r9) goto L11;
        r7.add(((Measurable) ListProtector.get(r17, r8)).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r18, Constraints.Companion.fixedHeight-OenEA2s(r4))));
        r8 = r8 + 1;
        goto L9
    L11:
        int r2 = r4;
    L27:
        return MeasureScope.-CC.layout$default(r16, r3, r2, null, new x2(r6, r7), 4, null);
    L12:
        int r10 = r3 / r5;
        int r11 = ShortNavigationBarKt.access$calculateCenteredContentHorizontalPadding(r5, r3);
        r6.element = r11;
        int r12 = (r3 - (r11 * 2)) / r5;
        List<? extends Measurable> r13 = r17;
        int r14 = r13.size();
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L18;
        int r19 = ((Measurable) ListProtector.get(r17, r15)).maxIntrinsicHeight(r12);
        if (r4 >= r19) goto L17;
        r4 = RangesKt.coerceAtMost(r19, Constraints.getMaxHeight-impl(r18));
    L17:
        r15 = r15 + 1;
        goto L13
    L18:
        ArrayList r110 = new ArrayList(r17.size());
        int r20 = r13.size();
    L19:
        if (r8 >= r20) goto L25;
        Measurable r111 = (Measurable) ListProtector.get(r17, r8);
        int r112 = r111.maxIntrinsicWidth(Constraints.getMinHeight-impl(r18));
        if (r12 >= r112) goto L23;
        int r113 = RangesKt.coerceAtMost(r112, r10);
        r6.element -= (r113 - r12) / 2;
    L24:
        r110.add(r111.measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(r18, Constraints.Companion.fixed-JhjzzOo(r113, r4))));
        r8 = r8 + 1;
        goto L19
    L23:
        r113 = r12;
        goto L24
    L25:
        r2 = r4;
        r7 = r110;
        goto L27
    L5:
        return MeasureScope.-CC.layout$default(r16, r3, r4, null, new w2(), 4, null);
    }
}
