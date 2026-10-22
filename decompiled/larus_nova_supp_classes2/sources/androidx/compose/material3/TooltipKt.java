package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.BasicTooltipDefaults;
import androidx.compose.material3.internal.BasicTooltipKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\u001al\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0012\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0014\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0016\u001av\u0010\u0017\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001b2\b\b\u0002\u0010\"\u001a\u00020\u001b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b#\u0010$\u001ax\u0010\u0017\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001b2\b\b\u0002\u0010\"\u001a\u00020\u001b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b&\u0010'\u001a\u009a\u0001\u0010(\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010!\u001a\u00020\u001b2\b\b\u0002\u0010\"\u001a\u00020\u001b2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b.\u0010/\u001a\u009c\u0001\u0010(\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010!\u001a\u00020\u001b2\b\b\u0002\u0010\"\u001a\u00020\u001b2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b0\u00101\u001a+\u00102\u001a\u00020\n2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u000206H\u0007¢\u0006\u0002\u00107\u001a&\u00108\u001a\u00020\n2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u000206H\u0007\u001a\u001c\u00109\u001a\u00020\f*\u00020\f2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000eH\u0001\u001a\u001a\u0010<\u001a\u00020\f*\u00020\f2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0>H\u0000\u001a \u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0000\u001aT\u0010F\u001a\u00020\f*\u00020\f2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0019\u0010N\u001a\u0015\u0012\u0004\u0012\u00020O\u0012\u0006\u0012\u0004\u0018\u00010P0\u0005¢\u0006\u0002\b\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\bQ\u0010R\"\u0016\u0010S\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bT\u0010U\"\u0016\u0010W\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bX\u0010U\"\u0016\u0010Y\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bZ\u0010U\"\u0010\u0010[\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0010\u0010\\\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0014\u0010]\u001a\u00020^X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`\"\u0016\u0010a\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bb\u0010U\"\u0016\u0010c\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bd\u0010U\"\u0010\u0010e\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0010\u0010f\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V\"\u0016\u0010g\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bh\u0010U\"\u0016\u0010i\u001a\u00020\u001bX\u0080\u0004¢\u0006\n\n\u0002\u0010V\u001a\u0004\bj\u0010U¨\u0006k²\u0006\n\u0010l\u001a\u00020@X\u008a\u0084\u0002²\u0006\n\u0010m\u001a\u00020@X\u008a\u0084\u0002"}, d2 = {"TooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "Lkotlin/Function0;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "onDismissRequest", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "hasAction", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PlainTooltip", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "shadowElevation", "PlainTooltip-m9Er-Xc", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "caretShape", "PlainTooltip-gv3ox5I", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltip", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip-ZuUcA3Q", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "RichTooltip-EkvW5A0", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "rememberTooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "TooltipState", "textVerticalPadding", "subheadExists", "actionExists", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "caretX", "", "tooltipWidth", "screenWidthPx", "", "anchorBounds", "Landroidx/compose/ui/geometry/Rect;", "layoutCaret", "transformationMatrix", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/Matrix;", "density", "Landroidx/compose/ui/unit/Density;", "windowContainerSize", "Landroidx/compose/ui/unit/IntSize;", "getAnchorLayoutCoordinates", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCaret-J5j9r9c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/unit/Density;JLkotlin/jvm/functions/Function1;Landroidx/compose/ui/window/PopupPositionProvider;)Landroidx/compose/ui/Modifier;", "SpacingBetweenTooltipAndAnchor", "getSpacingBetweenTooltipAndAnchor", "()F", "F", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "PlainTooltipVerticalPadding", "PlainTooltipHorizontalPadding", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "HeightToSubheadFirstLine", "getHeightToSubheadFirstLine", "HeightFromSubheadToTextFirstLine", "TextBottomPadding", "ActionLabelMinHeight", "getActionLabelMinHeight", "ActionLabelBottomPadding", "getActionLabelBottomPadding", "material3", "scale", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TooltipKt {
    private static final float ActionLabelBottomPadding = 0.0f;
    private static final float ActionLabelMinHeight = 0.0f;
    private static final float HeightFromSubheadToTextFirstLine = 0.0f;
    private static final float HeightToSubheadFirstLine = 0.0f;
    private static final PaddingValues PlainTooltipContentPadding = null;
    private static final float PlainTooltipHorizontalPadding = 0.0f;
    private static final float PlainTooltipVerticalPadding = 0.0f;
    private static final float RichTooltipHorizontalPadding = 0.0f;
    private static final float SpacingBetweenTooltipAndAnchor = 0.0f;
    private static final float TextBottomPadding = 0.0f;
    private static final float TooltipMinHeight = 0.0f;
    private static final float TooltipMinWidth = 0.0f;

    static {
        float r0 = 4;
        SpacingBetweenTooltipAndAnchor = Dp.constructor-impl(r0);
        float r1 = 24;
        TooltipMinHeight = Dp.constructor-impl(r1);
        TooltipMinWidth = Dp.constructor-impl(40);
        float r2 = Dp.constructor-impl(r0);
        PlainTooltipVerticalPadding = r2;
        float r3 = 8;
        float r4 = Dp.constructor-impl(r3);
        PlainTooltipHorizontalPadding = r4;
        PlainTooltipContentPadding = PaddingKt.m954PaddingValuesYgX7TsA(r4, r2);
        float r5 = 16;
        RichTooltipHorizontalPadding = Dp.constructor-impl(r5);
        HeightToSubheadFirstLine = Dp.constructor-impl(28);
        HeightFromSubheadToTextFirstLine = Dp.constructor-impl(r1);
        TextBottomPadding = Dp.constructor-impl(r5);
        ActionLabelMinHeight = Dp.constructor-impl(36);
        ActionLabelBottomPadding = Dp.constructor-impl(r3);
    }

    private static final Unit PlainTooltip_gv3ox5I$lambda$11(TooltipScope r16, Modifier r17, Shape r18, float r19, Shape r20, long r21, long r23, float r25, float r26, Function2 r27, int r28, int r29, Composer r30, int r31) {
        m3555PlainTooltipgv3ox5I(r16, r17, r18, r19, r20, r21, r23, r25, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), r29);
        return Unit.INSTANCE;
    }

    private static final Unit PlainTooltip_m9Er_Xc$lambda$6(TooltipScope r17, Modifier r18, long r19, float r21, Shape r22, long r23, long r25, float r27, float r28, Function2 r29, int r30, int r31, Composer r32, int r33) {
        m3556PlainTooltipm9ErXc(r17, r18, r19, r21, r22, r23, r25, r27, r28, r29, r32, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), r31);
        return Unit.INSTANCE;
    }

    private static final Unit RichTooltip_EkvW5A0$lambda$17(TooltipScope r16, Modifier r17, Function2 r18, Function2 r19, Shape r20, float r21, Shape r22, RichTooltipColors r23, float r24, float r25, Function2 r26, int r27, int r28, int r29, Composer r30, int r31) {
        m3557RichTooltipEkvW5A0(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit RichTooltip_ZuUcA3Q$lambda$12(TooltipScope r17, Modifier r18, Function2 r19, Function2 r20, long r21, float r23, Shape r24, RichTooltipColors r25, float r26, float r27, Function2 r28, int r29, int r30, int r31, Composer r32, int r33) {
        m3558RichTooltipZuUcA3Q(r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    private static final Unit TooltipBox$lambda$0(PopupPositionProvider r11, Function3 r12, TooltipState r13, Modifier r14, boolean r15, boolean r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        TooltipBox(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit TooltipBox$lambda$1(PopupPositionProvider r12, Function3 r13, TooltipState r14, Modifier r15, Function0 r16, boolean r17, boolean r18, Function2 r19, int r20, int r21, Composer r22, int r23) {
        TooltipBox(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit TooltipBox$lambda$5(PopupPositionProvider r13, Function3 r14, TooltipState r15, Modifier r16, Function0 r17, boolean r18, boolean r19, boolean r20, Function2 r21, int r22, int r23, Composer r24, int r25) {
        TooltipBox(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TooltipScope r0, Modifier r1, Shape r2, float r3, Shape r4, long r5, long r7, float r9, float r10, Function2 r11, int r12, int r13, Composer r14, int r15) {
        return PlainTooltip_gv3ox5I$lambda$11(r0, r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit b(PopupPositionProvider r0, Function3 r1, TooltipState r2, Modifier r3, boolean r4, boolean r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return TooltipBox$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit c(PopupPositionProvider r0, Function3 r1, TooltipState r2, Modifier r3, Function0 r4, boolean r5, boolean r6, Function2 r7, int r8, int r9, Composer r10, int r11) {
        return TooltipBox$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit d(TooltipScope r0, Modifier r1, Function2 r2, Function2 r3, Shape r4, float r5, Shape r6, RichTooltipColors r7, float r8, float r9, Function2 r10, int r11, int r12, int r13, Composer r14, int r15) {
        return RichTooltip_EkvW5A0$lambda$17(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ LayoutCoordinates e(TooltipScope r0, MeasureScope r1) {
        return RichTooltip_EkvW5A0$lambda$15$lambda$14(r0, r1);
    }

    public static /* synthetic */ MeasureResult f(long r0, Function1 r2, Density r3, PopupPositionProvider r4, MutableState r5, MeasureScope r6, Measurable r7, Constraints r8) {
        return layoutCaret_J5j9r9c$lambda$22(r0, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ LayoutCoordinates g(TooltipScope r0, MeasureScope r1) {
        return PlainTooltip_gv3ox5I$lambda$9$lambda$8(r0, r1);
    }

    public static /* synthetic */ Unit h(PopupPositionProvider r0, Function3 r1, TooltipState r2, Modifier r3, Function0 r4, boolean r5, boolean r6, boolean r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        return TooltipBox$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit i(Placeable r0, Placeable.PlacementScope r1) {
        return layoutCaret_J5j9r9c$lambda$22$lambda$21(r0, r1);
    }

    public static /* synthetic */ Unit j(TooltipScope r1, Modifier r2, long r3, float r5, Shape r6, long r7, long r9, float r11, float r12, Function2 r13, int r14, int r15, Composer r16, int r17) {
        return PlainTooltip_m9Er_Xc$lambda$6(r1, r2, r3, r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit k(TooltipScope r1, Modifier r2, Function2 r3, Function2 r4, long r5, float r7, Shape r8, RichTooltipColors r9, float r10, float r11, Function2 r12, int r13, int r14, int r15, Composer r16, int r17) {
        return RichTooltip_ZuUcA3Q$lambda$12(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ LayoutCoordinates l(MutableState r0) {
        return TooltipBox$lambda$4$lambda$3(r0);
    }

    public static final float getActionLabelBottomPadding() {
        return ActionLabelBottomPadding;
    }

    public static final float getActionLabelMinHeight() {
        return ActionLabelMinHeight;
    }

    public static final float getHeightToSubheadFirstLine() {
        return HeightToSubheadFirstLine;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return PlainTooltipContentPadding;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    private static final LayoutCoordinates TooltipBox$lambda$4$lambda$3(MutableState r0) {
        return (LayoutCoordinates) r0.getValue();
    }

    private static final LayoutCoordinates PlainTooltip_gv3ox5I$lambda$9$lambda$8(TooltipScope r0, MeasureScope r1) {
        return r0.obtainAnchorBounds(r1);
    }

    private static final LayoutCoordinates RichTooltip_EkvW5A0$lambda$15$lambda$14(TooltipScope r0, MeasureScope r1) {
        return r0.obtainAnchorBounds(r1);
    }

    public static final Modifier animateTooltip(Modifier r2, final Transition<Boolean> r3) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1(r3);
    L7:
        return ComposedModifierKt.composed(r2, r0, new AnonymousClass2(r3));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    private static final Unit layoutCaret_J5j9r9c$lambda$22$lambda$21(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.place$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    public static final TooltipState TooltipState(boolean r1, boolean r2, MutatorMutex r3) {
        return new TooltipStateImpl(r1, r2, r3);
    }

    public static final float caretX(float r5, int r6, Rect r7) {
        float r0 = r7.getLeft();
        float r8 = r7.getRight();
        float r2 = 2;
        float r1 = (r0 + r8) / r2;
        float r9 = r6;
        if (r5 >= r9) goto L15;
        float r3 = r5 / r2;
        if ((r1 - r3) >= MenuKt.ClosedAlphaTarget) goto L10;
        float r10 = Math.max(r5 - r9, -r0);
    L14:
        return r1 + r10;
    L10:
        if ((r1 + r3) <= r9) goto L13;
        r10 = Math.min(r5 - r8, MenuKt.ClosedAlphaTarget);
        goto L14
    L13:
        return r3;
    L15:
        return r1;
    }

    public static final Modifier textVerticalPadding(Modifier r9, boolean r10, boolean r11) {
        if (r10 == true) goto L7;
        if (r11 == true) goto L7;
        return PaddingKt.m962paddingVpY3zN4$default(r9, MenuKt.ClosedAlphaTarget, PlainTooltipVerticalPadding, 1, null);
    L7:
        return PaddingKt.m964paddingqDBjuR0$default(AlignmentLineKt.m777paddingFromBaselineVpY3zN4$default(r9, HeightFromSubheadToTextFirstLine, MenuKt.ClosedAlphaTarget, 2, null), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, TextBottomPadding, 7, null);
    }

    public static /* synthetic */ TooltipState TooltipState$default(boolean r0, boolean r1, MutatorMutex r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0 = false;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r1 = true;
    L9:
        if ((r3 & 4) == 0) goto L12;
        r2 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
    L12:
        return TooltipState(r0, r1, r2);
    }

    /* JADX INFO: renamed from: layoutCaret-J5j9r9c, reason: not valid java name */
    private static final Modifier m3559layoutCaretJ5j9r9c(Modifier r8, final MutableState<Matrix> r9, final Density r10, final long r11, final Function1<? super MeasureScope, ? extends LayoutCoordinates> r13, final PopupPositionProvider r14) {
        return LayoutModifierKt.layout(r8, new uw(r11, r13, r10, r14, r9));
    }

    public static final TooltipState rememberTooltipState(boolean r4, boolean r5, MutatorMutex r6, Composer r7, int r8, int r9) {
        boolean r1 = false;
        if ((r9 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r6 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventStart(-1413230530, r8, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:962)");
    L15:
        if (((r8 & 112) ^ 48) <= 32) goto L19;
        if (r7.changed(r5) == false) goto L19;
    L20:
        boolean r10 = true;
    L23:
        if (((r8 & 896) ^ 384) <= 256) goto L27;
        if (r7.changed(r6) == false) goto L27;
    L28:
        r1 = true;
    L29:
        boolean r11 = r10 | r1;
        Object r12 = r7.rememberedValue();
        if (r11 == false) goto L32;
    L33:
        r12 = new TooltipStateImpl(r4, r5, r6);
        r7.updateRememberedValue(r12);
    L34:
        TooltipStateImpl r13 = (TooltipStateImpl) r12;
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
    L37:
        return r13;
    L32:
        if (r12 != Composer.Companion.getEmpty()) goto L34;
    L27:
        if ((r8 & 384) != 256) goto L29;
    L19:
        if ((r8 & 48) == 32) goto L20;
        r10 = false;
        goto L23
    }

    private static final MeasureResult layoutCaret_J5j9r9c$lambda$22(long r26, Function1 r28, Density r29, PopupPositionProvider r30, MutableState r31, MeasureScope r32, Measurable r33, Constraints r34) {
        final Placeable r1 = r33.measure-BRTryo0(r34.unbox-impl());
        int r2 = r1.getWidth();
        int r3 = r1.getHeight();
        int r6 = (int) (r26 >> 32);
        int r5 = (int) (r26 & 4294967295L);
        float r9 = r2;
        float r10 = r3;
        LayoutCoordinates r11 = (LayoutCoordinates) r28.invoke(r32);
        if (r11 == null) goto L126;
        int r13 = r29.roundToPx-0680j_4(SpacingBetweenTooltipAndAnchor);
        Rect r12 = LayoutCoordinatesKt.boundsInWindow(r11);
        float r14 = r12.getTop();
        float r15 = r12.getBottom();
        float r16 = r12.getRight();
        float r17 = r12.getLeft();
        boolean r7 = r30 instanceof TooltipPositionProviderImpl;
        if (r7 == false) goto L30;
        int r4 = ((TooltipPositionProviderImpl) r30).m3564getTypelOKsHw4();
        TooltipAnchorPosition.Companion r18 = TooltipAnchorPosition.Companion;
        if (TooltipAnchorPosition.m3531equalsimpl0(r4, r18.m3538getLeftlOKsHw4()) == false) goto L9;
    L28:
        r10 = r10 / 2;
    L32:
        if (r7 == false) goto L73;
        int r8 = ((TooltipPositionProviderImpl) r30).m3564getTypelOKsHw4();
        TooltipAnchorPosition.Companion r19 = TooltipAnchorPosition.Companion;
        if (TooltipAnchorPosition.m3531equalsimpl0(r8, r19.m3538getLeftlOKsHw4()) == false) goto L42;
        if (((r17 - r13) - r9) >= MenuKt.ClosedAlphaTarget) goto L38;
        float r20 = MenuKt.ClosedAlphaTarget;
    L39:
        long r21 = Offset.constructor-impl((Float.floatToRawIntBits(r20) << 32) | (((long) Float.floatToRawIntBits(r10)) & 4294967295L));
    L40:
        char r22 = ' ';
        long r110 = 4294967295L;
    L74:
        float[] r111 = Matrix.constructor-impl$default(null, 1, null);
        Matrix.translate-impl$default(r111, Float.intBitsToFloat((int) (r21 >> r22)), Float.intBitsToFloat((int) (r21 & r110)), MenuKt.ClosedAlphaTarget, 4, null);
        if (r7 == false) goto L119;
        int r0 = ((TooltipPositionProviderImpl) r30).m3564getTypelOKsHw4();
        TooltipAnchorPosition.Companion r23 = TooltipAnchorPosition.Companion;
        if (TooltipAnchorPosition.m3531equalsimpl0(r0, r23.m3538getLeftlOKsHw4()) == false) goto L83;
        if (((r17 - r13) - r9) >= MenuKt.ClosedAlphaTarget) goto L81;
        Matrix.rotateZ-impl(r111, 90.0f);
    L124:
        r31.setValue(Matrix.box-impl(r111));
        goto L126
    L81:
        Matrix.rotateZ-impl(r111, -90.0f);
        goto L124
    L83:
        if (TooltipAnchorPosition.m3531equalsimpl0(r0, r23.m3539getRightlOKsHw4()) == false) goto L89;
        if (((r16 + r13) + r9) <= r6) goto L87;
        Matrix.rotateZ-impl(r111, -90.0f);
        goto L124
    L87:
        Matrix.rotateZ-impl(r111, 90.0f);
        goto L124
    L89:
        if (TooltipAnchorPosition.m3531equalsimpl0(r0, r23.m3540getStartlOKsHw4()) == false) goto L101;
        if (r32.getLayoutDirection() != LayoutDirection.Ltr) goto L97;
        if (((r17 - r13) - r9) >= MenuKt.ClosedAlphaTarget) goto L95;
        Matrix.rotateZ-impl(r111, 90.0f);
        goto L124
    L95:
        Matrix.rotateZ-impl(r111, -90.0f);
        goto L124
    L97:
        if (((r16 + r13) + r9) <= r6) goto L99;
        Matrix.rotateZ-impl(r111, -90.0f);
        goto L124
    L99:
        Matrix.rotateZ-impl(r111, 90.0f);
        goto L124
    L101:
        if (TooltipAnchorPosition.m3531equalsimpl0(r0, r23.m3537getEndlOKsHw4()) == false) goto L113;
        if (r32.getLayoutDirection() != LayoutDirection.Ltr) goto L109;
        if (((r16 + r13) + r9) <= r6) goto L107;
        Matrix.rotateZ-impl(r111, -90.0f);
        goto L124
    L107:
        Matrix.rotateZ-impl(r111, 90.0f);
        goto L124
    L109:
        if (((r17 - r13) - r9) >= MenuKt.ClosedAlphaTarget) goto L111;
        Matrix.rotateZ-impl(r111, 90.0f);
        goto L124
    L111:
        Matrix.rotateZ-impl(r111, -90.0f);
        goto L124
    L113:
        if (r10 != MenuKt.ClosedAlphaTarget) goto L115;
        boolean r112 = true;
    L116:
        if (r112 == false) goto L124;
        Matrix.rotateX-impl(r111, 180.0f);
        goto L124
    L115:
        r112 = false;
        goto L116
    L119:
        if (r10 != MenuKt.ClosedAlphaTarget) goto L121;
        boolean r113 = true;
    L122:
        if (r113 == false) goto L124;
        Matrix.rotateX-impl(r111, 180.0f);
        goto L124
    L121:
        r113 = false;
        goto L122
    L38:
        r20 = r9;
        goto L39
    L42:
        if (TooltipAnchorPosition.m3531equalsimpl0(r8, r19.m3539getRightlOKsHw4()) == false) goto L49;
        if (((r16 + r13) + r9) <= r6) goto L46;
        float r24 = r9;
    L47:
        r21 = Offset.constructor-impl((Float.floatToRawIntBits(r24) << 32) | (((long) Float.floatToRawIntBits(r10)) & 4294967295L));
        goto L40
    L46:
        r24 = MenuKt.ClosedAlphaTarget;
        goto L47
    L49:
        if (TooltipAnchorPosition.m3531equalsimpl0(r8, r19.m3540getStartlOKsHw4()) == false) goto L61;
        if (r32.getLayoutDirection() != LayoutDirection.Ltr) goto L56;
        if (((r17 - r13) - r9) < MenuKt.ClosedAlphaTarget) goto L58;
    L57:
        float r25 = r9;
    L59:
        r21 = Offset.constructor-impl((Float.floatToRawIntBits(r25) << 32) | (((long) Float.floatToRawIntBits(r10)) & 4294967295L));
    L58:
        r25 = MenuKt.ClosedAlphaTarget;
        goto L59
    L56:
        if (((r16 + r13) + r9) <= r6) goto L58;
    L61:
        if (TooltipAnchorPosition.m3531equalsimpl0(r8, r19.m3537getEndlOKsHw4()) == true) goto L63;
        r22 = ' ';
        r110 = 4294967295L;
        r21 = Offset.constructor-impl((Float.floatToRawIntBits(caretX(r9, r6, r12)) << 32) | (((long) Float.floatToRawIntBits(r10)) & 4294967295L));
        goto L74
    L63:
        if (r32.getLayoutDirection() != LayoutDirection.Ltr) goto L68;
        if (((r16 + r13) + r9) > r6) goto L70;
    L69:
        float r27 = MenuKt.ClosedAlphaTarget;
    L71:
        r22 = ' ';
        r110 = 4294967295L;
        r21 = Offset.constructor-impl((Float.floatToRawIntBits(r27) << 32) | (Float.floatToRawIntBits(r10) & 4294967295L));
    L70:
        r27 = r9;
        goto L71
    L68:
        if (((r17 - r13) - r9) >= MenuKt.ClosedAlphaTarget) goto L70;
    L73:
        r22 = ' ';
        r110 = 4294967295L;
        r21 = Offset.constructor-impl((Float.floatToRawIntBits(caretX(r9, r6, r12)) << 32) | (((long) Float.floatToRawIntBits(r10)) & 4294967295L));
        goto L74
    L9:
        if (TooltipAnchorPosition.m3531equalsimpl0(r4, r18.m3539getRightlOKsHw4()) == true) goto L28;
        if (TooltipAnchorPosition.m3531equalsimpl0(r4, r18.m3540getStartlOKsHw4()) == true) goto L28;
        if (TooltipAnchorPosition.m3531equalsimpl0(r4, r18.m3537getEndlOKsHw4()) == true) goto L28;
        if (TooltipAnchorPosition.m3531equalsimpl0(r4, r18.m3535getAbovelOKsHw4()) == false) goto L21;
        if (((r14 - r10) - r13) >= MenuKt.ClosedAlphaTarget) goto L32;
    L31:
        r10 = MenuKt.ClosedAlphaTarget;
        goto L32
    L21:
        if (TooltipAnchorPosition.m3531equalsimpl0(r4, r18.m3536getBelowlOKsHw4()) == false) goto L26;
        if (((r15 + r10) + r13) <= r5) goto L31;
    L26:
        if (((r14 - r10) - r13) >= MenuKt.ClosedAlphaTarget) goto L32;
    L30:
        if (((r14 - r10) - r13) >= MenuKt.ClosedAlphaTarget) goto L32;
    L126:
        return MeasureScope.-CC.layout$default(r32, r2, r3, null, new sw(r1), 4, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of TooltipBox API that contains onDismissRequest and hasAction params.")
    public static final /* synthetic */ void TooltipBox(final PopupPositionProvider r21, final Function3 r22, final TooltipState r23, Modifier r24, boolean r25, boolean r26, final Function2 r27, Composer r28, final int r29, final int r30) {
        Composer r14 = r28.startRestartGroup(-375963176);
        if ((r30 & 1) == 0) goto L6;
        int r1 = r29 | 6;
    L14:
        if ((r30 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r30 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L36:
        int r2 = r30 & 8;
        if (r2 == 0) goto L40;
        r1 = r1 | 3072;
    L46:
        Modifier r3 = r24;
    L47:
        int r4 = r30 & 16;
        if (r4 == 0) goto L51;
        r1 = r1 | 24576;
    L57:
        final boolean r5 = r25;
    L58:
        int r6 = r30 & 32;
        if (r6 == 0) goto L62;
        r1 = r1 | 196608;
    L68:
        boolean r7 = r26;
    L70:
        if ((r30 & 64) == 0) goto L73;
        r1 = r1 | 1572864;
    L79:
        boolean r16 = true;
        if ((599187 & r1) == 599186) goto L82;
        boolean r8 = true;
    L84:
        if (r14.shouldExecute(r8, r1 & 1) == false) goto L101;
        if (r2 == 0) goto L87;
        Modifier r17 = Modifier.Companion;
    L88:
        if (r4 == 0) goto L90;
        boolean r18 = true;
    L91:
        if (r6 != 0) goto L95;
        r16 = r7;
    L95:
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventStart(-375963176, r1, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:118)");
    L97:
        int r0 = ((((r1 & 14) | 12607488) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168);
        int r9 = r1 << 3;
        int r19 = ((r0 | (458752 & r9)) | (r9 & 3670016)) | ((r1 << 6) & 234881024);
        TooltipBox(r21, r22, r23, r17, null, r18, r16, false, r27, r14, r19, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventEnd();
    L100:
        final boolean r10 = r16;
        final Modifier r11 = r17;
        r5 = r18;
    L102:
        ScopeUpdateScope r12 = r14.endRestartGroup();
        if (r12 == null) goto L106;
        r12.updateScope(new vw(r21, r22, r23, r11, r5, r10, r27, r29, r30));
        return;
    L106:
        return;
    L90:
        r18 = r5;
        goto L91
    L87:
        r17 = r3;
        goto L88
    L101:
        r14.skipToGroupEnd();
        r11 = r3;
        r10 = r7;
        goto L102
    L82:
        r8 = false;
        goto L84
    L73:
        if ((r29 & 1572864) != 0) goto L79;
        if (r14.changedInstance(r27) == false) goto L77;
        int r13 = 1048576;
    L78:
        r1 = r1 | r13;
        goto L79
    L77:
        r13 = 524288;
        goto L78
    L62:
        if ((196608 & r29) != 0) goto L68;
        r7 = r26;
        if (r14.changed(r7) == false) goto L66;
        int r15 = 131072;
    L67:
        r1 = r1 | r15;
        goto L70
    L66:
        r15 = 65536;
        goto L67
    L51:
        if ((r29 & 24576) != 0) goto L57;
        r5 = r25;
        if (r14.changed(r5) == false) goto L55;
        int r20 = 16384;
    L56:
        r1 = r1 | r20;
        goto L58
    L55:
        r20 = 8192;
        goto L56
    L40:
        if ((r29 & 3072) != 0) goto L46;
        r3 = r24;
        if (r14.changed(r3) == false) goto L44;
        int r31 = 2048;
    L45:
        r1 = r1 | r31;
        goto L47
    L44:
        r31 = 1024;
        goto L45
    L27:
        if ((r29 & 384) != 0) goto L36;
        if ((r29 & 512) != 0) goto L31;
        boolean r32 = r14.changed(r23);
    L32:
        if (r32 == false) goto L34;
        int r33 = 256;
    L35:
        r1 = r1 | r33;
        goto L36
    L34:
        r33 = 128;
        goto L35
    L31:
        r32 = r14.changedInstance(r23);
        goto L32
    L17:
        if ((r29 & 48) != 0) goto L24;
        if (r14.changedInstance(r22) == false) goto L21;
        int r34 = 32;
    L22:
        r1 = r1 | r34;
        goto L24
    L21:
        r34 = 16;
        goto L22
    L6:
        if ((r29 & 6) == 0) goto L8;
        r1 = r29;
        goto L14
    L8:
        if (r14.changed(r21) == false) goto L10;
        int r35 = 4;
    L11:
        r1 = r35 | r29;
        goto L14
    L10:
        r35 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of TooltipBox API that contains hasAction param.")
    public static final /* synthetic */ void TooltipBox(final PopupPositionProvider r22, final Function3 r23, final TooltipState r24, Modifier r25, Function0 r26, boolean r27, boolean r28, final Function2 r29, Composer r30, final int r31, final int r32) {
        Composer r15 = r30.startRestartGroup(2055306788);
        if ((r32 & 1) == 0) goto L6;
        int r1 = r31 | 6;
    L14:
        if ((r32 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r32 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L36:
        int r2 = r32 & 8;
        if (r2 == 0) goto L40;
        r1 = r1 | 3072;
    L46:
        Modifier r3 = r25;
    L47:
        int r4 = r32 & 32;
        if (r4 == 0) goto L51;
        r1 = r1 | 196608;
    L57:
        boolean r5 = r27;
    L58:
        int r6 = r32 & 64;
        if (r6 == 0) goto L62;
        r1 = r1 | 1572864;
    L68:
        final boolean r7 = r28;
    L70:
        if ((r32 & 128) == 0) goto L73;
        r1 = r1 | 12582912;
    L79:
        boolean r17 = true;
        if ((4785299 & r1) == 4785298) goto L82;
        boolean r0 = true;
    L84:
        if (r15.shouldExecute(r0, r1 & 1) == false) goto L105;
        if (r2 == 0) goto L87;
        Modifier r18 = Modifier.Companion;
    L89:
        if ((r32 & 16) == 0) goto L91;
        Function0 r19 = null;
    L92:
        if (r4 == 0) goto L94;
        boolean r20 = true;
    L95:
        if (r6 != 0) goto L99;
        r17 = r7;
    L99:
        if (ComposerKt.isTraceInProgress() == false) goto L101;
        ComposerKt.traceEventStart(2055306788, r1, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:208)");
    L101:
        TooltipBox(r22, r23, r24, r18, null, r20, r17, false, r29, r15, (((((((r1 & 14) | 12607488) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (458752 & r1)) | (3670016 & r1)) | ((r1 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L104;
        ComposerKt.traceEventEnd();
    L104:
        r7 = r17;
        final Modifier r8 = r18;
        final Function0 r9 = r19;
        final boolean r10 = r20;
    L106:
        ScopeUpdateScope r11 = r15.endRestartGroup();
        if (r11 == null) goto L110;
        r11.updateScope(new yw(r22, r23, r24, r8, r9, r10, r7, r29, r31, r32));
        return;
    L110:
        return;
    L94:
        r20 = r5;
        goto L95
    L91:
        r19 = r26;
        goto L92
    L87:
        r18 = r3;
        goto L89
    L105:
        r15.skipToGroupEnd();
        r8 = r3;
        r10 = r5;
        r9 = r26;
        goto L106
    L82:
        r0 = false;
        goto L84
    L73:
        if ((r31 & 12582912) != 0) goto L79;
        if (r15.changedInstance(r29) == false) goto L77;
        int r12 = 8388608;
    L78:
        r1 = r1 | r12;
        goto L79
    L77:
        r12 = 4194304;
        goto L78
    L62:
        if ((1572864 & r31) != 0) goto L68;
        r7 = r28;
        if (r15.changed(r7) == false) goto L66;
        int r13 = 1048576;
    L67:
        r1 = r1 | r13;
        goto L70
    L66:
        r13 = 524288;
        goto L67
    L51:
        if ((196608 & r31) != 0) goto L57;
        r5 = r27;
        if (r15.changed(r5) == false) goto L55;
        int r14 = 131072;
    L56:
        r1 = r1 | r14;
        goto L58
    L55:
        r14 = 65536;
        goto L56
    L40:
        if ((r31 & 3072) != 0) goto L46;
        r3 = r25;
        if (r15.changed(r3) == false) goto L44;
        int r16 = 2048;
    L45:
        r1 = r1 | r16;
        goto L47
    L44:
        r16 = 1024;
        goto L45
    L27:
        if ((r31 & 384) != 0) goto L36;
        if ((r31 & 512) != 0) goto L31;
        boolean r21 = r15.changed(r24);
    L32:
        if (r21 == false) goto L34;
        int r33 = 256;
    L35:
        r1 = r1 | r33;
        goto L36
    L34:
        r33 = 128;
        goto L35
    L31:
        r21 = r15.changedInstance(r24);
        goto L32
    L17:
        if ((r31 & 48) != 0) goto L24;
        if (r15.changedInstance(r23) == false) goto L21;
        int r34 = 32;
    L22:
        r1 = r1 | r34;
        goto L24
    L21:
        r34 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r1 = r31;
        goto L14
    L8:
        if (r15.changed(r22) == false) goto L10;
        int r35 = 4;
    L11:
        r1 = r35 | r31;
        goto L14
    L10:
        r35 = 2;
        goto L11
    }

    public static final void TooltipBox(final PopupPositionProvider r24, final Function3<? super TooltipScope, ? super Composer, ? super Integer, Unit> r25, final TooltipState r26, Modifier r27, Function0<Unit> r28, boolean r29, boolean r30, boolean r31, final Function2<? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        Composer r9 = r33.startRestartGroup(-293753984);
        if ((r35 & 1) == 0) goto L6;
        int r1 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r35 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L36:
        int r3 = r35 & 8;
        if (r3 == 0) goto L40;
        r1 = r1 | 3072;
    L47:
        int r5 = r35 & 16;
        if (r5 == 0) goto L51;
        r1 = r1 | 24576;
    L58:
        int r7 = r35 & 32;
        if (r7 == 0) goto L62;
        r1 = r1 | 196608;
    L68:
        boolean r8 = r29;
    L69:
        int r16 = r35 & 64;
        if (r16 == 0) goto L73;
        r1 = r1 | 1572864;
    L79:
        int r0 = r35 & 128;
        if (r0 == 0) goto L83;
        r1 = r1 | 12582912;
    L90:
        if ((r35 & 256) == 0) goto L93;
        r1 = r1 | 100663296;
    L100:
        if ((38347923 & r1) == 38347922) goto L102;
        boolean r2 = true;
    L104:
        if (r9.shouldExecute(r2, r1 & 1) == false) goto L134;
        if (r3 == 0) goto L107;
        Modifier r19 = Modifier.Companion;
    L109:
        if (r5 == 0) goto L111;
        Function0<Unit> r20 = null;
    L112:
        if (r7 == 0) goto L114;
        boolean r21 = false;
    L115:
        if (r16 == 0) goto L117;
        boolean r17 = true;
    L118:
        if (r0 == 0) goto L120;
        boolean r22 = false;
    L122:
        if (ComposerKt.isTraceInProgress() == false) goto L124;
        ComposerKt.traceEventStart(-293753984, r1, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:309)");
    L124:
        final Transition r4 = TransitionKt.updateTransition(r26.getTransition(), "tooltip transition", r9, MutableTransitionState.$stable | 48, 0);
        Object r6 = r9.rememberedValue();
        Composer.Companion r10 = Composer.Companion;
        if (r6 != r10.getEmpty()) goto L127;
        r6 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r9.updateRememberedValue(r6);
    L127:
        final MutableState r11 = (MutableState) r6;
        Object r12 = r9.rememberedValue();
        if (r12 != r10.getEmpty()) goto L130;
        r12 = new TooltipScopeImpl(new dx(r11), r24);
        r9.updateRememberedValue(r12);
    L130:
        final TooltipScopeImpl r13 = (TooltipScopeImpl) r12;
        ComposableLambda r14 = ComposableLambdaKt.rememberComposableLambda(-23901870, true, new TooltipKt$TooltipBox$wrappedContent$1(r11, r32), r9, 54);
        Composer r23 = r9;
        BasicTooltipKt.BasicTooltipBox(r24, ComposableLambdaKt.rememberComposableLambda(-527401546, true, new AnonymousClass3(r4, r25, r13), r9, 54), r26, r19, r20, r21, r17, r22, r14, r9, (((((((r1 & 14) | 100663344) | (r1 & 896)) | (r1 & 7168)) | (57344 & r1)) | (458752 & r1)) | (3670016 & r1)) | (r1 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L133;
        ComposerKt.traceEventEnd();
    L133:
        final boolean r15 = r17;
        final Modifier r18 = r19;
        final Function0<Unit> r36 = r20;
        final boolean r37 = r21;
        final boolean r38 = r22;
    L135:
        ScopeUpdateScope r110 = r23.endRestartGroup();
        if (r110 == null) goto L139;
        r110.updateScope(new tw(r24, r25, r26, r18, r36, r37, r15, r38, r32, r34, r35));
        return;
    L139:
        return;
    L120:
        r22 = r31;
        goto L122
    L117:
        r17 = r30;
        goto L118
    L114:
        r21 = r8;
        goto L115
    L111:
        r20 = r28;
        goto L112
    L107:
        r19 = r27;
        goto L109
    L134:
        r23 = r9;
        r23.skipToGroupEnd();
        r18 = r27;
        r36 = r28;
        r15 = r30;
        r37 = r8;
        r38 = r31;
        goto L135
    L102:
        r2 = false;
        goto L104
    L93:
        if ((r34 & 100663296) != 0) goto L100;
        if (r9.changedInstance(r32) == false) goto L97;
        int r39 = 67108864;
    L98:
        r1 = r1 | r39;
        goto L100
    L97:
        r39 = 33554432;
        goto L98
    L83:
        if ((r34 & 12582912) != 0) goto L90;
        if (r9.changed(r31) == false) goto L87;
        int r111 = 8388608;
    L88:
        r1 = r1 | r111;
        goto L90
    L87:
        r111 = 4194304;
        goto L88
    L73:
        if ((r34 & 1572864) != 0) goto L79;
        if (r9.changed(r30) == false) goto L77;
        int r112 = 1048576;
    L78:
        r1 = r1 | r112;
        goto L79
    L77:
        r112 = 524288;
        goto L78
    L62:
        if ((196608 & r34) != 0) goto L68;
        r8 = r29;
        if (r9.changed(r8) == false) goto L66;
        int r113 = 131072;
    L67:
        r1 = r1 | r113;
        goto L69
    L66:
        r113 = 65536;
        goto L67
    L51:
        if ((r34 & 24576) != 0) goto L58;
        if (r9.changedInstance(r28) == false) goto L55;
        int r40 = 16384;
    L56:
        r1 = r1 | r40;
        goto L58
    L55:
        r40 = 8192;
        goto L56
    L40:
        if ((r34 & 3072) != 0) goto L47;
        if (r9.changed(r27) == false) goto L44;
        int r41 = 2048;
    L45:
        r1 = r1 | r41;
        goto L47
    L44:
        r41 = 1024;
        goto L45
    L27:
        if ((r34 & 384) != 0) goto L36;
        if ((r34 & 512) != 0) goto L31;
        boolean r42 = r9.changed(r26);
    L32:
        if (r42 == false) goto L34;
        int r43 = 256;
    L35:
        r1 = r1 | r43;
        goto L36
    L34:
        r43 = 128;
        goto L35
    L31:
        r42 = r9.changedInstance(r26);
        goto L32
    L17:
        if ((r34 & 48) != 0) goto L24;
        if (r9.changedInstance(r25) == false) goto L21;
        int r44 = 32;
    L22:
        r1 = r1 | r44;
        goto L24
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r1 = r34;
        goto L14
    L8:
        if (r9.changed(r24) == false) goto L10;
        int r45 = 4;
    L11:
        r1 = r45 | r34;
        goto L14
    L10:
        r45 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: PlainTooltip-gv3ox5I, reason: not valid java name */
    public static final void m3555PlainTooltipgv3ox5I(final TooltipScope r33, Modifier r34, Shape r35, float r36, Shape r37, long r38, long r40, float r42, float r43, final Function2<? super Composer, ? super Integer, Unit> r44, Composer r45, final int r46, final int r47) {
        Composer r2 = r45.startRestartGroup(-343758958);
        if ((Integer.MIN_VALUE & r47) == 0) goto L6;
        int r3 = r46 | 6;
    L16:
        int r6 = r47 & 1;
        if (r6 == 0) goto L20;
        r3 = r3 | 48;
    L26:
        Modifier r7 = r34;
    L27:
        int r8 = r47 & 2;
        if (r8 == 0) goto L31;
        r3 = r3 | 384;
    L37:
        Shape r10 = r35;
    L38:
        int r11 = r47 & 4;
        if (r11 == 0) goto L42;
        r3 = r3 | 3072;
    L48:
        float r15 = r36;
    L50:
        if ((r46 & 24576) == 0) goto L52;
        Shape r9 = r37;
    L61:
        if ((r46 & 196608) != 0) goto L71;
        if ((r47 & 16) == 0) goto L65;
    L67:
        int r19 = 65536;
    L68:
        r3 = r3 | r19;
        goto L71
    L65:
        if (r2.changed(r38) == false) goto L67;
        r19 = 131072;
    L71:
        if ((r46 & 1572864) != 0) goto L80;
        if ((r47 & 32) == 0) goto L75;
    L77:
        int r20 = 524288;
    L78:
        r3 = r3 | r20;
        goto L80
    L75:
        if (r2.changed(r40) == false) goto L77;
        r20 = 1048576;
    L80:
        int r21 = r47 & 64;
        if (r21 == 0) goto L84;
        r3 = r3 | 12582912;
    L90:
        int r1 = r47 & 128;
        if (r1 == 0) goto L94;
        r3 = r3 | 100663296;
    L101:
        if ((r47 & 256) == 0) goto L104;
        r3 = r3 | 805306368;
    L111:
        if ((306783379 & r3) == 306783378) goto L113;
        boolean r0 = true;
    L115:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L203;
        r2.startDefaults();
        if ((r46 & 1) != 0) goto L119;
    L131:
        if (r6 == 0) goto L133;
        r7 = Modifier.Companion;
    L133:
        if (r8 == 0) goto L135;
        r10 = null;
    L135:
        if (r11 == 0) goto L138;
        r15 = TooltipDefaults.INSTANCE.m3545getPlainTooltipMaxWidthD9Ej5fM();
    L138:
        if ((r47 & 8) == 0) goto L141;
        r3 = r3 & (-57345);
        r9 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(r2, 6);
    L141:
        if ((r47 & 16) == 0) goto L143;
        long r25 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(r2, 6);
        r3 = r3 & (-458753);
    L145:
        if ((r47 & 32) == 0) goto L147;
        long r27 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(r2, 6);
        r3 = (-3670017) & r3;
    L149:
        if (r21 == 0) goto L151;
        float r4 = Dp.constructor-impl(0);
    L152:
        if (r1 == 0) goto L154;
        float r12 = Dp.constructor-impl(0);
    L155:
        int r13 = r3;
        float r14 = r4;
        final float r5 = r15;
        final long r16 = r25;
        long r28 = r27;
    L156:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L159;
        ComposerKt.traceEventStart(-343758958, r13, -1, "androidx.compose.material3.PlainTooltip (Tooltip.kt:430)");
    L159:
        if (r10 == null) goto L198;
        r2.startReplaceGroup(-1720477287);
        Object r17 = r2.rememberedValue();
        Composer.Companion r18 = Composer.Companion;
        if (r17 != r18.getEmpty()) goto L164;
        r17 = SnapshotStateKt.mutableStateOf$default(Matrix.box-impl(Matrix.constructor-impl$default(null, 1, null)), null, 2, null);
        r2.updateRememberedValue(r17);
    L164:
        MutableState r22 = (MutableState) r17;
        Density r110 = (Density) r2.consume(CompositionLocalsKt.getLocalDensity());
        long r111 = ((WindowInfo) r2.consume(CompositionLocalsKt.getLocalWindowInfo())).getContainerSize-YbymL2g();
        Modifier.Companion r112 = Modifier.Companion;
        if ((r13 & 14) != 4) goto L167;
        final TooltipScope r23 = r33;
    L174:
        boolean r113 = true;
    L175:
        Object r24 = r2.rememberedValue();
        if (r113 == false) goto L178;
    L179:
        r24 = new ww(r23);
        r2.updateRememberedValue(r24);
    L180:
        Modifier r26 = m3559layoutCaretJ5j9r9c(r112, r22, r110, r111, (Function1) r24, r33.obtainPositionProvider()).then(r7);
        if (((57344 & r13) ^ 24576) <= 16384) goto L185;
        if (r2.changed(r9) == false) goto L185;
    L186:
        boolean r114 = true;
    L189:
        if ((r13 & 896) != 256) goto L191;
        boolean r29 = true;
    L192:
        boolean r115 = r114 | r29;
        Object r116 = r2.rememberedValue();
        if (r115 == false) goto L195;
    L196:
        r116 = new TooltipCaretShape(r22, r9, r10);
        r2.updateRememberedValue(r116);
    L197:
        r2.endReplaceGroup();
        Modifier r117 = r26;
        Shape r118 = (TooltipCaretShape) r116;
    L199:
        int r30 = r13 >> 9;
        SurfaceKt.m3213SurfaceT9BRK9s(r117, r118, r28, 0, r14, r12, null, ComposableLambdaKt.rememberComposableLambda(-1573998995, true, new TooltipKt$PlainTooltip$4(r5, r16, r44), r2, 54), r2, ((((r13 >> 12) & 896) | 12582912) | (57344 & r30)) | (r30 & 458752), 72);
        if (ComposerKt.isTraceInProgress() == false) goto L202;
        ComposerKt.traceEventEnd();
    L202:
        float r119 = r12;
        float r120 = r14;
        final Shape r31 = r9;
        long r32 = r16;
        final float r39 = r5;
        final Shape r41 = r10;
        long r48 = r32;
    L204:
        ScopeUpdateScope r121 = r2.endRestartGroup();
        if (r121 == null) goto L208;
        final Modifier r49 = r7;
        final long r50 = r48;
        final long r51 = r28;
        final float r122 = r120;
        final float r123 = r119;
        r121.updateScope(new xw(r33, r49, r41, r39, r31, r50, r51, r122, r123, r44, r46, r47));
        return;
    L208:
        return;
    L195:
        if (r116 != r18.getEmpty()) goto L197;
    L191:
        r29 = false;
    L185:
        if ((r13 & 24576) == 16384) goto L186;
        r114 = false;
        goto L189
    L178:
        if (r24 != r18.getEmpty()) goto L180;
    L167:
        if ((r13 & 8) == 0) goto L171;
        r23 = r33;
        if (r2.changedInstance(r23) == true) goto L174;
    L172:
        r113 = false;
        goto L175
    L171:
        r23 = r33;
        goto L172
    L198:
        r14 = r14;
        r2.startReplaceGroup(-1719831991);
        r2.endReplaceGroup();
        r117 = r7;
        r118 = r9;
        goto L199
    L154:
        r12 = r43;
        goto L155
    L151:
        r4 = r42;
        goto L152
    L147:
        r27 = r40;
        goto L149
    L143:
        r25 = r38;
        goto L145
    L119:
        if (r2.getDefaultsInvalid() == true) goto L131;
        r2.skipToGroupEnd();
        if ((r47 & 8) == 0) goto L125;
        r3 = r3 & (-57345);
    L125:
        if ((r47 & 16) == 0) goto L128;
        r3 = r3 & (-458753);
    L128:
        if ((r47 & 32) == 0) goto L130;
        r3 = r3 & (-3670017);
    L130:
        r28 = r40;
        r14 = r42;
        r12 = r43;
        r13 = r3;
        r5 = r15;
        r16 = r38;
        goto L156
    L203:
        r2.skipToGroupEnd();
        r28 = r40;
        r120 = r42;
        r119 = r43;
        r31 = r9;
        r41 = r10;
        r39 = r15;
        r48 = r38;
        goto L204
    L113:
        r0 = false;
        goto L115
    L104:
        if ((r46 & 805306368) != 0) goto L111;
        if (r2.changedInstance(r44) == false) goto L108;
        int r52 = 536870912;
    L109:
        r3 = r3 | r52;
        goto L111
    L108:
        r52 = 268435456;
        goto L109
    L94:
        if ((r46 & 100663296) != 0) goto L101;
        if (r2.changed(r43) == false) goto L98;
        int r210 = 67108864;
    L99:
        r3 = r3 | r210;
        goto L101
    L98:
        r210 = 33554432;
        goto L99
    L84:
        if ((r46 & 12582912) != 0) goto L90;
        if (r2.changed(r42) == false) goto L88;
        int r53 = 8388608;
    L89:
        r3 = r3 | r53;
        goto L90
    L88:
        r53 = 4194304;
        goto L89
    L52:
        if ((r47 & 8) != 0) goto L56;
        r9 = r37;
        if (r2.changed(r9) == false) goto L57;
        int r124 = 16384;
    L58:
        r3 = r3 | r124;
    L57:
        r124 = 8192;
        goto L58
    L56:
        r9 = r37;
        goto L57
    L42:
        if ((r46 & 3072) != 0) goto L48;
        r15 = r36;
        if (r2.changed(r15) == false) goto L46;
        int r125 = 2048;
    L47:
        r3 = r3 | r125;
        goto L50
    L46:
        r125 = 1024;
        goto L47
    L31:
        if ((r46 & 384) != 0) goto L37;
        r10 = r35;
        if (r2.changed(r10) == false) goto L35;
        int r126 = 256;
    L36:
        r3 = r3 | r126;
        goto L38
    L35:
        r126 = 128;
        goto L36
    L20:
        if ((r46 & 48) != 0) goto L26;
        r7 = r34;
        if (r2.changed(r7) == false) goto L24;
        int r54 = 32;
    L25:
        r3 = r3 | r54;
        goto L27
    L24:
        r54 = 16;
        goto L25
    L6:
        if ((r46 & 6) == 0) goto L8;
        r3 = r46;
        goto L16
    L8:
        if ((r46 & 8) != 0) goto L10;
        boolean r55 = r2.changed(r33);
    L11:
        if (r55 == false) goto L13;
        int r56 = 4;
    L14:
        r3 = r56 | r46;
        goto L16
    L13:
        r56 = 2;
        goto L14
    L10:
        r55 = r2.changedInstance(r33);
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: PlainTooltip-m9Er-Xc, reason: not valid java name */
    public static final /* synthetic */ void m3556PlainTooltipm9ErXc(final TooltipScope r32, Modifier r33, long r34, float r36, Shape r37, long r38, long r40, float r42, float r43, final Function2 r44, Composer r45, final int r46, final int r47) {
        Composer r12 = r45.startRestartGroup(-1881241092);
        if ((Integer.MIN_VALUE & r47) == 0) goto L6;
        int r1 = r46 | 6;
    L16:
        int r2 = r47 & 1;
        if (r2 == 0) goto L20;
        r1 = r1 | 48;
    L28:
        if ((r46 & 384) != 0) goto L38;
        if ((r47 & 2) != 0) goto L35;
        if (r12.changed(r34) == false) goto L35;
        int r6 = 256;
    L36:
        r1 = r1 | r6;
    L35:
        r6 = 128;
    L38:
        int r7 = r47 & 4;
        if (r7 == 0) goto L42;
        r1 = r1 | 3072;
    L48:
        float r8 = r36;
    L50:
        if ((r46 & 24576) == 0) goto L52;
        Shape r9 = r37;
    L61:
        if ((196608 & r46) == 0) goto L63;
        long r10 = r38;
    L72:
        if ((1572864 & r46) != 0) goto L80;
        int r48 = r1;
        if ((r47 & 32) == 0) goto L76;
    L78:
        int r16 = 524288;
    L79:
        int r17 = r48 | r16;
    L81:
        int r18 = r47 & 64;
        if (r18 == 0) goto L84;
        r17 = r17 | 12582912;
        final float r11 = r42;
    L91:
        int r0 = r47 & 128;
        if (r0 == 0) goto L95;
        r17 = r17 | 100663296;
    L102:
        int r19 = 805306368;
        if ((r47 & 256) == 0) goto L106;
    L104:
        r17 = r17 | r19;
    L112:
        int r3 = r17;
        if ((r3 & 306783379) == 306783378) goto L115;
        boolean r4 = true;
    L117:
        if (r12.shouldExecute(r4, r3 & 1) == false) goto L172;
        r12.startDefaults();
        if ((r46 & 1) != 0) goto L121;
    L136:
        if (r2 == 0) goto L138;
        Modifier r5 = Modifier.Companion;
    L140:
        if ((r47 & 2) == 0) goto L142;
        long r110 = DpSize.Companion.getUnspecified-MYxV2XQ();
        r3 = r3 & (-897);
    L143:
        if (r7 == 0) goto L145;
        float r13 = TooltipDefaults.INSTANCE.m3545getPlainTooltipMaxWidthD9Ej5fM();
    L147:
        if ((r47 & 8) == 0) goto L149;
        Shape r14 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape(r12, 6);
        r3 = r3 & (-57345);
    L151:
        if ((r47 & 16) == 0) goto L153;
        long r15 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(r12, 6);
        r3 = r3 & (-458753);
    L155:
        if ((r47 & 32) == 0) goto L157;
        long r21 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(r12, 6);
        r3 = r3 & (-3670017);
    L158:
        if (r18 == 0) goto L160;
        float r20 = Dp.constructor-impl(0);
    L161:
        if (r0 == 0) goto L163;
        float r24 = Dp.constructor-impl(0);
    L164:
        Modifier r111 = r5;
        float r112 = r13;
        float r23 = r20;
        Shape r113 = r14;
        long r114 = r110;
        long r115 = r15;
    L165:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L168;
        ComposerKt.traceEventStart(-1881241092, r3, -1, "androidx.compose.material3.PlainTooltip (Tooltip.kt:389)");
    L168:
        long r27 = r114;
        Composer r29 = r12;
        m3555PlainTooltipgv3ox5I(r32, r111, TooltipDefaults.INSTANCE.m3543caretShapeEaSLcWc(r114), r112, r113, r115, r21, r23, r24, r44, r12, ((((((((r3 & 14) | (r3 & 112)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3)) | (234881024 & r3)) | (r3 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L171;
        ComposerKt.traceEventEnd();
    L171:
        final Modifier r22 = r111;
        final float r25 = r112;
        final Shape r26 = r113;
        final long r28 = r115;
        final long r30 = r21;
        r11 = r23;
        final float r116 = r24;
        final long r31 = r27;
    L173:
        ScopeUpdateScope r117 = r29.endRestartGroup();
        if (r117 == null) goto L177;
        r117.updateScope(new zw(r32, r22, r31, r25, r26, r28, r30, r11, r116, r44, r46, r47));
        return;
    L177:
        return;
    L163:
        r24 = r43;
        goto L164
    L160:
        r20 = r11;
        goto L161
    L157:
        r21 = r40;
        goto L158
    L153:
        r15 = r10;
        goto L155
    L149:
        r14 = r9;
        goto L151
    L145:
        r13 = r8;
        goto L147
    L142:
        r110 = r34;
        goto L143
    L138:
        r5 = r33;
        goto L140
    L121:
        if (r12.getDefaultsInvalid() == true) goto L136;
        r12.skipToGroupEnd();
        if ((r47 & 2) == 0) goto L127;
        r3 = r3 & (-897);
    L127:
        if ((r47 & 8) == 0) goto L130;
        r3 = r3 & (-57345);
    L130:
        if ((r47 & 16) == 0) goto L133;
        r3 = r3 & (-458753);
    L133:
        if ((r47 & 32) == 0) goto L135;
        r3 = r3 & (-3670017);
    L135:
        r111 = r33;
        r21 = r40;
        r24 = r43;
        r112 = r8;
        r113 = r9;
        r115 = r10;
        r23 = r11;
        r114 = r34;
        goto L165
    L172:
        r29 = r12;
        r29.skipToGroupEnd();
        r22 = r33;
        r31 = r34;
        r116 = r43;
        r25 = r8;
        r26 = r9;
        r28 = r10;
        r30 = r40;
        goto L173
    L115:
        r4 = false;
        goto L117
    L106:
        if ((r46 & 805306368) != 0) goto L112;
        if (r12.changedInstance(r44) == false) goto L110;
        r19 = 536870912;
        goto L104
    L110:
        r19 = 268435456;
        goto L104
    L95:
        if ((100663296 & r46) != 0) goto L102;
        if (r12.changed(r43) == false) goto L99;
        int r118 = 67108864;
    L100:
        r17 = r17 | r118;
        goto L102
    L99:
        r118 = 33554432;
        goto L100
    L84:
        r11 = r42;
        if ((r46 & 12582912) != 0) goto L91;
        if (r12.changed(r11) == false) goto L89;
        int r119 = 8388608;
    L90:
        r17 = r17 | r119;
        goto L91
    L89:
        r119 = 4194304;
        goto L90
    L76:
        if (r12.changed(r40) == false) goto L78;
        r16 = 1048576;
        goto L79
    L80:
        r17 = r1;
        goto L81
    L63:
        if ((r47 & 16) != 0) goto L67;
        r10 = r38;
        if (r12.changed(r10) == false) goto L68;
        int r120 = 131072;
    L69:
        r1 = r1 | r120;
    L68:
        r120 = 65536;
        goto L69
    L67:
        r10 = r38;
        goto L68
    L52:
        if ((r47 & 8) != 0) goto L56;
        r9 = r37;
        if (r12.changed(r9) == false) goto L57;
        int r35 = 16384;
    L58:
        r1 = r1 | r35;
    L57:
        r35 = 8192;
        goto L58
    L56:
        r9 = r37;
        goto L57
    L42:
        if ((r46 & 3072) != 0) goto L48;
        r8 = r36;
        if (r12.changed(r8) == false) goto L46;
        int r39 = 2048;
    L47:
        r1 = r1 | r39;
        goto L50
    L46:
        r39 = 1024;
        goto L47
    L20:
        if ((r46 & 48) != 0) goto L28;
        if (r12.changed(r33) == false) goto L24;
        int r41 = 32;
    L25:
        r1 = r1 | r41;
        goto L28
    L24:
        r41 = 16;
        goto L25
    L6:
        if ((r46 & 6) == 0) goto L8;
        r1 = r46;
        goto L16
    L8:
        if ((r46 & 8) != 0) goto L10;
        boolean r49 = r12.changed(r32);
    L11:
        if (r49 == false) goto L13;
        int r50 = 4;
    L14:
        r1 = r50 | r46;
        goto L16
    L13:
        r50 = 2;
        goto L14
    L10:
        r49 = r12.changedInstance(r32);
        goto L11
    }

    /* JADX INFO: renamed from: RichTooltip-EkvW5A0, reason: not valid java name */
    public static final void m3557RichTooltipEkvW5A0(final TooltipScope r31, Modifier r32, Function2<? super Composer, ? super Integer, Unit> r33, Function2<? super Composer, ? super Integer, Unit> r34, Shape r35, float r36, Shape r37, RichTooltipColors r38, float r39, float r40, final Function2<? super Composer, ? super Integer, Unit> r41, Composer r42, final int r43, final int r44, final int r45) {
        Composer r2 = r42.startRestartGroup(236290785);
        if ((Integer.MIN_VALUE & r45) == 0) goto L6;
        int r3 = r43 | 6;
    L16:
        int r6 = r45 & 1;
        if (r6 == 0) goto L20;
        r3 = r3 | 48;
    L27:
        int r8 = r45 & 2;
        if (r8 == 0) goto L31;
        r3 = r3 | 384;
    L38:
        int r10 = r45 & 4;
        if (r10 == 0) goto L42;
        r3 = r3 | 3072;
    L49:
        int r15 = r45 & 8;
        if (r15 == 0) goto L53;
        r3 = r3 | 24576;
    L60:
        int r17 = r45 & 16;
        if (r17 == 0) goto L64;
        r3 = r3 | 196608;
    L71:
        if ((r43 & 1572864) != 0) goto L81;
        if ((r45 & 32) == 0) goto L75;
    L77:
        int r22 = 524288;
    L78:
        r3 = r3 | r22;
        goto L81
    L75:
        if (r2.changed(r37) == false) goto L77;
        r22 = 1048576;
    L81:
        if ((r43 & 12582912) != 0) goto L90;
        if ((r45 & 64) == 0) goto L85;
    L87:
        int r23 = 4194304;
    L88:
        r3 = r3 | r23;
        goto L90
    L85:
        if (r2.changed(r38) == false) goto L87;
        r23 = 8388608;
    L90:
        int r0 = r45 & 128;
        if (r0 == 0) goto L94;
        r3 = r3 | 100663296;
    L100:
        int r4 = r45 & 256;
        if (r4 == 0) goto L104;
        r3 = r3 | 805306368;
    L111:
        if ((r45 & 512) == 0) goto L114;
        int r5 = r44 | 6;
    L121:
        boolean r24 = false;
        if ((r3 & 306783379) == 306783378) goto L124;
    L127:
        boolean r7 = true;
    L129:
        if (r2.shouldExecute(r7, r3 & 1) == false) goto L216;
        r2.startDefaults();
        if ((r43 & 1) != 0) goto L133;
    L142:
        if (r6 == 0) goto L144;
        Modifier r9 = Modifier.Companion;
    L145:
        if (r8 == 0) goto L147;
        Function2<? super Composer, ? super Integer, Unit> r11 = null;
    L148:
        if (r10 == 0) goto L150;
        final Function2<? super Composer, ? super Integer, Unit> r12 = null;
    L151:
        if (r15 == 0) goto L153;
        Shape r13 = null;
    L154:
        if (r17 == 0) goto L156;
        float r16 = TooltipDefaults.INSTANCE.m3546getRichTooltipMaxWidthD9Ej5fM();
    L158:
        if ((r45 & 32) == 0) goto L160;
        Shape r14 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(r2, 6);
        r3 = r3 & (-3670017);
    L161:
        Modifier r310 = r9;
        if ((r45 & 64) == 0) goto L164;
        final RichTooltipColors r18 = TooltipDefaults.INSTANCE.richTooltipColors(r2, 6);
        r3 = r3 & (-29360129);
    L165:
        if (r0 == 0) goto L167;
        float r1 = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
    L168:
        if (r4 == 0) goto L170;
        float r19 = RichTooltipTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L171:
        float r20 = r1;
        Modifier r21 = r310;
        float r30 = r16;
        int r110 = r3;
        float r25 = r30;
    L172:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L175;
        ComposerKt.traceEventStart(236290785, r110, r5, "androidx.compose.material3.RichTooltip (Tooltip.kt:542)");
    L175:
        if (r13 == null) goto L211;
        r2.startReplaceGroup(-111951894);
        Object r26 = r2.rememberedValue();
        Composer.Companion r111 = Composer.Companion;
        if (r26 != r111.getEmpty()) goto L180;
        r26 = SnapshotStateKt.mutableStateOf$default(Matrix.box-impl(Matrix.constructor-impl$default(null, 1, null)), null, 2, null);
        r2.updateRememberedValue(r26);
    L180:
        MutableState r27 = (MutableState) r26;
        Density r28 = (Density) r2.consume(CompositionLocalsKt.getLocalDensity());
        long r29 = ((WindowInfo) r2.consume(CompositionLocalsKt.getLocalWindowInfo())).getContainerSize-YbymL2g();
        Modifier.Companion r112 = Modifier.Companion;
        if ((r110 & 14) != 4) goto L183;
    L188:
        boolean r46 = true;
    L189:
        Object r47 = r2.rememberedValue();
        if (r46 == false) goto L192;
    L193:
        r47 = new ax(r31);
        r2.updateRememberedValue(r47);
    L194:
        Modifier r48 = m3559layoutCaretJ5j9r9c(r112, r27, r28, r29, (Function1) r47, r31.obtainPositionProvider()).then(r21);
        if (((3670016 & r110) ^ 1572864) <= 1048576) goto L199;
        if (r2.changed(r14) == false) goto L199;
    L200:
        boolean r49 = true;
    L203:
        if ((57344 & r110) != 16384) goto L205;
        r24 = true;
    L205:
        boolean r50 = r49 | r24;
        Object r51 = r2.rememberedValue();
        if (r50 == false) goto L208;
    L209:
        r51 = new TooltipCaretShape(r27, r14, r13);
        r2.updateRememberedValue(r51);
    L210:
        r2.endReplaceGroup();
        Shape r113 = (TooltipCaretShape) r51;
    L212:
        Modifier r311 = r48;
        Modifier r52 = SizeKt.m1018sizeInqDBjuR0$default(r311, TooltipMinWidth, TooltipMinHeight, r25, MenuKt.ClosedAlphaTarget, 8, null);
        long r114 = r18.m3026getContainerColor0d7_KjU();
        final Function2<? super Composer, ? super Integer, Unit> r53 = r11;
        ComposableLambda r210 = ComposableLambdaKt.rememberComposableLambda(-1249811482, true, new TooltipKt$RichTooltip$4(r53, r12, r18, r41), r2, 54);
        int r54 = r110 >> 12;
        float r211 = r20;
        float r212 = r19;
        SurfaceKt.m3213SurfaceT9BRK9s(r52, r113, r114, 0, r211, r212, null, r210, r2, ((57344 & r54) | 12582912) | (r54 & 458752), 72);
        if (ComposerKt.isTraceInProgress() == false) goto L215;
        ComposerKt.traceEventEnd();
    L215:
        final float r55 = r20;
        final Function2<? super Composer, ? super Integer, Unit> r56 = r12;
        final Shape r57 = r13;
        final float r115 = r19;
        final RichTooltipColors r58 = r18;
        final float r59 = r25;
        Modifier r60 = r21;
    L217:
        ScopeUpdateScope r116 = r2.endRestartGroup();
        if (r116 == null) goto L221;
        final Modifier r61 = r60;
        final Function2<? super Composer, ? super Integer, Unit> r62 = r53;
        final Shape r63 = r14;
        r116.updateScope(new bx(r31, r61, r62, r56, r57, r59, r63, r58, r55, r115, r41, r43, r44, r45));
        return;
    L221:
        return;
    L208:
        if (r51 != r111.getEmpty()) goto L210;
    L199:
        if ((r110 & 1572864) == 1048576) goto L200;
        r49 = false;
        goto L203
    L192:
        if (r47 != r111.getEmpty()) goto L194;
    L183:
        if ((r110 & 8) != 0) goto L185;
    L187:
        r46 = false;
        goto L189
    L185:
        if (r2.changedInstance(r31) == false) goto L187;
    L211:
        r19 = r19;
        r2.startReplaceGroup(-111306598);
        r2.endReplaceGroup();
        r48 = r21;
        r113 = r14;
        goto L212
    L170:
        r19 = r40;
        goto L171
    L167:
        r1 = r39;
        goto L168
    L164:
        r18 = r38;
        goto L165
    L160:
        r14 = r37;
        goto L161
    L156:
        r16 = r36;
        goto L158
    L153:
        r13 = r35;
        goto L154
    L150:
        r12 = r34;
        goto L151
    L147:
        r11 = r33;
        goto L148
    L144:
        r9 = r32;
        goto L145
    L133:
        if (r2.getDefaultsInvalid() == true) goto L142;
        r2.skipToGroupEnd();
        if ((r45 & 32) == 0) goto L139;
        r3 = r3 & (-3670017);
    L139:
        if ((r45 & 64) == 0) goto L141;
        r3 = r3 & (-29360129);
    L141:
        r21 = r32;
        r11 = r33;
        r12 = r34;
        r13 = r35;
        r14 = r37;
        r18 = r38;
        r20 = r39;
        r19 = r40;
        r110 = r3;
        r25 = r36;
        goto L172
    L216:
        r2.skipToGroupEnd();
        r60 = r32;
        r53 = r33;
        r56 = r34;
        r57 = r35;
        r59 = r36;
        r14 = r37;
        r58 = r38;
        r55 = r39;
        r115 = r40;
        goto L217
    L124:
        if ((r5 & 3) != 2) goto L127;
        r7 = false;
        goto L129
    L114:
        if ((r44 & 6) == 0) goto L116;
        r5 = r44;
        goto L121
    L116:
        if (r2.changedInstance(r41) == false) goto L118;
        int r64 = 4;
    L119:
        r5 = r44 | r64;
        goto L121
    L118:
        r64 = 2;
        goto L119
    L104:
        if ((r43 & 805306368) != 0) goto L111;
        if (r2.changed(r40) == false) goto L108;
        int r213 = 536870912;
    L109:
        r3 = r3 | r213;
        goto L111
    L108:
        r213 = 268435456;
        goto L109
    L94:
        if ((r43 & 100663296) != 0) goto L100;
        if (r2.changed(r39) == false) goto L98;
        int r214 = 67108864;
    L99:
        r3 = r3 | r214;
        goto L100
    L98:
        r214 = 33554432;
        goto L99
    L64:
        if ((r43 & 196608) != 0) goto L71;
        if (r2.changed(r36) == false) goto L68;
        int r117 = 131072;
    L69:
        r3 = r3 | r117;
        goto L71
    L68:
        r117 = 65536;
        goto L69
    L53:
        if ((r43 & 24576) != 0) goto L60;
        if (r2.changed(r35) == false) goto L57;
        int r118 = 16384;
    L58:
        r3 = r3 | r118;
        goto L60
    L57:
        r118 = 8192;
        goto L58
    L42:
        if ((r43 & 3072) != 0) goto L49;
        if (r2.changedInstance(r34) == false) goto L46;
        int r119 = 2048;
    L47:
        r3 = r3 | r119;
        goto L49
    L46:
        r119 = 1024;
        goto L47
    L31:
        if ((r43 & 384) != 0) goto L38;
        if (r2.changedInstance(r33) == false) goto L35;
        int r120 = 256;
    L36:
        r3 = r3 | r120;
        goto L38
    L35:
        r120 = 128;
        goto L36
    L20:
        if ((r43 & 48) != 0) goto L27;
        if (r2.changed(r32) == false) goto L24;
        int r65 = 32;
    L25:
        r3 = r3 | r65;
        goto L27
    L24:
        r65 = 16;
        goto L25
    L6:
        if ((r43 & 6) == 0) goto L8;
        r3 = r43;
        goto L16
    L8:
        if ((r43 & 8) != 0) goto L10;
        boolean r66 = r2.changed(r31);
    L11:
        if (r66 == false) goto L13;
        int r67 = 4;
    L14:
        r3 = r67 | r43;
        goto L16
    L13:
        r67 = 2;
        goto L14
    L10:
        r66 = r2.changedInstance(r31);
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: RichTooltip-ZuUcA3Q, reason: not valid java name */
    public static final /* synthetic */ void m3558RichTooltipZuUcA3Q(final TooltipScope r32, Modifier r33, Function2 r34, Function2 r35, long r36, float r38, Shape r39, RichTooltipColors r40, float r41, float r42, final Function2 r43, Composer r44, final int r45, final int r46, final int r47) {
        Composer r12 = r44.startRestartGroup(-2125725529);
        if ((Integer.MIN_VALUE & r47) == 0) goto L6;
        int r1 = r45 | 6;
    L16:
        int r4 = r47 & 1;
        if (r4 == 0) goto L20;
        r1 = r1 | 48;
    L27:
        int r6 = r47 & 2;
        if (r6 == 0) goto L31;
        r1 = r1 | 384;
    L38:
        int r8 = r47 & 4;
        if (r8 == 0) goto L42;
        r1 = r1 | 3072;
    L48:
        Function2 r9 = r35;
    L50:
        if ((r45 & 24576) == 0) goto L52;
        long r10 = r36;
    L60:
        int r16 = r47 & 16;
        if (r16 == 0) goto L64;
        r1 = r1 | 196608;
    L71:
        if ((r45 & 1572864) != 0) goto L81;
        if ((r47 & 32) == 0) goto L75;
    L77:
        int r18 = 524288;
    L78:
        r1 = r1 | r18;
        goto L81
    L75:
        if (r12.changed(r39) == false) goto L77;
        r18 = 1048576;
    L81:
        if ((r45 & 12582912) != 0) goto L90;
        if ((r47 & 64) == 0) goto L85;
    L87:
        int r19 = 4194304;
    L88:
        r1 = r1 | r19;
        goto L90
    L85:
        if (r12.changed(r40) == false) goto L87;
        r19 = 8388608;
    L90:
        int r0 = r47 & 128;
        if (r0 == 0) goto L94;
        r1 = r1 | 100663296;
    L100:
        int r2 = r47 & 256;
        if (r2 == 0) goto L104;
        r1 = r1 | 805306368;
    L111:
        if ((r47 & 512) == 0) goto L114;
        int r3 = r46 | 6;
    L122:
        if ((r1 & 306783379) == 306783378) goto L124;
    L127:
        boolean r5 = true;
    L129:
        if (r12.shouldExecute(r5, r1 & 1) == false) goto L184;
        r12.startDefaults();
        if ((r45 & 1) != 0) goto L133;
    L145:
        if (r4 == 0) goto L147;
        Modifier r7 = Modifier.Companion;
    L148:
        Function2 r11 = null;
        if (r6 == 0) goto L151;
        Function2 r13 = null;
    L152:
        if (r8 != 0) goto L156;
        r11 = r9;
    L156:
        if ((r47 & 8) == 0) goto L158;
        long r14 = DpSize.Companion.getUnspecified-MYxV2XQ();
        r1 = r1 & (-57345);
    L159:
        if (r16 == 0) goto L161;
        float r15 = TooltipDefaults.INSTANCE.m3546getRichTooltipMaxWidthD9Ej5fM();
    L163:
        if ((r47 & 32) == 0) goto L165;
        Shape r17 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(r12, 6);
        r1 = r1 & (-3670017);
    L166:
        Modifier r37 = r7;
        if ((r47 & 64) == 0) goto L169;
        RichTooltipColors r20 = TooltipDefaults.INSTANCE.richTooltipColors(r12, 6);
        r1 = r1 & (-29360129);
    L170:
        if (r0 == 0) goto L172;
        float r21 = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
    L173:
        if (r2 == 0) goto L175;
        float r24 = RichTooltipTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L176:
        RichTooltipColors r22 = r20;
        Function2 r110 = r11;
        Function2 r111 = r13;
        float r23 = r15;
        Shape r25 = r17;
        r10 = r14;
    L177:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L180;
        ComposerKt.traceEventStart(-2125725529, r1, r3, "androidx.compose.material3.RichTooltip (Tooltip.kt:497)");
    L180:
        long r27 = r10;
        Composer r29 = r12;
        m3557RichTooltipEkvW5A0(r32, r37, r111, r110, TooltipDefaults.INSTANCE.m3543caretShapeEaSLcWc(r10), r23, r25, r22, r21, r24, r43, r12, ((((((((r1 & 14) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (458752 & r1)) | (3670016 & r1)) | (29360128 & r1)) | (234881024 & r1)) | (r1 & 1879048192), r3 & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L183;
        ComposerKt.traceEventEnd();
    L183:
        final Modifier r26 = r37;
        final Function2 r28 = r111;
        final Function2 r30 = r110;
        final float r31 = r23;
        final Shape r48 = r25;
        final RichTooltipColors r49 = r22;
        final float r112 = r21;
        final float r113 = r24;
        final long r50 = r27;
    L185:
        ScopeUpdateScope r114 = r29.endRestartGroup();
        if (r114 == null) goto L189;
        r114.updateScope(new cx(r32, r26, r28, r30, r50, r31, r48, r49, r112, r113, r43, r45, r46, r47));
        return;
    L189:
        return;
    L175:
        r24 = r42;
        goto L176
    L172:
        r21 = r41;
        goto L173
    L169:
        r20 = r40;
        goto L170
    L165:
        r17 = r39;
        goto L166
    L161:
        r15 = r38;
        goto L163
    L158:
        r14 = r10;
        goto L159
    L151:
        r13 = r34;
        goto L152
    L147:
        r7 = r33;
        goto L148
    L133:
        if (r12.getDefaultsInvalid() == true) goto L145;
        r12.skipToGroupEnd();
        if ((r47 & 8) == 0) goto L139;
        r1 = r1 & (-57345);
    L139:
        if ((r47 & 32) == 0) goto L142;
        r1 = r1 & (-3670017);
    L142:
        if ((r47 & 64) == 0) goto L144;
        r1 = r1 & (-29360129);
    L144:
        r37 = r33;
        r111 = r34;
        r23 = r38;
        r25 = r39;
        r22 = r40;
        r21 = r41;
        r24 = r42;
        r110 = r9;
        goto L177
    L184:
        r29 = r12;
        r29.skipToGroupEnd();
        r26 = r33;
        r28 = r34;
        r31 = r38;
        r48 = r39;
        r30 = r9;
        r50 = r10;
        r49 = r40;
        r112 = r41;
        r113 = r42;
        goto L185
    L124:
        if ((r3 & 3) != 2) goto L127;
        r5 = false;
        goto L129
    L114:
        if ((r46 & 6) == 0) goto L116;
        r3 = r46;
        goto L122
    L116:
        if (r12.changedInstance(r43) == false) goto L118;
        int r115 = 4;
    L119:
        r3 = r46 | r115;
        goto L122
    L118:
        r115 = 2;
        goto L119
    L104:
        if ((r45 & 805306368) != 0) goto L111;
        if (r12.changed(r42) == false) goto L108;
        int r116 = 536870912;
    L109:
        r1 = r1 | r116;
        goto L111
    L108:
        r116 = 268435456;
        goto L109
    L94:
        if ((r45 & 100663296) != 0) goto L100;
        if (r12.changed(r41) == false) goto L98;
        int r117 = 67108864;
    L99:
        r1 = r1 | r117;
        goto L100
    L98:
        r117 = 33554432;
        goto L99
    L64:
        if ((r45 & 196608) != 0) goto L71;
        if (r12.changed(r38) == false) goto L68;
        int r118 = 131072;
    L69:
        r1 = r1 | r118;
        goto L71
    L68:
        r118 = 65536;
        goto L69
    L52:
        if ((r47 & 8) != 0) goto L56;
        r10 = r36;
        if (r12.changed(r10) == false) goto L57;
        int r119 = 16384;
    L58:
        r1 = r1 | r119;
    L57:
        r119 = 8192;
        goto L58
    L56:
        r10 = r36;
        goto L57
    L42:
        if ((r45 & 3072) != 0) goto L48;
        r9 = r35;
        if (r12.changedInstance(r9) == false) goto L46;
        int r120 = 2048;
    L47:
        r1 = r1 | r120;
        goto L50
    L46:
        r120 = 1024;
        goto L47
    L31:
        if ((r45 & 384) != 0) goto L38;
        if (r12.changedInstance(r34) == false) goto L35;
        int r51 = 256;
    L36:
        r1 = r1 | r51;
        goto L38
    L35:
        r51 = 128;
        goto L36
    L20:
        if ((r45 & 48) != 0) goto L27;
        if (r12.changed(r33) == false) goto L24;
        int r52 = 32;
    L25:
        r1 = r1 | r52;
        goto L27
    L24:
        r52 = 16;
        goto L25
    L6:
        if ((r45 & 6) == 0) goto L8;
        r1 = r45;
        goto L16
    L8:
        if ((r45 & 8) != 0) goto L10;
        boolean r53 = r12.changed(r32);
    L11:
        if (r53 == false) goto L13;
        int r54 = 4;
    L14:
        r1 = r54 | r45;
        goto L16
    L13:
        r54 = 2;
        goto L14
    L10:
        r53 = r12.changedInstance(r32);
        goto L11
    }
}
