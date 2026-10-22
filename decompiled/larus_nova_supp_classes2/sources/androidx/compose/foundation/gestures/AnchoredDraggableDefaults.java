package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00152#\b\u0002\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00060\n2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u001bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableDefaults;", "", "<init>", "()V", "SnapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "PositionalThreshold", "Lkotlin/Function1;", "getPositionalThreshold", "()Lkotlin/jvm/functions/Function1;", "DecayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "T", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "positionalThreshold", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "totalDistance", "animationSpec", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnchoredDraggableDefaults {
    public static final int $stable = 0;
    private static final DecayAnimationSpec<Float> DecayAnimationSpec = null;
    public static final AnchoredDraggableDefaults INSTANCE = null;
    private static final Function1<Float, Float> PositionalThreshold = null;
    private static final AnimationSpec<Float> SnapAnimationSpec = null;

    private AnchoredDraggableDefaults() {
    }

    private static final float PositionalThreshold$lambda$0(float r1) {
        return r1 / 2.0f;
    }

    public static /* synthetic */ float a(float r0) {
        return PositionalThreshold$lambda$0(r0);
    }

    static {
        INSTANCE = new AnchoredDraggableDefaults();
        SnapAnimationSpec = AnimationSpecKt.tween$default(0, 0, null, 7, null);
        PositionalThreshold = new a();
        DecayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 3, null);
        $stable = 8;
    }

    public final DecayAnimationSpec<Float> getDecayAnimationSpec() {
        return DecayAnimationSpec;
    }

    public final Function1<Float, Float> getPositionalThreshold() {
        return PositionalThreshold;
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        return SnapAnimationSpec;
    }

    public final <T> TargetedFlingBehavior flingBehavior(AnchoredDraggableState<T> r6, Function1<? super Float, Float> r7, AnimationSpec<Float> r8, Composer r9, int r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r7 = PositionalThreshold;
    L6:
        if ((r11 & 4) == 0) goto L9;
        r8 = SnapAnimationSpec;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-952742024, r10, -1, "androidx.compose.foundation.gestures.AnchoredDraggableDefaults.flingBehavior (AnchoredDraggable.kt:1537)");
    L11:
        Density r12 = (Density) r9.consume(CompositionLocalsKt.getLocalDensity());
        boolean r1 = r9.changed(r12);
        boolean r3 = false;
        if (((r10 & 14) ^ 6) <= 4) goto L16;
        if (r9.changed(r6) == false) goto L16;
    L17:
        boolean r0 = true;
    L19:
        boolean r2 = r0 | r1;
        if (((r10 & 112) ^ 48) <= 32) goto L24;
        if (r9.changed(r7) == false) goto L24;
    L25:
        r3 = true;
    L26:
        boolean r13 = (r2 | r3) | r9.changed(r8);
        Object r4 = r9.rememberedValue();
        if (r13 == false) goto L29;
    L30:
        r4 = AnchoredDraggableKt.anchoredDraggableFlingBehavior(r6, r12, r7, r8);
        r9.updateRememberedValue(r4);
    L31:
        TargetedFlingBehavior r5 = (TargetedFlingBehavior) r4;
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventEnd();
    L34:
        return r5;
    L29:
        if (r4 != Composer.Companion.getEmpty()) goto L31;
    L24:
        if ((r10 & 48) != 32) goto L26;
    L16:
        if ((r10 & 6) == 4) goto L17;
        r0 = false;
        goto L19
    }
}
