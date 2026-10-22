package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u009b\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001c\u001a\u0091\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001d\u001a\u008b\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001e\u001aA\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0016¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b$\u0010%\u001aA\u0010&\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0016¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b'\u0010%\u001a;\u0010(\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010)\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001a\"\u0010/\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002\"\u000e\u00101\u001a\u000202X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00103\u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u00104¨\u00065"}, d2 = {"SegmentedButton", "", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "shape", "Landroidx/compose/ui/graphics/Shape;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "label", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "SingleChoiceSegmentedButtonRow", "space", "Landroidx/compose/ui/unit/Dp;", "content", "Lkotlin/ExtensionFunctionType;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MultiChoiceSegmentedButtonRow", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButtonContent", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "CheckedZIndexFactor", "", "IconSpacing", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5.0f;
    private static final float IconSpacing = 0.0f;

    private static final Unit MultiChoiceSegmentedButtonRow_uFdPcIQ$lambda$13(Modifier r6, float r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        m3098MultiChoiceSegmentedButtonRowuFdPcIQ(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    private static final Unit SegmentedButton$lambda$1(MultiChoiceSegmentedButtonRowScope r17, boolean r18, Function1 r19, Shape r20, Modifier r21, boolean r22, SegmentedButtonColors r23, BorderStroke r24, PaddingValues r25, MutableInteractionSource r26, Function2 r27, Function2 r28, int r29, int r30, int r31, Composer r32, int r33) {
        SegmentedButton(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    private static final Unit SegmentedButton$lambda$5(SingleChoiceSegmentedButtonRowScope r17, boolean r18, Function0 r19, Shape r20, Modifier r21, boolean r22, SegmentedButtonColors r23, BorderStroke r24, PaddingValues r25, MutableInteractionSource r26, Function2 r27, Function2 r28, int r29, int r30, int r31, Composer r32, int r33) {
        SegmentedButton(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    private static final Unit SegmentedButton$lambda$6(MultiChoiceSegmentedButtonRowScope r16, boolean r17, Function1 r18, Shape r19, Modifier r20, boolean r21, SegmentedButtonColors r22, BorderStroke r23, MutableInteractionSource r24, Function2 r25, Function2 r26, int r27, int r28, int r29, Composer r30, int r31) {
        SegmentedButton(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit SegmentedButton$lambda$7(SingleChoiceSegmentedButtonRowScope r16, boolean r17, Function0 r18, Shape r19, Modifier r20, boolean r21, SegmentedButtonColors r22, BorderStroke r23, MutableInteractionSource r24, Function2 r25, Function2 r26, int r27, int r28, int r29, Composer r30, int r31) {
        SegmentedButton(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit SegmentedButtonContent$lambda$15(Function2 r0, Function2 r1, PaddingValues r2, int r3, Composer r4, int r5) {
        SegmentedButtonContent(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SingleChoiceSegmentedButtonRow_uFdPcIQ$lambda$10(Modifier r6, float r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        m3099SingleChoiceSegmentedButtonRowuFdPcIQ(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(SingleChoiceSegmentedButtonRowScope r0, boolean r1, Function0 r2, Shape r3, Modifier r4, boolean r5, SegmentedButtonColors r6, BorderStroke r7, MutableInteractionSource r8, Function2 r9, Function2 r10, int r11, int r12, int r13, Composer r14, int r15) {
        return SegmentedButton$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ MeasureResult b(State r0, boolean r1, MeasureScope r2, Measurable r3, Constraints r4) {
        return interactionZIndex$lambda$19(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit c(SingleChoiceSegmentedButtonRowScope r1, boolean r2, Function0 r3, Shape r4, Modifier r5, boolean r6, SegmentedButtonColors r7, BorderStroke r8, PaddingValues r9, MutableInteractionSource r10, Function2 r11, Function2 r12, int r13, int r14, int r15, Composer r16, int r17) {
        return SegmentedButton$lambda$5(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit d(Modifier r0, float r1, Function3 r2, int r3, int r4, Composer r5, int r6) {
        return MultiChoiceSegmentedButtonRow_uFdPcIQ$lambda$13(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit e(SemanticsPropertyReceiver r0) {
        return SegmentedButton$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ Unit f(Function2 r0, Function2 r1, PaddingValues r2, int r3, Composer r4, int r5) {
        return SegmentedButtonContent$lambda$15(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit g(MultiChoiceSegmentedButtonRowScope r1, boolean r2, Function1 r3, Shape r4, Modifier r5, boolean r6, SegmentedButtonColors r7, BorderStroke r8, PaddingValues r9, MutableInteractionSource r10, Function2 r11, Function2 r12, int r13, int r14, int r15, Composer r16, int r17) {
        return SegmentedButton$lambda$1(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit h(Modifier r0, float r1, Function3 r2, int r3, int r4, Composer r5, int r6) {
        return SingleChoiceSegmentedButtonRow_uFdPcIQ$lambda$10(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit i(MultiChoiceSegmentedButtonRowScope r0, boolean r1, Function1 r2, Shape r3, Modifier r4, boolean r5, SegmentedButtonColors r6, BorderStroke r7, MutableInteractionSource r8, Function2 r9, Function2 r10, int r11, int r12, int r13, Composer r14, int r15) {
        return SegmentedButton$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit j(State r0, boolean r1, Placeable r2, Placeable.PlacementScope r3) {
        return interactionZIndex$lambda$19$lambda$18(r0, r1, r2, r3);
    }

    static {
        IconSpacing = Dp.constructor-impl(8);
    }

    public static final /* synthetic */ float access$getIconSpacing$p() {
        return IconSpacing;
    }

    private static final Unit SegmentedButton$lambda$4$lambda$3(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getRadioButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    private static final State<Integer> interactionCountAsState(InteractionSource r6, Composer r7, int r8) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(281890131, r8, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:459)");
    L5:
        Object r0 = r7.rememberedValue();
        Composer.Companion r1 = Composer.Companion;
        boolean r3 = false;
        if (r0 != r1.getEmpty()) goto L8;
        r0 = SnapshotIntStateKt.mutableIntStateOf(0);
        r7.updateRememberedValue(r0);
    L8:
        MutableIntState r2 = (MutableIntState) r0;
        int r4 = r8 & 14;
        if ((r4 ^ 6) <= 4) goto L13;
        if (r7.changed(r6) == false) goto L13;
    L14:
        r3 = true;
    L15:
        Object r9 = r7.rememberedValue();
        if (r3 == false) goto L18;
    L19:
        r9 = new SegmentedButtonKt$interactionCountAsState$1$1(r6, r2, null);
        r7.updateRememberedValue(r9);
    L20:
        EffectsKt.LaunchedEffect(r6, (Function2) r9, r7, r4);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
    L23:
        return r2;
    L18:
        if (r9 != r1.getEmpty()) goto L20;
    L13:
        if ((r8 & 6) != 4) goto L15;
        goto L14
    }

    private static final Modifier interactionZIndex(Modifier r1, final boolean r2, final State<Integer> r3) {
        return LayoutModifierKt.layout(r1, new sn(r3, r2));
    }

    private static final Unit interactionZIndex$lambda$19$lambda$18(State r0, boolean r1, Placeable r2, Placeable.PlacementScope r3) {
        float r4 = ((Number) r0.getValue()).floatValue();
        if (r1 == false) goto L5;
        float r5 = CheckedZIndexFactor;
    L6:
        r3.place(r2, 0, 0, r4 + r5);
        return Unit.INSTANCE;
    L5:
        r5 = MenuKt.ClosedAlphaTarget;
        goto L6
    }

    private static final void SegmentedButtonContent(final Function2<? super Composer, ? super Integer, Unit> r8, final Function2<? super Composer, ? super Integer, Unit> r9, final PaddingValues r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(-1069265073);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 48) != 0) goto L18;
        if (r13.changedInstance(r9) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r12 & 384) != 0) goto L25;
        if (r13.changed(r10) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r13.shouldExecute(r4, r1 & 1) == true) goto L31;
        r13.skipToGroupEnd();
    L49:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L53;
        r14.updateScope(new mn(r8, r9, r10, r12));
        return;
    L53:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-1069265073, r1, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:386)");
    L33:
        Alignment r0 = Alignment.Companion.getCenter();
        Modifier r5 = PaddingKt.padding(Modifier.Companion, r10);
        MeasurePolicy r6 = BoxKt.maybeCachedBoxMeasurePolicy(r0, false);
        int r7 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r15 = r13.getCurrentCompositionLocalMap();
        Modifier r16 = ComposedModifierKt.materializeModifier(r13, r5);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r18 = r17.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L36;
        ComposablesKt.invalidApplier();
    L36:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L39;
        r13.createNode(r18);
    L40:
        Composer r19 = Updater.constructor-impl(r13);
        Updater.set-impl(r19, r6, r17.getSetMeasurePolicy());
        Updater.set-impl(r19, r15, r17.getSetResolvedCompositionLocals());
        Function2 r20 = r17.getSetCompositeKeyHash();
        if (r19.getInserting() == false) goto L43;
    L44:
        r19.updateRememberedValue(Integer.valueOf(r7));
        r19.apply(Integer.valueOf(r7), r20);
    L45:
        Updater.set-impl(r19, r16, r17.getSetModifier());
        BoxScopeInstance r21 = BoxScopeInstance.INSTANCE;
        TextStyle r22 = TypographyKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont(), r13, 6);
        final FiniteAnimationSpec r23 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r13, 6);
        TextKt.ProvideTextStyle(r22, ComposableLambdaKt.rememberComposableLambda(-1372614088, true, new SegmentedButtonKt$SegmentedButtonContent$1$1(r8, r9, r23), r13, 54), r13, 48);
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
        goto L49
    L43:
        if (Intrinsics.areEqual(r19.rememberedValue(), Integer.valueOf(r7)) == true) goto L45;
    L39:
        r13.useNode();
        goto L40
    L27:
        r4 = false;
        goto L29
    L5:
        if (r13.changedInstance(r8) == false) goto L7;
        int r24 = 4;
    L8:
        r1 = r24 | r12;
        goto L11
    L7:
        r24 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$SegmentedButtonContent(Function2 r0, Function2 r1, PaddingValues r2, Composer r3, int r4) {
        SegmentedButtonContent(r0, r1, r2, r3, r4);
    }

    private static final MeasureResult interactionZIndex$lambda$19(final State r7, final boolean r8, MeasureScope r9, Measurable r10, Constraints r11) {
        final Placeable r12 = r10.measure-BRTryo0(r11.unbox-impl());
        return MeasureScope.-CC.layout$default(r9, r12.getWidth(), r12.getHeight(), null, new ln(r7, r8, r12), 4, null);
    }

    /* JADX INFO: renamed from: MultiChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m3098MultiChoiceSegmentedButtonRowuFdPcIQ(Modifier r8, float r9, final Function3<? super MultiChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12, final int r13) {
        Composer r14 = r11.startRestartGroup(1844783038);
        int r1 = r13 & 1;
        if (r1 == 0) goto L6;
        int r2 = r12 | 6;
    L13:
        int r3 = r13 & 2;
        if (r3 == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r13 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L34:
        if ((r2 & 147) == 146) goto L36;
        boolean r4 = true;
    L38:
        if (r14.shouldExecute(r4, r2 & 1) == false) goto L64;
        if (r1 == 0) goto L41;
        r8 = Modifier.Companion;
    L41:
        if (r3 == 0) goto L44;
        r9 = SegmentedButtonDefaults.INSTANCE.m3096getBorderWidthD9Ej5fM();
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(1844783038, r2, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:367)");
    L46:
        Modifier r0 = IntrinsicKt.width(SizeKt.m999defaultMinSizeVpY3zN4$default(r8, MenuKt.ClosedAlphaTarget, OutlinedSegmentedButtonTokens.INSTANCE.getContainerHeight-D9Ej5fM(), 1, null), IntrinsicSize.Min);
        MeasurePolicy r5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m806spacedBy0680j_4(Dp.constructor-impl(-r9)), Alignment.Companion.getCenterVertically(), r14, 48);
        int r6 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r7 = r14.getCurrentCompositionLocalMap();
        Modifier r15 = ComposedModifierKt.materializeModifier(r14, r0);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r17 = r16.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L49;
        ComposablesKt.invalidApplier();
    L49:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L52;
        r14.createNode(r17);
    L53:
        Composer r18 = Updater.constructor-impl(r14);
        Updater.set-impl(r18, r5, r16.getSetMeasurePolicy());
        Updater.set-impl(r18, r7, r16.getSetResolvedCompositionLocals());
        Function2 r19 = r16.getSetCompositeKeyHash();
        if (r18.getInserting() == false) goto L56;
    L57:
        r18.updateRememberedValue(Integer.valueOf(r6));
        r18.apply(Integer.valueOf(r6), r19);
    L58:
        Updater.set-impl(r18, r15, r16.getSetModifier());
        RowScopeInstance r20 = RowScopeInstance.INSTANCE;
        Object r21 = r14.rememberedValue();
        if (r21 != Composer.Companion.getEmpty()) goto L61;
        r21 = new MultiChoiceSegmentedButtonScopeWrapper(r20);
        r14.updateRememberedValue(r21);
    L61:
        r10.invoke((MultiChoiceSegmentedButtonScopeWrapper) r21, r14, Integer.valueOf(((r2 >> 3) & 112) | 6));
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L65;
        ComposerKt.traceEventEnd();
    L65:
        final Modifier r22 = r8;
        final float r23 = r9;
        ScopeUpdateScope r24 = r14.endRestartGroup();
        if (r24 == null) goto L69;
        r24.updateScope(new on(r22, r23, r10, r12, r13));
        return;
    L69:
        return;
    L56:
        if (Intrinsics.areEqual(r18.rememberedValue(), Integer.valueOf(r6)) == true) goto L58;
    L52:
        r14.useNode();
        goto L53
    L64:
        r14.skipToGroupEnd();
        goto L65
    L36:
        r4 = false;
        goto L38
    L27:
        if ((r12 & 384) != 0) goto L34;
        if (r14.changedInstance(r10) == false) goto L31;
        int r25 = 256;
    L32:
        r2 = r2 | r25;
        goto L34
    L31:
        r25 = 128;
        goto L32
    L17:
        if ((r12 & 48) != 0) goto L24;
        if (r14.changed(r9) == false) goto L21;
        int r26 = 32;
    L22:
        r2 = r2 | r26;
        goto L24
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r12 & 6) == 0) goto L8;
        r2 = r12;
        goto L13
    L8:
        if (r14.changed(r8) == false) goto L10;
        int r27 = 4;
    L11:
        r2 = r27 | r12;
        goto L13
    L10:
        r27 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    public static final void m3099SingleChoiceSegmentedButtonRowuFdPcIQ(Modifier r8, float r9, final Function3<? super SingleChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12, final int r13) {
        Composer r14 = r11.startRestartGroup(2041406825);
        int r1 = r13 & 1;
        if (r1 == 0) goto L6;
        int r2 = r12 | 6;
    L13:
        int r3 = r13 & 2;
        if (r3 == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r13 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L34:
        if ((r2 & 147) == 146) goto L36;
        boolean r4 = true;
    L38:
        if (r14.shouldExecute(r4, r2 & 1) == false) goto L64;
        if (r1 == 0) goto L41;
        r8 = Modifier.Companion;
    L41:
        if (r3 == 0) goto L44;
        r9 = SegmentedButtonDefaults.INSTANCE.m3096getBorderWidthD9Ej5fM();
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(2041406825, r2, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:331)");
    L46:
        Modifier r0 = IntrinsicKt.width(SizeKt.m999defaultMinSizeVpY3zN4$default(SelectableGroupKt.selectableGroup(r8), MenuKt.ClosedAlphaTarget, OutlinedSegmentedButtonTokens.INSTANCE.getContainerHeight-D9Ej5fM(), 1, null), IntrinsicSize.Min);
        MeasurePolicy r5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m806spacedBy0680j_4(Dp.constructor-impl(-r9)), Alignment.Companion.getCenterVertically(), r14, 48);
        int r6 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r7 = r14.getCurrentCompositionLocalMap();
        Modifier r15 = ComposedModifierKt.materializeModifier(r14, r0);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r17 = r16.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L49;
        ComposablesKt.invalidApplier();
    L49:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L52;
        r14.createNode(r17);
    L53:
        Composer r18 = Updater.constructor-impl(r14);
        Updater.set-impl(r18, r5, r16.getSetMeasurePolicy());
        Updater.set-impl(r18, r7, r16.getSetResolvedCompositionLocals());
        Function2 r19 = r16.getSetCompositeKeyHash();
        if (r18.getInserting() == false) goto L56;
    L57:
        r18.updateRememberedValue(Integer.valueOf(r6));
        r18.apply(Integer.valueOf(r6), r19);
    L58:
        Updater.set-impl(r18, r15, r16.getSetModifier());
        RowScopeInstance r20 = RowScopeInstance.INSTANCE;
        Object r21 = r14.rememberedValue();
        if (r21 != Composer.Companion.getEmpty()) goto L61;
        r21 = new SingleChoiceSegmentedButtonScopeWrapper(r20);
        r14.updateRememberedValue(r21);
    L61:
        r10.invoke((SingleChoiceSegmentedButtonScopeWrapper) r21, r14, Integer.valueOf(((r2 >> 3) & 112) | 6));
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L65;
        ComposerKt.traceEventEnd();
    L65:
        final Modifier r22 = r8;
        final float r23 = r9;
        ScopeUpdateScope r24 = r14.endRestartGroup();
        if (r24 == null) goto L69;
        r24.updateScope(new pn(r22, r23, r10, r12, r13));
        return;
    L69:
        return;
    L56:
        if (Intrinsics.areEqual(r18.rememberedValue(), Integer.valueOf(r6)) == true) goto L58;
    L52:
        r14.useNode();
        goto L53
    L64:
        r14.skipToGroupEnd();
        goto L65
    L36:
        r4 = false;
        goto L38
    L27:
        if ((r12 & 384) != 0) goto L34;
        if (r14.changedInstance(r10) == false) goto L31;
        int r25 = 256;
    L32:
        r2 = r2 | r25;
        goto L34
    L31:
        r25 = 128;
        goto L32
    L17:
        if ((r12 & 48) != 0) goto L24;
        if (r14.changed(r9) == false) goto L21;
        int r26 = 32;
    L22:
        r2 = r2 | r26;
        goto L24
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r12 & 6) == 0) goto L8;
        r2 = r12;
        goto L13
    L8:
        if (r14.changed(r8) == false) goto L10;
        int r27 = 4;
    L11:
        r2 = r27 | r12;
        goto L13
    L10:
        r27 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "kept for binary compatibility")
    public static final /* synthetic */ void SegmentedButton(final MultiChoiceSegmentedButtonRowScope r27, final boolean r28, final Function1 r29, final Shape r30, Modifier r31, boolean r32, SegmentedButtonColors r33, BorderStroke r34, MutableInteractionSource r35, Function2 r36, final Function2 r37, Composer r38, final int r39, final int r40, final int r41) {
        Composer r12 = r38.startRestartGroup(2065856961);
        if ((Integer.MIN_VALUE & r41) == 0) goto L6;
        int r1 = r39 | 6;
    L14:
        if ((r41 & 1) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r41 & 2) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r41 & 4) == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        int r4 = r41 & 8;
        if (r4 == 0) goto L47;
        r1 = r1 | 24576;
    L54:
        int r6 = r41 & 16;
        if (r6 == 0) goto L58;
        r1 = r1 | 196608;
    L66:
        if ((1572864 & r39) != 0) goto L77;
        if ((r41 & 32) != 0) goto L73;
        if (r12.changed(r33) == false) goto L73;
        int r16 = 1048576;
    L74:
        r1 = r1 | r16;
    L73:
        r16 = 524288;
    L77:
        if ((r39 & 12582912) != 0) goto L86;
        if ((r41 & 64) == 0) goto L81;
    L83:
        int r17 = 4194304;
    L84:
        r1 = r1 | r17;
        goto L86
    L81:
        if (r12.changed(r34) == false) goto L83;
        r17 = 8388608;
    L86:
        int r0 = r41 & 128;
        if (r0 == 0) goto L90;
        r1 = r1 | 100663296;
    L96:
        int r2 = r41 & 256;
        if (r2 == 0) goto L100;
        r1 = r1 | 805306368;
    L107:
        if ((r41 & 512) == 0) goto L110;
        int r3 = r40 | 6;
    L118:
        if ((r1 & 306783379) == 306783378) goto L120;
    L123:
        boolean r5 = true;
    L125:
        if (r12.shouldExecute(r5, r1 & 1) == false) goto L166;
        r12.startDefaults();
        if ((r39 & 1) != 0) goto L129;
    L138:
        if (r4 == 0) goto L140;
        Modifier r7 = Modifier.Companion;
    L141:
        if (r6 == 0) goto L143;
        boolean r8 = true;
    L145:
        if ((r41 & 32) == 0) goto L147;
        SegmentedButtonColors r9 = SegmentedButtonDefaults.INSTANCE.colors(r12, 6);
        r1 = r1 & (-3670017);
    L149:
        if ((r41 & 64) == 0) goto L151;
        BorderStroke r10 = SegmentedButtonDefaults.m3093borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, r9.m3076borderColorWaAFU9c$material3(r8, r28), MenuKt.ClosedAlphaTarget, 2, null);
        r1 = r1 & (-29360129);
    L152:
        if (r0 == 0) goto L154;
        MutableInteractionSource r11 = null;
    L155:
        if (r2 == 0) goto L157;
        MutableInteractionSource r310 = r11;
        MutableInteractionSource r22 = r310;
        r1 = r1;
        Function2 r23 = ComposableLambdaKt.rememberComposableLambda(-1867102712, true, new AnonymousClass8(r28), r12, 54);
    L158:
        Modifier r18 = r7;
        boolean r19 = r8;
        SegmentedButtonColors r20 = r9;
        BorderStroke r21 = r10;
    L159:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L162;
        ComposerKt.traceEventStart(2065856961, r1, r3, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:266)");
    L162:
        Modifier r13 = r18;
        boolean r14 = r19;
        SegmentedButtonColors r15 = r20;
        BorderStroke r24 = r21;
        MutableInteractionSource r25 = r22;
        Function2 r110 = r23;
        Composer r26 = r12;
        SegmentedButton(r27, r28, r29, r30, r13, r14, r15, r24, SegmentedButtonDefaults.INSTANCE.getContentPadding(), r25, r110, r37, r12, (((((((((r1 & 14) | 100663296) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (57344 & r1)) | (458752 & r1)) | (3670016 & r1)) | (29360128 & r1)) | ((r1 << 3) & 1879048192), ((r1 >> 27) & 14) | ((r3 << 3) & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L165;
        ComposerKt.traceEventEnd();
    L165:
        final Modifier r42 = r18;
        final boolean r43 = r19;
        final SegmentedButtonColors r44 = r20;
        final BorderStroke r45 = r21;
        final MutableInteractionSource r46 = r22;
        final Function2 r111 = r23;
    L167:
        ScopeUpdateScope r112 = r26.endRestartGroup();
        if (r112 == null) goto L171;
        r112.updateScope(new rn(r27, r28, r29, r30, r42, r43, r44, r45, r46, r111, r37, r39, r40, r41));
        return;
    L171:
        return;
    L157:
        r22 = r11;
        r23 = r36;
        goto L158
    L154:
        r11 = r35;
        goto L155
    L151:
        r10 = r34;
        goto L152
    L147:
        r9 = r33;
        goto L149
    L143:
        r8 = r32;
        goto L145
    L140:
        r7 = r31;
        goto L141
    L129:
        if (r12.getDefaultsInvalid() == true) goto L138;
        r12.skipToGroupEnd();
        if ((r41 & 32) == 0) goto L135;
        r1 = r1 & (-3670017);
    L135:
        if ((r41 & 64) == 0) goto L137;
        r1 = r1 & (-29360129);
    L137:
        r18 = r31;
        r19 = r32;
        r20 = r33;
        r21 = r34;
        r22 = r35;
        r23 = r36;
        goto L159
    L166:
        r26 = r12;
        r26.skipToGroupEnd();
        r42 = r31;
        r43 = r32;
        r44 = r33;
        r45 = r34;
        r46 = r35;
        r111 = r36;
        goto L167
    L120:
        if ((r3 & 3) != 2) goto L123;
        r5 = false;
        goto L125
    L110:
        if ((r40 & 6) == 0) goto L112;
        r3 = r40;
        goto L118
    L112:
        if (r12.changedInstance(r37) == false) goto L114;
        int r113 = 4;
    L115:
        r3 = r40 | r113;
        goto L118
    L114:
        r113 = 2;
        goto L115
    L100:
        if ((r39 & 805306368) != 0) goto L107;
        if (r12.changedInstance(r36) == false) goto L104;
        int r114 = 536870912;
    L105:
        r1 = r1 | r114;
        goto L107
    L104:
        r114 = 268435456;
        goto L105
    L90:
        if ((r39 & 100663296) != 0) goto L96;
        if (r12.changed(r35) == false) goto L94;
        int r115 = 67108864;
    L95:
        r1 = r1 | r115;
        goto L96
    L94:
        r115 = 33554432;
        goto L95
    L58:
        if ((196608 & r39) != 0) goto L66;
        if (r12.changed(r32) == false) goto L62;
        int r47 = 131072;
    L63:
        r1 = r1 | r47;
        goto L66
    L62:
        r47 = 65536;
        goto L63
    L47:
        if ((r39 & 24576) != 0) goto L54;
        if (r12.changed(r31) == false) goto L51;
        int r48 = 16384;
    L52:
        r1 = r1 | r48;
        goto L54
    L51:
        r48 = 8192;
        goto L52
    L37:
        if ((r39 & 3072) != 0) goto L43;
        if (r12.changed(r30) == false) goto L41;
        int r49 = 2048;
    L42:
        r1 = r1 | r49;
        goto L43
    L41:
        r49 = 1024;
        goto L42
    L27:
        if ((r39 & 384) != 0) goto L34;
        if (r12.changedInstance(r29) == false) goto L31;
        int r50 = 256;
    L32:
        r1 = r1 | r50;
        goto L34
    L31:
        r50 = 128;
        goto L32
    L17:
        if ((r39 & 48) != 0) goto L24;
        if (r12.changed(r28) == false) goto L21;
        int r51 = 32;
    L22:
        r1 = r1 | r51;
        goto L24
    L21:
        r51 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r1 = r39;
        goto L14
    L8:
        if (r12.changed(r27) == false) goto L10;
        int r52 = 4;
    L11:
        r1 = r52 | r39;
        goto L14
    L10:
        r52 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "kept for binary compatibility")
    public static final /* synthetic */ void SegmentedButton(final SingleChoiceSegmentedButtonRowScope r27, final boolean r28, final Function0 r29, final Shape r30, Modifier r31, boolean r32, SegmentedButtonColors r33, BorderStroke r34, MutableInteractionSource r35, Function2 r36, final Function2 r37, Composer r38, final int r39, final int r40, final int r41) {
        Composer r12 = r38.startRestartGroup(1723786701);
        if ((Integer.MIN_VALUE & r41) == 0) goto L6;
        int r1 = r39 | 6;
    L14:
        if ((r41 & 1) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r41 & 2) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r41 & 4) == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        int r4 = r41 & 8;
        if (r4 == 0) goto L47;
        r1 = r1 | 24576;
    L54:
        int r6 = r41 & 16;
        if (r6 == 0) goto L58;
        r1 = r1 | 196608;
    L66:
        if ((1572864 & r39) != 0) goto L77;
        if ((r41 & 32) != 0) goto L73;
        if (r12.changed(r33) == false) goto L73;
        int r16 = 1048576;
    L74:
        r1 = r1 | r16;
    L73:
        r16 = 524288;
    L77:
        if ((r39 & 12582912) != 0) goto L86;
        if ((r41 & 64) == 0) goto L81;
    L83:
        int r17 = 4194304;
    L84:
        r1 = r1 | r17;
        goto L86
    L81:
        if (r12.changed(r34) == false) goto L83;
        r17 = 8388608;
    L86:
        int r0 = r41 & 128;
        if (r0 == 0) goto L90;
        r1 = r1 | 100663296;
    L96:
        int r2 = r41 & 256;
        if (r2 == 0) goto L100;
        r1 = r1 | 805306368;
    L107:
        if ((r41 & 512) == 0) goto L110;
        int r3 = r40 | 6;
    L118:
        if ((r1 & 306783379) == 306783378) goto L120;
    L123:
        boolean r5 = true;
    L125:
        if (r12.shouldExecute(r5, r1 & 1) == false) goto L166;
        r12.startDefaults();
        if ((r39 & 1) != 0) goto L129;
    L138:
        if (r4 == 0) goto L140;
        Modifier r7 = Modifier.Companion;
    L141:
        if (r6 == 0) goto L143;
        boolean r8 = true;
    L145:
        if ((r41 & 32) == 0) goto L147;
        SegmentedButtonColors r9 = SegmentedButtonDefaults.INSTANCE.colors(r12, 6);
        r1 = r1 & (-3670017);
    L149:
        if ((r41 & 64) == 0) goto L151;
        BorderStroke r10 = SegmentedButtonDefaults.m3093borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, r9.m3076borderColorWaAFU9c$material3(r8, r28), MenuKt.ClosedAlphaTarget, 2, null);
        r1 = r1 & (-29360129);
    L152:
        if (r0 == 0) goto L154;
        MutableInteractionSource r11 = null;
    L155:
        if (r2 == 0) goto L157;
        MutableInteractionSource r310 = r11;
        MutableInteractionSource r22 = r310;
        r1 = r1;
        Function2 r23 = ComposableLambdaKt.rememberComposableLambda(61121126, true, new AnonymousClass10(r28), r12, 54);
    L158:
        Modifier r18 = r7;
        boolean r19 = r8;
        SegmentedButtonColors r20 = r9;
        BorderStroke r21 = r10;
    L159:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L162;
        ComposerKt.traceEventStart(1723786701, r1, r3, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:296)");
    L162:
        Modifier r13 = r18;
        boolean r14 = r19;
        SegmentedButtonColors r15 = r20;
        BorderStroke r24 = r21;
        MutableInteractionSource r25 = r22;
        Function2 r110 = r23;
        Composer r26 = r12;
        SegmentedButton(r27, r28, r29, r30, r13, r14, r15, r24, SegmentedButtonDefaults.INSTANCE.getContentPadding(), r25, r110, r37, r12, (((((((((r1 & 14) | 100663296) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (57344 & r1)) | (458752 & r1)) | (3670016 & r1)) | (29360128 & r1)) | ((r1 << 3) & 1879048192), ((r1 >> 27) & 14) | ((r3 << 3) & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L165;
        ComposerKt.traceEventEnd();
    L165:
        final Modifier r42 = r18;
        final boolean r43 = r19;
        final SegmentedButtonColors r44 = r20;
        final BorderStroke r45 = r21;
        final MutableInteractionSource r46 = r22;
        final Function2 r111 = r23;
    L167:
        ScopeUpdateScope r112 = r26.endRestartGroup();
        if (r112 == null) goto L171;
        r112.updateScope(new nn(r27, r28, r29, r30, r42, r43, r44, r45, r46, r111, r37, r39, r40, r41));
        return;
    L171:
        return;
    L157:
        r22 = r11;
        r23 = r36;
        goto L158
    L154:
        r11 = r35;
        goto L155
    L151:
        r10 = r34;
        goto L152
    L147:
        r9 = r33;
        goto L149
    L143:
        r8 = r32;
        goto L145
    L140:
        r7 = r31;
        goto L141
    L129:
        if (r12.getDefaultsInvalid() == true) goto L138;
        r12.skipToGroupEnd();
        if ((r41 & 32) == 0) goto L135;
        r1 = r1 & (-3670017);
    L135:
        if ((r41 & 64) == 0) goto L137;
        r1 = r1 & (-29360129);
    L137:
        r18 = r31;
        r19 = r32;
        r20 = r33;
        r21 = r34;
        r22 = r35;
        r23 = r36;
        goto L159
    L166:
        r26 = r12;
        r26.skipToGroupEnd();
        r42 = r31;
        r43 = r32;
        r44 = r33;
        r45 = r34;
        r46 = r35;
        r111 = r36;
        goto L167
    L120:
        if ((r3 & 3) != 2) goto L123;
        r5 = false;
        goto L125
    L110:
        if ((r40 & 6) == 0) goto L112;
        r3 = r40;
        goto L118
    L112:
        if (r12.changedInstance(r37) == false) goto L114;
        int r113 = 4;
    L115:
        r3 = r40 | r113;
        goto L118
    L114:
        r113 = 2;
        goto L115
    L100:
        if ((r39 & 805306368) != 0) goto L107;
        if (r12.changedInstance(r36) == false) goto L104;
        int r114 = 536870912;
    L105:
        r1 = r1 | r114;
        goto L107
    L104:
        r114 = 268435456;
        goto L105
    L90:
        if ((r39 & 100663296) != 0) goto L96;
        if (r12.changed(r35) == false) goto L94;
        int r115 = 67108864;
    L95:
        r1 = r1 | r115;
        goto L96
    L94:
        r115 = 33554432;
        goto L95
    L58:
        if ((196608 & r39) != 0) goto L66;
        if (r12.changed(r32) == false) goto L62;
        int r47 = 131072;
    L63:
        r1 = r1 | r47;
        goto L66
    L62:
        r47 = 65536;
        goto L63
    L47:
        if ((r39 & 24576) != 0) goto L54;
        if (r12.changed(r31) == false) goto L51;
        int r48 = 16384;
    L52:
        r1 = r1 | r48;
        goto L54
    L51:
        r48 = 8192;
        goto L52
    L37:
        if ((r39 & 3072) != 0) goto L43;
        if (r12.changed(r30) == false) goto L41;
        int r49 = 2048;
    L42:
        r1 = r1 | r49;
        goto L43
    L41:
        r49 = 1024;
        goto L42
    L27:
        if ((r39 & 384) != 0) goto L34;
        if (r12.changedInstance(r29) == false) goto L31;
        int r50 = 256;
    L32:
        r1 = r1 | r50;
        goto L34
    L31:
        r50 = 128;
        goto L32
    L17:
        if ((r39 & 48) != 0) goto L24;
        if (r12.changed(r28) == false) goto L21;
        int r51 = 32;
    L22:
        r1 = r1 | r51;
        goto L24
    L21:
        r51 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r1 = r39;
        goto L14
    L8:
        if (r12.changed(r27) == false) goto L10;
        int r52 = 4;
    L11:
        r1 = r52 | r39;
        goto L14
    L10:
        r52 = 2;
        goto L11
    }

    public static final void SegmentedButton(final MultiChoiceSegmentedButtonRowScope r30, final boolean r31, final Function1<? super Boolean, Unit> r32, final Shape r33, Modifier r34, boolean r35, SegmentedButtonColors r36, BorderStroke r37, PaddingValues r38, MutableInteractionSource r39, Function2<? super Composer, ? super Integer, Unit> r40, final Function2<? super Composer, ? super Integer, Unit> r41, Composer r42, final int r43, final int r44, final int r45) {
        Composer r3 = r42.startRestartGroup(697872538);
        if ((Integer.MIN_VALUE & r45) == 0) goto L6;
        int r6 = r43 | 6;
    L14:
        if ((r45 & 1) == 0) goto L17;
        r6 = r6 | 48;
    L24:
        if ((r45 & 2) == 0) goto L27;
        r6 = r6 | 384;
    L34:
        if ((r45 & 4) == 0) goto L37;
        r6 = r6 | 3072;
    L43:
        int r7 = r45 & 8;
        if (r7 == 0) goto L47;
        r6 = r6 | 24576;
    L54:
        int r16 = r45 & 16;
        if (r16 == 0) goto L58;
        r6 = r6 | 196608;
    L65:
        if ((r43 & 1572864) != 0) goto L75;
        if ((r45 & 32) == 0) goto L69;
    L71:
        int r18 = 524288;
    L72:
        r6 = r6 | r18;
        goto L75
    L69:
        if (r3.changed(r36) == false) goto L71;
        r18 = 1048576;
    L75:
        if ((r43 & 12582912) != 0) goto L84;
        if ((r45 & 64) == 0) goto L79;
    L81:
        int r19 = 4194304;
    L82:
        r6 = r6 | r19;
        goto L84
    L79:
        if (r3.changed(r37) == false) goto L81;
        r19 = 8388608;
    L84:
        int r9 = r45 & 128;
        if (r9 == 0) goto L88;
        r6 = r6 | 100663296;
    L94:
        int r0 = r45 & 256;
        if (r0 == 0) goto L98;
        r6 = r6 | 805306368;
    L104:
        int r1 = r45 & 512;
        if (r1 == 0) goto L108;
        int r17 = r44 | 6;
    L116:
        if ((r45 & 1024) == 0) goto L119;
        r17 = r17 | 48;
    L125:
        int r2 = r17;
        if ((r6 & 306783379) == 306783378) goto L128;
    L131:
        boolean r5 = true;
    L133:
        if (r3.shouldExecute(r5, r6 & 1) == false) goto L183;
        r3.startDefaults();
        if ((r43 & 1) != 0) goto L137;
    L146:
        if (r7 == 0) goto L148;
        Modifier r8 = Modifier.Companion;
    L149:
        if (r16 == 0) goto L151;
        boolean r10 = true;
    L153:
        if ((r45 & 32) == 0) goto L155;
        SegmentedButtonColors r11 = SegmentedButtonDefaults.INSTANCE.colors(r3, 6);
        r6 = r6 & (-3670017);
    L157:
        if ((r45 & 64) == 0) goto L159;
        BorderStroke r110 = SegmentedButtonDefaults.m3093borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, r11.m3076borderColorWaAFU9c$material3(r10, r31), MenuKt.ClosedAlphaTarget, 2, null);
        r6 = r6 & (-29360129);
    L160:
        if (r9 == 0) goto L162;
        PaddingValues r12 = SegmentedButtonDefaults.INSTANCE.getContentPadding();
    L163:
        if (r0 == 0) goto L165;
        MutableInteractionSource r4 = null;
    L166:
        if (r1 == 0) goto L168;
        MutableInteractionSource r21 = r4;
        Function2<? super Composer, ? super Integer, Unit> r13 = ComposableLambdaKt.rememberComposableLambda(1181873313, true, new AnonymousClass1(r31), r3, 54);
    L169:
        boolean r14 = r10;
        BorderStroke r111 = r110;
        PaddingValues r15 = r12;
        Modifier r112 = r8;
        int r20 = r6;
    L170:
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L173;
        ComposerKt.traceEventStart(697872538, r20, r2, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:142)");
    L173:
        if (r21 != null) goto L178;
        r3.startReplaceGroup(-1615180959);
        Object r22 = r3.rememberedValue();
        if (r22 != Composer.Companion.getEmpty()) goto L177;
        r22 = InteractionSourceKt.MutableInteractionSource();
        r3.updateRememberedValue(r22);
    L177:
        MutableInteractionSource r23 = (MutableInteractionSource) r22;
        r3.endReplaceGroup();
    L179:
        long r24 = r11.m3077containerColorWaAFU9c$material3(r14, r31);
        int r25 = r20;
        long r26 = r11.m3078contentColorWaAFU9c$material3(r14, r31);
        final PaddingValues r27 = r15;
        final Function2<? super Composer, ? super Integer, Unit> r28 = r13;
        State<Integer> r29 = interactionCountAsState(r23, r3, 0);
        MutableInteractionSource r210 = r23;
        Modifier r46 = interactionZIndex(RowScope.CC.weight$default(r30, r112, 1.0f, false, 2, null), r31, r29);
        ButtonDefaults r47 = ButtonDefaults.INSTANCE;
        boolean r211 = r14;
        SegmentedButtonColors r212 = r11;
        int r48 = r25 >> 3;
        int r49 = r48 & 14;
        Composer r213 = r3;
        BorderStroke r113 = r111;
        SurfaceKt.m3215Surfaced85dljk(r31, r32, SizeKt.m998defaultMinSizeVpY3zN4(r46, r47.m2359getMinWidthD9Ej5fM(), r47.m2358getMinHeightD9Ej5fM()), r211, r33, r24, r26, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r113, r210, ComposableLambdaKt.rememberComposableLambda(1717860164, true, new AnonymousClass2(r28, r41, r27), r3, 54), r213, ((((r48 & 112) | r49) | ((r25 >> 6) & 7168)) | ((r25 << 3) & 57344)) | (1879048192 & (r25 << 6)), 48, 384);
        if (ComposerKt.isTraceInProgress() == false) goto L182;
        ComposerKt.traceEventEnd();
    L182:
        final Modifier r50 = r112;
        final BorderStroke r51 = r111;
        final boolean r52 = r211;
        final MutableInteractionSource r114 = r21;
        final PaddingValues r53 = r27;
        final SegmentedButtonColors r54 = r212;
        final Function2<? super Composer, ? super Integer, Unit> r115 = r28;
    L184:
        ScopeUpdateScope r116 = r213.endRestartGroup();
        if (r116 == null) goto L188;
        r116.updateScope(new qn(r30, r31, r32, r33, r50, r52, r54, r51, r53, r114, r115, r41, r43, r44, r45));
        return;
    L188:
        return;
    L178:
        r3.startReplaceGroup(640633398);
        r3.endReplaceGroup();
        r23 = r21;
        goto L179
    L168:
        r21 = r4;
        r13 = r40;
        goto L169
    L165:
        r4 = r39;
        goto L166
    L162:
        r12 = r38;
        goto L163
    L159:
        r110 = r37;
        goto L160
    L155:
        r11 = r36;
        goto L157
    L151:
        r10 = r35;
        goto L153
    L148:
        r8 = r34;
        goto L149
    L137:
        if (r3.getDefaultsInvalid() == true) goto L146;
        r3.skipToGroupEnd();
        if ((r45 & 32) == 0) goto L143;
        r6 = r6 & (-3670017);
    L143:
        if ((r45 & 64) == 0) goto L145;
        r6 = r6 & (-29360129);
    L145:
        r112 = r34;
        r14 = r35;
        r11 = r36;
        r111 = r37;
        r15 = r38;
        r21 = r39;
        r13 = r40;
        r20 = r6;
        goto L170
    L183:
        r213 = r3;
        r213.skipToGroupEnd();
        r50 = r34;
        r52 = r35;
        r54 = r36;
        r51 = r37;
        r53 = r38;
        r114 = r39;
        r115 = r40;
        goto L184
    L128:
        if ((r2 & 19) != 18) goto L131;
        r5 = false;
        goto L133
    L119:
        if ((r44 & 48) != 0) goto L125;
        if (r3.changedInstance(r41) == false) goto L123;
        int r117 = 32;
    L124:
        r17 = r17 | r117;
        goto L125
    L123:
        r117 = 16;
        goto L124
    L108:
        if ((r44 & 6) == 0) goto L110;
        r17 = r44;
        goto L116
    L110:
        if (r3.changedInstance(r40) == false) goto L112;
        int r118 = 4;
    L113:
        r17 = r44 | r118;
        goto L116
    L112:
        r118 = 2;
        goto L113
    L98:
        if ((r43 & 805306368) != 0) goto L104;
        if (r3.changed(r39) == false) goto L102;
        int r214 = 536870912;
    L103:
        r6 = r6 | r214;
        goto L104
    L102:
        r214 = 268435456;
        goto L103
    L88:
        if ((r43 & 100663296) != 0) goto L94;
        if (r3.changed(r38) == false) goto L92;
        int r215 = 67108864;
    L93:
        r6 = r6 | r215;
        goto L94
    L92:
        r215 = 33554432;
        goto L93
    L58:
        if ((r43 & 196608) != 0) goto L65;
        if (r3.changed(r35) == false) goto L62;
        int r119 = 131072;
    L63:
        r6 = r6 | r119;
        goto L65
    L62:
        r119 = 65536;
        goto L63
    L47:
        if ((r43 & 24576) != 0) goto L54;
        if (r3.changed(r34) == false) goto L51;
        int r120 = 16384;
    L52:
        r6 = r6 | r120;
        goto L54
    L51:
        r120 = 8192;
        goto L52
    L37:
        if ((r43 & 3072) != 0) goto L43;
        if (r3.changed(r33) == false) goto L41;
        int r55 = 2048;
    L42:
        r6 = r6 | r55;
        goto L43
    L41:
        r55 = 1024;
        goto L42
    L27:
        if ((r43 & 384) != 0) goto L34;
        if (r3.changedInstance(r32) == false) goto L31;
        int r56 = 256;
    L32:
        r6 = r6 | r56;
        goto L34
    L31:
        r56 = 128;
        goto L32
    L17:
        if ((r43 & 48) != 0) goto L24;
        if (r3.changed(r31) == false) goto L21;
        int r57 = 32;
    L22:
        r6 = r6 | r57;
        goto L24
    L21:
        r57 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r6 = r43;
        goto L14
    L8:
        if (r3.changed(r30) == false) goto L10;
        int r58 = 4;
    L11:
        r6 = r58 | r43;
        goto L14
    L10:
        r58 = 2;
        goto L11
    }

    public static final void SegmentedButton(final SingleChoiceSegmentedButtonRowScope r31, final boolean r32, final Function0<Unit> r33, final Shape r34, Modifier r35, boolean r36, SegmentedButtonColors r37, BorderStroke r38, PaddingValues r39, MutableInteractionSource r40, Function2<? super Composer, ? super Integer, Unit> r41, final Function2<? super Composer, ? super Integer, Unit> r42, Composer r43, final int r44, final int r45, final int r46) {
        Composer r8 = r43.startRestartGroup(1532041126);
        if ((Integer.MIN_VALUE & r46) == 0) goto L6;
        int r1 = r44 | 6;
    L14:
        if ((r46 & 1) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r46 & 2) == 0) goto L27;
        r1 = r1 | 384;
    L35:
        if ((r46 & 4) == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        int r10 = r46 & 8;
        if (r10 == 0) goto L48;
        r1 = r1 | 24576;
    L54:
        Modifier r13 = r35;
    L55:
        int r16 = r46 & 16;
        if (r16 == 0) goto L59;
        r1 = r1 | 196608;
    L66:
        if ((r44 & 1572864) != 0) goto L76;
        if ((r46 & 32) == 0) goto L70;
    L72:
        int r18 = 524288;
    L73:
        r1 = r1 | r18;
        goto L76
    L70:
        if (r8.changed(r37) == false) goto L72;
        r18 = 1048576;
    L76:
        if ((r44 & 12582912) != 0) goto L85;
        if ((r46 & 64) == 0) goto L80;
    L82:
        int r19 = 4194304;
    L83:
        r1 = r1 | r19;
        goto L85
    L80:
        if (r8.changed(r38) == false) goto L82;
        r19 = 8388608;
    L85:
        int r9 = r46 & 128;
        if (r9 == 0) goto L89;
        r1 = r1 | 100663296;
    L95:
        int r0 = r46 & 256;
        if (r0 == 0) goto L99;
        r1 = r1 | 805306368;
    L105:
        int r2 = r46 & 512;
        if (r2 == 0) goto L109;
        int r17 = r45 | 6;
    L117:
        if ((r46 & 1024) == 0) goto L120;
        r17 = r17 | 48;
    L126:
        int r3 = r17;
        if ((r1 & 306783379) == 306783378) goto L129;
    L132:
        boolean r4 = true;
    L134:
        if (r8.shouldExecute(r4, r1 & 1) == false) goto L187;
        r8.startDefaults();
        if ((r44 & 1) != 0) goto L138;
    L147:
        if (r10 == 0) goto L149;
        Modifier r5 = Modifier.Companion;
    L150:
        if (r16 == 0) goto L152;
        boolean r11 = true;
    L154:
        if ((r46 & 32) == 0) goto L156;
        SegmentedButtonColors r14 = SegmentedButtonDefaults.INSTANCE.colors(r8, 6);
        r1 = r1 & (-3670017);
    L158:
        if ((r46 & 64) == 0) goto L160;
        BorderStroke r110 = SegmentedButtonDefaults.m3093borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, r14.m3076borderColorWaAFU9c$material3(r11, r32), MenuKt.ClosedAlphaTarget, 2, null);
        r1 = r1 & (-29360129);
    L161:
        if (r9 == 0) goto L163;
        PaddingValues r12 = SegmentedButtonDefaults.INSTANCE.getContentPadding();
    L164:
        if (r0 == 0) goto L166;
        MutableInteractionSource r6 = null;
    L167:
        if (r2 == 0) goto L169;
        MutableInteractionSource r310 = r6;
        final Function2<? super Composer, ? super Integer, Unit> r7 = ComposableLambdaKt.rememberComposableLambda(-643804033, true, new AnonymousClass4(r32), r8, 54);
        MutableInteractionSource r22 = r310;
    L170:
        Modifier r111 = r5;
        boolean r15 = r11;
        SegmentedButtonColors r20 = r14;
        BorderStroke r21 = r110;
        int r112 = r1;
        final PaddingValues r23 = r12;
    L171:
        r8.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L174;
        ComposerKt.traceEventStart(1532041126, r112, r3, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:222)");
    L174:
        if (r22 != null) goto L179;
        r8.startReplaceGroup(-1579561419);
        Object r24 = r8.rememberedValue();
        if (r24 != Composer.Companion.getEmpty()) goto L178;
        r24 = InteractionSourceKt.MutableInteractionSource();
        r8.updateRememberedValue(r24);
    L178:
        r8.endReplaceGroup();
        MutableInteractionSource r25 = (MutableInteractionSource) r24;
    L180:
        long r26 = r20.m3077containerColorWaAFU9c$material3(r15, r32);
        long r27 = r20.m3078contentColorWaAFU9c$material3(r15, r32);
        State<Integer> r28 = interactionCountAsState(r25, r8, 0);
        Modifier r29 = interactionZIndex(RowScope.CC.weight$default(r31, r111, 1.0f, false, 2, null), r32, r28);
        ButtonDefaults r30 = ButtonDefaults.INSTANCE;
        Modifier r47 = SizeKt.m998defaultMinSizeVpY3zN4(r29, r30.m2359getMinWidthD9Ej5fM(), r30.m2358getMinHeightD9Ej5fM());
        Object r48 = r8.rememberedValue();
        if (r48 != Composer.Companion.getEmpty()) goto L183;
        r48 = new jn();
        r8.updateRememberedValue(r48);
    L183:
        MutableInteractionSource r113 = r25;
        Modifier r49 = SemanticsModifierKt.semantics$default(r47, false, (Function1) r48, 1, null);
        ComposableLambda r50 = ComposableLambdaKt.rememberComposableLambda(-1208080836, true, new AnonymousClass6(r7, r42, r23), r8, 54);
        int r51 = r112;
        int r52 = r51 >> 3;
        int r53 = r52 & 14;
        int r54 = ((((r52 & 112) | r53) | ((r51 >> 6) & 7168)) | ((r51 << 3) & 57344)) | ((r51 << 6) & 1879048192);
        Function2<? super Composer, ? super Integer, Unit> r210 = r7;
        PaddingValues r211 = r23;
        SegmentedButtonColors r114 = r20;
        boolean r212 = r15;
        Composer r213 = r8;
        SurfaceKt.m3214Surfaced85dljk(r32, r33, r49, r15, r34, r26, r27, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r21, r113, r50, r213, r54, 48, 384);
        if (ComposerKt.isTraceInProgress() == false) goto L186;
        ComposerKt.traceEventEnd();
    L186:
        final Modifier r55 = r111;
        final SegmentedButtonColors r56 = r114;
        final Function2<? super Composer, ? super Integer, Unit> r115 = r210;
        final BorderStroke r57 = r21;
        final MutableInteractionSource r116 = r22;
        final PaddingValues r58 = r211;
        final boolean r59 = r212;
    L188:
        ScopeUpdateScope r117 = r213.endRestartGroup();
        if (r117 == null) goto L192;
        r117.updateScope(new kn(r31, r32, r33, r34, r55, r59, r56, r57, r58, r116, r115, r42, r44, r45, r46));
        return;
    L192:
        return;
    L179:
        r8.startReplaceGroup(-882238238);
        r8.endReplaceGroup();
        r25 = r22;
        goto L180
    L169:
        r22 = r6;
        r7 = r41;
        goto L170
    L166:
        r6 = r40;
        goto L167
    L163:
        r12 = r39;
        goto L164
    L160:
        r110 = r38;
        goto L161
    L156:
        r14 = r37;
        goto L158
    L152:
        r11 = r36;
        goto L154
    L149:
        r5 = r13;
        goto L150
    L138:
        if (r8.getDefaultsInvalid() == true) goto L147;
        r8.skipToGroupEnd();
        if ((r46 & 32) == 0) goto L144;
        r1 = r1 & (-3670017);
    L144:
        if ((r46 & 64) == 0) goto L146;
        r1 = r1 & (-29360129);
    L146:
        r15 = r36;
        r20 = r37;
        r21 = r38;
        r22 = r40;
        r7 = r41;
        r111 = r13;
        r112 = r1;
        r23 = r39;
        goto L171
    L187:
        r213 = r8;
        r213.skipToGroupEnd();
        r59 = r36;
        r56 = r37;
        r57 = r38;
        r58 = r39;
        r116 = r40;
        r115 = r41;
        r55 = r13;
        goto L188
    L129:
        if ((r3 & 19) != 18) goto L132;
        r4 = false;
        goto L134
    L120:
        if ((r45 & 48) != 0) goto L126;
        if (r8.changedInstance(r42) == false) goto L124;
        int r118 = 32;
    L125:
        r17 = r17 | r118;
        goto L126
    L124:
        r118 = 16;
        goto L125
    L109:
        if ((r45 & 6) == 0) goto L111;
        r17 = r45;
        goto L117
    L111:
        if (r8.changedInstance(r41) == false) goto L113;
        int r119 = 4;
    L114:
        r17 = r45 | r119;
        goto L117
    L113:
        r119 = 2;
        goto L114
    L99:
        if ((r44 & 805306368) != 0) goto L105;
        if (r8.changed(r40) == false) goto L103;
        int r214 = 536870912;
    L104:
        r1 = r1 | r214;
        goto L105
    L103:
        r214 = 268435456;
        goto L104
    L89:
        if ((r44 & 100663296) != 0) goto L95;
        if (r8.changed(r39) == false) goto L93;
        int r215 = 67108864;
    L94:
        r1 = r1 | r215;
        goto L95
    L93:
        r215 = 33554432;
        goto L94
    L59:
        if ((r44 & 196608) != 0) goto L66;
        if (r8.changed(r36) == false) goto L63;
        int r120 = 131072;
    L64:
        r1 = r1 | r120;
        goto L66
    L63:
        r120 = 65536;
        goto L64
    L48:
        if ((r44 & 24576) != 0) goto L54;
        r13 = r35;
        if (r8.changed(r13) == false) goto L52;
        int r121 = 16384;
    L53:
        r1 = r1 | r121;
        goto L55
    L52:
        r121 = 8192;
        goto L53
    L38:
        if ((r44 & 3072) != 0) goto L44;
        if (r8.changed(r34) == false) goto L42;
        int r122 = 2048;
    L43:
        r1 = r1 | r122;
        goto L44
    L42:
        r122 = 1024;
        goto L43
    L27:
        if ((r44 & 384) != 0) goto L35;
        if (r8.changedInstance(r33) == false) goto L31;
        int r123 = 256;
    L32:
        r1 = r1 | r123;
        goto L35
    L31:
        r123 = 128;
        goto L32
    L17:
        if ((r44 & 48) != 0) goto L24;
        if (r8.changed(r32) == false) goto L21;
        int r60 = 32;
    L22:
        r1 = r1 | r60;
        goto L24
    L21:
        r60 = 16;
        goto L22
    L6:
        if ((r44 & 6) == 0) goto L8;
        r1 = r44;
        goto L14
    L8:
        if (r8.changed(r31) == false) goto L10;
        int r61 = 4;
    L11:
        r1 = r61 | r44;
        goto L14
    L10:
        r61 = 2;
        goto L11
    }
}
