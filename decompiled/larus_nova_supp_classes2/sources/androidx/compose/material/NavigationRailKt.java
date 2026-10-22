package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aw\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u008d\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00172\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010#\u001aO\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172&\u0010\u0010\u001a\"\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0004\b+\u0010,\u001a?\u0010-\u001a\u00020\u00012\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000e2\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019¢\u0006\u0002\b\u000e2\b\b\u0001\u0010.\u001a\u00020'H\u0003¢\u0006\u0002\u0010/\u001a#\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108\u001a5\u00109\u001a\u000201*\u0002022\u0006\u0010:\u001a\u0002042\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\b\u0001\u0010.\u001a\u00020'H\u0002¢\u0006\u0004\b;\u0010<\"\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020'0>X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010?\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010C\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010D\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010E\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u000e\u0010F\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G²\u0006\n\u0010*\u001a\u00020'X\u008a\u0084\u0002"}, d2 = {"NavigationRail", "", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "NavigationRail-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailTransition", "activeColor", "inactiveColor", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "NavigationRailItemSize", "F", "NavigationRailItemCompactSize", "NavigationRailPadding", "HeaderPadding", "ItemLabelBaselineBottomOffset", "ItemIconTopOffset", "ZeroInsets", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationRailKt {
    private static final float HeaderPadding = 0.0f;
    private static final float ItemIconTopOffset = 0.0f;
    private static final float ItemLabelBaselineBottomOffset = 0.0f;
    private static final TweenSpec<Float> NavigationRailAnimationSpec = null;
    private static final float NavigationRailItemCompactSize = 0.0f;
    private static final float NavigationRailItemSize = 0.0f;
    private static final float NavigationRailPadding = 0.0f;
    private static final WindowInsets ZeroInsets = null;

    private static final Unit NavigationRailItemBaselineLayout$lambda$11(Function2 r0, Function2 r1, float r2, int r3, Composer r4, int r5) {
        NavigationRailItemBaselineLayout(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit NavigationRailItem_0S3VyRs$lambda$4(boolean r16, Function0 r17, Function2 r18, Modifier r19, boolean r20, Function2 r21, boolean r22, MutableInteractionSource r23, long r24, long r26, int r28, int r29, Composer r30, int r31) {
        m2106NavigationRailItem0S3VyRs(r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), r29);
        return Unit.INSTANCE;
    }

    private static final Unit NavigationRailTransition_Klgx_Pg$lambda$6(long r9, long r11, boolean r13, Function3 r14, int r15, Composer r16, int r17) {
        m2107NavigationRailTransitionKlgxPg(r9, r11, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit NavigationRail_HsRjFd4$lambda$1(Modifier r12, long r13, long r15, float r17, Function3 r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        m2104NavigationRailHsRjFd4(r12, r13, r15, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit NavigationRail_afqeVBk$lambda$0(WindowInsets r13, Modifier r14, long r15, long r17, float r19, Function3 r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m2105NavigationRailafqeVBk(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Placeable r0, int r1, int r2, Placeable.PlacementScope r3) {
        return placeIcon_3p2s80s$lambda$12(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(Function2 r0, Function2 r1, float r2, int r3, Composer r4, int r5) {
        return NavigationRailItemBaselineLayout$lambda$11(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit c(boolean r0, Function0 r1, Function2 r2, Modifier r3, boolean r4, Function2 r5, boolean r6, MutableInteractionSource r7, long r8, long r10, int r12, int r13, Composer r14, int r15) {
        return NavigationRailItem_0S3VyRs$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r10, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit d(long r0, long r2, boolean r4, Function3 r5, int r6, Composer r7, int r8) {
        return NavigationRailTransition_Klgx_Pg$lambda$6(r0, r2, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit e(WindowInsets r0, Modifier r1, long r2, long r4, float r6, Function3 r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return NavigationRail_afqeVBk$lambda$0(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit f(Modifier r0, long r1, long r3, float r5, Function3 r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return NavigationRail_HsRjFd4$lambda$1(r0, r1, r3, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit g(float r0, Placeable r1, int r2, int r3, int r4, Placeable r5, int r6, int r7, Placeable.PlacementScope r8) {
        return placeLabelAndIcon_DIyivk0$lambda$13(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    static {
        NavigationRailAnimationSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
        NavigationRailItemSize = Dp.constructor-impl(72);
        NavigationRailItemCompactSize = Dp.constructor-impl(56);
        float r0 = 8;
        NavigationRailPadding = Dp.constructor-impl(r0);
        HeaderPadding = Dp.constructor-impl(r0);
        ItemLabelBaselineBottomOffset = Dp.constructor-impl(16);
        ItemIconTopOffset = Dp.constructor-impl(14);
        ZeroInsets = WindowInsetsKt.m1045WindowInsetsa9UjIt4$default(Dp.constructor-impl(0), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    }

    public static final /* synthetic */ float access$getHeaderPadding$p() {
        return HeaderPadding;
    }

    public static final /* synthetic */ float access$getNavigationRailPadding$p() {
        return NavigationRailPadding;
    }

    private static final float NavigationRailTransition_Klgx_Pg$lambda$5(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    public static final /* synthetic */ float access$NavigationRailTransition_Klgx_Pg$lambda$5(State r0) {
        return NavigationRailTransition_Klgx_Pg$lambda$5(r0);
    }

    /* JADX INFO: renamed from: access$placeIcon-3p2s80s, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m2108access$placeIcon3p2s80s(MeasureScope r0, Placeable r1, long r2) {
        return m2110placeIcon3p2s80s(r0, r1, r2);
    }

    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    private static final MeasureResult m2110placeIcon3p2s80s(MeasureScope r9, final Placeable r10, long r11) {
        final int r0 = Math.max(0, (Constraints.getMaxWidth-impl(r11) - r10.getWidth()) / 2);
        final int r1 = Math.max(0, (Constraints.getMaxHeight-impl(r11) - r10.getHeight()) / 2);
        return MeasureScope.-CC.layout$default(r9, Constraints.getMaxWidth-impl(r11), Constraints.getMaxHeight-impl(r11), null, new z6(r10, r0, r1), 4, null);
    }

    private static final Unit placeIcon_3p2s80s$lambda$12(Placeable r7, int r8, int r9, Placeable.PlacementScope r10) {
        Placeable.PlacementScope.placeRelative$default(r10, r7, r8, r9, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final void NavigationRailItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> r11, final Function2<? super Composer, ? super Integer, Unit> r12, final float r13, Composer r14, final int r15) {
        Composer r16 = r14.startRestartGroup(-1276874318);
        if ((r15 & 6) == 0) goto L5;
        int r1 = r15;
    L11:
        if ((r15 & 48) != 0) goto L18;
        if (r16.changedInstance(r12) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r15 & 384) == 0) goto L20;
    L24:
        boolean r6 = true;
        if ((r1 & 147) == 146) goto L27;
        boolean r3 = true;
    L29:
        if (r16.shouldExecute(r3, r1 & 1) == true) goto L31;
        r16.skipToGroupEnd();
    L90:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L94;
        r17.updateScope(new e7(r11, r12, r13, r15));
        return;
    L94:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-1276874318, r1, -1, "androidx.compose.material.NavigationRailItemBaselineLayout (NavigationRail.kt:317)");
    L34:
        if ((r1 & 112) != 32) goto L36;
        boolean r0 = true;
    L38:
        if ((r1 & 896) == 256) goto L41;
        r6 = false;
    L41:
        boolean r4 = r0 | r6;
        Object r5 = r16.rememberedValue();
        if (r4 == false) goto L44;
    L45:
        r5 = new NavigationRailKt$NavigationRailItemBaselineLayout$2$1(r12, r13);
        r16.updateRememberedValue(r5);
    L46:
        MeasurePolicy r7 = (MeasurePolicy) r5;
        Modifier.Companion r8 = Modifier.Companion;
        int r9 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r10 = r16.getCurrentCompositionLocalMap();
        Modifier r18 = ComposedModifierKt.materializeModifier(r16, r8);
        ComposeUiNode.Companion r19 = ComposeUiNode.Companion;
        Function0 r20 = r19.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L49;
        ComposablesKt.invalidApplier();
    L49:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L52;
        r16.createNode(r20);
    L53:
        Composer r21 = Updater.constructor-impl(r16);
        Updater.set-impl(r21, r7, r19.getSetMeasurePolicy());
        Updater.set-impl(r21, r10, r19.getSetResolvedCompositionLocals());
        Function2 r22 = r19.getSetCompositeKeyHash();
        if (r21.getInserting() == false) goto L56;
    L57:
        r21.updateRememberedValue(Integer.valueOf(r9));
        r21.apply(Integer.valueOf(r9), r22);
    L58:
        Updater.set-impl(r21, r18, r19.getSetModifier());
        Modifier r23 = LayoutIdKt.layoutId(r8, "icon");
        Alignment.Companion r24 = Alignment.Companion;
        MeasurePolicy r25 = BoxKt.maybeCachedBoxMeasurePolicy(r24.getTopStart(), false);
        int r26 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r27 = r16.getCurrentCompositionLocalMap();
        Modifier r28 = ComposedModifierKt.materializeModifier(r16, r23);
        Function0 r29 = r19.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L61;
        ComposablesKt.invalidApplier();
    L61:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L64;
        r16.createNode(r29);
    L65:
        Composer r30 = Updater.constructor-impl(r16);
        Updater.set-impl(r30, r25, r19.getSetMeasurePolicy());
        Updater.set-impl(r30, r27, r19.getSetResolvedCompositionLocals());
        Function2 r31 = r19.getSetCompositeKeyHash();
        if (r30.getInserting() == false) goto L68;
    L69:
        r30.updateRememberedValue(Integer.valueOf(r26));
        r30.apply(Integer.valueOf(r26), r31);
    L70:
        Updater.set-impl(r30, r28, r19.getSetModifier());
        BoxScopeInstance r32 = BoxScopeInstance.INSTANCE;
        r11.invoke(r16, Integer.valueOf(r1 & 14));
        r16.endNode();
        if (r12 == null) goto L85;
        r16.startReplaceGroup(-1177221249);
        Modifier r33 = AlphaKt.alpha(LayoutIdKt.layoutId(r8, "label"), r13);
        MeasurePolicy r34 = BoxKt.maybeCachedBoxMeasurePolicy(r24.getTopStart(), false);
        int r35 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r36 = r16.getCurrentCompositionLocalMap();
        Modifier r37 = ComposedModifierKt.materializeModifier(r16, r33);
        Function0 r38 = r19.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L75;
        ComposablesKt.invalidApplier();
    L75:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L78;
        r16.createNode(r38);
    L79:
        Composer r39 = Updater.constructor-impl(r16);
        Updater.set-impl(r39, r34, r19.getSetMeasurePolicy());
        Updater.set-impl(r39, r36, r19.getSetResolvedCompositionLocals());
        Function2 r40 = r19.getSetCompositeKeyHash();
        if (r39.getInserting() == false) goto L82;
    L83:
        r39.updateRememberedValue(Integer.valueOf(r35));
        r39.apply(Integer.valueOf(r35), r40);
    L84:
        Updater.set-impl(r39, r37, r19.getSetModifier());
        r12.invoke(r16, Integer.valueOf((r1 >> 3) & 14));
        r16.endNode();
        r16.endReplaceGroup();
    L86:
        r16.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L90;
        ComposerKt.traceEventEnd();
        goto L90
    L82:
        if (Intrinsics.areEqual(r39.rememberedValue(), Integer.valueOf(r35)) == true) goto L84;
    L78:
        r16.useNode();
        goto L79
    L85:
        r16.startReplaceGroup(-1177121305);
        r16.endReplaceGroup();
        goto L86
    L68:
        if (Intrinsics.areEqual(r30.rememberedValue(), Integer.valueOf(r26)) == true) goto L70;
    L64:
        r16.useNode();
        goto L65
    L56:
        if (Intrinsics.areEqual(r21.rememberedValue(), Integer.valueOf(r9)) == true) goto L58;
    L52:
        r16.useNode();
        goto L53
    L44:
        if (r5 != Composer.Companion.getEmpty()) goto L46;
    L36:
        r0 = false;
        goto L38
    L27:
        r3 = false;
        goto L29
    L20:
        if (r16.changed(r13) == false) goto L22;
        int r41 = 256;
    L23:
        r1 = r1 | r41;
        goto L24
    L22:
        r41 = 128;
        goto L23
    L5:
        if (r16.changedInstance(r11) == false) goto L7;
        int r42 = 4;
    L8:
        r1 = r42 | r15;
        goto L11
    L7:
        r42 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$NavigationRailItemBaselineLayout(Function2 r0, Function2 r1, float r2, Composer r3, int r4) {
        NavigationRailItemBaselineLayout(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: access$placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final /* synthetic */ MeasureResult m2109access$placeLabelAndIconDIyivk0(MeasureScope r0, Placeable r1, Placeable r2, long r3, float r5) {
        return m2111placeLabelAndIconDIyivk0(r0, r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    private static final MeasureResult m2111placeLabelAndIconDIyivk0(MeasureScope r14, final Placeable r15, final Placeable r16, long r17, final float r19) {
        int r1 = r15.get(AlignmentLineKt.getLastBaseline());
        final int r6 = (Constraints.getMaxHeight-impl(r17) - r1) - r14.roundToPx-0680j_4(ItemLabelBaselineBottomOffset);
        final int r5 = (Constraints.getMaxWidth-impl(r17) - r15.getWidth()) / 2;
        final int r10 = r14.roundToPx-0680j_4(ItemIconTopOffset);
        int r2 = (Constraints.getMaxHeight-impl(r17) - r16.getHeight()) / 2;
        final int r9 = (Constraints.getMaxWidth-impl(r17) - r16.getWidth()) / 2;
        final int r7 = MathKt.roundToInt((r2 - r10) * (1 - r19));
        return MeasureScope.-CC.layout$default(r14, Constraints.getMaxWidth-impl(r17), Constraints.getMaxHeight-impl(r17), null, new a7(r19, r15, r5, r6, r7, r16, r9, r10), 4, null);
    }

    /* JADX INFO: renamed from: NavigationRailTransition-Klgx-Pg, reason: not valid java name */
    private static final void m2107NavigationRailTransitionKlgxPg(final long r26, final long r28, final boolean r30, final Function3<? super Float, ? super Composer, ? super Integer, Unit> r31, Composer r32, final int r33) {
        Composer r15 = r32.startRestartGroup(140356545);
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
        r13.updateScope(new d7(r26, r28, r30, r31, r33));
        return;
    L51:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(140356545, r8, -1, "androidx.compose.material.NavigationRailTransition (NavigationRail.kt:285)");
    L40:
        if (r30 == false) goto L42;
        float r14 = 1.0f;
    L43:
        r0 = r15;
        final State<Float> r16 = AnimateAsStateKt.animateFloatAsState(r14, NavigationRailAnimationSpec, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, null, r15, 48, 28);
        long r17 = ColorKt.lerp-jxsXWHM(r28, r26, NavigationRailTransition_Klgx_Pg$lambda$5(r16));
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(Color.copy-wmQWz5c$default(r17, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(r17)))}, ComposableLambdaKt.rememberComposableLambda(1330097921, true, new NavigationRailKt$NavigationRailTransition$1(r31, r16), r0, 54), r0, ProvidedValue.$stable | 48);
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

    /* JADX INFO: renamed from: NavigationRail-HsRjFd4, reason: not valid java name */
    public static final void m2104NavigationRailHsRjFd4(Modifier r22, long r23, long r25, float r27, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r28, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(-2116369751);
        int r2 = r32 & 1;
        if (r2 == 0) goto L6;
        int r4 = r31 | 6;
        Modifier r3 = r22;
    L14:
        if ((r31 & 48) == 0) goto L16;
        long r5 = r23;
    L25:
        if ((r31 & 384) == 0) goto L27;
        long r7 = r25;
    L35:
        int r10 = r32 & 8;
        if (r10 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        float r11 = r27;
    L46:
        int r12 = r32 & 16;
        if (r12 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r13 = r28;
    L58:
        if ((r32 & 32) == 0) goto L61;
        r4 = r4 | 196608;
    L69:
        if ((74899 & r4) == 74898) goto L71;
        boolean r0 = true;
    L73:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L107;
        r1.startDefaults();
        if ((r31 & 1) != 0) goto L77;
    L87:
        if (r2 == 0) goto L89;
        Modifier r6 = Modifier.Companion;
    L91:
        if ((r32 & 2) == 0) goto L94;
        r4 = r4 & (-113);
        r5 = MaterialTheme.INSTANCE.getColors(r1, 6).m2003getSurface0d7_KjU();
    L94:
        if ((r32 & 4) == 0) goto L96;
        long r8 = ColorsKt.m2017contentColorForek8zF_U(r5, r1, (r4 >> 3) & 14);
        r4 = r4 & (-897);
        r7 = r8;
    L96:
        if (r10 == 0) goto L98;
        r11 = NavigationRailDefaults.INSTANCE.m2103getElevationD9Ej5fM();
    L98:
        if (r12 != 0) goto L99;
    L86:
        float r9 = r11;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r14 = r13;
    L100:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L103;
        ComposerKt.traceEventStart(-2116369751, r4, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:172)");
    L103:
        int r15 = r4 << 3;
        m2105NavigationRailafqeVBk(ZeroInsets, r6, r5, r7, r9, r14, r29, r1, ((((((r15 & 112) | 6) | (r15 & 896)) | (r15 & 7168)) | (57344 & r15)) | (458752 & r15)) | (r15 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventEnd();
    L106:
        r11 = r9;
        r13 = r14;
        r3 = r6;
    L108:
        ScopeUpdateScope r16 = r1.endRestartGroup();
        if (r16 == null) goto L112;
        final Modifier r17 = r3;
        final long r18 = r5;
        final long r19 = r7;
        final float r20 = r11;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r21 = r13;
        r16.updateScope(new c7(r17, r18, r19, r20, r21, r29, r31, r32));
        return;
    L112:
        return;
    L99:
        r14 = null;
        r9 = r11;
        goto L100
    L89:
        r6 = r3;
        goto L91
    L77:
        if (r1.getDefaultsInvalid() == true) goto L87;
        r1.skipToGroupEnd();
        if ((r32 & 2) == 0) goto L83;
        r4 = r4 & (-113);
    L83:
        if ((r32 & 4) == 0) goto L85;
        r4 = r4 & (-897);
    L85:
        r6 = r3;
        goto L86
    L107:
        r1.skipToGroupEnd();
        goto L108
    L71:
        r0 = false;
        goto L73
    L61:
        if ((r31 & 196608) != 0) goto L69;
        if (r1.changedInstance(r29) == false) goto L65;
        int r110 = 131072;
    L66:
        r4 = r4 | r110;
        goto L69
    L65:
        r110 = 65536;
        goto L66
    L50:
        if ((r31 & 24576) != 0) goto L56;
        r13 = r28;
        if (r1.changedInstance(r13) == false) goto L54;
        int r111 = 16384;
    L55:
        r4 = r4 | r111;
        goto L58
    L54:
        r111 = 8192;
        goto L55
    L39:
        if ((r31 & 3072) != 0) goto L45;
        r11 = r27;
        if (r1.changed(r11) == false) goto L43;
        int r112 = 2048;
    L44:
        r4 = r4 | r112;
        goto L46
    L43:
        r112 = 1024;
        goto L44
    L27:
        if ((r32 & 4) != 0) goto L31;
        r7 = r25;
        if (r1.changed(r7) == false) goto L32;
        int r113 = 256;
    L33:
        r4 = r4 | r113;
    L32:
        r113 = 128;
        goto L33
    L31:
        r7 = r25;
        goto L32
    L16:
        if ((r32 & 2) != 0) goto L20;
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
        if ((r31 & 6) != 0) goto L12;
        r3 = r22;
        if (r1.changed(r3) == false) goto L10;
        int r26 = 4;
    L11:
        r4 = r26 | r31;
        goto L14
    L10:
        r26 = 2;
        goto L11
    L12:
        r3 = r22;
        r4 = r31;
        goto L14
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

    /* JADX INFO: renamed from: NavigationRail-afqeVBk, reason: not valid java name */
    public static final void m2105NavigationRailafqeVBk(final WindowInsets r25, Modifier r26, long r27, long r29, float r31, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r32, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r33, Composer r34, final int r35, final int r36) {
        Composer r2 = r34.startRestartGroup(-171916405);
        if ((r36 & 1) == 0) goto L6;
        int r3 = r35 | 6;
    L13:
        int r4 = r36 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r35 & 384) != 0) goto L36;
        if ((r36 & 4) != 0) goto L32;
        if (r2.changed(r27) == false) goto L32;
        int r8 = 256;
    L33:
        r3 = r3 | r8;
    L32:
        r8 = 128;
    L36:
        if ((r35 & 3072) != 0) goto L44;
        long r11 = r29;
        if ((r36 & 8) == 0) goto L40;
    L42:
        int r9 = 1024;
    L43:
        r3 = r3 | r9;
    L45:
        int r10 = r36 & 16;
        if (r10 == 0) goto L49;
        r3 = r3 | 24576;
    L55:
        float r13 = r31;
    L56:
        int r14 = r36 & 32;
        if (r14 == 0) goto L60;
        r3 = r3 | 196608;
    L66:
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r15 = r32;
    L68:
        if ((r36 & 64) == 0) goto L71;
        r3 = r3 | 1572864;
    L78:
        if ((r3 & 599187) == 599186) goto L80;
        boolean r0 = true;
    L82:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L118;
        r2.startDefaults();
        if ((r35 & 1) != 0) goto L86;
    L95:
        if (r4 == 0) goto L97;
        Modifier r1 = Modifier.Companion;
    L99:
        if ((r36 & 4) == 0) goto L101;
        long r5 = MaterialTheme.INSTANCE.getColors(r2, 6).m2003getSurface0d7_KjU();
        r3 = r3 & (-897);
    L103:
        if ((r36 & 8) == 0) goto L105;
        r11 = ColorsKt.m2017contentColorForek8zF_U(r5, r2, (r3 >> 6) & 14);
        r3 = r3 & (-7169);
    L105:
        if (r10 == 0) goto L107;
        float r7 = NavigationRailDefaults.INSTANCE.m2103getElevationD9Ej5fM();
    L108:
        if (r14 == 0) goto L110;
        r15 = null;
    L110:
        long r23 = r11;
        int r12 = r3;
        float r6 = r7;
        long r16 = r23;
    L111:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventStart(-171916405, r12, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
    L114:
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r17 = r15;
        SurfaceKt.m2175SurfaceFjzlyU(r1, null, r5, r16, null, r6, ComposableLambdaKt.rememberComposableLambda(366031815, true, new NavigationRailKt$NavigationRail$1(r25, r15, r33), r2, 54), r2, (((((r12 >> 3) & 14) | 1572864) | (r12 & 896)) | (r12 & 7168)) | ((r12 << 3) & 458752), 18);
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventEnd();
    L117:
        r13 = r6;
        r15 = r17;
        Modifier r18 = r1;
    L119:
        ScopeUpdateScope r19 = r2.endRestartGroup();
        if (r19 == null) goto L123;
        final Modifier r20 = r18;
        final long r21 = r5;
        final long r22 = r16;
        final float r24 = r13;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r28 = r15;
        r19.updateScope(new b7(r25, r20, r21, r22, r24, r28, r33, r35, r36));
        return;
    L123:
        return;
    L107:
        r7 = r13;
        goto L108
    L101:
        r5 = r27;
        goto L103
    L97:
        r1 = r26;
        goto L99
    L86:
        if (r2.getDefaultsInvalid() == true) goto L95;
        r2.skipToGroupEnd();
        if ((r36 & 4) == 0) goto L92;
        r3 = r3 & (-897);
    L92:
        if ((r36 & 8) == 0) goto L94;
        r3 = r3 & (-7169);
    L94:
        r1 = r26;
        r5 = r27;
        r16 = r11;
        r12 = r3;
        r6 = r13;
        goto L111
    L118:
        r2.skipToGroupEnd();
        r18 = r26;
        r5 = r27;
        r16 = r11;
        goto L119
    L80:
        r0 = false;
        goto L82
    L71:
        if ((r35 & 1572864) != 0) goto L78;
        if (r2.changedInstance(r33) == false) goto L75;
        int r110 = 1048576;
    L76:
        r3 = r3 | r110;
        goto L78
    L75:
        r110 = 524288;
        goto L76
    L60:
        if ((196608 & r35) != 0) goto L66;
        r15 = r32;
        if (r2.changedInstance(r15) == false) goto L64;
        int r111 = 131072;
    L65:
        r3 = r3 | r111;
        goto L68
    L64:
        r111 = 65536;
        goto L65
    L49:
        if ((r35 & 24576) != 0) goto L55;
        r13 = r31;
        if (r2.changed(r13) == false) goto L53;
        int r112 = 16384;
    L54:
        r3 = r3 | r112;
        goto L56
    L53:
        r112 = 8192;
        goto L54
    L40:
        if (r2.changed(r11) == false) goto L42;
        r9 = 2048;
        goto L43
    L44:
        r11 = r29;
        goto L45
    L17:
        if ((r35 & 48) != 0) goto L25;
        if (r2.changed(r26) == false) goto L21;
        int r30 = 32;
    L22:
        r3 = r3 | r30;
        goto L25
    L21:
        r30 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r3 = r35;
        goto L13
    L8:
        if (r2.changed(r25) == false) goto L10;
        int r37 = 4;
    L11:
        r3 = r37 | r35;
        goto L13
    L10:
        r37 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: NavigationRailItem-0S3VyRs, reason: not valid java name */
    public static final void m2106NavigationRailItem0S3VyRs(final boolean r24, final Function0<Unit> r25, final Function2<? super Composer, ? super Integer, Unit> r26, Modifier r27, boolean r28, Function2<? super Composer, ? super Integer, Unit> r29, boolean r30, MutableInteractionSource r31, long r32, long r34, Composer r36, final int r37, final int r38) {
        Composer r1 = r36.startRestartGroup(83562179);
        if ((r38 & 1) == 0) goto L6;
        int r4 = r37 | 6;
    L14:
        if ((r38 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L25:
        if ((r38 & 4) == 0) goto L28;
        r4 = r4 | 384;
    L34:
        int r6 = r38 & 8;
        if (r6 == 0) goto L38;
        r4 = r4 | 3072;
    L44:
        Modifier r7 = r27;
    L45:
        int r8 = r38 & 16;
        if (r8 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        boolean r9 = r28;
    L56:
        int r10 = r38 & 32;
        if (r10 == 0) goto L60;
        r4 = r4 | 196608;
    L66:
        final Function2<? super Composer, ? super Integer, Unit> r11 = r29;
    L67:
        int r12 = r38 & 64;
        if (r12 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        final boolean r15 = r30;
    L78:
        int r0 = r38 & 128;
        if (r0 == 0) goto L82;
        r4 = r4 | 12582912;
    L89:
        if ((r37 & 100663296) != 0) goto L100;
        if ((r38 & 256) != 0) goto L96;
        if (r1.changed(r32) == false) goto L96;
        int r17 = 67108864;
    L97:
        r4 = r4 | r17;
    L96:
        r17 = 33554432;
    L100:
        if ((r37 & 805306368) != 0) goto L111;
        if ((r38 & 512) != 0) goto L107;
        if (r1.changed(r34) == false) goto L107;
        int r18 = 536870912;
    L108:
        r4 = r4 | r18;
    L107:
        r18 = 268435456;
    L111:
        if ((r4 & 306783379) == 306783378) goto L113;
        boolean r2 = true;
    L115:
        if (r1.shouldExecute(r2, r4 & 1) == false) goto L175;
        r1.startDefaults();
        Function2 r19 = null;
        if ((r37 & 1) != 0) goto L119;
    L128:
        if (r6 == 0) goto L130;
        Modifier r3 = Modifier.Companion;
    L131:
        if (r8 == 0) goto L133;
        r9 = true;
    L133:
        if (r10 == 0) goto L135;
        r11 = null;
    L135:
        if (r12 == 0) goto L137;
        r15 = true;
    L137:
        if (r0 == 0) goto L139;
        MutableInteractionSource r5 = null;
    L141:
        if ((r38 & 256) == 0) goto L143;
        long r13 = MaterialTheme.INSTANCE.getColors(r1, 6).m1999getPrimary0d7_KjU();
        r4 = r4 & (-234881025);
    L145:
        if ((r38 & 512) == 0) goto L147;
        long r110 = Color.copy-wmQWz5c$default(((Color) r1.consume(ContentColorKt.getLocalContentColor())).unbox-impl(), ContentAlpha.INSTANCE.getMedium(r1, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        r4 = r4 & (-1879048193);
    L148:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L152;
        ComposerKt.traceEventStart(83562179, r4, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
    L152:
        if (r11 != null) goto L154;
        r1.startReplaceGroup(-1679605042);
    L155:
        r1.endReplaceGroup();
        final Function2 r14 = r19;
        if (r11 != null) goto L158;
        float r16 = NavigationRailItemCompactSize;
    L159:
        Modifier r111 = SizeKt.m1014size3ABfNKs(SelectableKt.m1289selectableO2vRcR0(r3, r24, r5, RippleKt.m2139rippleH2RKhps$default(false, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r13, 2, null), r9, Role.box-impl(Role.Companion.getTab-o7Vup1c()), r25), r16);
        MeasurePolicy r112 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r20 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r21 = r1.getCurrentCompositionLocalMap();
        Modifier r113 = ComposedModifierKt.materializeModifier(r1, r111);
        ComposeUiNode.Companion r114 = ComposeUiNode.Companion;
        MutableInteractionSource r35 = r5;
        Function0 r22 = r114.getConstructor();
        Modifier r39 = r3;
        if ((r1.getApplier() instanceof Applier) == true) goto L162;
        ComposablesKt.invalidApplier();
    L162:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L165;
        r1.createNode(r22);
    L166:
        Composer r23 = Updater.constructor-impl(r1);
        Updater.set-impl(r23, r112, r114.getSetMeasurePolicy());
        Updater.set-impl(r23, r21, r114.getSetResolvedCompositionLocals());
        Function2 r33 = r114.getSetCompositeKeyHash();
        if (r23.getInserting() == false) goto L169;
    L170:
        r23.updateRememberedValue(Integer.valueOf(r20));
        r23.apply(Integer.valueOf(r20), r33);
    L171:
        Updater.set-impl(r23, r113, r114.getSetModifier());
        BoxScopeInstance r40 = BoxScopeInstance.INSTANCE;
        int r41 = r4 >> 24;
        long r210 = r13;
        long r211 = r110;
        m2107NavigationRailTransitionKlgxPg(r210, r211, r24, ComposableLambdaKt.rememberComposableLambda(317431928, true, new NavigationRailKt$NavigationRailItem$1$1(r15, r26, r14), r1, 54), r1, ((r41 & 112) | ((r41 & 14) | 3072)) | ((r4 << 6) & 896));
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L174;
        ComposerKt.traceEventEnd();
    L174:
        final MutableInteractionSource r42 = r35;
        final Modifier r43 = r39;
        final boolean r44 = r9;
        final long r45 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r46 = r11;
        final boolean r47 = r15;
        final long r115 = r110;
    L176:
        ScopeUpdateScope r116 = r1.endRestartGroup();
        if (r116 == null) goto L180;
        r116.updateScope(new y6(r24, r25, r26, r43, r44, r46, r47, r42, r45, r115, r37, r38));
        return;
    L180:
        return;
    L169:
        if (Intrinsics.areEqual(r23.rememberedValue(), Integer.valueOf(r20)) == true) goto L171;
    L165:
        r1.useNode();
        goto L166
    L158:
        r16 = NavigationRailItemSize;
        goto L159
    L154:
        r1.startReplaceGroup(-1679605041);
        r19 = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new NavigationRailKt$NavigationRailItem$styledLabel$1$1(r11), r1, 54);
        goto L155
    L147:
        r110 = r34;
        goto L148
    L143:
        r13 = r32;
        goto L145
    L139:
        r5 = r31;
        goto L141
    L130:
        r3 = r7;
        goto L131
    L119:
        if (r1.getDefaultsInvalid() == true) goto L128;
        r1.skipToGroupEnd();
        if ((r38 & 256) == 0) goto L125;
        r4 = r4 & (-234881025);
    L125:
        if ((r38 & 512) == 0) goto L127;
        r4 = r4 & (-1879048193);
    L127:
        r5 = r31;
        r110 = r34;
        r3 = r7;
        r13 = r32;
        goto L148
    L175:
        r1.skipToGroupEnd();
        r42 = r31;
        r43 = r7;
        r44 = r9;
        r46 = r11;
        r47 = r15;
        r45 = r32;
        r115 = r34;
        goto L176
    L113:
        r2 = false;
        goto L115
    L82:
        if ((r37 & 12582912) != 0) goto L89;
        if (r1.changed(r31) == false) goto L86;
        int r117 = 8388608;
    L87:
        r4 = r4 | r117;
        goto L89
    L86:
        r117 = 4194304;
        goto L87
    L71:
        if ((1572864 & r37) != 0) goto L77;
        r15 = r30;
        if (r1.changed(r15) == false) goto L75;
        int r118 = 1048576;
    L76:
        r4 = r4 | r118;
        goto L78
    L75:
        r118 = 524288;
        goto L76
    L60:
        if ((196608 & r37) != 0) goto L66;
        r11 = r29;
        if (r1.changedInstance(r11) == false) goto L64;
        int r119 = 131072;
    L65:
        r4 = r4 | r119;
        goto L67
    L64:
        r119 = 65536;
        goto L65
    L49:
        if ((r37 & 24576) != 0) goto L55;
        r9 = r28;
        if (r1.changed(r9) == false) goto L53;
        int r120 = 16384;
    L54:
        r4 = r4 | r120;
        goto L56
    L53:
        r120 = 8192;
        goto L54
    L38:
        if ((r37 & 3072) != 0) goto L44;
        r7 = r27;
        if (r1.changed(r7) == false) goto L42;
        int r48 = 2048;
    L43:
        r4 = r4 | r48;
        goto L45
    L42:
        r48 = 1024;
        goto L43
    L28:
        if ((r37 & 384) != 0) goto L34;
        if (r1.changedInstance(r26) == false) goto L32;
        int r49 = 256;
    L33:
        r4 = r4 | r49;
        goto L34
    L32:
        r49 = 128;
        goto L33
    L17:
        if ((r37 & 48) != 0) goto L25;
        if (r1.changedInstance(r25) == false) goto L21;
        int r50 = 32;
    L22:
        r4 = r4 | r50;
        goto L25
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r4 = r37;
        goto L14
    L8:
        if (r1.changed(r24) == false) goto L10;
        int r51 = 4;
    L11:
        r4 = r51 | r37;
        goto L14
    L10:
        r51 = 2;
        goto L11
    }
}
