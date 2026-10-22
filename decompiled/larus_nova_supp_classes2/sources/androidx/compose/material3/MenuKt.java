package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0082\u0001\u0010\u001c\u001a\u00020\u00012\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0013\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e¢\u0006\u0002\b\u00182\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e¢\u0006\u0002\b\u00182\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0001¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0000¢\u0006\u0002\u0010.\"\u0016\u0010/\u001a\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101\"\u0010\u00103\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00104\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0016\u00105\u001a\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\b6\u00101\"\u0010\u00107\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00108\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u000e\u00109\u001a\u00020:X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020:X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020:X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020:X\u0080T¢\u0006\u0002\n\u0000¨\u0006>²\u0006\n\u0010?\u001a\u00020:X\u008a\u0084\u0002²\u0006\n\u0010@\u001a\u00020:X\u008a\u0084\u0002"}, d2 = {"DropdownMenuContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "expandedState", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenuContent-Qj0Zi0g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "MenuVerticalMargin", "getMenuVerticalMargin", "()F", "F", "MenuListItemContainerHeight", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemDefaultMaxWidth", "ExpandedScaleTarget", "", "ClosedScaleTarget", "ExpandedAlphaTarget", "ClosedAlphaTarget", "material3", "scale", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MenuKt {
    public static final float ClosedAlphaTarget = 0.0f;
    public static final float ClosedScaleTarget = 0.8f;
    private static final float DropdownMenuItemDefaultMaxWidth = 0.0f;
    private static final float DropdownMenuItemDefaultMinWidth = 0.0f;
    private static final float DropdownMenuItemHorizontalPadding = 0.0f;
    private static final float DropdownMenuVerticalPadding = 0.0f;
    public static final float ExpandedAlphaTarget = 1.0f;
    public static final float ExpandedScaleTarget = 1.0f;
    private static final float MenuListItemContainerHeight = 0.0f;
    private static final float MenuVerticalMargin = 0.0f;

    private static final Unit DropdownMenuContent_Qj0Zi0g$lambda$6(Modifier r14, MutableTransitionState r15, MutableState r16, ScrollState r17, Shape r18, long r19, float r21, float r22, BorderStroke r23, Function3 r24, int r25, Composer r26, int r27) {
        m2865DropdownMenuContentQj0Zi0g(r14, r15, r16, r17, r18, r19, r21, r22, r23, r24, r26, RecomposeScopeImplKt.updateChangedFlags(r25 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit DropdownMenuItemContent$lambda$8(Function2 r12, Function0 r13, Modifier r14, Function2 r15, Function2 r16, boolean r17, MenuItemColors r18, PaddingValues r19, MutableInteractionSource r20, int r21, Composer r22, int r23) {
        DropdownMenuItemContent(r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, RecomposeScopeImplKt.updateChangedFlags(r21 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(boolean r0, MutableTransitionState r1, MutableState r2, State r3, State r4, GraphicsLayerScope r5) {
        return DropdownMenuContent_Qj0Zi0g$lambda$5$lambda$4(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit b(Function2 r0, Function0 r1, Modifier r2, Function2 r3, Function2 r4, boolean r5, MenuItemColors r6, PaddingValues r7, MutableInteractionSource r8, int r9, Composer r10, int r11) {
        return DropdownMenuItemContent$lambda$8(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit c(Modifier r0, MutableTransitionState r1, MutableState r2, ScrollState r3, Shape r4, long r5, float r7, float r8, BorderStroke r9, Function3 r10, int r11, Composer r12, int r13) {
        return DropdownMenuContent_Qj0Zi0g$lambda$6(r0, r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13);
    }

    static {
        float r0 = 48;
        MenuVerticalMargin = Dp.constructor-impl(r0);
        MenuListItemContainerHeight = Dp.constructor-impl(r0);
        DropdownMenuItemHorizontalPadding = Dp.constructor-impl(12);
        DropdownMenuVerticalPadding = Dp.constructor-impl(8);
        DropdownMenuItemDefaultMinWidth = Dp.constructor-impl(112);
        DropdownMenuItemDefaultMaxWidth = Dp.constructor-impl(280);
    }

    public static final /* synthetic */ float access$getDropdownMenuItemHorizontalPadding$p() {
        return DropdownMenuItemHorizontalPadding;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    private static final float DropdownMenuContent_Qj0Zi0g$lambda$1(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final float DropdownMenuContent_Qj0Zi0g$lambda$3(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    public static final long calculateTransformOrigin(IntRect r5, IntRect r6) {
        float r2 = 1.0f;
        if (r6.getLeft() < r5.getRight()) goto L6;
    L4:
        float r0 = ClosedAlphaTarget;
    L13:
        if (r6.getTop() < r5.getBottom()) goto L16;
    L14:
        r2 = ClosedAlphaTarget;
    L23:
        return TransformOriginKt.TransformOrigin(r0, r2);
    L16:
        if (r6.getBottom() <= r5.getTop()) goto L23;
        if (r6.getHeight() == 0) goto L14;
        r2 = (((Math.max(r5.getTop(), r6.getTop()) + Math.min(r5.getBottom(), r6.getBottom())) / 2) - r6.getTop()) / r6.getHeight();
        goto L23
    L6:
        if (r6.getRight() > r5.getLeft()) goto L9;
        r0 = 1.0f;
        goto L13
    L9:
        if (r6.getWidth() == 0) goto L4;
        r0 = (((Math.max(r5.getLeft(), r6.getLeft()) + Math.min(r5.getRight(), r6.getRight())) / 2) - r6.getLeft()) / r6.getWidth();
        goto L13
    }

    private static final Unit DropdownMenuContent_Qj0Zi0g$lambda$5$lambda$4(boolean r3, MutableTransitionState r4, MutableState r5, State r6, State r7, GraphicsLayerScope r8) {
        float r0 = 0.8f;
        float r1 = 1.0f;
        if (r3 == true) goto L6;
        float r2 = DropdownMenuContent_Qj0Zi0g$lambda$1(r6);
    L9:
        r8.setScaleX(r2);
        if (r3 == true) goto L13;
        r0 = DropdownMenuContent_Qj0Zi0g$lambda$1(r6);
    L15:
        r8.setScaleY(r0);
        if (r3 == true) goto L19;
        r1 = DropdownMenuContent_Qj0Zi0g$lambda$3(r7);
    L22:
        r8.setAlpha(r1);
        r8.setTransformOrigin-__ExYCQ(((TransformOrigin) r5.getValue()).unbox-impl());
        return Unit.INSTANCE;
    L19:
        if (((Boolean) r4.getTargetState()).booleanValue() == true) goto L22;
        r1 = ClosedAlphaTarget;
        goto L22
    L13:
        if (((Boolean) r4.getTargetState()).booleanValue() == false) goto L15;
        r0 = 1.0f;
        goto L15
    L6:
        if (((Boolean) r4.getTargetState()).booleanValue() == false) goto L8;
        r2 = 1.0f;
        goto L9
    L8:
        r2 = 0.8f;
        goto L9
    }

    public static final void DropdownMenuItemContent(final Function2<? super Composer, ? super Integer, Unit> r22, final Function0<Unit> r23, final Modifier r24, final Function2<? super Composer, ? super Integer, Unit> r25, final Function2<? super Composer, ? super Integer, Unit> r26, final boolean r27, final MenuItemColors r28, final PaddingValues r29, final MutableInteractionSource r30, Composer r31, final int r32) {
        Composer r1 = r31.startRestartGroup(-1325192924);
        if ((r32 & 6) == 0) goto L5;
        int r3 = r32;
    L11:
        if ((r32 & 48) != 0) goto L19;
        if (r1.changedInstance(r23) == false) goto L15;
        int r5 = 32;
    L16:
        r3 = r3 | r5;
        goto L19
    L15:
        r5 = 16;
    L19:
        if ((r32 & 384) != 0) goto L27;
        if (r1.changed(r24) == false) goto L23;
        int r6 = 256;
    L24:
        r3 = r3 | r6;
        goto L27
    L23:
        r6 = 128;
    L27:
        if ((r32 & 3072) != 0) goto L35;
        if (r1.changedInstance(r25) == false) goto L31;
        int r7 = 2048;
    L32:
        r3 = r3 | r7;
        goto L35
    L31:
        r7 = 1024;
    L35:
        if ((r32 & 24576) != 0) goto L43;
        if (r1.changedInstance(r26) == false) goto L39;
        int r9 = 16384;
    L40:
        r3 = r3 | r9;
        goto L43
    L39:
        r9 = 8192;
    L43:
        if ((196608 & r32) != 0) goto L51;
        if (r1.changed(r27) == false) goto L47;
        int r11 = 131072;
    L48:
        r3 = r3 | r11;
        goto L51
    L47:
        r11 = 65536;
    L51:
        if ((1572864 & r32) != 0) goto L58;
        if (r1.changed(r28) == false) goto L55;
        int r12 = 1048576;
    L56:
        r3 = r3 | r12;
        goto L58
    L55:
        r12 = 524288;
    L58:
        if ((12582912 & r32) != 0) goto L65;
        if (r1.changed(r29) == false) goto L62;
        int r13 = 8388608;
    L63:
        r3 = r3 | r13;
        goto L65
    L62:
        r13 = 4194304;
    L65:
        if ((100663296 & r32) != 0) goto L72;
        if (r1.changed(r30) == false) goto L69;
        int r14 = 67108864;
    L70:
        r3 = r3 | r14;
        goto L72
    L69:
        r14 = 33554432;
    L72:
        if ((38347923 & r3) == 38347922) goto L74;
        boolean r15 = true;
    L76:
        if (r1.shouldExecute(r15, r3 & 1) == true) goto L78;
        r1.skipToGroupEnd();
    L96:
        ScopeUpdateScope r16 = r1.endRestartGroup();
        if (r16 == null) goto L100;
        r16.updateScope(new vd(r22, r23, r24, r25, r26, r27, r28, r29, r30, r32));
        return;
    L100:
        return;
    L78:
        if (ComposerKt.isTraceInProgress() == false) goto L80;
        ComposerKt.traceEventStart(-1325192924, r3, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:428)");
    L80:
        Modifier r17 = SizeKt.fillMaxWidth$default(ClickableKt.m375clickableO2vRcR0$default(r24, r30, RippleKt.m3031rippleH2RKhps$default(true, ClosedAlphaTarget, 0, 6, null), r27, null, null, r23, 24, null), ClosedAlphaTarget, 1, null);
        float r18 = DropdownMenuItemDefaultMinWidth;
        float r19 = DropdownMenuItemDefaultMaxWidth;
        Modifier r4 = PaddingKt.padding(SizeKt.m1018sizeInqDBjuR0$default(r17, r18, MenuListItemContainerHeight, r19, ClosedAlphaTarget, 8, null), r29);
        Alignment.Vertical r110 = Alignment.Companion.getCenterVertically();
        MeasurePolicy r111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), r110, r1, 48);
        int r112 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r113 = r1.getCurrentCompositionLocalMap();
        Modifier r8 = ComposedModifierKt.materializeModifier(r1, r4);
        ComposeUiNode.Companion r114 = ComposeUiNode.Companion;
        Function0 r115 = r114.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L83;
        ComposablesKt.invalidApplier();
    L83:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L86;
        r1.createNode(r115);
    L87:
        Composer r0 = Updater.constructor-impl(r1);
        Updater.set-impl(r0, r111, r114.getSetMeasurePolicy());
        Updater.set-impl(r0, r113, r114.getSetResolvedCompositionLocals());
        Function2 r116 = r114.getSetCompositeKeyHash();
        if (r0.getInserting() == false) goto L90;
    L91:
        r0.updateRememberedValue(Integer.valueOf(r112));
        r0.apply(Integer.valueOf(r112), r116);
    L92:
        Updater.set-impl(r0, r8, r114.getSetModifier());
        final RowScopeInstance r117 = RowScopeInstance.INSTANCE;
        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(r1, 6).getLabelLarge(), ComposableLambdaKt.rememberComposableLambda(865999929, true, new MenuKt$DropdownMenuItemContent$1$1(r25, r28, r27, r26, r117, r22), r1, 54), r1, 48);
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L96;
        ComposerKt.traceEventEnd();
        goto L96
    L90:
        if (Intrinsics.areEqual(r0.rememberedValue(), Integer.valueOf(r112)) == true) goto L92;
    L86:
        r1.useNode();
        goto L87
    L74:
        r15 = false;
        goto L76
    L5:
        if (r1.changedInstance(r22) == false) goto L7;
        int r10 = 4;
    L8:
        r3 = r10 | r32;
        goto L11
    L7:
        r10 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: DropdownMenuContent-Qj0Zi0g, reason: not valid java name */
    public static final void m2865DropdownMenuContentQj0Zi0g(final Modifier r27, final MutableTransitionState<Boolean> r28, final MutableState<TransformOrigin> r29, final ScrollState r30, final Shape r31, final long r32, final float r34, final float r35, final BorderStroke r36, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r37, Composer r38, final int r39) {
        Composer r10 = r38.startRestartGroup(848986741);
        if ((r39 & 6) == 0) goto L5;
        int r2 = r39;
    L11:
        if ((r39 & 48) != 0) goto L21;
        if ((r39 & 64) != 0) goto L15;
        boolean r3 = r10.changed(r28);
    L16:
        if (r3 == false) goto L18;
        int r4 = 32;
    L19:
        r2 = r2 | r4;
        goto L21
    L18:
        r4 = 16;
        goto L19
    L15:
        r3 = r10.changedInstance(r28);
    L21:
        if ((r39 & 384) != 0) goto L28;
        if (r10.changed(r29) == false) goto L25;
        int r5 = 256;
    L26:
        r2 = r2 | r5;
        goto L28
    L25:
        r5 = 128;
    L28:
        if ((r39 & 3072) != 0) goto L35;
        if (r10.changed(r30) == false) goto L32;
        int r6 = 2048;
    L33:
        r2 = r2 | r6;
        goto L35
    L32:
        r6 = 1024;
    L35:
        if ((r39 & 24576) != 0) goto L42;
        if (r10.changed(r31) == false) goto L39;
        int r7 = 16384;
    L40:
        r2 = r2 | r7;
        goto L42
    L39:
        r7 = 8192;
    L42:
        if ((196608 & r39) != 0) goto L49;
        if (r10.changed(r32) == false) goto L46;
        int r8 = 131072;
    L47:
        r2 = r2 | r8;
        goto L49
    L46:
        r8 = 65536;
    L49:
        if ((1572864 & r39) != 0) goto L57;
        if (r10.changed(r34) == false) goto L53;
        int r13 = 1048576;
    L54:
        r2 = r2 | r13;
        goto L57
    L53:
        r13 = 524288;
    L57:
        if ((r39 & 12582912) != 0) goto L65;
        if (r10.changed(r35) == false) goto L61;
        int r16 = 8388608;
    L62:
        r2 = r2 | r16;
        goto L65
    L61:
        r16 = 4194304;
    L65:
        if ((r39 & 100663296) != 0) goto L72;
        if (r10.changed(r36) == false) goto L69;
        int r17 = 67108864;
    L70:
        r2 = r2 | r17;
        goto L72
    L69:
        r17 = 33554432;
    L72:
        if ((r39 & 805306368) != 0) goto L79;
        if (r10.changedInstance(r37) == false) goto L76;
        int r18 = 536870912;
    L77:
        r2 = r2 | r18;
        goto L79
    L76:
        r18 = 268435456;
    L79:
        if ((r2 & 306783379) == 306783378) goto L81;
        boolean r0 = true;
    L83:
        if (r10.shouldExecute(r0, r2 & 1) == true) goto L85;
        r10.skipToGroupEnd();
    L147:
        ScopeUpdateScope r14 = r10.endRestartGroup();
        if (r14 == null) goto L151;
        r14.updateScope(new ud(r27, r28, r29, r30, r31, r32, r34, r35, r36, r37, r39));
        return;
    L151:
        return;
    L85:
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventStart(848986741, r2, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:369)");
    L87:
        Transition r1 = TransitionKt.updateTransition(r28, "DropDownMenu", r10, (MutableTransitionState.$stable | 48) | ((r2 >> 3) & 14), 0);
        final FiniteAnimationSpec r9 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r10, 6);
        final FiniteAnimationSpec r11 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r10, 6);
        Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> r12 = new MenuKt$DropdownMenuContent$scale$2(r9);
        FloatCompanionObject r15 = FloatCompanionObject.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> r19 = VectorConvertersKt.getVectorConverter(r15);
        boolean r110 = ((Boolean) r1.getCurrentState()).booleanValue();
        r10.startReplaceGroup(143964305);
        if (ComposerKt.isTraceInProgress() == false) goto L90;
        ComposerKt.traceEventStart(143964305, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:377)");
    L90:
        float r26 = 1.0f;
        if (r110 == false) goto L93;
        float r111 = 1.0f;
    L95:
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventEnd();
    L97:
        r10.endReplaceGroup();
        Float r112 = Float.valueOf(r111);
        boolean r113 = ((Boolean) r1.getTargetState()).booleanValue();
        r10.startReplaceGroup(143964305);
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventStart(143964305, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:377)");
    L100:
        if (r113 == false) goto L102;
        float r20 = 1.0f;
    L104:
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventEnd();
    L106:
        r10.endReplaceGroup();
        final State r21 = TransitionKt.createTransitionAnimation(r1, r112, Float.valueOf(r20), (FiniteAnimationSpec) r12.invoke(r1.getSegment(), r10, 0), r19, "FloatAnimation", r10, 0);
        Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> r22 = new MenuKt$DropdownMenuContent$alpha$2(r11);
        TwoWayConverter<Float, AnimationVector1D> r114 = VectorConvertersKt.getVectorConverter(r15);
        boolean r23 = ((Boolean) r1.getCurrentState()).booleanValue();
        r10.startReplaceGroup(892761509);
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventStart(892761509, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:382)");
    L109:
        if (r23 == false) goto L111;
        float r24 = 1.0f;
    L113:
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventEnd();
    L115:
        r10.endReplaceGroup();
        Float r115 = Float.valueOf(r24);
        boolean r25 = ((Boolean) r1.getTargetState()).booleanValue();
        r10.startReplaceGroup(892761509);
        if (ComposerKt.isTraceInProgress() == false) goto L118;
        ComposerKt.traceEventStart(892761509, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:382)");
    L118:
        if (r25 == true) goto L122;
        r26 = ClosedAlphaTarget;
    L122:
        if (ComposerKt.isTraceInProgress() == false) goto L124;
        ComposerKt.traceEventEnd();
    L124:
        r10.endReplaceGroup();
        boolean r33 = false;
        final State r40 = TransitionKt.createTransitionAnimation(r1, r115, Float.valueOf(r26), (FiniteAnimationSpec) r22.invoke(r1.getSegment(), r10, 0), r114, "FloatAnimation", r10, 0);
        final boolean r41 = ((Boolean) r10.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue();
        Modifier.Companion r116 = Modifier.Companion;
        boolean r42 = r10.changed(r41) | r10.changed(r21);
        if ((r2 & 112) != 32) goto L127;
    L132:
        boolean r43 = true;
    L133:
        boolean r44 = (r42 | r43) | r10.changed(r40);
        if ((r2 & 896) != 256) goto L136;
        r33 = true;
    L136:
        boolean r45 = r33 | r44;
        Object r46 = r10.rememberedValue();
        if (r45 == false) goto L139;
    L142:
        Function1 r117 = new td(r41, r28, r29, r21, r40);
        r10.updateRememberedValue(r117);
        r46 = r117;
    L143:
        Modifier r118 = GraphicsLayerModifierKt.graphicsLayer(r116, (Function1) r46);
        ComposableLambda r210 = ComposableLambdaKt.rememberComposableLambda(-1463404422, true, new MenuKt$DropdownMenuContent$2(r27, r30, r37), r10, 54);
        int r47 = r2 >> 9;
        int r48 = (r47 & 112) | 12582912;
        int r49 = (r47 & 896) | r48;
        int r50 = r2 >> 6;
        SurfaceKt.m3213SurfaceT9BRK9s(r118, r31, r32, 0, r34, r35, r36, r210, r10, ((r49 | (57344 & r50)) | (458752 & r50)) | (r50 & 3670016), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L147;
        ComposerKt.traceEventEnd();
        goto L147
    L139:
        if (r46 != Composer.Companion.getEmpty()) goto L143;
    L127:
        if ((r2 & 64) != 0) goto L129;
    L131:
        r43 = false;
        goto L133
    L129:
        if (r10.changedInstance(r28) == false) goto L131;
    L111:
        r24 = ClosedAlphaTarget;
        goto L113
    L102:
        r20 = 0.8f;
        goto L104
    L93:
        r111 = 0.8f;
        goto L95
    L81:
        r0 = false;
        goto L83
    L5:
        if (r10.changed(r27) == false) goto L7;
        int r51 = 4;
    L8:
        r2 = r51 | r39;
        goto L11
    L7:
        r51 = 2;
        goto L8
    }
}
