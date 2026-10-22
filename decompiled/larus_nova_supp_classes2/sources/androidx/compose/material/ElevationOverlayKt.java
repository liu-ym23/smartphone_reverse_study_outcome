package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0004\b\n\u0010\u000b\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0004¨\u0006\u000e"}, d2 = {"LocalElevationOverlay", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/ElevationOverlay;", "getLocalElevationOverlay", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "calculateForegroundColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "calculateForegroundColor-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "LocalAbsoluteElevation", "getLocalAbsoluteElevation", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ElevationOverlayKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteElevation = null;
    private static final ProvidableCompositionLocal<ElevationOverlay> LocalElevationOverlay = null;

    private static final Dp LocalAbsoluteElevation$lambda$1() {
        return Dp.box-impl(Dp.constructor-impl(0));
    }

    public static /* synthetic */ Dp a() {
        return LocalAbsoluteElevation$lambda$1();
    }

    public static /* synthetic */ ElevationOverlay b() {
        return LocalElevationOverlay$lambda$0();
    }

    static {
        LocalElevationOverlay = CompositionLocalKt.staticCompositionLocalOf(new r4());
        LocalAbsoluteElevation = CompositionLocalKt.compositionLocalOf$default(null, new s4(), 1, null);
    }

    private static final ElevationOverlay LocalElevationOverlay$lambda$0() {
        return DefaultElevationOverlay.INSTANCE;
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteElevation() {
        return LocalAbsoluteElevation;
    }

    public static final ProvidableCompositionLocal<ElevationOverlay> getLocalElevationOverlay() {
        return LocalElevationOverlay;
    }

    /* JADX INFO: renamed from: access$calculateForegroundColor-CLU3JFs, reason: not valid java name */
    public static final /* synthetic */ long m2057access$calculateForegroundColorCLU3JFs(long r0, float r2, Composer r3, int r4) {
        return m2058calculateForegroundColorCLU3JFs(r0, r2, r3, r4);
    }

    /* JADX INFO: renamed from: calculateForegroundColor-CLU3JFs, reason: not valid java name */
    private static final long m2058calculateForegroundColorCLU3JFs(long r9, float r11, Composer r12, int r13) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1613340891, r13, -1, "androidx.compose.material.calculateForegroundColor (ElevationOverlay.kt:85)");
    L5:
        long r10 = Color.copy-wmQWz5c$default(ColorsKt.m2017contentColorForek8zF_U(r9, r12, r13 & 14), ((((float) Math.log(r11 + 1)) * 4.5f) + 2.0f) / 100.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r10;
    }
}
