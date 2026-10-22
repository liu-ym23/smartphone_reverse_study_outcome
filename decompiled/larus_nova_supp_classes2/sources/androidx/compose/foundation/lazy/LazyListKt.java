package androidx.compose.foundation.lazy;

import android.os.Trace;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a¢\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010\u001e\u001a\u0085\u0001\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0003¢\u0006\u0002\u0010*\u001a\"\u0010+\u001a\u00020\u0001*\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u000201H\u0002¨\u00062"}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;ILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "visibleItemsList", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyListKt {
    private static final Unit LazyList$lambda$0(Modifier r18, LazyListState r19, PaddingValues r20, boolean r21, boolean r22, FlingBehavior r23, boolean r24, OverscrollEffect r25, int r26, Alignment.Horizontal r27, Arrangement.Vertical r28, Alignment.Vertical r29, Arrangement.Horizontal r30, Function1 r31, int r32, int r33, int r34, Composer r35, int r36) {
        LazyList(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r35, RecomposeScopeImplKt.updateChangedFlags(r32 | 1), RecomposeScopeImplKt.updateChangedFlags(r33), r34);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r1, LazyListState r2, PaddingValues r3, boolean r4, boolean r5, FlingBehavior r6, boolean r7, OverscrollEffect r8, int r9, Alignment.Horizontal r10, Arrangement.Vertical r11, Alignment.Vertical r12, Arrangement.Horizontal r13, Function1 r14, int r15, int r16, int r17, Composer r18, int r19) {
        return LazyList$lambda$0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static final /* synthetic */ void access$keepAroundItems(CacheWindowLogic r0, List r1, LazyListMeasuredItemProvider r2) {
        keepAroundItems(r0, r1, r2);
    }

    private static final void keepAroundItems(CacheWindowLogic r2, List<LazyListMeasuredItem> r3, LazyListMeasuredItemProvider r4) {
        Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
    L18:
        th = move-exception;
        Trace.endSection();
        throw th;
    L4:
        if (r2.hasValidBounds() == true) goto L6;
    L15:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L18
        Trace.endSection();
        return;
    L6:
        if ((!r3.isEmpty()) == false) goto L15;
        int r0 = ((LazyListMeasuredItem) CollectionsKt.first(r3)).getIndex();     // Catch: Throwable -> L18
        int r6 = ((LazyListMeasuredItem) CollectionsKt.last(r3)).getIndex();     // Catch: Throwable -> L18
        int r1 = r2.getPrefetchWindowStartLine$foundation_release();     // Catch: Throwable -> L18
    L8:
        if (r1 >= r0) goto L10;
        r4.keepAround(r1);     // Catch: Throwable -> L18
        r1 = r1 + 1;     // Catch: Throwable -> L18
        goto L8
    L10:
        int r7 = r6 + 1;     // Catch: Throwable -> L18
        int r8 = r2.getPrefetchWindowEndLine$foundation_release();     // Catch: Throwable -> L18
        if (r7 > r8) goto L15;
    L12:
        r4.keepAround(r7);     // Catch: Throwable -> L18
        if (r7 == r8) goto L15;
        r7 = r7 + 1;     // Catch: Throwable -> L18
        goto L12
    }

    private static final LazyLayoutMeasurePolicy rememberLazyListMeasurePolicy(Function0<? extends LazyListItemProvider> r21, LazyListState r22, PaddingValues r23, boolean r24, boolean r25, int r26, Alignment.Horizontal r27, Alignment.Vertical r28, Arrangement.Horizontal r29, Arrangement.Vertical r30, CoroutineScope r31, GraphicsContext r32, StickyItemsPlacement r33, Composer r34, int r35, int r36) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(406165748, r35, r36, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:188)");
    L6:
        if (((r35 & 112) ^ 48) <= 32) goto L12;
        if (r34.changed(r22) == false) goto L12;
    L13:
        boolean r4 = true;
    L16:
        if (((r35 & 896) ^ 384) <= 256) goto L20;
        if (r34.changed(r23) == false) goto L20;
    L21:
        boolean r7 = true;
    L23:
        boolean r5 = r4 | r7;
        if (((r35 & 7168) ^ 3072) <= 2048) goto L28;
        if (r34.changed(r24) == false) goto L28;
    L29:
        boolean r8 = true;
    L31:
        boolean r6 = r5 | r8;
        if (((57344 & r35) ^ 24576) <= 16384) goto L36;
        if (r34.changed(r25) == false) goto L36;
    L37:
        boolean r9 = true;
    L39:
        boolean r10 = r6 | r9;
        if (((458752 & r35) ^ 196608) <= 131072) goto L44;
        if (r34.changed(r26) == false) goto L44;
    L45:
        boolean r11 = true;
    L47:
        boolean r12 = r10 | r11;
        if (((3670016 & r35) ^ 1572864) <= 1048576) goto L52;
        if (r34.changed(r27) == false) goto L52;
    L53:
        boolean r13 = true;
    L55:
        boolean r14 = r12 | r13;
        if (((29360128 & r35) ^ 12582912) <= 8388608) goto L62;
        if (r34.changed(r28) == false) goto L62;
    L63:
        boolean r15 = true;
    L65:
        boolean r16 = r14 | r15;
        if (((234881024 & r35) ^ 100663296) <= 67108864) goto L72;
        if (r34.changed(r29) == false) goto L72;
    L73:
        boolean r17 = true;
    L75:
        boolean r18 = r16 | r17;
        if (((1879048192 & r35) ^ 805306368) <= 536870912) goto L82;
        if (r34.changed(r30) == false) goto L82;
    L83:
        boolean r1 = true;
    L85:
        boolean r2 = (r1 | r18) | r34.changed(r32);
        if (((r36 & 896) ^ 384) <= 256) goto L92;
        if (r34.changed(r33) == false) goto L92;
    L93:
        boolean r19 = true;
    L95:
        boolean r3 = r2 | r19;
        Object r20 = r34.rememberedValue();
        if (r3 == false) goto L98;
    L99:
        r20 = new LazyListKt$rememberLazyListMeasurePolicy$1$1(r22, r25, r23, r24, r21, r30, r29, r26, r31, r32, r33, r27, r28);
        r34.updateRememberedValue(r20);
    L100:
        LazyLayoutMeasurePolicy r37 = (LazyLayoutMeasurePolicy) r20;
        if (ComposerKt.isTraceInProgress() == false) goto L103;
        ComposerKt.traceEventEnd();
    L103:
        return r37;
    L98:
        if (r20 != Composer.Companion.getEmpty()) goto L100;
    L92:
        if ((r36 & 384) == 256) goto L93;
        r19 = false;
    L82:
        if ((r35 & 805306368) == 536870912) goto L83;
        r1 = false;
    L72:
        if ((100663296 & r35) == 67108864) goto L73;
        r17 = false;
    L62:
        if ((12582912 & r35) == 8388608) goto L63;
        r15 = false;
    L52:
        if ((r35 & 1572864) == 1048576) goto L53;
        r13 = false;
    L44:
        if ((r35 & 196608) == 131072) goto L45;
        r11 = false;
    L36:
        if ((r35 & 24576) == 16384) goto L37;
        r9 = false;
    L28:
        if ((r35 & 3072) == 2048) goto L29;
        r8 = false;
    L20:
        if ((r35 & 384) == 256) goto L21;
        r7 = false;
    L12:
        if ((r35 & 48) == 32) goto L13;
        r4 = false;
        goto L16
    }

    public static final void LazyList(final Modifier r31, final LazyListState r32, final PaddingValues r33, final boolean r34, final boolean r35, final FlingBehavior r36, final boolean r37, final OverscrollEffect r38, int r39, Alignment.Horizontal r40, Arrangement.Vertical r41, Alignment.Vertical r42, Arrangement.Horizontal r43, final Function1<? super LazyListScope, Unit> r44, Composer r45, final int r46, final int r47, final int r48) {
        Composer r8 = r45.startRestartGroup(924924659);
        if ((r48 & 1) == 0) goto L6;
        int r3 = r46 | 6;
    L13:
        int r16 = 16;
        if ((r48 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L23:
        int r17 = 128;
        if ((r48 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L34:
        int r20 = 2048;
        if ((r48 & 8) == 0) goto L38;
        r3 = r3 | 3072;
    L45:
        if ((r48 & 16) == 0) goto L48;
        r3 = r3 | 24576;
    L55:
        if ((r48 & 32) == 0) goto L58;
        r3 = r3 | 196608;
    L66:
        if ((r48 & 64) == 0) goto L69;
        r3 = r3 | 1572864;
    L76:
        if ((r48 & 128) == 0) goto L79;
        r3 = r3 | 12582912;
    L87:
        if ((r46 & 100663296) != 0) goto L97;
        if ((r48 & 256) != 0) goto L94;
        if (r8.changed(r39) == false) goto L94;
        int r23 = 67108864;
    L95:
        r3 = r3 | r23;
    L94:
        r23 = 33554432;
    L97:
        int r2 = r48 & 512;
        if (r2 == 0) goto L101;
        r3 = r3 | 805306368;
    L107:
        int r4 = r48 & 1024;
        if (r4 == 0) goto L111;
        int r19 = r47 | 6;
    L118:
        int r5 = r48 & 2048;
        if (r5 == 0) goto L122;
        r19 = r19 | 48;
    L127:
        int r6 = r19;
        int r7 = r48 & 4096;
        if (r7 == 0) goto L131;
        r6 = r6 | 384;
    L138:
        if ((r48 & 8192) == 0) goto L141;
        r6 = r6 | 3072;
    L148:
        if ((306783379 & r3) == 306783378) goto L150;
    L153:
        boolean r10 = true;
    L155:
        if (r8.shouldExecute(r10, r3 & 1) == false) goto L203;
        r8.startDefaults();
        if ((r46 & 1) == 0) goto L166;
        if (r8.getDefaultsInvalid() == true) goto L166;
        r8.skipToGroupEnd();
        if ((r48 & 256) == 0) goto L164;
        r3 = r3 & (-234881025);
    L164:
        int r11 = r39;
        Alignment.Horizontal r18 = r40;
        Arrangement.Vertical r110 = r41;
        Alignment.Vertical r21 = r42;
        Arrangement.Horizontal r22 = r43;
        int r9 = r3;
    L181:
        r8.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L184;
        ComposerKt.traceEventStart(924924659, r9, r6, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:85)");
    L184:
        int r24 = (r9 >> 3) & 14;
        Function0<LazyListItemProvider> r25 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(r32, r44, r8, r24 | ((r6 >> 6) & 112));
        int r12 = r9 >> 9;
        LazyLayoutSemanticState r26 = LazyListSemanticsKt.rememberLazyListSemanticState(r32, r35, r8, r24 | (r12 & 112));
        Object r13 = r8.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L187;
        r13 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r8);
        r8.updateRememberedValue(r13);
    L187:
        CoroutineScope r111 = (CoroutineScope) r13;
        GraphicsContext r27 = (GraphicsContext) r8.consume(CompositionLocalsKt.getLocalGraphicsContext());
        if ((!((Boolean) r8.consume(CompositionLocalsKt.getLocalScrollCaptureInProgress())).booleanValue()) == false) goto L190;
        StickyItemsPlacement r112 = StickyItemsPlacement.Companion.getStickToTopPlacement();
    L191:
        int r14 = (r12 & 3670016) | (((((r9 & 112) | (r9 & 896)) | (r9 & 7168)) | (57344 & r9)) | (458752 & r12));
        int r15 = r6 << 18;
        int r28 = r9;
        int r1 = r11;
        LazyLayoutMeasurePolicy r113 = rememberLazyListMeasurePolicy(r25, r32, r33, r34, r35, r11, r18, r21, r22, r110, r111, r27, r112, r8, ((r14 | (29360128 & r15)) | (r15 & 234881024)) | ((r6 << 27) & 1879048192), 0);
        if (r35 == false) goto L194;
        Orientation r29 = Orientation.Vertical;
    L195:
        Orientation r114 = r29;
        if (r37 == false) goto L198;
        Composer r115 = r8;
        r115.startReplaceGroup(-2077085864);
        Modifier r30 = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(r32, r1, r115, r24 | ((r28 >> 21) & 112)), r32.getBeyondBoundsInfo$foundation_release(), r34, r114);
        r115.endReplaceGroup();
    L199:
        LazyLayoutKt.LazyLayout(r25, ScrollingContainerKt.scrollingContainer$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(r31.then(r32.getRemeasurementModifier$foundation_release()).then(r32.getAwaitLayoutModifier$foundation_release()), r25, r26, r114, r37, r34, r115, ((r28 >> 6) & 57344) | (458752 & (r28 << 6))).then(r30).then(r32.getItemAnimator$foundation_release().getModifier()), r32, r114, r37, r34, r36, r32.getInternalInteractionSource$foundation_release(), false, r38, null, 256, null), r32.getPrefetchState$foundation_release(), r113, r115, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L202;
        ComposerKt.traceEventEnd();
    L202:
        final int r49 = r1;
        final Alignment.Horizontal r116 = r18;
        final Arrangement.Vertical r117 = r110;
        final Alignment.Vertical r118 = r21;
        final Arrangement.Horizontal r119 = r22;
    L204:
        ScopeUpdateScope r120 = r115.endRestartGroup();
        if (r120 == null) goto L208;
        r120.updateScope(new m(r31, r32, r33, r34, r35, r36, r37, r38, r49, r116, r117, r118, r119, r44, r46, r47, r48));
        return;
    L208:
        return;
    L198:
        r115 = r8;
        r115.startReplaceGroup(-2076657041);
        r115.endReplaceGroup();
        r30 = Modifier.Companion;
        goto L199
    L194:
        r29 = Orientation.Horizontal;
        goto L195
    L190:
        r112 = null;
    L166:
        if ((r48 & 256) == 0) goto L168;
        r11 = LazyList_androidKt.defaultLazyListBeyondBoundsItemCount(r8, 0);
        r3 = r3 & (-234881025);
    L169:
        if (r2 == 0) goto L171;
        Alignment.Horizontal r50 = null;
    L172:
        if (r4 == 0) goto L174;
        Arrangement.Vertical r51 = null;
    L175:
        if (r5 == 0) goto L177;
        Alignment.Vertical r52 = null;
    L178:
        if (r7 == 0) goto L180;
        r18 = r50;
        r9 = r3;
        r110 = r51;
        r21 = r52;
        r22 = null;
        goto L181
    L180:
        r22 = r43;
        r18 = r50;
        r9 = r3;
        r110 = r51;
        r21 = r52;
        goto L181
    L177:
        r52 = r42;
        goto L178
    L174:
        r51 = r41;
        goto L175
    L171:
        r50 = r40;
        goto L172
    L168:
        r11 = r39;
        goto L169
    L203:
        r115 = r8;
        r115.skipToGroupEnd();
        r49 = r39;
        r116 = r40;
        r117 = r41;
        r118 = r42;
        r119 = r43;
        goto L204
    L150:
        if ((r6 & 1171) != 1170) goto L153;
        r10 = false;
        goto L155
    L141:
        if ((r47 & 3072) != 0) goto L148;
        if (r8.changedInstance(r44) == true) goto L146;
        r20 = 1024;
    L146:
        r6 = r6 | r20;
        goto L148
    L131:
        if ((r47 & 384) != 0) goto L138;
        if (r8.changed(r43) == false) goto L135;
        r17 = 256;
    L135:
        r6 = r6 | r17;
        goto L138
    L122:
        if ((r47 & 48) != 0) goto L127;
        if (r8.changed(r42) == false) goto L126;
        r16 = 32;
    L126:
        r19 = r19 | r16;
        goto L127
    L111:
        if ((r47 & 6) == 0) goto L113;
        r19 = r47;
        goto L118
    L113:
        if (r8.changed(r41) == false) goto L115;
        int r121 = 4;
    L116:
        r19 = r47 | r121;
        goto L118
    L115:
        r121 = 2;
        goto L116
    L101:
        if ((r46 & 805306368) != 0) goto L107;
        if (r8.changed(r40) == false) goto L105;
        int r210 = 536870912;
    L106:
        r3 = r3 | r210;
        goto L107
    L105:
        r210 = 268435456;
        goto L106
    L79:
        if ((r46 & 12582912) != 0) goto L87;
        if (r8.changed(r38) == false) goto L83;
        int r211 = 8388608;
    L84:
        r3 = r3 | r211;
        goto L87
    L83:
        r211 = 4194304;
        goto L84
    L69:
        if ((r46 & 1572864) != 0) goto L76;
        if (r8.changed(r37) == false) goto L73;
        int r122 = 1048576;
    L74:
        r3 = r3 | r122;
        goto L76
    L73:
        r122 = 524288;
        goto L74
    L58:
        if ((r46 & 196608) != 0) goto L66;
        if (r8.changed(r36) == false) goto L62;
        int r123 = 131072;
    L63:
        r3 = r3 | r123;
        goto L66
    L62:
        r123 = 65536;
        goto L63
    L48:
        if ((r46 & 24576) != 0) goto L55;
        if (r8.changed(r35) == false) goto L52;
        int r53 = 16384;
    L53:
        r3 = r3 | r53;
        goto L55
    L52:
        r53 = 8192;
        goto L53
    L38:
        if ((r46 & 3072) != 0) goto L45;
        if (r8.changed(r34) == false) goto L42;
        int r54 = 2048;
    L43:
        r3 = r3 | r54;
        goto L45
    L42:
        r54 = 1024;
        goto L43
    L27:
        if ((r46 & 384) != 0) goto L34;
        if (r8.changed(r33) == false) goto L31;
        int r124 = 256;
    L32:
        r3 = r3 | r124;
        goto L34
    L31:
        r124 = 128;
        goto L32
    L17:
        if ((r46 & 48) != 0) goto L23;
        if (r8.changed(r32) == false) goto L21;
        int r55 = 32;
    L22:
        r3 = r3 | r55;
        goto L23
    L21:
        r55 = 16;
        goto L22
    L6:
        if ((r46 & 6) == 0) goto L8;
        r3 = r46;
        goto L13
    L8:
        if (r8.changed(r31) == false) goto L10;
        int r56 = 4;
    L11:
        r3 = r56 | r46;
        goto L13
    L10:
        r56 = 2;
        goto L11
    }
}
