package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aw\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0081\u0001\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00132\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010\u001f\u001a\u00020\u00012\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\n2\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0015H\u0003¢\u0006\u0002\u0010%\u001a5\u0010&\u001a\u00020'*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100\u001aM\u00101\u001a\u00020'*\u00020(2\u0006\u00102\u001a\u00020*2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u00103\u001a\u00020#H\u0002¢\u0006\u0004\b4\u00105\"\u000e\u00106\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010;\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\b=\u0010>\"\u0010\u0010@\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0016\u0010A\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bB\u0010>\"\u0016\u0010C\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bD\u0010>\"\u0016\u0010E\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bF\u0010>\"\u0010\u0010G\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010H\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010I\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020L0KX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010N¨\u0006O²\u0006\n\u0010P\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", NavigationRailKt.IconLayoutIdTag, "enabled", NavigationRailKt.LabelLayoutIdTag, "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", NavigationRailKt.IndicatorRippleLayoutIdTag, NavigationRailKt.IndicatorLayoutIdTag, "alphaAnimationProgress", "", "sizeAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "animationProgress", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationRailVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getNavigationRailVerticalPadding", "()F", "F", "NavigationRailHeaderPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailItemHeight", "getNavigationRailItemHeight", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPaddingWithLabel", "IndicatorVerticalPaddingNoLabel", "LocalNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/NavigationRailOverride;", "getLocalNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3", "iconColor", "textColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding = 0.0f;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel = 0.0f;
    private static final float IndicatorVerticalPaddingWithLabel = 0.0f;
    private static final String LabelLayoutIdTag = "label";
    private static final ProvidableCompositionLocal<NavigationRailOverride> LocalNavigationRailOverride = null;
    private static final float NavigationRailHeaderPadding = 0.0f;
    private static final float NavigationRailItemHeight = 0.0f;
    private static final float NavigationRailItemVerticalPadding = 0.0f;
    private static final float NavigationRailItemWidth = 0.0f;
    private static final float NavigationRailVerticalPadding = 0.0f;

    static {
        float r0 = 4;
        NavigationRailVerticalPadding = Dp.constructor-impl(r0);
        NavigationRailHeaderPadding = Dp.constructor-impl(8);
        NavigationRailItemWidth = NavigationRailCollapsedTokens.INSTANCE.getNarrowContainerWidth-D9Ej5fM();
        NavigationRailVerticalItemTokens r1 = NavigationRailVerticalItemTokens.INSTANCE;
        NavigationRailItemHeight = r1.getActiveIndicatorWidth-D9Ej5fM();
        NavigationRailItemVerticalPadding = Dp.constructor-impl(r0);
        float r2 = r1.getActiveIndicatorWidth-D9Ej5fM();
        NavigationRailBaselineItemTokens r3 = NavigationRailBaselineItemTokens.INSTANCE;
        float r4 = 2;
        IndicatorHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(r2 - r3.getIconSize-D9Ej5fM()) / r4);
        IndicatorVerticalPaddingWithLabel = Dp.constructor-impl(Dp.constructor-impl(r1.getActiveIndicatorHeight-D9Ej5fM() - r3.getIconSize-D9Ej5fM()) / r4);
        IndicatorVerticalPaddingNoLabel = Dp.constructor-impl(Dp.constructor-impl(r1.getActiveIndicatorWidth-D9Ej5fM() - r3.getIconSize-D9Ej5fM()) / r4);
        LocalNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new ki(), 1, null);
    }

    private static final Unit NavigationRailItem$lambda$11(boolean r13, Function0 r14, Function2 r15, Modifier r16, boolean r17, Function2 r18, boolean r19, NavigationRailItemColors r20, MutableInteractionSource r21, int r22, int r23, Composer r24, int r25) {
        NavigationRailItem(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit NavigationRailItemLayout$lambda$18(Function2 r10, Function2 r11, Function2 r12, Function2 r13, boolean r14, Function0 r15, Function0 r16, int r17, Composer r18, int r19) {
        NavigationRailItemLayout(r10, r11, r12, r13, r14, r15, r16, r18, RecomposeScopeImplKt.updateChangedFlags(r17 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit NavigationRail_qi6gXK8$lambda$1(Modifier r12, long r13, long r15, Function3 r17, WindowInsets r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        m2960NavigationRailqi6gXK8(r12, r13, r15, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, long r1, long r3, Function3 r5, WindowInsets r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return NavigationRail_qi6gXK8$lambda$1(r0, r1, r3, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit b(Function2 r0, Function2 r1, Function2 r2, Function2 r3, boolean r4, Function0 r5, Function0 r6, int r7, Composer r8, int r9) {
        return NavigationRailItemLayout$lambda$18(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ float c(State r0) {
        return NavigationRailItem$lambda$10$lambda$7$lambda$6(r0);
    }

    public static /* synthetic */ NavigationRailOverride d() {
        return LocalNavigationRailOverride$lambda$23();
    }

    public static /* synthetic */ float e(State r0) {
        return NavigationRailItem$lambda$10$lambda$9$lambda$8(r0);
    }

    public static /* synthetic */ Unit f(boolean r0, Function0 r1, Function2 r2, Modifier r3, boolean r4, Function2 r5, boolean r6, NavigationRailItemColors r7, MutableInteractionSource r8, int r9, int r10, Composer r11, int r12) {
        return NavigationRailItem$lambda$11(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit g(boolean r0, Function0 r1, GraphicsLayerScope r2) {
        return NavigationRailItemLayout$lambda$17$lambda$15$lambda$14(r0, r1, r2);
    }

    public static /* synthetic */ Unit h(Placeable r0, Placeable r1, int r2, int r3, Placeable r4, int r5, int r6, int r7, int r8, Placeable.PlacementScope r9) {
        return placeIcon_X9ElhV4$lambda$20(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit i(Placeable r0, boolean r1, float r2, Placeable r3, int r4, float r5, float r6, Placeable r7, int r8, float r9, Placeable r10, int r11, float r12, int r13, MeasureScope r14, Placeable.PlacementScope r15) {
        return placeLabelAndIcon_zUg2_y0$lambda$22(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    private static final NavigationRailOverride LocalNavigationRailOverride$lambda$23() {
        return DefaultNavigationRailOverride.INSTANCE;
    }

    public static final /* synthetic */ float access$getIndicatorHorizontalPadding$p() {
        return IndicatorHorizontalPadding;
    }

    public static final /* synthetic */ float access$getIndicatorVerticalPaddingNoLabel$p() {
        return IndicatorVerticalPaddingNoLabel;
    }

    public static final /* synthetic */ float access$getIndicatorVerticalPaddingWithLabel$p() {
        return IndicatorVerticalPaddingWithLabel;
    }

    public static final /* synthetic */ float access$getNavigationRailHeaderPadding$p() {
        return NavigationRailHeaderPadding;
    }

    public static final ProvidableCompositionLocal<NavigationRailOverride> getLocalNavigationRailOverride() {
        return LocalNavigationRailOverride;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    private static final float NavigationRailItem$lambda$10$lambda$7$lambda$6(State r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final float NavigationRailItem$lambda$10$lambda$9$lambda$8(State r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final Unit NavigationRailItemLayout$lambda$17$lambda$15$lambda$14(boolean r0, Function0 r1, GraphicsLayerScope r2) {
        if (r0 == false) goto L4;
        float r3 = 1.0f;
    L5:
        r2.setAlpha(r3);
        return Unit.INSTANCE;
    L4:
        r3 = ((Number) r1.invoke()).floatValue();
        goto L5
    }

    /* JADX INFO: renamed from: access$placeIcon-X9ElhV4, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m2961access$placeIconX9ElhV4(MeasureScope r0, Placeable r1, Placeable r2, Placeable r3, long r4) {
        return m2963placeIconX9ElhV4(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    private static final MeasureResult m2963placeIconX9ElhV4(MeasureScope r16, final Placeable r17, final Placeable r18, final Placeable r19, long r20) {
        int r2 = r17.getWidth();
        int r3 = r18.getWidth();
        if (r19 == null) goto L5;
        int r4 = r19.getWidth();
    L6:
        final int r5 = ConstraintsKt.constrainWidth-K40F9xA(r20, Math.max(r2, Math.max(r3, r4)));
        final int r0 = ConstraintsKt.constrainHeight-K40F9xA(r20, r16.roundToPx-0680j_4(NavigationRailItemHeight));
        final int r7 = (r5 - r17.getWidth()) / 2;
        final int r8 = (r0 - r17.getHeight()) / 2;
        final int r10 = (r5 - r18.getWidth()) / 2;
        final int r11 = (r0 - r18.getHeight()) / 2;
        return MeasureScope.-CC.layout$default(r16, r5, r0, null, new li(r19, r17, r7, r8, r18, r10, r11, r5, r0), 4, null);
    L5:
        r4 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: access$placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m2962access$placeLabelAndIconzUg2_y0(MeasureScope r0, Placeable r1, Placeable r2, Placeable r3, Placeable r4, long r5, boolean r7, float r8) {
        return m2964placeLabelAndIconzUg2_y0(r0, r1, r2, r3, r4, r5, r7, r8);
    }

    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    private static final MeasureResult m2964placeLabelAndIconzUg2_y0(final MeasureScope r20, final Placeable r21, final Placeable r22, final Placeable r23, final Placeable r24, long r25, final boolean r27, final float r28) {
        float r0 = r22.getHeight();
        float r1 = IndicatorVerticalPaddingWithLabel;
        float r2 = r0 + r20.toPx-0680j_4(r1);
        float r3 = NavigationRailItemVerticalPadding;
        float r4 = (r2 + r20.toPx-0680j_4(r3)) + r21.getHeight();
        float r5 = 2;
        final float r10 = RangesKt.coerceAtLeast((Constraints.getMinHeight-impl(r25) - r4) / r5, r20.toPx-0680j_4(r1));
        float r6 = r4 + (r10 * r5);
        if (r27 == false) goto L5;
        float r7 = r10;
    L6:
        final float r8 = (r7 - r10) * (1 - r28);
        final float r9 = ((r22.getHeight() + r10) + r20.toPx-0680j_4(r1)) + r20.toPx-0680j_4(r3);
        int r11 = r22.getWidth();
        int r12 = r21.getWidth();
        if (r24 == null) goto L9;
        int r13 = r24.getWidth();
    L10:
        final int r16 = ConstraintsKt.constrainWidth-K40F9xA(r25, Math.max(r11, Math.max(r12, r13)));
        final int r14 = (r16 - r21.getWidth()) / 2;
        final int r15 = (r16 - r22.getWidth()) / 2;
        final int r17 = (r16 - r23.getWidth()) / 2;
        final float r18 = r10 - r20.toPx-0680j_4(r1);
        return MeasureScope.-CC.layout$default(r20, r16, MathKt.roundToInt(r6), null, new pi(r24, r27, r28, r21, r14, r9, r8, r22, r15, r10, r23, r17, r18, r16, r20), 4, null);
    L9:
        r13 = 0;
        goto L10
    L5:
        r7 = (r6 - r22.getHeight()) / r5;
        goto L6
    }

    /* JADX INFO: renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    public static final void m2960NavigationRailqi6gXK8(Modifier r24, long r25, long r27, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r29, WindowInsets r30, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r31, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(331386280);
        int r2 = r34 & 1;
        if (r2 == 0) goto L6;
        int r4 = r33 | 6;
        Modifier r3 = r24;
    L14:
        if ((r33 & 48) == 0) goto L16;
        long r5 = r25;
    L25:
        if ((r33 & 384) == 0) goto L27;
        long r7 = r27;
    L35:
        int r10 = r34 & 8;
        if (r10 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r11 = r29;
    L47:
        if ((r33 & 24576) == 0) goto L49;
        WindowInsets r12 = r30;
    L58:
        if ((r34 & 32) == 0) goto L61;
        r4 = r4 | 196608;
    L69:
        if ((74899 & r4) == 74898) goto L71;
        boolean r14 = true;
    L73:
        if (r1.shouldExecute(r14, r4 & 1) == false) goto L109;
        r1.startDefaults();
        if ((r33 & 1) != 0) goto L77;
    L89:
        if (r2 == 0) goto L91;
        Modifier r6 = Modifier.Companion;
    L93:
        if ((r34 & 2) == 0) goto L96;
        r5 = NavigationRailDefaults.INSTANCE.getContainerColor(r1, 6);
        r4 = r4 & (-113);
    L96:
        if ((r34 & 4) == 0) goto L98;
        r7 = ColorSchemeKt.m2496contentColorForek8zF_U(r5, r1, (r4 >> 3) & 14);
        r4 = r4 & (-897);
    L98:
        if (r10 == 0) goto L101;
        r11 = null;
    L101:
        if ((r34 & 16) == 0) goto L103;
        r4 = r4 & (-57345);
        r12 = NavigationRailDefaults.INSTANCE.getWindowInsets(r1, 6);
    L103:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventStart(331386280, r4, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:126)");
    L106:
        ((NavigationRailOverride) r1.consume(LocalNavigationRailOverride)).NavigationRail(new NavigationRailOverrideScope(r6, r5, r7, r11, r12, r31, null), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L110;
        ComposerKt.traceEventEnd();
    L110:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L114;
        final Modifier r8 = r6;
        final long r9 = r5;
        final long r13 = r7;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r16 = r11;
        final WindowInsets r17 = r12;
        r15.updateScope(new ji(r8, r9, r13, r16, r17, r31, r33, r34));
        return;
    L114:
        return;
    L91:
        r6 = r3;
        goto L93
    L77:
        if (r1.getDefaultsInvalid() == true) goto L89;
        r1.skipToGroupEnd();
        if ((r34 & 2) == 0) goto L83;
        r4 = r4 & (-113);
    L83:
        if ((r34 & 4) == 0) goto L86;
        r4 = r4 & (-897);
    L86:
        if ((r34 & 16) == 0) goto L88;
        r4 = r4 & (-57345);
    L88:
        r6 = r3;
        goto L103
    L109:
        r1.skipToGroupEnd();
        r6 = r3;
        goto L110
    L71:
        r14 = false;
        goto L73
    L61:
        if ((r33 & 196608) != 0) goto L69;
        if (r1.changedInstance(r31) == false) goto L65;
        int r18 = 131072;
    L66:
        r4 = r4 | r18;
        goto L69
    L65:
        r18 = 65536;
        goto L66
    L49:
        if ((r34 & 16) != 0) goto L53;
        r12 = r30;
        if (r1.changed(r12) == false) goto L54;
        int r19 = 16384;
    L55:
        r4 = r4 | r19;
    L54:
        r19 = 8192;
        goto L55
    L53:
        r12 = r30;
        goto L54
    L39:
        if ((r33 & 3072) != 0) goto L45;
        r11 = r29;
        if (r1.changedInstance(r11) == false) goto L43;
        int r110 = 2048;
    L44:
        r4 = r4 | r110;
        goto L47
    L43:
        r110 = 1024;
        goto L44
    L27:
        if ((r34 & 4) != 0) goto L31;
        r7 = r27;
        if (r1.changed(r7) == false) goto L32;
        int r111 = 256;
    L33:
        r4 = r4 | r111;
    L32:
        r111 = 128;
        goto L33
    L31:
        r7 = r27;
        goto L32
    L16:
        if ((r34 & 2) != 0) goto L20;
        r5 = r25;
        if (r1.changed(r5) == false) goto L21;
        int r20 = 32;
    L22:
        r4 = r4 | r20;
    L21:
        r20 = 16;
        goto L22
    L20:
        r5 = r25;
        goto L21
    L6:
        if ((r33 & 6) != 0) goto L12;
        r3 = r24;
        if (r1.changed(r3) == false) goto L10;
        int r21 = 4;
    L11:
        r4 = r21 | r33;
        goto L14
    L10:
        r21 = 2;
        goto L11
    L12:
        r3 = r24;
        r4 = r33;
        goto L14
    }

    private static final void NavigationRailItemLayout(final Function2<? super Composer, ? super Integer, Unit> r18, final Function2<? super Composer, ? super Integer, Unit> r19, final Function2<? super Composer, ? super Integer, Unit> r20, final Function2<? super Composer, ? super Integer, Unit> r21, final boolean r22, final Function0<Float> r23, final Function0<Float> r24, Composer r25, final int r26) {
        Composer r9 = r25.startRestartGroup(-759267492);
        if ((r26 & 6) == 0) goto L5;
        int r10 = r26;
    L11:
        if ((r26 & 48) != 0) goto L18;
        if (r9.changedInstance(r19) == false) goto L15;
        int r11 = 32;
    L16:
        r10 = r10 | r11;
        goto L18
    L15:
        r11 = 16;
    L18:
        if ((r26 & 384) != 0) goto L25;
        if (r9.changedInstance(r20) == false) goto L22;
        int r12 = 256;
    L23:
        r10 = r10 | r12;
        goto L25
    L22:
        r12 = 128;
    L25:
        if ((r26 & 3072) != 0) goto L32;
        if (r9.changedInstance(r21) == false) goto L29;
        int r13 = 2048;
    L30:
        r10 = r10 | r13;
        goto L32
    L29:
        r13 = 1024;
    L32:
        if ((r26 & 24576) != 0) goto L39;
        if (r9.changed(r22) == false) goto L36;
        int r14 = 16384;
    L37:
        r10 = r10 | r14;
        goto L39
    L36:
        r14 = 8192;
    L39:
        if ((196608 & r26) != 0) goto L46;
        if (r9.changedInstance(r23) == false) goto L43;
        int r15 = 131072;
    L44:
        r10 = r10 | r15;
        goto L46
    L43:
        r15 = 65536;
    L46:
        if ((1572864 & r26) == 0) goto L48;
    L52:
        boolean r16 = true;
        if ((599187 & r10) == 599186) goto L55;
        boolean r17 = true;
    L57:
        if (r9.shouldExecute(r17, r10 & 1) == true) goto L59;
        r9.skipToGroupEnd();
    L135:
        ScopeUpdateScope r27 = r9.endRestartGroup();
        if (r27 == null) goto L139;
        r27.updateScope(new ii(r18, r19, r20, r21, r22, r23, r24, r26));
        return;
    L139:
        return;
    L59:
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventStart(-759267492, r10, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:557)");
    L61:
        Modifier.Companion r0 = Modifier.Companion;
        Modifier r110 = BadgeKt.badgeBounds(r0);
        if ((3670016 & r10) != 1048576) goto L64;
        boolean r111 = true;
    L66:
        if ((r10 & 7168) != 2048) goto L68;
        boolean r112 = true;
    L69:
        boolean r113 = r112 | r111;
        int r114 = 57344 & r10;
        if (r114 != 16384) goto L72;
        boolean r115 = true;
    L73:
        boolean r116 = r113 | r115;
        Object r117 = r9.rememberedValue();
        if (r116 == false) goto L76;
    L77:
        r117 = new NavigationRailKt$NavigationRailItemLayout$1$1(r24, r21, r22);
        r9.updateRememberedValue(r117);
    L78:
        MeasurePolicy r118 = (MeasurePolicy) r117;
        int r119 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r120 = r9.getCurrentCompositionLocalMap();
        Modifier r121 = ComposedModifierKt.materializeModifier(r9, r110);
        ComposeUiNode.Companion r122 = ComposeUiNode.Companion;
        Function0 r7 = r122.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L81;
        ComposablesKt.invalidApplier();
    L81:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L84;
        r9.createNode(r7);
    L85:
        Composer r8 = Updater.constructor-impl(r9);
        Updater.set-impl(r8, r118, r122.getSetMeasurePolicy());
        Updater.set-impl(r8, r120, r122.getSetResolvedCompositionLocals());
        Function2 r28 = r122.getSetCompositeKeyHash();
        if (r8.getInserting() == false) goto L88;
    L89:
        r8.updateRememberedValue(Integer.valueOf(r119));
        r8.apply(Integer.valueOf(r119), r28);
    L90:
        Updater.set-impl(r8, r121, r122.getSetModifier());
        r18.invoke(r9, Integer.valueOf(r10 & 14));
        r19.invoke(r9, Integer.valueOf((r10 >> 3) & 14));
        Modifier r29 = LayoutIdKt.layoutId(r0, IconLayoutIdTag);
        Alignment.Companion r30 = Alignment.Companion;
        MeasurePolicy r123 = BoxKt.maybeCachedBoxMeasurePolicy(r30.getTopStart(), false);
        int r124 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r125 = r9.getCurrentCompositionLocalMap();
        Modifier r31 = ComposedModifierKt.materializeModifier(r9, r29);
        Function0 r126 = r122.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L93;
        ComposablesKt.invalidApplier();
    L93:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L96;
        r9.createNode(r126);
    L97:
        Composer r1 = Updater.constructor-impl(r9);
        Updater.set-impl(r1, r123, r122.getSetMeasurePolicy());
        Updater.set-impl(r1, r125, r122.getSetResolvedCompositionLocals());
        Function2 r127 = r122.getSetCompositeKeyHash();
        if (r1.getInserting() == false) goto L100;
    L101:
        r1.updateRememberedValue(Integer.valueOf(r124));
        r1.apply(Integer.valueOf(r124), r127);
    L102:
        Updater.set-impl(r1, r31, r122.getSetModifier());
        BoxScopeInstance r2 = BoxScopeInstance.INSTANCE;
        r20.invoke(r9, Integer.valueOf((r10 >> 6) & 14));
        r9.endNode();
        if (r21 == null) goto L130;
        r9.startReplaceGroup(773116085);
        Modifier r3 = LayoutIdKt.layoutId(r0, LabelLayoutIdTag);
        if (r114 != 16384) goto L107;
        boolean r128 = true;
    L109:
        if ((458752 & r10) == 131072) goto L112;
        r16 = false;
    L112:
        boolean r4 = r128 | r16;
        Object r32 = r9.rememberedValue();
        if (r4 == false) goto L115;
    L116:
        r32 = new hi(r22, r23);
        r9.updateRememberedValue(r32);
    L117:
        Modifier r5 = GraphicsLayerModifierKt.graphicsLayer(r3, (Function1) r32);
        MeasurePolicy r6 = BoxKt.maybeCachedBoxMeasurePolicy(r30.getTopStart(), false);
        int r33 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r34 = r9.getCurrentCompositionLocalMap();
        Modifier r35 = ComposedModifierKt.materializeModifier(r9, r5);
        Function0 r129 = r122.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L120;
        ComposablesKt.invalidApplier();
    L120:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L123;
        r9.createNode(r129);
    L124:
        Composer r130 = Updater.constructor-impl(r9);
        Updater.set-impl(r130, r6, r122.getSetMeasurePolicy());
        Updater.set-impl(r130, r34, r122.getSetResolvedCompositionLocals());
        Function2 r36 = r122.getSetCompositeKeyHash();
        if (r130.getInserting() == false) goto L127;
    L128:
        r130.updateRememberedValue(Integer.valueOf(r33));
        r130.apply(Integer.valueOf(r33), r36);
    L129:
        Updater.set-impl(r130, r35, r122.getSetModifier());
        r21.invoke(r9, Integer.valueOf((r10 >> 9) & 14));
        r9.endNode();
        r9.endReplaceGroup();
    L131:
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L135;
        ComposerKt.traceEventEnd();
        goto L135
    L127:
        if (Intrinsics.areEqual(r130.rememberedValue(), Integer.valueOf(r33)) == true) goto L129;
    L123:
        r9.useNode();
        goto L124
    L115:
        if (r32 != Composer.Companion.getEmpty()) goto L117;
    L107:
        r128 = false;
        goto L109
    L130:
        r9.startReplaceGroup(773387087);
        r9.endReplaceGroup();
        goto L131
    L100:
        if (Intrinsics.areEqual(r1.rememberedValue(), Integer.valueOf(r124)) == true) goto L102;
    L96:
        r9.useNode();
        goto L97
    L88:
        if (Intrinsics.areEqual(r8.rememberedValue(), Integer.valueOf(r119)) == true) goto L90;
    L84:
        r9.useNode();
        goto L85
    L76:
        if (r117 != Composer.Companion.getEmpty()) goto L78;
    L72:
        r115 = false;
        goto L73
    L68:
        r112 = false;
        goto L69
    L64:
        r111 = false;
        goto L66
    L55:
        r17 = false;
        goto L57
    L48:
        if (r9.changedInstance(r24) == false) goto L50;
        int r131 = 1048576;
    L51:
        r10 = r10 | r131;
        goto L52
    L50:
        r131 = 524288;
        goto L51
    L5:
        if (r9.changedInstance(r18) == false) goto L7;
        int r132 = 4;
    L8:
        r10 = r132 | r26;
        goto L11
    L7:
        r132 = 2;
        goto L8
    }

    private static final Unit placeIcon_X9ElhV4$lambda$20(Placeable r14, Placeable r15, int r16, int r17, Placeable r18, int r19, int r20, int r21, int r22, Placeable.PlacementScope r23) {
        if (r14 == null) goto L4;
        Placeable.PlacementScope.placeRelative$default(r23, r14, (r21 - r14.getWidth()) / 2, (r22 - r14.getHeight()) / 2, MenuKt.ClosedAlphaTarget, 4, null);
    L4:
        Placeable.PlacementScope.placeRelative$default(r23, r15, r16, r17, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r23, r18, r19, r20, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    public static final void NavigationRailItem(final boolean r30, final Function0<Unit> r31, final Function2<? super Composer, ? super Integer, Unit> r32, Modifier r33, boolean r34, Function2<? super Composer, ? super Integer, Unit> r35, boolean r36, NavigationRailItemColors r37, MutableInteractionSource r38, Composer r39, final int r40, final int r41) {
        Composer r9 = r39.startRestartGroup(-1620317701);
        if ((r41 & 1) == 0) goto L6;
        int r1 = r40 | 6;
    L14:
        if ((r41 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r41 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r2 = r41 & 8;
        if (r2 == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        int r4 = r41 & 16;
        if (r4 == 0) goto L48;
        r1 = r1 | 24576;
    L55:
        int r6 = r41 & 32;
        if (r6 == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        Function2<? super Composer, ? super Integer, Unit> r7 = r35;
    L66:
        int r12 = r41 & 64;
        if (r12 == 0) goto L70;
        r1 = r1 | 1572864;
    L77:
        if ((r40 & 12582912) != 0) goto L87;
        if ((r41 & 128) != 0) goto L84;
        if (r9.changed(r37) == false) goto L84;
        int r18 = 8388608;
    L85:
        r1 = r1 | r18;
    L84:
        r18 = 4194304;
    L87:
        int r0 = r41 & 256;
        if (r0 == 0) goto L91;
        r1 = r1 | 100663296;
    L98:
        if ((r1 & 38347923) == 38347922) goto L100;
        boolean r3 = true;
    L102:
        if (r9.shouldExecute(r3, r1 & 1) == false) goto L188;
        r9.startDefaults();
        if ((r40 & 1) != 0) goto L106;
    L114:
        if (r2 == 0) goto L116;
        Modifier r5 = Modifier.Companion;
    L117:
        if (r4 == 0) goto L119;
        boolean r8 = true;
    L120:
        if (r6 == 0) goto L122;
        r7 = null;
    L122:
        if (r12 == 0) goto L124;
        boolean r10 = true;
    L126:
        if ((r41 & 128) == 0) goto L128;
        NavigationRailItemColors r11 = NavigationRailItemDefaults.INSTANCE.colors(r9, 6);
        r1 = r1 & (-29360129);
    L129:
        if (r0 == 0) goto L131;
        Modifier r21 = r5;
        boolean r22 = r8;
        boolean r24 = r10;
        NavigationRailItemColors r13 = r11;
        Function2<? super Composer, ? super Integer, Unit> r23 = r7;
        r38 = null;
    L113:
        int r14 = r1;
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L135;
        ComposerKt.traceEventStart(-1620317701, r14, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:209)");
    L135:
        if (r38 != null) goto L140;
        r9.startReplaceGroup(253288608);
        Object r15 = r9.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L139;
        r15 = InteractionSourceKt.MutableInteractionSource();
        r9.updateRememberedValue(r15);
    L139:
        r9.endReplaceGroup();
        MutableInteractionSource r16 = (MutableInteractionSource) r15;
    L141:
        MotionSchemeKeyTokens r17 = MotionSchemeKeyTokens.DefaultEffects;
        final FiniteAnimationSpec r19 = MotionSchemeKt.value(r17, r9, 6);
        MutableInteractionSource r27 = r16;
        ComposableLambda r20 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new NavigationRailKt$NavigationRailItem$styledIcon$1(r13, r30, r22, r19, r23, r24, r32), r9, 54);
        if (r23 != null) goto L144;
        r9.startReplaceGroup(254215848);
        r9.endReplaceGroup();
        ComposableLambda r25 = null;
    L145:
        Modifier r26 = SizeKt.m999defaultMinSizeVpY3zN4$default(SelectableKt.m1289selectableO2vRcR0(r21, r30, r27, null, r22, Role.box-impl(Role.Companion.getTab-o7Vup1c()), r31), MenuKt.ClosedAlphaTarget, NavigationRailItemHeight, 1, null);
        float r28 = NavigationRailItemWidth;
        Modifier r29 = SizeKt.m1021widthInVpY3zN4$default(r26, r28, MenuKt.ClosedAlphaTarget, 2, null);
        MeasurePolicy r42 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), true);
        int r110 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r43 = r9.getCurrentCompositionLocalMap();
        Modifier r44 = ComposedModifierKt.materializeModifier(r9, r29);
        ComposeUiNode.Companion r111 = ComposeUiNode.Companion;
        Function0 r112 = r111.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L148;
        ComposablesKt.invalidApplier();
    L148:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L151;
        r9.createNode(r112);
    L152:
        Composer r113 = Updater.constructor-impl(r9);
        Updater.set-impl(r113, r42, r111.getSetMeasurePolicy());
        Updater.set-impl(r113, r43, r111.getSetResolvedCompositionLocals());
        Function2 r45 = r111.getSetCompositeKeyHash();
        if (r113.getInserting() == false) goto L155;
    L156:
        r113.updateRememberedValue(Integer.valueOf(r110));
        r113.apply(Integer.valueOf(r110), r45);
    L157:
        Updater.set-impl(r113, r44, r111.getSetModifier());
        BoxScopeInstance r46 = BoxScopeInstance.INSTANCE;
        if (r30 == false) goto L160;
        float r47 = 1.0f;
    L161:
        NavigationRailItemColors r48 = r13;
        final State<Float> r114 = AnimateAsStateKt.animateFloatAsState(r47, MotionSchemeKt.value(r17, r9, 6), MenuKt.ClosedAlphaTarget, null, null, r9, 0, 28);
        if (r30 == false) goto L164;
        float r115 = 1.0f;
    L165:
        final State<Float> r116 = AnimateAsStateKt.animateFloatAsState(r115, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r9, 6), MenuKt.ClosedAlphaTarget, null, null, r9, 0, 28);
        Density r117 = (Density) r9.consume(CompositionLocalsKt.getLocalDensity());
        long r118 = Float.floatToRawIntBits((r117.roundToPx-0680j_4(r28) - r117.roundToPx-0680j_4(NavigationRailVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM())) / 2);
        long r49 = Offset.constructor-impl((((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L) | (r118 << 32));
        Unit r50 = Unit.INSTANCE;
        boolean r119 = r9.changed(r27) | r9.changed(r49);
        Object r120 = r9.rememberedValue();
        if (r119 == false) goto L168;
    L169:
        r120 = new MappedInteractionSource(r27, r49, null);
        r9.updateRememberedValue(r120);
    L170:
        final MappedInteractionSource r121 = (MappedInteractionSource) r120;
        if (r23 == null) goto L173;
        r9.startReplaceGroup(-1825624334);
        final Shape r51 = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), r9, 6);
        r9.endReplaceGroup();
    L174:
        ComposableLambda r52 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new NavigationRailKt$NavigationRailItem$1$indicatorRipple$1(r51, r121), r9, 54);
        ComposableLambda r122 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new NavigationRailKt$NavigationRailItem$1$indicator$1(r114, r48, r51), r9, 54);
        boolean r53 = r9.changed(r114);
        Object r54 = r9.rememberedValue();
        if (r53 == false) goto L177;
    L178:
        r54 = new mi(r114);
        r9.updateRememberedValue(r54);
    L179:
        Function0 r123 = (Function0) r54;
        boolean r55 = r9.changed(r116);
        Object r56 = r9.rememberedValue();
        if (r55 == false) goto L182;
    L183:
        r56 = new ni(r116);
        r9.updateRememberedValue(r56);
    L184:
        NavigationRailItemLayout(r52, r122, r20, r25, r24, r123, (Function0) r56, r9, (57344 & (r14 >> 6)) | 438);
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L187;
        ComposerKt.traceEventEnd();
    L187:
        NavigationRailItemColors r124 = r48;
        final Modifier r57 = r21;
        final boolean r58 = r22;
        final Function2<? super Composer, ? super Integer, Unit> r59 = r23;
        final boolean r60 = r24;
    L189:
        ScopeUpdateScope r125 = r9.endRestartGroup();
        if (r125 == null) goto L193;
        final NavigationRailItemColors r61 = r124;
        final MutableInteractionSource r62 = r38;
        r125.updateScope(new oi(r30, r31, r32, r57, r58, r59, r60, r61, r62, r40, r41));
        return;
    L193:
        return;
    L182:
        if (r56 != Composer.Companion.getEmpty()) goto L184;
    L177:
        if (r54 != Composer.Companion.getEmpty()) goto L179;
    L173:
        r9.startReplaceGroup(-1825528978);
        r51 = ShapesKt.getValue(ShapeKeyTokens.CornerFull, r9, 6);
        r9.endReplaceGroup();
        goto L174
    L168:
        if (r120 != Composer.Companion.getEmpty()) goto L170;
    L164:
        r115 = MenuKt.ClosedAlphaTarget;
        goto L165
    L160:
        r47 = MenuKt.ClosedAlphaTarget;
        goto L161
    L155:
        if (Intrinsics.areEqual(r113.rememberedValue(), Integer.valueOf(r110)) == true) goto L157;
    L151:
        r9.useNode();
        goto L152
    L144:
        r9.startReplaceGroup(254215849);
        final NavigationRailItemColors r310 = r13;
        final boolean r311 = r22;
        final Function2<? super Composer, ? super Integer, Unit> r312 = r23;
        r25 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new NavigationRailKt$NavigationRailItem$styledLabel$1$1(r310, r30, r311, r19, r312), r9, 54);
        r9.endReplaceGroup();
        goto L145
    L140:
        r9.startReplaceGroup(1947832599);
        r9.endReplaceGroup();
        r16 = r38;
        goto L141
    L131:
        r21 = r5;
        r22 = r8;
        r24 = r10;
        r13 = r11;
    L112:
        r23 = r7;
        goto L113
    L128:
        r11 = r37;
        goto L129
    L124:
        r10 = r36;
        goto L126
    L119:
        r8 = r34;
        goto L120
    L116:
        r5 = r33;
        goto L117
    L106:
        if (r9.getDefaultsInvalid() == true) goto L114;
        r9.skipToGroupEnd();
        if ((r41 & 128) == 0) goto L111;
        r1 = r1 & (-29360129);
    L111:
        r21 = r33;
        r22 = r34;
        r24 = r36;
        r13 = r37;
        goto L112
    L188:
        r9.skipToGroupEnd();
        r57 = r33;
        r58 = r34;
        r124 = r37;
        r38 = r38;
        r59 = r7;
        r60 = r36;
        goto L189
    L100:
        r3 = false;
        goto L102
    L91:
        if ((r40 & 100663296) != 0) goto L98;
        if (r9.changed(r38) == false) goto L95;
        int r126 = 67108864;
    L96:
        r1 = r1 | r126;
        goto L98
    L95:
        r126 = 33554432;
        goto L96
    L70:
        if ((r40 & 1572864) != 0) goto L77;
        if (r9.changed(r36) == false) goto L74;
        int r127 = 1048576;
    L75:
        r1 = r1 | r127;
        goto L77
    L74:
        r127 = 524288;
        goto L75
    L59:
        if ((196608 & r40) != 0) goto L65;
        r7 = r35;
        if (r9.changedInstance(r7) == false) goto L63;
        int r128 = 131072;
    L64:
        r1 = r1 | r128;
        goto L66
    L63:
        r128 = 65536;
        goto L64
    L48:
        if ((r40 & 24576) != 0) goto L55;
        if (r9.changed(r34) == false) goto L52;
        int r63 = 16384;
    L53:
        r1 = r1 | r63;
        goto L55
    L52:
        r63 = 8192;
        goto L53
    L37:
        if ((r40 & 3072) != 0) goto L44;
        if (r9.changed(r33) == false) goto L41;
        int r64 = 2048;
    L42:
        r1 = r1 | r64;
        goto L44
    L41:
        r64 = 1024;
        goto L42
    L27:
        if ((r40 & 384) != 0) goto L33;
        if (r9.changedInstance(r32) == false) goto L31;
        int r65 = 256;
    L32:
        r1 = r1 | r65;
        goto L33
    L31:
        r65 = 128;
        goto L32
    L17:
        if ((r40 & 48) != 0) goto L24;
        if (r9.changedInstance(r31) == false) goto L21;
        int r66 = 32;
    L22:
        r1 = r1 | r66;
        goto L24
    L21:
        r66 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r1 = r40;
        goto L14
    L8:
        if (r9.changed(r30) == false) goto L10;
        int r67 = 4;
    L11:
        r1 = r67 | r40;
        goto L14
    L10:
        r67 = 2;
        goto L11
    }

    private static final Unit placeLabelAndIcon_zUg2_y0$lambda$22(Placeable r8, boolean r9, float r10, Placeable r11, int r12, float r13, float r14, Placeable r15, int r16, float r17, Placeable r18, int r19, float r20, int r21, MeasureScope r22, Placeable.PlacementScope r23) {
        if (r8 == null) goto L4;
        Placeable.PlacementScope.placeRelative$default(r23, r8, (r21 - r8.getWidth()) / 2, MathKt.roundToInt((r17 - r22.toPx-0680j_4(IndicatorVerticalPaddingWithLabel)) + r14), MenuKt.ClosedAlphaTarget, 4, null);
    L4:
        if (r9 == false) goto L6;
    L10:
        Placeable.PlacementScope.placeRelative$default(r23, r11, r12, MathKt.roundToInt(r13 + r14), MenuKt.ClosedAlphaTarget, 4, null);
    L11:
        Placeable.PlacementScope.placeRelative$default(r23, r15, r16, MathKt.roundToInt(r17 + r14), MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r23, r18, r19, MathKt.roundToInt(r20 + r14), MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L6:
        if (r10 != MenuKt.ClosedAlphaTarget) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L8:
        r0 = false;
        goto L9
    }
}
