package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.HorizontalRuler;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aS\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\n\u001aO\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\f\u0010%\u001a\u00020\b*\u00020\bH\u0000\"\u0016\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0017\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015\"\u0016\u0010\u0019\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015\"\u0016\u0010\u001b\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015\"\u0014\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"BadgedBox", "", "badge", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Badge", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "Landroidx/compose/foundation/layout/RowScope;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgeWithContentHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getBadgeWithContentHorizontalPadding", "()F", "F", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentVerticalOffset", "getBadgeWithContentVerticalOffset", "BadgeOffset", "getBadgeOffset", "BadgeTopRuler", "Landroidx/compose/ui/layout/HorizontalRuler;", "getBadgeTopRuler", "()Landroidx/compose/ui/layout/HorizontalRuler;", "BadgeEndRuler", "Landroidx/compose/ui/layout/VerticalRuler;", "getBadgeEndRuler", "()Landroidx/compose/ui/layout/VerticalRuler;", "badgeBounds", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BadgeKt {
    private static final VerticalRuler BadgeEndRuler = null;
    private static final float BadgeOffset = 0.0f;
    private static final HorizontalRuler BadgeTopRuler = null;
    private static final float BadgeWithContentHorizontalOffset = 0.0f;
    private static final float BadgeWithContentHorizontalPadding = 0.0f;
    private static final float BadgeWithContentVerticalOffset = 0.0f;

    static {
        BadgeWithContentHorizontalPadding = Dp.constructor-impl(4);
        BadgeWithContentHorizontalOffset = Dp.constructor-impl(12);
        BadgeWithContentVerticalOffset = Dp.constructor-impl(14);
        BadgeOffset = Dp.constructor-impl(6);
        BadgeTopRuler = new HorizontalRuler();
        BadgeEndRuler = new VerticalRuler();
    }

    private static final Unit Badge_eopBjH0$lambda$4(Modifier r10, long r11, long r13, Function3 r15, int r16, int r17, Composer r18, int r19) {
        m2328BadgeeopBjH0(r10, r11, r13, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit BadgedBox$lambda$2(Function3 r6, Modifier r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        BadgedBox(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(RulerScope r0) {
        return badgeBounds$lambda$7$lambda$5(r0);
    }

    public static /* synthetic */ Unit b(Placeable r0, Placeable.PlacementScope r1) {
        return badgeBounds$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ MeasureResult c(MeasureScope r0, Measurable r1, Constraints r2) {
        return badgeBounds$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(Modifier r0, long r1, long r3, Function3 r5, int r6, int r7, Composer r8, int r9) {
        return Badge_eopBjH0$lambda$4(r0, r1, r3, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit e(Function3 r0, Modifier r1, Function3 r2, int r3, int r4, Composer r5, int r6) {
        return BadgedBox$lambda$2(r0, r1, r2, r3, r4, r5, r6);
    }

    public static final VerticalRuler getBadgeEndRuler() {
        return BadgeEndRuler;
    }

    public static final float getBadgeOffset() {
        return BadgeOffset;
    }

    public static final HorizontalRuler getBadgeTopRuler() {
        return BadgeTopRuler;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentVerticalOffset() {
        return BadgeWithContentVerticalOffset;
    }

    public static final Modifier badgeBounds(Modifier r1) {
        return LayoutModifierKt.layout(r1, new l1());
    }

    private static final Unit badgeBounds$lambda$7$lambda$5(RulerScope r4) {
        r4.provides(BadgeEndRuler, (int) (r4.getCoordinates().getSize-YbymL2g() >> 32));
        r4.provides(BadgeTopRuler, MenuKt.ClosedAlphaTarget);
        return Unit.INSTANCE;
    }

    private static final Unit badgeBounds$lambda$7$lambda$6(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.place$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final MeasureResult badgeBounds$lambda$7(MeasureScope r8, Measurable r9, Constraints r10) {
        final Placeable r11 = r9.measure-BRTryo0(r10.unbox-impl());
        return MeasureScope.-CC.layout$default(r8, r11.getWidth(), r11.getHeight(), null, new i1(), new j1(r11), 4, null);
    }

    public static final void BadgedBox(final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> r16, Modifier r17, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> r18, Composer r19, final int r20, final int r21) {
        Composer r2 = r19.startRestartGroup(-1693825945);
        if ((r21 & 1) == 0) goto L6;
        int r5 = r20 | 6;
    L13:
        int r6 = r21 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L23:
        Modifier r7 = r17;
    L25:
        if ((r21 & 4) == 0) goto L28;
        r5 = r5 | 384;
    L35:
        if ((r5 & 147) == 146) goto L37;
        boolean r8 = true;
    L39:
        if (r2.shouldExecute(r8, r5 & 1) == false) goto L88;
        if (r6 == 0) goto L42;
        Modifier r9 = Modifier.Companion;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(-1693825945, r5, -1, "androidx.compose.material3.BadgedBox (Badge.kt:67)");
    L46:
        Object r0 = r2.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L49;
        r0 = BadgeKt$BadgedBox$1$1.INSTANCE;
        r2.updateRememberedValue(r0);
    L49:
        MeasurePolicy r1 = (MeasurePolicy) r0;
        int r10 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r11 = r2.getCurrentCompositionLocalMap();
        Modifier r12 = ComposedModifierKt.materializeModifier(r2, r9);
        ComposeUiNode.Companion r13 = ComposeUiNode.Companion;
        Function0 r14 = r13.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L52;
        ComposablesKt.invalidApplier();
    L52:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L55;
        r2.createNode(r14);
    L56:
        Composer r15 = Updater.constructor-impl(r2);
        Updater.set-impl(r15, r1, r13.getSetMeasurePolicy());
        Updater.set-impl(r15, r11, r13.getSetResolvedCompositionLocals());
        Function2 r3 = r13.getSetCompositeKeyHash();
        if (r15.getInserting() == false) goto L59;
    L60:
        r15.updateRememberedValue(Integer.valueOf(r10));
        r15.apply(Integer.valueOf(r10), r3);
    L61:
        Updater.set-impl(r15, r12, r13.getSetModifier());
        Modifier.Companion r4 = Modifier.Companion;
        Modifier r22 = LayoutIdKt.layoutId(r4, "anchor");
        Alignment.Companion r23 = Alignment.Companion;
        int r110 = ((r5 << 3) & 7168) | 54;
        MeasurePolicy r24 = BoxKt.maybeCachedBoxMeasurePolicy(r23.getCenter(), false);
        int r111 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r112 = r2.getCurrentCompositionLocalMap();
        Modifier r25 = ComposedModifierKt.materializeModifier(r2, r22);
        Function0 r113 = r13.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L64;
        ComposablesKt.invalidApplier();
    L64:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L67;
        r2.createNode(r113);
    L68:
        Composer r114 = Updater.constructor-impl(r2);
        Updater.set-impl(r114, r24, r13.getSetMeasurePolicy());
        Updater.set-impl(r114, r112, r13.getSetResolvedCompositionLocals());
        Function2 r26 = r13.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L71;
    L72:
        r114.updateRememberedValue(Integer.valueOf(r111));
        r114.apply(Integer.valueOf(r111), r26);
    L73:
        Updater.set-impl(r114, r25, r13.getSetModifier());
        BoxScopeInstance r27 = BoxScopeInstance.INSTANCE;
        r18.invoke(r27, r2, Integer.valueOf(((r110 >> 6) & 112) | 6));
        r2.endNode();
        Modifier r28 = LayoutIdKt.layoutId(r4, "badge");
        int r29 = ((r5 << 9) & 7168) | 6;
        MeasurePolicy r30 = BoxKt.maybeCachedBoxMeasurePolicy(r23.getTopStart(), false);
        int r31 = ComposablesKt.getCurrentCompositeKeyHash(r2, 0);
        CompositionLocalMap r115 = r2.getCurrentCompositionLocalMap();
        Modifier r32 = ComposedModifierKt.materializeModifier(r2, r28);
        Function0 r116 = r13.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L76;
        ComposablesKt.invalidApplier();
    L76:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L79;
        r2.createNode(r116);
    L80:
        Composer r117 = Updater.constructor-impl(r2);
        Updater.set-impl(r117, r30, r13.getSetMeasurePolicy());
        Updater.set-impl(r117, r115, r13.getSetResolvedCompositionLocals());
        Function2 r33 = r13.getSetCompositeKeyHash();
        if (r117.getInserting() == false) goto L83;
    L84:
        r117.updateRememberedValue(Integer.valueOf(r31));
        r117.apply(Integer.valueOf(r31), r33);
    L85:
        Updater.set-impl(r117, r32, r13.getSetModifier());
        r16.invoke(r27, r2, Integer.valueOf(((r29 >> 6) & 112) | 6));
        r2.endNode();
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventEnd();
    L89:
        ScopeUpdateScope r34 = r2.endRestartGroup();
        if (r34 == null) goto L93;
        final Modifier r35 = r9;
        r34.updateScope(new m1(r16, r35, r18, r20, r21));
        return;
    L93:
        return;
    L83:
        if (Intrinsics.areEqual(r117.rememberedValue(), Integer.valueOf(r31)) == true) goto L85;
    L79:
        r2.useNode();
        goto L80
    L71:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r111)) == true) goto L73;
    L67:
        r2.useNode();
        goto L68
    L59:
        if (Intrinsics.areEqual(r15.rememberedValue(), Integer.valueOf(r10)) == true) goto L61;
    L55:
        r2.useNode();
        goto L56
    L42:
        r9 = r7;
        goto L44
    L88:
        r2.skipToGroupEnd();
        r9 = r7;
        goto L89
    L37:
        r8 = false;
        goto L39
    L28:
        if ((r20 & 384) != 0) goto L35;
        if (r2.changedInstance(r18) == false) goto L32;
        int r36 = 256;
    L33:
        r5 = r5 | r36;
        goto L35
    L32:
        r36 = 128;
        goto L33
    L17:
        if ((r20 & 48) != 0) goto L23;
        r7 = r17;
        if (r2.changed(r7) == false) goto L21;
        int r37 = 32;
    L22:
        r5 = r5 | r37;
        goto L25
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r20 & 6) == 0) goto L8;
        r5 = r20;
        goto L13
    L8:
        if (r2.changedInstance(r16) == false) goto L10;
        int r38 = 4;
    L11:
        r5 = r38 | r20;
        goto L13
    L10:
        r38 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Badge-eopBjH0, reason: not valid java name */
    public static final void m2328BadgeeopBjH0(Modifier r16, long r17, long r19, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r21, Composer r22, final int r23, final int r24) {
        Composer r1 = r22.startRestartGroup(1428256508);
        int r2 = r24 & 1;
        if (r2 == 0) goto L6;
        int r5 = r23 | 6;
        Modifier r4 = r16;
    L14:
        if ((r23 & 48) != 0) goto L22;
        long r8 = r17;
        if ((r24 & 2) == 0) goto L18;
    L20:
        int r6 = 16;
    L21:
        r5 = r5 | r6;
    L24:
        if ((r23 & 384) != 0) goto L32;
        long r10 = r19;
        if ((r24 & 4) == 0) goto L28;
    L30:
        int r7 = 128;
    L31:
        r5 = r5 | r7;
    L33:
        int r9 = r24 & 8;
        if (r9 == 0) goto L37;
        r5 = r5 | 3072;
    L43:
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r12 = r21;
    L45:
        if ((r5 & 1171) == 1170) goto L47;
        boolean r13 = true;
    L49:
        if (r1.shouldExecute(r13, r5 & 1) == false) goto L106;
        r1.startDefaults();
        if ((r23 & 1) != 0) goto L53;
    L62:
        if (r2 == 0) goto L64;
        Modifier r3 = Modifier.Companion;
    L66:
        if ((r24 & 2) == 0) goto L69;
        r8 = BadgeDefaults.INSTANCE.getContainerColor(r1, 6);
        r5 = r5 & (-113);
    L69:
        if ((r24 & 4) == 0) goto L71;
        r10 = ColorSchemeKt.m2496contentColorForek8zF_U(r8, r1, (r5 >> 3) & 14);
        r5 = r5 & (-897);
    L71:
        if (r9 == 0) goto L73;
        r12 = null;
    L73:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventStart(1428256508, r5, -1, "androidx.compose.material3.Badge (Badge.kt:155)");
    L76:
        BadgeTokens r0 = BadgeTokens.INSTANCE;
        if (r12 == null) goto L79;
        float r11 = r0.getLargeSize-D9Ej5fM();
    L80:
        if (r12 == null) goto L82;
        r1.startReplaceGroup(-1051012910);
        Shape r14 = ShapesKt.getValue(BadgeTokens.INSTANCE.getLargeShape(), r1, 6);
        r1.endReplaceGroup();
    L83:
        Modifier r15 = BackgroundKt.m341backgroundbw27NRU(SizeKt.m998defaultMinSizeVpY3zN4(r3, r11, r11), r8, r14);
        if (r12 == null) goto L86;
        Modifier r18 = PaddingKt.m962paddingVpY3zN4$default(Modifier.Companion, BadgeWithContentHorizontalPadding, MenuKt.ClosedAlphaTarget, 2, null);
    L87:
        Modifier r20 = r15.then(r18);
        MeasurePolicy r25 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getCenterVertically(), r1, 54);
        int r26 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r110 = r1.getCurrentCompositionLocalMap();
        Modifier r27 = ComposedModifierKt.materializeModifier(r1, r20);
        ComposeUiNode.Companion r111 = ComposeUiNode.Companion;
        Function0 r28 = r111.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L90;
        ComposablesKt.invalidApplier();
    L90:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L93;
        r1.createNode(r28);
    L94:
        Composer r29 = Updater.constructor-impl(r1);
        Updater.set-impl(r29, r25, r111.getSetMeasurePolicy());
        Updater.set-impl(r29, r110, r111.getSetResolvedCompositionLocals());
        Function2 r30 = r111.getSetCompositeKeyHash();
        if (r29.getInserting() == false) goto L97;
    L98:
        r29.updateRememberedValue(Integer.valueOf(r26));
        r29.apply(Integer.valueOf(r26), r30);
    L99:
        Updater.set-impl(r29, r27, r111.getSetModifier());
        final RowScopeInstance r31 = RowScopeInstance.INSTANCE;
        if (r12 == null) goto L102;
        r1.startReplaceGroup(1345815094);
        ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(r10, TypographyKt.getValue(BadgeTokens.INSTANCE.getLargeLabelTextFont(), r1, 6), ComposableLambdaKt.rememberComposableLambda(541712501, true, new BadgeKt$Badge$1$1(r12, r31), r1, 54), r1, ((r5 >> 6) & 14) | 384);
        r1.endReplaceGroup();
    L103:
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L107;
        ComposerKt.traceEventEnd();
    L107:
        final long r32 = r10;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r33 = r12;
        ScopeUpdateScope r112 = r1.endRestartGroup();
        if (r112 == null) goto L111;
        final Modifier r34 = r3;
        final long r35 = r8;
        r112.updateScope(new k1(r34, r35, r32, r33, r23, r24));
        return;
    L111:
        return;
    L102:
        r1.startReplaceGroup(1346141834);
        r1.endReplaceGroup();
        goto L103
    L97:
        if (Intrinsics.areEqual(r29.rememberedValue(), Integer.valueOf(r26)) == true) goto L99;
    L93:
        r1.useNode();
        goto L94
    L86:
        r18 = Modifier.Companion;
        goto L87
    L82:
        r1.startReplaceGroup(-1050955529);
        r14 = ShapesKt.getValue(BadgeTokens.INSTANCE.getShape(), r1, 6);
        r1.endReplaceGroup();
        goto L83
    L79:
        r11 = r0.getSize-D9Ej5fM();
        goto L80
    L64:
        r3 = r4;
        goto L66
    L53:
        if (r1.getDefaultsInvalid() == true) goto L62;
        r1.skipToGroupEnd();
        if ((r24 & 2) == 0) goto L59;
        r5 = r5 & (-113);
    L59:
        if ((r24 & 4) == 0) goto L61;
        r5 = r5 & (-897);
    L61:
        r3 = r4;
        goto L73
    L106:
        r1.skipToGroupEnd();
        r3 = r4;
        goto L107
    L47:
        r13 = false;
        goto L49
    L37:
        if ((r23 & 3072) != 0) goto L43;
        r12 = r21;
        if (r1.changedInstance(r12) == false) goto L41;
        int r113 = 2048;
    L42:
        r5 = r5 | r113;
        goto L45
    L41:
        r113 = 1024;
        goto L42
    L28:
        if (r1.changed(r10) == false) goto L30;
        r7 = 256;
        goto L31
    L32:
        r10 = r19;
        goto L33
    L18:
        if (r1.changed(r8) == false) goto L20;
        r6 = 32;
        goto L21
    L22:
        r8 = r17;
        goto L24
    L6:
        if ((r23 & 6) != 0) goto L12;
        r4 = r16;
        if (r1.changed(r4) == false) goto L10;
        int r36 = 4;
    L11:
        r5 = r36 | r23;
        goto L14
    L10:
        r36 = 2;
        goto L11
    L12:
        r4 = r16;
        r5 = r23;
        goto L14
    }
}
