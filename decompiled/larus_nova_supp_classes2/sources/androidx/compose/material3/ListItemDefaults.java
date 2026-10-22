package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015Ji\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010 \u001a\u00020\u0014*\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/compose/material3/ListItemDefaults;", "", "<init>", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "colors", "Landroidx/compose/material3/ListItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ListItemColors;", "headlineColor", "leadingIconColor", "overlineColor", "supportingColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "colors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemColors;", "defaultListItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultListItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ListItemColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ListItemDefaults {
    public static final int $stable = 0;
    private static final float Elevation = 0.0f;
    public static final ListItemDefaults INSTANCE = null;

    private ListItemDefaults() {
    }

    static {
        INSTANCE = new ListItemDefaults();
        Elevation = ListTokens.INSTANCE.getListItemContainerElevation-D9Ej5fM();
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m2827getElevationD9Ej5fM() {
        return Elevation;
    }

    public final ListItemColors getDefaultListItemColors$material3(ColorScheme r32) {
        ListItemColors r1 = r32.getDefaultListItemColorsCached$material3();
        if (r1 != null) goto L6;
        ListTokens r19 = ListTokens.INSTANCE;
        ListItemColors r2 = new ListItemColors(ColorSchemeKt.fromToken(r32, r19.getListItemContainerColor()), ColorSchemeKt.fromToken(r32, r19.getListItemLabelTextColor()), ColorSchemeKt.fromToken(r32, r19.getListItemLeadingIconColor()), ColorSchemeKt.fromToken(r32, r19.getListItemOverlineColor()), ColorSchemeKt.fromToken(r32, r19.getListItemSupportingTextColor()), ColorSchemeKt.fromToken(r32, r19.getListItemTrailingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r32, r19.getListItemDisabledLabelTextColor()), r19.getListItemDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r32, r19.getListItemDisabledLeadingIconColor()), r19.getListItemDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r32, r19.getListItemDisabledTrailingIconColor()), r19.getListItemDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r32.setDefaultListItemColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public final ListItemColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-552214416, r5, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:546)");
    L5:
        ListItemColors r6 = getDefaultListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getContainerColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1253579929, r5, -1, "androidx.compose.material3.ListItemDefaults.<get-containerColor> (ListItem.kt:536)");
    L5:
        long r6 = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getContentColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1076068327, r5, -1, "androidx.compose.material3.ListItemDefaults.<get-contentColor> (ListItem.kt:540)");
    L5:
        long r6 = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemLabelTextColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-496871597, r5, -1, "androidx.compose.material3.ListItemDefaults.<get-shape> (ListItem.kt:532)");
    L5:
        Shape r6 = ShapesKt.getValue(ListTokens.INSTANCE.getListItemContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: colors-J08w3-E, reason: not valid java name */
    public final ListItemColors m2826colorsJ08w3E(long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, Composer r42, int r43, int r44) {
        if ((r44 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r44 & 2) == 0) goto L9;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r44 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r44 & 8) == 0) goto L17;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r44 & 16) == 0) goto L21;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r44 & 32) == 0) goto L25;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r44 & 64) == 0) goto L29;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L31:
        if ((r44 & 128) == 0) goto L33;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L35:
        if ((r44 & 256) == 0) goto L37;
        long r17 = Color.Companion.getUnspecified-0d7_KjU();
    L39:
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventStart(-352515689, r43, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:576)");
    L42:
        ListItemColors r0 = getDefaultListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(r42, 6)).m2811copy5r9EGqc(r1, r3, r5, r7, r9, r11, r13, r15, r17);
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventEnd();
    L45:
        return r0;
    L37:
        r17 = r40;
        goto L39
    L33:
        r15 = r38;
        goto L35
    L29:
        r13 = r36;
        goto L31
    L25:
        r11 = r34;
        goto L27
    L21:
        r9 = r32;
        goto L23
    L17:
        r7 = r30;
        goto L19
    L13:
        r5 = r28;
        goto L15
    L9:
        r3 = r26;
        goto L11
    L5:
        r1 = r24;
        goto L7
    }
}
