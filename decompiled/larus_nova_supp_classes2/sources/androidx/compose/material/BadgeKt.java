package androidx.compose.material;

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
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001aS\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\n\u001aO\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0017\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015\"\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b\"\u0016\u0010\u001c\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015\"\u0016\u0010\u001e\u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001f\u0010\u0015\"\u0016\u0010 \u001a\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0015¨\u0006\""}, d2 = {"BadgedBox", "", "badge", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Badge", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "Landroidx/compose/foundation/layout/RowScope;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgeRadius", "Landroidx/compose/ui/unit/Dp;", "getBadgeRadius", "()F", "F", "BadgeWithContentRadius", "getBadgeWithContentRadius", "BadgeContentFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "BadgeWithContentHorizontalPadding", "getBadgeWithContentHorizontalPadding", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeHorizontalOffset", "getBadgeHorizontalOffset", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BadgeKt {
    private static final long BadgeContentFontSize = 0;
    private static final float BadgeHorizontalOffset = 0.0f;
    private static final float BadgeRadius = 0.0f;
    private static final float BadgeWithContentHorizontalOffset = 0.0f;
    private static final float BadgeWithContentHorizontalPadding = 0.0f;
    private static final float BadgeWithContentRadius = 0.0f;

    static {
        float r0 = 4;
        BadgeRadius = Dp.constructor-impl(r0);
        BadgeWithContentRadius = Dp.constructor-impl(8);
        BadgeContentFontSize = TextUnitKt.getSp(10);
        BadgeWithContentHorizontalPadding = Dp.constructor-impl(r0);
        BadgeWithContentHorizontalOffset = Dp.constructor-impl(-Dp.constructor-impl(6));
        BadgeHorizontalOffset = Dp.constructor-impl(-Dp.constructor-impl(r0));
    }

    private static final Unit Badge_eopBjH0$lambda$4(Modifier r10, long r11, long r13, Function3 r15, int r16, int r17, Composer r18, int r19) {
        m1942BadgeeopBjH0(r10, r11, r13, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit BadgedBox$lambda$2(Function3 r6, Modifier r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        BadgedBox(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function3 r0, Modifier r1, Function3 r2, int r3, int r4, Composer r5, int r6) {
        return BadgedBox$lambda$2(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit b(Modifier r0, long r1, long r3, Function3 r5, int r6, int r7, Composer r8, int r9) {
        return Badge_eopBjH0$lambda$4(r0, r1, r3, r5, r6, r7, r8, r9);
    }

    public static final /* synthetic */ long access$getBadgeContentFontSize$p() {
        return BadgeContentFontSize;
    }

    public static final float getBadgeHorizontalOffset() {
        return BadgeHorizontalOffset;
    }

    public static final float getBadgeRadius() {
        return BadgeRadius;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentRadius() {
        return BadgeWithContentRadius;
    }

    public static final void BadgedBox(final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> r16, Modifier r17, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> r18, Composer r19, final int r20, final int r21) {
        Composer r2 = r19.startRestartGroup(898422008);
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
        ComposerKt.traceEventStart(898422008, r5, -1, "androidx.compose.material.BadgedBox (Badge.kt:61)");
    L46:
        Object r0 = r2.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L49;
        r0 = BadgeKt$BadgedBox$2$1.INSTANCE;
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
        r34.updateScope(new i1(r16, r35, r18, r20, r21));
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
    public static final void m1942BadgeeopBjH0(Modifier r16, long r17, long r19, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r21, Composer r22, final int r23, final int r24) {
        Composer r1 = r22.startRestartGroup(-1356170301);
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
        if (r1.shouldExecute(r13, r5 & 1) == false) goto L98;
        r1.startDefaults();
        if ((r23 & 1) != 0) goto L53;
    L62:
        if (r2 == 0) goto L64;
        Modifier r3 = Modifier.Companion;
    L66:
        if ((r24 & 2) == 0) goto L69;
        r8 = MaterialTheme.INSTANCE.getColors(r1, 6).m1993getError0d7_KjU();
        r5 = r5 & (-113);
    L69:
        if ((r24 & 4) == 0) goto L71;
        r10 = ColorsKt.m2017contentColorForek8zF_U(r8, r1, (r5 >> 3) & 14);
        r5 = r5 & (-897);
    L71:
        if (r9 == 0) goto L73;
        r12 = null;
    L73:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventStart(-1356170301, r5, -1, "androidx.compose.material.Badge (Badge.kt:129)");
    L76:
        if (r12 == null) goto L78;
        float r0 = BadgeWithContentRadius;
    L79:
        RoundedCornerShape r11 = RoundedCornerShapeKt.m1334RoundedCornerShape0680j_4(r0);
        float r14 = r0 * 2;
        Modifier r15 = PaddingKt.m962paddingVpY3zN4$default(ClipKt.clip(BackgroundKt.m341backgroundbw27NRU(SizeKt.m998defaultMinSizeVpY3zN4(r3, Dp.constructor-impl(r14), Dp.constructor-impl(r14)), r8, r11), r11), BadgeWithContentHorizontalPadding, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        MeasurePolicy r18 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getCenterVertically(), r1, 54);
        int r20 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r25 = r1.getCurrentCompositionLocalMap();
        Modifier r26 = ComposedModifierKt.materializeModifier(r1, r15);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r111 = r110.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L82;
        ComposablesKt.invalidApplier();
    L82:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L85;
        r1.createNode(r111);
    L86:
        Composer r27 = Updater.constructor-impl(r1);
        Updater.set-impl(r27, r18, r110.getSetMeasurePolicy());
        Updater.set-impl(r27, r25, r110.getSetResolvedCompositionLocals());
        Function2 r28 = r110.getSetCompositeKeyHash();
        if (r27.getInserting() == false) goto L89;
    L90:
        r27.updateRememberedValue(Integer.valueOf(r20));
        r27.apply(Integer.valueOf(r20), r28);
    L91:
        Updater.set-impl(r27, r26, r110.getSetModifier());
        final RowScopeInstance r29 = RowScopeInstance.INSTANCE;
        if (r12 == null) goto L94;
        r1.startReplaceGroup(749640967);
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(r10)), ComposableLambdaKt.rememberComposableLambda(1185347010, true, new BadgeKt$Badge$1$1(r12, r29), r1, 54), r1, ProvidedValue.$stable | 48);
        r1.endReplaceGroup();
    L95:
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventEnd();
    L99:
        final long r30 = r10;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r31 = r12;
        ScopeUpdateScope r112 = r1.endRestartGroup();
        if (r112 == null) goto L103;
        final Modifier r32 = r3;
        final long r33 = r8;
        r112.updateScope(new j1(r32, r33, r30, r31, r23, r24));
        return;
    L103:
        return;
    L94:
        r1.startReplaceGroup(749906203);
        r1.endReplaceGroup();
        goto L95
    L89:
        if (Intrinsics.areEqual(r27.rememberedValue(), Integer.valueOf(r20)) == true) goto L91;
    L85:
        r1.useNode();
        goto L86
    L78:
        r0 = BadgeRadius;
        goto L79
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
    L98:
        r1.skipToGroupEnd();
        r3 = r4;
        goto L99
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
        int r34 = 4;
    L11:
        r5 = r34 | r23;
        goto L14
    L10:
        r34 = 2;
        goto L11
    L12:
        r4 = r16;
        r5 = r23;
        goto L14
    }
}
