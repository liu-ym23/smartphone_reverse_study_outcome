package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonKt$ExtendedFloatingActionButton$5 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ float $endPadding;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ float $iconPadding;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ float $minWidth;
    final /* synthetic */ float $startPadding;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    public FloatingActionButtonKt$ExtendedFloatingActionButton$5(boolean r1, float r2, float r3, float r4, float r5, Function2<? super Composer, ? super Integer, Unit> r6, float r7, Function2<? super Composer, ? super Integer, Unit> r8) {
        this.$expanded = r1;
        this.$minWidth = r2;
        this.$minHeight = r3;
        this.$startPadding = r4;
        this.$endPadding = r5;
        this.$icon = r6;
        this.$iconPadding = r7;
        this.$text = r8;
    }

    public static /* synthetic */ Unit a(Placeable r0, Placeable.PlacementScope r1) {
        return invoke$lambda$4$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ boolean b(Transition r0) {
        return invoke$lambda$12$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit c(State r0, GraphicsLayerScope r1) {
        return invoke$lambda$12$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ Unit d(SemanticsPropertyReceiver r0) {
        return invoke$lambda$12$lambda$8$lambda$7(r0);
    }

    public static /* synthetic */ MeasureResult e(float r0, State r1, MeasureScope r2, Measurable r3, Constraints r4) {
        return invoke$lambda$4$lambda$3(r0, r1, r2, r3, r4);
    }

    private static final boolean invoke$lambda$12$lambda$6$lambda$5(Transition r4) {
        if (((Number) r4.getCurrentState()).floatValue() != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        return false;
    L8:
        if (r4.isRunning() == true) goto L10;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private static final Unit invoke$lambda$12$lambda$8$lambda$7(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$12$lambda$10$lambda$9(State r0, GraphicsLayerScope r1) {
        r1.setAlpha(((Number) r0.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$4$lambda$3$lambda$2(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.place$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r30, int r31) {
        if ((r31 & 3) == 2) goto L5;
        boolean r2 = true;
    L7:
        if (r30.shouldExecute(r2, r31 & 1) == true) goto L9;
        r30.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventStart(-827388388, r31, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:464)");
    L12:
        if (this.$expanded == false) goto L14;
        float r1 = 1.0f;
    L15:
        final Transition r14 = TransitionKt.updateTransition(Float.valueOf(r1), "expanded state", r30, 48, 0);
        final FiniteAnimationSpec r3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r30, 6);
        final FiniteAnimationSpec r15 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r30, 6);
        Function3<Transition.Segment<Float>, Composer, Integer, FiniteAnimationSpec<Float>> r4 = new FloatingActionButtonKt$ExtendedFloatingActionButton$5$expandedWidthProgress$1(r3);
        FloatCompanionObject r16 = FloatCompanionObject.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> r5 = VectorConvertersKt.getVectorConverter(r16);
        float r6 = ((Number) r14.getCurrentState()).floatValue();
        r30.startReplaceGroup(-157343033);
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-157343033, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:469)");
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
    L21:
        r30.endReplaceGroup();
        Float r7 = Float.valueOf(r6);
        float r8 = ((Number) r14.getTargetState()).floatValue();
        r30.startReplaceGroup(-157343033);
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventStart(-157343033, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:469)");
    L25:
        if (ComposerKt.isTraceInProgress() == false) goto L27;
        ComposerKt.traceEventEnd();
    L27:
        r30.endReplaceGroup();
        final State r9 = TransitionKt.createTransitionAnimation(r14, r7, Float.valueOf(r8), (FiniteAnimationSpec) r4.invoke(r14.getSegment(), r30, 0), r5, "FloatAnimation", r30, 0);
        Function3<Transition.Segment<Float>, Composer, Integer, FiniteAnimationSpec<Float>> r10 = new FloatingActionButtonKt$ExtendedFloatingActionButton$5$expandedAlphaProgress$1(r15);
        TwoWayConverter<Float, AnimationVector1D> r11 = VectorConvertersKt.getVectorConverter(r16);
        float r12 = ((Number) r14.getCurrentState()).floatValue();
        r30.startReplaceGroup(175363167);
        if (ComposerKt.isTraceInProgress() == false) goto L31;
        ComposerKt.traceEventStart(175363167, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:471)");
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
    L33:
        r30.endReplaceGroup();
        Float r13 = Float.valueOf(r12);
        float r17 = ((Number) r14.getTargetState()).floatValue();
        r30.startReplaceGroup(175363167);
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventStart(175363167, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:471)");
    L37:
        if (ComposerKt.isTraceInProgress() == false) goto L39;
        ComposerKt.traceEventEnd();
    L39:
        r30.endReplaceGroup();
        final State r18 = TransitionKt.createTransitionAnimation(r14, r13, Float.valueOf(r17), (FiniteAnimationSpec) r10.invoke(r14.getSegment(), r30, 0), r11, "FloatAnimation", r30, 0);
        Modifier.Companion r19 = Modifier.Companion;
        boolean r20 = r30.changed(this.$minWidth) | r30.changed(r9);
        final float r21 = this.$minWidth;
        Object r22 = r30.rememberedValue();
        if (r20 == false) goto L42;
    L43:
        r22 = new rb(r21, r9);
        r30.updateRememberedValue(r22);
    L44:
        Modifier r23 = PaddingKt.m964paddingqDBjuR0$default(SizeKt.m1018sizeInqDBjuR0$default(LayoutModifierKt.layout(r19, (Function3) r22), this.$minWidth, this.$minHeight, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 12, null), this.$startPadding, MenuKt.ClosedAlphaTarget, this.$endPadding, MenuKt.ClosedAlphaTarget, 10, null);
        Alignment.Companion r24 = Alignment.Companion;
        Alignment.Vertical r25 = r24.getCenterVertically();
        Function2<Composer, Integer, Unit> r26 = this.$icon;
        float r27 = this.$iconPadding;
        Function2<Composer, Integer, Unit> r28 = this.$text;
        Arrangement r110 = Arrangement.INSTANCE;
        MeasurePolicy r29 = RowKt.rowMeasurePolicy(r110.getStart(), r25, r30, 48);
        int r111 = ComposablesKt.getCurrentCompositeKeyHash(r30, 0);
        CompositionLocalMap r112 = r30.getCurrentCompositionLocalMap();
        Modifier r32 = ComposedModifierKt.materializeModifier(r30, r23);
        ComposeUiNode.Companion r113 = ComposeUiNode.Companion;
        Function0 r114 = r113.getConstructor();
        if ((r30.getApplier() instanceof Applier) == true) goto L47;
        ComposablesKt.invalidApplier();
    L47:
        r30.startReusableNode();
        if (r30.getInserting() == false) goto L50;
        r30.createNode(r114);
    L51:
        Composer r0 = Updater.constructor-impl(r30);
        Updater.set-impl(r0, r29, r113.getSetMeasurePolicy());
        Updater.set-impl(r0, r112, r113.getSetResolvedCompositionLocals());
        Function2 r33 = r113.getSetCompositeKeyHash();
        if (r0.getInserting() == false) goto L54;
    L55:
        r0.updateRememberedValue(Integer.valueOf(r111));
        r0.apply(Integer.valueOf(r111), r33);
    L56:
        Updater.set-impl(r0, r32, r113.getSetModifier());
        RowScopeInstance r34 = RowScopeInstance.INSTANCE;
        r26.invoke(r30, 0);
        boolean r35 = r30.changed(r14);
        Object r36 = r30.rememberedValue();
        if (r35 == false) goto L59;
    L60:
        r36 = SnapshotStateKt.derivedStateOf(new sb(r14));
        r30.updateRememberedValue(r36);
    L62:
        if (((Boolean) ((State) r36).getValue()).booleanValue() == true) goto L84;
        r30.startReplaceGroup(65675329);
        Object r37 = r30.rememberedValue();
        Composer.Companion r38 = Composer.Companion;
        if (r37 != r38.getEmpty()) goto L66;
        r37 = new tb();
        r30.updateRememberedValue(r37);
    L66:
        Modifier r39 = SemanticsModifierKt.clearAndSetSemantics(r19, (Function1) r37);
        boolean r40 = r30.changed(r18);
        Object r41 = r30.rememberedValue();
        if (r40 == false) goto L69;
    L70:
        r41 = new ub(r18);
        r30.updateRememberedValue(r41);
    L71:
        Modifier r42 = GraphicsLayerModifierKt.graphicsLayer(r39, (Function1) r41);
        MeasurePolicy r43 = RowKt.rowMeasurePolicy(r110.getStart(), r24.getTop(), r30, 0);
        int r44 = ComposablesKt.getCurrentCompositeKeyHash(r30, 0);
        CompositionLocalMap r45 = r30.getCurrentCompositionLocalMap();
        Modifier r46 = ComposedModifierKt.materializeModifier(r30, r42);
        Function0 r47 = r113.getConstructor();
        if ((r30.getApplier() instanceof Applier) == true) goto L74;
        ComposablesKt.invalidApplier();
    L74:
        r30.startReusableNode();
        if (r30.getInserting() == false) goto L77;
        r30.createNode(r47);
    L78:
        Composer r48 = Updater.constructor-impl(r30);
        Updater.set-impl(r48, r43, r113.getSetMeasurePolicy());
        Updater.set-impl(r48, r45, r113.getSetResolvedCompositionLocals());
        Function2 r49 = r113.getSetCompositeKeyHash();
        if (r48.getInserting() == false) goto L81;
    L82:
        r48.updateRememberedValue(Integer.valueOf(r44));
        r48.apply(Integer.valueOf(r44), r49);
    L83:
        Updater.set-impl(r48, r46, r113.getSetModifier());
        SpacerKt.Spacer(SizeKt.m1019width3ABfNKs(r19, r27), r30, 0);
        r28.invoke(r30, 0);
        r30.endNode();
        r30.endReplaceGroup();
    L85:
        r30.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L90;
        ComposerKt.traceEventEnd();
        return;
    L90:
        return;
    L81:
        if (Intrinsics.areEqual(r48.rememberedValue(), Integer.valueOf(r44)) == true) goto L83;
    L77:
        r30.useNode();
        goto L78
    L69:
        if (r41 != r38.getEmpty()) goto L71;
    L84:
        r30.startReplaceGroup(65953058);
        r30.endReplaceGroup();
        goto L85
    L59:
        if (r36 != Composer.Companion.getEmpty()) goto L62;
    L54:
        if (Intrinsics.areEqual(r0.rememberedValue(), Integer.valueOf(r111)) == true) goto L56;
    L50:
        r30.useNode();
        goto L51
    L42:
        if (r22 != Composer.Companion.getEmpty()) goto L44;
    L14:
        r1 = MenuKt.ClosedAlphaTarget;
        goto L15
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    private static final MeasureResult invoke$lambda$4$lambda$3(float r8, State r9, MeasureScope r10, Measurable r11, Constraints r12) {
        int r0 = r11.maxIntrinsicWidth(Constraints.getMaxHeight-impl(r12.unbox-impl()));
        int r2 = MathHelpersKt.lerp(r10.roundToPx-0680j_4(r8), r0, ((Number) r9.getValue()).floatValue());
        final Placeable r13 = r11.measure-BRTryo0(r12.unbox-impl());
        return MeasureScope.-CC.layout$default(r10, r2, r13.getHeight(), null, new vb(r13), 4, null);
    }
}
