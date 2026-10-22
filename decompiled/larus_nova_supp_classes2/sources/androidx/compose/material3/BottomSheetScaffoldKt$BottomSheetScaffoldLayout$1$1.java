package androidx.compose.material3;

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
    final /* synthetic */ Function0<Float> $sheetOffset;
    final /* synthetic */ SheetState $sheetState;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SheetValue.values().length];
            r0[SheetValue.PartiallyExpanded.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SheetValue.Expanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SheetValue.Hidden.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(SheetState r1, Function0<Float> r2) {
        this.$sheetState = r1;
        this.$sheetOffset = r2;
    }

    public static /* synthetic */ Unit a(List r0, int r1, List r2, SheetState r3, Function0 r4, int r5, List r6, List r7, int r8, Placeable.PlacementScope r9) {
        return measure_3p2s80s$lambda$12(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
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
    public final MeasureResult m2341measure3p2s80s(MeasureScope r28, List<? extends List<? extends Measurable>> r29, long r30) {
        int r2 = 0;
        List r3 = (List) ListProtector.get(r29, 0);
        int r4 = 1;
        List r5 = (List) ListProtector.get(r29, 1);
        List r6 = (List) ListProtector.get(r29, 2);
        List r1 = (List) ListProtector.get(r29, 3);
        final int r17 = Constraints.getMaxWidth-impl(r30);
        final int r18 = Constraints.getMaxHeight-impl(r30);
        long r7 = Constraints.copy-Zbe2FdA$default(r30, 0, 0, 0, 0, 10, null);
        final ArrayList r9 = new ArrayList(r6.size());
        int r10 = r6.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r9.add(((Measurable) ListProtector.get(r6, r11)).measure-BRTryo0(r7));
        r11 = r11 + 1;
        goto L3
    L5:
        final ArrayList r15 = new ArrayList(r3.size());
        int r8 = r3.size();
        int r12 = 0;
    L6:
        if (r12 >= r8) goto L9;
        r15.add(((Measurable) ListProtector.get(r3, r12)).measure-BRTryo0(r7));
        r12 = r12 + 1;
        goto L6
    L9:
        if (r15.isEmpty() == false) goto L11;
        Integer r13 = null;
    L18:
        Integer r14 = r13;
        if (r14 == null) goto L21;
        final int r16 = r14.intValue();
    L22:
        long r19 = Constraints.copy-Zbe2FdA$default(r7, 0, 0, 0, r18 - r16, 7, null);
        final ArrayList r110 = new ArrayList(r5.size());
        int r20 = r5.size();
        int r111 = 0;
    L23:
        if (r111 >= r20) goto L25;
        r110.add(((Measurable) ListProtector.get(r5, r111)).measure-BRTryo0(r19));
        r111 = r111 + 1;
        goto L23
    L25:
        final ArrayList r112 = new ArrayList(r1.size());
        int r21 = r1.size();
    L26:
        if (r2 >= r21) goto L28;
        r112.add(((Measurable) ListProtector.get(r1, r2)).measure-BRTryo0(r7));
        r2 = r2 + 1;
        goto L26
    L28:
        final SheetState r113 = this.$sheetState;
        final Function0<Float> r114 = this.$sheetOffset;
        return MeasureScope.-CC.layout$default(r28, r17, r18, null, new e2(r9, r17, r112, r113, r114, r18, r110, r15, r16), 4, null);
    L21:
        r16 = 0;
        goto L22
    L11:
        r13 = Integer.valueOf(((Placeable) ListProtector.get(r15, 0)).getHeight());
        int r22 = CollectionsKt.getLastIndex(r15);
        if (1 > r22) goto L18;
    L13:
        Integer r115 = Integer.valueOf(((Placeable) ListProtector.get(r15, r4)).getHeight());
        if (r115.compareTo(r13) <= 0) goto L16;
        r13 = r115;
    L16:
        if (r4 == r22) goto L18;
        r4 = r4 + 1;
        goto L13
    }

    private static final Unit measure_3p2s80s$lambda$12(List r18, int r19, List r20, SheetState r21, Function0 r22, int r23, List r24, List r25, int r26, Placeable.PlacementScope r27) {
        Integer r5 = null;
        int r7 = 0;
        if (r18.isEmpty() == false) goto L5;
        Integer r4 = null;
    L13:
        Integer r6 = r4;
        if (r6 == null) goto L16;
        int r8 = r6.intValue();
    L17:
        int r9 = Math.max(0, (r19 - r8) / 2);
        if (r20.isEmpty() == false) goto L20;
        Integer r10 = null;
    L28:
        Integer r11 = r10;
        if (r11 == null) goto L31;
        int r12 = r11.intValue();
    L33:
        if (r20.isEmpty() == true) goto L43;
        r5 = Integer.valueOf(((Placeable) ListProtector.get(r20, 0)).getHeight());
        int r13 = CollectionsKt.getLastIndex(r20);
        if (1 > r13) goto L43;
        int r14 = 1;
    L38:
        Integer r15 = Integer.valueOf(((Placeable) ListProtector.get(r20, r14)).getHeight());
        if (r15.compareTo(r5) <= 0) goto L41;
        r5 = r15;
    L41:
        if (r14 == r13) goto L43;
        r14 = r14 + 1;
    L43:
        Integer r16 = r5;
        if (r16 == null) goto L46;
        int r17 = r16.intValue();
    L47:
        int r110 = (r19 - r12) / 2;
        int r28 = WhenMappings.$EnumSwitchMapping$0[r21.getCurrentValue().ordinal()];
        if (r28 == 1) goto L56;
        if (r28 != 2) goto L51;
    L55:
        int r29 = r23 - r17;
    L57:
        int r30 = r24.size();
        int r31 = 0;
    L58:
        if (r31 >= r30) goto L60;
        Placeable.PlacementScope.placeRelative$default(r27, (Placeable) ListProtector.get(r24, r31), 0, r26, MenuKt.ClosedAlphaTarget, 4, null);
        r31 = r31 + 1;
        goto L58
    L60:
        int r2 = r25.size();
        int r32 = 0;
    L61:
        if (r32 >= r2) goto L63;
        Placeable.PlacementScope.placeRelative$default(r27, (Placeable) ListProtector.get(r25, r32), 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r32 = r32 + 1;
        goto L61
    L63:
        int r3 = r18.size();
        int r33 = 0;
    L64:
        if (r33 >= r3) goto L66;
        Placeable.PlacementScope.placeRelative$default(r27, (Placeable) ListProtector.get(r18, r33), r9, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r33 = r33 + 1;
        goto L64
    L66:
        int r0 = r20.size();
    L67:
        if (r7 >= r0) goto L70;
        Placeable.PlacementScope.placeRelative$default(r27, (Placeable) ListProtector.get(r20, r7), r110, r29, MenuKt.ClosedAlphaTarget, 4, null);
        r7 = r7 + 1;
        goto L67
    L70:
        return Unit.INSTANCE;
    L51:
        if (r28 == 3) goto L55;
        throw new NoWhenBranchMatchedException();
    L56:
        r29 = MathKt.roundToInt(((Number) r22.invoke()).floatValue()) - r17;
        goto L57
    L46:
        r17 = 0;
        goto L47
    L31:
        r12 = 0;
        goto L33
    L20:
        r10 = Integer.valueOf(((Placeable) ListProtector.get(r20, 0)).getWidth());
        int r111 = CollectionsKt.getLastIndex(r20);
        if (1 > r111) goto L28;
        int r112 = 1;
    L23:
        Integer r113 = Integer.valueOf(((Placeable) ListProtector.get(r20, r112)).getWidth());
        if (r113.compareTo(r10) <= 0) goto L26;
        r10 = r113;
    L26:
        if (r112 == r111) goto L28;
        r112 = r112 + 1;
        goto L23
    L16:
        r8 = 0;
        goto L17
    L5:
        r4 = Integer.valueOf(((Placeable) ListProtector.get(r18, 0)).getWidth());
        int r34 = CollectionsKt.getLastIndex(r18);
        if (1 > r34) goto L13;
        int r35 = 1;
    L8:
        Integer r114 = Integer.valueOf(((Placeable) ListProtector.get(r18, r35)).getWidth());
        if (r114.compareTo(r4) <= 0) goto L11;
        r4 = r114;
    L11:
        if (r35 == r34) goto L13;
        r35 = r35 + 1;
        goto L8
    }
}
