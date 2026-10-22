package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyGridItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridSlotsProvider $slots;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ StickyItemsPlacement $stickyItemsScrollBehavior;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyGridKt$rememberLazyGridMeasurePolicy$1$1(LazyGridState r1, boolean r2, PaddingValues r3, boolean r4, Function0<? extends LazyGridItemProvider> r5, LazyGridSlotsProvider r6, Arrangement.Vertical r7, Arrangement.Horizontal r8, CoroutineScope r9, GraphicsContext r10, StickyItemsPlacement r11) {
        this.$state = r1;
        this.$isVertical = r2;
        this.$contentPadding = r3;
        this.$reverseLayout = r4;
        this.$itemProviderLambda = r5;
        this.$slots = r6;
        this.$verticalArrangement = r7;
        this.$horizontalArrangement = r8;
        this.$coroutineScope = r9;
        this.$graphicsContext = r10;
        this.$stickyItemsScrollBehavior = r11;
    }

    public static /* synthetic */ MeasureResult a(LazyLayoutMeasureScope r0, long r1, int r3, int r4, int r5, int r6, Function1 r7) {
        return measure_0kLqBqw$lambda$6(r0, r1, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ ArrayList b(LazyGridSpanLayoutProvider r0, LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 r1, int r2) {
        return measure_0kLqBqw$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ int c(LazyGridSpanLayoutProvider r0, int r1) {
        return measure_0kLqBqw$lambda$4(r0, r1);
    }

    private static final int measure_0kLqBqw$lambda$4(LazyGridSpanLayoutProvider r0, int r1) {
        return r0.getLineIndexOfItem(r1);
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider] */
    /* JADX WARN: Type inference failed for: r34v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider] */
    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* JADX INFO: renamed from: measure-0kLqBqw */
    public final MeasureResult mo1082measure0kLqBqw(final LazyLayoutMeasureScope r51, final long r52) {
        ObservableScopeInvalidator.m1184attachToScopeimpl(this.$state.m1126getMeasurementScopeInvalidatorzYiylxw$foundation_release());
        if (this.$state.getHasLookaheadOccurred$foundation_release() == false) goto L5;
    L8:
        boolean r28 = true;
    L10:
        if (this.$isVertical == false) goto L12;
        Orientation r2 = Orientation.Vertical;
    L13:
        CheckScrollableContainerConstraintsKt.m370checkScrollableContainerConstraintsK40F9xA(r52, r2);
        if (this.$isVertical == false) goto L16;
        int r3 = r51.roundToPx-0680j_4(this.$contentPadding.mo899calculateLeftPaddingu2uoSUM(r51.getLayoutDirection()));
    L18:
        if (this.$isVertical == false) goto L20;
        int r4 = r51.roundToPx-0680j_4(this.$contentPadding.mo900calculateRightPaddingu2uoSUM(r51.getLayoutDirection()));
    L21:
        int r5 = r51.roundToPx-0680j_4(this.$contentPadding.mo901calculateTopPaddingD9Ej5fM());
        int r6 = r51.roundToPx-0680j_4(this.$contentPadding.mo898calculateBottomPaddingD9Ej5fM());
        final int r11 = r5 + r6;
        final int r12 = r3 + r4;
        boolean r7 = this.$isVertical;
        if (r7 == false) goto L24;
        int r8 = r11;
    L25:
        if (r7 == true) goto L27;
    L29:
        if (r7 == true) goto L31;
    L33:
        if (r7 == false) goto L35;
    L37:
        int r16 = r4;
    L38:
        final int r17 = r8 - r16;
        long r9 = ConstraintsKt.offset-NN6Ew-U(r52, -r12, -r11);
        final LazyGridItemProvider r10 = (LazyGridItemProvider) this.$itemProviderLambda.invoke();
        final LazyGridSpanLayoutProvider r13 = r10.getSpanLayoutProvider();
        final LazyGridSlots r20 = this.$slots.mo1110invoke0kLqBqw(r51, r9);
        int r14 = r20.getSizes().length;
        r13.setSlotsPerLine(r14);
        if (this.$isVertical == false) goto L45;
        Arrangement.Vertical r15 = this.$verticalArrangement;
        if (r15 == null) goto L43;
        float r18 = r15.mo812getSpacingD9Ej5fM();
    L48:
        final int r26 = r51.roundToPx-0680j_4(r18);
        final int r19 = r10.getItemCount();
        if (this.$isVertical == false) goto L51;
        int r21 = Constraints.getMaxHeight-impl(r52) - r11;
    L52:
        int r27 = r21;
        if (this.$reverseLayout == false) goto L63;
        if (r27 > 0) goto L63;
        boolean r22 = this.$isVertical;
        if (r22 == true) goto L60;
        r3 = r3 + r27;
    L60:
        if (r22 == false) goto L62;
        r5 = r5 + r27;
    L62:
        long r23 = IntOffset.constructor-impl((((long) r3) << 32) | (((long) r5) & 4294967295L));
    L64:
        final long r110 = r23;
        final LazyGridState r24 = this.$state;
        final boolean r25 = this.$isVertical;
        final boolean r29 = this.$reverseLayout;
        final int r30 = r16;
        final ?? r34 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(r10, r51, r26, r24, r25, r29, r30, r17, r110);
        final boolean r31 = this.$isVertical;
        final ?? r111 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(r31, r20, r19, r26, r34, r13);
        Function1 r112 = new q(r13, r111);
        Function1 r113 = new r(r13);
        Snapshot.Companion r32 = Snapshot.Companion;
        LazyGridState r33 = this.$state;
        Snapshot r35 = r32.getCurrentThreadSnapshot();
        CacheWindowLogic r43 = null;
        if (r35 == null) goto L67;
        Function1 r36 = r35.getReadObserver();
    L68:
        Snapshot r37 = r32.makeCurrentNonObservable(r35);
        int r38 = r33.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(r10, r33.getFirstVisibleItemIndex());     // Catch: Throwable -> L89
        if (r38 < r19) goto L74;
        if (r19 <= 0) goto L74;
        int r114 = r13.getLineIndexOfItem(r19 - 1);     // Catch: Throwable -> L89
        int r115 = 0;
    L75:
        Unit r39 = Unit.INSTANCE;     // Catch: Throwable -> L89
        r32.restoreNonObservable(r35, r37, r36);
        List<Integer> r310 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(r10, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
        if (r51.isLookingAhead() == true) goto L81;
        if (r28 == false) goto L81;
        float r40 = this.$state.getScrollDeltaBetweenPasses$foundation_release();
    L82:
        LazyLayoutItemAnimator<LazyGridMeasuredItem> r210 = this.$state.getItemAnimator$foundation_release();
        boolean r211 = r51.isLookingAhead();
        LazyGridMeasureResult r311 = this.$state.getApproachLayoutInfo$foundation_release();
        MutableState<Unit> r312 = this.$state.m1127getPlacementScopeInvalidatorzYiylxw$foundation_release();
        LazyGridMeasureResult r41 = LazyGridMeasureKt.m1121measureLazyGridt1x4au0(r19, r111, r34, r27, r16, r17, r26, r114, r115, r40, r9, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, r51, r210, r14, r310, r28, r211, r311, this.$coroutineScope, r312, this.$graphicsContext, r112, r113, this.$stickyItemsScrollBehavior, new s(r51, r52, r12, r11));
        LazyGridState.applyMeasureResult$foundation_release$default(this.$state, r41, r51.isLookingAhead(), false, 4, null);
        Object r0 = this.$state.getPrefetchStrategy$foundation_release();
        if ((r0 instanceof CacheWindowLogic) == false) goto L85;
        r43 = (CacheWindowLogic) r0;
    L85:
        CacheWindowLogic r1 = r43;
        if (r1 == null) goto L88;
        LazyGridKt.access$keepAroundItems(r1, r41.getOrientation(), r41.getVisibleItemsInfo(), r111);
    L88:
        return r41;
    L81:
        r40 = this.$state.getScrollToBeConsumed$foundation_release();
    L74:
        r114 = r13.getLineIndexOfItem(r38);     // Catch: Throwable -> L89
        r115 = r33.getFirstVisibleItemScrollOffset();     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        r32.restoreNonObservable(r35, r37, r36);
        throw th;
    L67:
        r36 = null;
    L63:
        r23 = IntOffset.constructor-impl((((long) r3) << 32) | (((long) r5) & 4294967295L));
        goto L64
    L51:
        r21 = Constraints.getMaxWidth-impl(r52) - r12;
        goto L52
    L43:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
        throw new KotlinNothingValueException();
    L45:
        Arrangement.Horizontal r42 = this.$horizontalArrangement;
        if (r42 == null) goto L92;
        r18 = r42.mo812getSpacingD9Ej5fM();
        goto L48
    L92:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
        throw new KotlinNothingValueException();
    L35:
        if (this.$reverseLayout == true) goto L37;
        r16 = r3;
        goto L38
    L31:
        if (this.$reverseLayout == false) goto L33;
        r16 = r6;
        goto L38
    L27:
        if (this.$reverseLayout == true) goto L29;
        r16 = r5;
        goto L38
    L24:
        r8 = r12;
        goto L25
    L20:
        r4 = r51.roundToPx-0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, r51.getLayoutDirection()));
        goto L21
    L16:
        r3 = r51.roundToPx-0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, r51.getLayoutDirection()));
        goto L18
    L12:
        r2 = Orientation.Horizontal;
        goto L13
    L5:
        if (r51.isLookingAhead() == true) goto L8;
        r28 = false;
        goto L10
    }

    private static final ArrayList measure_0kLqBqw$lambda$3(LazyGridSpanLayoutProvider r8, LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 r9, int r10) {
        LazyGridSpanLayoutProvider.LineConfiguration r11 = r8.getLineConfiguration(r10);
        int r12 = r11.getFirstItemIndex();
        ArrayList r0 = new ArrayList(r11.getSpans().size());
        List<GridItemSpan> r13 = r11.getSpans();
        int r1 = r13.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r4 = GridItemSpan.m1106getCurrentLineSpanimpl(((GridItemSpan) ListProtector.get(r13, r2)).m1109unboximpl());
        r0.add(TuplesKt.to(Integer.valueOf(r12), Constraints.box-impl(r9.m1125childConstraintsJhjzzOo$foundation_release(r3, r4))));
        r12 = r12 + 1;
        r3 = r3 + r4;
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private static final MeasureResult measure_0kLqBqw$lambda$6(LazyLayoutMeasureScope r0, long r1, int r3, int r4, int r5, int r6, Function1 r7) {
        return r0.layout(ConstraintsKt.constrainWidth-K40F9xA(r1, r5 + r3), ConstraintsKt.constrainHeight-K40F9xA(r1, r6 + r4), MapsKt.emptyMap(), r7);
    }
}
