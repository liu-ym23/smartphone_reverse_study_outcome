package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J_\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/NavigationDrawerItemDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedContainerColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContainerColor", "selectedIconColor", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedBadgeColor", "unselectedBadgeColor", "colors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationDrawerItemColors;", "ItemPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationDrawerItemDefaults {
    public static final int $stable = 0;
    public static final NavigationDrawerItemDefaults INSTANCE = null;
    private static final PaddingValues ItemPadding = null;

    private NavigationDrawerItemDefaults() {
    }

    static {
        INSTANCE = new NavigationDrawerItemDefaults();
        ItemPadding = PaddingKt.m955PaddingValuesYgX7TsA$default(Dp.constructor-impl(12), MenuKt.ClosedAlphaTarget, 2, null);
    }

    public final PaddingValues getItemPadding() {
        return ItemPadding;
    }

    /* JADX INFO: renamed from: colors-oq7We08, reason: not valid java name */
    public final NavigationDrawerItemColors m2902colorsoq7We08(long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, Composer r35, int r36, int r37) {
        if ((r37 & 1) == 0) goto L5;
        long r4 = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorColor(), r35, 6);
    L7:
        if ((r37 & 2) == 0) goto L9;
        long r6 = Color.Companion.getTransparent-0d7_KjU();
    L11:
        if ((r37 & 4) == 0) goto L13;
        long r8 = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIconColor(), r35, 6);
    L15:
        if ((r37 & 8) == 0) goto L17;
        long r10 = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getInactiveIconColor(), r35, 6);
    L19:
        if ((r37 & 16) == 0) goto L21;
        long r12 = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveLabelTextColor(), r35, 6);
    L23:
        if ((r37 & 32) == 0) goto L25;
        long r2 = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getInactiveLabelTextColor(), r35, 6);
    L27:
        if ((r37 & 64) == 0) goto L29;
        long r14 = r12;
    L31:
        if ((r37 & 128) == 0) goto L33;
        long r0 = r2;
    L34:
        long r34 = r0;
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventStart(-1574983348, r36, -1, "androidx.compose.material3.NavigationDrawerItemDefaults.colors (NavigationDrawer.kt:1172)");
    L38:
        DefaultDrawerItemsColor r1 = new DefaultDrawerItemsColor(r8, r10, r12, r2, r4, r6, r14, r34, null);
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventEnd();
    L41:
        return r1;
    L33:
        r0 = r33;
        goto L34
    L29:
        r14 = r31;
        goto L31
    L25:
        r2 = r29;
        goto L27
    L21:
        r12 = r27;
        goto L23
    L17:
        r10 = r25;
        goto L19
    L13:
        r8 = r23;
        goto L15
    L9:
        r6 = r21;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }
}
