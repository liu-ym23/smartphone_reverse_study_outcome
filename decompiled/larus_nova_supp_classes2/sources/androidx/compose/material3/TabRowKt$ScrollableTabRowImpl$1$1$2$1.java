package androidx.compose.material3;

import androidx.collection.MutableIntList;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TabRowKt$ScrollableTabRowImpl$1$1$2$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ float $minTabWidth;
    final /* synthetic */ TabRowKt$ScrollableTabRowImpl$1$scope$1$1 $scope;
    final /* synthetic */ ScrollableTabData $scrollableTabData;
    final /* synthetic */ int $selectedTabIndex;

    public TabRowKt$ScrollableTabRowImpl$1$1$2$1(float r1, float r2, TabRowKt$ScrollableTabRowImpl$1$scope$1$1 r3, int r4, ScrollableTabData r5) {
        this.$edgePadding = r1;
        this.$minTabWidth = r2;
        this.$scope = r3;
        this.$selectedTabIndex = r4;
        this.$scrollableTabData = r5;
    }

    public static /* synthetic */ Unit a(Ref.FloatRef r0, float r1, List r2, List r3, ScrollableTabData r4, MeasureScope r5, int r6, List r7, int r8, int r9, Placeable.PlacementScope r10) {
        return measure_3p2s80s$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
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
    public final MeasureResult m3273measure3p2s80s(final MeasureScope r23, List<? extends List<? extends Measurable>> r24, long r25) {
        List r3 = (List) ListProtector.get(r24, 0);
        List r1 = (List) ListProtector.get(r24, 1);
        final int r8 = r23.roundToPx-0680j_4(this.$edgePadding);
        int r5 = r3.size();
        Integer r6 = 0;
        List r7 = r3;
        int r9 = r7.size();
        int r10 = 0;
    L4:
        if (r10 >= r9) goto L6;
        r6 = Integer.valueOf(Math.max(r6.intValue(), ((Measurable) ListProtector.get(r3, r10)).maxIntrinsicHeight(Integer.MAX_VALUE)));
        r10 = r10 + 1;
        goto L4
    L6:
        final int r21 = r6.intValue();
        int r11 = r8 * 2;
        long r12 = Constraints.copy-Zbe2FdA$default(r25, r23.roundToPx-0680j_4(this.$minTabWidth), 0, r21, r21, 2, null);
        Ref.FloatRef r15 = new Ref.FloatRef();
        r15.element = this.$edgePadding;
        ArrayList r13 = new ArrayList(r3.size());
        int r14 = r7.size();
        int r16 = 0;
    L7:
        if (r16 >= r14) goto L9;
        r13.add(((Measurable) ListProtector.get(r3, r16)).measure-BRTryo0(r12));
        r16 = r16 + 1;
        goto L7
    L9:
        MutableIntList r2 = new MutableIntList(0, 1, null);
        int r4 = r7.size();
        int r17 = 0;
    L10:
        if (r17 >= r4) goto L12;
        r2.add(((Measurable) ListProtector.get(r3, r17)).maxIntrinsicWidth(Integer.MAX_VALUE));
        r17 = r17 + 1;
        goto L10
    L12:
        float r18 = this.$minTabWidth;
        final ArrayList r19 = new ArrayList(r5);
        int r110 = r11;
        int r20 = 0;
    L13:
        if (r20 >= r5) goto L15;
        float r22 = ComparisonsKt.maxOf(Dp.box-impl(r18), Dp.box-impl(r23.toDp-u2uoSUM(((Placeable) ListProtector.get(r13, r20)).getWidth()))).unbox-impl();
        r110 = r110 + r23.roundToPx-0680j_4(r22);
        TabPosition r111 = new TabPosition(r15.element, r22, ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(r23.toDp-u2uoSUM(r2.get(r20)) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * 2))), Dp.box-impl(Dp.constructor-impl(24))).unbox-impl(), null);
        r15.element = Dp.constructor-impl(r15.element + r22);
        r19.add(r111);
        r20 = r20 + 1;
        goto L13
    L15:
        this.$scope.setTabPositions(r19);
        int r26 = this.$selectedTabIndex;
        final ArrayList r27 = new ArrayList(r1.size());
        int r28 = r1.size();
        int r29 = 0;
    L16:
        if (r29 >= r28) goto L18;
        r27.add(((Measurable) ListProtector.get(r1, r29)).measure-BRTryo0(Constraints.copy-Zbe2FdA(r25, 0, r23.roundToPx-0680j_4(((TabPosition) ListProtector.get(r19, r26)).m3252getContentWidthD9Ej5fM()), 0, r21)));
        r29 = r29 + 1;
        r13 = r13;
        r15 = r15;
        goto L16
    L18:
        final ArrayList r30 = r13;
        final Ref.FloatRef r112 = r15;
        final float r31 = this.$edgePadding;
        final ScrollableTabData r32 = this.$scrollableTabData;
        final int r113 = this.$selectedTabIndex;
        return MeasureScope.-CC.layout$default(r23, r110, r21, null, new ws(r112, r31, r30, r27, r32, r23, r8, r19, r113, r21), 4, null);
    }

    private static final Unit measure_3p2s80s$lambda$7(Ref.FloatRef r16, float r17, List r18, List r19, ScrollableTabData r20, MeasureScope r21, int r22, List r23, int r24, int r25, Placeable.PlacementScope r26) {
        r16.element = r17;
        int r4 = r18.size();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L5;
        Placeable.PlacementScope.placeRelative$default(r26, (Placeable) ListProtector.get(r18, r6), r21.roundToPx-0680j_4(r16.element), 0, MenuKt.ClosedAlphaTarget, 4, null);
        r16.element = Dp.constructor-impl(r16.element + ((TabPosition) ListProtector.get(r23, r6)).m3255getWidthD9Ej5fM());
        r6 = r6 + 1;
        goto L3
    L5:
        int r0 = r19.size();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        Placeable r10 = (Placeable) ListProtector.get(r19, r1);
        Placeable.PlacementScope.placeRelative$default(r26, r10, Math.max(0, (r21.roundToPx-0680j_4(((TabPosition) ListProtector.get(r23, r24)).m3255getWidthD9Ej5fM()) - r10.getWidth()) / 2), r25 - r10.getHeight(), MenuKt.ClosedAlphaTarget, 4, null);
        r1 = r1 + 1;
        goto L6
    L8:
        r20.onLaidOut(r21, r22, r23, r24);
        return Unit.INSTANCE;
    }
}
