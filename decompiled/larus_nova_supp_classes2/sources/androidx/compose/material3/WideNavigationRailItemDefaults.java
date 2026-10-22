package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationRailColorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\fJU\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u00020\u000b*\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/WideNavigationRailItemDefaults;", "", "<init>", "()V", "iconPositionFor", "Landroidx/compose/material3/NavigationItemIconPosition;", "railExpanded", "", "iconPositionFor-s8pcRp0", "(Z)I", "colors", "Landroidx/compose/material3/NavigationItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationItemColors;", "defaultWideNavigationRailItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultWideNavigationRailItemColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationItemColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailItemDefaults {
    public static final int $stable = 0;
    public static final WideNavigationRailItemDefaults INSTANCE = null;

    static {
        INSTANCE = new WideNavigationRailItemDefaults();
    }

    private WideNavigationRailItemDefaults() {
    }

    private final NavigationItemColors getDefaultWideNavigationRailItemColors(ColorScheme r24) {
        NavigationItemColors r1 = r24.getDefaultWideNavigationRailItemColorsCached$material3();
        if (r1 != null) goto L6;
        NavigationRailColorTokens r2 = NavigationRailColorTokens.INSTANCE;
        NavigationItemColors r3 = new NavigationItemColors(ColorSchemeKt.fromToken(r24, r2.getItemActiveIcon()), ColorSchemeKt.fromToken(r24, r2.getItemActiveLabelText()), ColorSchemeKt.fromToken(r24, r2.getItemActiveIndicator()), ColorSchemeKt.fromToken(r24, r2.getItemInactiveIcon()), ColorSchemeKt.fromToken(r24, r2.getItemInactiveLabelText()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r24, r2.getItemInactiveIcon()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r24, r2.getItemInactiveLabelText()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r24.setDefaultWideNavigationRailItemColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    /* JADX INFO: renamed from: iconPositionFor-s8pcRp0, reason: not valid java name */
    public final int m3615iconPositionFors8pcRp0(boolean r1) {
        if (r1 == false) goto L5;
        return NavigationItemIconPosition.Companion.m2931getStartxw1Ddg();
    L5:
        return NavigationItemIconPosition.Companion.m2932getTopxw1Ddg();
    }

    public final NavigationItemColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(911821421, r5, -1, "androidx.compose.material3.WideNavigationRailItemDefaults.colors (WideNavigationRail.kt:889)");
    L5:
        NavigationItemColors r6 = getDefaultWideNavigationRailItemColors(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: colors-69fazGs, reason: not valid java name */
    public final NavigationItemColors m3614colors69fazGs(long r23, long r25, long r27, long r29, long r31, long r33, long r35, Composer r37, int r38, int r39) {
        if ((r39 & 1) == 0) goto L5;
        long r3 = ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveIcon(), r37, 6);
    L7:
        if ((r39 & 2) == 0) goto L9;
        long r5 = ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveLabelText(), r37, 6);
    L11:
        if ((r39 & 4) == 0) goto L13;
        long r7 = ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemActiveIndicator(), r37, 6);
    L15:
        if ((r39 & 8) == 0) goto L17;
        long r9 = ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemInactiveIcon(), r37, 6);
    L19:
        if ((r39 & 16) == 0) goto L21;
        long r11 = ColorSchemeKt.getValue(NavigationRailColorTokens.INSTANCE.getItemInactiveLabelText(), r37, 6);
    L23:
        if ((r39 & 32) == 0) goto L25;
        long r13 = Color.copy-wmQWz5c$default(r9, 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if ((r39 & 64) == 0) goto L29;
        long r15 = Color.copy-wmQWz5c$default(r11, 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(1759081702, r38, -1, "androidx.compose.material3.WideNavigationRailItemDefaults.colors (WideNavigationRail.kt:914)");
    L34:
        NavigationItemColors r0 = getDefaultWideNavigationRailItemColors(MaterialTheme.INSTANCE.getColorScheme(r37, 6)).m2914copy4JmcsL4(r3, r5, r7, r9, r11, r13, r15);
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
