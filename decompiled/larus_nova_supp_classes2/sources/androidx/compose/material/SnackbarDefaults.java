package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/compose/material/SnackbarDefaults;", "", "<init>", "()V", "SnackbarOverlayAlpha", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "getBackgroundColor", "(Landroidx/compose/runtime/Composer;I)J", "primaryActionColor", "getPrimaryActionColor", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnackbarDefaults {
    public static final int $stable = 0;
    public static final SnackbarDefaults INSTANCE = null;
    private static final float SnackbarOverlayAlpha = 0.8f;

    static {
        INSTANCE = new SnackbarDefaults();
    }

    private SnackbarDefaults() {
    }

    public final long getBackgroundColor(Composer r11, int r12) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1630911716, r12, -1, "androidx.compose.material.SnackbarDefaults.<get-backgroundColor> (Snackbar.kt:201)");
    L5:
        MaterialTheme r13 = MaterialTheme.INSTANCE;
        long r14 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r13.getColors(r11, 6).m1998getOnSurface0d7_KjU(), 0.8f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r13.getColors(r11, 6).m2003getSurface0d7_KjU());
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r14;
    }

    public final long getPrimaryActionColor(Composer r11, int r12) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-810329402, r12, -1, "androidx.compose.material.SnackbarDefaults.<get-primaryActionColor> (Snackbar.kt:221)");
    L5:
        Colors r13 = MaterialTheme.INSTANCE.getColors(r11, 6);
        if (r13.isLight() == false) goto L8;
        long r0 = r13.m1999getPrimary0d7_KjU();
        long r14 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r13.m2003getSurface0d7_KjU(), 0.6f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null), r0);
    L10:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        return r14;
    L8:
        r14 = r13.m2000getPrimaryVariant0d7_KjU();
        goto L10
    }
}
