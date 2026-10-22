package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.material3.tokens.NavigationBarVerticalItemTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
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
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0085\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010\u001f\u001a\u007f\u0010 \u001a\u00020\u00012\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u000e2\u0006\u0010\u001a\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0016H\u0003¢\u0006\u0002\u0010&\u001a5\u0010'\u001a\u00020(*\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101\u001aM\u00102\u001a\u00020(*\u00020)2\u0006\u00103\u001a\u00020+2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u00104\u001a\u00020$H\u0002¢\u0006\u0004\b5\u00106\"\u000e\u00107\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010<\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010>\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\b?\u0010@\"\u0016\u0010A\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\bB\u0010@\"\u0010\u0010C\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010D\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\bE\u0010@\"\u0010\u0010F\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010G\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\bH\u0010@\"\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010M¨\u0006N²\u0006\n\u0010O\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010P\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020RX\u008a\u008e\u0002"}, d2 = {"NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItem", "selected", "", "onClick", "Lkotlin/Function0;", NavigationBarKt.IconLayoutIdTag, "enabled", NavigationBarKt.LabelLayoutIdTag, "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemLayout", NavigationBarKt.IndicatorRippleLayoutIdTag, NavigationBarKt.IndicatorLayoutIdTag, "alphaAnimationProgress", "", "sizeAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "animationProgress", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationBarHeight", "F", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "IndicatorVerticalOffset", "NavigationBarItemToIconMinimumPadding", "getNavigationBarItemToIconMinimumPadding", "LocalNavigationBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/NavigationBarOverride;", "getLocalNavigationBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3", "iconColor", "textColor", "itemWidth", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding = 0.0f;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = 0.0f;
    private static final float IndicatorVerticalPadding = 0.0f;
    private static final String LabelLayoutIdTag = "label";
    private static final ProvidableCompositionLocal<NavigationBarOverride> LocalNavigationBarOverride = null;
    private static final float NavigationBarHeight = 0.0f;
    private static final float NavigationBarIndicatorToLabelPadding = 0.0f;
    private static final float NavigationBarItemHorizontalPadding = 0.0f;
    private static final float NavigationBarItemToIconMinimumPadding = 0.0f;

    private static final Unit NavigationBarItem$lambda$16(RowScope r14, boolean r15, Function0 r16, Function2 r17, Modifier r18, boolean r19, Function2 r20, boolean r21, NavigationBarItemColors r22, MutableInteractionSource r23, int r24, int r25, Composer r26, int r27) {
        NavigationBarItem(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit NavigationBarItemLayout$lambda$23(Function2 r10, Function2 r11, Function2 r12, Function2 r13, boolean r14, Function0 r15, Function0 r16, int r17, Composer r18, int r19) {
        NavigationBarItemLayout(r10, r11, r12, r13, r14, r15, r16, r18, RecomposeScopeImplKt.updateChangedFlags(r17 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit NavigationBar_HsRjFd4$lambda$1(Modifier r12, long r13, long r15, float r17, WindowInsets r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        m2893NavigationBarHsRjFd4(r12, r13, r15, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ NavigationBarOverride a() {
        return LocalNavigationBarOverride$lambda$28();
    }

    public static /* synthetic */ float b(State r0) {
        return NavigationBarItem$lambda$15$lambda$14$lambda$13(r0);
    }

    public static /* synthetic */ Unit c(boolean r0, Function0 r1, GraphicsLayerScope r2) {
        return NavigationBarItemLayout$lambda$22$lambda$20$lambda$19(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(Placeable r0, boolean r1, float r2, Placeable r3, int r4, float r5, float r6, Placeable r7, int r8, float r9, Placeable r10, int r11, float r12, int r13, MeasureScope r14, Placeable.PlacementScope r15) {
        return placeLabelAndIcon_zUg2_y0$lambda$27(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit e(RowScope r0, boolean r1, Function0 r2, Function2 r3, Modifier r4, boolean r5, Function2 r6, boolean r7, NavigationBarItemColors r8, MutableInteractionSource r9, int r10, int r11, Composer r12, int r13) {
        return NavigationBarItem$lambda$16(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit f(Function2 r0, Function2 r1, Function2 r2, Function2 r3, boolean r4, Function0 r5, Function0 r6, int r7, Composer r8, int r9) {
        return NavigationBarItemLayout$lambda$23(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit g(Modifier r0, long r1, long r3, float r5, WindowInsets r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return NavigationBar_HsRjFd4$lambda$1(r0, r1, r3, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit h(Placeable r0, Placeable r1, int r2, int r3, Placeable r4, int r5, int r6, int r7, int r8, Placeable.PlacementScope r9) {
        return placeIcon_X9ElhV4$lambda$25(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ float i(State r0) {
        return NavigationBarItem$lambda$15$lambda$12$lambda$11(r0);
    }

    public static /* synthetic */ Unit j(MutableIntState r0, IntSize r1) {
        return NavigationBarItem$lambda$8$lambda$7(r0, r1);
    }

    static {
        NavigationBarHeight = NavigationBarTokens.INSTANCE.getTallContainerHeight-D9Ej5fM();
        NavigationBarItemHorizontalPadding = Dp.constructor-impl(8);
        NavigationBarIndicatorToLabelPadding = Dp.constructor-impl(4);
        NavigationBarVerticalItemTokens r0 = NavigationBarVerticalItemTokens.INSTANCE;
        float r2 = 2;
        IndicatorHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(r0.getActiveIndicatorWidth-D9Ej5fM() - r0.getIconSize-D9Ej5fM()) / r2);
        IndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(r0.getActiveIndicatorHeight-D9Ej5fM() - r0.getIconSize-D9Ej5fM()) / r2);
        IndicatorVerticalOffset = Dp.constructor-impl(12);
        NavigationBarItemToIconMinimumPadding = Dp.constructor-impl(44);
        LocalNavigationBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new wf(), 1, null);
    }

    private static final NavigationBarOverride LocalNavigationBarOverride$lambda$28() {
        return DefaultNavigationBarOverride.INSTANCE;
    }

    public static final /* synthetic */ float access$getIndicatorHorizontalPadding$p() {
        return IndicatorHorizontalPadding;
    }

    public static final /* synthetic */ float access$getNavigationBarHeight$p() {
        return NavigationBarHeight;
    }

    public static final float getIndicatorVerticalPadding() {
        return IndicatorVerticalPadding;
    }

    public static final ProvidableCompositionLocal<NavigationBarOverride> getLocalNavigationBarOverride() {
        return LocalNavigationBarOverride;
    }

    public static final float getNavigationBarIndicatorToLabelPadding() {
        return NavigationBarIndicatorToLabelPadding;
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarItemToIconMinimumPadding() {
        return NavigationBarItemToIconMinimumPadding;
    }

    private static final float NavigationBarItem$lambda$15$lambda$12$lambda$11(State r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final float NavigationBarItem$lambda$15$lambda$14$lambda$13(State r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final int NavigationBarItem$lambda$5(MutableIntState r0) {
        return r0.getIntValue();
    }

    private static final void NavigationBarItem$lambda$6(MutableIntState r0, int r1) {
        r0.setIntValue(r1);
    }

    private static final Unit NavigationBarItem$lambda$8$lambda$7(MutableIntState r2, IntSize r3) {
        NavigationBarItem$lambda$6(r2, (int) (r3.unbox-impl() >> 32));
        return Unit.INSTANCE;
    }

    private static final Unit NavigationBarItemLayout$lambda$22$lambda$20$lambda$19(boolean r0, Function0 r1, GraphicsLayerScope r2) {
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
    public static final /* synthetic */ MeasureResult m2894access$placeIconX9ElhV4(MeasureScope r0, Placeable r1, Placeable r2, Placeable r3, long r4) {
        return m2896placeIconX9ElhV4(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    private static final MeasureResult m2896placeIconX9ElhV4(MeasureScope r15, final Placeable r16, final Placeable r17, final Placeable r18, long r19) {
        if (Constraints.getMaxWidth-impl(r19) != Integer.MAX_VALUE) goto L5;
        int r1 = r16.getWidth() + (r15.roundToPx-0680j_4(NavigationBarItemToIconMinimumPadding) * 2);
    L6:
        final int r12 = ConstraintsKt.constrainHeight-K40F9xA(r19, r15.roundToPx-0680j_4(NavigationBarHeight));
        final int r5 = (r1 - r16.getWidth()) / 2;
        final int r6 = (r12 - r16.getHeight()) / 2;
        final int r8 = (r1 - r17.getWidth()) / 2;
        final int r9 = (r12 - r17.getHeight()) / 2;
        final int r10 = r1;
        return MeasureScope.-CC.layout$default(r15, r1, r12, null, new uf(r18, r16, r5, r6, r17, r8, r9, r10, r12), 4, null);
    L5:
        r1 = Constraints.getMaxWidth-impl(r19);
        goto L6
    }

    /* JADX INFO: renamed from: access$placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m2895access$placeLabelAndIconzUg2_y0(MeasureScope r0, Placeable r1, Placeable r2, Placeable r3, Placeable r4, long r5, boolean r7, float r8) {
        return m2897placeLabelAndIconzUg2_y0(r0, r1, r2, r3, r4, r5, r7, r8);
    }

    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    private static final MeasureResult m2897placeLabelAndIconzUg2_y0(final MeasureScope r20, final Placeable r21, final Placeable r22, final Placeable r23, final Placeable r24, long r25, final boolean r27, final float r28) {
        float r0 = r22.getHeight();
        float r1 = IndicatorVerticalPadding;
        float r2 = r0 + r20.toPx-0680j_4(r1);
        float r3 = NavigationBarIndicatorToLabelPadding;
        float r4 = (r2 + r20.toPx-0680j_4(r3)) + r21.getHeight();
        float r5 = 2;
        final float r10 = RangesKt.coerceAtLeast((Constraints.getMinHeight-impl(r25) - r4) / r5, r20.toPx-0680j_4(r1));
        float r6 = r4 + (r10 * r5);
        if (r27 == false) goto L5;
        float r7 = r10;
    L6:
        final float r8 = (r7 - r10) * (1 - r28);
        final float r9 = ((r22.getHeight() + r10) + r20.toPx-0680j_4(r1)) + r20.toPx-0680j_4(r3);
        if (Constraints.getMaxWidth-impl(r25) != Integer.MAX_VALUE) goto L9;
        int r11 = r22.getWidth() + (r20.roundToPx-0680j_4(NavigationBarItemToIconMinimumPadding) * 2);
    L10:
        final int r16 = r11;
        final int r12 = (r16 - r21.getWidth()) / 2;
        final int r13 = (r16 - r22.getWidth()) / 2;
        final int r14 = (r16 - r23.getWidth()) / 2;
        final float r15 = r10 - r20.toPx-0680j_4(r1);
        return MeasureScope.-CC.layout$default(r20, r16, MathKt.roundToInt(r6), null, new nf(r24, r27, r28, r21, r12, r9, r8, r22, r13, r10, r23, r14, r15, r16, r20), 4, null);
    L9:
        r11 = Constraints.getMaxWidth-impl(r25);
        goto L10
    L5:
        r7 = (r6 - r22.getHeight()) / r5;
        goto L6
    }

    /* JADX INFO: renamed from: NavigationBar-HsRjFd4, reason: not valid java name */
    public static final void m2893NavigationBarHsRjFd4(Modifier r24, long r25, long r27, float r29, WindowInsets r30, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r31, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(1054099326);
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
        float r11 = r29;
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
        r5 = NavigationBarDefaults.INSTANCE.getContainerColor(r1, 6);
        r4 = r4 & (-113);
    L96:
        if ((r34 & 4) == 0) goto L98;
        r7 = ColorSchemeKt.m2495contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(r1, 6), r5);
        r4 = r4 & (-897);
    L98:
        if (r10 == 0) goto L101;
        r11 = NavigationBarDefaults.INSTANCE.m2878getElevationD9Ej5fM();
    L101:
        if ((r34 & 16) == 0) goto L103;
        r4 = r4 & (-57345);
        r12 = NavigationBarDefaults.INSTANCE.getWindowInsets(r1, 6);
    L103:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventStart(1054099326, r4, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:118)");
    L106:
        ((NavigationBarOverride) r1.consume(LocalNavigationBarOverride)).NavigationBar(new NavigationBarOverrideScope(r6, r5, r7, r11, r12, r31, null), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L110;
        ComposerKt.traceEventEnd();
    L110:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L114;
        final Modifier r8 = r6;
        final long r9 = r5;
        final long r13 = r7;
        final float r16 = r11;
        final WindowInsets r17 = r12;
        r15.updateScope(new vf(r8, r9, r13, r16, r17, r31, r33, r34));
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
        if (r1.changed(r11) == false) goto L43;
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

    private static final void NavigationBarItemLayout(final Function2<? super Composer, ? super Integer, Unit> r18, final Function2<? super Composer, ? super Integer, Unit> r19, final Function2<? super Composer, ? super Integer, Unit> r20, final Function2<? super Composer, ? super Integer, Unit> r21, final boolean r22, final Function0<Float> r23, final Function0<Float> r24, Composer r25, final int r26) {
        Composer r9 = r25.startRestartGroup(-1019541078);
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
        r27.updateScope(new pf(r18, r19, r20, r21, r22, r23, r24, r26));
        return;
    L139:
        return;
    L59:
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventStart(-1019541078, r10, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:553)");
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
        r117 = new NavigationBarKt$NavigationBarItemLayout$1$1(r24, r21, r22);
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
        r9.startReplaceGroup(-660471321);
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
        r32 = new of(r22, r23);
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
        r9.startReplaceGroup(-660200319);
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

    private static final Unit placeIcon_X9ElhV4$lambda$25(Placeable r14, Placeable r15, int r16, int r17, Placeable r18, int r19, int r20, int r21, int r22, Placeable.PlacementScope r23) {
        if (r14 == null) goto L4;
        Placeable.PlacementScope.placeRelative$default(r23, r14, (r21 - r14.getWidth()) / 2, (r22 - r14.getHeight()) / 2, MenuKt.ClosedAlphaTarget, 4, null);
    L4:
        Placeable.PlacementScope.placeRelative$default(r23, r15, r16, r17, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r23, r18, r19, r20, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    public static final void NavigationBarItem(final RowScope r31, final boolean r32, final Function0<Unit> r33, final Function2<? super Composer, ? super Integer, Unit> r34, Modifier r35, boolean r36, Function2<? super Composer, ? super Integer, Unit> r37, boolean r38, NavigationBarItemColors r39, MutableInteractionSource r40, Composer r41, final int r42, final int r43) {
        Composer r9 = r41.startRestartGroup(974293026);
        if ((Integer.MIN_VALUE & r43) == 0) goto L6;
        int r1 = r42 | 6;
    L14:
        if ((r43 & 1) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r43 & 2) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r43 & 4) == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        int r2 = r43 & 8;
        if (r2 == 0) goto L47;
        r1 = r1 | 24576;
    L54:
        int r4 = r43 & 16;
        if (r4 == 0) goto L58;
        r1 = r1 | 196608;
    L65:
        int r6 = r43 & 32;
        if (r6 == 0) goto L69;
        r1 = r1 | 1572864;
    L75:
        final Function2<? super Composer, ? super Integer, Unit> r7 = r37;
    L76:
        int r16 = r43 & 64;
        if (r16 == 0) goto L80;
        r1 = r1 | 12582912;
    L87:
        if ((r42 & 100663296) != 0) goto L97;
        if ((r43 & 128) != 0) goto L94;
        if (r9.changed(r39) == false) goto L94;
        int r18 = 67108864;
    L95:
        r1 = r1 | r18;
    L94:
        r18 = 33554432;
    L97:
        int r0 = r43 & 256;
        if (r0 == 0) goto L101;
        r1 = r1 | 805306368;
    L108:
        if ((r1 & 306783379) == 306783378) goto L110;
        boolean r3 = true;
    L112:
        if (r9.shouldExecute(r3, r1 & 1) == false) goto L199;
        r9.startDefaults();
        if ((r42 & 1) != 0) goto L116;
    L122:
        if (r2 == 0) goto L124;
        Modifier r5 = Modifier.Companion;
    L125:
        if (r4 == 0) goto L127;
        boolean r8 = true;
    L128:
        if (r6 == 0) goto L130;
        r7 = null;
    L130:
        if (r16 == 0) goto L132;
        boolean r25 = true;
    L134:
        if ((r43 & 128) == 0) goto L136;
        NavigationBarItemColors r10 = NavigationBarItemDefaults.INSTANCE.colors(r9, 6);
        r1 = r1 & (-234881025);
    L137:
        if (r0 == 0) goto L139;
        MutableInteractionSource r26 = null;
    L140:
        NavigationBarItemColors r11 = r10;
        int r12 = r1;
    L141:
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L144;
        ComposerKt.traceEventStart(974293026, r12, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:205)");
    L144:
        if (r26 != null) goto L149;
        r9.startReplaceGroup(-224963495);
        Object r13 = r9.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L148;
        r13 = InteractionSourceKt.MutableInteractionSource();
        r9.updateRememberedValue(r13);
    L148:
        r9.endReplaceGroup();
        MutableInteractionSource r14 = (MutableInteractionSource) r13;
    L150:
        MotionSchemeKeyTokens r15 = MotionSchemeKeyTokens.DefaultEffects;
        final FiniteAnimationSpec r17 = MotionSchemeKt.value(r15, r9, 6);
        MutableInteractionSource r28 = r14;
        int r29 = r12;
        final NavigationBarItemColors r30 = r11;
        ComposableLambda r19 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new NavigationBarKt$NavigationBarItem$styledIcon$1(r11, r32, r8, r17, r7, r25, r34), r9, 54);
        if (r7 != null) goto L153;
        r9.startReplaceGroup(-224036658);
        r9.endReplaceGroup();
        ComposableLambda r20 = null;
    L154:
        Object r21 = r9.rememberedValue();
        Composer.Companion r22 = Composer.Companion;
        if (r21 != r22.getEmpty()) goto L157;
        r21 = SnapshotIntStateKt.mutableIntStateOf(0);
        r9.updateRememberedValue(r21);
    L157:
        final MutableIntState r23 = (MutableIntState) r21;
        Modifier r24 = RowScope.CC.weight$default(r31, SizeKt.m999defaultMinSizeVpY3zN4$default(SelectableKt.m1289selectableO2vRcR0(r5, r32, r28, null, r8, Role.box-impl(Role.Companion.getTab-o7Vup1c()), r33), MenuKt.ClosedAlphaTarget, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
        Object r27 = r9.rememberedValue();
        if (r27 != r22.getEmpty()) goto L160;
        r27 = new qf(r23);
        r9.updateRememberedValue(r27);
    L160:
        Modifier r44 = OnRemeasuredModifierKt.onSizeChanged(r24, (Function1) r27);
        MeasurePolicy r45 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), true);
        int r110 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r46 = r9.getCurrentCompositionLocalMap();
        Modifier r47 = ComposedModifierKt.materializeModifier(r9, r44);
        ComposeUiNode.Companion r111 = ComposeUiNode.Companion;
        Function0 r112 = r111.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L163;
        ComposablesKt.invalidApplier();
    L163:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L166;
        r9.createNode(r112);
    L167:
        Composer r48 = Updater.constructor-impl(r9);
        Updater.set-impl(r48, r45, r111.getSetMeasurePolicy());
        Updater.set-impl(r48, r46, r111.getSetResolvedCompositionLocals());
        Function2 r49 = r111.getSetCompositeKeyHash();
        if (r48.getInserting() == false) goto L170;
    L171:
        r48.updateRememberedValue(Integer.valueOf(r110));
        r48.apply(Integer.valueOf(r110), r49);
    L172:
        Updater.set-impl(r48, r47, r111.getSetModifier());
        BoxScopeInstance r50 = BoxScopeInstance.INSTANCE;
        if (r32 == false) goto L175;
        float r51 = 1.0f;
    L176:
        final State<Float> r52 = AnimateAsStateKt.animateFloatAsState(r51, MotionSchemeKt.value(r15, r9, 6), MenuKt.ClosedAlphaTarget, null, null, r9, 0, 28);
        if (r32 == false) goto L179;
        float r113 = 1.0f;
    L180:
        final State<Float> r53 = AnimateAsStateKt.animateFloatAsState(r113, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r9, 6), MenuKt.ClosedAlphaTarget, null, null, r9, 0, 28);
        Density r54 = (Density) r9.consume(CompositionLocalsKt.getLocalDensity());
        float r55 = (NavigationBarItem$lambda$5(r23) - r54.roundToPx-0680j_4(NavigationBarVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM())) / 2;
        float r56 = r54.toPx-0680j_4(IndicatorVerticalOffset);
        long r114 = Float.floatToRawIntBits(r55);
        ComposableLambda r310 = r20;
        long r57 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r56)) & 4294967295L) | (r114 << 32));
        Unit r58 = Unit.INSTANCE;
        boolean r59 = r9.changed(r28) | r9.changed(r57);
        Object r115 = r9.rememberedValue();
        if (r59 == false) goto L183;
    L184:
        r115 = new MappedInteractionSource(r28, r57, null);
        r9.updateRememberedValue(r115);
    L185:
        final MappedInteractionSource r116 = (MappedInteractionSource) r115;
        ComposableLambda r117 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new NavigationBarKt$NavigationBarItem$2$indicatorRipple$1(r116), r9, 54);
        ComposableLambda r118 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new NavigationBarKt$NavigationBarItem$2$indicator$1(r52, r30), r9, 54);
        boolean r60 = r9.changed(r52);
        Object r61 = r9.rememberedValue();
        if (r60 == false) goto L188;
    L189:
        r61 = new rf(r52);
        r9.updateRememberedValue(r61);
    L190:
        Function0 r119 = (Function0) r61;
        boolean r62 = r9.changed(r53);
        Object r63 = r9.rememberedValue();
        if (r62 == false) goto L193;
    L194:
        r63 = new sf(r53);
        r9.updateRememberedValue(r63);
    L195:
        NavigationBarItemLayout(r117, r118, r19, r310, r25, r119, (Function0) r63, r9, ((r29 >> 9) & 57344) | 438);
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L198;
        ComposerKt.traceEventEnd();
    L198:
        NavigationBarItemColors r120 = r30;
        final Modifier r64 = r5;
        final boolean r65 = r8;
        r7 = r7;
    L200:
        ScopeUpdateScope r121 = r9.endRestartGroup();
        if (r121 == null) goto L204;
        final boolean r66 = r25;
        final NavigationBarItemColors r67 = r120;
        final MutableInteractionSource r122 = r26;
        r121.updateScope(new tf(r31, r32, r33, r34, r64, r65, r7, r66, r67, r122, r42, r43));
        return;
    L204:
        return;
    L193:
        if (r63 != r22.getEmpty()) goto L195;
    L188:
        if (r61 != r22.getEmpty()) goto L190;
    L183:
        if (r115 != r22.getEmpty()) goto L185;
    L179:
        r113 = MenuKt.ClosedAlphaTarget;
        goto L180
    L175:
        r51 = MenuKt.ClosedAlphaTarget;
        goto L176
    L170:
        if (Intrinsics.areEqual(r48.rememberedValue(), Integer.valueOf(r110)) == true) goto L172;
    L166:
        r9.useNode();
        goto L167
    L153:
        r9.startReplaceGroup(-224036657);
        final boolean r311 = r8;
        final Function2<? super Composer, ? super Integer, Unit> r410 = r7;
        r20 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new NavigationBarKt$NavigationBarItem$styledLabel$1$1(r30, r32, r311, r17, r410), r9, 54);
        r9.endReplaceGroup();
        goto L154
    L149:
        r9.startReplaceGroup(-7257538);
        r9.endReplaceGroup();
        r14 = r26;
        goto L150
    L139:
        r26 = r40;
        goto L140
    L136:
        r10 = r39;
        goto L137
    L132:
        r25 = r38;
        goto L134
    L127:
        r8 = r36;
        goto L128
    L124:
        r5 = r35;
        goto L125
    L116:
        if (r9.getDefaultsInvalid() == true) goto L122;
        r9.skipToGroupEnd();
        if ((r43 & 128) == 0) goto L121;
        r1 = r1 & (-234881025);
    L121:
        r5 = r35;
        r8 = r36;
        r25 = r38;
        r26 = r40;
        r12 = r1;
        r7 = r7;
        r11 = r39;
        goto L141
    L199:
        r9.skipToGroupEnd();
        r64 = r35;
        r65 = r36;
        r25 = r38;
        r120 = r39;
        r26 = r40;
        goto L200
    L110:
        r3 = false;
        goto L112
    L101:
        if ((r42 & 805306368) != 0) goto L108;
        if (r9.changed(r40) == false) goto L105;
        int r123 = 536870912;
    L106:
        r1 = r1 | r123;
        goto L108
    L105:
        r123 = 268435456;
        goto L106
    L80:
        if ((r42 & 12582912) != 0) goto L87;
        if (r9.changed(r38) == false) goto L84;
        int r124 = 8388608;
    L85:
        r1 = r1 | r124;
        goto L87
    L84:
        r124 = 4194304;
        goto L85
    L69:
        if ((1572864 & r42) != 0) goto L75;
        r7 = r37;
        if (r9.changedInstance(r7) == false) goto L73;
        int r125 = 1048576;
    L74:
        r1 = r1 | r125;
        goto L76
    L73:
        r125 = 524288;
        goto L74
    L58:
        if ((196608 & r42) != 0) goto L65;
        if (r9.changed(r36) == false) goto L62;
        int r68 = 131072;
    L63:
        r1 = r1 | r68;
        goto L65
    L62:
        r68 = 65536;
        goto L63
    L47:
        if ((r42 & 24576) != 0) goto L54;
        if (r9.changed(r35) == false) goto L51;
        int r69 = 16384;
    L52:
        r1 = r1 | r69;
        goto L54
    L51:
        r69 = 8192;
        goto L52
    L37:
        if ((r42 & 3072) != 0) goto L43;
        if (r9.changedInstance(r34) == false) goto L41;
        int r70 = 2048;
    L42:
        r1 = r1 | r70;
        goto L43
    L41:
        r70 = 1024;
        goto L42
    L27:
        if ((r42 & 384) != 0) goto L34;
        if (r9.changedInstance(r33) == false) goto L31;
        int r71 = 256;
    L32:
        r1 = r1 | r71;
        goto L34
    L31:
        r71 = 128;
        goto L32
    L17:
        if ((r42 & 48) != 0) goto L24;
        if (r9.changed(r32) == false) goto L21;
        int r72 = 32;
    L22:
        r1 = r1 | r72;
        goto L24
    L21:
        r72 = 16;
        goto L22
    L6:
        if ((r42 & 6) == 0) goto L8;
        r1 = r42;
        goto L14
    L8:
        if (r9.changed(r31) == false) goto L10;
        int r73 = 4;
    L11:
        r1 = r73 | r42;
        goto L14
    L10:
        r73 = 2;
        goto L11
    }

    private static final Unit placeLabelAndIcon_zUg2_y0$lambda$27(Placeable r8, boolean r9, float r10, Placeable r11, int r12, float r13, float r14, Placeable r15, int r16, float r17, Placeable r18, int r19, float r20, int r21, MeasureScope r22, Placeable.PlacementScope r23) {
        if (r8 == null) goto L4;
        Placeable.PlacementScope.placeRelative$default(r23, r8, (r21 - r8.getWidth()) / 2, MathKt.roundToInt((r17 - r22.roundToPx-0680j_4(IndicatorVerticalPadding)) + r14), MenuKt.ClosedAlphaTarget, 4, null);
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
