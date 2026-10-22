package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SnackbarKt$TextOnlySnackbar$2$1 implements MeasurePolicy {
    public static final SnackbarKt$TextOnlySnackbar$2$1 INSTANCE = null;

    static {
        INSTANCE = new SnackbarKt$TextOnlySnackbar$2$1();
    }

    public SnackbarKt$TextOnlySnackbar$2$1() {
    }

    public static /* synthetic */ Unit a(ArrayList r0, int r1, Placeable.PlacementScope r2) {
        return measure_3p2s80s$lambda$2(r0, r1, r2);
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

    private static final Unit measure_3p2s80s$lambda$2(ArrayList r10, int r11, Placeable.PlacementScope r12) {
        int r0 = r10.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        Placeable r4 = (Placeable) ListProtector.get(r10, r1);
        Placeable.PlacementScope.placeRelative$default(r12, r4, 0, (r11 - r4.getHeight()) / 2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r1 = r1 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m2158measure3p2s80s(MeasureScope r17, List<? extends Measurable> r18, long r19) {
        final ArrayList r1 = new ArrayList(r18.size());
        int r2 = r18.size();
        boolean r4 = false;
        int r5 = 0;
        int r6 = RtlSpacingHelper.UNDEFINED;
        int r7 = RtlSpacingHelper.UNDEFINED;
        int r8 = 0;
    L3:
        if (r5 >= r2) goto L18;
        Placeable r9 = ((Measurable) ListProtector.get(r18, r5)).measure-BRTryo0(r19);
        r1.add(r9);
        if (r9.get(AlignmentLineKt.getFirstBaseline()) == Integer.MIN_VALUE) goto L11;
        if (r6 != Integer.MIN_VALUE) goto L8;
    L9:
        r6 = r9.get(AlignmentLineKt.getFirstBaseline());
        goto L11
    L8:
        if (r9.get(AlignmentLineKt.getFirstBaseline()) < r6) goto L9;
    L11:
        if (r9.get(AlignmentLineKt.getLastBaseline()) == Integer.MIN_VALUE) goto L16;
        if (r7 != Integer.MIN_VALUE) goto L14;
    L15:
        r7 = r9.get(AlignmentLineKt.getLastBaseline());
        goto L16
    L14:
        if (r9.get(AlignmentLineKt.getLastBaseline()) > r7) goto L15;
    L16:
        r8 = Math.max(r8, r9.getHeight());
        r5 = r5 + 1;
        goto L3
    L18:
        if (r6 == Integer.MIN_VALUE) goto L21;
        if (r7 == Integer.MIN_VALUE) goto L21;
        r4 = true;
    L21:
        if (r6 == r7) goto L25;
        if (r4 == false) goto L25;
        float r0 = SnackbarKt.access$getSnackbarMinHeightTwoLines$p();
    L26:
        final int r3 = Math.max(r17.roundToPx-0680j_4(r0), r8);
        return MeasureScope.-CC.layout$default(r17, Constraints.getMaxWidth-impl(r19), r3, null, new ta(r1, r3), 4, null);
    L25:
        r0 = SnackbarKt.access$getSnackbarMinHeightOneLine$p();
        goto L26
    }
}
