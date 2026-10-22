package androidx.compose.foundation.pager;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001aÕ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c21\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0007¢\u0006\u0004\b#\u0010$\u001aë\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)21\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0007¢\u0006\u0004\b*\u0010+\u001aß\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020'21\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0007¢\u0006\u0004\b,\u0010-\u001aë\u0001\u0010.\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)21\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0007¢\u0006\u0004\b1\u00102\u001aß\u0001\u0010.\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020'21\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0007¢\u0006\u0004\b3\u00104\u001aL\u00105\u001a\u00020\u000b*\u00020'2\u0006\u00106\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000bH\u0000\u001a,\u0010>\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0017\u0010B\u001a\u00020\u00012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0082\b¨\u0006F"}, d2 = {"HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondBoundsPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "beyondViewportPageCount", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "HorizontalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "currentPageOffset", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", "currentPageOffsetFraction", "", "pageCount", "pagerSemantics", "isVertical", "scope", "Lkotlinx/coroutines/CoroutineScope;", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PagerKt {
    private static final Unit HorizontalPager__8jOkeI$lambda$1(PagerState r19, Modifier r20, PaddingValues r21, PageSize r22, int r23, float r24, Alignment.Vertical r25, TargetedFlingBehavior r26, boolean r27, boolean r28, Function1 r29, NestedScrollConnection r30, SnapPosition r31, OverscrollEffect r32, Function4 r33, int r34, int r35, int r36, Composer r37, int r38) {
        m1256HorizontalPager8jOkeI(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r37, RecomposeScopeImplKt.updateChangedFlags(r34 | 1), RecomposeScopeImplKt.updateChangedFlags(r35), r36);
        return Unit.INSTANCE;
    }

    private static final Unit HorizontalPager_oI3XNZo$lambda$2(PagerState r18, Modifier r19, PaddingValues r20, PageSize r21, int r22, float r23, Alignment.Vertical r24, TargetedFlingBehavior r25, boolean r26, boolean r27, Function1 r28, NestedScrollConnection r29, SnapPosition r30, Function4 r31, int r32, int r33, int r34, Composer r35, int r36) {
        m1257HorizontalPageroI3XNZo(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r35, RecomposeScopeImplKt.updateChangedFlags(r32 | 1), RecomposeScopeImplKt.updateChangedFlags(r33), r34);
        return Unit.INSTANCE;
    }

    private static final Unit HorizontalPager_xYaah8o$lambda$0(PagerState r17, Modifier r18, PaddingValues r19, PageSize r20, int r21, float r22, Alignment.Vertical r23, TargetedFlingBehavior r24, boolean r25, boolean r26, Function1 r27, NestedScrollConnection r28, Function4 r29, int r30, int r31, int r32, Composer r33, int r34) {
        m1258HorizontalPagerxYaah8o(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r33, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31), r32);
        return Unit.INSTANCE;
    }

    private static final Unit VerticalPager__8jOkeI$lambda$3(PagerState r19, Modifier r20, PaddingValues r21, PageSize r22, int r23, float r24, Alignment.Horizontal r25, TargetedFlingBehavior r26, boolean r27, boolean r28, Function1 r29, NestedScrollConnection r30, SnapPosition r31, OverscrollEffect r32, Function4 r33, int r34, int r35, int r36, Composer r37, int r38) {
        m1259VerticalPager8jOkeI(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r37, RecomposeScopeImplKt.updateChangedFlags(r34 | 1), RecomposeScopeImplKt.updateChangedFlags(r35), r36);
        return Unit.INSTANCE;
    }

    private static final Unit VerticalPager_oI3XNZo$lambda$4(PagerState r18, Modifier r19, PaddingValues r20, PageSize r21, int r22, float r23, Alignment.Horizontal r24, TargetedFlingBehavior r25, boolean r26, boolean r27, Function1 r28, NestedScrollConnection r29, SnapPosition r30, Function4 r31, int r32, int r33, int r34, Composer r35, int r36) {
        m1260VerticalPageroI3XNZo(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r35, RecomposeScopeImplKt.updateChangedFlags(r32 | 1), RecomposeScopeImplKt.updateChangedFlags(r33), r34);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ boolean a(PagerState r0, CoroutineScope r1) {
        return pagerSemantics$lambda$9$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit b(PagerState r1, Modifier r2, PaddingValues r3, PageSize r4, int r5, float r6, Alignment.Horizontal r7, TargetedFlingBehavior r8, boolean r9, boolean r10, Function1 r11, NestedScrollConnection r12, SnapPosition r13, Function4 r14, int r15, int r16, int r17, Composer r18, int r19) {
        return VerticalPager_oI3XNZo$lambda$4(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ Unit c(PagerState r1, Modifier r2, PaddingValues r3, PageSize r4, int r5, float r6, Alignment.Vertical r7, TargetedFlingBehavior r8, boolean r9, boolean r10, Function1 r11, NestedScrollConnection r12, SnapPosition r13, Function4 r14, int r15, int r16, int r17, Composer r18, int r19) {
        return HorizontalPager_oI3XNZo$lambda$2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ Unit d(boolean r0, PagerState r1, CoroutineScope r2, SemanticsPropertyReceiver r3) {
        return pagerSemantics$lambda$9(r0, r1, r2, r3);
    }

    private static final void debugLog(Function0<String> r0) {
    }

    public static /* synthetic */ boolean e(PagerState r0, CoroutineScope r1) {
        return pagerSemantics$lambda$9$lambda$7(r0, r1);
    }

    public static /* synthetic */ boolean f(PagerState r0, CoroutineScope r1) {
        return pagerSemantics$lambda$9$lambda$8(r0, r1);
    }

    public static /* synthetic */ boolean g(PagerState r0, CoroutineScope r1) {
        return pagerSemantics$lambda$9$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit h(PagerState r1, Modifier r2, PaddingValues r3, PageSize r4, int r5, float r6, Alignment.Vertical r7, TargetedFlingBehavior r8, boolean r9, boolean r10, Function1 r11, NestedScrollConnection r12, SnapPosition r13, OverscrollEffect r14, Function4 r15, int r16, int r17, int r18, Composer r19, int r20) {
        return HorizontalPager__8jOkeI$lambda$1(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ Unit i(PagerState r1, Modifier r2, PaddingValues r3, PageSize r4, int r5, float r6, Alignment.Horizontal r7, TargetedFlingBehavior r8, boolean r9, boolean r10, Function1 r11, NestedScrollConnection r12, SnapPosition r13, OverscrollEffect r14, Function4 r15, int r16, int r17, int r18, Composer r19, int r20) {
        return VerticalPager__8jOkeI$lambda$3(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ Unit j(PagerState r1, Modifier r2, PaddingValues r3, PageSize r4, int r5, float r6, Alignment.Vertical r7, TargetedFlingBehavior r8, boolean r9, boolean r10, Function1 r11, NestedScrollConnection r12, Function4 r13, int r14, int r15, int r16, Composer r17, int r18) {
        return HorizontalPager_xYaah8o$lambda$0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    private static final boolean pagerSemantics$lambda$9$lambda$5(PagerState r0, CoroutineScope r1) {
        return pagerSemantics$performBackwardPaging(r0, r1);
    }

    private static final boolean pagerSemantics$lambda$9$lambda$6(PagerState r0, CoroutineScope r1) {
        return pagerSemantics$performForwardPaging(r0, r1);
    }

    private static final boolean pagerSemantics$lambda$9$lambda$7(PagerState r0, CoroutineScope r1) {
        return pagerSemantics$performBackwardPaging(r0, r1);
    }

    private static final boolean pagerSemantics$lambda$9$lambda$8(PagerState r0, CoroutineScope r1) {
        return pagerSemantics$performForwardPaging(r0, r1);
    }

    private static final boolean pagerSemantics$performBackwardPaging(PagerState r7, CoroutineScope r8) {
        if (r7.getCanScrollBackward() == false) goto L5;
        BuildersKt.launch$default(r8, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1(r7, null), 3, null);
        return true;
    L5:
        return false;
    }

    private static final boolean pagerSemantics$performForwardPaging(PagerState r7, CoroutineScope r8) {
        if (r7.getCanScrollForward() == false) goto L5;
        BuildersKt.launch$default(r8, null, null, new PagerKt$pagerSemantics$performForwardPaging$1(r7, null), 3, null);
        return true;
    L5:
        return false;
    }

    private static final Unit pagerSemantics$lambda$9(boolean r2, final PagerState r3, final CoroutineScope r4, SemanticsPropertyReceiver r5) {
        if (r2 == false) goto L5;
        SemanticsPropertiesKt.pageUp$default(r5, null, new p(r3, r4), 1, null);
        SemanticsPropertiesKt.pageDown$default(r5, null, new q(r3, r4), 1, null);
    L7:
        return Unit.INSTANCE;
    L5:
        SemanticsPropertiesKt.pageLeft$default(r5, null, new r(r3, r4), 1, null);
        SemanticsPropertiesKt.pageRight$default(r5, null, new s(r3, r4), 1, null);
        goto L7
    }

    public static final Modifier pagerSemantics(Modifier r1, final PagerState r2, final boolean r3, final CoroutineScope r4, boolean r5) {
        if (r5 == false) goto L5;
        return r1.then(SemanticsModifierKt.semantics$default(Modifier.Companion, false, new j(r3, r2, r4), 1, null));
    L5:
        return r1.then(Modifier.Companion);
    }

    public static final int currentPageOffset(SnapPosition r7, int r8, int r9, int r10, int r11, int r12, int r13, float r14, int r15) {
        return MathKt.roundToInt(r7.position(r8, r9, r11, r12, r13, r15) - (r14 * (r9 + r10)));
    }

    /* JADX INFO: renamed from: HorizontalPager-xYaah8o, reason: not valid java name */
    public static final void m1258HorizontalPagerxYaah8o(final PagerState r34, Modifier r35, PaddingValues r36, PageSize r37, int r38, float r39, Alignment.Vertical r40, TargetedFlingBehavior r41, boolean r42, boolean r43, Function1<? super Integer, ? extends Object> r44, NestedScrollConnection r45, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> r46, Composer r47, final int r48, final int r49, final int r50) {
        Composer r13 = r47.startRestartGroup(-1054685464);
        if ((r50 & 1) == 0) goto L6;
        int r0 = r48 | 6;
    L13:
        int r3 = r50 & 2;
        if (r3 == 0) goto L17;
        r0 = r0 | 48;
    L23:
        Modifier r6 = r35;
    L24:
        int r7 = r50 & 4;
        if (r7 == 0) goto L28;
        r0 = r0 | 384;
    L35:
        int r16 = r50 & 8;
        if (r16 == 0) goto L39;
        r0 = r0 | 3072;
    L46:
        int r18 = r50 & 16;
        if (r18 == 0) goto L50;
        r0 = r0 | 24576;
    L56:
        int r4 = r38;
    L57:
        int r20 = r50 & 32;
        if (r20 == 0) goto L60;
        r0 = r0 | 196608;
        float r5 = r39;
    L67:
        int r23 = r50 & 64;
        if (r23 == 0) goto L71;
        r0 = r0 | 1572864;
    L78:
        if ((r48 & 12582912) == 0) goto L80;
        TargetedFlingBehavior r12 = r41;
    L88:
        int r9 = r50 & 256;
        if (r9 == 0) goto L92;
        r0 = r0 | 100663296;
    L98:
        int r8 = r50 & 512;
        if (r8 == 0) goto L102;
        int r28 = r0 | 805306368;
        r8 = r8;
    L110:
        int r1 = r50 & 1024;
        if (r1 == 0) goto L114;
        int r17 = r49 | 6;
    L122:
        if ((r49 & 48) != 0) goto L132;
        if ((r50 & 2048) != 0) goto L129;
        if (r13.changedInstance(r45) == false) goto L129;
        int r19 = 32;
    L130:
        r17 = r17 | r19;
    L129:
        r19 = 16;
    L132:
        int r2 = r17;
        if ((r50 & 4096) == 0) goto L136;
        r2 = r2 | 384;
    L143:
        boolean r110 = true;
        if ((r28 & 306783379) == 306783378) goto L146;
    L149:
        boolean r10 = true;
    L151:
        if (r13.shouldExecute(r10, r28 & 1) == false) goto L207;
        r13.startDefaults();
        if ((r48 & 1) != 0) goto L155;
    L164:
        if (r3 == 0) goto L166;
        Modifier r22 = Modifier.Companion;
    L167:
        if (r7 == 0) goto L169;
        PaddingValues r24 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L170:
        if (r16 == 0) goto L172;
        PageSize r111 = PageSize.Fill.INSTANCE;
    L173:
        if (r18 == 0) goto L175;
        int r112 = 0;
    L176:
        if (r20 == 0) goto L178;
        float r21 = Dp.constructor-impl(0);
    L179:
        if (r23 == 0) goto L181;
        Alignment.Vertical r25 = Alignment.Companion.getCenterVertically();
    L183:
        if ((r50 & 128) == 0) goto L185;
        boolean r29 = false;
        TargetedFlingBehavior r11 = PagerDefaults.INSTANCE.flingBehavior(r34, null, null, null, MenuKt.ClosedAlphaTarget, r13, (r28 & 14) | 196608, 30);
        r28 = r28 & (-29360129);
    L186:
        if (r9 != 0) goto L189;
        r110 = r42;
    L189:
        if (r8 != 0) goto L192;
        r29 = r43;
    L192:
        if (r1 == 0) goto L194;
        Function1<? super Integer, ? extends Object> r14 = null;
    L196:
        if ((r50 & 2048) == 0) goto L198;
        NestedScrollConnection r30 = PagerDefaults.INSTANCE.pageNestedScrollConnection(r34, Orientation.Horizontal, r13, (r28 & 14) | 432);
        r2 = r2 & (-113);
    L199:
        float r26 = r21;
        int r27 = r112;
        int r33 = r28;
        Function1<? super Integer, ? extends Object> r210 = r14;
        int r15 = r33;
    L200:
        r13.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L203;
        ComposerKt.traceEventStart(-1054685464, r15, r2, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:76)");
    L203:
        Composer r211 = r13;
        m1256HorizontalPager8jOkeI(r34, r22, r24, r111, r27, r26, r25, r11, r110, r29, r210, r30, null, null, r46, r211, (((((((((r15 & 14) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168)) | (57344 & r15)) | (458752 & r15)) | (3670016 & r15)) | (29360128 & r15)) | (234881024 & r15)) | (r15 & 1879048192), ((r2 & 14) | (r2 & 112)) | ((r2 << 6) & 57344), 12288);
        if (ComposerKt.isTraceInProgress() == false) goto L206;
        ComposerKt.traceEventEnd();
    L206:
        final PageSize r31 = r111;
        final int r32 = r27;
        final float r51 = r26;
        final Modifier r52 = r22;
        final Alignment.Vertical r53 = r25;
        final PaddingValues r54 = r24;
        final TargetedFlingBehavior r55 = r11;
        final boolean r56 = r110;
        final Function1<? super Integer, ? extends Object> r113 = r210;
        final boolean r114 = r29;
        final NestedScrollConnection r115 = r30;
    L208:
        ScopeUpdateScope r116 = r211.endRestartGroup();
        if (r116 == null) goto L212;
        r116.updateScope(new l(r34, r52, r54, r31, r32, r51, r53, r55, r56, r114, r113, r115, r46, r48, r49, r50));
        return;
    L212:
        return;
    L198:
        r30 = r45;
        r2 = r2;
        goto L199
    L194:
        r14 = r44;
        goto L196
    L185:
        r29 = false;
        r11 = r12;
        goto L186
    L181:
        r25 = r40;
        goto L183
    L178:
        r21 = r5;
        goto L179
    L175:
        r112 = r4;
        goto L176
    L172:
        r111 = r37;
        goto L173
    L169:
        r24 = r36;
        goto L170
    L166:
        r22 = r6;
        goto L167
    L155:
        if (r13.getDefaultsInvalid() == true) goto L164;
        r13.skipToGroupEnd();
        if ((r50 & 128) == 0) goto L161;
        r28 = r28 & (-29360129);
    L161:
        if ((r50 & 2048) == 0) goto L163;
        r2 = r2 & (-113);
    L163:
        r24 = r36;
        r111 = r37;
        r25 = r40;
        r110 = r42;
        r29 = r43;
        r30 = r45;
        r27 = r4;
        r26 = r5;
        r22 = r6;
        r11 = r12;
        r15 = r28;
        r210 = r44;
        goto L200
    L207:
        r211 = r13;
        r211.skipToGroupEnd();
        r54 = r36;
        r53 = r40;
        r56 = r42;
        r114 = r43;
        r113 = r44;
        r52 = r6;
        r55 = r12;
        r115 = r45;
        r51 = r5;
        r32 = r4;
        r31 = r37;
        goto L208
    L146:
        if ((r2 & 147) != 146) goto L149;
        r10 = false;
        goto L151
    L136:
        if ((r49 & 384) != 0) goto L143;
        if (r13.changedInstance(r46) == false) goto L140;
        int r212 = 256;
    L141:
        r2 = r2 | r212;
        goto L143
    L140:
        r212 = 128;
        goto L141
    L114:
        if ((r49 & 6) == 0) goto L116;
        r17 = r49;
        goto L122
    L116:
        if (r13.changedInstance(r44) == false) goto L118;
        int r117 = 4;
    L119:
        r17 = r49 | r117;
        goto L122
    L118:
        r117 = 2;
        goto L119
    L102:
        if ((r48 & 805306368) != 0) goto L109;
        if (r13.changed(r43) == false) goto L106;
        int r213 = 536870912;
    L107:
        r0 = r0 | r213;
        goto L109
    L106:
        r213 = 268435456;
    L109:
        r28 = r0;
        goto L110
    L92:
        if ((r48 & 100663296) != 0) goto L98;
        if (r13.changed(r42) == false) goto L96;
        int r214 = 67108864;
    L97:
        r0 = r0 | r214;
        goto L98
    L96:
        r214 = 33554432;
        goto L97
    L80:
        if ((r50 & 128) != 0) goto L84;
        r12 = r41;
        if (r13.changed(r12) == false) goto L85;
        int r215 = 8388608;
    L86:
        r0 = r0 | r215;
    L85:
        r215 = 4194304;
        goto L86
    L84:
        r12 = r41;
        goto L85
    L71:
        if ((r48 & 1572864) != 0) goto L78;
        if (r13.changed(r40) == false) goto L75;
        int r216 = 1048576;
    L76:
        r0 = r0 | r216;
        goto L78
    L75:
        r216 = 524288;
        goto L76
    L60:
        r5 = r39;
        if ((r48 & 196608) != 0) goto L67;
        if (r13.changed(r5) == false) goto L65;
        int r217 = 131072;
    L66:
        r0 = r0 | r217;
        goto L67
    L65:
        r217 = 65536;
        goto L66
    L50:
        if ((r48 & 24576) != 0) goto L56;
        r4 = r38;
        if (r13.changed(r4) == false) goto L54;
        int r218 = 16384;
    L55:
        r0 = r0 | r218;
        goto L57
    L54:
        r218 = 8192;
        goto L55
    L39:
        if ((r48 & 3072) != 0) goto L46;
        if (r13.changed(r37) == false) goto L43;
        int r118 = 2048;
    L44:
        r0 = r0 | r118;
        goto L46
    L43:
        r118 = 1024;
        goto L44
    L28:
        if ((r48 & 384) != 0) goto L35;
        if (r13.changed(r36) == false) goto L32;
        int r119 = 256;
    L33:
        r0 = r0 | r119;
        goto L35
    L32:
        r119 = 128;
        goto L33
    L17:
        if ((r48 & 48) != 0) goto L23;
        r6 = r35;
        if (r13.changed(r6) == false) goto L21;
        int r57 = 32;
    L22:
        r0 = r0 | r57;
        goto L24
    L21:
        r57 = 16;
        goto L22
    L6:
        if ((r48 & 6) == 0) goto L8;
        r0 = r48;
        goto L13
    L8:
        if (r13.changed(r34) == false) goto L10;
        int r58 = 4;
    L11:
        r0 = r58 | r48;
        goto L13
    L10:
        r58 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* JADX INFO: renamed from: HorizontalPager-oI3XNZo, reason: not valid java name */
    public static final /* synthetic */ void m1257HorizontalPageroI3XNZo(final PagerState r35, Modifier r36, PaddingValues r37, PageSize r38, int r39, float r40, Alignment.Vertical r41, TargetedFlingBehavior r42, boolean r43, boolean r44, Function1 r45, NestedScrollConnection r46, SnapPosition r47, final Function4 r48, Composer r49, final int r50, final int r51, final int r52) {
        Composer r10 = r49.startRestartGroup(1163833967);
        if ((r52 & 1) == 0) goto L6;
        int r0 = r50 | 6;
    L13:
        int r3 = r52 & 2;
        if (r3 == 0) goto L17;
        r0 = r0 | 48;
    L23:
        Modifier r6 = r36;
    L24:
        int r7 = r52 & 4;
        if (r7 == 0) goto L28;
        r0 = r0 | 384;
    L35:
        int r16 = r52 & 8;
        int r17 = 1024;
        if (r16 == 0) goto L39;
        r0 = r0 | 3072;
    L46:
        int r20 = r52 & 16;
        if (r20 == 0) goto L50;
        r0 = r0 | 24576;
    L56:
        int r4 = r39;
    L57:
        int r22 = r52 & 32;
        if (r22 == 0) goto L60;
        r0 = r0 | 196608;
        float r5 = r40;
    L67:
        int r25 = r52 & 64;
        if (r25 == 0) goto L71;
        r0 = r0 | 1572864;
    L78:
        if ((r50 & 12582912) == 0) goto L80;
        TargetedFlingBehavior r13 = r42;
    L88:
        int r9 = r52 & 256;
        if (r9 == 0) goto L92;
        r0 = r0 | 100663296;
    L98:
        int r8 = r52 & 512;
        if (r8 == 0) goto L102;
        int r30 = r0 | 805306368;
        r8 = r8;
    L110:
        int r1 = r52 & 1024;
        if (r1 == 0) goto L114;
        int r19 = r51 | 6;
    L122:
        if ((r51 & 48) != 0) goto L132;
        if ((r52 & 2048) != 0) goto L129;
        if (r10.changedInstance(r46) == false) goto L129;
        int r21 = 32;
    L130:
        r19 = r19 | r21;
    L129:
        r21 = 16;
    L132:
        int r2 = r19;
        int r11 = r52 & 4096;
        if (r11 == 0) goto L136;
        r2 = r2 | 384;
    L144:
        if ((r52 & 8192) == 0) goto L147;
        r2 = r2 | 3072;
    L153:
        boolean r18 = true;
        if ((r30 & 306783379) == 306783378) goto L156;
    L159:
        boolean r12 = true;
    L161:
        if (r10.shouldExecute(r12, r30 & 1) == false) goto L220;
        r10.startDefaults();
        if ((r50 & 1) != 0) goto L165;
    L174:
        if (r3 == 0) goto L176;
        Modifier r110 = Modifier.Companion;
    L177:
        if (r7 == 0) goto L179;
        PaddingValues r23 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L180:
        if (r16 == 0) goto L182;
        PageSize r111 = PageSize.Fill.INSTANCE;
    L183:
        if (r20 == 0) goto L185;
        int r24 = 0;
    L186:
        if (r22 == 0) goto L188;
        float r26 = Dp.constructor-impl(0);
    L189:
        if (r25 == 0) goto L191;
        Alignment.Vertical r27 = Alignment.Companion.getCenterVertically();
    L193:
        if ((r52 & 128) == 0) goto L195;
        int r14 = 0;
        TargetedFlingBehavior r15 = PagerDefaults.INSTANCE.flingBehavior(r35, null, null, null, MenuKt.ClosedAlphaTarget, r10, (r30 & 14) | 196608, 30);
        r30 = r30 & (-29360129);
    L196:
        if (r9 != 0) goto L199;
        r18 = r43;
    L199:
        if (r8 == 0) goto L201;
        boolean r28 = false;
    L202:
        if (r1 == 0) goto L204;
        Function1 r29 = null;
    L206:
        if ((r52 & 2048) == 0) goto L208;
        NestedScrollConnection r31 = PagerDefaults.INSTANCE.pageNestedScrollConnection(r35, Orientation.Horizontal, r10, (r30 & 14) | 432);
        r2 = r2 & (-113);
    L209:
        if (r11 == 0) goto L211;
        SnapPosition r32 = SnapPosition.Start.INSTANCE;
    L212:
        boolean r210 = r18;
        float r211 = r26;
        int r33 = r30;
        NestedScrollConnection r34 = r31;
        int r212 = r24;
        PageSize r213 = r111;
    L213:
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L216;
        ComposerKt.traceEventStart(1163833967, r33, r2, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:203)");
    L216:
        Composer r214 = r10;
        m1256HorizontalPager8jOkeI(r35, r110, r23, r213, r212, r211, r27, r15, r210, r28, r29, r34, r32, OverscrollKt.rememberOverscrollEffect(r10, r14), r48, r214, (((((((((r33 & 14) | (r33 & 112)) | (r33 & 896)) | (r33 & 7168)) | (57344 & r33)) | (458752 & r33)) | (3670016 & r33)) | (29360128 & r33)) | (234881024 & r33)) | (r33 & 1879048192), (((r2 & 14) | (r2 & 112)) | (r2 & 896)) | ((r2 << 3) & 57344), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L219;
        ComposerKt.traceEventEnd();
    L219:
        final Modifier r53 = r110;
        final PageSize r54 = r213;
        final PaddingValues r55 = r23;
        final int r56 = r212;
        final float r57 = r211;
        final Alignment.Vertical r58 = r27;
        final TargetedFlingBehavior r59 = r15;
        final boolean r60 = r210;
        final boolean r112 = r28;
        final Function1 r113 = r29;
        final NestedScrollConnection r114 = r34;
        final SnapPosition r115 = r32;
    L221:
        ScopeUpdateScope r116 = r214.endRestartGroup();
        if (r116 == null) goto L225;
        r116.updateScope(new k(r35, r53, r55, r54, r56, r57, r58, r59, r60, r112, r113, r114, r115, r48, r50, r51, r52));
        return;
    L225:
        return;
    L211:
        r32 = r47;
        goto L212
    L208:
        r31 = r46;
        r2 = r2;
        goto L209
    L204:
        r29 = r45;
        goto L206
    L201:
        r28 = r44;
        goto L202
    L195:
        r14 = 0;
        r15 = r13;
        goto L196
    L191:
        r27 = r41;
        goto L193
    L188:
        r26 = r5;
        goto L189
    L185:
        r24 = r4;
        goto L186
    L182:
        r111 = r38;
        goto L183
    L179:
        r23 = r37;
        goto L180
    L176:
        r110 = r6;
        goto L177
    L165:
        if (r10.getDefaultsInvalid() == true) goto L174;
        r10.skipToGroupEnd();
        if ((r52 & 128) == 0) goto L171;
        r30 = r30 & (-29360129);
    L171:
        if ((r52 & 2048) == 0) goto L173;
        r2 = r2 & (-113);
    L173:
        r23 = r37;
        r213 = r38;
        r27 = r41;
        r210 = r43;
        r28 = r44;
        r29 = r45;
        r32 = r47;
        r212 = r4;
        r211 = r5;
        r110 = r6;
        r15 = r13;
        r33 = r30;
        r14 = 0;
        r34 = r46;
        goto L213
    L220:
        r214 = r10;
        r214.skipToGroupEnd();
        r55 = r37;
        r58 = r41;
        r60 = r43;
        r112 = r44;
        r113 = r45;
        r114 = r46;
        r53 = r6;
        r59 = r13;
        r115 = r47;
        r57 = r5;
        r56 = r4;
        r54 = r38;
        goto L221
    L156:
        if ((r2 & 1171) != 1170) goto L159;
        r12 = false;
        goto L161
    L147:
        if ((r51 & 3072) != 0) goto L153;
        if (r10.changedInstance(r48) == false) goto L151;
        r17 = 2048;
    L151:
        r2 = r2 | r17;
        goto L153
    L136:
        if ((r51 & 384) != 0) goto L144;
        if (r10.changed(r47) == false) goto L140;
        int r215 = 256;
    L141:
        r2 = r2 | r215;
        goto L144
    L140:
        r215 = 128;
        goto L141
    L114:
        if ((r51 & 6) == 0) goto L116;
        r19 = r51;
        goto L122
    L116:
        if (r10.changedInstance(r45) == false) goto L118;
        int r117 = 4;
    L119:
        r19 = r51 | r117;
        goto L122
    L118:
        r117 = 2;
        goto L119
    L102:
        if ((r50 & 805306368) != 0) goto L109;
        if (r10.changed(r44) == false) goto L106;
        int r310 = 536870912;
    L107:
        r0 = r0 | r310;
        goto L109
    L106:
        r310 = 268435456;
    L109:
        r30 = r0;
        goto L110
    L92:
        if ((r50 & 100663296) != 0) goto L98;
        if (r10.changed(r43) == false) goto L96;
        int r216 = 67108864;
    L97:
        r0 = r0 | r216;
        goto L98
    L96:
        r216 = 33554432;
        goto L97
    L80:
        if ((r52 & 128) != 0) goto L84;
        r13 = r42;
        if (r10.changed(r13) == false) goto L85;
        int r217 = 8388608;
    L86:
        r0 = r0 | r217;
    L85:
        r217 = 4194304;
        goto L86
    L84:
        r13 = r42;
        goto L85
    L71:
        if ((r50 & 1572864) != 0) goto L78;
        if (r10.changed(r41) == false) goto L75;
        int r218 = 1048576;
    L76:
        r0 = r0 | r218;
        goto L78
    L75:
        r218 = 524288;
        goto L76
    L60:
        r5 = r40;
        if ((r50 & 196608) != 0) goto L67;
        if (r10.changed(r5) == false) goto L65;
        int r219 = 131072;
    L66:
        r0 = r0 | r219;
        goto L67
    L65:
        r219 = 65536;
        goto L66
    L50:
        if ((r50 & 24576) != 0) goto L56;
        r4 = r39;
        if (r10.changed(r4) == false) goto L54;
        int r220 = 16384;
    L55:
        r0 = r0 | r220;
        goto L57
    L54:
        r220 = 8192;
        goto L55
    L39:
        if ((r50 & 3072) != 0) goto L46;
        if (r10.changed(r38) == false) goto L43;
        int r221 = 2048;
    L44:
        r0 = r0 | r221;
        goto L46
    L43:
        r221 = 1024;
        goto L44
    L28:
        if ((r50 & 384) != 0) goto L35;
        if (r10.changed(r37) == false) goto L32;
        int r118 = 256;
    L33:
        r0 = r0 | r118;
        goto L35
    L32:
        r118 = 128;
        goto L33
    L17:
        if ((r50 & 48) != 0) goto L23;
        r6 = r36;
        if (r10.changed(r6) == false) goto L21;
        int r61 = 32;
    L22:
        r0 = r0 | r61;
        goto L24
    L21:
        r61 = 16;
        goto L22
    L6:
        if ((r50 & 6) == 0) goto L8;
        r0 = r50;
        goto L13
    L8:
        if (r10.changed(r35) == false) goto L10;
        int r62 = 4;
    L11:
        r0 = r62 | r50;
        goto L13
    L10:
        r62 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* JADX INFO: renamed from: VerticalPager-oI3XNZo, reason: not valid java name */
    public static final /* synthetic */ void m1260VerticalPageroI3XNZo(final PagerState r35, Modifier r36, PaddingValues r37, PageSize r38, int r39, float r40, Alignment.Horizontal r41, TargetedFlingBehavior r42, boolean r43, boolean r44, Function1 r45, NestedScrollConnection r46, SnapPosition r47, final Function4 r48, Composer r49, final int r50, final int r51, final int r52) {
        Composer r10 = r49.startRestartGroup(-1474550033);
        if ((r52 & 1) == 0) goto L6;
        int r0 = r50 | 6;
    L13:
        int r3 = r52 & 2;
        if (r3 == 0) goto L17;
        r0 = r0 | 48;
    L23:
        Modifier r6 = r36;
    L24:
        int r7 = r52 & 4;
        if (r7 == 0) goto L28;
        r0 = r0 | 384;
    L35:
        int r16 = r52 & 8;
        int r17 = 1024;
        if (r16 == 0) goto L39;
        r0 = r0 | 3072;
    L46:
        int r20 = r52 & 16;
        if (r20 == 0) goto L50;
        r0 = r0 | 24576;
    L56:
        int r4 = r39;
    L57:
        int r22 = r52 & 32;
        if (r22 == 0) goto L60;
        r0 = r0 | 196608;
        float r5 = r40;
    L67:
        int r25 = r52 & 64;
        if (r25 == 0) goto L71;
        r0 = r0 | 1572864;
    L78:
        if ((r50 & 12582912) == 0) goto L80;
        TargetedFlingBehavior r13 = r42;
    L88:
        int r9 = r52 & 256;
        if (r9 == 0) goto L92;
        r0 = r0 | 100663296;
    L98:
        int r8 = r52 & 512;
        if (r8 == 0) goto L102;
        int r30 = r0 | 805306368;
        r8 = r8;
    L110:
        int r1 = r52 & 1024;
        if (r1 == 0) goto L114;
        int r19 = r51 | 6;
    L122:
        if ((r51 & 48) != 0) goto L132;
        if ((r52 & 2048) != 0) goto L129;
        if (r10.changedInstance(r46) == false) goto L129;
        int r21 = 32;
    L130:
        r19 = r19 | r21;
    L129:
        r21 = 16;
    L132:
        int r2 = r19;
        int r11 = r52 & 4096;
        if (r11 == 0) goto L136;
        r2 = r2 | 384;
    L144:
        if ((r52 & 8192) == 0) goto L147;
        r2 = r2 | 3072;
    L153:
        boolean r18 = true;
        if ((r30 & 306783379) == 306783378) goto L156;
    L159:
        boolean r12 = true;
    L161:
        if (r10.shouldExecute(r12, r30 & 1) == false) goto L220;
        r10.startDefaults();
        if ((r50 & 1) != 0) goto L165;
    L174:
        if (r3 == 0) goto L176;
        Modifier r110 = Modifier.Companion;
    L177:
        if (r7 == 0) goto L179;
        PaddingValues r23 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L180:
        if (r16 == 0) goto L182;
        PageSize r111 = PageSize.Fill.INSTANCE;
    L183:
        if (r20 == 0) goto L185;
        int r24 = 0;
    L186:
        if (r22 == 0) goto L188;
        float r26 = Dp.constructor-impl(0);
    L189:
        if (r25 == 0) goto L191;
        Alignment.Horizontal r27 = Alignment.Companion.getCenterHorizontally();
    L193:
        if ((r52 & 128) == 0) goto L195;
        int r14 = 0;
        TargetedFlingBehavior r15 = PagerDefaults.INSTANCE.flingBehavior(r35, null, null, null, MenuKt.ClosedAlphaTarget, r10, (r30 & 14) | 196608, 30);
        r30 = r30 & (-29360129);
    L196:
        if (r9 != 0) goto L199;
        r18 = r43;
    L199:
        if (r8 == 0) goto L201;
        boolean r28 = false;
    L202:
        if (r1 == 0) goto L204;
        Function1 r29 = null;
    L206:
        if ((r52 & 2048) == 0) goto L208;
        NestedScrollConnection r31 = PagerDefaults.INSTANCE.pageNestedScrollConnection(r35, Orientation.Vertical, r10, (r30 & 14) | 432);
        r2 = r2 & (-113);
    L209:
        if (r11 == 0) goto L211;
        SnapPosition r32 = SnapPosition.Start.INSTANCE;
    L212:
        boolean r210 = r18;
        float r211 = r26;
        int r33 = r30;
        NestedScrollConnection r34 = r31;
        int r212 = r24;
        PageSize r213 = r111;
    L213:
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L216;
        ComposerKt.traceEventStart(-1474550033, r33, r2, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:333)");
    L216:
        Composer r214 = r10;
        m1259VerticalPager8jOkeI(r35, r110, r23, r213, r212, r211, r27, r15, r210, r28, r29, r34, r32, OverscrollKt.rememberOverscrollEffect(r10, r14), r48, r214, (((((((((r33 & 14) | (r33 & 112)) | (r33 & 896)) | (r33 & 7168)) | (57344 & r33)) | (458752 & r33)) | (3670016 & r33)) | (29360128 & r33)) | (234881024 & r33)) | (r33 & 1879048192), (((r2 & 14) | (r2 & 112)) | (r2 & 896)) | ((r2 << 3) & 57344), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L219;
        ComposerKt.traceEventEnd();
    L219:
        final Modifier r53 = r110;
        final PageSize r54 = r213;
        final PaddingValues r55 = r23;
        final int r56 = r212;
        final float r57 = r211;
        final Alignment.Horizontal r58 = r27;
        final TargetedFlingBehavior r59 = r15;
        final boolean r60 = r210;
        final boolean r112 = r28;
        final Function1 r113 = r29;
        final NestedScrollConnection r114 = r34;
        final SnapPosition r115 = r32;
    L221:
        ScopeUpdateScope r116 = r214.endRestartGroup();
        if (r116 == null) goto L225;
        r116.updateScope(new n(r35, r53, r55, r54, r56, r57, r58, r59, r60, r112, r113, r114, r115, r48, r50, r51, r52));
        return;
    L225:
        return;
    L211:
        r32 = r47;
        goto L212
    L208:
        r31 = r46;
        r2 = r2;
        goto L209
    L204:
        r29 = r45;
        goto L206
    L201:
        r28 = r44;
        goto L202
    L195:
        r14 = 0;
        r15 = r13;
        goto L196
    L191:
        r27 = r41;
        goto L193
    L188:
        r26 = r5;
        goto L189
    L185:
        r24 = r4;
        goto L186
    L182:
        r111 = r38;
        goto L183
    L179:
        r23 = r37;
        goto L180
    L176:
        r110 = r6;
        goto L177
    L165:
        if (r10.getDefaultsInvalid() == true) goto L174;
        r10.skipToGroupEnd();
        if ((r52 & 128) == 0) goto L171;
        r30 = r30 & (-29360129);
    L171:
        if ((r52 & 2048) == 0) goto L173;
        r2 = r2 & (-113);
    L173:
        r23 = r37;
        r213 = r38;
        r27 = r41;
        r210 = r43;
        r28 = r44;
        r29 = r45;
        r32 = r47;
        r212 = r4;
        r211 = r5;
        r110 = r6;
        r15 = r13;
        r33 = r30;
        r14 = 0;
        r34 = r46;
        goto L213
    L220:
        r214 = r10;
        r214.skipToGroupEnd();
        r55 = r37;
        r58 = r41;
        r60 = r43;
        r112 = r44;
        r113 = r45;
        r114 = r46;
        r53 = r6;
        r59 = r13;
        r115 = r47;
        r57 = r5;
        r56 = r4;
        r54 = r38;
        goto L221
    L156:
        if ((r2 & 1171) != 1170) goto L159;
        r12 = false;
        goto L161
    L147:
        if ((r51 & 3072) != 0) goto L153;
        if (r10.changedInstance(r48) == false) goto L151;
        r17 = 2048;
    L151:
        r2 = r2 | r17;
        goto L153
    L136:
        if ((r51 & 384) != 0) goto L144;
        if (r10.changed(r47) == false) goto L140;
        int r215 = 256;
    L141:
        r2 = r2 | r215;
        goto L144
    L140:
        r215 = 128;
        goto L141
    L114:
        if ((r51 & 6) == 0) goto L116;
        r19 = r51;
        goto L122
    L116:
        if (r10.changedInstance(r45) == false) goto L118;
        int r117 = 4;
    L119:
        r19 = r51 | r117;
        goto L122
    L118:
        r117 = 2;
        goto L119
    L102:
        if ((r50 & 805306368) != 0) goto L109;
        if (r10.changed(r44) == false) goto L106;
        int r310 = 536870912;
    L107:
        r0 = r0 | r310;
        goto L109
    L106:
        r310 = 268435456;
    L109:
        r30 = r0;
        goto L110
    L92:
        if ((r50 & 100663296) != 0) goto L98;
        if (r10.changed(r43) == false) goto L96;
        int r216 = 67108864;
    L97:
        r0 = r0 | r216;
        goto L98
    L96:
        r216 = 33554432;
        goto L97
    L80:
        if ((r52 & 128) != 0) goto L84;
        r13 = r42;
        if (r10.changed(r13) == false) goto L85;
        int r217 = 8388608;
    L86:
        r0 = r0 | r217;
    L85:
        r217 = 4194304;
        goto L86
    L84:
        r13 = r42;
        goto L85
    L71:
        if ((r50 & 1572864) != 0) goto L78;
        if (r10.changed(r41) == false) goto L75;
        int r218 = 1048576;
    L76:
        r0 = r0 | r218;
        goto L78
    L75:
        r218 = 524288;
        goto L76
    L60:
        r5 = r40;
        if ((r50 & 196608) != 0) goto L67;
        if (r10.changed(r5) == false) goto L65;
        int r219 = 131072;
    L66:
        r0 = r0 | r219;
        goto L67
    L65:
        r219 = 65536;
        goto L66
    L50:
        if ((r50 & 24576) != 0) goto L56;
        r4 = r39;
        if (r10.changed(r4) == false) goto L54;
        int r220 = 16384;
    L55:
        r0 = r0 | r220;
        goto L57
    L54:
        r220 = 8192;
        goto L55
    L39:
        if ((r50 & 3072) != 0) goto L46;
        if (r10.changed(r38) == false) goto L43;
        int r221 = 2048;
    L44:
        r0 = r0 | r221;
        goto L46
    L43:
        r221 = 1024;
        goto L44
    L28:
        if ((r50 & 384) != 0) goto L35;
        if (r10.changed(r37) == false) goto L32;
        int r118 = 256;
    L33:
        r0 = r0 | r118;
        goto L35
    L32:
        r118 = 128;
        goto L33
    L17:
        if ((r50 & 48) != 0) goto L23;
        r6 = r36;
        if (r10.changed(r6) == false) goto L21;
        int r61 = 32;
    L22:
        r0 = r0 | r61;
        goto L24
    L21:
        r61 = 16;
        goto L22
    L6:
        if ((r50 & 6) == 0) goto L8;
        r0 = r50;
        goto L13
    L8:
        if (r10.changed(r35) == false) goto L10;
        int r62 = 4;
    L11:
        r0 = r62 | r50;
        goto L13
    L10:
        r62 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: HorizontalPager--8jOkeI, reason: not valid java name */
    public static final void m1256HorizontalPager8jOkeI(final PagerState r37, Modifier r38, PaddingValues r39, PageSize r40, int r41, float r42, Alignment.Vertical r43, TargetedFlingBehavior r44, boolean r45, boolean r46, Function1<? super Integer, ? extends Object> r47, NestedScrollConnection r48, SnapPosition r49, OverscrollEffect r50, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> r51, Composer r52, final int r53, final int r54, final int r55) {
        Composer r10 = r52.startRestartGroup(1860873769);
        if ((r55 & 1) == 0) goto L6;
        int r0 = r53 | 6;
    L13:
        int r3 = r55 & 2;
        if (r3 == 0) goto L17;
        r0 = r0 | 48;
    L23:
        Modifier r6 = r38;
    L24:
        int r7 = r55 & 4;
        if (r7 == 0) goto L28;
        r0 = r0 | 384;
    L35:
        int r16 = r55 & 8;
        int r17 = 1024;
        if (r16 == 0) goto L39;
        r0 = r0 | 3072;
    L46:
        int r20 = r55 & 16;
        int r21 = 16384;
        if (r20 == 0) goto L50;
        r0 = r0 | 24576;
    L56:
        int r4 = r41;
    L57:
        int r24 = r55 & 32;
        if (r24 == 0) goto L60;
        r0 = r0 | 196608;
        float r5 = r42;
    L67:
        int r27 = r55 & 64;
        if (r27 == 0) goto L71;
        r0 = r0 | 1572864;
    L78:
        if ((r53 & 12582912) == 0) goto L80;
        TargetedFlingBehavior r13 = r44;
    L88:
        int r9 = r55 & 256;
        if (r9 == 0) goto L92;
        r0 = r0 | 100663296;
    L98:
        int r8 = r55 & 512;
        if (r8 == 0) goto L102;
        int r32 = r0 | 805306368;
        r8 = r8;
    L110:
        int r1 = r55 & 1024;
        if (r1 == 0) goto L114;
        int r19 = r54 | 6;
    L122:
        if ((r54 & 48) != 0) goto L132;
        if ((r55 & 2048) != 0) goto L129;
        if (r10.changedInstance(r48) == false) goto L129;
        int r23 = 32;
    L130:
        r19 = r19 | r23;
    L129:
        r23 = 16;
    L132:
        int r2 = r19;
        int r11 = r55 & 4096;
        if (r11 == 0) goto L136;
        r2 = r2 | 384;
    L144:
        if ((r54 & 3072) != 0) goto L154;
        if ((r55 & 8192) != 0) goto L151;
        if (r10.changed(r50) == false) goto L151;
        r17 = 2048;
    L151:
        r2 = r2 | r17;
    L154:
        if ((r55 & 16384) == 0) goto L157;
        r2 = r2 | 24576;
    L164:
        boolean r18 = true;
        if ((r32 & 306783379) == 306783378) goto L167;
    L170:
        boolean r12 = true;
    L172:
        if (r10.shouldExecute(r12, r32 & 1) == false) goto L238;
        r10.startDefaults();
        if ((r53 & 1) != 0) goto L176;
    L188:
        if (r3 == 0) goto L190;
        Modifier r110 = Modifier.Companion;
    L191:
        if (r7 == 0) goto L193;
        PaddingValues r22 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L194:
        if (r16 == 0) goto L196;
        PageSize r111 = PageSize.Fill.INSTANCE;
    L197:
        if (r20 == 0) goto L199;
        int r25 = 0;
    L200:
        if (r24 == 0) goto L202;
        float r26 = Dp.constructor-impl(0);
    L203:
        if (r27 == 0) goto L205;
        Alignment.Vertical r28 = Alignment.Companion.getCenterVertically();
    L207:
        if ((r55 & 128) == 0) goto L209;
        int r14 = 0;
        TargetedFlingBehavior r15 = PagerDefaults.INSTANCE.flingBehavior(r37, null, null, null, MenuKt.ClosedAlphaTarget, r10, (r32 & 14) | 196608, 30);
        r32 = r32 & (-29360129);
        r13 = r15;
    L210:
        if (r9 != 0) goto L213;
        r18 = r45;
    L213:
        if (r8 == 0) goto L215;
        boolean r29 = false;
    L216:
        if (r1 == 0) goto L218;
        Function1<? super Integer, ? extends Object> r30 = null;
    L220:
        if ((r55 & 2048) == 0) goto L222;
        NestedScrollConnection r31 = PagerDefaults.INSTANCE.pageNestedScrollConnection(r37, Orientation.Horizontal, r10, (r32 & 14) | 432);
        int r33 = r2 & (-113);
    L223:
        if (r11 == 0) goto L225;
        SnapPosition r34 = SnapPosition.Start.INSTANCE;
    L227:
        if ((r55 & 8192) == 0) goto L229;
        r2 = r33 & (-7169);
        OverscrollEffect r35 = OverscrollKt.rememberOverscrollEffect(r10, r14);
    L230:
        TargetedFlingBehavior r210 = r13;
        boolean r211 = r18;
        int r212 = r25;
        float r213 = r26;
        Alignment.Vertical r214 = r28;
        int r36 = r32;
        NestedScrollConnection r310 = r31;
        PageSize r215 = r111;
        PaddingValues r216 = r22;
        Modifier r217 = r110;
    L231:
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L234;
        ComposerKt.traceEventStart(1860873769, r36, r2, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:163)");
    L234:
        int r56 = r36 >> 6;
        int r57 = r36 << 12;
        int r112 = ((((((((((r36 >> 3) & 14) | 24576) | ((r36 << 3) & 112)) | (r36 & 896)) | ((r36 >> 18) & 7168)) | (458752 & r56)) | (3670016 & r56)) | ((r2 << 12) & 29360128)) | (234881024 & r57)) | (r57 & 1879048192);
        int r58 = (((r36 >> 9) & 14) | 3072) | (r2 & 112);
        int r59 = r2 << 6;
        Composer r311 = r10;
        LazyLayoutPagerKt.m1252PagereLwUrMk(r217, r37, r216, r29, Orientation.Horizontal, r210, r211, r35, r212, r213, r215, r310, r30, Alignment.Companion.getCenterHorizontally(), r214, r34, r51, r311, r112, (((r2 << 9) & 458752) | ((r58 | (r59 & 896)) | (r56 & 57344))) | (3670016 & r59), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L237;
        ComposerKt.traceEventEnd();
    L237:
        final Modifier r60 = r217;
        final PaddingValues r61 = r216;
        final PageSize r62 = r215;
        final int r63 = r212;
        final float r64 = r213;
        final Alignment.Vertical r65 = r214;
        final TargetedFlingBehavior r66 = r210;
        final boolean r67 = r211;
        final boolean r113 = r29;
        final Function1<? super Integer, ? extends Object> r114 = r30;
        final NestedScrollConnection r115 = r310;
        final SnapPosition r116 = r34;
        final OverscrollEffect r117 = r35;
    L239:
        ScopeUpdateScope r118 = r311.endRestartGroup();
        if (r118 == null) goto L243;
        r118.updateScope(new m(r37, r60, r61, r62, r63, r64, r65, r66, r67, r113, r114, r115, r116, r117, r51, r53, r54, r55));
        return;
    L243:
        return;
    L229:
        r35 = r50;
        r2 = r33;
        goto L230
    L225:
        r34 = r49;
        goto L227
    L222:
        r31 = r48;
        r33 = r2;
        goto L223
    L218:
        r30 = r47;
        goto L220
    L215:
        r29 = r46;
        goto L216
    L209:
        r14 = 0;
        goto L210
    L205:
        r28 = r43;
        goto L207
    L202:
        r26 = r5;
        goto L203
    L199:
        r25 = r4;
        goto L200
    L196:
        r111 = r40;
        goto L197
    L193:
        r22 = r39;
        goto L194
    L190:
        r110 = r6;
        goto L191
    L176:
        if (r10.getDefaultsInvalid() == true) goto L188;
        r10.skipToGroupEnd();
        if ((r55 & 128) == 0) goto L182;
        r32 = r32 & (-29360129);
    L182:
        if ((r55 & 2048) == 0) goto L185;
        r2 = r2 & (-113);
    L185:
        if ((r55 & 8192) == 0) goto L187;
        r2 = r2 & (-7169);
    L187:
        r216 = r39;
        r215 = r40;
        r214 = r43;
        r211 = r45;
        r29 = r46;
        r30 = r47;
        r34 = r49;
        r35 = r50;
        r212 = r4;
        r213 = r5;
        r217 = r6;
        r210 = r13;
        r36 = r32;
        r310 = r48;
        goto L231
    L238:
        r311 = r10;
        r311.skipToGroupEnd();
        r61 = r39;
        r65 = r43;
        r67 = r45;
        r113 = r46;
        r114 = r47;
        r115 = r48;
        r117 = r50;
        r60 = r6;
        r66 = r13;
        r116 = r49;
        r64 = r5;
        r63 = r4;
        r62 = r40;
        goto L239
    L167:
        if ((r2 & 9363) != 9362) goto L170;
        r12 = false;
        goto L172
    L157:
        if ((r54 & 24576) != 0) goto L164;
        if (r10.changedInstance(r51) == true) goto L162;
        r21 = 8192;
    L162:
        r2 = r2 | r21;
        goto L164
    L136:
        if ((r54 & 384) != 0) goto L144;
        if (r10.changed(r49) == false) goto L140;
        int r218 = 256;
    L141:
        r2 = r2 | r218;
        goto L144
    L140:
        r218 = 128;
        goto L141
    L114:
        if ((r54 & 6) == 0) goto L116;
        r19 = r54;
        goto L122
    L116:
        if (r10.changedInstance(r47) == false) goto L118;
        int r119 = 4;
    L119:
        r19 = r54 | r119;
        goto L122
    L118:
        r119 = 2;
        goto L119
    L102:
        if ((r53 & 805306368) != 0) goto L109;
        if (r10.changed(r46) == false) goto L106;
        int r312 = 536870912;
    L107:
        r0 = r0 | r312;
        goto L109
    L106:
        r312 = 268435456;
    L109:
        r32 = r0;
        goto L110
    L92:
        if ((r53 & 100663296) != 0) goto L98;
        if (r10.changed(r45) == false) goto L96;
        int r313 = 67108864;
    L97:
        r0 = r0 | r313;
        goto L98
    L96:
        r313 = 33554432;
        goto L97
    L80:
        if ((r55 & 128) != 0) goto L84;
        r13 = r44;
        if (r10.changed(r13) == false) goto L85;
        int r314 = 8388608;
    L86:
        r0 = r0 | r314;
    L85:
        r314 = 4194304;
        goto L86
    L84:
        r13 = r44;
        goto L85
    L71:
        if ((r53 & 1572864) != 0) goto L78;
        if (r10.changed(r43) == false) goto L75;
        int r219 = 1048576;
    L76:
        r0 = r0 | r219;
        goto L78
    L75:
        r219 = 524288;
        goto L76
    L60:
        r5 = r42;
        if ((r53 & 196608) != 0) goto L67;
        if (r10.changed(r5) == false) goto L65;
        int r220 = 131072;
    L66:
        r0 = r0 | r220;
        goto L67
    L65:
        r220 = 65536;
        goto L66
    L50:
        if ((r53 & 24576) != 0) goto L56;
        r4 = r41;
        if (r10.changed(r4) == false) goto L54;
        int r221 = 16384;
    L55:
        r0 = r0 | r221;
        goto L57
    L54:
        r221 = 8192;
        goto L55
    L39:
        if ((r53 & 3072) != 0) goto L46;
        if (r10.changed(r40) == false) goto L43;
        int r222 = 2048;
    L44:
        r0 = r0 | r222;
        goto L46
    L43:
        r222 = 1024;
        goto L44
    L28:
        if ((r53 & 384) != 0) goto L35;
        if (r10.changed(r39) == false) goto L32;
        int r120 = 256;
    L33:
        r0 = r0 | r120;
        goto L35
    L32:
        r120 = 128;
        goto L33
    L17:
        if ((r53 & 48) != 0) goto L23;
        r6 = r38;
        if (r10.changed(r6) == false) goto L21;
        int r68 = 32;
    L22:
        r0 = r0 | r68;
        goto L24
    L21:
        r68 = 16;
        goto L22
    L6:
        if ((r53 & 6) == 0) goto L8;
        r0 = r53;
        goto L13
    L8:
        if (r10.changed(r37) == false) goto L10;
        int r69 = 4;
    L11:
        r0 = r69 | r53;
        goto L13
    L10:
        r69 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: VerticalPager--8jOkeI, reason: not valid java name */
    public static final void m1259VerticalPager8jOkeI(final PagerState r37, Modifier r38, PaddingValues r39, PageSize r40, int r41, float r42, Alignment.Horizontal r43, TargetedFlingBehavior r44, boolean r45, boolean r46, Function1<? super Integer, ? extends Object> r47, NestedScrollConnection r48, SnapPosition r49, OverscrollEffect r50, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> r51, Composer r52, final int r53, final int r54, final int r55) {
        Composer r10 = r52.startRestartGroup(-1590376023);
        if ((r55 & 1) == 0) goto L6;
        int r0 = r53 | 6;
    L13:
        int r3 = r55 & 2;
        if (r3 == 0) goto L17;
        r0 = r0 | 48;
    L23:
        Modifier r6 = r38;
    L24:
        int r7 = r55 & 4;
        if (r7 == 0) goto L28;
        r0 = r0 | 384;
    L35:
        int r16 = r55 & 8;
        int r17 = 1024;
        if (r16 == 0) goto L39;
        r0 = r0 | 3072;
    L46:
        int r20 = r55 & 16;
        int r21 = 16384;
        if (r20 == 0) goto L50;
        r0 = r0 | 24576;
    L56:
        int r4 = r41;
    L57:
        int r24 = r55 & 32;
        if (r24 == 0) goto L60;
        r0 = r0 | 196608;
        float r5 = r42;
    L67:
        int r27 = r55 & 64;
        if (r27 == 0) goto L71;
        r0 = r0 | 1572864;
    L78:
        if ((r53 & 12582912) == 0) goto L80;
        TargetedFlingBehavior r14 = r44;
    L88:
        int r9 = r55 & 256;
        if (r9 == 0) goto L92;
        r0 = r0 | 100663296;
    L98:
        int r8 = r55 & 512;
        if (r8 == 0) goto L102;
        int r32 = r0 | 805306368;
        r8 = r8;
    L110:
        int r1 = r55 & 1024;
        if (r1 == 0) goto L114;
        int r19 = r54 | 6;
    L122:
        if ((r54 & 48) != 0) goto L132;
        if ((r55 & 2048) != 0) goto L129;
        if (r10.changedInstance(r48) == false) goto L129;
        int r23 = 32;
    L130:
        r19 = r19 | r23;
    L129:
        r23 = 16;
    L132:
        int r2 = r19;
        int r11 = r55 & 4096;
        if (r11 == 0) goto L136;
        r2 = r2 | 384;
    L144:
        if ((r54 & 3072) != 0) goto L154;
        if ((r55 & 8192) != 0) goto L151;
        if (r10.changed(r50) == false) goto L151;
        r17 = 2048;
    L151:
        r2 = r2 | r17;
    L154:
        if ((r55 & 16384) == 0) goto L157;
        r2 = r2 | 24576;
    L164:
        boolean r18 = true;
        if ((r32 & 306783379) == 306783378) goto L167;
    L170:
        boolean r12 = true;
    L172:
        if (r10.shouldExecute(r12, r32 & 1) == false) goto L238;
        r10.startDefaults();
        if ((r53 & 1) != 0) goto L176;
    L188:
        if (r3 == 0) goto L190;
        Modifier r110 = Modifier.Companion;
    L191:
        if (r7 == 0) goto L193;
        PaddingValues r22 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L194:
        if (r16 == 0) goto L196;
        PageSize r111 = PageSize.Fill.INSTANCE;
    L197:
        if (r20 == 0) goto L199;
        int r25 = 0;
    L200:
        if (r24 == 0) goto L202;
        float r26 = Dp.constructor-impl(0);
    L203:
        if (r27 == 0) goto L205;
        Alignment.Horizontal r28 = Alignment.Companion.getCenterHorizontally();
    L207:
        if ((r55 & 128) == 0) goto L209;
        int r13 = 0;
        TargetedFlingBehavior r15 = PagerDefaults.INSTANCE.flingBehavior(r37, null, null, null, MenuKt.ClosedAlphaTarget, r10, (r32 & 14) | 196608, 30);
        r32 = r32 & (-29360129);
        r14 = r15;
    L210:
        if (r9 != 0) goto L213;
        r18 = r45;
    L213:
        if (r8 == 0) goto L215;
        boolean r29 = false;
    L216:
        if (r1 == 0) goto L218;
        Function1<? super Integer, ? extends Object> r30 = null;
    L220:
        if ((r55 & 2048) == 0) goto L222;
        NestedScrollConnection r31 = PagerDefaults.INSTANCE.pageNestedScrollConnection(r37, Orientation.Vertical, r10, (r32 & 14) | 432);
        int r33 = r2 & (-113);
    L223:
        if (r11 == 0) goto L225;
        SnapPosition r34 = SnapPosition.Start.INSTANCE;
    L227:
        if ((r55 & 8192) == 0) goto L229;
        r2 = r33 & (-7169);
        OverscrollEffect r35 = OverscrollKt.rememberOverscrollEffect(r10, r13);
    L230:
        TargetedFlingBehavior r210 = r14;
        boolean r211 = r18;
        int r212 = r25;
        float r213 = r26;
        Alignment.Horizontal r214 = r28;
        int r36 = r32;
        NestedScrollConnection r310 = r31;
        PageSize r215 = r111;
        PaddingValues r216 = r22;
        Modifier r217 = r110;
    L231:
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L234;
        ComposerKt.traceEventStart(-1590376023, r36, r2, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:293)");
    L234:
        int r56 = r36 >> 6;
        int r57 = ((((((((r36 >> 3) & 14) | 24576) | ((r36 << 3) & 112)) | (r36 & 896)) | ((r36 >> 18) & 7168)) | (458752 & r56)) | (r56 & 3670016)) | ((r2 << 12) & 29360128);
        int r58 = r36 << 12;
        int r112 = (r57 | (234881024 & r58)) | (r58 & 1879048192);
        int r59 = r36 >> 9;
        int r60 = ((r59 & 14) | 24576) | (r2 & 112);
        int r61 = r2 << 6;
        int r62 = (r2 << 9) & 458752;
        Composer r311 = r10;
        LazyLayoutPagerKt.m1252PagereLwUrMk(r217, r37, r216, r29, Orientation.Vertical, r210, r211, r35, r212, r213, r215, r310, r30, r214, Alignment.Companion.getCenterVertically(), r34, r51, r311, r112, (r62 | ((r59 & 7168) | (r60 | (r61 & 896)))) | (3670016 & r61), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L237;
        ComposerKt.traceEventEnd();
    L237:
        final Modifier r63 = r217;
        final PaddingValues r64 = r216;
        final PageSize r65 = r215;
        final int r66 = r212;
        final float r67 = r213;
        final Alignment.Horizontal r68 = r214;
        final TargetedFlingBehavior r69 = r210;
        final boolean r70 = r211;
        final boolean r113 = r29;
        final Function1<? super Integer, ? extends Object> r114 = r30;
        final NestedScrollConnection r115 = r310;
        final SnapPosition r116 = r34;
        final OverscrollEffect r117 = r35;
    L239:
        ScopeUpdateScope r118 = r311.endRestartGroup();
        if (r118 == null) goto L243;
        r118.updateScope(new o(r37, r63, r64, r65, r66, r67, r68, r69, r70, r113, r114, r115, r116, r117, r51, r53, r54, r55));
        return;
    L243:
        return;
    L229:
        r35 = r50;
        r2 = r33;
        goto L230
    L225:
        r34 = r49;
        goto L227
    L222:
        r31 = r48;
        r33 = r2;
        goto L223
    L218:
        r30 = r47;
        goto L220
    L215:
        r29 = r46;
        goto L216
    L209:
        r13 = 0;
        goto L210
    L205:
        r28 = r43;
        goto L207
    L202:
        r26 = r5;
        goto L203
    L199:
        r25 = r4;
        goto L200
    L196:
        r111 = r40;
        goto L197
    L193:
        r22 = r39;
        goto L194
    L190:
        r110 = r6;
        goto L191
    L176:
        if (r10.getDefaultsInvalid() == true) goto L188;
        r10.skipToGroupEnd();
        if ((r55 & 128) == 0) goto L182;
        r32 = r32 & (-29360129);
    L182:
        if ((r55 & 2048) == 0) goto L185;
        r2 = r2 & (-113);
    L185:
        if ((r55 & 8192) == 0) goto L187;
        r2 = r2 & (-7169);
    L187:
        r216 = r39;
        r215 = r40;
        r214 = r43;
        r211 = r45;
        r29 = r46;
        r30 = r47;
        r34 = r49;
        r35 = r50;
        r212 = r4;
        r213 = r5;
        r217 = r6;
        r210 = r14;
        r36 = r32;
        r310 = r48;
        goto L231
    L238:
        r311 = r10;
        r311.skipToGroupEnd();
        r64 = r39;
        r68 = r43;
        r70 = r45;
        r113 = r46;
        r114 = r47;
        r115 = r48;
        r116 = r49;
        r63 = r6;
        r69 = r14;
        r117 = r50;
        r67 = r5;
        r66 = r4;
        r65 = r40;
        goto L239
    L167:
        if ((r2 & 9363) != 9362) goto L170;
        r12 = false;
        goto L172
    L157:
        if ((r54 & 24576) != 0) goto L164;
        if (r10.changedInstance(r51) == true) goto L162;
        r21 = 8192;
    L162:
        r2 = r2 | r21;
        goto L164
    L136:
        if ((r54 & 384) != 0) goto L144;
        if (r10.changed(r49) == false) goto L140;
        int r218 = 256;
    L141:
        r2 = r2 | r218;
        goto L144
    L140:
        r218 = 128;
        goto L141
    L114:
        if ((r54 & 6) == 0) goto L116;
        r19 = r54;
        goto L122
    L116:
        if (r10.changedInstance(r47) == false) goto L118;
        int r119 = 4;
    L119:
        r19 = r54 | r119;
        goto L122
    L118:
        r119 = 2;
        goto L119
    L102:
        if ((r53 & 805306368) != 0) goto L109;
        if (r10.changed(r46) == false) goto L106;
        int r312 = 536870912;
    L107:
        r0 = r0 | r312;
        goto L109
    L106:
        r312 = 268435456;
    L109:
        r32 = r0;
        goto L110
    L92:
        if ((r53 & 100663296) != 0) goto L98;
        if (r10.changed(r45) == false) goto L96;
        int r313 = 67108864;
    L97:
        r0 = r0 | r313;
        goto L98
    L96:
        r313 = 33554432;
        goto L97
    L80:
        if ((r55 & 128) != 0) goto L84;
        r14 = r44;
        if (r10.changed(r14) == false) goto L85;
        int r314 = 8388608;
    L86:
        r0 = r0 | r314;
    L85:
        r314 = 4194304;
        goto L86
    L84:
        r14 = r44;
        goto L85
    L71:
        if ((r53 & 1572864) != 0) goto L78;
        if (r10.changed(r43) == false) goto L75;
        int r219 = 1048576;
    L76:
        r0 = r0 | r219;
        goto L78
    L75:
        r219 = 524288;
        goto L76
    L60:
        r5 = r42;
        if ((r53 & 196608) != 0) goto L67;
        if (r10.changed(r5) == false) goto L65;
        int r220 = 131072;
    L66:
        r0 = r0 | r220;
        goto L67
    L65:
        r220 = 65536;
        goto L66
    L50:
        if ((r53 & 24576) != 0) goto L56;
        r4 = r41;
        if (r10.changed(r4) == false) goto L54;
        int r221 = 16384;
    L55:
        r0 = r0 | r221;
        goto L57
    L54:
        r221 = 8192;
        goto L55
    L39:
        if ((r53 & 3072) != 0) goto L46;
        if (r10.changed(r40) == false) goto L43;
        int r222 = 2048;
    L44:
        r0 = r0 | r222;
        goto L46
    L43:
        r222 = 1024;
        goto L44
    L28:
        if ((r53 & 384) != 0) goto L35;
        if (r10.changed(r39) == false) goto L32;
        int r120 = 256;
    L33:
        r0 = r0 | r120;
        goto L35
    L32:
        r120 = 128;
        goto L33
    L17:
        if ((r53 & 48) != 0) goto L23;
        r6 = r38;
        if (r10.changed(r6) == false) goto L21;
        int r71 = 32;
    L22:
        r0 = r0 | r71;
        goto L24
    L21:
        r71 = 16;
        goto L22
    L6:
        if ((r53 & 6) == 0) goto L8;
        r0 = r53;
        goto L13
    L8:
        if (r10.changed(r37) == false) goto L10;
        int r72 = 4;
    L11:
        r0 = r72 | r53;
        goto L13
    L10:
        r72 = 2;
        goto L11
    }
}
