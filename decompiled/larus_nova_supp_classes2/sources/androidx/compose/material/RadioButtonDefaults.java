package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/material/RadioButtonDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/RadioButtonColors;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = null;

    static {
        INSTANCE = new RadioButtonDefaults();
    }

    private RadioButtonDefaults() {
    }

    /* JADX INFO: renamed from: colors-RGew2ao, reason: not valid java name */
    public final RadioButtonColors m2134colorsRGew2ao(long r20, long r22, long r24, Composer r26, int r27, int r28) {
        if ((r28 & 1) == 0) goto L5;
        long r7 = MaterialTheme.INSTANCE.getColors(r26, 6).m2001getSecondary0d7_KjU();
    L7:
        if ((r28 & 2) == 0) goto L9;
        long r9 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r26, 6).m1998getOnSurface0d7_KjU(), 0.6f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r28 & 4) == 0) goto L13;
        long r11 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r26, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(r26, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(1370708026, r27, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:161)");
    L17:
        boolean r4 = false;
        if ((6 ^ (r27 & 14)) <= 4) goto L22;
        if (r26.changed(r7) == false) goto L22;
    L23:
        boolean r2 = true;
    L26:
        if (((r27 & 112) ^ 48) <= 32) goto L30;
        if (r26.changed(r9) == false) goto L30;
    L31:
        boolean r3 = true;
    L33:
        boolean r5 = r2 | r3;
        if (((r27 & 896) ^ 384) <= 256) goto L38;
        if (r26.changed(r11) == false) goto L38;
    L39:
        r4 = true;
    L40:
        boolean r1 = r5 | r4;
        Object r6 = r26.rememberedValue();
        if (r1 == false) goto L43;
    L44:
        r6 = new DefaultRadioButtonColors(r7, r9, r11, null);
        r26.updateRememberedValue(r6);
    L45:
        DefaultRadioButtonColors r8 = (DefaultRadioButtonColors) r6;
        if (ComposerKt.isTraceInProgress() == false) goto L48;
        ComposerKt.traceEventEnd();
    L48:
        return r8;
    L43:
        if (r6 != Composer.Companion.getEmpty()) goto L45;
    L38:
        if ((r27 & 384) != 256) goto L40;
    L30:
        if ((r27 & 48) == 32) goto L31;
        r3 = false;
    L22:
        if ((r27 & 6) == 4) goto L23;
        r2 = false;
        goto L26
    L13:
        r11 = r24;
        goto L15
    L9:
        r9 = r22;
        goto L11
    L5:
        r7 = r20;
        goto L7
    }
}
