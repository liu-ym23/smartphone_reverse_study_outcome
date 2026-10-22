package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aB\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001aB\u0010\u000b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001aÄ\u0001\u0010\f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a£\u0001\u0010\u001d\u001a\u00020\u00012\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0001¢\u0006\u0004\b \u0010!\u001a2\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001a2\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0001¢\u0006\u0004\b%\u0010&\"\u0016\u0010'\u001a\u00020\u001aX\u0080\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)\"\u0016\u0010+\u001a\u00020\u001aX\u0080\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b,\u0010)\"\u0010\u0010-\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010*\"\u0010\u0010.\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010*\"\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020605X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u00069"}, d2 = {"BasicAlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AlertDialog", "AlertDialogImpl", "confirmButton", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "AlertDialogImpl-wrnwzgE", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "AlertDialogContent", "buttons", "buttonContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DialogMinWidth", "getDialogMinWidth", "()F", "F", "DialogMaxWidth", "getDialogMaxWidth", "ButtonsMainAxisSpacing", "ButtonsCrossAxisSpacing", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TitlePadding", "TextPadding", "LocalBasicAlertDialogOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/BasicAlertDialogOverride;", "getLocalBasicAlertDialogOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AlertDialogKt {
    private static final float ButtonsCrossAxisSpacing = 0.0f;
    private static final float ButtonsMainAxisSpacing = 0.0f;
    private static final float DialogMaxWidth = 0.0f;
    private static final float DialogMinWidth = 0.0f;
    private static final PaddingValues DialogPadding = null;
    private static final PaddingValues IconPadding = null;
    private static final ProvidableCompositionLocal<BasicAlertDialogOverride> LocalBasicAlertDialogOverride = null;
    private static final PaddingValues TextPadding = null;
    private static final PaddingValues TitlePadding = null;

    private static final Unit AlertDialog$lambda$2(Function0 r7, Modifier r8, DialogProperties r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        AlertDialog(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit AlertDialogContent_4hvqGtA$lambda$4(Function2 r21, Modifier r22, Function2 r23, Function2 r24, Function2 r25, Shape r26, long r27, float r29, long r30, long r32, long r34, long r36, int r38, int r39, int r40, Composer r41, int r42) {
        m2281AlertDialogContent4hvqGtA(r21, r22, r23, r24, r25, r26, r27, r29, r30, r32, r34, r36, r41, RecomposeScopeImplKt.updateChangedFlags(r38 | 1), RecomposeScopeImplKt.updateChangedFlags(r39), r40);
        return Unit.INSTANCE;
    }

    private static final Unit AlertDialogFlowRow_ixp7dh8$lambda$6(float r0, float r1, Function2 r2, int r3, Composer r4, int r5) {
        m2282AlertDialogFlowRowixp7dh8(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit AlertDialogImpl_wrnwzgE$lambda$3(Function0 r21, Function2 r22, Modifier r23, Function2 r24, Function2 r25, Function2 r26, Function2 r27, Shape r28, long r29, long r31, long r33, long r35, float r37, DialogProperties r38, int r39, int r40, Composer r41, int r42) {
        m2283AlertDialogImplwrnwzgE(r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r33, r35, r37, r38, r41, RecomposeScopeImplKt.updateChangedFlags(r39 | 1), RecomposeScopeImplKt.updateChangedFlags(r40));
        return Unit.INSTANCE;
    }

    private static final Unit BasicAlertDialog$lambda$1(Function0 r7, Modifier r8, DialogProperties r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        BasicAlertDialog(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function0 r0, Modifier r1, DialogProperties r2, Function2 r3, int r4, int r5, Composer r6, int r7) {
        return AlertDialog$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ BasicAlertDialogOverride b() {
        return LocalBasicAlertDialogOverride$lambda$7();
    }

    public static /* synthetic */ Unit c(float r0, float r1, Function2 r2, int r3, Composer r4, int r5) {
        return AlertDialogFlowRow_ixp7dh8$lambda$6(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit d(Function0 r0, Modifier r1, DialogProperties r2, Function2 r3, int r4, int r5, Composer r6, int r7) {
        return BasicAlertDialog$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit e(Function2 r1, Modifier r2, Function2 r3, Function2 r4, Function2 r5, Shape r6, long r7, float r9, long r10, long r12, long r14, long r16, int r18, int r19, int r20, Composer r21, int r22) {
        return AlertDialogContent_4hvqGtA$lambda$4(r1, r2, r3, r4, r5, r6, r7, r9, r10, r12, r14, r16, r18, r19, r20, r21, r22);
    }

    public static /* synthetic */ Unit f(Function0 r1, Function2 r2, Modifier r3, Function2 r4, Function2 r5, Function2 r6, Function2 r7, Shape r8, long r9, long r11, long r13, long r15, float r17, DialogProperties r18, int r19, int r20, Composer r21, int r22) {
        return AlertDialogImpl_wrnwzgE$lambda$3(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r15, r17, r18, r19, r20, r21, r22);
    }

    static {
        DialogMinWidth = Dp.constructor-impl(280);
        DialogMaxWidth = Dp.constructor-impl(560);
        ButtonsMainAxisSpacing = Dp.constructor-impl(8);
        ButtonsCrossAxisSpacing = Dp.constructor-impl(12);
        float r0 = 24;
        DialogPadding = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(r0));
        float r1 = 16;
        IconPadding = PaddingKt.m957PaddingValuesa9UjIt4$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Dp.constructor-impl(r1), 7, null);
        TitlePadding = PaddingKt.m957PaddingValuesa9UjIt4$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Dp.constructor-impl(r1), 7, null);
        TextPadding = PaddingKt.m957PaddingValuesa9UjIt4$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Dp.constructor-impl(r0), 7, null);
        LocalBasicAlertDialogOverride = CompositionLocalKt.compositionLocalOf$default(null, new e(), 1, null);
    }

    private static final BasicAlertDialogOverride LocalBasicAlertDialogOverride$lambda$7() {
        return DefaultBasicAlertDialogOverride.INSTANCE;
    }

    public static final /* synthetic */ float access$getButtonsCrossAxisSpacing$p() {
        return ButtonsCrossAxisSpacing;
    }

    public static final /* synthetic */ float access$getButtonsMainAxisSpacing$p() {
        return ButtonsMainAxisSpacing;
    }

    public static final /* synthetic */ PaddingValues access$getDialogPadding$p() {
        return DialogPadding;
    }

    public static final /* synthetic */ PaddingValues access$getIconPadding$p() {
        return IconPadding;
    }

    public static final /* synthetic */ PaddingValues access$getTextPadding$p() {
        return TextPadding;
    }

    public static final /* synthetic */ PaddingValues access$getTitlePadding$p() {
        return TitlePadding;
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }

    public static final ProvidableCompositionLocal<BasicAlertDialogOverride> getLocalBasicAlertDialogOverride() {
        return LocalBasicAlertDialogOverride;
    }

    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m2282AlertDialogFlowRowixp7dh8(final float r8, final float r9, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(-917637668);
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
        r14.updateScope(new d(r8, r9, r10, r12));
        return;
    L66:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-917637668, r1, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:379)");
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

    @Deprecated(message = "Use BasicAlertDialog instead", replaceWith = @ReplaceWith(expression = "BasicAlertDialog(onDismissRequest, modifier, properties, content)", imports = {}))
    public static final void AlertDialog(final Function0<Unit> r20, Modifier r21, DialogProperties r22, final Function2<? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25, final int r26) {
        Composer r1 = r24.startRestartGroup(402506956);
        if ((r26 & 1) == 0) goto L6;
        int r3 = r25 | 6;
    L13:
        int r4 = r26 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r6 = r21;
    L24:
        int r7 = r26 & 4;
        if (r7 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        DialogProperties r8 = r22;
    L36:
        if ((r26 & 8) == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        if ((r3 & 1171) == 1170) goto L48;
        boolean r9 = true;
    L50:
        if (r1.shouldExecute(r9, r3 & 1) == false) goto L64;
        if (r4 == 0) goto L53;
        Modifier r5 = Modifier.Companion;
    L54:
        if (r7 == 0) goto L56;
        DialogProperties r14 = new DialogProperties(false, false, false, 7, null);
    L58:
        if (ComposerKt.isTraceInProgress() == false) goto L60;
        ComposerKt.traceEventStart(402506956, r3, -1, "androidx.compose.material3.AlertDialog (AlertDialog.kt:215)");
    L60:
        Modifier r10 = r5;
        DialogProperties r11 = r14;
        BasicAlertDialog(r20, r10, r11, r23, r1, (((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventEnd();
    L63:
        final DialogProperties r12 = r14;
    L65:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L69;
        final Modifier r2 = r5;
        r13.updateScope(new a(r20, r2, r12, r23, r25, r26));
        return;
    L69:
        return;
    L56:
        r14 = r8;
        goto L58
    L53:
        r5 = r6;
        goto L54
    L64:
        r1.skipToGroupEnd();
        r5 = r6;
        r12 = r8;
        goto L65
    L48:
        r9 = false;
        goto L50
    L39:
        if ((r25 & 3072) != 0) goto L46;
        if (r1.changedInstance(r23) == false) goto L43;
        int r15 = 2048;
    L44:
        r3 = r3 | r15;
        goto L46
    L43:
        r15 = 1024;
        goto L44
    L28:
        if ((r25 & 384) != 0) goto L34;
        r8 = r22;
        if (r1.changed(r8) == false) goto L32;
        int r16 = 256;
    L33:
        r3 = r3 | r16;
        goto L36
    L32:
        r16 = 128;
        goto L33
    L17:
        if ((r25 & 48) != 0) goto L23;
        r6 = r21;
        if (r1.changed(r6) == false) goto L21;
        int r17 = 32;
    L22:
        r3 = r3 | r17;
        goto L24
    L21:
        r17 = 16;
        goto L22
    L6:
        if ((r25 & 6) == 0) goto L8;
        r3 = r25;
        goto L13
    L8:
        if (r1.changedInstance(r20) == false) goto L10;
        int r18 = 4;
    L11:
        r3 = r18 | r25;
        goto L13
    L10:
        r18 = 2;
        goto L11
    }

    public static final void BasicAlertDialog(final Function0<Unit> r19, Modifier r20, DialogProperties r21, final Function2<? super Composer, ? super Integer, Unit> r22, Composer r23, final int r24, final int r25) {
        Composer r2 = r23.startRestartGroup(24925658);
        if ((r25 & 1) == 0) goto L6;
        int r3 = r24 | 6;
    L13:
        int r6 = r25 & 2;
        if (r6 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r7 = r20;
    L24:
        int r8 = r25 & 4;
        if (r8 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        DialogProperties r9 = r21;
    L36:
        if ((r25 & 8) == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        if ((r3 & 1171) == 1170) goto L48;
        boolean r10 = true;
    L50:
        if (r2.shouldExecute(r10, r3 & 1) == false) goto L62;
        if (r6 == 0) goto L53;
        Modifier r11 = Modifier.Companion;
    L54:
        if (r8 == 0) goto L57;
        r9 = new DialogProperties(false, false, false, 7, null);
    L57:
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventStart(24925658, r3, -1, "androidx.compose.material3.BasicAlertDialog (AlertDialog.kt:143)");
    L59:
        ((BasicAlertDialogOverride) r2.consume(LocalBasicAlertDialogOverride)).BasicAlertDialog(new BasicAlertDialogOverrideScope(r19, r11, r9, r22), r2, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventEnd();
    L63:
        final DialogProperties r4 = r9;
        ScopeUpdateScope r12 = r2.endRestartGroup();
        if (r12 == null) goto L67;
        final Modifier r5 = r11;
        r12.updateScope(new c(r19, r5, r4, r22, r24, r25));
        return;
    L67:
        return;
    L53:
        r11 = r7;
        goto L54
    L62:
        r2.skipToGroupEnd();
        r11 = r7;
        goto L63
    L48:
        r10 = false;
        goto L50
    L39:
        if ((r24 & 3072) != 0) goto L46;
        if (r2.changedInstance(r22) == false) goto L43;
        int r13 = 2048;
    L44:
        r3 = r3 | r13;
        goto L46
    L43:
        r13 = 1024;
        goto L44
    L28:
        if ((r24 & 384) != 0) goto L34;
        r9 = r21;
        if (r2.changed(r9) == false) goto L32;
        int r14 = 256;
    L33:
        r3 = r3 | r14;
        goto L36
    L32:
        r14 = 128;
        goto L33
    L17:
        if ((r24 & 48) != 0) goto L23;
        r7 = r20;
        if (r2.changed(r7) == false) goto L21;
        int r15 = 32;
    L22:
        r3 = r3 | r15;
        goto L24
    L21:
        r15 = 16;
        goto L22
    L6:
        if ((r24 & 6) == 0) goto L8;
        r3 = r24;
        goto L13
    L8:
        if (r2.changedInstance(r19) == false) goto L10;
        int r16 = 4;
    L11:
        r3 = r16 | r24;
        goto L13
    L10:
        r16 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    public static final void m2281AlertDialogContent4hvqGtA(final Function2<? super Composer, ? super Integer, Unit> r35, Modifier r36, final Function2<? super Composer, ? super Integer, Unit> r37, final Function2<? super Composer, ? super Integer, Unit> r38, final Function2<? super Composer, ? super Integer, Unit> r39, final Shape r40, final long r41, final float r43, final long r44, final long r46, final long r48, final long r50, Composer r52, final int r53, final int r54, final int r55) {
        Composer r13 = r52.startRestartGroup(1378716401);
        if ((r55 & 1) == 0) goto L6;
        int r1 = r53 | 6;
    L13:
        int r4 = r55 & 2;
        if (r4 == 0) goto L17;
        r1 = r1 | 48;
    L23:
        Modifier r7 = r36;
    L25:
        if ((r55 & 4) == 0) goto L28;
        r1 = r1 | 384;
    L35:
        if ((r55 & 8) == 0) goto L38;
        r1 = r1 | 3072;
    L45:
        if ((r55 & 16) == 0) goto L48;
        r1 = r1 | 24576;
    L55:
        if ((r55 & 32) == 0) goto L58;
        r1 = r1 | 196608;
    L66:
        if ((r55 & 64) == 0) goto L69;
        r1 = r1 | 1572864;
    L76:
        if ((r55 & 128) == 0) goto L79;
        r1 = r1 | 12582912;
    L87:
        if ((r55 & 256) == 0) goto L90;
        r1 = r1 | 100663296;
    L97:
        if ((r55 & 512) == 0) goto L100;
        r1 = r1 | 805306368;
    L107:
        if ((r55 & 1024) == 0) goto L110;
        int r3 = r54 | 6;
    L118:
        if ((r55 & 2048) == 0) goto L121;
        r3 = r3 | 48;
    L128:
        if ((306783379 & r1) == 306783378) goto L130;
    L133:
        boolean r5 = true;
    L135:
        if (r13.shouldExecute(r5, r1 & 1) == false) goto L146;
        if (r4 == 0) goto L138;
        Modifier r30 = Modifier.Companion;
    L140:
        if (ComposerKt.isTraceInProgress() == false) goto L142;
        ComposerKt.traceEventStart(1378716401, r1, r3, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:308)");
    L142:
        ComposableLambda r0 = ComposableLambdaKt.rememberComposableLambda(-652798794, true, new AlertDialogKt$AlertDialogContent$1(r37, r38, r39, r46, r48, r50, r44, r35), r13, 54);
        int r6 = r1 >> 12;
        int r16 = (((((r1 >> 3) & 14) | 12582912) | (r6 & 112)) | (r6 & 896)) | ((r1 >> 9) & 57344);
        Composer r2 = r13;
        SurfaceKt.m3213SurfaceT9BRK9s(r30, r40, r41, 0, r43, MenuKt.ClosedAlphaTarget, null, r0, r13, r16, 104);
        if (ComposerKt.isTraceInProgress() == false) goto L145;
        ComposerKt.traceEventEnd();
    L145:
        final Modifier r8 = r30;
    L147:
        ScopeUpdateScope r12 = r2.endRestartGroup();
        if (r12 == null) goto L151;
        r12.updateScope(new f(r35, r8, r37, r38, r39, r40, r41, r43, r44, r46, r48, r50, r53, r54, r55));
        return;
    L151:
        return;
    L138:
        r30 = r7;
        goto L140
    L146:
        r2 = r13;
        r2.skipToGroupEnd();
        r8 = r7;
        goto L147
    L130:
        if ((r3 & 19) != 18) goto L133;
        r5 = false;
        goto L135
    L121:
        if ((r54 & 48) != 0) goto L128;
        if (r13.changed(r50) == false) goto L125;
        int r9 = 32;
    L126:
        r3 = r3 | r9;
        goto L128
    L125:
        r9 = 16;
        goto L126
    L110:
        if ((r54 & 6) == 0) goto L112;
        r3 = r54;
        goto L118
    L112:
        if (r13.changed(r48) == false) goto L114;
        int r17 = 4;
    L115:
        r3 = r54 | r17;
        goto L118
    L114:
        r17 = 2;
        goto L115
    L100:
        if ((r53 & 805306368) != 0) goto L107;
        if (r13.changed(r46) == false) goto L104;
        int r10 = 536870912;
    L105:
        r1 = r1 | r10;
        goto L107
    L104:
        r10 = 268435456;
        goto L105
    L90:
        if ((r53 & 100663296) != 0) goto L97;
        if (r13.changed(r44) == false) goto L94;
        int r11 = 67108864;
    L95:
        r1 = r1 | r11;
        goto L97
    L94:
        r11 = 33554432;
        goto L95
    L79:
        if ((r53 & 12582912) != 0) goto L87;
        if (r13.changed(r43) == false) goto L83;
        int r18 = 8388608;
    L84:
        r1 = r1 | r18;
        goto L87
    L83:
        r18 = 4194304;
        goto L84
    L69:
        if ((r53 & 1572864) != 0) goto L76;
        if (r13.changed(r41) == false) goto L73;
        int r19 = 1048576;
    L74:
        r1 = r1 | r19;
        goto L76
    L73:
        r19 = 524288;
        goto L74
    L58:
        if ((r53 & 196608) != 0) goto L66;
        if (r13.changed(r40) == false) goto L62;
        int r110 = 131072;
    L63:
        r1 = r1 | r110;
        goto L66
    L62:
        r110 = 65536;
        goto L63
    L48:
        if ((r53 & 24576) != 0) goto L55;
        if (r13.changedInstance(r39) == false) goto L52;
        int r14 = 16384;
    L53:
        r1 = r1 | r14;
        goto L55
    L52:
        r14 = 8192;
        goto L53
    L38:
        if ((r53 & 3072) != 0) goto L45;
        if (r13.changedInstance(r38) == false) goto L42;
        int r15 = 2048;
    L43:
        r1 = r1 | r15;
        goto L45
    L42:
        r15 = 1024;
        goto L43
    L28:
        if ((r53 & 384) != 0) goto L35;
        if (r13.changedInstance(r37) == false) goto L32;
        int r20 = 256;
    L33:
        r1 = r1 | r20;
        goto L35
    L32:
        r20 = 128;
        goto L33
    L17:
        if ((r53 & 48) != 0) goto L23;
        r7 = r36;
        if (r13.changed(r7) == false) goto L21;
        int r21 = 32;
    L22:
        r1 = r1 | r21;
        goto L25
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r53 & 6) == 0) goto L8;
        r1 = r53;
        goto L13
    L8:
        if (r13.changedInstance(r35) == false) goto L10;
        int r22 = 4;
    L11:
        r1 = r22 | r53;
        goto L13
    L10:
        r22 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: AlertDialogImpl-wrnwzgE, reason: not valid java name */
    public static final void m2283AlertDialogImplwrnwzgE(final Function0<Unit> r34, final Function2<? super Composer, ? super Integer, Unit> r35, final Modifier r36, final Function2<? super Composer, ? super Integer, Unit> r37, final Function2<? super Composer, ? super Integer, Unit> r38, final Function2<? super Composer, ? super Integer, Unit> r39, final Function2<? super Composer, ? super Integer, Unit> r40, final Shape r41, final long r42, final long r44, final long r46, final long r48, final float r50, final DialogProperties r51, Composer r52, final int r53, final int r54) {
        Composer r8 = r52.startRestartGroup(-867616355);
        if ((r53 & 6) == 0) goto L5;
        int r1 = r53;
    L10:
        int r5 = 32;
        if ((r53 & 48) != 0) goto L18;
        if (r8.changedInstance(r35) == false) goto L15;
        int r4 = 32;
    L16:
        r1 = r1 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r53 & 384) == 0) goto L20;
    L24:
        int r16 = 1024;
        if ((r53 & 3072) != 0) goto L33;
        if (r8.changedInstance(r37) == false) goto L29;
        int r17 = 2048;
    L30:
        r1 = r1 | r17;
        goto L33
    L29:
        r17 = 1024;
    L33:
        if ((r53 & 24576) != 0) goto L41;
        if (r8.changedInstance(r38) == false) goto L37;
        int r18 = 16384;
    L38:
        r1 = r1 | r18;
        goto L41
    L37:
        r18 = 8192;
    L41:
        if ((r53 & 196608) != 0) goto L48;
        if (r8.changedInstance(r39) == false) goto L45;
        int r19 = 131072;
    L46:
        r1 = r1 | r19;
        goto L48
    L45:
        r19 = 65536;
    L48:
        if ((r53 & 1572864) != 0) goto L55;
        if (r8.changedInstance(r40) == false) goto L52;
        int r110 = 1048576;
    L53:
        r1 = r1 | r110;
        goto L55
    L52:
        r110 = 524288;
    L55:
        if ((r53 & 12582912) == 0) goto L57;
    L61:
        int r21 = r1;
        if ((r53 & 100663296) != 0) goto L69;
        if (r8.changed(r42) == false) goto L66;
        int r22 = 67108864;
    L67:
        r21 = r21 | r22;
        goto L69
    L66:
        r22 = 33554432;
    L69:
        if ((r53 & 805306368) == 0) goto L71;
    L75:
        int r3 = r21;
        if ((r54 & 6) == 0) goto L78;
        int r23 = r54;
    L84:
        if ((r54 & 48) != 0) goto L91;
        if (r8.changed(r48) == true) goto L89;
        r5 = 16;
    L89:
        r23 = r23 | r5;
    L91:
        if ((r54 & 384) != 0) goto L98;
        if (r8.changed(r50) == false) goto L95;
        int r111 = 256;
    L96:
        r23 = r23 | r111;
        goto L98
    L95:
        r111 = 128;
    L98:
        if ((r54 & 3072) != 0) goto L104;
        if (r8.changed(r51) == false) goto L102;
        r16 = 2048;
    L102:
        r23 = r23 | r16;
    L104:
        int r0 = r23;
        if ((306783379 & r3) == 306783378) goto L107;
    L110:
        boolean r2 = true;
    L112:
        if (r8.shouldExecute(r2, r3 & 1) == true) goto L114;
        r8.skipToGroupEnd();
    L120:
        ScopeUpdateScope r9 = r8.endRestartGroup();
        if (r9 == null) goto L124;
        r9.updateScope(new b(r34, r35, r36, r37, r38, r39, r40, r41, r42, r44, r46, r48, r50, r51, r53, r54));
        return;
    L124:
        return;
    L114:
        if (ComposerKt.isTraceInProgress() == false) goto L116;
        ComposerKt.traceEventStart(-867616355, r3, r0, "androidx.compose.material3.AlertDialogImpl (AlertDialog.kt:260)");
    L116:
        int r6 = (r0 >> 3) & 896;
        BasicAlertDialog(r34, r36, r51, ComposableLambdaKt.rememberComposableLambda(527420759, true, new AlertDialogKt$AlertDialogImpl$1(r38, r39, r40, r41, r42, r50, r44, r46, r48, r37, r35), r8, 54), r8, r6 | (((r3 & 14) | 3072) | ((r3 >> 3) & 112)), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
        goto L120
    L107:
        if ((r0 & 1171) != 1170) goto L110;
        r2 = false;
        goto L112
    L78:
        if (r8.changed(r46) == false) goto L80;
        int r24 = 4;
    L81:
        r23 = r54 | r24;
        goto L84
    L80:
        r24 = 2;
        goto L81
    L71:
        if (r8.changed(r44) == false) goto L73;
        int r25 = 536870912;
    L74:
        r21 = r21 | r25;
        goto L75
    L73:
        r25 = 268435456;
        goto L74
    L57:
        if (r8.changed(r41) == false) goto L59;
        int r20 = 8388608;
    L60:
        r1 = r1 | r20;
        goto L61
    L59:
        r20 = 4194304;
        goto L60
    L20:
        if (r8.changed(r36) == false) goto L22;
        int r7 = 256;
    L23:
        r1 = r1 | r7;
        goto L24
    L22:
        r7 = 128;
        goto L23
    L5:
        if (r8.changedInstance(r34) == false) goto L7;
        int r10 = 4;
    L8:
        r1 = r10 | r53;
        goto L10
    L7:
        r10 = 2;
        goto L8
    }
}
