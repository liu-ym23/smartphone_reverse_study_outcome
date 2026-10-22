package androidx.compose.material3;

import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.internal.SwipeEdge;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsLayerScope;
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
public final class SearchBarKt$FullScreenSearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<BackEventProgress.InProgress> $firstInProgressValue;
    final /* synthetic */ MutableState<BackEventProgress.InProgress> $lastInProgressValue;
    final /* synthetic */ SearchBarState $state;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    public SearchBarKt$FullScreenSearchBarLayout$2$1(MutableState<BackEventProgress.InProgress> r1, SearchBarState r2, MutableWindowInsets r3, MutableState<BackEventProgress.InProgress> r4) {
        this.$lastInProgressValue = r1;
        this.$state = r2;
        this.$unconsumedInsets = r3;
        this.$firstInProgressValue = r4;
    }

    public static /* synthetic */ Unit a(MutableState r0, float r1, SearchBarState r2, Placeable r3, Placeable r4, int r5, Placeable r6, int r7, long r8, MeasureScope r10, int r11, MutableState r12, int r13, int r14, Placeable.PlacementScope r15) {
        return measure_3p2s80s$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit b(SearchBarState r0, GraphicsLayerScope r1) {
        return measure_3p2s80s$lambda$6$lambda$5(r0, r1);
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

    private static final Unit measure_3p2s80s$lambda$6$lambda$5(SearchBarState r0, GraphicsLayerScope r1) {
        r1.setAlpha(r0.getProgress());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m3070measure3p2s80s(final MeasureScope r24, List<? extends Measurable> r25, final long r26) {
        MeasureScope r15 = r24;
        List<? extends Measurable> r1 = r25;
        final float r3 = SearchBarKt.access$transform((BackEventProgress.InProgress) this.$lastInProgressValue.getValue());
        Integer r2 = Integer.valueOf(SearchBarKt.access$getCollapsedBounds(this.$state).getWidth());
        if (r2.intValue() == 0) goto L5;
        boolean r4 = true;
    L6:
        Integer r7 = null;
        if (r4 == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        int r5 = r2.intValue();
    L13:
        Integer r6 = Integer.valueOf(SearchBarKt.access$getCollapsedBounds(this.$state).getHeight());
        if (r6.intValue() == 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
        r7 = r6;
    L19:
        if (r7 == null) goto L21;
        int r9 = r7.intValue();
    L22:
        final int r13 = RangesKt.coerceAtLeast(MathKt.roundToInt(Constraints.getMaxWidth-impl(r26) * 0.9f), r5);
        final int r14 = RangesKt.coerceAtLeast(MathKt.roundToInt(Constraints.getMaxHeight-impl(r26) * 0.9f), r9);
        int r10 = MathHelpersKt.lerp(Constraints.getMaxWidth-impl(r26), r13, r3);
        int r11 = MathHelpersKt.lerp(Constraints.getMaxHeight-impl(r26), r14, r3);
        int r12 = ConstraintsKt.constrainWidth-K40F9xA(r26, MathHelpersKt.lerp(r5, r10, this.$state.getProgress()));
        int r16 = ConstraintsKt.constrainHeight-K40F9xA(r26, MathHelpersKt.lerp(r9, r11, this.$state.getProgress()));
        List<? extends Measurable> r17 = r1;
        int r18 = r17.size();
        int r19 = 0;
    L24:
        if (r19 >= r18) goto L44;
        Measurable r20 = (Measurable) ListProtector.get(r1, r19);
        int r110 = r18;
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r20), "Surface") == true) goto L27;
        r19 = r19 + 1;
        r15 = r24;
        r1 = r25;
        r18 = r110;
        goto L24
    L27:
        final Placeable r21 = r20.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(r12, r16));
        int r22 = r17.size();
        int r23 = 0;
    L28:
        if (r23 >= r22) goto L41;
        Measurable r111 = (Measurable) ListProtector.get(r1, r23);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r111), "InputField") == true) goto L31;
        r23 = r23 + 1;
        r15 = r24;
        r1 = r25;
        goto L28
    L31:
        final Placeable r27 = r111.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(r12, r9));
        int r112 = this.$unconsumedInsets.getTop(r15) + r15.roundToPx-0680j_4(SearchBarKt.getSearchBarVerticalPadding());
        int r28 = r15.roundToPx-0680j_4(SearchBarKt.getSearchBarVerticalPadding());
        final int r29 = MathHelpersKt.lerp(0, r112, Math.min(this.$state.getProgress(), 1 - r3));
        final int r113 = MathHelpersKt.lerp(0, r28, this.$state.getProgress());
        int r30 = (r27.getHeight() + r29) + r113;
        int r31 = r17.size();
        int r114 = 0;
    L32:
        if (r114 >= r31) goto L38;
        Measurable r32 = (Measurable) ListProtector.get(r1, r114);
        int r115 = r31;
        final int r116 = r112;
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r32), "Content") == true) goto L35;
        r114 = r114 + 1;
        r1 = r25;
        r31 = r115;
        r112 = r116;
        goto L32
    L35:
        final Placeable r33 = r32.measure-BRTryo0(ConstraintsKt.Constraints(r12, r12, 0, RangesKt.coerceAtLeast(r16 - r30, 0)));
        int r117 = Constraints.getMaxWidth-impl(r26);
        int r118 = Constraints.getMaxHeight-impl(r26);
        final MutableState<BackEventProgress.InProgress> r34 = this.$lastInProgressValue;
        final SearchBarState r35 = this.$state;
        final MutableState<BackEventProgress.InProgress> r119 = this.$firstInProgressValue;
        return MeasureScope.-CC.layout$default(r24, r117, r118, null, new xm(r34, r3, r35, r21, r27, r29, r33, r113, r26, r24, r13, r119, r14, r116), 4, null);
    L38:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L41:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L44:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L21:
        r9 = r15.roundToPx-0680j_4(SearchBarDefaults.INSTANCE.m3044getInputFieldHeightD9Ej5fM());
        goto L22
    L16:
        r8 = false;
        goto L17
    L12:
        r5 = r15.roundToPx-0680j_4(SearchBarKt.getSearchBarMinWidth());
        goto L13
    L5:
        r4 = false;
        goto L6
    }

    private static final int measure_3p2s80s$lambda$6$endOffsetX(BackEventProgress.InProgress r1, long r2, MeasureScope r4, int r5, SearchBarState r6) {
        if (r1.getSwipeEdge() != SwipeEdge.Left) goto L5;
        int r3 = (Constraints.getMaxWidth-impl(r2) - r4.roundToPx-0680j_4(SearchBarKt.access$getSearchBarPredictiveBackMinMargin$p())) - r5;
    L7:
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r3, SearchBarKt.access$getCollapsedBounds(r6).getRight() - r5), SearchBarKt.access$getCollapsedBounds(r6).getLeft());
    L5:
        r3 = r4.roundToPx-0680j_4(SearchBarKt.access$getSearchBarPredictiveBackMinMargin$p());
        goto L7
    }

    private static final int measure_3p2s80s$lambda$6$endOffsetY(BackEventProgress.InProgress r2, MutableState<BackEventProgress.InProgress> r3, long r4, int r6, MeasureScope r7, int r8, SearchBarState r9) {
        float r5 = r2.getTouchY();
        BackEventProgress.InProgress r10 = (BackEventProgress.InProgress) r3.getValue();
        if (r10 == null) goto L6;
        float r11 = r5 - r10.getTouchY();
        return RangesKt.coerceAtMost((MathHelpersKt.lerp(0, Math.min(RangesKt.coerceAtLeast(((Constraints.getMaxHeight-impl(r4) - r6) / 2) - r7.roundToPx-0680j_4(SearchBarKt.access$getSearchBarPredictiveBackMinMargin$p()), 0), r7.roundToPx-0680j_4(SearchBarKt.access$getSearchBarPredictiveBackMaxOffsetY$p())), Math.abs(r11) / Constraints.getMaxHeight-impl(r4)) * ((int) Math.signum(r11))) + r8, SearchBarKt.access$getCollapsedBounds(r9).getTop());
    L6:
        return 0;
    }

    private static final Unit measure_3p2s80s$lambda$6(MutableState r12, float r13, final SearchBarState r14, Placeable r15, Placeable r16, int r17, Placeable r18, int r19, long r20, MeasureScope r22, int r23, MutableState r24, int r25, int r26, Placeable.PlacementScope r27) {
        BackEventProgress.InProgress r2 = (BackEventProgress.InProgress) r12.getValue();
        if (r2 == null) goto L5;
        int r3 = measure_3p2s80s$lambda$6$endOffsetX(r2, r20, r22, r23, r14);
    L6:
        int r4 = MathHelpersKt.lerp(0, r3, r13);
        BackEventProgress.InProgress r5 = (BackEventProgress.InProgress) r12.getValue();
        if (r5 == null) goto L9;
        int r6 = measure_3p2s80s$lambda$6$endOffsetY(r5, r24, r20, r25, r22, r26, r14);
    L10:
        int r0 = MathHelpersKt.lerp(0, r6, r13);
        int r1 = MathHelpersKt.lerp(SearchBarKt.access$getCollapsedBounds(r14).getLeft(), r4, r14.getProgress());
        int r7 = MathHelpersKt.lerp(SearchBarKt.access$getCollapsedBounds(r14).getTop(), r0, r14.getProgress());
        Placeable.PlacementScope.place$default(r27, r15, r1, r7, MenuKt.ClosedAlphaTarget, 4, null);
        int r8 = r7 + r17;
        Placeable.PlacementScope.place$default(r27, r16, r1, r8, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeWithLayer$default(r27, r18, r1, (r8 + r16.getHeight()) + r19, MenuKt.ClosedAlphaTarget, new wm(r14), 4, null);
        return Unit.INSTANCE;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }
}
