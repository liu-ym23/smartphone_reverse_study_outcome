package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000fJ\u0091\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJK\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u0005H\u0007¢\u0006\u0004\b,\u0010-J[\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u00020\u00112\b\b\u0002\u00104\u001a\u00020\u00112\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u00106\u001a\u00020\u00112\b\b\u0002\u00107\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\u0005H\u0007¢\u0006\u0004\b9\u0010:R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0018\u0010 \u001a\u00020\u000e*\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010;\u001a\u00020<8G¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006?"}, d2 = {"Landroidx/compose/material3/InputChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "AvatarSize", "getAvatarSize-D9Ej5fM", "inputChipColors", "Landroidx/compose/material3/SelectableChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "inputChipColors-kwJvTHA", "(JJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "defaultInputChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultInputChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "inputChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "inputChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "inputChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "inputChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InputChipDefaults {
    public static final int $stable = 0;
    private static final float AvatarSize = 0.0f;
    private static final float Height = 0.0f;
    public static final InputChipDefaults INSTANCE = null;
    private static final float IconSize = 0.0f;

    private InputChipDefaults() {
    }

    static {
        INSTANCE = new InputChipDefaults();
        InputChipTokens r0 = InputChipTokens.INSTANCE;
        Height = r0.getContainerHeight-D9Ej5fM();
        IconSize = r0.getLeadingIconSize-D9Ej5fM();
        AvatarSize = r0.getAvatarSize-D9Ej5fM();
    }

    /* JADX INFO: renamed from: getAvatarSize-D9Ej5fM, reason: not valid java name */
    public final float m2793getAvatarSizeD9Ej5fM() {
        return AvatarSize;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m2794getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2795getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final SelectableChipColors getDefaultInputChipColors$material3(ColorScheme r40) {
        SelectableChipColors r1 = r40.getDefaultInputChipColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r11 = Color.Companion;
        long r3 = r11.getTransparent-0d7_KjU();
        InputChipTokens r27 = InputChipTokens.INSTANCE;
        SelectableChipColors r2 = new SelectableChipColors(r3, ColorSchemeKt.fromToken(r40, r27.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(r40, r27.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(r40, r27.getUnselectedTrailingIconColor()), r11.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getDisabledLabelTextColor()), r27.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getDisabledLeadingIconColor()), r27.getDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getDisabledTrailingIconColor()), r27.getDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r40, r27.getSelectedContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getDisabledSelectedContainerColor()), r27.getDisabledSelectedContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r40, r27.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(r40, r27.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(r40, r27.getSelectedTrailingIconColor()), null);
        r40.setDefaultInputChipColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1052444143, r5, -1, "androidx.compose.material3.InputChipDefaults.<get-shape> (Chip.kt:1715)");
    L5:
        Shape r6 = ShapesKt.getValue(InputChipTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final SelectableChipColors inputChipColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-770375587, r5, -1, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1562)");
    L5:
        SelectableChipColors r6 = getDefaultInputChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: inputChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m2798inputChipElevationaqJV_2Y(float r6, float r7, float r8, float r9, float r10, float r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r6 = InputChipTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L6:
        if ((r14 & 2) == 0) goto L8;
        float r15 = r6;
    L10:
        if ((r14 & 4) == 0) goto L12;
        float r0 = r6;
    L14:
        if ((r14 & 8) == 0) goto L16;
        float r1 = r6;
    L18:
        if ((r14 & 16) == 0) goto L20;
        r10 = InputChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM();
    L20:
        float r2 = r10;
        if ((r14 & 32) == 0) goto L23;
        float r16 = r6;
    L25:
        if (ComposerKt.isTraceInProgress() == false) goto L27;
        ComposerKt.traceEventStart(1745270109, r13, -1, "androidx.compose.material3.InputChipDefaults.inputChipElevation (Chip.kt:1666)");
    L27:
        SelectableChipElevation r3 = new SelectableChipElevation(r6, r15, r0, r1, r2, r16, null);
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
    L30:
        return r3;
    L23:
        r16 = r11;
        goto L25
    L16:
        r1 = r9;
        goto L18
    L12:
        r0 = r8;
        goto L14
    L8:
        r15 = r7;
        goto L10
    }

    /* JADX INFO: renamed from: inputChipBorder-_7El2pE, reason: not valid java name */
    public final BorderStroke m2796inputChipBorder_7El2pE(boolean r18, boolean r19, long r20, long r22, long r24, long r26, float r28, float r29, Composer r30, int r31, int r32) {
        if ((r32 & 4) == 0) goto L5;
        long r4 = ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getUnselectedOutlineColor(), r30, 6);
    L7:
        if ((r32 & 8) == 0) goto L9;
        long r6 = Color.Companion.getTransparent-0d7_KjU();
    L11:
        if ((r32 & 16) == 0) goto L13;
        InputChipTokens r2 = InputChipTokens.INSTANCE;
        long r3 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r2.getDisabledUnselectedOutlineColor(), r30, 6), r2.getDisabledUnselectedOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r32 & 32) == 0) goto L17;
        long r8 = Color.Companion.getTransparent-0d7_KjU();
    L19:
        if ((r32 & 64) == 0) goto L21;
        float r0 = InputChipTokens.INSTANCE.getUnselectedOutlineWidth-D9Ej5fM();
    L23:
        if ((r32 & 128) == 0) goto L25;
        float r1 = InputChipTokens.INSTANCE.getSelectedOutlineWidth-D9Ej5fM();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(2050575347, r31, -1, "androidx.compose.material3.InputChipDefaults.inputChipBorder (Chip.kt:1703)");
    L29:
        if (r18 == false) goto L32;
        if (r19 == false) goto L35;
        r4 = r6;
    L35:
        if (r19 == false) goto L37;
        r0 = r1;
    L37:
        BorderStroke r5 = BorderStrokeKt.m369BorderStrokecXLIe8U(r0, r4);
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventEnd();
    L40:
        return r5;
    L32:
        if (r19 == false) goto L34;
        r4 = r8;
        goto L35
    L34:
        r4 = r3;
        goto L35
    L25:
        r1 = r29;
        goto L27
    L21:
        r0 = r28;
        goto L23
    L17:
        r8 = r26;
        goto L19
    L13:
        r3 = r24;
        goto L15
    L9:
        r6 = r22;
        goto L11
    L5:
        r4 = r20;
        goto L7
    }

    /* JADX INFO: renamed from: inputChipColors-kwJvTHA, reason: not valid java name */
    public final SelectableChipColors m2797inputChipColorskwJvTHA(long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, Composer r58, int r59, int r60, int r61) {
        if ((r61 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r61 & 2) == 0) goto L9;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r61 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r61 & 8) == 0) goto L17;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r61 & 16) == 0) goto L21;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r61 & 32) == 0) goto L25;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r61 & 64) == 0) goto L29;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L31:
        if ((r61 & 128) == 0) goto L33;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L34:
        long r17 = r15;
        if ((r61 & 256) == 0) goto L37;
        long r16 = Color.Companion.getUnspecified-0d7_KjU();
    L38:
        long r19 = r16;
        if ((r61 & 512) == 0) goto L41;
        long r18 = Color.Companion.getUnspecified-0d7_KjU();
    L42:
        long r21 = r18;
        if ((r61 & 1024) == 0) goto L45;
        long r110 = Color.Companion.getUnspecified-0d7_KjU();
    L46:
        long r23 = r110;
        if ((r61 & 2048) == 0) goto L49;
        long r111 = Color.Companion.getUnspecified-0d7_KjU();
    L51:
        if ((r61 & 4096) == 0) goto L53;
        long r25 = Color.Companion.getUnspecified-0d7_KjU();
    L55:
        if (ComposerKt.isTraceInProgress() == false) goto L58;
        ComposerKt.traceEventStart(1312840646, r59, r60, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1599)");
    L58:
        SelectableChipColors r0 = getDefaultInputChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r58, 6)).m3102copydaRQuJA(r1, r3, r5, r7, r9, r11, r13, r17, r19, r21, r23, r111, r25);
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventEnd();
    L61:
        return r0;
    L53:
        r25 = r56;
        goto L55
    L49:
        r111 = r54;
        goto L51
    L45:
        r110 = r52;
        goto L46
    L41:
        r18 = r50;
        goto L42
    L37:
        r16 = r48;
        goto L38
    L33:
        r15 = r46;
        goto L34
    L29:
        r13 = r44;
        goto L31
    L25:
        r11 = r42;
        goto L27
    L21:
        r9 = r40;
        goto L23
    L17:
        r7 = r38;
        goto L19
    L13:
        r5 = r36;
        goto L15
    L9:
        r3 = r34;
        goto L11
    L5:
        r1 = r32;
        goto L7
    }
}
