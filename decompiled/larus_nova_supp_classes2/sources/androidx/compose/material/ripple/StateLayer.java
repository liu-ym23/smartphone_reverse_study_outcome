package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J!\u0010\u0017\u001a\u00020\u0012*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/material/ripple/StateLayer;", "", "bounded", "", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(ZLkotlin/jvm/functions/Function0;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "interactions", "", "Landroidx/compose/foundation/interaction/Interaction;", "currentInteraction", "handleInteraction", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "handleInteraction$material_ripple", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StateLayer {
    private final Animatable<Float, AnimationVector1D> animatedAlpha;
    private final boolean bounded;
    private Interaction currentInteraction;
    private final List<Interaction> interactions;
    private final Function0<RippleAlpha> rippleAlpha;

    public static final /* synthetic */ Animatable access$getAnimatedAlpha$p(StateLayer r0) {
        return r0.animatedAlpha;
    }

    public StateLayer(boolean r2, Function0<RippleAlpha> r3) {
        this.bounded = r2;
        this.rippleAlpha = r3;
        this.animatedAlpha = AnimatableKt.Animatable$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 2, null);
        this.interactions = new ArrayList();
    }

    public final void handleInteraction$material_ripple(Interaction r10, CoroutineScope r11) {
        if ((r10 instanceof HoverInteraction.Enter) == false) goto L6;
        this.interactions.add(r10);
    L23:
        Interaction r12 = (Interaction) CollectionsKt.lastOrNull(this.interactions);
        if (Intrinsics.areEqual(this.currentInteraction, r12) == false) goto L26;
        return;
    L26:
        if (r12 == null) goto L38;
        RippleAlpha r1 = (RippleAlpha) this.rippleAlpha.invoke();
        if ((r12 instanceof HoverInteraction.Enter) == false) goto L31;
        float r2 = r1.getHoveredAlpha();
    L37:
        BuildersKt.launch$default(r11, null, null, new StateLayer$handleInteraction$1(this, r2, RippleKt.access$incomingStateLayerAnimationSpecFor(r12), null), 3, null);
    L39:
        this.currentInteraction = r12;
        return;
    L31:
        if ((r12 instanceof FocusInteraction.Focus) == false) goto L34;
        r2 = r1.getFocusedAlpha();
        goto L37
    L34:
        if ((r12 instanceof DragInteraction.Start) == false) goto L36;
        r2 = r1.getDraggedAlpha();
        goto L37
    L36:
        r2 = MenuKt.ClosedAlphaTarget;
        goto L37
    L38:
        BuildersKt.launch$default(r11, null, null, new StateLayer$handleInteraction$2(this, RippleKt.access$outgoingStateLayerAnimationSpecFor(this.currentInteraction), null), 3, null);
        goto L39
    L6:
        if ((r10 instanceof HoverInteraction.Exit) == false) goto L9;
        this.interactions.remove(((HoverInteraction.Exit) r10).getEnter());
        goto L23
    L9:
        if ((r10 instanceof FocusInteraction.Focus) == false) goto L12;
        this.interactions.add(r10);
        goto L23
    L12:
        if ((r10 instanceof FocusInteraction.Unfocus) == false) goto L15;
        this.interactions.remove(((FocusInteraction.Unfocus) r10).getFocus());
        goto L23
    L15:
        if ((r10 instanceof DragInteraction.Start) == false) goto L18;
        this.interactions.add(r10);
        goto L23
    L18:
        if ((r10 instanceof DragInteraction.Stop) == false) goto L21;
        this.interactions.remove(((DragInteraction.Stop) r10).getStart());
        goto L23
    L21:
        if ((r10 instanceof DragInteraction.Cancel) == false) goto L41;
        this.interactions.remove(((DragInteraction.Cancel) r10).getStart());
        goto L23
    }

    /* JADX INFO: renamed from: drawStateLayer-mxwnekA, reason: not valid java name */
    public final void m2277drawStateLayermxwnekA(DrawScope r23, float r24, long r25) {
        float r4 = this.animatedAlpha.getValue().floatValue();
        if (r4 <= MenuKt.ClosedAlphaTarget) goto L23;
        long r11 = Color.copy-wmQWz5c$default(r25, r4, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        if (this.bounded == false) goto L17;
        float r5 = Size.getWidth-impl(r23.getSize-NH-jbRc());
        float r6 = Size.getHeight-impl(r23.getSize-NH-jbRc());
        int r7 = ClipOp.Companion.getIntersect-rtfAjoo();
        DrawContext r8 = r23.getDrawContext();
        long r14 = r8.getSize-NH-jbRc();
        r8.getCanvas().save();
        r8.getTransform().clipRect-N_I0leg(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r5, r6, r7);     // Catch: Throwable -> L13
        long r9 = r14;
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r23, r11, r24, 0, MenuKt.ClosedAlphaTarget, null, null, 0, 124, null);     // Catch: Throwable -> L11
        r8.getCanvas().restore();
        r8.setSize-uvyYCjk(r9);
        return;
    L11:
        th = th;
    L15:
        r8.getCanvas().restore();
        r8.setSize-uvyYCjk(r9);
        throw th;
    L13:
        th = th;
        r9 = r14;
        goto L15
    L17:
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r23, r11, r24, 0, MenuKt.ClosedAlphaTarget, null, null, 0, 124, null);
        return;
    }
}
