package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JU\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010JA\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0011\u001a\u00020\u0005*\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/NavigationBarItemDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationBarItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "defaultNavigationBarItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultNavigationBarItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationBarItemColors;", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationBarItemDefaults {
    public static final int $stable = 0;
    public static final NavigationBarItemDefaults INSTANCE = null;

    static {
        INSTANCE = new NavigationBarItemDefaults();
    }

    private NavigationBarItemDefaults() {
    }

    public final NavigationBarItemColors getDefaultNavigationBarItemColors$material3(ColorScheme r24) {
        NavigationBarItemColors r1 = r24.getDefaultNavigationBarItemColorsCached$material3();
        if (r1 != null) goto L6;
        NavigationBarTokens r2 = NavigationBarTokens.INSTANCE;
        NavigationBarItemColors r3 = new NavigationBarItemColors(ColorSchemeKt.fromToken(r24, r2.getItemActiveIconColor()), ColorSchemeKt.fromToken(r24, r2.getItemActiveLabelTextColor()), ColorSchemeKt.fromToken(r24, r2.getItemActiveIndicatorColor()), ColorSchemeKt.fromToken(r24, r2.getItemInactiveIconColor()), ColorSchemeKt.fromToken(r24, r2.getItemInactiveLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r24, r2.getItemInactiveIconColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r24, r2.getItemInactiveLabelTextColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r24.setDefaultNavigationBarItemColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final NavigationBarItemColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1018883954, r5, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:344)");
    L5:
        NavigationBarItemColors r6 = getDefaultNavigationBarItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with disabledIconColor and disabledTextColor")
    /* JADX INFO: renamed from: colors-zjMxDiM, reason: not valid java name */
    public final /* synthetic */ NavigationBarItemColors m2892colorszjMxDiM(long r22, long r24, long r26, long r28, long r30, Composer r32, int r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        long r6 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIconColor(), r32, 6);
    L7:
        if ((r34 & 2) == 0) goto L9;
        long r8 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveLabelTextColor(), r32, 6);
    L11:
        if ((r34 & 4) == 0) goto L13;
        long r10 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorColor(), r32, 6);
    L15:
        if ((r34 & 8) == 0) goto L17;
        long r12 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemInactiveIconColor(), r32, 6);
    L19:
        if ((r34 & 16) == 0) goto L21;
        long r14 = ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor(), r32, 6);
    L23:
        if (ComposerKt.isTraceInProgress() == false) goto L25;
        ComposerKt.traceEventStart(-213647161, r33, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:412)");
    L25:
        NavigationBarItemColors r0 = new NavigationBarItemColors(r6, r8, r10, r12, r14, Color.copy-wmQWz5c$default(r12, 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(r14, 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r0;
    L21:
        r14 = r30;
        goto L23
    L17:
        r12 = r28;
        goto L19
    L13:
        r10 = r26;
        goto L15
    L9:
        r8 = r24;
        goto L11
    L5:
        r6 = r22;
        goto L7
    }

    /* JADX INFO: renamed from: colors-69fazGs, reason: not valid java name */
    public final NavigationBarItemColors m2891colors69fazGs(long r19, long r21, long r23, long r25, long r27, long r29, long r31, Composer r33, int r34, int r35) {
        if ((r35 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r35 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r35 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r35 & 8) == 0) goto L17;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r35 & 16) == 0) goto L21;
        long r8 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r35 & 32) == 0) goto L25;
        long r10 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r35 & 64) == 0) goto L29;
        long r12 = Color.Companion.getUnspecified-0d7_KjU();
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-1618564327, r34, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:369)");
    L34:
        NavigationBarItemColors r1 = getDefaultNavigationBarItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(r33, 6)).m2880copy4JmcsL4(r0, r2, r4, r6, r8, r10, r12);
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
    L37:
        return r1;
    L29:
        r12 = r31;
        goto L31
    L25:
        r10 = r29;
        goto L27
    L21:
        r8 = r27;
        goto L23
    L17:
        r6 = r25;
        goto L19
    L13:
        r4 = r23;
        goto L15
    L9:
        r2 = r21;
        goto L11
    L5:
        r0 = r19;
        goto L7
    }
}
