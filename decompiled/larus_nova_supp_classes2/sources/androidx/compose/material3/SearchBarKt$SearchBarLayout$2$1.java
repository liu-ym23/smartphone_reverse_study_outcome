package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SearchBarKt$SearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    public SearchBarKt$SearchBarLayout$2$1(Animatable<Float, AnimationVector1D> r1, MutableWindowInsets r2, MutableState<BackEventCompat> r3, MutableFloatState r4, MutableState<BackEventCompat> r5) {
        this.$animationProgress = r1;
        this.$unconsumedInsets = r2;
        this.$currentBackEvent = r3;
        this.$finalBackProgress = r4;
        this.$firstBackEvent = r5;
    }

    public static /* synthetic */ Unit a(MeasureScope r0, long r1, MutableState r3, float r4, float r5, MutableState r6, int r7, Placeable r8, int r9, Placeable r10, int r11, Placeable r12, int r13, Placeable.PlacementScope r14) {
        return measure_3p2s80s$lambda$3(r0, r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
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
    public final MeasureResult m3071measure3p2s80s(final MeasureScope r24, List<? extends Measurable> r25, final long r26) {
        final float r6 = this.$animationProgress.getValue().floatValue();
        List<? extends Measurable> r2 = r25;
        int r5 = r2.size();
        int r8 = 0;
    L4:
        if (r8 >= r5) goto L32;
        Measurable r10 = (Measurable) ListProtector.get(r25, r8);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r10), "InputField") == true) goto L7;
        r8 = r8 + 1;
        goto L4
    L7:
        int r7 = r2.size();
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L29;
        Measurable r11 = (Measurable) ListProtector.get(r25, r9);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r11), "Surface") == true) goto L11;
        r9 = r9 + 1;
        r24 = r24;
        r26 = r26;
        goto L8
    L11:
        int r3 = r2.size();
        int r12 = 0;
    L12:
        if (r12 >= r3) goto L17;
        Object r13 = ListProtector.get(r25, r12);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r13), "Content") == true) goto L18;
        r12 = r12 + 1;
    L18:
        Measurable r14 = (Measurable) r13;
        final int r15 = this.$unconsumedInsets.getTop(r24) + r24.roundToPx-0680j_4(SearchBarKt.getSearchBarVerticalPadding());
        int r1 = r24.roundToPx-0680j_4(SearchBarKt.getSearchBarVerticalPadding());
        int r4 = ConstraintsKt.constrainWidth-K40F9xA(r26, r10.maxIntrinsicWidth(Constraints.getMaxHeight-impl(r26)));
        int r16 = ConstraintsKt.constrainHeight-K40F9xA(r26, r10.minIntrinsicHeight(Constraints.getMaxWidth-impl(r26)));
        int r17 = MathKt.roundToInt(Constraints.getMaxWidth-impl(r26) * 0.9f);
        int r18 = MathKt.roundToInt(Constraints.getMaxHeight-impl(r26) * 0.9f);
        final float r19 = SearchBarKt.access$calculatePredictiveBackMultiplier((BackEventCompat) this.$currentBackEvent.getValue(), r6, this.$finalBackProgress.getFloatValue());
        int r20 = MathHelpersKt.lerp(r4, r17, r19);
        int r110 = r15 + r16;
        int r21 = MathHelpersKt.lerp(r110, r18, r19);
        int r111 = Constraints.getMaxWidth-impl(r26);
        int r22 = Constraints.getMaxHeight-impl(r26);
        int r23 = MathHelpersKt.lerp(r20, r111, r6);
        final int r112 = MathHelpersKt.lerp(r21, r22, r6);
        final int r113 = MathHelpersKt.lerp(r15, 0, r6);
        final int r27 = MathHelpersKt.lerp(0, r1, r6);
        final Placeable r114 = r10.measure-BRTryo0(ConstraintsKt.Constraints(r23, r111, r16, r16));
        int r115 = r114.getWidth();
        final Placeable r116 = r11.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(r115, r112 - r113));
        if (r14 != null) goto L21;
        Placeable r117 = null;
    L26:
        final MutableState<BackEventCompat> r28 = this.$currentBackEvent;
        final MutableState<BackEventCompat> r29 = this.$firstBackEvent;
        final Placeable r118 = r117;
        return MeasureScope.-CC.layout$default(r24, r115, r112, null, new zm(r24, r26, r28, r6, r19, r29, r112, r116, r113, r114, r15, r118, r27), 4, null);
    L21:
        if (Constraints.getHasBoundedHeight-impl(r26) == false) goto L23;
        int r30 = 0;
        int r31 = RangesKt.coerceAtLeast(Constraints.getMaxHeight-impl(r26) - (r110 + r1), 0);
    L24:
        r117 = r14.measure-BRTryo0(ConstraintsKt.Constraints(r115, r115, r30, r31));
        goto L26
    L23:
        r30 = 0;
        r31 = Constraints.getMaxHeight-impl(r26);
        goto L24
    L17:
        r13 = null;
        goto L18
    L29:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L32:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private static final Unit measure_3p2s80s$lambda$3(MeasureScope r11, long r12, MutableState r14, float r15, float r16, MutableState r17, int r18, Placeable r19, int r20, Placeable r21, int r22, Placeable r23, int r24, Placeable.PlacementScope r25) {
        int r1 = r11.roundToPx-0680j_4(SearchBarKt.access$getSearchBarPredictiveBackMinMargin$p());
        int r10 = SearchBarKt.m3064access$calculatePredictiveBackOffsetXrOvwMX4(r12, r1, (BackEventCompat) r14.getValue(), r11.getLayoutDirection(), r15, r16);
        int r0 = SearchBarKt.m3065access$calculatePredictiveBackOffsetYdzo92Q0(r12, r1, (BackEventCompat) r14.getValue(), (BackEventCompat) r17.getValue(), r18, r11.roundToPx-0680j_4(SearchBarKt.access$getSearchBarPredictiveBackMaxOffsetY$p()), r16);
        Placeable.PlacementScope.placeRelative$default(r25, r19, r10, r0 + r20, MenuKt.ClosedAlphaTarget, 4, null);
        int r2 = r0 + r22;
        Placeable.PlacementScope.placeRelative$default(r25, r21, r10, r2, MenuKt.ClosedAlphaTarget, 4, null);
        if (r23 == null) goto L6;
        Placeable.PlacementScope.placeRelative$default(r25, r23, r10, (r2 + r21.getHeight()) + r24, MenuKt.ClosedAlphaTarget, 4, null);
    L6:
        return Unit.INSTANCE;
    }
}
