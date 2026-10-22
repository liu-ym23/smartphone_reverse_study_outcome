package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016JK\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0016JK\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u0016J\r\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001dJ7\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0004\b#\u0010$J\r\u0010)\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001dJ7\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0004\b*\u0010$J\r\u0010-\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001dJ7\u0010-\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u001fH\u0007¢\u0006\u0004\b.\u0010$J\u0017\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00105R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0018\u0010%\u001a\u00020\u001c*\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0018\u0010+\u001a\u00020\u001c*\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b,\u0010(R\u0018\u0010/\u001a\u00020\u001c*\u00020&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010(¨\u00066"}, d2 = {"Landroidx/compose/material3/CardDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedShape", "getElevatedShape", "outlinedShape", "getOutlinedShape", "cardElevation", "Landroidx/compose/material3/CardElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "cardElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardElevation;", "elevatedCardElevation", "elevatedCardElevation-aqJV_2Y", "outlinedCardElevation", "outlinedCardElevation-aqJV_2Y", "cardColors", "Landroidx/compose/material3/CardColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CardColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "cardColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardColors;", "defaultCardColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultCardColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CardColors;", "elevatedCardColors", "elevatedCardColors-ro_MJ88", "defaultElevatedCardColors", "getDefaultElevatedCardColors$material3", "outlinedCardColors", "outlinedCardColors-ro_MJ88", "defaultOutlinedCardColors", "getDefaultOutlinedCardColors$material3", "outlinedCardBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CardDefaults {
    public static final int $stable = 0;
    public static final CardDefaults INSTANCE = null;

    static {
        INSTANCE = new CardDefaults();
    }

    private CardDefaults() {
    }

    public final CardColors getDefaultCardColors$material3(ColorScheme r20) {
        CardColors r1 = r20.getDefaultCardColorsCached$material3();
        if (r1 != null) goto L6;
        FilledCardTokens r2 = FilledCardTokens.INSTANCE;
        CardColors r3 = new CardColors(ColorSchemeKt.fromToken(r20, r2.getContainerColor()), ColorSchemeKt.m2495contentColorFor4WTKRHQ(r20, ColorSchemeKt.fromToken(r20, r2.getContainerColor())), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r20, r2.getDisabledContainerColor()), r2.getDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r20, r2.getContainerColor())), Color.copy-wmQWz5c$default(ColorSchemeKt.m2495contentColorFor4WTKRHQ(r20, ColorSchemeKt.fromToken(r20, r2.getContainerColor())), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r20.setDefaultCardColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final CardColors getDefaultElevatedCardColors$material3(ColorScheme r20) {
        CardColors r1 = r20.getDefaultElevatedCardColorsCached$material3();
        if (r1 != null) goto L6;
        ElevatedCardTokens r2 = ElevatedCardTokens.INSTANCE;
        CardColors r3 = new CardColors(ColorSchemeKt.fromToken(r20, r2.getContainerColor()), ColorSchemeKt.m2495contentColorFor4WTKRHQ(r20, ColorSchemeKt.fromToken(r20, r2.getContainerColor())), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r20, r2.getDisabledContainerColor()), r2.getDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r20, r2.getDisabledContainerColor())), Color.copy-wmQWz5c$default(ColorSchemeKt.m2495contentColorFor4WTKRHQ(r20, ColorSchemeKt.fromToken(r20, r2.getContainerColor())), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r20.setDefaultElevatedCardColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final CardColors getDefaultOutlinedCardColors$material3(ColorScheme r20) {
        CardColors r1 = r20.getDefaultOutlinedCardColorsCached$material3();
        if (r1 != null) goto L6;
        OutlinedCardTokens r2 = OutlinedCardTokens.INSTANCE;
        CardColors r3 = new CardColors(ColorSchemeKt.fromToken(r20, r2.getContainerColor()), ColorSchemeKt.m2495contentColorFor4WTKRHQ(r20, ColorSchemeKt.fromToken(r20, r2.getContainerColor())), ColorSchemeKt.fromToken(r20, r2.getContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.m2495contentColorFor4WTKRHQ(r20, ColorSchemeKt.fromToken(r20, r2.getContainerColor())), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r20.setDefaultOutlinedCardColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final CardColors cardColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1876034303, r5, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:472)");
    L5:
        CardColors r6 = getDefaultCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final CardColors elevatedCardColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1610137975, r5, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:518)");
    L5:
        CardColors r6 = getDefaultElevatedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getElevatedShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-133496185, r5, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:374)");
    L5:
        Shape r6 = ShapesKt.getValue(ElevatedCardTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getOutlinedShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1095404023, r5, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:378)");
    L5:
        Shape r6 = ShapesKt.getValue(OutlinedCardTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1266660211, r5, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:370)");
    L5:
        Shape r6 = ShapesKt.getValue(FilledCardTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final CardColors outlinedCardColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1204388929, r5, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:567)");
    L5:
        CardColors r6 = getDefaultOutlinedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final BorderStroke outlinedCardBorder(boolean r9, Composer r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r9 = true;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L9;
        ComposerKt.traceEventStart(-392936593, r11, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:613)");
    L9:
        if (r9 == false) goto L11;
        r10.startReplaceGroup(2106932974);
        long r13 = ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getOutlineColor(), r10, 6);
        r10.endReplaceGroup();
    L12:
        boolean r14 = r10.changed(r13);
        Object r0 = r10.rememberedValue();
        if (r14 == false) goto L15;
    L16:
        r0 = BorderStrokeKt.m369BorderStrokecXLIe8U(OutlinedCardTokens.INSTANCE.getOutlineWidth-D9Ej5fM(), r13);
        r10.updateRememberedValue(r0);
    L17:
        BorderStroke r1 = (BorderStroke) r0;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r1;
    L15:
        if (r0 != Composer.Companion.getEmpty()) goto L17;
    L11:
        r10.startReplaceGroup(2107012365);
        r13 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getDisabledOutlineColor(), r10, 6), 0.12f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.getValue(ElevatedCardTokens.INSTANCE.getContainerColor(), r10, 6));
        r10.endReplaceGroup();
        goto L12
    }

    /* JADX INFO: renamed from: cardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m2370cardColorsro_MJ88(long r15, long r17, long r19, long r21, Composer r23, int r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r25 & 2) == 0) goto L9;
        long r4 = ColorSchemeKt.m2496contentColorForek8zF_U(r2, r23, r24 & 14);
    L11:
        if ((r25 & 4) == 0) goto L13;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r25 & 8) == 0) goto L17;
        long r8 = Color.copy-wmQWz5c$default(r4, 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-1589582123, r24, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:490)");
    L21:
        CardColors r0 = getDefaultCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(r23, 6)).m2365copyjRlVdoo(r2, r4, r6, r8);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r0;
    L17:
        r8 = r21;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r4 = r17;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    /* JADX INFO: renamed from: elevatedCardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m2372elevatedCardColorsro_MJ88(long r15, long r17, long r19, long r21, Composer r23, int r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r25 & 2) == 0) goto L9;
        long r4 = ColorSchemeKt.m2496contentColorForek8zF_U(r2, r23, r24 & 14);
    L11:
        if ((r25 & 4) == 0) goto L13;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r25 & 8) == 0) goto L17;
        long r8 = Color.copy-wmQWz5c$default(r4, 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(139558303, r24, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:536)");
    L21:
        CardColors r0 = getDefaultElevatedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(r23, 6)).m2365copyjRlVdoo(r2, r4, r6, r8);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r0;
    L17:
        r8 = r21;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r4 = r17;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    /* JADX INFO: renamed from: outlinedCardColors-ro_MJ88, reason: not valid java name */
    public final CardColors m2374outlinedCardColorsro_MJ88(long r17, long r19, long r21, long r23, Composer r25, int r26, int r27) {
        if ((r27 & 1) == 0) goto L5;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r27 & 2) == 0) goto L9;
        long r4 = ColorSchemeKt.m2496contentColorForek8zF_U(r2, r25, r26 & 14);
    L11:
        if ((r27 & 4) == 0) goto L13;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r27 & 8) == 0) goto L17;
        long r8 = Color.copy-wmQWz5c$default(ColorSchemeKt.m2496contentColorForek8zF_U(r2, r25, r26 & 14), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-1112362409, r26, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:585)");
    L21:
        CardColors r0 = getDefaultOutlinedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(r25, 6)).m2365copyjRlVdoo(r2, r4, r6, r8);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r0;
    L17:
        r8 = r23;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    /* JADX INFO: renamed from: cardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m2371cardElevationaqJV_2Y(float r6, float r7, float r8, float r9, float r10, float r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r6 = FilledCardTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L6:
        if ((r14 & 2) == 0) goto L8;
        r7 = FilledCardTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
    L8:
        float r15 = r7;
        if ((r14 & 4) == 0) goto L11;
        r8 = FilledCardTokens.INSTANCE.getFocusContainerElevation-D9Ej5fM();
    L11:
        float r0 = r8;
        if ((r14 & 8) == 0) goto L14;
        r9 = FilledCardTokens.INSTANCE.getHoverContainerElevation-D9Ej5fM();
    L14:
        float r1 = r9;
        if ((r14 & 16) == 0) goto L17;
        r10 = FilledCardTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM();
    L17:
        float r2 = r10;
        if ((r14 & 32) == 0) goto L20;
        r11 = FilledCardTokens.INSTANCE.getDisabledContainerElevation-D9Ej5fM();
    L20:
        float r16 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventStart(-574898487, r13, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:400)");
    L23:
        CardElevation r3 = new CardElevation(r6, r15, r0, r1, r2, r16, null);
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventEnd();
    L26:
        return r3;
    }

    /* JADX INFO: renamed from: elevatedCardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m2373elevatedCardElevationaqJV_2Y(float r6, float r7, float r8, float r9, float r10, float r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r6 = ElevatedCardTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L6:
        if ((r14 & 2) == 0) goto L8;
        r7 = ElevatedCardTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
    L8:
        float r15 = r7;
        if ((r14 & 4) == 0) goto L11;
        r8 = ElevatedCardTokens.INSTANCE.getFocusContainerElevation-D9Ej5fM();
    L11:
        float r0 = r8;
        if ((r14 & 8) == 0) goto L14;
        r9 = ElevatedCardTokens.INSTANCE.getHoverContainerElevation-D9Ej5fM();
    L14:
        float r1 = r9;
        if ((r14 & 16) == 0) goto L17;
        r10 = ElevatedCardTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM();
    L17:
        float r2 = r10;
        if ((r14 & 32) == 0) goto L20;
        r11 = ElevatedCardTokens.INSTANCE.getDisabledContainerElevation-D9Ej5fM();
    L20:
        float r16 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventStart(1154241939, r13, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:430)");
    L23:
        CardElevation r3 = new CardElevation(r6, r15, r0, r1, r2, r16, null);
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventEnd();
    L26:
        return r3;
    }

    /* JADX INFO: renamed from: outlinedCardElevation-aqJV_2Y, reason: not valid java name */
    public final CardElevation m2375outlinedCardElevationaqJV_2Y(float r6, float r7, float r8, float r9, float r10, float r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r6 = OutlinedCardTokens.INSTANCE.getContainerElevation-D9Ej5fM();
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
        r10 = OutlinedCardTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM();
    L20:
        float r2 = r10;
        if ((r14 & 32) == 0) goto L23;
        r11 = OutlinedCardTokens.INSTANCE.getDisabledContainerElevation-D9Ej5fM();
    L23:
        float r16 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-97678773, r13, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:459)");
    L26:
        CardElevation r3 = new CardElevation(r6, r15, r0, r1, r2, r16, null);
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventEnd();
    L29:
        return r3;
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
