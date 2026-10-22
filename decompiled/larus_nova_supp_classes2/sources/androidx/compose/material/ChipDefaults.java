package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013JK\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0015\u0010\u0013Ji\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\fH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJi\u0010\u001f\u001a\u00020\u00172\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\fH\u0007¢\u0006\u0004\b \u0010\u001eR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010!\u001a\u00020\"8G¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010)\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b*\u0010\u0007R\u0013\u0010+\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b,\u0010\u0007R\u0013\u0010-\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b.\u0010\u0007¨\u0006/"}, d2 = {"Landroidx/compose/material/ChipDefaults;", "", "<init>", "()V", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "LeadingIconOpacity", "", "ContentOpacity", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "LeadingIconSize", "getLeadingIconSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final ChipDefaults INSTANCE = null;
    public static final float LeadingIconOpacity = 0.54f;
    private static final float LeadingIconSize = 0.0f;
    private static final float MinHeight = 0.0f;
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize = 0.0f;
    private static final float SelectedIconSize = 0.0f;

    private ChipDefaults() {
    }

    static {
        INSTANCE = new ChipDefaults();
        MinHeight = Dp.constructor-impl(32);
        OutlinedBorderSize = Dp.constructor-impl(1);
        LeadingIconSize = Dp.constructor-impl(20);
        SelectedIconSize = Dp.constructor-impl(18);
    }

    /* JADX INFO: renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1984getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1985getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m1986getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* JADX INFO: renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1987getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }

    public final BorderStroke getOutlinedBorder(Composer r9, int r10) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1650225597, r10, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:539)");
    L5:
        BorderStroke r11 = BorderStrokeKt.m369BorderStrokecXLIe8U(OutlinedBorderSize, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r9, 6).m1998getOnSurface0d7_KjU(), 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r11;
    }

    /* JADX INFO: renamed from: chipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1982chipColors5tl4gsc(long r18, long r20, long r22, long r24, long r26, long r28, Composer r30, int r31, int r32) {
        if ((r32 & 1) == 0) goto L5;
        MaterialTheme r1 = MaterialTheme.INSTANCE;
        long r3 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r1.getColors(r30, 6).m1998getOnSurface0d7_KjU(), 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r1.getColors(r30, 6).m2003getSurface0d7_KjU());
    L7:
        if ((r32 & 2) == 0) goto L9;
        long r5 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r30, 6).m1998getOnSurface0d7_KjU(), 0.87f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r32 & 4) == 0) goto L13;
        long r7 = Color.copy-wmQWz5c$default(r5, 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r32 & 8) == 0) goto L17;
        MaterialTheme r2 = MaterialTheme.INSTANCE;
        long r9 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r2.getColors(r30, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(r30, 6) * 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r2.getColors(r30, 6).m2003getSurface0d7_KjU());
    L19:
        if ((r32 & 16) == 0) goto L21;
        long r19 = r5;
        long r11 = Color.copy-wmQWz5c$default(r19, ContentAlpha.INSTANCE.getDisabled(r30, 6) * 0.87f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L23:
        if ((r32 & 32) == 0) goto L25;
        long r110 = r7;
        long r0 = Color.copy-wmQWz5c$default(r110, ContentAlpha.INSTANCE.getDisabled(r30, 6) * 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(1838505436, r31, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:389)");
    L29:
        DefaultChipColors r4 = new DefaultChipColors(r3, r5, r7, r9, r11, r0, null);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        return r4;
    L25:
        r0 = r28;
        goto L27
    L21:
        r11 = r26;
        goto L23
    L17:
        r9 = r24;
        goto L19
    L13:
        r7 = r22;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    /* JADX INFO: renamed from: outlinedChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1988outlinedChipColors5tl4gsc(long r23, long r25, long r27, long r29, long r31, long r33, Composer r35, int r36, int r37) {
        if ((r37 & 1) == 0) goto L5;
        long r3 = MaterialTheme.INSTANCE.getColors(r35, 6).m2003getSurface0d7_KjU();
    L7:
        if ((r37 & 2) == 0) goto L9;
        long r5 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r35, 6).m1998getOnSurface0d7_KjU(), 0.87f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r37 & 4) == 0) goto L13;
        long r7 = Color.copy-wmQWz5c$default(r5, 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r37 & 8) == 0) goto L17;
        long r9 = r3;
    L19:
        if ((r37 & 16) == 0) goto L21;
        long r24 = r5;
        long r11 = Color.copy-wmQWz5c$default(r24, ContentAlpha.INSTANCE.getDisabled(r35, 6) * 0.87f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L23:
        if ((r37 & 32) == 0) goto L25;
        long r26 = r7;
        long r14 = Color.copy-wmQWz5c$default(r26, ContentAlpha.INSTANCE.getDisabled(r35, 6) * 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(-1763922662, r36, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:422)");
    L29:
        int r16 = ((((((r36 & 14) | (r36 & 112)) | (r36 & 896)) | (r36 & 7168)) | (57344 & r36)) | (458752 & r36)) | (r36 & 3670016);
        ChipColors r0 = m1982chipColors5tl4gsc(r3, r5, r7, r9, r11, r14, r35, r16, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        return r0;
    L25:
        r14 = r33;
        goto L27
    L21:
        r11 = r31;
        goto L23
    L17:
        r9 = r29;
        goto L19
    L13:
        r7 = r27;
        goto L15
    L9:
        r5 = r25;
        goto L11
    L5:
        r3 = r23;
        goto L7
    }

    /* JADX INFO: renamed from: filterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1983filterChipColorsJ08w3E(long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, Composer r44, int r45, int r46) {
        if ((r46 & 1) == 0) goto L5;
        MaterialTheme r2 = MaterialTheme.INSTANCE;
        long r4 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r2.getColors(r44, 6).m1998getOnSurface0d7_KjU(), 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r2.getColors(r44, 6).m2003getSurface0d7_KjU());
    L7:
        if ((r46 & 2) == 0) goto L9;
        long r6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r44, 6).m1998getOnSurface0d7_KjU(), 0.87f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r46 & 4) == 0) goto L13;
        long r8 = Color.copy-wmQWz5c$default(r6, 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r46 & 8) == 0) goto L17;
        MaterialTheme r3 = MaterialTheme.INSTANCE;
        long r10 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r3.getColors(r44, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(r44, 6) * 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r3.getColors(r44, 6).m2003getSurface0d7_KjU());
    L19:
        if ((r46 & 16) == 0) goto L21;
        long r27 = r6;
        long r12 = Color.copy-wmQWz5c$default(r27, ContentAlpha.INSTANCE.getDisabled(r44, 6) * 0.87f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L23:
        if ((r46 & 32) == 0) goto L25;
        long r29 = r8;
        long r14 = Color.copy-wmQWz5c$default(r29, ContentAlpha.INSTANCE.getDisabled(r44, 6) * 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if ((r46 & 64) == 0) goto L29;
        long r15 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r44, 6).m1998getOnSurface0d7_KjU(), 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r4);
    L31:
        if ((r46 & 128) == 0) goto L33;
        long r5 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r44, 6).m1998getOnSurface0d7_KjU(), 0.16f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r6);
    L35:
        if ((r46 & 256) == 0) goto L37;
        long r0 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r44, 6).m1998getOnSurface0d7_KjU(), 0.16f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r8);
    L39:
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventStart(830140629, r45, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:474)");
    L42:
        DefaultSelectableChipColors r1 = new DefaultSelectableChipColors(r4, r6, r8, r10, r12, r14, r15, r5, r0, null);
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventEnd();
    L45:
        return r1;
    L37:
        r0 = r42;
        goto L39
    L33:
        r5 = r40;
        goto L35
    L29:
        r15 = r38;
        goto L31
    L25:
        r14 = r36;
        goto L27
    L21:
        r12 = r34;
        goto L23
    L17:
        r10 = r32;
        goto L19
    L13:
        r8 = r30;
        goto L15
    L9:
        r6 = r28;
        goto L11
    L5:
        r4 = r26;
        goto L7
    }

    /* JADX INFO: renamed from: outlinedFilterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1989outlinedFilterChipColorsJ08w3E(long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, Composer r44, int r45, int r46) {
        if ((r46 & 1) == 0) goto L5;
        long r4 = MaterialTheme.INSTANCE.getColors(r44, 6).m2003getSurface0d7_KjU();
    L7:
        if ((r46 & 2) == 0) goto L9;
        long r6 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r44, 6).m1998getOnSurface0d7_KjU(), 0.87f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r46 & 4) == 0) goto L13;
        long r8 = Color.copy-wmQWz5c$default(r6, 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r46 & 8) == 0) goto L17;
        long r10 = r4;
    L19:
        if ((r46 & 16) == 0) goto L21;
        long r27 = r6;
        long r12 = Color.copy-wmQWz5c$default(r27, ContentAlpha.INSTANCE.getDisabled(r44, 6) * 0.87f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L23:
        if ((r46 & 32) == 0) goto L25;
        long r29 = r8;
        long r14 = Color.copy-wmQWz5c$default(r29, ContentAlpha.INSTANCE.getDisabled(r44, 6) * 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if ((r46 & 64) == 0) goto L29;
        long r15 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r44, 6).m1998getOnSurface0d7_KjU(), 0.16f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r4);
    L31:
        if ((r46 & 128) == 0) goto L33;
        long r3 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r44, 6).m1998getOnSurface0d7_KjU(), 0.16f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r6);
    L35:
        if ((r46 & 256) == 0) goto L37;
        long r0 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r44, 6).m1998getOnSurface0d7_KjU(), 0.16f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r8);
    L39:
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventStart(346878099, r45, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:523)");
    L42:
        DefaultSelectableChipColors r1 = new DefaultSelectableChipColors(r4, r6, r8, r10, r12, r14, r15, r3, r0, null);
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventEnd();
    L45:
        return r1;
    L37:
        r0 = r42;
        goto L39
    L33:
        r3 = r40;
        goto L35
    L29:
        r15 = r38;
        goto L31
    L25:
        r14 = r36;
        goto L27
    L21:
        r12 = r34;
        goto L23
    L17:
        r10 = r32;
        goto L19
    L13:
        r8 = r30;
        goto L15
    L9:
        r6 = r28;
        goto L11
    L5:
        r4 = r26;
        goto L7
    }
}
