package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.selection.SelectableKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a]\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0091\u0001\u0010\u0014\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00162\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u0007H\u0007¢\u0006\u0004\b!\u0010\"\u001aO\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162&\u0010\u000b\u001a\"\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0004\b*\u0010+\u001a?\u0010,\u001a\u00020\u00012\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u000e2\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018¢\u0006\u0002\b\u000e2\b\b\u0001\u0010-\u001a\u00020&H\u0003¢\u0006\u0002\u0010.\u001a#\u0010/\u001a\u000200*\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002¢\u0006\u0004\b6\u00107\u001a5\u00108\u001a\u000200*\u0002012\u0006\u00109\u001a\u0002032\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\b\u0001\u0010-\u001a\u00020&H\u0002¢\u0006\u0004\b:\u0010;\"\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020&0=X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010>\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010@\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010A\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u000e\u0010B\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C²\u0006\n\u0010)\u001a\u00020&X\u008a\u0084\u0002"}, d2 = {"BottomNavigation", "", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-_UMDTes", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "BottomNavigationHeight", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "ZeroInsets", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = null;
    private static final float BottomNavigationHeight = 0.0f;
    private static final float BottomNavigationItemHorizontalPadding = 0.0f;
    private static final float CombinedItemTextBaseline = 0.0f;
    private static final WindowInsets ZeroInsets = null;

    private static final Unit BottomNavigationItemBaselineLayout$lambda$11(Function2 r0, Function2 r1, float r2, int r3, Composer r4, int r5) {
        BottomNavigationItemBaselineLayout(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit BottomNavigationItem_jY6E1Zs$lambda$4(RowScope r17, boolean r18, Function0 r19, Function2 r20, Modifier r21, boolean r22, Function2 r23, boolean r24, MutableInteractionSource r25, long r26, long r28, int r30, int r31, int r32, Composer r33, int r34) {
        m1948BottomNavigationItemjY6E1Zs(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r33, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31), r32);
        return Unit.INSTANCE;
    }

    private static final Unit BottomNavigationTransition_Klgx_Pg$lambda$6(long r9, long r11, boolean r13, Function3 r14, int r15, Composer r16, int r17) {
        m1949BottomNavigationTransitionKlgxPg(r9, r11, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit BottomNavigation_PEIptTM$lambda$1(Modifier r11, long r12, long r14, float r16, Function3 r17, int r18, int r19, Composer r20, int r21) {
        m1946BottomNavigationPEIptTM(r11, r12, r14, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit BottomNavigation__UMDTes$lambda$0(WindowInsets r12, Modifier r13, long r14, long r16, float r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        m1947BottomNavigation_UMDTes(r12, r13, r14, r16, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Placeable r0, int r1, Placeable.PlacementScope r2) {
        return placeIcon_3p2s80s$lambda$12(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(Modifier r0, long r1, long r3, float r5, Function3 r6, int r7, int r8, Composer r9, int r10) {
        return BottomNavigation_PEIptTM$lambda$1(r0, r1, r3, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit c(RowScope r1, boolean r2, Function0 r3, Function2 r4, Modifier r5, boolean r6, Function2 r7, boolean r8, MutableInteractionSource r9, long r10, long r12, int r14, int r15, int r16, Composer r17, int r18) {
        return BottomNavigationItem_jY6E1Zs$lambda$4(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit d(Function2 r0, Function2 r1, float r2, int r3, Composer r4, int r5) {
        return BottomNavigationItemBaselineLayout$lambda$11(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit e(float r0, Placeable r1, int r2, int r3, int r4, Placeable r5, int r6, int r7, Placeable.PlacementScope r8) {
        return placeLabelAndIcon_DIyivk0$lambda$13(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit f(WindowInsets r0, Modifier r1, long r2, long r4, float r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return BottomNavigation__UMDTes$lambda$0(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit g(long r0, long r2, boolean r4, Function3 r5, int r6, Composer r7, int r8) {
        return BottomNavigationTransition_Klgx_Pg$lambda$6(r0, r2, r4, r5, r6, r7, r8);
    }

    static {
        BottomNavigationAnimationSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
        BottomNavigationHeight = Dp.constructor-impl(56);
        float r0 = 12;
        BottomNavigationItemHorizontalPadding = Dp.constructor-impl(r0);
        CombinedItemTextBaseline = Dp.constructor-impl(r0);
        float r1 = 0;
        ZeroInsets = WindowInsetsKt.m1044WindowInsetsa9UjIt4(Dp.constructor-impl(r1), Dp.constructor-impl(r1), Dp.constructor-impl(r1), Dp.constructor-impl(r1));
    }

    public static final /* synthetic */ float access$getBottomNavigationHeight$p() {
        return BottomNavigationHeight;
    }

    private static final float BottomNavigationTransition_Klgx_Pg$lambda$5(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    public static final /* synthetic */ float access$BottomNavigationTransition_Klgx_Pg$lambda$5(State r0) {
        return BottomNavigationTransition_Klgx_Pg$lambda$5(r0);
    }

    /* JADX INFO: renamed from: access$placeIcon-3p2s80s, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m1950access$placeIcon3p2s80s(MeasureScope r0, Placeable r1, long r2) {
        return m1952placeIcon3p2s80s(r0, r1, r2);
    }

    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    private static final MeasureResult m1952placeIcon3p2s80s(MeasureScope r8, final Placeable r9, long r10) {
        int r3 = ConstraintsKt.constrainHeight-K40F9xA(r10, r8.roundToPx-0680j_4(BottomNavigationHeight));
        final int r11 = (r3 - r9.getHeight()) / 2;
        return MeasureScope.-CC.layout$default(r8, r9.getWidth(), r3, null, new s1(r9, r11), 4, null);
    }

    private static final Unit placeIcon_3p2s80s$lambda$12(Placeable r7, int r8, Placeable.PlacementScope r9) {
        Placeable.PlacementScope.placeRelative$default(r9, r7, 0, r8, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final void BottomNavigationItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> r16, final Function2<? super Composer, ? super Integer, Unit> r17, final float r18, Composer r19, final int r20) {
        Composer r5 = r19.startRestartGroup(-1481587758);
        if ((r20 & 6) == 0) goto L5;
        int r6 = r20;
    L11:
        if ((r20 & 48) != 0) goto L18;
        if (r5.changedInstance(r17) == false) goto L15;
        int r8 = 32;
    L16:
        r6 = r6 | r8;
        goto L18
    L15:
        r8 = 16;
    L18:
        if ((r20 & 384) == 0) goto L20;
    L24:
        boolean r12 = true;
        if ((r6 & 147) == 146) goto L27;
        boolean r9 = true;
    L29:
        if (r5.shouldExecute(r9, r6 & 1) == true) goto L31;
        r5.skipToGroupEnd();
    L90:
        ScopeUpdateScope r4 = r5.endRestartGroup();
        if (r4 == null) goto L94;
        r4.updateScope(new t1(r16, r17, r18, r20));
        return;
    L94:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-1481587758, r6, -1, "androidx.compose.material.BottomNavigationItemBaselineLayout (BottomNavigation.kt:311)");
    L34:
        if ((r6 & 112) != 32) goto L36;
        boolean r7 = true;
    L38:
        if ((r6 & 896) == 256) goto L41;
        r12 = false;
    L41:
        boolean r10 = r7 | r12;
        Object r11 = r5.rememberedValue();
        if (r10 == false) goto L44;
    L45:
        r11 = new BottomNavigationKt$BottomNavigationItemBaselineLayout$2$1(r17, r18);
        r5.updateRememberedValue(r11);
    L46:
        MeasurePolicy r13 = (MeasurePolicy) r11;
        Modifier.Companion r14 = Modifier.Companion;
        int r15 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r110 = r5.getCurrentCompositionLocalMap();
        Modifier r111 = ComposedModifierKt.materializeModifier(r5, r14);
        ComposeUiNode.Companion r112 = ComposeUiNode.Companion;
        Function0 r113 = r112.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L49;
        ComposablesKt.invalidApplier();
    L49:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L52;
        r5.createNode(r113);
    L53:
        Composer r114 = Updater.constructor-impl(r5);
        Updater.set-impl(r114, r13, r112.getSetMeasurePolicy());
        Updater.set-impl(r114, r110, r112.getSetResolvedCompositionLocals());
        Function2 r21 = r112.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L56;
    L57:
        r114.updateRememberedValue(Integer.valueOf(r15));
        r114.apply(Integer.valueOf(r15), r21);
    L58:
        Updater.set-impl(r114, r111, r112.getSetModifier());
        Modifier r22 = LayoutIdKt.layoutId(r14, "icon");
        Alignment.Companion r23 = Alignment.Companion;
        MeasurePolicy r115 = BoxKt.maybeCachedBoxMeasurePolicy(r23.getTopStart(), false);
        int r116 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r117 = r5.getCurrentCompositionLocalMap();
        Modifier r24 = ComposedModifierKt.materializeModifier(r5, r22);
        Function0 r118 = r112.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L61;
        ComposablesKt.invalidApplier();
    L61:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L64;
        r5.createNode(r118);
    L65:
        Composer r119 = Updater.constructor-impl(r5);
        Updater.set-impl(r119, r115, r112.getSetMeasurePolicy());
        Updater.set-impl(r119, r117, r112.getSetResolvedCompositionLocals());
        Function2 r120 = r112.getSetCompositeKeyHash();
        if (r119.getInserting() == false) goto L68;
    L69:
        r119.updateRememberedValue(Integer.valueOf(r116));
        r119.apply(Integer.valueOf(r116), r120);
    L70:
        Updater.set-impl(r119, r24, r112.getSetModifier());
        BoxScopeInstance r25 = BoxScopeInstance.INSTANCE;
        r16.invoke(r5, Integer.valueOf(r6 & 14));
        r5.endNode();
        if (r17 == null) goto L85;
        r5.startReplaceGroup(1977704767);
        Modifier r26 = PaddingKt.m962paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(r14, "label"), r18), BottomNavigationItemHorizontalPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        MeasurePolicy r27 = BoxKt.maybeCachedBoxMeasurePolicy(r23.getTopStart(), false);
        int r28 = ComposablesKt.getCurrentCompositeKeyHash(r5, 0);
        CompositionLocalMap r29 = r5.getCurrentCompositionLocalMap();
        Modifier r30 = ComposedModifierKt.materializeModifier(r5, r26);
        Function0 r121 = r112.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L75;
        ComposablesKt.invalidApplier();
    L75:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L78;
        r5.createNode(r121);
    L79:
        Composer r122 = Updater.constructor-impl(r5);
        Updater.set-impl(r122, r27, r112.getSetMeasurePolicy());
        Updater.set-impl(r122, r29, r112.getSetResolvedCompositionLocals());
        Function2 r31 = r112.getSetCompositeKeyHash();
        if (r122.getInserting() == false) goto L82;
    L83:
        r122.updateRememberedValue(Integer.valueOf(r28));
        r122.apply(Integer.valueOf(r28), r31);
    L84:
        Updater.set-impl(r122, r30, r112.getSetModifier());
        r17.invoke(r5, Integer.valueOf((r6 >> 3) & 14));
        r5.endNode();
        r5.endReplaceGroup();
    L86:
        r5.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L90;
        ComposerKt.traceEventEnd();
        goto L90
    L82:
        if (Intrinsics.areEqual(r122.rememberedValue(), Integer.valueOf(r28)) == true) goto L84;
    L78:
        r5.useNode();
        goto L79
    L85:
        r5.startReplaceGroup(1977958471);
        r5.endReplaceGroup();
        goto L86
    L68:
        if (Intrinsics.areEqual(r119.rememberedValue(), Integer.valueOf(r116)) == true) goto L70;
    L64:
        r5.useNode();
        goto L65
    L56:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r15)) == true) goto L58;
    L52:
        r5.useNode();
        goto L53
    L44:
        if (r11 != Composer.Companion.getEmpty()) goto L46;
    L36:
        r7 = false;
        goto L38
    L27:
        r9 = false;
        goto L29
    L20:
        if (r5.changed(r18) == false) goto L22;
        int r32 = 256;
    L23:
        r6 = r6 | r32;
        goto L24
    L22:
        r32 = 128;
        goto L23
    L5:
        if (r5.changedInstance(r16) == false) goto L7;
        int r33 = 4;
    L8:
        r6 = r33 | r20;
        goto L11
    L7:
        r33 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$BottomNavigationItemBaselineLayout(Function2 r0, Function2 r1, float r2, Composer r3, int r4) {
        BottomNavigationItemBaselineLayout(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: access$placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m1951access$placeLabelAndIconDIyivk0(MeasureScope r0, Placeable r1, Placeable r2, long r3, float r5) {
        return m1953placeLabelAndIconDIyivk0(r0, r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    private static final MeasureResult m1953placeLabelAndIconDIyivk0(MeasureScope r15, final Placeable r16, final Placeable r17, long r18, final float r20) {
        int r2 = r15.roundToPx-0680j_4(CombinedItemTextBaseline) - r16.get(AlignmentLineKt.getFirstBaseline());
        int r1 = (r17.getHeight() + r16.getHeight()) + r2;
        int r11 = ConstraintsKt.constrainHeight-K40F9xA(r18, Math.max(r1, r15.roundToPx-0680j_4(BottomNavigationHeight)));
        final int r10 = RangesKt.coerceAtLeast((r11 - r1) / 2, 0);
        int r3 = (r11 - r17.getHeight()) / 2;
        final int r6 = (r17.getHeight() + r10) + r2;
        int r12 = Math.max(r16.getWidth(), r17.getWidth());
        final int r5 = (r12 - r16.getWidth()) / 2;
        final int r9 = (r12 - r17.getWidth()) / 2;
        final int r7 = MathKt.roundToInt((r3 - r10) * (1 - r20));
        return MeasureScope.-CC.layout$default(r15, r12, r11, null, new q1(r20, r16, r5, r6, r7, r17, r9, r10), 4, null);
    }

    /* JADX INFO: renamed from: BottomNavigationTransition-Klgx-Pg, reason: not valid java name */
    private static final void m1949BottomNavigationTransitionKlgxPg(final long r26, final long r28, final boolean r30, final Function3<? super Float, ? super Composer, ? super Integer, Unit> r31, Composer r32, final int r33) {
        Composer r15 = r32.startRestartGroup(616920545);
        if ((r33 & 6) == 0) goto L5;
        int r8 = r33;
    L11:
        if ((r33 & 48) != 0) goto L18;
        if (r15.changed(r28) == false) goto L15;
        int r9 = 32;
    L16:
        r8 = r8 | r9;
        goto L18
    L15:
        r9 = 16;
    L18:
        if ((r33 & 384) != 0) goto L25;
        if (r15.changed(r30) == false) goto L22;
        int r10 = 256;
    L23:
        r8 = r8 | r10;
        goto L25
    L22:
        r10 = 128;
    L25:
        if ((r33 & 3072) != 0) goto L32;
        if (r15.changedInstance(r31) == false) goto L29;
        int r11 = 2048;
    L30:
        r8 = r8 | r11;
        goto L32
    L29:
        r11 = 1024;
    L32:
        if ((r8 & 1171) == 1170) goto L34;
        boolean r12 = true;
    L36:
        if (r15.shouldExecute(r12, r8 & 1) == true) goto L38;
        Composer r0 = r15;
        r0.skipToGroupEnd();
    L47:
        ScopeUpdateScope r13 = r0.endRestartGroup();
        if (r13 == null) goto L51;
        r13.updateScope(new w1(r26, r28, r30, r31, r33));
        return;
    L51:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(616920545, r8, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:279)");
    L40:
        if (r30 == false) goto L42;
        float r14 = 1.0f;
    L43:
        r0 = r15;
        final State<Float> r16 = AnimateAsStateKt.animateFloatAsState(r14, BottomNavigationAnimationSpec, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, null, r15, 48, 28);
        long r17 = ColorKt.lerp-jxsXWHM(r28, r26, BottomNavigationTransition_Klgx_Pg$lambda$5(r16));
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(Color.copy-wmQWz5c$default(r17, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(r17)))}, ComposableLambdaKt.rememberComposableLambda(343660833, true, new BottomNavigationKt$BottomNavigationTransition$1(r31, r16), r0, 54), r0, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventEnd();
        goto L47
    L42:
        r14 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L43
    L34:
        r12 = false;
        goto L36
    L5:
        if (r15.changed(r26) == false) goto L7;
        int r18 = 4;
    L8:
        r8 = r18 | r33;
        goto L11
    L7:
        r18 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: BottomNavigation-PEIptTM, reason: not valid java name */
    public static final void m1946BottomNavigationPEIptTM(Modifier r22, long r23, long r25, float r27, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r28, Composer r29, final int r30, final int r31) {
        Composer r1 = r29.startRestartGroup(783675913);
        int r2 = r31 & 1;
        if (r2 == 0) goto L6;
        int r4 = r30 | 6;
        Modifier r3 = r22;
    L14:
        if ((r30 & 48) == 0) goto L16;
        long r5 = r23;
    L25:
        if ((r30 & 384) != 0) goto L33;
        long r9 = r25;
        if ((r31 & 4) == 0) goto L29;
    L31:
        int r7 = 128;
    L32:
        r4 = r4 | r7;
    L34:
        int r8 = r31 & 8;
        if (r8 == 0) goto L38;
        r4 = r4 | 3072;
    L44:
        float r11 = r27;
    L46:
        if ((r31 & 16) == 0) goto L49;
        r4 = r4 | 24576;
    L56:
        if ((r4 & 9363) == 9362) goto L58;
        boolean r12 = true;
    L60:
        if (r1.shouldExecute(r12, r4 & 1) == false) goto L93;
        r1.startDefaults();
        if ((r30 & 1) != 0) goto L64;
    L75:
        if (r2 == 0) goto L77;
        Modifier r6 = Modifier.Companion;
    L79:
        if ((r31 & 2) == 0) goto L82;
        r5 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(r1, 6));
        r4 = r4 & (-113);
    L82:
        if ((r31 & 4) == 0) goto L84;
        r9 = ColorsKt.m2017contentColorForek8zF_U(r5, r1, (r4 >> 3) & 14);
        r4 = r4 & (-897);
    L84:
        if (r8 != 0) goto L85;
    L73:
        float r10 = r11;
    L74:
        long r20 = r9;
        int r13 = r4;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventStart(783675913, r13, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:161)");
    L89:
        int r14 = r13 << 3;
        int r18 = (((((r14 & 112) | 6) | (r14 & 896)) | (r14 & 7168)) | (57344 & r14)) | (r14 & 458752);
        m1947BottomNavigation_UMDTes(ZeroInsets, r6, r5, r20, r10, r28, r1, r18, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventEnd();
    L92:
        r9 = r20;
    L94:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L98;
        final Modifier r16 = r6;
        final long r17 = r5;
        final long r19 = r9;
        final float r21 = r10;
        r15.updateScope(new r1(r16, r17, r19, r21, r28, r30, r31));
        return;
    L98:
        return;
    L85:
        r10 = BottomNavigationDefaults.INSTANCE.m1945getElevationD9Ej5fM();
        goto L74
    L77:
        r6 = r3;
        goto L79
    L64:
        if (r1.getDefaultsInvalid() == true) goto L75;
        r1.skipToGroupEnd();
        if ((r31 & 2) == 0) goto L70;
        r4 = r4 & (-113);
    L70:
        if ((r31 & 4) == 0) goto L72;
        r4 = r4 & (-897);
    L72:
        r6 = r3;
        goto L73
    L93:
        r1.skipToGroupEnd();
        r6 = r3;
        r10 = r11;
        goto L94
    L58:
        r12 = false;
        goto L60
    L49:
        if ((r30 & 24576) != 0) goto L56;
        if (r1.changedInstance(r28) == false) goto L53;
        int r110 = 16384;
    L54:
        r4 = r4 | r110;
        goto L56
    L53:
        r110 = 8192;
        goto L54
    L38:
        if ((r30 & 3072) != 0) goto L44;
        r11 = r27;
        if (r1.changed(r11) == false) goto L42;
        int r111 = 2048;
    L43:
        r4 = r4 | r111;
        goto L46
    L42:
        r111 = 1024;
        goto L43
    L29:
        if (r1.changed(r9) == false) goto L31;
        r7 = 256;
        goto L32
    L33:
        r9 = r25;
        goto L34
    L16:
        if ((r31 & 2) != 0) goto L20;
        r5 = r23;
        if (r1.changed(r5) == false) goto L21;
        int r24 = 32;
    L22:
        r4 = r4 | r24;
    L21:
        r24 = 16;
        goto L22
    L20:
        r5 = r23;
        goto L21
    L6:
        if ((r30 & 6) != 0) goto L12;
        r3 = r22;
        if (r1.changed(r3) == false) goto L10;
        int r26 = 4;
    L11:
        r4 = r26 | r30;
        goto L14
    L10:
        r26 = 2;
        goto L11
    L12:
        r3 = r22;
        r4 = r30;
        goto L14
    }

    /* JADX INFO: renamed from: BottomNavigation-_UMDTes, reason: not valid java name */
    public static final void m1947BottomNavigation_UMDTes(final WindowInsets r25, Modifier r26, long r27, long r29, float r31, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        Composer r2 = r33.startRestartGroup(-636542119);
        if ((r35 & 1) == 0) goto L6;
        int r3 = r34 | 6;
    L13:
        int r4 = r35 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r26;
    L25:
        if ((r34 & 384) == 0) goto L27;
        long r6 = r27;
    L36:
        if ((r34 & 3072) == 0) goto L38;
        long r10 = r29;
    L46:
        int r12 = r35 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        float r13 = r31;
    L58:
        if ((r35 & 32) == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        if ((74899 & r3) == 74898) goto L70;
        boolean r14 = true;
    L72:
        if (r2.shouldExecute(r14, r3 & 1) == false) goto L103;
        r2.startDefaults();
        if ((r34 & 1) != 0) goto L76;
    L86:
        if (r4 == 0) goto L89;
        r5 = Modifier.Companion;
    L89:
        if ((r35 & 4) == 0) goto L92;
        r6 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(r2, 6));
        r3 = r3 & (-897);
    L92:
        if ((r35 & 8) == 0) goto L94;
        r10 = ColorsKt.m2017contentColorForek8zF_U(r6, r2, (r3 >> 6) & 14);
        r3 = r3 & (-7169);
    L94:
        if (r12 != 0) goto L95;
    L84:
        float r22 = r13;
    L85:
        long r23 = r10;
        int r11 = r3;
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventStart(-636542119, r11, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:106)");
    L99:
        ComposableLambda r18 = ComposableLambdaKt.rememberComposableLambda(807373717, true, new BottomNavigationKt$BottomNavigation$1(r25, r32), r2, 54);
        int r20 = (((((r11 >> 3) & 14) | 1572864) | (r11 & 896)) | (r11 & 7168)) | ((r11 << 3) & 458752);
        SurfaceKt.m2175SurfaceFjzlyU(r5, null, r6, r23, null, r22, r18, r2, r20, 18);
        if (ComposerKt.isTraceInProgress() == false) goto L102;
        ComposerKt.traceEventEnd();
    L102:
        r10 = r23;
        final long r7 = r6;
        final float r8 = r22;
    L104:
        ScopeUpdateScope r15 = r2.endRestartGroup();
        if (r15 == null) goto L108;
        final Modifier r9 = r5;
        final long r16 = r10;
        r15.updateScope(new v1(r25, r9, r7, r16, r8, r32, r34, r35));
        return;
    L108:
        return;
    L95:
        r22 = BottomNavigationDefaults.INSTANCE.m1945getElevationD9Ej5fM();
        goto L85
    L76:
        if (r2.getDefaultsInvalid() == true) goto L86;
        r2.skipToGroupEnd();
        if ((r35 & 4) == 0) goto L82;
        r3 = r3 & (-897);
    L82:
        if ((r35 & 8) == 0) goto L84;
        r3 = r3 & (-7169);
        goto L84
    L103:
        r2.skipToGroupEnd();
        r7 = r6;
        r8 = r13;
        goto L104
    L70:
        r14 = false;
        goto L72
    L61:
        if ((r34 & 196608) != 0) goto L68;
        if (r2.changedInstance(r32) == false) goto L65;
        int r17 = 131072;
    L66:
        r3 = r3 | r17;
        goto L68
    L65:
        r17 = 65536;
        goto L66
    L50:
        if ((r34 & 24576) != 0) goto L56;
        r13 = r31;
        if (r2.changed(r13) == false) goto L54;
        int r19 = 16384;
    L55:
        r3 = r3 | r19;
        goto L58
    L54:
        r19 = 8192;
        goto L55
    L38:
        if ((r35 & 8) != 0) goto L42;
        r10 = r29;
        if (r2.changed(r10) == false) goto L43;
        int r110 = 2048;
    L44:
        r3 = r3 | r110;
    L43:
        r110 = 1024;
        goto L44
    L42:
        r10 = r29;
        goto L43
    L27:
        if ((r35 & 4) != 0) goto L31;
        r6 = r27;
        if (r2.changed(r6) == false) goto L32;
        int r111 = 256;
    L33:
        r3 = r3 | r111;
    L32:
        r111 = 128;
        goto L33
    L31:
        r6 = r27;
        goto L32
    L17:
        if ((r34 & 48) != 0) goto L23;
        r5 = r26;
        if (r2.changed(r5) == false) goto L21;
        int r21 = 32;
    L22:
        r3 = r3 | r21;
        goto L25
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r3 = r34;
        goto L13
    L8:
        if (r2.changed(r25) == false) goto L10;
        int r24 = 4;
    L11:
        r3 = r24 | r34;
        goto L13
    L10:
        r24 = 2;
        goto L11
    }

    private static final Unit placeLabelAndIcon_DIyivk0$lambda$13(float r7, Placeable r8, int r9, int r10, int r11, Placeable r12, int r13, int r14, Placeable.PlacementScope r15) {
        if (r7 != androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        Placeable.PlacementScope.placeRelative$default(r15, r8, r9, r10 + r11, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    L8:
        Placeable.PlacementScope.placeRelative$default(r15, r12, r13, r14 + r11, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: BottomNavigationItem-jY6E1Zs, reason: not valid java name */
    public static final void m1948BottomNavigationItemjY6E1Zs(final RowScope r25, final boolean r26, final Function0<Unit> r27, final Function2<? super Composer, ? super Integer, Unit> r28, Modifier r29, boolean r30, Function2<? super Composer, ? super Integer, Unit> r31, boolean r32, MutableInteractionSource r33, long r34, long r36, Composer r38, final int r39, final int r40, final int r41) {
        Composer r1 = r38.startRestartGroup(-1744464261);
        if ((Integer.MIN_VALUE & r41) == 0) goto L6;
        int r6 = r39 | 6;
    L14:
        if ((r41 & 1) == 0) goto L17;
        r6 = r6 | 48;
    L25:
        if ((r41 & 2) == 0) goto L28;
        r6 = r6 | 384;
    L36:
        if ((r41 & 4) == 0) goto L39;
        r6 = r6 | 3072;
    L45:
        int r9 = r41 & 8;
        if (r9 == 0) goto L49;
        r6 = r6 | 24576;
    L55:
        Modifier r10 = r29;
    L56:
        int r11 = r41 & 16;
        if (r11 == 0) goto L60;
        r6 = r6 | 196608;
    L66:
        boolean r12 = r30;
    L67:
        int r13 = r41 & 32;
        if (r13 == 0) goto L71;
        r6 = r6 | 1572864;
    L77:
        int r16 = r41 & 64;
        if (r16 == 0) goto L81;
        r6 = r6 | 12582912;
    L87:
        int r5 = r41 & 128;
        if (r5 == 0) goto L91;
        r6 = r6 | 100663296;
    L98:
        if ((r39 & 805306368) != 0) goto L108;
        if ((r41 & 256) == 0) goto L102;
    L104:
        int r0 = 268435456;
    L105:
        r6 = r6 | r0;
        goto L108
    L102:
        if (r1.changed(r34) == false) goto L104;
        r0 = 536870912;
    L108:
        if ((r40 & 6) == 0) goto L110;
        int r2 = r40;
    L118:
        if ((r6 & 306783379) == 306783378) goto L120;
    L123:
        boolean r3 = true;
    L125:
        if (r1.shouldExecute(r3, r6 & 1) == false) goto L182;
        r1.startDefaults();
        Function2 r18 = null;
        if ((r39 & 1) != 0) goto L129;
    L138:
        if (r9 == 0) goto L140;
        Modifier r4 = Modifier.Companion;
    L141:
        if (r11 == 0) goto L143;
        r12 = true;
    L143:
        if (r13 == 0) goto L145;
        final Function2<? super Composer, ? super Integer, Unit> r14 = null;
    L146:
        if (r16 == 0) goto L148;
        final boolean r15 = true;
    L149:
        if (r5 == 0) goto L151;
        MutableInteractionSource r7 = null;
    L153:
        if ((r41 & 256) == 0) goto L155;
        long r19 = ((Color) r1.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        r6 = r6 & (-1879048193);
    L157:
        if ((r41 & 512) == 0) goto L159;
        long r21 = Color.copy-wmQWz5c$default(r19, ContentAlpha.INSTANCE.getMedium(r1, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        r2 = r2 & (-15);
    L160:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L163;
        ComposerKt.traceEventStart(-1744464261, r6, r2, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:208)");
    L163:
        if (r14 != null) goto L165;
        r1.startReplaceGroup(-229962826);
    L166:
        r1.endReplaceGroup();
        final Function2 r8 = r18;
        Modifier r17 = RowScope.CC.weight$default(r25, SelectableKt.m1289selectableO2vRcR0(r4, r26, r7, RippleKt.m2139rippleH2RKhps$default(false, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r19, 2, null), r12, Role.box-impl(Role.Companion.getTab-o7Vup1c()), r27), 1.0f, false, 2, null);
        MeasurePolicy r110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r20 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        Modifier r37 = r4;
        CompositionLocalMap r22 = r1.getCurrentCompositionLocalMap();
        Modifier r111 = ComposedModifierKt.materializeModifier(r1, r17);
        ComposeUiNode.Companion r112 = ComposeUiNode.Companion;
        MutableInteractionSource r310 = r7;
        Function0 r23 = r112.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L169;
        ComposablesKt.invalidApplier();
    L169:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L172;
        r1.createNode(r23);
    L173:
        Composer r24 = Updater.constructor-impl(r1);
        Updater.set-impl(r24, r110, r112.getSetMeasurePolicy());
        Updater.set-impl(r24, r22, r112.getSetResolvedCompositionLocals());
        Function2 r35 = r112.getSetCompositeKeyHash();
        if (r24.getInserting() == false) goto L176;
    L177:
        r24.updateRememberedValue(Integer.valueOf(r20));
        r24.apply(Integer.valueOf(r20), r35);
    L178:
        Updater.set-impl(r24, r111, r112.getSetModifier());
        BoxScopeInstance r42 = BoxScopeInstance.INSTANCE;
        long r210 = r19;
        long r311 = r21;
        m1949BottomNavigationTransitionKlgxPg(r210, r311, r26, ComposableLambdaKt.rememberComposableLambda(2011119551, true, new BottomNavigationKt$BottomNavigationItem$1$1(r15, r28, r8), r1, 54), r1, (((r2 << 3) & 112) | (((r6 >> 27) & 14) | 3072)) | ((r6 << 3) & 896));
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L181;
        ComposerKt.traceEventEnd();
    L181:
        final Modifier r43 = r37;
        final Function2<? super Composer, ? super Integer, Unit> r44 = r14;
        final boolean r45 = r15;
        final boolean r46 = r12;
        final long r113 = r19;
        final long r114 = r21;
        final MutableInteractionSource r47 = r310;
    L183:
        ScopeUpdateScope r48 = r1.endRestartGroup();
        if (r48 == null) goto L187;
        r48.updateScope(new u1(r25, r26, r27, r28, r43, r46, r44, r45, r47, r113, r114, r39, r40, r41));
        return;
    L187:
        return;
    L176:
        if (Intrinsics.areEqual(r24.rememberedValue(), Integer.valueOf(r20)) == true) goto L178;
    L172:
        r1.useNode();
        goto L173
    L165:
        r1.startReplaceGroup(-229962825);
        r18 = ComposableLambdaKt.rememberComposableLambda(2120789583, true, new BottomNavigationKt$BottomNavigationItem$styledLabel$1$1(r14), r1, 54);
        goto L166
    L159:
        r21 = r36;
        goto L160
    L155:
        r19 = r34;
        goto L157
    L151:
        r7 = r33;
        goto L153
    L148:
        r15 = r32;
        goto L149
    L145:
        r14 = r31;
        goto L146
    L140:
        r4 = r10;
        goto L141
    L129:
        if (r1.getDefaultsInvalid() == true) goto L138;
        r1.skipToGroupEnd();
        if ((r41 & 256) == 0) goto L135;
        r6 = r6 & (-1879048193);
    L135:
        if ((r41 & 512) == 0) goto L137;
        r2 = r2 & (-15);
    L137:
        r14 = r31;
        r7 = r33;
        r19 = r34;
        r21 = r36;
        r4 = r10;
        r15 = r32;
        goto L160
    L182:
        r1.skipToGroupEnd();
        r44 = r31;
        r45 = r32;
        r47 = r33;
        r43 = r10;
        r46 = r12;
        r113 = r34;
        r114 = r36;
        goto L183
    L120:
        if ((r2 & 3) != 2) goto L123;
        r3 = false;
        goto L125
    L110:
        if ((r41 & 512) == 0) goto L112;
    L114:
        int r49 = 2;
    L115:
        r2 = r40 | r49;
        goto L118
    L112:
        if (r1.changed(r36) == false) goto L114;
        r49 = 4;
        goto L115
    L91:
        if ((r39 & 100663296) != 0) goto L98;
        if (r1.changed(r33) == false) goto L95;
        int r115 = 67108864;
    L96:
        r6 = r6 | r115;
        goto L98
    L95:
        r115 = 33554432;
        goto L96
    L81:
        if ((r39 & 12582912) != 0) goto L87;
        if (r1.changed(r32) == false) goto L85;
        int r116 = 8388608;
    L86:
        r6 = r6 | r116;
        goto L87
    L85:
        r116 = 4194304;
        goto L86
    L71:
        if ((r39 & 1572864) != 0) goto L77;
        if (r1.changedInstance(r31) == false) goto L75;
        int r117 = 1048576;
    L76:
        r6 = r6 | r117;
        goto L77
    L75:
        r117 = 524288;
        goto L76
    L60:
        if ((196608 & r39) != 0) goto L66;
        r12 = r30;
        if (r1.changed(r12) == false) goto L64;
        int r118 = 131072;
    L65:
        r6 = r6 | r118;
        goto L67
    L64:
        r118 = 65536;
        goto L65
    L49:
        if ((r39 & 24576) != 0) goto L55;
        r10 = r29;
        if (r1.changed(r10) == false) goto L53;
        int r119 = 16384;
    L54:
        r6 = r6 | r119;
        goto L56
    L53:
        r119 = 8192;
        goto L54
    L39:
        if ((r39 & 3072) != 0) goto L45;
        if (r1.changedInstance(r28) == false) goto L43;
        int r50 = 2048;
    L44:
        r6 = r6 | r50;
        goto L45
    L43:
        r50 = 1024;
        goto L44
    L28:
        if ((r39 & 384) != 0) goto L36;
        if (r1.changedInstance(r27) == false) goto L32;
        int r51 = 256;
    L33:
        r6 = r6 | r51;
        goto L36
    L32:
        r51 = 128;
        goto L33
    L17:
        if ((r39 & 48) != 0) goto L25;
        if (r1.changed(r26) == false) goto L21;
        int r52 = 32;
    L22:
        r6 = r6 | r52;
        goto L25
    L21:
        r52 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r6 = r39;
        goto L14
    L8:
        if (r1.changed(r25) == false) goto L10;
        int r53 = 4;
    L11:
        r6 = r53 | r39;
        goto L14
    L10:
        r53 = 2;
        goto L11
    }
}
