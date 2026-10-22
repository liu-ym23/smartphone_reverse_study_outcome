package androidx.compose.material;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001aY\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001ac\u0010\u0012\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u001b\u001a\u001d\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0002\u0010/\"\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u0016\u0010\u001f\u001a\u00020\u001dX\u0080\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010!\"\u0010\u0010\"\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u0016\u0010#\u001a\u00020\u001dX\u0080\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b$\u0010!\"\u0010\u0010%\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u0010\u0010&\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u0010\u0010'\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u000e\u0010(\u001a\u00020)X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020)X\u0080T¢\u0006\u0002\n\u0000¨\u00060²\u0006\n\u00101\u001a\u000202X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u000202X\u008a\u0084\u0002"}, d2 = {"DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "onClick", "Lkotlin/Function0;", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MenuElevation", "Landroidx/compose/ui/unit/Dp;", "F", "MenuVerticalMargin", "getMenuVerticalMargin", "()F", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemDefaultMaxWidth", "DropdownMenuItemDefaultMinHeight", "InTransitionDuration", "", "OutTransitionDuration", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material", "scale", "", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMaxWidth = 0.0f;
    private static final float DropdownMenuItemDefaultMinHeight = 0.0f;
    private static final float DropdownMenuItemDefaultMinWidth = 0.0f;
    private static final float DropdownMenuItemHorizontalPadding = 0.0f;
    private static final float DropdownMenuVerticalPadding = 0.0f;
    public static final int InTransitionDuration = 120;
    private static final float MenuElevation = 0.0f;
    private static final float MenuVerticalMargin = 0.0f;
    public static final int OutTransitionDuration = 75;

    private static final Unit DropdownMenuContent$lambda$6(MutableTransitionState r9, MutableState r10, ScrollState r11, Modifier r12, Function3 r13, int r14, int r15, Composer r16, int r17) {
        DropdownMenuContent(r9, r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit DropdownMenuItemContent$lambda$8(Function0 r10, Modifier r11, boolean r12, PaddingValues r13, MutableInteractionSource r14, Function3 r15, int r16, int r17, Composer r18, int r19) {
        DropdownMenuItemContent(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(MutableState r0, State r1, State r2, GraphicsLayerScope r3) {
        return DropdownMenuContent$lambda$5$lambda$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(MutableTransitionState r0, MutableState r1, ScrollState r2, Modifier r3, Function3 r4, int r5, int r6, Composer r7, int r8) {
        return DropdownMenuContent$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit c(Function0 r0, Modifier r1, boolean r2, PaddingValues r3, MutableInteractionSource r4, Function3 r5, int r6, int r7, Composer r8, int r9) {
        return DropdownMenuItemContent$lambda$8(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    static {
        float r0 = 8;
        MenuElevation = Dp.constructor-impl(r0);
        float r1 = 48;
        MenuVerticalMargin = Dp.constructor-impl(r1);
        DropdownMenuItemHorizontalPadding = Dp.constructor-impl(16);
        DropdownMenuVerticalPadding = Dp.constructor-impl(r0);
        DropdownMenuItemDefaultMinWidth = Dp.constructor-impl(112);
        DropdownMenuItemDefaultMaxWidth = Dp.constructor-impl(280);
        DropdownMenuItemDefaultMinHeight = Dp.constructor-impl(r1);
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

    private static final float DropdownMenuContent$lambda$1(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final float DropdownMenuContent$lambda$3(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    public static final long calculateTransformOrigin(IntRect r5, IntRect r6) {
        float r2 = 1.0f;
        if (r6.getLeft() < r5.getRight()) goto L6;
    L4:
        float r0 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L13:
        if (r6.getTop() < r5.getBottom()) goto L16;
    L14:
        r2 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
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

    private static final Unit DropdownMenuContent$lambda$5$lambda$4(MutableState r1, State r2, State r3, GraphicsLayerScope r4) {
        r4.setScaleX(DropdownMenuContent$lambda$1(r2));
        r4.setScaleY(DropdownMenuContent$lambda$1(r2));
        r4.setAlpha(DropdownMenuContent$lambda$3(r3));
        r4.setTransformOrigin-__ExYCQ(((TransformOrigin) r1.getValue()).unbox-impl());
        return Unit.INSTANCE;
    }

    public static final void DropdownMenuContent(final MutableTransitionState<Boolean> r24, final MutableState<TransformOrigin> r25, final ScrollState r26, Modifier r27, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r28, Composer r29, final int r30, final int r31) {
        Composer r4 = r29.startRestartGroup(1077393800);
        if ((r31 & 1) == 0) goto L6;
        int r7 = r30 | 6;
    L17:
        if ((r31 & 2) == 0) goto L20;
        r7 = r7 | 48;
    L27:
        if ((r31 & 4) == 0) goto L30;
        r7 = r7 | 384;
    L36:
        int r8 = r31 & 8;
        if (r8 == 0) goto L40;
        r7 = r7 | 3072;
    L46:
        Modifier r9 = r27;
    L48:
        if ((r31 & 16) == 0) goto L51;
        r7 = r7 | 24576;
    L57:
        int r14 = r7;
        if ((r14 & 9363) == 9362) goto L60;
        boolean r10 = true;
    L62:
        if (r4.shouldExecute(r10, r14 & 1) == false) goto L119;
        if (r8 == 0) goto L65;
        Modifier r11 = Modifier.Companion;
    L67:
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventStart(1077393800, r14, -1, "androidx.compose.material.DropdownMenuContent (Menu.kt:154)");
    L69:
        Transition r0 = TransitionKt.rememberTransition(r24, "DropDownMenu", r4, (MutableTransitionState.$stable | 48) | (r14 & 14), 0);
        MenuKt$DropdownMenuContent$scale$2 r12 = MenuKt$DropdownMenuContent$scale$2.INSTANCE;
        FloatCompanionObject r17 = FloatCompanionObject.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> r18 = VectorConvertersKt.getVectorConverter(r17);
        boolean r13 = ((Boolean) r0.getCurrentState()).booleanValue();
        r4.startReplaceGroup(-1833869404);
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventStart(-1833869404, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:170)");
    L72:
        float r19 = 0.8f;
        float r20 = 1.0f;
        if (r13 == false) goto L75;
        float r15 = 1.0f;
    L77:
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
    L79:
        r4.endReplaceGroup();
        Float r16 = Float.valueOf(r15);
        boolean r21 = ((Boolean) r0.getTargetState()).booleanValue();
        r4.startReplaceGroup(-1833869404);
        if (ComposerKt.isTraceInProgress() == false) goto L82;
        ComposerKt.traceEventStart(-1833869404, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:170)");
    L82:
        if (r21 == false) goto L85;
        r19 = 1.0f;
    L85:
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventEnd();
    L87:
        r4.endReplaceGroup();
        final Modifier r23 = r11;
        final State r110 = TransitionKt.createTransitionAnimation(r0, r16, Float.valueOf(r19), (FiniteAnimationSpec) r12.invoke(r0.getSegment(), r4, 0), r18, "FloatAnimation", r4, 0);
        MenuKt$DropdownMenuContent$alpha$2 r22 = MenuKt$DropdownMenuContent$alpha$2.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> r111 = VectorConvertersKt.getVectorConverter(r17);
        boolean r32 = ((Boolean) r0.getCurrentState()).booleanValue();
        r4.startReplaceGroup(-1578341192);
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventStart(-1578341192, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:191)");
    L91:
        if (r32 == false) goto L93;
        float r33 = 1.0f;
    L95:
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventEnd();
    L97:
        r4.endReplaceGroup();
        Float r34 = Float.valueOf(r33);
        boolean r112 = ((Boolean) r0.getTargetState()).booleanValue();
        r4.startReplaceGroup(-1578341192);
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventStart(-1578341192, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:191)");
    L100:
        if (r112 == true) goto L104;
        r20 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L104:
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventEnd();
    L106:
        r4.endReplaceGroup();
        final State r35 = TransitionKt.createTransitionAnimation(r0, r34, Float.valueOf(r20), (FiniteAnimationSpec) r22.invoke(r0.getSegment(), r4, 0), r111, "FloatAnimation", r4, 0);
        Modifier.Companion r36 = Modifier.Companion;
        boolean r37 = r4.changed(r110) | r4.changed(r35);
        if ((r14 & 112) != 32) goto L109;
        boolean r113 = true;
    L110:
        boolean r1 = r37 | r113;
        Object r38 = r4.rememberedValue();
        if (r1 == false) goto L113;
    L114:
        r38 = new a6(r25, r110, r35);
        r4.updateRememberedValue(r38);
    L115:
        CardKt.m1977CardFjzlyU(GraphicsLayerModifierKt.graphicsLayer(r36, (Function1) r38), null, 0, 0, null, MenuElevation, ComposableLambdaKt.rememberComposableLambda(-707086267, true, new AnonymousClass2(r23, r26, r28), r4, 54), r4, 1769472, 30);
        if (ComposerKt.isTraceInProgress() == false) goto L118;
        ComposerKt.traceEventEnd();
    L118:
        r9 = r23;
    L120:
        ScopeUpdateScope r39 = r4.endRestartGroup();
        if (r39 == null) goto L124;
        final Modifier r5 = r9;
        r39.updateScope(new b6(r24, r25, r26, r5, r28, r30, r31));
        return;
    L124:
        return;
    L113:
        if (r38 != Composer.Companion.getEmpty()) goto L115;
    L109:
        r113 = false;
        goto L110
    L93:
        r33 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L95
    L75:
        r15 = 0.8f;
        goto L77
    L65:
        r11 = r9;
        goto L67
    L119:
        r4.skipToGroupEnd();
        goto L120
    L60:
        r10 = false;
        goto L62
    L51:
        if ((r30 & 24576) != 0) goto L57;
        if (r4.changedInstance(r28) == false) goto L55;
        int r114 = 16384;
    L56:
        r7 = r7 | r114;
        goto L57
    L55:
        r114 = 8192;
        goto L56
    L40:
        if ((r30 & 3072) != 0) goto L46;
        r9 = r27;
        if (r4.changed(r9) == false) goto L44;
        int r115 = 2048;
    L45:
        r7 = r7 | r115;
        goto L48
    L44:
        r115 = 1024;
        goto L45
    L30:
        if ((r30 & 384) != 0) goto L36;
        if (r4.changed(r26) == false) goto L34;
        int r40 = 256;
    L35:
        r7 = r7 | r40;
        goto L36
    L34:
        r40 = 128;
        goto L35
    L20:
        if ((r30 & 48) != 0) goto L27;
        if (r4.changed(r25) == false) goto L24;
        int r41 = 32;
    L25:
        r7 = r7 | r41;
        goto L27
    L24:
        r41 = 16;
        goto L25
    L6:
        if ((r30 & 6) == 0) goto L8;
        r7 = r30;
        goto L17
    L8:
        if ((r30 & 8) != 0) goto L10;
        boolean r42 = r4.changed(r24);
    L11:
        if (r42 == false) goto L13;
        int r43 = 4;
    L14:
        r7 = r43 | r30;
        goto L17
    L13:
        r43 = 2;
        goto L14
    L10:
        r42 = r4.changedInstance(r24);
        goto L11
    }

    public static final void DropdownMenuItemContent(final Function0<Unit> r25, Modifier r26, boolean r27, PaddingValues r28, MutableInteractionSource r29, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32, final int r33) {
        Composer r1 = r31.startRestartGroup(-674391690);
        if ((r33 & 1) == 0) goto L6;
        int r3 = r32 | 6;
    L13:
        int r4 = r33 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r26;
    L24:
        int r8 = r33 & 4;
        if (r8 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r9 = r27;
    L35:
        int r10 = r33 & 8;
        if (r10 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        PaddingValues r11 = r28;
    L46:
        int r12 = r33 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L58:
        if ((r33 & 32) == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        if ((74899 & r3) == 74898) goto L70;
        boolean r14 = true;
    L72:
        if (r1.shouldExecute(r14, r3 & 1) == false) goto L105;
        if (r4 == 0) goto L75;
        Modifier r6 = Modifier.Companion;
    L76:
        if (r8 == 0) goto L78;
        final boolean r7 = true;
    L79:
        if (r10 == 0) goto L81;
        PaddingValues r15 = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
    L83:
        if (r12 == 0) goto L85;
        MutableInteractionSource r17 = null;
    L87:
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventStart(-674391690, r3, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:228)");
    L89:
        PaddingValues r13 = r15;
        Modifier r0 = PaddingKt.padding(SizeKt.m1018sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m375clickableO2vRcR0$default(r6, r17, RippleKt.m2139rippleH2RKhps$default(true, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0, 6, null), r7, null, null, r25, 24, null), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 8, null), r13);
        MeasurePolicy r16 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getCenterVertically(), r1, 48);
        int r18 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r19 = r1.getCurrentCompositionLocalMap();
        Modifier r2 = ComposedModifierKt.materializeModifier(r1, r0);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r111 = r110.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L92;
        ComposablesKt.invalidApplier();
    L92:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L95;
        r1.createNode(r111);
    L96:
        Composer r112 = Updater.constructor-impl(r1);
        Updater.set-impl(r112, r16, r110.getSetMeasurePolicy());
        Updater.set-impl(r112, r19, r110.getSetResolvedCompositionLocals());
        Function2 r20 = r110.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L99;
    L100:
        r112.updateRememberedValue(Integer.valueOf(r18));
        r112.apply(Integer.valueOf(r18), r20);
    L101:
        Updater.set-impl(r112, r2, r110.getSetModifier());
        final RowScopeInstance r21 = RowScopeInstance.INSTANCE;
        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(r1, 6).getSubtitle1(), ComposableLambdaKt.rememberComposableLambda(-77738101, true, new MenuKt$DropdownMenuItemContent$1$1(r7, r30, r21), r1, 54), r1, 48);
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L104;
        ComposerKt.traceEventEnd();
    L104:
        final boolean r22 = r7;
        final MutableInteractionSource r23 = r17;
    L106:
        ScopeUpdateScope r24 = r1.endRestartGroup();
        if (r24 == null) goto L110;
        final Modifier r34 = r6;
        final PaddingValues r35 = r13;
        r24.updateScope(new z5(r25, r34, r22, r35, r23, r30, r32, r33));
        return;
    L110:
        return;
    L99:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r18)) == true) goto L101;
    L95:
        r1.useNode();
        goto L96
    L85:
        r17 = r29;
        goto L87
    L81:
        r15 = r11;
        goto L83
    L78:
        r7 = r9;
        goto L79
    L75:
        r6 = r5;
        goto L76
    L105:
        r1.skipToGroupEnd();
        r6 = r5;
        r22 = r9;
        r13 = r11;
        r23 = r29;
        goto L106
    L70:
        r14 = false;
        goto L72
    L61:
        if ((r32 & 196608) != 0) goto L68;
        if (r1.changedInstance(r30) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
        goto L68
    L65:
        r113 = 65536;
        goto L66
    L50:
        if ((r32 & 24576) != 0) goto L58;
        if (r1.changed(r29) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
        goto L58
    L54:
        r114 = 8192;
        goto L55
    L39:
        if ((r32 & 3072) != 0) goto L45;
        r11 = r28;
        if (r1.changed(r11) == false) goto L43;
        int r115 = 2048;
    L44:
        r3 = r3 | r115;
        goto L46
    L43:
        r115 = 1024;
        goto L44
    L28:
        if ((r32 & 384) != 0) goto L34;
        r9 = r27;
        if (r1.changed(r9) == false) goto L32;
        int r116 = 256;
    L33:
        r3 = r3 | r116;
        goto L35
    L32:
        r116 = 128;
        goto L33
    L17:
        if ((r32 & 48) != 0) goto L23;
        r5 = r26;
        if (r1.changed(r5) == false) goto L21;
        int r36 = 32;
    L22:
        r3 = r3 | r36;
        goto L24
    L21:
        r36 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r3 = r32;
        goto L13
    L8:
        if (r1.changedInstance(r25) == false) goto L10;
        int r37 = 4;
    L11:
        r3 = r37 | r32;
        goto L13
    L10:
        r37 = 2;
        goto L11
    }
}
