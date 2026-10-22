package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000k\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001c\u001a/\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\u0010\b\u001a(\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u0001H\u0080@¢\u0006\u0002\u0010\u000e\u001a\u0012\u0010\u000f\u001a\u00020\r*\u00020\u0001H\u0080@¢\u0006\u0002\u0010\u000e\u001a\u0017\u0010\u001e\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0007H\u0082\b\u001a\u0014\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010\u0006\u001a\u00020\u0003H\u0000\u001a\u0014\u0010$\u001a\u00020\"*\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001aO\u0010%\u001a\u00020\r*\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050*2\u001d\u0010+\u001a\u0019\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0,¢\u0006\u0002\b.H\u0082@¢\u0006\u0002\u0010/\"\u0016\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013\"\u000e\u0010\u0015\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0017\u001a\u00020\u0018X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u00060"}, d2 = {"rememberPagerState", "Landroidx/compose/foundation/pager/PagerState;", "initialPage", "", "initialPageOffsetFraction", "", "pageCount", "Lkotlin/Function0;", "(IFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "PagerState", "currentPage", "currentPageOffsetFraction", "animateToNextPage", "", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "DefaultPositionThreshold", "Landroidx/compose/ui/unit/Dp;", "getDefaultPositionThreshold", "()F", "F", "MaxPagesForAnimateScroll", "PagesToPrefetch", "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "UnitDensity", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "debugLog", "generateMsg", "", "calculateNewMaxScrollOffset", "", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "calculateNewMinScrollOffset", "animateScrollToPage", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "targetPage", "targetPageOffsetToSnappedPosition", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "updateTargetPage", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PagerStateKt {
    private static final float DefaultPositionThreshold = 0.0f;
    private static final PagerMeasureResult EmptyLayoutInfo = null;
    private static final int MaxPagesForAnimateScroll = 3;
    public static final int PagesToPrefetch = 1;
    private static final PagerStateKt$UnitDensity$1 UnitDensity = null;

    public static /* synthetic */ DefaultPagerState a(int r0, float r1, Function0 r2) {
        return rememberPagerState$lambda$1$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(Ref.FloatRef r0, LazyLayoutScrollScope r1, float r2, float r3) {
        return animateScrollToPage$lambda$7(r0, r1, r2, r3);
    }

    private static final void debugLog(Function0<String> r0) {
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1] */
    static {
        DefaultPositionThreshold = Dp.constructor-impl(56);
        EmptyLayoutInfo = new PagerMeasureResult(CollectionsKt.emptyList(), 0, 0, 0, Orientation.Horizontal, 0, 0, false, 0, null, null, MenuKt.ClosedAlphaTarget, 0, false, SnapPosition.Start.INSTANCE, new PagerStateKt$EmptyLayoutInfo$1(), false, null, null, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), 393216, null);
        UnitDensity = new PagerStateKt$UnitDensity$1();
    }

    public static final /* synthetic */ PagerStateKt$UnitDensity$1 access$getUnitDensity$p() {
        return UnitDensity;
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    public static final PagerMeasureResult getEmptyLayoutInfo() {
        return EmptyLayoutInfo;
    }

    public static final /* synthetic */ long access$calculateNewMinScrollOffset(PagerMeasureResult r0, int r1) {
        return calculateNewMinScrollOffset(r0, r1);
    }

    public static final Object animateToNextPage(PagerState r8, Continuation<? super Unit> r9) {
        if ((r8.getCurrentPage() + 1) >= r8.getPageCount()) goto L10;
        Object r10 = PagerState.animateScrollToPage$default(r8, r8.getCurrentPage() + 1, MenuKt.ClosedAlphaTarget, null, r9, 6, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r10;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public static final Object animateToPreviousPage(PagerState r8, Continuation<? super Unit> r9) {
        if ((r8.getCurrentPage() - 1) < 0) goto L10;
        Object r10 = PagerState.animateScrollToPage$default(r8, r8.getCurrentPage() - 1, MenuKt.ClosedAlphaTarget, null, r9, 6, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r10;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public static final long calculateNewMaxScrollOffset(PagerLayoutInfo r10, int r11) {
        long r1 = (((((long) r11) * ((long) (r10.getPageSpacing() + r10.getPageSize()))) + ((long) r10.getBeforeContentPadding())) + ((long) r10.getAfterContentPadding())) - ((long) r10.getPageSpacing());
        if (r10.getOrientation() != Orientation.Horizontal) goto L5;
        long r3 = r10.mo1261getViewportSizeYbymL2g() >> 32;
    L6:
        int r0 = (int) r3;
        return RangesKt.coerceAtLeast(r1 - ((long) (r0 - RangesKt.coerceIn(r10.getSnapPosition().position(r0, r10.getPageSize(), r10.getBeforeContentPadding(), r10.getAfterContentPadding(), r11 - 1, r11), 0, r0))), 0);
    L5:
        r3 = r10.mo1261getViewportSizeYbymL2g() & 4294967295L;
        goto L6
    }

    private static final long calculateNewMinScrollOffset(PagerMeasureResult r9, int r10) {
        if (r9.getOrientation() != Orientation.Horizontal) goto L5;
        long r0 = r9.mo1261getViewportSizeYbymL2g() >> 32;
    L6:
        int r1 = (int) r0;
        return RangesKt.coerceIn(r9.getSnapPosition().position(r1, r9.getPageSize(), r9.getBeforeContentPadding(), r9.getAfterContentPadding(), 0, r10), 0, r1);
    L5:
        r0 = r9.mo1261getViewportSizeYbymL2g() & 4294967295L;
        goto L6
    }

    public static final PagerState PagerState(int r1, float r2, Function0<Integer> r3) {
        return new DefaultPagerState(r1, r2, r3);
    }

    private static final DefaultPagerState rememberPagerState$lambda$1$lambda$0(int r1, float r2, Function0 r3) {
        return new DefaultPagerState(r1, r2, r3);
    }

    private static final Unit animateScrollToPage$lambda$7(Ref.FloatRef r0, LazyLayoutScrollScope r1, float r2, float r3) {
        r0.element += r1.scrollBy(r2 - r0.element);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ PagerState PagerState$default(int r0, float r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r1 = MenuKt.ClosedAlphaTarget;
    L9:
        return PagerState(r0, r1, r2);
    }

    public static final /* synthetic */ Object access$animateScrollToPage(LazyLayoutScrollScope r0, int r1, float r2, AnimationSpec r3, Function2 r4, Continuation r5) {
        return animateScrollToPage(r0, r1, r2, r3, r4, r5);
    }

    private static final Object animateScrollToPage(final LazyLayoutScrollScope r8, int r9, float r10, AnimationSpec<Float> r11, Function2<? super ScrollScope, ? super Integer, Unit> r12, Continuation<? super Unit> r13) {
        r12.invoke(r8, Boxing.boxInt(r9));
        if (r9 <= r8.getFirstVisibleItemIndex()) goto L5;
        boolean r14 = true;
    L6:
        int r2 = (r8.getLastVisibleItemIndex() - r8.getFirstVisibleItemIndex()) + 1;
        if (r14 == true) goto L9;
    L10:
        if (r14 == false) goto L12;
    L19:
        float r1 = LazyLayoutScrollScope.CC.calculateDistanceTo$default(r8, r9, 0, 2, null) + r10;
        final Ref.FloatRef r15 = new Ref.FloatRef();
        Object r16 = SuspendAnimationKt.animate$default(MenuKt.ClosedAlphaTarget, r1, MenuKt.ClosedAlphaTarget, r11, new f0(r15, r8), r13, 4, null);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        return r16;
    L23:
        return Unit.INSTANCE;
    L12:
        if (r9 >= r8.getFirstVisibleItemIndex()) goto L19;
    L14:
        if (Math.abs(r9 - r8.getFirstVisibleItemIndex()) < 3) goto L19;
        if (r14 == false) goto L17;
        int r17 = RangesKt.coerceAtLeast(r9 - r2, r8.getFirstVisibleItemIndex());
    L18:
        r8.snapToItem(r17, 0);
        goto L19
    L17:
        r17 = RangesKt.coerceAtMost(r2 + r9, r8.getFirstVisibleItemIndex());
        goto L18
    L9:
        if (r9 > r8.getLastVisibleItemIndex()) goto L14;
    L5:
        r14 = false;
        goto L6
    }

    public static final PagerState rememberPagerState(final int r6, final float r7, final Function0<Integer> r8, Composer r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r7 = MenuKt.ClosedAlphaTarget;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1210768637, r10, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:89)");
    L11:
        Object[] r12 = new Object[0];
        Saver<DefaultPagerState, ?> r0 = DefaultPagerState.Companion.getSaver();
        boolean r4 = true;
        if (((r10 & 14) ^ 6) <= 4) goto L16;
        if (r9.changed(r6) == false) goto L16;
    L17:
        boolean r2 = true;
    L20:
        if (((r10 & 112) ^ 48) <= 32) goto L24;
        if (r9.changed(r7) == false) goto L24;
    L25:
        boolean r3 = true;
    L27:
        boolean r5 = r2 | r3;
        if (((r10 & 896) ^ 384) <= 256) goto L32;
        if (r9.changed(r8) == false) goto L32;
    L35:
        boolean r13 = r5 | r4;
        Object r14 = r9.rememberedValue();
        if (r13 == false) goto L38;
    L39:
        r14 = new g0(r6, r7, r8);
        r9.updateRememberedValue(r14);
    L40:
        DefaultPagerState r15 = (DefaultPagerState) RememberSaveableKt.rememberSaveable(r12, r0, (Function0) r14, r9, 0);
        r15.getPageCountState().setValue(r8);
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
    L43:
        return r15;
    L38:
        if (r14 != Composer.Companion.getEmpty()) goto L40;
    L32:
        if ((r10 & 384) == 256) goto L35;
        r4 = false;
    L24:
        if ((r10 & 48) == 32) goto L25;
        r3 = false;
    L16:
        if ((r10 & 6) == 4) goto L17;
        r2 = false;
        goto L20
    }
}
