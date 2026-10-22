package androidx.compose.foundation.lazy.grid;

import android.os.Trace;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001aq\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0003¢\u0006\u0002\u0010&\u001a*\u0010'\u001a\u00020\u0001*\u00020(2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020/H\u0002¨\u00060"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "visibleItemsList", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridKt {
    private static final Unit LazyGrid$lambda$0(Modifier r17, LazyGridState r18, LazyGridSlotsProvider r19, PaddingValues r20, boolean r21, boolean r22, FlingBehavior r23, boolean r24, OverscrollEffect r25, Arrangement.Vertical r26, Arrangement.Horizontal r27, Function1 r28, int r29, int r30, int r31, Composer r32, int r33) {
        LazyGrid(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r1, LazyGridState r2, LazyGridSlotsProvider r3, PaddingValues r4, boolean r5, boolean r6, FlingBehavior r7, boolean r8, OverscrollEffect r9, Arrangement.Vertical r10, Arrangement.Horizontal r11, Function1 r12, int r13, int r14, int r15, Composer r16, int r17) {
        return LazyGrid$lambda$0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static final /* synthetic */ void access$keepAroundItems(CacheWindowLogic r0, Orientation r1, List r2, LazyGridMeasuredLineProvider r3) {
        keepAroundItems(r0, r1, r2, r3);
    }

    private static final void keepAroundItems(CacheWindowLogic r1, Orientation r2, List<LazyGridMeasuredItem> r3, LazyGridMeasuredLineProvider r4) {
        Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
    L18:
        th = move-exception;
        Trace.endSection();
        throw th;
    L4:
        if (r1.hasValidBounds() == true) goto L6;
    L15:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L18
        Trace.endSection();
        return;
    L6:
        if ((!r3.isEmpty()) == false) goto L15;
        int r0 = LazyGridItemInfoKt.lineIndex((LazyGridItemInfo) CollectionsKt.first(r3), r2);     // Catch: Throwable -> L18
        int r6 = LazyGridItemInfoKt.lineIndex((LazyGridItemInfo) CollectionsKt.last(r3), r2);     // Catch: Throwable -> L18
        int r7 = r1.getPrefetchWindowStartLine$foundation_release();     // Catch: Throwable -> L18
    L8:
        if (r7 >= r0) goto L10;
        r4.keepAround(r7);     // Catch: Throwable -> L18
        r7 = r7 + 1;     // Catch: Throwable -> L18
        goto L8
    L10:
        int r8 = r6 + 1;     // Catch: Throwable -> L18
        int r9 = r1.getPrefetchWindowEndLine$foundation_release();     // Catch: Throwable -> L18
        if (r8 > r9) goto L15;
    L12:
        r4.keepAround(r8);     // Catch: Throwable -> L18
        if (r8 == r9) goto L15;
        r8 = r8 + 1;     // Catch: Throwable -> L18
        goto L12
    }

    private static final LazyLayoutMeasurePolicy rememberLazyGridMeasurePolicy(Function0<? extends LazyGridItemProvider> r18, LazyGridState r19, LazyGridSlotsProvider r20, PaddingValues r21, boolean r22, boolean r23, Arrangement.Horizontal r24, Arrangement.Vertical r25, CoroutineScope r26, GraphicsContext r27, StickyItemsPlacement r28, Composer r29, int r30, int r31) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1030995717, r30, r31, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:180)");
    L5:
        boolean r4 = false;
        if (((r30 & 112) ^ 48) <= 32) goto L12;
        if (r29.changed(r19) == false) goto L12;
    L13:
        boolean r3 = true;
    L16:
        if (((r30 & 896) ^ 384) <= 256) goto L20;
        if (r29.changed(r20) == false) goto L20;
    L21:
        boolean r6 = true;
    L23:
        boolean r5 = r3 | r6;
        if (((r30 & 7168) ^ 3072) <= 2048) goto L28;
        if (r29.changed(r21) == false) goto L28;
    L29:
        boolean r7 = true;
    L31:
        boolean r8 = r5 | r7;
        if (((57344 & r30) ^ 24576) <= 16384) goto L36;
        if (r29.changed(r22) == false) goto L36;
    L37:
        boolean r9 = true;
    L39:
        boolean r10 = r8 | r9;
        if (((458752 & r30) ^ 196608) <= 131072) goto L44;
        if (r29.changed(r23) == false) goto L44;
    L45:
        boolean r11 = true;
    L47:
        boolean r12 = r10 | r11;
        if (((3670016 & r30) ^ 1572864) <= 1048576) goto L52;
        if (r29.changed(r24) == false) goto L52;
    L53:
        boolean r13 = true;
    L55:
        boolean r14 = r12 | r13;
        if (((29360128 & r30) ^ 12582912) <= 8388608) goto L60;
        if (r29.changed(r25) == false) goto L60;
    L61:
        r4 = true;
    L62:
        boolean r1 = (r14 | r4) | r29.changed(r27);
        Object r15 = r29.rememberedValue();
        if (r1 == false) goto L65;
    L66:
        r15 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(r19, r23, r21, r22, r18, r20, r25, r24, r26, r27, r28);
        r29.updateRememberedValue(r15);
    L67:
        LazyLayoutMeasurePolicy r16 = (LazyLayoutMeasurePolicy) r15;
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventEnd();
    L70:
        return r16;
    L65:
        if (r15 != Composer.Companion.getEmpty()) goto L67;
    L60:
        if ((r30 & 12582912) != 8388608) goto L62;
    L52:
        if ((r30 & 1572864) == 1048576) goto L53;
        r13 = false;
    L44:
        if ((r30 & 196608) == 131072) goto L45;
        r11 = false;
    L36:
        if ((r30 & 24576) == 16384) goto L37;
        r9 = false;
    L28:
        if ((r30 & 3072) == 2048) goto L29;
        r7 = false;
    L20:
        if ((r30 & 384) == 256) goto L21;
        r6 = false;
    L12:
        if ((r30 & 48) == 32) goto L13;
        r3 = false;
        goto L16
    }

    public static final void LazyGrid(Modifier r32, final LazyGridState r33, final LazyGridSlotsProvider r34, PaddingValues r35, boolean r36, final boolean r37, FlingBehavior r38, final boolean r39, final OverscrollEffect r40, final Arrangement.Vertical r41, final Arrangement.Horizontal r42, final Function1<? super LazyGridScope, Unit> r43, Composer r44, final int r45, final int r46, final int r47) {
        Composer r8 = r44.startRestartGroup(708740370);
        int r1 = r47 & 1;
        if (r1 == 0) goto L6;
        int r5 = r45 | 6;
    L13:
        int r16 = 16;
        if ((r47 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L24:
        if ((r47 & 4) == 0) goto L27;
        r5 = r5 | 384;
    L36:
        int r6 = r47 & 8;
        if (r6 == 0) goto L40;
        r5 = r5 | 3072;
    L47:
        int r17 = r47 & 16;
        if (r17 == 0) goto L51;
        r5 = r5 | 24576;
    L59:
        if ((r47 & 32) == 0) goto L62;
        r5 = r5 | 196608;
    L69:
        if ((r45 & 1572864) != 0) goto L77;
        final FlingBehavior r7 = r38;
        if ((r47 & 64) == 0) goto L73;
    L75:
        int r20 = 524288;
    L76:
        r5 = r5 | r20;
    L79:
        if ((r47 & 128) == 0) goto L82;
        r5 = r5 | 12582912;
    L89:
        if ((r47 & 256) == 0) goto L92;
        r5 = r5 | 100663296;
    L100:
        if ((r47 & 512) == 0) goto L103;
        r5 = r5 | 805306368;
    L111:
        if ((r47 & 1024) == 0) goto L114;
        int r18 = r46 | 6;
    L122:
        if ((r47 & 2048) == 0) goto L125;
        r18 = r18 | 48;
    L130:
        int r0 = r18;
        boolean r4 = false;
        if ((r5 & 306783379) == 306783378) goto L133;
    L136:
        boolean r2 = true;
    L138:
        if (r8.shouldExecute(r2, r5 & 1) == false) goto L183;
        r8.startDefaults();
        if ((r45 & 1) != 0) goto L142;
    L148:
        if (r1 == 0) goto L150;
        Modifier r3 = Modifier.Companion;
    L151:
        if (r6 == 0) goto L153;
        PaddingValues r9 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L154:
        if (r17 != 0) goto L158;
        r4 = r36;
    L158:
        if ((r47 & 64) == 0) goto L160;
        r5 = r5 & (-3670017);
        Modifier r10 = r3;
        PaddingValues r19 = r9;
        FlingBehavior r110 = ScrollableDefaults.INSTANCE.flingBehavior(r8, 6);
        boolean r11 = r4;
    L161:
        r8.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventStart(708740370, r5, r0, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:83)");
    L164:
        int r12 = (r5 >> 3) & 14;
        Function0<LazyGridItemProvider> r111 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(r33, r43, r8, (r0 & 112) | r12);
        int r21 = r5 >> 9;
        LazyLayoutSemanticState r22 = LazySemanticsKt.rememberLazyGridSemanticState(r33, r11, r8, (r21 & 112) | r12);
        Object r13 = r8.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L167;
        r13 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r8);
        r8.updateRememberedValue(r13);
    L167:
        CoroutineScope r23 = (CoroutineScope) r13;
        GraphicsContext r24 = (GraphicsContext) r8.consume(CompositionLocalsKt.getLocalGraphicsContext());
        if ((!((Boolean) r8.consume(CompositionLocalsKt.getLocalScrollCaptureInProgress())).booleanValue()) == false) goto L170;
        StickyItemsPlacement r14 = StickyItemsPlacement.Companion.getStickToTopPlacement();
    L171:
        PaddingValues r15 = r19;
        boolean r25 = r11;
        int r27 = r5;
        boolean r28 = r11;
        Modifier r29 = r10;
        LazyLayoutMeasurePolicy r112 = rememberLazyGridMeasurePolicy(r111, r33, r34, r15, r25, r37, r42, r41, r23, r24, r14, r8, (((r0 << 18) & 3670016) | (((((r5 & 112) | (r5 & 896)) | (r5 & 7168)) | (57344 & r5)) | (458752 & r5))) | ((r5 >> 6) & 29360128), 0);
        if (r37 == false) goto L174;
        Orientation r26 = Orientation.Vertical;
    L175:
        Orientation r30 = r26;
        if (r39 == false) goto L178;
        Composer r113 = r8;
        r113.startReplaceGroup(27343139);
        boolean r114 = r28;
        Modifier r31 = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(r33, r113, r12), r33.getBeyondBoundsInfo$foundation_release(), r114, r30);
        r113.endReplaceGroup();
    L179:
        boolean r48 = r114;
        FlingBehavior r49 = r110;
        boolean r115 = r114;
        LazyLayoutKt.LazyLayout(r111, ScrollingContainerKt.scrollingContainer$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(r29.then(r33.getRemeasurementModifier$foundation_release()).then(r33.getAwaitLayoutModifier$foundation_release()), r111, r22, r30, r39, r114, r113, (r21 & 57344) | ((r27 << 3) & 458752)).then(r31).then(r33.getItemAnimator$foundation_release().getModifier()), r33, r30, r39, r48, r49, r33.getInternalInteractionSource$foundation_release(), false, r40, null, 256, null), r33.getPrefetchState$foundation_release(), r112, r113, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L182;
        ComposerKt.traceEventEnd();
    L182:
        final boolean r50 = r115;
        final PaddingValues r51 = r19;
        r7 = r110;
        final Modifier r52 = r29;
    L184:
        ScopeUpdateScope r116 = r113.endRestartGroup();
        if (r116 == null) goto L188;
        r116.updateScope(new p(r52, r33, r34, r51, r50, r37, r7, r39, r40, r41, r42, r43, r45, r46, r47));
        return;
    L188:
        return;
    L178:
        r113 = r8;
        r114 = r28;
        r113.startReplaceGroup(27639344);
        r113.endReplaceGroup();
        r31 = Modifier.Companion;
        goto L179
    L174:
        r26 = Orientation.Horizontal;
        goto L175
    L170:
        r14 = null;
        goto L171
    L160:
        r19 = r9;
        r11 = r4;
        r110 = r7;
        r10 = r3;
        goto L161
    L153:
        r9 = r35;
        goto L154
    L150:
        r3 = r32;
        goto L151
    L142:
        if (r8.getDefaultsInvalid() == true) goto L148;
        r8.skipToGroupEnd();
        if ((r47 & 64) == 0) goto L147;
        r5 = r5 & (-3670017);
    L147:
        r19 = r35;
        r11 = r36;
        r110 = r7;
        r10 = r32;
        goto L161
    L183:
        r113 = r8;
        r113.skipToGroupEnd();
        r52 = r32;
        r51 = r35;
        r50 = r36;
        goto L184
    L133:
        if ((r0 & 19) != 18) goto L136;
        r2 = false;
        goto L138
    L125:
        if ((r46 & 48) != 0) goto L130;
        if (r8.changedInstance(r43) == false) goto L129;
        r16 = 32;
    L129:
        r18 = r18 | r16;
        goto L130
    L114:
        if ((r46 & 6) == 0) goto L116;
        r18 = r46;
        goto L122
    L116:
        if (r8.changed(r42) == false) goto L118;
        int r117 = 4;
    L119:
        r18 = r46 | r117;
        goto L122
    L118:
        r117 = 2;
        goto L119
    L103:
        if ((805306368 & r45) != 0) goto L111;
        if (r8.changed(r41) == false) goto L107;
        int r210 = 536870912;
    L108:
        r5 = r5 | r210;
        goto L111
    L107:
        r210 = 268435456;
        goto L108
    L92:
        if ((r45 & 100663296) != 0) goto L100;
        if (r8.changed(r40) == false) goto L96;
        int r211 = 67108864;
    L97:
        r5 = r5 | r211;
        goto L100
    L96:
        r211 = 33554432;
        goto L97
    L82:
        if ((r45 & 12582912) != 0) goto L89;
        if (r8.changed(r39) == false) goto L86;
        int r53 = 8388608;
    L87:
        r5 = r5 | r53;
        goto L89
    L86:
        r53 = 4194304;
        goto L87
    L73:
        if (r8.changed(r7) == false) goto L75;
        r20 = 1048576;
        goto L76
    L77:
        r7 = r38;
        goto L79
    L62:
        if ((r45 & 196608) != 0) goto L69;
        if (r8.changed(r37) == false) goto L66;
        int r118 = 131072;
    L67:
        r5 = r5 | r118;
        goto L69
    L66:
        r118 = 65536;
        goto L67
    L51:
        if ((r45 & 24576) != 0) goto L59;
        if (r8.changed(r36) == false) goto L55;
        int r119 = 16384;
    L56:
        r5 = r5 | r119;
        goto L59
    L55:
        r119 = 8192;
        goto L56
    L40:
        if ((r45 & 3072) != 0) goto L47;
        if (r8.changed(r35) == false) goto L44;
        int r120 = 2048;
    L45:
        r5 = r5 | r120;
        goto L47
    L44:
        r120 = 1024;
        goto L45
    L27:
        if ((r45 & 384) != 0) goto L36;
        if ((r45 & 512) != 0) goto L31;
        boolean r54 = r8.changed(r34);
    L32:
        if (r54 == false) goto L34;
        int r55 = 256;
    L35:
        r5 = r5 | r55;
        goto L36
    L34:
        r55 = 128;
        goto L35
    L31:
        r54 = r8.changedInstance(r34);
        goto L32
    L17:
        if ((r45 & 48) != 0) goto L24;
        if (r8.changed(r33) == false) goto L21;
        int r56 = 32;
    L22:
        r5 = r5 | r56;
        goto L24
    L21:
        r56 = 16;
        goto L22
    L6:
        if ((r45 & 6) == 0) goto L8;
        r5 = r45;
        goto L13
    L8:
        if (r8.changed(r32) == false) goto L10;
        int r57 = 4;
    L11:
        r5 = r57 | r45;
        goto L13
    L10:
        r57 = 2;
        goto L11
    }
}
