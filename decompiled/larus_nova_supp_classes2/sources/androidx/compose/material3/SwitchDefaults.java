package androidx.compose.material3;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J¯\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u0005*\u00020\u001b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u00020\u001f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SwitchColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "defaultSwitchColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSwitchColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SwitchColors;", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = null;
    private static final float IconSize = 0.0f;

    private SwitchDefaults() {
    }

    static {
        INSTANCE = new SwitchDefaults();
        IconSize = Dp.constructor-impl(16);
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3244getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final SwitchColors getDefaultSwitchColors$material3(ColorScheme r49) {
        SwitchColors r1 = r49.getDefaultSwitchColorsCached$material3();
        if (r1 != null) goto L6;
        SwitchTokens r33 = SwitchTokens.INSTANCE;
        long r3 = ColorSchemeKt.fromToken(r49, r33.getSelectedHandleColor());
        long r5 = ColorSchemeKt.fromToken(r49, r33.getSelectedTrackColor());
        Color.Companion r23 = Color.Companion;
        SwitchColors r2 = new SwitchColors(r3, r5, r23.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(r49, r33.getSelectedIconColor()), ColorSchemeKt.fromToken(r49, r33.getUnselectedHandleColor()), ColorSchemeKt.fromToken(r49, r33.getUnselectedTrackColor()), ColorSchemeKt.fromToken(r49, r33.getUnselectedFocusTrackOutlineColor()), ColorSchemeKt.fromToken(r49, r33.getUnselectedIconColor()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r49, r33.getDisabledSelectedHandleColor()), r33.getDisabledSelectedHandleOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r49.m2480getSurface0d7_KjU()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r49, r33.getDisabledSelectedTrackColor()), r33.getDisabledTrackOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r49.m2480getSurface0d7_KjU()), r23.getTransparent-0d7_KjU(), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r49, r33.getDisabledSelectedIconColor()), r33.getDisabledSelectedIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r49.m2480getSurface0d7_KjU()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r49, r33.getDisabledUnselectedHandleColor()), r33.getDisabledUnselectedHandleOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r49.m2480getSurface0d7_KjU()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r49, r33.getDisabledUnselectedTrackColor()), r33.getDisabledTrackOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r49.m2480getSurface0d7_KjU()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r49, r33.getDisabledUnselectedTrackOutlineColor()), r33.getDisabledTrackOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r49.m2480getSurface0d7_KjU()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r49, r33.getDisabledUnselectedIconColor()), r33.getDisabledUnselectedIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r49.m2480getSurface0d7_KjU()), null);
        r49.setDefaultSwitchColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public final SwitchColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(435552781, r5, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:306)");
    L5:
        SwitchColors r6 = getDefaultSwitchColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: colors-V1nXRL4, reason: not valid java name */
    public final SwitchColors m3243colorsV1nXRL4(long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, Composer r73, int r74, int r75, int r76) {
        if ((r76 & 1) == 0) goto L5;
        long r4 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), r73, 6);
    L7:
        if ((r76 & 2) == 0) goto L9;
        long r6 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), r73, 6);
    L11:
        if ((r76 & 4) == 0) goto L13;
        long r8 = Color.Companion.getTransparent-0d7_KjU();
    L15:
        if ((r76 & 8) == 0) goto L17;
        long r10 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), r73, 6);
    L19:
        if ((r76 & 16) == 0) goto L21;
        long r12 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), r73, 6);
    L23:
        if ((r76 & 32) == 0) goto L25;
        long r14 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), r73, 6);
    L27:
        if ((r76 & 64) == 0) goto L29;
        long r16 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), r73, 6);
    L31:
        if ((r76 & 128) == 0) goto L33;
        long r18 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), r73, 6);
    L35:
        if ((r76 & 256) == 0) goto L37;
        SwitchTokens r2 = SwitchTokens.INSTANCE;
        long r3 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r2.getDisabledSelectedHandleColor(), r73, 6), r2.getDisabledSelectedHandleOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), MaterialTheme.INSTANCE.getColorScheme(r73, 6).m2480getSurface0d7_KjU());
    L39:
        if ((r76 & 512) == 0) goto L41;
        SwitchTokens r5 = SwitchTokens.INSTANCE;
        long r7 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r5.getDisabledSelectedTrackColor(), r73, 6), r5.getDisabledTrackOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), MaterialTheme.INSTANCE.getColorScheme(r73, 6).m2480getSurface0d7_KjU());
    L43:
        if ((r76 & 1024) == 0) goto L45;
        long r15 = Color.Companion.getTransparent-0d7_KjU();
    L46:
        long r25 = r15;
        if ((r76 & 2048) == 0) goto L49;
        SwitchTokens r17 = SwitchTokens.INSTANCE;
        long r9 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r17.getDisabledSelectedIconColor(), r73, 6), r17.getDisabledSelectedIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        int r19 = 6;
        long r11 = ColorKt.compositeOver--OWjLjI(r9, MaterialTheme.INSTANCE.getColorScheme(r73, 6).m2480getSurface0d7_KjU());
    L51:
        if ((r76 & 4096) == 0) goto L53;
        SwitchTokens r13 = SwitchTokens.INSTANCE;
        long r20 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r13.getDisabledUnselectedHandleColor(), r73, r19), r13.getDisabledUnselectedHandleOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        r19 = 6;
        long r21 = ColorKt.compositeOver--OWjLjI(r20, MaterialTheme.INSTANCE.getColorScheme(r73, 6).m2480getSurface0d7_KjU());
    L55:
        if ((r76 & 8192) == 0) goto L57;
        SwitchTokens r22 = SwitchTokens.INSTANCE;
        long r23 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r22.getDisabledUnselectedTrackColor(), r73, r19), r22.getDisabledTrackOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        r19 = 6;
        long r24 = ColorKt.compositeOver--OWjLjI(r23, MaterialTheme.INSTANCE.getColorScheme(r73, 6).m2480getSurface0d7_KjU());
    L59:
        if ((r76 & 16384) == 0) goto L61;
        SwitchTokens r26 = SwitchTokens.INSTANCE;
        long r27 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r26.getDisabledUnselectedTrackOutlineColor(), r73, r19), r26.getDisabledTrackOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        r19 = 6;
        long r28 = ColorKt.compositeOver--OWjLjI(r27, MaterialTheme.INSTANCE.getColorScheme(r73, 6).m2480getSurface0d7_KjU());
    L63:
        if ((r76 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        SwitchTokens r1 = SwitchTokens.INSTANCE;
        long r0 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r1.getDisabledUnselectedIconColor(), r73, r19), r1.getDisabledUnselectedIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), MaterialTheme.INSTANCE.getColorScheme(r73, 6).m2480getSurface0d7_KjU());
    L67:
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventStart(1937926421, r74, r75, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:369)");
    L69:
        SwitchColors r29 = new SwitchColors(r4, r6, r8, r10, r12, r14, r16, r18, r3, r7, r25, r11, r21, r24, r28, r0, null);
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventEnd();
    L72:
        return r29;
    L65:
        r0 = r71;
        goto L67
    L61:
        r28 = r69;
        goto L63
    L57:
        r24 = r67;
        goto L59
    L53:
        r21 = r65;
        goto L55
    L49:
        r19 = 6;
        r11 = r63;
        goto L51
    L45:
        r15 = r61;
        goto L46
    L41:
        r7 = r59;
        goto L43
    L37:
        r3 = r57;
        goto L39
    L33:
        r18 = r55;
        goto L35
    L29:
        r16 = r53;
        goto L31
    L25:
        r14 = r51;
        goto L27
    L21:
        r12 = r49;
        goto L23
    L17:
        r10 = r47;
        goto L19
    L13:
        r8 = r45;
        goto L15
    L9:
        r6 = r43;
        goto L11
    L5:
        r4 = r41;
        goto L7
    }
}
