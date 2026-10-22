package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0087\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0004\b \u0010!\u001a!\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010&\u001a7\u0010'\u001a\u00020$2\b\b\u0002\u0010(\u001a\u00020)2\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010+\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010,\u001a\u008a\u0001\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b4\u00105\u001aq\u00106\u001a\u00020\u00012\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00162\u0006\u0010;\u001a\u00020$H\u0003¢\u0006\u0002\u0010<\u001a\u0014\u0010=\u001a\u00020\b*\u00020\b2\u0006\u0010.\u001a\u00020$H\u0000\u001a\u0014\u0010>\u001a\u00020\b*\u00020\b2\u0006\u0010.\u001a\u00020$H\u0000¨\u0006?"}, d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "Landroidx/compose/material3/SheetState;", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "StandardBottomSheet", "state", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-w7I5h1o", "(Landroidx/compose/material3/SheetState;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;Landroidx/compose/runtime/Composer;I)V", "verticalScaleUp", "verticalScaleDown", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetScaffoldKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SheetValue.values().length];
            r0[SheetValue.Hidden.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SheetValue.PartiallyExpanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SheetValue.Expanded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final Unit BottomSheetScaffoldLayout$lambda$16(Function2 r9, Function2 r10, Function2 r11, Function2 r12, Function0 r13, SheetState r14, int r15, Composer r16, int r17) {
        BottomSheetScaffoldLayout(r9, r10, r11, r12, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit BottomSheetScaffold_sdMYb0k$lambda$1(Function3 r25, Modifier r26, BottomSheetScaffoldState r27, float r28, float r29, Shape r30, long r31, long r33, float r35, float r36, Function2 r37, boolean r38, Function2 r39, Function3 r40, long r41, long r43, Function3 r45, int r46, int r47, int r48, Composer r49, int r50) {
        m2338BottomSheetScaffoldsdMYb0k(r25, r26, r27, r28, r29, r30, r31, r33, r35, r36, r37, r38, r39, r40, r41, r43, r45, r49, RecomposeScopeImplKt.updateChangedFlags(r46 | 1), RecomposeScopeImplKt.updateChangedFlags(r47), r48);
        return Unit.INSTANCE;
    }

    private static final Unit StandardBottomSheet_w7I5h1o$lambda$14(SheetState r17, float r18, float r19, boolean r20, Shape r21, long r22, long r24, float r26, float r27, Function2 r28, Function3 r29, int r30, int r31, Composer r32, int r33) {
        m2339StandardBottomSheetw7I5h1o(r17, r18, r19, r20, r21, r22, r24, r26, r27, r28, r29, r32, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Function2 r1, Function2 r2, Function2 r3, Function0 r4, SheetState r5, int r6, Composer r7, int r8) {
        return BottomSheetScaffoldLayout$lambda$16(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit b(SheetState r0, GraphicsLayerScope r1) {
        return verticalScaleUp$lambda$17(r0, r1);
    }

    public static /* synthetic */ Unit c(CoroutineScope r0, SheetState r1, float r2) {
        return StandardBottomSheet_w7I5h1o$lambda$10$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(Function3 r1, Modifier r2, BottomSheetScaffoldState r3, float r4, float r5, Shape r6, long r7, long r9, float r11, float r12, Function2 r13, boolean r14, Function2 r15, Function3 r16, long r17, long r19, Function3 r21, int r22, int r23, int r24, Composer r25, int r26) {
        return BottomSheetScaffold_sdMYb0k$lambda$1(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17, r19, r21, r22, r23, r24, r25, r26);
    }

    public static /* synthetic */ Unit e(SheetState r0, float r1, float r2, float r3, DraggableAnchorsConfig r4) {
        return StandardBottomSheet_w7I5h1o$lambda$13$lambda$12$lambda$11(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean f(SheetValue r0) {
        return rememberStandardBottomSheetState$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ Pair g(SheetState r0, float r1, IntSize r2, Constraints r3) {
        return StandardBottomSheet_w7I5h1o$lambda$13$lambda$12(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit h(SheetState r1, float r2, float r3, boolean r4, Shape r5, long r6, long r8, float r10, float r11, Function2 r12, Function3 r13, int r14, int r15, Composer r16, int r17) {
        return StandardBottomSheet_w7I5h1o$lambda$14(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit i(SheetState r0, FiniteAnimationSpec r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3) {
        return StandardBottomSheet_w7I5h1o$lambda$7$lambda$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit j(SheetState r0, GraphicsLayerScope r1) {
        return verticalScaleDown$lambda$18(r0, r1);
    }

    private static final boolean rememberStandardBottomSheetState$lambda$5$lambda$4(SheetValue r0) {
        return true;
    }

    public static final Modifier verticalScaleDown(Modifier r1, final SheetState r2) {
        return GraphicsLayerModifierKt.graphicsLayer(r1, new c2(r2));
    }

    private static final Unit verticalScaleDown$lambda$18(SheetState r8, GraphicsLayerScope r9) {
        float r0 = r8.getAnchoredDraggableState$material3().getOffset();
        float r10 = r8.getAnchoredDraggableState$material3().getAnchors().minAnchor();
        if (r0 >= r10) goto L5;
        float r11 = r10 - r0;
    L7:
        if (r11 <= MenuKt.ClosedAlphaTarget) goto L9;
        float r1 = 1 / ((Float.intBitsToFloat((int) (r9.getSize-NH-jbRc() & 4294967295L)) + r11) / Float.intBitsToFloat((int) (r9.getSize-NH-jbRc() & 4294967295L)));
    L10:
        r9.setScaleY(r1);
        r9.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, MenuKt.ClosedAlphaTarget));
        return Unit.INSTANCE;
    L9:
        r1 = 1.0f;
        goto L10
    L5:
        r11 = MenuKt.ClosedAlphaTarget;
        goto L7
    }

    public static final Modifier verticalScaleUp(Modifier r1, final SheetState r2) {
        return GraphicsLayerModifierKt.graphicsLayer(r1, new z1(r2));
    }

    private static final Unit verticalScaleUp$lambda$17(SheetState r6, GraphicsLayerScope r7) {
        float r0 = r6.getAnchoredDraggableState$material3().getOffset();
        float r8 = r6.getAnchoredDraggableState$material3().getAnchors().minAnchor();
        if (r0 >= r8) goto L5;
        float r9 = r8 - r0;
    L7:
        if (r9 <= MenuKt.ClosedAlphaTarget) goto L9;
        float r1 = (Float.intBitsToFloat((int) (r7.getSize-NH-jbRc() & 4294967295L)) + r9) / Float.intBitsToFloat((int) (r7.getSize-NH-jbRc() & 4294967295L));
    L10:
        r7.setScaleY(r1);
        r7.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, MenuKt.ClosedAlphaTarget));
        return Unit.INSTANCE;
    L9:
        r1 = 1.0f;
        goto L10
    L5:
        r9 = MenuKt.ClosedAlphaTarget;
        goto L7
    }

    private static final Unit StandardBottomSheet_w7I5h1o$lambda$10$lambda$9(CoroutineScope r6, SheetState r7, float r8) {
        BuildersKt.launch$default(r6, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$nestedScroll$1$1$1(r7, r8, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final Pair StandardBottomSheet_w7I5h1o$lambda$13$lambda$12(final SheetState r4, final float r5, IntSize r6, Constraints r7) {
        final float r8 = Constraints.getMaxHeight-impl(r7.unbox-impl());
        final float r9 = (int) (r6.unbox-impl() & 4294967295L);
        DraggableAnchors r10 = AnchoredDraggableKt.DraggableAnchors(new a2(r4, r8, r5, r9));
        SheetValue r11 = (SheetValue) r4.getAnchoredDraggableState$material3().getTargetValue();
        int r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r12 != 1) goto L5;
        SheetValue r13 = SheetValue.Hidden;
        if (r10.hasAnchorFor(r13) == false) goto L32;
    L30:
        r11 = r13;
    L32:
        return TuplesKt.to(r10, r11);
    L5:
        if (r12 != 2) goto L7;
        r13 = SheetValue.PartiallyExpanded;
        if (r10.hasAnchorFor(r13) == true) goto L30;
        r13 = SheetValue.Expanded;
        if (r10.hasAnchorFor(r13) == true) goto L30;
        r13 = SheetValue.Hidden;
        if (r10.hasAnchorFor(r13) == false) goto L32;
    L7:
        if (r12 != 3) goto L18;
        r13 = SheetValue.Expanded;
        if (r10.hasAnchorFor(r13) == true) goto L30;
        r13 = SheetValue.PartiallyExpanded;
        if (r10.hasAnchorFor(r13) == true) goto L30;
        r13 = SheetValue.Hidden;
        if (r10.hasAnchorFor(r13) == false) goto L32;
    L18:
        throw new NoWhenBranchMatchedException();
    }

    private static final Unit StandardBottomSheet_w7I5h1o$lambda$7$lambda$6(SheetState r0, FiniteAnimationSpec r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3) {
        r0.setShowMotionSpec$material3(r1);
        r0.setHideMotionSpec$material3(r2);
        r0.setAnchoredDraggableMotionSpec$material3(r3);
        return Unit.INSTANCE;
    }

    private static final Unit StandardBottomSheet_w7I5h1o$lambda$13$lambda$12$lambda$11(SheetState r2, float r3, float r4, float r5, DraggableAnchorsConfig r6) {
        if (r2.getSkipPartiallyExpanded$material3() == true) goto L6;
        r6.at(SheetValue.PartiallyExpanded, r3 - r4);
    L6:
        if (r5 != r4) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == true) goto L12;
        r6.at(SheetValue.Expanded, Math.max(r3 - r5, MenuKt.ClosedAlphaTarget));
    L12:
        if (r2.getSkipHiddenState$material3() == true) goto L15;
        r6.at(SheetValue.Hidden, r3);
    L15:
        return Unit.INSTANCE;
    L8:
        r7 = false;
        goto L9
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState r7, SnackbarHostState r8, Composer r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r7 = rememberStandardBottomSheetState(null, null, false, r9, 0, 7);
    L6:
        if ((r11 & 2) == 0) goto L12;
        Object r12 = r9.rememberedValue();
        if (r12 != Composer.Companion.getEmpty()) goto L10;
        r12 = new SnackbarHostState();
        r9.updateRememberedValue(r12);
    L10:
        r8 = (SnackbarHostState) r12;
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(-1474606134, r10, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:191)");
    L14:
        boolean r0 = false;
        if (((r10 & 14) ^ 6) <= 4) goto L19;
        if (r9.changed(r7) == false) goto L19;
    L20:
        boolean r13 = true;
    L23:
        if (((r10 & 112) ^ 48) <= 32) goto L27;
        if (r9.changed(r8) == false) goto L27;
    L28:
        r0 = true;
    L29:
        boolean r14 = r13 | r0;
        Object r15 = r9.rememberedValue();
        if (r14 == false) goto L32;
    L33:
        r15 = new BottomSheetScaffoldState(r7, r8);
        r9.updateRememberedValue(r15);
    L34:
        BottomSheetScaffoldState r16 = (BottomSheetScaffoldState) r15;
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
    L37:
        return r16;
    L32:
        if (r15 != Composer.Companion.getEmpty()) goto L34;
    L27:
        if ((r10 & 48) != 32) goto L29;
    L19:
        if ((r10 & 6) == 4) goto L20;
        r13 = false;
        goto L23
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue r9, Function1<? super SheetValue, Boolean> r10, boolean r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r9 = SheetValue.PartiallyExpanded;
    L5:
        SheetValue r2 = r9;
        if ((r14 & 2) == 0) goto L11;
        Object r15 = r12.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L10;
        r15 = new y1();
        r12.updateRememberedValue(r15);
    L10:
        r10 = (Function1) r15;
    L11:
        Function1<? super SheetValue, Boolean> r1 = r10;
        if ((r14 & 4) == 0) goto L14;
        boolean r3 = true;
    L16:
        if (ComposerKt.isTraceInProgress() == false) goto L18;
        ComposerKt.traceEventStart(678511581, r13, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:215)");
    L18:
        SheetState r16 = SheetDefaultsKt.m3114rememberSheetStateAGcomas(false, r1, r2, r3, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r12, ((r13 & 112) | ((r13 << 6) & 896)) | ((r13 << 3) & 7168), 49);
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
    L21:
        return r16;
    L14:
        r3 = r11;
        goto L16
    }

    private static final void BottomSheetScaffoldLayout(final Function2<? super Composer, ? super Integer, Unit> r17, final Function2<? super Composer, ? super Integer, Unit> r18, final Function2<? super Composer, ? super Integer, Unit> r19, final Function2<? super Composer, ? super Integer, Unit> r20, final Function0<Float> r21, final SheetState r22, Composer r23, final int r24) {
        Composer r8 = r23.startRestartGroup(-1217723575);
        if ((r24 & 6) == 0) goto L5;
        int r9 = r24;
    L11:
        if ((r24 & 48) != 0) goto L18;
        if (r8.changedInstance(r18) == false) goto L15;
        int r12 = 32;
    L16:
        r9 = r9 | r12;
        goto L18
    L15:
        r12 = 16;
    L18:
        if ((r24 & 384) != 0) goto L25;
        if (r8.changedInstance(r19) == false) goto L22;
        int r13 = 256;
    L23:
        r9 = r9 | r13;
        goto L25
    L22:
        r13 = 128;
    L25:
        if ((r24 & 3072) != 0) goto L32;
        if (r8.changedInstance(r20) == false) goto L29;
        int r14 = 2048;
    L30:
        r9 = r9 | r14;
        goto L32
    L29:
        r14 = 1024;
    L32:
        if ((r24 & 24576) != 0) goto L39;
        if (r8.changedInstance(r21) == false) goto L36;
        int r15 = 16384;
    L37:
        r9 = r9 | r15;
        goto L39
    L36:
        r15 = 8192;
    L39:
        if ((196608 & r24) == 0) goto L41;
    L45:
        boolean r16 = true;
        if ((74899 & r9) == 74898) goto L48;
        boolean r110 = true;
    L50:
        if (r8.shouldExecute(r110, r9 & 1) == true) goto L52;
        r8.skipToGroupEnd();
    L95:
        ScopeUpdateScope r10 = r8.endRestartGroup();
        if (r10 == null) goto L99;
        r10.updateScope(new t1(r17, r18, r19, r20, r21, r22, r24));
        return;
    L99:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(-1217723575, r9, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:413)");
    L54:
        Function2[] r0 = new Function2[4];
        if (r17 != null) goto L57;
        Function2<? super Composer, ? super Integer, Unit> r11 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m2530getLambda$788244078$material3();
    L58:
        r0[0] = r11;
        r0[1] = r18;
        r0[2] = r19;
        r0[3] = r20;
        List r1 = CollectionsKt.listOf(r0);
        if ((458752 & r9) != 131072) goto L61;
        boolean r111 = true;
    L63:
        if ((r9 & 57344) != 16384) goto L65;
        boolean r25 = true;
    L66:
        boolean r26 = r25 | r111;
        Object r112 = r8.rememberedValue();
        if (r26 == false) goto L69;
    L70:
        r112 = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(r22, r21);
        r8.updateRememberedValue(r112);
    L71:
        MultiContentMeasurePolicy r113 = (MultiContentMeasurePolicy) r112;
        Modifier.Companion r27 = Modifier.Companion;
        Function2 r2 = LayoutKt.combineAsVirtualLayouts(r1);
        if (r8.changed(r113) == true) goto L74;
        r16 = false;
    L74:
        Object r114 = r8.rememberedValue();
        if (r16 == false) goto L77;
    L78:
        r114 = MultiContentMeasurePolicyKt.createMeasurePolicy(r113);
        r8.updateRememberedValue(r114);
    L79:
        MeasurePolicy r115 = (MeasurePolicy) r114;
        int r116 = ComposablesKt.getCurrentCompositeKeyHash(r8, 0);
        CompositionLocalMap r117 = r8.getCurrentCompositionLocalMap();
        Modifier r28 = ComposedModifierKt.materializeModifier(r8, r27);
        ComposeUiNode.Companion r118 = ComposeUiNode.Companion;
        Function0 r119 = r118.getConstructor();
        if ((r8.getApplier() instanceof Applier) == true) goto L82;
        ComposablesKt.invalidApplier();
    L82:
        r8.startReusableNode();
        if (r8.getInserting() == false) goto L85;
        r8.createNode(r119);
    L86:
        Composer r120 = Updater.constructor-impl(r8);
        Updater.set-impl(r120, r115, r118.getSetMeasurePolicy());
        Updater.set-impl(r120, r117, r118.getSetResolvedCompositionLocals());
        Function2 r121 = r118.getSetCompositeKeyHash();
        if (r120.getInserting() == false) goto L89;
    L90:
        r120.updateRememberedValue(Integer.valueOf(r116));
        r120.apply(Integer.valueOf(r116), r121);
    L91:
        Updater.set-impl(r120, r28, r118.getSetModifier());
        r2.invoke(r8, 0);
        r8.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventEnd();
        goto L95
    L89:
        if (Intrinsics.areEqual(r120.rememberedValue(), Integer.valueOf(r116)) == true) goto L91;
    L85:
        r8.useNode();
        goto L86
    L77:
        if (r114 != Composer.Companion.getEmpty()) goto L79;
    L69:
        if (r112 != Composer.Companion.getEmpty()) goto L71;
    L65:
        r25 = false;
        goto L66
    L61:
        r111 = false;
        goto L63
    L57:
        r11 = r17;
        goto L58
    L48:
        r110 = false;
        goto L50
    L41:
        if (r8.changed(r22) == false) goto L43;
        int r122 = 131072;
    L44:
        r9 = r9 | r122;
        goto L45
    L43:
        r122 = 65536;
        goto L44
    L5:
        if (r8.changedInstance(r17) == false) goto L7;
        int r29 = 4;
    L8:
        r9 = r29 | r24;
        goto L11
    L7:
        r29 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$BottomSheetScaffoldLayout(Function2 r0, Function2 r1, Function2 r2, Function2 r3, Function0 r4, SheetState r5, Composer r6, int r7) {
        BottomSheetScaffoldLayout(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: StandardBottomSheet-w7I5h1o, reason: not valid java name */
    private static final void m2339StandardBottomSheetw7I5h1o(final SheetState r24, final float r25, final float r26, final boolean r27, final Shape r28, final long r29, final long r31, final float r33, final float r34, final Function2<? super Composer, ? super Integer, Unit> r35, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r3 = r37.startRestartGroup(-2108849428);
        if ((r38 & 6) == 0) goto L5;
        int r1 = r38;
    L11:
        if ((r38 & 48) != 0) goto L18;
        if (r3.changed(r25) == false) goto L15;
        int r10 = 32;
    L16:
        r1 = r1 | r10;
        goto L18
    L15:
        r10 = 16;
    L18:
        if ((r38 & 384) != 0) goto L25;
        if (r3.changed(r26) == false) goto L22;
        int r11 = 256;
    L23:
        r1 = r1 | r11;
        goto L25
    L22:
        r11 = 128;
    L25:
        if ((r38 & 3072) != 0) goto L32;
        if (r3.changed(r27) == false) goto L29;
        int r12 = 2048;
    L30:
        r1 = r1 | r12;
        goto L32
    L29:
        r12 = 1024;
    L32:
        if ((r38 & 24576) != 0) goto L39;
        if (r3.changed(r28) == false) goto L36;
        int r13 = 16384;
    L37:
        r1 = r1 | r13;
        goto L39
    L36:
        r13 = 8192;
    L39:
        if ((196608 & r38) != 0) goto L46;
        if (r3.changed(r29) == false) goto L43;
        int r14 = 131072;
    L44:
        r1 = r1 | r14;
        goto L46
    L43:
        r14 = 65536;
    L46:
        if ((1572864 & r38) != 0) goto L53;
        if (r3.changed(r31) == false) goto L50;
        int r15 = 1048576;
    L51:
        r1 = r1 | r15;
        goto L53
    L50:
        r15 = 524288;
    L53:
        if ((r38 & 12582912) != 0) goto L61;
        if (r3.changed(r33) == false) goto L57;
        int r16 = 8388608;
    L58:
        r1 = r1 | r16;
        goto L61
    L57:
        r16 = 4194304;
    L61:
        if ((r38 & 100663296) != 0) goto L68;
        if (r3.changed(r34) == false) goto L65;
        int r17 = 67108864;
    L66:
        r1 = r1 | r17;
        goto L68
    L65:
        r17 = 33554432;
    L68:
        if ((r38 & 805306368) != 0) goto L75;
        if (r3.changedInstance(r35) == false) goto L72;
        int r18 = 536870912;
    L73:
        r1 = r1 | r18;
        goto L75
    L72:
        r18 = 268435456;
    L75:
        if ((r39 & 6) == 0) goto L77;
        int r2 = r39;
    L83:
        if ((r1 & 306783379) == 306783378) goto L85;
    L88:
        boolean r0 = true;
    L90:
        if (r3.shouldExecute(r0, r1 & 1) == true) goto L92;
        Composer r4 = r3;
        r4.skipToGroupEnd();
    L128:
        ScopeUpdateScope r19 = r4.endRestartGroup();
        if (r19 == null) goto L132;
        r19.updateScope(new x1(r24, r25, r26, r27, r28, r29, r31, r33, r34, r35, r36, r38, r39));
        return;
    L132:
        return;
    L92:
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventStart(-2108849428, r1, r2, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:235)");
    L94:
        MotionSchemeKeyTokens r5 = MotionSchemeKeyTokens.DefaultSpatial;
        final FiniteAnimationSpec r9 = MotionSchemeKt.value(r5, r3, 6);
        final FiniteAnimationSpec r6 = MotionSchemeKt.value(r5, r3, 6);
        final FiniteAnimationSpec r7 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r3, 6);
        int r110 = r1 & 14;
        if (r110 != 4) goto L97;
        boolean r8 = true;
    L98:
        boolean r20 = ((r8 | r3.changedInstance(r6)) | r3.changedInstance(r7)) | r3.changedInstance(r9);
        int r21 = r1;
        Object r22 = r3.rememberedValue();
        if (r20 == false) goto L101;
    L102:
        r22 = new u1(r24, r6, r7, r9);
        r3.updateRememberedValue(r22);
    L103:
        EffectsKt.SideEffect((Function0) r22, r3, 0);
        Object r23 = r3.rememberedValue();
        Composer.Companion r30 = Composer.Companion;
        if (r23 != r30.getEmpty()) goto L106;
        r23 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r3);
        r3.updateRememberedValue(r23);
    L106:
        final CoroutineScope r32 = (CoroutineScope) r23;
        Orientation r40 = Orientation.Vertical;
        final float r41 = ((Density) r3.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(r25);
        if (r27 == false) goto L114;
        r3.startReplaceGroup(2049456610);
        Modifier.Companion r42 = Modifier.Companion;
        boolean r43 = r3.changed(r24.getAnchoredDraggableState$material3());
        Object r111 = r3.rememberedValue();
        if (r43 == false) goto L111;
    L112:
        r111 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r24, r40, new v1(r32, r24));
        r3.updateRememberedValue(r111);
    L113:
        Object r44 = null;
        Modifier r45 = NestedScrollModifierKt.nestedScroll$default(r42, (NestedScrollConnection) r111, null, 2, null);
        r3.endReplaceGroup();
    L115:
        Modifier r46 = SizeKt.m1005requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m1021widthInVpY3zN4$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, r26, 1, r44), MenuKt.ClosedAlphaTarget, 1, r44), r25, MenuKt.ClosedAlphaTarget, 2, r44).then(r45);
        AnchoredDraggableState<SheetValue> r47 = r24.getAnchoredDraggableState$material3();
        if (r110 != 4) goto L118;
        boolean r112 = true;
    L119:
        boolean r113 = r112 | r3.changed(r41);
        Object r114 = r3.rememberedValue();
        if (r113 == false) goto L122;
    L123:
        r114 = new w1(r24, r41);
        r3.updateRememberedValue(r114);
    L124:
        Modifier r48 = verticalScaleUp(AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(r46, r47, r40, (Function2) r114), r24.getAnchoredDraggableState$material3(), r40, r27, false, null, 24, null), r24);
        ComposableLambda r49 = ComposableLambdaKt.rememberComposableLambda(1508311921, true, new BottomSheetScaffoldKt$StandardBottomSheet$3(r24, r35, r36, r32, r27), r3, 54);
        int r50 = r21 >> 9;
        int r210 = (((((r50 & 112) | 12582912) | (r50 & 896)) | (r50 & 7168)) | (57344 & r50)) | (r50 & 458752);
        r4 = r3;
        SurfaceKt.m3213SurfaceT9BRK9s(r48, r28, r29, r31, r33, r34, null, r49, r4, r210, 64);
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventEnd();
        goto L128
    L122:
        if (r114 != r30.getEmpty()) goto L124;
    L118:
        r112 = false;
        goto L119
    L111:
        if (r111 != r30.getEmpty()) goto L113;
    L114:
        r44 = null;
        r3.startReplaceGroup(2049851798);
        r3.endReplaceGroup();
        r45 = Modifier.Companion;
        goto L115
    L101:
        if (r22 != Composer.Companion.getEmpty()) goto L103;
    L97:
        r8 = false;
        goto L98
    L85:
        if ((r2 & 3) != 2) goto L88;
        r0 = false;
        goto L90
    L77:
        if (r3.changedInstance(r36) == false) goto L79;
        int r115 = 4;
    L80:
        r2 = r39 | r115;
        goto L83
    L79:
        r115 = 2;
        goto L80
    L5:
        if (r3.changed(r24) == false) goto L7;
        int r51 = 4;
    L8:
        r1 = r51 | r38;
        goto L11
    L7:
        r51 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$StandardBottomSheet-w7I5h1o, reason: not valid java name */
    public static final /* synthetic */ void m2340access$StandardBottomSheetw7I5h1o(SheetState r0, float r1, float r2, boolean r3, Shape r4, long r5, long r7, float r9, float r10, Function2 r11, Function3 r12, Composer r13, int r14, int r15) {
        m2339StandardBottomSheetw7I5h1o(r0, r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15);
    }

    /* JADX INFO: renamed from: BottomSheetScaffold-sdMYb0k, reason: not valid java name */
    public static final void m2338BottomSheetScaffoldsdMYb0k(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r32, Modifier r33, BottomSheetScaffoldState r34, float r35, float r36, Shape r37, long r38, long r40, float r42, float r43, Function2<? super Composer, ? super Integer, Unit> r44, boolean r45, Function2<? super Composer, ? super Integer, Unit> r46, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r47, long r48, long r50, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> r52, Composer r53, final int r54, final int r55, final int r56) {
        Composer r0 = r53.startRestartGroup(920075480);
        if ((r56 & 1) == 0) goto L6;
        int r4 = r54 | 6;
    L13:
        int r5 = r56 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L25:
        if ((r54 & 384) != 0) goto L35;
        if ((r56 & 4) != 0) goto L32;
        if (r0.changed(r34) == false) goto L32;
        int r12 = 256;
    L33:
        r4 = r4 | r12;
    L32:
        r12 = 128;
    L35:
        int r13 = r56 & 8;
        int r16 = 2048;
        if (r13 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r18 = r56 & 16;
        int r19 = 8192;
        if (r18 == 0) goto L50;
        r4 = r4 | 24576;
    L58:
        if ((r54 & 196608) != 0) goto L68;
        if ((r56 & 32) == 0) goto L62;
    L64:
        int r24 = 65536;
    L65:
        r4 = r4 | r24;
        goto L68
    L62:
        if (r0.changed(r37) == false) goto L64;
        r24 = 131072;
    L68:
        if ((r54 & 1572864) != 0) goto L78;
        if ((r56 & 64) == 0) goto L72;
    L74:
        int r26 = 524288;
    L75:
        r4 = r4 | r26;
        goto L78
    L72:
        if (r0.changed(r38) == false) goto L74;
        r26 = 1048576;
    L78:
        if ((r54 & 12582912) != 0) goto L87;
        if ((r56 & 128) == 0) goto L82;
    L84:
        int r28 = 4194304;
    L85:
        r4 = r4 | r28;
        goto L87
    L82:
        if (r0.changed(r40) == false) goto L84;
        r28 = 8388608;
    L87:
        int r10 = r56 & 256;
        if (r10 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r1 = r56 & 512;
        if (r1 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r2 = r56 & 1024;
        if (r2 == 0) goto L111;
        int r21 = r55 | 6;
    L118:
        int r3 = r56 & 2048;
        if (r3 == 0) goto L122;
        r21 = r21 | 48;
    L128:
        int r6 = r21;
        int r7 = r56 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L139:
        int r8 = r56 & 8192;
        if (r8 == 0) goto L143;
        r6 = r6 | 3072;
    L151:
        if ((r55 & 24576) != 0) goto L160;
        if ((r56 & 16384) == 0) goto L155;
    L157:
        r6 = r6 | r19;
        goto L160
    L155:
        if (r0.changed(r48) == false) goto L157;
        r19 = 16384;
    L160:
        if ((196608 & r55) != 0) goto L170;
        if ((32768 & r56) == 0) goto L164;
    L166:
        int r9 = 65536;
    L167:
        r6 = r6 | r9;
        goto L170
    L164:
        if (r0.changed(r50) == false) goto L166;
        r9 = 131072;
    L170:
        if ((r56 & 65536) == 0) goto L173;
        r6 = r6 | 1572864;
    L181:
        if ((r4 & 306783379) == 306783378) goto L183;
    L186:
        boolean r11 = true;
    L188:
        if (r0.shouldExecute(r11, r4 & 1) == false) goto L285;
        r0.startDefaults();
        if ((r54 & 1) != 0) goto L192;
    L213:
        if (r5 == 0) goto L215;
        Modifier r14 = Modifier.Companion;
    L217:
        if ((r56 & 4) == 0) goto L219;
        BottomSheetScaffoldState r15 = rememberBottomSheetScaffoldState(null, null, r0, 0, 3);
        r4 = r4 & (-897);
    L220:
        if (r13 == 0) goto L222;
        float r17 = BottomSheetDefaults.INSTANCE.m2336getSheetPeekHeightD9Ej5fM();
    L223:
        if (r18 == 0) goto L225;
        float r110 = BottomSheetDefaults.INSTANCE.m2335getSheetMaxWidthD9Ej5fM();
    L226:
        Modifier r39 = r14;
        if ((r56 & 32) == 0) goto L229;
        Shape r20 = BottomSheetDefaults.INSTANCE.getExpandedShape(r0, 6);
        r4 = r4 & (-458753);
    L230:
        Shape r310 = r20;
        if ((r56 & 64) == 0) goto L233;
        int r111 = r4 & (-3670017);
        long r22 = BottomSheetDefaults.INSTANCE.getContainerColor(r0, 6);
    L235:
        if ((r56 & 128) == 0) goto L237;
        long r23 = ColorSchemeKt.m2496contentColorForek8zF_U(r22, r0, (r111 >> 18) & 14);
        int r112 = r111 & (-29360129);
    L238:
        long r25 = r22;
        if (r10 == 0) goto L241;
        float r27 = Dp.constructor-impl(0);
    L242:
        if (r1 == 0) goto L244;
        float r29 = BottomSheetDefaults.INSTANCE.m2333getElevationD9Ej5fM();
    L245:
        if (r2 == 0) goto L247;
        Function2<? super Composer, ? super Integer, Unit> r30 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3();
    L248:
        if (r3 == 0) goto L250;
        boolean r31 = true;
    L251:
        if (r7 == 0) goto L253;
        Function2<? super Composer, ? super Integer, Unit> r41 = null;
    L254:
        if (r8 == 0) goto L256;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r49 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3();
    L258:
        if ((r56 & 16384) == 0) goto L260;
        r6 = r6 & (-57345);
        long r51 = MaterialTheme.INSTANCE.getColorScheme(r0, 6).m2480getSurface0d7_KjU();
    L262:
        if ((32768 & r56) == 0) goto L264;
        int r113 = r6 & (-458753);
        long r210 = ColorSchemeKt.m2496contentColorForek8zF_U(r51, r0, (r6 >> 12) & 14);
    L265:
        float r57 = r29;
        Function2<? super Composer, ? super Integer, Unit> r58 = r30;
    L266:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L269;
        ComposerKt.traceEventStart(920075480, r112, r113, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:135)");
    L269:
        Modifier r114 = BackgroundKt.m342backgroundbw27NRU$default(SizeKt.fillMaxSize$default(r39, MenuKt.ClosedAlphaTarget, 1, null), r51, null, 2, null);
        MeasurePolicy r115 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r116 = ComposablesKt.getCurrentCompositeKeyHash(r0, 0);
        CompositionLocalMap r117 = r0.getCurrentCompositionLocalMap();
        Modifier r118 = ComposedModifierKt.materializeModifier(r0, r114);
        ComposeUiNode.Companion r119 = ComposeUiNode.Companion;
        Modifier r120 = r39;
        Function0 r59 = r119.getConstructor();
        if ((r0.getApplier() instanceof Applier) == true) goto L272;
        ComposablesKt.invalidApplier();
    L272:
        r0.startReusableNode();
        if (r0.getInserting() == false) goto L275;
        r0.createNode(r59);
    L276:
        Composer r60 = Updater.constructor-impl(r0);
        Updater.set-impl(r60, r115, r119.getSetMeasurePolicy());
        Updater.set-impl(r60, r117, r119.getSetResolvedCompositionLocals());
        Function2 r121 = r119.getSetCompositeKeyHash();
        if (r60.getInserting() == false) goto L279;
    L280:
        r60.updateRememberedValue(Integer.valueOf(r116));
        r60.apply(Integer.valueOf(r116), r121);
    L281:
        Updater.set-impl(r60, r118, r119.getSetModifier());
        BoxScopeInstance r61 = BoxScopeInstance.INSTANCE;
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(r210)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1$1(r15, r41, r52, r17, r110, r31, r310, r25, r23, r27, r57, r58, r32, r49), r0, 54), r0, ProvidedValue.$stable | 48);
        r0.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L284;
        ComposerKt.traceEventEnd();
    L284:
        final float r122 = r57;
        final Function2<? super Composer, ? super Integer, Unit> r123 = r58;
        final boolean r124 = r31;
        final Function2<? super Composer, ? super Integer, Unit> r125 = r41;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r126 = r49;
        final BottomSheetScaffoldState r62 = r15;
        final float r63 = r110;
        final long r64 = r23;
        final long r65 = r25;
        final long r127 = r51;
        final Shape r66 = r310;
        final Modifier r67 = r120;
        final long r128 = r210;
        float r311 = r17;
        final float r129 = r27;
        final float r68 = r311;
    L286:
        ScopeUpdateScope r69 = r0.endRestartGroup();
        if (r69 == null) goto L290;
        r69.updateScope(new b2(r32, r67, r62, r68, r63, r66, r65, r64, r129, r122, r123, r124, r125, r126, r127, r128, r52, r54, r55, r56));
        return;
    L290:
        return;
    L279:
        if (Intrinsics.areEqual(r60.rememberedValue(), Integer.valueOf(r116)) == true) goto L281;
    L275:
        r0.useNode();
        goto L276
    L264:
        r210 = r50;
        r113 = r6;
        goto L265
    L260:
        r51 = r48;
        goto L262
    L256:
        r49 = r47;
        goto L258
    L253:
        r41 = r46;
        goto L254
    L250:
        r31 = r45;
        goto L251
    L247:
        r30 = r44;
        goto L248
    L244:
        r29 = r43;
        goto L245
    L241:
        r27 = r42;
        goto L242
    L237:
        r23 = r40;
        r112 = r111;
        goto L238
    L233:
        r111 = r4;
        r22 = r38;
        goto L235
    L229:
        r20 = r37;
        goto L230
    L225:
        r110 = r36;
        goto L226
    L222:
        r17 = r35;
        goto L223
    L219:
        r15 = r34;
        goto L220
    L215:
        r14 = r33;
        goto L217
    L192:
        if (r0.getDefaultsInvalid() == true) goto L213;
        r0.skipToGroupEnd();
        if ((r56 & 4) == 0) goto L198;
        r4 = r4 & (-897);
    L198:
        if ((r56 & 32) == 0) goto L201;
        r4 = r4 & (-458753);
    L201:
        if ((r56 & 64) == 0) goto L204;
        r4 = r4 & (-3670017);
    L204:
        if ((r56 & 128) == 0) goto L207;
        r4 = r4 & (-29360129);
    L207:
        if ((r56 & 16384) == 0) goto L210;
        r6 = r6 & (-57345);
    L210:
        if ((32768 & r56) == 0) goto L212;
        r6 = r6 & (-458753);
    L212:
        r39 = r33;
        r15 = r34;
        r17 = r35;
        r110 = r36;
        r310 = r37;
        r25 = r38;
        r23 = r40;
        r57 = r43;
        r58 = r44;
        r41 = r46;
        r49 = r47;
        r51 = r48;
        r210 = r50;
        r112 = r4;
        r113 = r6;
        r27 = r42;
        r31 = r45;
        goto L266
    L285:
        r0.skipToGroupEnd();
        r67 = r33;
        r62 = r34;
        r68 = r35;
        r63 = r36;
        r66 = r37;
        r65 = r38;
        r64 = r40;
        r129 = r42;
        r122 = r43;
        r123 = r44;
        r124 = r45;
        r125 = r46;
        r126 = r47;
        r127 = r48;
        r128 = r50;
        goto L286
    L183:
        if ((599187 & r6) != 599186) goto L186;
        r11 = false;
        goto L188
    L173:
        if ((r55 & 1572864) != 0) goto L181;
        if (r0.changedInstance(r52) == false) goto L177;
        int r130 = 1048576;
    L178:
        r6 = r6 | r130;
        goto L181
    L177:
        r130 = 524288;
        goto L178
    L143:
        if ((r55 & 3072) != 0) goto L151;
        if (r0.changedInstance(r47) == true) goto L148;
        r16 = 1024;
    L148:
        r6 = r6 | r16;
        goto L151
    L132:
        if ((r55 & 384) != 0) goto L139;
        if (r0.changedInstance(r46) == false) goto L136;
        int r211 = 256;
    L137:
        r6 = r6 | r211;
        goto L139
    L136:
        r211 = 128;
        goto L137
    L122:
        if ((r55 & 48) != 0) goto L128;
        if (r0.changed(r45) == false) goto L126;
        int r212 = 32;
    L127:
        r21 = r21 | r212;
        goto L128
    L126:
        r212 = 16;
        goto L127
    L111:
        if ((r55 & 6) == 0) goto L113;
        r21 = r55;
        goto L118
    L113:
        if (r0.changedInstance(r44) == false) goto L115;
        int r213 = 4;
    L116:
        r21 = r55 | r213;
        goto L118
    L115:
        r213 = 2;
        goto L116
    L101:
        if ((r54 & 805306368) != 0) goto L107;
        if (r0.changed(r43) == false) goto L105;
        int r214 = 536870912;
    L106:
        r4 = r4 | r214;
        goto L107
    L105:
        r214 = 268435456;
        goto L106
    L91:
        if ((r54 & 100663296) != 0) goto L97;
        if (r0.changed(r42) == false) goto L95;
        int r215 = 67108864;
    L96:
        r4 = r4 | r215;
        goto L97
    L95:
        r215 = 33554432;
        goto L96
    L50:
        if ((r54 & 24576) != 0) goto L58;
        if (r0.changed(r36) == false) goto L54;
        int r216 = 16384;
    L55:
        r4 = r4 | r216;
        goto L58
    L54:
        r216 = 8192;
        goto L55
    L39:
        if ((r54 & 3072) != 0) goto L46;
        if (r0.changed(r35) == false) goto L43;
        int r131 = 2048;
    L44:
        r4 = r4 | r131;
        goto L46
    L43:
        r131 = 1024;
        goto L44
    L17:
        if ((r54 & 48) != 0) goto L25;
        if (r0.changed(r33) == false) goto L21;
        int r70 = 32;
    L22:
        r4 = r4 | r70;
        goto L25
    L21:
        r70 = 16;
        goto L22
    L6:
        if ((r54 & 6) == 0) goto L8;
        r4 = r54;
        goto L13
    L8:
        if (r0.changedInstance(r32) == false) goto L10;
        int r71 = 4;
    L11:
        r4 = r71 | r54;
        goto L13
    L10:
        r71 = 2;
        goto L11
    }
}
