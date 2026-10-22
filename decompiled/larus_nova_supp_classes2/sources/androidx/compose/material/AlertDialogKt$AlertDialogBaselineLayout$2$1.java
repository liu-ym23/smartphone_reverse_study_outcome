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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class AlertDialogKt$AlertDialogBaselineLayout$2$1 implements MeasurePolicy {
    public static final AlertDialogKt$AlertDialogBaselineLayout$2$1 INSTANCE = null;

    static {
        INSTANCE = new AlertDialogKt$AlertDialogBaselineLayout$2$1();
    }

    public AlertDialogKt$AlertDialogBaselineLayout$2$1() {
    }

    public static /* synthetic */ Unit a(Placeable r0, int r1, Placeable r2, int r3, Placeable.PlacementScope r4) {
        return measure_3p2s80s$lambda$7(r0, r1, r2, r3, r4);
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
    public final MeasureResult m1916measure3p2s80s(MeasureScope r17, List<? extends Measurable> r18, long r19) {
        List<? extends Measurable> r2 = r18;
        int r3 = r2.size();
        int r4 = 0;
        int r5 = 0;
    L3:
        Integer r6 = null;
        if (r5 >= r3) goto L9;
        Object r7 = ListProtector.get(r18, r5);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r7), "title") == true) goto L10;
        r5 = r5 + 1;
    L10:
        Measurable r8 = (Measurable) r7;
        if (r8 == null) goto L13;
        final Placeable r9 = r8.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r19, 0, 0, 0, 0, 11, null));
    L14:
        int r10 = r2.size();
        int r11 = 0;
    L15:
        if (r11 >= r10) goto L20;
        Object r12 = ListProtector.get(r18, r11);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r12), "text") == true) goto L21;
        r11 = r11 + 1;
    L21:
        Measurable r13 = (Measurable) r12;
        if (r13 == null) goto L24;
        final Placeable r1 = r13.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r19, 0, 0, 0, 0, 11, null));
    L25:
        if (r9 == null) goto L27;
        int r14 = r9.getWidth();
    L28:
        if (r1 == null) goto L30;
        int r15 = r1.getWidth();
    L31:
        int r16 = Math.max(r14, r15);
        if (r9 == null) goto L39;
        int r20 = Integer.valueOf(r9.get(AlignmentLineKt.getFirstBaseline())).intValue();
        if (r20 != Integer.MIN_VALUE) goto L36;
        Integer r21 = null;
    L37:
        if (r21 == null) goto L39;
        int r22 = r21.intValue();
    L40:
        if (r9 == null) goto L47;
        int r23 = r9.get(AlignmentLineKt.getLastBaseline());
        if (r23 != Integer.MIN_VALUE) goto L44;
        Integer r24 = null;
    L45:
        if (r24 == null) goto L47;
        int r25 = r24.intValue();
    L48:
        final int r26 = r17.roundToPx--R2X_6o(AlertDialogKt.access$getTitleBaselineDistanceFromTop$p()) - r22;
        if (r1 == null) goto L56;
        int r27 = r1.get(AlignmentLineKt.getFirstBaseline());
        if (r27 == Integer.MIN_VALUE) goto L54;
        r6 = Integer.valueOf(r27);
    L54:
        if (r6 == null) goto L56;
        int r28 = r6.intValue();
    L57:
        if (r9 != null) goto L59;
        int r29 = r17.roundToPx--R2X_6o(AlertDialogKt.access$getTextBaselineDistanceFromTop$p());
    L60:
        if (r9 == null) goto L62;
        int r30 = r9.getHeight() + r26;
    L63:
        if (r9 != null) goto L65;
        final int r110 = r29 - r28;
    L69:
        if (r1 == null) goto L77;
        if (r25 != 0) goto L72;
        r4 = (r1.getHeight() + r29) - r28;
        goto L77
    L72:
        int r111 = (r1.getHeight() + r29) - r28;
        if (r9 == null) goto L75;
        r4 = r9.getHeight();
    L75:
        r4 = r111 - (r4 - r25);
    L77:
        return MeasureScope.-CC.layout$default(r17, r16, r4 + r30, null, new d(r9, r26, r1, r110), 4, null);
    L65:
        if (r25 != 0) goto L67;
        int r112 = r30 - r28;
    L68:
        r110 = r112 + r29;
        goto L69
    L67:
        r112 = (r26 + r25) - r28;
        goto L68
    L62:
        r30 = 0;
        goto L63
    L59:
        r29 = r17.roundToPx--R2X_6o(AlertDialogKt.access$getTextBaselineDistanceFromTitle$p());
    L56:
        r28 = 0;
        goto L57
    L44:
        r24 = Integer.valueOf(r23);
    L47:
        r25 = 0;
        goto L48
    L36:
        r21 = Integer.valueOf(r20);
    L39:
        r22 = 0;
        goto L40
    L30:
        r15 = 0;
        goto L31
    L27:
        r14 = 0;
        goto L28
    L24:
        r1 = null;
        goto L25
    L20:
        r12 = null;
        goto L21
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    }

    private static final Unit measure_3p2s80s$lambda$7(Placeable r14, int r15, Placeable r16, int r17, Placeable.PlacementScope r18) {
        if (r14 == null) goto L4;
        Placeable.PlacementScope.place$default(r18, r14, 0, r15, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    L4:
        if (r16 == null) goto L7;
        Placeable.PlacementScope.place$default(r18, r16, 0, r17, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    L7:
        return Unit.INSTANCE;
    }
}
