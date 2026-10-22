package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/CheckboxDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledColor", "disabledIndeterminateColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/CheckboxColors;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = null;

    static {
        INSTANCE = new CheckboxDefaults();
    }

    private CheckboxDefaults() {
    }

    /* JADX INFO: renamed from: colors-zjMxDiM, reason: not valid java name */
    public final CheckboxColors m1979colorszjMxDiM(long r31, long r33, long r35, long r37, long r39, Composer r41, int r42, int r43) {
        if ((r43 & 1) == 0) goto L5;
        long r4 = MaterialTheme.INSTANCE.getColors(r41, 6).m2001getSecondary0d7_KjU();
    L7:
        if ((r43 & 2) == 0) goto L9;
        long r11 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r41, 6).m1998getOnSurface0d7_KjU(), 0.6f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r43 & 4) == 0) goto L13;
        long r7 = MaterialTheme.INSTANCE.getColors(r41, 6).m2003getSurface0d7_KjU();
    L15:
        if ((r43 & 8) == 0) goto L17;
        long r13 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r41, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(r41, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if ((r43 & 16) == 0) goto L21;
        long r32 = r4;
        long r9 = Color.copy-wmQWz5c$default(r32, ContentAlpha.INSTANCE.getDisabled(r41, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L23:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(469524104, r42, -1, "androidx.compose.material.CheckboxDefaults.colors (Checkbox.kt:225)");
    L26:
        if (((r42 & 14) ^ 6) <= 4) goto L30;
        if (r41.changed(r4) == false) goto L30;
    L31:
        boolean r2 = true;
    L34:
        if (((r42 & 112) ^ 48) <= 32) goto L38;
        if (r41.changed(r11) == false) goto L38;
    L39:
        boolean r3 = true;
    L41:
        boolean r5 = r2 | r3;
        if (((r42 & 896) ^ 384) <= 256) goto L46;
        if (r41.changed(r7) == false) goto L46;
    L47:
        boolean r6 = true;
    L49:
        boolean r8 = r5 | r6;
        if (((r42 & 7168) ^ 3072) <= 2048) goto L54;
        if (r41.changed(r13) == false) goto L54;
    L55:
        boolean r10 = true;
    L57:
        boolean r12 = r8 | r10;
        if (((57344 & r42) ^ 24576) <= 16384) goto L62;
        if (r41.changed(r9) == false) goto L62;
    L63:
        boolean r14 = true;
    L65:
        boolean r1 = r12 | r14;
        Object r15 = r41.rememberedValue();
        if (r1 == false) goto L68;
    L69:
        long r27 = r9;
        long r25 = r13;
        long r23 = r11;
        long r16 = r4;
        r15 = new DefaultCheckboxColors(r7, Color.copy-wmQWz5c$default(r7, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r16, Color.copy-wmQWz5c$default(r4, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r25, Color.copy-wmQWz5c$default(r25, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r27, r4, r23, r25, r27, null);
        r41.updateRememberedValue(r15);
    L70:
        DefaultCheckboxColors r17 = (DefaultCheckboxColors) r15;
        if (ComposerKt.isTraceInProgress() == false) goto L73;
        ComposerKt.traceEventEnd();
    L73:
        return r17;
    L68:
        if (r15 != Composer.Companion.getEmpty()) goto L70;
    L62:
        if ((r42 & 24576) == 16384) goto L63;
        r14 = false;
    L54:
        if ((r42 & 3072) == 2048) goto L55;
        r10 = false;
    L46:
        if ((r42 & 384) == 256) goto L47;
        r6 = false;
    L38:
        if ((r42 & 48) == 32) goto L39;
        r3 = false;
    L30:
        if ((r42 & 6) == 4) goto L31;
        r2 = false;
        goto L34
    L21:
        r9 = r39;
        goto L23
    L17:
        r13 = r37;
        goto L19
    L13:
        r7 = r35;
        goto L15
    L9:
        r11 = r33;
        goto L11
    L5:
        r4 = r31;
        goto L7
    }
}
