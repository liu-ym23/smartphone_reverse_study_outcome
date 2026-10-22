package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ListItemKt$BaselinesOffsetColumn$1$1 implements MeasurePolicy {
    final /* synthetic */ List<Dp> $offsets;

    public ListItemKt$BaselinesOffsetColumn$1$1(List<Dp> r1) {
        this.$offsets = r1;
    }

    public static /* synthetic */ Unit a(List r0, int[] r1, Placeable.PlacementScope r2) {
        return measure_3p2s80s$lambda$4(r0, r1, r2);
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

    private static final Unit measure_3p2s80s$lambda$4(List r10, int[] r11, Placeable.PlacementScope r12) {
        int r0 = r10.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        Placeable.PlacementScope.placeRelative$default(r12, (Placeable) ListProtector.get(r10, r1), 0, r11[r1], androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r1 = r1 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m2086measure3p2s80s(MeasureScope r11, List<? extends Measurable> r12, long r13) {
        long r14 = Constraints.copy-Zbe2FdA$default(r13, 0, 0, 0, Integer.MAX_VALUE, 3, null);
        final ArrayList r0 = new ArrayList(r12.size());
        int r1 = r12.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(((Measurable) ListProtector.get(r12, r3)).measure-BRTryo0(r14));
        r3 = r3 + 1;
        goto L3
    L5:
        Integer r15 = 0;
        int r16 = r0.size();
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L8;
        r15 = Integer.valueOf(Math.max(r15.intValue(), ((Placeable) ListProtector.get(r0, r17)).getWidth()));
        r17 = r17 + 1;
        goto L6
    L8:
        int r4 = r15.intValue();
        final int[] r18 = new int[r0.size()];
        List<Dp> r19 = this.$offsets;
        int r110 = r0.size();
        int r2 = 0;
        int r5 = 0;
    L9:
        if (r2 >= r110) goto L16;
        Placeable r6 = (Placeable) ListProtector.get(r0, r2);
        if (r2 <= 0) goto L13;
        int r7 = r2 - 1;
        int r8 = ((Placeable) ListProtector.get(r0, r7)).getHeight() - ((Placeable) ListProtector.get(r0, r7)).get(AlignmentLineKt.getLastBaseline());
    L14:
        int r9 = Math.max(0, (r11.roundToPx-0680j_4(((Dp) ListProtector.get(r19, r2)).unbox-impl()) - r6.get(AlignmentLineKt.getFirstBaseline())) - r8);
        r18[r2] = r9 + r5;
        r5 = r5 + (r9 + r6.getHeight());
        r2 = r2 + 1;
        goto L9
    L13:
        r8 = 0;
        goto L14
    L16:
        return MeasureScope.-CC.layout$default(r11, r4, r5, null, new v5(r0, r18), 4, null);
    }
}
