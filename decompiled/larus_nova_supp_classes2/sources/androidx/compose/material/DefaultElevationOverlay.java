package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/DefaultElevationOverlay;", "Landroidx/compose/material/ElevationOverlay;", "<init>", "()V", "apply", "Landroidx/compose/ui/graphics/Color;", "color", "elevation", "Landroidx/compose/ui/unit/Dp;", "apply-7g2Lkgo", "(JFLandroidx/compose/runtime/Composer;I)J", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultElevationOverlay implements ElevationOverlay {
    public static final DefaultElevationOverlay INSTANCE = null;

    static {
        INSTANCE = new DefaultElevationOverlay();
    }

    private DefaultElevationOverlay() {
    }

    @Override // androidx.compose.material.ElevationOverlay
    /* JADX INFO: renamed from: apply-7g2Lkgo, reason: not valid java name */
    public long mo2030apply7g2Lkgo(long r4, float r6, Composer r7, int r8) {
        r7.startReplaceGroup(-1687113661);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1687113661, r8, -1, "androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:67)");
    L5:
        Colors r0 = MaterialTheme.INSTANCE.getColors(r7, 6);
        if (Dp.compareTo-0680j_4(r6, Dp.constructor-impl(0)) > 0) goto L8;
    L10:
        r7.startReplaceGroup(-1095440862);
        r7.endReplaceGroup();
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        r7.endReplaceGroup();
        return r4;
    L8:
        if (r0.isLight() == true) goto L10;
        r7.startReplaceGroup(-1095579370);
        r4 = ColorKt.compositeOver--OWjLjI(ElevationOverlayKt.m2057access$calculateForegroundColorCLU3JFs(r4, r6, r7, (r8 & 112) | (r8 & 14)), r4);
        r7.endReplaceGroup();
        goto L12
    }
}
