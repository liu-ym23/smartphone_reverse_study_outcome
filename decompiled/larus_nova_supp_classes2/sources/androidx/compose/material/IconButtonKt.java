package androidx.compose.material;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.ToggleableKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\\\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0011\"\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"IconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconButtonKt {
    private static final float RippleRadius = 0.0f;

    private static final Unit IconButton$lambda$1(Function0 r9, Modifier r10, boolean r11, MutableInteractionSource r12, Function2 r13, int r14, int r15, Composer r16, int r17) {
        IconButton(r9, r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit IconToggleButton$lambda$3(boolean r10, Function1 r11, Modifier r12, boolean r13, MutableInteractionSource r14, Function2 r15, int r16, int r17, Composer r18, int r19) {
        IconToggleButton(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function0 r0, Modifier r1, boolean r2, MutableInteractionSource r3, Function2 r4, int r5, int r6, Composer r7, int r8) {
        return IconButton$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit b(boolean r0, Function1 r1, Modifier r2, boolean r3, MutableInteractionSource r4, Function2 r5, int r6, int r7, Composer r8, int r9) {
        return IconToggleButton$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    static {
        RippleRadius = Dp.constructor-impl(24);
    }

    public static final void IconButton(final Function0<Unit> r18, Modifier r19, boolean r20, MutableInteractionSource r21, final Function2<? super Composer, ? super Integer, Unit> r22, Composer r23, final int r24, final int r25) {
        Composer r1 = r23.startRestartGroup(1316660641);
        if ((r25 & 1) == 0) goto L6;
        int r3 = r24 | 6;
    L13:
        int r4 = r25 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r7 = r19;
    L24:
        int r8 = r25 & 4;
        if (r8 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r9 = r20;
    L35:
        int r10 = r25 & 8;
        if (r10 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        MutableInteractionSource r11 = r21;
    L47:
        if ((r25 & 16) == 0) goto L50;
        r3 = r3 | 24576;
    L57:
        if ((r3 & 9363) == 9362) goto L59;
        boolean r12 = true;
    L61:
        if (r1.shouldExecute(r12, r3 & 1) == false) goto L94;
        if (r4 == 0) goto L64;
        Modifier r5 = Modifier.Companion;
    L65:
        if (r8 == 0) goto L67;
        boolean r16 = true;
    L68:
        if (r10 == 0) goto L70;
        MutableInteractionSource r17 = null;
    L72:
        if (ComposerKt.isTraceInProgress() == false) goto L74;
        ComposerKt.traceEventStart(1316660641, r3, -1, "androidx.compose.material.IconButton (IconButton.kt:60)");
    L74:
        MutableInteractionSource r13 = r17;
        boolean r14 = r16;
        Modifier r0 = ClickableKt.m375clickableO2vRcR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(r5), r13, RippleKt.m2139rippleH2RKhps$default(false, RippleRadius, 0, 4, null), r14, null, Role.box-impl(Role.Companion.getButton-o7Vup1c()), r18, 8, null);
        MeasurePolicy r15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r2 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r26 = r1.getCurrentCompositionLocalMap();
        Modifier r6 = ComposedModifierKt.materializeModifier(r1, r0);
        ComposeUiNode.Companion r27 = ComposeUiNode.Companion;
        Function0 r110 = r27.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L77;
        ComposablesKt.invalidApplier();
    L77:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L80;
        r1.createNode(r110);
    L81:
        Composer r111 = Updater.constructor-impl(r1);
        Updater.set-impl(r111, r15, r27.getSetMeasurePolicy());
        Updater.set-impl(r111, r26, r27.getSetResolvedCompositionLocals());
        Function2 r28 = r27.getSetCompositeKeyHash();
        if (r111.getInserting() == false) goto L84;
    L85:
        r111.updateRememberedValue(Integer.valueOf(r2));
        r111.apply(Integer.valueOf(r2), r28);
    L86:
        Updater.set-impl(r111, r6, r27.getSetModifier());
        BoxScopeInstance r29 = BoxScopeInstance.INSTANCE;
        if (r16 == false) goto L89;
        r1.startReplaceGroup(-1874697310);
        float r30 = ((Number) r1.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
    L90:
        r1.endReplaceGroup();
        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(r30)), r22, r1, ProvidedValue.$stable | ((r3 >> 9) & 112));
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        ComposerKt.traceEventEnd();
    L93:
        final Modifier r31 = r5;
        final boolean r32 = r16;
        final MutableInteractionSource r33 = r17;
    L95:
        ScopeUpdateScope r34 = r1.endRestartGroup();
        if (r34 == null) goto L99;
        r34.updateScope(new m5(r18, r31, r32, r33, r22, r24, r25));
        return;
    L99:
        return;
    L89:
        r1.startReplaceGroup(-1874696477);
        r30 = ContentAlpha.INSTANCE.getDisabled(r1, 6);
        goto L90
    L84:
        if (Intrinsics.areEqual(r111.rememberedValue(), Integer.valueOf(r2)) == true) goto L86;
    L80:
        r1.useNode();
        goto L81
    L70:
        r17 = r11;
        goto L72
    L67:
        r16 = r9;
        goto L68
    L64:
        r5 = r7;
        goto L65
    L94:
        r1.skipToGroupEnd();
        r31 = r7;
        r32 = r9;
        r33 = r11;
        goto L95
    L59:
        r12 = false;
        goto L61
    L50:
        if ((r24 & 24576) != 0) goto L57;
        if (r1.changedInstance(r22) == false) goto L54;
        int r112 = 16384;
    L55:
        r3 = r3 | r112;
        goto L57
    L54:
        r112 = 8192;
        goto L55
    L39:
        if ((r24 & 3072) != 0) goto L45;
        r11 = r21;
        if (r1.changed(r11) == false) goto L43;
        int r113 = 2048;
    L44:
        r3 = r3 | r113;
        goto L47
    L43:
        r113 = 1024;
        goto L44
    L28:
        if ((r24 & 384) != 0) goto L34;
        r9 = r20;
        if (r1.changed(r9) == false) goto L32;
        int r114 = 256;
    L33:
        r3 = r3 | r114;
        goto L35
    L32:
        r114 = 128;
        goto L33
    L17:
        if ((r24 & 48) != 0) goto L23;
        r7 = r19;
        if (r1.changed(r7) == false) goto L21;
        int r35 = 32;
    L22:
        r3 = r3 | r35;
        goto L24
    L21:
        r35 = 16;
        goto L22
    L6:
        if ((r24 & 6) == 0) goto L8;
        r3 = r24;
        goto L13
    L8:
        if (r1.changedInstance(r18) == false) goto L10;
        int r36 = 4;
    L11:
        r3 = r36 | r24;
        goto L13
    L10:
        r36 = 2;
        goto L11
    }

    public static final void IconToggleButton(final boolean r18, final Function1<? super Boolean, Unit> r19, Modifier r20, boolean r21, MutableInteractionSource r22, final Function2<? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25, final int r26) {
        Composer r1 = r24.startRestartGroup(1097147314);
        if ((r26 & 1) == 0) goto L6;
        int r3 = r25 | 6;
    L14:
        if ((r26 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r26 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r8 = r20;
    L35:
        int r9 = r26 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r10 = r21;
    L46:
        int r11 = r26 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        MutableInteractionSource r12 = r22;
    L58:
        if ((r26 & 32) == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r16 = true;
        if ((74899 & r3) == 74898) goto L70;
        boolean r13 = true;
    L72:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L105;
        if (r5 == 0) goto L75;
        Modifier r6 = Modifier.Companion;
    L76:
        if (r9 != 0) goto L79;
        r16 = r10;
    L79:
        if (r11 == 0) goto L81;
        MutableInteractionSource r17 = null;
    L83:
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventStart(1097147314, r3, -1, "androidx.compose.material.IconToggleButton (IconButton.kt:104)");
    L85:
        MutableInteractionSource r14 = r17;
        boolean r15 = r16;
        Modifier r0 = ToggleableKt.m1297toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(r6), r18, r14, RippleKt.m2139rippleH2RKhps$default(false, RippleRadius, 0, 4, null), r15, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), r19);
        MeasurePolicy r27 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r28 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r110 = r1.getCurrentCompositionLocalMap();
        Modifier r2 = ComposedModifierKt.materializeModifier(r1, r0);
        ComposeUiNode.Companion r111 = ComposeUiNode.Companion;
        Function0 r112 = r111.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L88;
        ComposablesKt.invalidApplier();
    L88:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L91;
        r1.createNode(r112);
    L92:
        Composer r113 = Updater.constructor-impl(r1);
        Updater.set-impl(r113, r27, r111.getSetMeasurePolicy());
        Updater.set-impl(r113, r110, r111.getSetResolvedCompositionLocals());
        Function2 r29 = r111.getSetCompositeKeyHash();
        if (r113.getInserting() == false) goto L95;
    L96:
        r113.updateRememberedValue(Integer.valueOf(r28));
        r113.apply(Integer.valueOf(r28), r29);
    L97:
        Updater.set-impl(r113, r2, r111.getSetModifier());
        BoxScopeInstance r4 = BoxScopeInstance.INSTANCE;
        if (r16 == false) goto L100;
        r1.startReplaceGroup(1952142323);
        float r7 = ((Number) r1.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
    L101:
        r1.endReplaceGroup();
        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(r7)), r23, r1, ((r3 >> 12) & 112) | ProvidedValue.$stable);
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L104;
        ComposerKt.traceEventEnd();
    L104:
        final Modifier r30 = r6;
        r10 = r16;
        final MutableInteractionSource r31 = r17;
    L106:
        ScopeUpdateScope r32 = r1.endRestartGroup();
        if (r32 == null) goto L110;
        final boolean r33 = r10;
        r32.updateScope(new n5(r18, r19, r30, r33, r31, r23, r25, r26));
        return;
    L110:
        return;
    L100:
        r1.startReplaceGroup(1952143156);
        r7 = ContentAlpha.INSTANCE.getDisabled(r1, 6);
        goto L101
    L95:
        if (Intrinsics.areEqual(r113.rememberedValue(), Integer.valueOf(r28)) == true) goto L97;
    L91:
        r1.useNode();
        goto L92
    L81:
        r17 = r12;
        goto L83
    L75:
        r6 = r8;
        goto L76
    L105:
        r1.skipToGroupEnd();
        r30 = r8;
        r31 = r12;
        goto L106
    L70:
        r13 = false;
        goto L72
    L61:
        if ((r25 & 196608) != 0) goto L67;
        if (r1.changedInstance(r23) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
        goto L67
    L65:
        r114 = 65536;
        goto L66
    L50:
        if ((r25 & 24576) != 0) goto L56;
        r12 = r22;
        if (r1.changed(r12) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
        goto L58
    L54:
        r115 = 8192;
        goto L55
    L39:
        if ((r25 & 3072) != 0) goto L45;
        r10 = r21;
        if (r1.changed(r10) == false) goto L43;
        int r116 = 2048;
    L44:
        r3 = r3 | r116;
        goto L46
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r25 & 384) != 0) goto L34;
        r8 = r20;
        if (r1.changed(r8) == false) goto L32;
        int r34 = 256;
    L33:
        r3 = r3 | r34;
        goto L35
    L32:
        r34 = 128;
        goto L33
    L17:
        if ((r25 & 48) != 0) goto L24;
        if (r1.changedInstance(r19) == false) goto L21;
        int r35 = 32;
    L22:
        r3 = r3 | r35;
        goto L24
    L21:
        r35 = 16;
        goto L22
    L6:
        if ((r25 & 6) == 0) goto L8;
        r3 = r25;
        goto L14
    L8:
        if (r1.changed(r18) == false) goto L10;
        int r36 = 4;
    L11:
        r3 = r36 | r25;
        goto L14
    L10:
        r36 = 2;
        goto L11
    }
}
