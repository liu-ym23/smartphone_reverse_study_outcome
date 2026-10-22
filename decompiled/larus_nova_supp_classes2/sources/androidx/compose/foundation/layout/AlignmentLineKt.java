package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\"\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"paddingFrom", "Landroidx/compose/ui/Modifier;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/Dp;", "after", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "horizontal", "", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AlignmentLineKt {
    public static /* synthetic */ Unit a(AlignmentLine r0, float r1, int r2, int r3, int r4, Placeable r5, int r6, Placeable.PlacementScope r7) {
        return alignmentLineOffsetMeasure_tjqqzMA$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    private static final boolean getHorizontal(AlignmentLine r0) {
        return r0 instanceof HorizontalAlignmentLine;
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m776paddingFromBaselineVpY3zN4(Modifier r7, float r8, float r9) {
        if ((!Float.isNaN(r8)) == false) goto L5;
        Modifier r10 = m773paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), r8, MenuKt.ClosedAlphaTarget, 4, null);
    L6:
        Modifier r11 = r7.then(r10);
        if ((!Float.isNaN(r9)) == false) goto L9;
        Modifier r12 = m773paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), MenuKt.ClosedAlphaTarget, r9, 2, null);
    L11:
        return r11.then(r12);
    L9:
        r12 = Modifier.Companion;
        goto L11
    L5:
        r10 = Modifier.Companion;
        goto L6
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m778paddingFromBaselinewCyjxdI(Modifier r14, long r15, long r17) {
        boolean r2 = true;
        if (TextUnit.getRawType-impl(r15) != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        Modifier r1 = m775paddingFromY_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), r15, 0, 4, null);
    L9:
        Modifier r3 = r14.then(r1);
        if (TextUnit.getRawType-impl(r17) == 0) goto L13;
        r2 = false;
    L13:
        if (r2 == true) goto L15;
        Modifier r4 = m775paddingFromY_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0, r17, 2, null);
    L17:
        return r3.then(r4);
    L15:
        r4 = Modifier.Companion;
        goto L17
    L8:
        r1 = Modifier.Companion;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m772paddingFrom4j6BHR0(Modifier r7, final AlignmentLine r8, final float r9, final float r10) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new AlignmentLineKt$paddingFrom4j6BHR0$$inlined$debugInspectorInfo$1(r8, r9, r10);
    L7:
        return r7.then(new AlignmentLineOffsetDpElement(r8, r9, r10, r0, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m774paddingFromY_r0B1c(Modifier r9, final AlignmentLine r10, final long r11, final long r13) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new AlignmentLineKt$paddingFromY_r0B1c$$inlined$debugInspectorInfo$1(r10, r11, r13);
    L7:
        return r9.then(new AlignmentLineOffsetTextUnitElement(r10, r11, r13, r0, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m777paddingFromBaselineVpY3zN4$default(Modifier r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        return m776paddingFromBaselineVpY3zN4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m779paddingFromBaselinewCyjxdI$default(Modifier r0, long r1, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L9:
        return m778paddingFromBaselinewCyjxdI(r0, r1, r3);
    }

    /* JADX INFO: renamed from: access$alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m770access$alignmentLineOffsetMeasuretjqqzMA(MeasureScope r0, AlignmentLine r1, float r2, float r3, Measurable r4, long r5) {
        return m771alignmentLineOffsetMeasuretjqqzMA(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    private static final MeasureResult m771alignmentLineOffsetMeasuretjqqzMA(MeasureScope r14, final AlignmentLine r15, final float r16, float r17, Measurable r18, long r19) {
        if (getHorizontal(r15) == false) goto L5;
        long r1 = Constraints.copy-Zbe2FdA$default(r19, 0, 0, 0, 0, 11, null);
    L6:
        final Placeable r9 = r18.measure-BRTryo0(r1);
        int r2 = r9.get(r15);
        if (r2 != Integer.MIN_VALUE) goto L11;
        r2 = 0;
    L11:
        if (getHorizontal(r15) == false) goto L13;
        int r3 = r9.getHeight();
    L15:
        if (getHorizontal(r15) == false) goto L17;
        int r5 = Constraints.getMaxHeight-impl(r19);
    L19:
        if ((!Float.isNaN(r16)) == false) goto L21;
        int r7 = r14.roundToPx-0680j_4(r16);
    L22:
        int r6 = r5 - r3;
        final int r8 = RangesKt.coerceIn(r7 - r2, 0, r6);
        if ((!Float.isNaN(r17)) == false) goto L25;
        int r10 = r14.roundToPx-0680j_4(r17);
    L26:
        final int r11 = RangesKt.coerceIn((r10 - r3) + r2, 0, r6 - r8);
        if (getHorizontal(r15) == false) goto L29;
        int r4 = r9.getWidth();
    L31:
        if (getHorizontal(r15) == false) goto L33;
        int r12 = Math.max((r9.getHeight() + r8) + r11, Constraints.getMinHeight-impl(r19));
    L34:
        final int r13 = r12;
        final int r20 = r4;
        return MeasureScope.-CC.layout$default(r14, r4, r13, null, new a(r15, r16, r8, r20, r11, r9, r13), 4, null);
    L33:
        r12 = r9.getHeight();
        goto L34
    L29:
        r4 = Math.max((r9.getWidth() + r8) + r11, Constraints.getMinWidth-impl(r19));
        goto L31
    L25:
        r10 = 0;
        goto L26
    L21:
        r7 = 0;
        goto L22
    L17:
        r5 = Constraints.getMaxWidth-impl(r19);
        goto L19
    L13:
        r3 = r9.getWidth();
        goto L15
    L5:
        r1 = Constraints.copy-Zbe2FdA$default(r19, 0, 0, 0, 0, 14, null);
        goto L6
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m773paddingFrom4j6BHR0$default(Modifier r0, AlignmentLine r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        return m772paddingFrom4j6BHR0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m775paddingFromY_r0B1c$default(Modifier r6, AlignmentLine r7, long r8, long r10, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L5:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        r10 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L9:
        return m774paddingFromY_r0B1c(r6, r7, r2, r10);
    }

    private static final Unit alignmentLineOffsetMeasure_tjqqzMA$lambda$3(AlignmentLine r10, float r11, int r12, int r13, int r14, Placeable r15, int r16, Placeable.PlacementScope r17) {
        if (getHorizontal(r10) == false) goto L6;
        int r5 = 0;
    L10:
        if (getHorizontal(r10) == true) goto L13;
        int r6 = 0;
    L16:
        Placeable.PlacementScope.placeRelative$default(r17, r15, r5, r6, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L13:
        if (Dp.equals-impl0(r11, Dp.Companion.getUnspecified-D9Ej5fM()) == true) goto L15;
        r6 = r12;
        goto L16
    L15:
        r6 = (r16 - r14) - r15.getHeight();
        goto L16
    L6:
        if (Dp.equals-impl0(r11, Dp.Companion.getUnspecified-D9Ej5fM()) == true) goto L8;
        r5 = r12;
        goto L10
    L8:
        r5 = (r13 - r14) - r15.getWidth();
        goto L10
    }
}
