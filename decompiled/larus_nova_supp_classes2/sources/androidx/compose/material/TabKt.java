package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u007f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\n¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a:\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0004\b\u001f\u0010 \u001a7\u0010!\u001a\u00020\u00012\u0013\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010\"\u001a\u001c\u0010#\u001a\u00020\u0001*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002\u001aD\u0010)\u001a\u00020\u0001*\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020(2\u0006\u0010'\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(H\u0002\"\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00104\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u000e\u00105\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00108\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00109\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u0010:\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0010\u0010>\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006?²\u0006\n\u0010@\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2 = {"Tab", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "text", "Landroidx/compose/runtime/Composable;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "LeadingIconTab", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextOrIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "textOrIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "tabHeight", "", "placeTextAndIcon", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "iconPlaceable", "tabWidth", "firstBaseline", "lastBaseline", "SmallTabHeight", "Landroidx/compose/ui/unit/Dp;", "F", "LargeTabHeight", "TabFadeInAnimationDuration", "TabFadeInAnimationDelay", "TabFadeOutAnimationDuration", "HorizontalTextPadding", "SingleLineTextBaselineWithIcon", "DoubleLineTextBaselineWithIcon", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextDistanceFromLeadingIcon", "material", "color"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabKt {
    private static final float DoubleLineTextBaselineWithIcon = 0.0f;
    private static final float HorizontalTextPadding = 0.0f;
    private static final long IconDistanceFromBaseline = 0;
    private static final float LargeTabHeight = 0.0f;
    private static final float SingleLineTextBaselineWithIcon = 0.0f;
    private static final float SmallTabHeight = 0.0f;
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float TextDistanceFromLeadingIcon = 0.0f;

    private static final Unit LeadingIconTab_0nD_MI0$lambda$2(boolean r15, Function0 r16, Function2 r17, Function2 r18, Modifier r19, boolean r20, MutableInteractionSource r21, long r22, long r24, int r26, int r27, Composer r28, int r29) {
        m2192LeadingIconTab0nDMI0(r15, r16, r17, r18, r19, r20, r21, r22, r24, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    private static final Unit TabBaselineLayout$lambda$11(Function2 r0, Function2 r1, int r2, Composer r3, int r4) {
        TabBaselineLayout(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TabTransition_Klgx_Pg$lambda$6(long r9, long r11, boolean r13, Function2 r14, int r15, Composer r16, int r17) {
        m2195TabTransitionKlgxPg(r9, r11, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Tab_0nD_MI0$lambda$1(boolean r15, Function0 r16, Modifier r17, boolean r18, Function2 r19, Function2 r20, MutableInteractionSource r21, long r22, long r24, int r26, int r27, Composer r28, int r29) {
        m2193Tab0nDMI0(r15, r16, r17, r18, r19, r20, r21, r22, r24, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    private static final Unit Tab_EVJuX4I$lambda$3(boolean r14, Function0 r15, Modifier r16, boolean r17, MutableInteractionSource r18, long r19, long r21, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m2194TabEVJuX4I(r14, r15, r16, r17, r18, r19, r21, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Function2 r1, int r2, Composer r3, int r4) {
        return TabBaselineLayout$lambda$11(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit b(boolean r0, Function0 r1, Modifier r2, boolean r3, Function2 r4, Function2 r5, MutableInteractionSource r6, long r7, long r9, int r11, int r12, Composer r13, int r14) {
        return Tab_0nD_MI0$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit c(boolean r0, Function0 r1, Function2 r2, Function2 r3, Modifier r4, boolean r5, MutableInteractionSource r6, long r7, long r9, int r11, int r12, Composer r13, int r14) {
        return LeadingIconTab_0nD_MI0$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit d(long r0, long r2, boolean r4, Function2 r5, int r6, Composer r7, int r8) {
        return TabTransition_Klgx_Pg$lambda$6(r0, r2, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit e(boolean r0, Function0 r1, Modifier r2, boolean r3, MutableInteractionSource r4, long r5, long r7, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return Tab_EVJuX4I$lambda$3(r0, r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13);
    }

    static {
        SmallTabHeight = Dp.constructor-impl(48);
        LargeTabHeight = Dp.constructor-impl(72);
        HorizontalTextPadding = Dp.constructor-impl(16);
        SingleLineTextBaselineWithIcon = Dp.constructor-impl(14);
        DoubleLineTextBaselineWithIcon = Dp.constructor-impl(6);
        IconDistanceFromBaseline = TextUnitKt.getSp(20);
        TextDistanceFromLeadingIcon = Dp.constructor-impl(8);
    }

    public static final /* synthetic */ float access$getHorizontalTextPadding$p() {
        return HorizontalTextPadding;
    }

    public static final /* synthetic */ float access$getLargeTabHeight$p() {
        return LargeTabHeight;
    }

    public static final /* synthetic */ float access$getSmallTabHeight$p() {
        return SmallTabHeight;
    }

    public static final /* synthetic */ float access$getTextDistanceFromLeadingIcon$p() {
        return TextDistanceFromLeadingIcon;
    }

    private static final long TabTransition_Klgx_Pg$lambda$5(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    public static final /* synthetic */ void access$placeTextOrIcon(Placeable.PlacementScope r0, Placeable r1, int r2) {
        placeTextOrIcon(r0, r1, r2);
    }

    private static final void placeTextOrIcon(Placeable.PlacementScope r7, Placeable r8, int r9) {
        Placeable.PlacementScope.placeRelative$default(r7, r8, 0, (r9 - r8.getHeight()) / 2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    }

    private static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> r12, final Function2<? super Composer, ? super Integer, Unit> r13, Composer r14, final int r15) {
        Composer r16 = r14.startRestartGroup(1466813041);
        if ((r15 & 6) == 0) goto L5;
        int r1 = r15;
    L11:
        if ((r15 & 48) == 0) goto L13;
    L17:
        boolean r7 = true;
        if ((r1 & 19) == 18) goto L20;
        boolean r4 = true;
    L22:
        if (r16.shouldExecute(r4, r1 & 1) == true) goto L24;
        r16.skipToGroupEnd();
    L86:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L90;
        r17.updateScope(new cc(r12, r13, r15));
        return;
    L90:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(1466813041, r1, -1, "androidx.compose.material.TabBaselineLayout (Tab.kt:297)");
    L26:
        int r0 = r1 & 14;
        if (r0 != 4) goto L29;
        boolean r2 = true;
    L31:
        if ((r1 & 112) == 32) goto L34;
        r7 = false;
    L34:
        boolean r3 = r2 | r7;
        Object r5 = r16.rememberedValue();
        if (r3 == false) goto L37;
    L38:
        r5 = new TabKt$TabBaselineLayout$2$1(r12, r13);
        r16.updateRememberedValue(r5);
    L39:
        MeasurePolicy r6 = (MeasurePolicy) r5;
        Modifier.Companion r8 = Modifier.Companion;
        int r9 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r10 = r16.getCurrentCompositionLocalMap();
        Modifier r11 = ComposedModifierKt.materializeModifier(r16, r8);
        ComposeUiNode.Companion r18 = ComposeUiNode.Companion;
        Function0 r19 = r18.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L42;
        ComposablesKt.invalidApplier();
    L42:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L45;
        r16.createNode(r19);
    L46:
        Composer r110 = Updater.constructor-impl(r16);
        Updater.set-impl(r110, r6, r18.getSetMeasurePolicy());
        Updater.set-impl(r110, r10, r18.getSetResolvedCompositionLocals());
        Function2 r20 = r18.getSetCompositeKeyHash();
        if (r110.getInserting() == false) goto L49;
    L50:
        r110.updateRememberedValue(Integer.valueOf(r9));
        r110.apply(Integer.valueOf(r9), r20);
    L51:
        Updater.set-impl(r110, r11, r18.getSetModifier());
        if (r12 == null) goto L66;
        r16.startReplaceGroup(-1044948645);
        Modifier r21 = PaddingKt.m962paddingVpY3zN4$default(LayoutIdKt.layoutId(r8, "text"), HorizontalTextPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        MeasurePolicy r22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r23 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r24 = r16.getCurrentCompositionLocalMap();
        Modifier r25 = ComposedModifierKt.materializeModifier(r16, r21);
        Function0 r26 = r18.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L56;
        ComposablesKt.invalidApplier();
    L56:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L59;
        r16.createNode(r26);
    L60:
        Composer r27 = Updater.constructor-impl(r16);
        Updater.set-impl(r27, r22, r18.getSetMeasurePolicy());
        Updater.set-impl(r27, r24, r18.getSetResolvedCompositionLocals());
        Function2 r28 = r18.getSetCompositeKeyHash();
        if (r27.getInserting() == false) goto L63;
    L64:
        r27.updateRememberedValue(Integer.valueOf(r23));
        r27.apply(Integer.valueOf(r23), r28);
    L65:
        Updater.set-impl(r27, r25, r18.getSetModifier());
        BoxScopeInstance r29 = BoxScopeInstance.INSTANCE;
        r12.invoke(r16, Integer.valueOf(r0));
        r16.endNode();
        r16.endReplaceGroup();
    L67:
        if (r13 == null) goto L81;
        r16.startReplaceGroup(-1044815097);
        Modifier r30 = LayoutIdKt.layoutId(r8, "icon");
        MeasurePolicy r31 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r32 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r33 = r16.getCurrentCompositionLocalMap();
        Modifier r34 = ComposedModifierKt.materializeModifier(r16, r30);
        Function0 r35 = r18.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L71;
        ComposablesKt.invalidApplier();
    L71:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L74;
        r16.createNode(r35);
    L75:
        Composer r36 = Updater.constructor-impl(r16);
        Updater.set-impl(r36, r31, r18.getSetMeasurePolicy());
        Updater.set-impl(r36, r33, r18.getSetResolvedCompositionLocals());
        Function2 r37 = r18.getSetCompositeKeyHash();
        if (r36.getInserting() == false) goto L78;
    L79:
        r36.updateRememberedValue(Integer.valueOf(r32));
        r36.apply(Integer.valueOf(r32), r37);
    L80:
        Updater.set-impl(r36, r34, r18.getSetModifier());
        BoxScopeInstance r38 = BoxScopeInstance.INSTANCE;
        r13.invoke(r16, Integer.valueOf((r1 >> 3) & 14));
        r16.endNode();
        r16.endReplaceGroup();
    L82:
        r16.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventEnd();
        goto L86
    L78:
        if (Intrinsics.areEqual(r36.rememberedValue(), Integer.valueOf(r32)) == true) goto L80;
    L74:
        r16.useNode();
        goto L75
    L81:
        r16.startReplaceGroup(-1044752632);
        r16.endReplaceGroup();
        goto L82
    L63:
        if (Intrinsics.areEqual(r27.rememberedValue(), Integer.valueOf(r23)) == true) goto L65;
    L59:
        r16.useNode();
        goto L60
    L66:
        r16.startReplaceGroup(-1044843896);
        r16.endReplaceGroup();
        goto L67
    L49:
        if (Intrinsics.areEqual(r110.rememberedValue(), Integer.valueOf(r9)) == true) goto L51;
    L45:
        r16.useNode();
        goto L46
    L37:
        if (r5 != Composer.Companion.getEmpty()) goto L39;
    L29:
        r2 = false;
        goto L31
    L20:
        r4 = false;
        goto L22
    L13:
        if (r16.changedInstance(r13) == false) goto L15;
        int r39 = 32;
    L16:
        r1 = r1 | r39;
        goto L17
    L15:
        r39 = 16;
        goto L16
    L5:
        if (r16.changedInstance(r12) == false) goto L7;
        int r40 = 4;
    L8:
        r1 = r40 | r15;
        goto L11
    L7:
        r40 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$TabBaselineLayout(Function2 r0, Function2 r1, Composer r2, int r3) {
        TabBaselineLayout(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    private static final void m2195TabTransitionKlgxPg(final long r20, final long r22, final boolean r24, final Function2<? super Composer, ? super Integer, Unit> r25, Composer r26, final int r27) {
        Composer r1 = r26.startRestartGroup(-1841653376);
        if ((r27 & 6) == 0) goto L5;
        int r2 = r27;
    L11:
        if ((r27 & 48) != 0) goto L18;
        if (r1.changed(r22) == false) goto L15;
        int r8 = 32;
    L16:
        r2 = r2 | r8;
        goto L18
    L15:
        r8 = 16;
    L18:
        if ((r27 & 384) != 0) goto L25;
        if (r1.changed(r24) == false) goto L22;
        int r9 = 256;
    L23:
        r2 = r2 | r9;
        goto L25
    L22:
        r9 = 128;
    L25:
        if ((r27 & 3072) != 0) goto L32;
        if (r1.changedInstance(r25) == false) goto L29;
        int r10 = 2048;
    L30:
        r2 = r2 | r10;
        goto L32
    L29:
        r10 = 1024;
    L32:
        if ((r2 & 1171) == 1170) goto L34;
        boolean r11 = true;
    L36:
        if (r1.shouldExecute(r11, r2 & 1) == true) goto L38;
        r1.skipToGroupEnd();
    L76:
        ScopeUpdateScope r12 = r1.endRestartGroup();
        if (r12 == null) goto L80;
        r12.updateScope(new ec(r20, r22, r24, r25, r27));
        return;
    L80:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-1841653376, r2, -1, "androidx.compose.material.TabTransition (Tab.kt:266)");
    L40:
        int r3 = r2 >> 6;
        Transition r13 = TransitionKt.updateTransition(Boolean.valueOf(r24), null, r1, r3 & 14, 2);
        TabKt$TabTransition$color$2 r0 = TabKt$TabTransition$color$2.INSTANCE;
        boolean r14 = ((Boolean) r13.getTargetState()).booleanValue();
        r1.startReplaceGroup(90393475);
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventStart(90393475, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:282)");
    L43:
        if (r14 == false) goto L45;
        long r18 = r20;
    L47:
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        r1.endReplaceGroup();
        ColorSpace r15 = Color.getColorSpace-impl(r18);
        boolean r19 = r1.changed(r15);
        Object r16 = r1.rememberedValue();
        if (r19 == false) goto L52;
    L53:
        r16 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(r15);
        r1.updateRememberedValue(r16);
    L54:
        TwoWayConverter r17 = (TwoWayConverter) r16;
        boolean r21 = ((Boolean) r13.getCurrentState()).booleanValue();
        r1.startReplaceGroup(90393475);
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventStart(90393475, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:282)");
    L57:
        if (r21 == false) goto L59;
        long r4 = r20;
    L61:
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventEnd();
    L63:
        r1.endReplaceGroup();
        Color r23 = Color.box-impl(r4);
        boolean r5 = ((Boolean) r13.getTargetState()).booleanValue();
        r1.startReplaceGroup(90393475);
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventStart(90393475, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:282)");
    L66:
        if (r5 == false) goto L68;
        long r6 = r20;
    L70:
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventEnd();
    L72:
        r1.endReplaceGroup();
        State r7 = TransitionKt.createTransitionAnimation(r13, r23, Color.box-impl(r6), (FiniteAnimationSpec) r0.invoke(r13.getSegment(), r1, 0), r17, "ColorAnimation", r1, 0);
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(Color.copy-wmQWz5c$default(TabTransition_Klgx_Pg$lambda$5(r7), 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(TabTransition_Klgx_Pg$lambda$5(r7))))}, r25, r1, ProvidedValue.$stable | (r3 & 112));
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventEnd();
        goto L76
    L68:
        r6 = r22;
        goto L70
    L59:
        r4 = r22;
        goto L61
    L52:
        if (r16 != Composer.Companion.getEmpty()) goto L54;
    L45:
        r18 = r22;
        goto L47
    L34:
        r11 = false;
        goto L36
    L5:
        if (r1.changed(r20) == false) goto L7;
        int r28 = 4;
    L8:
        r2 = r28 | r27;
        goto L11
    L7:
        r28 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$placeTextAndIcon(Placeable.PlacementScope r0, Density r1, Placeable r2, Placeable r3, int r4, int r5, int r6, int r7) {
        placeTextAndIcon(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    private static final void placeTextAndIcon(Placeable.PlacementScope r12, Density r13, Placeable r14, Placeable r15, int r16, int r17, int r18, int r19) {
        if (r18 != r19) goto L5;
        float r3 = SingleLineTextBaselineWithIcon;
    L6:
        int r4 = r13.roundToPx-0680j_4(r3) + r13.roundToPx-0680j_4(TabRowDefaults.INSTANCE.m2203getIndicatorHeightD9Ej5fM());
        int r5 = (r15.getHeight() + r13.roundToPx--R2X_6o(IconDistanceFromBaseline)) - r18;
        int r7 = (r16 - r14.getWidth()) / 2;
        int r0 = (r17 - r19) - r4;
        Placeable.PlacementScope.placeRelative$default(r12, r14, r7, r0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r12, r15, (r16 - r15.getWidth()) / 2, r0 - r5, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return;
    L5:
        r3 = DoubleLineTextBaselineWithIcon;
        goto L6
    }

    /* JADX INFO: renamed from: Tab-EVJuX4I, reason: not valid java name */
    public static final void m2194TabEVJuX4I(final boolean r29, final Function0<Unit> r30, Modifier r31, boolean r32, MutableInteractionSource r33, long r34, long r36, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r38, Composer r39, final int r40, final int r41) {
        Composer r9 = r39.startRestartGroup(-1847932236);
        if ((r41 & 1) == 0) goto L6;
        int r1 = r40 | 6;
    L14:
        if ((r41 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r41 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r41 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r5 = r32;
    L45:
        int r6 = r41 & 16;
        if (r6 == 0) goto L49;
        r1 = r1 | 24576;
    L55:
        MutableInteractionSource r7 = r33;
    L57:
        if ((196608 & r40) == 0) goto L59;
        long r13 = r34;
    L68:
        if ((1572864 & r40) != 0) goto L76;
        int r310 = r1;
        if ((r41 & 64) == 0) goto L72;
    L74:
        int r16 = 524288;
    L75:
        int r17 = r310 | r16;
    L78:
        if ((r41 & 128) == 0) goto L81;
        r17 = r17 | 12582912;
    L89:
        if ((r17 & 4793491) == 4793490) goto L91;
        boolean r0 = true;
    L93:
        if (r9.shouldExecute(r0, r17 & 1) == false) goto L127;
        r9.startDefaults();
        if ((r40 & 1) != 0) goto L97;
    L107:
        if (r2 == 0) goto L109;
        Modifier r3 = Modifier.Companion;
    L110:
        if (r4 == 0) goto L112;
        r5 = true;
    L112:
        if (r6 == 0) goto L115;
        r7 = null;
    L115:
        if ((r41 & 32) == 0) goto L118;
        r13 = ((Color) r9.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        r17 = r17 & (-458753);
    L118:
        if ((r41 & 64) != 0) goto L119;
    L106:
        long r25 = r36;
        boolean r21 = r5;
        MutableInteractionSource r22 = r7;
        long r23 = r13;
        int r8 = r17;
    L120:
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L123;
        ComposerKt.traceEventStart(-1847932236, r8, -1, "androidx.compose.material.Tab (Tab.kt:229)");
    L123:
        final IndicationNodeFactory r18 = RippleKt.m2139rippleH2RKhps$default(true, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r23, 2, null);
        final Modifier r14 = r3;
        final MutableInteractionSource r19 = r22;
        final boolean r110 = r21;
        int r10 = r8 >> 15;
        m2195TabTransitionKlgxPg(r23, r25, r29, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new TabKt$Tab$3(r14, r29, r19, r18, r110, r30, r38), r9, 54), r9, ((r10 & 112) | ((r10 & 14) | 3072)) | ((r8 << 6) & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventEnd();
    L126:
        final Modifier r11 = r3;
        final boolean r12 = r21;
        final MutableInteractionSource r15 = r22;
        final long r20 = r23;
    L128:
        ScopeUpdateScope r111 = r9.endRestartGroup();
        if (r111 == null) goto L132;
        final long r24 = r25;
        r111.updateScope(new bc(r29, r30, r11, r12, r15, r20, r24, r38, r40, r41));
        return;
    L132:
        return;
    L119:
        long r112 = Color.copy-wmQWz5c$default(r13, ContentAlpha.INSTANCE.getMedium(r9, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        r21 = r5;
        r22 = r7;
        r23 = r13;
        r8 = r17 & (-3670017);
        r25 = r112;
        goto L120
    L109:
        r3 = r31;
        goto L110
    L97:
        if (r9.getDefaultsInvalid() == true) goto L107;
        r9.skipToGroupEnd();
        if ((r41 & 32) == 0) goto L103;
        r17 = r17 & (-458753);
    L103:
        if ((r41 & 64) == 0) goto L105;
        r17 = r17 & (-3670017);
    L105:
        r3 = r31;
        goto L106
    L127:
        r9.skipToGroupEnd();
        r11 = r31;
        r25 = r36;
        r12 = r5;
        r15 = r7;
        r20 = r13;
        goto L128
    L91:
        r0 = false;
        goto L93
    L81:
        if ((r40 & 12582912) != 0) goto L89;
        if (r9.changedInstance(r38) == false) goto L85;
        int r113 = 8388608;
    L86:
        r17 = r17 | r113;
        goto L89
    L85:
        r113 = 4194304;
        goto L86
    L72:
        if (r9.changed(r36) == false) goto L74;
        r16 = 1048576;
        goto L75
    L76:
        r17 = r1;
        goto L78
    L59:
        if ((r41 & 32) != 0) goto L63;
        r13 = r34;
        if (r9.changed(r13) == false) goto L64;
        int r114 = 131072;
    L65:
        r1 = r1 | r114;
    L64:
        r114 = 65536;
        goto L65
    L63:
        r13 = r34;
        goto L64
    L49:
        if ((r40 & 24576) != 0) goto L55;
        r7 = r33;
        if (r9.changed(r7) == false) goto L53;
        int r115 = 16384;
    L54:
        r1 = r1 | r115;
        goto L57
    L53:
        r115 = 8192;
        goto L54
    L38:
        if ((r40 & 3072) != 0) goto L44;
        r5 = r32;
        if (r9.changed(r5) == false) goto L42;
        int r26 = 2048;
    L43:
        r1 = r1 | r26;
        goto L45
    L42:
        r26 = 1024;
        goto L43
    L27:
        if ((r40 & 384) != 0) goto L34;
        if (r9.changed(r31) == false) goto L31;
        int r27 = 256;
    L32:
        r1 = r1 | r27;
        goto L34
    L31:
        r27 = 128;
        goto L32
    L17:
        if ((r40 & 48) != 0) goto L23;
        if (r9.changedInstance(r30) == false) goto L21;
        int r28 = 32;
    L22:
        r1 = r1 | r28;
        goto L23
    L21:
        r28 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r1 = r40;
        goto L14
    L8:
        if (r9.changed(r29) == false) goto L10;
        int r35 = 4;
    L11:
        r1 = r35 | r40;
        goto L14
    L10:
        r35 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: LeadingIconTab-0nD-MI0, reason: not valid java name */
    public static final void m2192LeadingIconTab0nDMI0(final boolean r28, final Function0<Unit> r29, final Function2<? super Composer, ? super Integer, Unit> r30, final Function2<? super Composer, ? super Integer, Unit> r31, Modifier r32, boolean r33, MutableInteractionSource r34, long r35, long r37, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(-524682663);
        if ((r41 & 1) == 0) goto L6;
        int r3 = r40 | 6;
    L14:
        if ((r41 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r41 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L34:
        if ((r41 & 8) == 0) goto L37;
        r3 = r3 | 3072;
    L43:
        int r4 = r41 & 16;
        if (r4 == 0) goto L47;
        r3 = r3 | 24576;
    L53:
        final Modifier r5 = r32;
    L54:
        int r6 = r41 & 32;
        if (r6 == 0) goto L58;
        r3 = r3 | 196608;
    L64:
        boolean r7 = r33;
    L65:
        int r8 = r41 & 64;
        if (r8 == 0) goto L69;
        r3 = r3 | 1572864;
    L77:
        if ((12582912 & r40) != 0) goto L88;
        if ((r41 & 128) != 0) goto L84;
        if (r1.changed(r35) == false) goto L84;
        int r16 = 8388608;
    L85:
        r3 = r3 | r16;
    L84:
        r16 = 4194304;
    L88:
        if ((r40 & 100663296) != 0) goto L96;
        long r9 = r37;
        if ((r41 & 256) == 0) goto L92;
    L94:
        int r0 = 33554432;
    L95:
        r3 = r3 | r0;
    L98:
        if ((38347923 & r3) == 38347922) goto L100;
        boolean r2 = true;
    L102:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L138;
        r1.startDefaults();
        if ((r40 & 1) != 0) goto L106;
    L116:
        if (r4 == 0) goto L118;
        r5 = Modifier.Companion;
    L118:
        if (r6 == 0) goto L120;
        r7 = true;
    L120:
        if (r8 == 0) goto L122;
        MutableInteractionSource r10 = null;
    L124:
        if ((r41 & 128) == 0) goto L126;
        long r18 = ((Color) r1.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        r3 = r3 & (-29360129);
    L128:
        if ((r41 & 256) == 0) goto L130;
        long r20 = r18;
        MutableInteractionSource r17 = r10;
        int r11 = r3 & (-234881025);
        Modifier r12 = r5;
        boolean r13 = r7;
        long r21 = Color.copy-wmQWz5c$default(r20, ContentAlpha.INSTANCE.getMedium(r1, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L131:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventStart(-524682663, r11, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
    L134:
        final IndicationNodeFactory r14 = RippleKt.m2139rippleH2RKhps$default(true, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r18, 2, null);
        final Modifier r15 = r12;
        final MutableInteractionSource r19 = r17;
        final boolean r22 = r13;
        int r23 = r11;
        ComposableLambda r24 = ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new TabKt$LeadingIconTab$1(r15, r28, r19, r14, r22, r29, r31, r30), r1, 54);
        int r25 = r23 >> 21;
        int r26 = (r25 & 14) | 3072;
        long r36 = r18;
        long r38 = r21;
        m2195TabTransitionKlgxPg(r36, r38, r28, r24, r1, ((r25 & 112) | r26) | ((r23 << 6) & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L137;
        ComposerKt.traceEventEnd();
    L137:
        r5 = r12;
        final boolean r27 = r13;
        final MutableInteractionSource r42 = r17;
        final long r43 = r18;
        final long r110 = r21;
    L139:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L143;
        r111.updateScope(new fc(r28, r29, r30, r31, r5, r27, r42, r43, r110, r40, r41));
        return;
    L143:
        return;
    L130:
        r17 = r10;
    L115:
        r12 = r5;
        r13 = r7;
        r21 = r9;
        r11 = r3;
        goto L131
    L126:
        r18 = r35;
        goto L128
    L122:
        r10 = r34;
        goto L124
    L106:
        if (r1.getDefaultsInvalid() == true) goto L116;
        r1.skipToGroupEnd();
        if ((r41 & 128) == 0) goto L112;
        r3 = r3 & (-29360129);
    L112:
        if ((r41 & 256) == 0) goto L114;
        r3 = r3 & (-234881025);
    L114:
        r17 = r34;
        r18 = r35;
        goto L115
    L138:
        r1.skipToGroupEnd();
        r27 = r7;
        r110 = r9;
        r42 = r34;
        r43 = r35;
        goto L139
    L100:
        r2 = false;
        goto L102
    L92:
        if (r1.changed(r9) == false) goto L94;
        r0 = 67108864;
        goto L95
    L96:
        r9 = r37;
        goto L98
    L69:
        if ((1572864 & r40) != 0) goto L77;
        if (r1.changed(r34) == false) goto L73;
        int r112 = 1048576;
    L74:
        r3 = r3 | r112;
        goto L77
    L73:
        r112 = 524288;
        goto L74
    L58:
        if ((196608 & r40) != 0) goto L64;
        r7 = r33;
        if (r1.changed(r7) == false) goto L62;
        int r44 = 131072;
    L63:
        r3 = r3 | r44;
        goto L65
    L62:
        r44 = 65536;
        goto L63
    L47:
        if ((r40 & 24576) != 0) goto L53;
        r5 = r32;
        if (r1.changed(r5) == false) goto L51;
        int r45 = 16384;
    L52:
        r3 = r3 | r45;
        goto L54
    L51:
        r45 = 8192;
        goto L52
    L37:
        if ((r40 & 3072) != 0) goto L43;
        if (r1.changedInstance(r31) == false) goto L41;
        int r46 = 2048;
    L42:
        r3 = r3 | r46;
        goto L43
    L41:
        r46 = 1024;
        goto L42
    L27:
        if ((r40 & 384) != 0) goto L34;
        if (r1.changedInstance(r30) == false) goto L31;
        int r47 = 256;
    L32:
        r3 = r3 | r47;
        goto L34
    L31:
        r47 = 128;
        goto L32
    L17:
        if ((r40 & 48) != 0) goto L24;
        if (r1.changedInstance(r29) == false) goto L21;
        int r48 = 32;
    L22:
        r3 = r3 | r48;
        goto L24
    L21:
        r48 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r3 = r40;
        goto L14
    L8:
        if (r1.changed(r28) == false) goto L10;
        int r49 = 4;
    L11:
        r3 = r49 | r40;
        goto L14
    L10:
        r49 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Tab-0nD-MI0, reason: not valid java name */
    public static final void m2193Tab0nDMI0(final boolean r29, final Function0<Unit> r30, Modifier r31, boolean r32, Function2<? super Composer, ? super Integer, Unit> r33, Function2<? super Composer, ? super Integer, Unit> r34, MutableInteractionSource r35, long r36, long r38, Composer r40, final int r41, final int r42) {
        Composer r1 = r40.startRestartGroup(-610760526);
        if ((r42 & 1) == 0) goto L6;
        int r3 = r41 | 6;
    L14:
        if ((r42 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r42 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r31;
    L35:
        int r7 = r42 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r8 = r32;
    L46:
        int r9 = r42 & 16;
        if (r9 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        final Function2<? super Composer, ? super Integer, Unit> r10 = r33;
    L57:
        int r11 = r42 & 32;
        if (r11 == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        int r15 = r42 & 64;
        if (r15 == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((r41 & 12582912) != 0) goto L89;
        if ((r42 & 128) == 0) goto L83;
    L85:
        int r0 = 4194304;
    L86:
        r3 = r3 | r0;
        goto L89
    L83:
        if (r1.changed(r36) == false) goto L85;
        r0 = 8388608;
    L89:
        if ((100663296 & r41) != 0) goto L97;
        long r14 = r38;
        if ((r42 & 256) == 0) goto L93;
    L95:
        int r2 = 33554432;
    L96:
        r3 = r3 | r2;
    L99:
        if ((38347923 & r3) == 38347922) goto L101;
        boolean r4 = true;
    L103:
        if (r1.shouldExecute(r4, r3 & 1) == false) goto L147;
        r1.startDefaults();
        if ((r41 & 1) != 0) goto L107;
    L116:
        if (r5 == 0) goto L118;
        r6 = Modifier.Companion;
    L118:
        if (r7 == 0) goto L120;
        r8 = true;
    L120:
        if (r9 == 0) goto L122;
        r10 = null;
    L122:
        if (r11 == 0) goto L124;
        final Function2<? super Composer, ? super Integer, Unit> r12 = null;
    L125:
        if (r15 == 0) goto L127;
        MutableInteractionSource r13 = null;
    L129:
        if ((r42 & 128) == 0) goto L131;
        long r21 = ((Color) r1.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        r3 = r3 & (-29360129);
    L133:
        if ((r42 & 256) == 0) goto L135;
        r14 = Color.copy-wmQWz5c$default(r21, ContentAlpha.INSTANCE.getMedium(r1, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        r3 = r3 & (-234881025);
    L135:
        int r16 = r3;
        long r27 = r14;
        long r17 = r21;
    L136:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L140;
        ComposerKt.traceEventStart(-610760526, r16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
    L140:
        if (r10 != null) goto L142;
        r1.startReplaceGroup(-1684864799);
        r1.endReplaceGroup();
        final Function2 r18 = null;
        boolean r19 = true;
    L143:
        int r20 = r16 >> 6;
        Modifier r110 = r6;
        boolean r111 = r8;
        MutableInteractionSource r112 = r13;
        long r113 = r17;
        long r22 = r27;
        m2194TabEVJuX4I(r29, r30, r110, r111, r112, r113, r22, ComposableLambdaKt.rememberComposableLambda(-1088373601, r19, new TabKt$Tab$1(r18, r12), r1, 54), r1, (((57344 & r20) | (((((r16 & 14) | 12582912) | (r16 & 112)) | (r16 & 896)) | (r16 & 7168))) | (458752 & r20)) | (r20 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L146;
        ComposerKt.traceEventEnd();
    L146:
        final MutableInteractionSource r23 = r13;
        final boolean r24 = r8;
        final Function2<? super Composer, ? super Integer, Unit> r25 = r10;
        final long r114 = r27;
        final long r26 = r17;
        final Modifier r28 = r6;
        final Function2<? super Composer, ? super Integer, Unit> r37 = r12;
    L148:
        ScopeUpdateScope r115 = r1.endRestartGroup();
        if (r115 == null) goto L152;
        r115.updateScope(new dc(r29, r30, r28, r24, r25, r37, r23, r26, r114, r41, r42));
        return;
    L152:
        return;
    L142:
        r1.startReplaceGroup(-1684864798);
        r19 = true;
        Function2 r116 = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new TabKt$Tab$styledText$1$1(r10), r1, 54);
        r1.endReplaceGroup();
        r18 = r116;
        goto L143
    L131:
        r21 = r36;
        goto L133
    L127:
        r13 = r35;
        goto L129
    L124:
        r12 = r34;
        goto L125
    L107:
        if (r1.getDefaultsInvalid() == true) goto L116;
        r1.skipToGroupEnd();
        if ((r42 & 128) == 0) goto L113;
        r3 = r3 & (-29360129);
    L113:
        if ((r42 & 256) == 0) goto L115;
        r3 = r3 & (-234881025);
    L115:
        r12 = r34;
        r13 = r35;
        r16 = r3;
        r27 = r14;
        r17 = r36;
        goto L136
    L147:
        r1.skipToGroupEnd();
        r23 = r35;
        r28 = r6;
        r24 = r8;
        r25 = r10;
        r114 = r14;
        r37 = r34;
        r26 = r36;
        goto L148
    L101:
        r4 = false;
        goto L103
    L93:
        if (r1.changed(r14) == false) goto L95;
        r2 = 67108864;
        goto L96
    L97:
        r14 = r38;
        goto L99
    L72:
        if ((r41 & 1572864) != 0) goto L79;
        if (r1.changed(r35) == false) goto L76;
        int r117 = 1048576;
    L77:
        r3 = r3 | r117;
        goto L79
    L76:
        r117 = 524288;
        goto L77
    L61:
        if ((196608 & r41) != 0) goto L68;
        if (r1.changedInstance(r34) == false) goto L65;
        int r118 = 131072;
    L66:
        r3 = r3 | r118;
        goto L68
    L65:
        r118 = 65536;
        goto L66
    L50:
        if ((r41 & 24576) != 0) goto L56;
        r10 = r33;
        if (r1.changedInstance(r10) == false) goto L54;
        int r119 = 16384;
    L55:
        r3 = r3 | r119;
        goto L57
    L54:
        r119 = 8192;
        goto L55
    L39:
        if ((r41 & 3072) != 0) goto L45;
        r8 = r32;
        if (r1.changed(r8) == false) goto L43;
        int r39 = 2048;
    L44:
        r3 = r3 | r39;
        goto L46
    L43:
        r39 = 1024;
        goto L44
    L28:
        if ((r41 & 384) != 0) goto L34;
        r6 = r31;
        if (r1.changed(r6) == false) goto L32;
        int r43 = 256;
    L33:
        r3 = r3 | r43;
        goto L35
    L32:
        r43 = 128;
        goto L33
    L17:
        if ((r41 & 48) != 0) goto L24;
        if (r1.changedInstance(r30) == false) goto L21;
        int r44 = 32;
    L22:
        r3 = r3 | r44;
        goto L24
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r41 & 6) == 0) goto L8;
        r3 = r41;
        goto L14
    L8:
        if (r1.changed(r29) == false) goto L10;
        int r45 = 4;
    L11:
        r3 = r45 | r41;
        goto L14
    L10:
        r45 = 2;
        goto L11
    }
}
