package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JU\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\u0005*\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/ShortNavigationBarItemDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/NavigationItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationItemColors;", "defaultShortNavigationBarItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultShortNavigationBarItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationItemColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ShortNavigationBarItemDefaults {
    public static final int $stable = 0;
    public static final ShortNavigationBarItemDefaults INSTANCE = null;

    static {
        INSTANCE = new ShortNavigationBarItemDefaults();
    }

    private ShortNavigationBarItemDefaults() {
    }

    public final NavigationItemColors getDefaultShortNavigationBarItemColors$material3(ColorScheme r24) {
        NavigationItemColors r1 = r24.getDefaultShortNavigationBarItemColorsCached$material3();
        if (r1 != null) goto L6;
        NavigationBarTokens r2 = NavigationBarTokens.INSTANCE;
        NavigationItemColors r3 = new NavigationItemColors(ColorSchemeKt.fromToken(r24, r2.getItemActiveIconColor()), ColorSchemeKt.fromToken(r24, r2.getItemActiveLabelTextColor()), ColorSchemeKt.fromToken(r24, r2.getItemActiveIndicatorColor()), ColorSchemeKt.fromToken(r24, r2.getItemInactiveIconColor()), ColorSchemeKt.fromToken(r24, r2.getItemInactiveLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r24, r2.getItemInactiveIconColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r24, r2.getItemInactiveLabelTextColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r24.setDefaultShortNavigationBarItemColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final NavigationItemColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(954437293, r5, -1, "androidx.compose.material3.ShortNavigationBarItemDefaults.colors (ShortNavigationBar.kt:287)");
    L5:
        NavigationItemColors r6 = getDefaultShortNavigationBarItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: colors-69fazGs, reason: not valid java name */
    public final NavigationItemColors m3129colors69fazGs(long r23, long r25, long r27, long r29, long r31, long r33, long r35, Composer r37, int r38, int r39) {
        if ((r39 & 1) == 0) goto L5;
        long r3 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIconColor(), r37, 6);
    L7:
        if ((r39 & 2) == 0) goto L9;
        long r5 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveLabelTextColor(), r37, 6);
    L11:
        if ((r39 & 4) == 0) goto L13;
        long r7 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorColor(), r37, 6);
    L15:
        if ((r39 & 8) == 0) goto L17;
        long r9 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemInactiveIconColor(), r37, 6);
    L19:
        if ((r39 & 16) == 0) goto L21;
        long r11 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor(), r37, 6);
    L23:
        if ((r39 & 32) == 0) goto L25;
        long r13 = Color.copy-wmQWz5c$default(r9, 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if ((r39 & 64) == 0) goto L29;
        long r15 = Color.copy-wmQWz5c$default(r11, 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(1801697574, r38, -1, "androidx.compose.material3.ShortNavigationBarItemDefaults.colors (ShortNavigationBar.kt:312)");
    L34:
        NavigationItemColors r0 = getDefaultShortNavigationBarItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(r37, 6)).m2914copy4JmcsL4(r3, r5, r7, r9, r11, r13, r15);
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
    L37:
        return r0;
    L29:
        r15 = r35;
        goto L31
    L25:
        r13 = r33;
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
}
