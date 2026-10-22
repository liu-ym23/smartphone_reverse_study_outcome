package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a·\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u009f\u0001\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001aQ\u0010\u001a\u001a\u00020\u00012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"TimePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "title", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "modeToggleButton", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "TimePickerDialog-FItCLgY", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TimePickerDialogLayout", "TimePickerDialogLayout-3csKH6Y", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TimePickerCustomLayout", "actions", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TimePickerDialogKt {
    private static final Unit TimePickerCustomLayout$lambda$3(Function2 r0, Function2 r1, Function3 r2, int r3, Composer r4, int r5) {
        TimePickerCustomLayout(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TimePickerDialogLayout_3csKH6Y$lambda$1(Function2 r13, Function2 r14, Modifier r15, Function2 r16, Function2 r17, Shape r18, long r19, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m3395TimePickerDialogLayout3csKH6Y(r13, r14, r15, r16, r17, r18, r19, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit TimePickerDialog_FItCLgY$lambda$0(Function0 r15, Function2 r16, Function2 r17, Modifier r18, DialogProperties r19, Function2 r20, Function2 r21, Shape r22, long r23, Function3 r25, int r26, int r27, Composer r28, int r29) {
        m3394TimePickerDialogFItCLgY(r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Function2 r1, Modifier r2, Function2 r3, Function2 r4, Shape r5, long r6, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return TimePickerDialogLayout_3csKH6Y$lambda$1(r0, r1, r2, r3, r4, r5, r6, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit b(Function2 r0, Function2 r1, Function3 r2, int r3, Composer r4, int r5) {
        return TimePickerCustomLayout$lambda$3(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit c(Function0 r0, Function2 r1, Function2 r2, Modifier r3, DialogProperties r4, Function2 r5, Function2 r6, Shape r7, long r8, Function3 r10, int r11, int r12, Composer r13, int r14) {
        return TimePickerDialog_FItCLgY$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14);
    }

    public static final void TimePickerCustomLayout(final Function2<? super Composer, ? super Integer, Unit> r8, final Function2<? super Composer, ? super Integer, Unit> r9, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(-493479138);
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
    L52:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L56;
        r14.updateScope(new ku(r8, r9, r10, r12));
        return;
    L56:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-493479138, r1, -1, "androidx.compose.material3.TimePickerCustomLayout (TimePickerDialog.kt:130)");
    L33:
        ComposableLambda r0 = ComposableLambdaKt.rememberComposableLambda(468305759, true, new TimePickerDialogKt$TimePickerCustomLayout$content$1(r10, r8, r9), r13, 54);
        Object r5 = r13.rememberedValue();
        if (r5 != Composer.Companion.getEmpty()) goto L36;
        r5 = TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1.INSTANCE;
        r13.updateRememberedValue(r5);
    L36:
        MeasurePolicy r6 = (MeasurePolicy) r5;
        Modifier.Companion r7 = Modifier.Companion;
        int r15 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r16 = r13.getCurrentCompositionLocalMap();
        Modifier r17 = ComposedModifierKt.materializeModifier(r13, r7);
        ComposeUiNode.Companion r18 = ComposeUiNode.Companion;
        Function0 r19 = r18.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L39;
        ComposablesKt.invalidApplier();
    L39:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L42;
        r13.createNode(r19);
    L43:
        Composer r20 = Updater.constructor-impl(r13);
        Updater.set-impl(r20, r6, r18.getSetMeasurePolicy());
        Updater.set-impl(r20, r16, r18.getSetResolvedCompositionLocals());
        Function2 r21 = r18.getSetCompositeKeyHash();
        if (r20.getInserting() == false) goto L46;
    L47:
        r20.updateRememberedValue(Integer.valueOf(r15));
        r20.apply(Integer.valueOf(r15), r21);
    L48:
        Updater.set-impl(r20, r17, r18.getSetModifier());
        r0.invoke(r13, 6);
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L52;
        ComposerKt.traceEventEnd();
        goto L52
    L46:
        if (Intrinsics.areEqual(r20.rememberedValue(), Integer.valueOf(r15)) == true) goto L48;
    L42:
        r13.useNode();
        goto L43
    L27:
        r4 = false;
        goto L29
    L5:
        if (r13.changedInstance(r8) == false) goto L7;
        int r22 = 4;
    L8:
        r1 = r22 | r12;
        goto L11
    L7:
        r22 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: TimePickerDialogLayout-3csKH6Y, reason: not valid java name */
    public static final void m3395TimePickerDialogLayout3csKH6Y(final Function2<? super Composer, ? super Integer, Unit> r28, final Function2<? super Composer, ? super Integer, Unit> r29, Modifier r30, Function2<? super Composer, ? super Integer, Unit> r31, Function2<? super Composer, ? super Integer, Unit> r32, Shape r33, long r34, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r1 = r37.startRestartGroup(-401873644);
        if ((r39 & 1) == 0) goto L6;
        int r3 = r38 | 6;
    L14:
        if ((r39 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r39 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r30;
    L35:
        int r7 = r39 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function2<? super Composer, ? super Integer, Unit> r8 = r31;
    L46:
        int r9 = r39 & 16;
        if (r9 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Function2<? super Composer, ? super Integer, Unit> r12 = r32;
    L58:
        if ((196608 & r38) == 0) goto L60;
        Shape r13 = r33;
    L69:
        if ((1572864 & r38) == 0) goto L71;
        long r14 = r34;
    L80:
        if ((r39 & 128) == 0) goto L83;
        r3 = r3 | 12582912;
    L91:
        if ((r3 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L128;
        r1.startDefaults();
        if ((r38 & 1) != 0) goto L99;
    L108:
        if (r5 == 0) goto L111;
        r6 = Modifier.Companion;
    L111:
        if (r7 == 0) goto L113;
        r8 = null;
    L113:
        if (r9 == 0) goto L116;
        r12 = null;
    L116:
        if ((r39 & 32) == 0) goto L119;
        r3 = r3 & (-458753);
        r13 = TimePickerDialogDefaults.INSTANCE.getShape(r1, 6);
    L119:
        if ((r39 & 64) != 0) goto L120;
    L107:
        final Function2<? super Composer, ? super Integer, Unit> r2 = r12;
        Shape r4 = r13;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L124;
        ComposerKt.traceEventStart(-401873644, r3, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:104)");
    L124:
        final Function2<? super Composer, ? super Integer, Unit> r35 = r8;
        int r23 = ((r3 >> 12) & 112) | 12607488;
        long r10 = r14;
        SurfaceKt.m3213SurfaceT9BRK9s(BackgroundKt.m341backgroundbw27NRU(r6, r14, r4), r4, 0, 0, DialogTokens.INSTANCE.getContainerElevation-D9Ej5fM(), MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new TimePickerDialogKt$TimePickerDialogLayout$1(r29, r36, r35, r2, r28), r1, 54), r1, r23, 108);
        if (ComposerKt.isTraceInProgress() == false) goto L127;
        ComposerKt.traceEventEnd();
    L127:
        final Function2<? super Composer, ? super Integer, Unit> r11 = r2;
        Modifier r25 = r6;
        final Shape r15 = r4;
        final Modifier r16 = r25;
        final Function2<? super Composer, ? super Integer, Unit> r17 = r8;
        final long r18 = r10;
    L129:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L133;
        r19.updateScope(new lu(r28, r29, r16, r17, r11, r15, r18, r36, r38, r39));
        return;
    L133:
        return;
    L120:
        r14 = TimePickerDialogDefaults.INSTANCE.getContainerColor(r1, 6);
    L106:
        r3 = r3 & (-3670017);
        goto L107
    L99:
        if (r1.getDefaultsInvalid() == true) goto L108;
        r1.skipToGroupEnd();
        if ((r39 & 32) == 0) goto L105;
        r3 = r3 & (-458753);
    L105:
        if ((r39 & 64) == 0) goto L107;
    L128:
        r1.skipToGroupEnd();
        r16 = r6;
        r17 = r8;
        r11 = r12;
        r15 = r13;
        r18 = r14;
        goto L129
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r38 & 12582912) != 0) goto L91;
        if (r1.changedInstance(r36) == false) goto L87;
        int r110 = 8388608;
    L88:
        r3 = r3 | r110;
        goto L91
    L87:
        r110 = 4194304;
        goto L88
    L71:
        if ((r39 & 64) != 0) goto L75;
        r14 = r34;
        if (r1.changed(r14) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
    L76:
        r111 = 524288;
        goto L77
    L75:
        r14 = r34;
        goto L76
    L60:
        if ((r39 & 32) != 0) goto L64;
        r13 = r33;
        if (r1.changed(r13) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
    L65:
        r112 = 65536;
        goto L66
    L64:
        r13 = r33;
        goto L65
    L50:
        if ((r38 & 24576) != 0) goto L56;
        r12 = r32;
        if (r1.changedInstance(r12) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
        goto L58
    L54:
        r113 = 8192;
        goto L55
    L39:
        if ((r38 & 3072) != 0) goto L45;
        r8 = r31;
        if (r1.changedInstance(r8) == false) goto L43;
        int r20 = 2048;
    L44:
        r3 = r3 | r20;
        goto L46
    L43:
        r20 = 1024;
        goto L44
    L28:
        if ((r38 & 384) != 0) goto L34;
        r6 = r30;
        if (r1.changed(r6) == false) goto L32;
        int r21 = 256;
    L33:
        r3 = r3 | r21;
        goto L35
    L32:
        r21 = 128;
        goto L33
    L17:
        if ((r38 & 48) != 0) goto L24;
        if (r1.changedInstance(r29) == false) goto L21;
        int r22 = 32;
    L22:
        r3 = r3 | r22;
        goto L24
    L21:
        r22 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r3 = r38;
        goto L14
    L8:
        if (r1.changedInstance(r28) == false) goto L10;
        int r24 = 4;
    L11:
        r3 = r24 | r38;
        goto L14
    L10:
        r24 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: TimePickerDialog-FItCLgY, reason: not valid java name */
    public static final void m3394TimePickerDialogFItCLgY(final Function0<Unit> r26, final Function2<? super Composer, ? super Integer, Unit> r27, final Function2<? super Composer, ? super Integer, Unit> r28, Modifier r29, DialogProperties r30, Function2<? super Composer, ? super Integer, Unit> r31, Function2<? super Composer, ? super Integer, Unit> r32, Shape r33, long r34, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r1 = r37.startRestartGroup(951250327);
        if ((r39 & 1) == 0) goto L6;
        int r3 = r38 | 6;
    L14:
        if ((r39 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r39 & 4) == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r6 = r39 & 8;
        if (r6 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Modifier r7 = r29;
    L46:
        int r8 = r39 & 16;
        if (r8 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        DialogProperties r9 = r30;
    L57:
        int r10 = r39 & 32;
        if (r10 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        Function2<? super Composer, ? super Integer, Unit> r11 = r31;
    L68:
        int r14 = r39 & 64;
        if (r14 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        Function2<? super Composer, ? super Integer, Unit> r15 = r32;
    L80:
        if ((r38 & 12582912) != 0) goto L91;
        if ((r39 & 128) != 0) goto L87;
        if (r1.changed(r33) == false) goto L87;
        int r17 = 8388608;
    L88:
        r3 = r3 | r17;
    L87:
        r17 = 4194304;
    L91:
        if ((r38 & 100663296) != 0) goto L101;
        if ((r39 & 256) == 0) goto L95;
    L97:
        int r0 = 33554432;
    L98:
        r3 = r3 | r0;
        goto L101
    L95:
        if (r1.changed(r34) == false) goto L97;
        r0 = 67108864;
    L101:
        if ((r39 & 512) == 0) goto L104;
        r3 = r3 | 805306368;
    L112:
        if ((r3 & 306783379) == 306783378) goto L114;
        boolean r2 = true;
    L116:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L155;
        r1.startDefaults();
        if ((r38 & 1) != 0) goto L120;
    L130:
        if (r6 == 0) goto L132;
        r7 = Modifier.Companion;
    L132:
        if (r8 == 0) goto L135;
        r9 = new DialogProperties(false, false, false, 3, null);
    L135:
        if (r10 == 0) goto L137;
        r11 = null;
    L137:
        if (r14 == 0) goto L140;
        r15 = null;
    L140:
        if ((r39 & 128) == 0) goto L142;
        Shape r4 = TimePickerDialogDefaults.INSTANCE.getShape(r1, 6);
        r3 = r3 & (-29360129);
    L144:
        if ((r39 & 256) == 0) goto L146;
        long r5 = TimePickerDialogDefaults.INSTANCE.getContainerColor(r1, 6);
        r3 = r3 & (-234881025);
    L147:
        Shape r12 = r4;
    L129:
        final Function2<? super Composer, ? super Integer, Unit> r13 = r15;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L151;
        ComposerKt.traceEventStart(951250327, r3, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:79)");
    L151:
        final Modifier r18 = r7;
        final Function2<? super Composer, ? super Integer, Unit> r19 = r11;
        final Shape r20 = r12;
        final long r21 = r5;
        DialogProperties r35 = r9;
        AndroidDialog_androidKt.Dialog(r26, r35, ComposableLambdaKt.rememberComposableLambda(296331566, true, new TimePickerDialogKt$TimePickerDialog$1(r27, r28, r18, r19, r13, r20, r21, r36), r1, 54), r1, ((r3 >> 9) & 112) | ((r3 & 14) | 384), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L154;
        ComposerKt.traceEventEnd();
    L154:
        final Shape r16 = r12;
        final Modifier r22 = r7;
        final Function2<? super Composer, ? super Integer, Unit> r23 = r13;
        long r24 = r5;
        final DialogProperties r25 = r9;
        final long r40 = r24;
        final Function2<? super Composer, ? super Integer, Unit> r41 = r11;
    L156:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L160;
        r110.updateScope(new mu(r26, r27, r28, r22, r25, r41, r23, r16, r40, r36, r38, r39));
        return;
    L160:
        return;
    L146:
        r5 = r34;
        goto L147
    L142:
        r4 = r33;
        goto L144
    L120:
        if (r1.getDefaultsInvalid() == true) goto L130;
        r1.skipToGroupEnd();
        if ((r39 & 128) == 0) goto L126;
        r3 = r3 & (-29360129);
    L126:
        if ((r39 & 256) == 0) goto L128;
        r3 = r3 & (-234881025);
    L128:
        r12 = r33;
        r5 = r34;
        goto L129
    L155:
        r1.skipToGroupEnd();
        r16 = r33;
        r22 = r7;
        r25 = r9;
        r41 = r11;
        r23 = r15;
        r40 = r34;
        goto L156
    L114:
        r2 = false;
        goto L116
    L104:
        if ((r38 & 805306368) != 0) goto L112;
        if (r1.changedInstance(r36) == false) goto L108;
        int r111 = 536870912;
    L109:
        r3 = r3 | r111;
        goto L112
    L108:
        r111 = 268435456;
        goto L109
    L72:
        if ((1572864 & r38) != 0) goto L78;
        r15 = r32;
        if (r1.changedInstance(r15) == false) goto L76;
        int r112 = 1048576;
    L77:
        r3 = r3 | r112;
        goto L80
    L76:
        r112 = 524288;
        goto L77
    L61:
        if ((196608 & r38) != 0) goto L67;
        r11 = r31;
        if (r1.changedInstance(r11) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
        goto L68
    L65:
        r113 = 65536;
        goto L66
    L50:
        if ((r38 & 24576) != 0) goto L56;
        r9 = r30;
        if (r1.changed(r9) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
        goto L57
    L54:
        r114 = 8192;
        goto L55
    L39:
        if ((r38 & 3072) != 0) goto L45;
        r7 = r29;
        if (r1.changed(r7) == false) goto L43;
        int r42 = 2048;
    L44:
        r3 = r3 | r42;
        goto L46
    L43:
        r42 = 1024;
        goto L44
    L28:
        if ((r38 & 384) != 0) goto L35;
        if (r1.changedInstance(r28) == false) goto L32;
        int r43 = 256;
    L33:
        r3 = r3 | r43;
        goto L35
    L32:
        r43 = 128;
        goto L33
    L17:
        if ((r38 & 48) != 0) goto L25;
        if (r1.changedInstance(r27) == false) goto L21;
        int r44 = 32;
    L22:
        r3 = r3 | r44;
        goto L25
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r3 = r38;
        goto L14
    L8:
        if (r1.changedInstance(r26) == false) goto L10;
        int r45 = 4;
    L11:
        r3 = r45 | r38;
        goto L14
    L10:
        r45 = 2;
        goto L11
    }
}
