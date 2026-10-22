package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "DividerAlpha", "", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    private static final Unit Divider_oMI9zvI$lambda$0(Modifier r9, long r10, float r12, float r13, int r14, int r15, Composer r16, int r17) {
        m2032DivideroMI9zvI(r9, r10, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, long r1, float r3, float r4, int r5, int r6, Composer r7, int r8) {
        return Divider_oMI9zvI$lambda$0(r0, r1, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: Divider-oMI9zvI, reason: not valid java name */
    public static final void m2032DivideroMI9zvI(Modifier r24, long r25, float r27, float r28, Composer r29, final int r30, final int r31) {
        Composer r1 = r29.startRestartGroup(-1249392198);
        int r2 = r31 & 1;
        if (r2 == 0) goto L6;
        int r4 = r30 | 6;
        Modifier r3 = r24;
    L14:
        if ((r30 & 48) != 0) goto L22;
        long r7 = r25;
        if ((r31 & 2) == 0) goto L18;
    L20:
        int r5 = 16;
    L21:
        r4 = r4 | r5;
    L23:
        int r6 = r31 & 4;
        if (r6 == 0) goto L27;
        r4 = r4 | 384;
    L33:
        float r9 = r27;
    L34:
        int r10 = r31 & 8;
        if (r10 == 0) goto L38;
        r4 = r4 | 3072;
    L44:
        float r11 = r28;
    L46:
        if ((r4 & 1171) == 1170) goto L48;
        boolean r12 = true;
    L50:
        if (r1.shouldExecute(r12, r4 & 1) == false) goto L87;
        r1.startDefaults();
        if ((r30 & 1) != 0) goto L54;
    L60:
        if (r2 == 0) goto L62;
        Modifier r8 = Modifier.Companion;
    L64:
        if ((r31 & 2) == 0) goto L66;
        r7 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r1, 6).m1998getOnSurface0d7_KjU(), 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        r4 = r4 & (-113);
    L66:
        if (r6 == 0) goto L68;
        r9 = Dp.constructor-impl(1);
    L68:
        if (r10 == 0) goto L70;
        r11 = Dp.constructor-impl(0);
    L70:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L74;
        ComposerKt.traceEventStart(-1249392198, r4, -1, "androidx.compose.material.Divider (Divider.kt:50)");
    L74:
        if (r11 != androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L76;
        boolean r13 = true;
    L77:
        if (r13 == true) goto L79;
        Modifier r14 = PaddingKt.m964paddingqDBjuR0$default(Modifier.Companion, r11, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L81:
        if (Dp.equals-impl0(r9, Dp.Companion.getHairline-D9Ej5fM()) == false) goto L83;
        r1.startReplaceGroup(-455967894);
        float r15 = Dp.constructor-impl(1.0f / ((Density) r1.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
        r1.endReplaceGroup();
    L84:
        BoxKt.Box(BackgroundKt.m342backgroundbw27NRU$default(SizeKt.m1000height3ABfNKs(SizeKt.fillMaxWidth$default(r8.then(r14), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), r15), r7, null, 2, null), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventEnd();
    L88:
        final float r16 = r9;
        final float r17 = r11;
        ScopeUpdateScope r18 = r1.endRestartGroup();
        if (r18 == null) goto L92;
        final Modifier r19 = r8;
        final long r20 = r7;
        r18.updateScope(new g3(r19, r20, r16, r17, r30, r31));
        return;
    L92:
        return;
    L83:
        r1.startReplaceGroup(-455901337);
        r1.endReplaceGroup();
        r15 = r9;
        goto L84
    L79:
        r14 = Modifier.Companion;
        goto L81
    L76:
        r13 = false;
        goto L77
    L62:
        r8 = r3;
        goto L64
    L54:
        if (r1.getDefaultsInvalid() == true) goto L60;
        r1.skipToGroupEnd();
        if ((r31 & 2) == 0) goto L59;
        r4 = r4 & (-113);
    L59:
        r8 = r3;
        goto L70
    L87:
        r1.skipToGroupEnd();
        r8 = r3;
        goto L88
    L48:
        r12 = false;
        goto L50
    L38:
        if ((r30 & 3072) != 0) goto L44;
        r11 = r28;
        if (r1.changed(r11) == false) goto L42;
        int r110 = 2048;
    L43:
        r4 = r4 | r110;
        goto L46
    L42:
        r110 = 1024;
        goto L43
    L27:
        if ((r30 & 384) != 0) goto L33;
        r9 = r27;
        if (r1.changed(r9) == false) goto L31;
        int r111 = 256;
    L32:
        r4 = r4 | r111;
        goto L34
    L31:
        r111 = 128;
        goto L32
    L18:
        if (r1.changed(r7) == false) goto L20;
        r5 = 32;
        goto L21
    L22:
        r7 = r25;
        goto L23
    L6:
        if ((r30 & 6) != 0) goto L12;
        r3 = r24;
        if (r1.changed(r3) == false) goto L10;
        int r21 = 4;
    L11:
        r4 = r21 | r30;
        goto L14
    L10:
        r21 = 2;
        goto L11
    L12:
        r3 = r24;
        r4 = r30;
        goto L14
    }
}
