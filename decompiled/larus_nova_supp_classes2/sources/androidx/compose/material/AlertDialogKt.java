package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¢\u0001\u0010\u0000\u001a\u00020\u00012\u000e\b\b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0013\b\b\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0015\b\b\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\b\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\b\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0081\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u008b\u0001\u0010\u0000\u001a\u00020\u00012\u000e\b\b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0013\b\b\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0015\b\b\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\b\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0081\b¢\u0006\u0004\b\u0015\u0010\u0016\u001ax\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0013\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u001c\u001a2\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0004\b\"\u0010#\"\u000e\u0010$\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(\"\u0010\u0010)\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(\"\u0010\u0010*\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006+"}, d2 = {"AlertDialogImpl", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialogImpl-0nD-MI0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;I)V", "buttons", "AlertDialogImpl-SxpAMN0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;I)V", "AlertDialogContent", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TitlePadding", "TextPadding", "TitleBaselineDistanceFromTop", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTitle", "TextBaselineDistanceFromTop", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AlertDialogKt {
    private static final long TextBaselineDistanceFromTitle = 0;
    private static final long TextBaselineDistanceFromTop = 0;
    private static final Modifier TextPadding = null;
    private static final long TitleBaselineDistanceFromTop = 0;
    private static final Modifier TitlePadding = null;

    private static final Unit AlertDialogBaselineLayout$lambda$7(ColumnScope r0, Function2 r1, Function2 r2, int r3, Composer r4, int r5) {
        AlertDialogBaselineLayout(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit AlertDialogContent_WMdw5o4$lambda$0(Function2 r13, Modifier r14, Function2 r15, Function2 r16, Shape r17, long r18, long r20, int r22, int r23, Composer r24, int r25) {
        m1912AlertDialogContentWMdw5o4(r13, r14, r15, r16, r17, r18, r20, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit AlertDialogFlowRow_ixp7dh8$lambda$9(float r0, float r1, Function2 r2, int r3, Composer r4, int r5) {
        m1913AlertDialogFlowRowixp7dh8(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(ColumnScope r0, Function2 r1, Function2 r2, int r3, Composer r4, int r5) {
        return AlertDialogBaselineLayout$lambda$7(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit b(Function2 r0, Modifier r1, Function2 r2, Function2 r3, Shape r4, long r5, long r7, int r9, int r10, Composer r11, int r12) {
        return AlertDialogContent_WMdw5o4$lambda$0(r0, r1, r2, r3, r4, r5, r7, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit c(float r0, float r1, Function2 r2, int r3, Composer r4, int r5) {
        return AlertDialogFlowRow_ixp7dh8$lambda$9(r0, r1, r2, r3, r4, r5);
    }

    static {
        Modifier.Companion r7 = Modifier.Companion;
        float r8 = 24;
        TitlePadding = PaddingKt.m964paddingqDBjuR0$default(r7, Dp.constructor-impl(r8), androidx.compose.material3.MenuKt.ClosedAlphaTarget, Dp.constructor-impl(r8), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 10, null);
        TextPadding = PaddingKt.m964paddingqDBjuR0$default(r7, Dp.constructor-impl(r8), androidx.compose.material3.MenuKt.ClosedAlphaTarget, Dp.constructor-impl(r8), Dp.constructor-impl(28), 2, null);
        TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
        TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
        TextBaselineDistanceFromTop = TextUnitKt.getSp(38);
    }

    public static final /* synthetic */ long access$getTextBaselineDistanceFromTitle$p() {
        return TextBaselineDistanceFromTitle;
    }

    public static final /* synthetic */ long access$getTextBaselineDistanceFromTop$p() {
        return TextBaselineDistanceFromTop;
    }

    public static final /* synthetic */ long access$getTitleBaselineDistanceFromTop$p() {
        return TitleBaselineDistanceFromTop;
    }

    public static final void AlertDialogBaselineLayout(final ColumnScope r8, final Function2<? super Composer, ? super Integer, Unit> r9, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(1213983107);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 48) != 0) goto L18;
        if (r13.changedInstance(r9) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r12 & 384) != 0) goto L25;
        if (r13.changedInstance(r10) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r13.shouldExecute(r4, r1 & 1) == true) goto L31;
        r13.skipToGroupEnd();
    L85:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L89;
        r14.updateScope(new b(r8, r9, r10, r12));
        return;
    L89:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(1213983107, r1, -1, "androidx.compose.material.AlertDialogBaselineLayout (AlertDialog.kt:247)");
    L33:
        Modifier r0 = r8.weight(Modifier.Companion, 1.0f, false);
        Object r5 = r13.rememberedValue();
        if (r5 != Composer.Companion.getEmpty()) goto L36;
        r5 = AlertDialogKt$AlertDialogBaselineLayout$2$1.INSTANCE;
        r13.updateRememberedValue(r5);
    L36:
        MeasurePolicy r6 = (MeasurePolicy) r5;
        int r7 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r15 = r13.getCurrentCompositionLocalMap();
        Modifier r16 = ComposedModifierKt.materializeModifier(r13, r0);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r18 = r17.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L39;
        ComposablesKt.invalidApplier();
    L39:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L42;
        r13.createNode(r18);
    L43:
        Composer r19 = Updater.constructor-impl(r13);
        Updater.set-impl(r19, r6, r17.getSetMeasurePolicy());
        Updater.set-impl(r19, r15, r17.getSetResolvedCompositionLocals());
        Function2 r20 = r17.getSetCompositeKeyHash();
        if (r19.getInserting() == false) goto L46;
    L47:
        r19.updateRememberedValue(Integer.valueOf(r7));
        r19.apply(Integer.valueOf(r7), r20);
    L48:
        Updater.set-impl(r19, r16, r17.getSetModifier());
        if (r9 != null) goto L52;
        r13.startReplaceGroup(1809237538);
    L51:
        r13.endReplaceGroup();
        if (r10 != null) goto L68;
        r13.startReplaceGroup(1809370342);
    L67:
        r13.endReplaceGroup();
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventEnd();
        goto L85
    L68:
        r13.startReplaceGroup(1809370343);
        Modifier r21 = LayoutIdKt.layoutId(TextPadding, "text");
        Alignment.Companion r22 = Alignment.Companion;
        Modifier r23 = r8.align(r21, r22.getStart());
        MeasurePolicy r24 = BoxKt.maybeCachedBoxMeasurePolicy(r22.getTopStart(), false);
        int r25 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r26 = r13.getCurrentCompositionLocalMap();
        Modifier r27 = ComposedModifierKt.materializeModifier(r13, r23);
        Function0 r28 = r17.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L71;
        ComposablesKt.invalidApplier();
    L71:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L74;
        r13.createNode(r28);
    L75:
        Composer r29 = Updater.constructor-impl(r13);
        Updater.set-impl(r29, r24, r17.getSetMeasurePolicy());
        Updater.set-impl(r29, r26, r17.getSetResolvedCompositionLocals());
        Function2 r30 = r17.getSetCompositeKeyHash();
        if (r29.getInserting() == false) goto L78;
    L79:
        r29.updateRememberedValue(Integer.valueOf(r25));
        r29.apply(Integer.valueOf(r25), r30);
    L80:
        Updater.set-impl(r29, r27, r17.getSetModifier());
        BoxScopeInstance r31 = BoxScopeInstance.INSTANCE;
        r10.invoke(r13, 0);
        r13.endNode();
        goto L67
    L78:
        if (Intrinsics.areEqual(r29.rememberedValue(), Integer.valueOf(r25)) == true) goto L80;
    L74:
        r13.useNode();
        goto L75
    L52:
        r13.startReplaceGroup(1809237539);
        Modifier r32 = LayoutIdKt.layoutId(TitlePadding, "title");
        Alignment.Companion r33 = Alignment.Companion;
        Modifier r34 = r8.align(r32, r33.getStart());
        MeasurePolicy r35 = BoxKt.maybeCachedBoxMeasurePolicy(r33.getTopStart(), false);
        int r36 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r37 = r13.getCurrentCompositionLocalMap();
        Modifier r38 = ComposedModifierKt.materializeModifier(r13, r34);
        Function0 r39 = r17.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L55;
        ComposablesKt.invalidApplier();
    L55:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L58;
        r13.createNode(r39);
    L59:
        Composer r40 = Updater.constructor-impl(r13);
        Updater.set-impl(r40, r35, r17.getSetMeasurePolicy());
        Updater.set-impl(r40, r37, r17.getSetResolvedCompositionLocals());
        Function2 r41 = r17.getSetCompositeKeyHash();
        if (r40.getInserting() == false) goto L62;
    L63:
        r40.updateRememberedValue(Integer.valueOf(r36));
        r40.apply(Integer.valueOf(r36), r41);
    L64:
        Updater.set-impl(r40, r38, r17.getSetModifier());
        BoxScopeInstance r42 = BoxScopeInstance.INSTANCE;
        r9.invoke(r13, 0);
        r13.endNode();
        goto L51
    L62:
        if (Intrinsics.areEqual(r40.rememberedValue(), Integer.valueOf(r36)) == true) goto L64;
    L58:
        r13.useNode();
        goto L59
    L46:
        if (Intrinsics.areEqual(r19.rememberedValue(), Integer.valueOf(r7)) == true) goto L48;
    L42:
        r13.useNode();
        goto L43
    L27:
        r4 = false;
        goto L29
    L5:
        if (r13.changed(r8) == false) goto L7;
        int r43 = 4;
    L8:
        r1 = r43 | r12;
        goto L11
    L7:
        r43 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m1913AlertDialogFlowRowixp7dh8(final float r8, final float r9, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(1271829505);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 48) != 0) goto L18;
        if (r13.changed(r9) == false) goto L15;
        int r3 = 32;
    L16:
        r1 = r1 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r12 & 384) == 0) goto L20;
    L24:
        boolean r6 = true;
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r13.shouldExecute(r4, r1 & 1) == true) goto L31;
        r13.skipToGroupEnd();
    L62:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L66;
        r14.updateScope(new a(r8, r9, r10, r12));
        return;
    L66:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(1271829505, r1, -1, "androidx.compose.material.AlertDialogFlowRow (AlertDialog.kt:349)");
    L34:
        if ((r1 & 14) != 4) goto L36;
        boolean r0 = true;
    L38:
        if ((r1 & 112) == 32) goto L41;
        r6 = false;
    L41:
        boolean r2 = r0 | r6;
        Object r5 = r13.rememberedValue();
        if (r2 == false) goto L44;
    L45:
        r5 = new AlertDialogKt$AlertDialogFlowRow$1$1(r8, r9);
        r13.updateRememberedValue(r5);
    L46:
        MeasurePolicy r7 = (MeasurePolicy) r5;
        int r15 = (r1 >> 6) & 14;
        Modifier.Companion r16 = Modifier.Companion;
        int r17 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r18 = r13.getCurrentCompositionLocalMap();
        Modifier r19 = ComposedModifierKt.materializeModifier(r13, r16);
        ComposeUiNode.Companion r20 = ComposeUiNode.Companion;
        Function0 r21 = r20.getConstructor();
        int r22 = ((r15 << 6) & 896) | 6;
        if ((r13.getApplier() instanceof Applier) == true) goto L49;
        ComposablesKt.invalidApplier();
    L49:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L52;
        r13.createNode(r21);
    L53:
        Composer r23 = Updater.constructor-impl(r13);
        Updater.set-impl(r23, r7, r20.getSetMeasurePolicy());
        Updater.set-impl(r23, r18, r20.getSetResolvedCompositionLocals());
        Function2 r24 = r20.getSetCompositeKeyHash();
        if (r23.getInserting() == false) goto L56;
    L57:
        r23.updateRememberedValue(Integer.valueOf(r17));
        r23.apply(Integer.valueOf(r17), r24);
    L58:
        Updater.set-impl(r23, r19, r20.getSetModifier());
        r10.invoke(r13, Integer.valueOf((r22 >> 6) & 14));
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventEnd();
        goto L62
    L56:
        if (Intrinsics.areEqual(r23.rememberedValue(), Integer.valueOf(r17)) == true) goto L58;
    L52:
        r13.useNode();
        goto L53
    L44:
        if (r5 != Composer.Companion.getEmpty()) goto L46;
    L36:
        r0 = false;
        goto L38
    L27:
        r4 = false;
        goto L29
    L20:
        if (r13.changedInstance(r10) == false) goto L22;
        int r25 = 256;
    L23:
        r1 = r1 | r25;
        goto L24
    L22:
        r25 = 128;
        goto L23
    L5:
        if (r13.changed(r8) == false) goto L7;
        int r26 = 4;
    L8:
        r1 = r26 | r12;
        goto L11
    L7:
        r26 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: AlertDialogContent-WMdw5o4, reason: not valid java name */
    public static final void m1912AlertDialogContentWMdw5o4(final Function2<? super Composer, ? super Integer, Unit> r27, Modifier r28, Function2<? super Composer, ? super Integer, Unit> r29, Function2<? super Composer, ? super Integer, Unit> r30, Shape r31, long r32, long r34, Composer r36, final int r37, final int r38) {
        Composer r2 = r36.startRestartGroup(1945098332);
        if ((r38 & 1) == 0) goto L6;
        int r3 = r37 | 6;
    L13:
        int r4 = r38 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r38 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r8 = r38 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function2<? super Composer, ? super Integer, Unit> r9 = r30;
    L47:
        if ((r37 & 24576) == 0) goto L49;
        Shape r11 = r31;
    L58:
        if ((196608 & r37) == 0) goto L60;
        long r12 = r32;
    L69:
        if ((r37 & 1572864) == 0) goto L71;
        long r14 = r34;
    L80:
        if ((r3 & 599187) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L130;
        r2.startDefaults();
        if ((r37 & 1) != 0) goto L88;
    L101:
        if (r4 == 0) goto L103;
        Modifier r1 = Modifier.Companion;
    L104:
        final Function2<? super Composer, ? super Integer, Unit> r5 = null;
        if (r6 == 0) goto L107;
        final Function2<? super Composer, ? super Integer, Unit> r7 = null;
    L108:
        if (r8 != 0) goto L112;
        r5 = r9;
    L112:
        if ((r38 & 16) == 0) goto L114;
        Shape r10 = MaterialTheme.INSTANCE.getShapes(r2, 6).getMedium();
        r3 = r3 & (-57345);
    L116:
        if ((r38 & 32) == 0) goto L118;
        long r13 = MaterialTheme.INSTANCE.getColors(r2, 6).m2003getSurface0d7_KjU();
        r3 = r3 & (-458753);
    L120:
        if ((r38 & 64) == 0) goto L122;
        long r15 = ColorsKt.m2017contentColorForek8zF_U(r13, r2, (r3 >> 15) & 14);
        r3 = r3 & (-3670017);
        long r23 = r13;
        long r25 = r15;
    L123:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventStart(1945098332, r3, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:201)");
    L126:
        int r16 = ((r3 >> 3) & 14) | 1572864;
        int r17 = r3 >> 9;
        Modifier r18 = r1;
        Shape r19 = r10;
        long r110 = r23;
        long r111 = r25;
        SurfaceKt.m2175SurfaceFjzlyU(r18, r19, r110, r111, null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, ComposableLambdaKt.rememberComposableLambda(802957984, true, new AlertDialogKt$AlertDialogContent$1(r7, r5, r27), r2, 54), r2, ((r16 | (r17 & 112)) | (r17 & 896)) | (r17 & 7168), 48);
        if (ComposerKt.isTraceInProgress() == false) goto L129;
        ComposerKt.traceEventEnd();
    L129:
        Modifier r20 = r1;
        final Shape r21 = r10;
        final long r22 = r25;
    L131:
        ScopeUpdateScope r112 = r2.endRestartGroup();
        if (r112 == null) goto L135;
        final Modifier r24 = r20;
        final Function2<? super Composer, ? super Integer, Unit> r26 = r7;
        final long r33 = r23;
        r112.updateScope(new c(r27, r24, r26, r5, r21, r33, r22, r37, r38));
        return;
    L135:
        return;
    L122:
        r23 = r13;
    L100:
        r25 = r14;
        goto L123
    L118:
        r13 = r12;
        goto L120
    L114:
        r10 = r11;
        goto L116
    L107:
        r7 = r29;
        goto L108
    L103:
        r1 = r28;
        goto L104
    L88:
        if (r2.getDefaultsInvalid() == true) goto L101;
        r2.skipToGroupEnd();
        if ((r38 & 16) == 0) goto L94;
        r3 = r3 & (-57345);
    L94:
        if ((r38 & 32) == 0) goto L97;
        r3 = r3 & (-458753);
    L97:
        if ((r38 & 64) == 0) goto L99;
        r3 = r3 & (-3670017);
    L99:
        r1 = r28;
        r7 = r29;
        r5 = r9;
        r10 = r11;
        r23 = r12;
        goto L100
    L130:
        r2.skipToGroupEnd();
        r20 = r28;
        r7 = r29;
        r5 = r9;
        r21 = r11;
        r23 = r12;
        r22 = r14;
        goto L131
    L82:
        r0 = false;
        goto L84
    L71:
        if ((r38 & 64) != 0) goto L75;
        r14 = r34;
        if (r2.changed(r14) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
    L76:
        r113 = 524288;
        goto L77
    L75:
        r14 = r34;
        goto L76
    L60:
        if ((r38 & 32) != 0) goto L64;
        r12 = r32;
        if (r2.changed(r12) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
    L65:
        r114 = 65536;
        goto L66
    L64:
        r12 = r32;
        goto L65
    L49:
        if ((r38 & 16) != 0) goto L53;
        r11 = r31;
        if (r2.changed(r11) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
    L54:
        r115 = 8192;
        goto L55
    L53:
        r11 = r31;
        goto L54
    L39:
        if ((r37 & 3072) != 0) goto L45;
        r9 = r30;
        if (r2.changedInstance(r9) == false) goto L43;
        int r116 = 2048;
    L44:
        r3 = r3 | r116;
        goto L47
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r37 & 384) != 0) goto L35;
        if (r2.changedInstance(r29) == false) goto L32;
        int r35 = 256;
    L33:
        r3 = r3 | r35;
        goto L35
    L32:
        r35 = 128;
        goto L33
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r2.changed(r28) == false) goto L21;
        int r39 = 32;
    L22:
        r3 = r3 | r39;
        goto L24
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r3 = r37;
        goto L13
    L8:
        if (r2.changedInstance(r27) == false) goto L10;
        int r40 = 4;
    L11:
        r3 = r40 | r37;
        goto L13
    L10:
        r40 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: AlertDialogImpl-SxpAMN0, reason: not valid java name */
    public static final void m1915AlertDialogImplSxpAMN0(Function0<Unit> r11, Function2<? super Composer, ? super Integer, Unit> r12, Modifier r13, Function2<? super Composer, ? super Integer, Unit> r14, Function2<? super Composer, ? super Integer, Unit> r15, Shape r16, long r17, long r19, DialogProperties r21, Composer r22, int r23) {
        AndroidDialog_androidKt.Dialog(r11, r21, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(r12, r13, r14, r15, r16, r17, r19), r22, 54), r22, ((r23 & 14) | 384) | ((r23 >> 21) & 112), 0);
    }

    /* JADX INFO: renamed from: AlertDialogImpl-0nD-MI0, reason: not valid java name */
    public static final void m1914AlertDialogImpl0nDMI0(Function0<Unit> r19, Function2<? super Composer, ? super Integer, Unit> r20, Modifier r21, Function2<? super Composer, ? super Integer, Unit> r22, Function2<? super Composer, ? super Integer, Unit> r23, Function2<? super Composer, ? super Integer, Unit> r24, Shape r25, long r26, long r28, DialogProperties r30, Composer r31, int r32) {
        int r0 = r32 >> 3;
        AndroidAlertDialog_androidKt.m1919AlertDialogwqdebIU(r19, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(r22, r20), r31, 54), r21, r23, r24, r25, r26, r28, r30, r31, ((((((((r32 & 14) | 48) | (r32 & 896)) | (r0 & 7168)) | (57344 & r0)) | (458752 & r0)) | (3670016 & r0)) | (29360128 & r0)) | (r0 & 234881024), 0);
    }
}
