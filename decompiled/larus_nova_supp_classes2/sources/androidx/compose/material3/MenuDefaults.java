package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015JK\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u001e\u001a\u00020\u0014*\u00020\u001f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/compose/material3/MenuDefaults;", "", "<init>", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "ShadowElevation", "getShadowElevation-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "itemColors", "Landroidx/compose/material3/MenuItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemColors;", "textColor", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "itemColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemColors;", "defaultMenuItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultMenuItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/MenuItemColors;", "DropdownMenuItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDropdownMenuItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MenuDefaults {
    public static final int $stable = 0;
    private static final PaddingValues DropdownMenuItemContentPadding = null;
    public static final MenuDefaults INSTANCE = null;
    private static final float ShadowElevation = 0.0f;
    private static final float TonalElevation = 0.0f;

    private MenuDefaults() {
    }

    static {
        INSTANCE = new MenuDefaults();
        TonalElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        ShadowElevation = MenuTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        DropdownMenuItemContentPadding = PaddingKt.m954PaddingValuesYgX7TsA(MenuKt.access$getDropdownMenuItemHorizontalPadding$p(), Dp.constructor-impl(0));
    }

    public final PaddingValues getDropdownMenuItemContentPadding() {
        return DropdownMenuItemContentPadding;
    }

    /* JADX INFO: renamed from: getShadowElevation-D9Ej5fM, reason: not valid java name */
    public final float m2851getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m2852getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final MenuItemColors getDefaultMenuItemColors$material3(ColorScheme r23) {
        MenuItemColors r1 = r23.getDefaultMenuItemColorsCached$material3();
        if (r1 != null) goto L6;
        ListTokens r2 = ListTokens.INSTANCE;
        MenuItemColors r3 = new MenuItemColors(ColorSchemeKt.fromToken(r23, r2.getListItemLabelTextColor()), ColorSchemeKt.fromToken(r23, r2.getListItemLeadingIconColor()), ColorSchemeKt.fromToken(r23, r2.getListItemTrailingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r23, r2.getListItemDisabledLabelTextColor()), r2.getListItemDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r23, r2.getListItemDisabledLeadingIconColor()), r2.getListItemDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r23, r2.getListItemDisabledTrailingIconColor()), r2.getListItemDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r23.setDefaultMenuItemColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final long getContainerColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1787427929, r5, -1, "androidx.compose.material3.MenuDefaults.<get-containerColor> (Menu.kt:193)");
    L5:
        long r6 = ColorSchemeKt.getValue(MenuTokens.INSTANCE.getContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(218702739, r5, -1, "androidx.compose.material3.MenuDefaults.<get-shape> (Menu.kt:189)");
    L5:
        Shape r6 = ShapesKt.getValue(MenuTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final MenuItemColors itemColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1326531516, r5, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:199)");
    L5:
        MenuItemColors r6 = getDefaultMenuItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: itemColors-5tl4gsc, reason: not valid java name */
    public final MenuItemColors m2853itemColors5tl4gsc(long r17, long r19, long r21, long r23, long r25, long r27, Composer r29, int r30, int r31) {
        if ((r31 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r31 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r31 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r31 & 8) == 0) goto L17;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r31 & 16) == 0) goto L21;
        long r8 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r31 & 32) == 0) goto L25;
        long r10 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(-1278543580, r30, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:224)");
    L29:
        MenuItemColors r1 = getDefaultMenuItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(r29, 6)).m2855copytNS2XkQ(r0, r2, r4, r6, r8, r10);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        return r1;
    L25:
        r10 = r27;
        goto L27
    L21:
        r8 = r25;
        goto L23
    L17:
        r6 = r23;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r2 = r19;
        goto L11
    L5:
        r0 = r17;
        goto L7
    }
}
