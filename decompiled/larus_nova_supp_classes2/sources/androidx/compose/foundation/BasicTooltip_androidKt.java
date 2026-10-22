package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001ac\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"BasicTooltipBoxAndroid", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/foundation/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "BasicTooltipBox", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicTooltip_androidKt {
    private static final Unit BasicTooltipBoxAndroid$lambda$0(PopupPositionProvider r11, Function2 r12, BasicTooltipState r13, Modifier r14, boolean r15, boolean r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        BasicTooltipBox(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(PopupPositionProvider r0, Function2 r1, BasicTooltipState r2, Modifier r3, boolean r4, boolean r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return BasicTooltipBoxAndroid$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
    public static final /* synthetic */ void BasicTooltipBox(final PopupPositionProvider r20, final Function2 r21, final BasicTooltipState r22, Modifier r23, boolean r24, boolean r25, final Function2 r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(-1368136524);
        if ((r29 & 1) == 0) goto L6;
        int r3 = r28 | 6;
    L14:
        if ((r29 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r29 & 4) == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r6 = r29 & 8;
        if (r6 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Modifier r7 = r23;
    L46:
        int r9 = r29 & 16;
        if (r9 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        boolean r10 = r24;
    L57:
        int r11 = r29 & 32;
        if (r11 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r12 = r25;
    L69:
        if ((r29 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((599187 & r3) == 599186) goto L81;
        boolean r13 = true;
    L83:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L100;
        if (r6 == 0) goto L86;
        Modifier r8 = Modifier.Companion;
    L87:
        if (r9 == 0) goto L89;
        boolean r14 = true;
    L90:
        if (r11 == 0) goto L92;
        boolean r19 = true;
    L94:
        if (ComposerKt.isTraceInProgress() == false) goto L96;
        ComposerKt.traceEventStart(-1368136524, r3, -1, "androidx.compose.foundation.BasicTooltipBoxAndroid (BasicTooltip.android.kt:61)");
    L96:
        Modifier r15 = r8;
        boolean r16 = r14;
        boolean r17 = r19;
        BasicTooltipKt.BasicTooltipBox(r20, r21, r22, r15, r16, r17, r26, r1, ((((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (r3 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventEnd();
    L99:
        r12 = r19;
    L101:
        ScopeUpdateScope r18 = r1.endRestartGroup();
        if (r18 == null) goto L105;
        final Modifier r4 = r8;
        final boolean r5 = r14;
        final boolean r30 = r12;
        r18.updateScope(new v(r20, r21, r22, r4, r5, r30, r26, r28, r29));
        return;
    L105:
        return;
    L92:
        r19 = r12;
        goto L94
    L89:
        r14 = r10;
        goto L90
    L86:
        r8 = r7;
        goto L87
    L100:
        r1.skipToGroupEnd();
        r8 = r7;
        r14 = r10;
        goto L101
    L81:
        r13 = false;
        goto L83
    L72:
        if ((r28 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r26) == false) goto L76;
        int r110 = 1048576;
    L77:
        r3 = r3 | r110;
        goto L79
    L76:
        r110 = 524288;
        goto L77
    L61:
        if ((196608 & r28) != 0) goto L67;
        r12 = r25;
        if (r1.changed(r12) == false) goto L65;
        int r111 = 131072;
    L66:
        r3 = r3 | r111;
        goto L69
    L65:
        r111 = 65536;
        goto L66
    L50:
        if ((r28 & 24576) != 0) goto L56;
        r10 = r24;
        if (r1.changed(r10) == false) goto L54;
        int r112 = 16384;
    L55:
        r3 = r3 | r112;
        goto L57
    L54:
        r112 = 8192;
        goto L55
    L39:
        if ((r28 & 3072) != 0) goto L45;
        r7 = r23;
        if (r1.changed(r7) == false) goto L43;
        int r31 = 2048;
    L44:
        r3 = r3 | r31;
        goto L46
    L43:
        r31 = 1024;
        goto L44
    L28:
        if ((r28 & 384) != 0) goto L35;
        if (r1.changed(r22) == false) goto L32;
        int r32 = 256;
    L33:
        r3 = r3 | r32;
        goto L35
    L32:
        r32 = 128;
        goto L33
    L17:
        if ((r28 & 48) != 0) goto L25;
        if (r1.changedInstance(r21) == false) goto L21;
        int r33 = 32;
    L22:
        r3 = r3 | r33;
        goto L25
    L21:
        r33 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r3 = r28;
        goto L14
    L8:
        if (r1.changed(r20) == false) goto L10;
        int r34 = 4;
    L11:
        r3 = r34 | r28;
        goto L14
    L10:
        r34 = 2;
        goto L11
    }
}
