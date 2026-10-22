package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-w41Enmo", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;FFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridKt {
    private static final Unit LazyStaggeredGrid_w41Enmo$lambda$0(LazyStaggeredGridState r17, Orientation r18, LazyGridStaggeredGridSlotsProvider r19, Modifier r20, PaddingValues r21, boolean r22, FlingBehavior r23, boolean r24, OverscrollEffect r25, float r26, float r27, Function1 r28, int r29, int r30, int r31, Composer r32, int r33) {
        m1215LazyStaggeredGridw41Enmo(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(LazyStaggeredGridState r1, Orientation r2, LazyGridStaggeredGridSlotsProvider r3, Modifier r4, PaddingValues r5, boolean r6, FlingBehavior r7, boolean r8, OverscrollEffect r9, float r10, float r11, Function1 r12, int r13, int r14, int r15, Composer r16, int r17) {
        return LazyStaggeredGrid_w41Enmo$lambda$0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    /* JADX INFO: renamed from: LazyStaggeredGrid-w41Enmo, reason: not valid java name */
    public static final void m1215LazyStaggeredGridw41Enmo(final LazyStaggeredGridState r29, final Orientation r30, final LazyGridStaggeredGridSlotsProvider r31, Modifier r32, PaddingValues r33, boolean r34, FlingBehavior r35, boolean r36, final OverscrollEffect r37, float r38, float r39, final Function1<? super LazyStaggeredGridScope, Unit> r40, Composer r41, final int r42, final int r43, final int r44) {
        Composer r10 = r41.startRestartGroup(-1904835166);
        if ((r44 & 1) == 0) goto L6;
        int r1 = r42 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r44 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L36:
        int r4 = r44 & 8;
        if (r4 == 0) goto L40;
        r1 = r1 | 3072;
    L47:
        int r8 = r44 & 16;
        if (r8 == 0) goto L51;
        r1 = r1 | 24576;
    L57:
        PaddingValues r9 = r33;
    L58:
        int r16 = r44 & 32;
        if (r16 == 0) goto L62;
        r1 = r1 | 196608;
    L69:
        if ((r42 & 1572864) != 0) goto L78;
        if ((r44 & 64) == 0) goto L73;
    L75:
        int r18 = 524288;
    L76:
        r1 = r1 | r18;
        goto L78
    L73:
        if (r10.changed(r35) == false) goto L75;
        r18 = 1048576;
    L78:
        int r5 = r44 & 128;
        if (r5 == 0) goto L82;
        r1 = r1 | 12582912;
    L89:
        if ((r44 & 256) == 0) goto L92;
        r1 = r1 | 100663296;
    L99:
        int r0 = r44 & 512;
        if (r0 == 0) goto L103;
        r1 = r1 | 805306368;
    L109:
        int r2 = r44 & 1024;
        if (r2 == 0) goto L113;
        int r17 = r43 | 6;
    L121:
        if ((r44 & 2048) == 0) goto L124;
        r17 = r17 | 48;
    L130:
        int r3 = r17;
        boolean r19 = true;
        if ((r1 & 306783379) == 306783378) goto L133;
    L136:
        boolean r6 = true;
    L138:
        if (r10.shouldExecute(r6, r1 & 1) == false) goto L185;
        r10.startDefaults();
        if ((r42 & 1) != 0) goto L142;
    L148:
        if (r4 == 0) goto L150;
        Modifier r7 = Modifier.Companion;
    L151:
        if (r8 == 0) goto L153;
        PaddingValues r11 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L154:
        if (r16 == 0) goto L156;
        boolean r12 = false;
    L158:
        if ((r44 & 64) == 0) goto L160;
        FlingBehavior r13 = ScrollableDefaults.INSTANCE.flingBehavior(r10, 6);
        r1 = r1 & (-3670017);
    L161:
        if (r5 != 0) goto L164;
        r19 = r36;
    L164:
        if (r0 == 0) goto L166;
        int r14 = 0;
        float r15 = Dp.constructor-impl(0);
    L167:
        if (r2 == 0) goto L169;
        float r22 = Dp.constructor-impl(r14);
    L170:
        Modifier r20 = r7;
        float r21 = r15;
        PaddingValues r110 = r11;
        boolean r111 = r19;
        FlingBehavior r112 = r13;
        boolean r23 = r12;
        int r24 = r1;
    L171:
        r10.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L174;
        ComposerKt.traceEventStart(-1904835166, r24, r3, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
    L174:
        int r25 = r24 & 14;
        Function0<LazyStaggeredGridItemProvider> r26 = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(r29, r40, r10, (r3 & 112) | r25);
        Object r27 = r10.rememberedValue();
        if (r27 != Composer.Companion.getEmpty()) goto L177;
        r27 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r10);
        r10.updateRememberedValue(r27);
    L177:
        int r28 = r24 >> 6;
        int r210 = r24 >> 12;
        int r211 = r24;
        boolean r113 = r23;
        Modifier r114 = r20;
        LazyLayoutMeasurePolicy r115 = LazyStaggeredGridMeasurePolicyKt.m1228rememberStaggeredGridMeasurePolicyqKj4JfE(r29, r26, r110, r23, r30, r21, r22, (CoroutineScope) r27, r31, (GraphicsContext) r10.consume(CompositionLocalsKt.getLocalGraphicsContext()), r10, (((((r28 & 7168) | ((r28 & 896) | r25)) | ((r24 << 9) & 57344)) | (r210 & 458752)) | (3670016 & (r3 << 18))) | ((r24 << 18) & 234881024));
        LazyLayoutSemanticState r45 = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(r29, r113, r10, (r210 & 112) | r25);
        if (r111 == false) goto L180;
        r10.startReplaceGroup(-1834534838);
        Modifier r46 = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.Companion, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(r29, r10, r25), r29.getBeyondBoundsInfo$foundation_release(), r113, r30);
        r10.endReplaceGroup();
    L181:
        boolean r47 = r111;
        FlingBehavior r48 = r112;
        Composer r212 = r10;
        LazyLayoutKt.LazyLayout(r26, ScrollingContainerKt.scrollingContainer$default(LazyLayoutSemanticsKt.lazyLayoutSemantics(r114.then(r29.getRemeasurementModifier$foundation_release()).then(r29.getAwaitLayoutModifier$foundation_release()), r26, r45, r30, r111, r113, r10, (((r211 << 6) & 7168) | ((r211 >> 9) & 57344)) | (r211 & 458752)).then(r46).then(r29.getItemAnimator$foundation_release().getModifier()), r29, r30, r47, r113, r48, r29.getMutableInteractionSource$foundation_release(), false, r37, null, 256, null), r29.getPrefetchState$foundation_release(), r115, r212, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L184;
        ComposerKt.traceEventEnd();
    L184:
        final boolean r49 = r113;
        final Modifier r50 = r114;
        final PaddingValues r51 = r110;
        final FlingBehavior r52 = r112;
        final boolean r53 = r111;
        final float r116 = r21;
        final float r117 = r22;
    L186:
        ScopeUpdateScope r118 = r212.endRestartGroup();
        if (r118 == null) goto L190;
        r118.updateScope(new m(r29, r30, r31, r50, r51, r49, r52, r53, r37, r116, r117, r40, r42, r43, r44));
        return;
    L190:
        return;
    L180:
        r10.startReplaceGroup(-1834229984);
        r10.endReplaceGroup();
        r46 = Modifier.Companion;
        goto L181
    L169:
        r22 = r39;
        goto L170
    L166:
        r14 = 0;
        r15 = r38;
        goto L167
    L160:
        r13 = r35;
        goto L161
    L156:
        r12 = r34;
        goto L158
    L153:
        r11 = r9;
        goto L154
    L150:
        r7 = r32;
        goto L151
    L142:
        if (r10.getDefaultsInvalid() == true) goto L148;
        r10.skipToGroupEnd();
        if ((r44 & 64) == 0) goto L147;
        r1 = r1 & (-3670017);
    L147:
        r23 = r34;
        r112 = r35;
        r111 = r36;
        r21 = r38;
        r22 = r39;
        r24 = r1;
        r110 = r9;
        r20 = r32;
        goto L171
    L185:
        r212 = r10;
        r212.skipToGroupEnd();
        r50 = r32;
        r49 = r34;
        r52 = r35;
        r53 = r36;
        r116 = r38;
        r117 = r39;
        r51 = r9;
        goto L186
    L133:
        if ((r3 & 19) != 18) goto L136;
        r6 = false;
        goto L138
    L124:
        if ((r43 & 48) != 0) goto L130;
        if (r10.changedInstance(r40) == false) goto L128;
        int r119 = 32;
    L129:
        r17 = r17 | r119;
        goto L130
    L128:
        r119 = 16;
        goto L129
    L113:
        if ((r43 & 6) == 0) goto L115;
        r17 = r43;
        goto L121
    L115:
        if (r10.changed(r39) == false) goto L117;
        int r120 = 4;
    L118:
        r17 = r43 | r120;
        goto L121
    L117:
        r120 = 2;
        goto L118
    L103:
        if ((r42 & 805306368) != 0) goto L109;
        if (r10.changed(r38) == false) goto L107;
        int r213 = 536870912;
    L108:
        r1 = r1 | r213;
        goto L109
    L107:
        r213 = 268435456;
        goto L108
    L92:
        if ((r42 & 100663296) != 0) goto L99;
        if (r10.changed(r37) == false) goto L96;
        int r214 = 67108864;
    L97:
        r1 = r1 | r214;
        goto L99
    L96:
        r214 = 33554432;
        goto L97
    L82:
        if ((r42 & 12582912) != 0) goto L89;
        if (r10.changed(r36) == false) goto L86;
        int r215 = 8388608;
    L87:
        r1 = r1 | r215;
        goto L89
    L86:
        r215 = 4194304;
        goto L87
    L62:
        if ((r42 & 196608) != 0) goto L69;
        if (r10.changed(r34) == false) goto L66;
        int r121 = 131072;
    L67:
        r1 = r1 | r121;
        goto L69
    L66:
        r121 = 65536;
        goto L67
    L51:
        if ((r42 & 24576) != 0) goto L57;
        r9 = r33;
        if (r10.changed(r9) == false) goto L55;
        int r122 = 16384;
    L56:
        r1 = r1 | r122;
        goto L58
    L55:
        r122 = 8192;
        goto L56
    L40:
        if ((r42 & 3072) != 0) goto L47;
        if (r10.changed(r32) == false) goto L44;
        int r54 = 2048;
    L45:
        r1 = r1 | r54;
        goto L47
    L44:
        r54 = 1024;
        goto L45
    L27:
        if ((r42 & 384) != 0) goto L36;
        if ((r42 & 512) != 0) goto L31;
        boolean r55 = r10.changed(r31);
    L32:
        if (r55 == false) goto L34;
        int r56 = 256;
    L35:
        r1 = r1 | r56;
        goto L36
    L34:
        r56 = 128;
        goto L35
    L31:
        r55 = r10.changedInstance(r31);
        goto L32
    L17:
        if ((r42 & 48) != 0) goto L24;
        if (r10.changed(r30.ordinal()) == false) goto L21;
        int r57 = 32;
    L22:
        r1 = r1 | r57;
        goto L24
    L21:
        r57 = 16;
        goto L22
    L6:
        if ((r42 & 6) == 0) goto L8;
        r1 = r42;
        goto L14
    L8:
        if (r10.changed(r29) == false) goto L10;
        int r58 = 4;
    L11:
        r1 = r58 | r42;
        goto L14
    L10:
        r58 = 2;
        goto L11
    }
}
