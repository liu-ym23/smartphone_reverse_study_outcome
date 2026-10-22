package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a/\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\"\u000e\u0010\u0018\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "calculateSelectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "selectionColor", "textColor", "backgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "binarySearchForAccessibleSelectionColorAlpha", "", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "DefaultSelectionBackgroundAlpha", "MinimumSelectionBackgroundAlpha", "DesiredContrastRatio", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    /* JADX INFO: renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m2089calculateContrastRatioOWjLjI(long r0, long r2) {
        float r1 = ColorKt.luminance-8_81llA(r0) + 0.05f;
        float r3 = ColorKt.luminance-8_81llA(r2) + 0.05f;
        return Math.max(r1, r3) / Math.min(r1, r3);
    }

    /* JADX INFO: renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m2088binarySearchForAccessibleSelectionColorAlphaysEtTa8(long r12, long r14, long r16) {
        float r1 = 0.2f;
        float r9 = 0.4f;
        float r10 = 0.4f;
        int r11 = 0;
    L4:
        if (r11 >= 7) goto L17;
        float r2 = (m2090calculateContrastRationb2GgbA(r12, r9, r14, r16) / DesiredContrastRatio) - 1.0f;
        if (androidx.compose.material3.MenuKt.ClosedAlphaTarget <= r2) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == true) goto L17;
        if (r2 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L15;
        r10 = r9;
    L16:
        r9 = (r10 + r1) / 2.0f;
        r11 = r11 + 1;
        goto L4
    L15:
        r1 = r9;
        goto L16
    L8:
        if (r2 > 0.01f) goto L10;
        r4 = true;
    L17:
        return r9;
    }

    /* JADX INFO: renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m2091calculateSelectionBackgroundColorysEtTa8(long r8, long r10, long r12) {
        float r0 = m2090calculateContrastRationb2GgbA(r8, 0.4f, r10, r12);
        float r1 = m2090calculateContrastRationb2GgbA(r8, 0.2f, r10, r12);
        if (r0 < DesiredContrastRatio) goto L6;
        float r2 = 0.4f;
    L10:
        return Color.copy-wmQWz5c$default(r8, r2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L6:
        if (r1 >= DesiredContrastRatio) goto L8;
        r2 = 0.2f;
        goto L10
    L8:
        r2 = m2088binarySearchForAccessibleSelectionColorAlphaysEtTa8(r8, r10, r12);
        goto L10
    }

    public static final TextSelectionColors rememberTextSelectionColors(Colors r18, Composer r19, int r20) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-721696685, r20, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
    L5:
        long r4 = r18.m1999getPrimary0d7_KjU();
        long r8 = r18.m1992getBackground0d7_KjU();
        r19.startReplaceGroup(-2060761573);
        long r2 = ColorsKt.m2016contentColorFor4WTKRHQ(r18, r8);
        if (r2 == 16) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L12;
        r2 = ((Color) r19.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L12:
        r19.endReplaceGroup();
        long r7 = Color.copy-wmQWz5c$default(r2, ContentAlpha.INSTANCE.getMedium(r19, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        boolean r3 = (r19.changed(r4) | r19.changed(r8)) | r19.changed(r7);
        Object r5 = r19.rememberedValue();
        if (r3 == false) goto L15;
    L16:
        r5 = new TextSelectionColors(r18.m1999getPrimary0d7_KjU(), m2091calculateSelectionBackgroundColorysEtTa8(r4, r7, r8), null);
        r19.updateRememberedValue(r5);
    L17:
        TextSelectionColors r9 = (TextSelectionColors) r5;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r9;
    L15:
        if (r5 != Composer.Companion.getEmpty()) goto L17;
    L8:
        r6 = false;
        goto L9
    }

    /* JADX INFO: renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m2090calculateContrastRationb2GgbA(long r8, float r10, long r11, long r13) {
        long r9 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r8, r10, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r13);
        return m2089calculateContrastRatioOWjLjI(ColorKt.compositeOver--OWjLjI(r11, r9), r9);
    }
}
