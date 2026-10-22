package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ClickableTextKt {
    private static final Unit ClickableText_4YKlhWE$lambda$6(AnnotatedString r12, Modifier r13, TextStyle r14, boolean r15, int r16, int r17, Function1 r18, Function1 r19, int r20, int r21, Composer r22, int r23) {
        m1361ClickableText4YKlhWE(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(MutableState r0, Function1 r1, TextLayoutResult r2) {
        return ClickableText_4YKlhWE$lambda$5$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(TextLayoutResult r0) {
        return ClickableText_4YKlhWE$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ Unit c(AnnotatedString r0, Modifier r1, TextStyle r2, boolean r3, int r4, int r5, Function1 r6, Function1 r7, int r8, int r9, Composer r10, int r11) {
        return ClickableText_4YKlhWE$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    private static final Unit ClickableText_4YKlhWE$lambda$1$lambda$0(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final Unit ClickableText_4YKlhWE$lambda$5$lambda$4(MutableState r0, Function1 r1, TextLayoutResult r2) {
        r0.setValue(r2);
        r1.invoke(r2);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation. Check LinkAnnotation's documentation for more details and samples.")
    /* JADX INFO: renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    public static final void m1361ClickableText4YKlhWE(final AnnotatedString r26, Modifier r27, TextStyle r28, boolean r29, int r30, int r31, Function1<? super TextLayoutResult, Unit> r32, final Function1<? super Integer, Unit> r33, Composer r34, final int r35, final int r36) {
        Composer r1 = r34.startRestartGroup(-246609449);
        if ((r36 & 1) == 0) goto L6;
        int r4 = r35 | 6;
    L13:
        int r5 = r36 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        Modifier r6 = r27;
    L24:
        int r7 = r36 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        TextStyle r11 = r28;
    L35:
        int r12 = r36 & 8;
        if (r12 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        boolean r13 = r29;
    L46:
        int r14 = r36 & 16;
        if (r14 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        int r15 = r30;
    L57:
        int r16 = r36 & 32;
        if (r16 == 0) goto L60;
        r4 = r4 | 196608;
        int r3 = r31;
    L67:
        int r17 = r36 & 64;
        if (r17 == 0) goto L71;
        r4 = r4 | 1572864;
    L78:
        if ((r36 & 128) == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        boolean r21 = false;
        if ((4793491 & r4) == 4793490) goto L90;
        boolean r0 = true;
    L92:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L139;
        if (r5 == 0) goto L95;
        r6 = Modifier.Companion;
    L95:
        if (r7 == 0) goto L97;
        TextStyle r2 = TextStyle.Companion.getDefault();
    L98:
        if (r12 == 0) goto L100;
        boolean r8 = true;
    L101:
        if (r14 == 0) goto L103;
        final int r9 = TextOverflow.Companion.getClip-gIe3tQ8();
    L104:
        if (r16 == 0) goto L106;
        r3 = Integer.MAX_VALUE;
    L106:
        if (r17 == 0) goto L111;
        Object r10 = r1.rememberedValue();
        if (r10 != Composer.Companion.getEmpty()) goto L110;
        r10 = new j1();
        r1.updateRememberedValue(r10);
    L110:
        final Function1<? super TextLayoutResult, Unit> r18 = (Function1) r10;
    L113:
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventStart(-246609449, r4, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
    L115:
        Object r19 = r1.rememberedValue();
        Composer.Companion r110 = Composer.Companion;
        if (r19 != r110.getEmpty()) goto L118;
        r19 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r1.updateRememberedValue(r19);
    L118:
        final MutableState r111 = (MutableState) r19;
        Modifier.Companion r112 = Modifier.Companion;
        if ((29360128 & r4) != 8388608) goto L121;
        boolean r113 = true;
    L122:
        Object r114 = r1.rememberedValue();
        if (r113 == false) goto L125;
    L126:
        r114 = new ClickableTextKt$ClickableText$pressIndicator$1$1(r111, r33);
        r1.updateRememberedValue(r114);
    L127:
        Modifier r115 = r6.then(SuspendingPointerInputFilterKt.pointerInput(r112, r33, (PointerInputEventHandler) r114));
        if ((r4 & 3670016) != 1048576) goto L130;
        r21 = true;
    L130:
        Object r116 = r1.rememberedValue();
        if (r21 == false) goto L133;
    L134:
        r116 = new k1(r111, r18);
        r1.updateRememberedValue(r116);
    L135:
        int r23 = ((((r4 & 14) | (r4 & 896)) | (57344 & r4)) | (458752 & (r4 << 6))) | ((r4 << 3) & 3670016);
        TextStyle r117 = r2;
        BasicTextKt.m1354BasicTextCL7eQgs(r26, r115, r117, (Function1) r116, r9, r8, r3, 0, null, null, null, r1, r23, 0, 1920);
        if (ComposerKt.isTraceInProgress() == false) goto L138;
        ComposerKt.traceEventEnd();
    L138:
        final boolean r20 = r8;
        final Modifier r22 = r6;
        final int r24 = r3;
        final TextStyle r25 = r2;
    L140:
        ScopeUpdateScope r118 = r1.endRestartGroup();
        if (r118 == null) goto L144;
        r118.updateScope(new l1(r26, r22, r25, r20, r9, r24, r18, r33, r35, r36));
        return;
    L144:
        return;
    L133:
        if (r116 != r110.getEmpty()) goto L135;
    L125:
        if (r114 != r110.getEmpty()) goto L127;
    L121:
        r113 = false;
        goto L122
    L111:
        r18 = r32;
        goto L113
    L103:
        r9 = r15;
        goto L104
    L100:
        r8 = r13;
        goto L101
    L97:
        r2 = r11;
        goto L98
    L139:
        r1.skipToGroupEnd();
        r18 = r32;
        r22 = r6;
        r20 = r13;
        r9 = r15;
        r24 = r3;
        r25 = r11;
        goto L140
    L90:
        r0 = false;
        goto L92
    L81:
        if ((r35 & 12582912) != 0) goto L87;
        if (r1.changedInstance(r33) == false) goto L85;
        int r37 = 8388608;
    L86:
        r4 = r4 | r37;
        goto L87
    L85:
        r37 = 4194304;
        goto L86
    L71:
        if ((r35 & 1572864) != 0) goto L78;
        if (r1.changedInstance(r32) == false) goto L75;
        int r210 = 1048576;
    L76:
        r4 = r4 | r210;
        goto L78
    L75:
        r210 = 524288;
        goto L76
    L60:
        r3 = r31;
        if ((r35 & 196608) != 0) goto L67;
        if (r1.changed(r3) == false) goto L65;
        int r119 = 131072;
    L66:
        r4 = r4 | r119;
        goto L67
    L65:
        r119 = 65536;
        goto L66
    L50:
        if ((r35 & 24576) != 0) goto L56;
        r15 = r30;
        if (r1.changed(r15) == false) goto L54;
        int r120 = 16384;
    L55:
        r4 = r4 | r120;
        goto L57
    L54:
        r120 = 8192;
        goto L55
    L39:
        if ((r35 & 3072) != 0) goto L45;
        r13 = r29;
        if (r1.changed(r13) == false) goto L43;
        int r121 = 2048;
    L44:
        r4 = r4 | r121;
        goto L46
    L43:
        r121 = 1024;
        goto L44
    L28:
        if ((r35 & 384) != 0) goto L34;
        r11 = r28;
        if (r1.changed(r11) == false) goto L32;
        int r122 = 256;
    L33:
        r4 = r4 | r122;
        goto L35
    L32:
        r122 = 128;
        goto L33
    L17:
        if ((r35 & 48) != 0) goto L23;
        r6 = r27;
        if (r1.changed(r6) == false) goto L21;
        int r38 = 32;
    L22:
        r4 = r4 | r38;
        goto L24
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r4 = r35;
        goto L13
    L8:
        if (r1.changed(r26) == false) goto L10;
        int r39 = 4;
    L11:
        r4 = r39 | r35;
        goto L13
    L10:
        r39 = 2;
        goto L11
    }
}
