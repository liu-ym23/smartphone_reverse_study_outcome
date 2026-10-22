package androidx.compose.animation;

import android.view.ViewConfiguration;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0005\u001a\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0007¢\u0006\u0002\u0010\u000b\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"splineBasedDecayDeprecated", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "density", "Landroidx/compose/ui/unit/Density;", "splineBasedDecay", "platformFlingScrollFriction", "", "getPlatformFlingScrollFriction", "()F", "rememberSplineBasedDecay", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/DecayAnimationSpec;", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SplineBasedFloatDecayAnimationSpec_androidKt {
    private static final float platformFlingScrollFriction = 0.0f;

    static {
        platformFlingScrollFriction = ViewConfiguration.getScrollFriction();
    }

    public static final float getPlatformFlingScrollFriction() {
        return platformFlingScrollFriction;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Moved to common code")
    public static final /* synthetic */ DecayAnimationSpec splineBasedDecay(Density r0) {
        return SplineBasedDecayKt.splineBasedDecay(r0);
    }

    public static final <T> DecayAnimationSpec<T> rememberSplineBasedDecay(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(904445851, r4, -1, "androidx.compose.animation.rememberSplineBasedDecay (SplineBasedFloatDecayAnimationSpec.android.kt:40)");
    L5:
        Density r5 = (Density) r3.consume(CompositionLocalsKt.getLocalDensity());
        boolean r0 = r3.changed(r5.getDensity());
        Object r1 = r3.rememberedValue();
        if (r0 == false) goto L8;
    L9:
        r1 = DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(r5));
        r3.updateRememberedValue(r1);
    L10:
        DecayAnimationSpec<T> r2 = (DecayAnimationSpec) r1;
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r2;
    L8:
        if (r1 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }
}
