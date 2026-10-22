package androidx.compose.material;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ Function0<Float> $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ BottomSheetState $sheetState;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[BottomSheetValue.values().length];
            r0[BottomSheetValue.Collapsed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[BottomSheetValue.Expanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(Function0<Float> r1, int r2, float r3, BottomSheetState r4) {
        this.$sheetOffset = r1;
        this.$floatingActionButtonPosition = r2;
        this.$sheetPeekHeight = r3;
        this.$sheetState = r4;
    }

    public static /* synthetic */ Unit a(Function0 r1, int r2, MeasureScope r3, int r4, int r5, float r6, int r7, int r8, BottomSheetState r9, int r10, int r11, List r12, List r13, List r14, List r15, List r16, int r17, Placeable.PlacementScope r18) {
        return measure_3p2s80s$lambda$15(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m1962measure3p2s80s(final MeasureScope r29, List<? extends List<? extends Measurable>> r30, long r31) {
        List r3 = (List) ListProtector.get(r30, 0);
        List r5 = (List) ListProtector.get(r30, 1);
        List r6 = (List) ListProtector.get(r30, 2);
        List r7 = (List) ListProtector.get(r30, 3);
        List r1 = (List) ListProtector.get(r30, 4);
        final int r26 = Constraints.getMaxWidth-impl(r31);
        final int r27 = Constraints.getMaxHeight-impl(r31);
        long r8 = Constraints.copy-Zbe2FdA$default(r31, 0, 0, 0, 0, 10, null);
        final ArrayList r15 = new ArrayList(r6.size());
        int r10 = r6.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r15.add(((Measurable) ListProtector.get(r6, r11)).measure-BRTryo0(r8));
        r11 = r11 + 1;
        goto L3
    L5:
        final ArrayList r9 = new ArrayList(r3.size());
        int r12 = r3.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L9;
        r9.add(((Measurable) ListProtector.get(r3, r13)).measure-BRTryo0(r8));
        r13 = r13 + 1;
        goto L6
    L9:
        if (r9.isEmpty() == false) goto L11;
        Object r4 = null;
    L19:
        Placeable r14 = (Placeable) r4;
        if (r14 == null) goto L22;
        final int r25 = r14.getHeight();
    L23:
        long r16 = Constraints.copy-Zbe2FdA$default(r8, 0, 0, 0, r27 - r25, 7, null);
        final ArrayList r17 = new ArrayList(r5.size());
        int r18 = r5.size();
        int r19 = 0;
    L24:
        if (r19 >= r18) goto L26;
        r17.add(((Measurable) ListProtector.get(r5, r19)).measure-BRTryo0(r16));
        r19 = r19 + 1;
        goto L24
    L26:
        final ArrayList r20 = new ArrayList(r7.size());
        int r110 = r7.size();
        int r111 = 0;
    L27:
        if (r111 >= r110) goto L30;
        r20.add(((Measurable) ListProtector.get(r7, r111)).measure-BRTryo0(r8));
        r111 = r111 + 1;
        goto L27
    L30:
        if (r20.isEmpty() == false) goto L32;
        Object r21 = null;
    L40:
        Placeable r22 = (Placeable) r21;
        if (r22 == null) goto L43;
        final int r112 = r22.getWidth();
    L45:
        if (r20.isEmpty() == false) goto L47;
        Object r23 = null;
    L55:
        Placeable r24 = (Placeable) r23;
        if (r24 == null) goto L58;
        int r28 = r24.getHeight();
    L59:
        final ArrayList r32 = new ArrayList(r1.size());
        int r113 = r1.size();
        int r114 = 0;
    L60:
        if (r114 >= r113) goto L63;
        r32.add(((Measurable) ListProtector.get(r1, r114)).measure-BRTryo0(r8));
        r114 = r114 + 1;
        goto L60
    L63:
        if (r32.isEmpty() == false) goto L65;
        Object r2 = null;
    L73:
        Placeable r33 = (Placeable) r2;
        if (r33 == null) goto L76;
        final int r115 = r33.getWidth();
    L78:
        if (r32.isEmpty() == false) goto L80;
        Object r116 = null;
    L88:
        Placeable r117 = (Placeable) r116;
        if (r117 == null) goto L91;
        final int r118 = r117.getHeight();
    L92:
        final Function0<Float> r34 = this.$sheetOffset;
        final int r119 = this.$floatingActionButtonPosition;
        final float r120 = this.$sheetPeekHeight;
        final BottomSheetState r35 = this.$sheetState;
        final int r121 = r28;
        return MeasureScope.-CC.layout$default(r29, r26, r27, null, new i2(r34, r119, r29, r26, r112, r120, r121, r115, r35, r118, r27, r17, r9, r15, r20, r32, r25), 4, null);
    L91:
        r118 = 0;
        goto L92
    L80:
        Object r36 = ListProtector.get(r32, 0);
        int r37 = ((Placeable) r36).getHeight();
        int r38 = CollectionsKt.getLastIndex(r32);
        int r122 = 1;
        if (1 > r38) goto L87;
    L82:
        Object r123 = ListProtector.get(r32, r122);
        int r124 = ((Placeable) r123).getHeight();
        if (r37 >= r124) goto L85;
        r36 = r123;
        r37 = r124;
    L85:
        if (r122 == r38) goto L87;
        r122 = r122 + 1;
    L87:
        r116 = r36;
        goto L88
    L76:
        r115 = 0;
        goto L78
    L65:
        r2 = ListProtector.get(r32, 0);
        int r39 = ((Placeable) r2).getWidth();
        int r40 = CollectionsKt.getLastIndex(r32);
        if (1 > r40) goto L73;
        int r125 = 1;
    L68:
        Object r126 = ListProtector.get(r32, r125);
        int r127 = ((Placeable) r126).getWidth();
        if (r39 >= r127) goto L71;
        r2 = r126;
        r39 = r127;
    L71:
        if (r125 == r40) goto L73;
        r125 = r125 + 1;
        goto L68
    L58:
        r28 = 0;
        goto L59
    L47:
        r23 = ListProtector.get(r20, 0);
        int r128 = ((Placeable) r23).getHeight();
        int r129 = CollectionsKt.getLastIndex(r20);
        if (1 > r129) goto L55;
        int r130 = 1;
    L50:
        Object r131 = ListProtector.get(r20, r130);
        int r41 = ((Placeable) r131).getHeight();
        if (r128 >= r41) goto L53;
        r128 = r41;
        r23 = r131;
    L53:
        if (r130 == r129) goto L55;
        r130 = r130 + 1;
        goto L50
    L43:
        r112 = 0;
        goto L45
    L32:
        r21 = ListProtector.get(r20, 0);
        int r132 = ((Placeable) r21).getWidth();
        int r133 = CollectionsKt.getLastIndex(r20);
        if (1 > r133) goto L40;
        int r134 = 1;
    L35:
        Object r135 = ListProtector.get(r20, r134);
        int r136 = ((Placeable) r135).getWidth();
        if (r132 >= r136) goto L38;
        r21 = r135;
        r132 = r136;
    L38:
        if (r134 == r133) goto L40;
        r134 = r134 + 1;
        goto L35
    L22:
        r25 = 0;
        goto L23
    L11:
        r4 = ListProtector.get(r9, 0);
        int r137 = ((Placeable) r4).getHeight();
        int r138 = CollectionsKt.getLastIndex(r9);
        if (1 > r138) goto L19;
        int r139 = 1;
    L14:
        Object r140 = ListProtector.get(r9, r139);
        int r141 = ((Placeable) r140).getHeight();
        if (r137 >= r141) goto L17;
        r137 = r141;
        r4 = r140;
    L17:
        if (r139 == r138) goto L19;
        r139 = r139 + 1;
        goto L14
    }

    private static final Unit measure_3p2s80s$lambda$15(Function0 r17, int r18, MeasureScope r19, int r20, int r21, float r22, int r23, int r24, BottomSheetState r25, int r26, int r27, List r28, List r29, List r30, List r31, List r32, int r33, Placeable.PlacementScope r34) {
        int r7 = MathKt.roundToInt(((Number) r17.invoke()).floatValue());
        FabPosition.Companion r8 = FabPosition.Companion;
        if (FabPosition.m2064equalsimpl0(r18, r8.m2070getStart5ygKITE()) == false) goto L7;
        int r0 = r19.roundToPx-0680j_4(BottomSheetScaffoldKt.access$getFabSpacing$p());
    L10:
        int r9 = r23 / 2;
        if (r19.toPx-0680j_4(r22) >= r9) goto L13;
        int r10 = (r7 - r23) - r19.roundToPx-0680j_4(BottomSheetScaffoldKt.access$getFabSpacing$p());
    L14:
        int r1 = (r20 - r24) / 2;
        int r11 = WhenMappings.$EnumSwitchMapping$0[r25.getCurrentValue().ordinal()];
        if (r11 == 1) goto L20;
        if (r11 != 2) goto L19;
        int r12 = r27 - r26;
    L21:
        int r13 = r28.size();
        int r14 = 0;
        int r15 = 0;
    L22:
        if (r15 >= r13) goto L24;
        Placeable.PlacementScope.placeRelative$default(r34, (Placeable) ListProtector.get(r28, r15), 0, r33, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r15 = r15 + 1;
        goto L22
    L24:
        int r2 = r29.size();
        int r16 = 0;
    L25:
        if (r16 >= r2) goto L27;
        Placeable.PlacementScope.placeRelative$default(r34, (Placeable) ListProtector.get(r29, r16), 0, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r16 = r16 + 1;
        goto L25
    L27:
        int r3 = r30.size();
        int r4 = 0;
    L28:
        if (r4 >= r3) goto L30;
        Placeable.PlacementScope.placeRelative$default(r34, (Placeable) ListProtector.get(r30, r4), 0, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r4 = r4 + 1;
        goto L28
    L30:
        int r5 = r31.size();
        int r6 = 0;
    L31:
        if (r6 >= r5) goto L33;
        Placeable.PlacementScope.placeRelative$default(r34, (Placeable) ListProtector.get(r31, r6), r0, r10, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r6 = r6 + 1;
        goto L31
    L33:
        int r35 = r32.size();
    L34:
        if (r14 >= r35) goto L37;
        Placeable.PlacementScope.placeRelative$default(r34, (Placeable) ListProtector.get(r32, r14), r1, r12, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        r14 = r14 + 1;
        goto L34
    L37:
        return Unit.INSTANCE;
    L19:
        throw new NoWhenBranchMatchedException();
    L20:
        r12 = r10 - r26;
        goto L21
    L13:
        r10 = r7 - r9;
        goto L14
    L7:
        if (FabPosition.m2064equalsimpl0(r18, r8.m2068getCenter5ygKITE()) == false) goto L9;
        r0 = (r20 - r21) / 2;
        goto L10
    L9:
        r0 = (r20 - r21) - r19.roundToPx-0680j_4(BottomSheetScaffoldKt.access$getFabSpacing$p());
        goto L10
    }
}
