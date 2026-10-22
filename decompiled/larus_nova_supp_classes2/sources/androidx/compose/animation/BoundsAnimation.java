package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ,\u0010\u001a\u001a\u00020\u001b2\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012RW\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u00052\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bR\b\u0012\u0004\u0012\u00020\u00060\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0019\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010!\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b!\u0010\"R \u0010#\u001a\b\u0012\u0004\u0012\u00020\t0$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R;\u0010*\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010)2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010)8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0019\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0013\u00100\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00106\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b7\u0010\"¨\u0006\u0007"}, d2 = {"Landroidx/compose/animation/BoundsAnimation;", "", "transitionScope", "Landroidx/compose/animation/SharedTransitionScope;", "transition", "Landroidx/compose/animation/core/Transition;", "", "animation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "<init>", "(Landroidx/compose/animation/SharedTransitionScope;Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/BoundsTransform;)V", "getTransitionScope", "()Landroidx/compose/animation/SharedTransitionScope;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "<set-?>", "getAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "animation$delegate", "Landroidx/compose/runtime/MutableState;", "updateAnimation", "", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "setBoundsTransform", "(Landroidx/compose/animation/BoundsTransform;)V", "boundsTransform$delegate", "isRunning", "()Z", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "Landroidx/compose/runtime/State;", "animationState", "getAnimationState", "()Landroidx/compose/runtime/State;", "setAnimationState", "(Landroidx/compose/runtime/State;)V", "animationState$delegate", "value", "getValue", "()Landroidx/compose/ui/geometry/Rect;", "animate", "currentBounds", "targetBounds", "target", "getTarget"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BoundsAnimation {
    public static final int $stable = 8;
    private final MutableState animation$delegate;
    private FiniteAnimationSpec<Rect> animationSpec;
    private final MutableState animationState$delegate;
    private final MutableState boundsTransform$delegate;
    private final Transition<Boolean> transition;
    private final SharedTransitionScope transitionScope;

    private final BoundsTransform getBoundsTransform() {
        return (BoundsTransform) this.boundsTransform$delegate.getValue();
    }

    public final Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> getAnimation() {
        return (Transition.DeferredAnimation) this.animation$delegate.getValue();
    }

    public final State<Rect> getAnimationState() {
        return (State) this.animationState$delegate.getValue();
    }

    public final boolean getTarget() {
        return this.transition.getTargetState().booleanValue();
    }

    public final Rect getValue() {
        if (this.transitionScope.isTransitionActive() == false) goto L8;
        State<Rect> r0 = getAnimationState();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Rect) r0.getValue();
    L8:
        return null;
    }

    public final boolean isRunning() {
        Transition r0 = this.transition;
    L4:
        if (r0.getParentTransition() == null) goto L7;
        r0 = r0.getParentTransition();
        Intrinsics.checkNotNull(r0);
        goto L4
    L7:
        return !Intrinsics.areEqual(r0.getCurrentState(), r0.getTargetState());
    }

    public final FiniteAnimationSpec<Rect> getAnimationSpec() {
        return this.animationSpec;
    }

    public final Transition<Boolean> getTransition() {
        return this.transition;
    }

    public final SharedTransitionScope getTransitionScope() {
        return this.transitionScope;
    }

    private final void setAnimation(Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> r2) {
        this.animation$delegate.setValue(r2);
    }

    private final void setBoundsTransform(BoundsTransform r2) {
        this.boundsTransform$delegate.setValue(r2);
    }

    public final void setAnimationSpec(FiniteAnimationSpec<Rect> r1) {
        this.animationSpec = r1;
    }

    public final void setAnimationState(State<Rect> r2) {
        this.animationState$delegate.setValue(r2);
    }

    public final void animate(final Rect r4, final Rect r5) {
        if (this.transitionScope.isTransitionActive() == true) goto L5;
        return;
    L5:
        if (getAnimationState() != null) goto L7;
        this.animationSpec = getBoundsTransform().transform(r4, r5);
    L7:
        setAnimationState(getAnimation().animate(new AnonymousClass1(this), new AnonymousClass2(this, r5, r4)));
    }

    public final void updateAnimation(Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> r2, BoundsTransform r3) {
        if (Intrinsics.areEqual(getAnimation(), r2) == true) goto L5;
        setAnimation(r2);
        setAnimationState(null);
        this.animationSpec = BoundsAnimationKt.access$getDefaultBoundsAnimation$p();
    L5:
        setBoundsTransform(r3);
    }

    public BoundsAnimation(SharedTransitionScope r1, Transition<Boolean> r2, Transition<Boolean>.DeferredAnimation<Rect, AnimationVector4D> r3, BoundsTransform r4) {
        this.transitionScope = r1;
        this.transition = r2;
        this.animation$delegate = SnapshotStateKt.mutableStateOf$default(r3, null, 2, null);
        this.boundsTransform$delegate = SnapshotStateKt.mutableStateOf$default(r4, null, 2, null);
        this.animationSpec = BoundsAnimationKt.access$getDefaultBoundsAnimation$p();
        this.animationState$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }
}
