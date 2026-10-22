package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001aF\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"ContextMenuArea", "", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "onDismiss", "Lkotlin/Function0;", "contextMenuBuilderBlock", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "onOpenGesture", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ContextMenu", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuArea_androidKt {
    private static final Unit ContextMenu$lambda$6(ContextMenuState r7, Function0 r8, Modifier r9, Function1 r10, int r11, int r12, Composer r13, int r14) {
        ContextMenu(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenu$lambda$8(ContextMenuState r7, Function0 r8, Modifier r9, Function1 r10, int r11, int r12, Composer r13, int r14) {
        ContextMenu(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuArea$lambda$5(ContextMenuState r11, Function0 r12, Function1 r13, Modifier r14, boolean r15, Function0 r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        ContextMenuArea(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a() {
        return ContextMenuArea$lambda$1$lambda$0();
    }

    public static /* synthetic */ Unit b(ContextMenuState r0, Function0 r1, Function1 r2, Modifier r3, boolean r4, Function0 r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return ContextMenuArea$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit c(ContextMenuState r0, Function0 r1, Modifier r2, Function1 r3, int r4, int r5, Composer r6, int r7) {
        return ContextMenu$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit d(ContextMenuState r0, Function0 r1, Modifier r2, Function1 r3, int r4, int r5, Composer r6, int r7) {
        return ContextMenu$lambda$8(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit e(Function0 r0, ContextMenuState r1, Offset r2) {
        return ContextMenuArea$lambda$3$lambda$2(r0, r1, r2);
    }

    private static final Unit ContextMenuArea$lambda$1$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuArea$lambda$3$lambda$2(Function0 r2, ContextMenuState r3, Offset r4) {
        r2.invoke();
        r3.setStatus(new ContextMenuState.Status.Open(r4.unbox-impl(), null));
        return Unit.INSTANCE;
    }

    public static final void ContextMenu(final ContextMenuState r21, final Function0<Unit> r22, Modifier r23, final Function1<? super ContextMenuScope, Unit> r24, Composer r25, final int r26, final int r27) {
        Composer r1 = r25.startRestartGroup(645832757);
        if ((r27 & 1) == 0) goto L6;
        int r3 = r26 | 6;
    L14:
        if ((r27 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r27 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r7 = r23;
    L36:
        if ((r27 & 8) == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        if ((r3 & 1171) == 1170) goto L48;
        boolean r8 = true;
    L50:
        if (r1.shouldExecute(r8, r3 & 1) == false) goto L75;
        if (r6 == 0) goto L53;
        Modifier r14 = Modifier.Companion;
    L55:
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventStart(645832757, r3, -1, "androidx.compose.foundation.contextmenu.ContextMenu (ContextMenuArea.android.kt:73)");
    L57:
        ContextMenuState.Status r0 = r21.getStatus();
        if ((r0 instanceof ContextMenuState.Status.Open) == false) goto L60;
        ContextMenuState.Status.Open r2 = (ContextMenuState.Status.Open) r0;
        boolean r9 = r1.changed(r2);
        Object r10 = r1.rememberedValue();
        if (r9 == false) goto L69;
    L70:
        r10 = new ContextMenuPopupPositionProvider(IntOffsetKt.round-k-4lQ0M(r2.m489getOffsetF1C5BW0()), null, 2, null);
        r1.updateRememberedValue(r10);
    L71:
        Modifier r11 = r14;
        ContextMenuUi_androidKt.ContextMenuPopup((ContextMenuPopupPositionProvider) r10, r22, r11, r24, r1, ((r3 & 112) | (r3 & 896)) | (r3 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L74;
        ComposerKt.traceEventEnd();
    L74:
        final Modifier r4 = r14;
    L76:
        ScopeUpdateScope r12 = r1.endRestartGroup();
        if (r12 == null) goto L81;
        r12.updateScope(new b(r21, r22, r4, r24, r26, r27));
        return;
    L81:
        return;
    L69:
        if (r10 != Composer.Companion.getEmpty()) goto L71;
    L60:
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventEnd();
    L62:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L80;
        final Modifier r5 = r14;
        r13.updateScope(new a(r21, r22, r5, r24, r26, r27));
        return;
    L80:
        return;
    L53:
        r14 = r7;
        goto L55
    L75:
        r1.skipToGroupEnd();
        r4 = r7;
        goto L76
    L48:
        r8 = false;
        goto L50
    L39:
        if ((r26 & 3072) != 0) goto L46;
        if (r1.changedInstance(r24) == false) goto L43;
        int r15 = 2048;
    L44:
        r3 = r3 | r15;
        goto L46
    L43:
        r15 = 1024;
        goto L44
    L28:
        if ((r26 & 384) != 0) goto L34;
        r7 = r23;
        if (r1.changed(r7) == false) goto L32;
        int r16 = 256;
    L33:
        r3 = r3 | r16;
        goto L36
    L32:
        r16 = 128;
        goto L33
    L17:
        if ((r26 & 48) != 0) goto L24;
        if (r1.changedInstance(r22) == false) goto L21;
        int r17 = 32;
    L22:
        r3 = r3 | r17;
        goto L24
    L21:
        r17 = 16;
        goto L22
    L6:
        if ((r26 & 6) == 0) goto L8;
        r3 = r26;
        goto L14
    L8:
        if (r1.changed(r21) == false) goto L10;
        int r18 = 4;
    L11:
        r3 = r18 | r26;
        goto L14
    L10:
        r18 = 2;
        goto L11
    }

    public static final void ContextMenuArea(final ContextMenuState r18, final Function0<Unit> r19, final Function1<? super ContextMenuScope, Unit> r20, Modifier r21, boolean r22, Function0<Unit> r23, final Function2<? super Composer, ? super Integer, Unit> r24, Composer r25, final int r26, final int r27) {
        Composer r10 = r25.startRestartGroup(1877873755);
        if ((r27 & 1) == 0) goto L6;
        int r1 = r26 | 6;
    L14:
        if ((r27 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r27 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r3 = r27 & 8;
        if (r3 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        Modifier r5 = r21;
    L44:
        int r6 = r27 & 16;
        if (r6 == 0) goto L48;
        r1 = r1 | 24576;
    L54:
        boolean r13 = r22;
    L55:
        int r14 = r27 & 32;
        if (r14 == 0) goto L58;
        r1 = r1 | 196608;
        Function0<Unit> r4 = r23;
    L66:
        if ((r27 & 64) == 0) goto L69;
        r1 = r1 | 1572864;
    L76:
        if ((r1 & 599187) == 599186) goto L78;
        boolean r2 = true;
    L80:
        if (r10.shouldExecute(r2, r1 & 1) == false) goto L127;
        if (r3 == 0) goto L83;
        Modifier r15 = Modifier.Companion;
    L84:
        if (r6 == 0) goto L86;
        r13 = true;
    L86:
        if (r14 == 0) goto L91;
        Object r7 = r10.rememberedValue();
        if (r7 != Composer.Companion.getEmpty()) goto L90;
        r7 = new c();
        r10.updateRememberedValue(r7);
    L90:
        final Function0<Unit> r16 = (Function0) r7;
    L93:
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventStart(1877873755, r1, -1, "androidx.compose.foundation.contextmenu.ContextMenuArea (ContextMenuArea.android.kt:46)");
    L95:
        if (r13 == false) goto L110;
        r10.startReplaceGroup(1788348907);
        if ((458752 & r1) != 131072) goto L99;
        boolean r8 = true;
    L101:
        if ((r1 & 14) != 4) goto L103;
        boolean r9 = true;
    L104:
        boolean r11 = r8 | r9;
        Object r12 = r10.rememberedValue();
        if (r11 == false) goto L107;
    L108:
        r12 = new d(r16, r18);
        r10.updateRememberedValue(r12);
    L109:
        Modifier r17 = ContextMenuGestures_androidKt.contextMenuGestures(r15, (Function1) r12);
        r10.endReplaceGroup();
    L111:
        MeasurePolicy r0 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
        long r28 = ComposablesKt.getCurrentCompositeKeyHashCode(r10, 0);
        int r29 = (int) (r28 ^ (r28 >>> 32));
        CompositionLocalMap r30 = r10.getCurrentCompositionLocalMap();
        Modifier r31 = ComposedModifierKt.materializeModifier(r10, r17);
        ComposeUiNode.Companion r32 = ComposeUiNode.Companion;
        Function0 r33 = r32.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L114;
        ComposablesKt.invalidApplier();
    L114:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L117;
        r10.createNode(r33);
    L118:
        Composer r34 = Updater.constructor-impl(r10);
        Updater.set-impl(r34, r0, r32.getSetMeasurePolicy());
        Updater.set-impl(r34, r30, r32.getSetResolvedCompositionLocals());
        Function2 r35 = r32.getSetCompositeKeyHash();
        if (r34.getInserting() == false) goto L121;
    L122:
        r34.updateRememberedValue(Integer.valueOf(r29));
        r34.apply(Integer.valueOf(r29), r35);
    L123:
        Updater.set-impl(r34, r31, r32.getSetModifier());
        BoxScopeInstance r36 = BoxScopeInstance.INSTANCE;
        r24.invoke(r10, Integer.valueOf((r1 >> 18) & 14));
        ContextMenu(r18, r19, null, r20, r10, ((r1 & 14) | (r1 & 112)) | ((r1 << 3) & 7168), 4);
        r10.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventEnd();
    L126:
        final boolean r37 = r13;
        final Function0<Unit> r38 = r16;
        final Modifier r39 = r15;
    L128:
        ScopeUpdateScope r110 = r10.endRestartGroup();
        if (r110 == null) goto L132;
        r110.updateScope(new e(r18, r19, r20, r39, r37, r38, r24, r26, r27));
        return;
    L132:
        return;
    L121:
        if (Intrinsics.areEqual(r34.rememberedValue(), Integer.valueOf(r29)) == true) goto L123;
    L117:
        r10.useNode();
        goto L118
    L107:
        if (r12 != Composer.Companion.getEmpty()) goto L109;
    L103:
        r9 = false;
        goto L104
    L99:
        r8 = false;
        goto L101
    L110:
        r10.startReplaceGroup(1788505767);
        r10.endReplaceGroup();
        r17 = r15;
        goto L111
    L91:
        r16 = r4;
        goto L93
    L83:
        r15 = r5;
        goto L84
    L127:
        r10.skipToGroupEnd();
        r38 = r4;
        r39 = r5;
        r37 = r13;
        goto L128
    L78:
        r2 = false;
        goto L80
    L69:
        if ((r26 & 1572864) != 0) goto L76;
        if (r10.changedInstance(r24) == false) goto L73;
        int r111 = 1048576;
    L74:
        r1 = r1 | r111;
        goto L76
    L73:
        r111 = 524288;
        goto L74
    L58:
        r4 = r23;
        if ((r26 & 196608) != 0) goto L66;
        if (r10.changedInstance(r4) == false) goto L63;
        int r112 = 131072;
    L64:
        r1 = r1 | r112;
        goto L66
    L63:
        r112 = 65536;
        goto L64
    L48:
        if ((r26 & 24576) != 0) goto L54;
        r13 = r22;
        if (r10.changed(r13) == false) goto L52;
        int r113 = 16384;
    L53:
        r1 = r1 | r113;
        goto L55
    L52:
        r113 = 8192;
        goto L53
    L37:
        if ((r26 & 3072) != 0) goto L43;
        r5 = r21;
        if (r10.changed(r5) == false) goto L41;
        int r40 = 2048;
    L42:
        r1 = r1 | r40;
        goto L44
    L41:
        r40 = 1024;
        goto L42
    L27:
        if ((r26 & 384) != 0) goto L33;
        if (r10.changedInstance(r20) == false) goto L31;
        int r41 = 256;
    L32:
        r1 = r1 | r41;
        goto L33
    L31:
        r41 = 128;
        goto L32
    L17:
        if ((r26 & 48) != 0) goto L24;
        if (r10.changedInstance(r19) == false) goto L21;
        int r42 = 32;
    L22:
        r1 = r1 | r42;
        goto L24
    L21:
        r42 = 16;
        goto L22
    L6:
        if ((r26 & 6) == 0) goto L8;
        r1 = r26;
        goto L14
    L8:
        if (r10.changed(r18) == false) goto L10;
        int r43 = 4;
    L11:
        r1 = r43 | r26;
        goto L14
    L10:
        r43 = 2;
        goto L11
    }
}
