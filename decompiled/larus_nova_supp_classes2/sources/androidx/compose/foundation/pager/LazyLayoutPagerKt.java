package androidx.compose.foundation.pager;

import androidx.autofill.HintConstants;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aå\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$21\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*H\u0001¢\u0006\u0004\b+\u0010,\u001a\u0081\u0001\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u0004\u001a\u00020\u000521\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*2#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120.H\u0003¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u00063"}, d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-eLwUrMk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutPagerKt {
    private static final Unit Pager_eLwUrMk$lambda$7(Modifier r21, PagerState r22, PaddingValues r23, boolean r24, Orientation r25, TargetedFlingBehavior r26, boolean r27, OverscrollEffect r28, int r29, float r30, PageSize r31, NestedScrollConnection r32, Function1 r33, Alignment.Horizontal r34, Alignment.Vertical r35, SnapPosition r36, Function4 r37, int r38, int r39, int r40, Composer r41, int r42) {
        m1252PagereLwUrMk(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r41, RecomposeScopeImplKt.updateChangedFlags(r38 | 1), RecomposeScopeImplKt.updateChangedFlags(r39), r40);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ PagerLayoutIntervalContent a(State r0, State r1, Function0 r2) {
        return rememberPagerItemProviderLambda$lambda$10$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ int b(PagerState r0) {
        return Pager_eLwUrMk$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ Unit c(Modifier r1, PagerState r2, PaddingValues r3, boolean r4, Orientation r5, TargetedFlingBehavior r6, boolean r7, OverscrollEffect r8, int r9, float r10, PageSize r11, NestedScrollConnection r12, Function1 r13, Alignment.Horizontal r14, Alignment.Vertical r15, SnapPosition r16, Function4 r17, int r18, int r19, int r20, Composer r21, int r22) {
        return Pager_eLwUrMk$lambda$7(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public static /* synthetic */ PagerLazyLayoutItemProvider d(State r0, PagerState r1) {
        return rememberPagerItemProviderLambda$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ int e(PagerState r0) {
        return Pager_eLwUrMk$lambda$4$lambda$3(r0);
    }

    private static final int Pager_eLwUrMk$lambda$2$lambda$1(PagerState r0) {
        return r0.getPageCount();
    }

    private static final int Pager_eLwUrMk$lambda$4$lambda$3(PagerState r0) {
        return r0.getPageCount();
    }

    private static final Modifier dragDirectionDetector(Modifier r2, final PagerState r3) {
        return r2.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, r3, new AnonymousClass1(r3)));
    }

    private static final PagerLazyLayoutItemProvider rememberPagerItemProviderLambda$lambda$10$lambda$9(State r2, PagerState r3) {
        PagerLayoutIntervalContent r4 = (PagerLayoutIntervalContent) r2.getValue();
        return new PagerLazyLayoutItemProvider(r3, r4, new NearestRangeKeyIndexMap(r3.getNearestRange$foundation_release(), r4));
    }

    private static final PagerLayoutIntervalContent rememberPagerItemProviderLambda$lambda$10$lambda$8(State r1, State r2, Function0 r3) {
        return new PagerLayoutIntervalContent((Function4) r1.getValue(), (Function1) r2.getValue(), ((Number) r3.invoke()).intValue());
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(final PagerState r5, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> r6, Function1<? super Integer, ? extends Object> r7, final Function0<Integer> r8, Composer r9, int r10) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1052364153, r10, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:258)");
    L5:
        final State r11 = SnapshotStateKt.rememberUpdatedState(r6, r9, (r10 >> 3) & 14);
        final State r12 = SnapshotStateKt.rememberUpdatedState(r7, r9, (r10 >> 6) & 14);
        boolean r1 = false;
        if (((r10 & 14) ^ 6) <= 4) goto L10;
        if (r9.changed(r5) == false) goto L10;
    L11:
        boolean r0 = true;
    L13:
        boolean r2 = (r0 | r9.changed(r11)) | r9.changed(r12);
        if (((r10 & 7168) ^ 3072) <= 2048) goto L18;
        if (r9.changed(r8) == false) goto L18;
    L19:
        r1 = true;
    L20:
        boolean r13 = r2 | r1;
        Object r3 = r9.rememberedValue();
        if (r13 == false) goto L23;
    L24:
        final State r14 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new g(r11, r12, r8));
        final State r15 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new h(r14, r5));
        r3 = new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1(r15);
        r9.updateRememberedValue(r3);
    L25:
        KProperty0 r4 = (KProperty0) r3;
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r4;
    L23:
        if (r3 != Composer.Companion.getEmpty()) goto L25;
    L18:
        if ((r10 & 3072) != 2048) goto L20;
    L10:
        if ((r10 & 6) == 4) goto L11;
        r0 = false;
        goto L13
    }

    /* JADX INFO: renamed from: Pager-eLwUrMk, reason: not valid java name */
    public static final void m1252PagereLwUrMk(final Modifier r34, final PagerState r35, final PaddingValues r36, final boolean r37, final Orientation r38, final TargetedFlingBehavior r39, final boolean r40, final OverscrollEffect r41, int r42, float r43, final PageSize r44, final NestedScrollConnection r45, final Function1<? super Integer, ? extends Object> r46, final Alignment.Horizontal r47, final Alignment.Vertical r48, final SnapPosition r49, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> r50, Composer r51, final int r52, final int r53, final int r54) {
        Composer r7 = r51.startRestartGroup(-572816025);
        if ((r54 & 1) == 0) goto L6;
        int r2 = r52 | 6;
    L14:
        if ((r54 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L23:
        int r16 = 256;
        if ((r54 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L34:
        int r19 = 2048;
        if ((r54 & 8) == 0) goto L38;
        r2 = r2 | 3072;
    L44:
        int r18 = 16384;
        if ((r54 & 16) == 0) goto L48;
        r2 = r2 | 24576;
    L55:
        if ((r54 & 32) == 0) goto L58;
        r2 = r2 | 196608;
    L65:
        if ((r54 & 64) == 0) goto L68;
        r2 = r2 | 1572864;
    L75:
        if ((r54 & 128) == 0) goto L78;
        r2 = r2 | 12582912;
    L85:
        int r5 = r54 & 256;
        if (r5 == 0) goto L89;
        r2 = r2 | 100663296;
    L95:
        int r1 = r54 & 512;
        if (r1 == 0) goto L99;
        r2 = r2 | 805306368;
    L106:
        if ((r54 & 1024) == 0) goto L109;
        int r28 = r53 | 6;
    L117:
        if ((r54 & 2048) == 0) goto L120;
        r28 = r28 | 48;
    L126:
        int r3 = r28;
        if ((r54 & 4096) == 0) goto L130;
        r3 = r3 | 384;
    L138:
        if ((r54 & 8192) == 0) goto L141;
        r3 = r3 | 3072;
    L149:
        if ((r54 & 16384) == 0) goto L152;
        r3 = r3 | 24576;
    L160:
        if ((r54 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L163;
        r3 = r3 | 196608;
    L170:
        if ((r54 & 65536) == 0) goto L173;
        r3 = r3 | 1572864;
    L180:
        if ((r2 & 306783379) == 306783378) goto L182;
    L185:
        boolean r4 = true;
    L187:
        if (r7.shouldExecute(r4, r2 & 1) == false) goto L264;
        if (r5 == 0) goto L190;
        int r6 = 0;
    L191:
        if (r1 == 0) goto L193;
        float r8 = Dp.constructor-impl(0);
    L195:
        if (ComposerKt.isTraceInProgress() == false) goto L197;
        ComposerKt.traceEventStart(-572816025, r2, r3, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:102)");
    L197:
        if (r6 < 0) goto L199;
        boolean r9 = true;
    L200:
        if (r9 == true) goto L202;
        InlineClassHelperKt.throwIllegalArgumentException("beyondViewportPageCount should be greater than or equal to 0, you selected " + r6);
    L202:
        int r10 = r2 & 112;
        if (r10 != 32) goto L205;
        boolean r11 = true;
    L206:
        Object r15 = r7.rememberedValue();
        if (r11 == false) goto L209;
    L210:
        r15 = new d(r35);
        r7.updateRememberedValue(r15);
    L211:
        int r12 = r2 >> 3;
        int r14 = r12 & 14;
        int r17 = r3 >> 15;
        int r110 = r2;
        int r111 = r3;
        int r112 = r6;
        Function0<PagerLazyLayoutItemProvider> r21 = rememberPagerItemProviderLambda(r35, r50, r46, (Function0) r15, r7, (r14 | (r17 & 112)) | (r3 & 896));
        Object r13 = r7.rememberedValue();
        Composer.Companion r22 = Composer.Companion;
        if (r13 != r22.getEmpty()) goto L214;
        Composer r20 = r7;
        r13 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r20);
        r20.updateRememberedValue(r13);
    L215:
        CoroutineScope r23 = (CoroutineScope) r13;
        if (r10 != 32) goto L218;
        boolean r24 = true;
    L219:
        Object r25 = r20.rememberedValue();
        if (r24 == false) goto L222;
    L223:
        r25 = new e(r35);
        r20.updateRememberedValue(r25);
    L224:
        Function0 r113 = (Function0) r25;
        int r26 = r110 >> 9;
        int r27 = ((((((r110 & 896) | r10) | (r110 & 7168)) | (57344 & r110)) | (458752 & r26)) | (r26 & 3670016)) | ((r111 << 21) & 29360128);
        int r29 = r111 << 15;
        Composer r210 = r20;
        float r211 = r8;
        LazyLayoutMeasurePolicy r114 = PagerMeasurePolicyKt.m1264rememberPagerMeasurePolicy8u0NR3k(r21, r35, r36, r37, r38, r112, r8, r44, r47, r48, r49, r23, r113, r210, (r27 | (234881024 & r29)) | (r29 & 1879048192), r17 & 14);
        Orientation r115 = Orientation.Vertical;
        Composer r116 = r210;
        if (r38 != r115) goto L227;
        boolean r117 = true;
    L228:
        LazyLayoutSemanticState r30 = PagerSemanticsKt.rememberPagerSemanticState(r35, r117, r116, r14);
        if (r10 != 32) goto L231;
        boolean r118 = true;
    L233:
        if ((r110 & 458752) != 131072) goto L235;
        boolean r31 = true;
    L236:
        boolean r32 = r31 | r118;
        Object r33 = r116.rememberedValue();
        if (r32 == false) goto L239;
    L242:
        r33 = new PagerWrapperFlingBehavior(r39, r35);
        r116.updateRememberedValue(r33);
    L243:
        PagerWrapperFlingBehavior r119 = (PagerWrapperFlingBehavior) r33;
        BringIntoViewSpec r55 = (BringIntoViewSpec) r116.consume(BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec());
        if (r10 != 32) goto L246;
        boolean r120 = true;
    L247:
        boolean r56 = r116.changed(r55) | r120;
        Object r57 = r116.rememberedValue();
        if (r56 == false) goto L250;
    L251:
        r57 = new PagerBringIntoViewSpec(r35, r55);
        r116.updateRememberedValue(r57);
    L252:
        PagerBringIntoViewSpec r121 = (PagerBringIntoViewSpec) r57;
        if (r40 == false) goto L255;
        r116.startReplaceGroup(-853761213);
        int r58 = r112;
        Modifier r59 = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(r35, r58, r116, r14 | ((r110 >> 21) & 112)), r35.getBeyondBoundsInfo$foundation_release(), r37, r38);
        r116.endReplaceGroup();
    L256:
        Modifier r60 = r59;
        int r122 = r58;
        Modifier r61 = LazyLayoutSemanticsKt.lazyLayoutSemantics(r34.then(r35.getRemeasurementModifier$foundation_release()).then(r35.getAwaitLayoutModifier$foundation_release()), r21, r30, r38, r40, r37, r116, ((r12 & 7168) | ((r110 >> 6) & 57344)) | ((r110 << 6) & 458752));
        if (r38 != r115) goto L259;
        boolean r62 = true;
    L260:
        LazyLayoutKt.LazyLayout(r21, NestedScrollModifierKt.nestedScroll$default(dragDirectionDetector(ScrollingContainerKt.scrollingContainer(PagerKt.pagerSemantics(r61, r35, r62, r23, r40).then(r60), r35, r38, r40, r37, r119, r35.getInternalInteractionSource$foundation_release(), false, r41, r121), r35), r45, null, 2, null), r35.getPrefetchState$foundation_release(), r114, r116, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L263;
        ComposerKt.traceEventEnd();
    L263:
        final int r63 = r122;
    L265:
        ScopeUpdateScope r123 = r116.endRestartGroup();
        if (r123 == null) goto L269;
        final float r124 = r211;
        r123.updateScope(new f(r34, r35, r36, r37, r38, r39, r40, r41, r63, r124, r44, r45, r46, r47, r48, r49, r50, r52, r53, r54));
        return;
    L269:
        return;
    L259:
        r62 = false;
        goto L260
    L255:
        r58 = r112;
        r116.startReplaceGroup(-853331429);
        r116.endReplaceGroup();
        r59 = Modifier.Companion;
        goto L256
    L250:
        if (r57 != r22.getEmpty()) goto L252;
    L246:
        r120 = false;
        goto L247
    L239:
        if (r33 != r22.getEmpty()) goto L243;
    L235:
        r31 = false;
        goto L236
    L231:
        r118 = false;
        goto L233
    L227:
        r117 = false;
        goto L228
    L222:
        if (r25 != r22.getEmpty()) goto L224;
    L218:
        r24 = false;
        goto L219
    L214:
        r20 = r7;
        goto L215
    L209:
        if (r15 != Composer.Companion.getEmpty()) goto L211;
    L205:
        r11 = false;
        goto L206
    L199:
        r9 = false;
        goto L200
    L193:
        r8 = r43;
        goto L195
    L190:
        r6 = r42;
        goto L191
    L264:
        r116 = r7;
        r116.skipToGroupEnd();
        r63 = r42;
        r211 = r43;
        goto L265
    L182:
        if ((599187 & r3) != 599186) goto L185;
        r4 = false;
        goto L187
    L173:
        if ((r53 & 1572864) != 0) goto L180;
        if (r7.changedInstance(r50) == false) goto L177;
        int r125 = 1048576;
    L178:
        r3 = r3 | r125;
        goto L180
    L177:
        r125 = 524288;
        goto L178
    L163:
        if ((r53 & 196608) != 0) goto L170;
        if (r7.changed(r49) == false) goto L167;
        int r126 = 131072;
    L168:
        r3 = r3 | r126;
        goto L170
    L167:
        r126 = 65536;
        goto L168
    L152:
        if ((r53 & 24576) != 0) goto L160;
        if (r7.changed(r48) == true) goto L157;
        r18 = 8192;
    L157:
        r3 = r3 | r18;
        goto L160
    L141:
        if ((r53 & 3072) != 0) goto L149;
        if (r7.changed(r47) == true) goto L146;
        r19 = 1024;
    L146:
        r3 = r3 | r19;
        goto L149
    L130:
        if ((r53 & 384) != 0) goto L138;
        if (r7.changedInstance(r46) == true) goto L135;
        r16 = 128;
    L135:
        r3 = r3 | r16;
        goto L138
    L120:
        if ((r53 & 48) != 0) goto L126;
        if (r7.changedInstance(r45) == false) goto L124;
        int r212 = 32;
    L125:
        r28 = r28 | r212;
        goto L126
    L124:
        r212 = 16;
        goto L125
    L109:
        if ((r53 & 6) == 0) goto L111;
        r28 = r53;
        goto L117
    L111:
        if (r7.changed(r44) == false) goto L113;
        int r213 = 4;
    L114:
        r28 = r53 | r213;
        goto L117
    L113:
        r213 = 2;
        goto L114
    L99:
        if ((r52 & 805306368) != 0) goto L106;
        if (r7.changed(r43) == false) goto L103;
        int r214 = 536870912;
    L104:
        r2 = r2 | r214;
        goto L106
    L103:
        r214 = 268435456;
        goto L104
    L89:
        if ((r52 & 100663296) != 0) goto L95;
        if (r7.changed(r42) == false) goto L93;
        int r215 = 67108864;
    L94:
        r2 = r2 | r215;
        goto L95
    L93:
        r215 = 33554432;
        goto L94
    L78:
        if ((12582912 & r52) != 0) goto L85;
        if (r7.changed(r41) == false) goto L82;
        int r216 = 8388608;
    L83:
        r2 = r2 | r216;
        goto L85
    L82:
        r216 = 4194304;
        goto L83
    L68:
        if ((r52 & 1572864) != 0) goto L75;
        if (r7.changed(r40) == false) goto L72;
        int r64 = 1048576;
    L73:
        r2 = r2 | r64;
        goto L75
    L72:
        r64 = 524288;
        goto L73
    L58:
        if ((r52 & 196608) != 0) goto L65;
        if (r7.changed(r39) == false) goto L62;
        int r65 = 131072;
    L63:
        r2 = r2 | r65;
        goto L65
    L62:
        r65 = 65536;
        goto L63
    L48:
        if ((r52 & 24576) != 0) goto L55;
        if (r7.changed(r38.ordinal()) == false) goto L52;
        int r66 = 16384;
    L53:
        r2 = r2 | r66;
        goto L55
    L52:
        r66 = 8192;
        goto L53
    L38:
        if ((r52 & 3072) != 0) goto L44;
        if (r7.changed(r37) == false) goto L42;
        int r67 = 2048;
    L43:
        r2 = r2 | r67;
        goto L44
    L42:
        r67 = 1024;
        goto L43
    L27:
        if ((r52 & 384) != 0) goto L34;
        if (r7.changed(r36) == false) goto L31;
        int r127 = 256;
    L32:
        r2 = r2 | r127;
        goto L34
    L31:
        r127 = 128;
        goto L32
    L17:
        if ((r52 & 48) != 0) goto L23;
        if (r7.changed(r35) == false) goto L21;
        int r68 = 32;
    L22:
        r2 = r2 | r68;
        goto L23
    L21:
        r68 = 16;
        goto L22
    L6:
        if ((r52 & 6) == 0) goto L8;
        r2 = r52;
        goto L14
    L8:
        if (r7.changed(r34) == false) goto L10;
        int r69 = 4;
    L11:
        r2 = r69 | r52;
        goto L14
    L10:
        r69 = 2;
        goto L11
    }
}
