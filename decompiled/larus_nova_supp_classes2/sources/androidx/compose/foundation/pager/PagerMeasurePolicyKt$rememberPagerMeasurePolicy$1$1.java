package androidx.compose.foundation.pager;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ int $beyondViewportPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function0<PagerLazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function0<Integer> $pageCount;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ SnapPosition $snapPosition;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    public PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(PagerState r1, Orientation r2, PaddingValues r3, boolean r4, float r5, PageSize r6, Function0<PagerLazyLayoutItemProvider> r7, Function0<Integer> r8, Alignment.Vertical r9, Alignment.Horizontal r10, int r11, SnapPosition r12, CoroutineScope r13) {
        this.$state = r1;
        this.$orientation = r2;
        this.$contentPadding = r3;
        this.$reverseLayout = r4;
        this.$pageSpacing = r5;
        this.$pageSize = r6;
        this.$itemProviderLambda = r7;
        this.$pageCount = r8;
        this.$verticalAlignment = r9;
        this.$horizontalAlignment = r10;
        this.$beyondViewportPageCount = r11;
        this.$snapPosition = r12;
        this.$coroutineScope = r13;
    }

    public static /* synthetic */ MeasureResult a(LazyLayoutMeasureScope r0, long r1, int r3, int r4, int r5, int r6, Function1 r7) {
        return measure_0kLqBqw$lambda$2(r0, r1, r3, r4, r5, r6, r7);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* JADX INFO: renamed from: measure-0kLqBqw */
    public final MeasureResult mo1082measure0kLqBqw(final LazyLayoutMeasureScope r44, final long r45) {
        ObservableScopeInvalidator.m1184attachToScopeimpl(this.$state.m1265getMeasurementScopeInvalidatorzYiylxw$foundation_release());
        Orientation r2 = this.$orientation;
        Orientation r3 = Orientation.Vertical;
        if (r2 != r3) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        Orientation r7 = r3;
    L9:
        CheckScrollableContainerConstraintsKt.m370checkScrollableContainerConstraintsK40F9xA(r45, r7);
        if (r4 == false) goto L12;
        int r8 = r44.roundToPx-0680j_4(this.$contentPadding.mo899calculateLeftPaddingu2uoSUM(r44.getLayoutDirection()));
    L13:
        if (r4 == false) goto L15;
        int r9 = r44.roundToPx-0680j_4(this.$contentPadding.mo900calculateRightPaddingu2uoSUM(r44.getLayoutDirection()));
    L16:
        int r10 = r44.roundToPx-0680j_4(this.$contentPadding.mo901calculateTopPaddingD9Ej5fM());
        int r11 = r44.roundToPx-0680j_4(this.$contentPadding.mo898calculateBottomPaddingD9Ej5fM());
        final int r12 = r10 + r11;
        final int r13 = r8 + r9;
        if (r4 == false) goto L19;
        int r14 = r12;
    L20:
        if (r4 == true) goto L22;
    L24:
        if (r4 == true) goto L26;
    L28:
        if (r4 == false) goto L30;
    L32:
        int r23 = r9;
    L33:
        int r15 = r14 - r23;
        long r24 = ConstraintsKt.offset-NN6Ew-U(r45, -r13, -r12);
        this.$state.setDensity$foundation_release(r44);
        int r16 = r44.roundToPx-0680j_4(this.$pageSpacing);
        if (r4 == false) goto L36;
        int r17 = Constraints.getMaxHeight-impl(r45) - r12;
    L38:
        if (this.$reverseLayout == false) goto L47;
        if (r17 > 0) goto L47;
        if (r4 == true) goto L44;
        r8 = r8 + r17;
    L44:
        if (r4 == false) goto L46;
        r10 = r10 + r17;
    L46:
        long r5 = ((long) r10) & 4294967295L;
        long r6 = IntOffset.constructor-impl(r5 | (((long) r8) << 32));
    L48:
        long r33 = r6;
        int r35 = RangesKt.coerceAtLeast(this.$pageSize.calculateMainAxisPageSize(r44, r17, r16), 0);
        PagerState r18 = this.$state;
        if (this.$orientation != r3) goto L51;
        int r19 = Constraints.getMaxWidth-impl(r24);
    L53:
        if (this.$orientation == r3) goto L55;
        int r110 = Constraints.getMaxHeight-impl(r24);
    L56:
        r18.m1269setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, r19, 0, r110, 5, null));
        PagerLazyLayoutItemProvider r20 = (PagerLazyLayoutItemProvider) this.$itemProviderLambda.invoke();
        int r111 = (r17 + r23) + r15;
        Snapshot.Companion r21 = Snapshot.Companion;
        PagerState r22 = this.$state;
        SnapPosition r112 = this.$snapPosition;
        Snapshot r25 = r21.getCurrentThreadSnapshot();
        if (r25 == null) goto L59;
        Function1 r26 = r25.getReadObserver();
    L60:
        Snapshot r27 = r21.makeCurrentNonObservable(r25);
        int r36 = r22.matchScrollPositionWithKey$foundation_release(r20, r22.getCurrentPage());     // Catch: Throwable -> L64
        int r113 = r23;
        int r114 = PagerKt.currentPageOffset(r112, r111, r35, r16, r113, r15, r22.getCurrentPage(), r22.getCurrentPageOffsetFraction(), r22.getPageCount());     // Catch: Throwable -> L64
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L64
        r21.restoreNonObservable(r25, r27, r26);
        List<Integer> r29 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(r20, this.$state.getPinnedPages$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
        MutableIntObjectMap r32 = IntObjectMapKt.mutableIntObjectMapOf();
        int r30 = ((Number) this.$pageCount.invoke()).intValue();
        MutableState<Unit> r210 = this.$state.m1266getPlacementScopeInvalidatorzYiylxw$foundation_release();
        Orientation r31 = this.$orientation;
        Alignment.Vertical r34 = this.$verticalAlignment;
        Alignment.Horizontal r37 = this.$horizontalAlignment;
        boolean r38 = this.$reverseLayout;
        int r39 = this.$beyondViewportPageCount;
        SnapPosition r40 = this.$snapPosition;
        CoroutineScope r41 = this.$coroutineScope;
        Function3 r42 = new z(r44, r45, r13, r12);
        PagerMeasureResult r43 = PagerMeasureKt.m1263measurePagerBiYVr7A(r44, r30, r20, r17, r23, r15, r16, r36, r114, r24, r31, r34, r37, r38, r33, r35, r39, r29, r40, r210, r41, r42, r32);
        PagerState.applyMeasureResult$foundation_release$default(this.$state, r43, r44.isLookingAhead(), false, 4, null);
        return r43;
    L64:
        th = move-exception;
        r21.restoreNonObservable(r25, r27, r26);
        throw th;
    L59:
        r26 = null;
        goto L60
    L55:
        r110 = r35;
        goto L56
    L51:
        r19 = r35;
    L47:
        r6 = IntOffset.constructor-impl((((long) r8) << 32) | (((long) r10) & 4294967295L));
        goto L48
    L36:
        r17 = Constraints.getMaxWidth-impl(r45) - r13;
        goto L38
    L30:
        if (this.$reverseLayout == true) goto L32;
        r23 = r8;
        goto L33
    L26:
        if (this.$reverseLayout == false) goto L28;
        r23 = r11;
        goto L33
    L22:
        if (this.$reverseLayout == true) goto L24;
        r23 = r10;
        goto L33
    L19:
        r14 = r13;
        goto L20
    L15:
        r9 = r44.roundToPx-0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, r44.getLayoutDirection()));
        goto L16
    L12:
        r8 = r44.roundToPx-0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, r44.getLayoutDirection()));
        goto L13
    L8:
        r7 = Orientation.Horizontal;
        goto L9
    L5:
        r4 = false;
        goto L6
    }

    private static final MeasureResult measure_0kLqBqw$lambda$2(LazyLayoutMeasureScope r0, long r1, int r3, int r4, int r5, int r6, Function1 r7) {
        return r0.layout(ConstraintsKt.constrainWidth-K40F9xA(r1, r5 + r3), ConstraintsKt.constrainHeight-K40F9xA(r1, r6 + r4), MapsKt.emptyMap(), r7);
    }
}
