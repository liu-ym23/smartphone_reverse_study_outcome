package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u00020\u0001*\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0080@¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"animateElevation", "", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/unit/Dp;", "target", "from", "Landroidx/compose/foundation/interaction/Interaction;", "to", "animateElevation-rAjV9yQ", "(Landroidx/compose/animation/core/Animatable;FLandroidx/compose/foundation/interaction/Interaction;Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DefaultIncomingSpec", "Landroidx/compose/animation/core/TweenSpec;", "DefaultOutgoingSpec", "HoveredOutgoingSpec", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ElevationKt {
    private static final TweenSpec<Dp> DefaultIncomingSpec = null;
    private static final TweenSpec<Dp> DefaultOutgoingSpec = null;
    private static final TweenSpec<Dp> HoveredOutgoingSpec = null;

    static {
        DefaultIncomingSpec = new TweenSpec(MenuKt.InTransitionDuration, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
        DefaultOutgoingSpec = new TweenSpec(TextFieldImplKt.AnimationDuration, 0, new CubicBezierEasing(0.4f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.6f, 1.0f), 2, null);
        HoveredOutgoingSpec = new TweenSpec(MenuKt.InTransitionDuration, 0, new CubicBezierEasing(0.4f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.6f, 1.0f), 2, null);
    }

    public static final /* synthetic */ TweenSpec access$getDefaultIncomingSpec$p() {
        return DefaultIncomingSpec;
    }

    public static final /* synthetic */ TweenSpec access$getDefaultOutgoingSpec$p() {
        return DefaultOutgoingSpec;
    }

    public static final /* synthetic */ TweenSpec access$getHoveredOutgoingSpec$p() {
        return HoveredOutgoingSpec;
    }

    /* JADX INFO: renamed from: animateElevation-rAjV9yQ, reason: not valid java name */
    public static final Object m2055animateElevationrAjV9yQ(Animatable<Dp, ?> r8, float r9, Interaction r10, Interaction r11, Continuation<? super Unit> r12) {
        if (r11 == null) goto L5;
        AnimationSpec<Dp> r13 = ElevationDefaults.INSTANCE.incomingAnimationSpecForInteraction(r11);
    L4:
        AnimationSpec<Dp> r2 = r13;
        if (r2 == null) goto L14;
        Object r14 = Animatable.animateTo$default(r8, Dp.box-impl(r9), r2, null, null, r12, 12, null);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r14;
    L13:
        return Unit.INSTANCE;
    L14:
        Object r15 = r8.snapTo(Dp.box-impl(r9), r12);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r15;
    L18:
        return Unit.INSTANCE;
    L5:
        if (r10 == null) goto L7;
        r13 = ElevationDefaults.INSTANCE.outgoingAnimationSpecForInteraction(r10);
        goto L4
    L7:
        r13 = null;
        goto L4
    }

    /* JADX INFO: renamed from: animateElevation-rAjV9yQ$default, reason: not valid java name */
    public static /* synthetic */ Object m2056animateElevationrAjV9yQ$default(Animatable r1, float r2, Interaction r3, Interaction r4, Continuation r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return m2055animateElevationrAjV9yQ(r1, r2, r3, r4, r5);
    }
}
