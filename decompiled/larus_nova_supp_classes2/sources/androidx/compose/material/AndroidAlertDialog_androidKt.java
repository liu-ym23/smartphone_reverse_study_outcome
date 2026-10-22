package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a§\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt {
    private static final Unit AlertDialog_6oU6zVQ$lambda$0(Function0 r16, Function2 r17, Modifier r18, Function2 r19, Function2 r20, Function2 r21, Shape r22, long r23, long r25, DialogProperties r27, int r28, int r29, Composer r30, int r31) {
        m1918AlertDialog6oU6zVQ(r16, r17, r18, r19, r20, r21, r22, r23, r25, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), r29);
        return Unit.INSTANCE;
    }

    private static final Unit AlertDialog_wqdebIU$lambda$1(Function0 r15, Function2 r16, Modifier r17, Function2 r18, Function2 r19, Shape r20, long r21, long r23, DialogProperties r25, int r26, int r27, Composer r28, int r29) {
        m1919AlertDialogwqdebIU(r15, r16, r17, r18, r19, r20, r21, r23, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function0 r0, Function2 r1, Modifier r2, Function2 r3, Function2 r4, Shape r5, long r6, long r8, DialogProperties r10, int r11, int r12, Composer r13, int r14) {
        return AlertDialog_wqdebIU$lambda$1(r0, r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit b(Function0 r0, Function2 r1, Modifier r2, Function2 r3, Function2 r4, Function2 r5, Shape r6, long r7, long r9, DialogProperties r11, int r12, int r13, Composer r14, int r15) {
        return AlertDialog_6oU6zVQ$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14, r15);
    }

    /* JADX INFO: renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    public static final void m1919AlertDialogwqdebIU(final Function0<Unit> r20, final Function2<? super Composer, ? super Integer, Unit> r21, Modifier r22, Function2<? super Composer, ? super Integer, Unit> r23, Function2<? super Composer, ? super Integer, Unit> r24, Shape r25, long r26, long r28, DialogProperties r30, Composer r31, final int r32, final int r33) {
        Composer r1 = r31.startRestartGroup(1409209698);
        if ((r33 & 1) == 0) goto L6;
        int r3 = r32 | 6;
    L14:
        if ((r33 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r33 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r7 = r33 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function2<? super Composer, ? super Integer, Unit> r8 = r23;
    L46:
        int r9 = r33 & 16;
        if (r9 == 0) goto L50;
        r3 = r3 | 24576;
    L58:
        if ((196608 & r32) != 0) goto L69;
        if ((r33 & 32) != 0) goto L65;
        if (r1.changed(r25) == false) goto L65;
        int r14 = 131072;
    L66:
        r3 = r3 | r14;
    L65:
        r14 = 65536;
    L69:
        if ((1572864 & r32) == 0) goto L71;
        long r15 = r26;
    L80:
        if ((r32 & 12582912) != 0) goto L88;
        long r10 = r28;
        if ((r33 & 128) == 0) goto L84;
    L86:
        int r0 = 4194304;
    L87:
        r3 = r3 | r0;
    L89:
        int r2 = r33 & 256;
        if (r2 == 0) goto L93;
        r3 = r3 | 100663296;
    L100:
        if ((r3 & 38347923) == 38347922) goto L102;
        boolean r4 = true;
    L104:
        if (r1.shouldExecute(r4, r3 & 1) == false) goto L150;
        r1.startDefaults();
        if ((r32 & 1) != 0) goto L108;
    L120:
        if (r5 == 0) goto L122;
        Modifier r6 = Modifier.Companion;
    L123:
        final Function2<? super Composer, ? super Integer, Unit> r11 = null;
        if (r7 == 0) goto L126;
        r8 = null;
    L126:
        if (r9 != 0) goto L130;
        r11 = r24;
    L130:
        if ((r33 & 32) == 0) goto L132;
        Shape r12 = MaterialTheme.INSTANCE.getShapes(r1, 6).getMedium();
        r3 = r3 & (-458753);
    L134:
        if ((r33 & 64) == 0) goto L137;
        r15 = MaterialTheme.INSTANCE.getColors(r1, 6).m2003getSurface0d7_KjU();
        r3 = r3 & (-3670017);
    L137:
        if ((r33 & 128) == 0) goto L139;
        final long r13 = ColorsKt.m2017contentColorForek8zF_U(r15, r1, (r3 >> 18) & 14);
        r3 = r3 & (-29360129);
    L140:
        if (r2 == 0) goto L142;
        DialogProperties r16 = new DialogProperties(false, false, false, 7, null);
    L143:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L146;
        ComposerKt.traceEventStart(1409209698, r3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
    L146:
        int r17 = (r3 & 234881024) | ((((((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3));
        Modifier r29 = r6;
        DialogProperties r27 = r16;
        AndroidDialog_androidKt.Dialog(r20, r27, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(r21, r6, r8, r11, r12, r15, r13), r1, 54), r1, ((r17 >> 21) & 112) | ((r17 & 14) | 384), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L149;
        ComposerKt.traceEventEnd();
    L149:
        final Modifier r18 = r29;
        final DialogProperties r19 = r16;
        final Shape r34 = r12;
        final Function2<? super Composer, ? super Integer, Unit> r35 = r8;
        final long r36 = r15;
    L151:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L155;
        r110.updateScope(new s(r20, r21, r18, r35, r11, r34, r36, r13, r19, r32, r33));
        return;
    L155:
        return;
    L142:
        r16 = r30;
        goto L143
    L139:
        r13 = r10;
        goto L140
    L132:
        r12 = r25;
        goto L134
    L122:
        r6 = r22;
        goto L123
    L108:
        if (r1.getDefaultsInvalid() == true) goto L120;
        r1.skipToGroupEnd();
        if ((r33 & 32) == 0) goto L114;
        r3 = r3 & (-458753);
    L114:
        if ((r33 & 64) == 0) goto L117;
        r3 = r3 & (-3670017);
    L117:
        if ((r33 & 128) == 0) goto L119;
        r3 = r3 & (-29360129);
    L119:
        r6 = r22;
        r11 = r24;
        r12 = r25;
        r16 = r30;
        r13 = r10;
        goto L143
    L150:
        r1.skipToGroupEnd();
        r18 = r22;
        r11 = r24;
        r34 = r25;
        r35 = r8;
        r13 = r10;
        r36 = r15;
        r19 = r30;
        goto L151
    L102:
        r4 = false;
        goto L104
    L93:
        if ((r32 & 100663296) != 0) goto L100;
        if (r1.changed(r30) == false) goto L97;
        int r111 = 67108864;
    L98:
        r3 = r3 | r111;
        goto L100
    L97:
        r111 = 33554432;
        goto L98
    L84:
        if (r1.changed(r10) == false) goto L86;
        r0 = 8388608;
        goto L87
    L88:
        r10 = r28;
        goto L89
    L71:
        if ((r33 & 64) != 0) goto L75;
        r15 = r26;
        if (r1.changed(r15) == false) goto L76;
        int r112 = 1048576;
    L77:
        r3 = r3 | r112;
    L76:
        r112 = 524288;
        goto L77
    L75:
        r15 = r26;
        goto L76
    L50:
        if ((r32 & 24576) != 0) goto L58;
        if (r1.changedInstance(r24) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
        goto L58
    L54:
        r113 = 8192;
        goto L55
    L39:
        if ((r32 & 3072) != 0) goto L45;
        r8 = r23;
        if (r1.changedInstance(r8) == false) goto L43;
        int r37 = 2048;
    L44:
        r3 = r3 | r37;
        goto L46
    L43:
        r37 = 1024;
        goto L44
    L28:
        if ((r32 & 384) != 0) goto L35;
        if (r1.changed(r22) == false) goto L32;
        int r38 = 256;
    L33:
        r3 = r3 | r38;
        goto L35
    L32:
        r38 = 128;
        goto L33
    L17:
        if ((r32 & 48) != 0) goto L24;
        if (r1.changedInstance(r21) == false) goto L21;
        int r39 = 32;
    L22:
        r3 = r3 | r39;
        goto L24
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r3 = r32;
        goto L14
    L8:
        if (r1.changedInstance(r20) == false) goto L10;
        int r40 = 4;
    L11:
        r3 = r40 | r32;
        goto L14
    L10:
        r40 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    public static final void m1918AlertDialog6oU6zVQ(final Function0<Unit> r30, final Function2<? super Composer, ? super Integer, Unit> r31, Modifier r32, Function2<? super Composer, ? super Integer, Unit> r33, Function2<? super Composer, ? super Integer, Unit> r34, Function2<? super Composer, ? super Integer, Unit> r35, Shape r36, long r37, long r39, DialogProperties r41, Composer r42, final int r43, final int r44) {
        Composer r1 = r42.startRestartGroup(1967984963);
        if ((r44 & 1) == 0) goto L6;
        int r4 = r43 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L23:
        int r5 = r44 & 4;
        if (r5 == 0) goto L27;
        r4 = r4 | 384;
    L34:
        int r7 = r44 & 8;
        if (r7 == 0) goto L38;
        r4 = r4 | 3072;
    L44:
        Function2<? super Composer, ? super Integer, Unit> r8 = r33;
    L45:
        int r9 = r44 & 16;
        if (r9 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        Function2<? super Composer, ? super Integer, Unit> r10 = r34;
    L56:
        int r11 = r44 & 32;
        if (r11 == 0) goto L60;
        r4 = r4 | 196608;
    L66:
        Function2<? super Composer, ? super Integer, Unit> r12 = r35;
    L68:
        if ((1572864 & r43) == 0) goto L70;
        Shape r15 = r36;
    L79:
        if ((r43 & 12582912) != 0) goto L89;
        if ((r44 & 128) == 0) goto L83;
    L85:
        int r0 = 4194304;
    L86:
        r4 = r4 | r0;
        goto L89
    L83:
        if (r1.changed(r37) == false) goto L85;
        r0 = 8388608;
    L89:
        if ((100663296 & r43) != 0) goto L98;
        if ((r44 & 256) == 0) goto L93;
    L95:
        int r2 = 33554432;
    L96:
        r4 = r4 | r2;
        goto L98
    L93:
        if (r1.changed(r39) == false) goto L95;
        r2 = 67108864;
    L98:
        int r3 = r44 & 512;
        if (r3 == 0) goto L102;
        r4 = r4 | 805306368;
    L109:
        if ((306783379 & r4) == 306783378) goto L111;
        boolean r6 = true;
    L113:
        if (r1.shouldExecute(r6, r4 & 1) == false) goto L163;
        r1.startDefaults();
        if ((r43 & 1) != 0) goto L117;
    L129:
        if (r5 == 0) goto L131;
        Modifier r13 = Modifier.Companion;
    L132:
        Function2<? super Composer, ? super Integer, Unit> r14 = null;
        if (r7 == 0) goto L135;
        r8 = null;
    L135:
        if (r9 == 0) goto L137;
        r10 = null;
    L137:
        if (r11 != 0) goto L141;
        r14 = r12;
    L141:
        if ((r44 & 64) == 0) goto L143;
        final Shape r16 = MaterialTheme.INSTANCE.getShapes(r1, 6).getMedium();
        r4 = r4 & (-3670017);
    L145:
        if ((r44 & 128) == 0) goto L147;
        long r17 = MaterialTheme.INSTANCE.getColors(r1, 6).m2003getSurface0d7_KjU();
        r4 = r4 & (-29360129);
    L149:
        if ((r44 & 256) == 0) goto L151;
        long r18 = ColorsKt.m2017contentColorForek8zF_U(r17, r1, (r4 >> 21) & 14);
        r4 = (-234881025) & r4;
    L152:
        if (r3 == 0) goto L154;
        DialogProperties r19 = new DialogProperties(false, false, false, 7, null);
    L155:
        int r20 = r4;
        long r21 = r18;
    L156:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L159;
        ComposerKt.traceEventStart(1967984963, r20, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
    L159:
        int r22 = (((((((((r20 & 14) | (r20 & 112)) | (r20 & 896)) | (r20 & 7168)) | (57344 & r20)) | (458752 & r20)) | (3670016 & r20)) | (29360128 & r20)) | (234881024 & r20)) | (r20 & 1879048192);
        Function2<? super Composer, ? super Integer, Unit> r38 = r8;
        ComposableLambda r110 = ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(r8, r31), r1, 54);
        int r23 = ((r22 & 14) | 48) | (r22 & 896);
        int r24 = r22 >> 3;
        m1919AlertDialogwqdebIU(r30, r110, r13, r10, r14, r16, r17, r21, r19, r1, (((((r23 | (r24 & 7168)) | (57344 & r24)) | (458752 & r24)) | (3670016 & r24)) | (29360128 & r24)) | (r24 & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L162;
        ComposerKt.traceEventEnd();
    L162:
        final Function2<? super Composer, ? super Integer, Unit> r25 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r26 = r10;
        final long r27 = r17;
        final DialogProperties r111 = r19;
        final long r112 = r21;
        final Function2<? super Composer, ? super Integer, Unit> r28 = r38;
        final Modifier r29 = r13;
    L164:
        ScopeUpdateScope r113 = r1.endRestartGroup();
        if (r113 == null) goto L168;
        r113.updateScope(new q(r30, r31, r29, r28, r26, r25, r16, r27, r112, r111, r43, r44));
        return;
    L168:
        return;
    L154:
        r19 = r41;
        goto L155
    L151:
        r18 = r39;
        goto L152
    L147:
        r17 = r37;
        goto L149
    L143:
        r16 = r15;
        goto L145
    L131:
        r13 = r32;
        goto L132
    L117:
        if (r1.getDefaultsInvalid() == true) goto L129;
        r1.skipToGroupEnd();
        if ((r44 & 64) == 0) goto L123;
        r4 = r4 & (-3670017);
    L123:
        if ((r44 & 128) == 0) goto L126;
        r4 = r4 & (-29360129);
    L126:
        if ((r44 & 256) == 0) goto L128;
        r4 = r4 & (-234881025);
    L128:
        r13 = r32;
        r19 = r41;
        r20 = r4;
        r14 = r12;
        r16 = r15;
        r17 = r37;
        r21 = r39;
        goto L156
    L163:
        r1.skipToGroupEnd();
        r29 = r32;
        r28 = r8;
        r26 = r10;
        r25 = r12;
        r16 = r15;
        r27 = r37;
        r112 = r39;
        r111 = r41;
        goto L164
    L111:
        r6 = false;
        goto L113
    L102:
        if ((r43 & 805306368) != 0) goto L109;
        if (r1.changed(r41) == false) goto L106;
        int r40 = 536870912;
    L107:
        r4 = r4 | r40;
        goto L109
    L106:
        r40 = 268435456;
        goto L107
    L70:
        if ((r44 & 64) != 0) goto L74;
        r15 = r36;
        if (r1.changed(r15) == false) goto L75;
        int r114 = 1048576;
    L76:
        r4 = r4 | r114;
    L75:
        r114 = 524288;
        goto L76
    L74:
        r15 = r36;
        goto L75
    L60:
        if ((196608 & r43) != 0) goto L66;
        r12 = r35;
        if (r1.changedInstance(r12) == false) goto L64;
        int r115 = 131072;
    L65:
        r4 = r4 | r115;
        goto L68
    L64:
        r115 = 65536;
        goto L65
    L49:
        if ((r43 & 24576) != 0) goto L55;
        r10 = r34;
        if (r1.changedInstance(r10) == false) goto L53;
        int r116 = 16384;
    L54:
        r4 = r4 | r116;
        goto L56
    L53:
        r116 = 8192;
        goto L54
    L38:
        if ((r43 & 3072) != 0) goto L44;
        r8 = r33;
        if (r1.changedInstance(r8) == false) goto L42;
        int r45 = 2048;
    L43:
        r4 = r4 | r45;
        goto L45
    L42:
        r45 = 1024;
        goto L43
    L27:
        if ((r43 & 384) != 0) goto L34;
        if (r1.changed(r32) == false) goto L31;
        int r46 = 256;
    L32:
        r4 = r4 | r46;
        goto L34
    L31:
        r46 = 128;
        goto L32
    L17:
        if ((r43 & 48) != 0) goto L23;
        if (r1.changedInstance(r31) == false) goto L21;
        int r47 = 32;
    L22:
        r4 = r4 | r47;
        goto L23
    L21:
        r47 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r4 = r43;
        goto L14
    L8:
        if (r1.changedInstance(r30) == false) goto L10;
        int r48 = 4;
    L11:
        r4 = r48 | r43;
        goto L14
    L10:
        r48 = 2;
        goto L11
    }
}
