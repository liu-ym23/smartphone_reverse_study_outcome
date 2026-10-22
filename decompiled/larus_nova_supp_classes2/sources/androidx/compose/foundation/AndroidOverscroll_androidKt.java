package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\tH\u0000\u001a\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0002\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0013\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015\"\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"rememberPlatformOverscrollFactory", "Landroidx/compose/foundation/OverscrollFactory;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "rememberPlatformOverscrollFactory-3J-VO9M", "(JLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/OverscrollFactory;", "defaultOverscrollFactory", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "rememberPlatformOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "destretchMultiplier", "", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "destretchMultiplier-GyEprt8", "(I)F", "FlingDestretchFactor", "DefaultGlowColor", "J", "DefaultGlowPaddingValues", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidOverscroll_androidKt {
    private static final long DefaultGlowColor = 0;
    private static final PaddingValues DefaultGlowPaddingValues = null;
    private static final float FlingDestretchFactor = 4.0f;

    static {
        DefaultGlowColor = ColorKt.Color(4284900966L);
        DefaultGlowPaddingValues = PaddingKt.m955PaddingValuesYgX7TsA$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 3, null);
    }

    public static final /* synthetic */ long access$getDefaultGlowColor$p() {
        return DefaultGlowColor;
    }

    public static final /* synthetic */ PaddingValues access$getDefaultGlowPaddingValues$p() {
        return DefaultGlowPaddingValues;
    }

    /* JADX INFO: renamed from: access$destretchMultiplier-GyEprt8, reason: not valid java name */
    public static final /* synthetic */ float m337access$destretchMultiplierGyEprt8(int r0) {
        return m338destretchMultiplierGyEprt8(r0);
    }

    public static final OverscrollFactory defaultOverscrollFactory(CompositionLocalAccessorScope r8) {
        Context r2 = (Context) r8.getCurrentValue(AndroidCompositionLocals_androidKt.getLocalContext());
        Density r3 = (Density) r8.getCurrentValue(CompositionLocalsKt.getLocalDensity());
        OverscrollConfiguration r9 = (OverscrollConfiguration) r8.getCurrentValue(OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration());
        if (r9 != null) goto L6;
        return null;
    L6:
        return new AndroidEdgeEffectOverscrollFactory(r2, r3, r9.m445getGlowColor0d7_KjU(), r9.getDrawPadding(), null);
    }

    /* JADX INFO: renamed from: destretchMultiplier-GyEprt8, reason: not valid java name */
    private static final float m338destretchMultiplierGyEprt8(int r1) {
        if (NestedScrollSource.equals-impl0(r1, NestedScrollSource.Companion.getSideEffect-WNlRxjI()) == false) goto L5;
        return FlingDestretchFactor;
    L5:
        return 1.0f;
    }

    public static final OverscrollEffect rememberPlatformOverscrollEffect(Composer r8, int r9) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1569526143, r9, -1, "androidx.compose.foundation.rememberPlatformOverscrollEffect (AndroidOverscroll.android.kt:107)");
    L5:
        Context r1 = (Context) r8.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Density r2 = (Density) r8.consume(CompositionLocalsKt.getLocalDensity());
        OverscrollConfiguration r10 = (OverscrollConfiguration) r8.consume(OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration());
        if (r10 != null) goto L8;
        r8.startReplaceGroup(-1555310353);
        r8.endReplaceGroup();
        AndroidEdgeEffectOverscrollEffect r11 = null;
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        return r11;
    L8:
        r8.startReplaceGroup(-1555277648);
        boolean r0 = (r8.changed(r1) | r8.changed(r2)) | r8.changed(r10);
        Object r3 = r8.rememberedValue();
        if (r0 == false) goto L11;
    L12:
        AndroidEdgeEffectOverscrollEffect r7 = new AndroidEdgeEffectOverscrollEffect(r1, r2, r10.m445getGlowColor0d7_KjU(), r10.getDrawPadding(), null);
        r8.updateRememberedValue(r7);
        r3 = r7;
    L13:
        r8.endReplaceGroup();
        r11 = (AndroidEdgeEffectOverscrollEffect) r3;
        goto L15
    L11:
        if (r3 != Composer.Companion.getEmpty()) goto L13;
        goto L12
    }

    /* JADX INFO: renamed from: rememberPlatformOverscrollFactory-3J-VO9M, reason: not valid java name */
    public static final OverscrollFactory m339rememberPlatformOverscrollFactory3JVO9M(long r7, PaddingValues r9, Composer r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r7 = DefaultGlowColor;
    L5:
        long r3 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = DefaultGlowPaddingValues;
    L8:
        PaddingValues r5 = r9;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-2017030679, r11, -1, "androidx.compose.foundation.rememberPlatformOverscrollFactory (AndroidOverscroll.android.kt:85)");
    L11:
        AndroidEdgeEffectOverscrollFactory r8 = new AndroidEdgeEffectOverscrollFactory((Context) r10.consume(AndroidCompositionLocals_androidKt.getLocalContext()), (Density) r10.consume(CompositionLocalsKt.getLocalDensity()), r3, r5, null);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r8;
    }
}
