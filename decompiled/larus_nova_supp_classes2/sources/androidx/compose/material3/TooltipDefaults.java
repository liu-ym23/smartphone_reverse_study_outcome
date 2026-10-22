package androidx.compose.material3;

import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0017\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"J7\u0010 \u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\tH\u0007¢\u0006\u0004\b'\u0010(J\u0019\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u0016H\u0007¢\u0006\u0004\b0\u00101J\u0019\u00102\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u0016H\u0007¢\u0006\u0004\b3\u00101J\u0019\u00104\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u0016H\u0007¢\u0006\u0004\b5\u00101J!\u00104\u001a\u00020.2\u0006\u00106\u001a\u0002072\b\b\u0002\u0010/\u001a\u00020\u0016H\u0007¢\u0006\u0004\b8\u00109R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0013\u0010\u0010\u001a\u00020\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\u00020\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u00020\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010)\u001a\u00020!*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010:\u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006="}, d2 = {"Landroidx/compose/material3/TooltipDefaults;", "", "<init>", "()V", "plainTooltipContainerShape", "Landroidx/compose/ui/graphics/Shape;", "getPlainTooltipContainerShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "plainTooltipContainerColor", "Landroidx/compose/ui/graphics/Color;", "getPlainTooltipContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "plainTooltipContentColor", "getPlainTooltipContentColor", "richTooltipContainerShape", "getRichTooltipContainerShape", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "getCaretSize-MYxV2XQ", "()J", "J", "plainTooltipMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getPlainTooltipMaxWidth-D9Ej5fM", "()F", "F", "richTooltipMaxWidth", "getRichTooltipMaxWidth-D9Ej5fM", "caretShape", "Landroidx/compose/material3/DefaultTooltipCaretShape;", "caretShape-EaSLcWc", "(J)Landroidx/compose/ui/graphics/Shape;", "richTooltipColors", "Landroidx/compose/material3/RichTooltipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/RichTooltipColors;", "containerColor", "contentColor", "titleContentColor", "actionContentColor", "richTooltipColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RichTooltipColors;", "defaultRichTooltipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultRichTooltipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/RichTooltipColors;", "rememberPlainTooltipPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "spacingBetweenTooltipAndAnchor", "rememberPlainTooltipPositionProvider-kHDZbjc", "(FLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/window/PopupPositionProvider;", "rememberRichTooltipPositionProvider", "rememberRichTooltipPositionProvider-kHDZbjc", "rememberTooltipPositionProvider", "rememberTooltipPositionProvider-kHDZbjc", "positioning", "Landroidx/compose/material3/TooltipAnchorPosition;", "rememberTooltipPositionProvider-Hu5FAss", "(IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/window/PopupPositionProvider;", "DefaultCaretShape", "getDefaultCaretShape$material3", "()Landroidx/compose/material3/DefaultTooltipCaretShape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TooltipDefaults {
    public static final int $stable = 0;
    private static final DefaultTooltipCaretShape DefaultCaretShape = null;
    public static final TooltipDefaults INSTANCE = null;
    private static final long caretSize = 0;
    private static final float plainTooltipMaxWidth = 0.0f;
    private static final float richTooltipMaxWidth = 0.0f;

    private TooltipDefaults() {
    }

    static {
        INSTANCE = new TooltipDefaults();
        long r0 = DpKt.DpSize-YgX7TsA(Dp.constructor-impl(16), Dp.constructor-impl(8));
        caretSize = r0;
        plainTooltipMaxWidth = Dp.constructor-impl(200);
        richTooltipMaxWidth = Dp.constructor-impl(320);
        DefaultCaretShape = new DefaultTooltipCaretShape(r0, null);
    }

    public final DefaultTooltipCaretShape caretShape() {
        return DefaultCaretShape;
    }

    /* JADX INFO: renamed from: getCaretSize-MYxV2XQ, reason: not valid java name */
    public final long m3544getCaretSizeMYxV2XQ() {
        return caretSize;
    }

    public final DefaultTooltipCaretShape getDefaultCaretShape$material3() {
        return DefaultCaretShape;
    }

    /* JADX INFO: renamed from: getPlainTooltipMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m3545getPlainTooltipMaxWidthD9Ej5fM() {
        return plainTooltipMaxWidth;
    }

    /* JADX INFO: renamed from: getRichTooltipMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m3546getRichTooltipMaxWidthD9Ej5fM() {
        return richTooltipMaxWidth;
    }

    /* JADX INFO: renamed from: caretShape-EaSLcWc, reason: not valid java name */
    public final Shape m3543caretShapeEaSLcWc(long r3) {
        return new DefaultTooltipCaretShape(r3, null);
    }

    public final RichTooltipColors getDefaultRichTooltipColors$material3(ColorScheme r12) {
        RichTooltipColors r0 = r12.getDefaultRichTooltipColorsCached$material3();
        if (r0 != null) goto L6;
        RichTooltipTokens r1 = RichTooltipTokens.INSTANCE;
        RichTooltipColors r2 = new RichTooltipColors(ColorSchemeKt.fromToken(r12, r1.getContainerColor()), ColorSchemeKt.fromToken(r12, r1.getSupportingTextColor()), ColorSchemeKt.fromToken(r12, r1.getSubheadColor()), ColorSchemeKt.fromToken(r12, r1.getActionLabelTextColor()), null);
        r12.setDefaultRichTooltipColorsCached$material3(r2);
        return r2;
    L6:
        return r0;
    }

    public final long getPlainTooltipContainerColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(102696215, r5, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerColor> (Tooltip.kt:626)");
    L5:
        long r6 = ColorSchemeKt.getValue(PlainTooltipTokens.INSTANCE.getContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getPlainTooltipContainerShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(49570325, r5, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerShape> (Tooltip.kt:622)");
    L5:
        Shape r6 = ShapesKt.getValue(PlainTooltipTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getPlainTooltipContentColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1982928937, r5, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContentColor> (Tooltip.kt:630)");
    L5:
        long r6 = ColorSchemeKt.getValue(PlainTooltipTokens.INSTANCE.getSupportingTextColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getRichTooltipContainerShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1138709783, r5, -1, "androidx.compose.material3.TooltipDefaults.<get-richTooltipContainerShape> (Tooltip.kt:634)");
    L5:
        Shape r6 = ShapesKt.getValue(RichTooltipTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final RichTooltipColors richTooltipColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1622312141, r5, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:660)");
    L5:
        RichTooltipColors r6 = getDefaultRichTooltipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: caretShape-EaSLcWc$default, reason: not valid java name */
    public static /* synthetic */ Shape m3542caretShapeEaSLcWc$default(TooltipDefaults r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = caretSize;
    L6:
        return r0.m3543caretShapeEaSLcWc(r1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of rememberTooltipPositionProvider API.", replaceWith = @ReplaceWith(expression = "rememberTooltipPositionProvider(spacingBetweenTooltipAndAnchor)", imports = {}))
    /* JADX INFO: renamed from: rememberPlainTooltipPositionProvider-kHDZbjc, reason: not valid java name */
    public final PopupPositionProvider m3547rememberPlainTooltipPositionProviderkHDZbjc(float r3, Composer r4, int r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = TooltipKt.getSpacingBetweenTooltipAndAnchor();
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(1047866909, r5, -1, "androidx.compose.material3.TooltipDefaults.rememberPlainTooltipPositionProvider (Tooltip.kt:707)");
    L8:
        final int r7 = ((Density) r4.consume(CompositionLocalsKt.getLocalDensity())).roundToPx-0680j_4(r3);
        boolean r8 = r4.changed(r7);
        Object r9 = r4.rememberedValue();
        if (r8 == false) goto L11;
    L12:
        r9 = new TooltipDefaults$rememberPlainTooltipPositionProvider$1$1(r7);
        r4.updateRememberedValue(r9);
    L13:
        TooltipDefaults$rememberPlainTooltipPositionProvider$1$1 r10 = (TooltipDefaults$rememberPlainTooltipPositionProvider$1$1) r9;
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        return r10;
    L11:
        if (r9 != Composer.Companion.getEmpty()) goto L13;
        goto L12
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of rememberTooltipPositionProvider API.", replaceWith = @ReplaceWith(expression = "rememberTooltipPositionProvider(spacingBetweenTooltipAndAnchor)", imports = {}))
    /* JADX INFO: renamed from: rememberRichTooltipPositionProvider-kHDZbjc, reason: not valid java name */
    public final PopupPositionProvider m3548rememberRichTooltipPositionProviderkHDZbjc(float r3, Composer r4, int r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = TooltipKt.getSpacingBetweenTooltipAndAnchor();
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(-1538806795, r5, -1, "androidx.compose.material3.TooltipDefaults.rememberRichTooltipPositionProvider (Tooltip.kt:746)");
    L8:
        final int r7 = ((Density) r4.consume(CompositionLocalsKt.getLocalDensity())).roundToPx-0680j_4(r3);
        boolean r8 = r4.changed(r7);
        Object r9 = r4.rememberedValue();
        if (r8 == false) goto L11;
    L12:
        r9 = new TooltipDefaults$rememberRichTooltipPositionProvider$1$1(r7);
        r4.updateRememberedValue(r9);
    L13:
        TooltipDefaults$rememberRichTooltipPositionProvider$1$1 r10 = (TooltipDefaults$rememberRichTooltipPositionProvider$1$1) r9;
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        return r10;
    L11:
        if (r9 != Composer.Companion.getEmpty()) goto L13;
        goto L12
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of rememberTooltipPositionProvider API that takes a preferred positioning. Please use rememberTooltipPositionProvider with TooltipAnchorPosition.Above if this same behavior is desired.", replaceWith = @ReplaceWith(expression = "rememberTooltipPositionProvider(TooltipAnchorPosition.ABOVE, spacingBetweenTooltipAndAnchor)", imports = {}))
    /* JADX INFO: renamed from: rememberTooltipPositionProvider-kHDZbjc, reason: not valid java name */
    public final PopupPositionProvider m3550rememberTooltipPositionProviderkHDZbjc(float r3, Composer r4, int r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = TooltipKt.getSpacingBetweenTooltipAndAnchor();
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(-1613894159, r5, -1, "androidx.compose.material3.TooltipDefaults.rememberTooltipPositionProvider (Tooltip.kt:799)");
    L8:
        final int r7 = ((Density) r4.consume(CompositionLocalsKt.getLocalDensity())).roundToPx-0680j_4(r3);
        boolean r8 = r4.changed(r7);
        Object r9 = r4.rememberedValue();
        if (r8 == false) goto L11;
    L12:
        r9 = new TooltipDefaults$rememberTooltipPositionProvider$1$1(r7);
        r4.updateRememberedValue(r9);
    L13:
        TooltipDefaults$rememberTooltipPositionProvider$1$1 r10 = (TooltipDefaults$rememberTooltipPositionProvider$1$1) r9;
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        return r10;
    L11:
        if (r9 != Composer.Companion.getEmpty()) goto L13;
        goto L12
    }

    /* JADX INFO: renamed from: rememberTooltipPositionProvider-Hu5FAss, reason: not valid java name */
    public final PopupPositionProvider m3549rememberTooltipPositionProviderHu5FAss(int r3, float r4, Composer r5, int r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = TooltipKt.getSpacingBetweenTooltipAndAnchor();
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(-573803578, r6, -1, "androidx.compose.material3.TooltipDefaults.rememberTooltipPositionProvider (Tooltip.kt:849)");
    L8:
        int r8 = ((Density) r5.consume(CompositionLocalsKt.getLocalDensity())).roundToPx-0680j_4(r4);
        boolean r9 = r5.changed(r8);
        if (((r6 & 14) ^ 6) <= 4) goto L13;
        if (r5.changed(r3) == false) goto L13;
    L14:
        boolean r10 = true;
    L16:
        boolean r11 = r10 | r9;
        Object r12 = r5.rememberedValue();
        if (r11 == false) goto L19;
    L20:
        r12 = new TooltipPositionProviderImpl(r3, r8, null);
        r5.updateRememberedValue(r12);
    L21:
        TooltipPositionProviderImpl r13 = (TooltipPositionProviderImpl) r12;
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r13;
    L19:
        if (r12 != Composer.Companion.getEmpty()) goto L21;
    L13:
        if ((r6 & 6) == 4) goto L14;
        r10 = false;
        goto L16
    }

    /* JADX INFO: renamed from: richTooltipColors-ro_MJ88, reason: not valid java name */
    public final RichTooltipColors m3551richTooltipColorsro_MJ88(long r13, long r15, long r17, long r19, Composer r21, int r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r23 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(1498555081, r22, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:673)");
    L21:
        RichTooltipColors r1 = getDefaultRichTooltipColors$material3(MaterialTheme.INSTANCE.getColorScheme(r21, 6)).m3024copyjRlVdoo(r0, r2, r4, r6);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r1;
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }
}
