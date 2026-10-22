package androidx.compose.foundation.text;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "placements", "", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextMeasurePolicy implements MeasurePolicy {
    private final Function0<List<Rect>> placements;
    private final Function0<Boolean> shouldMeasureLinks;

    public static /* synthetic */ Unit a(List r0, List r1, Placeable.PlacementScope r2) {
        return measure_3p2s80s$lambda$6(r0, r1, r2);
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

    /* JADX WARN: Multi-variable type inference failed */
    public TextMeasurePolicy(Function0<Boolean> r1, Function0<? extends List<Rect>> r2) {
        this.shouldMeasureLinks = r1;
        this.placements = r2;
    }

    private static final Unit measure_3p2s80s$lambda$6(List r12, List r13, Placeable.PlacementScope r14) {
        int r0 = 0;
        if (r12 == null) goto L7;
        int r1 = r12.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        Pair r3 = (Pair) ListProtector.get(r12, r2);
        Placeable.PlacementScope.place-70tqf50$default(r14, (Placeable) r3.component1(), ((IntOffset) r3.component2()).unbox-impl(), MenuKt.ClosedAlphaTarget, 2, null);
        r2 = r2 + 1;
    L7:
        if (r13 == null) goto L16;
        int r15 = r13.size();
    L9:
        if (r0 >= r15) goto L16;
        Pair r4 = (Pair) ListProtector.get(r13, r0);
        Placeable r5 = (Placeable) r4.component1();
        Function0 r6 = (Function0) r4.component2();
        if (r6 == null) goto L13;
        long r7 = ((IntOffset) r6.invoke()).unbox-impl();
    L14:
        Placeable.PlacementScope.place-70tqf50$default(r14, r5, r7, MenuKt.ClosedAlphaTarget, 2, null);
        r0 = r0 + 1;
        goto L9
    L13:
        r7 = IntOffset.Companion.getZero-nOcc-ac();
    L16:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1488measure3p2s80s(MeasureScope r21, List<? extends Measurable> r22, long r23) {
        ArrayList r2 = new ArrayList(r22.size());
        List<? extends Measurable> r3 = r22;
        int r4 = r3.size();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L8;
        Object r7 = ListProtector.get(r22, r6);
        if ((!(((Measurable) r7).getParentData() instanceof TextRangeLayoutModifier)) == false) goto L7;
        r2.add(r7);
    L7:
        r6 = r6 + 1;
        goto L3
    L8:
        List r5 = (List) this.placements.invoke();
        if (r5 == null) goto L21;
        ArrayList r8 = new ArrayList(r5.size());
        int r9 = r5.size();
        int r10 = 0;
    L11:
        if (r10 >= r9) goto L20;
        Rect r11 = (Rect) ListProtector.get(r5, r10);
        if (r11 == null) goto L15;
        Pair r12 = new Pair(((Measurable) ListProtector.get(r2, r10)).measure-BRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(r11.getRight() - r11.getLeft()), 0, (int) Math.floor(r11.getBottom() - r11.getTop()), 5, null)), IntOffset.box-impl(IntOffset.constructor-impl((((long) Math.round(r11.getTop())) & 4294967295L) | (((long) Math.round(r11.getLeft())) << 32))));
    L16:
        ArrayList r13 = r8;
        if (r12 == null) goto L19;
        r13.add(r12);
    L19:
        r10 = r10 + 1;
        r8 = r13;
        goto L11
    L15:
        r12 = null;
        goto L16
    L20:
        final ArrayList r14 = r8;
    L22:
        ArrayList r15 = new ArrayList(r22.size());
        int r16 = r3.size();
        int r17 = 0;
    L23:
        if (r17 >= r16) goto L28;
        Object r18 = ListProtector.get(r22, r17);
        if ((((Measurable) r18).getParentData() instanceof TextRangeLayoutModifier) == false) goto L27;
        r15.add(r18);
    L27:
        r17 = r17 + 1;
        goto L23
    L28:
        final List r1 = BasicTextKt.access$measureWithTextRangeMeasureConstraints(r15, this.shouldMeasureLinks);
        return MeasureScope.-CC.layout$default(r21, Constraints.getMaxWidth-impl(r23), Constraints.getMaxHeight-impl(r23), null, new s4(r14, r1), 4, null);
    L21:
        r14 = null;
        goto L22
    }
}
