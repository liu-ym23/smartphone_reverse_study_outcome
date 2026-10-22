package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SnackbarKt$OneRowSnackbar$2$1 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $dismissActionTag;
    final /* synthetic */ String $textTag;

    public SnackbarKt$OneRowSnackbar$2$1(String r1, String r2, String r3) {
        this.$actionTag = r1;
        this.$dismissActionTag = r2;
        this.$textTag = r3;
    }

    public static /* synthetic */ Unit a(Placeable r0, int r1, Placeable r2, int r3, int r4, Placeable r5, int r6, int r7, Placeable.PlacementScope r8) {
        return measure_3p2s80s$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8);
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
    public final MeasureResult m3200measure3p2s80s(MeasureScope r22, List<? extends Measurable> r23, long r24) {
        int r10 = Math.min(Constraints.getMaxWidth-impl(r24), r22.roundToPx-0680j_4(SnackbarKt.access$getContainerMaxWidth$p()));
        String r5 = this.$actionTag;
        List<? extends Measurable> r6 = r23;
        int r7 = r6.size();
        int r8 = 0;
    L3:
        Placeable r9 = null;
        if (r8 >= r7) goto L9;
        Object r12 = ListProtector.get(r23, r8);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r12), r5) == true) goto L10;
        r8 = r8 + 1;
    L10:
        Measurable r13 = (Measurable) r12;
        if (r13 == null) goto L13;
        Placeable r15 = r13.measure-BRTryo0(r24);
    L14:
        String r11 = this.$dismissActionTag;
        int r14 = r6.size();
        int r16 = 0;
    L15:
        if (r16 >= r14) goto L20;
        Object r17 = ListProtector.get(r23, r16);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r17), r11) == true) goto L21;
        r16 = r16 + 1;
    L21:
        Measurable r18 = (Measurable) r17;
        if (r18 == null) goto L24;
        r9 = r18.measure-BRTryo0(r24);
    L24:
        final Placeable r19 = r9;
        if (r15 == null) goto L27;
        int r110 = r15.getWidth();
    L28:
        if (r15 == null) goto L30;
        int r111 = r15.getHeight();
    L31:
        if (r19 == null) goto L33;
        int r112 = r19.getWidth();
    L34:
        if (r19 == null) goto L36;
        int r20 = r19.getHeight();
    L37:
        if (r112 != 0) goto L39;
        int r21 = r22.roundToPx-0680j_4(SnackbarKt.access$getTextEndExtraSpacing$p());
    L40:
        int r25 = RangesKt.coerceAtLeast(((r10 - r110) - r112) - r21, Constraints.getMinWidth-impl(r24));
        String r26 = this.$textTag;
        int r27 = r6.size();
        int r28 = 0;
    L41:
        if (r28 >= r27) goto L73;
        Measurable r113 = (Measurable) ListProtector.get(r23, r28);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r113), r26) == true) goto L44;
        r28 = r28 + 1;
        r20 = r20;
        goto L41
    L44:
        int r0 = r20;
        final Placeable r2 = r113.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r24, 0, r25, 0, 0, 9, null));
        int r3 = r2.get(AlignmentLineKt.getFirstBaseline());
        int r4 = r2.get(AlignmentLineKt.getLastBaseline());
        boolean r29 = true;
        if (r3 == Integer.MIN_VALUE) goto L48;
        if (r4 == Integer.MIN_VALUE) goto L48;
        boolean r30 = true;
    L49:
        if (r3 == r4) goto L53;
        if (r30 == false) goto L53;
        r29 = false;
    L53:
        final int r31 = r10 - r112;
        final int r114 = r31 - r110;
        if (r29 == false) goto L62;
        int r1 = Math.max(r22.roundToPx-0680j_4(SnackbarTokens.INSTANCE.getSingleLineContainerHeight-D9Ej5fM()), Math.max(r111, r0));
        int r32 = (r1 - r2.getHeight()) / 2;
        if (r15 == null) goto L60;
        int r33 = r15.get(AlignmentLineKt.getFirstBaseline());
        if (r33 == Integer.MIN_VALUE) goto L60;
        int r34 = (r3 + r32) - r33;
    L61:
        final int r210 = r34;
        final int r115 = r32;
        int r35 = r1;
    L67:
        if (r19 == null) goto L69;
        final int r116 = (r35 - r19.getHeight()) / 2;
    L70:
        final Placeable r36 = r15;
        return MeasureScope.-CC.layout$default(r22, r10, r35, null, new br(r2, r115, r19, r31, r116, r36, r114, r210), 4, null);
    L69:
        r116 = 0;
    L60:
        r34 = 0;
        goto L61
    L62:
        int r37 = r22.roundToPx-0680j_4(SnackbarKt.access$getHeightToFirstLine$p()) - r3;
        r35 = Math.max(r22.roundToPx-0680j_4(SnackbarTokens.INSTANCE.getTwoLinesContainerHeight-D9Ej5fM()), r2.getHeight() + r37);
        if (r15 == null) goto L65;
        int r38 = (r35 - r15.getHeight()) / 2;
    L66:
        r115 = r37;
        r210 = r38;
        goto L67
    L65:
        r38 = 0;
    L48:
        r30 = false;
        goto L49
    L73:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L39:
        r21 = 0;
        goto L40
    L36:
        r20 = 0;
        goto L37
    L33:
        r112 = 0;
        goto L34
    L30:
        r111 = 0;
        goto L31
    L27:
        r110 = 0;
        goto L28
    L20:
        r17 = null;
        goto L21
    L13:
        r15 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    }

    private static final Unit measure_3p2s80s$lambda$4(Placeable r14, int r15, Placeable r16, int r17, int r18, Placeable r19, int r20, int r21, Placeable.PlacementScope r22) {
        Placeable.PlacementScope.placeRelative$default(r22, r14, 0, r15, MenuKt.ClosedAlphaTarget, 4, null);
        if (r16 == null) goto L5;
        Placeable.PlacementScope.placeRelative$default(r22, r16, r17, r18, MenuKt.ClosedAlphaTarget, 4, null);
    L5:
        if (r19 == null) goto L8;
        Placeable.PlacementScope.placeRelative$default(r22, r19, r20, r21, MenuKt.ClosedAlphaTarget, 4, null);
    L8:
        return Unit.INSTANCE;
    }
}
