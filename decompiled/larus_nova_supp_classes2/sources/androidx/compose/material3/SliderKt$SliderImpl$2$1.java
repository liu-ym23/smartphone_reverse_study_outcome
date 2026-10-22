package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
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
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SliderKt$SliderImpl$2$1 implements MeasurePolicy {
    final /* synthetic */ SliderState $state;

    public SliderKt$SliderImpl$2$1(SliderState r1) {
        this.$state = r1;
    }

    public static /* synthetic */ Unit a(Placeable r0, int r1, int r2, Placeable r3, int r4, Ref.IntRef r5, Placeable.PlacementScope r6) {
        return measure_3p2s80s$lambda$3(r0, r1, r2, r3, r4, r5, r6);
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
    public final MeasureResult m3179measure3p2s80s(MeasureScope r26, List<? extends Measurable> r27, long r28) {
        List<? extends Measurable> r2 = r27;
        int r3 = r2.size();
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L53;
        Measurable r7 = (Measurable) ListProtector.get(r27, r5);
        boolean r10 = true;
        if (LayoutIdKt.getLayoutId(r7) != SliderComponents.THUMB) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == true) goto L10;
        r5 = r5 + 1;
        goto L4
    L10:
        final Placeable r6 = r7.measure-BRTryo0(r28);
        int r9 = r2.size();
        int r11 = 0;
    L11:
        if (r11 >= r9) goto L50;
        Measurable r12 = (Measurable) ListProtector.get(r27, r11);
        if (LayoutIdKt.getLayoutId(r12) != SliderComponents.TRACK) goto L15;
        boolean r13 = true;
    L16:
        if (r13 == true) goto L17;
        r11 = r11 + 1;
        goto L11
    L17:
        Orientation r1 = this.$state.getOrientation$material3();
        Orientation r14 = Orientation.Vertical;
        if (r1 != r14) goto L20;
        Placeable r15 = r12.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U$default(r28, 0, -r6.getHeight(), 1, null), 0, 0, 0, 0, 14, null));
    L21:
        final Placeable r16 = r15;
        final Ref.IntRef r17 = new Ref.IntRef();
        float r18 = this.$state.getCoercedValueAsFraction();
        if (Intrinsics.areEqual(r18, ArraysKt.firstOrNull(this.$state.getTickFractions$material3())) == false) goto L24;
    L27:
        int r19 = r16.get(SliderKt.getCornerSizeAlignmentLine());
        if (r19 == Integer.MIN_VALUE) goto L31;
        r4 = r19;
    L31:
        if (this.$state.getOrientation$material3() != r14) goto L41;
        int r20 = Math.max(r16.getWidth(), r6.getWidth());
        int r21 = r6.getHeight() + r16.getHeight();
        int r22 = (r20 - r16.getWidth()) / 2;
        int r23 = r6.getHeight() / 2;
        int r24 = (r20 - r6.getWidth()) / 2;
        if (this.$state.getSteps() <= 0) goto L36;
        if (r10 == true) goto L36;
        int r25 = MathKt.roundToInt((r16.getHeight() - (r4 * 2)) * r18) + r4;
    L37:
        r17.element = r25;
        if (this.$state.getReverseVerticalDirection$material3() == false) goto L40;
        r17.element = r16.getHeight() - r17.element;
    L40:
        final int r110 = r22;
        final int r111 = r23;
        final int r112 = r24;
    L47:
        this.$state.updateDimensions$material3(r20, r21);
        return MeasureScope.-CC.layout$default(r26, r20, r21, null, new kq(r16, r110, r111, r6, r112, r17), 4, null);
    L36:
        r25 = MathKt.roundToInt(r16.getHeight() * r18);
        goto L37
    L41:
        r20 = r6.getWidth() + r16.getWidth();
        r21 = Math.max(r16.getHeight(), r6.getHeight());
        int r29 = r6.getWidth() / 2;
        int r30 = (r21 - r16.getHeight()) / 2;
        if (this.$state.getSteps() <= 0) goto L45;
        if (r10 == true) goto L45;
        int r31 = MathKt.roundToInt((r16.getWidth() - (r4 * 2)) * r18) + r4;
    L46:
        r17.element = (r21 - r6.getHeight()) / 2;
        r112 = r31;
        r110 = r29;
        r111 = r30;
    L45:
        r31 = MathKt.roundToInt(r16.getWidth() * r18);
        goto L46
    L24:
        if (Intrinsics.areEqual(r18, ArraysKt.lastOrNull(this.$state.getTickFractions$material3())) == true) goto L27;
        r10 = false;
        goto L27
    L20:
        r15 = r12.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U$default(r28, -r6.getWidth(), 0, 2, null), 0, 0, 0, 0, 11, null));
        goto L21
    L15:
        r13 = false;
        goto L16
    L50:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L8:
        r8 = false;
        goto L9
    L53:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private static final Unit measure_3p2s80s$lambda$3(Placeable r7, int r8, int r9, Placeable r10, int r11, Ref.IntRef r12, Placeable.PlacementScope r13) {
        Placeable.PlacementScope.placeRelative$default(r13, r7, r8, r9, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r13, r10, r11, r12.element, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }
}
