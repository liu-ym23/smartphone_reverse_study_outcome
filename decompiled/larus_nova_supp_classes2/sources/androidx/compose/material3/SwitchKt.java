package androidx.compose.material3;

import androidx.compose.animation.core.SnapSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001al\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001aR\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0013\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u0017X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019\"\u0016\u0010\u001b\u001a\u00020\u0017X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019\"\u0010\u0010\u001d\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001e\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001f\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/SwitchColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "ThumbDiameter", "Landroidx/compose/ui/unit/Dp;", "getThumbDiameter", "()F", "F", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "SwitchWidth", "SwitchHeight", "ThumbPadding", "SnapSpec", "Landroidx/compose/animation/core/SnapSpec;", "", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SwitchKt {
    private static final SnapSpec<Float> SnapSpec = null;
    private static final float SwitchHeight = 0.0f;
    private static final float SwitchWidth = 0.0f;
    private static final float ThumbDiameter = 0.0f;
    private static final float ThumbPadding = 0.0f;
    private static final float UncheckedThumbDiameter = 0.0f;

    private static final Unit Switch$lambda$1(boolean r11, Function1 r12, Modifier r13, Function2 r14, boolean r15, SwitchColors r16, MutableInteractionSource r17, int r18, int r19, Composer r20, int r21) {
        Switch(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit SwitchImpl$lambda$4(Modifier r10, boolean r11, boolean r12, SwitchColors r13, Function2 r14, InteractionSource r15, Shape r16, int r17, Composer r18, int r19) {
        SwitchImpl(r10, r11, r12, r13, r14, r15, r16, r18, RecomposeScopeImplKt.updateChangedFlags(r17 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, boolean r1, boolean r2, SwitchColors r3, Function2 r4, InteractionSource r5, Shape r6, int r7, Composer r8, int r9) {
        return SwitchImpl$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit b(boolean r0, Function1 r1, Modifier r2, Function2 r3, boolean r4, SwitchColors r5, MutableInteractionSource r6, int r7, int r8, Composer r9, int r10) {
        return Switch$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    static {
        SwitchTokens r0 = SwitchTokens.INSTANCE;
        float r1 = r0.getSelectedHandleWidth-D9Ej5fM();
        ThumbDiameter = r1;
        UncheckedThumbDiameter = r0.getUnselectedHandleWidth-D9Ej5fM();
        SwitchWidth = r0.getTrackWidth-D9Ej5fM();
        float r2 = r0.getTrackHeight-D9Ej5fM();
        SwitchHeight = r2;
        ThumbPadding = Dp.constructor-impl(Dp.constructor-impl(r2 - r1) / 2);
        SnapSpec = new SnapSpec(0, 1, null);
    }

    public static final /* synthetic */ SnapSpec access$getSnapSpec$p() {
        return SnapSpec;
    }

    public static final /* synthetic */ float access$getSwitchHeight$p() {
        return SwitchHeight;
    }

    public static final /* synthetic */ float access$getSwitchWidth$p() {
        return SwitchWidth;
    }

    public static final /* synthetic */ float access$getThumbPadding$p() {
        return ThumbPadding;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }

    private static final void SwitchImpl(final Modifier r25, final boolean r26, final boolean r27, final SwitchColors r28, final Function2<? super Composer, ? super Integer, Unit> r29, final InteractionSource r30, final Shape r31, Composer r32, final int r33) {
        Composer r9 = r32.startRestartGroup(-670917213);
        if ((r33 & 6) == 0) goto L5;
        int r10 = r33;
    L11:
        if ((r33 & 48) != 0) goto L18;
        if (r9.changed(r26) == false) goto L15;
        int r12 = 32;
    L16:
        r10 = r10 | r12;
        goto L18
    L15:
        r12 = 16;
    L18:
        if ((r33 & 384) != 0) goto L25;
        if (r9.changed(r27) == false) goto L22;
        int r13 = 256;
    L23:
        r10 = r10 | r13;
        goto L25
    L22:
        r13 = 128;
    L25:
        if ((r33 & 3072) != 0) goto L32;
        if (r9.changed(r28) == false) goto L29;
        int r14 = 2048;
    L30:
        r10 = r10 | r14;
        goto L32
    L29:
        r14 = 1024;
    L32:
        if ((r33 & 24576) != 0) goto L39;
        if (r9.changedInstance(r29) == false) goto L36;
        int r15 = 16384;
    L37:
        r10 = r10 | r15;
        goto L39
    L36:
        r15 = 8192;
    L39:
        if ((196608 & r33) != 0) goto L46;
        if (r9.changed(r30) == false) goto L43;
        int r16 = 131072;
    L44:
        r10 = r10 | r16;
        goto L46
    L43:
        r16 = 65536;
    L46:
        if ((1572864 & r33) != 0) goto L53;
        if (r9.changed(r31) == false) goto L50;
        int r17 = 1048576;
    L51:
        r10 = r10 | r17;
        goto L53
    L50:
        r17 = 524288;
    L53:
        if ((599187 & r10) == 599186) goto L55;
        boolean r18 = true;
    L57:
        if (r9.shouldExecute(r18, r10 & 1) == true) goto L59;
        r9.skipToGroupEnd();
    L93:
        ScopeUpdateScope r11 = r9.endRestartGroup();
        if (r11 == null) goto L97;
        r11.updateScope(new wr(r25, r26, r27, r28, r29, r30, r31, r33));
        return;
    L97:
        return;
    L59:
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventStart(-670917213, r10, -1, "androidx.compose.material3.SwitchImpl (Switch.kt:143)");
    L61:
        long r19 = r28.m3242trackColorWaAFU9c$material3(r27, r26);
        long r110 = r28.m3241thumbColorWaAFU9c$material3(r27, r26);
        SwitchTokens r0 = SwitchTokens.INSTANCE;
        Shape r111 = ShapesKt.getValue(r0.getTrackShape(), r9, 6);
        Modifier r8 = BackgroundKt.m341backgroundbw27NRU(BorderKt.m353borderxT4_qwU(r25, r0.getTrackOutlineWidth-D9Ej5fM(), r28.m3222borderColorWaAFU9c$material3(r27, r26), r111), r19, r111);
        Alignment.Companion r112 = Alignment.Companion;
        MeasurePolicy r113 = BoxKt.maybeCachedBoxMeasurePolicy(r112.getTopStart(), false);
        int r114 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r115 = r9.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r9, r8);
        ComposeUiNode.Companion r116 = ComposeUiNode.Companion;
        Function0 r1 = r116.getConstructor();
        int r117 = r10;
        if ((r9.getApplier() instanceof Applier) == true) goto L64;
        ComposablesKt.invalidApplier();
    L64:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L67;
        r9.createNode(r1);
    L68:
        Composer r2 = Updater.constructor-impl(r9);
        Updater.set-impl(r2, r113, r116.getSetMeasurePolicy());
        Updater.set-impl(r2, r115, r116.getSetResolvedCompositionLocals());
        Function2 r118 = r116.getSetCompositeKeyHash();
        if (r2.getInserting() == false) goto L71;
    L72:
        r2.updateRememberedValue(Integer.valueOf(r114));
        r2.apply(Integer.valueOf(r114), r118);
    L73:
        Updater.set-impl(r2, r20, r116.getSetModifier());
        Modifier r3 = BackgroundKt.m341backgroundbw27NRU(IndicationKt.indication(BoxScopeInstance.INSTANCE.align(Modifier.Companion, r112.getCenterStart()).then(new ThumbElement(r30, r26, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r9, 6))), r30, RippleKt.m3031rippleH2RKhps$default(false, Dp.constructor-impl(r0.getStateLayerSize-D9Ej5fM() / 2), 0, 4, null)), r110, r31);
        MeasurePolicy r4 = BoxKt.maybeCachedBoxMeasurePolicy(r112.getCenter(), false);
        int r21 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r119 = r9.getCurrentCompositionLocalMap();
        Modifier r5 = ComposedModifierKt.materializeModifier(r9, r3);
        Function0 r120 = r116.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L76;
        ComposablesKt.invalidApplier();
    L76:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L79;
        r9.createNode(r120);
    L80:
        Composer r121 = Updater.constructor-impl(r9);
        Updater.set-impl(r121, r4, r116.getSetMeasurePolicy());
        Updater.set-impl(r121, r119, r116.getSetResolvedCompositionLocals());
        Function2 r6 = r116.getSetCompositeKeyHash();
        if (r121.getInserting() == false) goto L83;
    L84:
        r121.updateRememberedValue(Integer.valueOf(r21));
        r121.apply(Integer.valueOf(r21), r6);
    L85:
        Updater.set-impl(r121, r5, r116.getSetModifier());
        if (r29 == null) goto L88;
        r9.startReplaceGroup(1235836927);
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(r28.m3240iconColorWaAFU9c$material3(r27, r26))), r29, r9, ProvidedValue.$stable | ((r117 >> 9) & 112));
        r9.endReplaceGroup();
    L89:
        r9.endNode();
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        ComposerKt.traceEventEnd();
        goto L93
    L88:
        r9.startReplaceGroup(1236071411);
        r9.endReplaceGroup();
        goto L89
    L83:
        if (Intrinsics.areEqual(r121.rememberedValue(), Integer.valueOf(r21)) == true) goto L85;
    L79:
        r9.useNode();
        goto L80
    L71:
        if (Intrinsics.areEqual(r2.rememberedValue(), Integer.valueOf(r114)) == true) goto L73;
    L67:
        r9.useNode();
        goto L68
    L55:
        r18 = false;
        goto L57
    L5:
        if (r9.changed(r25) == false) goto L7;
        int r122 = 4;
    L8:
        r10 = r122 | r33;
        goto L11
    L7:
        r122 = 2;
        goto L8
    }

    public static final void Switch(final boolean r22, final Function1<? super Boolean, Unit> r23, Modifier r24, Function2<? super Composer, ? super Integer, Unit> r25, boolean r26, SwitchColors r27, MutableInteractionSource r28, Composer r29, final int r30, final int r31) {
        Composer r15 = r29.startRestartGroup(-263339167);
        if ((r31 & 1) == 0) goto L6;
        int r1 = r30 | 6;
    L14:
        if ((r31 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r31 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r31 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        Function2<? super Composer, ? super Integer, Unit> r5 = r25;
    L45:
        int r6 = r31 & 16;
        if (r6 == 0) goto L49;
        r1 = r1 | 24576;
    L55:
        boolean r10 = r26;
    L57:
        if ((196608 & r30) == 0) goto L59;
        SwitchColors r11 = r27;
    L67:
        int r12 = r31 & 64;
        if (r12 == 0) goto L71;
        r1 = r1 | 1572864;
    L77:
        MutableInteractionSource r13 = r28;
    L79:
        if ((r1 & 599187) == 599186) goto L81;
        boolean r0 = true;
    L83:
        if (r15.shouldExecute(r0, r1 & 1) == false) goto L122;
        r15.startDefaults();
        if ((r30 & 1) != 0) goto L87;
    L93:
        if (r2 == 0) goto L95;
        Modifier r3 = Modifier.Companion;
    L96:
        if (r4 == 0) goto L98;
        r5 = null;
    L98:
        if (r6 == 0) goto L101;
        r10 = true;
    L101:
        if ((r31 & 32) == 0) goto L103;
        r1 = r1 & (-458753);
        r11 = SwitchDefaults.INSTANCE.colors(r15, 6);
    L103:
        if (r12 == 0) goto L105;
        Modifier r14 = r3;
        int r9 = r1;
        Function2<? super Composer, ? super Integer, Unit> r18 = r5;
        boolean r19 = r10;
        SwitchColors r20 = r11;
        MutableInteractionSource r21 = null;
    L106:
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventStart(-263339167, r9, -1, "androidx.compose.material3.Switch (Switch.kt:98)");
    L109:
        if (r21 != null) goto L114;
        r15.startReplaceGroup(1768604058);
        Object r7 = r15.rememberedValue();
        if (r7 != Composer.Companion.getEmpty()) goto L113;
        r7 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r7);
    L113:
        r15.endReplaceGroup();
        MutableInteractionSource r16 = (MutableInteractionSource) r7;
    L115:
        if (r23 == null) goto L117;
        MutableInteractionSource r8 = r16;
        boolean r17 = false;
        Object r110 = null;
        int r111 = 6;
        boolean r32 = r19;
        Modifier r33 = ToggleableKt.m1297toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion), r22, r8, null, r32, Role.box-impl(Role.Companion.getSwitch-o7Vup1c()), r23);
    L118:
        Modifier r34 = SizeKt.m1008requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(r14.then(r33), Alignment.Companion.getCenter(), r17, 2, r110), SwitchWidth, SwitchHeight);
        Shape r35 = ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), r15, r111);
        int r36 = r9 << 3;
        int r37 = r9 >> 6;
        int r112 = (((r36 & 112) | (r37 & 896)) | (r37 & 7168)) | (r36 & 57344);
        Modifier r38 = r14;
        Composer r39 = r15;
        SwitchImpl(r34, r22, r19, r20, r18, r16, r35, r39, r112);
        if (ComposerKt.isTraceInProgress() == false) goto L121;
        ComposerKt.traceEventEnd();
    L121:
        final Modifier r40 = r38;
        final Function2<? super Composer, ? super Integer, Unit> r41 = r18;
        final boolean r42 = r19;
        final SwitchColors r43 = r20;
    L123:
        ScopeUpdateScope r113 = r39.endRestartGroup();
        if (r113 == null) goto L127;
        final MutableInteractionSource r44 = r21;
        r113.updateScope(new xr(r22, r23, r40, r41, r42, r43, r44, r30, r31));
        return;
    L127:
        return;
    L117:
        r17 = false;
        r110 = null;
        r111 = 6;
        r33 = Modifier.Companion;
        goto L118
    L114:
        r15.startReplaceGroup(334145757);
        r15.endReplaceGroup();
        r16 = r21;
        goto L115
    L105:
        r9 = r1;
        r18 = r5;
        r19 = r10;
        r20 = r11;
        r21 = r13;
        r14 = r3;
        goto L106
    L95:
        r3 = r24;
        goto L96
    L87:
        if (r15.getDefaultsInvalid() == true) goto L93;
        r15.skipToGroupEnd();
        if ((r31 & 32) == 0) goto L92;
        r1 = r1 & (-458753);
    L92:
        r9 = r1;
        r18 = r5;
        r19 = r10;
        r20 = r11;
        r21 = r13;
        r14 = r24;
        goto L106
    L122:
        r39 = r15;
        r39.skipToGroupEnd();
        r40 = r24;
        r41 = r5;
        r42 = r10;
        r43 = r11;
        r21 = r13;
        goto L123
    L81:
        r0 = false;
        goto L83
    L71:
        if ((1572864 & r30) != 0) goto L77;
        r13 = r28;
        if (r15.changed(r13) == false) goto L75;
        int r114 = 1048576;
    L76:
        r1 = r1 | r114;
        goto L79
    L75:
        r114 = 524288;
        goto L76
    L59:
        if ((r31 & 32) != 0) goto L63;
        r11 = r27;
        if (r15.changed(r11) == false) goto L64;
        int r115 = 131072;
    L65:
        r1 = r1 | r115;
    L64:
        r115 = 65536;
        goto L65
    L63:
        r11 = r27;
        goto L64
    L49:
        if ((r30 & 24576) != 0) goto L55;
        r10 = r26;
        if (r15.changed(r10) == false) goto L53;
        int r116 = 16384;
    L54:
        r1 = r1 | r116;
        goto L57
    L53:
        r116 = 8192;
        goto L54
    L38:
        if ((r30 & 3072) != 0) goto L44;
        r5 = r25;
        if (r15.changedInstance(r5) == false) goto L42;
        int r45 = 2048;
    L43:
        r1 = r1 | r45;
        goto L45
    L42:
        r45 = 1024;
        goto L43
    L27:
        if ((r30 & 384) != 0) goto L34;
        if (r15.changed(r24) == false) goto L31;
        int r46 = 256;
    L32:
        r1 = r1 | r46;
        goto L34
    L31:
        r46 = 128;
        goto L32
    L17:
        if ((r30 & 48) != 0) goto L23;
        if (r15.changedInstance(r23) == false) goto L21;
        int r47 = 32;
    L22:
        r1 = r1 | r47;
        goto L23
    L21:
        r47 = 16;
        goto L22
    L6:
        if ((r30 & 6) == 0) goto L8;
        r1 = r30;
        goto L14
    L8:
        if (r15.changed(r22) == false) goto L10;
        int r48 = 4;
    L11:
        r1 = r48 | r30;
        goto L14
    L10:
        r48 = 2;
        goto L11
    }
}
