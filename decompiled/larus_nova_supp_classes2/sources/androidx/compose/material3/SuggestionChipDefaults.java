package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJK\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016JK\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001f\u0010 J5\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u0005H\u0007¢\u0006\u0004\b(\u0010)J-\u0010!\u001a\u00020*2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u0005H\u0007¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJK\u0010-\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b.\u0010\u0016JK\u00103\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b4\u0010 R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0018\u0010/\u001a\u00020\f*\u0002008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00105\u001a\u0002068G¢\u0006\u0006\u001a\u0004\b7\u00108¨\u00069"}, d2 = {"Landroidx/compose/material3/SuggestionChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "suggestionChipColors", "Landroidx/compose/material3/ChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledIconContentColor", "suggestionChipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "suggestionChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "suggestionChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "suggestionChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "borderColor", "disabledBorderColor", "borderWidth", "suggestionChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "Landroidx/compose/material3/ChipBorder;", "suggestionChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "elevatedSuggestionChipColors", "elevatedSuggestionChipColors-5tl4gsc", "defaultElevatedSuggestionChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultElevatedSuggestionChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "elevatedSuggestionChipElevation", "elevatedSuggestionChipElevation-aqJV_2Y", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SuggestionChipDefaults {
    public static final int $stable = 0;
    private static final float Height = 0.0f;
    public static final SuggestionChipDefaults INSTANCE = null;
    private static final float IconSize = 0.0f;

    private SuggestionChipDefaults() {
    }

    static {
        INSTANCE = new SuggestionChipDefaults();
        SuggestionChipTokens r0 = SuggestionChipTokens.INSTANCE;
        Height = r0.getContainerHeight-D9Ej5fM();
        IconSize = r0.getLeadingIconSize-D9Ej5fM();
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m3207getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3208getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ChipColors getDefaultElevatedSuggestionChipColors$material3(ColorScheme r30) {
        ChipColors r1 = r30.getDefaultElevatedSuggestionChipColorsCached$material3();
        if (r1 != null) goto L6;
        SuggestionChipTokens r13 = SuggestionChipTokens.INSTANCE;
        long r3 = ColorSchemeKt.fromToken(r30, r13.getElevatedContainerColor());
        long r5 = ColorSchemeKt.fromToken(r30, r13.getLabelTextColor());
        long r7 = ColorSchemeKt.fromToken(r30, r13.getLeadingIconColor());
        Color.Companion r17 = Color.Companion;
        long r9 = r17.getUnspecified-0d7_KjU();
        long r18 = ColorSchemeKt.fromToken(r30, r13.getElevatedDisabledContainerColor());
        AssistChipTokens r15 = AssistChipTokens.INSTANCE;
        ChipColors r2 = new ChipColors(r3, r5, r7, r9, Color.copy-wmQWz5c$default(r18, r15.getElevatedDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r30, r13.getDisabledLabelTextColor()), r13.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r30, r15.getDisabledIconColor()), r15.getDisabledIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r17.getUnspecified-0d7_KjU(), null);
        r30.setDefaultElevatedSuggestionChipColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public final ChipColors elevatedSuggestionChipColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1671233087, r5, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1851)");
    L5:
        ChipColors r6 = getDefaultElevatedSuggestionChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(641188183, r5, -1, "androidx.compose.material3.SuggestionChipDefaults.<get-shape> (Chip.kt:1937)");
    L5:
        Shape r6 = ShapesKt.getValue(SuggestionChipTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final ChipColors suggestionChipColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1918570697, r5, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1733)");
    L5:
        ChipColors r6 = ChipKt.getDefaultSuggestionChipColors(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Maintained for binary compatibility. Use the suggestChipBorder functions instead", replaceWith = @ReplaceWith(expression = "suggestionChipBorder(enabled, borderColor, disabledBorderColor, borderWidth)", imports = {}))
    /* JADX INFO: renamed from: suggestionChipBorder-d_3_b6Q, reason: not valid java name */
    public final ChipBorder m3209suggestionChipBorderd_3_b6Q(long r15, long r17, float r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        long r3 = ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), r20, 6);
    L7:
        if ((r22 & 2) == 0) goto L9;
        SuggestionChipTokens r1 = SuggestionChipTokens.INSTANCE;
        long r0 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r1.getFlatDisabledOutlineColor(), r20, 6), r1.getFlatDisabledOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r22 & 4) == 0) goto L13;
        float r2 = SuggestionChipTokens.INSTANCE.getFlatOutlineWidth-D9Ej5fM();
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(439283919, r21, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1839)");
    L17:
        ChipBorder r5 = new ChipBorder(r3, r0, r2, null);
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r5;
    L13:
        r2 = r19;
        goto L15
    L9:
        r0 = r17;
        goto L11
    L5:
        r3 = r15;
        goto L7
    }

    /* JADX INFO: renamed from: suggestionChipBorder-h1eT-Ww, reason: not valid java name */
    public final BorderStroke m3210suggestionChipBorderh1eTWw(boolean r15, long r16, long r18, float r20, Composer r21, int r22, int r23) {
        if ((r23 & 2) == 0) goto L5;
        long r3 = ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), r21, 6);
    L7:
        if ((r23 & 4) == 0) goto L9;
        SuggestionChipTokens r1 = SuggestionChipTokens.INSTANCE;
        long r0 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r1.getFlatDisabledOutlineColor(), r21, 6), r1.getFlatDisabledOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r23 & 8) == 0) goto L13;
        float r2 = SuggestionChipTokens.INSTANCE.getFlatOutlineWidth-D9Ej5fM();
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(-637354809, r22, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1812)");
    L17:
        if (r15 == true) goto L20;
        r3 = r0;
    L20:
        BorderStroke r4 = BorderStrokeKt.m369BorderStrokecXLIe8U(r2, r3);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
    L23:
        return r4;
    L13:
        r2 = r20;
        goto L15
    L9:
        r0 = r18;
        goto L11
    L5:
        r3 = r16;
        goto L7
    }

    /* JADX INFO: renamed from: elevatedSuggestionChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m3205elevatedSuggestionChipColors5tl4gsc(long r20, long r22, long r24, long r26, long r28, long r30, Composer r32, int r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r34 & 2) == 0) goto L9;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r34 & 4) == 0) goto L13;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r34 & 8) == 0) goto L17;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r34 & 16) == 0) goto L21;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r34 & 32) == 0) goto L25;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(1269423125, r33, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1873)");
    L29:
        ChipColors r2 = getDefaultElevatedSuggestionChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r32, 6));
        Color.Companion r0 = Color.Companion;
        ChipColors r1 = r2.m2397copyFD3wquc(r3, r5, r7, r0.getUnspecified-0d7_KjU(), r11, r13, r15, r0.getUnspecified-0d7_KjU());
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        return r1;
    L25:
        r15 = r30;
        goto L27
    L21:
        r13 = r28;
        goto L23
    L17:
        r11 = r26;
        goto L19
    L13:
        r7 = r24;
        goto L15
    L9:
        r5 = r22;
        goto L11
    L5:
        r3 = r20;
        goto L7
    }

    /* JADX INFO: renamed from: elevatedSuggestionChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m3206elevatedSuggestionChipElevationaqJV_2Y(float r6, float r7, float r8, float r9, float r10, float r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r6 = SuggestionChipTokens.INSTANCE.getElevatedContainerElevation-D9Ej5fM();
    L6:
        if ((r14 & 2) == 0) goto L8;
        r7 = SuggestionChipTokens.INSTANCE.getElevatedPressedContainerElevation-D9Ej5fM();
    L8:
        float r15 = r7;
        if ((r14 & 4) == 0) goto L11;
        r8 = SuggestionChipTokens.INSTANCE.getElevatedFocusContainerElevation-D9Ej5fM();
    L11:
        float r0 = r8;
        if ((r14 & 8) == 0) goto L14;
        r9 = SuggestionChipTokens.INSTANCE.getElevatedHoverContainerElevation-D9Ej5fM();
    L14:
        float r1 = r9;
        if ((r14 & 16) == 0) goto L17;
        r10 = SuggestionChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM();
    L17:
        float r2 = r10;
        if ((r14 & 32) == 0) goto L20;
        r11 = SuggestionChipTokens.INSTANCE.getElevatedDisabledContainerElevation-D9Ej5fM();
    L20:
        float r16 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventStart(1118088467, r13, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipElevation (Chip.kt:1926)");
    L23:
        ChipElevation r3 = new ChipElevation(r6, r15, r0, r1, r2, r16, null);
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventEnd();
    L26:
        return r3;
    }

    /* JADX INFO: renamed from: suggestionChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m3211suggestionChipColors5tl4gsc(long r20, long r22, long r24, long r26, long r28, long r30, Composer r32, int r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r34 & 2) == 0) goto L9;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r34 & 4) == 0) goto L13;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r34 & 8) == 0) goto L17;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r34 & 16) == 0) goto L21;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r34 & 32) == 0) goto L25;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(1882647883, r33, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1755)");
    L29:
        ChipColors r2 = ChipKt.getDefaultSuggestionChipColors(MaterialTheme.INSTANCE.getColorScheme(r32, 6));
        Color.Companion r0 = Color.Companion;
        ChipColors r1 = r2.m2397copyFD3wquc(r3, r5, r7, r0.getUnspecified-0d7_KjU(), r11, r13, r15, r0.getUnspecified-0d7_KjU());
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        return r1;
    L25:
        r15 = r30;
        goto L27
    L21:
        r13 = r28;
        goto L23
    L17:
        r11 = r26;
        goto L19
    L13:
        r7 = r24;
        goto L15
    L9:
        r5 = r22;
        goto L11
    L5:
        r3 = r20;
        goto L7
    }

    /* JADX INFO: renamed from: suggestionChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m3212suggestionChipElevationaqJV_2Y(float r6, float r7, float r8, float r9, float r10, float r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r6 = SuggestionChipTokens.INSTANCE.getFlatContainerElevation-D9Ej5fM();
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
        r10 = SuggestionChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM();
    L20:
        float r2 = r10;
        if ((r14 & 32) == 0) goto L23;
        float r16 = r6;
    L25:
        if (ComposerKt.isTraceInProgress() == false) goto L27;
        ComposerKt.traceEventStart(1929994057, r13, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipElevation (Chip.kt:1786)");
    L27:
        ChipElevation r3 = new ChipElevation(r6, r15, r0, r1, r2, r16, null);
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
}
