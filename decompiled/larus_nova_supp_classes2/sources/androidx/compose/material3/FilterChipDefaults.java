package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJ\u0087\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJK\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007¢\u0006\u0004\b)\u0010*J[\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u0005H\u0007¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJ\u0087\u0001\u00108\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000fH\u0007¢\u0006\u0004\b9\u0010\u001cJK\u0010<\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007¢\u0006\u0004\b=\u0010*R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0018\u0010\u001d\u001a\u00020\f*\u00020\u001e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0018\u0010:\u001a\u00020\f*\u00020\u001e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u0010 R\u0011\u0010>\u001a\u00020?8G¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006B"}, d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "filterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "filterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "defaultFilterChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultFilterChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "filterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "filterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "filterChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "elevatedFilterChipColors", "elevatedFilterChipColors-XqyqHi0", "defaultElevatedFilterChipColors", "getDefaultElevatedFilterChipColors$material3", "elevatedFilterChipElevation", "elevatedFilterChipElevation-aqJV_2Y", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilterChipDefaults {
    public static final int $stable = 0;
    private static final float Height = 0.0f;
    public static final FilterChipDefaults INSTANCE = null;
    private static final float IconSize = 0.0f;

    private FilterChipDefaults() {
    }

    static {
        INSTANCE = new FilterChipDefaults();
        FilterChipTokens r0 = FilterChipTokens.INSTANCE;
        Height = r0.getContainerHeight-D9Ej5fM();
        IconSize = r0.getIconSize-D9Ej5fM();
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m2716getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2717getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColors$material3(ColorScheme r40) {
        SelectableChipColors r1 = r40.getDefaultElevatedFilterChipColorsCached$material3();
        if (r1 != null) goto L6;
        FilterChipTokens r27 = FilterChipTokens.INSTANCE;
        SelectableChipColors r2 = new SelectableChipColors(ColorSchemeKt.fromToken(r40, r27.getElevatedUnselectedContainerColor()), ColorSchemeKt.fromToken(r40, r27.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(r40, r27.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(r40, r27.getUnselectedTrailingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getElevatedDisabledContainerColor()), r27.getElevatedDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getDisabledLabelTextColor()), r27.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getDisabledLeadingIconColor()), r27.getDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getDisabledTrailingIconColor()), r27.getDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r40, r27.getElevatedSelectedContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getElevatedDisabledContainerColor()), r27.getElevatedDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r40, r27.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(r40, r27.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(r40, r27.getSelectedTrailingIconColor()), null);
        r40.setDefaultElevatedFilterChipColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public final SelectableChipColors getDefaultFilterChipColors$material3(ColorScheme r40) {
        SelectableChipColors r1 = r40.getDefaultFilterChipColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r11 = Color.Companion;
        long r3 = r11.getTransparent-0d7_KjU();
        FilterChipTokens r27 = FilterChipTokens.INSTANCE;
        SelectableChipColors r2 = new SelectableChipColors(r3, ColorSchemeKt.fromToken(r40, r27.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(r40, r27.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(r40, r27.getUnselectedTrailingIconColor()), r11.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getDisabledLabelTextColor()), r27.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getDisabledLeadingIconColor()), r27.getDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getDisabledTrailingIconColor()), r27.getDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r40, r27.getFlatSelectedContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r40, r27.getFlatDisabledSelectedContainerColor()), r27.getFlatDisabledSelectedContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r40, r27.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(r40, r27.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(r40, r27.getSelectedTrailingIconColor()), null);
        r40.setDefaultFilterChipColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public final SelectableChipColors elevatedFilterChipColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1082953289, r5, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1424)");
    L5:
        SelectableChipColors r6 = getDefaultElevatedFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final SelectableChipColors filterChipColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1743772077, r5, -1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1267)");
    L5:
        SelectableChipColors r6 = getDefaultFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1598643637, r5, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:1541)");
    L5:
        Shape r6 = ShapesKt.getValue(FilterChipTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: elevatedFilterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m2712elevatedFilterChipElevationaqJV_2Y(float r6, float r7, float r8, float r9, float r10, float r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r6 = FilterChipTokens.INSTANCE.getElevatedContainerElevation-D9Ej5fM();
    L6:
        if ((r14 & 2) == 0) goto L8;
        r7 = FilterChipTokens.INSTANCE.getElevatedPressedContainerElevation-D9Ej5fM();
    L8:
        float r15 = r7;
        if ((r14 & 4) == 0) goto L11;
        r8 = FilterChipTokens.INSTANCE.getElevatedFocusContainerElevation-D9Ej5fM();
    L11:
        float r0 = r8;
        if ((r14 & 8) == 0) goto L14;
        r9 = FilterChipTokens.INSTANCE.getElevatedHoverContainerElevation-D9Ej5fM();
    L14:
        float r1 = r9;
        if ((r14 & 16) == 0) goto L17;
        r10 = FilterChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM();
    L17:
        float r2 = r10;
        if ((r14 & 32) == 0) goto L20;
        r11 = FilterChipTokens.INSTANCE.getElevatedDisabledContainerElevation-D9Ej5fM();
    L20:
        float r16 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventStart(684803697, r13, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:1530)");
    L23:
        SelectableChipElevation r3 = new SelectableChipElevation(r6, r15, r0, r1, r2, r16, null);
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventEnd();
    L26:
        return r3;
    }

    /* JADX INFO: renamed from: filterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m2715filterChipElevationaqJV_2Y(float r6, float r7, float r8, float r9, float r10, float r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r6 = FilterChipTokens.INSTANCE.getFlatContainerElevation-D9Ej5fM();
    L6:
        if ((r14 & 2) == 0) goto L8;
        r7 = FilterChipTokens.INSTANCE.getFlatSelectedPressedContainerElevation-D9Ej5fM();
    L8:
        float r15 = r7;
        if ((r14 & 4) == 0) goto L11;
        r8 = FilterChipTokens.INSTANCE.getFlatSelectedFocusContainerElevation-D9Ej5fM();
    L11:
        float r0 = r8;
        if ((r14 & 8) == 0) goto L14;
        r9 = FilterChipTokens.INSTANCE.getFlatSelectedHoverContainerElevation-D9Ej5fM();
    L14:
        float r1 = r9;
        if ((r14 & 16) == 0) goto L17;
        r10 = FilterChipTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM();
    L17:
        float r2 = r10;
        if ((r14 & 32) == 0) goto L20;
        float r16 = r6;
    L22:
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventStart(-757972185, r13, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:1372)");
    L24:
        SelectableChipElevation r3 = new SelectableChipElevation(r6, r15, r0, r1, r2, r16, null);
        if (ComposerKt.isTraceInProgress() == false) goto L27;
        ComposerKt.traceEventEnd();
    L27:
        return r3;
    L20:
        r16 = r11;
        goto L22
    }

    /* JADX INFO: renamed from: filterChipBorder-_7El2pE, reason: not valid java name */
    public final BorderStroke m2713filterChipBorder_7El2pE(boolean r18, boolean r19, long r20, long r22, long r24, long r26, float r28, float r29, Composer r30, int r31, int r32) {
        if ((r32 & 4) == 0) goto L5;
        long r4 = ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), r30, 6);
    L7:
        if ((r32 & 8) == 0) goto L9;
        long r6 = Color.Companion.getTransparent-0d7_KjU();
    L11:
        if ((r32 & 16) == 0) goto L13;
        FilterChipTokens r2 = FilterChipTokens.INSTANCE;
        long r3 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r2.getFlatDisabledUnselectedOutlineColor(), r30, 6), r2.getFlatDisabledUnselectedOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r32 & 32) == 0) goto L17;
        long r8 = Color.Companion.getTransparent-0d7_KjU();
    L19:
        if ((r32 & 64) == 0) goto L21;
        float r0 = FilterChipTokens.INSTANCE.getFlatUnselectedOutlineWidth-D9Ej5fM();
    L23:
        if ((r32 & 128) == 0) goto L25;
        float r1 = FilterChipTokens.INSTANCE.getFlatSelectedOutlineWidth-D9Ej5fM();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(-1138342447, r31, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:1409)");
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

    /* JADX INFO: renamed from: elevatedFilterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m2711elevatedFilterChipColorsXqyqHi0(long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, Composer r54, int r55, int r56, int r57) {
        if ((r57 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r57 & 2) == 0) goto L9;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r57 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r57 & 8) == 0) goto L17;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r57 & 16) == 0) goto L21;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r57 & 32) == 0) goto L25;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r57 & 64) == 0) goto L29;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L31:
        if ((r57 & 128) == 0) goto L33;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L34:
        long r17 = r15;
        if ((r57 & 256) == 0) goto L37;
        long r16 = Color.Companion.getUnspecified-0d7_KjU();
    L38:
        long r19 = r16;
        if ((r57 & 512) == 0) goto L41;
        long r18 = Color.Companion.getUnspecified-0d7_KjU();
    L42:
        long r21 = r18;
        if ((r57 & 1024) == 0) goto L45;
        long r110 = Color.Companion.getUnspecified-0d7_KjU();
    L47:
        if ((r57 & 2048) == 0) goto L49;
        long r23 = Color.Companion.getUnspecified-0d7_KjU();
    L51:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(-915841711, r55, r56, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1459)");
    L54:
        SelectableChipColors r0 = getDefaultElevatedFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r54, 6)).m3102copydaRQuJA(r1, r3, r5, r5, r7, r9, r11, r13, r17, r19, r21, r110, r23);
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventEnd();
    L57:
        return r0;
    L49:
        r23 = r52;
        goto L51
    L45:
        r110 = r50;
        goto L47
    L41:
        r18 = r48;
        goto L42
    L37:
        r16 = r46;
        goto L38
    L33:
        r15 = r44;
        goto L34
    L29:
        r13 = r42;
        goto L31
    L25:
        r11 = r40;
        goto L27
    L21:
        r9 = r38;
        goto L23
    L17:
        r7 = r36;
        goto L19
    L13:
        r5 = r34;
        goto L15
    L9:
        r3 = r32;
        goto L11
    L5:
        r1 = r30;
        goto L7
    }

    /* JADX INFO: renamed from: filterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m2714filterChipColorsXqyqHi0(long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, Composer r54, int r55, int r56, int r57) {
        if ((r57 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r57 & 2) == 0) goto L9;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r57 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r57 & 8) == 0) goto L17;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r57 & 16) == 0) goto L21;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r57 & 32) == 0) goto L25;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r57 & 64) == 0) goto L29;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L31:
        if ((r57 & 128) == 0) goto L33;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L34:
        long r17 = r15;
        if ((r57 & 256) == 0) goto L37;
        long r16 = Color.Companion.getUnspecified-0d7_KjU();
    L38:
        long r19 = r16;
        if ((r57 & 512) == 0) goto L41;
        long r18 = Color.Companion.getUnspecified-0d7_KjU();
    L42:
        long r21 = r18;
        if ((r57 & 1024) == 0) goto L45;
        long r110 = Color.Companion.getUnspecified-0d7_KjU();
    L47:
        if ((r57 & 2048) == 0) goto L49;
        long r23 = Color.Companion.getUnspecified-0d7_KjU();
    L51:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(-1831479801, r55, r56, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1302)");
    L54:
        SelectableChipColors r0 = getDefaultFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r54, 6)).m3102copydaRQuJA(r1, r3, r5, r5, r7, r9, r11, r13, r17, r19, r21, r110, r23);
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventEnd();
    L57:
        return r0;
    L49:
        r23 = r52;
        goto L51
    L45:
        r110 = r50;
        goto L47
    L41:
        r18 = r48;
        goto L42
    L37:
        r16 = r46;
        goto L38
    L33:
        r15 = r44;
        goto L34
    L29:
        r13 = r42;
        goto L31
    L25:
        r11 = r40;
        goto L27
    L21:
        r9 = r38;
        goto L23
    L17:
        r7 = r36;
        goto L19
    L13:
        r5 = r34;
        goto L15
    L9:
        r3 = r32;
        goto L11
    L5:
        r1 = r30;
        goto L7
    }
}
