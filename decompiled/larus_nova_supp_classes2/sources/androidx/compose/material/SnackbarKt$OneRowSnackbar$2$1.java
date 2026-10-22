package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.ListUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SnackbarKt$OneRowSnackbar$2$1 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $textTag;

    public SnackbarKt$OneRowSnackbar$2$1(String r1, String r2) {
        this.$actionTag = r1;
        this.$textTag = r2;
    }

    public static /* synthetic */ Unit a(Placeable r0, int r1, Placeable r2, int r3, int r4, Placeable.PlacementScope r5) {
        return measure_3p2s80s$lambda$3(r0, r1, r2, r3, r4, r5);
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

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m2157measure3p2s80s(MeasureScope r20, List<? extends Measurable> r21, long r22) {
        String r3 = this.$actionTag;
        List<? extends Measurable> r4 = r21;
        int r5 = r4.size();
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r7 >= r5) goto L33;
        Measurable r9 = (Measurable) ListProtector.get(r21, r7);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r9), r3) == true) goto L7;
        r7 = r7 + 1;
        goto L4
    L7:
        final Placeable r8 = r9.measure-BRTryo0(r22);
        int r10 = RangesKt.coerceAtLeast((Constraints.getMaxWidth-impl(r22) - r8.getWidth()) - r20.roundToPx-0680j_4(SnackbarKt.access$getTextEndExtraSpacing$p()), Constraints.getMinWidth-impl(r22));
        String r11 = this.$textTag;
        int r12 = r4.size();
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L30;
        Measurable r14 = (Measurable) ListProtector.get(r21, r13);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r14), r11) == true) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        final Placeable r15 = r14.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r22, 0, r10, 0, 0, 9, null));
        int r2 = r15.get(AlignmentLineKt.getFirstBaseline());
        int r16 = r15.get(AlignmentLineKt.getLastBaseline());
        boolean r17 = true;
        if (r2 == Integer.MIN_VALUE) goto L15;
        if (r16 == Integer.MIN_VALUE) goto L15;
        boolean r18 = true;
    L16:
        if (r2 == r16) goto L20;
        if (r18 == false) goto L20;
        r17 = false;
    L20:
        final int r19 = Constraints.getMaxWidth-impl(r22) - r8.getWidth();
        if (r17 == false) goto L26;
        int r23 = Math.max(r20.roundToPx-0680j_4(SnackbarKt.access$getSnackbarMinHeightOneLine$p()), r8.getHeight());
        int r24 = (r23 - r15.getHeight()) / 2;
        int r25 = r8.get(AlignmentLineKt.getFirstBaseline());
        if (r25 == Integer.MIN_VALUE) goto L25;
        r6 = (r2 + r24) - r25;
    L25:
        final int r110 = r6;
        final int r111 = r24;
    L27:
        int r26 = Constraints.getMaxWidth-impl(r22);
        Function1 r27 = new ra(r15, r111, r8, r19, r110);
        return MeasureScope.-CC.layout$default(r20, r26, r23, null, r27, 4, null);
    L26:
        int r28 = r20.roundToPx-0680j_4(SnackbarKt.access$getHeightToFirstLine$p()) - r2;
        int r29 = Math.max(r20.roundToPx-0680j_4(SnackbarKt.access$getSnackbarMinHeightTwoLines$p()), r15.getHeight() + r28);
        r111 = r28;
        r110 = (r29 - r8.getHeight()) / 2;
        r23 = r29;
    L15:
        r18 = false;
        goto L16
    L30:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L33:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private static final Unit measure_3p2s80s$lambda$3(Placeable r14, int r15, Placeable r16, int r17, int r18, Placeable.PlacementScope r19) {
        Placeable.PlacementScope.placeRelative$default(r19, r14, 0, r15, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r19, r16, r17, r18, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }
}
