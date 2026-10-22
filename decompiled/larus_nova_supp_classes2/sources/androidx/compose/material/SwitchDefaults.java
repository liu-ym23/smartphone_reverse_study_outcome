package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Js\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/SwitchDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedTrackAlpha", "", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedTrackAlpha", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "colors-SQMK_m0", "(JJFJJFJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SwitchColors;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = null;

    static {
        INSTANCE = new SwitchDefaults();
    }

    private SwitchDefaults() {
    }

    /* JADX INFO: renamed from: colors-SQMK_m0, reason: not valid java name */
    public final SwitchColors m2190colorsSQMK_m0(long r25, long r27, float r29, long r30, long r32, float r34, long r35, long r37, long r39, long r41, Composer r43, int r44, int r45, int r46) {
        if ((r46 & 1) == 0) goto L5;
        long r4 = MaterialTheme.INSTANCE.getColors(r43, 6).m2002getSecondaryVariant0d7_KjU();
    L7:
        if ((r46 & 2) == 0) goto L9;
        long r6 = r4;
    L11:
        if ((r46 & 4) == 0) goto L13;
        float r2 = 0.54f;
    L15:
        if ((r46 & 8) == 0) goto L17;
        long r8 = MaterialTheme.INSTANCE.getColors(r43, 6).m2003getSurface0d7_KjU();
    L19:
        if ((r46 & 16) == 0) goto L21;
        long r10 = MaterialTheme.INSTANCE.getColors(r43, 6).m1998getOnSurface0d7_KjU();
    L23:
        if ((r46 & 32) == 0) goto L25;
        float r12 = 0.38f;
    L27:
        if ((r46 & 64) == 0) goto L29;
        long r26 = r4;
        long r3 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r26, ContentAlpha.INSTANCE.getDisabled(r43, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), MaterialTheme.INSTANCE.getColors(r43, 6).m2003getSurface0d7_KjU());
    L31:
        if ((r46 & 128) == 0) goto L33;
        long r28 = r6;
        int r15 = 6;
        long r5 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r28, ContentAlpha.INSTANCE.getDisabled(r43, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), MaterialTheme.INSTANCE.getColors(r43, 6).m2003getSurface0d7_KjU());
    L35:
        if ((r46 & 256) == 0) goto L37;
        long r210 = r8;
        long r13 = Color.copy-wmQWz5c$default(r210, ContentAlpha.INSTANCE.getDisabled(r43, r15), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        r15 = 6;
        long r9 = ColorKt.compositeOver--OWjLjI(r13, MaterialTheme.INSTANCE.getColors(r43, 6).m2003getSurface0d7_KjU());
    L39:
        if ((r46 & 512) == 0) goto L41;
        long r211 = r10;
        long r0 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r211, ContentAlpha.INSTANCE.getDisabled(r43, r15), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), MaterialTheme.INSTANCE.getColors(r43, 6).m2003getSurface0d7_KjU());
    L43:
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventStart(-1032127534, r44, r45, "androidx.compose.material.SwitchDefaults.colors (Switch.kt:341)");
    L45:
        long r7 = Color.copy-wmQWz5c$default(r6, r2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        long r11 = Color.copy-wmQWz5c$default(r10, r12, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        long r14 = Color.copy-wmQWz5c$default(r5, r2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        long r1 = Color.copy-wmQWz5c$default(r0, r12, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        DefaultSwitchColors r16 = new DefaultSwitchColors(r4, r7, r8, r11, r3, r14, r9, r1, null);
        if (ComposerKt.isTraceInProgress() == false) goto L48;
        ComposerKt.traceEventEnd();
    L48:
        return r16;
    L41:
        r0 = r41;
        goto L43
    L37:
        r9 = r39;
        goto L39
    L33:
        r15 = 6;
        r5 = r37;
        goto L35
    L29:
        r3 = r35;
        goto L31
    L25:
        r12 = r34;
        goto L27
    L21:
        r10 = r32;
        goto L23
    L17:
        r8 = r30;
        goto L19
    L13:
        r2 = r29;
        goto L15
    L9:
        r6 = r27;
        goto L11
    L5:
        r4 = r25;
        goto L7
    }
}
