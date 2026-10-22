package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0097\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0019\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001c"}, d2 = {"DatePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "colors", "Landroidx/compose/material3/DatePickerColors;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DatePickerDialog-GmEhDVc", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DialogButtonsPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DialogButtonsMainAxisSpacing", "F", "DialogButtonsCrossAxisSpacing", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DatePickerDialog_androidKt {
    private static final float DialogButtonsCrossAxisSpacing = 0.0f;
    private static final float DialogButtonsMainAxisSpacing = 0.0f;
    private static final PaddingValues DialogButtonsPadding = null;

    private static final Unit DatePickerDialog_GmEhDVc$lambda$0(Function0 r13, Function2 r14, Modifier r15, Function2 r16, Shape r17, float r18, DatePickerColors r19, DialogProperties r20, Function3 r21, int r22, int r23, Composer r24, int r25) {
        m2580DatePickerDialogGmEhDVc(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function0 r0, Function2 r1, Modifier r2, Function2 r3, Shape r4, float r5, DatePickerColors r6, DialogProperties r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        return DatePickerDialog_GmEhDVc$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    static {
        float r0 = 8;
        DialogButtonsPadding = PaddingKt.m957PaddingValuesa9UjIt4$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Dp.constructor-impl(6), Dp.constructor-impl(r0), 3, null);
        DialogButtonsMainAxisSpacing = Dp.constructor-impl(r0);
        DialogButtonsCrossAxisSpacing = Dp.constructor-impl(12);
    }

    public static final /* synthetic */ float access$getDialogButtonsCrossAxisSpacing$p() {
        return DialogButtonsCrossAxisSpacing;
    }

    public static final /* synthetic */ float access$getDialogButtonsMainAxisSpacing$p() {
        return DialogButtonsMainAxisSpacing;
    }

    public static final /* synthetic */ PaddingValues access$getDialogButtonsPadding$p() {
        return DialogButtonsPadding;
    }

    /* JADX INFO: renamed from: DatePickerDialog-GmEhDVc, reason: not valid java name */
    public static final void m2580DatePickerDialogGmEhDVc(final Function0<Unit> r24, final Function2<? super Composer, ? super Integer, Unit> r25, Modifier r26, Function2<? super Composer, ? super Integer, Unit> r27, Shape r28, float r29, DatePickerColors r30, DialogProperties r31, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        Composer r8 = r33.startRestartGroup(219718641);
        if ((r35 & 1) == 0) goto L6;
        int r1 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r35 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r35 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L46:
        if ((r34 & 24576) == 0) goto L48;
        Shape r6 = r28;
    L56:
        int r12 = r35 & 32;
        if (r12 == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        float r13 = r29;
    L68:
        if ((1572864 & r34) == 0) goto L70;
        DatePickerColors r14 = r30;
    L78:
        int r15 = r35 & 128;
        if (r15 == 0) goto L82;
        r1 = r1 | 12582912;
    L89:
        if ((r35 & 256) == 0) goto L92;
        r1 = r1 | 100663296;
    L100:
        if ((r1 & 38347923) == 38347922) goto L102;
        boolean r0 = true;
    L104:
        if (r8.shouldExecute(r0, r1 & 1) == false) goto L145;
        r8.startDefaults();
        if ((r34 & 1) != 0) goto L108;
    L117:
        if (r2 == 0) goto L119;
        Modifier r3 = Modifier.Companion;
    L120:
        if (r4 == 0) goto L122;
        Function2<? super Composer, ? super Integer, Unit> r5 = null;
    L124:
        if ((r35 & 16) == 0) goto L126;
        Shape r7 = DatePickerDefaults.INSTANCE.getShape(r8, 6);
        r1 = r1 & (-57345);
    L127:
        if (r12 == 0) goto L129;
        float r9 = DatePickerDefaults.INSTANCE.m2579getTonalElevationD9Ej5fM();
    L131:
        if ((r35 & 64) == 0) goto L133;
        DatePickerColors r10 = DatePickerDefaults.INSTANCE.colors(r8, 6);
        r1 = r1 & (-3670017);
    L134:
        if (r15 == 0) goto L136;
        DialogProperties r23 = new DialogProperties(false, false, false, 3, null);
    L137:
        Shape r20 = r7;
        DatePickerColors r22 = r10;
        float r21 = r9;
    L138:
        r8.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L141;
        ComposerKt.traceEventStart(219718641, r1, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:74)");
    L141:
        Modifier r11 = SizeKt.wrapContentHeight$default(r3, null, false, 3, null);
        final Shape r16 = r20;
        final DatePickerColors r17 = r22;
        final float r18 = r21;
        final Function2<? super Composer, ? super Integer, Unit> r19 = r5;
        ComposableLambda r36 = ComposableLambdaKt.rememberComposableLambda(1108953335, true, new DatePickerDialog_androidKt$DatePickerDialog$1(r16, r17, r18, r32, r19, r25), r8, 54);
        int r37 = ((r1 & 14) | 3072) | ((r1 >> 15) & 896);
        AlertDialogKt.BasicAlertDialog(r24, r11, r23, r36, r8, r37, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L144;
        ComposerKt.traceEventEnd();
    L144:
        final Modifier r38 = r3;
        final Function2<? super Composer, ? super Integer, Unit> r39 = r5;
        final Shape r40 = r20;
        final float r41 = r21;
        final DatePickerColors r42 = r22;
    L146:
        ScopeUpdateScope r110 = r8.endRestartGroup();
        if (r110 == null) goto L150;
        final DialogProperties r43 = r23;
        r110.updateScope(new w4(r24, r25, r38, r39, r40, r41, r42, r43, r32, r34, r35));
        return;
    L150:
        return;
    L136:
        r23 = r31;
        goto L137
    L133:
        r10 = r14;
        goto L134
    L129:
        r9 = r13;
        goto L131
    L126:
        r7 = r6;
        goto L127
    L122:
        r5 = r27;
        goto L124
    L119:
        r3 = r26;
        goto L120
    L108:
        if (r8.getDefaultsInvalid() == true) goto L117;
        r8.skipToGroupEnd();
        if ((r35 & 16) == 0) goto L114;
        r1 = r1 & (-57345);
    L114:
        if ((r35 & 64) == 0) goto L116;
        r1 = r1 & (-3670017);
    L116:
        r3 = r26;
        r5 = r27;
        r23 = r31;
        r20 = r6;
        r21 = r13;
        r22 = r14;
        goto L138
    L145:
        r8.skipToGroupEnd();
        r38 = r26;
        r39 = r27;
        r23 = r31;
        r40 = r6;
        r41 = r13;
        r42 = r14;
        goto L146
    L102:
        r0 = false;
        goto L104
    L92:
        if ((r34 & 100663296) != 0) goto L100;
        if (r8.changedInstance(r32) == false) goto L96;
        int r111 = 67108864;
    L97:
        r1 = r1 | r111;
        goto L100
    L96:
        r111 = 33554432;
        goto L97
    L82:
        if ((r34 & 12582912) != 0) goto L89;
        if (r8.changed(r31) == false) goto L86;
        int r112 = 8388608;
    L87:
        r1 = r1 | r112;
        goto L89
    L86:
        r112 = 4194304;
        goto L87
    L70:
        if ((r35 & 64) != 0) goto L74;
        r14 = r30;
        if (r8.changed(r14) == false) goto L75;
        int r113 = 1048576;
    L76:
        r1 = r1 | r113;
    L75:
        r113 = 524288;
        goto L76
    L74:
        r14 = r30;
        goto L75
    L60:
        if ((196608 & r34) != 0) goto L66;
        r13 = r29;
        if (r8.changed(r13) == false) goto L64;
        int r114 = 131072;
    L65:
        r1 = r1 | r114;
        goto L68
    L64:
        r114 = 65536;
        goto L65
    L48:
        if ((r35 & 16) != 0) goto L52;
        r6 = r28;
        if (r8.changed(r6) == false) goto L53;
        int r115 = 16384;
    L54:
        r1 = r1 | r115;
    L53:
        r115 = 8192;
        goto L54
    L52:
        r6 = r28;
        goto L53
    L38:
        if ((r34 & 3072) != 0) goto L46;
        if (r8.changedInstance(r27) == false) goto L42;
        int r44 = 2048;
    L43:
        r1 = r1 | r44;
        goto L46
    L42:
        r44 = 1024;
        goto L43
    L27:
        if ((r34 & 384) != 0) goto L34;
        if (r8.changed(r26) == false) goto L31;
        int r45 = 256;
    L32:
        r1 = r1 | r45;
        goto L34
    L31:
        r45 = 128;
        goto L32
    L17:
        if ((r34 & 48) != 0) goto L23;
        if (r8.changedInstance(r25) == false) goto L21;
        int r46 = 32;
    L22:
        r1 = r1 | r46;
        goto L23
    L21:
        r46 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r1 = r34;
        goto L14
    L8:
        if (r8.changedInstance(r24) == false) goto L10;
        int r47 = 4;
    L11:
        r1 = r47 | r34;
        goto L14
    L10:
        r47 = 2;
        goto L11
    }
}
