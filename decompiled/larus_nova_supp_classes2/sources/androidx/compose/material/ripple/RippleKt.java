package androidx.compose.material.ripple;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002\"\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"createRippleModifierNode", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "createRippleModifierNode-TDGSqEk", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/DelegatableNode;", "rememberRipple", "Landroidx/compose/foundation/Indication;", "Landroidx/compose/ui/graphics/Color;", "rememberRipple-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "incomingStateLayerAnimationSpecFor", "Landroidx/compose/animation/core/AnimationSpec;", "", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingStateLayerAnimationSpecFor", "DefaultTweenSpec", "Landroidx/compose/animation/core/TweenSpec;", "material-ripple"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RippleKt {
    private static final TweenSpec<Float> DefaultTweenSpec = null;

    static {
        DefaultTweenSpec = new TweenSpec(15, 0, EasingKt.getLinearEasing(), 2, null);
    }

    public static final /* synthetic */ AnimationSpec access$incomingStateLayerAnimationSpecFor(Interaction r0) {
        return incomingStateLayerAnimationSpecFor(r0);
    }

    public static final /* synthetic */ AnimationSpec access$outgoingStateLayerAnimationSpecFor(Interaction r0) {
        return outgoingStateLayerAnimationSpecFor(r0);
    }

    private static final AnimationSpec<Float> incomingStateLayerAnimationSpecFor(Interaction r7) {
        if ((r7 instanceof HoverInteraction.Enter) == false) goto L6;
        return DefaultTweenSpec;
    L6:
        if ((r7 instanceof FocusInteraction.Focus) == false) goto L9;
        return new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, null);
    L9:
        if ((r7 instanceof DragInteraction.Start) == false) goto L12;
        return new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, null);
    L12:
        return DefaultTweenSpec;
    }

    private static final AnimationSpec<Float> outgoingStateLayerAnimationSpecFor(Interaction r6) {
        if ((r6 instanceof HoverInteraction.Enter) == false) goto L6;
        return DefaultTweenSpec;
    L6:
        if ((r6 instanceof FocusInteraction.Focus) == false) goto L9;
        return DefaultTweenSpec;
    L9:
        if ((r6 instanceof DragInteraction.Start) == false) goto L12;
        return new TweenSpec(TextFieldImplKt.AnimationDuration, 0, EasingKt.getLinearEasing(), 2, null);
    L12:
        return DefaultTweenSpec;
    }

    /* JADX INFO: renamed from: createRippleModifierNode-TDGSqEk, reason: not valid java name */
    public static final DelegatableNode m2269createRippleModifierNodeTDGSqEk(InteractionSource r0, boolean r1, float r2, ColorProducer r3, Function0<RippleAlpha> r4) {
        return Ripple_androidKt.m2276createPlatformRippleNodeTDGSqEk(r0, r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "rememberRipple has been deprecated - it returns an old Indication implementation that is not compatible with the new Indication APIs that provide notable performance improvements. Instead, use the new ripple APIs provided by design system libraries, such as material and material3. If you are implementing your own design system library, use createRippleNode to create your own custom ripple implementation that queries your own theme values. For a migration guide and background information, please visit developer.android.com")
    /* JADX INFO: renamed from: rememberRipple-9IZ8Weo, reason: not valid java name */
    public static final Indication m2270rememberRipple9IZ8Weo(boolean r4, float r5, long r6, Composer r8, int r9, int r10) {
        boolean r1 = true;
        if ((r10 & 1) == 0) goto L6;
        r4 = true;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r5 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        if ((r10 & 4) == 0) goto L12;
        r6 = Color.Companion.getUnspecified-0d7_KjU();
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(1635163520, r9, -1, "androidx.compose.material.ripple.rememberRipple (Ripple.kt:144)");
    L14:
        State r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r6), r8, (r9 >> 6) & 14);
        if (((r9 & 14) ^ 6) <= 4) goto L19;
        if (r8.changed(r4) == false) goto L19;
    L20:
        boolean r11 = true;
    L23:
        if (((r9 & 112) ^ 48) <= 32) goto L27;
        if (r8.changed(r5) == false) goto L27;
    L30:
        boolean r12 = r11 | r1;
        Object r13 = r8.rememberedValue();
        if (r12 == false) goto L33;
    L34:
        r13 = new PlatformRipple(r4, r5, r7, null);
        r8.updateRememberedValue(r13);
    L35:
        PlatformRipple r14 = (PlatformRipple) r13;
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        return r14;
    L33:
        if (r13 != Composer.Companion.getEmpty()) goto L35;
    L27:
        if ((r9 & 48) == 32) goto L30;
        r1 = false;
    L19:
        if ((r9 & 6) == 4) goto L20;
        r11 = false;
        goto L23
    }
}
