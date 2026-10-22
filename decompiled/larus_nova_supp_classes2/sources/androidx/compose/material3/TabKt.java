package androidx.compose.material3;

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
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
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
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u007f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\n¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a:\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0004\b\u001f\u0010 \u001a7\u0010!\u001a\u00020\u00012\u0013\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010\"\u001a\u001c\u0010#\u001a\u00020\u0001*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002\u001aD\u0010)\u001a\u00020\u0001*\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020(2\u0006\u0010'\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(H\u0002\"\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00104\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0016\u00105\u001a\u000202X\u0080\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b6\u00107\"\u0010\u00108\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00109\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<\"\u0010\u0010=\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006>²\u0006\n\u0010?\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"Tab", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "text", "Landroidx/compose/runtime/Composable;", "icon", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "LeadingIconTab", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextOrIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "textOrIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "tabHeight", "", "placeTextAndIcon", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "iconPlaceable", "tabWidth", "firstBaseline", "lastBaseline", "SmallTabHeight", "Landroidx/compose/ui/unit/Dp;", "F", "LargeTabHeight", "HorizontalTextPadding", "getHorizontalTextPadding", "()F", "SingleLineTextBaselineWithIcon", "DoubleLineTextBaselineWithIcon", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextDistanceFromLeadingIcon", "material3", "color"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabKt {
    private static final float DoubleLineTextBaselineWithIcon = 0.0f;
    private static final float HorizontalTextPadding = 0.0f;
    private static final long IconDistanceFromBaseline = 0;
    private static final float LargeTabHeight = 0.0f;
    private static final float SingleLineTextBaselineWithIcon = 0.0f;
    private static final float SmallTabHeight = 0.0f;
    private static final float TextDistanceFromLeadingIcon = 0.0f;

    private static final Unit LeadingIconTab_wqdebIU$lambda$2(boolean r15, Function0 r16, Function2 r17, Function2 r18, Modifier r19, boolean r20, long r21, long r23, MutableInteractionSource r25, int r26, int r27, Composer r28, int r29) {
        m3247LeadingIconTabwqdebIU(r15, r16, r17, r18, r19, r20, r21, r23, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    private static final Unit TabBaselineLayout$lambda$11(Function2 r0, Function2 r1, int r2, Composer r3, int r4) {
        TabBaselineLayout(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TabTransition_Klgx_Pg$lambda$6(long r9, long r11, boolean r13, Function2 r14, int r15, Composer r16, int r17) {
        m3250TabTransitionKlgxPg(r9, r11, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Tab_bogVsAg$lambda$3(boolean r14, Function0 r15, Modifier r16, boolean r17, long r18, long r20, MutableInteractionSource r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m3248TabbogVsAg(r14, r15, r16, r17, r18, r20, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit Tab_wqdebIU$lambda$1(boolean r15, Function0 r16, Modifier r17, boolean r18, Function2 r19, Function2 r20, long r21, long r23, MutableInteractionSource r25, int r26, int r27, Composer r28, int r29) {
        m3249TabwqdebIU(r15, r16, r17, r18, r19, r20, r21, r23, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(long r0, long r2, boolean r4, Function2 r5, int r6, Composer r7, int r8) {
        return TabTransition_Klgx_Pg$lambda$6(r0, r2, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit b(boolean r0, Function0 r1, Modifier r2, boolean r3, Function2 r4, Function2 r5, long r6, long r8, MutableInteractionSource r10, int r11, int r12, Composer r13, int r14) {
        return Tab_wqdebIU$lambda$1(r0, r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit c(boolean r0, Function0 r1, Modifier r2, boolean r3, long r4, long r6, MutableInteractionSource r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return Tab_bogVsAg$lambda$3(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit d(Function2 r0, Function2 r1, int r2, Composer r3, int r4) {
        return TabBaselineLayout$lambda$11(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit e(boolean r0, Function0 r1, Function2 r2, Function2 r3, Modifier r4, boolean r5, long r6, long r8, MutableInteractionSource r10, int r11, int r12, Composer r13, int r14) {
        return LeadingIconTab_wqdebIU$lambda$2(r0, r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14);
    }

    static {
        SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        LargeTabHeight = Dp.constructor-impl(72);
        HorizontalTextPadding = Dp.constructor-impl(16);
        SingleLineTextBaselineWithIcon = Dp.constructor-impl(14);
        DoubleLineTextBaselineWithIcon = Dp.constructor-impl(6);
        IconDistanceFromBaseline = TextUnitKt.getSp(20);
        TextDistanceFromLeadingIcon = Dp.constructor-impl(8);
    }

    public static final /* synthetic */ long access$getIconDistanceFromBaseline$p() {
        return IconDistanceFromBaseline;
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

    public static final float getHorizontalTextPadding() {
        return HorizontalTextPadding;
    }

    private static final long TabTransition_Klgx_Pg$lambda$5(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    public static final /* synthetic */ void access$placeTextOrIcon(Placeable.PlacementScope r0, Placeable r1, int r2) {
        placeTextOrIcon(r0, r1, r2);
    }

    private static final void placeTextOrIcon(Placeable.PlacementScope r7, Placeable r8, int r9) {
        Placeable.PlacementScope.placeRelative$default(r7, r8, 0, (r9 - r8.getHeight()) / 2, MenuKt.ClosedAlphaTarget, 4, null);
    }

    private static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> r12, final Function2<? super Composer, ? super Integer, Unit> r13, Composer r14, final int r15) {
        Composer r16 = r14.startRestartGroup(-1349901398);
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
        r17.updateScope(new cs(r12, r13, r15));
        return;
    L90:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1349901398, r1, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:300)");
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
        r16.startReplaceGroup(870361332);
        Modifier r21 = PaddingKt.m962paddingVpY3zN4$default(LayoutIdKt.layoutId(r8, "text"), HorizontalTextPadding, MenuKt.ClosedAlphaTarget, 2, null);
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
        r16.startReplaceGroup(870494880);
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
        r16.startReplaceGroup(870557345);
        r16.endReplaceGroup();
        goto L82
    L63:
        if (Intrinsics.areEqual(r27.rememberedValue(), Integer.valueOf(r23)) == true) goto L65;
    L59:
        r16.useNode();
        goto L60
    L66:
        r16.startReplaceGroup(870466081);
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
    private static final void m3250TabTransitionKlgxPg(final long r18, final long r20, final boolean r22, final Function2<? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25) {
        Composer r1 = r24.startRestartGroup(-833145221);
        if ((r25 & 6) == 0) goto L5;
        int r2 = r25;
    L11:
        if ((r25 & 48) != 0) goto L18;
        if (r1.changed(r20) == false) goto L15;
        int r8 = 32;
    L16:
        r2 = r2 | r8;
        goto L18
    L15:
        r8 = 16;
    L18:
        if ((r25 & 384) != 0) goto L25;
        if (r1.changed(r22) == false) goto L22;
        int r9 = 256;
    L23:
        r2 = r2 | r9;
        goto L25
    L22:
        r9 = 128;
    L25:
        if ((r25 & 3072) != 0) goto L32;
        if (r1.changedInstance(r23) == false) goto L29;
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
        r12.updateScope(new es(r18, r20, r22, r23, r25));
        return;
    L80:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-833145221, r2, -1, "androidx.compose.material3.TabTransition (Tab.kt:274)");
    L40:
        int r3 = r2 >> 6;
        Transition r13 = TransitionKt.updateTransition(Boolean.valueOf(r22), null, r1, r3 & 14, 2);
        TabKt$TabTransition$color$2 r0 = TabKt$TabTransition$color$2.INSTANCE;
        boolean r14 = ((Boolean) r13.getTargetState()).booleanValue();
        r1.startReplaceGroup(-1069234984);
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventStart(-1069234984, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:289)");
    L43:
        if (r14 == false) goto L45;
        long r16 = r18;
    L47:
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        r1.endReplaceGroup();
        ColorSpace r5 = Color.getColorSpace-impl(r16);
        boolean r15 = r1.changed(r5);
        Object r17 = r1.rememberedValue();
        if (r15 == false) goto L52;
    L53:
        r17 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(r5);
        r1.updateRememberedValue(r17);
    L54:
        TwoWayConverter r6 = (TwoWayConverter) r17;
        boolean r19 = ((Boolean) r13.getCurrentState()).booleanValue();
        r1.startReplaceGroup(-1069234984);
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventStart(-1069234984, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:289)");
    L57:
        if (r19 == false) goto L59;
        long r110 = r18;
    L61:
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventEnd();
    L63:
        r1.endReplaceGroup();
        Color r21 = Color.box-impl(r110);
        boolean r111 = ((Boolean) r13.getTargetState()).booleanValue();
        r1.startReplaceGroup(-1069234984);
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventStart(-1069234984, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:289)");
    L66:
        if (r111 == false) goto L68;
        long r112 = r18;
    L70:
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventEnd();
    L72:
        r1.endReplaceGroup();
        State r4 = TransitionKt.createTransitionAnimation(r13, r21, Color.box-impl(r112), (FiniteAnimationSpec) r0.invoke(r13.getSegment(), r1, 0), r6, "ColorAnimation", r1, 0);
        int r7 = r3 & 112;
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(TabTransition_Klgx_Pg$lambda$5(r4))), r23, r1, r7 | ProvidedValue.$stable);
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventEnd();
        goto L76
    L68:
        r112 = r20;
        goto L70
    L59:
        r110 = r20;
        goto L61
    L52:
        if (r17 != Composer.Companion.getEmpty()) goto L54;
    L45:
        r16 = r20;
        goto L47
    L34:
        r11 = false;
        goto L36
    L5:
        if (r1.changed(r18) == false) goto L7;
        int r26 = 4;
    L8:
        r2 = r26 | r25;
        goto L11
    L7:
        r26 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$placeTextAndIcon(Placeable.PlacementScope r0, Density r1, Placeable r2, Placeable r3, int r4, int r5, int r6, int r7) {
        placeTextAndIcon(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    private static final void placeTextAndIcon(Placeable.PlacementScope r12, Density r13, Placeable r14, Placeable r15, int r16, int r17, int r18, int r19) {
        if (r18 != r19) goto L5;
        float r3 = SingleLineTextBaselineWithIcon;
    L6:
        int r4 = r13.roundToPx-0680j_4(r3) + r13.roundToPx-0680j_4(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM());
        int r5 = (r15.getHeight() + r13.roundToPx--R2X_6o(IconDistanceFromBaseline)) - r18;
        int r7 = (r16 - r14.getWidth()) / 2;
        int r0 = (r17 - r19) - r4;
        Placeable.PlacementScope.placeRelative$default(r12, r14, r7, r0, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r12, r15, (r16 - r15.getWidth()) / 2, r0 - r5, MenuKt.ClosedAlphaTarget, 4, null);
        return;
    L5:
        r3 = DoubleLineTextBaselineWithIcon;
        goto L6
    }

    /* JADX INFO: renamed from: Tab-bogVsAg, reason: not valid java name */
    public static final void m3248TabbogVsAg(final boolean r27, final Function0<Unit> r28, Modifier r29, boolean r30, long r31, long r33, MutableInteractionSource r35, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r9 = r37.startRestartGroup(-1573136853);
        if ((r39 & 1) == 0) goto L6;
        int r1 = r38 | 6;
    L14:
        if ((r39 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r39 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r39 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L46:
        if ((r38 & 24576) == 0) goto L48;
        long r6 = r31;
    L57:
        if ((196608 & r38) == 0) goto L59;
        long r13 = r33;
    L67:
        int r15 = r39 & 64;
        if (r15 == 0) goto L71;
        r1 = r1 | 1572864;
    L78:
        if ((r39 & 128) == 0) goto L81;
        r1 = r1 | 12582912;
    L89:
        if ((r1 & 4793491) == 4793490) goto L91;
        boolean r0 = true;
    L93:
        if (r9.shouldExecute(r0, r1 & 1) == false) goto L129;
        r9.startDefaults();
        if ((r38 & 1) != 0) goto L97;
    L107:
        if (r2 == 0) goto L109;
        Modifier r3 = Modifier.Companion;
    L110:
        if (r4 == 0) goto L112;
        boolean r5 = true;
    L114:
        if ((r39 & 16) == 0) goto L117;
        r6 = ((Color) r9.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        r1 = r1 & (-57345);
    L117:
        if ((r39 & 32) == 0) goto L119;
        r1 = r1 & (-458753);
        r13 = r6;
    L119:
        if (r15 == 0) goto L121;
        boolean r21 = r5;
        MutableInteractionSource r26 = null;
    L106:
        long r22 = r6;
        long r24 = r13;
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L125;
        ComposerKt.traceEventStart(-1573136853, r1, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
    L125:
        final IndicationNodeFactory r17 = RippleKt.m3031rippleH2RKhps$default(true, MenuKt.ClosedAlphaTarget, r22, 2, null);
        final Modifier r14 = r3;
        final MutableInteractionSource r16 = r26;
        final boolean r18 = r21;
        int r7 = r1 >> 12;
        m3250TabTransitionKlgxPg(r22, r24, r27, ComposableLambdaKt.rememberComposableLambda(1128552423, true, new TabKt$Tab$3(r14, r27, r16, r17, r18, r28, r36), r9, 54), r9, ((r7 & 112) | ((r7 & 14) | 3072)) | ((r1 << 6) & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventEnd();
    L128:
        final Modifier r8 = r3;
        final boolean r10 = r21;
        final long r11 = r22;
        final long r12 = r24;
    L130:
        ScopeUpdateScope r19 = r9.endRestartGroup();
        if (r19 == null) goto L134;
        final MutableInteractionSource r20 = r26;
        r19.updateScope(new as(r27, r28, r8, r10, r11, r12, r20, r36, r38, r39));
        return;
    L134:
        return;
    L121:
        r26 = r35;
        r21 = r5;
        goto L106
    L112:
        r5 = r30;
        goto L114
    L109:
        r3 = r29;
        goto L110
    L97:
        if (r9.getDefaultsInvalid() == true) goto L107;
        r9.skipToGroupEnd();
        if ((r39 & 16) == 0) goto L103;
        r1 = r1 & (-57345);
    L103:
        if ((r39 & 32) == 0) goto L105;
        r1 = r1 & (-458753);
    L105:
        r3 = r29;
        r21 = r30;
        r26 = r35;
        goto L106
    L129:
        r9.skipToGroupEnd();
        r8 = r29;
        r10 = r30;
        r26 = r35;
        r11 = r6;
        r12 = r13;
        goto L130
    L91:
        r0 = false;
        goto L93
    L81:
        if ((r38 & 12582912) != 0) goto L89;
        if (r9.changedInstance(r36) == false) goto L85;
        int r110 = 8388608;
    L86:
        r1 = r1 | r110;
        goto L89
    L85:
        r110 = 4194304;
        goto L86
    L71:
        if ((r38 & 1572864) != 0) goto L78;
        if (r9.changed(r35) == false) goto L75;
        int r111 = 1048576;
    L76:
        r1 = r1 | r111;
        goto L78
    L75:
        r111 = 524288;
        goto L76
    L59:
        if ((r39 & 32) != 0) goto L63;
        r13 = r33;
        if (r9.changed(r13) == false) goto L64;
        int r112 = 131072;
    L65:
        r1 = r1 | r112;
    L64:
        r112 = 65536;
        goto L65
    L63:
        r13 = r33;
        goto L64
    L48:
        if ((r39 & 16) != 0) goto L52;
        r6 = r31;
        if (r9.changed(r6) == false) goto L53;
        int r113 = 16384;
    L54:
        r1 = r1 | r113;
    L53:
        r113 = 8192;
        goto L54
    L52:
        r6 = r31;
        goto L53
    L38:
        if ((r38 & 3072) != 0) goto L46;
        if (r9.changed(r30) == false) goto L42;
        int r23 = 2048;
    L43:
        r1 = r1 | r23;
        goto L46
    L42:
        r23 = 1024;
        goto L43
    L27:
        if ((r38 & 384) != 0) goto L34;
        if (r9.changed(r29) == false) goto L31;
        int r25 = 256;
    L32:
        r1 = r1 | r25;
        goto L34
    L31:
        r25 = 128;
        goto L32
    L17:
        if ((r38 & 48) != 0) goto L23;
        if (r9.changedInstance(r28) == false) goto L21;
        int r32 = 32;
    L22:
        r1 = r1 | r32;
        goto L23
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r1 = r38;
        goto L14
    L8:
        if (r9.changed(r27) == false) goto L10;
        int r34 = 4;
    L11:
        r1 = r34 | r38;
        goto L14
    L10:
        r34 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: LeadingIconTab-wqdebIU, reason: not valid java name */
    public static final void m3247LeadingIconTabwqdebIU(final boolean r23, final Function0<Unit> r24, final Function2<? super Composer, ? super Integer, Unit> r25, final Function2<? super Composer, ? super Integer, Unit> r26, Modifier r27, boolean r28, long r29, long r31, MutableInteractionSource r33, Composer r34, final int r35, final int r36) {
        Composer r1 = r34.startRestartGroup(-611535578);
        if ((r36 & 1) == 0) goto L6;
        int r3 = r35 | 6;
    L14:
        if ((r36 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r36 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L34:
        if ((r36 & 8) == 0) goto L37;
        r3 = r3 | 3072;
    L43:
        int r4 = r36 & 16;
        if (r4 == 0) goto L47;
        r3 = r3 | 24576;
    L53:
        final Modifier r5 = r27;
    L54:
        int r6 = r36 & 32;
        if (r6 == 0) goto L58;
        r3 = r3 | 196608;
    L66:
        if ((1572864 & r35) != 0) goto L77;
        if ((r36 & 64) != 0) goto L73;
        if (r1.changed(r29) == false) goto L73;
        int r10 = 1048576;
    L74:
        r3 = r3 | r10;
    L73:
        r10 = 524288;
    L77:
        if ((12582912 & r35) != 0) goto L85;
        long r7 = r31;
        if ((r36 & 128) == 0) goto L81;
    L83:
        int r9 = 4194304;
    L84:
        r3 = r3 | r9;
    L86:
        int r11 = r36 & 256;
        if (r11 == 0) goto L90;
        r3 = r3 | 100663296;
    L96:
        MutableInteractionSource r12 = r33;
    L98:
        if ((r3 & 38347923) == 38347922) goto L100;
        boolean r0 = true;
    L102:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L138;
        r1.startDefaults();
        if ((r35 & 1) != 0) goto L106;
    L116:
        if (r4 == 0) goto L118;
        r5 = Modifier.Companion;
    L118:
        if (r6 == 0) goto L120;
        boolean r2 = true;
    L122:
        if ((r36 & 64) == 0) goto L124;
        long r18 = ((Color) r1.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        r3 = r3 & (-3670017);
    L126:
        if ((r36 & 128) == 0) goto L128;
        r3 = (-29360129) & r3;
        r7 = r18;
    L128:
        if (r11 == 0) goto L130;
        MutableInteractionSource r16 = null;
        int r13 = r3;
        long r20 = r7;
        boolean r8 = r2;
        Modifier r14 = r5;
    L131:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventStart(-611535578, r13, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
    L134:
        final IndicationNodeFactory r15 = RippleKt.m3031rippleH2RKhps$default(true, MenuKt.ClosedAlphaTarget, r18, 2, null);
        final Modifier r17 = r14;
        final MutableInteractionSource r19 = r16;
        final boolean r21 = r8;
        Modifier r110 = r14;
        int r22 = r13;
        int r30 = r22 >> 18;
        long r210 = r18;
        long r211 = r20;
        m3250TabTransitionKlgxPg(r210, r211, r23, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new TabKt$LeadingIconTab$1(r17, r23, r19, r15, r21, r24, r26, r25), r1, 54), r1, ((r30 & 112) | ((r30 & 14) | 3072)) | ((r22 << 6) & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L137;
        ComposerKt.traceEventEnd();
    L137:
        final boolean r32 = r8;
        final MutableInteractionSource r111 = r16;
        r5 = r110;
        final long r37 = r18;
        final long r38 = r20;
    L139:
        ScopeUpdateScope r112 = r1.endRestartGroup();
        if (r112 == null) goto L143;
        r112.updateScope(new ds(r23, r24, r25, r26, r5, r32, r37, r38, r111, r35, r36));
        return;
    L143:
        return;
    L130:
        r8 = r2;
    L115:
        r14 = r5;
        r20 = r7;
        r16 = r12;
        r13 = r3;
        goto L131
    L124:
        r18 = r29;
        goto L126
    L120:
        r2 = r28;
        goto L122
    L106:
        if (r1.getDefaultsInvalid() == true) goto L116;
        r1.skipToGroupEnd();
        if ((r36 & 64) == 0) goto L112;
        r3 = r3 & (-3670017);
    L112:
        if ((r36 & 128) == 0) goto L114;
        r3 = r3 & (-29360129);
    L114:
        r8 = r28;
        r18 = r29;
        goto L115
    L138:
        r1.skipToGroupEnd();
        r32 = r28;
        r111 = r12;
        r38 = r7;
        r37 = r29;
        goto L139
    L100:
        r0 = false;
        goto L102
    L90:
        if ((100663296 & r35) != 0) goto L96;
        r12 = r33;
        if (r1.changed(r12) == false) goto L94;
        int r113 = 67108864;
    L95:
        r3 = r3 | r113;
        goto L98
    L94:
        r113 = 33554432;
        goto L95
    L81:
        if (r1.changed(r7) == false) goto L83;
        r9 = 8388608;
        goto L84
    L85:
        r7 = r31;
        goto L86
    L58:
        if ((196608 & r35) != 0) goto L66;
        if (r1.changed(r28) == false) goto L62;
        int r39 = 131072;
    L63:
        r3 = r3 | r39;
        goto L66
    L62:
        r39 = 65536;
        goto L63
    L47:
        if ((r35 & 24576) != 0) goto L53;
        r5 = r27;
        if (r1.changed(r5) == false) goto L51;
        int r40 = 16384;
    L52:
        r3 = r3 | r40;
        goto L54
    L51:
        r40 = 8192;
        goto L52
    L37:
        if ((r35 & 3072) != 0) goto L43;
        if (r1.changedInstance(r26) == false) goto L41;
        int r41 = 2048;
    L42:
        r3 = r3 | r41;
        goto L43
    L41:
        r41 = 1024;
        goto L42
    L27:
        if ((r35 & 384) != 0) goto L34;
        if (r1.changedInstance(r25) == false) goto L31;
        int r42 = 256;
    L32:
        r3 = r3 | r42;
        goto L34
    L31:
        r42 = 128;
        goto L32
    L17:
        if ((r35 & 48) != 0) goto L24;
        if (r1.changedInstance(r24) == false) goto L21;
        int r43 = 32;
    L22:
        r3 = r3 | r43;
        goto L24
    L21:
        r43 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r3 = r35;
        goto L14
    L8:
        if (r1.changed(r23) == false) goto L10;
        int r44 = 4;
    L11:
        r3 = r44 | r35;
        goto L14
    L10:
        r44 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Tab-wqdebIU, reason: not valid java name */
    public static final void m3249TabwqdebIU(final boolean r31, final Function0<Unit> r32, Modifier r33, boolean r34, Function2<? super Composer, ? super Integer, Unit> r35, Function2<? super Composer, ? super Integer, Unit> r36, long r37, long r39, MutableInteractionSource r41, Composer r42, final int r43, final int r44) {
        Composer r1 = r42.startRestartGroup(1015017965);
        if ((r44 & 1) == 0) goto L6;
        int r3 = r43 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r44 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r7 = r44 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r8 = r34;
    L46:
        int r9 = r44 & 16;
        if (r9 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        final Function2<? super Composer, ? super Integer, Unit> r10 = r35;
    L57:
        int r11 = r44 & 32;
        if (r11 == 0) goto L61;
        r3 = r3 | 196608;
    L69:
        if ((1572864 & r43) != 0) goto L80;
        if ((r44 & 64) != 0) goto L76;
        if (r1.changed(r37) == false) goto L76;
        int r16 = 1048576;
    L77:
        r3 = r3 | r16;
    L76:
        r16 = 524288;
    L80:
        if ((r43 & 12582912) != 0) goto L88;
        long r14 = r39;
        if ((r44 & 128) == 0) goto L84;
    L86:
        int r0 = 4194304;
    L87:
        r3 = r3 | r0;
    L89:
        int r2 = r44 & 256;
        if (r2 == 0) goto L93;
        r3 = r3 | 100663296;
    L100:
        if ((r3 & 38347923) == 38347922) goto L102;
        boolean r4 = true;
    L104:
        if (r1.shouldExecute(r4, r3 & 1) == false) goto L149;
        r1.startDefaults();
        Function2 r19 = null;
        if ((r43 & 1) != 0) goto L108;
    L117:
        if (r5 == 0) goto L119;
        Modifier r6 = Modifier.Companion;
    L120:
        if (r7 == 0) goto L122;
        r8 = true;
    L122:
        if (r9 == 0) goto L124;
        r10 = null;
    L124:
        if (r11 == 0) goto L126;
        final Function2<? super Composer, ? super Integer, Unit> r12 = null;
    L128:
        if ((r44 & 64) == 0) goto L130;
        long r20 = ((Color) r1.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        r3 = r3 & (-3670017);
    L132:
        if ((r44 & 128) == 0) goto L134;
        r3 = r3 & (-29360129);
        r14 = r20;
    L134:
        if (r2 == 0) goto L136;
        MutableInteractionSource r13 = null;
    L137:
        long r15 = r20;
    L138:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L142;
        ComposerKt.traceEventStart(1015017965, r3, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
    L142:
        if (r10 != null) goto L144;
        r1.startReplaceGroup(1830899669);
    L145:
        r1.endReplaceGroup();
        final Function2 r17 = r19;
        int r18 = (((r3 & 14) | 12582912) | (r3 & 112)) | (r3 & 7168);
        int r21 = r3 >> 6;
        m3248TabbogVsAg(r31, r32, BadgeKt.badgeBounds(r6), r8, r15, r14, r13, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new TabKt$Tab$1(r17, r12), r1, 54), r1, ((r18 | (57344 & r21)) | (458752 & r21)) | (r21 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventEnd();
    L148:
        final MutableInteractionSource r110 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r22 = r12;
        final Function2<? super Composer, ? super Integer, Unit> r23 = r10;
        final long r24 = r14;
        long r29 = r15;
        final Modifier r25 = r6;
        final boolean r26 = r8;
        final long r27 = r29;
    L150:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L154;
        r111.updateScope(new bs(r31, r32, r25, r26, r23, r22, r27, r24, r110, r43, r44));
        return;
    L154:
        return;
    L144:
        r1.startReplaceGroup(1830899670);
        r19 = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new TabKt$Tab$styledText$1$1(r10), r1, 54);
        goto L145
    L136:
        r13 = r41;
        goto L137
    L130:
        r20 = r37;
        goto L132
    L126:
        r12 = r36;
        goto L128
    L119:
        r6 = r33;
        goto L120
    L108:
        if (r1.getDefaultsInvalid() == true) goto L117;
        r1.skipToGroupEnd();
        if ((r44 & 64) == 0) goto L114;
        r3 = r3 & (-3670017);
    L114:
        if ((r44 & 128) == 0) goto L116;
        r3 = r3 & (-29360129);
    L116:
        r6 = r33;
        r12 = r36;
        r13 = r41;
        r3 = r3;
        r14 = r14;
        r15 = r37;
        goto L138
    L149:
        r1.skipToGroupEnd();
        r25 = r33;
        r22 = r36;
        r110 = r41;
        r26 = r8;
        r23 = r10;
        r24 = r14;
        r27 = r37;
        goto L150
    L102:
        r4 = false;
        goto L104
    L93:
        if ((r43 & 100663296) != 0) goto L100;
        if (r1.changed(r41) == false) goto L97;
        int r112 = 67108864;
    L98:
        r3 = r3 | r112;
        goto L100
    L97:
        r112 = 33554432;
        goto L98
    L84:
        if (r1.changed(r14) == false) goto L86;
        r0 = 8388608;
        goto L87
    L88:
        r14 = r39;
        goto L89
    L61:
        if ((196608 & r43) != 0) goto L69;
        if (r1.changedInstance(r36) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
        goto L69
    L65:
        r113 = 65536;
        goto L66
    L50:
        if ((r43 & 24576) != 0) goto L56;
        r10 = r35;
        if (r1.changedInstance(r10) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
        goto L57
    L54:
        r114 = 8192;
        goto L55
    L39:
        if ((r43 & 3072) != 0) goto L45;
        r8 = r34;
        if (r1.changed(r8) == false) goto L43;
        int r28 = 2048;
    L44:
        r3 = r3 | r28;
        goto L46
    L43:
        r28 = 1024;
        goto L44
    L28:
        if ((r43 & 384) != 0) goto L35;
        if (r1.changed(r33) == false) goto L32;
        int r30 = 256;
    L33:
        r3 = r3 | r30;
        goto L35
    L32:
        r30 = 128;
        goto L33
    L17:
        if ((r43 & 48) != 0) goto L24;
        if (r1.changedInstance(r32) == false) goto L21;
        int r38 = 32;
    L22:
        r3 = r3 | r38;
        goto L24
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r3 = r43;
        goto L14
    L8:
        if (r1.changed(r31) == false) goto L10;
        int r40 = 4;
    L11:
        r3 = r40 | r43;
        goto L14
    L10:
        r40 = 2;
        goto L11
    }
}
