package androidx.compose.foundation.text;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/text/LinksTextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LinksTextMeasurePolicy implements MeasurePolicy {
    private final Function0<Boolean> shouldMeasureLinks;

    public static /* synthetic */ Unit a(List r0, LinksTextMeasurePolicy r1, Placeable.PlacementScope r2) {
        return measure_3p2s80s$lambda$1(r0, r1, r2);
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

    public LinksTextMeasurePolicy(Function0<Boolean> r1) {
        this.shouldMeasureLinks = r1;
    }

    private static final Unit measure_3p2s80s$lambda$1(List r10, LinksTextMeasurePolicy r11, Placeable.PlacementScope r12) {
        List r13 = BasicTextKt.access$measureWithTextRangeMeasureConstraints(r10, r11.shouldMeasureLinks);
        if (r13 == null) goto L12;
        int r14 = r13.size();
        int r0 = 0;
    L5:
        if (r0 >= r14) goto L12;
        Pair r1 = (Pair) ListProtector.get(r13, r0);
        Placeable r4 = (Placeable) r1.component1();
        Function0 r2 = (Function0) r1.component2();
        if (r2 == null) goto L9;
        long r3 = ((IntOffset) r2.invoke()).unbox-impl();
    L10:
        Placeable.PlacementScope.place-70tqf50$default(r12, r4, r3, MenuKt.ClosedAlphaTarget, 2, null);
        r0 = r0 + 1;
        goto L5
    L9:
        r3 = IntOffset.Companion.getZero-nOcc-ac();
    L12:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1397measure3p2s80s(MeasureScope r8, final List<? extends Measurable> r9, long r10) {
        return MeasureScope.-CC.layout$default(r8, Constraints.getMaxWidth-impl(r10), Constraints.getMaxHeight-impl(r10), null, new w2(r9, this), 4, null);
    }
}
