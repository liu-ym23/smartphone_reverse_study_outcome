package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Js\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/material/SliderDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SliderColors;", "InactiveTrackAlpha", "", "DisabledInactiveTrackAlpha", "DisabledActiveTrackAlpha", "TickAlpha", "DisabledTickAlpha", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final float DisabledActiveTrackAlpha = 0.32f;
    public static final float DisabledInactiveTrackAlpha = 0.12f;
    public static final float DisabledTickAlpha = 0.12f;
    public static final SliderDefaults INSTANCE = null;
    public static final float InactiveTrackAlpha = 0.24f;
    public static final float TickAlpha = 0.54f;

    static {
        INSTANCE = new SliderDefaults();
    }

    private SliderDefaults() {
    }

    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m2149colorsq0g_0yA(long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, Composer r46, int r47, int r48, int r49) {
        if ((r49 & 1) == 0) goto L5;
        long r5 = MaterialTheme.INSTANCE.getColors(r46, 6).m1999getPrimary0d7_KjU();
    L7:
        if ((r49 & 2) == 0) goto L9;
        MaterialTheme r3 = MaterialTheme.INSTANCE;
        long r7 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r3.getColors(r46, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(r46, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r3.getColors(r46, 6).m2003getSurface0d7_KjU());
    L11:
        if ((r49 & 4) == 0) goto L13;
        long r9 = MaterialTheme.INSTANCE.getColors(r46, 6).m1999getPrimary0d7_KjU();
    L15:
        if ((r49 & 8) == 0) goto L17;
        long r11 = Color.copy-wmQWz5c$default(r9, 0.24f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if ((r49 & 16) == 0) goto L21;
        long r4 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r46, 6).m1998getOnSurface0d7_KjU(), 0.32f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L23:
        if ((r49 & 32) == 0) goto L25;
        long r13 = Color.copy-wmQWz5c$default(r4, 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if ((r49 & 64) == 0) goto L29;
        long r15 = Color.copy-wmQWz5c$default(ColorsKt.m2017contentColorForek8zF_U(r9, r46, (r47 >> 6) & 14), 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L31:
        if ((r49 & 128) == 0) goto L33;
        long r17 = Color.copy-wmQWz5c$default(r9, 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L35:
        if ((r49 & 256) == 0) goto L37;
        long r19 = Color.copy-wmQWz5c$default(r15, 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L39:
        if ((r49 & 512) == 0) goto L41;
        long r21 = Color.copy-wmQWz5c$default(r13, 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L43:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(436017687, r47, r48, "androidx.compose.material.SliderDefaults.colors (Slider.kt:605)");
    L46:
        DefaultSliderColors r0 = new DefaultSliderColors(r5, r7, r9, r11, r4, r13, r15, r17, r19, r21, null);
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        return r0;
    L41:
        r21 = r44;
        goto L43
    L37:
        r19 = r42;
        goto L39
    L33:
        r17 = r40;
        goto L35
    L29:
        r15 = r38;
        goto L31
    L25:
        r13 = r36;
        goto L27
    L21:
        r4 = r34;
        goto L23
    L17:
        r11 = r32;
        goto L19
    L13:
        r9 = r30;
        goto L15
    L9:
        r7 = r28;
        goto L11
    L5:
        r5 = r26;
        goto L7
    }
}
