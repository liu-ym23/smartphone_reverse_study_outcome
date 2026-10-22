package androidx.compose.material3;

import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JK\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u0005*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/CheckboxDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/CheckboxColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledCheckedColor", "disabledUncheckedColor", "disabledIndeterminateColor", "colors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CheckboxColors;", "defaultCheckboxColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultCheckboxColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CheckboxColors;", "StrokeWidth", "Landroidx/compose/ui/unit/Dp;", "getStrokeWidth-D9Ej5fM", "()F", "F", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = null;
    private static final float StrokeWidth = 0.0f;

    private CheckboxDefaults() {
    }

    static {
        INSTANCE = new CheckboxDefaults();
        StrokeWidth = Dp.constructor-impl(2);
    }

    /* JADX INFO: renamed from: getStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m2392getStrokeWidthD9Ej5fM() {
        return StrokeWidth;
    }

    public final CheckboxColors getDefaultCheckboxColors$material3(ColorScheme r38) {
        CheckboxColors r1 = r38.getDefaultCheckboxColorsCached$material3();
        if (r1 != null) goto L6;
        CheckboxTokens r25 = CheckboxTokens.INSTANCE;
        long r3 = ColorSchemeKt.fromToken(r38, r25.getSelectedIconColor());
        Color.Companion r13 = Color.Companion;
        CheckboxColors r2 = new CheckboxColors(r3, r13.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(r38, r25.getSelectedContainerColor()), r13.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r38, r25.getSelectedDisabledContainerColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r13.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r38, r25.getSelectedDisabledContainerColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r38, r25.getSelectedContainerColor()), ColorSchemeKt.fromToken(r38, r25.getUnselectedOutlineColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r38, r25.getSelectedDisabledContainerColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r38, r25.getUnselectedDisabledOutlineColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r38, r25.getSelectedDisabledContainerColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r38.setDefaultCheckboxColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public final CheckboxColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-9530498, r5, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:315)");
    L5:
        CheckboxColors r6 = getDefaultCheckboxColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: colors-5tl4gsc, reason: not valid java name */
    public final CheckboxColors m2391colors5tl4gsc(long r28, long r30, long r32, long r34, long r36, long r38, Composer r40, int r41, int r42) {
        if ((r42 & 1) == 0) goto L5;
        long r17 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r42 & 2) == 0) goto L9;
        long r19 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r42 & 4) == 0) goto L13;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r42 & 8) == 0) goto L17;
        long r21 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r42 & 16) == 0) goto L21;
        long r23 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r42 & 32) == 0) goto L25;
        long r25 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(-89536160, r41, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:341)");
    L29:
        CheckboxColors r2 = getDefaultCheckboxColors$material3(MaterialTheme.INSTANCE.getColorScheme(r40, 6));
        Color.Companion r0 = Color.Companion;
        long r7 = r17;
        long r11 = r21;
        CheckboxColors r1 = r2.m2378copy2qZNXz8(r3, r0.getTransparent-0d7_KjU(), r7, r0.getTransparent-0d7_KjU(), r11, r0.getTransparent-0d7_KjU(), r25, r17, r19, r21, r23, r25);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        return r1;
    L25:
        r25 = r38;
        goto L27
    L21:
        r23 = r36;
        goto L23
    L17:
        r21 = r34;
        goto L19
    L13:
        r3 = r32;
        goto L15
    L9:
        r19 = r30;
        goto L11
    L5:
        r17 = r28;
        goto L7
    }
}
