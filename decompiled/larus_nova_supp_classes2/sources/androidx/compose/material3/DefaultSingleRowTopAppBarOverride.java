package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/DefaultSingleRowTopAppBarOverride;", "Landroidx/compose/material3/SingleRowTopAppBarOverride;", "<init>", "()V", "SingleRowTopAppBar", "", "Landroidx/compose/material3/SingleRowTopAppBarOverrideScope;", "(Landroidx/compose/material3/SingleRowTopAppBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "targetColor", "Landroidx/compose/ui/graphics/Color;"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultSingleRowTopAppBarOverride implements SingleRowTopAppBarOverride {
    public static final int $stable = 0;
    public static final DefaultSingleRowTopAppBarOverride INSTANCE = null;

    static {
        INSTANCE = new DefaultSingleRowTopAppBarOverride();
    }

    private DefaultSingleRowTopAppBarOverride() {
    }

    private static final float SingleRowTopAppBar$lambda$15$lambda$14$lambda$13() {
        return 1.0f;
    }

    private static final Unit SingleRowTopAppBar$lambda$16(DefaultSingleRowTopAppBarOverride r0, SingleRowTopAppBarOverrideScope r1, int r2, Composer r3, int r4) {
        r0.SingleRowTopAppBar(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ float a(SingleRowTopAppBarOverrideScope r0) {
        return SingleRowTopAppBar$lambda$15$lambda$12$lambda$11(r0);
    }

    public static /* synthetic */ Unit b(SingleRowTopAppBarOverrideScope r0, float r1) {
        return SingleRowTopAppBar$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ float c() {
        return SingleRowTopAppBar$lambda$15$lambda$14$lambda$13();
    }

    public static /* synthetic */ Unit d(State r0, DrawScope r1) {
        return SingleRowTopAppBar$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit e(SemanticsPropertyReceiver r0) {
        return SingleRowTopAppBar$lambda$9$lambda$8(r0);
    }

    public static /* synthetic */ Unit f(DefaultSingleRowTopAppBarOverride r0, SingleRowTopAppBarOverrideScope r1, int r2, Composer r3, int r4) {
        return SingleRowTopAppBar$lambda$16(r0, r1, r2, r3, r4);
    }

    private static final float SingleRowTopAppBar$lambda$15$lambda$12$lambda$11(SingleRowTopAppBarOverrideScope r0) {
        TopAppBarScrollBehavior r1 = r0.getScrollBehavior();
        if (r1 == null) goto L7;
        TopAppBarState r2 = r1.getState();
        if (r2 == null) goto L7;
        return r2.getHeightOffset();
    L7:
        return MenuKt.ClosedAlphaTarget;
    }

    private static final long SingleRowTopAppBar$lambda$2(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    private static final Unit SingleRowTopAppBar$lambda$9$lambda$8(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setTraversalGroup(r1, true);
        return Unit.INSTANCE;
    }

    private static final Unit SingleRowTopAppBar$lambda$4$lambda$3(SingleRowTopAppBarOverrideScope r1, float r2) {
        TopAppBarState r3 = r1.getScrollBehavior().getState();
        r3.setHeightOffset(r3.getHeightOffset() + r2);
        return Unit.INSTANCE;
    }

    private static final Unit SingleRowTopAppBar$lambda$7$lambda$6(State r13, DrawScope r14) {
        long r1 = ((Color) r13.getValue()).unbox-impl();
        if (Color.equals-impl0(r1, Color.Companion.getUnspecified-0d7_KjU()) == true) goto L6;
        DrawScope.-CC.drawRect-n-J9OG0$default(r14, r1, 0, 0, MenuKt.ClosedAlphaTarget, null, null, 0, 126, null);
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.SingleRowTopAppBarOverride
    public void SingleRowTopAppBar(final SingleRowTopAppBarOverrideScope r36, Composer r37, final int r38) {
        Composer r15 = r37.startRestartGroup(2137486921);
        if ((r38 & 6) == 0) goto L5;
        int r12 = r38;
    L10:
        boolean r13 = true;
        if ((r12 & 3) == 2) goto L13;
        boolean r3 = true;
    L15:
        if (r15.shouldExecute(r3, r12 & 1) == true) goto L17;
        Composer r2 = r15;
        r2.skipToGroupEnd();
    L99:
        ScopeUpdateScope r4 = r2.endRestartGroup();
        if (r4 == null) goto L103;
        r4.updateScope(new t8(this, r36, r38));
        return;
    L103:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventStart(2137486921, r12, -1, "androidx.compose.material3.DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar (AppBar.kt:2510)");
    L20:
        if ((!Float.isNaN(r36.m3135getExpandedHeightD9Ej5fM())) == true) goto L22;
    L27:
        boolean r5 = false;
    L28:
        if (r5 == false) goto L97;
        boolean r6 = r15.changed(r36.getColors()) | r15.changed(r36.getScrollBehavior());
        Object r7 = r15.rememberedValue();
        if (r6 == false) goto L32;
    L33:
        r7 = SnapshotStateKt.derivedStateOf(new DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$targetColor$2$1(r36));
        r15.updateRememberedValue(r7);
    L34:
        final State<Color> r8 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(SingleRowTopAppBar$lambda$2((State) r7), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r15, 6), null, null, r15, 0, 12);
        ComposableLambda r23 = ComposableLambdaKt.rememberComposableLambda(-1658896622, true, new DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$actionsRow$1(r36), r15, 54);
        if (r36.getScrollBehavior() != null) goto L37;
    L57:
        r15.startReplaceGroup(690108113);
        r15.endReplaceGroup();
        Modifier r9 = Modifier.Companion;
    L58:
        Modifier r10 = r36.getModifier().then(r9);
        boolean r11 = r15.changed(r8);
        Object r14 = r15.rememberedValue();
        if (r11 == false) goto L61;
    L62:
        r14 = new p8(r8);
        r15.updateRememberedValue(r14);
    L63:
        Modifier r16 = DrawModifierKt.drawBehind(r10, (Function1) r14);
        Object r17 = r15.rememberedValue();
        Composer.Companion r18 = Composer.Companion;
        if (r17 != r18.getEmpty()) goto L66;
        r17 = new q8();
        r15.updateRememberedValue(r17);
    L66:
        Modifier r19 = SemanticsModifierKt.semantics$default(r16, false, (Function1) r17, 1, null);
        Unit r20 = Unit.INSTANCE;
        Object r21 = r15.rememberedValue();
        if (r21 != r18.getEmpty()) goto L69;
        r21 = DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$4$1.INSTANCE;
        r15.updateRememberedValue(r21);
    L69:
        Modifier r22 = SuspendingPointerInputFilterKt.pointerInput(r19, r20, (PointerInputEventHandler) r21);
        MeasurePolicy r24 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r25 = ComposablesKt.getCurrentCompositeKeyHash(r15, 0);
        CompositionLocalMap r26 = r15.getCurrentCompositionLocalMap();
        Modifier r27 = ComposedModifierKt.materializeModifier(r15, r22);
        ComposeUiNode.Companion r28 = ComposeUiNode.Companion;
        Function0 r29 = r28.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L72;
        ComposablesKt.invalidApplier();
    L72:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L75;
        r15.createNode(r29);
    L76:
        Composer r30 = Updater.constructor-impl(r15);
        Updater.set-impl(r30, r24, r28.getSetMeasurePolicy());
        Updater.set-impl(r30, r26, r28.getSetResolvedCompositionLocals());
        Function2 r31 = r28.getSetCompositeKeyHash();
        if (r30.getInserting() == false) goto L79;
    L80:
        r30.updateRememberedValue(Integer.valueOf(r25));
        r30.apply(Integer.valueOf(r25), r31);
    L81:
        Updater.set-impl(r30, r27, r28.getSetModifier());
        BoxScopeInstance r32 = BoxScopeInstance.INSTANCE;
        Modifier r33 = AppBarKt.access$adjustHeightOffsetLimit(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.Companion, r36.getWindowInsets())), r36.getScrollBehavior());
        if ((r12 & 14) == 4) goto L85;
        r13 = false;
    L85:
        Object r34 = r15.rememberedValue();
        if (r13 == false) goto L88;
    L89:
        r34 = new r8(r36);
        r15.updateRememberedValue(r34);
    L90:
        FloatProducer r35 = (FloatProducer) r34;
        long r39 = r36.getColors().m3573getNavigationIconContentColor0d7_KjU();
        long r40 = r36.getColors().m3576getTitleContentColor0d7_KjU();
        long r110 = r36.getColors().m3571getActionIconContentColor0d7_KjU();
        long r111 = r36.getColors().m3575getSubtitleContentColor0d7_KjU();
        Function2<Composer, Integer, Unit> r41 = r36.getTitle();
        TextStyle r112 = r36.getTitleTextStyle();
        Function2<Composer, Integer, Unit> r113 = r36.getSubtitle();
        TextStyle r114 = r36.getSubtitleTextStyle();
        Arrangement.HorizontalOrVertical r210 = Arrangement.INSTANCE.getCenter();
        Alignment.Horizontal r211 = r36.getTitleHorizontalAlignment();
        Function2<Composer, Integer, Unit> r212 = r36.getNavigationIcon();
        float r213 = r36.m3135getExpandedHeightD9Ej5fM();
        Object r115 = r15.rememberedValue();
        if (r115 != r18.getEmpty()) goto L93;
        r115 = new s8();
        r15.updateRememberedValue(r115);
    L93:
        r2 = r15;
        AppBarKt.m2319access$TopAppBarLayoutlyUyIHI(r33, r35, r39, r40, r111, r110, r41, r112, r113, r114, (Function0) r115, r210, r211, 0, false, r212, r23, r213, r2, 0, 1600566);
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventEnd();
        goto L99
    L88:
        if (r34 != r18.getEmpty()) goto L90;
    L79:
        if (Intrinsics.areEqual(r30.rememberedValue(), Integer.valueOf(r25)) == true) goto L81;
    L75:
        r15.useNode();
        goto L76
    L61:
        if (r14 != Composer.Companion.getEmpty()) goto L63;
    L37:
        if (r36.getScrollBehavior().isPinned() == true) goto L57;
        r15.startReplaceGroup(689467622);
        Modifier.Companion r214 = Modifier.Companion;
        Orientation r215 = Orientation.Vertical;
        int r42 = r12 & 14;
        if (r42 != 4) goto L41;
        boolean r43 = true;
    L42:
        Object r44 = r15.rememberedValue();
        if (r43 == false) goto L45;
    L46:
        r44 = new o8(r36);
        r15.updateRememberedValue(r44);
    L47:
        DraggableState r216 = DraggableKt.rememberDraggableState((Function1) r44, r15, 0);
        if (r42 != 4) goto L50;
        boolean r45 = true;
    L51:
        Object r46 = r15.rememberedValue();
        if (r45 == false) goto L54;
    L55:
        r46 = new DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$appBarDragModifier$2$1(r36, null);
        r15.updateRememberedValue(r46);
    L56:
        r9 = DraggableKt.draggable$default(r214, r216, r215, false, null, false, null, (Function3) r46, false, 188, null);
        r15.endReplaceGroup();
        goto L58
    L54:
        if (r46 != Composer.Companion.getEmpty()) goto L56;
    L50:
        r45 = false;
        goto L51
    L45:
        if (r44 != Composer.Companion.getEmpty()) goto L47;
    L41:
        r43 = false;
        goto L42
    L32:
        if (r7 != Composer.Companion.getEmpty()) goto L34;
    L97:
        throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
    L22:
        if ((Float.floatToRawIntBits(r36.m3135getExpandedHeightD9Ej5fM()) & Integer.MAX_VALUE) >= 2139095040) goto L24;
        boolean r47 = true;
    L25:
        if (r47 == false) goto L27;
        r5 = true;
        goto L28
    L24:
        r47 = false;
        goto L25
    L13:
        r3 = false;
        goto L15
    L5:
        if (r15.changed(r36) == false) goto L7;
        int r48 = 4;
    L8:
        r12 = r48 | r38;
        goto L10
    L7:
        r48 = 2;
        goto L8
    }
}
