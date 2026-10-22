package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/DefaultModalWideNavigationRailOverride;", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "<init>", "()V", "ModalWideNavigationRail", "", "Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;", "(Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "isCollapsed", "", "modalExpanded"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultModalWideNavigationRailOverride implements ModalWideNavigationRailOverride {
    public static final int $stable = 0;
    public static final DefaultModalWideNavigationRailOverride INSTANCE = null;

    static {
        INSTANCE = new DefaultModalWideNavigationRailOverride();
    }

    private DefaultModalWideNavigationRailOverride() {
    }

    private static final Unit ModalWideNavigationRail$lambda$23(DefaultModalWideNavigationRailOverride r0, ModalWideNavigationRailOverrideScope r1, int r2, Composer r3, int r4) {
        r0.ModalWideNavigationRail(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(DefaultModalWideNavigationRailOverride r0, ModalWideNavigationRailOverrideScope r1, int r2, Composer r3, int r4) {
        return ModalWideNavigationRail$lambda$23(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit b(CoroutineScope r0, Animatable r1, float r2) {
        return ModalWideNavigationRail$lambda$20$lambda$19(r0, r1, r2);
    }

    public static /* synthetic */ Unit c(CoroutineScope r0, ModalWideNavigationRailOverrideScope r1) {
        return ModalWideNavigationRail$lambda$18$lambda$17(r0, r1);
    }

    public static /* synthetic */ boolean d(State r0) {
        return ModalWideNavigationRail$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit e(Channel r0, ModalWideNavigationRailOverrideScope r1) {
        return ModalWideNavigationRail$lambda$16$lambda$15(r0, r1);
    }

    public static /* synthetic */ boolean f(State r0) {
        return ModalWideNavigationRail$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ Unit g(CoroutineScope r0, Animatable r1) {
        return ModalWideNavigationRail$lambda$22$lambda$21(r0, r1);
    }

    private static final boolean ModalWideNavigationRail$lambda$3$lambda$2(State r1) {
        if (((Number) r1.getValue()).floatValue() != MenuKt.ClosedAlphaTarget) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean ModalWideNavigationRail$lambda$4(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final boolean ModalWideNavigationRail$lambda$6$lambda$5(State r1) {
        if (((Number) r1.getValue()).floatValue() < 0.3f) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean ModalWideNavigationRail$lambda$7(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    public static final /* synthetic */ boolean access$ModalWideNavigationRail$lambda$7(State r0) {
        return ModalWideNavigationRail$lambda$7(r0);
    }

    private static final Unit ModalWideNavigationRail$lambda$16$lambda$15(Channel r0, ModalWideNavigationRailOverrideScope r1) {
        r0.trySend-JP2dKIU(Boolean.valueOf(WideNavigationRailStateKt.isExpanded(r1.getState().getTargetValue())));
        return Unit.INSTANCE;
    }

    private static final Unit ModalWideNavigationRail$lambda$18$lambda$17(CoroutineScope r6, ModalWideNavigationRailOverrideScope r7) {
        BuildersKt.launch$default(r6, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$4$1$1(r7, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final Unit ModalWideNavigationRail$lambda$22$lambda$21(CoroutineScope r6, Animatable r7) {
        BuildersKt.launch$default(r6, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$6$1$1(r7, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final Unit ModalWideNavigationRail$lambda$20$lambda$19(CoroutineScope r6, Animatable r7, float r8) {
        BuildersKt.launch$default(r6, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$5$1$1(r7, r8, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [boolean, int] */
    @Override // androidx.compose.material3.ModalWideNavigationRailOverride
    public void ModalWideNavigationRail(final ModalWideNavigationRailOverrideScope r26, Composer r27, final int r28) {
        Composer r15 = r27.startRestartGroup(1751235721);
        if ((r28 & 6) == 0) goto L5;
        int r12 = r28;
    L14:
        if ((r12 & 3) == 2) goto L16;
        boolean r1 = true;
    L18:
        if (r15.shouldExecute(r1, r12 & 1) == true) goto L20;
        Composer r13 = r15;
        r13.skipToGroupEnd();
    L161:
        ScopeUpdateScope r0 = r13.endRestartGroup();
        if (r0 == null) goto L165;
        r0.updateScope(new j8(this, r26, r28));
        return;
    L165:
        return;
    L20:
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventStart(1751235721, r12, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail (WideNavigationRail.kt:503)");
    L23:
        if (r26.getShouldHideOnCollapse() == false) goto L25;
        r15.startReplaceGroup(95781714);
        r15.endReplaceGroup();
        Function2<Composer, Integer, Unit> r22 = r26.getContent();
    L31:
        Density r2 = (Density) r15.consume(CompositionLocalsKt.getLocalDensity());
        FiniteAnimationSpec r3 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r15, 6);
        boolean r4 = r15.changed(r26.getState());
        Object r5 = r15.rememberedValue();
        if (r4 == false) goto L34;
    L35:
        r5 = new ModalWideNavigationRailState(r26.getState(), r2, r3);
        r15.updateRememberedValue(r5);
    L36:
        final ModalWideNavigationRailState r6 = (ModalWideNavigationRailState) r5;
        if (WideNavigationRailStateKt.isExpanded(r26.getState().getTargetValue()) == true) goto L39;
        float r7 = MenuKt.ClosedAlphaTarget;
    L40:
        final State<Float> r8 = AnimateAsStateKt.animateFloatAsState(r7, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r15, 6), MenuKt.ClosedAlphaTarget, null, null, r15, 0, 28);
        Object r9 = r15.rememberedValue();
        Composer.Companion r10 = Composer.Companion;
        if (r9 != r10.getEmpty()) goto L43;
        r9 = SnapshotStateKt.derivedStateOf(new d8(r8));
        r15.updateRememberedValue(r9);
    L43:
        State r11 = (State) r9;
        Object r14 = r15.rememberedValue();
        if (r14 != r10.getEmpty()) goto L46;
        r14 = SnapshotStateKt.derivedStateOf(new e8(r8));
        r15.updateRememberedValue(r14);
    L46:
        final State r16 = (State) r14;
        int r17 = r12 & 14;
        if (r17 != 4) goto L49;
    L54:
        boolean r18 = true;
    L55:
        boolean r19 = r18 | r15.changedInstance(r6);
        Object r20 = r15.rememberedValue();
        if (r19 == false) goto L58;
    L59:
        r20 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1(r26, r6, null);
        r15.updateRememberedValue(r20);
    L60:
        final Function1 r21 = (Function1) r20;
        if (r17 != 4) goto L63;
    L68:
        boolean r23 = true;
    L69:
        boolean r24 = r23 | r15.changedInstance(r6);
        Object r25 = r15.rememberedValue();
        if (r24 == false) goto L72;
    L73:
        r25 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1(r26, r6, null);
        r15.updateRememberedValue(r25);
    L74:
        final Function2 r29 = (Function2) r25;
        if (r26.getShouldHideOnCollapse() == false) goto L77;
    L79:
        r13 = r15;
        r13.startReplaceGroup(97788313);
        r13.endReplaceGroup();
    L80:
        Object r110 = r13.rememberedValue();
        if (r110 != r10.getEmpty()) goto L83;
        r110 = ChannelKt.Channel$default(-1, null, null, 6, null);
        r13.updateRememberedValue(r110);
    L83:
        final Channel r111 = (Channel) r110;
        if (r26.getShouldHideOnCollapse() == false) goto L91;
        r13.startReplaceGroup(97908438);
        boolean r112 = r13.changedInstance(r111) | r13.changedInstance(r6);
        Object r113 = r13.rememberedValue();
        if (r112 == false) goto L88;
    L89:
        r113 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1(r111, r6, null);
        r13.updateRememberedValue(r113);
    L90:
        ?? r114 = 0;
        EffectsKt.LaunchedEffect(r111, (Function2) r113, r13, 0);
        r13.endReplaceGroup();
    L93:
        if (ModalWideNavigationRail$lambda$4(r11) == true) goto L156;
        r13.startReplaceGroup(98512256);
        if (r26.getShouldHideOnCollapse() == true) goto L109;
        r13.startReplaceGroup(98472731);
        Modifier r30 = BackgroundKt.m341backgroundbw27NRU(Modifier.Companion, r26.getColors().m3608getContainerColor0d7_KjU(), r26.getCollapsedShape());
        MeasurePolicy r31 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), r114);
        int r115 = ComposablesKt.getCurrentCompositeKeyHash(r13, r114);
        CompositionLocalMap r116 = r13.getCurrentCompositionLocalMap();
        Modifier r32 = ComposedModifierKt.materializeModifier(r13, r30);
        ComposeUiNode.Companion r117 = ComposeUiNode.Companion;
        Function0 r118 = r117.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L99;
        ComposablesKt.invalidApplier();
    L99:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L102;
        r13.createNode(r118);
    L103:
        Composer r33 = Updater.constructor-impl(r13);
        Updater.set-impl(r33, r31, r117.getSetMeasurePolicy());
        Updater.set-impl(r33, r116, r117.getSetResolvedCompositionLocals());
        Function2 r34 = r117.getSetCompositeKeyHash();
        if (r33.getInserting() == false) goto L106;
    L107:
        r33.updateRememberedValue(Integer.valueOf(r115));
        r33.apply(Integer.valueOf(r115), r34);
    L108:
        Updater.set-impl(r33, r32, r117.getSetModifier());
        BoxScopeInstance r35 = BoxScopeInstance.INSTANCE;
        Modifier r36 = r26.getModifier();
        float r37 = WideNavigationRailKt.access$getCollapsedRailWidth$p();
        int r38 = 2;
        float r119 = MenuKt.ClosedAlphaTarget;
        SpacerKt.Spacer(SizeKt.fillMaxHeight$default(SizeKt.m1021widthInVpY3zN4$default(r36, r37, MenuKt.ClosedAlphaTarget, 2, null), MenuKt.ClosedAlphaTarget, 1, null), r13, 0);
        r13.endNode();
        r13.endReplaceGroup();
    L110:
        Object r39 = r13.rememberedValue();
        if (r39 != r10.getEmpty()) goto L113;
        r39 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r13);
        r13.updateRememberedValue(r39);
    L113:
        final CoroutineScope r40 = (CoroutineScope) r39;
        Object r41 = r13.rememberedValue();
        if (r41 != r10.getEmpty()) goto L116;
        r41 = AnimatableKt.Animatable$default(r119, r119, r38, null);
        r13.updateRememberedValue(r41);
    L116:
        final Animatable r42 = (Animatable) r41;
        Object r43 = r13.rememberedValue();
        if (r43 != r10.getEmpty()) goto L119;
        r43 = new RailPredictiveBackState();
        r13.updateRememberedValue(r43);
    L119:
        final RailPredictiveBackState r120 = (RailPredictiveBackState) r43;
        boolean r44 = r13.changedInstance(r111);
        if (r17 != 4) goto L122;
    L127:
        boolean r121 = true;
    L128:
        boolean r45 = r44 | r121;
        Object r122 = r13.rememberedValue();
        if (r45 == false) goto L131;
    L132:
        r122 = new f8(r111, r26);
        r13.updateRememberedValue(r122);
    L133:
        boolean r46 = false;
        EffectsKt.SideEffect((Function0) r122, r13, 0);
        ModalWideNavigationRailProperties r123 = r26.getExpandedProperties();
        boolean r124 = r13.changedInstance(r40);
        if (r17 != 4) goto L136;
    L139:
        r46 = true;
    L140:
        boolean r47 = r124 | r46;
        Object r48 = r13.rememberedValue();
        if (r47 == false) goto L143;
    L144:
        r48 = new g8(r40, r26);
        r13.updateRememberedValue(r48);
    L145:
        Function0 r125 = (Function0) r48;
        boolean r49 = r13.changedInstance(r40) | r13.changedInstance(r42);
        Object r50 = r13.rememberedValue();
        if (r49 == false) goto L148;
    L149:
        r50 = new h8(r40, r42);
        r13.updateRememberedValue(r50);
    L150:
        Function1 r126 = (Function1) r50;
        boolean r51 = r13.changedInstance(r40) | r13.changedInstance(r42);
        Object r52 = r13.rememberedValue();
        if (r51 == false) goto L153;
    L154:
        r52 = new i8(r40, r42);
        r13.updateRememberedValue(r52);
    L155:
        final Function2<Composer, Integer, Unit> r53 = r22;
        WideNavigationRail_androidKt.ModalWideNavigationRailDialog(r125, r123, r126, (Function0) r52, r120, ComposableLambdaKt.rememberComposableLambda(1345045690, true, new AnonymousClass7(r26, r6, r21, r42, r120, r29, r53, r16), r13, 54), r13, 221184);
        r13.endReplaceGroup();
    L158:
        if (ComposerKt.isTraceInProgress() == false) goto L161;
        ComposerKt.traceEventEnd();
        goto L161
    L153:
        if (r52 != r10.getEmpty()) goto L155;
    L148:
        if (r50 != r10.getEmpty()) goto L150;
    L143:
        if (r48 != r10.getEmpty()) goto L145;
    L136:
        if ((r12 & 8) == 0) goto L140;
        if (r13.changedInstance(r26) == false) goto L140;
    L131:
        if (r122 != r10.getEmpty()) goto L133;
    L122:
        if ((r12 & 8) != 0) goto L124;
    L126:
        r121 = false;
        goto L128
    L124:
        if (r13.changedInstance(r26) == false) goto L126;
    L106:
        if (Intrinsics.areEqual(r33.rememberedValue(), Integer.valueOf(r115)) == true) goto L108;
    L102:
        r13.useNode();
        goto L103
    L109:
        r38 = 2;
        r119 = MenuKt.ClosedAlphaTarget;
        r13.startReplaceGroup(98809081);
        r13.endReplaceGroup();
        goto L110
    L156:
        r13.startReplaceGroup(101334713);
        r13.endReplaceGroup();
        goto L158
    L88:
        if (r113 != r10.getEmpty()) goto L90;
    L91:
        r114 = 0;
        r13.startReplaceGroup(98341849);
        r13.endReplaceGroup();
        goto L93
    L77:
        if (ModalWideNavigationRail$lambda$4(r11) == false) goto L79;
        r15.startReplaceGroup(97400069);
        WideNavigationRailKt.access$WideNavigationRailLayout(r26.getModifier(), false, false, r26.getColors(), r26.getCollapsedShape(), r26.getHeader(), r26.getWindowInsets(), r26.getArrangement(), r22, r15, 432);
        r15.endReplaceGroup();
        r13 = r15;
        goto L80
    L72:
        if (r25 != r10.getEmpty()) goto L74;
    L63:
        if ((r12 & 8) != 0) goto L65;
    L67:
        r23 = false;
        goto L69
    L65:
        if (r15.changedInstance(r26) == false) goto L67;
    L58:
        if (r20 != r10.getEmpty()) goto L60;
    L49:
        if ((r12 & 8) != 0) goto L51;
    L53:
        r18 = false;
        goto L55
    L51:
        if (r15.changedInstance(r26) == false) goto L53;
    L39:
        r7 = 1.0f;
        goto L40
    L34:
        if (r5 != Composer.Companion.getEmpty()) goto L36;
    L25:
        r15.startReplaceGroup(95826602);
        boolean r54 = r15.changed(r26.getContent());
        Object r55 = r15.rememberedValue();
        if (r54 == false) goto L28;
    L29:
        r55 = MovableContentKt.movableContentOf(r26.getContent());
        r15.updateRememberedValue(r55);
    L30:
        r15.endReplaceGroup();
        r22 = (Function2) r55;
        goto L31
    L28:
        if (r55 != Composer.Companion.getEmpty()) goto L30;
    L16:
        r1 = false;
        goto L18
    L5:
        if ((r28 & 8) != 0) goto L7;
        boolean r56 = r15.changed(r26);
    L8:
        if (r56 == false) goto L10;
        int r57 = 4;
    L11:
        r12 = r57 | r28;
        goto L14
    L10:
        r57 = 2;
        goto L11
    L7:
        r56 = r15.changedInstance(r26);
        goto L8
    }
}
