package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\b'\u0010(J-\u0010)\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\b*\u0010+J-\u0010,\u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\b-\u0010+R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010.\u001a\u00020/X\u0086T¢\u0006\u0002\n\u0000R\u0013\u00100\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b1\u0010\u000eR\u0011\u00102\u001a\u0002038G¢\u0006\u0006\u001a\u0004\b4\u00105R\u0010\u00106\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u00107\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000b¨\u00069"}, d2 = {"Landroidx/compose/material/ButtonDefaults;", "", "<init>", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "MinWidth", "getMinWidth-D9Ej5fM", "()F", "MinHeight", "getMinHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "IconSpacing", "getIconSpacing-D9Ej5fM", "elevation", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "pressedElevation", "disabledElevation", "elevation-yajeYGU", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonElevation;", "buttonColors", "Landroidx/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "outlinedButtonColors", "outlinedButtonColors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ButtonColors;", "textButtonColors", "textButtonColors-RGew2ao", "OutlinedBorderOpacity", "", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "TextButtonHorizontalPadding", "TextButtonContentPadding", "getTextButtonContentPadding", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding = 0.0f;
    private static final float ButtonVerticalPadding = 0.0f;
    private static final PaddingValues ContentPadding = null;
    public static final ButtonDefaults INSTANCE = null;
    private static final float IconSize = 0.0f;
    private static final float IconSpacing = 0.0f;
    private static final float MinHeight = 0.0f;
    private static final float MinWidth = 0.0f;
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize = 0.0f;
    private static final PaddingValues TextButtonContentPadding = null;
    private static final float TextButtonHorizontalPadding = 0.0f;

    private ButtonDefaults() {
    }

    static {
        INSTANCE = new ButtonDefaults();
        float r0 = Dp.constructor-impl(16);
        ButtonHorizontalPadding = r0;
        float r1 = 8;
        float r2 = Dp.constructor-impl(r1);
        ButtonVerticalPadding = r2;
        PaddingValues r3 = PaddingKt.m956PaddingValuesa9UjIt4(r0, r2, r0, r2);
        ContentPadding = r3;
        MinWidth = Dp.constructor-impl(64);
        MinHeight = Dp.constructor-impl(36);
        IconSize = Dp.constructor-impl(18);
        IconSpacing = Dp.constructor-impl(r1);
        OutlinedBorderSize = Dp.constructor-impl(1);
        float r4 = Dp.constructor-impl(r1);
        TextButtonHorizontalPadding = r4;
        TextButtonContentPadding = PaddingKt.m956PaddingValuesa9UjIt4(r4, r3.mo901calculateTopPaddingD9Ej5fM(), r4, r3.mo898calculateBottomPaddingD9Ej5fM());
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1970getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m1971getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1972getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1973getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m1974getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    public final BorderStroke getOutlinedBorder(Composer r9, int r10) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2091313033, r10, -1, "androidx.compose.material.ButtonDefaults.<get-outlinedBorder> (Button.kt:473)");
    L5:
        BorderStroke r11 = BorderStrokeKt.m369BorderStrokecXLIe8U(OutlinedBorderSize, Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r9, 6).m1998getOnSurface0d7_KjU(), 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r11;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    /* JADX INFO: renamed from: elevation-yajeYGU, reason: not valid java name */
    public final /* synthetic */ ButtonElevation m1969elevationyajeYGU(float r10, float r11, float r12, Composer r13, int r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r10 = Dp.constructor-impl(2);
    L5:
        float r1 = r10;
        if ((r15 & 2) == 0) goto L8;
        r11 = Dp.constructor-impl(8);
    L8:
        float r2 = r11;
        if ((r15 & 4) == 0) goto L11;
        r12 = Dp.constructor-impl(0);
    L11:
        float r3 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(1428576874, r14, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:347)");
    L14:
        float r16 = 4;
        ButtonElevation r17 = m1968elevationR_JCAzs(r1, r2, r3, Dp.constructor-impl(r16), Dp.constructor-impl(r16), r13, ((((r14 & 14) | 27648) | (r14 & 112)) | (r14 & 896)) | ((r14 << 6) & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        return r17;
    }

    /* JADX INFO: renamed from: outlinedButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m1975outlinedButtonColorsRGew2ao(long r21, long r23, long r25, Composer r27, int r28, int r29) {
        if ((r29 & 1) == 0) goto L5;
        long r10 = MaterialTheme.INSTANCE.getColors(r27, 6).m2003getSurface0d7_KjU();
    L7:
        if ((r29 & 2) == 0) goto L9;
        long r8 = MaterialTheme.INSTANCE.getColors(r27, 6).m1999getPrimary0d7_KjU();
    L11:
        if ((r29 & 4) == 0) goto L13;
        long r12 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r27, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(r27, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(-2124406093, r28, -1, "androidx.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:434)");
    L17:
        DefaultButtonColors r0 = new DefaultButtonColors(r10, r8, r10, r12, null);
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r0;
    L13:
        r12 = r25;
        goto L15
    L9:
        r8 = r23;
        goto L11
    L5:
        r10 = r21;
        goto L7
    }

    /* JADX INFO: renamed from: textButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m1976textButtonColorsRGew2ao(long r19, long r21, long r23, Composer r25, int r26, int r27) {
        if ((r27 & 1) == 0) goto L5;
        long r8 = Color.Companion.getTransparent-0d7_KjU();
    L7:
        if ((r27 & 2) == 0) goto L9;
        long r6 = MaterialTheme.INSTANCE.getColors(r25, 6).m1999getPrimary0d7_KjU();
    L11:
        if ((r27 & 4) == 0) goto L13;
        long r10 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r25, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(r25, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(182742216, r26, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:456)");
    L17:
        DefaultButtonColors r0 = new DefaultButtonColors(r8, r6, r8, r10, null);
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r0;
    L13:
        r10 = r23;
        goto L15
    L9:
        r6 = r21;
        goto L11
    L5:
        r8 = r19;
        goto L7
    }

    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m1967buttonColorsro_MJ88(long r18, long r20, long r22, long r24, Composer r26, int r27, int r28) {
        if ((r28 & 1) == 0) goto L5;
        long r4 = MaterialTheme.INSTANCE.getColors(r26, 6).m1999getPrimary0d7_KjU();
    L7:
        if ((r28 & 2) == 0) goto L9;
        long r6 = ColorsKt.m2017contentColorForek8zF_U(r4, r26, r27 & 14);
    L11:
        if ((r28 & 4) == 0) goto L13;
        MaterialTheme r2 = MaterialTheme.INSTANCE;
        long r8 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r2.getColors(r26, 6).m1998getOnSurface0d7_KjU(), 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r2.getColors(r26, 6).m2003getSurface0d7_KjU());
    L15:
        if ((r28 & 8) == 0) goto L17;
        long r3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r26, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(r26, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(1870371134, r27, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:412)");
    L21:
        DefaultButtonColors r0 = new DefaultButtonColors(r4, r6, r8, r3, null);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r0;
    L17:
        r3 = r24;
        goto L19
    L13:
        r8 = r22;
        goto L15
    L9:
        r6 = r20;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    /* JADX INFO: renamed from: elevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m1968elevationR_JCAzs(float r8, float r9, float r10, float r11, float r12, Composer r13, int r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r8 = Dp.constructor-impl(2);
    L5:
        float r1 = r8;
        if ((r15 & 2) == 0) goto L8;
        r9 = Dp.constructor-impl(8);
    L8:
        float r2 = r9;
        boolean r16 = false;
        if ((r15 & 4) == 0) goto L11;
        r10 = Dp.constructor-impl(0);
    L11:
        float r3 = r10;
        if ((r15 & 8) == 0) goto L14;
        r11 = Dp.constructor-impl(4);
    L14:
        float r4 = r11;
        if ((r15 & 16) == 0) goto L17;
        r12 = Dp.constructor-impl(4);
    L17:
        float r5 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-737170518, r14, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:374)");
    L21:
        if (((r14 & 14) ^ 6) <= 4) goto L25;
        if (r13.changed(r1) == false) goto L25;
    L26:
        boolean r17 = true;
    L29:
        if (((r14 & 112) ^ 48) <= 32) goto L33;
        if (r13.changed(r2) == false) goto L33;
    L34:
        boolean r18 = true;
    L36:
        boolean r19 = r17 | r18;
        if (((r14 & 896) ^ 384) <= 256) goto L41;
        if (r13.changed(r3) == false) goto L41;
    L42:
        boolean r110 = true;
    L44:
        boolean r20 = r19 | r110;
        if (((r14 & 7168) ^ 3072) <= 2048) goto L49;
        if (r13.changed(r4) == false) goto L49;
    L50:
        boolean r111 = true;
    L52:
        boolean r21 = r20 | r111;
        if (((57344 & r14) ^ 24576) <= 16384) goto L57;
        if (r13.changed(r5) == false) goto L57;
    L58:
        r16 = true;
    L59:
        boolean r22 = r21 | r16;
        Object r23 = r13.rememberedValue();
        if (r22 == false) goto L62;
    L63:
        r23 = new DefaultButtonElevation(r1, r2, r3, r4, r5, null);
        r13.updateRememberedValue(r23);
    L64:
        DefaultButtonElevation r24 = (DefaultButtonElevation) r23;
        if (ComposerKt.isTraceInProgress() == false) goto L67;
        ComposerKt.traceEventEnd();
    L67:
        return r24;
    L62:
        if (r23 != Composer.Companion.getEmpty()) goto L64;
    L57:
        if ((r14 & 24576) != 16384) goto L59;
    L49:
        if ((r14 & 3072) == 2048) goto L50;
        r111 = false;
    L41:
        if ((r14 & 384) == 256) goto L42;
        r110 = false;
    L33:
        if ((r14 & 48) == 32) goto L34;
        r18 = false;
    L25:
        if ((r14 & 6) == 4) goto L26;
        r17 = false;
        goto L29
    }
}
