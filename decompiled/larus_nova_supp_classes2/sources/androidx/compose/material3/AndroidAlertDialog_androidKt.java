package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÜ\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt {
    private static final Unit AlertDialog_Oix01E0$lambda$0(Function0 r22, Function2 r23, Modifier r24, Function2 r25, Function2 r26, Function2 r27, Function2 r28, Shape r29, long r30, long r32, long r34, long r36, float r38, DialogProperties r39, int r40, int r41, int r42, Composer r43, int r44) {
        m2289AlertDialogOix01E0(r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r34, r36, r38, r39, r43, RecomposeScopeImplKt.updateChangedFlags(r40 | 1), RecomposeScopeImplKt.updateChangedFlags(r41), r42);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function0 r1, Function2 r2, Modifier r3, Function2 r4, Function2 r5, Function2 r6, Function2 r7, Shape r8, long r9, long r11, long r13, long r15, float r17, DialogProperties r18, int r19, int r20, int r21, Composer r22, int r23) {
        return AlertDialog_Oix01E0$lambda$0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r15, r17, r18, r19, r20, r21, r22, r23);
    }

    /* JADX INFO: renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    public static final void m2289AlertDialogOix01E0(final Function0<Unit> r47, final Function2<? super Composer, ? super Integer, Unit> r48, Modifier r49, Function2<? super Composer, ? super Integer, Unit> r50, Function2<? super Composer, ? super Integer, Unit> r51, Function2<? super Composer, ? super Integer, Unit> r52, Function2<? super Composer, ? super Integer, Unit> r53, Shape r54, long r55, long r57, long r59, long r61, float r63, DialogProperties r64, Composer r65, final int r66, final int r67, final int r68) {
        Composer r1 = r65.startRestartGroup(94478519);
        if ((r68 & 1) == 0) goto L6;
        int r5 = r66 | 6;
    L14:
        if ((r68 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r9 = r68 & 4;
        if (r9 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        Modifier r12 = r49;
    L35:
        int r16 = r68 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L39;
        r5 = r5 | 3072;
    L46:
        int r19 = r68 & 16;
        if (r19 == 0) goto L50;
        r5 = r5 | 24576;
    L57:
        int r21 = r68 & 32;
        if (r21 == 0) goto L60;
        r5 = r5 | 196608;
        Function2<? super Composer, ? super Integer, Unit> r7 = r52;
    L67:
        int r23 = r68 & 64;
        if (r23 == 0) goto L70;
        r5 = r5 | 1572864;
        Function2<? super Composer, ? super Integer, Unit> r8 = r53;
    L78:
        if ((r66 & 12582912) == 0) goto L80;
        Shape r10 = r54;
    L89:
        if ((r66 & 100663296) != 0) goto L99;
        if ((r68 & 256) == 0) goto L93;
    L95:
        int r11 = 33554432;
    L96:
        r5 = r5 | r11;
        goto L99
    L93:
        if (r1.changed(r55) == false) goto L95;
        r11 = 67108864;
    L99:
        if ((805306368 & r66) != 0) goto L109;
        if ((r68 & 512) == 0) goto L103;
    L105:
        int r13 = 268435456;
    L106:
        r5 = r5 | r13;
        goto L109
    L103:
        if (r1.changed(r57) == false) goto L105;
        r13 = 536870912;
    L109:
        if ((r67 & 6) == 0) goto L111;
        int r14 = r67;
    L119:
        if ((r67 & 48) != 0) goto L128;
        if ((r68 & 2048) == 0) goto L123;
    L125:
        int r22 = 16;
    L126:
        r14 = r14 | r22;
        goto L128
    L123:
        if (r1.changed(r61) == false) goto L125;
        r22 = 32;
    L128:
        int r0 = r68 & 4096;
        if (r0 == 0) goto L132;
        r14 = r14 | 384;
    L139:
        int r3 = r68 & 8192;
        if (r3 == 0) goto L143;
        r14 = r14 | 3072;
    L151:
        if ((r5 & 306783379) == 306783378) goto L153;
    L156:
        boolean r2 = true;
    L158:
        if (r1.shouldExecute(r2, r5 & 1) == false) goto L227;
        r1.startDefaults();
        if ((r66 & 1) != 0) goto L162;
    L180:
        if (r9 == 0) goto L182;
        r12 = Modifier.Companion;
    L182:
        Function2<? super Composer, ? super Integer, Unit> r4 = null;
        if (r16 == 0) goto L185;
        Function2<? super Composer, ? super Integer, Unit> r15 = null;
    L186:
        if (r19 == 0) goto L188;
        Function2<? super Composer, ? super Integer, Unit> r18 = null;
    L189:
        if (r21 == 0) goto L191;
        r7 = null;
    L191:
        if (r23 != 0) goto L195;
        r4 = r8;
    L195:
        if ((r68 & 128) == 0) goto L198;
        r5 = r5 & (-29360129);
        r10 = AlertDialogDefaults.INSTANCE.getShape(r1, 6);
    L198:
        if ((r68 & 256) == 0) goto L200;
        long r110 = AlertDialogDefaults.INSTANCE.getContainerColor(r1, 6);
        r5 = r5 & (-234881025);
    L202:
        if ((r68 & 512) == 0) goto L204;
        long r24 = AlertDialogDefaults.INSTANCE.getIconContentColor(r1, 6);
        r5 = r5 & (-1879048193);
    L206:
        if ((r68 & 1024) == 0) goto L208;
        long r25 = AlertDialogDefaults.INSTANCE.getTitleContentColor(r1, 6);
        r14 = r14 & (-15);
    L210:
        if ((r68 & 2048) == 0) goto L212;
        long r26 = AlertDialogDefaults.INSTANCE.getTextContentColor(r1, 6);
        r14 = r14 & (-113);
    L213:
        if (r0 == 0) goto L215;
        float r6 = AlertDialogDefaults.INSTANCE.m2280getTonalElevationD9Ej5fM();
    L216:
        if (r3 == 0) goto L218;
        DialogProperties r20 = new DialogProperties(false, false, false, 7, null);
    L219:
        int r27 = r14;
        long r28 = r110;
        long r37 = r24;
        long r39 = r25;
        long r41 = r26;
        int r111 = r5;
        float r29 = r6;
        Function2<? super Composer, ? super Integer, Unit> r30 = r18;
    L220:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L223;
        ComposerKt.traceEventStart(94478519, r111, r27, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
    L223:
        AlertDialogKt.m2283AlertDialogImplwrnwzgE(r47, r48, r12, r15, r30, r7, r4, r10, r28, r37, r39, r41, r29, r20, r1, (((((((((r111 & 14) | (r111 & 112)) | (r111 & 896)) | (r111 & 7168)) | (57344 & r111)) | (458752 & r111)) | (3670016 & r111)) | (29360128 & r111)) | (234881024 & r111)) | (r111 & 1879048192), (((r27 & 14) | (r27 & 112)) | (r27 & 896)) | (r27 & 7168));
        if (ComposerKt.isTraceInProgress() == false) goto L226;
        ComposerKt.traceEventEnd();
    L226:
        final float r112 = r29;
        final Function2<? super Composer, ? super Integer, Unit> r31 = r7;
        final DialogProperties r113 = r20;
        final Shape r32 = r10;
        final long r114 = r39;
        final Function2<? super Composer, ? super Integer, Unit> r33 = r30;
        final Function2<? super Composer, ? super Integer, Unit> r34 = r4;
        final Function2<? super Composer, ? super Integer, Unit> r35 = r15;
        final long r36 = r28;
        final Modifier r38 = r12;
        final long r115 = r37;
    L228:
        ScopeUpdateScope r40 = r1.endRestartGroup();
        if (r40 == null) goto L232;
        final long r116 = r41;
        r40.updateScope(new h(r47, r48, r38, r35, r33, r31, r34, r32, r36, r115, r114, r116, r112, r113, r66, r67, r68));
        return;
    L232:
        return;
    L218:
        r20 = r64;
        goto L219
    L215:
        r6 = r63;
        goto L216
    L212:
        r26 = r61;
        goto L213
    L208:
        r25 = r59;
        goto L210
    L204:
        r24 = r57;
        goto L206
    L200:
        r110 = r55;
        goto L202
    L188:
        r18 = r51;
        goto L189
    L185:
        r15 = r50;
        goto L186
    L162:
        if (r1.getDefaultsInvalid() == true) goto L180;
        r1.skipToGroupEnd();
        if ((r68 & 128) == 0) goto L168;
        r5 = r5 & (-29360129);
    L168:
        if ((r68 & 256) == 0) goto L171;
        r5 = r5 & (-234881025);
    L171:
        if ((r68 & 512) == 0) goto L174;
        r5 = r5 & (-1879048193);
    L174:
        if ((r68 & 1024) == 0) goto L177;
        r14 = r14 & (-15);
    L177:
        if ((r68 & 2048) == 0) goto L179;
        r14 = r14 & (-113);
    L179:
        r15 = r50;
        r30 = r51;
        r28 = r55;
        r37 = r57;
        r39 = r59;
        r41 = r61;
        r4 = r8;
        r27 = r14;
        r20 = r64;
        r111 = r5;
        r29 = r63;
        goto L220
    L227:
        r1.skipToGroupEnd();
        r35 = r50;
        r33 = r51;
        r114 = r59;
        r41 = r61;
        r112 = r63;
        r113 = r64;
        r31 = r7;
        r34 = r8;
        r32 = r10;
        r38 = r12;
        r36 = r55;
        r115 = r57;
        goto L228
    L153:
        if ((r14 & 1171) != 1170) goto L156;
        r2 = false;
        goto L158
    L143:
        if ((r67 & 3072) != 0) goto L151;
        if (r1.changed(r64) == true) goto L148;
        r17 = 1024;
    L148:
        r14 = r14 | r17;
        goto L151
    L132:
        if ((r67 & 384) != 0) goto L139;
        if (r1.changed(r63) == false) goto L136;
        int r210 = 256;
    L137:
        r14 = r14 | r210;
        goto L139
    L136:
        r210 = 128;
        goto L137
    L111:
        if ((r68 & 1024) == 0) goto L113;
    L115:
        int r211 = 2;
    L116:
        r14 = r67 | r211;
        goto L119
    L113:
        if (r1.changed(r59) == false) goto L115;
        r211 = 4;
        goto L116
    L80:
        if ((r68 & 128) != 0) goto L84;
        r10 = r54;
        if (r1.changed(r10) == false) goto L85;
        int r212 = 8388608;
    L86:
        r5 = r5 | r212;
    L85:
        r212 = 4194304;
        goto L86
    L84:
        r10 = r54;
        goto L85
    L70:
        r8 = r53;
        if ((r66 & 1572864) != 0) goto L78;
        if (r1.changedInstance(r8) == false) goto L75;
        int r213 = 1048576;
    L76:
        r5 = r5 | r213;
        goto L78
    L75:
        r213 = 524288;
        goto L76
    L60:
        r7 = r52;
        if ((r66 & 196608) != 0) goto L67;
        if (r1.changedInstance(r7) == false) goto L65;
        int r214 = 131072;
    L66:
        r5 = r5 | r214;
        goto L67
    L65:
        r214 = 65536;
        goto L66
    L50:
        if ((r66 & 24576) != 0) goto L57;
        if (r1.changedInstance(r51) == false) goto L54;
        int r215 = 16384;
    L55:
        r5 = r5 | r215;
        goto L57
    L54:
        r215 = 8192;
        goto L55
    L39:
        if ((r66 & 3072) != 0) goto L46;
        if (r1.changedInstance(r50) == false) goto L43;
        int r117 = 2048;
    L44:
        r5 = r5 | r117;
        goto L46
    L43:
        r117 = 1024;
        goto L44
    L28:
        if ((r66 & 384) != 0) goto L34;
        r12 = r49;
        if (r1.changed(r12) == false) goto L32;
        int r118 = 256;
    L33:
        r5 = r5 | r118;
        goto L35
    L32:
        r118 = 128;
        goto L33
    L17:
        if ((r66 & 48) != 0) goto L24;
        if (r1.changedInstance(r48) == false) goto L21;
        int r42 = 32;
    L22:
        r5 = r5 | r42;
        goto L24
    L21:
        r42 = 16;
        goto L22
    L6:
        if ((r66 & 6) == 0) goto L8;
        r5 = r66;
        goto L14
    L8:
        if (r1.changedInstance(r47) == false) goto L10;
        int r43 = 4;
    L11:
        r5 = r43 | r66;
        goto L14
    L10:
        r43 = 2;
        goto L11
    }
}
