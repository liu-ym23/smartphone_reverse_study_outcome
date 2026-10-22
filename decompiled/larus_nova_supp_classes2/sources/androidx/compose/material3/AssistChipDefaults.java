package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJ_\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018JK\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007¢\u0006\u0004\b%\u0010&J5\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u0005H\u0007¢\u0006\u0004\b.\u0010/J-\u0010'\u001a\u0002002\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u0005H\u0007¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJ_\u00103\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fH\u0007¢\u0006\u0004\b4\u0010\u0018JK\u00107\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007¢\u0006\u0004\b8\u0010&R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0018\u0010\u0019\u001a\u00020\f*\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0018\u00105\u001a\u00020\f*\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u001cR\u0011\u00109\u001a\u00020:8G¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006="}, d2 = {"Landroidx/compose/material3/AssistChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "assistChipColors", "Landroidx/compose/material3/ChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "assistChipColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "defaultAssistChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultAssistChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "assistChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "assistChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "assistChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "borderColor", "disabledBorderColor", "borderWidth", "assistChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "Landroidx/compose/material3/ChipBorder;", "assistChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "elevatedAssistChipColors", "elevatedAssistChipColors-oq7We08", "defaultElevatedAssistChipColors", "getDefaultElevatedAssistChipColors$material3", "elevatedAssistChipElevation", "elevatedAssistChipElevation-aqJV_2Y", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistChipDefaults {
    public static final int $stable = 0;
    private static final float Height = 0.0f;
    public static final AssistChipDefaults INSTANCE = null;
    private static final float IconSize = 0.0f;

    private AssistChipDefaults() {
    }

    static {
        INSTANCE = new AssistChipDefaults();
        AssistChipTokens r0 = AssistChipTokens.INSTANCE;
        Height = r0.getContainerHeight-D9Ej5fM();
        IconSize = r0.getIconSize-D9Ej5fM();
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m2326getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2327getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ChipColors getDefaultAssistChipColors$material3(ColorScheme r30) {
        ChipColors r1 = r30.getDefaultAssistChipColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r11 = Color.Companion;
        long r3 = r11.getTransparent-0d7_KjU();
        AssistChipTokens r17 = AssistChipTokens.INSTANCE;
        ChipColors r2 = new ChipColors(r3, ColorSchemeKt.fromToken(r30, r17.getLabelTextColor()), ColorSchemeKt.fromToken(r30, r17.getIconColor()), ColorSchemeKt.fromToken(r30, r17.getIconColor()), r11.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r30, r17.getDisabledLabelTextColor()), r17.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r30, r17.getDisabledIconColor()), r17.getDisabledIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r30, r17.getDisabledIconColor()), r17.getDisabledIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r30.setDefaultAssistChipColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public final ChipColors getDefaultElevatedAssistChipColors$material3(ColorScheme r30) {
        ChipColors r1 = r30.getDefaultElevatedAssistChipColorsCached$material3();
        if (r1 != null) goto L6;
        AssistChipTokens r17 = AssistChipTokens.INSTANCE;
        ChipColors r2 = new ChipColors(ColorSchemeKt.fromToken(r30, r17.getElevatedContainerColor()), ColorSchemeKt.fromToken(r30, r17.getLabelTextColor()), ColorSchemeKt.fromToken(r30, r17.getIconColor()), ColorSchemeKt.fromToken(r30, r17.getIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r30, r17.getElevatedDisabledContainerColor()), r17.getElevatedDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r30, r17.getDisabledLabelTextColor()), r17.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r30, r17.getDisabledIconColor()), r17.getDisabledIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r30, r17.getDisabledIconColor()), r17.getDisabledIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r30.setDefaultElevatedAssistChipColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public final ChipColors assistChipColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1961061417, r5, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1013)");
    L5:
        ChipColors r6 = getDefaultAssistChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final ChipColors elevatedAssistChipColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(655175583, r5, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1157)");
    L5:
        ChipColors r6 = getDefaultElevatedAssistChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1988153916, r5, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:1249)");
    L5:
        Shape r6 = ShapesKt.getValue(AssistChipTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Maintained for binary compatibility. Use the assistChipBorder function that returns BorderStroke instead", replaceWith = @ReplaceWith(expression = "assistChipBorder(enabled, borderColor, disabledBorderColor, borderWidth)", imports = {}))
    /* JADX INFO: renamed from: assistChipBorder-d_3_b6Q, reason: not valid java name */
    public final ChipBorder m2320assistChipBorderd_3_b6Q(long r15, long r17, float r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        long r3 = ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), r20, 6);
    L7:
        if ((r22 & 2) == 0) goto L9;
        AssistChipTokens r1 = AssistChipTokens.INSTANCE;
        long r0 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r1.getFlatDisabledOutlineColor(), r20, 6), r1.getFlatDisabledOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r22 & 4) == 0) goto L13;
        float r2 = AssistChipTokens.INSTANCE.getFlatOutlineWidth-D9Ej5fM();
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(382372847, r21, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1146)");
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

    /* JADX INFO: renamed from: assistChipBorder-h1eT-Ww, reason: not valid java name */
    public final BorderStroke m2321assistChipBorderh1eTWw(boolean r15, long r16, long r18, float r20, Composer r21, int r22, int r23) {
        if ((r23 & 2) == 0) goto L5;
        long r3 = ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), r21, 6);
    L7:
        if ((r23 & 4) == 0) goto L9;
        AssistChipTokens r1 = AssistChipTokens.INSTANCE;
        long r0 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r1.getFlatDisabledOutlineColor(), r21, 6), r1.getFlatDisabledOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r23 & 8) == 0) goto L13;
        float r2 = AssistChipTokens.INSTANCE.getFlatOutlineWidth-D9Ej5fM();
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(-1458649561, r22, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1118)");
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

    /* JADX INFO: renamed from: assistChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m2323assistChipElevationaqJV_2Y(float r6, float r7, float r8, float r9, float r10, float r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r6 = AssistChipTokens.INSTANCE.getFlatContainerElevation-D9Ej5fM();
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
        r10 = AssistChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM();
    L20:
        float r2 = r10;
        if ((r14 & 32) == 0) goto L23;
        float r16 = r6;
    L25:
        if (ComposerKt.isTraceInProgress() == false) goto L27;
        ComposerKt.traceEventStart(245366099, r13, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:1092)");
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

    /* JADX INFO: renamed from: elevatedAssistChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m2325elevatedAssistChipElevationaqJV_2Y(float r6, float r7, float r8, float r9, float r10, float r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r6 = AssistChipTokens.INSTANCE.getElevatedContainerElevation-D9Ej5fM();
    L6:
        if ((r14 & 2) == 0) goto L8;
        r7 = AssistChipTokens.INSTANCE.getElevatedPressedContainerElevation-D9Ej5fM();
    L8:
        float r15 = r7;
        if ((r14 & 4) == 0) goto L11;
        r8 = AssistChipTokens.INSTANCE.getElevatedFocusContainerElevation-D9Ej5fM();
    L11:
        float r0 = r8;
        if ((r14 & 8) == 0) goto L14;
        r9 = AssistChipTokens.INSTANCE.getElevatedHoverContainerElevation-D9Ej5fM();
    L14:
        float r1 = r9;
        if ((r14 & 16) == 0) goto L17;
        r10 = AssistChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM();
    L17:
        float r2 = r10;
        if ((r14 & 32) == 0) goto L20;
        r11 = AssistChipTokens.INSTANCE.getElevatedDisabledContainerElevation-D9Ej5fM();
    L20:
        float r16 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventStart(1457698077, r13, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:1238)");
    L23:
        ChipElevation r3 = new ChipElevation(r6, r15, r0, r1, r2, r16, null);
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventEnd();
    L26:
        return r3;
    }

    /* JADX INFO: renamed from: assistChipColors-oq7We08, reason: not valid java name */
    public final ChipColors m2322assistChipColorsoq7We08(long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, Composer r38, int r39, int r40) {
        if ((r40 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r40 & 2) == 0) goto L9;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r40 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r40 & 8) == 0) goto L17;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r40 & 16) == 0) goto L21;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r40 & 32) == 0) goto L25;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r40 & 64) == 0) goto L29;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L31:
        if ((r40 & 128) == 0) goto L33;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L35:
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventStart(-391745725, r39, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1039)");
    L38:
        ChipColors r0 = getDefaultAssistChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r38, 6)).m2397copyFD3wquc(r1, r3, r5, r7, r9, r11, r13, r15);
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventEnd();
    L41:
        return r0;
    L33:
        r15 = r36;
        goto L35
    L29:
        r13 = r34;
        goto L31
    L25:
        r11 = r32;
        goto L27
    L21:
        r9 = r30;
        goto L23
    L17:
        r7 = r28;
        goto L19
    L13:
        r5 = r26;
        goto L15
    L9:
        r3 = r24;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }

    /* JADX INFO: renamed from: elevatedAssistChipColors-oq7We08, reason: not valid java name */
    public final ChipColors m2324elevatedAssistChipColorsoq7We08(long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, Composer r38, int r39, int r40) {
        if ((r40 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r40 & 2) == 0) goto L9;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r40 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r40 & 8) == 0) goto L17;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r40 & 16) == 0) goto L21;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r40 & 32) == 0) goto L25;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r40 & 64) == 0) goto L29;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L31:
        if ((r40 & 128) == 0) goto L33;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L35:
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventStart(-535762675, r39, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1183)");
    L38:
        ChipColors r0 = SuggestionChipDefaults.INSTANCE.getDefaultElevatedSuggestionChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r38, 6)).m2397copyFD3wquc(r1, r3, r5, r7, r9, r11, r13, r15);
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventEnd();
    L41:
        return r0;
    L33:
        r15 = r36;
        goto L35
    L29:
        r13 = r34;
        goto L31
    L25:
        r11 = r32;
        goto L27
    L21:
        r9 = r30;
        goto L23
    L17:
        r7 = r28;
        goto L19
    L13:
        r5 = r26;
        goto L15
    L9:
        r3 = r24;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }
}
