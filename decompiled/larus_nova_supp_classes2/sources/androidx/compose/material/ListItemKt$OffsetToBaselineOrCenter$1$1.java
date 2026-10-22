package androidx.compose.material;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ListItemKt$OffsetToBaselineOrCenter$1$1 implements MeasurePolicy {
    final /* synthetic */ float $offset;

    public ListItemKt$OffsetToBaselineOrCenter$1$1(float r1) {
        this.$offset = r1;
    }

    public static /* synthetic */ Unit a(Placeable r0, int r1, Placeable.PlacementScope r2) {
        return measure_3p2s80s$lambda$0(r0, r1, r2);
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

    private static final Unit measure_3p2s80s$lambda$0(Placeable r7, int r8, Placeable.PlacementScope r9) {
        Placeable.PlacementScope.placeRelative$default(r9, r7, 0, r8, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m2087measure3p2s80s(MeasureScope r11, List<? extends Measurable> r12, long r13) {
        final Placeable r14 = ((Measurable) ListProtector.get(r12, 0)).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r13, 0, 0, 0, 0, 11, null));
        int r1 = r14.get(AlignmentLineKt.getFirstBaseline());
        if (r1 == Integer.MIN_VALUE) goto L5;
        final int r0 = r11.roundToPx-0680j_4(this.$offset) - r1;
        int r15 = Math.max(Constraints.getMinHeight-impl(r13), r14.getHeight() + r0);
    L6:
        int r2 = r14.getWidth();
        return MeasureScope.-CC.layout$default(r11, r2, r15, null, new w5(r14, r0), 4, null);
    L5:
        r15 = Math.max(Constraints.getMinHeight-impl(r13), r14.getHeight());
        r0 = IntOffset.getY-impl(Alignment.Companion.getCenter().align-KFBX0sM(IntSize.Companion.getZero-YbymL2g(), IntSize.constructor-impl((((long) 0) << 32) | (((long) (r15 - r14.getHeight())) & 4294967295L)), r11.getLayoutDirection()));
        goto L6
    }
}
