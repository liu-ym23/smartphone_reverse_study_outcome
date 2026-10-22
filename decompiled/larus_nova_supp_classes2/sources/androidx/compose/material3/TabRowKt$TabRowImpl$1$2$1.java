package androidx.compose.material3;

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
public final class TabRowKt$TabRowImpl$1$2$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ TabRowKt$TabRowImpl$1$scope$1$1 $scope;

    public TabRowKt$TabRowImpl$1$2$1(TabRowKt$TabRowImpl$1$scope$1$1 r1) {
        this.$scope = r1;
    }

    public static /* synthetic */ Unit a(List r0, List r1, List r2, Ref.IntRef r3, int r4, Placeable.PlacementScope r5) {
        return measure_3p2s80s$lambda$8(r0, r1, r2, r3, r4, r5);
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
    public final MeasureResult m3274measure3p2s80s(MeasureScope r28, List<? extends List<? extends Measurable>> r29, long r30) {
        List r3 = (List) ListProtector.get(r29, 0);
        List r4 = (List) ListProtector.get(r29, 1);
        int r5 = 2;
        List r1 = (List) ListProtector.get(r29, 2);
        int r6 = Constraints.getMaxWidth-impl(r30);
        int r7 = r3.size();
        final Ref.IntRef r12 = new Ref.IntRef();
        if (r7 <= 0) goto L5;
        r12.element = r6 / r7;
    L5:
        Integer r8 = 0;
        List r9 = r3;
        int r10 = r9.size();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L8;
        Measurable r13 = (Measurable) ListProtector.get(r3, r11);
        r8 = Integer.valueOf(Math.max(r13.maxIntrinsicHeight(r12.element), r8.intValue()));
        r11 = r11 + 1;
        goto L6
    L8:
        final int r14 = r8.intValue();
        TabRowKt$TabRowImpl$1$scope$1$1 r15 = this.$scope;
        ArrayList r16 = new ArrayList(r7);
        int r17 = 0;
    L9:
        if (r17 >= r7) goto L11;
        r16.add(new TabPosition(Dp.constructor-impl(r28.toDp-u2uoSUM(r12.element) * r17), r28.toDp-u2uoSUM(r12.element), ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(r28.toDp-u2uoSUM(Math.min(((Measurable) ListProtector.get(r3, r17)).maxIntrinsicWidth(r14), r12.element)) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * r5))), Dp.box-impl(Dp.constructor-impl(24))).unbox-impl(), null));
        r17 = r17 + 1;
        r7 = r7;
        r5 = 2;
        goto L9
    L11:
        r15.setTabPositions(r16);
        final ArrayList r0 = new ArrayList(r3.size());
        int r2 = r9.size();
        int r18 = 0;
    L12:
        if (r18 >= r2) goto L14;
        Measurable r19 = (Measurable) ListProtector.get(r3, r18);
        int r20 = r12.element;
        r0.add(r19.measure-BRTryo0(Constraints.copy-Zbe2FdA(r30, r20, r20, r14, r14)));
        r18 = r18 + 1;
        goto L12
    L14:
        final ArrayList r21 = new ArrayList(r4.size());
        int r22 = r4.size();
        int r23 = 0;
    L15:
        if (r23 >= r22) goto L17;
        r21.add(((Measurable) ListProtector.get(r4, r23)).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r30, 0, 0, 0, 0, 11, null)));
        r23 = r23 + 1;
        goto L15
    L17:
        final ArrayList r24 = new ArrayList(r1.size());
        int r25 = r1.size();
        int r26 = 0;
    L18:
        if (r26 >= r25) goto L21;
        Measurable r27 = (Measurable) ListProtector.get(r1, r26);
        int r31 = r12.element;
        r24.add(r27.measure-BRTryo0(Constraints.copy-Zbe2FdA(r30, r31, r31, 0, r14)));
        r26 = r26 + 1;
        goto L18
    L21:
        return MeasureScope.-CC.layout$default(r28, r6, r14, null, new at(r0, r21, r24, r12, r14), 4, null);
    }

    private static final Unit measure_3p2s80s$lambda$8(List r14, List r15, List r16, Ref.IntRef r17, int r18, Placeable.PlacementScope r19) {
        int r3 = r14.size();
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        Placeable.PlacementScope.placeRelative$default(r19, (Placeable) ListProtector.get(r14, r5), r5 * r17.element, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r5 = r5 + 1;
        goto L3
    L5:
        int r0 = r15.size();
        int r6 = 0;
    L6:
        if (r6 >= r0) goto L8;
        Placeable r7 = (Placeable) ListProtector.get(r15, r6);
        Placeable.PlacementScope.placeRelative$default(r19, r7, 0, r18 - r7.getHeight(), MenuKt.ClosedAlphaTarget, 4, null);
        r6 = r6 + 1;
        goto L6
    L8:
        int r1 = r16.size();
    L9:
        if (r4 >= r1) goto L12;
        Placeable r8 = (Placeable) ListProtector.get(r16, r4);
        Placeable.PlacementScope.placeRelative$default(r19, r8, 0, r18 - r8.getHeight(), MenuKt.ClosedAlphaTarget, 4, null);
        r4 = r4 + 1;
        goto L9
    L12:
        return Unit.INSTANCE;
    }
}
