package androidx.compose.material3;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.FloatProducer;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/DefaultTwoRowsTopAppBarOverride;", "Landroidx/compose/material3/TwoRowsTopAppBarOverride;", "<init>", "()V", "TwoRowsTopAppBar", "", "Landroidx/compose/material3/TwoRowsTopAppBarOverrideScope;", "(Landroidx/compose/material3/TwoRowsTopAppBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "hideTopRowSemantics", ""}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultTwoRowsTopAppBarOverride implements TwoRowsTopAppBarOverride {
    public static final int $stable = 0;
    public static final DefaultTwoRowsTopAppBarOverride INSTANCE = null;

    static {
        INSTANCE = new DefaultTwoRowsTopAppBarOverride();
    }

    private DefaultTwoRowsTopAppBarOverride() {
    }

    private static final float TwoRowsTopAppBar$lambda$27$lambda$26$lambda$23$lambda$22() {
        return MenuKt.ClosedAlphaTarget;
    }

    private static final Unit TwoRowsTopAppBar$lambda$28(DefaultTwoRowsTopAppBarOverride r0, TwoRowsTopAppBarOverrideScope r1, int r2, Composer r3, int r4) {
        r0.TwoRowsTopAppBar(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ float a() {
        return TwoRowsTopAppBar$lambda$27$lambda$26$lambda$23$lambda$22();
    }

    public static /* synthetic */ float b(TwoRowsTopAppBarOverrideScope r0) {
        return TwoRowsTopAppBar$lambda$27$lambda$26$lambda$25$lambda$24(r0);
    }

    public static /* synthetic */ Unit c(DefaultTwoRowsTopAppBarOverride r0, TwoRowsTopAppBarOverrideScope r1, int r2, Composer r3, int r4) {
        return TwoRowsTopAppBar$lambda$28(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit d(SemanticsPropertyReceiver r0) {
        return TwoRowsTopAppBar$lambda$20$lambda$19(r0);
    }

    public static /* synthetic */ float e(Function0 r0) {
        return TwoRowsTopAppBar$lambda$10$lambda$9(r0);
    }

    public static /* synthetic */ boolean f(Function0 r0) {
        return TwoRowsTopAppBar$lambda$12$lambda$11(r0);
    }

    public static /* synthetic */ float g(Function0 r0) {
        return TwoRowsTopAppBar$lambda$8$lambda$7(r0);
    }

    public static /* synthetic */ Unit h(TwoRowsTopAppBarOverrideScope r0, float r1) {
        return TwoRowsTopAppBar$lambda$15$lambda$14(r0, r1);
    }

    public static /* synthetic */ float i(TwoRowsTopAppBarOverrideScope r0) {
        return TwoRowsTopAppBar$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ Unit j(Function0 r0, DrawScope r1) {
        return TwoRowsTopAppBar$lambda$18$lambda$17(r0, r1);
    }

    private static final float TwoRowsTopAppBar$lambda$10$lambda$9(Function0 r1) {
        return 1.0f - ((Number) r1.invoke()).floatValue();
    }

    private static final boolean TwoRowsTopAppBar$lambda$12$lambda$11(Function0 r1) {
        if (((Number) r1.invoke()).floatValue() >= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean TwoRowsTopAppBar$lambda$13(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final Unit TwoRowsTopAppBar$lambda$20$lambda$19(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setTraversalGroup(r1, true);
        return Unit.INSTANCE;
    }

    private static final float TwoRowsTopAppBar$lambda$27$lambda$26$lambda$25$lambda$24(TwoRowsTopAppBarOverrideScope r0) {
        TopAppBarScrollBehavior r1 = r0.getScrollBehavior();
        if (r1 == null) goto L7;
        TopAppBarState r2 = r1.getState();
        if (r2 == null) goto L7;
        return r2.getHeightOffset();
    L7:
        return MenuKt.ClosedAlphaTarget;
    }

    private static final float TwoRowsTopAppBar$lambda$5$lambda$4(TwoRowsTopAppBarOverrideScope r0) {
        TopAppBarScrollBehavior r1 = r0.getScrollBehavior();
        if (r1 == null) goto L7;
        TopAppBarState r2 = r1.getState();
        if (r2 == null) goto L7;
        return r2.getCollapsedFraction();
    L7:
        return MenuKt.ClosedAlphaTarget;
    }

    private static final float TwoRowsTopAppBar$lambda$8$lambda$7(Function0 r1) {
        return AppBarKt.getTopTitleAlphaEasing().transform(((Number) r1.invoke()).floatValue());
    }

    private static final Unit TwoRowsTopAppBar$lambda$15$lambda$14(TwoRowsTopAppBarOverrideScope r1, float r2) {
        TopAppBarState r3 = r1.getScrollBehavior().getState();
        r3.setHeightOffset(r3.getHeightOffset() + r2);
        return Unit.INSTANCE;
    }

    private static final Unit TwoRowsTopAppBar$lambda$18$lambda$17(Function0 r13, DrawScope r14) {
        DrawScope.-CC.drawRect-n-J9OG0$default(r14, ((Color) r13.invoke()).unbox-impl(), 0, 0, MenuKt.ClosedAlphaTarget, null, null, 0, 126, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.TwoRowsTopAppBarOverride
    public void TwoRowsTopAppBar(final TwoRowsTopAppBarOverrideScope r42, Composer r43, final int r44) {
        Composer r3 = r43.startRestartGroup(-1640665680);
        if ((r44 & 6) == 0) goto L5;
        int r4 = r44;
    L11:
        if ((r4 & 3) == 2) goto L13;
        boolean r5 = true;
    L15:
        if (r3.shouldExecute(r5, r4 & 1) == true) goto L17;
        final TwoRowsTopAppBarOverrideScope r1 = r42;
        Composer r2 = r3;
        r2.skipToGroupEnd();
    L160:
        ScopeUpdateScope r0 = r2.endRestartGroup();
        if (r0 == null) goto L164;
        r0.updateScope(new d9(this, r1, r44));
        return;
    L164:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventStart(-1640665680, r4, -1, "androidx.compose.material3.DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar (AppBar.kt:2732)");
    L20:
        if ((!Float.isNaN(r42.m3599getCollapsedHeightD9Ej5fM())) == true) goto L22;
    L27:
        boolean r6 = false;
    L28:
        if (r6 == false) goto L158;
        if ((!Float.isNaN(r42.m3600getExpandedHeightD9Ej5fM())) == true) goto L32;
    L37:
        boolean r7 = false;
    L38:
        if (r7 == false) goto L156;
        if (Dp.compareTo-0680j_4(r42.m3600getExpandedHeightD9Ej5fM(), r42.m3599getCollapsedHeightD9Ej5fM()) < 0) goto L42;
        boolean r8 = true;
    L43:
        if (r8 == false) goto L154;
        int r9 = ((Density) r3.consume(CompositionLocalsKt.getLocalDensity())).roundToPx-0680j_4(r42.m3601getTitleBottomPaddingD9Ej5fM());
        int r10 = r4 & 14;
        if (r10 != 4) goto L47;
        boolean r11 = true;
    L48:
        Object r12 = r3.rememberedValue();
        if (r11 == false) goto L51;
    L52:
        r12 = new u8(r42);
        r3.updateRememberedValue(r12);
    L53:
        final Function0 r13 = (Function0) r12;
        if (r10 != 4) goto L56;
        boolean r14 = true;
    L57:
        boolean r15 = r14 | r3.changed(r13);
        Object r16 = r3.rememberedValue();
        if (r15 == false) goto L60;
    L61:
        r16 = new DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarContainerColor$1$1(r42, r13);
        r3.updateRememberedValue(r16);
    L62:
        final Function0 r17 = (Function0) r16;
        ComposableLambda r23 = ComposableLambdaKt.rememberComposableLambda(-1333673671, true, new DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$actionsRow$1(r42), r3, 54);
        boolean r18 = r3.changed(r13);
        Object r19 = r3.rememberedValue();
        if (r18 == false) goto L65;
    L66:
        r19 = new v8(r13);
        r3.updateRememberedValue(r19);
    L67:
        Function0 r110 = (Function0) r19;
        boolean r20 = r3.changed(r13);
        Object r21 = r3.rememberedValue();
        if (r20 == false) goto L70;
    L71:
        r21 = new w8(r13);
        r3.updateRememberedValue(r21);
    L72:
        Function0 r28 = (Function0) r21;
        boolean r22 = r3.changed(r13);
        Object r24 = r3.rememberedValue();
        if (r22 == false) goto L75;
    L76:
        r24 = SnapshotStateKt.derivedStateOf(new x8(r13));
        r3.updateRememberedValue(r24);
    L77:
        State r25 = (State) r24;
        boolean r29 = !TwoRowsTopAppBar$lambda$13(r25);
        if (r42.getScrollBehavior() != null) goto L80;
    L100:
        r3.startReplaceGroup(-340499894);
        r3.endReplaceGroup();
        Modifier r26 = Modifier.Companion;
    L101:
        Modifier r27 = r42.getModifier().then(r26);
        boolean r30 = r3.changed(r17);
        Object r31 = r3.rememberedValue();
        if (r30 == false) goto L104;
    L105:
        r31 = new z8(r17);
        r3.updateRememberedValue(r31);
    L106:
        Modifier r32 = DrawModifierKt.drawBehind(r27, (Function1) r31);
        Object r33 = r3.rememberedValue();
        Composer.Companion r34 = Composer.Companion;
        if (r33 != r34.getEmpty()) goto L109;
        r33 = new a9();
        r3.updateRememberedValue(r33);
    L109:
        Modifier r35 = SemanticsModifierKt.semantics$default(r32, false, (Function1) r33, 1, null);
        Unit r36 = Unit.INSTANCE;
        Object r37 = r3.rememberedValue();
        if (r37 != r34.getEmpty()) goto L112;
        r37 = DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1.INSTANCE;
        r3.updateRememberedValue(r37);
    L112:
        Modifier r38 = SuspendingPointerInputFilterKt.pointerInput(r35, r36, (PointerInputEventHandler) r37);
        Alignment.Companion r39 = Alignment.Companion;
        MeasurePolicy r40 = BoxKt.maybeCachedBoxMeasurePolicy(r39.getTopStart(), false);
        int r41 = ComposablesKt.getCurrentCompositeKeyHash(r3, 0);
        CompositionLocalMap r45 = r3.getCurrentCompositionLocalMap();
        Modifier r46 = ComposedModifierKt.materializeModifier(r3, r38);
        ComposeUiNode.Companion r111 = ComposeUiNode.Companion;
        Function0 r112 = r111.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L115;
        ComposablesKt.invalidApplier();
    L115:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L118;
        r3.createNode(r112);
    L119:
        Composer r113 = Updater.constructor-impl(r3);
        Updater.set-impl(r113, r40, r111.getSetMeasurePolicy());
        Updater.set-impl(r113, r45, r111.getSetResolvedCompositionLocals());
        Function2 r47 = r111.getSetCompositeKeyHash();
        if (r113.getInserting() == false) goto L122;
    L123:
        r113.updateRememberedValue(Integer.valueOf(r41));
        r113.apply(Integer.valueOf(r41), r47);
    L124:
        Updater.set-impl(r113, r46, r111.getSetModifier());
        BoxScopeInstance r48 = BoxScopeInstance.INSTANCE;
        Modifier.Companion r114 = Modifier.Companion;
        Arrangement r310 = Arrangement.INSTANCE;
        MeasurePolicy r49 = ColumnKt.columnMeasurePolicy(r310.getTop(), r39.getStart(), r3, 0);
        int r50 = ComposablesKt.getCurrentCompositeKeyHash(r3, 0);
        CompositionLocalMap r51 = r3.getCurrentCompositionLocalMap();
        Modifier r52 = ComposedModifierKt.materializeModifier(r3, r114);
        Function0 r53 = r111.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L127;
        ComposablesKt.invalidApplier();
    L127:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L130;
        r3.createNode(r53);
    L131:
        Composer r54 = Updater.constructor-impl(r3);
        Updater.set-impl(r54, r49, r111.getSetMeasurePolicy());
        Updater.set-impl(r54, r51, r111.getSetResolvedCompositionLocals());
        Function2 r55 = r111.getSetCompositeKeyHash();
        if (r54.getInserting() == false) goto L134;
    L135:
        r54.updateRememberedValue(Integer.valueOf(r50));
        r54.apply(Integer.valueOf(r50), r55);
    L136:
        Updater.set-impl(r54, r52, r111.getSetModifier());
        ColumnScopeInstance r56 = ColumnScopeInstance.INSTANCE;
        Modifier r210 = ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(r114, r42.getWindowInsets()));
        Object r57 = r3.rememberedValue();
        if (r57 != r34.getEmpty()) goto L139;
        r57 = new b9();
        r3.updateRememberedValue(r57);
    L139:
        AppBarKt.m2319access$TopAppBarLayoutlyUyIHI(r210, (FloatProducer) r57, r42.getColors().m3573getNavigationIconContentColor0d7_KjU(), r42.getColors().m3576getTitleContentColor0d7_KjU(), r42.getColors().m3575getSubtitleContentColor0d7_KjU(), r42.getColors().m3571getActionIconContentColor0d7_KjU(), r42.getSmallTitle(), r42.getSmallTitleTextStyle(), r42.getSmallSubtitle(), r42.getSmallSubtitleTextStyle(), r110, r310.getCenter(), r42.getTitleHorizontalAlignment(), 0, TwoRowsTopAppBar$lambda$13(r25), r42.getNavigationIcon(), r23, r42.m3599getCollapsedHeightD9Ej5fM(), r3, 0, 1575984);
        Modifier r58 = AppBarKt.access$adjustHeightOffsetLimit(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(r114, WindowInsetsKt.m1046onlybOOhFvg(r42.getWindowInsets(), WindowInsetsSides.Companion.m1070getHorizontalJoeWqyM()))), r42.getScrollBehavior());
        if (r10 != 4) goto L142;
        boolean r115 = true;
    L143:
        Object r59 = r3.rememberedValue();
        if (r115 == false) goto L146;
    L149:
        r1 = r42;
        r59 = new c9(r1);
        r2 = r3;
        r2.updateRememberedValue(r59);
    L150:
        FloatProducer r60 = (FloatProducer) r59;
        long r61 = r42.getColors().m3573getNavigationIconContentColor0d7_KjU();
        long r62 = r42.getColors().m3576getTitleContentColor0d7_KjU();
        long r116 = r42.getColors().m3571getActionIconContentColor0d7_KjU();
        long r63 = r42.getColors().m3575getSubtitleContentColor0d7_KjU();
        Function2<Composer, Integer, Unit> r117 = r42.getTitle();
        TextStyle r118 = r42.getTitleTextStyle();
        Function2<Composer, Integer, Unit> r119 = r42.getSubtitle();
        TextStyle r120 = r42.getSubtitleTextStyle();
        Arrangement.Vertical r121 = r310.getBottom();
        Alignment.Horizontal r122 = r42.getTitleHorizontalAlignment();
        float r211 = Dp.constructor-impl(r42.m3600getExpandedHeightD9Ej5fM() - r42.m3599getCollapsedHeightD9Ej5fM());
        ComposableSingletons$AppBarKt r64 = ComposableSingletons$AppBarKt.INSTANCE;
        AppBarKt.m2319access$TopAppBarLayoutlyUyIHI(r58, r60, r61, r62, r63, r116, r117, r118, r119, r120, r28, r121, r122, r9, r29, r64.m2520getLambda$2101264077$material3(), r64.getLambda$37575796$material3(), r211, r2, 0, 1769520);
        r2.endNode();
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L160;
        ComposerKt.traceEventEnd();
        goto L160
    L146:
        if (r59 == r34.getEmpty()) goto L149;
        r1 = r42;
        r2 = r3;
        goto L150
    L142:
        r115 = false;
        goto L143
    L134:
        if (Intrinsics.areEqual(r54.rememberedValue(), Integer.valueOf(r50)) == true) goto L136;
    L130:
        r3.useNode();
        goto L131
    L122:
        if (Intrinsics.areEqual(r113.rememberedValue(), Integer.valueOf(r41)) == true) goto L124;
    L118:
        r3.useNode();
        goto L119
    L104:
        if (r31 != Composer.Companion.getEmpty()) goto L106;
    L80:
        if (r42.getScrollBehavior().isPinned() == true) goto L100;
        r3.startReplaceGroup(-341140385);
        Modifier.Companion r311 = Modifier.Companion;
        Orientation r312 = Orientation.Vertical;
        if (r10 != 4) goto L84;
        boolean r65 = true;
    L85:
        Object r66 = r3.rememberedValue();
        if (r65 == false) goto L88;
    L89:
        r66 = new y8(r42);
        r3.updateRememberedValue(r66);
    L90:
        DraggableState r313 = DraggableKt.rememberDraggableState((Function1) r66, r3, 0);
        if (r10 != 4) goto L93;
        boolean r67 = true;
    L94:
        Object r68 = r3.rememberedValue();
        if (r67 == false) goto L97;
    L98:
        r68 = new DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1(r42, null);
        r3.updateRememberedValue(r68);
    L99:
        r26 = DraggableKt.draggable$default(r311, r313, r312, false, null, false, null, (Function3) r68, false, 188, null);
        r3.endReplaceGroup();
        goto L101
    L97:
        if (r68 != Composer.Companion.getEmpty()) goto L99;
    L93:
        r67 = false;
        goto L94
    L88:
        if (r66 != Composer.Companion.getEmpty()) goto L90;
    L84:
        r65 = false;
        goto L85
    L75:
        if (r24 != Composer.Companion.getEmpty()) goto L77;
    L70:
        if (r21 != Composer.Companion.getEmpty()) goto L72;
    L65:
        if (r19 != Composer.Companion.getEmpty()) goto L67;
    L60:
        if (r16 != Composer.Companion.getEmpty()) goto L62;
    L56:
        r14 = false;
        goto L57
    L51:
        if (r12 != Composer.Companion.getEmpty()) goto L53;
    L47:
        r11 = false;
        goto L48
    L154:
        throw new IllegalArgumentException("The expandedHeight is expected to be greater or equal to the collapsedHeight".toString());
    L42:
        r8 = false;
        goto L43
    L156:
        throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
    L32:
        if ((Float.floatToRawIntBits(r42.m3600getExpandedHeightD9Ej5fM()) & Integer.MAX_VALUE) >= 2139095040) goto L34;
        boolean r69 = true;
    L35:
        if (r69 == false) goto L37;
        r7 = true;
        goto L38
    L34:
        r69 = false;
        goto L35
    L158:
        throw new IllegalArgumentException("The collapsedHeight is expected to be specified and finite".toString());
    L22:
        if ((Float.floatToRawIntBits(r42.m3599getCollapsedHeightD9Ej5fM()) & Integer.MAX_VALUE) >= 2139095040) goto L24;
        boolean r70 = true;
    L25:
        if (r70 == false) goto L27;
        r6 = true;
        goto L28
    L24:
        r70 = false;
        goto L25
    L13:
        r5 = false;
        goto L15
    L5:
        if (r3.changed(r42) == false) goto L7;
        int r71 = 4;
    L8:
        r4 = r71 | r44;
        goto L11
    L7:
        r71 = 2;
        goto L8
    }
}
