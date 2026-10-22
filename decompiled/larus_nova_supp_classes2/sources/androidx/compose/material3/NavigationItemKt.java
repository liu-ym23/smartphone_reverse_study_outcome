package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001aÕ\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0004\b*\u0010+\u001a\u008d\u0001\u0010,\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0003¢\u0006\u0004\b2\u00103\u001a³\u0001\u00104\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010)\u001a\u00020\rH\u0003¢\u0006\u0004\b6\u00107\u001a3\u00108\u001a\u000209*\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0004\bA\u0010B\u001aS\u0010C\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\bE\u0010F\u001aC\u0010G\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\bH\u0010I\u001a\u0091\u0001\u0010J\u001a\u000209*\u00020:2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010 \u001a\u00020K2\u0006\u0010?\u001a\u00020@2\u0006\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010)\u001a\u00020\rH\u0002¢\u0006\u0004\bL\u0010M\u001a@\u0010N\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00032\u0011\u0010O\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010P\u001a\u001b\u0010Q\u001a\b\u0012\u0004\u0012\u0002010R2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010S\u001a\u001d\u0010T\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010U\u001a-\u0010V\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0005H\u0003¢\u0006\u0004\bW\u0010X\"\u000e\u0010Y\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010^\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010_¨\u0006`²\u0006\n\u0010a\u001a\u00020KX\u008a\u008e\u0002²\u0006\n\u0010a\u001a\u00020KX\u008a\u008e\u0002²\u0006\n\u00105\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"NavigationItem", "", "selected", "", "onClick", "Lkotlin/Function0;", NavigationItemKt.IconLayoutIdTag, "Landroidx/compose/runtime/Composable;", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "indicatorShape", "Landroidx/compose/ui/graphics/Shape;", "indicatorWidth", "Landroidx/compose/ui/unit/Dp;", "indicatorHorizontalPadding", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "startIconToLabelHorizontalPadding", "topIconItemVerticalPadding", "colors", "Landroidx/compose/material3/NavigationItemColors;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", NavigationItemKt.LabelLayoutIdTag, "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "NavigationItem-8Df7sds", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/Shape;FFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "AnimatedNavigationItem", "topIconIndicatorWidth", "topIconLabelTextStyle", "startIconLabelTextStyle", "topIconIndicatorHorizontalPadding", "topIconIndicatorVerticalPadding", "topIconIndicatorToLabelVerticalPadding", "startIconIndicatorHorizontalPadding", "startIconIndicatorVerticalPadding", "noLabelIndicatorPadding", "itemHorizontalPadding", "AnimatedNavigationItem-DQd_Gtc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;FFFFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "NavigationItemLayout", "Landroidx/compose/foundation/interaction/InteractionSource;", "indicatorColor", "Landroidx/compose/ui/graphics/Color;", "indicatorAnimationProgress", "", "NavigationItemLayout-KmRX-Dg", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;FFFFFLandroidx/compose/runtime/Composer;II)V", "AnimatedNavigationItemLayout", "iconPositionProgress", "AnimatedNavigationItemLayout-he0WsC4", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;FFFFFFFFLandroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndTopIcon", "labelPlaceable", "placeLabelAndTopIcon-qoqLrGI", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JFFF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndStartIcon", "placeLabelAndStartIcon-nru01g4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "placeAnimatedLabelAndIcon", "", "placeAnimatedLabelAndIcon-2QYhCQ8", "(Landroidx/compose/ui/layout/MeasureScope;ILkotlin/jvm/functions/Function0;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;IJFFFFFFF)Landroidx/compose/ui/layout/MeasureResult;", "StyledLabel", "content", "(ZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/NavigationItemColors;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "animateIndicatorProgressAsState", "Landroidx/compose/runtime/State;", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "IndicatorRipple", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "Indicator", "Indicator-3J-VO9M", "(JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "IndicatorVerticalOffset", "F", "material3", "itemWidth", "textStyle"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationItemKt {
    private static final String IconLayoutIdTag = "icon";
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = 0.0f;
    private static final String LabelLayoutIdTag = "label";

    private static final Unit AnimatedNavigationItemLayout_he0WsC4$lambda$35(InteractionSource r20, long r21, Shape r23, Function0 r24, Function2 r25, int r26, Function0 r27, Function2 r28, float r29, float r30, float r31, float r32, float r33, float r34, float r35, float r36, int r37, int r38, Composer r39, int r40) {
        m2934AnimatedNavigationItemLayouthe0WsC4(r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r39, RecomposeScopeImplKt.updateChangedFlags(r37 | 1), RecomposeScopeImplKt.updateChangedFlags(r38));
        return Unit.INSTANCE;
    }

    private static final Unit AnimatedNavigationItem_DQd_Gtc$lambda$27(boolean r25, Function0 r26, Function2 r27, Shape r28, float r29, TextStyle r30, TextStyle r31, float r32, float r33, float r34, float r35, float r36, float r37, float r38, float r39, NavigationItemColors r40, Modifier r41, boolean r42, Function2 r43, int r44, MutableInteractionSource r45, int r46, int r47, int r48, Composer r49, int r50) {
        m2933AnimatedNavigationItemDQd_Gtc(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r49, RecomposeScopeImplKt.updateChangedFlags(r46 | 1), RecomposeScopeImplKt.updateChangedFlags(r47), RecomposeScopeImplKt.updateChangedFlags(r48));
        return Unit.INSTANCE;
    }

    private static final Unit IndicatorRipple$lambda$42(InteractionSource r0, Shape r1, int r2, Composer r3, int r4) {
        IndicatorRipple(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Indicator_3J_VO9M$lambda$45(long r6, Shape r8, Function0 r9, int r10, Composer r11, int r12) {
        m2935Indicator3JVO9M(r6, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit NavigationItemLayout_KmRX_Dg$lambda$31(InteractionSource r17, long r18, Shape r20, Function2 r21, int r22, Function2 r23, Function0 r24, float r25, float r26, float r27, float r28, float r29, int r30, int r31, Composer r32, int r33) {
        m2937NavigationItemLayoutKmRXDg(r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r32, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31));
        return Unit.INSTANCE;
    }

    private static final Unit NavigationItem_8Df7sds$lambda$10(boolean r20, Function0 r21, Function2 r22, TextStyle r23, Shape r24, float r25, float r26, float r27, float r28, float r29, float r30, NavigationItemColors r31, Modifier r32, boolean r33, Function2 r34, int r35, MutableInteractionSource r36, int r37, int r38, Composer r39, int r40) {
        m2936NavigationItem8Df7sds(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r39, RecomposeScopeImplKt.updateChangedFlags(r37 | 1), RecomposeScopeImplKt.updateChangedFlags(r38));
        return Unit.INSTANCE;
    }

    private static final Unit StyledLabel$lambda$41(boolean r7, TextStyle r8, NavigationItemColors r9, boolean r10, Function2 r11, int r12, Composer r13, int r14) {
        StyledLabel(r7, r8, r9, r10, r11, r13, RecomposeScopeImplKt.updateChangedFlags(r12 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ TextStyle a(boolean r0, TextStyle r1, TextStyle r2, State r3) {
        return AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$18$lambda$17(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(InteractionSource r1, long r2, Shape r4, Function2 r5, int r6, Function2 r7, Function0 r8, float r9, float r10, float r11, float r12, float r13, int r14, int r15, Composer r16, int r17) {
        return NavigationItemLayout_KmRX_Dg$lambda$31(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit c(InteractionSource r0, Shape r1, int r2, Composer r3, int r4) {
        return IndicatorRipple$lambda$42(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ float d(State r0) {
        return AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$23$lambda$22(r0);
    }

    public static /* synthetic */ Unit e(boolean r0, TextStyle r1, NavigationItemColors r2, boolean r3, Function2 r4, int r5, Composer r6, int r7) {
        return StyledLabel$lambda$41(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit f(Placeable r0, int r1, int r2, Placeable r3, int r4, int r5, Placeable r6, int r7, int r8, Placeable r9, int r10, int r11, Placeable.PlacementScope r12) {
        return placeLabelAndStartIcon_nru01g4$lambda$38(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit g(MutableIntState r0, IntSize r1) {
        return NavigationItem_8Df7sds$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ float h(State r0) {
        return NavigationItem_8Df7sds$lambda$9$lambda$8$lambda$7(r0);
    }

    public static /* synthetic */ Unit i(Placeable r0, int r1, Placeable r2, int r3, int r4, Placeable r5, Object r6, int r7, Placeable r8, int r9, float r10, Placeable.PlacementScope r11) {
        return placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit j(long r0, Shape r2, Function0 r3, int r4, Composer r5, int r6) {
        return Indicator_3J_VO9M$lambda$45(r0, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit k(Placeable r0, int r1, int r2, Placeable r3, int r4, int r5, Placeable r6, int r7, int r8, Placeable r9, int r10, int r11, Placeable.PlacementScope r12) {
        return placeLabelAndTopIcon_qoqLrGI$lambda$37(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit l(boolean r1, Function0 r2, Function2 r3, Shape r4, float r5, TextStyle r6, TextStyle r7, float r8, float r9, float r10, float r11, float r12, float r13, float r14, float r15, NavigationItemColors r16, Modifier r17, boolean r18, Function2 r19, int r20, MutableInteractionSource r21, int r22, int r23, int r24, Composer r25, int r26) {
        return AnimatedNavigationItem_DQd_Gtc$lambda$27(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public static /* synthetic */ Unit m(MutableIntState r0, IntSize r1) {
        return AnimatedNavigationItem_DQd_Gtc$lambda$15$lambda$14(r0, r1);
    }

    public static /* synthetic */ Unit n(Function0 r0, GraphicsLayerScope r1) {
        return Indicator_3J_VO9M$lambda$44$lambda$43(r0, r1);
    }

    public static /* synthetic */ Unit o(Placeable r0, int r1, int r2, Placeable r3, int r4, int r5, Placeable r6, int r7, int r8, Placeable.PlacementScope r9) {
        return placeIcon_X9ElhV4$lambda$36(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ float p(State r0) {
        return AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$25$lambda$24(r0);
    }

    public static /* synthetic */ Unit q(InteractionSource r1, long r2, Shape r4, Function0 r5, Function2 r6, int r7, Function0 r8, Function2 r9, float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17, int r18, int r19, Composer r20, int r21) {
        return AnimatedNavigationItemLayout_he0WsC4$lambda$35(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static /* synthetic */ Unit r(boolean r1, Function0 r2, Function2 r3, TextStyle r4, Shape r5, float r6, float r7, float r8, float r9, float r10, float r11, NavigationItemColors r12, Modifier r13, boolean r14, Function2 r15, int r16, MutableInteractionSource r17, int r18, int r19, Composer r20, int r21) {
        return NavigationItem_8Df7sds$lambda$10(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static /* synthetic */ Unit s(float r0, GraphicsLayerScope r1) {
        return placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40$lambda$39(r0, r1);
    }

    static {
        IndicatorVerticalOffset = Dp.constructor-impl(12);
    }

    private static final int AnimatedNavigationItem_DQd_Gtc$lambda$12(MutableIntState r0) {
        return r0.getIntValue();
    }

    private static final float AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final TextStyle AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$19(State<TextStyle> r0) {
        return (TextStyle) r0.getValue();
    }

    private static final float AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$23$lambda$22(State r1) {
        return RangesKt.coerceAtLeast(((Number) r1.getValue()).floatValue(), MenuKt.ClosedAlphaTarget);
    }

    private static final float AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$25$lambda$24(State r1) {
        return RangesKt.coerceAtLeast(AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(r1), MenuKt.ClosedAlphaTarget);
    }

    private static final int NavigationItem_8Df7sds$lambda$1(MutableIntState r0) {
        return r0.getIntValue();
    }

    private static final float NavigationItem_8Df7sds$lambda$9$lambda$8$lambda$7(State r1) {
        return RangesKt.coerceAtLeast(((Number) r1.getValue()).floatValue(), MenuKt.ClosedAlphaTarget);
    }

    public static final /* synthetic */ TextStyle access$AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$19(State r0) {
        return AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$19(r0);
    }

    private static final void AnimatedNavigationItem_DQd_Gtc$lambda$13(MutableIntState r0, int r1) {
        r0.setIntValue(r1);
    }

    private static final Unit AnimatedNavigationItem_DQd_Gtc$lambda$15$lambda$14(MutableIntState r2, IntSize r3) {
        AnimatedNavigationItem_DQd_Gtc$lambda$13(r2, (int) (r3.unbox-impl() >> 32));
        return Unit.INSTANCE;
    }

    private static final Unit Indicator_3J_VO9M$lambda$44$lambda$43(Function0 r0, GraphicsLayerScope r1) {
        r1.setAlpha(((Number) r0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    private static final void NavigationItem_8Df7sds$lambda$2(MutableIntState r0, int r1) {
        r0.setIntValue(r1);
    }

    private static final Unit NavigationItem_8Df7sds$lambda$4$lambda$3(MutableIntState r2, IntSize r3) {
        NavigationItem_8Df7sds$lambda$2(r2, (int) (r3.unbox-impl() >> 32));
        return Unit.INSTANCE;
    }

    private static final Unit placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40$lambda$39(float r2, GraphicsLayerScope r3) {
        float r4 = r2 - 0.5f;
        r3.setAlpha((4 * r4) * r4);
        return Unit.INSTANCE;
    }

    private static final State<Float> animateIndicatorProgressAsState(boolean r8, Composer r9, int r10) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1105658511, r10, -1, "androidx.compose.material3.animateIndicatorProgressAsState (NavigationItem.kt:1094)");
    L5:
        if (r8 == false) goto L7;
        float r0 = 1.0f;
    L8:
        State<Float> r11 = AnimateAsStateKt.animateFloatAsState(r0, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r9, 6), MenuKt.ClosedAlphaTarget, null, null, r9, 0, 28);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r11;
    L7:
        r0 = MenuKt.ClosedAlphaTarget;
        goto L8
    }

    private static final TextStyle AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$18$lambda$17(boolean r0, TextStyle r1, TextStyle r2, State r3) {
        if (r0 == false) goto L7;
        if (AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(r3) >= 0.5f) goto L7;
        return r1;
    L7:
        return r2;
    }

    private static final void IndicatorRipple(final InteractionSource r11, final Shape r12, Composer r13, final int r14) {
        Composer r15 = r13.startRestartGroup(-629069867);
        if ((r14 & 6) == 0) goto L5;
        int r1 = r14;
    L11:
        if ((r14 & 48) != 0) goto L18;
        if (r15.changed(r12) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r15.shouldExecute(r3, r1 & 1) == true) goto L24;
        r15.skipToGroupEnd();
    L30:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L34;
        r16.updateScope(new ci(r11, r12, r14));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-629069867, r1, -1, "androidx.compose.material3.IndicatorRipple (NavigationItem.kt:1101)");
    L26:
        BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.Companion, IndicatorRippleLayoutIdTag), r12), r11, RippleKt.m3031rippleH2RKhps$default(false, MenuKt.ClosedAlphaTarget, 0, 7, null)), r15, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r3 = false;
        goto L22
    L5:
        if (r15.changed(r11) == false) goto L7;
        int r4 = 4;
    L8:
        r1 = r4 | r14;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: Indicator-3J-VO9M, reason: not valid java name */
    private static final void m2935Indicator3JVO9M(final long r7, final Shape r9, final Function0<Float> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(-273382589);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 48) != 0) goto L18;
        if (r13.changed(r9) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r12 & 384) == 0) goto L20;
    L24:
        boolean r5 = true;
        if ((r1 & 147) == 146) goto L27;
        boolean r3 = true;
    L29:
        if (r13.shouldExecute(r3, r1 & 1) == true) goto L31;
        r13.skipToGroupEnd();
    L46:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L50;
        r14.updateScope(new ai(r7, r9, r10, r12));
        return;
    L50:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-273382589, r1, -1, "androidx.compose.material3.Indicator (NavigationItem.kt:1114)");
    L33:
        Modifier r0 = LayoutIdKt.layoutId(Modifier.Companion, IndicatorLayoutIdTag);
        if ((r1 & 896) == 256) goto L37;
        r5 = false;
    L37:
        Object r4 = r13.rememberedValue();
        if (r5 == false) goto L40;
    L41:
        r4 = new zh(r10);
        r13.updateRememberedValue(r4);
    L42:
        BoxKt.Box(BackgroundKt.m341backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(r0, (Function1) r4), r7, r9), r13, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
        goto L46
    L40:
        if (r4 != Composer.Companion.getEmpty()) goto L42;
    L27:
        r3 = false;
        goto L29
    L20:
        if (r13.changedInstance(r10) == false) goto L22;
        int r6 = 256;
    L23:
        r1 = r1 | r6;
        goto L24
    L22:
        r6 = 128;
        goto L23
    L5:
        if (r13.changed(r7) == false) goto L7;
        int r8 = 4;
    L8:
        r1 = r8 | r12;
        goto L11
    L7:
        r8 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$placeIcon-X9ElhV4, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m2939access$placeIconX9ElhV4(MeasureScope r0, Placeable r1, Placeable r2, Placeable r3, long r4) {
        return m2943placeIconX9ElhV4(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    private static final MeasureResult m2943placeIconX9ElhV4(MeasureScope r16, final Placeable r17, final Placeable r18, final Placeable r19, long r20) {
        int r4 = ConstraintsKt.constrainWidth-K40F9xA(r20, r18.getWidth());
        int r5 = ConstraintsKt.constrainHeight-K40F9xA(r20, r18.getHeight());
        final int r8 = (r4 - r19.getWidth()) / 2;
        final int r9 = (r5 - r19.getHeight()) / 2;
        final int r11 = (r4 - r17.getWidth()) / 2;
        final int r12 = (r5 - r17.getHeight()) / 2;
        final int r14 = (r4 - r18.getWidth()) / 2;
        final int r15 = (r5 - r18.getHeight()) / 2;
        return MeasureScope.-CC.layout$default(r16, r4, r5, null, new oh(r19, r8, r9, r17, r11, r12, r18, r14, r15), 4, null);
    }

    private static final void StyledLabel(final boolean r8, final TextStyle r9, final NavigationItemColors r10, final boolean r11, final Function2<? super Composer, ? super Integer, Unit> r12, Composer r13, final int r14) {
        Composer r15 = r13.startRestartGroup(-2136267443);
        if ((r14 & 6) == 0) goto L5;
        int r1 = r14;
    L11:
        if ((r14 & 48) != 0) goto L18;
        if (r15.changed(r9) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r14 & 384) != 0) goto L25;
        if (r15.changed(r10) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r14 & 3072) != 0) goto L32;
        if (r15.changed(r11) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r14 & 24576) != 0) goto L39;
        if (r15.changedInstance(r12) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((r1 & 9363) == 9362) goto L41;
        boolean r6 = true;
    L43:
        if (r15.shouldExecute(r6, r1 & 1) == true) goto L45;
        r15.skipToGroupEnd();
    L51:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L55;
        r16.updateScope(new wh(r8, r9, r10, r11, r12, r14));
        return;
    L55:
        return;
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventStart(-2136267443, r1, -1, "androidx.compose.material3.StyledLabel (NavigationItem.kt:1083)");
    L47:
        ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(r10.m2923textColorWaAFU9c(r8, r11), r9, r12, r15, (r1 & 112) | ((r1 >> 6) & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L51;
        ComposerKt.traceEventEnd();
        goto L51
    L41:
        r6 = false;
        goto L43
    L5:
        if (r15.changed(r8) == false) goto L7;
        int r7 = 4;
    L8:
        r1 = r7 | r14;
        goto L11
    L7:
        r7 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$StyledLabel(boolean r0, TextStyle r1, NavigationItemColors r2, boolean r3, Function2 r4, Composer r5, int r6) {
        StyledLabel(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: access$placeLabelAndStartIcon-nru01g4, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m2940access$placeLabelAndStartIconnru01g4(MeasureScope r0, Placeable r1, Placeable r2, Placeable r3, Placeable r4, long r5, float r7) {
        return m2944placeLabelAndStartIconnru01g4(r0, r1, r2, r3, r4, r5, r7);
    }

    /* JADX INFO: renamed from: placeLabelAndStartIcon-nru01g4, reason: not valid java name */
    private static final MeasureResult m2944placeLabelAndStartIconnru01g4(MeasureScope r18, final Placeable r19, final Placeable r20, final Placeable r21, final Placeable r22, long r23, float r25) {
        int r4 = ConstraintsKt.constrainWidth-K40F9xA(r23, r21.getWidth());
        int r1 = ConstraintsKt.constrainHeight-K40F9xA(r23, r21.getHeight());
        final int r7 = (r4 - r22.getWidth()) / 2;
        final int r8 = (r1 - r22.getHeight()) / 2;
        final int r14 = (r1 - r20.getHeight()) / 2;
        final int r11 = (r1 - r19.getHeight()) / 2;
        final int r13 = (r4 - ((r20.getWidth() + r18.roundToPx-0680j_4(r25)) + r19.getWidth())) / 2;
        final int r10 = (r20.getWidth() + r13) + r18.roundToPx-0680j_4(r25);
        final int r16 = (r4 - r21.getWidth()) / 2;
        final int r17 = (r1 - r21.getHeight()) / 2;
        return MeasureScope.-CC.layout$default(r18, r4, r1, null, new xh(r22, r7, r8, r19, r10, r11, r20, r13, r14, r21, r16, r17), 4, null);
    }

    /* JADX INFO: renamed from: access$placeLabelAndTopIcon-qoqLrGI, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m2941access$placeLabelAndTopIconqoqLrGI(MeasureScope r0, Placeable r1, Placeable r2, Placeable r3, Placeable r4, long r5, float r7, float r8, float r9) {
        return m2945placeLabelAndTopIconqoqLrGI(r0, r1, r2, r3, r4, r5, r7, r8, r9);
    }

    /* JADX INFO: renamed from: placeLabelAndTopIcon-qoqLrGI, reason: not valid java name */
    private static final MeasureResult m2945placeLabelAndTopIconqoqLrGI(MeasureScope r23, final Placeable r24, final Placeable r25, final Placeable r26, final Placeable r27, long r28, float r30, float r31, float r32) {
        int r6 = ConstraintsKt.constrainWidth-K40F9xA(r28, Math.max(r24.getWidth(), r26.getWidth()));
        int r1 = ConstraintsKt.constrainHeight-K40F9xA(r28, MathKt.roundToInt(((r26.getHeight() + r23.toPx-0680j_4(r30)) + r24.getHeight()) + (r23.toPx-0680j_4(r32) * 2)));
        final int r19 = r23.roundToPx-0680j_4(Dp.constructor-impl(r32 + r31));
        final int r18 = (r6 - r25.getWidth()) / 2;
        final int r12 = (r6 - r27.getWidth()) / 2;
        final int r22 = r19 - r23.roundToPx-0680j_4(r31);
        final int r15 = (r6 - r24.getWidth()) / 2;
        final int r16 = (r19 + r25.getHeight()) + r23.roundToPx-0680j_4(Dp.constructor-impl(r30 + r31));
        final int r21 = (r6 - r26.getWidth()) / 2;
        return MeasureScope.-CC.layout$default(r23, r6, r1, null, new yh(r27, r12, r22, r24, r15, r16, r25, r18, r19, r26, r21, r22), 4, null);
    }

    private static final Unit placeIcon_X9ElhV4$lambda$36(Placeable r14, int r15, int r16, Placeable r17, int r18, int r19, Placeable r20, int r21, int r22, Placeable.PlacementScope r23) {
        Placeable.PlacementScope.placeRelative$default(r23, r14, r15, r16, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r23, r17, r18, r19, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r23, r20, r21, r22, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40(Placeable r16, int r17, Placeable r18, int r19, int r20, Placeable r21, Object r22, int r23, Placeable r24, int r25, final float r26, Placeable.PlacementScope r27) {
        Placeable.PlacementScope.placeRelativeWithLayer$default(r27, r16, r17, 0, MenuKt.ClosedAlphaTarget, null, 12, null);
        Placeable.PlacementScope.placeRelativeWithLayer$default(r27, r18, r19, r20, MenuKt.ClosedAlphaTarget, null, 12, null);
        Placeable.PlacementScope.placeRelativeWithLayer$default(r27, r21, ((Number) r22).intValue(), r23, MenuKt.ClosedAlphaTarget, new ph(r26), 4, null);
        Placeable.PlacementScope.placeRelativeWithLayer$default(r27, r24, r25, 0, MenuKt.ClosedAlphaTarget, null, 12, null);
        return Unit.INSTANCE;
    }

    private static final Unit placeLabelAndStartIcon_nru01g4$lambda$38(Placeable r14, int r15, int r16, Placeable r17, int r18, int r19, Placeable r20, int r21, int r22, Placeable r23, int r24, int r25, Placeable.PlacementScope r26) {
        Placeable.PlacementScope.placeRelative$default(r26, r14, r15, r16, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r26, r17, r18, r19, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r26, r20, r21, r22, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r26, r23, r24, r25, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit placeLabelAndTopIcon_qoqLrGI$lambda$37(Placeable r14, int r15, int r16, Placeable r17, int r18, int r19, Placeable r20, int r21, int r22, Placeable r23, int r24, int r25, Placeable.PlacementScope r26) {
        Placeable.PlacementScope.placeRelative$default(r26, r14, r15, r16, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r26, r17, r18, r19, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r26, r20, r21, r22, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r26, r23, r24, r25, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: NavigationItemLayout-KmRX-Dg, reason: not valid java name */
    private static final void m2937NavigationItemLayoutKmRXDg(final InteractionSource r25, final long r26, final Shape r28, final Function2<? super Composer, ? super Integer, Unit> r29, final int r30, final Function2<? super Composer, ? super Integer, Unit> r31, final Function0<Float> r32, final float r33, final float r34, final float r35, final float r36, final float r37, Composer r38, final int r39, final int r40) {
        Composer r12 = r38.startRestartGroup(-1473868071);
        int r3 = 4;
        if ((r39 & 6) == 0) goto L5;
        int r2 = r39;
    L10:
        int r6 = 32;
        if ((r39 & 48) != 0) goto L18;
        if (r12.changed(r26) == false) goto L15;
        int r13 = 32;
    L16:
        r2 = r2 | r13;
        goto L18
    L15:
        r13 = 16;
    L18:
        if ((r39 & 384) != 0) goto L25;
        if (r12.changed(r28) == false) goto L22;
        int r14 = 256;
    L23:
        r2 = r2 | r14;
        goto L25
    L22:
        r14 = 128;
    L25:
        if ((r39 & 3072) != 0) goto L32;
        if (r12.changedInstance(r29) == false) goto L29;
        int r15 = 2048;
    L30:
        r2 = r2 | r15;
        goto L32
    L29:
        r15 = 1024;
    L32:
        if ((r39 & 24576) != 0) goto L39;
        if (r12.changed(r30) == false) goto L36;
        int r16 = 16384;
    L37:
        r2 = r2 | r16;
        goto L39
    L36:
        r16 = 8192;
    L39:
        if ((196608 & r39) != 0) goto L46;
        if (r12.changedInstance(r31) == false) goto L43;
        int r17 = 131072;
    L44:
        r2 = r2 | r17;
        goto L46
    L43:
        r17 = 65536;
    L46:
        if ((1572864 & r39) != 0) goto L54;
        if (r12.changedInstance(r32) == false) goto L50;
        int r18 = 1048576;
    L51:
        r2 = r2 | r18;
        goto L54
    L50:
        r18 = 524288;
    L54:
        if ((12582912 & r39) != 0) goto L62;
        if (r12.changed(r33) == false) goto L58;
        int r19 = 8388608;
    L59:
        r2 = r2 | r19;
        goto L62
    L58:
        r19 = 4194304;
    L62:
        if ((r39 & 100663296) != 0) goto L69;
        if (r12.changed(r34) == false) goto L66;
        int r110 = 67108864;
    L67:
        r2 = r2 | r110;
        goto L69
    L66:
        r110 = 33554432;
    L69:
        if ((r39 & 805306368) != 0) goto L76;
        if (r12.changed(r35) == false) goto L73;
        int r111 = 536870912;
    L74:
        r2 = r2 | r111;
        goto L76
    L73:
        r111 = 268435456;
    L76:
        if ((r40 & 6) == 0) goto L78;
        int r4 = r40;
    L84:
        if ((r40 & 48) != 0) goto L91;
        if (r12.changed(r37) == true) goto L89;
        r6 = 16;
    L89:
        r4 = r4 | r6;
    L91:
        boolean r112 = true;
        if ((306783379 & r2) == 306783378) goto L94;
    L97:
        boolean r1 = true;
    L99:
        if (r12.shouldExecute(r1, r2 & 1) == true) goto L101;
        r12.skipToGroupEnd();
    L158:
        ScopeUpdateScope r113 = r12.endRestartGroup();
        if (r113 == null) goto L162;
        r113.updateScope(new vh(r25, r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r39, r40));
        return;
    L162:
        return;
    L101:
        if (ComposerKt.isTraceInProgress() == false) goto L103;
        ComposerKt.traceEventStart(-1473868071, r2, r4, "androidx.compose.material3.NavigationItemLayout (NavigationItem.kt:453)");
    L103:
        Modifier.Companion r5 = Modifier.Companion;
        Modifier r7 = BadgeKt.badgeBounds(r5);
        if (r31 == null) goto L110;
        if (NavigationItemIconPosition.m2927equalsimpl0(r30, NavigationItemIconPosition.Companion.m2932getTopxw1Ddg()) == true) goto L110;
        Object r8 = new StartIconMeasurePolicy(r32, r33, r34, r36, null);
    L114:
        int r9 = ComposablesKt.getCurrentCompositeKeyHash(r12, 0);
        CompositionLocalMap r10 = r12.getCurrentCompositionLocalMap();
        Modifier r11 = ComposedModifierKt.materializeModifier(r12, r7);
        ComposeUiNode.Companion r114 = ComposeUiNode.Companion;
        Function0 r0 = r114.getConstructor();
        if ((r12.getApplier() instanceof Applier) == true) goto L117;
        ComposablesKt.invalidApplier();
    L117:
        r12.startReusableNode();
        if (r12.getInserting() == false) goto L120;
        r12.createNode(r0);
    L121:
        Composer r20 = Updater.constructor-impl(r12);
        Updater.set-impl(r20, r8, r114.getSetMeasurePolicy());
        Updater.set-impl(r20, r10, r114.getSetResolvedCompositionLocals());
        Function2 r21 = r114.getSetCompositeKeyHash();
        if (r20.getInserting() == false) goto L124;
    L125:
        r20.updateRememberedValue(Integer.valueOf(r9));
        r20.apply(Integer.valueOf(r9), r21);
    L126:
        Updater.set-impl(r20, r11, r114.getSetModifier());
        int r22 = r2 >> 3;
        int r23 = r22 & 112;
        IndicatorRipple(r25, r28, r12, (r2 & 14) | r23);
        int r115 = r2;
        m2935Indicator3JVO9M(r26, r28, r32, r12, ((r22 & 14) | r23) | ((r2 >> 12) & 896));
        Modifier r24 = LayoutIdKt.layoutId(r5, IconLayoutIdTag);
        Alignment.Companion r27 = Alignment.Companion;
        MeasurePolicy r41 = BoxKt.maybeCachedBoxMeasurePolicy(r27.getTopStart(), false);
        int r42 = ComposablesKt.getCurrentCompositeKeyHash(r12, 0);
        CompositionLocalMap r43 = r12.getCurrentCompositionLocalMap();
        Modifier r44 = ComposedModifierKt.materializeModifier(r12, r24);
        Function0 r45 = r114.getConstructor();
        if ((r12.getApplier() instanceof Applier) == true) goto L129;
        ComposablesKt.invalidApplier();
    L129:
        r12.startReusableNode();
        if (r12.getInserting() == false) goto L132;
        r12.createNode(r45);
    L133:
        Composer r46 = Updater.constructor-impl(r12);
        Updater.set-impl(r46, r41, r114.getSetMeasurePolicy());
        Updater.set-impl(r46, r43, r114.getSetResolvedCompositionLocals());
        Function2 r47 = r114.getSetCompositeKeyHash();
        if (r46.getInserting() == false) goto L136;
    L137:
        r46.updateRememberedValue(Integer.valueOf(r42));
        r46.apply(Integer.valueOf(r42), r47);
    L138:
        Updater.set-impl(r46, r44, r114.getSetModifier());
        BoxScopeInstance r48 = BoxScopeInstance.INSTANCE;
        r29.invoke(r12, Integer.valueOf((r115 >> 9) & 14));
        r12.endNode();
        if (r31 == null) goto L153;
        r12.startReplaceGroup(-2087200706);
        Modifier r49 = LayoutIdKt.layoutId(r5, LabelLayoutIdTag);
        MeasurePolicy r50 = BoxKt.maybeCachedBoxMeasurePolicy(r27.getTopStart(), false);
        int r51 = ComposablesKt.getCurrentCompositeKeyHash(r12, 0);
        CompositionLocalMap r52 = r12.getCurrentCompositionLocalMap();
        Modifier r53 = ComposedModifierKt.materializeModifier(r12, r49);
        Function0 r54 = r114.getConstructor();
        if ((r12.getApplier() instanceof Applier) == true) goto L143;
        ComposablesKt.invalidApplier();
    L143:
        r12.startReusableNode();
        if (r12.getInserting() == false) goto L146;
        r12.createNode(r54);
    L147:
        Composer r55 = Updater.constructor-impl(r12);
        Updater.set-impl(r55, r50, r114.getSetMeasurePolicy());
        Updater.set-impl(r55, r52, r114.getSetResolvedCompositionLocals());
        Function2 r56 = r114.getSetCompositeKeyHash();
        if (r55.getInserting() == false) goto L150;
    L151:
        r55.updateRememberedValue(Integer.valueOf(r51));
        r55.apply(Integer.valueOf(r51), r56);
    L152:
        Updater.set-impl(r55, r53, r114.getSetModifier());
        r31.invoke(r12, Integer.valueOf((r115 >> 15) & 14));
        r12.endNode();
        r12.endReplaceGroup();
    L154:
        r12.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L158;
        ComposerKt.traceEventEnd();
        goto L158
    L150:
        if (Intrinsics.areEqual(r55.rememberedValue(), Integer.valueOf(r51)) == true) goto L152;
    L146:
        r12.useNode();
        goto L147
    L153:
        r12.startReplaceGroup(-2087119982);
        r12.endReplaceGroup();
        goto L154
    L136:
        if (Intrinsics.areEqual(r46.rememberedValue(), Integer.valueOf(r42)) == true) goto L138;
    L132:
        r12.useNode();
        goto L133
    L124:
        if (Intrinsics.areEqual(r20.rememberedValue(), Integer.valueOf(r9)) == true) goto L126;
    L120:
        r12.useNode();
    L110:
        if (r31 != null) goto L113;
        r112 = false;
    L113:
        r8 = new TopIconOrIconOnlyMeasurePolicy(r112, r32, r33, r34, r35, r37, null);
        goto L114
    L94:
        if ((r4 & 19) != 18) goto L97;
        r1 = false;
        goto L99
    L78:
        if (r12.changed(r36) == true) goto L81;
        r3 = 2;
    L81:
        r4 = r40 | r3;
        goto L84
    L5:
        if (r12.changed(r25) == false) goto L7;
        int r57 = 4;
    L8:
        r2 = r57 | r39;
        goto L10
    L7:
        r57 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$placeAnimatedLabelAndIcon-2QYhCQ8, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m2938access$placeAnimatedLabelAndIcon2QYhCQ8(MeasureScope r1, int r2, Function0 r3, Placeable r4, Placeable r5, Placeable r6, Placeable r7, int r8, long r9, float r11, float r12, float r13, float r14, float r15, float r16, float r17) {
        return m2942placeAnimatedLabelAndIcon2QYhCQ8(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17);
    }

    /* JADX INFO: renamed from: placeAnimatedLabelAndIcon-2QYhCQ8, reason: not valid java name */
    private static final MeasureResult m2942placeAnimatedLabelAndIcon2QYhCQ8(MeasureScope r21, int r22, Function0<Float> r23, final Placeable r24, final Placeable r25, final Placeable r26, final Placeable r27, int r28, long r29, float r31, float r32, float r33, float r34, float r35, float r36, float r37) {
        final float r6 = ((Number) r23.invoke()).floatValue();
        boolean r7 = NavigationItemIconPosition.m2927equalsimpl0(r22, NavigationItemIconPosition.Companion.m2932getTopxw1Ddg());
        float r10 = 2;
        float r11 = r37 * r10;
        int r8 = ConstraintsKt.constrainWidth-K40F9xA(r29, Math.max(r24.getWidth(), r28 + r21.roundToPx-0680j_4(Dp.constructor-impl(r11))));
        float r13 = r8 + ((ConstraintsKt.constrainWidth-K40F9xA(r29, r26.getWidth() + r21.roundToPx-0680j_4(r37)) - r8) * r6);
        int r1 = MathHelpersKt.lerp(ConstraintsKt.constrainHeight-K40F9xA(r29, MathKt.roundToInt((r26.getHeight() + r21.toPx-0680j_4(r31)) + r24.getHeight())), ConstraintsKt.constrainHeight-K40F9xA(r29, r26.getHeight()), r6);
        final int r2 = r21.roundToPx-0680j_4(r37);
        int r9 = MathKt.roundToInt((r13 - r27.getWidth()) / r10);
        int r12 = MathKt.roundToInt(((r2 + r13) - r27.getWidth()) / r10);
        boolean r14 = true;
        float r16 = MenuKt.ClosedAlphaTarget;
        if (r6 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r17 = true;
    L7:
        if (r17 == false) goto L9;
    L15:
        int r15 = MathHelpersKt.lerp(r9, r12, r6);
    L16:
        final int r18 = r15;
        int r19 = r21.roundToPx-0680j_4(r33) + r2;
        int r110 = r21.roundToPx-0680j_4(r34) + r2;
        int r111 = r21.roundToPx-0680j_4(r32);
        int r20 = r21.roundToPx-0680j_4(r35);
        final int r112 = MathHelpersKt.lerp(r19, r110, r6);
        final int r113 = MathHelpersKt.lerp(r111, r20, r6);
        int r30 = ((r25.getWidth() + r21.roundToPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(r33 * r10) + Dp.constructor-impl(r11)))) - r24.getWidth()) / 2;
        int r4 = (r25.getHeight() + r113) + r21.roundToPx-0680j_4(Dp.constructor-impl(r31 + r31));
        if (r7 == true) goto L19;
    L21:
        r16 = r21.roundToPx-0680j_4(r37) * (1.0f - r6);
    L22:
        float r3 = ((r25.getWidth() + r112) + r21.roundToPx-0680j_4(r36)) - r16;
        int r5 = (r1 - r24.getHeight()) / 2;
        if (r6 >= 0.5f) goto L25;
        Object r38 = Integer.valueOf(r30);
    L26:
        if (r6 < 0.5f) goto L29;
        r4 = r5;
    L29:
        final Object r114 = r38;
        final int r115 = r4;
        return MeasureScope.-CC.layout$default(r21, MathKt.roundToInt(r13), r1, null, new bi(r27, r18, r25, r112, r113, r24, r114, r115, r26, r2, r6), 4, null);
    L25:
        r38 = Float.valueOf(r3 * r6);
        goto L26
    L19:
        if (r6 <= MenuKt.ClosedAlphaTarget) goto L21;
    L9:
        if (r6 == 1.0f) goto L12;
        r14 = false;
    L12:
        if (r14 == true) goto L15;
        r15 = r21.roundToPx-0680j_4(r37);
        goto L16
    L5:
        r17 = false;
        goto L7
    }

    /* JADX INFO: renamed from: AnimatedNavigationItemLayout-he0WsC4, reason: not valid java name */
    private static final void m2934AnimatedNavigationItemLayouthe0WsC4(final InteractionSource r34, final long r35, final Shape r37, final Function0<Float> r38, final Function2<? super Composer, ? super Integer, Unit> r39, final int r40, final Function0<Float> r41, final Function2<? super Composer, ? super Integer, Unit> r42, final float r43, final float r44, final float r45, final float r46, final float r47, final float r48, final float r49, final float r50, Composer r51, final int r52, final int r53) {
        Composer r11 = r51.startRestartGroup(94433406);
        int r4 = 2;
        if ((r52 & 6) == 0) goto L5;
        int r2 = r52;
    L10:
        int r6 = 32;
        if ((r52 & 48) == 0) goto L13;
    L17:
        int r16 = 256;
        if ((r52 & 384) == 0) goto L20;
    L24:
        int r18 = 2048;
        if ((r52 & 3072) != 0) goto L32;
        if (r11.changedInstance(r38) == false) goto L29;
        int r20 = 2048;
    L30:
        r2 = r2 | r20;
        goto L32
    L29:
        r20 = 1024;
    L32:
        int r21 = 16384;
        if ((r52 & 24576) == 0) goto L35;
    L39:
        int r23 = 131072;
        if ((r52 & 196608) != 0) goto L47;
        if (r11.changed(r40) == false) goto L44;
        int r25 = 131072;
    L45:
        r2 = r2 | r25;
        goto L47
    L44:
        r25 = 65536;
    L47:
        if ((r52 & 1572864) != 0) goto L54;
        if (r11.changedInstance(r41) == false) goto L51;
        int r26 = 1048576;
    L52:
        r2 = r2 | r26;
        goto L54
    L51:
        r26 = 524288;
    L54:
        if ((r52 & 12582912) != 0) goto L61;
        if (r11.changedInstance(r42) == false) goto L58;
        int r27 = 8388608;
    L59:
        r2 = r2 | r27;
        goto L61
    L58:
        r27 = 4194304;
    L61:
        if ((r52 & 100663296) != 0) goto L68;
        if (r11.changed(r43) == false) goto L65;
        int r13 = 67108864;
    L66:
        r2 = r2 | r13;
        goto L68
    L65:
        r13 = 33554432;
    L68:
        if ((805306368 & r52) != 0) goto L76;
        if (r11.changed(r44) == false) goto L72;
        int r28 = 536870912;
    L73:
        r2 = r2 | r28;
        goto L76
    L72:
        r28 = 268435456;
    L76:
        if ((r53 & 6) == 0) goto L78;
        int r5 = r53;
    L83:
        if ((r53 & 48) != 0) goto L90;
        if (r11.changed(r46) == true) goto L88;
        r6 = 16;
    L88:
        r5 = r5 | r6;
    L90:
        if ((r53 & 384) != 0) goto L97;
        if (r11.changed(r47) == true) goto L95;
        r16 = 128;
    L95:
        r5 = r5 | r16;
    L97:
        if ((r53 & 3072) != 0) goto L105;
        if (r11.changed(r48) == true) goto L102;
        r18 = 1024;
    L102:
        r5 = r5 | r18;
    L105:
        if ((r53 & 24576) != 0) goto L113;
        if (r11.changed(r49) == true) goto L110;
        r21 = 8192;
    L110:
        r5 = r5 | r21;
    L113:
        if ((r53 & 196608) != 0) goto L120;
        if (r11.changed(r50) == true) goto L118;
        r23 = 65536;
    L118:
        r5 = r5 | r23;
    L120:
        if ((r2 & 306783379) == 306783378) goto L122;
    L125:
        boolean r0 = true;
    L127:
        if (r11.shouldExecute(r0, r2 & 1) == true) goto L129;
        r11.skipToGroupEnd();
    L179:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L183;
        r12.updateScope(new gi(r34, r35, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r52, r53));
        return;
    L183:
        return;
    L129:
        if (ComposerKt.isTraceInProgress() == false) goto L131;
        ComposerKt.traceEventStart(94433406, r2, r5, "androidx.compose.material3.AnimatedNavigationItemLayout (NavigationItem.kt:508)");
    L131:
        Modifier.Companion r1 = Modifier.Companion;
        Modifier r3 = BadgeKt.badgeBounds(r1);
        if (r42 == null) goto L134;
        Object r7 = new AnimatedMeasurePolicy(r40, r41, r38, r43, r44, r45, r46, r47, r49, r50, null);
    L135:
        int r8 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r14 = r11.getCurrentCompositionLocalMap();
        Modifier r9 = ComposedModifierKt.materializeModifier(r11, r3);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r10 = r17.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L138;
        ComposablesKt.invalidApplier();
    L138:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L141;
        r11.createNode(r10);
    L142:
        Composer r15 = Updater.constructor-impl(r11);
        Updater.set-impl(r15, r7, r17.getSetMeasurePolicy());
        Updater.set-impl(r15, r14, r17.getSetResolvedCompositionLocals());
        Function2 r19 = r17.getSetCompositeKeyHash();
        if (r15.getInserting() == false) goto L145;
    L146:
        r15.updateRememberedValue(Integer.valueOf(r8));
        r15.apply(Integer.valueOf(r8), r19);
    L147:
        Updater.set-impl(r15, r9, r17.getSetModifier());
        int r22 = r2 >> 3;
        int r24 = r22 & 112;
        IndicatorRipple(r34, r37, r11, (r2 & 14) | r24);
        int r110 = r2;
        m2935Indicator3JVO9M(r35, r37, r38, r11, ((r22 & 14) | r24) | (r22 & 896));
        Modifier r29 = LayoutIdKt.layoutId(r1, IconLayoutIdTag);
        Alignment.Companion r30 = Alignment.Companion;
        MeasurePolicy r31 = BoxKt.maybeCachedBoxMeasurePolicy(r30.getTopStart(), false);
        int r32 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r33 = r11.getCurrentCompositionLocalMap();
        Modifier r36 = ComposedModifierKt.materializeModifier(r11, r29);
        Function0 r54 = r17.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L150;
        ComposablesKt.invalidApplier();
    L150:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L153;
        r11.createNode(r54);
    L154:
        Composer r55 = Updater.constructor-impl(r11);
        Updater.set-impl(r55, r31, r17.getSetMeasurePolicy());
        Updater.set-impl(r55, r33, r17.getSetResolvedCompositionLocals());
        Function2 r56 = r17.getSetCompositeKeyHash();
        if (r55.getInserting() == false) goto L157;
    L158:
        r55.updateRememberedValue(Integer.valueOf(r32));
        r55.apply(Integer.valueOf(r32), r56);
    L159:
        Updater.set-impl(r55, r36, r17.getSetModifier());
        BoxScopeInstance r57 = BoxScopeInstance.INSTANCE;
        r39.invoke(r11, Integer.valueOf((r110 >> 12) & 14));
        r11.endNode();
        if (r42 == null) goto L174;
        r11.startReplaceGroup(-987944825);
        Modifier r58 = LayoutIdKt.layoutId(r1, LabelLayoutIdTag);
        MeasurePolicy r59 = BoxKt.maybeCachedBoxMeasurePolicy(r30.getTopStart(), false);
        int r60 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r61 = r11.getCurrentCompositionLocalMap();
        Modifier r62 = ComposedModifierKt.materializeModifier(r11, r58);
        Function0 r63 = r17.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L164;
        ComposablesKt.invalidApplier();
    L164:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L167;
        r11.createNode(r63);
    L168:
        Composer r64 = Updater.constructor-impl(r11);
        Updater.set-impl(r64, r59, r17.getSetMeasurePolicy());
        Updater.set-impl(r64, r61, r17.getSetResolvedCompositionLocals());
        Function2 r65 = r17.getSetCompositeKeyHash();
        if (r64.getInserting() == false) goto L171;
    L172:
        r64.updateRememberedValue(Integer.valueOf(r60));
        r64.apply(Integer.valueOf(r60), r65);
    L173:
        Updater.set-impl(r64, r62, r17.getSetModifier());
        r42.invoke(r11, Integer.valueOf((r110 >> 21) & 14));
        r11.endNode();
        r11.endReplaceGroup();
    L175:
        r11.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L179;
        ComposerKt.traceEventEnd();
        goto L179
    L171:
        if (Intrinsics.areEqual(r64.rememberedValue(), Integer.valueOf(r60)) == true) goto L173;
    L167:
        r11.useNode();
        goto L168
    L174:
        r11.startReplaceGroup(-987864101);
        r11.endReplaceGroup();
        goto L175
    L157:
        if (Intrinsics.areEqual(r55.rememberedValue(), Integer.valueOf(r32)) == true) goto L159;
    L153:
        r11.useNode();
        goto L154
    L145:
        if (Intrinsics.areEqual(r15.rememberedValue(), Integer.valueOf(r8)) == true) goto L147;
    L141:
        r11.useNode();
        goto L142
    L134:
        float r66 = 0;
        r7 = new TopIconOrIconOnlyMeasurePolicy(false, r38, r48, r48, Dp.constructor-impl(r66), Dp.constructor-impl(r66), null);
        goto L135
    L122:
        if ((74899 & r5) != 74898) goto L125;
        r0 = false;
        goto L127
    L78:
        if (r11.changed(r45) == false) goto L80;
        r4 = 4;
    L80:
        r5 = r4 | r53;
        goto L83
    L35:
        if (r11.changedInstance(r39) == false) goto L37;
        int r67 = 16384;
    L38:
        r2 = r2 | r67;
        goto L39
    L37:
        r67 = 8192;
        goto L38
    L20:
        if (r11.changed(r37) == false) goto L22;
        int r68 = 256;
    L23:
        r2 = r2 | r68;
        goto L24
    L22:
        r68 = 128;
        goto L23
    L13:
        if (r11.changed(r35) == false) goto L15;
        int r69 = 32;
    L16:
        r2 = r2 | r69;
        goto L17
    L15:
        r69 = 16;
        goto L16
    L5:
        if (r11.changed(r34) == false) goto L7;
        int r70 = 4;
    L8:
        r2 = r70 | r52;
        goto L10
    L7:
        r70 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: NavigationItem-8Df7sds, reason: not valid java name */
    public static final void m2936NavigationItem8Df7sds(final boolean r35, final Function0<Unit> r36, final Function2<? super Composer, ? super Integer, Unit> r37, final TextStyle r38, final Shape r39, final float r40, final float r41, final float r42, final float r43, final float r44, final float r45, final NavigationItemColors r46, final Modifier r47, final boolean r48, final Function2<? super Composer, ? super Integer, Unit> r49, final int r50, final MutableInteractionSource r51, Composer r52, final int r53, final int r54) {
        Composer r5 = r52.startRestartGroup(2075155418);
        if ((r53 & 6) == 0) goto L5;
        int r1 = r53;
    L10:
        int r16 = 16;
        if ((r53 & 48) != 0) goto L18;
        if (r5.changedInstance(r36) == false) goto L15;
        int r18 = 32;
    L16:
        r1 = r1 | r18;
        goto L18
    L15:
        r18 = 16;
    L18:
        int r19 = 256;
        if ((r53 & 384) == 0) goto L21;
    L25:
        int r20 = 2048;
        if ((r53 & 3072) != 0) goto L33;
        if (r5.changed(r38) == false) goto L30;
        int r22 = 2048;
    L31:
        r1 = r1 | r22;
        goto L33
    L30:
        r22 = 1024;
    L33:
        int r23 = 8192;
        if ((r53 & 24576) != 0) goto L42;
        if (r5.changed(r39) == false) goto L38;
        int r24 = 16384;
    L39:
        r1 = r1 | r24;
        goto L42
    L38:
        r24 = 8192;
    L42:
        if ((r53 & 196608) != 0) goto L49;
        if (r5.changed(r40) == false) goto L46;
        int r25 = 131072;
    L47:
        r1 = r1 | r25;
        goto L49
    L46:
        r25 = 65536;
    L49:
        if ((r53 & 1572864) != 0) goto L56;
        if (r5.changed(r41) == false) goto L53;
        int r26 = 1048576;
    L54:
        r1 = r1 | r26;
        goto L56
    L53:
        r26 = 524288;
    L56:
        if ((r53 & 12582912) != 0) goto L63;
        if (r5.changed(r42) == false) goto L60;
        int r27 = 8388608;
    L61:
        r1 = r1 | r27;
        goto L63
    L60:
        r27 = 4194304;
    L63:
        if ((r53 & 100663296) != 0) goto L70;
        if (r5.changed(r43) == false) goto L67;
        int r28 = 67108864;
    L68:
        r1 = r1 | r28;
        goto L70
    L67:
        r28 = 33554432;
    L70:
        if ((r53 & 805306368) != 0) goto L77;
        if (r5.changed(r44) == false) goto L74;
        int r29 = 536870912;
    L75:
        r1 = r1 | r29;
        goto L77
    L74:
        r29 = 268435456;
    L77:
        if ((r54 & 6) == 0) goto L79;
        int r210 = r54;
    L85:
        if ((r54 & 48) != 0) goto L91;
        if (r5.changed(r46) == false) goto L89;
        r16 = 32;
    L89:
        r210 = r210 | r16;
    L91:
        if ((r54 & 384) != 0) goto L99;
        if (r5.changed(r47) == true) goto L96;
        r19 = 128;
    L96:
        r210 = r210 | r19;
    L99:
        if ((r54 & 3072) != 0) goto L106;
        if (r5.changed(r48) == true) goto L104;
        r20 = 1024;
    L104:
        r210 = r210 | r20;
    L106:
        if ((r54 & 24576) != 0) goto L112;
        if (r5.changedInstance(r49) == false) goto L110;
        r23 = 16384;
    L110:
        r210 = r210 | r23;
    L112:
        if ((r54 & 196608) != 0) goto L119;
        if (r5.changed(r50) == false) goto L116;
        int r0 = 131072;
    L117:
        r210 = r210 | r0;
        goto L119
    L116:
        r0 = 65536;
    L119:
        if ((r54 & 1572864) == 0) goto L121;
    L125:
        int r2 = r210;
        if ((r1 & 306783379) == 306783378) goto L128;
    L131:
        boolean r3 = true;
    L133:
        if (r5.shouldExecute(r3, r1 & 1) == true) goto L135;
        Composer r8 = r5;
        r8.skipToGroupEnd();
    L185:
        ScopeUpdateScope r9 = r8.endRestartGroup();
        if (r9 == null) goto L189;
        r9.updateScope(new fi(r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r53, r54));
        return;
    L189:
        return;
    L135:
        if (ComposerKt.isTraceInProgress() == false) goto L137;
        ComposerKt.traceEventStart(2075155418, r1, r2, "androidx.compose.material3.NavigationItem (NavigationItem.kt:245)");
    L137:
        final long r4 = r46.m2922iconColorWaAFU9c(r35, r48);
        ComposableLambda r21 = ComposableLambdaKt.rememberComposableLambda(1119868672, true, new NavigationItemKt$NavigationItem$styledIcon$1(r4, r37), r5, 54);
        if (r49 != null) goto L140;
        r5.startReplaceGroup(-803302356);
        r5.endReplaceGroup();
        r8 = r5;
        Function2 r10 = null;
    L141:
        Object r6 = r8.rememberedValue();
        Composer.Companion r211 = Composer.Companion;
        if (r6 != r211.getEmpty()) goto L144;
        r6 = SnapshotIntStateKt.mutableIntStateOf(0);
        r8.updateRememberedValue(r6);
    L144:
        MutableIntState r7 = (MutableIntState) r6;
        Modifier r11 = SizeKt.m998defaultMinSizeVpY3zN4(SelectableKt.m1289selectableO2vRcR0(r47, r35, r51, null, r48, Role.box-impl(Role.Companion.getTab-o7Vup1c()), r36), ((Dp) r8.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl(), ((Dp) r8.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl());
        Object r12 = r8.rememberedValue();
        if (r12 != r211.getEmpty()) goto L147;
        final MutableIntState r13 = r7;
        r12 = new di(r13);
        r8.updateRememberedValue(r12);
    L148:
        Modifier r14 = OnRemeasuredModifierKt.onSizeChanged(r11, (Function1) r12);
        MeasurePolicy r15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), true);
        int r17 = ComposablesKt.getCurrentCompositeKeyHash(r8, 0);
        CompositionLocalMap r30 = r8.getCurrentCompositionLocalMap();
        Modifier r31 = ComposedModifierKt.materializeModifier(r8, r14);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r32 = r110.getConstructor();
        if ((r8.getApplier() instanceof Applier) == true) goto L151;
        ComposablesKt.invalidApplier();
    L151:
        r8.startReusableNode();
        if (r8.getInserting() == false) goto L154;
        r8.createNode(r32);
    L155:
        Composer r33 = Updater.constructor-impl(r8);
        Updater.set-impl(r33, r15, r110.getSetMeasurePolicy());
        Updater.set-impl(r33, r30, r110.getSetResolvedCompositionLocals());
        Function2 r34 = r110.getSetCompositeKeyHash();
        if (r33.getInserting() == false) goto L158;
    L159:
        r33.updateRememberedValue(Integer.valueOf(r17));
        r33.apply(Integer.valueOf(r17), r34);
    L160:
        Updater.set-impl(r33, r31, r110.getSetModifier());
        BoxScopeInstance r55 = BoxScopeInstance.INSTANCE;
        final State<Float> r56 = animateIndicatorProgressAsState(r35, r8, r1 & 14);
        if (NavigationItemIconPosition.m2927equalsimpl0(r50, NavigationItemIconPosition.Companion.m2932getTopxw1Ddg()) == false) goto L172;
        r8.startReplaceGroup(484755993);
        Density r57 = (Density) r8.consume(CompositionLocalsKt.getLocalDensity());
        float r58 = (NavigationItem_8Df7sds$lambda$1(r13) - r57.roundToPx-0680j_4(r40)) / 2;
        float r59 = r57.toPx-0680j_4(IndicatorVerticalOffset);
        long r60 = Offset.constructor-impl((Float.floatToRawIntBits(r58) << 32) | (Float.floatToRawIntBits(r59) & 4294967295L));
        Unit r61 = Unit.INSTANCE;
        if ((r2 & 3670016) != 1048576) goto L165;
        boolean r111 = true;
    L166:
        boolean r62 = r111 | r8.changed(r60);
        Object r63 = r8.rememberedValue();
        if (r62 == false) goto L169;
    L170:
        r63 = new MappedInteractionSource(r51, r60, null);
        r8.updateRememberedValue(r63);
    L171:
        MutableInteractionSource r64 = (MappedInteractionSource) r63;
        r8.endReplaceGroup();
    L173:
        if (r64 == null) goto L175;
        MutableInteractionSource r112 = r64;
    L176:
        long r113 = r46.m2918getSelectedIndicatorColor0d7_KjU();
        boolean r65 = r8.changed(r56);
        Object r66 = r8.rememberedValue();
        if (r65 == false) goto L179;
    L180:
        r66 = new ei(r56);
        r8.updateRememberedValue(r66);
    L181:
        int r67 = (((r1 >> 6) & 896) | 3072) | ((r19 >> 3) & 57344);
        int r68 = r1 << 3;
        m2937NavigationItemLayoutKmRXDg(r112, r113, r39, r21, r50, r10, (Function0) r66, r41, r42, r43, r44, r45, r8, ((r67 | (29360128 & r68)) | (234881024 & r68)) | (r68 & 1879048192), ((r1 >> 27) & 14) | ((r19 << 3) & 112));
        r8.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L185;
        ComposerKt.traceEventEnd();
        goto L185
    L179:
        if (r66 != r211.getEmpty()) goto L181;
    L175:
        r112 = r51;
        goto L176
    L169:
        if (r63 != r211.getEmpty()) goto L171;
    L165:
        r111 = false;
        goto L166
    L172:
        r8.startReplaceGroup(485471938);
        r8.endReplaceGroup();
        r64 = null;
        goto L173
    L158:
        if (Intrinsics.areEqual(r33.rememberedValue(), Integer.valueOf(r17)) == true) goto L160;
    L154:
        r8.useNode();
        goto L155
    L147:
        r13 = r7;
        goto L148
    L140:
        r5.startReplaceGroup(-803266737);
        r8 = r5;
        Function2 r69 = ComposableLambdaKt.rememberComposableLambda(1062206119, true, new NavigationItemKt$NavigationItem$styledLabel$1(r35, r38, r46, r48, r49), r8, 54);
        r8.endReplaceGroup();
        r10 = r69;
        goto L141
    L128:
        if ((599187 & r2) != 599186) goto L131;
        r3 = false;
        goto L133
    L121:
        if (r5.changed(r51) == false) goto L123;
        int r70 = 1048576;
    L124:
        r210 = r210 | r70;
        goto L125
    L123:
        r70 = 524288;
        goto L124
    L79:
        if (r5.changed(r45) == false) goto L81;
        int r212 = 4;
    L82:
        r210 = r54 | r212;
        goto L85
    L81:
        r212 = 2;
        goto L82
    L21:
        if (r5.changedInstance(r37) == false) goto L23;
        int r71 = 256;
    L24:
        r1 = r1 | r71;
        goto L25
    L23:
        r71 = 128;
        goto L24
    L5:
        if (r5.changed(r35) == false) goto L7;
        int r72 = 4;
    L8:
        r1 = r72 | r53;
        goto L10
    L7:
        r72 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: AnimatedNavigationItem-DQd_Gtc, reason: not valid java name */
    public static final void m2933AnimatedNavigationItemDQd_Gtc(final boolean r40, final Function0<Unit> r41, final Function2<? super Composer, ? super Integer, Unit> r42, final Shape r43, final float r44, final TextStyle r45, final TextStyle r46, final float r47, final float r48, final float r49, final float r50, final float r51, final float r52, final float r53, final float r54, final NavigationItemColors r55, final Modifier r56, final boolean r57, final Function2<? super Composer, ? super Integer, Unit> r58, final int r59, final MutableInteractionSource r60, Composer r61, final int r62, final int r63, final int r64) {
        Composer r3 = r61.startRestartGroup(-1114086313);
        if ((r62 & 6) == 0) goto L5;
        int r1 = r62;
    L10:
        int r18 = 16;
        if ((r62 & 48) == 0) goto L13;
    L17:
        int r19 = 256;
        if ((r62 & 384) == 0) goto L20;
    L24:
        int r21 = 2048;
        if ((r62 & 3072) != 0) goto L32;
        if (r3.changed(r43) == false) goto L29;
        int r23 = 2048;
    L30:
        r1 = r1 | r23;
        goto L32
    L29:
        r23 = 1024;
    L32:
        int r24 = 8192;
        if ((r62 & 24576) != 0) goto L40;
        if (r3.changed(r44) == false) goto L37;
        int r0 = 16384;
    L38:
        r1 = r1 | r0;
        goto L40
    L37:
        r0 = 8192;
    L40:
        if ((r62 & 196608) != 0) goto L47;
        if (r3.changed(r45) == false) goto L44;
        int r25 = 131072;
    L45:
        r1 = r1 | r25;
        goto L47
    L44:
        r25 = 65536;
    L47:
        if ((r62 & 1572864) != 0) goto L54;
        if (r3.changed(r46) == false) goto L51;
        int r26 = 1048576;
    L52:
        r1 = r1 | r26;
        goto L54
    L51:
        r26 = 524288;
    L54:
        if ((r62 & 12582912) != 0) goto L61;
        if (r3.changed(r47) == false) goto L58;
        int r27 = 8388608;
    L59:
        r1 = r1 | r27;
        goto L61
    L58:
        r27 = 4194304;
    L61:
        if ((r62 & 100663296) != 0) goto L68;
        if (r3.changed(r48) == false) goto L65;
        int r28 = 67108864;
    L66:
        r1 = r1 | r28;
        goto L68
    L65:
        r28 = 33554432;
    L68:
        if ((r62 & 805306368) != 0) goto L75;
        if (r3.changed(r49) == false) goto L72;
        int r29 = 536870912;
    L73:
        r1 = r1 | r29;
        goto L75
    L72:
        r29 = 268435456;
    L75:
        if ((r63 & 6) == 0) goto L77;
        int r210 = r63;
    L83:
        if ((r63 & 48) != 0) goto L89;
        if (r3.changed(r51) == false) goto L87;
        r18 = 32;
    L87:
        r210 = r210 | r18;
    L89:
        if ((r63 & 384) != 0) goto L97;
        if (r3.changed(r52) == true) goto L94;
        r19 = 128;
    L94:
        r210 = r210 | r19;
    L97:
        if ((r63 & 3072) != 0) goto L105;
        if (r3.changed(r53) == true) goto L102;
        r21 = 1024;
    L102:
        r210 = r210 | r21;
    L105:
        if ((r63 & 24576) != 0) goto L112;
        if (r3.changed(r54) == false) goto L109;
        r24 = 16384;
    L109:
        r210 = r210 | r24;
    L112:
        if ((r63 & 196608) != 0) goto L119;
        if (r3.changed(r55) == false) goto L116;
        int r110 = 131072;
    L117:
        r210 = r210 | r110;
        goto L119
    L116:
        r110 = 65536;
    L119:
        if ((r63 & 1572864) != 0) goto L126;
        if (r3.changed(r56) == false) goto L123;
        int r111 = 1048576;
    L124:
        r210 = r210 | r111;
        goto L126
    L123:
        r111 = 524288;
    L126:
        if ((r63 & 12582912) != 0) goto L133;
        if (r3.changed(r57) == false) goto L130;
        int r112 = 8388608;
    L131:
        r210 = r210 | r112;
        goto L133
    L130:
        r112 = 4194304;
    L133:
        if ((r63 & 100663296) != 0) goto L140;
        if (r3.changedInstance(r58) == false) goto L137;
        int r113 = 67108864;
    L138:
        r210 = r210 | r113;
        goto L140
    L137:
        r113 = 33554432;
    L140:
        if ((r63 & 805306368) == 0) goto L142;
    L146:
        int r9 = r210;
        if ((r64 & 6) == 0) goto L149;
        int r211 = r64;
    L155:
        if ((r1 & 306783379) != 306783378) goto L163;
        if ((306783379 & r9) != 306783378) goto L163;
        if ((r211 & 3) != 2) goto L163;
        boolean r2 = false;
    L165:
        if (r3.shouldExecute(r2, r1 & 1) == true) goto L167;
        Composer r14 = r3;
        r14.skipToGroupEnd();
    L226:
        ScopeUpdateScope r15 = r14.endRestartGroup();
        if (r15 == null) goto L230;
        r15.updateScope(new uh(r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r62, r63, r64));
        return;
    L230:
        return;
    L167:
        if (ComposerKt.isTraceInProgress() == false) goto L169;
        ComposerKt.traceEventStart(-1114086313, r1, r9, "androidx.compose.material3.AnimatedNavigationItem (NavigationItem.kt:343)");
    L169:
        int r4 = r1;
        final long r5 = r55.m2922iconColorWaAFU9c(r40, r57);
        ComposableLambda r13 = ComposableLambdaKt.rememberComposableLambda(851124593, true, new NavigationItemKt$AnimatedNavigationItem$styledIcon$1(r5, r42), r3, 54);
        Object r6 = r3.rememberedValue();
        Composer.Companion r212 = Composer.Companion;
        if (r6 != r212.getEmpty()) goto L172;
        r6 = SnapshotIntStateKt.mutableIntStateOf(0);
        r3.updateRememberedValue(r6);
    L172:
        final MutableIntState r7 = (MutableIntState) r6;
        r14 = r3;
        Modifier r8 = SizeKt.m998defaultMinSizeVpY3zN4(SelectableKt.m1289selectableO2vRcR0(r56, r40, r60, null, r57, Role.box-impl(Role.Companion.getTab-o7Vup1c()), r41), ((Dp) r14.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl(), ((Dp) r14.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl());
        Object r10 = r14.rememberedValue();
        if (r10 != r212.getEmpty()) goto L175;
        r10 = new qh(r7);
        r14.updateRememberedValue(r10);
    L175:
        Modifier r11 = OnRemeasuredModifierKt.onSizeChanged(r8, (Function1) r10);
        MeasurePolicy r12 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), true);
        int r16 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r17 = r14.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r14, r11);
        ComposeUiNode.Companion r22 = ComposeUiNode.Companion;
        Function0 r30 = r22.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L178;
        ComposablesKt.invalidApplier();
    L178:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L181;
        r14.createNode(r30);
    L182:
        Composer r31 = Updater.constructor-impl(r14);
        Updater.set-impl(r31, r12, r22.getSetMeasurePolicy());
        Updater.set-impl(r31, r17, r22.getSetResolvedCompositionLocals());
        Function2 r32 = r22.getSetCompositeKeyHash();
        if (r31.getInserting() == false) goto L185;
    L186:
        r31.updateRememberedValue(Integer.valueOf(r16));
        r31.apply(Integer.valueOf(r16), r32);
    L187:
        Updater.set-impl(r31, r20, r22.getSetModifier());
        BoxScopeInstance r33 = BoxScopeInstance.INSTANCE;
        final boolean r34 = NavigationItemIconPosition.m2927equalsimpl0(r59, NavigationItemIconPosition.Companion.m2932getTopxw1Ddg());
        final State<Float> r35 = animateIndicatorProgressAsState(r40, r14, r4 & 14);
        if (r34 == false) goto L190;
        float r114 = MenuKt.ClosedAlphaTarget;
    L191:
        final State<Float> r36 = AnimateAsStateKt.animateFloatAsState(r114, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r14, 6), MenuKt.ClosedAlphaTarget, null, null, r14, 0, 28);
        Object r37 = r14.rememberedValue();
        if (r37 != r212.getEmpty()) goto L194;
        r37 = SnapshotStateKt.derivedStateOf(new rh(r34, r45, r46, r36));
        r14.updateRememberedValue(r37);
    L194:
        final State r115 = (State) r37;
        boolean r116 = false;
        if (r58 == null) goto L197;
        r14.startReplaceGroup(680212713);
        MutableInteractionSource r117 = null;
        ComposableLambda r38 = ComposableLambdaKt.rememberComposableLambda(22475789, true, new NavigationItemKt$AnimatedNavigationItem$2$styledLabel$1(r40, r55, r57, r58, r115), r14, 54);
        r14.endReplaceGroup();
    L198:
        if (r34 == false) goto L208;
        r14.startReplaceGroup(680694081);
        Density r39 = (Density) r14.consume(CompositionLocalsKt.getLocalDensity());
        float r65 = (AnimatedNavigationItem_DQd_Gtc$lambda$12(r7) - r39.roundToPx-0680j_4(r44)) / 2;
        float r66 = r39.toPx-0680j_4(IndicatorVerticalOffset);
        long r67 = Offset.constructor-impl((Float.floatToRawIntBits(r65) << 32) | (((long) Float.floatToRawIntBits(r66)) & 4294967295L));
        Unit r68 = Unit.INSTANCE;
        if ((r211 & 14) != 4) goto L202;
        r116 = true;
    L202:
        boolean r69 = r116 | r14.changed(r67);
        Object r70 = r14.rememberedValue();
        if (r69 == false) goto L205;
    L206:
        r70 = new MappedInteractionSource(r60, r67, r117);
        r14.updateRememberedValue(r70);
    L207:
        MutableInteractionSource r71 = (MappedInteractionSource) r70;
        r14.endReplaceGroup();
    L209:
        if (r71 == null) goto L211;
        MutableInteractionSource r118 = r71;
    L212:
        long r119 = r55.m2918getSelectedIndicatorColor0d7_KjU();
        boolean r72 = r14.changed(r35);
        Object r73 = r14.rememberedValue();
        if (r72 == false) goto L215;
    L216:
        r73 = new sh(r35);
        r14.updateRememberedValue(r73);
    L217:
        Function0 r213 = (Function0) r73;
        boolean r74 = r14.changed(r36);
        Object r75 = r14.rememberedValue();
        if (r74 == false) goto L220;
    L221:
        r75 = new th(r36);
        r14.updateRememberedValue(r75);
    L222:
        int r76 = (((r4 >> 3) & 896) | 24576) | ((r9 >> 12) & 458752);
        int r77 = r4 << 3;
        int r310 = (r76 | (234881024 & r77)) | (r77 & 1879048192);
        int r78 = (r4 >> 27) & 14;
        int r79 = r9 << 3;
        m2934AnimatedNavigationItemLayouthe0WsC4(r118, r119, r43, r213, r13, r59, (Function0) r75, r38, r47, r48, r49, r50, r51, r52, r53, r54, r14, r310, ((((r78 | (r79 & 112)) | (r79 & 896)) | (r79 & 7168)) | (57344 & r79)) | (r79 & 458752));
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L226;
        ComposerKt.traceEventEnd();
        goto L226
    L220:
        if (r75 != r212.getEmpty()) goto L222;
    L215:
        if (r73 != r212.getEmpty()) goto L217;
    L211:
        r118 = r60;
        goto L212
    L205:
        if (r70 != r212.getEmpty()) goto L207;
    L208:
        r14.startReplaceGroup(681416753);
        r14.endReplaceGroup();
        r71 = r117;
        goto L209
    L197:
        r117 = null;
        r14.startReplaceGroup(680534989);
        r14.endReplaceGroup();
        r38 = null;
        goto L198
    L190:
        r114 = 1.0f;
        goto L191
    L185:
        if (Intrinsics.areEqual(r31.rememberedValue(), Integer.valueOf(r16)) == true) goto L187;
    L181:
        r14.useNode();
    L163:
        r2 = true;
        goto L165
    L149:
        if (r3.changed(r60) == false) goto L151;
        int r120 = 4;
    L152:
        r211 = r64 | r120;
        goto L155
    L151:
        r120 = 2;
        goto L152
    L142:
        if (r3.changed(r59) == false) goto L144;
        int r121 = 536870912;
    L145:
        r210 = r210 | r121;
        goto L146
    L144:
        r121 = 268435456;
        goto L145
    L77:
        if (r3.changed(r50) == false) goto L79;
        int r214 = 4;
    L80:
        r210 = r63 | r214;
        goto L83
    L79:
        r214 = 2;
        goto L80
    L20:
        if (r3.changedInstance(r42) == false) goto L22;
        int r80 = 256;
    L23:
        r1 = r1 | r80;
        goto L24
    L22:
        r80 = 128;
        goto L23
    L13:
        if (r3.changedInstance(r41) == false) goto L15;
        int r122 = 32;
    L16:
        r1 = r1 | r122;
        goto L17
    L15:
        r122 = 16;
        goto L16
    L5:
        if (r3.changed(r40) == false) goto L7;
        int r81 = 4;
    L8:
        r1 = r81 | r62;
        goto L10
    L7:
        r81 = 2;
        goto L8
    }
}
