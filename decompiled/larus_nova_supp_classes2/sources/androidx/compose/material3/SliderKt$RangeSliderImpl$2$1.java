package androidx.compose.material3;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.ListUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SliderKt$RangeSliderImpl$2$1 implements MeasurePolicy {
    final /* synthetic */ RangeSliderState $state;

    public SliderKt$RangeSliderImpl$2$1(RangeSliderState r1) {
        this.$state = r1;
    }

    public static /* synthetic */ Unit a(Placeable r0, int r1, int r2, Placeable r3, int r4, int r5, Placeable r6, int r7, int r8, Placeable.PlacementScope r9) {
        return measure_3p2s80s$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
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
    public final MeasureResult m3178measure3p2s80s(MeasureScope r30, List<? extends Measurable> r31, long r32) {
        List<? extends Measurable> r4 = r31;
        int r5 = r4.size();
        int r7 = 0;
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L59;
        Measurable r9 = (Measurable) ListProtector.get(r31, r6);
        boolean r12 = true;
        if (LayoutIdKt.getLayoutId(r9) != RangeSliderComponents.STARTTHUMB) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == true) goto L10;
        r6 = r6 + 1;
        goto L4
    L10:
        final Placeable r17 = r9.measure-BRTryo0(r32);
        int r8 = r4.size();
        int r11 = 0;
    L11:
        if (r11 >= r8) goto L56;
        Measurable r13 = (Measurable) ListProtector.get(r31, r11);
        if (LayoutIdKt.getLayoutId(r13) != RangeSliderComponents.ENDTHUMB) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == true) goto L17;
        r11 = r11 + 1;
        goto L11
    L17:
        final Placeable r20 = r13.measure-BRTryo0(r32);
        int r15 = r4.size();
        int r16 = 0;
    L18:
        if (r16 >= r15) goto L53;
        Measurable r18 = (Measurable) ListProtector.get(r31, r16);
        if (LayoutIdKt.getLayoutId(r18) != RangeSliderComponents.TRACK) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == true) goto L24;
        r16 = r16 + 1;
        goto L18
    L24:
        final Placeable r110 = r18.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U$default(r32, (-(r17.getWidth() + r20.getWidth())) / 2, 0, 2, null), 0, 0, 0, 0, 11, null));
        int r1 = r110.getWidth() + ((r17.getWidth() + r20.getWidth()) / 2);
        int r23 = Math.max(r110.getHeight(), Math.max(r17.getHeight(), r20.getHeight()));
        this.$state.setTotalWidth$material3(r1);
        this.$state.updateMinMaxPx$material3();
        float r2 = this.$state.getCoercedActiveRangeStartAsFraction$material3();
        if (Intrinsics.areEqual(r2, ArraysKt.firstOrNull(this.$state.getTickFractions$material3())) == false) goto L27;
    L30:
        boolean r3 = true;
    L31:
        float r21 = this.$state.getCoercedActiveRangeEndAsFraction$material3();
        if (Intrinsics.areEqual(r21, ArraysKt.firstOrNull(this.$state.getTickFractions$material3())) == false) goto L34;
    L37:
        final int r111 = r17.getWidth() / 2;
        int r22 = r110.get(SliderKt.getCornerSizeAlignmentLine());
        if (r22 == Integer.MIN_VALUE) goto L41;
        r7 = r22;
    L41:
        if (this.$state.getSteps() <= 0) goto L44;
        if (r3 == true) goto L44;
        int r24 = MathKt.roundToInt((r110.getWidth() - (r7 * 2)) * r2) + r7;
    L45:
        final int r112 = r24;
        int r25 = (r17.getWidth() - r20.getWidth()) / 2;
        if (this.$state.getSteps() <= 0) goto L49;
        if (r12 == true) goto L49;
        int r26 = MathKt.roundToInt(((r110.getWidth() - (r7 * 2)) * r21) + r25) + r7;
    L50:
        final int r27 = r26;
        final int r113 = (r23 - r110.getHeight()) / 2;
        final int r114 = (r23 - r17.getHeight()) / 2;
        final int r28 = (r23 - r20.getHeight()) / 2;
        return MeasureScope.-CC.layout$default(r30, r1, r23, null, new jq(r110, r111, r113, r17, r112, r114, r20, r27, r28), 4, null);
    L49:
        r26 = MathKt.roundToInt((r110.getWidth() * r21) + r25);
    L44:
        r24 = MathKt.roundToInt(r110.getWidth() * r2);
        goto L45
    L34:
        if (Intrinsics.areEqual(r21, ArraysKt.lastOrNull(this.$state.getTickFractions$material3())) == true) goto L37;
        r12 = false;
        goto L37
    L27:
        if (Intrinsics.areEqual(r2, ArraysKt.lastOrNull(this.$state.getTickFractions$material3())) == true) goto L30;
        r3 = false;
        goto L31
    L22:
        r19 = false;
        goto L23
    L53:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L15:
        r14 = false;
        goto L16
    L56:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L8:
        r10 = false;
        goto L9
    L59:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private static final Unit measure_3p2s80s$lambda$4(Placeable r14, int r15, int r16, Placeable r17, int r18, int r19, Placeable r20, int r21, int r22, Placeable.PlacementScope r23) {
        Placeable.PlacementScope.placeRelative$default(r23, r14, r15, r16, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r23, r17, r18, r19, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r23, r20, r21, r22, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }
}
