package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyListItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ StickyItemsPlacement $stickyItemsPlacement;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyListKt$rememberLazyListMeasurePolicy$1$1(LazyListState r1, boolean r2, PaddingValues r3, boolean r4, Function0<? extends LazyListItemProvider> r5, Arrangement.Vertical r6, Arrangement.Horizontal r7, int r8, CoroutineScope r9, GraphicsContext r10, StickyItemsPlacement r11, Alignment.Horizontal r12, Alignment.Vertical r13) {
        this.$state = r1;
        this.$isVertical = r2;
        this.$contentPadding = r3;
        this.$reverseLayout = r4;
        this.$itemProviderLambda = r5;
        this.$verticalArrangement = r6;
        this.$horizontalArrangement = r7;
        this.$beyondBoundsItemCount = r8;
        this.$coroutineScope = r9;
        this.$graphicsContext = r10;
        this.$stickyItemsPlacement = r11;
        this.$horizontalAlignment = r12;
        this.$verticalAlignment = r13;
    }

    public static /* synthetic */ MeasureResult a(LazyLayoutMeasureScope r0, long r1, int r3, int r4, int r5, int r6, Function1 r7) {
        return measure_0kLqBqw$lambda$3(r0, r1, r3, r4, r5, r6, r7);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
    public final MeasureResult mo1082measure0kLqBqw(final LazyLayoutMeasureScope r44, final long r45) {
        ObservableScopeInvalidator.m1184attachToScopeimpl(this.$state.m1098getMeasurementScopeInvalidatorzYiylxw$foundation_release());
        if (this.$state.getHasLookaheadOccurred$foundation_release() == false) goto L5;
    L8:
        boolean r27 = true;
    L10:
        if (this.$isVertical == false) goto L12;
        Orientation r2 = Orientation.Vertical;
    L13:
        CheckScrollableContainerConstraintsKt.m370checkScrollableContainerConstraintsK40F9xA(r45, r2);
        if (this.$isVertical == false) goto L16;
        int r3 = r44.roundToPx-0680j_4(this.$contentPadding.mo899calculateLeftPaddingu2uoSUM(r44.getLayoutDirection()));
    L18:
        if (this.$isVertical == false) goto L20;
        int r4 = r44.roundToPx-0680j_4(this.$contentPadding.mo900calculateRightPaddingu2uoSUM(r44.getLayoutDirection()));
    L21:
        int r5 = r44.roundToPx-0680j_4(this.$contentPadding.mo901calculateTopPaddingD9Ej5fM());
        int r6 = r44.roundToPx-0680j_4(this.$contentPadding.mo898calculateBottomPaddingD9Ej5fM());
        final int r13 = r5 + r6;
        final int r12 = r3 + r4;
        boolean r7 = this.$isVertical;
        if (r7 == false) goto L24;
        int r8 = r13;
    L25:
        if (r7 == true) goto L27;
    L29:
        if (r7 == true) goto L31;
    L33:
        if (r7 == false) goto L35;
    L37:
        int r18 = r4;
    L38:
        final int r23 = r8 - r18;
        final long r35 = ConstraintsKt.offset-NN6Ew-U(r45, -r12, -r13);
        final LazyListItemProvider r11 = (LazyListItemProvider) this.$itemProviderLambda.invoke();
        r11.getItemScope().setMaxSize(Constraints.getMaxWidth-impl(r35), Constraints.getMaxHeight-impl(r35));
        if (this.$isVertical == false) goto L45;
        Arrangement.Vertical r9 = this.$verticalArrangement;
        if (r9 == null) goto L43;
        float r10 = r9.mo812getSpacingD9Ej5fM();
    L48:
        final int r26 = r44.roundToPx-0680j_4(r10);
        final int r37 = r11.getItemCount();
        if (this.$isVertical == false) goto L51;
        int r14 = Constraints.getMaxHeight-impl(r45) - r13;
    L52:
        int r38 = r14;
        if (this.$reverseLayout == false) goto L63;
        if (r38 > 0) goto L63;
        boolean r15 = this.$isVertical;
        if (r15 == true) goto L60;
        r3 = r3 + r38;
    L60:
        if (r15 == false) goto L62;
        r5 = r5 + r38;
    L62:
        long r16 = IntOffset.constructor-impl((((long) r3) << 32) | (((long) r5) & 4294967295L));
    L64:
        final long r17 = r16;
        final boolean r19 = this.$isVertical;
        final Alignment.Horizontal r20 = this.$horizontalAlignment;
        final Alignment.Vertical r21 = this.$verticalAlignment;
        final boolean r22 = this.$reverseLayout;
        final LazyListState r24 = this.$state;
        final int r110 = r18;
        LazyListMeasuredItemProvider r111 = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(r35, r19, r11, r44, r37, r26, r20, r21, r22, r110, r23, r17, r24);
        Snapshot.Companion r25 = Snapshot.Companion;
        LazyListState r28 = this.$state;
        Snapshot r29 = r25.getCurrentThreadSnapshot();
        CacheWindowLogic r42 = null;
        if (r29 == null) goto L67;
        Function1 r30 = r29.getReadObserver();
    L68:
        Snapshot r31 = r25.makeCurrentNonObservable(r29);
        int r112 = r28.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(r11, r28.getFirstVisibleItemIndex());     // Catch: Throwable -> L83
        int r113 = r28.getFirstVisibleItemScrollOffset();     // Catch: Throwable -> L83
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L83
        r25.restoreNonObservable(r29, r31, r30);
        List<Integer> r0 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(r11, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
        if (r44.isLookingAhead() == true) goto L75;
        if (r27 == false) goto L75;
        float r33 = this.$state.getScrollDeltaBetweenPasses$foundation_release();
    L76:
        LazyListMeasureResult r1 = LazyListMeasureKt.m1088measureLazyListLCrQqZ4(r37, r111, r38, r18, r23, r26, r112, r113, r33, r35, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, r44, this.$state.getItemAnimator$foundation_release(), this.$beyondBoundsItemCount, r0, r27, r44.isLookingAhead(), this.$state.getApproachLayoutInfo$foundation_release(), this.$coroutineScope, this.$state.m1099getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$graphicsContext, this.$stickyItemsPlacement, new n(r44, r45, r12, r13));
        LazyListState.applyMeasureResult$foundation_release$default(this.$state, r1, r44.isLookingAhead(), false, 4, null);
        Object r34 = this.$state.getPrefetchStrategy$foundation_release();
        if ((r34 instanceof CacheWindowLogic) == false) goto L79;
        r42 = (CacheWindowLogic) r34;
    L79:
        CacheWindowLogic r36 = r42;
        if (r36 == null) goto L82;
        LazyListKt.access$keepAroundItems(r36, r1.getVisibleItemsInfo(), r111);
    L82:
        return r1;
    L75:
        r33 = this.$state.getScrollToBeConsumed$foundation_release();
    L83:
        th = move-exception;
        r25.restoreNonObservable(r29, r31, r30);
        throw th;
    L67:
        r30 = null;
    L63:
        r16 = IntOffset.constructor-impl((((long) r3) << 32) | (((long) r5) & 4294967295L));
        goto L64
    L51:
        r14 = Constraints.getMaxWidth-impl(r45) - r12;
        goto L52
    L43:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
        throw new KotlinNothingValueException();
    L45:
        Arrangement.Horizontal r39 = this.$horizontalArrangement;
        if (r39 == null) goto L86;
        r10 = r39.mo812getSpacingD9Ej5fM();
        goto L48
    L86:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
        throw new KotlinNothingValueException();
    L35:
        if (this.$reverseLayout == true) goto L37;
        r18 = r3;
        goto L38
    L31:
        if (this.$reverseLayout == false) goto L33;
        r18 = r6;
        goto L38
    L27:
        if (this.$reverseLayout == true) goto L29;
        r18 = r5;
        goto L38
    L24:
        r8 = r12;
        goto L25
    L20:
        r4 = r44.roundToPx-0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, r44.getLayoutDirection()));
        goto L21
    L16:
        r3 = r44.roundToPx-0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, r44.getLayoutDirection()));
        goto L18
    L12:
        r2 = Orientation.Horizontal;
        goto L13
    L5:
        if (r44.isLookingAhead() == true) goto L8;
        r27 = false;
        goto L10
    }

    private static final MeasureResult measure_0kLqBqw$lambda$3(LazyLayoutMeasureScope r0, long r1, int r3, int r4, int r5, int r6, Function1 r7) {
        return r0.layout(ConstraintsKt.constrainWidth-K40F9xA(r1, r5 + r3), ConstraintsKt.constrainHeight-K40F9xA(r1, r6 + r4), MapsKt.emptyMap(), r7);
    }
}
